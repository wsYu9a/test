package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bw implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.a.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aLn = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                aVar.aLn.add((String) optJSONArray.opt(i10));
            }
        }
        aVar.aLo = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (optJSONArray2 != null) {
            for (int i11 = 0; i11 < optJSONArray2.length(); i11++) {
                aVar.aLo.add((String) optJSONArray2.opt(i11));
            }
        }
        aVar.aLp = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (optJSONArray3 != null) {
            for (int i12 = 0; i12 < optJSONArray3.length(); i12++) {
                aVar.aLp.add((String) optJSONArray3.opt(i12));
            }
        }
        aVar.aLq = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (optJSONArray4 != null) {
            for (int i13 = 0; i13 < optJSONArray4.length(); i13++) {
                aVar.aLq.add((String) optJSONArray4.opt(i13));
            }
        }
        aVar.aLr = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (optJSONArray5 != null) {
            for (int i14 = 0; i14 < optJSONArray5.length(); i14++) {
                com.kwad.sdk.crash.online.monitor.a.b bVar = new com.kwad.sdk.crash.online.monitor.a.b();
                bVar.parseJson(optJSONArray5.optJSONObject(i14));
                aVar.aLr.add(bVar);
            }
        }
        aVar.aLt = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        aVar.aLu = jSONObject.optInt("batchNum", new Integer("10").intValue());
        aVar.arO = jSONObject.optDouble(com.sigmob.sdk.base.k.B, new Double("0.01").doubleValue());
        aVar.aLv = jSONObject.optInt("monitorSwitch");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.a.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "systemFilterList", aVar.aLn);
        com.kwad.sdk.utils.x.putValue(jSONObject, "sdkFilterList", aVar.aLo);
        com.kwad.sdk.utils.x.putValue(jSONObject, "matrixPrinterNameList", aVar.aLp);
        com.kwad.sdk.utils.x.putValue(jSONObject, "commonPrinterNameList", aVar.aLq);
        com.kwad.sdk.utils.x.putValue(jSONObject, "featureConfigList", aVar.aLr);
        com.kwad.sdk.utils.x.putValue(jSONObject, "afterFilterSystemCheckNum", aVar.aLt);
        com.kwad.sdk.utils.x.putValue(jSONObject, "batchNum", aVar.aLu);
        com.kwad.sdk.utils.x.putValue(jSONObject, com.sigmob.sdk.base.k.B, aVar.arO);
        int i10 = aVar.aLv;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "monitorSwitch", i10);
        }
        return jSONObject;
    }
}
