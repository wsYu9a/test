package com.kwad.framework.filedownloader.e;

import com.kwad.framework.filedownloader.f.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* loaded from: classes3.dex */
public final class b implements com.kwad.framework.filedownloader.e.a {
    private final BufferedOutputStream alo;
    private final RandomAccessFile alp;

    /* renamed from: fd */
    private final FileDescriptor f11966fd;

    public static class a implements c.e {
        @Override // com.kwad.framework.filedownloader.f.c.e
        public final com.kwad.framework.filedownloader.e.a c(File file) {
            return new b(file);
        }
    }

    public b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.alp = randomAccessFile;
        this.f11966fd = randomAccessFile.getFD();
        this.alo = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.kwad.framework.filedownloader.e.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.alo.close();
        this.alp.close();
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void seek(long j10) {
        this.alp.seek(j10);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void setLength(long j10) {
        this.alp.setLength(j10);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void write(byte[] bArr, int i10, int i11) {
        this.alo.write(bArr, 0, i11);
    }

    @Override // com.kwad.framework.filedownloader.e.a
    public final void xQ() {
        this.alo.flush();
        this.f11966fd.sync();
    }
}
