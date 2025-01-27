package com.martian.ttbook.sdk.adcomponents.adsdk;

import android.content.Context;
import android.content.pm.ProviderInfo;
import androidx.core.content.FileProvider;
import b.d.e.c.a.d;

/* loaded from: classes4.dex */
public class JhSdkDownloadProvider extends FileProvider {
    private static final String TAG = "ApiFileProvider";

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        d.k(TAG, "attachInfo enter,info = " + providerInfo.toString());
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        boolean onCreate = super.onCreate();
        d.k(TAG, "onCreate enter");
        return onCreate;
    }
}
