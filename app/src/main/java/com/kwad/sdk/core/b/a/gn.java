package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class gn implements com.kwad.sdk.core.d<com.kwad.sdk.commercial.i.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ase = jSONObject.optString("origin_url");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.ase)) {
            aVar.ase = "";
        }
        aVar.asf = jSONObject.optString("final_url");
        if (obj.toString().equals(aVar.asf)) {
            aVar.asf = "";
        }
        aVar.arW = jSONObject.optString("error_name");
        if (obj.toString().equals(aVar.arW)) {
            aVar.arW = "";
        }
        aVar.asg = jSONObject.optString("macro_type");
        if (obj.toString().equals(aVar.asg)) {
            aVar.asg = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.commercial.i.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.ase;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "origin_url", aVar.ase);
        }
        String str2 = aVar.asf;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "final_url", aVar.asf);
        }
        String str3 = aVar.arW;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "error_name", aVar.arW);
        }
        String str4 = aVar.asg;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "macro_type", aVar.asg);
        }
        return jSONObject;
    }
}
