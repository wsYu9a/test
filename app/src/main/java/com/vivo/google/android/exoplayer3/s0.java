package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.r0;

/* loaded from: classes4.dex */
public final class s0 extends r0 {

    /* renamed from: b */
    public final n6 f28034b;

    /* renamed from: c */
    public final n6 f28035c;

    /* renamed from: d */
    public int f28036d;

    /* renamed from: e */
    public boolean f28037e;

    /* renamed from: f */
    public int f28038f;

    public s0(n0 n0Var) {
        super(n0Var);
        this.f28034b = new n6(l6.f27726a);
        this.f28035c = new n6(4);
    }

    @Override // com.vivo.google.android.exoplayer3.r0
    public boolean a(n6 n6Var) {
        int l = n6Var.l();
        int i2 = (l >> 4) & 15;
        int i3 = l & 15;
        if (i3 == 7) {
            this.f28038f = i2;
            return i2 != 5;
        }
        throw new r0.a("Video format not supported: " + i3);
    }

    @Override // com.vivo.google.android.exoplayer3.r0
    public void b(n6 n6Var, long j2) {
        int l = n6Var.l();
        long n = j2 + (n6Var.n() * 1000);
        if (l == 0 && !this.f28037e) {
            n6 n6Var2 = new n6(new byte[n6Var.a()]);
            n6Var.a(n6Var2.f27874a, 0, n6Var.a());
            w6 b2 = w6.b(n6Var2);
            this.f28036d = b2.f28251b;
            this.f27986a.a(Format.createVideoSampleFormat(null, "video/avc", null, -1, -1, b2.f28252c, b2.f28253d, -1.0f, b2.f28250a, -1, b2.f28254e, null));
            this.f28037e = true;
            return;
        }
        if (l == 1 && this.f28037e) {
            byte[] bArr = this.f28035c.f27874a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i2 = 4 - this.f28036d;
            int i3 = 0;
            while (n6Var.a() > 0) {
                n6Var.a(this.f28035c.f27874a, i2, this.f28036d);
                this.f28035c.d(0);
                int o = this.f28035c.o();
                this.f28034b.d(0);
                this.f27986a.a(this.f28034b, 4);
                this.f27986a.a(n6Var, o);
                i3 = i3 + 4 + o;
            }
            this.f27986a.a(n, this.f28038f == 1 ? 1 : 0, i3, 0, null);
        }
    }
}
