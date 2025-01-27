package com.vivo.secboxsdk.protocol;

import com.vivo.secboxsdk.SecBoxCipherException;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;

/* loaded from: classes4.dex */
public final class b extends a {

    /* renamed from: f */
    private byte[] f31136f;

    /* renamed from: g */
    private byte[] f31137g;

    /* renamed from: h */
    private byte[] f31138h;

    /* renamed from: i */
    private byte[] f31139i;

    /* renamed from: j */
    private byte[] f31140j;

    public b() {
    }

    public final void d(byte[] bArr) {
        this.f31138h = bArr;
    }

    public final void e(byte[] bArr) {
        this.f31139i = bArr;
    }

    public final int f() {
        return 500;
    }

    public final void f(byte[] bArr) {
        this.f31140j = bArr;
    }

    public final void g(byte[] bArr) {
        this.f31136f = bArr;
    }

    public final void h(byte[] bArr) {
        this.f31137g = bArr;
    }

    public b(byte b2) {
        super((byte) 0);
    }

    public final byte[] g() throws SecBoxCipherException {
        boolean z;
        if (c() != null) {
            return c();
        }
        String d2 = d();
        if (d2 != null && d2.length() > 0) {
            int length = d2.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(d2.charAt(i2))) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            throw new SecBoxCipherException("keyToken must have value", -22);
        }
        if (this.f31138h == null) {
            this.f31138h = new byte[0];
        }
        if (this.f31139i == null) {
            this.f31139i = new byte[0];
        }
        if (this.f31140j == null) {
            this.f31140j = new byte[0];
        }
        if (this.f31138h.length >= Integer.MAX_VALUE) {
            throw new SecBoxCipherException("extend1.length cannot >=2147483647", -22);
        }
        if (this.f31139i.length >= Integer.MAX_VALUE) {
            throw new SecBoxCipherException("extend2.length cannot >=2147483647", -22);
        }
        if (this.f31140j.length >= Integer.MAX_VALUE) {
            throw new SecBoxCipherException("extend3.length cannot >=2147483647", -22);
        }
        if (com.vivo.secboxsdk.a.c.a(this.f31136f)) {
            throw new SecBoxCipherException("iv cannot be null", -24);
        }
        if (com.vivo.secboxsdk.a.c.a(this.f31137g)) {
            throw new SecBoxCipherException("encryptKey cannot be null", -25);
        }
        byte[] bytes = d().getBytes();
        int length2 = bytes.length + 16 + 1 + this.f31136f.length + 4 + this.f31137g.length + 4 + this.f31138h.length + 4 + this.f31139i.length + 4 + this.f31140j.length;
        short f2 = (short) f();
        byte b2 = (byte) b();
        short e2 = (short) e();
        ByteBuffer allocate = ByteBuffer.allocate(length2);
        allocate.putShort((short) length2);
        allocate.putLong(0L);
        allocate.putShort(f2);
        allocate.put(b2);
        allocate.putShort(e2);
        allocate.put((byte) bytes.length);
        allocate.put(bytes);
        allocate.put((byte) this.f31136f.length);
        allocate.put(this.f31136f);
        allocate.putInt(this.f31137g.length);
        allocate.put(this.f31137g);
        allocate.putInt(this.f31138h.length);
        byte[] bArr = this.f31138h;
        if (bArr != null && bArr.length > 0) {
            allocate.put(bArr);
        }
        allocate.putInt(this.f31139i.length);
        byte[] bArr2 = this.f31139i;
        if (bArr2 != null && bArr2.length > 0) {
            allocate.put(bArr2);
        }
        allocate.putInt(this.f31140j.length);
        byte[] bArr3 = this.f31140j;
        if (bArr3 != null && bArr3.length > 0) {
            allocate.put(bArr3);
        }
        byte[] array = allocate.array();
        CRC32 crc32 = new CRC32();
        crc32.update(array, 10, array.length - 10);
        allocate.putLong(2, crc32.getValue());
        byte[] array2 = allocate.array();
        a(array2);
        byte[] a2 = a();
        if (a2 != null) {
            byte[] bArr4 = new byte[array2.length + a2.length];
            System.arraycopy(array2, 0, bArr4, 0, array2.length);
            System.arraycopy(a2, 0, bArr4, array2.length, a2.length);
            array2 = bArr4;
        }
        b(array2);
        return array2;
    }
}
