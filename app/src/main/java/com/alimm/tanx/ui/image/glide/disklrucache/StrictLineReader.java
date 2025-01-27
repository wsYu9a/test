package com.alimm.tanx.ui.image.glide.disklrucache;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
class StrictLineReader implements Closeable {
    private static final byte CR = 13;
    private static final byte LF = 10;
    private byte[] buf;
    private final Charset charset;
    private int end;
    private final InputStream in;
    private int pos;

    /* renamed from: com.alimm.tanx.ui.image.glide.disklrucache.StrictLineReader$1 */
    public class AnonymousClass1 extends ByteArrayOutputStream {
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0) {
                int i11 = i10 - 1;
                if (((ByteArrayOutputStream) this).buf[i11] == 13) {
                    i10 = i11;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, StrictLineReader.this.charset.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void fillBuf() throws IOException {
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
    public void close() throws IOException {
        synchronized (this.in) {
            try {
                if (this.buf != null) {
                    this.buf = null;
                    this.in.close();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean hasUnterminatedLine() {
        return this.end == -1;
    }

    public String readLine() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.in) {
            try {
                if (this.buf == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.pos >= this.end) {
                    fillBuf();
                }
                for (int i12 = this.pos; i12 != this.end; i12++) {
                    byte[] bArr2 = this.buf;
                    if (bArr2[i12] == 10) {
                        int i13 = this.pos;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.charset.name());
                                this.pos = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.charset.name());
                        this.pos = i12 + 1;
                        return str2;
                    }
                }
                AnonymousClass1 anonymousClass1 = new ByteArrayOutputStream((this.end - this.pos) + 80) { // from class: com.alimm.tanx.ui.image.glide.disklrucache.StrictLineReader.1
                    public AnonymousClass1(int i102) {
                        super(i102);
                    }

                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i102 = ((ByteArrayOutputStream) this).count;
                        if (i102 > 0) {
                            int i112 = i102 - 1;
                            if (((ByteArrayOutputStream) this).buf[i112] == 13) {
                                i102 = i112;
                            }
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i102, StrictLineReader.this.charset.name());
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
                    fillBuf();
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

    public StrictLineReader(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(Util.US_ASCII)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.in = inputStream;
        this.charset = charset;
        this.buf = new byte[i10];
    }
}
