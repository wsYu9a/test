package com.nostra13.universalimageloader.core.assist;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class a extends InputStream {

    /* renamed from: a */
    private final InputStream f15915a;

    /* renamed from: b */
    private final int f15916b;

    public a(InputStream inputStream, int i2) {
        this.f15915a = inputStream;
        this.f15916b = i2;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f15916b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f15915a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f15915a.mark(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f15915a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f15915a.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f15915a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j2) throws IOException {
        return this.f15915a.skip(j2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f15915a.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.f15915a.read(bArr, i2, i3);
    }
}
