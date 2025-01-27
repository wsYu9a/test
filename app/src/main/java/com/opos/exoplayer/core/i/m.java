package com.opos.exoplayer.core.i;

import java.nio.charset.Charset;
import okio.Utf8;

/* loaded from: classes4.dex */
public final class m {

    /* renamed from: a */
    public byte[] f19048a;

    /* renamed from: b */
    private int f19049b;

    /* renamed from: c */
    private int f19050c;

    public m() {
    }

    public m(int i2) {
        this.f19048a = new byte[i2];
        this.f19050c = i2;
    }

    public m(byte[] bArr) {
        this.f19048a = bArr;
        this.f19050c = bArr.length;
    }

    public m(byte[] bArr, int i2) {
        this.f19048a = bArr;
        this.f19050c = i2;
    }

    public long A() {
        int i2;
        int i3;
        long j2 = this.f19048a[this.f19049b];
        int i4 = 7;
        while (true) {
            if (i4 < 0) {
                break;
            }
            if (((1 << i4) & j2) != 0) {
                i4--;
            } else if (i4 < 6) {
                j2 &= r6 - 1;
                i3 = 7 - i4;
            } else if (i4 == 7) {
                i3 = 1;
            }
        }
        i3 = 0;
        if (i3 == 0) {
            throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j2);
        }
        for (i2 = 1; i2 < i3; i2++) {
            if ((this.f19048a[this.f19049b + i2] & 192) != 128) {
                throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j2);
            }
            j2 = (j2 << 6) | (r3 & Utf8.REPLACEMENT_BYTE);
        }
        this.f19049b += i3;
        return j2;
    }

    public String a(int i2, Charset charset) {
        String str = new String(this.f19048a, this.f19049b, i2, charset);
        this.f19049b += i2;
        return str;
    }

    public void a() {
        this.f19049b = 0;
        this.f19050c = 0;
    }

    public void a(int i2) {
        a(e() < i2 ? new byte[i2] : this.f19048a, i2);
    }

    public void a(l lVar, int i2) {
        a(lVar.f19044a, 0, i2);
        lVar.a(0);
    }

    public void a(byte[] bArr, int i2) {
        this.f19048a = bArr;
        this.f19050c = i2;
        this.f19049b = 0;
    }

    public void a(byte[] bArr, int i2, int i3) {
        System.arraycopy(this.f19048a, this.f19049b, bArr, i2, i3);
        this.f19049b += i3;
    }

    public int b() {
        return this.f19050c - this.f19049b;
    }

    public void b(int i2) {
        a.a(i2 >= 0 && i2 <= this.f19048a.length);
        this.f19050c = i2;
    }

    public int c() {
        return this.f19050c;
    }

    public void c(int i2) {
        a.a(i2 >= 0 && i2 <= this.f19050c);
        this.f19049b = i2;
    }

    public int d() {
        return this.f19049b;
    }

    public void d(int i2) {
        c(this.f19049b + i2);
    }

    public int e() {
        byte[] bArr = this.f19048a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public String e(int i2) {
        return a(i2, Charset.forName("UTF-8"));
    }

    public char f() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        return (char) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    public String f(int i2) {
        if (i2 == 0) {
            return "";
        }
        int i3 = (this.f19049b + i2) - 1;
        String str = new String(this.f19048a, this.f19049b, (i3 >= this.f19050c || this.f19048a[i3] != 0) ? i2 : i2 - 1);
        this.f19049b += i2;
        return str;
    }

    public int g() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        this.f19049b = i2 + 1;
        return bArr[i2] & 255;
    }

    public int h() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        this.f19049b = i3 + 1;
        return (bArr[i3] & 255) | ((b2 & 255) << 8);
    }

    public int i() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        this.f19049b = i3 + 1;
        return ((bArr[i3] & 255) << 8) | (b2 & 255);
    }

    public short j() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        this.f19049b = i3 + 1;
        return (short) ((bArr[i3] & 255) | ((b2 & 255) << 8));
    }

    public int k() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        byte b3 = bArr[i3];
        this.f19049b = i4 + 1;
        return (bArr[i4] & 255) | ((b2 & 255) << 16) | ((b3 & 255) << 8);
    }

    public int l() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        byte b3 = bArr[i3];
        this.f19049b = i4 + 1;
        return (bArr[i4] & 255) | (((b2 & 255) << 24) >> 8) | ((b3 & 255) << 8);
    }

    public long m() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        this.f19049b = i5;
        long j4 = bArr[i4];
        this.f19049b = i5 + 1;
        return (bArr[i5] & 255) | ((j2 & 255) << 24) | ((j3 & 255) << 16) | ((j4 & 255) << 8);
    }

    public long n() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        this.f19049b = i5;
        long j4 = bArr[i4];
        this.f19049b = i5 + 1;
        return ((bArr[i5] & 255) << 24) | (j2 & 255) | ((j3 & 255) << 8) | ((j4 & 255) << 16);
    }

    public int o() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.f19049b = i5;
        byte b4 = bArr[i4];
        this.f19049b = i5 + 1;
        return (bArr[i5] & 255) | ((b2 & 255) << 24) | ((b3 & 255) << 16) | ((b4 & 255) << 8);
    }

    public int p() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        byte b3 = bArr[i3];
        int i5 = i4 + 1;
        this.f19049b = i5;
        byte b4 = bArr[i4];
        this.f19049b = i5 + 1;
        return ((bArr[i5] & 255) << 24) | (b2 & 255) | ((b3 & 255) << 8) | ((b4 & 255) << 16);
    }

    public long q() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        this.f19049b = i5;
        long j4 = bArr[i4];
        int i6 = i5 + 1;
        this.f19049b = i6;
        long j5 = bArr[i5];
        int i7 = i6 + 1;
        this.f19049b = i7;
        long j6 = bArr[i6];
        int i8 = i7 + 1;
        this.f19049b = i8;
        long j7 = bArr[i7];
        int i9 = i8 + 1;
        this.f19049b = i9;
        long j8 = bArr[i8];
        this.f19049b = i9 + 1;
        return (255 & bArr[i9]) | ((j2 & 255) << 56) | ((j3 & 255) << 48) | ((j4 & 255) << 40) | ((j5 & 255) << 32) | ((j6 & 255) << 24) | ((j7 & 255) << 16) | ((j8 & 255) << 8);
    }

    public long r() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        long j2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        long j3 = bArr[i3];
        int i5 = i4 + 1;
        this.f19049b = i5;
        long j4 = bArr[i4];
        int i6 = i5 + 1;
        this.f19049b = i6;
        long j5 = bArr[i5];
        int i7 = i6 + 1;
        this.f19049b = i7;
        long j6 = bArr[i6];
        int i8 = i7 + 1;
        this.f19049b = i8;
        long j7 = bArr[i7];
        int i9 = i8 + 1;
        this.f19049b = i9;
        long j8 = bArr[i8];
        this.f19049b = i9 + 1;
        return ((255 & bArr[i9]) << 56) | (j2 & 255) | ((j3 & 255) << 8) | ((j4 & 255) << 16) | ((j5 & 255) << 24) | ((j6 & 255) << 32) | ((j7 & 255) << 40) | ((j8 & 255) << 48);
    }

    public int s() {
        byte[] bArr = this.f19048a;
        int i2 = this.f19049b;
        int i3 = i2 + 1;
        this.f19049b = i3;
        byte b2 = bArr[i2];
        int i4 = i3 + 1;
        this.f19049b = i4;
        byte b3 = bArr[i3];
        this.f19049b = i4 + 2;
        return (b3 & 255) | ((b2 & 255) << 8);
    }

    public int t() {
        return (g() << 21) | (g() << 14) | (g() << 7) | g();
    }

    public int u() {
        int o = o();
        if (o >= 0) {
            return o;
        }
        throw new IllegalStateException("Top bit not zero: " + o);
    }

    public int v() {
        int p = p();
        if (p >= 0) {
            return p;
        }
        throw new IllegalStateException("Top bit not zero: " + p);
    }

    public long w() {
        long q = q();
        if (q >= 0) {
            return q;
        }
        throw new IllegalStateException("Top bit not zero: " + q);
    }

    public double x() {
        return Double.longBitsToDouble(q());
    }

    public String y() {
        if (b() == 0) {
            return null;
        }
        int i2 = this.f19049b;
        while (i2 < this.f19050c && this.f19048a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f19048a;
        int i3 = this.f19049b;
        String str = new String(bArr, i3, i2 - i3);
        this.f19049b = i2;
        if (i2 < this.f19050c) {
            this.f19049b = i2 + 1;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r0 == r2) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String z() {
        /*
            r6 = this;
            int r0 = r6.b()
            if (r0 != 0) goto L8
            r0 = 0
            goto L6b
        L8:
            int r0 = r6.f19049b
        La:
            int r1 = r6.f19050c
            if (r0 >= r1) goto L1b
            byte[] r1 = r6.f19048a
            r1 = r1[r0]
            boolean r1 = com.opos.exoplayer.core.i.u.a(r1)
            if (r1 != 0) goto L1b
            int r0 = r0 + 1
            goto La
        L1b:
            int r1 = r6.f19049b
            int r2 = r0 - r1
            r3 = 3
            if (r2 < r3) goto L3d
            byte[] r2 = r6.f19048a
            r4 = r2[r1]
            r5 = -17
            if (r4 != r5) goto L3d
            int r4 = r1 + 1
            r4 = r2[r4]
            r5 = -69
            if (r4 != r5) goto L3d
            int r4 = r1 + 2
            r2 = r2[r4]
            r4 = -65
            if (r2 != r4) goto L3d
            int r1 = r1 + r3
            r6.f19049b = r1
        L3d:
            java.lang.String r1 = new java.lang.String
            byte[] r2 = r6.f19048a
            int r3 = r6.f19049b
            int r4 = r0 - r3
            r1.<init>(r2, r3, r4)
            r6.f19049b = r0
            int r2 = r6.f19050c
            if (r0 != r2) goto L4f
            goto L6a
        L4f:
            byte[] r3 = r6.f19048a
            r4 = r3[r0]
            r5 = 13
            if (r4 != r5) goto L5e
            int r0 = r0 + 1
            r6.f19049b = r0
            if (r0 != r2) goto L5e
            goto L6a
        L5e:
            int r0 = r6.f19049b
            r2 = r3[r0]
            r3 = 10
            if (r2 != r3) goto L6a
            int r0 = r0 + 1
            r6.f19049b = r0
        L6a:
            r0 = r1
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.core.i.m.z():java.lang.String");
    }
}
