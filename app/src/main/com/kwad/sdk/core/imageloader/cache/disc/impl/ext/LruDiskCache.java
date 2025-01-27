package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.kwad.sdk.core.diskcache.a.a;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    protected int bufferSize;
    protected a cache;
    protected Bitmap.CompressFormat compressFormat;
    protected int compressQuality;
    protected final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j10) {
        this(file, null, fileNameGenerator, j10, 0);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j10, int i10) {
        try {
            this.cache = a.a(file, 1, 1, j10, i10);
        } catch (IOException e10) {
            L.e(e10);
            if (file2 != null) {
                initCache(file2, null, j10, i10);
            }
            if (this.cache == null) {
                throw e10;
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e10) {
            L.e(e10);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.EA());
        } catch (IOException e11) {
            L.e(e11);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        b.closeQuietly(this.cache);
        this.cache = null;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        Throwable th2;
        a.c cVar;
        File file = null;
        try {
            cVar = this.cache.dA(getKey(str));
            if (cVar != null) {
                try {
                    try {
                        file = cVar.dd(0);
                    } catch (Throwable th3) {
                        th2 = th3;
                        b.closeQuietly(cVar);
                        throw th2;
                    }
                } catch (IOException e10) {
                    e = e10;
                    L.e(e);
                    b.closeQuietly(cVar);
                    return null;
                }
            }
            b.closeQuietly(cVar);
            return file;
        } catch (IOException e11) {
            e = e11;
            cVar = null;
        } catch (Throwable th4) {
            th2 = th4;
            cVar = null;
            b.closeQuietly(cVar);
            throw th2;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cache.getDirectory();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e10) {
            L.e(e10);
            return false;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        a.C0487a dB = this.cache.dB(getKey(str));
        if (dB == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(dB.da(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            b.closeQuietly(bufferedOutputStream);
            if (copyStream) {
                dB.commit();
            } else {
                dB.abort();
            }
            return copyStream;
        } catch (Throwable th2) {
            b.closeQuietly(bufferedOutputStream);
            dB.abort();
            throw th2;
        }
    }

    public void setBufferSize(int i10) {
        this.bufferSize = i10;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i10) {
        this.compressQuality = i10;
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j10, int i10) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j11 = j10 == 0 ? Long.MAX_VALUE : j10;
        int i11 = i10 == 0 ? Integer.MAX_VALUE : i10;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
        initCache(file, file2, j11, i11);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        a.C0487a dB = this.cache.dB(getKey(str));
        if (dB == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(dB.da(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                dB.commit();
            } else {
                dB.abort();
            }
            return compress;
        } finally {
            b.closeQuietly(bufferedOutputStream);
        }
    }
}
