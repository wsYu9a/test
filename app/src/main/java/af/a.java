package af;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class a extends InputStream {

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f164b;

    /* renamed from: c, reason: collision with root package name */
    public final int f165c;

    public a(InputStream inputStream, int i10) {
        this.f164b = inputStream;
        this.f165c = i10;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f165c;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f164b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f164b.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f164b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f164b.read();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f164b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        return this.f164b.skip(j10);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return this.f164b.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return this.f164b.read(bArr, i10, i11);
    }
}
