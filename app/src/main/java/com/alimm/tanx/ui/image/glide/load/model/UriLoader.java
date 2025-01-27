package com.alimm.tanx.ui.image.glide.load.model;

import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.sigmob.sdk.base.k;

/* loaded from: classes.dex */
public abstract class UriLoader<T> implements ModelLoader<Uri, T> {
    private final Context context;
    private final ModelLoader<GlideUrl, T> urlLoader;

    public UriLoader(Context context, ModelLoader<GlideUrl, T> modelLoader) {
        this.context = context;
        this.urlLoader = modelLoader;
    }

    private static boolean isLocalUri(String str) {
        return k.f18193y.equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    public abstract DataFetcher<T> getAssetPathFetcher(Context context, String str);

    public abstract DataFetcher<T> getLocalUriFetcher(Context context, Uri uri);

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public final DataFetcher<T> getResourceFetcher(Uri uri, int i10, int i11) {
        String scheme = uri.getScheme();
        if (isLocalUri(scheme)) {
            if (!AssetUriParser.isAssetUri(uri)) {
                return getLocalUriFetcher(this.context, uri);
            }
            return getAssetPathFetcher(this.context, AssetUriParser.toAssetPath(uri));
        }
        if (this.urlLoader == null || !("http".equals(scheme) || "https".equals(scheme))) {
            return null;
        }
        return this.urlLoader.getResourceFetcher(new GlideUrl(uri.toString()), i10, i11);
    }
}
