package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ho implements com.kwad.sdk.core.d<com.kwad.components.core.webview.a.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.Yw = jSONObject.optString("originalID");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(cVar.Yw)) {
            cVar.Yw = "";
        }
        cVar.Yx = jSONObject.optString(t8.a.f30751f);
        if (obj.toString().equals(cVar.Yx)) {
            cVar.Yx = "";
        }
        cVar.Yy = jSONObject.optInt("adCacheId");
        cVar.Li = jSONObject.optString("creativeId");
        if (obj.toString().equals(cVar.Li)) {
            cVar.Li = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.components.core.webview.a.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cVar.Yw;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "originalID", cVar.Yw);
        }
        String str2 = cVar.Yx;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, t8.a.f30751f, cVar.Yx);
        }
        int i10 = cVar.Yy;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adCacheId", i10);
        }
        String str3 = cVar.Li;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", cVar.Li);
        }
        return jSONObject;
    }
}
