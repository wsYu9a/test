package ve;

import android.graphics.Bitmap;
import hf.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import ve.a;

/* loaded from: classes3.dex */
public class b implements te.b {

    /* renamed from: g */
    public static final int f31508g = 32768;

    /* renamed from: h */
    public static final Bitmap.CompressFormat f31509h = Bitmap.CompressFormat.PNG;

    /* renamed from: i */
    public static final int f31510i = 100;

    /* renamed from: j */
    public static final String f31511j = " argument must be not null";

    /* renamed from: k */
    public static final String f31512k = " argument must be positive number";

    /* renamed from: a */
    public a f31513a;

    /* renamed from: b */
    public File f31514b;

    /* renamed from: c */
    public final we.a f31515c;

    /* renamed from: d */
    public int f31516d;

    /* renamed from: e */
    public Bitmap.CompressFormat f31517e;

    /* renamed from: f */
    public int f31518f;

    public b(File file, we.a aVar, long j10) throws IOException {
        this(file, null, aVar, j10, 0);
    }

    @Override // te.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        a.c p10 = this.f31513a.p(b(str));
        if (p10 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(p10.i(0), this.f31516d);
        try {
            boolean c10 = hf.c.c(inputStream, bufferedOutputStream, aVar, this.f31516d);
            hf.c.a(bufferedOutputStream);
            if (c10) {
                p10.f();
            } else {
                p10.a();
            }
            return c10;
        } catch (Throwable th2) {
            hf.c.a(bufferedOutputStream);
            p10.a();
            throw th2;
        }
    }

    public final String b(String str) {
        return this.f31515c.generate(str);
    }

    public final void c(File file, File file2, long j10, int i10) throws IOException {
        try {
            this.f31513a = a.y(file, 1, 1, j10, i10);
        } catch (IOException e10) {
            hf.d.d(e10);
            if (file2 != null) {
                c(file2, null, j10, i10);
            }
            if (this.f31513a == null) {
                throw e10;
            }
        }
    }

    @Override // te.a
    public void clear() {
        try {
            this.f31513a.delete();
        } catch (IOException e10) {
            hf.d.d(e10);
        }
        try {
            c(this.f31513a.t(), this.f31514b, this.f31513a.v(), this.f31513a.u());
        } catch (IOException e11) {
            hf.d.d(e11);
        }
    }

    @Override // te.a
    public void close() {
        try {
            this.f31513a.close();
        } catch (IOException e10) {
            hf.d.d(e10);
        }
        this.f31513a = null;
    }

    public void d(int i10) {
        this.f31516d = i10;
    }

    public void e(Bitmap.CompressFormat compressFormat) {
        this.f31517e = compressFormat;
    }

    public void f(int i10) {
        this.f31518f = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [ve.a$e] */
    @Override // te.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            ve.a r1 = r3.f31513a     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L22
            java.lang.String r4 = r3.b(r4)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L22
            ve.a$e r4 = r1.s(r4)     // Catch: java.lang.Throwable -> L1d java.io.IOException -> L22
            if (r4 != 0) goto Le
            goto L13
        Le:
            r1 = 0
            java.io.File r0 = r4.b(r1)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1b
        L13:
            if (r4 == 0) goto L18
            r4.close()
        L18:
            return r0
        L19:
            r0 = move-exception
            goto L2d
        L1b:
            r1 = move-exception
            goto L24
        L1d:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L2d
        L22:
            r1 = move-exception
            r4 = r0
        L24:
            hf.d.d(r1)     // Catch: java.lang.Throwable -> L19
            if (r4 == 0) goto L2c
            r4.close()
        L2c:
            return r0
        L2d:
            if (r4 == 0) goto L32
            r4.close()
        L32:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ve.b.get(java.lang.String):java.io.File");
    }

    @Override // te.a
    public File getDirectory() {
        return this.f31513a.t();
    }

    @Override // te.a
    public boolean remove(String str) {
        try {
            return this.f31513a.D(b(str));
        } catch (IOException e10) {
            hf.d.d(e10);
            return false;
        }
    }

    @Override // te.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        a.c p10 = this.f31513a.p(b(str));
        if (p10 == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(p10.i(0), this.f31516d);
        try {
            boolean compress = bitmap.compress(this.f31517e, this.f31518f, bufferedOutputStream);
            if (compress) {
                p10.f();
            } else {
                p10.a();
            }
            return compress;
        } finally {
            hf.c.a(bufferedOutputStream);
        }
    }

    public b(File file, File file2, we.a aVar, long j10, int i10) throws IOException {
        this.f31516d = 32768;
        this.f31517e = f31509h;
        this.f31518f = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j11 = j10 == 0 ? Long.MAX_VALUE : j10;
        int i11 = i10 == 0 ? Integer.MAX_VALUE : i10;
        this.f31514b = file2;
        this.f31515c = aVar;
        c(file, file2, j11, i11);
    }
}
