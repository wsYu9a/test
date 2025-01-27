package i5;

import com.google.common.hash.HashCode;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@a5.a
@h
/* loaded from: classes2.dex */
public final class o extends FilterOutputStream {

    /* renamed from: b */
    public final m f26907b;

    public o(k kVar, OutputStream outputStream) {
        super((OutputStream) b5.u.E(outputStream));
        this.f26907b = (m) b5.u.E(kVar.newHasher());
    }

    public HashCode a() {
        return this.f26907b.i();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        this.f26907b.c((byte) i10);
        ((FilterOutputStream) this).out.write(i10);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f26907b.e(bArr, i10, i11);
        ((FilterOutputStream) this).out.write(bArr, i10, i11);
    }
}
