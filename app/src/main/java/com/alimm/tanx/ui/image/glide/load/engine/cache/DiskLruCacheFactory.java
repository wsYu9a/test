package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import java.io.File;

/* loaded from: classes.dex */
public class DiskLruCacheFactory implements DiskCache.Factory {
    private final CacheDirectoryGetter cacheDirectoryGetter;
    private final int diskCacheSize;

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory$1 */
    public class AnonymousClass1 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(str);
        }
    }

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory$2 */
    public class AnonymousClass2 implements CacheDirectoryGetter {
        final /* synthetic */ String val$diskCacheFolder;
        final /* synthetic */ String val$diskCacheName;

        public AnonymousClass2(String str, String str2) {
            str = str;
            str2 = str2;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            return new File(str, str2);
        }
    }

    public interface CacheDirectoryGetter {
        File getCacheDirectory();
    }

    public DiskLruCacheFactory(String str, int i10) {
        AnonymousClass1 anonymousClass1 = new CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.1
            final /* synthetic */ String val$diskCacheFolder;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str);
            }
        };
        this.diskCacheSize = i10;
        this.cacheDirectoryGetter = anonymousClass1;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory
    public DiskCache build() {
        File cacheDirectory = this.cacheDirectoryGetter.getCacheDirectory();
        if (cacheDirectory == null) {
            return null;
        }
        if (cacheDirectory.mkdirs() || (cacheDirectory.exists() && cacheDirectory.isDirectory())) {
            return DiskLruCacheWrapper.get(cacheDirectory, this.diskCacheSize);
        }
        return null;
    }

    public DiskLruCacheFactory(String str, String str2, int i10) {
        AnonymousClass2 anonymousClass2 = new CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.2
            final /* synthetic */ String val$diskCacheFolder;
            final /* synthetic */ String val$diskCacheName;

            public AnonymousClass2(String str3, String str22) {
                str = str3;
                str2 = str22;
            }

            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                return new File(str, str2);
            }
        };
        this.diskCacheSize = i10;
        this.cacheDirectoryGetter = anonymousClass2;
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, int i10) {
        this.diskCacheSize = i10;
        this.cacheDirectoryGetter = cacheDirectoryGetter;
    }
}
