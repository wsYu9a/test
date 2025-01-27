package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.webview.d.a;
import com.shu.priory.config.AdKeys;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ez implements com.kwad.sdk.core.d<a.C0502a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(a.C0502a c0502a, JSONObject jSONObject) {
        a2(c0502a, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(a.C0502a c0502a, JSONObject jSONObject) {
        return b2(c0502a, jSONObject);
    }

    /* renamed from: a */
    private static void a2(a.C0502a c0502a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0502a.ZA = jSONObject.optString("SDKVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(c0502a.ZA)) {
            c0502a.ZA = "";
        }
        c0502a.ZB = jSONObject.optInt("SDKVersionCode");
        c0502a.aCO = jSONObject.optString("tkVersion");
        if (obj.toString().equals(c0502a.aCO)) {
            c0502a.aCO = "";
        }
        c0502a.ZC = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(c0502a.ZC)) {
            c0502a.ZC = "";
        }
        c0502a.ZD = jSONObject.optInt("sdkApiVersionCode");
        c0502a.sdkType = jSONObject.optInt("sdkType");
        c0502a.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(c0502a.appVersion)) {
            c0502a.appVersion = "";
        }
        c0502a.appName = jSONObject.optString("appName");
        if (obj.toString().equals(c0502a.appName)) {
            c0502a.appName = "";
        }
        c0502a.appId = jSONObject.optString("appId");
        if (obj.toString().equals(c0502a.appId)) {
            c0502a.appId = "";
        }
        c0502a.aIY = jSONObject.optString("globalId");
        if (obj.toString().equals(c0502a.aIY)) {
            c0502a.aIY = "";
        }
        c0502a.aDG = jSONObject.optString("eGid");
        if (obj.toString().equals(c0502a.aDG)) {
            c0502a.aDG = "";
        }
        c0502a.aDF = jSONObject.optString("deviceSig");
        if (obj.toString().equals(c0502a.aDF)) {
            c0502a.aDF = "";
        }
        c0502a.ZE = jSONObject.optString("networkType");
        if (obj.toString().equals(c0502a.ZE)) {
            c0502a.ZE = "";
        }
        c0502a.ZF = jSONObject.optString("manufacturer");
        if (obj.toString().equals(c0502a.ZF)) {
            c0502a.ZF = "";
        }
        c0502a.model = jSONObject.optString(com.baidu.mobads.sdk.internal.bm.f6904i);
        if (obj.toString().equals(c0502a.model)) {
            c0502a.model = "";
        }
        c0502a.ZG = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(c0502a.ZG)) {
            c0502a.ZG = "";
        }
        c0502a.ZH = jSONObject.optInt("osType");
        c0502a.ZI = jSONObject.optString("systemVersion");
        if (obj.toString().equals(c0502a.ZI)) {
            c0502a.ZI = "";
        }
        c0502a.ZJ = jSONObject.optInt("osApi");
        c0502a.ZK = jSONObject.optString(com.umeng.analytics.pro.bt.N);
        if (obj.toString().equals(c0502a.ZK)) {
            c0502a.ZK = "";
        }
        c0502a.ZL = jSONObject.optString("locale");
        if (obj.toString().equals(c0502a.ZL)) {
            c0502a.ZL = "";
        }
        c0502a.aIZ = jSONObject.optString("uuid");
        if (obj.toString().equals(c0502a.aIZ)) {
            c0502a.aIZ = "";
        }
        c0502a.aJa = jSONObject.optBoolean("isDynamic");
        c0502a.ZM = jSONObject.optInt("screenWidth");
        c0502a.ZN = jSONObject.optInt("screenHeight");
        c0502a.axi = jSONObject.optString("imei");
        if (obj.toString().equals(c0502a.axi)) {
            c0502a.axi = "";
        }
        c0502a.axj = jSONObject.optString(AdKeys.OAID);
        if (obj.toString().equals(c0502a.axj)) {
            c0502a.axj = "";
        }
        c0502a.aDA = jSONObject.optString("androidId");
        if (obj.toString().equals(c0502a.aDA)) {
            c0502a.aDA = "";
        }
        c0502a.aDR = jSONObject.optString("mac");
        if (obj.toString().equals(c0502a.aDR)) {
            c0502a.aDR = "";
        }
        c0502a.ZO = jSONObject.optInt("statusBarHeight");
        c0502a.ZP = jSONObject.optInt("titleBarHeight");
        c0502a.aJb = jSONObject.optString("bridgeVersion");
        if (obj.toString().equals(c0502a.aJb)) {
            c0502a.aJb = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(a.C0502a c0502a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = c0502a.ZA;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "SDKVersion", c0502a.ZA);
        }
        int i10 = c0502a.ZB;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "SDKVersionCode", i10);
        }
        String str2 = c0502a.aCO;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "tkVersion", c0502a.aCO);
        }
        String str3 = c0502a.ZC;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkApiVersion", c0502a.ZC);
        }
        int i11 = c0502a.ZD;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkApiVersionCode", i11);
        }
        int i12 = c0502a.sdkType;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkType", i12);
        }
        String str4 = c0502a.appVersion;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appVersion", c0502a.appVersion);
        }
        String str5 = c0502a.appName;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appName", c0502a.appName);
        }
        String str6 = c0502a.appId;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appId", c0502a.appId);
        }
        String str7 = c0502a.aIY;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "globalId", c0502a.aIY);
        }
        String str8 = c0502a.aDG;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "eGid", c0502a.aDG);
        }
        String str9 = c0502a.aDF;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceSig", c0502a.aDF);
        }
        String str10 = c0502a.ZE;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "networkType", c0502a.ZE);
        }
        String str11 = c0502a.ZF;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "manufacturer", c0502a.ZF);
        }
        String str12 = c0502a.model;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.baidu.mobads.sdk.internal.bm.f6904i, c0502a.model);
        }
        String str13 = c0502a.ZG;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceBrand", c0502a.ZG);
        }
        int i13 = c0502a.ZH;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "osType", i13);
        }
        String str14 = c0502a.ZI;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "systemVersion", c0502a.ZI);
        }
        int i14 = c0502a.ZJ;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "osApi", i14);
        }
        String str15 = c0502a.ZK;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.umeng.analytics.pro.bt.N, c0502a.ZK);
        }
        String str16 = c0502a.ZL;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "locale", c0502a.ZL);
        }
        String str17 = c0502a.aIZ;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "uuid", c0502a.aIZ);
        }
        boolean z10 = c0502a.aJa;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isDynamic", z10);
        }
        int i15 = c0502a.ZM;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "screenWidth", i15);
        }
        int i16 = c0502a.ZN;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "screenHeight", i16);
        }
        String str18 = c0502a.axi;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "imei", c0502a.axi);
        }
        String str19 = c0502a.axj;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, AdKeys.OAID, c0502a.axj);
        }
        String str20 = c0502a.aDA;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "androidId", c0502a.aDA);
        }
        String str21 = c0502a.aDR;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "mac", c0502a.aDR);
        }
        int i17 = c0502a.ZO;
        if (i17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "statusBarHeight", i17);
        }
        int i18 = c0502a.ZP;
        if (i18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "titleBarHeight", i18);
        }
        String str22 = c0502a.aJb;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "bridgeVersion", c0502a.aJb);
        }
        return jSONObject;
    }
}
