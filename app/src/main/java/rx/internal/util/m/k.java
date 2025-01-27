package rx.internal.util.m;

/* loaded from: classes5.dex */
abstract class k<E> extends m<E> {
    private static final long f0;
    private volatile long g0;

    static {
        try {
            f0 = g0.f36837a.objectFieldOffset(k.class.getDeclaredField("g0"));
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public k(int i2) {
        super(i2);
    }

    protected final boolean p(long j2, long j3) {
        return g0.f36837a.compareAndSwapLong(this, f0, j2, j3);
    }

    protected final long q() {
        return this.g0;
    }
}
