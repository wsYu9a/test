package ck;

/* loaded from: classes5.dex */
public abstract class n<E> extends l<E> {
    public static final long Q;
    public volatile long P;

    static {
        try {
            Q = g0.f2178a.objectFieldOffset(n.class.getDeclaredField("P"));
        } catch (NoSuchFieldException e10) {
            throw new RuntimeException(e10);
        }
    }

    public n(int i10) {
        super(i10);
    }

    public final boolean n(long j10, long j11) {
        return g0.f2178a.compareAndSwapLong(this, Q, j10, j11);
    }

    public final long o() {
        return this.P;
    }
}
