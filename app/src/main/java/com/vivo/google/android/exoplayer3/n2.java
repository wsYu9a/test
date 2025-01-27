package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;

/* loaded from: classes4.dex */
public final class n2 implements j2 {

    /* renamed from: a */
    public final n6 f27859a = new n6(10);

    /* renamed from: b */
    public n0 f27860b;

    /* renamed from: c */
    public boolean f27861c;

    /* renamed from: d */
    public long f27862d;

    /* renamed from: e */
    public int f27863e;

    /* renamed from: f */
    public int f27864f;

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        this.f27861c = false;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        if (z) {
            this.f27861c = true;
            this.f27862d = j2;
            this.f27863e = 0;
            this.f27864f = 0;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        dVar.a();
        n0 a2 = ((l3) i0Var).a(dVar.c(), 4);
        this.f27860b = a2;
        a2.a(Format.createSampleFormat(dVar.b(), "application/id3", null, -1, null));
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(n6 n6Var) {
        if (this.f27861c) {
            int a2 = n6Var.a();
            int i2 = this.f27864f;
            if (i2 < 10) {
                int min = Math.min(a2, 10 - i2);
                System.arraycopy(n6Var.f27874a, n6Var.f27875b, this.f27859a.f27874a, this.f27864f, min);
                if (this.f27864f + min == 10) {
                    this.f27859a.d(0);
                    if (73 != this.f27859a.l() || 68 != this.f27859a.l() || 51 != this.f27859a.l()) {
                        this.f27861c = false;
                        return;
                    } else {
                        this.f27859a.e(3);
                        this.f27863e = this.f27859a.k() + 10;
                    }
                }
            }
            int min2 = Math.min(a2, this.f27863e - this.f27864f);
            this.f27860b.a(n6Var, min2);
            this.f27864f += min2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
        int i2;
        if (this.f27861c && (i2 = this.f27863e) != 0 && this.f27864f == i2) {
            this.f27860b.a(this.f27862d, 1, i2, 0, null);
            this.f27861c = false;
        }
    }
}
