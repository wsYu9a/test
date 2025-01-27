package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$1 */
    class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$diskCacheName;

        AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Nullable
        private File getInternalCacheDirectory() {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return str != null ? new File(cacheDir, str) : cacheDir;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File externalCacheDir;
            File internalCacheDirectory = getInternalCacheDirectory();
            return ((internalCacheDirectory == null || !internalCacheDirectory.exists()) && (externalCacheDir = context.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? str != null ? new File(externalCacheDir, str) : externalCacheDir : internalCacheDirectory;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j2) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j2);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j2) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory.1
            final /* synthetic */ Context val$context;
            final /* synthetic */ String val$diskCacheName;

            AnonymousClass1(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Nullable
            private File getInternalCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }

            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir;
                File internalCacheDirectory = getInternalCacheDirectory();
                return ((internalCacheDirectory == null || !internalCacheDirectory.exists()) && (externalCacheDir = context.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? str != null ? new File(externalCacheDir, str) : externalCacheDir : internalCacheDirectory;
            }
        }, j2);
    }
}
