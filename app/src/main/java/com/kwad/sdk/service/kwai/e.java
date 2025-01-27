package com.kwad.sdk.service.kwai;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public interface e {
    boolean X(AdTemplate adTemplate);

    String getApiVersion();

    int getApiVersionCode();

    String getAppId();

    String getAppName();

    Context getContext();

    boolean getIsExternal();

    String getSDKVersion();

    boolean hasInitFinish();

    boolean hasLiveCompoReady();

    boolean isPersonalRecommend();

    boolean isProgrammaticRecommend();

    com.kwad.sdk.core.response.a.e rK();
}
