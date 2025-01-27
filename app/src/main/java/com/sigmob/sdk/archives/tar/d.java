package com.sigmob.sdk.archives.tar;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {

    /* renamed from: i */
    public static final int f17547i = 512;

    /* renamed from: j */
    public static final int f17548j = 10240;

    /* renamed from: a */
    public InputStream f17549a;

    /* renamed from: b */
    public OutputStream f17550b;

    /* renamed from: c */
    public byte[] f17551c;

    /* renamed from: d */
    public int f17552d;

    /* renamed from: e */
    public int f17553e;

    /* renamed from: f */
    public int f17554f;

    /* renamed from: g */
    public int f17555g;

    /* renamed from: h */
    public int f17556h;

    public d(InputStream inputStream) {
        this(inputStream, f17548j);
    }

    public void a() throws IOException {
        if (this.f17550b == null) {
            InputStream inputStream = this.f17549a;
            if (inputStream != null) {
                if (inputStream != System.in) {
                    inputStream.close();
                }
                this.f17549a = null;
                return;
            }
            return;
        }
        b();
        OutputStream outputStream = this.f17550b;
        if (outputStream == System.out || outputStream == System.err) {
            return;
        }
        outputStream.close();
        this.f17550b = null;
    }

    public void b() throws IOException {
        if (this.f17550b == null) {
            throw new IOException("writing to an input buffer");
        }
        if (this.f17553e > 0) {
            j();
        }
    }

    public int c() {
        return this.f17554f;
    }

    public int d() {
        return this.f17552d;
    }

    public int e() {
        return this.f17553e - 1;
    }

    public int f() {
        return this.f17555g;
    }

    public final boolean g() throws IOException {
        if (this.f17549a == null) {
            throw new IOException("reading from an output buffer");
        }
        this.f17553e = 0;
        int i10 = this.f17554f;
        int i11 = 0;
        while (true) {
            if (i10 <= 0) {
                break;
            }
            long read = this.f17549a.read(this.f17551c, i11, i10);
            if (read != -1) {
                i11 = (int) (i11 + read);
                i10 = (int) (i10 - read);
            } else {
                if (i11 == 0) {
                    return false;
                }
                Arrays.fill(this.f17551c, i11, i10 + i11, (byte) 0);
            }
        }
        this.f17552d++;
        return true;
    }

    public byte[] h() throws IOException {
        if (this.f17549a == null) {
            if (this.f17550b == null) {
                throw new IOException("input buffer is closed");
            }
            throw new IOException("reading from an output buffer");
        }
        if (this.f17553e >= this.f17556h && !g()) {
            return null;
        }
        int i10 = this.f17555g;
        byte[] bArr = new byte[i10];
        System.arraycopy(this.f17551c, this.f17553e * i10, bArr, 0, i10);
        this.f17553e++;
        return bArr;
    }

    public void i() throws IOException {
        if (this.f17549a == null) {
            throw new IOException("reading (via skip) from an output buffer");
        }
        if (this.f17553e < this.f17556h || g()) {
            this.f17553e++;
        }
    }

    public final void j() throws IOException {
        OutputStream outputStream = this.f17550b;
        if (outputStream == null) {
            throw new IOException("writing to an input buffer");
        }
        outputStream.write(this.f17551c, 0, this.f17554f);
        this.f17550b.flush();
        this.f17553e = 0;
        this.f17552d++;
        Arrays.fill(this.f17551c, (byte) 0);
    }

    public d(InputStream inputStream, int i10) {
        this(inputStream, i10, 512);
    }

    public final void a(int i10, int i11) {
        this.f17554f = i10;
        this.f17555g = i11;
        int i12 = i10 / i11;
        this.f17556h = i12;
        this.f17551c = new byte[i10];
        if (this.f17549a != null) {
            this.f17552d = -1;
            this.f17553e = i12;
        } else {
            this.f17552d = 0;
            this.f17553e = 0;
        }
    }

    public void b(byte[] bArr) throws IOException {
        if (this.f17550b == null) {
            if (this.f17549a != null) {
                throw new IOException("writing to an input buffer");
            }
            throw new IOException("Output buffer is closed");
        }
        if (bArr.length != this.f17555g) {
            throw new IOException("record to write has length '" + bArr.length + "' which is not the record size of '" + this.f17555g + "'");
        }
        if (this.f17553e >= this.f17556h) {
            j();
        }
        byte[] bArr2 = this.f17551c;
        int i10 = this.f17553e;
        int i11 = this.f17555g;
        System.arraycopy(bArr, 0, bArr2, i10 * i11, i11);
        this.f17553e++;
    }

    public d(InputStream inputStream, int i10, int i11) {
        this.f17549a = inputStream;
        this.f17550b = null;
        a(i10, i11);
    }

    public boolean a(byte[] bArr) {
        int f10 = f();
        for (int i10 = 0; i10 < f10; i10++) {
            if (bArr[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public d(OutputStream outputStream) {
        this(outputStream, f17548j);
    }

    public void a(byte[] bArr, int i10) throws IOException {
        if (this.f17550b == null) {
            if (this.f17549a != null) {
                throw new IOException("writing to an input buffer");
            }
            throw new IOException("Output buffer is closed");
        }
        if (this.f17555g + i10 <= bArr.length) {
            if (this.f17553e >= this.f17556h) {
                j();
            }
            byte[] bArr2 = this.f17551c;
            int i11 = this.f17553e;
            int i12 = this.f17555g;
            System.arraycopy(bArr, i10, bArr2, i11 * i12, i12);
            this.f17553e++;
            return;
        }
        throw new IOException("record has length '" + bArr.length + "' with offset '" + i10 + "' which is less than the record size of '" + this.f17555g + "'");
    }

    public d(OutputStream outputStream, int i10) {
        this(outputStream, i10, 512);
    }

    public d(OutputStream outputStream, int i10, int i11) {
        this.f17549a = null;
        this.f17550b = outputStream;
        a(i10, i11);
    }
}
