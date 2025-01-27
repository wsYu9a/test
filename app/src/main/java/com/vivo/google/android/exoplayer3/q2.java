package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.x2;

/* loaded from: classes4.dex */
public final class q2 implements x2 {

    /* renamed from: a */
    public final j2 f27949a;

    /* renamed from: b */
    public final m6 f27950b = new m6(new byte[10]);

    /* renamed from: c */
    public int f27951c = 0;

    /* renamed from: d */
    public int f27952d;

    /* renamed from: e */
    public u6 f27953e;

    /* renamed from: f */
    public boolean f27954f;

    /* renamed from: g */
    public boolean f27955g;

    /* renamed from: h */
    public boolean f27956h;

    /* renamed from: i */
    public int f27957i;

    /* renamed from: j */
    public int f27958j;
    public boolean k;
    public long l;

    public q2(j2 j2Var) {
        this.f27949a = j2Var;
    }

    @Override // com.vivo.google.android.exoplayer3.x2
    public final void a() {
        this.f27951c = 0;
        this.f27952d = 0;
        this.f27956h = false;
        this.f27949a.a();
    }

    public final void a(int i2) {
        this.f27951c = i2;
        this.f27952d = 0;
    }

    @Override // com.vivo.google.android.exoplayer3.x2
    public final void a(n6 n6Var, boolean z) {
        boolean z2;
        if (z) {
            int i2 = this.f27951c;
            if (i2 != 2 && i2 == 3) {
                if (this.f27958j != -1) {
                    String str = "Unexpected start indicator: expected " + this.f27958j + " more bytes";
                }
                this.f27949a.b();
            }
            a(1);
        }
        while (n6Var.a() > 0) {
            int i3 = this.f27951c;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (a(n6Var, this.f27950b.f27770a, Math.min(10, this.f27957i)) && a(n6Var, (byte[]) null, this.f27957i)) {
                            this.f27950b.b(0);
                            this.l = C.TIME_UNSET;
                            if (this.f27954f) {
                                this.f27950b.c(4);
                                this.f27950b.c(1);
                                this.f27950b.c(1);
                                long a2 = (this.f27950b.a(3) << 30) | (this.f27950b.a(15) << 15) | this.f27950b.a(15);
                                this.f27950b.c(1);
                                if (!this.f27956h && this.f27955g) {
                                    this.f27950b.c(4);
                                    this.f27950b.c(1);
                                    this.f27950b.c(1);
                                    this.f27950b.c(1);
                                    this.f27953e.b(this.f27950b.a(15) | (this.f27950b.a(3) << 30) | (this.f27950b.a(15) << 15));
                                    this.f27956h = true;
                                }
                                this.l = this.f27953e.b(a2);
                            }
                            this.f27949a.a(this.l, this.k);
                            a(3);
                        }
                    } else if (i3 == 3) {
                        int a3 = n6Var.a();
                        int i4 = this.f27958j;
                        int i5 = i4 != -1 ? a3 - i4 : 0;
                        if (i5 > 0) {
                            a3 -= i5;
                            n6Var.c(n6Var.f27875b + a3);
                        }
                        this.f27949a.a(n6Var);
                        int i6 = this.f27958j;
                        if (i6 != -1) {
                            int i7 = i6 - a3;
                            this.f27958j = i7;
                            if (i7 == 0) {
                                this.f27949a.b();
                                a(1);
                            }
                        }
                    }
                } else if (a(n6Var, this.f27950b.f27770a, 9)) {
                    this.f27950b.b(0);
                    int a4 = this.f27950b.a(24);
                    if (a4 != 1) {
                        String str2 = "Unexpected start code prefix: " + a4;
                        this.f27958j = -1;
                        z2 = false;
                    } else {
                        this.f27950b.c(8);
                        int a5 = this.f27950b.a(16);
                        this.f27950b.c(5);
                        this.k = this.f27950b.d();
                        this.f27950b.c(2);
                        this.f27954f = this.f27950b.d();
                        this.f27955g = this.f27950b.d();
                        this.f27950b.c(6);
                        int a6 = this.f27950b.a(8);
                        this.f27957i = a6;
                        if (a5 == 0) {
                            this.f27958j = -1;
                        } else {
                            this.f27958j = ((a5 + 6) - 9) - a6;
                        }
                        z2 = true;
                    }
                    a(z2 ? 2 : 0);
                }
            } else {
                n6Var.e(n6Var.a());
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.x2
    public void a(u6 u6Var, i0 i0Var, x2.d dVar) {
        this.f27953e = u6Var;
        this.f27949a.a(i0Var, dVar);
    }

    public final boolean a(n6 n6Var, byte[] bArr, int i2) {
        int min = Math.min(n6Var.a(), i2 - this.f27952d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            n6Var.e(min);
        } else {
            System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, this.f27952d, min);
            n6Var.f27875b += min;
        }
        int i3 = this.f27952d + min;
        this.f27952d = i3;
        return i3 == i2;
    }
}
