package k5;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@p
@a5.c
/* loaded from: classes2.dex */
public final class o extends FilterOutputStream {

    /* renamed from: b */
    public long f27676b;

    public o(OutputStream outputStream) {
        super((OutputStream) b5.u.E(outputStream));
    }

    public long a() {
        return this.f27676b;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        ((FilterOutputStream) this).out.write(bArr, i10, i11);
        this.f27676b += i11;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i10) throws IOException {
        ((FilterOutputStream) this).out.write(i10);
        this.f27676b++;
    }
}
