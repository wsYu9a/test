package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hi implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.d> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        a2(dVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        return b2(dVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        dVar.aDR = jSONObject.optString("mac");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(dVar.aDR)) {
            dVar.aDR = "";
        }
        dVar.aDS = jSONObject.optString("kMac");
        if (obj.toString().equals(dVar.aDS)) {
            dVar.aDS = "";
        }
        dVar.aDT = jSONObject.optInt("connectionType");
        dVar.aDU = jSONObject.optInt("operatorType");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.request.model.d dVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = dVar.aDR;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mac", dVar.aDR);
        }
        String str2 = dVar.aDS;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "kMac", dVar.aDS);
        }
        int i10 = dVar.aDT;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "connectionType", i10);
        }
        int i11 = dVar.aDU;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "operatorType", i11);
        }
        return jSONObject;
    }
}
