package com.kwad.sdk.core.b.a;

import com.kwad.sdk.m.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ii implements com.kwad.sdk.core.d<com.kwad.sdk.m.c> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        a2(cVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        return b2(cVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cVar.funcSwitch = jSONObject.optLong("funcSwitch");
        cVar.aRD = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                cVar.aRD.add((String) optJSONArray.opt(i10));
            }
        }
        cVar.aRE = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                c.a aVar = new c.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i11));
                cVar.aRE.add(aVar);
            }
        }
        cVar.byteCount = jSONObject.optLong("byteCount");
        cVar.sampleRate = jSONObject.optDouble("sampleRate");
        cVar.aRF = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                com.kwad.sdk.m.a.a aVar2 = new com.kwad.sdk.m.a.a();
                aVar2.parseJson(optJSONArray3.optJSONObject(i12));
                cVar.aRF.add(aVar2);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.m.c cVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = cVar.funcSwitch;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "funcSwitch", j10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "urlList", cVar.aRD);
        com.kwad.sdk.utils.x.putValue(jSONObject, "actConfigList", cVar.aRE);
        long j11 = cVar.byteCount;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "byteCount", j11);
        }
        double d10 = cVar.sampleRate;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sampleRate", d10);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "anchorNodeList", cVar.aRF);
        return jSONObject;
    }
}
