package com.vivo.mobilead.h;

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
    private final InputStream f28878a;

    /* renamed from: b */
    private final Charset f28879b;

    /* renamed from: c */
    private byte[] f28880c;

    /* renamed from: d */
    private int f28881d;

    /* renamed from: e */
    private int f28882e;

    class a extends ByteArrayOutputStream {
        a(int i2) {
            super(i2);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i2 = ((ByteArrayOutputStream) this).count;
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (((ByteArrayOutputStream) this).buf[i3] == 13) {
                    i2 = i3;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i2, c.this.f28879b.name());
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    public c(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void c() throws IOException {
        InputStream inputStream = this.f28878a;
        byte[] bArr = this.f28880c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f28881d = 0;
        this.f28882e = read;
    }

    public String b() throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        synchronized (this.f28878a) {
            if (this.f28880c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f28881d >= this.f28882e) {
                c();
            }
            for (int i4 = this.f28881d; i4 != this.f28882e; i4++) {
                byte[] bArr2 = this.f28880c;
                if (bArr2[i4] == 10) {
                    if (i4 != this.f28881d) {
                        i3 = i4 - 1;
                        if (bArr2[i3] == 13) {
                            byte[] bArr3 = this.f28880c;
                            int i5 = this.f28881d;
                            String str = new String(bArr3, i5, i3 - i5, this.f28879b.name());
                            this.f28881d = i4 + 1;
                            return str;
                        }
                    }
                    i3 = i4;
                    byte[] bArr32 = this.f28880c;
                    int i52 = this.f28881d;
                    String str2 = new String(bArr32, i52, i3 - i52, this.f28879b.name());
                    this.f28881d = i4 + 1;
                    return str2;
                }
            }
            a aVar = new a((this.f28882e - this.f28881d) + 80);
            loop1: while (true) {
                byte[] bArr4 = this.f28880c;
                int i6 = this.f28881d;
                aVar.write(bArr4, i6, this.f28882e - i6);
                this.f28882e = -1;
                c();
                i2 = this.f28881d;
                while (i2 != this.f28882e) {
                    bArr = this.f28880c;
                    if (bArr[i2] == 10) {
                        break loop1;
                    }
                    i2++;
                }
            }
            int i7 = this.f28881d;
            if (i2 != i7) {
                aVar.write(bArr, i7, i2 - i7);
            }
            this.f28881d = i2 + 1;
            return aVar.toString();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f28878a) {
            if (this.f28880c != null) {
                this.f28880c = null;
                this.f28878a.close();
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
        if (!charset.equals(d.f28884a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f28878a = inputStream;
        this.f28879b = charset;
        this.f28880c = new byte[i2];
    }

    public boolean a() {
        return this.f28882e == -1;
    }
}
