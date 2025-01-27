package com.kwad.components.core.n.a.d;

import android.content.Context;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.components.s;

/* loaded from: classes3.dex */
public interface c extends com.kwad.sdk.components.b {
    s a(Context context, String str, int i10, int i11, boolean z10);

    StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i10);

    String getJsBaseDir(Context context, String str);

    ITkOfflineCompo.TKState getState();

    void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i10, TKDownloadListener tKDownloadListener);

    void onDestroy();
}
