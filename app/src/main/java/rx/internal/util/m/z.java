package rx.internal.util.m;

/* loaded from: classes5.dex */
abstract class z<E> extends f<E> {
    private static final Integer w = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    protected final int x;

    public z(int i2) {
        super(i2);
        this.x = Math.min(i2 / 4, w.intValue());
    }
}
