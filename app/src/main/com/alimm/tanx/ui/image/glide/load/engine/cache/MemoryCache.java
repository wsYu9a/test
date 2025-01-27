package com.alimm.tanx.ui.image.glide.load.engine.cache;

import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(Resource<?> resource);
    }

    void clearMemory();

    int getCurrentSize();

    int getMaxSize();

    Resource<?> put(Key key, Resource<?> resource);

    Resource<?> remove(Key key);

    void setResourceRemovedListener(ResourceRemovedListener resourceRemovedListener);

    void setSizeMultiplier(float f10);

    void trimMemory(int i10);
}
