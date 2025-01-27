package k5;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;
import javax.annotation.CheckForNull;

@p
@a5.c
/* loaded from: classes2.dex */
public final class h extends Reader {

    /* renamed from: b */
    @CheckForNull
    public CharSequence f27654b;

    /* renamed from: c */
    public int f27655c;

    /* renamed from: d */
    public int f27656d;

    public h(CharSequence charSequence) {
        this.f27654b = (CharSequence) b5.u.E(charSequence);
    }

    public final void a() throws IOException {
        if (this.f27654b == null) {
            throw new IOException("reader closed");
        }
    }

    public final boolean b() {
        return c() > 0;
    }

    public final int c() {
        Objects.requireNonNull(this.f27654b);
        return this.f27654b.length() - this.f27655c;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f27654b = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i10) throws IOException {
        b5.u.k(i10 >= 0, "readAheadLimit (%s) may not be negative", i10);
        a();
        this.f27656d = this.f27655c;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) throws IOException {
        b5.u.E(charBuffer);
        a();
        Objects.requireNonNull(this.f27654b);
        if (!b()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), c());
        for (int i10 = 0; i10 < min; i10++) {
            CharSequence charSequence = this.f27654b;
            int i11 = this.f27655c;
            this.f27655c = i11 + 1;
            charBuffer.put(charSequence.charAt(i11));
        }
        return min;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        a();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        a();
        this.f27655c = this.f27656d;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j10) throws IOException {
        int min;
        b5.u.p(j10 >= 0, "n (%s) may not be negative", j10);
        a();
        min = (int) Math.min(c(), j10);
        this.f27655c += min;
        return min;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        char c10;
        a();
        Objects.requireNonNull(this.f27654b);
        if (b()) {
            CharSequence charSequence = this.f27654b;
            int i10 = this.f27655c;
            this.f27655c = i10 + 1;
            c10 = charSequence.charAt(i10);
        } else {
            c10 = 65535;
        }
        return c10;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i10, int i11) throws IOException {
        b5.u.f0(i10, i10 + i11, cArr.length);
        a();
        Objects.requireNonNull(this.f27654b);
        if (!b()) {
            return -1;
        }
        int min = Math.min(i11, c());
        for (int i12 = 0; i12 < min; i12++) {
            CharSequence charSequence = this.f27654b;
            int i13 = this.f27655c;
            this.f27655c = i13 + 1;
            cArr[i10 + i12] = charSequence.charAt(i13);
        }
        return min;
    }
}
