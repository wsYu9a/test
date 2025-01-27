package com.kwad.sdk.components;

import android.view.View;
import java.util.Map;

/* loaded from: classes2.dex */
public interface l {
    void a(j jVar);

    void a(com.kwad.sdk.core.webview.b.g gVar);

    void a(String str, String str2, k kVar);

    void c(com.kwad.sdk.core.webview.b.a aVar);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);

    void unregisterJsBridge();
}
