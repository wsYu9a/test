package e5;

import com.google.common.collect.Iterators;
import java.util.ListIterator;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class w1<F, T> extends v1<F, T> implements ListIterator<T> {
    public w1(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(@d1 T t10) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<? extends F> b() {
        return Iterators.f(this.f25662b);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    @d1
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(@d1 T t10) {
        throw new UnsupportedOperationException();
    }
}
