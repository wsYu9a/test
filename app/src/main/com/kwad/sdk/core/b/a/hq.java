package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class hq implements com.kwad.sdk.core.d<com.kwad.sdk.g.a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aMy = jSONObject.optString("packageId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aMy)) {
            bVar.aMy = "";
        }
        bVar.aMz = jSONObject.optString("zipFileName");
        if (obj.toString().equals(bVar.aMz)) {
            bVar.aMz = "";
        }
        bVar.aMA = jSONObject.optString("zipPath");
        if (obj.toString().equals(bVar.aMA)) {
            bVar.aMA = "";
        }
        bVar.packageUrl = jSONObject.optString("packageUrl");
        if (obj.toString().equals(bVar.packageUrl)) {
            bVar.packageUrl = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.amT = jSONObject.optString("checksum");
        if (obj.toString().equals(bVar.amT)) {
            bVar.amT = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.aMC = jSONObject.optBoolean("public");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.g.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.aMy;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "packageId", bVar.aMy);
        }
        String str2 = bVar.aMz;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "zipFileName", bVar.aMz);
        }
        String str3 = bVar.aMA;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "zipPath", bVar.aMA);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.amT;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "checksum", bVar.amT);
        }
        int i10 = bVar.loadType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "loadType", i10);
        }
        int i11 = bVar.packageType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "packageType", i11);
        }
        boolean z10 = bVar.aMC;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "public", z10);
        }
        return jSONObject;
    }
}
