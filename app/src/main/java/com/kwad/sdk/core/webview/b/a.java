package com.kwad.sdk.core.webview.b;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface a {
    @NonNull
    String getKey();

    void handleJsCall(String str, @NonNull c cVar);

    void onDestroy();
}
