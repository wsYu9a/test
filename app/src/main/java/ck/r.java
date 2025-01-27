package ck;

/* loaded from: classes5.dex */
public abstract class r<E> extends t<E> {

    /* renamed from: e0 */
    public static final long f2203e0;

    /* renamed from: d0 */
    public volatile long f2204d0;

    static {
        try {
            f2203e0 = g0.f2178a.objectFieldOffset(r.class.getDeclaredField("d0"));
        } catch (NoSuchFieldException e10) {
            throw new RuntimeException(e10);
        }
    }

    public r(int i10) {
        super(i10);
    }

    public final boolean m(long j10, long j11) {
        return g0.f2178a.compareAndSwapLong(this, f2203e0, j10, j11);
    }

    public final long n() {
        return this.f2204d0;
    }
}
