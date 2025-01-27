package com.kwad.sdk.core.videocache.kwai;

import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.core.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes2.dex */
public final class b implements com.kwad.sdk.core.videocache.a {
    private final a anv;
    private RandomAccessFile aoj;
    public File file;

    public b(File file, a aVar) {
        File file2;
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.anv = aVar;
            d.p(file.getParentFile());
            boolean exists = file.exists();
            if (exists) {
                file2 = file;
            } else {
                file2 = new File(file.getParentFile(), file.getName() + ".download");
            }
            this.file = file2;
            this.aoj = new RandomAccessFile(this.file, exists ? t.k : "rw");
        } catch (IOException e2) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
        }
    }

    private static boolean o(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized int a(byte[] bArr, long j2, int i2) {
        try {
            this.aoj.seek(j2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(yw()), Integer.valueOf(bArr.length)), e2);
        }
        return this.aoj.read(bArr, 0, i2);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void close() {
        try {
            this.aoj.close();
            this.anv.n(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.file, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (!this.file.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
        }
        this.file = file;
        try {
            this.aoj = new RandomAccessFile(this.file, t.k);
            this.anv.n(this.file);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized void d(byte[] bArr, int i2) {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.aoj.seek(yw());
            this.aoj.write(bArr, 0, i2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i2), this.aoj, 8192), e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized boolean isCompleted() {
        return !o(this.file);
    }

    @Override // com.kwad.sdk.core.videocache.a
    public final synchronized long yw() {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e2);
        }
        return (int) this.aoj.length();
    }
}
