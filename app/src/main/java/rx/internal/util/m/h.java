package rx.internal.util.m;

/* loaded from: classes5.dex */
public abstract class h<E> extends f<E> {
    private static final long w;
    private static final int x;
    protected final long[] y;

    static {
        if (8 != g0.f36837a.arrayIndexScale(long[].class)) {
            throw new IllegalStateException("Unexpected long[] element size");
        }
        x = f.q + 3;
        w = r1.arrayBaseOffset(long[].class) + (32 << (r3 - r2));
    }

    public h(int i2) {
        super(i2);
        int i3 = (int) (this.u + 1);
        this.y = new long[(i3 << f.q) + 64];
        for (long j2 = 0; j2 < i3; j2++) {
            m(this.y, k(j2), j2);
        }
    }

    protected final long k(long j2) {
        return w + ((j2 & this.u) << x);
    }

    protected final long l(long[] jArr, long j2) {
        return g0.f36837a.getLongVolatile(jArr, j2);
    }

    protected final void m(long[] jArr, long j2, long j3) {
        g0.f36837a.putOrderedLong(jArr, j2, j3);
    }
}
