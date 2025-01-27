package ck;

/* loaded from: classes5.dex */
public abstract class h<E> extends f<E> {

    /* renamed from: y */
    public static final long f2179y;

    /* renamed from: z */
    public static final int f2180z;

    /* renamed from: x */
    public final long[] f2181x;

    static {
        if (8 != g0.f2178a.arrayIndexScale(long[].class)) {
            throw new IllegalStateException("Unexpected long[] element size");
        }
        f2180z = f.f2156t + 3;
        f2179y = r0.arrayBaseOffset(long[].class) + (32 << (r3 - r2));
    }

    public h(int i10) {
        super(i10);
        int i11 = (int) (this.f2160r + 1);
        this.f2181x = new long[(i11 << f.f2156t) + 64];
        for (long j10 = 0; j10 < i11; j10++) {
            m(this.f2181x, k(j10), j10);
        }
    }

    public final long k(long j10) {
        return f2179y + ((j10 & this.f2160r) << f2180z);
    }

    public final long l(long[] jArr, long j10) {
        return g0.f2178a.getLongVolatile(jArr, j10);
    }

    public final void m(long[] jArr, long j10, long j11) {
        g0.f2178a.putOrderedLong(jArr, j10, j11);
    }
}
