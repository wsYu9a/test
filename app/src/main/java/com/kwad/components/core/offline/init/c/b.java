package com.kwad.components.core.offline.init.c;

import android.content.Context;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.components.offline.api.core.webview.IWebView;

/* loaded from: classes2.dex */
public final class b implements IWebView {
    @Override // com.kwad.components.offline.api.core.webview.IWebView
    public final BaseKsWebView createWebView(Context context) {
        return new a(context);
    }
}
