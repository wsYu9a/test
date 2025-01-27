package com.kwad.sdk.utils;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ak {
    private Map<String, com.kwad.sdk.core.webview.a> aTW;
    private Map<String, com.kwad.sdk.core.webview.c.c> aTX;

    public final void a(String str, com.kwad.sdk.core.webview.a aVar) {
        this.aTW.put(str, aVar);
    }

    public final void b(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.aTX.put(str, cVar);
    }

    public final com.kwad.sdk.core.webview.a gO(String str) {
        return this.aTW.get(str);
    }

    public final com.kwad.sdk.core.webview.c.c gP(String str) {
        return this.aTX.get(str);
    }

    public final void release() {
        Iterator<com.kwad.sdk.core.webview.a> it = this.aTW.values().iterator();
        while (it.hasNext()) {
            it.next().oZ();
        }
        this.aTW.clear();
        this.aTX.clear();
    }
}
