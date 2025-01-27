package androidx.collection;

/* loaded from: classes.dex */
public final class CircularIntArray {
    private int mCapacityBitmask;
    private int[] mElements;
    private int mHead;
    private int mTail;

    public CircularIntArray() {
        this(8);
    }

    private void doubleCapacity() {
        int[] iArr = this.mElements;
        int length = iArr.length;
        int i10 = this.mHead;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        int[] iArr2 = new int[i12];
        System.arraycopy(iArr, i10, iArr2, 0, i11);
        System.arraycopy(this.mElements, 0, iArr2, i11, this.mHead);
        this.mElements = iArr2;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i12 - 1;
    }

    public void addFirst(int i10) {
        int i11 = (this.mHead - 1) & this.mCapacityBitmask;
        this.mHead = i11;
        this.mElements[i11] = i10;
        if (i11 == this.mTail) {
            doubleCapacity();
        }
    }

    public void addLast(int i10) {
        int[] iArr = this.mElements;
        int i11 = this.mTail;
        iArr[i11] = i10;
        int i12 = this.mCapacityBitmask & (i11 + 1);
        this.mTail = i12;
        if (i12 == this.mHead) {
            doubleCapacity();
        }
    }

    public void clear() {
        this.mTail = this.mHead;
    }

    public int get(int i10) {
        if (i10 < 0 || i10 >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i10)];
    }

    public int getFirst() {
        int i10 = this.mHead;
        if (i10 != this.mTail) {
            return this.mElements[i10];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getLast() {
        int i10 = this.mHead;
        int i11 = this.mTail;
        if (i10 != i11) {
            return this.mElements[(i11 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return this.mHead == this.mTail;
    }

    public int popFirst() {
        int i10 = this.mHead;
        if (i10 == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = this.mElements[i10];
        this.mHead = (i10 + 1) & this.mCapacityBitmask;
        return i11;
    }

    public int popLast() {
        int i10 = this.mHead;
        int i11 = this.mTail;
        if (i10 == i11) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = this.mCapacityBitmask & (i11 - 1);
        int i13 = this.mElements[i12];
        this.mTail = i12;
        return i13;
    }

    public void removeFromEnd(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mTail = this.mCapacityBitmask & (this.mTail - i10);
    }

    public void removeFromStart(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.mHead = this.mCapacityBitmask & (this.mHead + i10);
    }

    public int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public CircularIntArray(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i10 > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i10 = Integer.bitCount(i10) != 1 ? Integer.highestOneBit(i10 - 1) << 1 : i10;
        this.mCapacityBitmask = i10 - 1;
        this.mElements = new int[i10];
    }
}
