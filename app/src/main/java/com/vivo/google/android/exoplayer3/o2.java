package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;

/* loaded from: classes4.dex */
public final class o2 implements j2 {

    /* renamed from: a */
    public final n6 f27890a;

    /* renamed from: b */
    public final k0 f27891b;

    /* renamed from: c */
    public final String f27892c;

    /* renamed from: d */
    public String f27893d;

    /* renamed from: e */
    public n0 f27894e;

    /* renamed from: f */
    public int f27895f = 0;

    /* renamed from: g */
    public int f27896g;

    /* renamed from: h */
    public boolean f27897h;

    /* renamed from: i */
    public boolean f27898i;

    /* renamed from: j */
    public long f27899j;
    public int k;
    public long l;

    public o2(String str) {
        n6 n6Var = new n6(4);
        this.f27890a = n6Var;
        n6Var.f27874a[0] = -1;
        this.f27891b = new k0();
        this.f27892c = str;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a() {
        this.f27895f = 0;
        this.f27896g = 0;
        this.f27898i = false;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(long j2, boolean z) {
        this.l = j2;
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(i0 i0Var, x2.d dVar) {
        dVar.a();
        this.f27893d = dVar.b();
        this.f27894e = ((l3) i0Var).a(dVar.c(), 1);
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void a(n6 n6Var) {
        while (n6Var.a() > 0) {
            int i2 = this.f27895f;
            if (i2 == 0) {
                byte[] bArr = n6Var.f27874a;
                int i3 = n6Var.f27875b;
                int i4 = n6Var.f27876c;
                while (true) {
                    if (i3 >= i4) {
                        n6Var.d(i4);
                        break;
                    }
                    boolean z = (bArr[i3] & 255) == 255;
                    boolean z2 = this.f27898i && (bArr[i3] & 224) == 224;
                    this.f27898i = z;
                    if (z2) {
                        n6Var.d(i3 + 1);
                        this.f27898i = false;
                        this.f27890a.f27874a[1] = bArr[i3];
                        this.f27896g = 2;
                        this.f27895f = 1;
                        break;
                    }
                    i3++;
                }
            } else if (i2 == 1) {
                int min = Math.min(n6Var.a(), 4 - this.f27896g);
                n6Var.a(this.f27890a.f27874a, this.f27896g, min);
                int i5 = this.f27896g + min;
                this.f27896g = i5;
                if (i5 >= 4) {
                    this.f27890a.d(0);
                    if (k0.a(this.f27890a.c(), this.f27891b)) {
                        k0 k0Var = this.f27891b;
                        this.k = k0Var.f27554c;
                        if (!this.f27897h) {
                            long j2 = k0Var.f27558g * C.MICROS_PER_SECOND;
                            int i6 = k0Var.f27555d;
                            this.f27899j = j2 / i6;
                            this.f27894e.a(Format.createAudioSampleFormat(this.f27893d, k0Var.f27553b, null, -1, 4096, k0Var.f27556e, i6, null, null, 0, this.f27892c));
                            this.f27897h = true;
                        }
                        this.f27890a.d(0);
                        this.f27894e.a(this.f27890a, 4);
                        this.f27895f = 2;
                    } else {
                        this.f27896g = 0;
                        this.f27895f = 1;
                    }
                }
            } else if (i2 == 2) {
                int min2 = Math.min(n6Var.a(), this.k - this.f27896g);
                this.f27894e.a(n6Var, min2);
                int i7 = this.f27896g + min2;
                this.f27896g = i7;
                int i8 = this.k;
                if (i7 >= i8) {
                    this.f27894e.a(this.l, 1, i8, 0, null);
                    this.l += this.f27899j;
                    this.f27896g = 0;
                    this.f27895f = 0;
                }
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.j2
    public void b() {
    }
}
