package ve;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class c implements Closeable {

    /* renamed from: g */
    public static final byte f31519g = 13;

    /* renamed from: h */
    public static final byte f31520h = 10;

    /* renamed from: b */
    public final InputStream f31521b;

    /* renamed from: c */
    public final Charset f31522c;

    /* renamed from: d */
    public byte[] f31523d;

    /* renamed from: e */
    public int f31524e;

    /* renamed from: f */
    public int f31525f;

    public class a extends ByteArrayOutputStream {
        public a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, c.this.f31522c.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public final void b() throws IOException {
        InputStream inputStream = this.f31521b;
        byte[] bArr = this.f31523d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f31524e = 0;
        this.f31525f = read;
    }

    public String c() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f31521b) {
            try {
                if (this.f31523d == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.f31524e >= this.f31525f) {
                    b();
                }
                for (int i12 = this.f31524e; i12 != this.f31525f; i12++) {
                    byte[] bArr2 = this.f31523d;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f31524e;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f31522c.name());
                                this.f31524e = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f31522c.name());
                        this.f31524e = i12 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f31525f - this.f31524e) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f31523d;
                    int i14 = this.f31524e;
                    aVar.write(bArr3, i14, this.f31525f - i14);
                    this.f31525f = -1;
                    b();
                    i10 = this.f31524e;
                    while (i10 != this.f31525f) {
                        bArr = this.f31523d;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f31524e;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f31524e = i10 + 1;
                return aVar.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f31521b) {
            try {
                if (this.f31523d != null) {
                    this.f31523d = null;
                    this.f31521b.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public c(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(d.f31527a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f31521b = inputStream;
        this.f31522c = charset;
        this.f31523d = new byte[i10];
    }
}
