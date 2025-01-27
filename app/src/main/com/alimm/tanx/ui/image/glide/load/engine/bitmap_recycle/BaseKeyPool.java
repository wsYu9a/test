package com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle;

import com.alimm.tanx.ui.image.glide.load.engine.bitmap_recycle.Poolable;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.Queue;

/* loaded from: classes.dex */
abstract class BaseKeyPool<T extends Poolable> {
    private static final int MAX_SIZE = 20;
    private final Queue<T> keyPool = Util.createQueue(20);

    public abstract T create();

    public T get() {
        T poll = this.keyPool.poll();
        return poll == null ? create() : poll;
    }

    public void offer(T t10) {
        if (this.keyPool.size() < 20) {
            this.keyPool.offer(t10);
        }
    }
}
