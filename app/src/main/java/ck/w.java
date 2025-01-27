package ck;

/* loaded from: classes5.dex */
public abstract class w<E> extends s<E> {
    public static final long N;
    public volatile long M;

    static {
        try {
            N = g0.f2178a.objectFieldOffset(w.class.getDeclaredField("M"));
        } catch (NoSuchFieldException e10) {
            throw new RuntimeException(e10);
        }
    }

    public w(int i10) {
        super(i10);
    }

    public final long k() {
        return this.M;
    }

    public final void l(long j10) {
        g0.f2178a.putOrderedLong(this, N, j10);
    }
}
