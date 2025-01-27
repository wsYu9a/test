package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.report.n;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class cf implements com.kwad.sdk.core.d<n.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(n.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(n.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aDc = jSONObject.optInt("posIdWidth");
        aVar.aDd = jSONObject.optInt("posIdHeight");
    }

    /* renamed from: b */
    private static JSONObject b2(n.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = aVar.aDc;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "posIdWidth", i10);
        }
        int i11 = aVar.aDd;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "posIdHeight", i11);
        }
        return jSONObject;
    }
}
