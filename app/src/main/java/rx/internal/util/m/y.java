package rx.internal.util.m;

/* loaded from: classes5.dex */
public final class y<E> extends d0<E> {
    public y(int i2) {
        super(i2);
    }

    private long k() {
        return g0.f36837a.getLongVolatile(this, a0.f0);
    }

    private long l() {
        return g0.f36837a.getLongVolatile(this, e0.N);
    }

    private void m(long j2) {
        g0.f36837a.putOrderedLong(this, a0.f0, j2);
    }

    private void n(long j2) {
        g0.f36837a.putOrderedLong(this, e0.N, j2);
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public boolean offer(E e2) {
        E[] eArr = this.v;
        long j2 = this.O;
        long a2 = a(j2);
        if (f(eArr, a2) != null) {
            return false;
        }
        n(j2 + 1);
        h(eArr, a2, e2);
        return true;
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public E peek() {
        return e(a(this.g0));
    }

    @Override // java.util.Queue, rx.internal.util.m.i
    public E poll() {
        long j2 = this.g0;
        long a2 = a(j2);
        E[] eArr = this.v;
        E f2 = f(eArr, a2);
        if (f2 == null) {
            return null;
        }
        m(j2 + 1);
        h(eArr, a2, null);
        return f2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, rx.internal.util.m.i
    public int size() {
        long k = k();
        while (true) {
            long l = l();
            long k2 = k();
            if (k == k2) {
                return (int) (l - k2);
            }
            k = k2;
        }
    }
}
