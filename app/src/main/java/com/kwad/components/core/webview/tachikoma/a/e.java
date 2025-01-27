package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class e extends w {
    private final b acM;

    public static class a implements com.kwad.sdk.core.b {
        public int height;

        private a() {
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.x.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public interface b {
        @MainThread
        int jx();
    }

    public e(b bVar) {
        this.acM = bVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.acM;
        if (bVar != null) {
            aVar.height = bVar.jx();
            cVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
