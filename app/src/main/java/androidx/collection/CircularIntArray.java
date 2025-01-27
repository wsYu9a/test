package androidx.collection;

/* loaded from: classes.dex */
public final class CircularIntArray {

    /* renamed from: a, reason: collision with root package name */
    private int[] f1138a;

    /* renamed from: b, reason: collision with root package name */
    private int f1139b;

    /* renamed from: c, reason: collision with root package name */
    private int f1140c;

    /* renamed from: d, reason: collision with root package name */
    private int f1141d;

    public CircularIntArray() {
        this(8);
    }

    private void a() {
        int[] iArr = this.f1138a;
        int length = iArr.length;
        int i2 = this.f1139b;
        int i3 = length - i2;
        int i4 = length << 1;
        if (i4 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i4];
        System.arraycopy(iArr, i2, iArr2, 0, i3);
        System.arraycopy(this.f1138a, 0, iArr2, i3, this.f1139b);
        this.f1138a = iArr2;
        this.f1139b = 0;
        this.f1140c = length;
        this.f1141d = i4 - 1;
    }

    public void addFirst(int i2) {
        int i3 = (this.f1139b - 1) & this.f1141d;
        this.f1139b = i3;
        this.f1138a[i3] = i2;
        if (i3 == this.f1140c) {
            a();
        }
    }

    public void addLast(int i2) {
        int[] iArr = this.f1138a;
        int i3 = this.f1140c;
        iArr[i3] = i2;
        int i4 = this.f1141d & (i3 + 1);
        this.f1140c = i4;
        if (i4 == this.f1139b) {
            a();
        }
    }

    public void clear() {
        this.f1140c = this.f1139b;
    }

    public int get(int i2) {
        if (i2 < 0 || i2 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.f1138a[this.f1141d & (this.f1139b + i2)];
    }

    public int getFirst() {
        int i2 = this.f1139b;
        if (i2 != this.f1140c) {
            return this.f1138a[i2];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i2 = this.f1139b;
        int i3 = this.f1140c;
        if (i2 != i3) {
            return this.f1138a[(i3 - 1) & this.f1141d];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.f1139b == this.f1140c;
    }

    public int popFirst() {
        int i2 = this.f1139b;
        if (i2 == this.f1140c) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = this.f1138a[i2];
        this.f1139b = (i2 + 1) & this.f1141d;
        return i3;
    }

    public int popLast() {
        int i2 = this.f1139b;
        int i3 = this.f1140c;
        if (i2 == i3) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = this.f1141d & (i3 - 1);
        int i5 = this.f1138a[i4];
        this.f1140c = i4;
        return i5;
    }

    public void removeFromEnd(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f1140c = this.f1141d & (this.f1140c - i2);
    }

    public void removeFromStart(int i2) {
        if (i2 <= 0) {
            return;
        }
        if (i2 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.f1139b = this.f1141d & (this.f1139b + i2);
    }

    public int size() {
        return (this.f1140c - this.f1139b) & this.f1141d;
    }

    public CircularIntArray(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i2 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
        this.f1141d = i2 - 1;
        this.f1138a = new int[i2];
    }
}
