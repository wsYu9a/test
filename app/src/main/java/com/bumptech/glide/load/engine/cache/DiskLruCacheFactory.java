package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final long diskCacheSize;

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$1 */
    class AnonymousClass1 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;

        AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(str);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory$2 */
    class AnonymousClass2 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;
        final /* synthetic */ String val$diskCacheName;

        AnonymousClass2(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(str, str2);
        }
    }

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(String str, long j2) {
        this(new CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.1
            final /* synthetic */ String val$diskCacheFolder;

            AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str);
            }
        }, j2);
    }

    @Override // com.bumptech.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return DiskLruCacheWrapper.create(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }

    public DiskLruCacheFactory(String str, String str2, long j2) {
        this(new CacheDirectoryGetter() { // from class: com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.2
            final /* synthetic */ String val$diskCacheFolder;
            final /* synthetic */ String val$diskCacheName;

            AnonymousClass2(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str, str2);
            }
        }, j2);
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j2) {
        this.diskCacheSize = j2;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }
}
