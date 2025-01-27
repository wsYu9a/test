package com.vivo.google.android.exoplayer3.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.vivo.google.android.exoplayer3.a6;
import com.vivo.google.android.exoplayer3.o5;
import com.vivo.google.android.exoplayer3.p5;
import com.vivo.google.android.exoplayer3.q5;
import com.vivo.google.android.exoplayer3.upstream.DataSource;
import com.vivo.google.android.exoplayer3.upstream.FileDataSource;
import com.vivo.google.android.exoplayer3.w5;
import com.vivo.google.android.exoplayer3.y5;
import java.io.IOException;
import java.io.InterruptedIOException;

/* loaded from: classes4.dex */
public final class CacheDataSource implements DataSource {
    public static final long DEFAULT_MAX_CACHE_FILE_SIZE = 2097152;
    public static final int FLAG_BLOCK_ON_CACHE = 1;
    public static final int FLAG_IGNORE_CACHE_FOR_UNSET_LENGTH_REQUESTS = 4;
    public static final int FLAG_IGNORE_CACHE_ON_ERROR = 2;
    public final boolean blockOnCache;
    public long bytesRemaining;
    public final y5 cache;
    public final DataSource cacheReadDataSource;
    public final DataSource cacheWriteDataSource;
    public DataSource currentDataSource;
    public boolean currentRequestIgnoresCache;
    public boolean currentRequestUnbounded;

    @Nullable
    public final EventListener eventListener;
    public int flags;
    public final boolean ignoreCacheForUnsetLengthRequests;
    public final boolean ignoreCacheOnError;
    public String key;
    public a6 lockedSpan;
    public long readPosition;
    public boolean seenCacheError;
    public long totalCachedBytesRead;
    public final DataSource upstreamDataSource;
    public Uri uri;

    public interface EventListener {
        void onCachedBytesRead(long j2, long j3);
    }

    public CacheDataSource(y5 y5Var, DataSource dataSource) {
        this(y5Var, dataSource, 0, 2097152L);
    }

    public CacheDataSource(y5 y5Var, DataSource dataSource, int i2) {
        this(y5Var, dataSource, i2, 2097152L);
    }

    public CacheDataSource(y5 y5Var, DataSource dataSource, int i2, long j2) {
        this(y5Var, dataSource, new FileDataSource(), new CacheDataSink(y5Var, j2), i2, null);
    }

    public CacheDataSource(y5 y5Var, DataSource dataSource, DataSource dataSource2, o5 o5Var, int i2, @Nullable EventListener eventListener) {
        this.cache = y5Var;
        this.cacheReadDataSource = dataSource2;
        this.blockOnCache = (i2 & 1) != 0;
        this.ignoreCacheOnError = (i2 & 2) != 0;
        this.ignoreCacheForUnsetLengthRequests = (i2 & 4) != 0;
        this.upstreamDataSource = dataSource;
        this.cacheWriteDataSource = o5Var != null ? new w5(dataSource, o5Var) : null;
        this.eventListener = eventListener;
    }

    private void closeCurrentSource() {
        DataSource dataSource = this.currentDataSource;
        if (dataSource == null) {
            return;
        }
        try {
            dataSource.close();
            this.currentDataSource = null;
            this.currentRequestUnbounded = false;
        } finally {
            a6 a6Var = this.lockedSpan;
            if (a6Var != null) {
                this.cache.releaseHoleSpan(a6Var);
                this.lockedSpan = null;
            }
        }
    }

    private void handleBeforeThrow(IOException iOException) {
        if (this.currentDataSource == this.cacheReadDataSource || (iOException instanceof y5.a)) {
            this.seenCacheError = true;
        }
    }

    private void notifyBytesRead() {
        EventListener eventListener = this.eventListener;
        if (eventListener == null || this.totalCachedBytesRead <= 0) {
            return;
        }
        eventListener.onCachedBytesRead(this.cache.getCacheSpace(), this.totalCachedBytesRead);
        this.totalCachedBytesRead = 0L;
    }

