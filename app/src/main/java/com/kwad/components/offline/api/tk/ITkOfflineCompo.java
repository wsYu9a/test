package com.kwad.components.offline.api.tk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.api.SdkConfig;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface ITkOfflineCompo extends IOfflineCompo {
    public static final String IMPL = "com.kwad.tachikoma.TkOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.tachikoma";

    public enum TKState {
        READY,
        SO_FAIL
    }

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i2);

    String getJsBaseDir(Context context, String str);

    TKState getState();

    String getTKVersion();

    IOfflineCompoTachikomaView getView(Context context, String str, int i2, int i3);

    void initReal(Context context, SdkConfig sdkConfig, ITkOfflineCompoInitConfig iTkOfflineCompoInitConfig, InitCallBack initCallBack);

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i2, TKDownloadListener tKDownloadListener);

    void onConfigRefresh(Context context, @NonNull JSONObject jSONObject);

    void onDestroy();
}
