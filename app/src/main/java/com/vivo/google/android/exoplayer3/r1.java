package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.w1;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class r1 implements g0 {

    /* renamed from: a */
    public w1 f27987a;

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(i0 i0Var) {
        l3 l3Var = (l3) i0Var;
        n0 a2 = l3Var.a(0, 1);
        l3Var.f();
        w1 w1Var = this.f27987a;
        w1Var.f28218c = l3Var;
        w1Var.f28217b = a2;
        w1Var.f28216a = new s1();
        w1Var.a(true);
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void release() {
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public int a(h0 h0Var, l0 l0Var) {
        w1 w1Var = this.f27987a;
        int i2 = w1Var.f28223h;
        if (i2 == 0) {
            boolean z = true;
            while (z) {
                if (!w1Var.f28216a.a(h0Var)) {
                    w1Var.f28223h = 3;
                    return -1;
                }
                d0 d0Var = (d0) h0Var;
                long j2 = d0Var.f27268c;
                long j3 = w1Var.f28221f;
                w1Var.k = j2 - j3;
                boolean a2 = w1Var.a(w1Var.f28216a.f28040b, j3, w1Var.f28225j);
                if (a2) {
                    w1Var.f28221f = d0Var.f27268c;
                }
                z = a2;
            }
            Format format = w1Var.f28225j.f28226a;
            w1Var.f28224i = format.sampleRate;
            if (!w1Var.m) {
                w1Var.f28217b.a(format);
                w1Var.m = true;
            }
            u1 u1Var = w1Var.f28225j.f28227b;
            if (u1Var != null) {
                w1Var.f28219d = u1Var;
            } else {
                long j4 = ((d0) h0Var).f27267b;
                if (j4 == -1) {
                    w1Var.f28219d = new w1.b();
                } else {
                    t1 t1Var = w1Var.f28216a.f28039a;
                    w1Var.f28219d = new p1(w1Var.f28221f, j4, w1Var, t1Var.f28089e + t1Var.f28090f, t1Var.f28087c);
                }
            }
            w1Var.f28225j = null;
            w1Var.f28223h = 2;
            n6 n6Var = w1Var.f28216a.f28040b;
            byte[] bArr = n6Var.f27874a;
            if (bArr.length != 65025) {
                n6Var.f27874a = Arrays.copyOf(bArr, Math.max(65025, n6Var.f27876c));
            }
        } else if (i2 == 1) {
            ((d0) h0Var).c((int) w1Var.f28221f);
            w1Var.f28223h = 2;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException();
            }
            long a3 = w1Var.f28219d.a(h0Var);
            if (a3 >= 0) {
                l0Var.f27602a = a3;
                return 1;
            }
            if (a3 < -1) {
                w1Var.b(-(a3 + 2));
            }
            if (!w1Var.l) {
                ((l3) w1Var.f28218c).a(w1Var.f28219d.b());
                w1Var.l = true;
            }
            if (w1Var.k <= 0 && !w1Var.f28216a.a(h0Var)) {
                w1Var.f28223h = 3;
                return -1;
            }
            w1Var.k = 0L;
            n6 n6Var2 = w1Var.f28216a.f28040b;
            long a4 = w1Var.a(n6Var2);
            if (a4 >= 0) {
                long j5 = w1Var.f28222g;
                if (j5 + a4 >= w1Var.f28220e) {
                    long j6 = (j5 * C.MICROS_PER_SECOND) / w1Var.f28224i;
                    w1Var.f28217b.a(n6Var2, n6Var2.f27876c);
                    w1Var.f28217b.a(j6, 1, n6Var2.f27876c, 0, null);
                    w1Var.f28220e = -1L;
                }
            }
            w1Var.f28222g += a4;
        }
        return 0;
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public void a(long j2, long j3) {
        w1 w1Var = this.f27987a;
        s1 s1Var = w1Var.f28216a;
        s1Var.f28039a.a();
        s1Var.f28040b.r();
        s1Var.f28041c = -1;
        s1Var.f28043e = false;
        if (j2 == 0) {
            w1Var.a(!w1Var.l);
        } else if (w1Var.f28223h != 0) {
            w1Var.f28220e = w1Var.f28219d.b(j3);
            w1Var.f28223h = 2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.g0
    public boolean a(h0 h0Var) {
        boolean z;
        try {
            t1 t1Var = new t1();
            if (t1Var.a(h0Var, true) && (t1Var.f28086b & 2) == 2) {
                int min = Math.min(t1Var.f28090f, 8);
                n6 n6Var = new n6(min);
                ((d0) h0Var).a(n6Var.f27874a, 0, min, false);
                n6Var.d(0);
                if (n6Var.a() >= 5 && n6Var.l() == 127 && n6Var.m() == 1179402563) {
                    this.f27987a = new q1();
                } else {
                    n6Var.d(0);
                    try {
                        z = g1.a(1, n6Var, true);
                    } catch (f unused) {
                        z = false;
                    }
                    if (z) {
                        this.f27987a = new y1();
                    } else {
                        n6Var.d(0);
                        if (v1.b(n6Var)) {
                            this.f27987a = new v1();
                        }
                    }
                }
                return true;
            }
        } catch (f unused2) {
        }
        return false;
    }
}
