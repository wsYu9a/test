package rx.internal.util.m;

/* loaded from: classes5.dex */
public class j<E> extends k<E> {
    long h0;
    long i0;
    long j0;
    long k0;
    long l0;
    long m0;
    long n0;
    long o0;
    long p0;
    long q0;
    long r0;
    long s0;
    long t0;
    long u0;
    long v0;

    public j(int i2) {
        super(Math.max(2, i2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.m.i
    public boolean isEmpty() {
        return q() == o();
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        long j2 = this.u + 1;
        long[] jArr = this.y;
        long j3 = Long.MAX_VALUE;
        while (true) {
            long o = o();
            long k = k(o);
            long l = l(jArr, k) - o;
            if (l == 0) {
                long j4 = o + 1;
                if (n(o, j4)) {
                    i(a(o), e2);
                    m(jArr, k, j4);
                    return true;
                }
            } else if (l < 0) {
                long j5 = o - j2;
                if (j5 <= j3) {
                    j3 = q();
                    if (j5 <= j3) {
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

    @Override // java.util.Queue, rx.internal.util.m.i
    public E peek() {
        long q;
        E c2;
        do {
            q = q();
            c2 = c(a(q));
            if (c2 != null) {
                break;
            }
        } while (q != o());
        return c2;
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public E poll() {
        long[] jArr = this.y;
        long j2 = -1;
        while (true) {
            long q = q();
            long k = k(q);
            long j3 = q + 1;
            long l = l(jArr, k) - j3;
            if (l == 0) {
                if (p(q, j3)) {
                    long a2 = a(q);
                    E c2 = c(a2);
                    i(a2, null);
                    m(jArr, k, q + this.u + 1);
                    return c2;
                }
            } else if (l < 0 && q >= j2) {
                j2 = o();
                if (q == j2) {
                    return null;
                }
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.m.i
    public int size() {
        long q = q();
        while (true) {
            long o = o();
            long q2 = q();
            if (q == q2) {
                return (int) (o - q2);
            }
            q = q2;
        }
    }
}
