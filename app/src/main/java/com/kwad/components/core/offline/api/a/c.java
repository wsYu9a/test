package com.kwad.components.core.offline.api.a;

import android.content.Context;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.l;

/* loaded from: classes2.dex */
public interface c extends com.kwad.sdk.components.a {
    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i2);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    l getView(Context context, String str, int i2, int i3);

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i2, TKDownloadListener tKDownloadListener);

    void onDestroy();
}
