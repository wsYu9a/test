package com.kwad.sdk.core.b.a;

import com.shu.priory.config.AdKeys;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class dh implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.axi = jSONObject.optString("imei");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(bVar.axi)) {
            bVar.axi = "";
        }
        bVar.aDs = jSONObject.optString("imei1");
        if (obj.toString().equals(bVar.aDs)) {
            bVar.aDs = "";
        }
        bVar.aDt = jSONObject.optString("imei2");
        if (obj.toString().equals(bVar.aDt)) {
            bVar.aDt = "";
        }
        bVar.aDu = jSONObject.optString("meid");
        if (obj.toString().equals(bVar.aDu)) {
            bVar.aDu = "";
        }
        bVar.axj = jSONObject.optString(AdKeys.OAID);
        if (obj.toString().equals(bVar.axj)) {
            bVar.axj = "";
        }
        bVar.aDv = jSONObject.optString("appMkt");
        if (obj.toString().equals(bVar.aDv)) {
            bVar.aDv = "";
        }
        bVar.aDw = jSONObject.optString("appMktParam");
        if (obj.toString().equals(bVar.aDw)) {
            bVar.aDw = "";
        }
        bVar.Uu = jSONObject.optString("romName");
        if (obj.toString().equals(bVar.Uu)) {
            bVar.Uu = "";
        }
        bVar.ZH = jSONObject.optInt("osType");
        bVar.ZJ = jSONObject.optInt("osApi");
        bVar.aDx = jSONObject.optString("osVersion");
        if (obj.toString().equals(bVar.aDx)) {
            bVar.aDx = "";
        }
        bVar.ZK = jSONObject.optString(com.umeng.analytics.pro.bt.N);
        if (obj.toString().equals(bVar.ZK)) {
            bVar.ZK = "";
        }
        bVar.ZM = jSONObject.optInt("screenWidth");
        bVar.ZN = jSONObject.optInt("screenHeight");
        bVar.aDy = jSONObject.optInt("deviceWidth");
        bVar.aDz = jSONObject.optInt("deviceHeight");
        bVar.aDA = jSONObject.optString("androidId");
        if (obj.toString().equals(bVar.aDA)) {
            bVar.aDA = "";
        }
        bVar.aDB = jSONObject.optString("deviceId");
        if (obj.toString().equals(bVar.aDB)) {
            bVar.aDB = "";
        }
        bVar.aDC = jSONObject.optString("deviceVendor");
        if (obj.toString().equals(bVar.aDC)) {
            bVar.aDC = "";
        }
        bVar.aDD = jSONObject.optInt("platform");
        bVar.aDE = jSONObject.optString("deviceModel");
        if (obj.toString().equals(bVar.aDE)) {
            bVar.aDE = "";
        }
        bVar.ZG = jSONObject.optString("deviceBrand");
        if (obj.toString().equals(bVar.ZG)) {
            bVar.ZG = "";
        }
        bVar.aDF = jSONObject.optString("deviceSig");
        if (obj.toString().equals(bVar.aDF)) {
            bVar.aDF = "";
        }
        bVar.aDG = jSONObject.optString("eGid");
        if (obj.toString().equals(bVar.aDG)) {
            bVar.aDG = "";
        }
        bVar.aDH = jSONObject.optJSONArray("appPackageName");
        bVar.aDI = jSONObject.optString("arch");
        if (obj.toString().equals(bVar.aDI)) {
            bVar.aDI = "";
        }
        bVar.aDJ = jSONObject.optInt("screenDirection");
        bVar.aDK = jSONObject.optString("kwaiVersionName");
        if (obj.toString().equals(bVar.aDK)) {
            bVar.aDK = "";
        }
        bVar.aDL = jSONObject.optString("kwaiNebulaVersionName");
        if (obj.toString().equals(bVar.aDL)) {
            bVar.aDL = "";
        }
        bVar.aDM = jSONObject.optString("wechatVersionName");
        if (obj.toString().equals(bVar.aDM)) {
            bVar.aDM = "";
        }
        bVar.aDN = jSONObject.optLong("sourceFlag");
        bVar.aDO = jSONObject.optString("systemBootTime");
        if (obj.toString().equals(bVar.aDO)) {
            bVar.aDO = "";
        }
        bVar.aDP = jSONObject.optString("systemUpdateTime");
        if (obj.toString().equals(bVar.aDP)) {
            bVar.aDP = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.axi;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "imei", bVar.axi);
        }
        String str2 = bVar.aDs;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "imei1", bVar.aDs);
        }
        String str3 = bVar.aDt;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "imei2", bVar.aDt);
        }
        String str4 = bVar.aDu;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "meid", bVar.aDu);
        }
        String str5 = bVar.axj;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, AdKeys.OAID, bVar.axj);
        }
        String str6 = bVar.aDv;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appMkt", bVar.aDv);
        }
        String str7 = bVar.aDw;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appMktParam", bVar.aDw);
        }
        String str8 = bVar.Uu;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "romName", bVar.Uu);
        }
        int i10 = bVar.ZH;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "osType", i10);
        }
        int i11 = bVar.ZJ;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "osApi", i11);
        }
        String str9 = bVar.aDx;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "osVersion", bVar.aDx);
        }
        String str10 = bVar.ZK;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, com.umeng.analytics.pro.bt.N, bVar.ZK);
        }
        int i12 = bVar.ZM;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "screenWidth", i12);
        }
        int i13 = bVar.ZN;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "screenHeight", i13);
        }
        int i14 = bVar.aDy;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceWidth", i14);
        }
        int i15 = bVar.aDz;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceHeight", i15);
        }
        String str11 = bVar.aDA;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "androidId", bVar.aDA);
        }
        String str12 = bVar.aDB;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceId", bVar.aDB);
        }
        String str13 = bVar.aDC;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceVendor", bVar.aDC);
        }
        int i16 = bVar.aDD;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "platform", i16);
        }
        String str14 = bVar.aDE;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceModel", bVar.aDE);
        }
        String str15 = bVar.ZG;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceBrand", bVar.ZG);
        }
        String str16 = bVar.aDF;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deviceSig", bVar.aDF);
        }
        String str17 = bVar.aDG;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "eGid", bVar.aDG);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "appPackageName", bVar.aDH);
        String str18 = bVar.aDI;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "arch", bVar.aDI);
        }
        int i17 = bVar.aDJ;
        if (i17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "screenDirection", i17);
        }
        String str19 = bVar.aDK;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "kwaiVersionName", bVar.aDK);
        }
        String str20 = bVar.aDL;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "kwaiNebulaVersionName", bVar.aDL);
        }
        String str21 = bVar.aDM;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "wechatVersionName", bVar.aDM);
        }
        long j10 = bVar.aDN;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sourceFlag", j10);
        }
        String str22 = bVar.aDO;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "systemBootTime", bVar.aDO);
        }
        String str23 = bVar.aDP;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "systemUpdateTime", bVar.aDP);
        }
        return jSONObject;
    }
}
