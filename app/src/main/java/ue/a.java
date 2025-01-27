package ue;

import android.graphics.Bitmap;
import hf.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class a implements te.b {

    /* renamed from: g */
    public static final int f31041g = 32768;

    /* renamed from: h */
    public static final Bitmap.CompressFormat f31042h = Bitmap.CompressFormat.PNG;

    /* renamed from: i */
    public static final int f31043i = 100;

    /* renamed from: j */
    public static final String f31044j = " argument must be not null";

    /* renamed from: k */
    public static final String f31045k = ".tmp";

    /* renamed from: a */
    public final File f31046a;

    /* renamed from: b */
    public final File f31047b;

    /* renamed from: c */
    public final we.a f31048c;

    /* renamed from: d */
    public int f31049d;

    /* renamed from: e */
    public Bitmap.CompressFormat f31050e;

    /* renamed from: f */
    public int f31051f;

    public a(File file) {
        this(file, null);
    }

    @Override // te.a
    public boolean a(String str, InputStream inputStream, c.a aVar) throws IOException {
        boolean z10;
        File b10 = b(str);
        File file = new File(b10.getAbsolutePath() + ".tmp");
        try {
            try {
                z10 = hf.c.c(inputStream, new BufferedOutputStream(new FileOutputStream(file), this.f31049d), aVar, this.f31049d);
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            z10 = false;
        }
        try {
            hf.c.a(inputStream);
            boolean z11 = (!z10 || file.renameTo(b10)) ? z10 : false;
            if (!z11) {
                file.delete();
            }
            return z11;
        } catch (Throwable th3) {
            th = th3;
            hf.c.a(inputStream);
            if (!((!z10 || file.renameTo(b10)) ? z10 : false)) {
                file.delete();
            }
            throw th;
        }
    }

    public File b(String str) {
        File file;
        String generate = this.f31048c.generate(str);
        File file2 = this.f31046a;
        if (!file2.exists() && !this.f31046a.mkdirs() && (file = this.f31047b) != null && (file.exists() || this.f31047b.mkdirs())) {
            file2 = this.f31047b;
        }
        return new File(file2, generate);
    }

    public void c(int i10) {
        this.f31049d = i10;
    }

    @Override // te.a
    public void clear() {
        File[] listFiles = this.f31046a.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
    }

    public void d(Bitmap.CompressFormat compressFormat) {
        this.f31050e = compressFormat;
    }

    public void e(int i10) {
        this.f31051f = i10;
    }

    @Override // te.a
    public File get(String str) {
        return b(str);
    }

    @Override // te.a
    public File getDirectory() {
        return this.f31046a;
    }

    @Override // te.a
    public boolean remove(String str) {
        return b(str).delete();
    }

    @Override // te.a
    public boolean save(String str, Bitmap bitmap) throws IOException {
        File b10 = b(str);
        File file = new File(b10.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f31049d);
        try {
            boolean compress = bitmap.compress(this.f31050e, this.f31051f, bufferedOutputStream);
            hf.c.a(bufferedOutputStream);
            if (compress && !file.renameTo(b10)) {
                compress = false;
            }
            if (!compress) {
                file.delete();
            }
            bitmap.recycle();
            return compress;
        } catch (Throwable th2) {
            hf.c.a(bufferedOutputStream);
            file.delete();
            throw th2;
        }
    }

    public a(File file, File file2) {
        this(file, file2, ze.a.d());
    }

    public a(File file, File file2, we.a aVar) {
        this.f31049d = 32768;
        this.f31050e = f31042h;
        this.f31051f = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (aVar != null) {
            this.f31046a = file;
            this.f31047b = file2;
            this.f31048c = aVar;
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // te.a
    public void close() {
    }
}
