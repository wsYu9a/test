package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class cz extends dg {

    /* renamed from: a */
    protected static final int f23773a = -65536;

    /* renamed from: b */
    protected static final int f23774b = -2147418112;

    /* renamed from: h */
    private static final dl f23775h = new dl();

    /* renamed from: c */
    protected boolean f23776c;

    /* renamed from: d */
    protected boolean f23777d;

    /* renamed from: e */
    protected int f23778e;

    /* renamed from: f */
    protected boolean f23779f;

    /* renamed from: i */
    private byte[] f23780i;

    /* renamed from: j */
    private byte[] f23781j;

    /* renamed from: k */
    private byte[] f23782k;

    /* renamed from: l */
    private byte[] f23783l;

    /* renamed from: m */
    private byte[] f23784m;

    /* renamed from: n */
    private byte[] f23785n;

    /* renamed from: o */
    private byte[] f23786o;

    /* renamed from: p */
    private byte[] f23787p;

    public static class a implements di {

        /* renamed from: a */
        protected boolean f23788a;

        /* renamed from: b */
        protected boolean f23789b;

        /* renamed from: c */
        protected int f23790c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.di
        public dg a(du duVar) {
            cz czVar = new cz(duVar, this.f23788a, this.f23789b);
            int i10 = this.f23790c;
            if (i10 != 0) {
                czVar.c(i10);
            }
            return czVar;
        }

        public a(boolean z10, boolean z11) {
            this(z10, z11, 0);
        }

        public a(boolean z10, boolean z11, int i10) {
            this.f23788a = z10;
            this.f23789b = z11;
            this.f23790c = i10;
        }
    }

    public cz(du duVar) {
        this(duVar, false, true);
    }

    @Override // com.umeng.analytics.pro.dg
    public ByteBuffer A() throws cn {
        int w10 = w();
        d(w10);
        if (this.f23842g.h() >= w10) {
            ByteBuffer wrap = ByteBuffer.wrap(this.f23842g.f(), this.f23842g.g(), w10);
            this.f23842g.a(w10);
            return wrap;
        }
        byte[] bArr = new byte[w10];
        this.f23842g.d(bArr, 0, w10);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void b() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void c() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void d() throws cn {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void e() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void f() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void g() {
    }

    @Override // com.umeng.analytics.pro.dg
    public de h() throws cn {
        int w10 = w();
        if (w10 < 0) {
            if (((-65536) & w10) == f23774b) {
                return new de(z(), (byte) (w10 & 255), w());
            }
            throw new dh(4, "Bad version in readMessageBegin");
        }
        if (this.f23776c) {
            throw new dh(4, "Missing version in readMessageBegin, old client?");
        }
        return new de(b(w10), u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void i() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dl j() {
        return f23775h;
    }

    @Override // com.umeng.analytics.pro.dg
    public void k() {
    }

    @Override // com.umeng.analytics.pro.dg
    public db l() throws cn {
        byte u10 = u();
        return new db("", u10, u10 == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.dg
    public void m() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dd n() throws cn {
        return new dd(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void o() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dc p() throws cn {
        return new dc(u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void q() {
    }

    @Override // com.umeng.analytics.pro.dg
    public dk r() throws cn {
        return new dk(u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public void s() {
    }

    @Override // com.umeng.analytics.pro.dg
    public boolean t() throws cn {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.dg
    public byte u() throws cn {
        if (this.f23842g.h() < 1) {
            a(this.f23784m, 0, 1);
            return this.f23784m[0];
        }
        byte b10 = this.f23842g.f()[this.f23842g.g()];
        this.f23842g.a(1);
        return b10;
    }

    @Override // com.umeng.analytics.pro.dg
    public short v() throws cn {
        int i10;
        byte[] bArr = this.f23785n;
        if (this.f23842g.h() >= 2) {
            bArr = this.f23842g.f();
            i10 = this.f23842g.g();
            this.f23842g.a(2);
        } else {
            a(this.f23785n, 0, 2);
            i10 = 0;
        }
        return (short) ((bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8));
    }

    @Override // com.umeng.analytics.pro.dg
    public int w() throws cn {
        int i10;
        byte[] bArr = this.f23786o;
        if (this.f23842g.h() >= 4) {
            bArr = this.f23842g.f();
            i10 = this.f23842g.g();
            this.f23842g.a(4);
        } else {
            a(this.f23786o, 0, 4);
            i10 = 0;
        }
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public long x() throws cn {
        int i10;
        byte[] bArr = this.f23787p;
        if (this.f23842g.h() >= 8) {
            bArr = this.f23842g.f();
            i10 = this.f23842g.g();
            this.f23842g.a(8);
        } else {
            a(this.f23787p, 0, 8);
            i10 = 0;
        }
        return (bArr[i10 + 7] & 255) | ((bArr[i10] & 255) << 56) | ((bArr[i10 + 1] & 255) << 48) | ((bArr[i10 + 2] & 255) << 40) | ((bArr[i10 + 3] & 255) << 32) | ((bArr[i10 + 4] & 255) << 24) | ((bArr[i10 + 5] & 255) << 16) | ((bArr[i10 + 6] & 255) << 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public double y() throws cn {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.dg
    public String z() throws cn {
        int w10 = w();
        if (this.f23842g.h() < w10) {
            return b(w10);
        }
        try {
            String str = new String(this.f23842g.f(), this.f23842g.g(), w10, "UTF-8");
            this.f23842g.a(w10);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public cz(du duVar, boolean z10, boolean z11) {
        super(duVar);
        this.f23779f = false;
        this.f23780i = new byte[1];
        this.f23781j = new byte[2];
        this.f23782k = new byte[4];
        this.f23783l = new byte[8];
        this.f23784m = new byte[1];
        this.f23785n = new byte[2];
        this.f23786o = new byte[4];
        this.f23787p = new byte[8];
        this.f23776c = z10;
        this.f23777d = z11;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dl dlVar) {
    }

    public String b(int i10) throws cn {
        try {
            d(i10);
            byte[] bArr = new byte[i10];
            this.f23842g.d(bArr, 0, i10);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void c(int i10) {
        this.f23778e = i10;
        this.f23779f = true;
    }

    public void d(int i10) throws cn {
        if (i10 < 0) {
            throw new dh("Negative length: " + i10);
        }
        if (this.f23779f) {
            int i11 = this.f23778e - i10;
            this.f23778e = i11;
            if (i11 >= 0) {
                return;
            }
            throw new dh("Message length exceeded: " + i10);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(de deVar) throws cn {
        if (this.f23777d) {
            a(deVar.f23836b | f23774b);
            a(deVar.f23835a);
            a(deVar.f23837c);
        } else {
            a(deVar.f23835a);
            a(deVar.f23836b);
            a(deVar.f23837c);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(db dbVar) throws cn {
        a(dbVar.f23828b);
        a(dbVar.f23829c);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dd ddVar) throws cn {
        a(ddVar.f23832a);
        a(ddVar.f23833b);
        a(ddVar.f23834c);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dc dcVar) throws cn {
        a(dcVar.f23830a);
        a(dcVar.f23831b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dk dkVar) throws cn {
        a(dkVar.f23852a);
        a(dkVar.f23853b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(boolean z10) throws cn {
        a(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(byte b10) throws cn {
        byte[] bArr = this.f23780i;
        bArr[0] = b10;
        this.f23842g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(short s10) throws cn {
        byte[] bArr = this.f23781j;
        bArr[0] = (byte) ((s10 >> 8) & 255);
        bArr[1] = (byte) (s10 & 255);
        this.f23842g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(int i10) throws cn {
        byte[] bArr = this.f23782k;
        bArr[0] = (byte) ((i10 >> 24) & 255);
        bArr[1] = (byte) ((i10 >> 16) & 255);
        bArr[2] = (byte) ((i10 >> 8) & 255);
        bArr[3] = (byte) (i10 & 255);
        this.f23842g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(long j10) throws cn {
        byte[] bArr = this.f23783l;
        bArr[0] = (byte) ((j10 >> 56) & 255);
        bArr[1] = (byte) ((j10 >> 48) & 255);
        bArr[2] = (byte) ((j10 >> 40) & 255);
        bArr[3] = (byte) ((j10 >> 32) & 255);
        bArr[4] = (byte) ((j10 >> 24) & 255);
        bArr[5] = (byte) ((j10 >> 16) & 255);
        bArr[6] = (byte) ((j10 >> 8) & 255);
        bArr[7] = (byte) (j10 & 255);
        this.f23842g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(double d10) throws cn {
        a(Double.doubleToLongBits(d10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(String str) throws cn {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f23842g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(ByteBuffer byteBuffer) throws cn {
        int limit = byteBuffer.limit() - byteBuffer.position();
        a(limit);
        this.f23842g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    private int a(byte[] bArr, int i10, int i11) throws cn {
        d(i11);
        return this.f23842g.d(bArr, i10, i11);
    }
}
