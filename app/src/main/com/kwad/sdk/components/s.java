package com.kwad.sdk.components;

import android.view.View;
import java.util.Map;

/* loaded from: classes3.dex */
public interface s {
    void a(k kVar);

    void a(q qVar);

    void a(String str, String str2, r rVar);

    void b(com.kwad.sdk.core.webview.c.g gVar);

    n bd(String str);

    void c(com.kwad.sdk.core.webview.c.a aVar);

    Object execute(String str);

    int getUniqId();

    View getView();

    void onDestroy();

    void setCustomEnv(Map<String, Object> map);
}
