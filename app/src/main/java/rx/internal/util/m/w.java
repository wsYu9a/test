package rx.internal.util.m;

/* loaded from: classes5.dex */
abstract class w<E> extends s<E> {
    protected static final long L;
    private volatile long M;

    static {
        try {
            L = g0.f36837a.objectFieldOffset(w.class.getDeclaredField("M"));
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public w(int i2) {
        super(i2);
    }

    protected final long k() {
        return this.M;
    }

    protected final void l(long j2) {
        g0.f36837a.putOrderedLong(this, L, j2);
    }
}
