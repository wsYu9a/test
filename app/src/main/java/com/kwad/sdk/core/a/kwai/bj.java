package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.q;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bj implements com.kwad.sdk.core.d<q.a> {
    /* renamed from: a */
    private static void a2(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ajN = jSONObject.optInt("posIdWidth");
        aVar.ajO = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b */
    private static JSONObject b2(q.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.ajN;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posIdWidth", i2);
        }
        int i3 = aVar.ajO;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posIdHeight", i3);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(q.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(q.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
