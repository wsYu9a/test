package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes3.dex */
public final class as implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c YI;
    private a aaA = new a();

    @KsJson
    public class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: id */
        public int f11951id;
        public int status;

        public a() {
        }
    }

    private void r(int i10, int i11) {
        com.kwad.sdk.core.webview.c.c cVar = this.YI;
        if (cVar != null) {
            a aVar = this.aaA;
            aVar.f11951id = i10;
            aVar.status = 2;
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.YI = cVar;
    }

    public final void aQ(int i10) {
        r(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.YI = null;
    }
}
