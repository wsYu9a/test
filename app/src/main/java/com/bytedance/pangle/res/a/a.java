package com.bytedance.pangle.res.a;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class a {

    /* renamed from: f */
    private static final Logger f6240f = Logger.getLogger(a.class.getName());

    /* renamed from: a */
    private final byte[] f6241a;

    /* renamed from: b */
    private final h f6242b;

    /* renamed from: c */
    private final g f6243c;

    /* renamed from: d */
    private final e f6244d;

    /* renamed from: e */
    private C0074a f6245e;

    /* renamed from: com.bytedance.pangle.res.a.a$a */
    public static class C0074a {

        /* renamed from: a */
        public final short f6246a;

        /* renamed from: b */
        public final int f6247b;

        /* renamed from: c */
        public final int f6248c;

        /* renamed from: d */
        public final int f6249d;

        /* renamed from: e */
        public final int f6250e;

        private C0074a(short s, int i2, int i3, int i4) {
            this.f6246a = s;
            this.f6247b = i2;
            this.f6248c = i3;
            this.f6249d = i4;
            this.f6250e = i4 + i3;
        }

        public static C0074a a(g gVar, e eVar) {
            int a2 = eVar.a();
            try {
                return new C0074a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a2);
            } catch (EOFException unused) {
                return new C0074a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.f6244d = eVar;
        this.f6243c = new g(new i(eVar));
        this.f6241a = bArr;
        this.f6242b = hVar;
    }

    private String a(int i2) {
        int i3;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i3 = i2 - 1;
            if (i2 == 0 || this.f6243c.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i2 = i3;
        }
        this.f6243c.skipBytes(i3);
        return sb.toString();
    }

    private void b() {
        b(515);
        int readInt = this.f6243c.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f6243c.readInt();
            this.f6243c.skipBytes(256);
        }
        while (j().f6246a == 513) {
            c();
        }
    }

    private void c() {
        d();
        short s = j().f6246a;
        while (s == 514) {
            d();
            s = j().f6246a;
        }
        while (s == 513) {
            e();
            if (this.f6244d.a() < this.f6245e.f6250e) {
                f6240f.warning("Unknown data detected. Skipping: " + (this.f6245e.f6250e - this.f6244d.a()) + " byte(s)");
                e eVar = this.f6244d;
                eVar.skip((long) (this.f6245e.f6250e - eVar.a()));
            }
            s = j().f6246a;
        }
    }

    private void d() {
        b(514);
        this.f6243c.readUnsignedByte();
        this.f6243c.skipBytes(3);
        this.f6243c.skipBytes(this.f6243c.readInt() * 4);
    }

    private void e() {
        b(513);
        this.f6243c.readUnsignedByte();
        this.f6243c.readByte();
        this.f6243c.skipBytes(2);
        int readInt = this.f6243c.readInt();
        int readInt2 = this.f6243c.readInt();
        i();
        int i2 = (this.f6245e.f6249d + readInt2) - (readInt * 4);
        if (i2 != this.f6244d.a()) {
            f6240f.warning("Invalid data detected. Skipping: " + (i2 - this.f6244d.a()) + " byte(s)");
            this.f6243c.skipBytes(i2 - this.f6244d.a());
        }
        int[] a2 = this.f6243c.a(readInt);
        HashSet hashSet = new HashSet();
        for (int i3 : a2) {
            if (i3 != -1 && !hashSet.contains(Integer.valueOf(i3))) {
                f();
                hashSet.add(Integer.valueOf(i3));
            }
        }
    }

    private void f() {
        if (this.f6243c.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short readShort = this.f6243c.readShort();
        this.f6243c.readInt();
        if ((readShort & 1) == 0) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        int a2 = k.a(this.f6243c);
        k.a(this.f6241a, this.f6243c.readInt(), a2, this.f6242b);
        int readInt = this.f6243c.readInt();
        for (int i2 = 0; i2 < readInt; i2++) {
            int a3 = k.a(this.f6243c);
            k.a(this.f6241a, this.f6243c.readInt(), a3, this.f6242b);
            h();
        }
    }

    private void h() {
        this.f6243c.a();
        this.f6243c.b();
        byte readByte = this.f6243c.readByte();
        int a2 = k.a(this.f6243c);
        int readInt = this.f6243c.readInt();
        if (readByte == 1) {
            k.a(this.f6241a, readInt, a2, this.f6242b);
        }
        if (readByte == 2) {
            k.a(this.f6241a, readInt, a2, this.f6242b);
        }
    }

    private void i() {
        int readInt = this.f6243c.readInt();
        int i2 = 28;
        if (readInt < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.f6243c.readShort();
        this.f6243c.readShort();
        this.f6243c.readByte();
        this.f6243c.readByte();
        this.f6243c.readByte();
        this.f6243c.readByte();
        this.f6243c.readByte();
        this.f6243c.readByte();
        this.f6243c.readUnsignedShort();
        this.f6243c.readByte();
        this.f6243c.readByte();
        this.f6243c.readByte();
        this.f6243c.skipBytes(1);
        this.f6243c.readShort();
        this.f6243c.readShort();
        this.f6243c.readShort();
        this.f6243c.skipBytes(2);
        if (readInt >= 32) {
            this.f6243c.readByte();
            this.f6243c.readByte();
            this.f6243c.readShort();
            i2 = 32;
        }
        if (readInt >= 36) {
            this.f6243c.readShort();
            this.f6243c.readShort();
            i2 = 36;
        }
        if (readInt >= 48) {
            a(4).toCharArray();
            a(8).toCharArray();
            i2 = 48;
        }
        if (readInt >= 52) {
            this.f6243c.readByte();
            this.f6243c.readByte();
            this.f6243c.skipBytes(2);
            i2 = 52;
        }
        if (readInt >= 56) {
            this.f6243c.skipBytes(4);
            i2 = 56;
        }
        int i3 = readInt - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.f6243c.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                f6240f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f6240f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
            }
        }
        int i4 = readInt - i2;
        if (i4 > 0) {
            this.f6243c.skipBytes(i4);
        }
    }

    private C0074a j() {
        C0074a a2 = C0074a.a(this.f6243c, this.f6244d);
        this.f6245e = a2;
        return a2;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.f6243c.readInt();
        l.a(this.f6243c);
        j();
        for (int i2 = 0; i2 < readInt; i2++) {
            b(512);
            this.f6243c.readInt();
            this.f6243c.skipBytes(256);
            this.f6243c.skipBytes(4);
            this.f6243c.skipBytes(4);
            this.f6243c.skipBytes(4);
            this.f6243c.skipBytes(4);
            if (this.f6245e.f6247b == 288 && this.f6243c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f6243c);
            l.a(this.f6243c);
            j();
            boolean z = true;
            while (z) {
                short s = this.f6245e.f6246a;
                if (s == 514) {
                    c();
                } else if (s != 515) {
                    z = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i2) {
        if (this.f6245e.f6246a != i2) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i2), Short.valueOf(this.f6245e.f6246a)));
        }
    }
}
