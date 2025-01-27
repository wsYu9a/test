package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes4.dex */
public class bo extends bu {

    /* renamed from: d */
    private static final bz f25759d = new bz("");

    /* renamed from: e */
    private static final bp f25760e = new bp("", (byte) 0, 0);

    /* renamed from: f */
    private static final byte[] f25761f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};

    /* renamed from: h */
    private static final byte f25762h = -126;

    /* renamed from: i */
    private static final byte f25763i = 1;

    /* renamed from: j */
    private static final byte f25764j = 31;
    private static final byte k = -32;
    private static final int l = 5;

    /* renamed from: a */
    byte[] f25765a;

    /* renamed from: b */
    byte[] f25766b;

    /* renamed from: c */
    byte[] f25767c;
    private at m;
    private short n;
    private bp o;
    private Boolean p;
    private final long q;
    private byte[] r;

    private static class b {

        /* renamed from: a */
        public static final byte f25769a = 1;

        /* renamed from: b */
        public static final byte f25770b = 2;

        /* renamed from: c */
        public static final byte f25771c = 3;

        /* renamed from: d */
        public static final byte f25772d = 4;

        /* renamed from: e */
        public static final byte f25773e = 5;

        /* renamed from: f */
        public static final byte f25774f = 6;

        /* renamed from: g */
        public static final byte f25775g = 7;

        /* renamed from: h */
        public static final byte f25776h = 8;

        /* renamed from: i */
        public static final byte f25777i = 9;

        /* renamed from: j */
        public static final byte f25778j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    public bo(ci ciVar, long j2) {
        super(ciVar);
        this.m = new at(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.f25765a = new byte[5];
        this.f25766b = new byte[10];
        this.r = new byte[1];
        this.f25767c = new byte[1];
        this.q = j2;
    }

    private int E() throws bb {
        int i2 = 0;
        if (this.f25794g.h() >= 5) {
            byte[] f2 = this.f25794g.f();
            int g2 = this.f25794g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = f2[g2 + i2];
                i3 |= (b2 & ByteCompanionObject.MAX_VALUE) << i4;
                if ((b2 & ByteCompanionObject.MIN_VALUE) != 128) {
                    this.f25794g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte u = u();
                i2 |= (u & ByteCompanionObject.MAX_VALUE) << i5;
                if ((u & ByteCompanionObject.MIN_VALUE) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bb {
        int i2 = 0;
        long j2 = 0;
        if (this.f25794g.h() >= 10) {
            byte[] f2 = this.f25794g.f();
            int g2 = this.f25794g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                j3 |= (r4 & ByteCompanionObject.MAX_VALUE) << i3;
                if ((f2[g2 + i2] & ByteCompanionObject.MIN_VALUE) != 128) {
                    this.f25794g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                j2 |= (r0 & ByteCompanionObject.MAX_VALUE) << i2;
                if ((u() & ByteCompanionObject.MIN_VALUE) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & 15;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) throws bb {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.f25794g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws bv {
        if (i2 < 0) {
            throw new bv("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new bv("Length exceeded max allowed: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public ByteBuffer A() throws bb {
        int E = E();
        f(E);
        if (E == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[E];
        this.f25794g.d(bArr, 0, E);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bs bsVar) throws bb {
        b(f25762h);
        d(((bsVar.f25788b << 5) & (-32)) | 1);
        b(bsVar.f25789c);
        a(bsVar.f25787a);
    }

    @Override // com.umeng.analytics.pro.bu
    public void b() throws bb {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public void c() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void d() throws bb {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.bu
    public void e() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void f() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public void g() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bs h() throws bb {
        byte u = u();
        if (u != -126) {
            throw new bv("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(u));
        }
        byte u2 = u();
        byte b2 = (byte) (u2 & f25764j);
        if (b2 == 1) {
            return new bs(z(), (byte) ((u2 >> 5) & 3), E());
        }
        throw new bv("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void i() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bz j() throws bb {
        this.m.a(this.n);
        this.n = (short) 0;
        return f25759d;
    }

    @Override // com.umeng.analytics.pro.bu
    public void k() throws bb {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.bu
    public bp l() throws bb {
        byte u = u();
        if (u == 0) {
            return f25760e;
        }
        short s = (short) ((u & 240) >> 4);
        byte b2 = (byte) (u & 15);
        bp bpVar = new bp("", d(b2), s == 0 ? v() : (short) (this.n + s));
        if (c(u)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = bpVar.f25781c;
        return bpVar;
    }

    @Override // com.umeng.analytics.pro.bu
    public void m() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public br n() throws bb {
        int E = E();
        byte u = E == 0 ? (byte) 0 : u();
        return new br(d((byte) (u >> 4)), d((byte) (u & 15)), E);
    }

    @Override // com.umeng.analytics.pro.bu
    public void o() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public bq p() throws bb {
        byte u = u();
        int i2 = (u >> 4) & 15;
        if (i2 == 15) {
            i2 = E();
        }
        return new bq(d(u), i2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void q() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public by r() throws bb {
        return new by(p());
    }

    @Override // com.umeng.analytics.pro.bu
    public void s() throws bb {
    }

    @Override // com.umeng.analytics.pro.bu
    public boolean t() throws bb {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean booleanValue = bool.booleanValue();
        this.p = null;
        return booleanValue;
    }

    @Override // com.umeng.analytics.pro.bu
    public byte u() throws bb {
        if (this.f25794g.h() <= 0) {
            this.f25794g.d(this.f25767c, 0, 1);
            return this.f25767c[0];
        }
        byte b2 = this.f25794g.f()[this.f25794g.g()];
        this.f25794g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.bu
    public short v() throws bb {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public int w() throws bb {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.bu
    public long x() throws bb {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.bu
    public double y() throws bb {
        byte[] bArr = new byte[8];
        this.f25794g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.bu
    public String z() throws bb {
        int E = E();
        f(E);
        if (E == 0) {
            return "";
        }
        try {
            if (this.f25794g.h() < E) {
                return new String(e(E), "UTF-8");
            }
            String str = new String(this.f25794g.f(), this.f25794g.g(), E, "UTF-8");
            this.f25794g.a(E);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    public static class a implements bw {

        /* renamed from: a */
        private final long f25768a;

        public a() {
            this.f25768a = -1L;
        }

        @Override // com.umeng.analytics.pro.bw
        public bu a(ci ciVar) {
            return new bo(ciVar, this.f25768a);
        }

        public a(int i2) {
            this.f25768a = i2;
        }
    }

    private void b(int i2) throws bb {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.f25765a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.f25765a;
        bArr[i3] = (byte) i2;
        this.f25794g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) throws bb {
        b((byte) i2);
    }

    private byte d(byte b2) throws bv {
        byte b3 = (byte) (b2 & 15);
        switch (b3) {
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
                throw new bv("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f25761f[b2];
    }

    private void b(long j2) throws bb {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.f25766b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.f25766b;
        bArr[i2] = (byte) j2;
        this.f25794g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bz bzVar) throws bb {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bp bpVar) throws bb {
        if (bpVar.f25780b == 2) {
            this.o = bpVar;
        } else {
            a(bpVar, (byte) -1);
        }
    }

    private void b(byte b2) throws bb {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.f25794g.b(bArr);
    }

    private void a(bp bpVar, byte b2) throws bb {
        if (b2 == -1) {
            b2 = e(bpVar.f25780b);
        }
        short s = bpVar.f25781c;
        short s2 = this.n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(bpVar.f25781c);
        }
        this.n = bpVar.f25781c;
    }

    public bo(ci ciVar) {
        this(ciVar, -1L);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(br brVar) throws bb {
        int i2 = brVar.f25786c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(brVar.f25785b) | (e(brVar.f25784a) << 4));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(bq bqVar) throws bb {
        a(bqVar.f25782a, bqVar.f25783b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(by byVar) throws bb {
        a(byVar.f25804a, byVar.f25805b);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(boolean z) throws bb {
        bp bpVar = this.o;
        if (bpVar != null) {
            a(bpVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(byte b2) throws bb {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(short s) throws bb {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(int i2) throws bb {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(long j2) throws bb {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(double d2) throws bb {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.f25794g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(String str) throws bb {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.bu
    public void a(ByteBuffer byteBuffer) throws bb {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bb {
        b(i3);
        this.f25794g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bb {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((bArr[7] & 255) << 56) | ((bArr[6] & 255) << 48) | ((bArr[5] & 255) << 40) | ((bArr[4] & 255) << 32) | ((bArr[3] & 255) << 24) | ((bArr[2] & 255) << 16) | ((bArr[1] & 255) << 8) | (255 & bArr[0]);
    }
}
