package yi;

import java.io.IOException;
import java.io.OutputStream;
import org.mozilla.universalchardet.UniversalDetector;

/* loaded from: classes4.dex */
public class d extends OutputStream {

    /* renamed from: b */
    public OutputStream f33532b;

    /* renamed from: c */
    public final UniversalDetector f33533c = new UniversalDetector(null);

    public d(OutputStream outputStream) {
        this.f33532b = outputStream;
    }

    public String a() {
        return this.f33533c.g();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f33532b.close();
        this.f33533c.a();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.f33532b.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.f33532b.write(bArr, i10, i11);
        if (this.f33533c.k()) {
            return;
        }
        this.f33533c.j(bArr, i10, i11);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        write(new byte[]{(byte) i10});
    }
}
