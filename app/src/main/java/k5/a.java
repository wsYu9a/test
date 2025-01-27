package k5;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import javax.annotation.CheckForNull;

@p
@a5.c
/* loaded from: classes2.dex */
public class a extends Writer {

    /* renamed from: b */
    public final Appendable f27619b;

    /* renamed from: c */
    public boolean f27620c;

    public a(Appendable appendable) {
        this.f27619b = (Appendable) b5.u.E(appendable);
    }

    public final void a() throws IOException {
        if (this.f27620c) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27620c = true;
        Appendable appendable = this.f27619b;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        a();
        Appendable appendable = this.f27619b;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) throws IOException {
        a();
        this.f27619b.append(new String(cArr, i10, i11));
    }

    @Override // java.io.Writer
    public void write(int i10) throws IOException {
        a();
        this.f27619b.append((char) i10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c10) throws IOException {
        a();
        this.f27619b.append(c10);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        b5.u.E(str);
        a();
        this.f27619b.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence) throws IOException {
        a();
        this.f27619b.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@CheckForNull CharSequence charSequence, int i10, int i11) throws IOException {
        a();
        this.f27619b.append(charSequence, i10, i11);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i10, int i11) throws IOException {
        b5.u.E(str);
        a();
        this.f27619b.append(str, i10, i11 + i10);
    }
}
