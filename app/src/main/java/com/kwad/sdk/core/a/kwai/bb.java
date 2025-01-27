package com.kwad.sdk.core.a.kwai;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bb implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.kwai.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ase = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("systemFilterList");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                aVar.ase.add((String) optJSONArray.opt(i2));
            }
        }
        aVar.asf = new ArrayList();
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sdkFilterList");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                aVar.asf.add((String) optJSONArray2.opt(i3));
            }
        }
        aVar.asg = new ArrayList();
        JSONArray optJSONArray3 = jSONObject.optJSONArray("matrixPrinterNameList");
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                aVar.asg.add((String) optJSONArray3.opt(i4));
            }
        }
        aVar.ash = new ArrayList();
        JSONArray optJSONArray4 = jSONObject.optJSONArray("commonPrinterNameList");
        if (optJSONArray4 != null) {
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                aVar.ash.add((String) optJSONArray4.opt(i5));
            }
        }
        aVar.asi = new ArrayList();
        JSONArray optJSONArray5 = jSONObject.optJSONArray("featureConfigList");
        if (optJSONArray5 != null) {
            for (int i6 = 0; i6 < optJSONArray5.length(); i6++) {
                com.kwad.sdk.crash.online.monitor.kwai.b bVar = new com.kwad.sdk.crash.online.monitor.kwai.b();
                bVar.parseJson(optJSONArray5.optJSONObject(i6));
                aVar.asi.add(bVar);
            }
        }
        aVar.ask = jSONObject.optInt("afterFilterSystemCheckNum", new Integer("5").intValue());
        aVar.asl = jSONObject.optInt("batchNum", new Integer("10").intValue());
        aVar.aii = jSONObject.optDouble("ratio", new Double("0.01").doubleValue());
        aVar.asm = jSONObject.optInt("monitorSwitch");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "systemFilterList", aVar.ase);
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkFilterList", aVar.asf);
        com.kwad.sdk.utils.t.putValue(jSONObject, "matrixPrinterNameList", aVar.asg);
        com.kwad.sdk.utils.t.putValue(jSONObject, "commonPrinterNameList", aVar.ash);
        com.kwad.sdk.utils.t.putValue(jSONObject, "featureConfigList", aVar.asi);
        com.kwad.sdk.utils.t.putValue(jSONObject, "afterFilterSystemCheckNum", aVar.ask);
        com.kwad.sdk.utils.t.putValue(jSONObject, "batchNum", aVar.asl);
        com.kwad.sdk.utils.t.putValue(jSONObject, "ratio", aVar.aii);
        int i2 = aVar.asm;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "monitorSwitch", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.kwai.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
