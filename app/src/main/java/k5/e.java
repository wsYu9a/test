package k5;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

@p
@a5.c
/* loaded from: classes2.dex */
public abstract class e {

    public final class b extends i {

        /* renamed from: a */
        public final Charset f27632a;

        public /* synthetic */ b(e eVar, Charset charset, a aVar) {
            this(charset);
        }

        @Override // k5.i
        public Writer b() throws IOException {
            return new OutputStreamWriter(e.this.c(), this.f27632a);
        }

        public String toString() {
            String obj = e.this.toString();
            String valueOf = String.valueOf(this.f27632a);
            StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 13 + valueOf.length());
            sb2.append(obj);
            sb2.append(".asCharSink(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        public b(Charset charset) {
            this.f27632a = (Charset) b5.u.E(charset);
        }
    }

    public i a(Charset charset) {
        return new b(charset);
    }

    public OutputStream b() throws IOException {
        OutputStream c10 = c();
        return c10 instanceof BufferedOutputStream ? (BufferedOutputStream) c10 : new BufferedOutputStream(c10);
    }

    public abstract OutputStream c() throws IOException;

    public void d(byte[] bArr) throws IOException {
        b5.u.E(bArr);
        try {
            OutputStream outputStream = (OutputStream) m.a().b(c());
            outputStream.write(bArr);
            outputStream.flush();
        } finally {
        }
    }

    @CanIgnoreReturnValue
    public long e(InputStream inputStream) throws IOException {
        b5.u.E(inputStream);
        try {
            OutputStream outputStream = (OutputStream) m.a().b(c());
            long b10 = g.b(inputStream, outputStream);
            outputStream.flush();
            return b10;
        } finally {
        }
    }
}
