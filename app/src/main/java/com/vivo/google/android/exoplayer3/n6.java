package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.util.Util;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
public final class n6 {

    /* renamed from: a */
    public byte[] f27874a;

    /* renamed from: b */
    public int f27875b;

    /* renamed from: c */
    public int f27876c;

    public n6() {
    }

    public n6(int i2) {
        this.f27874a = new byte[i2];
        this.f27876c = i2;
    }

    public n6(byte[] bArr) {
        this.f27874a = bArr;
        this.f27876c = bArr.length;
    }

    public n6(byte[] bArr, int i2) {
        this.f27874a = bArr;
        this.f27876c = i2;
    }

    public int a() {
        return this.f27876c - this.f27875b;
    }

    public String a(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = (this.f27875b + i2) - 1;
        String str = new String(this.f27874a, this.f27875b, (i3 >= this.f27876c || this.f27874a[i3] != 0) ? i2 : i2 - 1);
        this.f27875b += i2;
        return str;
    }

    public String a(int i2, Charset charset) {
        String str = new String(this.f27874a, this.f27875b, i2, charset);
        this.f27875b += i2;
        return str;
    }

    public void a(m6 m6Var, int i2) {
        a(m6Var.f27770a, 0, i2);
        m6Var.b(0);
    }

    public void a(byte[] bArr, int i2) {
        this.f27874a = bArr;
        this.f27876c = i2;
        this.f27875b = 0;
    }

