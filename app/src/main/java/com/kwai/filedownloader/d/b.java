package com.kwai.filedownloader.d;

import com.kwai.filedownloader.e.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public final class b implements com.kwai.filedownloader.d.a {
    private final BufferedOutputStream aJl;
    private final RandomAccessFile aJm;
    private final FileDescriptor fd;

    public static class a implements c.e {
        @Override // com.kwai.filedownloader.e.c.e
        public final com.kwai.filedownloader.d.a ac(File file) {
            return new b(file);
        }
    }

    b(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.aJm = randomAccessFile;
        this.fd = randomAccessFile.getFD();
        this.aJl = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    @Override // com.kwai.filedownloader.d.a
    public final void IX() {
        this.aJl.flush();
        this.fd.sync();
    }

    @Override // com.kwai.filedownloader.d.a, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.aJl.close();
        this.aJm.close();
    }

    @Override // com.kwai.filedownloader.d.a
    public final void seek(long j2) {
        this.aJm.seek(j2);
    }

    @Override // com.kwai.filedownloader.d.a
    public final void setLength(long j2) {
        this.aJm.setLength(j2);
    }

    @Override // com.kwai.filedownloader.d.a
    public final void write(byte[] bArr, int i2, int i3) {
        this.aJl.write(bArr, 0, i3);
    }
}
