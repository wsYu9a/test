package com.vivo.google.android.exoplayer3;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class p1 implements u1 {

    /* renamed from: a */
    public final t1 f27917a = new t1();

    /* renamed from: b */
    public final long f27918b;

    /* renamed from: c */
    public final long f27919c;

    /* renamed from: d */
    public final w1 f27920d;

    /* renamed from: e */
    public int f27921e;

    /* renamed from: f */
    public long f27922f;

    /* renamed from: g */
    public long f27923g;

    /* renamed from: h */
    public long f27924h;

    /* renamed from: i */
    public long f27925i;

    /* renamed from: j */
    public long f27926j;
    public long k;
    public long l;

    public class a implements m0 {
        public a() {
        }

        @Override // com.vivo.google.android.exoplayer3.m0
        public long a(long j2) {
            if (j2 == 0) {
                return p1.this.f27918b;
            }
            p1 p1Var = p1.this;
            long j3 = (p1Var.f27920d.f28224i * j2) / C.MICROS_PER_SECOND;
            long j4 = p1Var.f27918b;
            long j5 = p1Var.f27919c;
            long j6 = (((j3 * (j5 - j4)) / p1Var.f27922f) - 30000) + j4;
            if (j6 >= j4) {
                j4 = j6;
            }
            return j4 >= j5 ? j5 - 1 : j4;
        }

        @Override // com.vivo.google.android.exoplayer3.m0
        public boolean a() {
            return true;
        }

        @Override // com.vivo.google.android.exoplayer3.m0
        public long c() {
            return (p1.this.f27922f * C.MICROS_PER_SECOND) / r0.f27920d.f28224i;
        }
    }

    public p1(long j2, long j3, w1 w1Var, int i2, long j4) {
        g1.a(j2 >= 0 && j3 > j2);
        this.f27920d = w1Var;
        this.f27918b = j2;
        this.f27919c = j3;
        if (i2 != j3 - j2) {
            this.f27921e = 0;
        } else {
            this.f27922f = j4;
            this.f27921e = 3;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.u1
    public long a(h0 h0Var) {
        t1 t1Var;
        long j2;
        long min;
        int i2 = this.f27921e;
        if (i2 == 0) {
            long j3 = ((d0) h0Var).f27268c;
            this.f27923g = j3;
            this.f27921e = 1;
            long j4 = this.f27919c - 65307;
            if (j4 > j3) {
                return j4;
            }
        } else if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j5 = this.f27924h;
            long j6 = 0;
            if (j5 != 0) {
                long j7 = this.f27925i;
                long j8 = this.f27926j;
                if (j7 == j8) {
                    min = -(this.k + 2);
                } else {
                    d0 d0Var = (d0) h0Var;
                    long j9 = d0Var.f27268c;
                    if (a(h0Var, j8)) {
                        this.f27917a.a(h0Var, false);
                        d0Var.f27270e = 0;
                        t1 t1Var2 = this.f27917a;
                        long j10 = t1Var2.f28087c;
                        long j11 = j5 - j10;
                        int i3 = t1Var2.f28089e + t1Var2.f28090f;
                        if (j11 < 0 || j11 > 72000) {
                            if (j11 < 0) {
                                this.f27926j = j9;
                                this.l = j10;
                            } else {
                                long j12 = i3;
                                long j13 = d0Var.f27268c + j12;
                                this.f27925i = j13;
                                this.k = j10;
                                if ((this.f27926j - j13) + j12 < 100000) {
                                    d0Var.c(i3);
                                    j2 = this.k;
                                }
                            }
                            long j14 = this.f27926j;
                            long j15 = this.f27925i;
                            if (j14 - j15 < 100000) {
                                this.f27926j = j15;
                                min = j15;
                            } else {
                                min = Math.min(Math.max((d0Var.f27268c - (i3 * (j11 <= 0 ? 2 : 1))) + ((j11 * (j14 - j15)) / (this.l - this.k)), j15), this.f27926j - 1);
                            }
                        } else {
                            d0Var.c(i3);
                            j2 = this.f27917a.f28087c;
                        }
                        min = -(j2 + 2);
                    } else {
                        min = this.f27925i;
                        if (min == j9) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                if (min >= 0) {
                    return min;
                }
                long j16 = this.f27924h;
                this.f27917a.a(h0Var, false);
                j6 = -(min + 2);
                while (true) {
                    t1 t1Var3 = this.f27917a;
                    if (t1Var3.f28087c >= j16) {
                        break;
                    }
                    ((d0) h0Var).c(t1Var3.f28089e + t1Var3.f28090f);
                    t1 t1Var4 = this.f27917a;
                    j6 = t1Var4.f28087c;
                    t1Var4.a(h0Var, false);
                }
                ((d0) h0Var).f27270e = 0;
            }
            this.f27921e = 3;
            return -(j6 + 2);
        }
        if (!a(h0Var, this.f27919c)) {
            throw new EOFException();
        }
        this.f27917a.a();
        while (true) {
            t1Var = this.f27917a;
            if ((t1Var.f28086b & 4) == 4) {
                break;
            }
            d0 d0Var2 = (d0) h0Var;
            if (d0Var2.f27268c >= this.f27919c) {
                break;
            }
            t1Var.a(h0Var, false);
            t1 t1Var5 = this.f27917a;
            d0Var2.c(t1Var5.f28089e + t1Var5.f28090f);
        }
        this.f27922f = t1Var.f28087c;
        this.f27921e = 3;
        return this.f27923g;
    }

    @Override // com.vivo.google.android.exoplayer3.u1
    public m0 b() {
        if (this.f27922f != 0) {
            return new a();
        }
        return null;
    }

    @Override // com.vivo.google.android.exoplayer3.u1
    public long b(long j2) {
        int i2 = this.f27921e;
        g1.a(i2 == 3 || i2 == 2);
        long j3 = j2 == 0 ? 0L : (this.f27920d.f28224i * j2) / C.MICROS_PER_SECOND;
        this.f27924h = j3;
        this.f27921e = 2;
        this.f27925i = this.f27918b;
        this.f27926j = this.f27919c;
        this.k = 0L;
        this.l = this.f27922f;
        return j3;
    }

    public boolean a(h0 h0Var, long j2) {
        int i2;
        long min = Math.min(j2 + 3, this.f27919c);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            d0 d0Var = (d0) h0Var;
            long j3 = d0Var.f27268c;
            int i4 = 0;
            if (i3 + j3 > min && (i3 = (int) (min - j3)) < 4) {
                return false;
            }
            d0Var.a(bArr, 0, i3, false);
            while (true) {
                i2 = i3 - 3;
                if (i4 < i2) {
                    if (bArr[i4] == 79 && bArr[i4 + 1] == 103 && bArr[i4 + 2] == 103 && bArr[i4 + 3] == 83) {
                        d0Var.c(i4);
                        return true;
                    }
                    i4++;
                }
            }
            d0Var.c(i2);
        }
    }
}