    public void a(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.f27874a, this.f27875b, bArr, i2, i3);
        this.f27875b += i3;
    }

    public int b() {
        byte[] bArr = this.f27874a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public void b(int i2) {
        a(b() < i2 ? new byte[i2] : this.f27874a, i2);
    }

    public int c() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b;
        int i3 = i2 + 1;
        this.f27875b = i3;
        int i4 = (bArr[i2] & 255) << 24;
        int i5 = i3 + 1;
        this.f27875b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 16);
        int i7 = i5 + 1;
        this.f27875b = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 8);
        this.f27875b = i7 + 1;
        return (bArr[i7] & 255) | i8;
    }

    public void c(int i2) {
        g1.a(i2 >= 0 && i2 <= this.f27874a.length);
        this.f27876c = i2;
    }

    public String d() {
        if (a() == 0) {
            return null;
        }
        int i2 = this.f27875b;
        while (i2 < this.f27876c && !Util.isLinebreak(this.f27874a[i2])) {
            i2++;
        }
        int i3 = this.f27875b;
        if (i2 - i3 >= 3) {
            byte[] bArr = this.f27874a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f27875b = i3 + 3;
            }
        }
        byte[] bArr2 = this.f27874a;
        int i4 = this.f27875b;
        String str = new String(bArr2, i4, i2 - i4);
        this.f27875b = i2;
        int i5 = this.f27876c;
        if (i2 == i5) {
            return str;
        }
        byte[] bArr3 = this.f27874a;
        if (bArr3[i2] == 13) {
            int i6 = i2 + 1;
            this.f27875b = i6;
            if (i6 == i5) {
                return str;
            }
        }
        int i7 = this.f27875b;
        if (bArr3[i7] == 10) {
            this.f27875b = i7 + 1;
        }
        return str;
    }

    public void d(int i2) {
        g1.a(i2 >= 0 && i2 <= this.f27876c);
        this.f27875b = i2;
    }

    public int e() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b;
        int i3 = i2 + 1;
        this.f27875b = i3;
        int i4 = bArr[i2] & 255;
        int i5 = i3 + 1;
        this.f27875b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        int i7 = i5 + 1;
        this.f27875b = i7;
        int i8 = i6 | ((bArr[i5] & 255) << 16);
        this.f27875b = i7 + 1;
        return ((bArr[i7] & 255) << 24) | i8;
    }

    public void e(int i2) {
        d(this.f27875b + i2);
    }

    public long f() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b + 1;
        this.f27875b = i2;
        long j2 = bArr[r1] & 255;
        int i3 = i2 + 1;
        this.f27875b = i3;
        long j3 = j2 | ((bArr[i2] & 255) << 8);
        int i4 = i3 + 1;
        this.f27875b = i4;
        long j4 = j3 | ((bArr[i3] & 255) << 16);
        this.f27875b = i4 + 1;
        return ((bArr[i4] & 255) << 24) | j4;
    }

    public int g() {
        int e2 = e();
        if (e2 >= 0) {
            return e2;
        }
        throw new IllegalStateException("Top bit not zero: " + e2);
    }

    public int h() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b;
        int i3 = i2 + 1;
        this.f27875b = i3;
        int i4 = bArr[i2] & 255;
        this.f27875b = i3 + 1;
        return ((bArr[i3] & 255) << 8) | i4;
    }

    public long i() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b + 1;
        this.f27875b = i2;
        long j2 = (bArr[r1] & 255) << 56;
        int i3 = i2 + 1;
        this.f27875b = i3;
        long j3 = j2 | ((bArr[i2] & 255) << 48);
        int i4 = i3 + 1;
        this.f27875b = i4;
        long j4 = j3 | ((bArr[i3] & 255) << 40);
        int i5 = i4 + 1;
        this.f27875b = i5;
        long j5 = j4 | ((bArr[i4] & 255) << 32);
        int i6 = i5 + 1;
        this.f27875b = i6;
        long j6 = j5 | ((bArr[i5] & 255) << 24);
        int i7 = i6 + 1;
        this.f27875b = i7;
        long j7 = j6 | ((bArr[i6] & 255) << 16);
        int i8 = i7 + 1;
        this.f27875b = i8;
        long j8 = j7 | ((bArr[i7] & 255) << 8);
        this.f27875b = i8 + 1;
        return (bArr[i8] & 255) | j8;
    }

    public String j() {
        if (a() == 0) {
            return null;
        }
        int i2 = this.f27875b;
        while (i2 < this.f27876c && this.f27874a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f27874a;
        int i3 = this.f27875b;
        String str = new String(bArr, i3, i2 - i3);
        this.f27875b = i2;
        if (i2 < this.f27876c) {
            this.f27875b = i2 + 1;
        }
        return str;
    }

    public int k() {
        return (l() << 21) | (l() << 14) | (l() << 7) | l();
    }

    public int l() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b;
        this.f27875b = i2 + 1;
        return bArr[i2] & 255;
    }

    public long m() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b + 1;
        this.f27875b = i2;
        long j2 = (bArr[r1] & 255) << 24;
        int i3 = i2 + 1;
        this.f27875b = i3;
        long j3 = j2 | ((bArr[i2] & 255) << 16);
        int i4 = i3 + 1;
        this.f27875b = i4;
        long j4 = j3 | ((bArr[i3] & 255) << 8);
        this.f27875b = i4 + 1;
        return (bArr[i4] & 255) | j4;
    }

    public int n() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b;
        int i3 = i2 + 1;
        this.f27875b = i3;
        int i4 = (bArr[i2] & 255) << 16;
        int i5 = i3 + 1;
        this.f27875b = i5;
        int i6 = i4 | ((bArr[i3] & 255) << 8);
        this.f27875b = i5 + 1;
        return (bArr[i5] & 255) | i6;
    }

    public int o() {
        int c2 = c();
        if (c2 >= 0) {
            return c2;
        }
        throw new IllegalStateException("Top bit not zero: " + c2);
    }

    public long p() {
        long i2 = i();
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalStateException("Top bit not zero: " + i2);
    }

    public int q() {
        byte[] bArr = this.f27874a;
        int i2 = this.f27875b;
        int i3 = i2 + 1;
        this.f27875b = i3;
        int i4 = (bArr[i2] & 255) << 8;
        this.f27875b = i3 + 1;
        return (bArr[i3] & 255) | i4;
    }

    public void r() {
        this.f27875b = 0;
        this.f27876c = 0;
    }
}
