package com.alimm.tanx.ui.image.glide.load.model.stream;

import android.content.Context;
import com.alimm.tanx.ui.image.glide.load.data.ByteArrayFetcher;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;
import com.alimm.tanx.ui.image.glide.load.model.GenericLoaderFactory;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoader;
import com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

/* loaded from: classes.dex */
public class StreamByteArrayLoader implements StreamModelLoader<byte[]> {

    /* renamed from: id */
    private final String f6331id;

    public static class Factory implements ModelLoaderFactory<byte[], InputStream> {
        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public ModelLoader<byte[], InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamByteArrayLoader();
        }

        @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamByteArrayLoader() {
        this.f6331id = "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(byte[] bArr, int i10, int i11) {
        return new ByteArrayFetcher(bArr, this.f6331id);
    }

    @Deprecated
    public StreamByteArrayLoader(String str) {
        this.f6331id = str;
    }
}
