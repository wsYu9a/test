package k5;

import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@p
@a5.a
@a5.c
/* loaded from: classes2.dex */
public final class q extends OutputStream {

    /* renamed from: b */
    public final int f27677b;

    /* renamed from: c */
    public final boolean f27678c;

    /* renamed from: d */
    public final f f27679d;

    /* renamed from: e */
    @CheckForNull
    public final File f27680e;

    /* renamed from: f */
    @GuardedBy("this")
    public OutputStream f27681f;

    /* renamed from: g */
    @CheckForNull
    @GuardedBy("this")
    public c f27682g;

    /* renamed from: h */
    @CheckForNull
    @GuardedBy("this")
    public File f27683h;

    public class a extends f {
        public a() {
        }

        public void finalize() {
            try {
                q.this.e();
            } catch (Throwable th2) {
                th2.printStackTrace(System.err);
            }
        }

        @Override // k5.f
        public InputStream m() throws IOException {
            return q.this.d();
        }
    }

    public class b extends f {
        public b() {
        }

        @Override // k5.f
        public InputStream m() throws IOException {
            return q.this.d();
        }
    }

    public static class c extends ByteArrayOutputStream {
        public c() {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public q(int i10) {
        this(i10, false);
    }

    @GuardedBy("this")
    private void update(int i10) throws IOException {
        c cVar = this.f27682g;
        if (cVar == null || cVar.getCount() + i10 <= this.f27677b) {
            return;
        }
        File createTempFile = File.createTempFile("FileBackedOutputStream", null, this.f27680e);
        if (this.f27678c) {
            createTempFile.deleteOnExit();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(this.f27682g.a(), 0, this.f27682g.getCount());
            fileOutputStream.flush();
            this.f27681f = fileOutputStream;
            this.f27683h = createTempFile;
            this.f27682g = null;
        } catch (IOException e10) {
            createTempFile.delete();
            throw e10;
        }
    }

    public f b() {
        return this.f27679d;
    }

    @CheckForNull
    @a5.d
    public synchronized File c() {
        return this.f27683h;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f27681f.close();
    }

    public final synchronized InputStream d() throws IOException {
        if (this.f27683h != null) {
            return new FileInputStream(this.f27683h);
        }
        Objects.requireNonNull(this.f27682g);
        return new ByteArrayInputStream(this.f27682g.a(), 0, this.f27682g.getCount());
    }

    public synchronized void e() throws IOException {
        try {
            close();
            c cVar = this.f27682g;
            if (cVar == null) {
                this.f27682g = new c(null);
            } else {
                cVar.reset();
            }
            this.f27681f = this.f27682g;
            File file = this.f27683h;
            if (file != null) {
                this.f27683h = null;
                if (!file.delete()) {
                    String valueOf = String.valueOf(file);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                    sb2.append("Could not delete: ");
                    sb2.append(valueOf);
                    throw new IOException(sb2.toString());
                }
            }
        } catch (Throwable th2) {
            if (this.f27682g == null) {
                this.f27682g = new c(null);
            } else {
                this.f27682g.reset();
            }
            this.f27681f = this.f27682g;
            File file2 = this.f27683h;
            if (file2 != null) {
                this.f27683h = null;
                if (!file2.delete()) {
                    String valueOf2 = String.valueOf(file2);
                    StringBuilder sb3 = new StringBuilder(valueOf2.length() + 18);
                    sb3.append("Could not delete: ");
                    sb3.append(valueOf2);
                    throw new IOException(sb3.toString());
                }
            }
            throw th2;
        } finally {
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        this.f27681f.flush();
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i10) throws IOException {
        update(1);
        this.f27681f.write(i10);
    }

    public q(int i10, boolean z10) {
        this(i10, z10, null);
    }

    public q(int i10, boolean z10, @CheckForNull File file) {
        this.f27677b = i10;
        this.f27678c = z10;
        this.f27680e = file;
        c cVar = new c(null);
        this.f27682g = cVar;
        this.f27681f = cVar;
        if (z10) {
            this.f27679d = new a();
        } else {
            this.f27679d = new b();
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i10, int i11) throws IOException {
        update(i11);
        this.f27681f.write(bArr, i10, i11);
    }
}
