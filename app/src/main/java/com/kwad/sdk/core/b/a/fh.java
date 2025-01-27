package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.config.item.h;
import com.shu.priory.config.AdKeys;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class fh implements com.kwad.sdk.core.d<h.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(h.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(h.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.axi = jSONObject.optString("imei");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.axi)) {
            aVar.axi = "";
        }
        aVar.axj = jSONObject.optString(AdKeys.OAID);
        if (obj.toString().equals(aVar.axj)) {
            aVar.axj = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(h.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.axi;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "imei", aVar.axi);
        }
        String str2 = aVar.axj;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, AdKeys.OAID, aVar.axj);
        }
        return jSONObject;
    }
}
