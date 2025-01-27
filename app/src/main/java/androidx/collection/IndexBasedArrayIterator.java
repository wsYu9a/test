package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
abstract class IndexBasedArrayIterator<T> implements Iterator<T> {
    private boolean mCanRemove;
    private int mIndex;
    private int mSize;

    public IndexBasedArrayIterator(int i10) {
        this.mSize = i10;
    }

    public abstract T elementAt(int i10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.mIndex < this.mSize;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T elementAt = elementAt(this.mIndex);
        this.mIndex++;
        this.mCanRemove = true;
        return elementAt;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.mCanRemove) {
            throw new IllegalStateException();
        }
        int i10 = this.mIndex - 1;
        this.mIndex = i10;
        removeAt(i10);
        this.mSize--;
        this.mCanRemove = false;
    }

    public abstract void removeAt(int i10);
}
