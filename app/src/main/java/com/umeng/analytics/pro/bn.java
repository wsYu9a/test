package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class bn extends bu {

    /* renamed from: a */
    protected static final int f25747a = -65536;

    /* renamed from: b */
    protected static final int f25748b = -2147418112;

    /* renamed from: h */
    private static final bz f25749h = new bz();

    /* renamed from: c */
    protected boolean f25750c;

    /* renamed from: d */
    protected boolean f25751d;

    /* renamed from: e */
    protected int f25752e;

    /* renamed from: f */
    protected boolean f25753f;

    /* renamed from: i */
    private byte[] f25754i;

    /* renamed from: j */
    private byte[] f25755j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    public static class a implements bw {

        /* renamed from: a */
        protected boolean f25756a;

        /* renamed from: b */
        protected boolean f25757b;

        /* renamed from: c */
        protected int f25758c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            bn bnVar = new bn(ciVar, this.f25756a, this.f25757b);
            int i2 = this.f25758c;
            if (i2 != 0) {
                bnVar.c(i2);
            }
            return bnVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.f25756a = false;
            this.f25757b = true;
            this.f25756a = z;
            this.f25757b = z2;
            this.f25758c = i2;
        }
    }

    public bn(ci ciVar) {
        this(ciVar, false, true);
    }

    @Override // com.umeng.analytics.pro.bu
    public ByteBuffer A() throws bb {
        int w = w();
        d(w);
        if (this.f25794g.h() >= w) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f25794g.f(), this.f25794g.g(), w);
            this.f25794g.a(w);
            return wrap;
        }
        byte[] bArr = new byte[w];
        this.f25794g.d(bArr, 0, w);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bs bsVar) throws bb {
        if (this.f25751d) {
            a(f25748b | bsVar.f25788b);
            a(bsVar.f25787a);
            a(bsVar.f25789c);
        } else {
            a(bsVar.f25787a);
            a(bsVar.f25788b);
            a(bsVar.f25789c);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bz bzVar) {
    }

    public String b(int i2) throws bb {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.f25794g.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void c() {
    }

    public void c(int i2) {
        this.f25752e = i2;
        this.f25753f = true;
    }

    @Override // com.umeng.analytics.pro.bu
    public void d() throws bb {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void e() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void f() {
    }

    @Override // com.umeng.analytics.pro.bu
    public void g() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bs h() throws bb {
        int w = w();
        if (w < 0) {
            if (((-65536) & w) == f25748b) {
                return new bs(z(), (byte) (w & 255), w());
            }
            throw new bv(4, "Bad version in readMessageBegin");
        }
        if (this.f25750c) {
            throw new bv(4, "Missing version in readMessageBegin, old client?");
        }
        return new bs(b(w), u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void i() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bz j() {
        return f25749h;
    }

    @Override // com.umeng.analytics.pro.bu
    public void k() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bp l() throws bb {
        byte u = u();
        return new bp("", u, u == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.bu
    public void m() {
    }

    @Override // com.umeng.analytics.pro.bu
    public br n() throws bb {
        return new br(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void o() {
    }

    @Override // com.umeng.analytics.pro.bu
    public bq p() throws bb {
        return new bq(u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void q() {
    }

    @Override // com.umeng.analytics.pro.bu
    public by r() throws bb {
        return new by(u(), w());
    }

    @Override // com.umeng.analytics.pro.bu
    public void s() {
    }

    @Override // com.umeng.analytics.pro.bu
    public boolean t() throws bb {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.bu
    public byte u() throws bb {
        if (this.f25794g.h() < 1) {
            a(this.m, 0, 1);
            return this.m[0];
        }
        byte b2 = this.f25794g.f()[this.f25794g.g()];
        this.f25794g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.bu
    public short v() throws bb {
        byte[] bArr = this.n;
        int i2 = 0;
        if (this.f25794g.h() >= 2) {
            bArr = this.f25794g.f();
            i2 = this.f25794g.g();
            this.f25794g.a(2);
        } else {
            a(this.n, 0, 2);
        }
        return (short) ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.bu
    public int w() throws bb {
        byte[] bArr = this.o;
        int i2 = 0;
        if (this.f25794g.h() >= 4) {
            bArr = this.f25794g.f();
            i2 = this.f25794g.g();
            this.f25794g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public long x() throws bb {
        byte[] bArr = this.p;
        int i2 = 0;
        if (this.f25794g.h() >= 8) {
            bArr = this.f25794g.f();
            i2 = this.f25794g.g();
            this.f25794g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return (bArr[i2 + 7] & 255) | ((bArr[i2] & 255) << 56) | ((bArr[i2 + 1] & 255) << 48) | ((bArr[i2 + 2] & 255) << 40) | ((bArr[i2 + 3] & 255) << 32) | ((bArr[i2 + 4] & 255) << 24) | ((bArr[i2 + 5] & 255) << 16) | ((bArr[i2 + 6] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public double y() throws bb {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.bu
    public String z() throws bb {
        int w = w();
        if (this.f25794g.h() < w) {
            return b(w);
        }
        try {
            String str = new String(this.f25794g.f(), this.f25794g.g(), w, "UTF-8");
            this.f25794g.a(w);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public bn(ci ciVar, boolean z, boolean z2) {
        super(ciVar);
        this.f25750c = false;
        this.f25751d = true;
        this.f25753f = false;
        this.f25754i = new byte[1];
        this.f25755j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.f25750c = z;
        this.f25751d = z2;
    }

    protected void d(int i2) throws bb {
        if (i2 < 0) {
            throw new bv("Negative length: " + i2);
        }
        if (this.f25753f) {
            int i3 = this.f25752e - i2;
            this.f25752e = i3;
            if (i3 >= 0) {
                return;
            }
            throw new bv("Message length exceeded: " + i2);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bp bpVar) throws bb {
        a(bpVar.f25780b);
        a(bpVar.f25781c);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(br brVar) throws bb {
        a(brVar.f25784a);
        a(brVar.f25785b);
        a(brVar.f25786c);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bq bqVar) throws bb {
        a(bqVar.f25782a);
        a(bqVar.f25783b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(by byVar) throws bb {
        a(byVar.f25804a);
        a(byVar.f25805b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(boolean z) throws bb {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(byte b2) throws bb {
        byte[] bArr = this.f25754i;
        bArr[0] = b2;
        this.f25794g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(short s) throws bb {
        byte[] bArr = this.f25755j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f25794g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(int i2) throws bb {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.f25794g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(long j2) throws bb {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        this.f25794g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(double d2) throws bb {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(String str) throws bb {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f25794g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(ByteBuffer byteBuffer) throws bb {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.f25794g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    private int a(byte[] bArr, int i2, int i3) throws bb {
        d(i3);
        return this.f25794g.d(bArr, i2, i3);
    }
}
