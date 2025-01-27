package rx.internal.util.m;

/* loaded from: classes5.dex */
abstract class e0<E> extends b0<E> {
    protected static final long N;
    protected long O;
    protected long P;

    static {
        try {
            N = g0.f36837a.objectFieldOffset(e0.class.getDeclaredField("O"));
        } catch (NoSuchFieldException e2) {
            throw new RuntimeException(e2);
        }
    }

    public e0(int i2) {
        super(i2);
    }
}
