package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e extends v {
    private final b UD;

    static class a implements com.kwad.sdk.core.b {
        public int height;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }

    public interface b {
        @MainThread
        int iZ();
    }

    public e(b bVar) {
        this.UD = bVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.UD;
        if (bVar != null) {
            aVar.height = bVar.iZ();
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
