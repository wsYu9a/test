package u6;

import t5.l;

/* loaded from: classes2.dex */
public final class d extends l {

    /* renamed from: c */
    public final float f30958c;

    /* renamed from: d */
    public final int f30959d;

    public d(float f10, float f11, float f12) {
        this(f10, f11, f12, 1);
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f30958c);
        return abs <= 1.0f || abs <= this.f30958c;
    }

    public d g(float f10, float f11, float f12) {
        int i10 = this.f30959d;
        int i11 = i10 + 1;
        float c10 = (i10 * c()) + f11;
        float f13 = i11;
        return new d(c10 / f13, ((this.f30959d * d()) + f10) / f13, ((this.f30959d * this.f30958c) + f12) / f13, i11);
    }

    public int h() {
        return this.f30959d;
    }

    public float i() {
        return this.f30958c;
    }

    public d(float f10, float f11, float f12, int i10) {
        super(f10, f11);
        this.f30958c = f12;
        this.f30959d = i10;
    }
}
