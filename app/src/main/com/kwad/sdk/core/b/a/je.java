package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.reward.k.t;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class je implements com.kwad.sdk.core.d<t.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(t.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(t.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.yU = jSONObject.optBoolean("needCloseNeo");
    }

    /* renamed from: b */
    private static JSONObject b2(t.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z10 = aVar.yU;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "needCloseNeo", z10);
        }
        return jSONObject;
    }
}
