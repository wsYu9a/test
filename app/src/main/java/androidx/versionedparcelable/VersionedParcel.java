package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public abstract class VersionedParcel {

    /* renamed from: a */
    private static final String f4019a = "VersionedParcel";

    /* renamed from: b */
    private static final int f4020b = -1;

    /* renamed from: c */
    private static final int f4021c = -2;

    /* renamed from: d */
    private static final int f4022d = -3;

    /* renamed from: e */
    private static final int f4023e = -4;

    /* renamed from: f */
    private static final int f4024f = -5;

    /* renamed from: g */
    private static final int f4025g = -6;

    /* renamed from: h */
    private static final int f4026h = -7;

    /* renamed from: i */
    private static final int f4027i = -9;

    /* renamed from: j */
    private static final int f4028j = 1;
    private static final int k = 2;
    private static final int l = 3;
    private static final int m = 4;
    private static final int n = 5;
    private static final int o = 7;
    private static final int p = 8;
    protected final ArrayMap<String, Method> q;
    protected final ArrayMap<String, Method> r;
    protected final ArrayMap<String, Class> s;

    /* renamed from: androidx.versionedparcelable.VersionedParcel$1 */
    class AnonymousClass1 extends ObjectInputStream {
        AnonymousClass1(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.q = arrayMap;
        this.r = arrayMap2;
        this.s = arrayMap3;
    }

    private void D(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void G(VersionedParcelable versionedParcelable) {
        try {
            writeString(c(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName() + " does not have a Parcelizer", e2);
        }
    }

    private Exception a(int i2, String str) {
        switch (i2) {
            case -9:
                return (Exception) readParcelable();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i2 + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class c(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.s.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.s.put(cls.getName(), cls3);
        return cls3;
    }

    private Method d(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.q.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.q.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    protected static Throwable e(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method f(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.r.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class c2 = c(cls);
        System.currentTimeMillis();
        Method declaredMethod = c2.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.r.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T> int getType(T t) {
        if (t instanceof String) {
            return 4;
        }
        if (t instanceof Parcelable) {
            return 2;
        }
        if (t instanceof VersionedParcelable) {
            return 1;
        }
        if (t instanceof Serializable) {
            return 3;
        }
        if (t instanceof IBinder) {
            return 5;
        }
        if (t instanceof Integer) {
            return 7;
        }
        if (t instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t.getClass().getName() + " cannot be VersionedParcelled");
    }

    private <T, S extends Collection<T>> S j(S s) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    s.add(s());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    s.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    s.add(r());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    s.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    s.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return s;
    }

    private Exception l(int i2, String str) {
        return a(i2, str);
    }

    private int m() {
        return readInt();
    }

    private <T> void w(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        F((VersionedParcelable) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        writeParcelable((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        D((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        writeString((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeStrongBinder((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeInt(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeFloat(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private <T> void x(Collection<T> collection, int i2) {
        setOutputField(i2);
        w(collection);
    }

    protected void A(int[] iArr) {
        if (iArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(iArr.length);
        for (int i2 : iArr) {
            writeInt(i2);
        }
    }

    protected void B(long[] jArr) {
        if (jArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(jArr.length);
        for (long j2 : jArr) {
            writeLong(j2);
        }
    }

    protected void C() {
        writeInt(0);
    }

    protected <T extends VersionedParcelable> void E(T t, VersionedParcel versionedParcel) {
        try {
            f(t.getClass()).invoke(null, t, versionedParcel);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (!(e5.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
            }
            throw ((RuntimeException) e5.getCause());
        }
    }

    protected void F(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        G(versionedParcelable);
        VersionedParcel b2 = b();
        E(versionedParcelable, b2);
        b2.closeField();
    }

    protected abstract VersionedParcel b();

    protected abstract void closeField();

    protected <T> T[] g(T[] tArr) {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(readInt);
        if (readInt != 0) {
            int readInt2 = readInt();
            if (readInt < 0) {
                return null;
            }
            if (readInt2 == 1) {
                while (readInt > 0) {
                    arrayList.add(s());
                    readInt--;
                }
            } else if (readInt2 == 2) {
                while (readInt > 0) {
                    arrayList.add(readParcelable());
                    readInt--;
                }
            } else if (readInt2 == 3) {
                while (readInt > 0) {
                    arrayList.add(r());
                    readInt--;
                }
            } else if (readInt2 == 4) {
                while (readInt > 0) {
                    arrayList.add(readString());
                    readInt--;
                }
            } else if (readInt2 == 5) {
                while (readInt > 0) {
                    arrayList.add(readStrongBinder());
                    readInt--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    protected boolean[] h() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            zArr[i2] = readInt() != 0;
        }
        return zArr;
    }

    protected abstract CharSequence i();

    public boolean isStream() {
        return false;
    }

    protected double[] k() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        double[] dArr = new double[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            dArr[i2] = readDouble();
        }
        return dArr;
    }

    protected float[] n() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            fArr[i2] = readFloat();
        }
        return fArr;
    }

    protected <T extends VersionedParcelable> T o(String str, VersionedParcel versionedParcel) {
        try {
            return (T) d(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e4);
        } catch (InvocationTargetException e5) {
            if (e5.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e5.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e5);
        }
    }

    protected int[] p() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        int[] iArr = new int[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    protected long[] q() {
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        long[] jArr = new long[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            jArr[i2] = readLong();
        }
        return jArr;
    }

    protected Serializable r() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                AnonymousClass1(InputStream inputStream) {
                    super(inputStream);
                }

                @Override // java.io.ObjectInputStream
                protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e2) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + readString + ")", e2);
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + readString + ")", e3);
        }
    }

    public <T> T[] readArray(T[] tArr, int i2) {
        return !readField(i2) ? tArr : (T[]) g(tArr);
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean z, int i2) {
        return !readField(i2) ? z : readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i2) {
        return !readField(i2) ? zArr : h();
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i2) {
        return !readField(i2) ? bundle : readBundle();
    }

    public byte readByte(byte b2, int i2) {
        return !readField(i2) ? b2 : (byte) (readInt() & 255);
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i2) {
        return !readField(i2) ? bArr : readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i2) {
        if (!readField(i2)) {
            return cArr;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        char[] cArr2 = new char[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            cArr2[i3] = (char) readInt();
        }
        return cArr2;
    }

    public CharSequence readCharSequence(CharSequence charSequence, int i2) {
        return !readField(i2) ? charSequence : i();
    }

    protected abstract double readDouble();

    public double readDouble(double d2, int i2) {
        return !readField(i2) ? d2 : readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i2) {
        return !readField(i2) ? dArr : k();
    }

    public Exception readException(Exception exc, int i2) {
        int m2;
        return (readField(i2) && (m2 = m()) != 0) ? l(m2, readString()) : exc;
    }

    protected abstract boolean readField(int i2);

    protected abstract float readFloat();

    public float readFloat(float f2, int i2) {
        return !readField(i2) ? f2 : readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i2) {
        return !readField(i2) ? fArr : n();
    }

    protected abstract int readInt();

    public int readInt(int i2, int i3) {
        return !readField(i3) ? i2 : readInt();
    }

    public int[] readIntArray(int[] iArr, int i2) {
        return !readField(i2) ? iArr : p();
    }

    public <T> List<T> readList(List<T> list, int i2) {
        return !readField(i2) ? list : (List) j(new ArrayList());
    }

    protected abstract long readLong();

    public long readLong(long j2, int i2) {
        return !readField(i2) ? j2 : readLong();
    }

    public long[] readLongArray(long[] jArr, int i2) {
        return !readField(i2) ? jArr : q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i2) {
        if (!readField(i2)) {
            return map;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (readInt == 0) {
            return arrayMap;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        j(arrayList);
        j(arrayList2);
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayMap.put(arrayList.get(i3), arrayList2.get(i3));
        }
        return arrayMap;
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t, int i2) {
        return !readField(i2) ? t : (T) readParcelable();
    }

    public <T> Set<T> readSet(Set<T> set, int i2) {
        return !readField(i2) ? set : (Set) j(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i2) {
        if (!readField(i2)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i2) {
        if (!readField(i2)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i2) {
        if (!readField(i2)) {
            return sparseBooleanArray;
        }
        int readInt = readInt();
        if (readInt < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    protected abstract String readString();

    public String readString(String str, int i2) {
        return !readField(i2) ? str : readString();
    }

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i2) {
        return !readField(i2) ? iBinder : readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t, int i2) {
        return !readField(i2) ? t : (T) s();
    }

    protected <T extends VersionedParcelable> T s() {
        String readString = readString();
        if (readString == null) {
            return null;
        }
        return (T) o(readString, b());
    }

    protected abstract void setOutputField(int i2);

    public void setSerializationFlags(boolean z, boolean z2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T> void t(T[] tArr) {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i2 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i2 < length) {
                    F((VersionedParcelable) tArr[i2]);
                    i2++;
                }
                return;
            }
            if (type == 2) {
                while (i2 < length) {
                    writeParcelable((Parcelable) tArr[i2]);
                    i2++;
                }
                return;
            }
            if (type == 3) {
                while (i2 < length) {
                    D((Serializable) tArr[i2]);
                    i2++;
                }
            } else if (type == 4) {
                while (i2 < length) {
                    writeString((String) tArr[i2]);
                    i2++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i2 < length) {
                    writeStrongBinder((IBinder) tArr[i2]);
                    i2++;
                }
            }
        }
    }

    protected void u(boolean[] zArr) {
        if (zArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(zArr.length);
        for (boolean z : zArr) {
            writeInt(z ? 1 : 0);
        }
    }

    protected abstract void v(CharSequence charSequence);

    public <T> void writeArray(T[] tArr, int i2) {
        setOutputField(i2);
        t(tArr);
    }

    protected abstract void writeBoolean(boolean z);

    public void writeBoolean(boolean z, int i2) {
        setOutputField(i2);
        writeBoolean(z);
    }

    public void writeBooleanArray(boolean[] zArr, int i2) {
        setOutputField(i2);
        u(zArr);
    }

    protected abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i2) {
        setOutputField(i2);
        writeBundle(bundle);
    }

    public void writeByte(byte b2, int i2) {
        setOutputField(i2);
        writeInt(b2);
    }

    protected abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i2) {
        setOutputField(i2);
        writeByteArray(bArr);
    }

    protected abstract void writeByteArray(byte[] bArr, int i2, int i3);

    public void writeCharArray(char[] cArr, int i2) {
        setOutputField(i2);
        if (cArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(cArr.length);
        for (char c2 : cArr) {
            writeInt(c2);
        }
    }

    public void writeCharSequence(CharSequence charSequence, int i2) {
        setOutputField(i2);
        v(charSequence);
    }

    protected abstract void writeDouble(double d2);

    public void writeDouble(double d2, int i2) {
        setOutputField(i2);
        writeDouble(d2);
    }

    public void writeDoubleArray(double[] dArr, int i2) {
        setOutputField(i2);
        y(dArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception exc, int i2) {
        setOutputField(i2);
        if (exc == 0) {
            C();
            return;
        }
        int i3 = 0;
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i3 = -9;
        } else if (exc instanceof SecurityException) {
            i3 = -1;
        } else if (exc instanceof BadParcelableException) {
            i3 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i3 = -3;
        } else if (exc instanceof NullPointerException) {
            i3 = -4;
        } else if (exc instanceof IllegalStateException) {
            i3 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i3 = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i3 = -7;
        }
        writeInt(i3);
        if (i3 == 0) {
            if (!(exc instanceof RuntimeException)) {
                throw new RuntimeException(exc);
            }
            throw ((RuntimeException) exc);
        }
        writeString(exc.getMessage());
        if (i3 != -9) {
            return;
        }
        writeParcelable((Parcelable) exc);
    }

    protected abstract void writeFloat(float f2);

    public void writeFloat(float f2, int i2) {
        setOutputField(i2);
        writeFloat(f2);
    }

    public void writeFloatArray(float[] fArr, int i2) {
        setOutputField(i2);
        z(fArr);
    }

    protected abstract void writeInt(int i2);

    public void writeInt(int i2, int i3) {
        setOutputField(i3);
        writeInt(i2);
    }

    public void writeIntArray(int[] iArr, int i2) {
        setOutputField(i2);
        A(iArr);
    }

    public <T> void writeList(List<T> list, int i2) {
        x(list, i2);
    }

    protected abstract void writeLong(long j2);

    public void writeLong(long j2, int i2) {
        setOutputField(i2);
        writeLong(j2);
    }

    public void writeLongArray(long[] jArr, int i2) {
        setOutputField(i2);
        B(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i2) {
        setOutputField(i2);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        w(arrayList);
        w(arrayList2);
    }

    protected abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i2) {
        setOutputField(i2);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i2) {
        setOutputField(i2);
        D(serializable);
    }

    public <T> void writeSet(Set<T> set, int i2) {
        x(set, i2);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i2) {
        setOutputField(i2);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i2) {
        setOutputField(i2);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i2) {
        setOutputField(i2);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            writeInt(sparseBooleanArray.keyAt(i3));
            writeBoolean(sparseBooleanArray.valueAt(i3));
        }
    }

    protected abstract void writeString(String str);

    public void writeString(String str, int i2) {
        setOutputField(i2);
        writeString(str);
    }

    protected abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i2) {
        setOutputField(i2);
        writeStrongBinder(iBinder);
    }

    protected abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i2) {
        setOutputField(i2);
        writeStrongInterface(iInterface);
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i2) {
        setOutputField(i2);
        F(versionedParcelable);
    }

    protected void y(double[] dArr) {
        if (dArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(dArr.length);
        for (double d2 : dArr) {
            writeDouble(d2);
        }
    }

    protected void z(float[] fArr) {
        if (fArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(fArr.length);
        for (float f2 : fArr) {
            writeFloat(f2);
        }
    }

    public void writeByteArray(byte[] bArr, int i2, int i3, int i4) {
        setOutputField(i4);
        writeByteArray(bArr, i2, i3);
    }
}
