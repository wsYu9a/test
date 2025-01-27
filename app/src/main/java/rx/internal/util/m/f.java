package rx.internal.util.m;

import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {
    protected static final int q;
    protected static final int r = 32;
    private static final long s;
    private static final int t;
    protected final long u;
    protected final E[] v;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        q = intValue;
        int arrayIndexScale = g0.f36837a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            t = intValue + 2;
        } else {
            if (8 != arrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            t = intValue + 3;
        }
        s = r2.arrayBaseOffset(Object[].class) + (32 << (t - intValue));
    }

    public f(int i2) {
        int b2 = p.b(i2);
        this.u = b2 - 1;
        this.v = (E[]) new Object[(b2 << q) + 64];
    }

    protected final long a(long j2) {
        return b(j2, this.u);
    }

    protected final long b(long j2, long j3) {
        return s + ((j2 & j3) << t);
    }

    protected final E c(long j2) {
        return d(this.v, j2);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    protected final E d(E[] eArr, long j2) {
        return (E) g0.f36837a.getObject(eArr, j2);
    }

    protected final E e(long j2) {
        return f(this.v, j2);
    }

    protected final E f(E[] eArr, long j2) {
        return (E) g0.f36837a.getObjectVolatile(eArr, j2);
    }

    protected final void g(long j2, E e2) {
        h(this.v, j2, e2);
    }

    protected final void h(E[] eArr, long j2, E e2) {
        g0.f36837a.putOrderedObject(eArr, j2, e2);
    }

    protected final void i(long j2, E e2) {
        j(this.v, j2, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    protected final void j(E[] eArr, long j2, E e2) {
        g0.f36837a.putObject(eArr, j2, e2);
    }
}
