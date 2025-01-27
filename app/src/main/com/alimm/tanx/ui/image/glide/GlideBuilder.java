package com.alimm.tanx.ui.image.glide;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.DecodeFormat;
import com.alimm.tanx.ui.image.glide.load.engine.Engine;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.BitmapPool;
import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache;
import com.alimm.tanx.ui.image.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.alimm.tanx.ui.image.glide.load.engine.cache.LruResourceCache;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemoryCache;
import com.alimm.tanx.ui.image.glide.load.engine.cache.MemorySizeCalculator;
import com.alimm.tanx.ui.image.glide.load.engine.executor.FifoPriorityThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class GlideBuilder {
    private BitmapPool bitmapPool;
    private final Context context;
    private DecodeFormat decodeFormat;
    private DiskCache.Factory diskCacheFactory;
    private ExecutorService diskCacheService;
    private Engine engine;
    private MemoryCache memoryCache;
    private ExecutorService sourceService;

    /* renamed from: com.alimm.tanx.ui.image.glide.GlideBuilder$1 */
    public class AnonymousClass1 implements DiskCache.Factory {
        final /* synthetic */ DiskCache val$diskCache;

        public AnonymousClass1(DiskCache diskCache) {
            diskCache = diskCache;
        }

        @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory
        public DiskCache build() {
            return diskCache;
        }
    }

    public GlideBuilder(Context context) {
        this.context = context.getApplicationContext();
    }

    public Glide createGlide() {
        if (this.sourceService == null) {
            this.sourceService = new FifoPriorityThreadPoolExecutor(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.diskCacheService == null) {
            this.diskCacheService = new FifoPriorityThreadPoolExecutor(1);
        }
        MemorySizeCalculator memorySizeCalculator = new MemorySizeCalculator(this.context);
        if (this.bitmapPool == null) {
            this.bitmapPool = new LruBitmapPool(memorySizeCalculator.getBitmapPoolSize());
        }
        if (this.memoryCache == null) {
            this.memoryCache = new LruResourceCache(memorySizeCalculator.getMemoryCacheSize());
        }
        if (this.diskCacheFactory == null) {
            this.diskCacheFactory = new InternalCacheDiskCacheFactory(this.context);
        }
        if (this.engine == null) {
            this.engine = new Engine(this.memoryCache, this.diskCacheFactory, this.diskCacheService, this.sourceService);
        }
        if (this.decodeFormat == null) {
            this.decodeFormat = DecodeFormat.DEFAULT;
        }
        return new Glide(this.engine, this.memoryCache, this.bitmapPool, this.context, this.decodeFormat);
    }

    public GlideBuilder setBitmapPool(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
        return this;
    }

    public GlideBuilder setDecodeFormat(DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        return this;
    }

    @Deprecated
    public GlideBuilder setDiskCache(DiskCache diskCache) {
        return setDiskCache(new DiskCache.Factory() { // from class: com.alimm.tanx.ui.image.glide.GlideBuilder.1
            final /* synthetic */ DiskCache val$diskCache;

            public AnonymousClass1(DiskCache diskCache2) {
                diskCache = diskCache2;
            }

            @Override // com.alimm.tanx.ui.image.glide.load.engine.cache.DiskCache.Factory
            public DiskCache build() {
                return diskCache;
            }
        });
    }

    public GlideBuilder setDiskCacheService(ExecutorService executorService) {
        this.diskCacheService = executorService;
        return this;
    }

    public GlideBuilder setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public GlideBuilder setMemoryCache(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
        return this;
    }

    public GlideBuilder setResizeService(ExecutorService executorService) {
        this.sourceService = executorService;
        return this;
    }

    public GlideBuilder setDiskCache(DiskCache.Factory factory) {
        this.diskCacheFactory = factory;
        return this;
    }
}
