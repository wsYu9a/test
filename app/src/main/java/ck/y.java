package ck;

/* loaded from: classes5.dex */
public final class y<E> extends d0<E> {
    public y(int i10) {
        super(i10);
    }

    private long k() {
        return g0.f2178a.getLongVolatile(this, a0.f2109h0);
    }

    private long l() {
        return g0.f2178a.getLongVolatile(this, e0.Q);
    }

    public final void m(long j10) {
        g0.f2178a.putOrderedLong(this, a0.f2109h0, j10);
    }

    public final void n(long j10) {
        g0.f2178a.putOrderedLong(this, e0.Q, j10);
    }

    @Override // java.util.Queue, ck.i
    public boolean offer(E e10) {
        E[] eArr = this.f2161s;
        long j10 = this.O;
        long a10 = a(j10);
        if (f(eArr, a10) != null) {
            return false;
        }
        n(j10 + 1);
        h(eArr, a10, e10);
        return true;
    }

    @Override // java.util.Queue, ck.i
    public E peek() {
        return e(a(this.f2110g0));
    }

    @Override // java.util.Queue, ck.i
    public E poll() {
        long j10 = this.f2110g0;
        long a10 = a(j10);
        E[] eArr = this.f2161s;
        E f10 = f(eArr, a10);
        if (f10 == null) {
            return null;
        }
        m(j10 + 1);
        h(eArr, a10, null);
        return f10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, ck.i
    public int size() {
        long k10 = k();
        while (true) {
            long l10 = l();
            long k11 = k();
            if (k10 == k11) {
                return (int) (l10 - k11);
            }
            k10 = k11;
        }
    }
}
