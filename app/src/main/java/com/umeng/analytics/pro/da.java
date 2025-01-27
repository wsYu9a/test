package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class da extends dg {

    /* renamed from: d */
    private static final dl f23797d = new dl("");

    /* renamed from: e */
    private static final db f23798e = new db("", (byte) 0, 0);

    /* renamed from: f */
    private static final byte[] f23799f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};

    /* renamed from: h */
    private static final byte f23800h = -126;

    /* renamed from: i */
    private static final byte f23801i = 1;

    /* renamed from: j */
    private static final byte f23802j = 31;

    /* renamed from: k */
    private static final byte f23803k = -32;

    /* renamed from: l */
    private static final int f23804l = 5;

    /* renamed from: a */
    byte[] f23805a;

    /* renamed from: b */
    byte[] f23806b;

    /* renamed from: c */
    byte[] f23807c;

    /* renamed from: m */
    private cf f23808m;

    /* renamed from: n */
    private short f23809n;

    /* renamed from: o */
    private db f23810o;

    /* renamed from: p */
    private Boolean f23811p;

    /* renamed from: q */
    private final long f23812q;

    /* renamed from: r */
    private byte[] f23813r;

    public static class b {

        /* renamed from: a */
        public static final byte f23815a = 1;

        /* renamed from: b */
        public static final byte f23816b = 2;

        /* renamed from: c */
        public static final byte f23817c = 3;

        /* renamed from: d */
        public static final byte f23818d = 4;

        /* renamed from: e */
        public static final byte f23819e = 5;

        /* renamed from: f */
        public static final byte f23820f = 6;

        /* renamed from: g */
        public static final byte f23821g = 7;

        /* renamed from: h */
        public static final byte f23822h = 8;

        /* renamed from: i */
        public static final byte f23823i = 9;

        /* renamed from: j */
        public static final byte f23824j = 10;

        /* renamed from: k */
        public static final byte f23825k = 11;

        /* renamed from: l */
        public static final byte f23826l = 12;

        private b() {
        }
    }

    public da(du duVar, long j10) {
        super(duVar);
        this.f23808m = new cf(15);
        this.f23809n = (short) 0;
        this.f23810o = null;
        this.f23811p = null;
        this.f23805a = new byte[5];
        this.f23806b = new byte[10];
        this.f23813r = new byte[1];
        this.f23807c = new byte[1];
        this.f23812q = j10;
    }

    private int E() throws cn {
        int i10 = 0;
        if (this.f23842g.h() >= 5) {
            byte[] f10 = this.f23842g.f();
            int g10 = this.f23842g.g();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                byte b10 = f10[g10 + i10];
                i11 |= (b10 & Byte.MAX_VALUE) << i12;
                if ((b10 & 128) != 128) {
                    this.f23842g.a(i10 + 1);
                    return i11;
                }
                i12 += 7;
                i10++;
            }
        } else {
            int i13 = 0;
            while (true) {
                byte u10 = u();
                i10 |= (u10 & Byte.MAX_VALUE) << i13;
                if ((u10 & 128) != 128) {
                    return i10;
                }
                i13 += 7;
            }
        }
    }

    private long F() throws cn {
        int i10 = 0;
        long j10 = 0;
        if (this.f23842g.h() >= 10) {
            byte[] f10 = this.f23842g.f();
            int g10 = this.f23842g.g();
            long j11 = 0;
            int i11 = 0;
            while (true) {
                j11 |= (r7 & Byte.MAX_VALUE) << i11;
                if ((f10[g10 + i10] & 128) != 128) {
                    this.f23842g.a(i10 + 1);
                    return j11;
                }
                i11 += 7;
                i10++;
            }
        } else {
            while (true) {
                j10 |= (r0 & Byte.MAX_VALUE) << i10;
                if ((u() & 128) != 128) {
                    return j10;
                }
                i10 += 7;
            }
        }
    }

    private int c(int i10) {
        return (i10 >> 31) ^ (i10 << 1);
    }

    private long d(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    private int g(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public ByteBuffer A() throws cn {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f23842g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void B() {
        this.f23808m.c();
        this.f23809n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void b() throws cn {
        this.f23809n = this.f23808m.a();
    }

    @Override // com.umeng.analytics.pro.dg
    public void e() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void f() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public de h() throws cn {
        byte u10 = u();
        if (u10 != -126) {
            throw new dh("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u10));
        }
        byte u11 = u();
        byte b10 = (byte) (u11 & 31);
        if (b10 == 1) {
            return new de(z(), (byte) ((u11 >> 5) & 3), E());
        }
        throw new dh("Expected version 1 but got " + ((int) b10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void i() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public dl j() throws cn {
        this.f23808m.a(this.f23809n);
        this.f23809n = (short) 0;
        return f23797d;
    }

    @Override // com.umeng.analytics.pro.dg
    public void k() throws cn {
        this.f23809n = this.f23808m.a();
    }

    @Override // com.umeng.analytics.pro.dg
    public db l() throws cn {
        byte u10 = u();
        if (u10 == 0) {
            return f23798e;
        }
        short s10 = (short) ((u10 & 240) >> 4);
        byte b10 = (byte) (u10 & 15);
        db dbVar = new db("", d(b10), s10 == 0 ? v() : (short) (this.f23809n + s10));
        if (c(u10)) {
            this.f23811p = b10 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f23809n = dbVar.f23829c;
        return dbVar;
    }

    @Override // com.umeng.analytics.pro.dg
    public void m() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public dd n() throws cn {
        int E = E();
        byte u10 = E == 0 ? (byte) 0 : u();
        return new dd(d((byte) (u10 >> 4)), d((byte) (u10 & 15)), E);
    }

    @Override // com.umeng.analytics.pro.dg
    public void o() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public dc p() throws cn {
        byte u10 = u();
        int i10 = (u10 >> 4) & 15;
        if (i10 == 15) {
            i10 = E();
        }
        return new dc(d(u10), i10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void q() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public dk r() throws cn {
        return new dk(p());
    }

    @Override // com.umeng.analytics.pro.dg
    public void s() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public boolean t() throws cn {
        Boolean bool = this.f23811p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.f23811p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.dg
    public byte u() throws cn {
        if (this.f23842g.h() <= 0) {
            this.f23842g.d(this.f23807c, 0, 1);
            return this.f23807c[0];
        }
        byte b10 = this.f23842g.f()[this.f23842g.g()];
        this.f23842g.a(1);
        return b10;
    }

    @Override // com.umeng.analytics.pro.dg
    public short v() throws cn {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.dg
    public int w() throws cn {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.dg
    public long x() throws cn {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.dg
    public double y() throws cn {
        byte[] bArr = new byte[8];
        this.f23842g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.dg
    public String z() throws cn {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f23842g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.f23842g.f(), this.f23842g.g(), E, "UTF-8");
            this.f23842g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    public static class a implements di {

        /* renamed from: a */
        private final long f23814a;

        public a() {
            this.f23814a = -1L;
        }

        @Override // com.umeng.analytics.pro.di
        public dg a(du duVar) {
            return new da(duVar, this.f23814a);
        }

        public a(int i10) {
            this.f23814a = i10;
        }
    }

    private void b(int i10) throws cn {
        int i11 = 0;
        while ((i10 & d3.a.f25243g) != 0) {
            this.f23805a[i11] = (byte) ((i10 & 127) | 128);
            i10 >>>= 7;
            i11++;
        }
        byte[] bArr = this.f23805a;
        bArr[i11] = (byte) i10;
        this.f23842g.b(bArr, 0, i11 + 1);
    }

    private long c(long j10) {
        return (j10 >> 63) ^ (j10 << 1);
    }

    private byte[] e(int i10) throws cn {
        if (i10 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i10];
        this.f23842g.d(bArr, 0, i10);
        return bArr;
    }

    private void f(int i10) throws dh {
        if (i10 < 0) {
            throw new dh("Negative length: " + i10);
        }
        long j10 = this.f23812q;
        if (j10 == -1 || i10 <= j10) {
            return;
        }
        throw new dh("Length exceeded max allowed: " + i10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(de deVar) throws cn {
        b(f23800h);
        d(((deVar.f23836b << 5) & (-32)) | 1);
        b(deVar.f23837c);
        a(deVar.f23835a);
    }

    @Override // com.umeng.analytics.pro.dg
    public void d() throws cn {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void g() throws cn {
    }

    private void d(int i10) throws cn {
        b((byte) i10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void c() throws cn {
    }

    private boolean c(byte b10) {
        int i10 = b10 & 15;
        return i10 == 1 || i10 == 2;
    }

    private byte d(byte b10) throws dh {
        byte b11 = (byte) (b10 & 15);
        switch (b11) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new dh("don't know what type: " + ((int) b11));
        }
    }

    private void b(long j10) throws cn {
        int i10 = 0;
        while (((-128) & j10) != 0) {
            this.f23806b[i10] = (byte) ((127 & j10) | 128);
            j10 >>>= 7;
            i10++;
        }
        byte[] bArr = this.f23806b;
        bArr[i10] = (byte) j10;
        this.f23842g.b(bArr, 0, i10 + 1);
    }

    private byte e(byte b10) {
        return f23799f[b10];
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dl dlVar) throws cn {
        this.f23808m.a(this.f23809n);
        this.f23809n = (short) 0;
    }

    private void b(byte b10) throws cn {
        byte[] bArr = this.f23813r;
        bArr[0] = b10;
        this.f23842g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(db dbVar) throws cn {
        if (dbVar.f23828b == 2) {
            this.f23810o = dbVar;
        } else {
            a(dbVar, (byte) -1);
        }
    }

    public da(du duVar) {
        this(duVar, -1L);
    }

    private void a(db dbVar, byte b10) throws cn {
        if (b10 == -1) {
            b10 = e(dbVar.f23828b);
        }
        short s10 = dbVar.f23829c;
        short s11 = this.f23809n;
        if (s10 > s11 && s10 - s11 <= 15) {
            d(b10 | ((s10 - s11) << 4));
        } else {
            b(b10);
            a(dbVar.f23829c);
        }
        this.f23809n = dbVar.f23829c;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dd ddVar) throws cn {
        int i10 = ddVar.f23834c;
        if (i10 == 0) {
            d(0);
            return;
        }
        b(i10);
        d(e(ddVar.f23833b) | (e(ddVar.f23832a) << 4));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dc dcVar) throws cn {
        a(dcVar.f23830a, dcVar.f23831b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dk dkVar) throws cn {
        a(dkVar.f23852a, dkVar.f23853b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(boolean z10) throws cn {
        db dbVar = this.f23810o;
        if (dbVar != null) {
            a(dbVar, z10 ? (byte) 1 : (byte) 2);
            this.f23810o = null;
        } else {
            b(z10 ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(byte b10) throws cn {
        b(b10);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(short s10) throws cn {
        b(c((int) s10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(int i10) throws cn {
        b(c(i10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(long j10) throws cn {
        b(c(j10));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(double d10) throws cn {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d10), bArr, 0);
        this.f23842g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(String str) throws cn {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(ByteBuffer byteBuffer) throws cn {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i10, int i11) throws cn {
        b(i11);
        this.f23842g.b(bArr, i10, i11);
    }

    public void a(byte b10, int i10) throws cn {
        if (i10 <= 14) {
            d(e(b10) | (i10 << 4));
        } else {
            d(e(b10) | 240);
            b(i10);
        }
    }

    private void a(long j10, byte[] bArr, int i10) {
        bArr[i10] = (byte) (j10 & 255);
        bArr[i10 + 1] = (byte) ((j10 >> 8) & 255);
        bArr[i10 + 2] = (byte) ((j10 >> 16) & 255);
        bArr[i10 + 3] = (byte) ((j10 >> 24) & 255);
        bArr[i10 + 4] = (byte) ((j10 >> 32) & 255);
        bArr[i10 + 5] = (byte) ((j10 >> 40) & 255);
        bArr[i10 + 6] = (byte) ((j10 >> 48) & 255);
        bArr[i10 + 7] = (byte) ((j10 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
