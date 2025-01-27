package ck;

import java.util.Iterator;

/* loaded from: classes5.dex */
public abstract class f<E> extends g<E> {

    /* renamed from: t */
    public static final int f2156t;

    /* renamed from: u */
    public static final int f2157u = 32;

    /* renamed from: v */
    public static final long f2158v;

    /* renamed from: w */
    public static final int f2159w;

    /* renamed from: r */
    public final long f2160r;

    /* renamed from: s */
    public final E[] f2161s;

    static {
        int intValue = Integer.getInteger("sparse.shift", 0).intValue();
        f2156t = intValue;
        int arrayIndexScale = g0.f2178a.arrayIndexScale(Object[].class);
        if (4 == arrayIndexScale) {
            f2159w = intValue + 2;
        } else {
            if (8 != arrayIndexScale) {
                throw new IllegalStateException("Unknown pointer size");
            }
            f2159w = intValue + 3;
        }
        f2158v = r1.arrayBaseOffset(Object[].class) + (32 << (f2159w - intValue));
    }

    public f(int i10) {
        int b10 = p.b(i10);
        this.f2160r = b10 - 1;
        this.f2161s = (E[]) new Object[(b10 << f2156t) + 64];
    }

    public final long a(long j10) {
        return b(j10, this.f2160r);
    }

    public final long b(long j10, long j11) {
        return f2158v + ((j10 & j11) << f2159w);
    }

    public final E c(long j10) {
        return d(this.f2161s, j10);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(E[] eArr, long j10) {
        return (E) g0.f2178a.getObject(eArr, j10);
    }

    public final E e(long j10) {
        return f(this.f2161s, j10);
    }

    public final E f(E[] eArr, long j10) {
        return (E) g0.f2178a.getObjectVolatile(eArr, j10);
    }

    public final void g(long j10, E e10) {
        h(this.f2161s, j10, e10);
    }

    public final void h(E[] eArr, long j10, E e10) {
        g0.f2178a.putOrderedObject(eArr, j10, e10);
    }

    public final void i(long j10, E e10) {
        j(this.f2161s, j10, e10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final void j(E[] eArr, long j10, E e10) {
        g0.f2178a.putObject(eArr, j10, e10);
    }
}
