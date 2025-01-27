package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.a.kwai.h;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gm implements com.kwad.sdk.core.d<h.b> {
    /* renamed from: a */
    private static void a2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.UG = jSONObject.optInt("playEndType");
    }

    /* renamed from: b */
    private static JSONObject b2(h.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.UG;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playEndType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
