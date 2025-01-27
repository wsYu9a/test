package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsWrapper;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class fy implements com.kwad.sdk.core.d<com.kwad.components.core.webview.kwai.c> {
    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("originalID");
        cVar.RY = optString;
        if (optString == JSONObject.NULL) {
            cVar.RY = "";
        }
        String optString2 = jSONObject.optString(OapsWrapper.KEY_PATH);
        cVar.RZ = optString2;
        if (optString2 == JSONObject.NULL) {
            cVar.RZ = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.RY;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originalID", cVar.RY);
        }
        String str2 = cVar.RZ;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, OapsWrapper.KEY_PATH, cVar.RZ);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.kwai.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }
}
