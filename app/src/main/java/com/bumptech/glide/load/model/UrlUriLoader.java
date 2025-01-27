package com.bumptech.glide.load.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import b.b.a.b.b;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.http.HttpHost;

/* loaded from: classes.dex */
public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {
    private static final Set<String> SCHEMES = Collections.unmodifiableSet(new HashSet(Arrays.asList(HttpHost.DEFAULT_SCHEME_NAME, b.f4198a)));
    private final ModelLoader<GlideUrl, Data> urlLoader;

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        @NonNull
        public ModelLoader<Uri, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.build(GlideUrl.class, InputStream.class));
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.urlLoader = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData<Data> buildLoadData(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        return this.urlLoader.buildLoadData(new GlideUrl(uri.toString()), i2, i3, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean handles(@NonNull Uri uri) {
        return SCHEMES.contains(uri.getScheme());
    }
}
