package com.opos.exoplayer.core.a;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class n {

    /* renamed from: a */
    private final int f17628a;

    /* renamed from: b */
    private final int f17629b;

    /* renamed from: c */
    private final float f17630c;

    /* renamed from: d */
    private final float f17631d;

    /* renamed from: e */
    private final float f17632e;

    /* renamed from: f */
    private final int f17633f;

    /* renamed from: g */
    private final int f17634g;

    /* renamed from: h */
    private final int f17635h;

    /* renamed from: i */
    private final short[] f17636i;

    /* renamed from: j */
    private int f17637j;
    private short[] k;
    private int l;
    private short[] m;
    private int n;
    private short[] o;
    private int r;
    private int s;
    private int t;
    private int u;
    private int w;
    private int x;
    private int y;
    private int p = 0;
    private int q = 0;
    private int v = 0;

    public n(int i2, int i3, float f2, float f3, int i4) {
        this.f17628a = i2;
        this.f17629b = i3;
        this.f17633f = i2 / 400;
        int i5 = i2 / 65;
        this.f17634g = i5;
        int i6 = i5 * 2;
        this.f17635h = i6;
        this.f17636i = new short[i6];
        this.f17637j = i6;
        this.k = new short[i6 * i3];
        this.l = i6;
        this.m = new short[i6 * i3];
        this.n = i6;
        this.o = new short[i6 * i3];
        this.f17630c = f2;
        this.f17631d = f3;
        this.f17632e = i2 / i4;
    }

    private int a(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 >= 2.0f) {
            i4 = (int) (i3 / (f2 - 1.0f));
        } else {
            this.u = (int) ((i3 * (2.0f - f2)) / (f2 - 1.0f));
            i4 = i3;
        }
        a(i4);
        a(i4, this.f17629b, this.m, this.s, sArr, i2, sArr, i2 + i3);
        this.s += i4;
        return i4;
    }

    private int a(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f17629b;
        int i6 = 1;
        int i7 = 255;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
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
        this.x = i6 / i8;
        this.y = i9 / i7;
        return i8;
    }

    private int a(short[] sArr, int i2, boolean z) {
        int i3;
        int i4 = this.f17628a;
        int i5 = i4 > 4000 ? i4 / 4000 : 1;
        if (this.f17629b == 1 && i5 == 1) {
            i3 = a(sArr, i2, this.f17633f, this.f17634g);
        } else {
            b(sArr, i2, i5);
            int a2 = a(this.f17636i, 0, this.f17633f / i5, this.f17634g / i5);
            if (i5 != 1) {
                int i6 = a2 * i5;
                int i7 = i5 * 4;
                int i8 = i6 - i7;
                int i9 = i6 + i7;
                int i10 = this.f17633f;
                if (i8 < i10) {
                    i8 = i10;
                }
                int i11 = this.f17634g;
                if (i9 > i11) {
                    i9 = i11;
                }
                if (this.f17629b == 1) {
                    i3 = a(sArr, i2, i8, i9);
                } else {
                    b(sArr, i2, 1);
                    i3 = a(this.f17636i, 0, i8, i9);
                }
            } else {
                i3 = a2;
            }
        }
        int i12 = a(this.x, this.y, z) ? this.v : i3;
        this.w = this.x;
        this.v = i3;
        return i12;
    }

    private void a(float f2) {
        int a2;
        int i2 = this.r;
        if (i2 < this.f17635h) {
            return;
        }
        int i3 = 0;
        do {
            if (this.u > 0) {
                a2 = d(i3);
            } else {
                int a3 = a(this.k, i3, true);
                double d2 = f2;
                short[] sArr = this.k;
                a2 = d2 > 1.0d ? a3 + a(sArr, i3, f2, a3) : b(sArr, i3, f2, a3);
            }
            i3 += a2;
        } while (this.f17635h + i3 <= i2);
        c(i3);
    }

    private void a(float f2, int i2) {
        int i3;
        int i4;
        if (this.s == i2) {
            return;
        }
        int i5 = this.f17628a;
        int i6 = (int) (i5 / f2);
        while (true) {
            if (i6 <= 16384 && i5 <= 16384) {
                break;
            }
            i6 /= 2;
            i5 /= 2;
        }
        e(i2);
        int i7 = 0;
        while (true) {
            int i8 = this.t;
            if (i7 >= i8 - 1) {
                f(i8 - 1);
                return;
            }
            while (true) {
                i3 = this.p;
                int i9 = (i3 + 1) * i6;
                i4 = this.q;
                if (i9 <= i4 * i5) {
                    break;
                }
                a(1);
                int i10 = 0;
                while (true) {
                    int i11 = this.f17629b;
                    if (i10 < i11) {
                        this.m[(this.s * i11) + i10] = b(this.o, (i11 * i7) + i10, i5, i6);
                        i10++;
                    }
                }
                this.q++;
                this.s++;
            }
            int i12 = i3 + 1;
            this.p = i12;
            if (i12 == i5) {
                this.p = 0;
                com.opos.exoplayer.core.i.a.b(i4 == i6);
                this.q = 0;
            }
            i7++;
        }
    }

    private void a(int i2) {
        int i3 = this.s + i2;
        int i4 = this.l;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.l = i5;
            this.m = Arrays.copyOf(this.m, i5 * this.f17629b);
        }
    }

    private static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
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

    private void a(short[] sArr, int i2, int i3) {
        a(i3);
        int i4 = this.f17629b;
        System.arraycopy(sArr, i2 * i4, this.m, this.s * i4, i4 * i3);
        this.s += i3;
    }

    private boolean a(int i2, int i3, boolean z) {
        return (i2 == 0 || this.v == 0 || (!z ? i2 > this.w : i3 <= i2 * 3 && i2 * 2 > this.w * 3)) ? false : true;
    }

    private int b(short[] sArr, int i2, float f2, int i3) {
        int i4;
        if (f2 < 0.5f) {
            i4 = (int) ((i3 * f2) / (1.0f - f2));
        } else {
            this.u = (int) ((i3 * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
            i4 = i3;
        }
        int i5 = i3 + i4;
        a(i5);
        int i6 = this.f17629b;
        System.arraycopy(sArr, i6 * i2, this.m, this.s * i6, i6 * i3);
        a(i4, this.f17629b, this.m, this.s + i3, sArr, i2 + i3, sArr, i2);
        this.s += i5;
        return i4;
    }

    private short b(short[] sArr, int i2, int i3, int i4) {
        short s = sArr[i2];
        short s2 = sArr[this.f17629b + i2];
        int i5 = this.q;
        int i6 = this.p;
        int i7 = (i6 + 1) * i4;
        int i8 = i7 - (i5 * i3);
        int i9 = i7 - (i6 * i4);
        return (short) (((s * i8) + (s2 * (i9 - i8))) / i9);
    }

    private void b(int i2) {
        int i3 = this.r + i2;
        int i4 = this.f17637j;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.f17637j = i5;
            this.k = Arrays.copyOf(this.k, i5 * this.f17629b);
        }
    }

    private void b(short[] sArr, int i2, int i3) {
        int i4 = this.f17635h / i3;
        int i5 = this.f17629b;
        int i6 = i3 * i5;
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i6; i9++) {
                i8 += sArr[(i7 * i6) + (i2 * i5) + i9];
            }
            this.f17636i[i7] = (short) (i8 / i6);
        }
    }

    private void c() {
        int i2 = this.s;
        float f2 = this.f17630c;
        float f3 = this.f17631d;
        float f4 = f2 / f3;
        float f5 = this.f17632e * f3;
        double d2 = f4;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            a(f4);
        } else {
            a(this.k, 0, this.r);
            this.r = 0;
        }
        if (f5 != 1.0f) {
            a(f5, i2);
        }
    }

    private void c(int i2) {
        int i3 = this.r - i2;
        short[] sArr = this.k;
        int i4 = this.f17629b;
        System.arraycopy(sArr, i2 * i4, sArr, 0, i4 * i3);
        this.r = i3;
    }

    private int d(int i2) {
        int min = Math.min(this.f17635h, this.u);
        a(this.k, i2, min);
        this.u -= min;
        return min;
    }

    private void e(int i2) {
        int i3 = this.s - i2;
        int i4 = this.t + i3;
        int i5 = this.n;
        if (i4 > i5) {
            int i6 = i5 + (i5 / 2) + i3;
            this.n = i6;
            this.o = Arrays.copyOf(this.o, i6 * this.f17629b);
        }
        short[] sArr = this.m;
        int i7 = this.f17629b;
        System.arraycopy(sArr, i7 * i2, this.o, this.t * i7, i7 * i3);
        this.s = i2;
        this.t = i3 + this.t;
    }

    private void f(int i2) {
        if (i2 == 0) {
            return;
        }
        short[] sArr = this.o;
        int i3 = this.f17629b;
        System.arraycopy(sArr, i3 * i2, sArr, 0, (this.t - i2) * i3);
        this.t -= i2;
    }

    public void a() {
        int i2;
        int i3 = this.r;
        float f2 = this.f17630c;
        float f3 = this.f17631d;
        int i4 = this.s + ((int) ((((i3 / (f2 / f3)) + this.t) / (this.f17632e * f3)) + 0.5f));
        b((this.f17635h * 2) + i3);
        int i5 = 0;
        while (true) {
            i2 = this.f17635h;
            int i6 = this.f17629b;
            if (i5 >= i2 * 2 * i6) {
                break;
            }
            this.k[(i6 * i3) + i5] = (short) 0;
            i5++;
        }
        this.r += i2 * 2;
        c();
        if (this.s > i4) {
            this.s = i4;
        }
        this.r = 0;
        this.u = 0;
        this.t = 0;
    }

    public void a(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i2 = this.f17629b;
        int i3 = remaining / i2;
        b(i3);
        shortBuffer.get(this.k, this.r * this.f17629b, ((i2 * i3) * 2) / 2);
        this.r = i3 + this.r;
        c();
    }

    public int b() {
        return this.s;
    }

    public void b(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.f17629b, this.s);
        shortBuffer.put(this.m, 0, this.f17629b * min);
        int i2 = this.s - min;
        this.s = i2;
        short[] sArr = this.m;
        int i3 = this.f17629b;
        System.arraycopy(sArr, min * i3, sArr, 0, i2 * i3);
    }
}
