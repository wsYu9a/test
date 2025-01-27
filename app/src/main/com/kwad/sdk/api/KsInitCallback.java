package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

@KsAdSdkApi
@Keep
/* loaded from: classes3.dex */
public interface KsInitCallback {
    void onFail(int i10, String str);

    void onSuccess();
}
