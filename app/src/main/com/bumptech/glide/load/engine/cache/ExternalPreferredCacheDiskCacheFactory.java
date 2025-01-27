package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes2.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory$1 */
    public class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$diskCacheName;

        public AnonymousClass1(Context context, String str) {
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
            File internalCacheDirectory = getInternalCacheDirectory();
            if (internalCacheDirectory != null && internalCacheDirectory.exists()) {
                return internalCacheDirectory;
            }
            File externalCacheDir = context.getExternalCacheDir();
            return (externalCacheDir == null || !externalCacheDir.canWrite()) ? internalCacheDirectory : str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j10) {
        this(context, "image_manager_disk_cache", j10);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j10) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory.1
            final /* synthetic */ Context val$context;
            final /* synthetic */ String val$diskCacheName;

            public AnonymousClass1(Context context2, String str2) {
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
                File internalCacheDirectory = getInternalCacheDirectory();
                if (internalCacheDirectory != null && internalCacheDirectory.exists()) {
                    return internalCacheDirectory;
                }
                File externalCacheDir = context.getExternalCacheDir();
                return (externalCacheDir == null || !externalCacheDir.canWrite()) ? internalCacheDirectory : str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, j10);
    }
}
