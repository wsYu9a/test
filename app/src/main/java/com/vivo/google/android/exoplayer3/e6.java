package com.vivo.google.android.exoplayer3;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class e6 {

    /* renamed from: a */
    public final File f27398a;

    /* renamed from: b */
    public final File f27399b;

    public static final class a extends OutputStream {

        /* renamed from: a */
        public final FileOutputStream f27400a;

        /* renamed from: b */
        public boolean f27401b = false;

        public a(File file) {
            this.f27400a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f27401b) {
                return;
            }
            this.f27401b = true;
            this.f27400a.flush();
            try {
                this.f27400a.getFD().sync();
            } catch (IOException unused) {
            }
            this.f27400a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f27400a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            this.f27400a.write(i2);
        }

        @Override // java.io.OutputStream
        public void write(@NonNull byte[] bArr) {
            this.f27400a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(@NonNull byte[] bArr, int i2, int i3) {
            this.f27400a.write(bArr, i2, i3);
        }
    }

    public e6(File file) {
        this.f27398a = file;
        this.f27399b = new File(file.getPath() + ".bak");
    }

    public InputStream a() {
        if (this.f27399b.exists()) {
            this.f27398a.delete();
            this.f27399b.renameTo(this.f27398a);
        }
        return new FileInputStream(this.f27398a);
    }

    public OutputStream b() {
        if (this.f27398a.exists()) {
            if (this.f27399b.exists()) {
                this.f27398a.delete();
            } else if (!this.f27398a.renameTo(this.f27399b)) {
                String str = "Couldn't rename file " + this.f27398a + " to backup file " + this.f27399b;
            }
        }
        try {
            return new a(this.f27398a);
        } catch (FileNotFoundException unused) {
            if (!this.f27398a.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.f27398a);
            }
            try {
                return new a(this.f27398a);
            } catch (FileNotFoundException unused2) {
                throw new IOException("Couldn't create " + this.f27398a);
            }
        }
    }
}
