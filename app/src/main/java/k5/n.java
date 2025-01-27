package k5;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@p
@a5.a
@a5.c
/* loaded from: classes2.dex */
public final class n extends FilterInputStream {

    /* renamed from: b */
    public long f27674b;

    /* renamed from: c */
    public long f27675c;

    public n(InputStream inputStream) {
        super((InputStream) b5.u.E(inputStream));
        this.f27675c = -1L;
    }

    public long a() {
        return this.f27674b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        ((FilterInputStream) this).in.mark(i10);
        this.f27675c = this.f27674b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f27674b++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f27675c == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f27674b = this.f27675c;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long skip = ((FilterInputStream) this).in.skip(j10);
        this.f27674b += skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (read != -1) {
            this.f27674b += read;
        }
        return read;
    }
}
