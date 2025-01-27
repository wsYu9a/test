package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import android.text.TextUtils;
import com.alimm.tanx.ui.image.glide.Glide;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.model.GlideUrl;
import com.alimm.tanx.ui.image.glide.load.model.Headers;
import com.alimm.tanx.ui.image.glide.load.model.ModelCache;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import java.io.InputStream;

/* loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<T> implements StreamModelLoader<T> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<T, GlideUrl> modelCache;

    public BaseGlideUrlLoader(Context context) {
        this(context, (ModelCache) null);
    }

    public Headers getHeaders(T t10, int i10, int i11) {
        return Headers.DEFAULT;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(T t10, int i10, int i11) {
        ModelCache<T, GlideUrl> modelCache = this.modelCache;
        GlideUrl glideUrl = modelCache != null ? modelCache.get(t10, i10, i11) : null;
        if (glideUrl == null) {
            String url = getUrl(t10, i10, i11);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(t10, i10, i11));
            ModelCache<T, GlideUrl> modelCache2 = this.modelCache;
            if (modelCache2 != null) {
                modelCache2.put(t10, i10, i11, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        return this.concreteLoader.getResourceFetcher(glideUrl, i10, i11);
    }

    public abstract String getUrl(T t10, int i10, int i11);

    public BaseGlideUrlLoader(Context context, ModelCache<T, GlideUrl> modelCache) {
        this((ModelLoader<GlideUrl, InputStream>) Glide.buildModelLoader(GlideUrl.class, InputStream.class, context), modelCache);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.concreteLoader = modelLoader;
        this.modelCache = null;
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<T, GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }
}
