package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class u implements com.kwad.sdk.core.webview.b.a {
    protected b SF;
    protected final com.kwad.sdk.core.webview.b mBridgeContext;

    public static class a implements com.kwad.sdk.core.b {
        public int height;
        public int width;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", this.width);
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    public interface b {
        void a(a aVar);
    }

    public u(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
    }

    public final void a(b bVar) {
        this.SF = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getContainerLimit";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a();
        b bVar = this.SF;
        if (bVar != null) {
            bVar.a(aVar);
        } else {
            aVar.width = this.mBridgeContext.LD.getWidth();
            aVar.height = this.mBridgeContext.LD.getHeight();
        }
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
