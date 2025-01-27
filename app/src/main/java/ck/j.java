package ck;

/* loaded from: classes5.dex */
public class j<E> extends k<E> {
    public long C0;
    public long D0;

    /* renamed from: i0 */
    public long f2182i0;

    /* renamed from: j0 */
    public long f2183j0;

    /* renamed from: k0 */
    public long f2184k0;

    /* renamed from: l0 */
    public long f2185l0;

    /* renamed from: m0 */
    public long f2186m0;

    /* renamed from: n0 */
    public long f2187n0;

    /* renamed from: o0 */
    public long f2188o0;

    /* renamed from: p0 */
    public long f2189p0;

    /* renamed from: q0 */
    public long f2190q0;

    /* renamed from: r0 */
    public long f2191r0;

    /* renamed from: s0 */
    public long f2192s0;

    /* renamed from: t0 */
    public long f2193t0;

    /* renamed from: u0 */
    public long f2194u0;

    public j(int i10) {
        super(Math.max(2, i10));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, ck.i
    public boolean isEmpty() {
        return q() == o();
    }

    @Override // java.util.Queue, ck.i
    public boolean offer(E e10) {
        if (e10 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j10 = this.f2160r + 1;
        long[] jArr = this.f2181x;
        long j11 = Long.MAX_VALUE;
        while (true) {
            long o10 = o();
            long k10 = k(o10);
            long l10 = l(jArr, k10) - o10;
            if (l10 == 0) {
                long j12 = o10 + 1;
                if (n(o10, j12)) {
                    i(a(o10), e10);
                    m(jArr, k10, j12);
                    return true;
                }
            } else if (l10 < 0) {
                long j13 = o10 - j10;
                if (j13 <= j11) {
                    j11 = q();
                    if (j13 <= j11) {
                        return false;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
    }

    @Override // java.util.Queue, ck.i
    public E peek() {
        long q10;
        E c10;
        do {
            q10 = q();
            c10 = c(a(q10));
            if (c10 != null) {
                break;
            }
        } while (q10 != o());
        return c10;
    }

    @Override // java.util.Queue, ck.i
    public E poll() {
        long[] jArr = this.f2181x;
        long j10 = -1;
        while (true) {
            long q10 = q();
            long k10 = k(q10);
            long j11 = q10 + 1;
            long l10 = l(jArr, k10) - j11;
            if (l10 == 0) {
                if (p(q10, j11)) {
                    long a10 = a(q10);
                    E c10 = c(a10);
                    i(a10, null);
                    m(jArr, k10, q10 + this.f2160r + 1);
                    return c10;
                }
            } else if (l10 < 0 && q10 >= j10) {
                j10 = o();
                if (q10 == j10) {
                    return null;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, ck.i
    public int size() {
        long q10 = q();
        while (true) {
            long o10 = o();
            long q11 = q();
            if (q10 == q11) {
                return (int) (o10 - q11);
            }
            q10 = q11;
        }
    }
}
