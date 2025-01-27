package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1173a = new Object();

    /* renamed from: b */
    private boolean f1174b;

    /* renamed from: c */
    private int[] f1175c;

    /* renamed from: d */
    private Object[] f1176d;

    /* renamed from: e */
    private int f1177e;

    public SparseArrayCompat() {
        this(10);
    }

    private void a() {
        int i2 = this.f1177e;
        int[] iArr = this.f1175c;
        Object[] objArr = this.f1176d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1173a) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1174b = false;
        this.f1177e = i3;
    }

    public void append(int i2, E e2) {
        int i3 = this.f1177e;
        if (i3 != 0 && i2 <= this.f1175c[i3 - 1]) {
            put(i2, e2);
            return;
        }
        if (this.f1174b && i3 >= this.f1175c.length) {
            a();
        }
        int i4 = this.f1177e;
        if (i4 >= this.f1175c.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i4 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr = new Object[idealIntArraySize];
            int[] iArr2 = this.f1175c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1176d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1175c = iArr;
            this.f1176d = objArr;
        }
        this.f1175c[i4] = i2;
        this.f1176d[i4] = e2;
        this.f1177e = i4 + 1;
    }

    public void clear() {
        int i2 = this.f1177e;
        Object[] objArr = this.f1176d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1177e = 0;
        this.f1174b = false;
    }

    public boolean containsKey(int i2) {
        return indexOfKey(i2) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(int i2) {
        remove(i2);
    }

    @Nullable
    public E get(int i2) {
        return get(i2, null);
    }

    public int indexOfKey(int i2) {
        if (this.f1174b) {
            a();
        }
        return ContainerHelpers.a(this.f1175c, this.f1177e, i2);
    }

    public int indexOfValue(E e2) {
        if (this.f1174b) {
            a();
        }
        for (int i2 = 0; i2 < this.f1177e; i2++) {
            if (this.f1176d[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i2) {
        if (this.f1174b) {
            a();
        }
        return this.f1175c[i2];
    }

    public void put(int i2, E e2) {
        int a2 = ContainerHelpers.a(this.f1175c, this.f1177e, i2);
        if (a2 >= 0) {
            this.f1176d[a2] = e2;
            return;
        }
        int i3 = a2 ^ (-1);
        int i4 = this.f1177e;
        if (i3 < i4) {
            Object[] objArr = this.f1176d;
            if (objArr[i3] == f1173a) {
                this.f1175c[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.f1174b && i4 >= this.f1175c.length) {
            a();
            i3 = ContainerHelpers.a(this.f1175c, this.f1177e, i2) ^ (-1);
        }
        int i5 = this.f1177e;
        if (i5 >= this.f1175c.length) {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i5 + 1);
            int[] iArr = new int[idealIntArraySize];
            Object[] objArr2 = new Object[idealIntArraySize];
            int[] iArr2 = this.f1175c;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1176d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1175c = iArr;
            this.f1176d = objArr2;
        }
        int i6 = this.f1177e;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.f1175c;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.f1176d;
            System.arraycopy(objArr4, i3, objArr4, i7, this.f1177e - i3);
        }
        this.f1175c[i3] = i2;
        this.f1176d[i3] = e2;
        this.f1177e++;
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int size = sparseArrayCompat.size();
        for (int i2 = 0; i2 < size; i2++) {
            put(sparseArrayCompat.keyAt(i2), sparseArrayCompat.valueAt(i2));
        }
    }

    @Nullable
    public E putIfAbsent(int i2, E e2) {
        E e3 = get(i2);
        if (e3 == null) {
            put(i2, e2);
        }
        return e3;
    }

    public void remove(int i2) {
        int a2 = ContainerHelpers.a(this.f1175c, this.f1177e, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f1176d;
            Object obj = objArr[a2];
            Object obj2 = f1173a;
            if (obj != obj2) {
                objArr[a2] = obj2;
                this.f1174b = true;
            }
        }
    }

    public void removeAt(int i2) {
        Object[] objArr = this.f1176d;
        Object obj = objArr[i2];
        Object obj2 = f1173a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f1174b = true;
        }
    }

    public void removeAtRange(int i2, int i3) {
        int min = Math.min(this.f1177e, i3 + i2);
        while (i2 < min) {
            removeAt(i2);
            i2++;
        }
    }

    @Nullable
    public E replace(int i2, E e2) {
        int indexOfKey = indexOfKey(i2);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.f1176d;
        E e3 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e2;
        return e3;
    }

    public void setValueAt(int i2, E e2) {
        if (this.f1174b) {
            a();
        }
        this.f1176d[i2] = e2;
    }

    public int size() {
        if (this.f1174b) {
            a();
        }
        return this.f1177e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1177e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1177e; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i2));
            sb.append('=');
            E valueAt = valueAt(i2);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i2) {
        if (this.f1174b) {
            a();
        }
        return (E) this.f1176d[i2];
    }

    public SparseArrayCompat(int i2) {
        this.f1174b = false;
        if (i2 == 0) {
            this.f1175c = ContainerHelpers.f1142a;
            this.f1176d = ContainerHelpers.f1144c;
        } else {
            int idealIntArraySize = ContainerHelpers.idealIntArraySize(i2);
            this.f1175c = new int[idealIntArraySize];
            this.f1176d = new Object[idealIntArraySize];
        }
    }

    /* renamed from: clone */
    public SparseArrayCompat<E> m31clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.f1175c = (int[]) this.f1175c.clone();
            sparseArrayCompat.f1176d = (Object[]) this.f1176d.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(int i2, E e2) {
        int a2 = ContainerHelpers.a(this.f1175c, this.f1177e, i2);
        if (a2 >= 0) {
            Object[] objArr = this.f1176d;
            if (objArr[a2] != f1173a) {
                return (E) objArr[a2];
            }
        }
        return e2;
    }

    public boolean replace(int i2, E e2, E e3) {
        int indexOfKey = indexOfKey(i2);
        if (indexOfKey < 0) {
            return false;
        }
        Object obj = this.f1176d[indexOfKey];
        if (obj != e2 && (e2 == null || !e2.equals(obj))) {
            return false;
        }
        this.f1176d[indexOfKey] = e3;
        return true;
    }

    public boolean remove(int i2, Object obj) {
        int indexOfKey = indexOfKey(i2);
        if (indexOfKey < 0) {
            return false;
        }
        E valueAt = valueAt(indexOfKey);
        if (obj != valueAt && (obj == null || !obj.equals(valueAt))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
