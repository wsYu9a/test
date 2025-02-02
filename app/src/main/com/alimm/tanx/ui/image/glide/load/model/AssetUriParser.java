package com.alimm.tanx.ui.image.glide.load.model;

import android.net.Uri;
import com.sigmob.sdk.base.k;

/* loaded from: classes.dex */
final class AssetUriParser {
    private static final String ASSET_PATH_SEGMENT = "android_asset";
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final int ASSET_PREFIX_LENGTH = 22;

    private AssetUriParser() {
    }

    public static boolean isAssetUri(Uri uri) {
        return k.f18193y.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && ASSET_PATH_SEGMENT.equals(uri.getPathSegments().get(0));
    }

    public static String toAssetPath(Uri uri) {
        return uri.toString().substring(ASSET_PREFIX_LENGTH);
    }
}
