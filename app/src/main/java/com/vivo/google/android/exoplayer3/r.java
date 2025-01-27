package com.vivo.google.android.exoplayer3;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class r {

    /* renamed from: a */
    public final int f27976a;

    /* renamed from: b */
    public final int f27977b;

    /* renamed from: c */
    public final int f27978c;

    /* renamed from: d */
    public final int f27979d;

    /* renamed from: e */
    public final int f27980e;

    /* renamed from: f */
    public final short[] f27981f;

    /* renamed from: g */
    public int f27982g;

    /* renamed from: h */
    public short[] f27983h;

    /* renamed from: i */
    public int f27984i;

    /* renamed from: j */
    public short[] f27985j;
    public int k;
    public short[] l;
    public int q;
    public int r;
    public int s;
    public int t;
    public int v;
    public int w;
    public int x;
    public int m = 0;
    public int n = 0;
    public int u = 0;
    public float o = 1.0f;
    public float p = 1.0f;

    public r(int i2, int i3) {
        this.f27976a = i2;
        this.f27977b = i3;
        this.f27978c = i2 / 400;
        int i4 = i2 / 65;
        this.f27979d = i4;
        int i5 = i4 * 2;
        this.f27980e = i5;
        this.f27981f = new short[i5];
        this.f27982g = i5;
        int i6 = i3 * i5;
        this.f27983h = new short[i6];
        this.f27984i = i5;
        this.f27985j = new short[i6];
        this.k = i5;
        this.l = new short[i6];
    }

    public static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }

    public final int a(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f27977b;
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                short s = sArr[i5 + i11];
                short s2 = sArr[i5 + i3 + i11];
                i10 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i10 * i8 < i6 * i3) {
                i8 = i3;
                i6 = i10;
            }
            if (i10 * i7 > i9 * i3) {
                i7 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.w = i6 / i8;
        this.x = i9 / i7;
        return i8;
    }

    public final void a() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.r;
        float f2 = this.o / this.p;
        double d2 = f2;
        int i10 = 1;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            int i11 = this.q;
            if (i11 >= this.f27980e) {
                int i12 = 0;
                while (true) {
                    int i13 = this.t;
                    if (i13 > 0) {
                        int min = Math.min(this.f27980e, i13);
                        a(this.f27983h, i12, min);
                        this.t -= min;
                        i12 += min;
                    } else {
                        short[] sArr = this.f27983h;
                        int i14 = this.f27976a;
                        int i15 = i14 > 4000 ? i14 / 4000 : 1;
                        if (this.f27977b == i10 && i15 == i10) {
                            i2 = a(sArr, i12, this.f27978c, this.f27979d);
                        } else {
                            b(sArr, i12, i15);
                            int a2 = a(this.f27981f, 0, this.f27978c / i15, this.f27979d / i15);
                            if (i15 != i10) {
                                int i16 = a2 * i15;
                                int i17 = i15 * 4;
                                int i18 = i16 - i17;
                                int i19 = i16 + i17;
                                int i20 = this.f27978c;
                                if (i18 < i20) {
                                    i18 = i20;
                                }
                                int i21 = this.f27979d;
                                if (i19 > i21) {
                                    i19 = i21;
                                }
                                if (this.f27977b == i10) {
                                    i2 = a(sArr, i12, i18, i19);
                                } else {
                                    b(sArr, i12, i10);
                                    i2 = a(this.f27981f, 0, i18, i19);
                                }
                            } else {
                                i2 = a2;
                            }
                        }
                        int i22 = this.w;
                        int i23 = i22 != 0 && this.u != 0 && this.x <= i22 * 3 && i22 * 2 > this.v * 3 ? this.u : i2;
                        this.v = i22;
                        this.u = i2;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.f27983h;
                            if (f2 >= 2.0f) {
                                i4 = (int) (i23 / (f2 - 1.0f));
                            } else {
                                this.t = (int) ((i23 * (2.0f - f2)) / (f2 - 1.0f));
                                i4 = i23;
                            }
                            b(i4);
                            int i24 = i4;
                            a(i4, this.f27977b, this.f27985j, this.r, sArr2, i12, sArr2, i12 + i23);
                            this.r += i24;
                            i12 += i23 + i24;
                        } else {
                            int i25 = i23;
                            short[] sArr3 = this.f27983h;
                            if (f2 < 0.5f) {
                                i3 = (int) ((i25 * f2) / (1.0f - f2));
                            } else {
                                this.t = (int) ((i25 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                                i3 = i25;
                            }
                            int i26 = i25 + i3;
                            b(i26);
                            int i27 = this.f27977b;
                            System.arraycopy(sArr3, i12 * i27, this.f27985j, this.r * i27, i27 * i25);
                            a(i3, this.f27977b, this.f27985j, this.r + i25, sArr3, i25 + i12, sArr3, i12);
                            this.r += i26;
                            i12 += i3;
                        }
                    }
                    if (this.f27980e + i12 > i11) {
                        break;
                    } else {
                        i10 = 1;
                    }
                }
                int i28 = this.q - i12;
                short[] sArr4 = this.f27983h;
                int i29 = this.f27977b;
                System.arraycopy(sArr4, i12 * i29, sArr4, 0, i29 * i28);
                this.q = i28;
            }
        } else {
            a(this.f27983h, 0, this.q);
            this.q = 0;
        }
        float f3 = this.p;
        if (f3 == 1.0f || this.r == i9) {
            return;
        }
        int i30 = this.f27976a;
        int i31 = (int) (i30 / f3);
        while (true) {
            if (i31 <= 16384 && i30 <= 16384) {
                break;
            }
            i31 /= 2;
            i30 /= 2;
        }
        int i32 = this.r - i9;
        int i33 = this.s + i32;
        int i34 = this.k;
        if (i33 > i34) {
            int i35 = i34 + (i34 / 2) + i32;
            this.k = i35;
            this.l = Arrays.copyOf(this.l, i35 * this.f27977b);
        }
        short[] sArr5 = this.f27985j;
        int i36 = this.f27977b;
        System.arraycopy(sArr5, i9 * i36, this.l, this.s * i36, i36 * i32);
        this.r = i9;
        this.s += i32;
        int i37 = 0;
        while (true) {
            i5 = this.s;
            i6 = i5 - 1;
            if (i37 >= i6) {
                break;
            }
            while (true) {
                i7 = this.m + 1;
                int i38 = i7 * i31;
                i8 = this.n;
                if (i38 <= i8 * i30) {
                    break;
                }
                b(1);
                int i39 = 0;
                while (true) {
                    int i40 = this.f27977b;
                    if (i39 < i40) {
                        short[] sArr6 = this.f27985j;
                        int i41 = (this.r * i40) + i39;
                        short[] sArr7 = this.l;
                        int i42 = (i37 * i40) + i39;
                        short s = sArr7[i42];
                        short s2 = sArr7[i42 + i40];
                        int i43 = this.n * i30;
                        int i44 = this.m;
                        int i45 = i44 * i31;
                        int i46 = (i44 + 1) * i31;
                        int i47 = i46 - i43;
                        int i48 = i46 - i45;
                        sArr6[i41] = (short) (((s * i47) + ((i48 - i47) * s2)) / i48);
                        i39++;
                    }
                }
                this.n++;
                this.r++;
            }
            this.m = i7;
            if (i7 == i30) {
                this.m = 0;
                g1.b(i8 == i31);
                this.n = 0;
            }
            i37++;
        }
        if (i6 == 0) {
            return;
        }
        short[] sArr8 = this.l;
        int i49 = this.f27977b;
        System.arraycopy(sArr8, i6 * i49, sArr8, 0, (i5 - i6) * i49);
        this.s -= i6;
    }

    public final void a(int i2) {
        int i3 = this.q + i2;
        int i4 = this.f27982g;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.f27982g = i5;
            this.f27983h = Arrays.copyOf(this.f27983h, i5 * this.f27977b);
        }
    }

    public final void a(short[] sArr, int i2, int i3) {
        b(i3);
        int i4 = this.f27977b;
        System.arraycopy(sArr, i2 * i4, this.f27985j, this.r * i4, i4 * i3);
        this.r += i3;
    }

    public final void b(int i2) {
        int i3 = this.r + i2;
        int i4 = this.f27984i;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.f27984i = i5;
            this.f27985j = Arrays.copyOf(this.f27985j, i5 * this.f27977b);
        }
    }

    public final void b(short[] sArr, int i2, int i3) {
        int i4 = this.f27980e / i3;
        int i5 = this.f27977b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f27981f[i8] = (short) (i9 / i6);
        }
    }
}
