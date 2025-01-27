package k5;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@p
@a5.c
/* loaded from: classes2.dex */
public class z extends Reader {

    /* renamed from: b */
    public final Iterator<? extends j> f27698b;

    /* renamed from: c */
    @CheckForNull
    public Reader f27699c;

    public z(Iterator<? extends j> it) throws IOException {
        this.f27698b = it;
        a();
    }

    public final void a() throws IOException {
        close();
        if (this.f27698b.hasNext()) {
            this.f27699c = this.f27698b.next().m();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.f27699c;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.f27699c = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) throws IOException {
        b5.u.E(cArr);
        Reader reader = this.f27699c;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i10, i11);
        if (read != -1) {
            return read;
        }
        a();
        return read(cArr, i10, i11);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.f27699c;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long j10) throws IOException {
        b5.u.e(j10 >= 0, "n is negative");
        if (j10 > 0) {
            while (true) {
                Reader reader = this.f27699c;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j10);
                if (skip > 0) {
                    return skip;
                }
                a();
            }
        }
        return 0L;
    }
}
