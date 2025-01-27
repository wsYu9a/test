package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.x2;

/* loaded from: classes4.dex */
public final class t2 implements x2 {

    /* renamed from: a */
    public final s2 f28093a;

    /* renamed from: b */
    public final n6 f28094b = new n6(32);

    /* renamed from: c */
    public int f28095c;

    /* renamed from: d */
    public int f28096d;

    /* renamed from: e */
    public boolean f28097e;

    /* renamed from: f */
    public boolean f28098f;

    public t2(s2 s2Var) {
        this.f28093a = s2Var;
    }

    @Override // com.vivo.google.android.exoplayer3.x2
    public void a() {
        this.f28098f = true;
    }

    @Override // com.vivo.google.android.exoplayer3.x2
    public void a(n6 n6Var, boolean z) {
        int l = z ? n6Var.f27875b + n6Var.l() : -1;
        if (this.f28098f) {
            if (!z) {
                return;
            }
            this.f28098f = false;
            n6Var.d(l);
            this.f28096d = 0;
        }
        while (n6Var.a() > 0) {
            int i2 = this.f28096d;
            if (i2 < 3) {
                if (i2 == 0) {
                    int l2 = n6Var.l();
                    n6Var.d(n6Var.f27875b - 1);
                    if (l2 == 255) {
                        this.f28098f = true;
                        return;
                    }
                }
                int min = Math.min(n6Var.a(), 3 - this.f28096d);
                n6Var.a(this.f28094b.f27874a, this.f28096d, min);
                int i3 = this.f28096d + min;
                this.f28096d = i3;
                if (i3 == 3) {
                    this.f28094b.b(3);
                    this.f28094b.e(1);
                    int l3 = this.f28094b.l();
                    int l4 = this.f28094b.l();
                    this.f28097e = (l3 & 128) != 0;
                    this.f28095c = (((l3 & 15) << 8) | l4) + 3;
                    int b2 = this.f28094b.b();
                    int i4 = this.f28095c;
                    if (b2 < i4) {
                        n6 n6Var2 = this.f28094b;
                        byte[] bArr = n6Var2.f27874a;
                        n6Var2.b(Math.min(4098, Math.max(i4, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f28094b.f27874a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(n6Var.a(), this.f28095c - this.f28096d);
                n6Var.a(this.f28094b.f27874a, this.f28096d, min2);
                int i5 = this.f28096d + min2;
                this.f28096d = i5;
                int i6 = this.f28095c;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.f28097e) {
                        this.f28094b.b(i6);
                    } else {
                        if (Util.crc(this.f28094b.f27874a, 0, i6, -1) != 0) {
                            this.f28098f = true;
                            return;
                        }
                        this.f28094b.b(this.f28095c - 4);
                    }
                    this.f28093a.a(this.f28094b);
                    this.f28096d = 0;
                }
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.x2
    public void a(u6 u6Var, i0 i0Var, x2.d dVar) {
        this.f28093a.a(u6Var, i0Var, dVar);
        this.f28098f = true;
    }
}
