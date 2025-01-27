package com.alimm.tanx.ui.image.glide.load.model;

import com.alimm.tanx.ui.image.glide.util.LruCache;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.Queue;

/* loaded from: classes.dex */
public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    /* renamed from: com.alimm.tanx.ui.image.glide.load.model.ModelCache$1 */
    public class AnonymousClass1 extends LruCache<ModelKey<A>, B> {
        public AnonymousClass1(int i10) {
            super(i10);
        }

        @Override // com.alimm.tanx.ui.image.glide.util.LruCache
        public /* bridge */ /* synthetic */ void onItemEvicted(Object obj, Object obj2) {
            onItemEvicted((ModelKey) obj, (ModelKey<A>) obj2);
        }

        public void onItemEvicted(ModelKey<A> modelKey, B b10) {
            modelKey.release();
        }
    }

    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> ModelKey<A> get(A a10, int i10, int i11) {
            ModelKey<A> modelKey = (ModelKey) KEY_QUEUE.poll();
            if (modelKey == null) {
                modelKey = new ModelKey<>();
            }
            ((ModelKey) modelKey).model = a10;
            ((ModelKey) modelKey).width = i10;
            ((ModelKey) modelKey).height = i11;
            return modelKey;
        }

        private void init(A a10, int i10, int i11) {
            this.model = a10;
            this.width = i10;
            this.height = i11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            return this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model);
        }

        public int hashCode() {
            return this.model.hashCode() + (((this.height * 31) + this.width) * 31);
        }

        public void release() {
            KEY_QUEUE.offer(this);
        }
    }

    public ModelCache() {
        this(250);
    }

    public B get(A a10, int i10, int i11) {
        ModelKey<A> modelKey = ModelKey.get(a10, i10, i11);
        B b10 = this.cache.get(modelKey);
        modelKey.release();
        return b10;
    }

    public void put(A a10, int i10, int i11, B b10) {
        this.cache.put(ModelKey.get(a10, i10, i11), b10);
    }

    public ModelCache(int i10) {
        this.cache = new LruCache<ModelKey<A>, B>(i10) { // from class: com.alimm.tanx.ui.image.glide.load.model.ModelCache.1
            public AnonymousClass1(int i102) {
                super(i102);
            }

            @Override // com.alimm.tanx.ui.image.glide.util.LruCache
            public /* bridge */ /* synthetic */ void onItemEvicted(Object obj, Object obj2) {
                onItemEvicted((ModelKey) obj, (ModelKey<A>) obj2);
            }

            public void onItemEvicted(ModelKey<A> modelKey, B b10) {
                modelKey.release();
            }
        };
    }
}
