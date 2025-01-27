package rx.internal.util.m;

/* loaded from: classes5.dex */
abstract class n<E> extends l<E> {
    private static final long O;
    private volatile long P;

    static {
        try {
            O = g0.f36837a.objectFieldOffset(n.class.getDeclaredField("P"));
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public n(int i2) {
        super(i2);
    }

    protected final boolean n(long j2, long j3) {
        return g0.f36837a.compareAndSwapLong(this, O, j2, j3);
    }

    protected final long o() {
        return this.P;
    }
}
