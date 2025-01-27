package com.kwad.sdk.core.diskcache.kwai;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class b implements Closeable {
    private final Charset aeP;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    /* renamed from: com.kwad.sdk.core.diskcache.kwai.b$1 */
    final class AnonymousClass1 extends ByteArrayOutputStream {
        AnonymousClass1(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0 && ((ByteArrayOutputStream) this).buf[i2 - 1] == 13) {
                i2--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, b.this.aeP.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    private b(InputStream inputStream, int i2, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(com.kwad.sdk.crash.utils.a.US_ASCII)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.in = inputStream;
        this.aeP = charset;
        this.buf = new byte[8192];
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void vr() {
        InputStream inputStream = this.in;
        byte[] bArr = this.buf;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.pos = 0;
        this.end = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.in) {
            if (this.buf != null) {
                this.buf = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(this.in);
            }
        }
    }

    public final String readLine() {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.in) {
            if (this.buf == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.pos >= this.end) {
                vr();
            }
            for (int i4 = this.pos; i4 != this.end; i4++) {
                byte[] bArr2 = this.buf;
                if (bArr2[i4] == 10) {
                    if (i4 != this.pos) {
                        i3 = i4 - 1;
                        if (bArr2[i3] == 13) {
                            byte[] bArr3 = this.buf;
                            int i5 = this.pos;
                            String str = new String(bArr3, i5, i3 - i5, this.aeP.name());
                            this.pos = i4 + 1;
                            return str;
                        }
                    }
                    i3 = i4;
                    byte[] bArr32 = this.buf;
                    int i52 = this.pos;
                    String str2 = new String(bArr32, i52, i3 - i52, this.aeP.name());
                    this.pos = i4 + 1;
                    return str2;
                }
            }
            AnonymousClass1 anonymousClass1 = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.kwai.b.1
                AnonymousClass1(int i22) {
                    super(i22);
                }

                @Override // java.io.ByteArrayOutputStream
                public final String toString() {
                    int i22 = ((ByteArrayOutputStream) this).count;
                    if (i22 > 0 && ((ByteArrayOutputStream) this).buf[i22 - 1] == 13) {
                        i22--;
                    }
                    try {
                        return new String(((ByteArrayOutputStream) this).buf, 0, i22, b.this.aeP.name());
                    } catch (UnsupportedEncodingException e2) {
                        throw new AssertionError(e2);
                    }
                }
            };
            loop1: while (true) {
                byte[] bArr4 = this.buf;
                int i6 = this.pos;
                anonymousClass1.write(bArr4, i6, this.end - i6);
                this.end = -1;
                vr();
                i2 = this.pos;
                while (i2 != this.end) {
                    bArr = this.buf;
                    if (bArr[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            int i7 = this.pos;
            if (i2 != i7) {
                anonymousClass1.write(bArr, i7, i2 - i7);
            }
            this.pos = i2 + 1;
            return anonymousClass1.toString();
        }
    }
}
