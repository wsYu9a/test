package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class dt implements com.kwad.sdk.core.d<com.kwad.sdk.crash.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aKD = jSONObject.optInt("funcSwitch");
        bVar.aKE = jSONObject.optString("minSdkVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.aKE)) {
            bVar.aKE = "";
        }
        bVar.aKF = jSONObject.optString("maxSdkVersionExclude");
        if (obj.toString().equals(bVar.aKF)) {
            bVar.aKF = "";
        }
        bVar.sdkType = jSONObject.optInt("sdkType");
        bVar.aKG = jSONObject.optString("md5V7");
        if (obj.toString().equals(bVar.aKG)) {
            bVar.aKG = "";
        }
        bVar.aKH = jSONObject.optString("md5V8");
        if (obj.toString().equals(bVar.aKH)) {
            bVar.aKH = "";
        }
        bVar.version = jSONObject.optString("version");
        if (obj.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.aKI = jSONObject.optString("v7Url");
        if (obj.toString().equals(bVar.aKI)) {
            bVar.aKI = "";
        }
        bVar.aKJ = jSONObject.optString("v8Url");
        if (obj.toString().equals(bVar.aKJ)) {
            bVar.aKJ = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.crash.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i10 = bVar.aKD;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "funcSwitch", i10);
        }
        String str = bVar.aKE;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "minSdkVersion", bVar.aKE);
        }
        String str2 = bVar.aKF;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "maxSdkVersionExclude", bVar.aKF);
        }
        int i11 = bVar.sdkType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkType", i11);
        }
        String str3 = bVar.aKG;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "md5V7", bVar.aKG);
        }
        String str4 = bVar.aKH;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "md5V8", bVar.aKH);
        }
        String str5 = bVar.version;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "version", bVar.version);
        }
        String str6 = bVar.aKI;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "v7Url", bVar.aKI);
        }
        String str7 = bVar.aKJ;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "v8Url", bVar.aKJ);
        }
        return jSONObject;
    }
}
