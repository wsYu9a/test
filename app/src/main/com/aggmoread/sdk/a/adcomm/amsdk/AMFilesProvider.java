package com.aggmoread.sdk.a.adcomm.amsdk;

import android.content.Context;
import android.content.pm.ProviderInfo;
import androidx.core.content.FileProvider;
import com.aggmoread.sdk.z.b.d;

/* loaded from: classes.dex */
public class AMFilesProvider extends FileProvider {
    private static final String TAG = "ApiFileProvider";

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        d.c(TAG, "attachInfo enter,info = " + providerInfo.toString());
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        boolean onCreate = super.onCreate();
        d.c(TAG, "onCreate enter");
        return onCreate;
    }
}
