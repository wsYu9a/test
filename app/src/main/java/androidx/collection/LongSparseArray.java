package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {

    /* renamed from: a */
    private static final Object f1145a = new Object();

    /* renamed from: b */
    private boolean f1146b;

    /* renamed from: c */
    private long[] f1147c;

    /* renamed from: d */
    private Object[] f1148d;

    /* renamed from: e */
    private int f1149e;

    public LongSparseArray() {
        this(10);
    }

    private void a() {
        int i2 = this.f1149e;
        long[] jArr = this.f1147c;
        Object[] objArr = this.f1148d;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f1145a) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f1146b = false;
        this.f1149e = i3;
    }

    public void append(long j2, E e2) {
        int i2 = this.f1149e;
        if (i2 != 0 && j2 <= this.f1147c[i2 - 1]) {
            put(j2, e2);
            return;
        }
        if (this.f1146b && i2 >= this.f1147c.length) {
            a();
        }
        int i3 = this.f1149e;
        if (i3 >= this.f1147c.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr = new Object[idealLongArraySize];
            long[] jArr2 = this.f1147c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f1148d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1147c = jArr;
            this.f1148d = objArr;
        }
        this.f1147c[i3] = j2;
        this.f1148d[i3] = e2;
        this.f1149e = i3 + 1;
    }

    public void clear() {
        int i2 = this.f1149e;
        Object[] objArr = this.f1148d;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f1149e = 0;
        this.f1146b = false;
    }

    public boolean containsKey(long j2) {
        return indexOfKey(j2) >= 0;
    }

    public boolean containsValue(E e2) {
        return indexOfValue(e2) >= 0;
    }

    @Deprecated
    public void delete(long j2) {
        remove(j2);
    }

    @Nullable
    public E get(long j2) {
        return get(j2, null);
    }

    public int indexOfKey(long j2) {
        if (this.f1146b) {
            a();
        }
        return ContainerHelpers.b(this.f1147c, this.f1149e, j2);
    }

    public int indexOfValue(E e2) {
        if (this.f1146b) {
            a();
        }
        for (int i2 = 0; i2 < this.f1149e; i2++) {
            if (this.f1148d[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i2) {
        if (this.f1146b) {
            a();
        }
        return this.f1147c[i2];
    }

    public void put(long j2, E e2) {
        int b2 = ContainerHelpers.b(this.f1147c, this.f1149e, j2);
        if (b2 >= 0) {
            this.f1148d[b2] = e2;
            return;
        }
        int i2 = b2 ^ (-1);
        int i3 = this.f1149e;
        if (i2 < i3) {
            Object[] objArr = this.f1148d;
            if (objArr[i2] == f1145a) {
                this.f1147c[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f1146b && i3 >= this.f1147c.length) {
            a();
            i2 = ContainerHelpers.b(this.f1147c, this.f1149e, j2) ^ (-1);
        }
        int i4 = this.f1149e;
        if (i4 >= this.f1147c.length) {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i4 + 1);
            long[] jArr = new long[idealLongArraySize];
            Object[] objArr2 = new Object[idealLongArraySize];
            long[] jArr2 = this.f1147c;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f1148d;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1147c = jArr;
            this.f1148d = objArr2;
        }
        int i5 = this.f1149e;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f1147c;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f1148d;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f1149e - i2);
        }
        this.f1147c[i2] = j2;
        this.f1148d[i2] = e2;
        this.f1149e++;
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
        }
    }

    @Nullable
    public E putIfAbsent(long j2, E e2) {
        E e3 = get(j2);
        if (e3 == null) {
            put(j2, e2);
        }
        return e3;
    }

    public void remove(long j2) {
        int b2 = ContainerHelpers.b(this.f1147c, this.f1149e, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f1148d;
            Object obj = objArr[b2];
            Object obj2 = f1145a;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.f1146b = true;
            }
        }
    }

    public void removeAt(int i2) {
        Object[] objArr = this.f1148d;
        Object obj = objArr[i2];
        Object obj2 = f1145a;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f1146b = true;
        }
    }

    @Nullable
    public E replace(long j2, E e2) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.f1148d;
        E e3 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e2;
        return e3;
    }

    public void setValueAt(int i2, E e2) {
        if (this.f1146b) {
            a();
        }
        this.f1148d[i2] = e2;
    }

    public int size() {
        if (this.f1146b) {
            a();
        }
        return this.f1149e;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1149e * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f1149e; i2++) {
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
        if (this.f1146b) {
            a();
        }
        return (E) this.f1148d[i2];
    }

    public LongSparseArray(int i2) {
        this.f1146b = false;
        if (i2 == 0) {
            this.f1147c = ContainerHelpers.f1143b;
            this.f1148d = ContainerHelpers.f1144c;
        } else {
            int idealLongArraySize = ContainerHelpers.idealLongArraySize(i2);
            this.f1147c = new long[idealLongArraySize];
            this.f1148d = new Object[idealLongArraySize];
        }
    }

    /* renamed from: clone */
    public LongSparseArray<E> m30clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.f1147c = (long[]) this.f1147c.clone();
            longSparseArray.f1148d = (Object[]) this.f1148d.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E get(long j2, E e2) {
        int b2 = ContainerHelpers.b(this.f1147c, this.f1149e, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f1148d;
            if (objArr[b2] != f1145a) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public boolean replace(long j2, E e2, E e3) {
        int indexOfKey = indexOfKey(j2);
        if (indexOfKey < 0) {
            return false;
        }
        Object obj = this.f1148d[indexOfKey];
        if (obj != e2 && (e2 == null || !e2.equals(obj))) {
            return false;
        }
        this.f1148d[indexOfKey] = e3;
        return true;
    }

    public boolean remove(long j2, Object obj) {
        int indexOfKey = indexOfKey(j2);
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
