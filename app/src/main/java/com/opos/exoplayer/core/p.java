package com.opos.exoplayer.core;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: a */
    public static final p f19184a = new p(1.0f, 1.0f);

    /* renamed from: b */
    public final float f19185b;

    /* renamed from: c */
    public final float f19186c;

    /* renamed from: d */
    private final int f19187d;

    public p(float f2, float f3) {
        com.opos.exoplayer.core.i.a.a(f2 > 0.0f);
        com.opos.exoplayer.core.i.a.a(f3 > 0.0f);
        this.f19185b = f2;
        this.f19186c = f3;
        this.f19187d = Math.round(f2 * 1000.0f);
    }

    public long a(long j2) {
        return this.f19187d * j2;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || p.class != obj.getClass()) {
                return false;
            }
            p pVar = (p) obj;
            if (this.f19185b != pVar.f19185b || this.f19186c != pVar.f19186c) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.f19185b) + 527) * 31) + Float.floatToRawIntBits(this.f19186c);
    }
}
