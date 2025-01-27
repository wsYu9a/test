package i5;

import com.google.common.hash.HashCode;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@a5.a
@h
/* loaded from: classes2.dex */
public final class n extends FilterInputStream {

    /* renamed from: b */
    public final m f26906b;

    public n(k kVar, InputStream inputStream) {
        super((InputStream) b5.u.E(inputStream));
        this.f26906b = (m) b5.u.E(kVar.newHasher());
    }

    public HashCode a() {
        return this.f26906b.i();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @CanIgnoreReturnValue
    public int read() throws IOException {
        int read = ((FilterInputStream) this).in.read();
        if (read != -1) {
            this.f26906b.c((byte) read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @CanIgnoreReturnValue
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int read = ((FilterInputStream) this).in.read(bArr, i10, i11);
        if (read != -1) {
            this.f26906b.e(bArr, i10, read);
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
    }
}
