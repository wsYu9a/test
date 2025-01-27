package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bh implements com.kwad.sdk.core.d<com.kwad.sdk.core.webview.c.a.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.x = jSONObject.optDouble("x");
        bVar.y = jSONObject.optDouble("y");
        bVar.width = jSONObject.optInt("width");
        bVar.height = jSONObject.optInt("height");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d2 = bVar.x;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "x", d2);
        }
        double d3 = bVar.y;
        if (d3 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "y", d3);
        }
        int i2 = bVar.width;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "width", i2);
        }
        int i3 = bVar.height;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.webview.c.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
