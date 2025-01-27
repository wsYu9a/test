package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.disklrucache.DiskLruCache;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final int maxSize;
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();
    private final SafeKeyGenerator safeKeyGenerator = new SafeKeyGenerator();

    public DiskLruCacheWrapper(File file, int i10) {
        this.directory = file;
        this.maxSize = i10;
    }

    public static synchronized DiskCache get(File file, int i10) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            try {
                if (wrapper == null) {
                    wrapper = new DiskLruCacheWrapper(file, i10);
                }
                diskLruCacheWrapper = wrapper;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return diskLruCacheWrapper;
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        try {
            if (this.diskLruCache == null) {
                this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, this.maxSize);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public synchronized void clear() {
        try {
            getDiskCache().delete();
            resetDiskCache();
        } catch (IOException e10) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to clear disk cache", e10);
            }
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public void delete(Key key) {
        try {
            getDiskCache().remove(this.safeKeyGenerator.getSafeKey(key));
        } catch (IOException e10) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to delete from disk cache", e10);
            }
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public void put(Key key, DiskCache.Writer writer) {
        String safeKey = this.safeKeyGenerator.getSafeKey(key);
        this.writeLocker.acquire(key);
        try {
            try {
                DiskLruCache.Editor edit = getDiskCache().edit(safeKey);
                if (edit != null) {
                    try {
                        if (writer.write(edit.getFile(0))) {
                            edit.commit();
                        }
                        edit.abortUnlessCommitted();
                    } catch (Throwable th2) {
                        edit.abortUnlessCommitted();
                        throw th2;
                    }
                }
            } catch (IOException e10) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to put to disk cache", e10);
                }
            }
            this.writeLocker.release(key);
        } catch (Throwable th3) {
            this.writeLocker.release(key);
            throw th3;
        }
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache
    public File get(Key key) {
        try {
            DiskLruCache.Value value = getDiskCache().get(this.safeKeyGenerator.getSafeKey(key));
            if (value != null) {
                return value.getFile(0);
            }
        } catch (IOException e10) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to get from disk cache", e10);
            }
        }
        return null;
    }
}
