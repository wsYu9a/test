package rx.internal.util.m;

/* loaded from: classes5.dex */
public final class q<E> extends u<E> {
    public q(int i2) {
        super(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.m.i
    public boolean isEmpty() {
        return n() == k();
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.v;
        long j2 = this.u;
        long k = k();
        long a2 = a(k);
        if (f(eArr, a2) != null) {
            if (k - n() > j2) {
                return false;
            }
            while (f(eArr, a2) != null) {
            }
        }
        j(eArr, a2, e2);
        l(k + 1);
        return true;
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public E peek() {
        E e2;
        long o = o();
        do {
            long n = n();
            if (n >= o) {
                long k = k();
                if (n >= k) {
                    return null;
                }
                p(k);
            }
            e2 = e(a(n));
        } while (e2 == null);
        return e2;
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public E poll() {
        long n;
        long o = o();
        do {
            n = n();
            if (n >= o) {
                long k = k();
                if (n >= k) {
                    return null;
                }
                p(k);
            }
        } while (!m(n, 1 + n));
        long a2 = a(n);
        E[] eArr = this.v;
        E d2 = d(eArr, a2);
        h(eArr, a2, null);
        return d2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.m.i
    public int size() {
        long n = n();
        while (true) {
            long k = k();
            long n2 = n();
            if (n == n2) {
                return (int) (k - n2);
            }
            n = n2;
        }
    }
}
