package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ay extends com.kwad.components.core.webview.tachikoma.a.w {

    public static final class a implements com.kwad.sdk.core.b {
        private String aaM;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.x.putValue(jSONObject, "lifeStatus", this.aaM);
            return jSONObject;
        }
    }

    private void aR(String str) {
        a aVar = new a();
        aVar.aaM = str;
        b(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public final void tu() {
        aR("showStart");
    }

    public final void tv() {
        aR("showEnd");
    }

    public final void tw() {
        aR("hideStart");
    }

    public final void tx() {
        aR("hideEnd");
    }

    public final void ty() {
        aR("pageVisiable");
    }

    public final void tz() {
        aR("pageInvisiable");
    }
}
