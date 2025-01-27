package com.vivo.google.android.exoplayer3.upstream.cache;

import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.o5;
import com.vivo.google.android.exoplayer3.q5;
import com.vivo.google.android.exoplayer3.r6;
import com.vivo.google.android.exoplayer3.util.Util;
import com.vivo.google.android.exoplayer3.y5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class CacheDataSink implements o5 {
    public static final int DEFAULT_BUFFER_SIZE = 20480;
    public final int bufferSize;
    public r6 bufferedOutputStream;
    public final y5 cache;
    public q5 dataSpec;
    public long dataSpecBytesWritten;
    public File file;
    public final long maxCacheFileSize;
    public OutputStream outputStream;
    public long outputStreamBytesWritten;
    public FileOutputStream underlyingFileOutputStream;

    public static class CacheDataSinkException extends y5.a {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    public CacheDataSink(y5 y5Var, long j2) {
        this(y5Var, j2, DEFAULT_BUFFER_SIZE);
    }

    public CacheDataSink(y5 y5Var, long j2, int i2) {
        this.cache = (y5) g1.a(y5Var);
        this.maxCacheFileSize = j2;
        this.bufferSize = i2;
    }

    private void closeCurrentOutputStream() {
        OutputStream outputStream = this.outputStream;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            this.underlyingFileOutputStream.getFD().sync();
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file = this.file;
            this.file = null;
            this.cache.commitFile(file);
        } catch (Throwable th) {
            Util.closeQuietly(this.outputStream);
            this.outputStream = null;
            File file2 = this.file;
            this.file = null;
            file2.delete();
            throw th;
        }
    }

    private void openNextOutputStream() {
        long j2 = this.dataSpec.f27973e;
        long min = j2 == -1 ? this.maxCacheFileSize : Math.min(j2 - this.dataSpecBytesWritten, this.maxCacheFileSize);
        y5 y5Var = this.cache;
        q5 q5Var = this.dataSpec;
        this.file = y5Var.startFile(q5Var.f27974f, this.dataSpecBytesWritten + q5Var.f27971c, min);
        FileOutputStream fileOutputStream = new FileOutputStream(this.file);
        this.underlyingFileOutputStream = fileOutputStream;
        OutputStream outputStream = fileOutputStream;
        if (this.bufferSize > 0) {
            r6 r6Var = this.bufferedOutputStream;
            if (r6Var == null) {
                this.bufferedOutputStream = new r6(this.underlyingFileOutputStream, this.bufferSize);
            } else {
                r6Var.a(fileOutputStream);
            }
            outputStream = this.bufferedOutputStream;
        }
        this.outputStream = outputStream;
        this.outputStreamBytesWritten = 0L;
    }

    @Override // com.vivo.google.android.exoplayer3.o5
    public void close() {
        if (this.dataSpec == null) {
            return;
        }
        try {
            closeCurrentOutputStream();
        } catch (IOException e2) {
            throw new CacheDataSinkException(e2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.o5
    public void open(q5 q5Var) {
        if (q5Var.f27973e == -1 && !q5Var.a(2)) {
            this.dataSpec = null;
            return;
        }
        this.dataSpec = q5Var;
        this.dataSpecBytesWritten = 0L;
        try {
            openNextOutputStream();
        } catch (IOException e2) {
            throw new CacheDataSinkException(e2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.o5
    public void write(byte[] bArr, int i2, int i3) {
        if (this.dataSpec == null) {
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            try {
                if (this.outputStreamBytesWritten == this.maxCacheFileSize) {
                    closeCurrentOutputStream();
                    openNextOutputStream();
                }
                int min = (int) Math.min(i3 - i4, this.maxCacheFileSize - this.outputStreamBytesWritten);
                this.outputStream.write(bArr, i2 + i4, min);
                i4 += min;
                long j2 = min;
                this.outputStreamBytesWritten += j2;
                this.dataSpecBytesWritten += j2;
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        }
    }
}
