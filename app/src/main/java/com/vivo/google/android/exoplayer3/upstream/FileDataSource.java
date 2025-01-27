package com.vivo.google.android.exoplayer3.upstream;

import android.net.Uri;
import com.kuaishou.weapon.p0.t;
import com.vivo.google.android.exoplayer3.q5;
import com.vivo.google.android.exoplayer3.x5;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public final class FileDataSource implements DataSource {
    public long bytesRemaining;
    public RandomAccessFile file;
    public final x5<? super FileDataSource> listener;
    public boolean opened;
    public Uri uri;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this(null);
    }

    public FileDataSource(x5<? super FileDataSource> x5Var) {
        this.listener = x5Var;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public void close() {
        this.uri = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.file;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e2) {
                throw new FileDataSourceException(e2);
            }
        } finally {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                x5<? super FileDataSource> x5Var = this.listener;
                if (x5Var != null) {
                    x5Var.onTransferEnd(this);
                }
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public Uri getUri() {
        return this.uri;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public long open(q5 q5Var) {
        try {
            this.uri = q5Var.f27969a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(q5Var.f27969a.getPath(), t.k);
            this.file = randomAccessFile;
            randomAccessFile.seek(q5Var.f27972d);
            long j2 = q5Var.f27973e;
            if (j2 == -1) {
                j2 = this.file.length() - q5Var.f27972d;
            }
            this.bytesRemaining = j2;
            if (j2 < 0) {
                throw new EOFException();
            }
            this.opened = true;
            x5<? super FileDataSource> x5Var = this.listener;
            if (x5Var != null) {
                x5Var.onTransferStart(this, q5Var);
            }
            return this.bytesRemaining;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.bytesRemaining;
        if (j2 == 0) {
            return -1;
        }
        try {
            int read = this.file.read(bArr, i2, (int) Math.min(j2, i3));
            if (read > 0) {
                this.bytesRemaining -= read;
                x5<? super FileDataSource> x5Var = this.listener;
                if (x5Var != null) {
                    x5Var.onBytesTransferred(this, read);
                }
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2);
        }
    }
}
