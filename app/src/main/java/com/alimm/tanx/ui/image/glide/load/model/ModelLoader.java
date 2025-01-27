package com.alimm.tanx.ui.image.glide.load.model;

import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;

/* loaded from: classes.dex */
public interface ModelLoader<T, Y> {
    DataFetcher<Y> getResourceFetcher(T t10, int i10, int i11);
}
