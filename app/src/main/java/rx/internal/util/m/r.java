package rx.internal.util.m;

/* loaded from: classes5.dex */
abstract class r<E> extends t<E> {
    protected static final long c0;
    private volatile long d0;

    static {
        try {
            c0 = g0.f36837a.objectFieldOffset(r.class.getDeclaredField("d0"));
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public r(int i2) {
        super(i2);
    }

    protected final boolean m(long j2, long j3) {
        return g0.f36837a.compareAndSwapLong(this, c0, j2, j3);
    }

    protected final long n() {
        return this.d0;
    }
}
