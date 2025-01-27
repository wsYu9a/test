package k5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@p
@a5.c
/* loaded from: classes2.dex */
public final class y extends InputStream {

    /* renamed from: b */
    public Iterator<? extends f> f27696b;

    /* renamed from: c */
    @CheckForNull
    public InputStream f27697c;

    public y(Iterator<? extends f> it) throws IOException {
        this.f27696b = (Iterator) b5.u.E(it);
        a();
    }

    public final void a() throws IOException {
        close();
        if (this.f27696b.hasNext()) {
            this.f27697c = this.f27696b.next().m();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f27697c;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f27697c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f27697c = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f27697c;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            a();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        InputStream inputStream = this.f27697c;
        if (inputStream == null || j10 <= 0) {
            return 0L;
        }
        long skip = inputStream.skip(j10);
        if (skip != 0) {
            return skip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f27697c.skip(j10 - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        b5.u.E(bArr);
        while (true) {
            InputStream inputStream = this.f27697c;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read(bArr, i10, i11);
            if (read != -1) {
                return read;
            }
            a();
        }
    }
}
