package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class lc implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.g> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        a2(gVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        return b2(gVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        gVar.aEc = jSONObject.optString("thirdUserId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(gVar.aEc)) {
            gVar.aEc = "";
        }
        gVar.aEd = jSONObject.optString("thirdUserName");
        if (obj.toString().equals(gVar.aEd)) {
            gVar.aEd = "";
        }
        gVar.thirdAge = jSONObject.optInt("thirdAge");
        gVar.thirdGender = jSONObject.optInt("thirdGender");
        gVar.thirdInterest = jSONObject.optString("thirdInterest");
        if (obj.toString().equals(gVar.thirdInterest)) {
            gVar.thirdInterest = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.request.model.g gVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = gVar.aEc;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "thirdUserId", gVar.aEc);
        }
        String str2 = gVar.aEd;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "thirdUserName", gVar.aEd);
        }
        int i10 = gVar.thirdAge;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "thirdAge", i10);
        }
        int i11 = gVar.thirdGender;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "thirdGender", i11);
        }
        String str3 = gVar.thirdInterest;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "thirdInterest", gVar.thirdInterest);
        }
        return jSONObject;
    }
}
