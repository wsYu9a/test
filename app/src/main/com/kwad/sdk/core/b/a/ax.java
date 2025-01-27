package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ax implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.j.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.status = jSONObject.optInt("status");
        bVar.asm = jSONObject.optInt("ad_action_type");
        bVar.ase = jSONObject.optString("origin_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.ase)) {
            bVar.ase = "";
        }
        bVar.asf = jSONObject.optString("final_url");
        if (obj.toString().equals(bVar.asf)) {
            bVar.asf = "";
        }
        bVar.asn = jSONObject.optInt("request_type");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.commercial.j.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.status;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "status", i10);
        }
        int i11 = bVar.asm;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "ad_action_type", i11);
        }
        String str = bVar.ase;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "origin_url", bVar.ase);
        }
        String str2 = bVar.asf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "final_url", bVar.asf);
        }
        int i12 = bVar.asn;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "request_type", i12);
        }
        return jSONObject;
    }
}
