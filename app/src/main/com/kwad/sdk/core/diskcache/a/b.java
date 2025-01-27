package com.kwad.sdk.core.diskcache.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class b implements Closeable {
    private final Charset ayc;
    private byte[] buf;
    private int end;
    private final InputStream in;
    private int pos;

    /* renamed from: com.kwad.sdk.core.diskcache.a.b$1 */
    public class AnonymousClass1 extends ByteArrayOutputStream {
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public final String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, b.this.ayc.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void EF() {
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
            try {
                if (this.buf != null) {
                    this.buf = null;
                    com.kwad.sdk.crash.utils.b.closeQuietly(this.in);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final String readLine() {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.in) {
            try {
                if (this.buf == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.pos >= this.end) {
                    EF();
                }
                for (int i12 = this.pos; i12 != this.end; i12++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i12] == 10) {
                        int i13 = this.pos;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.ayc.name());
                                this.pos = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.ayc.name());
                        this.pos = i12 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 anonymousClass1 = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.kwad.sdk.core.diskcache.a.b.1
                    public AnonymousClass1(int i102) {
                        super(i102);
                    }

                    @Override // java.io.ByteArrayOutputStream
                    public final String toString() {
                        int i102 = ((ByteArrayOutputStream) this).count;
                        if (i102 > 0 && ((ByteArrayOutputStream) this).buf[i102 - 1] == 13) {
                            i102--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i102, b.this.ayc.name());
                        } catch (UnsupportedEncodingException e10) {
                            throw new AssertionError(e10);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.buf;
                    int i14 = this.pos;
                    anonymousClass1.write(bArr3, i14, this.end - i14);
                    this.end = -1;
                    EF();
                    i10 = this.pos;
                    while (i10 != this.end) {
                        bArr = this.buf;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.pos;
                if (i10 != i15) {
                    anonymousClass1.write(bArr, i15, i10 - i15);
                }
                this.pos = i10 + 1;
                return anonymousClass1.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private b(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(com.kwad.sdk.crash.utils.a.US_ASCII)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.in = inputStream;
        this.ayc = charset;
        this.buf = new byte[8192];
    }
}
