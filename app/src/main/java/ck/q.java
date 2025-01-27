package ck;

/* loaded from: classes5.dex */
public final class q<E> extends u<E> {
    public q(int i10) {
        super(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, ck.i
    public boolean isEmpty() {
        return n() == k();
    }

    @Override // java.util.Queue, ck.i
    public boolean offer(E e10) {
        if (e10 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.f2161s;
        long j10 = this.f2160r;
        long k10 = k();
        long a10 = a(k10);
        if (f(eArr, a10) != null) {
            if (k10 - n() > j10) {
                return false;
            }
            while (f(eArr, a10) != null) {
            }
        }
        j(eArr, a10, e10);
        l(k10 + 1);
        return true;
    }

    @Override // java.util.Queue, ck.i
    public E peek() {
        E e10;
        long o10 = o();
        do {
            long n10 = n();
            if (n10 >= o10) {
                long k10 = k();
                if (n10 >= k10) {
                    return null;
                }
                p(k10);
            }
            e10 = e(a(n10));
        } while (e10 == null);
        return e10;
    }

    @Override // java.util.Queue, ck.i
    public E poll() {
        long n10;
        long o10 = o();
        do {
            n10 = n();
            if (n10 >= o10) {
                long k10 = k();
                if (n10 >= k10) {
                    return null;
                }
                p(k10);
            }
        } while (!m(n10, 1 + n10));
        long a10 = a(n10);
        E[] eArr = this.f2161s;
        E d10 = d(eArr, a10);
        h(eArr, a10, null);
        return d10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, ck.i
    public int size() {
        long n10 = n();
        while (true) {
            long k10 = k();
            long n11 = n();
            if (n10 == n11) {
                return (int) (k10 - n11);
            }
            n10 = n11;
        }
    }
}
