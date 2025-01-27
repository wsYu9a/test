package com.kwad.sdk.core.a.kwai;

import com.kwad.components.core.webview.jshandler.x;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class go implements com.kwad.sdk.core.d<x.a> {
    /* renamed from: a */
    private static void a2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("SDKVersion");
        aVar.SK = optString;
        if (optString == JSONObject.NULL) {
            aVar.SK = "";
        }
        aVar.SL = jSONObject.optInt("SDKVersionCode");
        String optString2 = jSONObject.optString("sdkApiVersion");
        aVar.SM = optString2;
        if (optString2 == JSONObject.NULL) {
            aVar.SM = "";
        }
        aVar.SN = jSONObject.optInt("sdkApiVersionCode");
        aVar.SO = jSONObject.optInt("sdkType");
        String optString3 = jSONObject.optString("appVersion");
        aVar.appVersion = optString3;
        if (optString3 == JSONObject.NULL) {
            aVar.appVersion = "";
        }
        String optString4 = jSONObject.optString("appName");
        aVar.appName = optString4;
        if (optString4 == JSONObject.NULL) {
            aVar.appName = "";
        }
        String optString5 = jSONObject.optString("appId");
        aVar.appId = optString5;
        if (optString5 == JSONObject.NULL) {
            aVar.appId = "";
        }
        String optString6 = jSONObject.optString("networkType");
        aVar.SP = optString6;
        if (optString6 == JSONObject.NULL) {
            aVar.SP = "";
        }
        String optString7 = jSONObject.optString("manufacturer");
        aVar.SQ = optString7;
        if (optString7 == JSONObject.NULL) {
            aVar.SQ = "";
        }
        String optString8 = jSONObject.optString(com.baidu.mobads.sdk.internal.bj.f5604i);
        aVar.model = optString8;
        if (optString8 == JSONObject.NULL) {
            aVar.model = "";
        }
        String optString9 = jSONObject.optString("deviceBrand");
        aVar.SR = optString9;
        if (optString9 == JSONObject.NULL) {
            aVar.SR = "";
        }
        aVar.SS = jSONObject.optInt("osType");
        String optString10 = jSONObject.optString("systemVersion");
        aVar.ST = optString10;
        if (optString10 == JSONObject.NULL) {
            aVar.ST = "";
        }
        aVar.SU = jSONObject.optInt("osApi");
        String optString11 = jSONObject.optString(com.umeng.analytics.pro.am.N);
        aVar.SV = optString11;
        if (optString11 == JSONObject.NULL) {
            aVar.SV = "";
        }
        String optString12 = jSONObject.optString("locale");
        aVar.SW = optString12;
        if (optString12 == JSONObject.NULL) {
            aVar.SW = "";
        }
        aVar.SX = jSONObject.optInt("screenWidth");
        aVar.SY = jSONObject.optInt("screenHeight");
        aVar.SZ = jSONObject.optInt("statusBarHeight");
        aVar.Ta = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b */
    private static JSONObject b2(x.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.SK;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", aVar.SK);
        }
        int i2 = aVar.SL;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i2);
        }
        String str2 = aVar.SM;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", aVar.SM);
        }
        int i3 = aVar.SN;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i3);
        }
        int i4 = aVar.SO;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i4);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", aVar.appId);
        }
        String str6 = aVar.SP;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", aVar.SP);
        }
        String str7 = aVar.SQ;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manufacturer", aVar.SQ);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.baidu.mobads.sdk.internal.bj.f5604i, aVar.model);
        }
        String str9 = aVar.SR;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", aVar.SR);
        }
        int i5 = aVar.SS;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osType", i5);
        }
        String str10 = aVar.ST;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", aVar.ST);
        }
        int i6 = aVar.SU;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i6);
        }
        String str11 = aVar.SV;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.umeng.analytics.pro.am.N, aVar.SV);
        }
        String str12 = aVar.SW;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "locale", aVar.SW);
        }
        int i7 = aVar.SX;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i7);
        }
        int i8 = aVar.SY;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i8);
        }
        int i9 = aVar.SZ;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i9);
        }
        int i10 = aVar.Ta;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i10);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(x.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(x.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
