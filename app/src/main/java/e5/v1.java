package e5;

import java.util.Iterator;

@a5.b
@m
/* loaded from: classes2.dex */
public abstract class v1<F, T> implements Iterator<T> {

    /* renamed from: b */
    public final Iterator<? extends F> f25662b;

    public v1(Iterator<? extends F> it) {
        this.f25662b = (Iterator) b5.u.E(it);
    }

    @d1
    public abstract T a(@d1 F f10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f25662b.hasNext();
    }

    @Override // java.util.Iterator
    @d1
    public final T next() {
        return a(this.f25662b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f25662b.remove();
    }
}
