package ck;

/* loaded from: classes5.dex */
public abstract class z<E> extends f<E> {

    /* renamed from: y */
    public static final Integer f2227y = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    /* renamed from: x */
    public final int f2228x;

    public z(int i10) {
        super(i10);
        this.f2228x = Math.min(i10 / 4, f2227y.intValue());
    }
}
