package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class u implements com.kwad.sdk.core.d<com.kwad.sdk.internal.api.a> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.aaM = jSONObject.optInt("thirdAge");
        aVar.aaN = jSONObject.optInt("thirdGender");
        String optString = jSONObject.optString("thirdInterest");
        aVar.aaO = optString;
        if (optString == JSONObject.NULL) {
            aVar.aaO = "";
        }
        String optString2 = jSONObject.optString("prevTitle");
        aVar.aaP = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.aaP = "";
        }
        String optString3 = jSONObject.optString("postTitle");
        aVar.aaQ = optString3;
        if (optString3 == JSONObject.NULL) {
            aVar.aaQ = "";
        }
        String optString4 = jSONObject.optString("historyTitle");
        aVar.aaR = optString4;
        if (optString4 == JSONObject.NULL) {
            aVar.aaR = "";
        }
        String optString5 = jSONObject.optString("channel");
        aVar.aaS = optString5;
        if (optString5 == JSONObject.NULL) {
            aVar.aaS = "";
        }
        aVar.aaT = jSONObject.optLong("cpmBidFloor");
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = aVar.aaM;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdAge", i2);
        }
        int i3 = aVar.aaN;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdGender", i3);
        }
        String str = aVar.aaO;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "thirdInterest", aVar.aaO);
        }
        String str2 = aVar.aaP;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "prevTitle", aVar.aaP);
        }
        String str3 = aVar.aaQ;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "postTitle", aVar.aaQ);
        }
        String str4 = aVar.aaR;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "historyTitle", aVar.aaR);
        }
        String str5 = aVar.aaS;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "channel", aVar.aaS);
        }
        long j2 = aVar.aaT;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cpmBidFloor", j2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.internal.api.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
