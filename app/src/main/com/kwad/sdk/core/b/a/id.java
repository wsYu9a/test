package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.ag;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class id implements com.kwad.sdk.core.d<ag.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(ag.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(ag.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.ZA = jSONObject.optString("SDKVersion");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.ZA)) {
            aVar.ZA = "";
        }
        aVar.ZB = jSONObject.optInt("SDKVersionCode");
        aVar.ZC = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(aVar.ZC)) {
            aVar.ZC = "";
        }
        aVar.ZD = jSONObject.optInt("sdkApiVersionCode");
        aVar.sdkType = jSONObject.optInt("sdkType");
        aVar.appVersion = jSONObject.optString("appVersion");
        if (obj.toString().equals(aVar.appVersion)) {
            aVar.appVersion = "";
        }
        aVar.appName = jSONObject.optString("appName");
        if (obj.toString().equals(aVar.appName)) {
            aVar.appName = "";
        }
        aVar.appId = jSONObject.optString("appId");
        if (obj.toString().equals(aVar.appId)) {
            aVar.appId = "";
        }
        aVar.ZE = jSONObject.optString("networkType");
        if (obj.toString().equals(aVar.ZE)) {
            aVar.ZE = "";
        }
        aVar.ZF = jSONObject.optString("manufacturer");
        if (obj.toString().equals(aVar.ZF)) {
            aVar.ZF = "";
        }
        aVar.model = jSONObject.optString(com.baidu.mobads.sdk.internal.bm.f6904i);
        if (obj.toString().equals(aVar.model)) {
            aVar.model = "";
        }
        aVar.ZG = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(aVar.ZG)) {
            aVar.ZG = "";
        }
        aVar.ZH = jSONObject.optInt("osType");
        aVar.ZI = jSONObject.optString("systemVersion");
        if (obj.toString().equals(aVar.ZI)) {
            aVar.ZI = "";
        }
        aVar.ZJ = jSONObject.optInt("osApi");
        aVar.ZK = jSONObject.optString(com.umeng.analytics.pro.bt.N);
        if (obj.toString().equals(aVar.ZK)) {
            aVar.ZK = "";
        }
        aVar.ZL = jSONObject.optString("locale");
        if (obj.toString().equals(aVar.ZL)) {
            aVar.ZL = "";
        }
        aVar.ZM = jSONObject.optInt("screenWidth");
        aVar.ZN = jSONObject.optInt("screenHeight");
        aVar.ZO = jSONObject.optInt("statusBarHeight");
        aVar.ZP = jSONObject.optInt("titleBarHeight");
    }

    /* renamed from: b */
    private static JSONObject b2(ag.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = aVar.ZA;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "SDKVersion", aVar.ZA);
        }
        int i10 = aVar.ZB;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "SDKVersionCode", i10);
        }
        String str2 = aVar.ZC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkApiVersion", aVar.ZC);
        }
        int i11 = aVar.ZD;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkApiVersionCode", i11);
        }
        int i12 = aVar.sdkType;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkType", i12);
        }
        String str3 = aVar.appVersion;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appVersion", aVar.appVersion);
        }
        String str4 = aVar.appName;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appName", aVar.appName);
        }
        String str5 = aVar.appId;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appId", aVar.appId);
        }
        String str6 = aVar.ZE;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "networkType", aVar.ZE);
        }
        String str7 = aVar.ZF;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "manufacturer", aVar.ZF);
        }
        String str8 = aVar.model;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.baidu.mobads.sdk.internal.bm.f6904i, aVar.model);
        }
        String str9 = aVar.ZG;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceBrand", aVar.ZG);
        }
        int i13 = aVar.ZH;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "osType", i13);
        }
        String str10 = aVar.ZI;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "systemVersion", aVar.ZI);
        }
        int i14 = aVar.ZJ;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "osApi", i14);
        }
        String str11 = aVar.ZK;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.umeng.analytics.pro.bt.N, aVar.ZK);
        }
        String str12 = aVar.ZL;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "locale", aVar.ZL);
        }
        int i15 = aVar.ZM;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "screenWidth", i15);
        }
        int i16 = aVar.ZN;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "screenHeight", i16);
        }
        int i17 = aVar.ZO;
        if (i17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "statusBarHeight", i17);
        }
        int i18 = aVar.ZP;
        if (i18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "titleBarHeight", i18);
        }
        return jSONObject;
    }
}
