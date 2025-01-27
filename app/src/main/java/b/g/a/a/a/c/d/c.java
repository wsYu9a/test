package b.g.a.a.a.c.d;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes4.dex */
class c implements Closeable {

    /* renamed from: a */
    private static final byte f4878a = 13;

    /* renamed from: b */
    private static final byte f4879b = 10;

    /* renamed from: c */
    private final InputStream f4880c;

    /* renamed from: d */
    private final Charset f4881d;

    /* renamed from: e */
    private byte[] f4882e;

    /* renamed from: f */
    private int f4883f;

    /* renamed from: g */
    private int f4884g;

    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, c.this.f4881d.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f4880c;
        byte[] bArr = this.f4882e;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f4883f = 0;
        this.f4884g = read;
    }

    public String c() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f4880c) {
            if (this.f4882e == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f4883f >= this.f4884g) {
                b();
            }
            for (int i4 = this.f4883f; i4 != this.f4884g; i4++) {
                byte[] bArr2 = this.f4882e;
                if (bArr2[i4] == 10) {
                    if (i4 != this.f4883f) {
                        i3 = i4 - 1;
                        if (bArr2[i3] == 13) {
                            byte[] bArr3 = this.f4882e;
                            int i5 = this.f4883f;
                            String str = new String(bArr3, i5, i3 - i5, this.f4881d.name());
                            this.f4883f = i4 + 1;
                            return str;
                        }
                    }
                    i3 = i4;
                    byte[] bArr32 = this.f4882e;
                    int i52 = this.f4883f;
                    String str2 = new String(bArr32, i52, i3 - i52, this.f4881d.name());
                    this.f4883f = i4 + 1;
                    return str2;
                }
            }
            a aVar = new a((this.f4884g - this.f4883f) + 80);
            loop1: while (true) {
                byte[] bArr4 = this.f4882e;
                int i6 = this.f4883f;
                aVar.write(bArr4, i6, this.f4884g - i6);
                this.f4884g = -1;
                b();
                i2 = this.f4883f;
                while (i2 != this.f4884g) {
                    bArr = this.f4882e;
                    if (bArr[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            int i7 = this.f4883f;
            if (i2 != i7) {
                aVar.write(bArr, i7, i2 - i7);
            }
            this.f4883f = i2 + 1;
            return aVar.toString();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f4880c) {
            if (this.f4882e != null) {
                this.f4882e = null;
                this.f4880c.close();
            }
        }
    }

    public c(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(d.f4886a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f4880c = inputStream;
        this.f4881d = charset;
        this.f4882e = new byte[i2];
    }
}
