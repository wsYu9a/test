package b.g.a.a.a.c.d;

import android.graphics.Bitmap;
import b.g.a.a.a.c.d.a;
import b.g.a.b.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class b implements b.g.a.a.a.b {

    /* renamed from: a */
    public static final int f4868a = 32768;

    /* renamed from: b */
    public static final Bitmap.CompressFormat f4869b = Bitmap.CompressFormat.PNG;

    /* renamed from: c */
    public static final int f4870c = 100;

    /* renamed from: d */
    private static final String f4871d = " argument must be not null";

    /* renamed from: e */
    private static final String f4872e = " argument must be positive number";

    /* renamed from: f */
    protected a f4873f;

    /* renamed from: g */
    private File f4874g;

    /* renamed from: h */
    protected final b.g.a.a.a.d.a f4875h;

    /* renamed from: i */
    protected int f4876i;

    /* renamed from: j */
    protected Bitmap.CompressFormat f4877j;
    protected int k;

    public b(File file, b.g.a.a.a.d.a aVar, long j2) throws IOException {
        this(file, null, aVar, j2, 0);
    }

    private String b(String str) {
        return this.f4875h.generate(str);
    }

    private void c(File file, File file2, long j2, int i2) throws IOException {
        try {
            this.f4873f = a.y(file, 1, 1, j2, i2);
        } catch (IOException e2) {
            b.g.a.b.d.d(e2);
            if (file2 != null) {
                c(file2, null, j2, i2);
            }
            if (this.f4873f == null) {
                throw e2;
            }
        }
    }

    @Override // b.g.a.a.a.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        a.c p = this.f4873f.p(b(str));
        if (p == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(p.i(0), this.f4876i);
        try {
            boolean c2 = b.g.a.b.c.c(inputStream, bufferedOutputStream, aVar, this.f4876i);
            b.g.a.b.c.a(bufferedOutputStream);
            if (c2) {
                p.f();
            } else {
                p.a();
            }
            return c2;
        } catch (Throwable th) {
            b.g.a.b.c.a(bufferedOutputStream);
            p.a();
            throw th;
        }
    }

    @Override // b.g.a.a.a.a
    public void clear() {
        try {
            this.f4873f.delete();
        } catch (IOException e2) {
            b.g.a.b.d.d(e2);
        }
        try {
            c(this.f4873f.t(), this.f4874g, this.f4873f.v(), this.f4873f.u());
        } catch (IOException e3) {
            b.g.a.b.d.d(e3);
        }
    }

    @Override // b.g.a.a.a.a
    public void close() {
        try {
            this.f4873f.close();
        } catch (IOException e2) {
            b.g.a.b.d.d(e2);
        }
        this.f4873f = null;
    }

    public void d(int i2) {
        this.f4876i = i2;
    }

    public void e(Bitmap.CompressFormat compressFormat) {
        this.f4877j = compressFormat;
    }

    public void f(int i2) {
        this.k = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    @Override // b.g.a.a.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            b.g.a.a.a.c.d.a r1 = r3.f4873f     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            java.lang.String r4 = r3.b(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            b.g.a.a.a.c.d.a$e r4 = r1.s(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            if (r4 != 0) goto Le
            goto L13
        Le:
            r1 = 0
            java.io.File r0 = r4.b(r1)     // Catch: java.io.IOException -> L19 java.lang.Throwable -> L2b
        L13:
            if (r4 == 0) goto L18
            r4.close()
        L18:
            return r0
        L19:
            r1 = move-exception
            goto L22
        L1b:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L2c
        L20:
            r1 = move-exception
            r4 = r0
        L22:
            b.g.a.b.d.d(r1)     // Catch: java.lang.Throwable -> L2b
            if (r4 == 0) goto L2a
            r4.close()
        L2a:
            return r0
        L2b:
            r0 = move-exception
        L2c:
            if (r4 == 0) goto L31
            r4.close()
        L31:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.g.a.a.a.c.d.b.get(java.lang.String):java.io.File");
    }

    @Override // b.g.a.a.a.a
    public File getDirectory() {
        return this.f4873f.t();
    }

    @Override // b.g.a.a.a.a
    public boolean remove(String str) {
        try {
            return this.f4873f.D(b(str));
        } catch (IOException e2) {
            b.g.a.b.d.d(e2);
            return false;
        }
    }

    @Override // b.g.a.a.a.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        a.c p = this.f4873f.p(b(str));
        if (p == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(p.i(0), this.f4876i);
        try {
            boolean compress = bitmap.compress(this.f4877j, this.k, bufferedOutputStream);
            if (compress) {
                p.f();
            } else {
                p.a();
            }
            return compress;
        } finally {
            b.g.a.b.c.a(bufferedOutputStream);
        }
    }

    public b(File file, File file2, b.g.a.a.a.d.a aVar, long j2, int i2) throws IOException {
        this.f4876i = 32768;
        this.f4877j = f4869b;
        this.k = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j3 = j2 == 0 ? Long.MAX_VALUE : j2;
        int i3 = i2 == 0 ? Integer.MAX_VALUE : i2;
        this.f4874g = file2;
        this.f4875h = aVar;
        c(file, file2, j3, i3);
    }
}
