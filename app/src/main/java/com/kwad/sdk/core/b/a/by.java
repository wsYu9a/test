package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class by implements com.kwad.sdk.core.d<com.kwad.sdk.crash.online.monitor.block.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aLf = jSONObject.optString("printerName");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.aLf)) {
            dVar.aLf = "";
        }
        dVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (obj.toString().equals(dVar.errorMsg)) {
            dVar.errorMsg = "";
        }
        dVar.aLg = jSONObject.optBoolean("isDisable");
        dVar.aLh = jSONObject.optBoolean("hasMatrix");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.online.monitor.block.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aLf;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "printerName", dVar.aLf);
        }
        String str2 = dVar.errorMsg;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, dVar.errorMsg);
        }
        boolean z10 = dVar.aLg;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isDisable", z10);
        }
        boolean z11 = dVar.aLh;
        if (z11) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "hasMatrix", z11);
        }
        return jSONObject;
    }
}
