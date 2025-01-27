package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cl implements com.kwad.sdk.core.d<com.kwad.components.core.webview.tachikoma.b.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.MI = jSONObject.optString("payload");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(gVar.MI)) {
            gVar.MI = "";
        }
        gVar.actionType = jSONObject.optInt("actionType");
        gVar.Yy = jSONObject.optInt("adCacheId");
        gVar.Li = jSONObject.optString("creativeId");
        if (obj.toString().equals(gVar.Li)) {
            gVar.Li = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.tachikoma.b.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.MI;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "payload", gVar.MI);
        }
        int i10 = gVar.actionType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "actionType", i10);
        }
        int i11 = gVar.Yy;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adCacheId", i11);
        }
        String str2 = gVar.Li;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", gVar.Li);
        }
        return jSONObject;
    }
}
