package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.kuaishou.weapon.p0.t;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class AssetFileDescriptorLocalUriFetcher extends LocalUriFetcher<AssetFileDescriptor> {
    public AssetFileDescriptorLocalUriFetcher(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // com.bumptech.glide.load.data.DataFetcher
    @NonNull
    public Class<AssetFileDescriptor> getDataClass() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.LocalUriFetcher
    public AssetFileDescriptor loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, t.f11211k);
        if (openAssetFileDescriptor != null) {
            return openAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
