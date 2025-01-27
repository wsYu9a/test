package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cd implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.d.b.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.f11975x = jSONObject.optDouble("x");
        cVar.f11976y = jSONObject.optDouble("y");
        cVar.width = jSONObject.optInt("width");
        cVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.d.b.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d10 = cVar.f11975x;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "x", d10);
        }
        double d11 = cVar.f11976y;
        if (d11 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "y", d11);
        }
        int i10 = cVar.width;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "width", i10);
        }
        int i11 = cVar.height;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "height", i11);
        }
        return jSONObject;
    }
}
