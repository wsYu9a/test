package b.g.a.a.a.c;

import android.graphics.Bitmap;
import b.g.a.b.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public abstract class a implements b.g.a.a.a.b {

    /* renamed from: a */
    public static final int f4829a = 32768;

    /* renamed from: b */
    public static final Bitmap.CompressFormat f4830b = Bitmap.CompressFormat.PNG;

    /* renamed from: c */
    public static final int f4831c = 100;

    /* renamed from: d */
    private static final String f4832d = " argument must be not null";

    /* renamed from: e */
    private static final String f4833e = ".tmp";

    /* renamed from: f */
    protected final File f4834f;

    /* renamed from: g */
    protected final File f4835g;

    /* renamed from: h */
    protected final b.g.a.a.a.d.a f4836h;

    /* renamed from: i */
    protected int f4837i;

    /* renamed from: j */
    protected Bitmap.CompressFormat f4838j;
    protected int k;

    public a(File file) {
        this(file, null);
    }

    @Override // b.g.a.a.a.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        boolean z;
        File b2 = b(str);
        File file = new File(b2.getAbsolutePath() + ".tmp");
        try {
            try {
                z = b.g.a.b.c.c(inputStream, new BufferedOutputStream(new FileOutputStream(file), this.f4837i), aVar, this.f4837i);
            } finally {
            }
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        try {
            b.g.a.b.c.a(inputStream);
            boolean z2 = (!z || file.renameTo(b2)) ? z : false;
            if (!z2) {
                file.delete();
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
            b.g.a.b.c.a(inputStream);
            if (!((!z || file.renameTo(b2)) ? z : false)) {
                file.delete();
            }
            throw th;
        }
    }

    protected File b(String str) {
        File file;
        String generate = this.f4836h.generate(str);
        File file2 = this.f4834f;
        if (!file2.exists() && !this.f4834f.mkdirs() && (file = this.f4835g) != null && (file.exists() || this.f4835g.mkdirs())) {
            file2 = this.f4835g;
        }
        return new File(file2, generate);
    }

    public void c(int i2) {
        this.f4837i = i2;
    }

    @Override // b.g.a.a.a.a
    public void clear() {
        File[] listFiles = this.f4834f.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    @Override // b.g.a.a.a.a
    public void close() {
    }

    public void d(Bitmap.CompressFormat compressFormat) {
        this.f4838j = compressFormat;
    }

    public void e(int i2) {
        this.k = i2;
    }

    @Override // b.g.a.a.a.a
    public File get(String str) {
        return b(str);
    }

    @Override // b.g.a.a.a.a
    public File getDirectory() {
        return this.f4834f;
    }

    @Override // b.g.a.a.a.a
    public boolean remove(String str) {
        return b(str).delete();
    }

    @Override // b.g.a.a.a.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        File b2 = b(str);
        File file = new File(b2.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f4837i);
        try {
            boolean compress = bitmap.compress(this.f4838j, this.k, bufferedOutputStream);
            b.g.a.b.c.a(bufferedOutputStream);
            if (compress && !file.renameTo(b2)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th) {
            b.g.a.b.c.a(bufferedOutputStream);
            file.delete();
            throw th;
        }
    }

    public a(File file, File file2) {
        this(file, file2, com.nostra13.universalimageloader.core.a.d());
    }

    public a(File file, File file2, b.g.a.a.a.d.a aVar) {
        this.f4837i = 32768;
        this.f4838j = f4830b;
        this.k = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (aVar != null) {
            this.f4834f = file;
            this.f4835g = file2;
            this.f4836h = aVar;
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }
}
