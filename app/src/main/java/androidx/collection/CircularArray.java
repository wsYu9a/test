package androidx.collection;

/* loaded from: classes.dex */
public final class CircularArray<E> {

    /* renamed from: a, reason: collision with root package name */
    private E[] f1134a;

    /* renamed from: b, reason: collision with root package name */
    private int f1135b;

    /* renamed from: c, reason: collision with root package name */
    private int f1136c;

    /* renamed from: d, reason: collision with root package name */
    private int f1137d;

    public CircularArray() {
        this(8);
    }

    private void a() {
        E[] eArr = this.f1134a;
        int length = eArr.length;
        int i2 = this.f1135b;
        int i3 = length - i2;
        int i4 = length << 1;
        if (i4 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        E[] eArr2 = (E[]) new Object[i4];
        System.arraycopy(eArr, i2, eArr2, 0, i3);
        System.arraycopy(this.f1134a, 0, eArr2, i3, this.f1135b);
        this.f1134a = eArr2;
        this.f1135b = 0;
        this.f1136c = length;
        this.f1137d = i4 - 1;
    }

    public void addFirst(E e2) {
        int i2 = (this.f1135b - 1) & this.f1137d;
        this.f1135b = i2;
        this.f1134a[i2] = e2;
        if (i2 == this.f1136c) {
            a();
        }
    }

    public void addLast(E e2) {
        E[] eArr = this.f1134a;
        int i2 = this.f1136c;
        eArr[i2] = e2;
        int i3 = this.f1137d & (i2 + 1);
        this.f1136c = i3;
        if (i3 == this.f1135b) {
            a();
        }
    }

    public void clear() {
        removeFromStart(size());
    }

    public E get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f1134a[this.f1137d & (this.f1135b + i2)];
    }

    public E getFirst() {
        int i2 = this.f1135b;
        if (i2 != this.f1136c) {
            return this.f1134a[i2];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public E getLast() {
        int i2 = this.f1135b;
        int i3 = this.f1136c;
        if (i2 != i3) {
            return this.f1134a[(i3 - 1) & this.f1137d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1135b == this.f1136c;
    }

    public E popFirst() {
        int i2 = this.f1135b;
        if (i2 == this.f1136c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.f1134a;
        E e2 = eArr[i2];
        eArr[i2] = null;
        this.f1135b = (i2 + 1) & this.f1137d;
        return e2;
    }

    public E popLast() {
        int i2 = this.f1135b;
        int i3 = this.f1136c;
        if (i2 == i3) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.f1137d & (i3 - 1);
        E[] eArr = this.f1134a;
        E e2 = eArr[i4];
        eArr[i4] = null;
        this.f1136c = i4;
        return e2;
    }

    public void removeFromEnd(int i2) {
        int i3;
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.f1136c;
        int i5 = i2 < i4 ? i4 - i2 : 0;
        int i6 = i5;
        while (true) {
            i3 = this.f1136c;
            if (i6 >= i3) {
                break;
            }
            this.f1134a[i6] = null;
            i6++;
        }
        int i7 = i3 - i5;
        int i8 = i2 - i7;
        this.f1136c = i3 - i7;
        if (i8 > 0) {
            int length = this.f1134a.length;
            this.f1136c = length;
            int i9 = length - i8;
            for (int i10 = i9; i10 < this.f1136c; i10++) {
                this.f1134a[i10] = null;
            }
            this.f1136c = i9;
        }
    }

    public void removeFromStart(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.f1134a.length;
        int i3 = this.f1135b;
        if (i2 < length - i3) {
            length = i3 + i2;
        }
        while (i3 < length) {
            this.f1134a[i3] = null;
            i3++;
        }
        int i4 = this.f1135b;
        int i5 = length - i4;
        int i6 = i2 - i5;
        this.f1135b = this.f1137d & (i4 + i5);
        if (i6 > 0) {
            for (int i7 = 0; i7 < i6; i7++) {
                this.f1134a[i7] = null;
            }
            this.f1135b = i6;
        }
    }

    public int size() {
        return (this.f1136c - this.f1135b) & this.f1137d;
    }

    public CircularArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i2 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.f1137d = i2 - 1;
        this.f1134a = (E[]) new Object[i2];
    }
}
