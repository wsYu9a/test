package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.ranger.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gt implements com.kwad.sdk.core.d<com.kwad.sdk.ranger.d> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.axS = jSONObject.optLong("funcSwitch");
        dVar.axT = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("urlList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                dVar.axT.add((String) optJSONArray.opt(i2));
            }
        }
        dVar.axU = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("actConfigList");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                d.a aVar = new d.a();
                aVar.parseJson(optJSONArray2.optJSONObject(i3));
                dVar.axU.add(aVar);
            }
        }
        dVar.axV = jSONObject.optLong("byteCount");
        dVar.axW = jSONObject.optDouble("sampleRate");
        dVar.axX = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("anchorNodeList");
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                com.kwad.sdk.ranger.kwai.a aVar2 = new com.kwad.sdk.ranger.kwai.a();
                aVar2.parseJson(optJSONArray3.optJSONObject(i4));
                dVar.axX.add(aVar2);
            }
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = dVar.axS;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "funcSwitch", j2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "urlList", dVar.axT);
        com.kwad.sdk.utils.t.putValue(jSONObject, "actConfigList", dVar.axU);
        long j3 = dVar.axV;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "byteCount", j3);
        }
        double d2 = dVar.axW;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sampleRate", d2);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "anchorNodeList", dVar.axX);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.ranger.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }
}
