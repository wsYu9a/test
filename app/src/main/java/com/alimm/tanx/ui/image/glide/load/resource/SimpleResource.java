package com.alimm.tanx.ui.image.glide.load.resource;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: classes.dex */
public class SimpleResource<T> implements Resource<T> {
    protected final T data;

    public SimpleResource(T t10) {
        if (t10 == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.data = t10;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final T get() {
        return this.data;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.engine.Resource
    public void recycle() {
    }
}
