package com.kwad.sdk.core.a.kwai;

import com.kwad.components.ad.reward.h.t;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class hn implements com.kwad.sdk.core.d<t.a> {
    /* renamed from: a */
    private static void a2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.xe = jSONObject.optBoolean("needCloseNeo");
    }

    /* renamed from: b */
    private static JSONObject b2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = aVar.xe;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "needCloseNeo", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(t.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(t.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
