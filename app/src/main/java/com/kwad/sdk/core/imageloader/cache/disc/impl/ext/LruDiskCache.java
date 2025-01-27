package com.kwad.sdk.core.imageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import com.kwad.sdk.core.diskcache.kwai.a;
import com.kwad.sdk.core.imageloader.cache.disc.DiskCache;
import com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import com.kwad.sdk.core.imageloader.utils.L;
import com.kwad.sdk.crash.utils.b;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
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

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j2) {
        this(file, null, fileNameGenerator, j2, 0);
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j2, int i2) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j2 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j3 = j2 == 0 ? Long.MAX_VALUE : j2;
        int i3 = i2 == 0 ? Integer.MAX_VALUE : i2;
        this.reserveCacheDir = file2;
        this.fileNameGenerator = fileNameGenerator;
        initCache(file, file2, j3, i3);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j2, int i2) {
        try {
            this.cache = a.a(file, 1, 1, j2, i2);
        } catch (IOException e2) {
            L.e(e2);
            if (file2 != null) {
                initCache(file2, null, j2, i2);
            }
            if (this.cache == null) {
                throw e2;
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e2) {
            L.e(e2);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.vm());
        } catch (IOException e3) {
            L.e(e3);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public void close() {
        b.closeQuietly(this.cache);
        this.cache = null;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public File get(String str) {
        Throwable th;
        a.c cVar;
        File file = null;
        try {
            cVar = this.cache.bF(getKey(str));
            if (cVar != null) {
                try {
                    try {
                        file = cVar.aZ(0);
                    } catch (Throwable th2) {
                        th = th2;
                        b.closeQuietly(cVar);
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    L.e(e);
                    b.closeQuietly(cVar);
                    return null;
                }
            }
            b.closeQuietly(cVar);
            return file;
        } catch (IOException e3) {
            e = e3;
            cVar = null;
        } catch (Throwable th3) {
            th = th3;
            cVar = null;
            b.closeQuietly(cVar);
            throw th;
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
        } catch (IOException e2) {
            L.e(e2);
            return false;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        a.C0210a bG = this.cache.bG(getKey(str));
        if (bG == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(bG.aW(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                bG.commit();
            } else {
                bG.abort();
            }
            return compress;
        } finally {
            b.closeQuietly(bufferedOutputStream);
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        a.C0210a bG = this.cache.bG(getKey(str));
        if (bG == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(bG.aW(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            b.closeQuietly(bufferedOutputStream);
            if (copyStream) {
                bG.commit();
            } else {
                bG.abort();
            }
            return copyStream;
        } catch (Throwable th) {
            b.closeQuietly(bufferedOutputStream);
            bG.abort();
            throw th;
        }
    }

    public void setBufferSize(int i2) {
        this.bufferSize = i2;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i2) {
        this.compressQuality = i2;
    }
}
