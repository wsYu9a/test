package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b implements com.kwad.sdk.core.webview.b.a {
    private AdTemplate mAdTemplate;
    protected final com.kwad.sdk.core.webview.b mBridgeContext;

    public b(@NonNull com.kwad.sdk.core.webview.b bVar, @NonNull AdTemplate adTemplate) {
        this.mBridgeContext = bVar;
        this.mAdTemplate = adTemplate;
    }

    private void R(AdTemplate adTemplate) {
        adTemplate.mIsForceJumpLandingPage = true;
        com.kwad.components.core.d.b.a.a(new a.C0172a(this.mBridgeContext.LD.getContext()).I(adTemplate).ap(1).aq(false));
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "activityMiddlePageConvert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("adTemplate")) {
                String string = jSONObject.getString("adTemplate");
                AdTemplate adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(string));
                R(adTemplate);
            } else {
                R(this.mAdTemplate);
            }
            cVar.a(null);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
