package u6;

import t5.l;

/* loaded from: classes2.dex */
public final class a extends l {

    /* renamed from: c */
    public final float f30946c;

    public a(float f10, float f11, float f12) {
        super(f10, f11);
        this.f30946c = f12;
    }

    public boolean f(float f10, float f11, float f12) {
        if (Math.abs(f11 - d()) > f10 || Math.abs(f12 - c()) > f10) {
            return false;
        }
        float abs = Math.abs(f10 - this.f30946c);
        return abs <= 1.0f || abs <= this.f30946c;
    }

    public a g(float f10, float f11, float f12) {
        return new a((c() + f11) / 2.0f, (d() + f10) / 2.0f, (this.f30946c + f12) / 2.0f);
    }
}
