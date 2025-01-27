package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.KsAdSDKImpl;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class y implements com.kwad.sdk.core.webview.b.a {
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    public static final class a implements com.kwad.sdk.core.b {
        private int screenOrientation;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenOrientation", this.screenOrientation);
            return jSONObject;
        }
    }

    public y(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getScreenOrientation";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.mBridgeContext.yU()) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        a aVar = new a();
        KsAdSDKImpl.get().getContext();
        aVar.screenOrientation = !com.kwad.sdk.utils.ai.DL() ? 1 : 0;
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
