package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.config.item.j;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class eg implements com.kwad.sdk.core.d<j.a> {
    /* renamed from: a */
    private static void a2(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adX = jSONObject.optInt("horizontalShowDuration", new Integer("180000").intValue());
        aVar.adY = jSONObject.optInt("verticalShowDuration", new Integer("90000").intValue());
    }

    /* renamed from: b */
    private static JSONObject b2(j.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "horizontalShowDuration", aVar.adX);
        com.kwad.sdk.utils.t.putValue(jSONObject, "verticalShowDuration", aVar.adY);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(j.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(j.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
