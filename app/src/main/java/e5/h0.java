package e5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ListIterator;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class h0<E> extends f0<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    public void add(@d1 E e10) {
        delegate().add(e10);
    }

    @Override // e5.f0
    /* renamed from: f */
    public abstract ListIterator<E> delegate();

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return delegate().hasPrevious();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return delegate().nextIndex();
    }

    @Override // java.util.ListIterator
    @CanIgnoreReturnValue
    @d1
    public E previous() {
        return delegate().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return delegate().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(@d1 E e10) {
        delegate().set(e10);
    }
}
