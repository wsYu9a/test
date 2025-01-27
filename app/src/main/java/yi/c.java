package yi;

import java.io.IOException;
import java.io.InputStream;
import org.mozilla.universalchardet.UniversalDetector;

/* loaded from: classes4.dex */
public class c extends InputStream {

    /* renamed from: b */
    public InputStream f33530b;

    /* renamed from: c */
    public final UniversalDetector f33531c = new UniversalDetector(null);

    public c(InputStream inputStream) {
        this.f33530b = inputStream;
    }

    public String a() {
        return this.f33531c.g();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f33530b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f33530b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f33530b.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f33530b.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) >= 0) {
            return bArr[0];
        }
        return -1;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f33530b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        if (this.f33531c.k()) {
            return this.f33530b.skip(j10);
        }
        int i10 = 0;
        long j11 = -1;
        for (long j12 = 0; j12 < j10 && i10 >= 0; j12++) {
            i10 = this.f33530b.read();
            j11++;
        }
        return j11;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = this.f33530b.read(bArr, i10, i11);
        if (!this.f33531c.k() && read > 0) {
            this.f33531c.j(bArr, i10, read);
        }
        if (read == -1) {
            this.f33531c.a();
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }
}
