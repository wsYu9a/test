package com.kwad.components.offline.api.adLive;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.api.SdkConfig;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface IAdLiveOfflineCompo extends IOfflineCompo {
    public static final String IMPL = "com.kwad.sdk.AdLiveOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adLive";

    public enum AdLiveState {
        READY,
        SO_FAIL
    }

    IAdLiveEndRequest getAdLiveEndRequest(String str);

    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2);

    AdLiveState getState();

    IAdLiveOfflineView getView(Context context, int i2);

    void initReal(Context context, SdkConfig sdkConfig, IAdLiveOfflineCompoInitConfig iAdLiveOfflineCompoInitConfig, InitCallBack initCallBack);

    void onConfigRefresh(Context context, @NonNull JSONObject jSONObject);
}
