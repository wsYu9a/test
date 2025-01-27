package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.webview.c.a;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class dx implements com.kwad.sdk.core.d<a.C0222a> {
    /* renamed from: a */
    private static void a2(a.C0222a c0222a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("SDKVersion");
        c0222a.SK = optString;
        if (optString == JSONObject.NULL) {
            c0222a.SK = "";
        }
        c0222a.SL = jSONObject.optInt("SDKVersionCode");
        String optString2 = jSONObject.optString("tkVersion");
        c0222a.ajB = optString2;
        if (optString2 == JSONObject.NULL) {
            c0222a.ajB = "";
        }
        String optString3 = jSONObject.optString("sdkApiVersion");
        c0222a.SM = optString3;
        if (optString3 == JSONObject.NULL) {
            c0222a.SM = "";
        }
        c0222a.SN = jSONObject.optInt("sdkApiVersionCode");
        c0222a.SO = jSONObject.optInt("sdkType");
        String optString4 = jSONObject.optString("appVersion");
        c0222a.appVersion = optString4;
        if (optString4 == JSONObject.NULL) {
            c0222a.appVersion = "";
        }
        String optString5 = jSONObject.optString("appName");
        c0222a.appName = optString5;
        if (optString5 == JSONObject.NULL) {
            c0222a.appName = "";
        }
        String optString6 = jSONObject.optString("appId");
        c0222a.appId = optString6;
        if (optString6 == JSONObject.NULL) {
            c0222a.appId = "";
        }
        String optString7 = jSONObject.optString("globalId");
        c0222a.aqh = optString7;
        if (optString7 == JSONObject.NULL) {
            c0222a.aqh = "";
        }
        String optString8 = jSONObject.optString("eGid");
        c0222a.alo = optString8;
        if (optString8 == JSONObject.NULL) {
            c0222a.alo = "";
        }
        String optString9 = jSONObject.optString("deviceSig");
        c0222a.aln = optString9;
        if (optString9 == JSONObject.NULL) {
            c0222a.aln = "";
        }
        String optString10 = jSONObject.optString("networkType");
        c0222a.SP = optString10;
        if (optString10 == JSONObject.NULL) {
            c0222a.SP = "";
        }
        String optString11 = jSONObject.optString("manufacturer");
        c0222a.SQ = optString11;
        if (optString11 == JSONObject.NULL) {
            c0222a.SQ = "";
        }
        String optString12 = jSONObject.optString(com.baidu.mobads.sdk.internal.bj.f5604i);
        c0222a.model = optString12;
        if (optString12 == JSONObject.NULL) {
            c0222a.model = "";
        }
        String optString13 = jSONObject.optString("deviceBrand");
        c0222a.SR = optString13;
        if (optString13 == JSONObject.NULL) {
            c0222a.SR = "";
        }
        c0222a.SS = jSONObject.optInt("osType");
        String optString14 = jSONObject.optString("systemVersion");
        c0222a.ST = optString14;
        if (optString14 == JSONObject.NULL) {
            c0222a.ST = "";
        }
        c0222a.SU = jSONObject.optInt("osApi");
        String optString15 = jSONObject.optString(com.umeng.analytics.pro.am.N);
        c0222a.SV = optString15;
        if (optString15 == JSONObject.NULL) {
            c0222a.SV = "";
        }
        String optString16 = jSONObject.optString("locale");
        c0222a.SW = optString16;
        if (optString16 == JSONObject.NULL) {
            c0222a.SW = "";
        }
        String optString17 = jSONObject.optString("uuid");
        c0222a.aqi = optString17;
        if (optString17 == JSONObject.NULL) {
            c0222a.aqi = "";
        }
        c0222a.aqj = jSONObject.optBoolean("isDynamic");
        c0222a.SX = jSONObject.optInt("screenWidth");
        c0222a.SY = jSONObject.optInt("screenHeight");
        String optString18 = jSONObject.optString("imei");
        c0222a.adV = optString18;
        if (optString18 == JSONObject.NULL) {
            c0222a.adV = "";
        }
        String optString19 = jSONObject.optString("oaid");
        c0222a.adW = optString19;
        if (optString19 == JSONObject.NULL) {
            c0222a.adW = "";
        }
        String optString20 = jSONObject.optString("androidId");
        c0222a.ali = optString20;
        if (optString20 == JSONObject.NULL) {
            c0222a.ali = "";
        }
        String optString21 = jSONObject.optString("mac");
        c0222a.alB = optString21;
        if (optString21 == JSONObject.NULL) {
            c0222a.alB = "";
        }
        c0222a.SZ = jSONObject.optInt("statusBarHeight");
        c0222a.Ta = jSONObject.optInt("titleBarHeight");
        String optString22 = jSONObject.optString("bridgeVersion");
        c0222a.aqk = optString22;
        if (optString22 == JSONObject.NULL) {
            c0222a.aqk = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0222a c0222a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0222a.SK;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersion", c0222a.SK);
        }
        int i2 = c0222a.SL;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "SDKVersionCode", i2);
        }
        String str2 = c0222a.ajB;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", c0222a.ajB);
        }
        String str3 = c0222a.SM;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", c0222a.SM);
        }
        int i3 = c0222a.SN;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersionCode", i3);
        }
        int i4 = c0222a.SO;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i4);
        }
        String str4 = c0222a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appVersion", c0222a.appVersion);
        }
        String str5 = c0222a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appName", c0222a.appName);
        }
        String str6 = c0222a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appId", c0222a.appId);
        }
        String str7 = c0222a.aqh;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "globalId", c0222a.aqh);
        }
        String str8 = c0222a.alo;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", c0222a.alo);
        }
        String str9 = c0222a.aln;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", c0222a.aln);
        }
        String str10 = c0222a.SP;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "networkType", c0222a.SP);
        }
        String str11 = c0222a.SQ;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "manufacturer", c0222a.SQ);
        }
        String str12 = c0222a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.baidu.mobads.sdk.internal.bj.f5604i, c0222a.model);
        }
        String str13 = c0222a.SR;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", c0222a.SR);
        }
        int i5 = c0222a.SS;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osType", i5);
        }
        String str14 = c0222a.ST;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemVersion", c0222a.ST);
        }
        int i6 = c0222a.SU;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i6);
        }
        String str15 = c0222a.SV;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.umeng.analytics.pro.am.N, c0222a.SV);
        }
        String str16 = c0222a.SW;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "locale", c0222a.SW);
        }
        String str17 = c0222a.aqi;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "uuid", c0222a.aqi);
        }
        boolean z = c0222a.aqj;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isDynamic", z);
        }
        int i7 = c0222a.SX;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i7);
        }
        int i8 = c0222a.SY;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i8);
        }
        String str18 = c0222a.adV;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", c0222a.adV);
        }
        String str19 = c0222a.adW;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "oaid", c0222a.adW);
        }
        String str20 = c0222a.ali;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", c0222a.ali);
        }
        String str21 = c0222a.alB;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "mac", c0222a.alB);
        }
        int i9 = c0222a.SZ;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "statusBarHeight", i9);
        }
        int i10 = c0222a.Ta;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "titleBarHeight", i10);
        }
        String str22 = c0222a.aqk;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bridgeVersion", c0222a.aqk);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0222a c0222a, JSONObject jSONObject) {
        a2(c0222a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0222a c0222a, JSONObject jSONObject) {
        return b2(c0222a, jSONObject);
    }
}
