package com.sigmob.sdk.archives.utils;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class b extends FilterInputStream {

    /* renamed from: a */
    public long f17583a;

    public b(InputStream inputStream) {
        super(inputStream);
    }

    public final void a(long j10) {
        if (j10 != -1) {
            this.f17583a += j10;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read >= 0) {
            a(1L);
        }
        return read;
    }

    public long a() {
        return this.f17583a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (read >= 0) {
            a(read);
        }
        return read;
    }
}
