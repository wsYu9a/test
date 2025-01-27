package com.alimm.tanx.ui.image.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.data.DataFetcher;

/* loaded from: classes.dex */
public class ResourceLoader<T> implements ModelLoader<Integer, T> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, T> uriLoader;

    public ResourceLoader(Context context, ModelLoader<Uri, T> modelLoader) {
        this(context.getResources(), modelLoader);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, T> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(Integer num, int i10, int i11) {
        Uri uri;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("android.resource://");
            sb2.append(this.resources.getResourcePackageName(num.intValue()));
            sb2.append('/');
            sb2.append(this.resources.getResourceTypeName(num.intValue()));
            sb2.append('/');
            sb2.append(this.resources.getResourceEntryName(num.intValue()));
            uri = Uri.parse(sb2.toString());
        } catch (Resources.NotFoundException e10) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Received invalid resource id: " + num, e10);
            }
            uri = null;
        }
        if (uri != null) {
            return this.uriLoader.getResourceFetcher(uri, i10, i11);
        }
        return null;
    }
}
