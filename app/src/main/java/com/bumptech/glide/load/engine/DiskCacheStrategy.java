package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes.dex */
public abstract class DiskCacheStrategy {
    public static final DiskCacheStrategy ALL = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.1
        AnonymousClass1() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy NONE = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.2
        AnonymousClass2() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };
    public static final DiskCacheStrategy DATA = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.3
        AnonymousClass3() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };
    public static final DiskCacheStrategy RESOURCE = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.4
        AnonymousClass4() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };
    public static final DiskCacheStrategy AUTOMATIC = new DiskCacheStrategy() { // from class: com.bumptech.glide.load.engine.DiskCacheStrategy.5
        AnonymousClass5() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$1 */
    class AnonymousClass1 extends DiskCacheStrategy {
        AnonymousClass1() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$2 */
    class AnonymousClass2 extends DiskCacheStrategy {
        AnonymousClass2() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$3 */
    class AnonymousClass3 extends DiskCacheStrategy {
        AnonymousClass3() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$4 */
    class AnonymousClass4 extends DiskCacheStrategy {
        AnonymousClass4() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return false;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DiskCacheStrategy$5 */
    class AnonymousClass5 extends DiskCacheStrategy {
        AnonymousClass5() {
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedData() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean decodeCachedResource() {
            return true;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isDataCacheable(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // com.bumptech.glide.load.engine.DiskCacheStrategy
        public boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean decodeCachedData();

    public abstract boolean decodeCachedResource();

    public abstract boolean isDataCacheable(DataSource dataSource);

    public abstract boolean isResourceCacheable(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
