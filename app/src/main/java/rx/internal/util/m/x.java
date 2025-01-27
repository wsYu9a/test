package rx.internal.util.m;

/* loaded from: classes5.dex */
abstract class x<E> extends v<E> {
    private volatile long t0;

    public x(int i2) {
        super(i2);
    }

    protected final long o() {
        return this.t0;
    }

    protected final void p(long j2) {
        this.t0 = j2;
    }
}
