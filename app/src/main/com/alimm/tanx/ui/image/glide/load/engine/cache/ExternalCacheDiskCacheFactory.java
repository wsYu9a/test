package com.alimm.tanx.ui.image.glide.load.engine.cache;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    /* renamed from: com.alimm.tanx.ui.image.glide.load.engine.cache.ExternalCacheDiskCacheFactory$1 */
    public class AnonymousClass1 implements DiskLruCacheFactory.CacheDirectoryGetter {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$diskCacheName;

        public AnonymousClass1(Context context, String str) {
            context = context;
            str = str;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
        public File getCacheDirectory() {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            String str = str;
            return str != null ? new File(externalCacheDir, str) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i10) {
        this(context, "image_manager_disk_cache", i10);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i10) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.alimm.tanx.ui.image.glide.load.engine.cache.ExternalCacheDiskCacheFactory.1
            final /* synthetic */ Context val$context;
            final /* synthetic */ String val$diskCacheName;

            public AnonymousClass1(Context context2, String str2) {
                context = context2;
                str = str2;
            }

            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                String str2 = str;
                return str2 != null ? new File(externalCacheDir, str2) : externalCacheDir;
            }
        }, i10);
    }
}
