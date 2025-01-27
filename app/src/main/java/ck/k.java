package ck;

/* loaded from: classes5.dex */
public abstract class k<E> extends m<E> {

    /* renamed from: h0 */
    public static final long f2195h0;

    /* renamed from: g0 */
    public volatile long f2196g0;

    static {
        try {
            f2195h0 = g0.f2178a.objectFieldOffset(k.class.getDeclaredField("g0"));
        } catch (NoSuchFieldException e10) {
            throw new RuntimeException(e10);
        }
    }

    public k(int i10) {
        super(i10);
    }

    public final boolean p(long j10, long j11) {
        return g0.f2178a.compareAndSwapLong(this, f2195h0, j10, j11);
    }

    public final long q() {
        return this.f2196g0;
    }
}