    private boolean openNextSource(boolean z) {
        a6 startReadWrite;
        q5 q5Var;
        IOException iOException = null;
        if (this.currentRequestIgnoresCache) {
            startReadWrite = null;
        } else if (this.blockOnCache) {
            try {
                startReadWrite = this.cache.startReadWrite(this.key, this.readPosition);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        } else {
            startReadWrite = this.cache.startReadWriteNonBlocking(this.key, this.readPosition);
        }
        boolean z2 = true;
        if (startReadWrite == null) {
            this.currentDataSource = this.upstreamDataSource;
            Uri uri = this.uri;
            long j2 = this.readPosition;
            q5Var = new q5(uri, null, j2, j2, this.bytesRemaining, this.key, this.flags);
        } else if (startReadWrite.f27152d) {
            Uri fromFile = Uri.fromFile(startReadWrite.f27153e);
            long j3 = this.readPosition - startReadWrite.f27150b;
            long j4 = startReadWrite.f27151c - j3;
            long j5 = this.bytesRemaining;
            if (j5 != -1) {
                j4 = Math.min(j4, j5);
            }
            q5 q5Var2 = new q5(fromFile, null, this.readPosition, j3, j4, this.key, this.flags);
            this.currentDataSource = this.cacheReadDataSource;
            q5Var = q5Var2;
        } else {
            long j6 = startReadWrite.f27151c;
            if (j6 == -1) {
                j6 = this.bytesRemaining;
            } else {
                long j7 = this.bytesRemaining;
                if (j7 != -1) {
                    j6 = Math.min(j6, j7);
                }
            }
            Uri uri2 = this.uri;
            long j8 = this.readPosition;
            q5Var = new q5(uri2, null, j8, j8, j6, this.key, this.flags);
            DataSource dataSource = this.cacheWriteDataSource;
            if (dataSource != null) {
                this.currentDataSource = dataSource;
                this.lockedSpan = startReadWrite;
            } else {
                this.currentDataSource = this.upstreamDataSource;
                this.cache.releaseHoleSpan(startReadWrite);
            }
        }
        this.currentRequestUnbounded = q5Var.f27973e == -1;
        long j9 = 0;
        try {
            j9 = this.currentDataSource.open(q5Var);
        } catch (IOException e2) {
            if (!z && this.currentRequestUnbounded) {
                for (Throwable th = e2; th != null; th = th.getCause()) {
                    if ((th instanceof p5) && ((p5) th).f27936a == 0) {
                        break;
                    }
                }
            }
            iOException = e2;
            if (iOException != null) {
                throw iOException;
            }
            z2 = false;
        }
        if (this.currentRequestUnbounded && j9 != -1) {
            this.bytesRemaining = j9;
            setContentLength(q5Var.f27972d + j9);
        }
        return z2;
    }

    private void setContentLength(long j2) {
        if (this.currentDataSource == this.cacheWriteDataSource) {
            this.cache.setContentLength(this.key, j2);
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public void close() {
        this.uri = null;
        notifyBytesRead();
        try {
            closeCurrentSource();
        } catch (IOException e2) {
            handleBeforeThrow(e2);
            throw e2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public Uri getUri() {
        DataSource dataSource = this.currentDataSource;
        return dataSource == this.upstreamDataSource ? dataSource.getUri() : this.uri;
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public long open(q5 q5Var) {
        try {
            Uri uri = q5Var.f27969a;
            this.uri = uri;
            this.flags = q5Var.f27975g;
            String str = q5Var.f27974f;
            if (str == null) {
                str = uri.toString();
            }
            this.key = str;
            this.readPosition = q5Var.f27972d;
            boolean z = (this.ignoreCacheOnError && this.seenCacheError) || (q5Var.f27973e == -1 && this.ignoreCacheForUnsetLengthRequests);
            this.currentRequestIgnoresCache = z;
            long j2 = q5Var.f27973e;
            if (j2 == -1 && !z) {
                long contentLength = this.cache.getContentLength(str);
                this.bytesRemaining = contentLength;
                if (contentLength != -1) {
                    long j3 = contentLength - q5Var.f27972d;
                    this.bytesRemaining = j3;
                    if (j3 <= 0) {
                        throw new p5(0);
                    }
                }
                openNextSource(true);
                return this.bytesRemaining;
            }
            this.bytesRemaining = j2;
            openNextSource(true);
            return this.bytesRemaining;
        } catch (IOException e2) {
            handleBeforeThrow(e2);
            throw e2;
        }
    }

    @Override // com.vivo.google.android.exoplayer3.upstream.DataSource
    public int read(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (this.bytesRemaining == 0) {
            return -1;
        }
        try {
            int read = this.currentDataSource.read(bArr, i2, i3);
            if (read >= 0) {
                if (this.currentDataSource == this.cacheReadDataSource) {
                    this.totalCachedBytesRead += read;
                }
                long j2 = read;
                this.readPosition += j2;
                long j3 = this.bytesRemaining;
                if (j3 != -1) {
                    this.bytesRemaining = j3 - j2;
                }
            } else {
                if (this.currentRequestUnbounded) {
                    setContentLength(this.readPosition);
                    this.bytesRemaining = 0L;
                }
                closeCurrentSource();
                long j4 = this.bytesRemaining;
                if ((j4 > 0 || j4 == -1) && openNextSource(false)) {
                    return read(bArr, i2, i3);
                }
            }
            return read;
        } catch (IOException e2) {
            handleBeforeThrow(e2);
            throw e2;
        }
    }
}
