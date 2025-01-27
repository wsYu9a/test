package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ga implements com.kwad.sdk.core.d<com.kwad.sdk.f.kwai.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("packageId");
        bVar.atm = optString;
        if (optString == JSONObject.NULL) {
            bVar.atm = "";
        }
        String optString2 = jSONObject.optString("zipFileName");
        bVar.atn = optString2;
        if (optString2 == JSONObject.NULL) {
            bVar.atn = "";
        }
        String optString3 = jSONObject.optString("zipPath");
        bVar.ato = optString3;
        if (optString3 == JSONObject.NULL) {
            bVar.ato = "";
        }
        String optString4 = jSONObject.optString("packageUrl");
        bVar.packageUrl = optString4;
        if (optString4 == JSONObject.NULL) {
            bVar.packageUrl = "";
        }
        String optString5 = jSONObject.optString("version");
        bVar.version = optString5;
        if (optString5 == JSONObject.NULL) {
            bVar.version = "";
        }
        String optString6 = jSONObject.optString("checksum");
        bVar.atq = optString6;
        if (optString6 == JSONObject.NULL) {
            bVar.atq = "";
        }
        bVar.loadType = jSONObject.optInt("loadType");
        bVar.packageType = jSONObject.optInt("packageType");
        bVar.atr = jSONObject.optBoolean("public");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.atm;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageId", bVar.atm);
        }
        String str2 = bVar.atn;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "zipFileName", bVar.atn);
        }
        String str3 = bVar.ato;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "zipPath", bVar.ato);
        }
        String str4 = bVar.packageUrl;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageUrl", bVar.packageUrl);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.atq;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "checksum", bVar.atq);
        }
        int i2 = bVar.loadType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "loadType", i2);
        }
        int i3 = bVar.packageType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "packageType", i3);
        }
        boolean z = bVar.atr;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "public", z);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.f.kwai.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
