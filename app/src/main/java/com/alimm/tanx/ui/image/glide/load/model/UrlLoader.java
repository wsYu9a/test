package com.alimm.tanx.ui.image.glide.load.model;

import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import java.net.URL;

/* loaded from: classes.dex */
public class UrlLoader<T> implements ModelLoader<URL, T> {
    private final ModelLoader<GlideUrl, T> glideUrlLoader;

    public UrlLoader(ModelLoader<GlideUrl, T> modelLoader) {
        this.glideUrlLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(URL url, int i10, int i11) {
        return this.glideUrlLoader.getResourceFetcher(new GlideUrl(url), i10, i11);
    }
}
