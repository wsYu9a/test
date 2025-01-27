package com.kwad.components.offline.api.core.webview;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface IBridgeHandler {
    @NonNull
    String getKey();

    void handleJsCall(String str);

    void onDestroy();
}
