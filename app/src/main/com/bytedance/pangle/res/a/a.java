package com.bytedance.pangle.res.a;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: f */
    private static final Logger f7747f = Logger.getLogger(a.class.getName());

    /* renamed from: a */
    private final byte[] f7748a;

    /* renamed from: b */
    private final h f7749b;

    /* renamed from: c */
    private final g f7750c;

    /* renamed from: d */
    private final e f7751d;

    /* renamed from: e */
    private C0234a f7752e;

    /* renamed from: com.bytedance.pangle.res.a.a$a */
    public static class C0234a {

        /* renamed from: a */
        public final short f7753a;

        /* renamed from: b */
        public final int f7754b;

        /* renamed from: c */
        public final int f7755c;

        /* renamed from: d */
        public final int f7756d;

        /* renamed from: e */
        public final int f7757e;

        private C0234a(short s10, int i10, int i11, int i12) {
            this.f7753a = s10;
            this.f7754b = i10;
            this.f7755c = i11;
            this.f7756d = i12;
            this.f7757e = i12 + i11;
        }

        public static C0234a a(g gVar, e eVar) {
            int a10 = eVar.a();
            try {
                return new C0234a(gVar.readShort(), gVar.readShort(), gVar.readInt(), a10);
            } catch (EOFException unused) {
                return new C0234a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.f7751d = eVar;
        this.f7750c = new g(new i(eVar));
        this.f7748a = bArr;
        this.f7749b = hVar;
    }

    private String a(int i10) {
        int i11;
        short s10;
        StringBuilder sb2 = new StringBuilder(16);
        while (true) {
            i11 = i10 - 1;
            if (i10 == 0 || this.f7750c.readByte() == 0) {
                break;
            }
            sb2.append((char) s10);
            i10 = i11;
        }
        this.f7750c.skipBytes(i11);
        return sb2.toString();
    }

    private void b() {
        b(515);
        int readInt = this.f7750c.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f7750c.readInt();
            this.f7750c.skipBytes(256);
        }
        while (j().f7753a == 513) {
            c();
        }
    }

    private void c() {
        d();
        short s10 = j().f7753a;
        while (s10 == 514) {
            d();
            s10 = j().f7753a;
        }
        while (s10 == 513) {
            e();
            if (this.f7751d.a() < this.f7752e.f7757e) {
                f7747f.warning("Unknown data detected. Skipping: " + (this.f7752e.f7757e - this.f7751d.a()) + " byte(s)");
                e eVar = this.f7751d;
                eVar.skip((long) (this.f7752e.f7757e - eVar.a()));
            }
            s10 = j().f7753a;
        }
    }

    private void d() {
        b(514);
        this.f7750c.readUnsignedByte();
        this.f7750c.skipBytes(3);
        this.f7750c.skipBytes(this.f7750c.readInt() * 4);
    }

    private void e() {
        b(InputDeviceCompat.SOURCE_DPAD);
        this.f7750c.readUnsignedByte();
        this.f7750c.readByte();
        this.f7750c.skipBytes(2);
        int readInt = this.f7750c.readInt();
        int readInt2 = this.f7750c.readInt();
        i();
        int i10 = (this.f7752e.f7756d + readInt2) - (readInt * 4);
        if (i10 != this.f7751d.a()) {
            f7747f.warning("Invalid data detected. Skipping: " + (i10 - this.f7751d.a()) + " byte(s)");
            this.f7750c.skipBytes(i10 - this.f7751d.a());
        }
        int[] a10 = this.f7750c.a(readInt);
        HashSet hashSet = new HashSet();
        for (int i11 : a10) {
            if (i11 != -1 && !hashSet.contains(Integer.valueOf(i11))) {
                f();
                hashSet.add(Integer.valueOf(i11));
            }
        }
    }

    private void f() {
        if (this.f7750c.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short readShort = this.f7750c.readShort();
        this.f7750c.readInt();
        if ((readShort & 1) == 0) {
            h();
        } else {
            g();
        }
    }

    private void g() {
        int a10 = k.a(this.f7750c);
        k.a(this.f7748a, this.f7750c.readInt(), a10, this.f7749b);
        int readInt = this.f7750c.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            int a11 = k.a(this.f7750c);
            k.a(this.f7748a, this.f7750c.readInt(), a11, this.f7749b);
            h();
        }
    }

    private void h() {
        this.f7750c.a();
        this.f7750c.b();
        byte readByte = this.f7750c.readByte();
        int a10 = k.a(this.f7750c);
        int readInt = this.f7750c.readInt();
        if (readByte == 1) {
            k.a(this.f7748a, readInt, a10, this.f7749b);
        }
        if (readByte == 2) {
            k.a(this.f7748a, readInt, a10, this.f7749b);
        }
    }

    private void i() {
        int readInt = this.f7750c.readInt();
        int i10 = 28;
        if (readInt < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.f7750c.readShort();
        this.f7750c.readShort();
        this.f7750c.readByte();
        this.f7750c.readByte();
        this.f7750c.readByte();
        this.f7750c.readByte();
        this.f7750c.readByte();
        this.f7750c.readByte();
        this.f7750c.readUnsignedShort();
        this.f7750c.readByte();
        this.f7750c.readByte();
        this.f7750c.readByte();
        this.f7750c.skipBytes(1);
        this.f7750c.readShort();
        this.f7750c.readShort();
        this.f7750c.readShort();
        this.f7750c.skipBytes(2);
        if (readInt >= 32) {
            this.f7750c.readByte();
            this.f7750c.readByte();
            this.f7750c.readShort();
            i10 = 32;
        }
        if (readInt >= 36) {
            this.f7750c.readShort();
            this.f7750c.readShort();
            i10 = 36;
        }
        if (readInt >= 48) {
            a(4).toCharArray();
            a(8).toCharArray();
            i10 = 48;
        }
        if (readInt >= 52) {
            this.f7750c.readByte();
            this.f7750c.readByte();
            this.f7750c.skipBytes(2);
            i10 = 52;
        }
        if (readInt >= 56) {
            this.f7750c.skipBytes(4);
            i10 = 56;
        }
        int i11 = readInt - 56;
        if (i11 > 0) {
            byte[] bArr = new byte[i11];
            i10 += i11;
            this.f7750c.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                f7747f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f7747f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(readInt), bigInteger));
            }
        }
        int i12 = readInt - i10;
        if (i12 > 0) {
            this.f7750c.skipBytes(i12);
        }
    }

    private C0234a j() {
        C0234a a10 = C0234a.a(this.f7750c, this.f7751d);
        this.f7752e = a10;
        return a10;
    }

    public final void a() {
        j();
        b(2);
        int readInt = this.f7750c.readInt();
        l.a(this.f7750c);
        j();
        for (int i10 = 0; i10 < readInt; i10++) {
            b(512);
            this.f7750c.readInt();
            this.f7750c.skipBytes(256);
            this.f7750c.skipBytes(4);
            this.f7750c.skipBytes(4);
            this.f7750c.skipBytes(4);
            this.f7750c.skipBytes(4);
            if (this.f7752e.f7754b == 288 && this.f7750c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f7750c);
            l.a(this.f7750c);
            j();
            boolean z10 = true;
            while (z10) {
                short s10 = this.f7752e.f7753a;
                if (s10 == 514) {
                    c();
                } else if (s10 != 515) {
                    z10 = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i10) {
        if (this.f7752e.f7753a != i10) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i10), Short.valueOf(this.f7752e.f7753a)));
        }
    }
}
