package e5;

import java.util.NoSuchElementException;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class a<E> extends a2<E> {

    /* renamed from: b */
    public final int f25604b;

    /* renamed from: c */
    public int f25605c;

    public a(int i10) {
        this(i10, 0);
    }

    @d1
    public abstract E a(int i10);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f25605c < this.f25604b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f25605c > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    @d1
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f25605c;
        this.f25605c = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f25605c;
    }

    @Override // java.util.ListIterator
    @d1
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f25605c - 1;
        this.f25605c = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f25605c - 1;
    }

    public a(int i10, int i11) {
        b5.u.d0(i11, i10);
        this.f25604b = i10;
        this.f25605c = i11;
    }
}
