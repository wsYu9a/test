package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Util;

/* loaded from: classes2.dex */
class AttributeStrategy implements LruPoolStrategy {
    private final KeyPool keyPool = new KeyPool();
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap<>();

    @VisibleForTesting
    public static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            return this.width == key.width && this.height == key.height && this.config == key.config;
        }

        public int hashCode() {
            int i10 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config config = this.config;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public void init(int i10, int i11, Bitmap.Config config) {
            this.width = i10;
            this.height = i11;
            this.config = config;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
        }
    }

    @VisibleForTesting
    public static class KeyPool extends BaseKeyPool<Key> {
        public Key get(int i10, int i11, Bitmap.Config config) {
            Key key = get();
            key.init(i10, i11, config);
            return key;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        public Key create() {
            return new Key(this);
        }
    }

    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int i10, int i11, Bitmap.Config config) {
        return this.groupedMap.get(this.keyPool.get(i10, i11, config));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap bitmap) {
        this.groupedMap.put(this.keyPool.get(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    public static String getBitmapString(int i10, int i11, Bitmap.Config config) {
        return "[" + i10 + "x" + i11 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int i10, int i11, Bitmap.Config config) {
        return getBitmapString(i10, i11, config);
    }
}
