package com.kwad.sdk.core.a.kwai;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ck implements com.kwad.sdk.core.d<com.kwad.sdk.core.request.model.b> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("imei");
        bVar.adV = optString;
        if (optString == JSONObject.NULL) {
            bVar.adV = "";
        }
        String optString2 = jSONObject.optString("imei1");
        bVar.ala = optString2;
        if (optString2 == JSONObject.NULL) {
            bVar.ala = "";
        }
        String optString3 = jSONObject.optString("imei2");
        bVar.alb = optString3;
        if (optString3 == JSONObject.NULL) {
            bVar.alb = "";
        }
        String optString4 = jSONObject.optString("meid");
        bVar.alc = optString4;
        if (optString4 == JSONObject.NULL) {
            bVar.alc = "";
        }
        String optString5 = jSONObject.optString("oaid");
        bVar.adW = optString5;
        if (optString5 == JSONObject.NULL) {
            bVar.adW = "";
        }
        String optString6 = jSONObject.optString("appMkt");
        bVar.ald = optString6;
        if (optString6 == JSONObject.NULL) {
            bVar.ald = "";
        }
        String optString7 = jSONObject.optString("appMktParam");
        bVar.ale = optString7;
        if (optString7 == JSONObject.NULL) {
            bVar.ale = "";
        }
        String optString8 = jSONObject.optString("romName");
        bVar.OK = optString8;
        if (optString8 == JSONObject.NULL) {
            bVar.OK = "";
        }
        bVar.SS = jSONObject.optInt("osType");
        bVar.SU = jSONObject.optInt("osApi");
        String optString9 = jSONObject.optString("osVersion");
        bVar.alf = optString9;
        if (optString9 == JSONObject.NULL) {
            bVar.alf = "";
        }
        String optString10 = jSONObject.optString(com.umeng.analytics.pro.am.N);
        bVar.SV = optString10;
        if (optString10 == JSONObject.NULL) {
            bVar.SV = "";
        }
        bVar.SX = jSONObject.optInt("screenWidth");
        bVar.SY = jSONObject.optInt("screenHeight");
        bVar.alg = jSONObject.optInt("deviceWidth");
        bVar.alh = jSONObject.optInt("deviceHeight");
        String optString11 = jSONObject.optString("androidId");
        bVar.ali = optString11;
        if (optString11 == JSONObject.NULL) {
            bVar.ali = "";
        }
        String optString12 = jSONObject.optString(com.alipay.mobilesecuritysdk.deviceID.c.w);
        bVar.alj = optString12;
        if (optString12 == JSONObject.NULL) {
            bVar.alj = "";
        }
        String optString13 = jSONObject.optString("deviceVendor");
        bVar.alk = optString13;
        if (optString13 == JSONObject.NULL) {
            bVar.alk = "";
        }
        bVar.all = jSONObject.optInt("platform");
        String optString14 = jSONObject.optString("deviceModel");
        bVar.alm = optString14;
        if (optString14 == JSONObject.NULL) {
            bVar.alm = "";
        }
        String optString15 = jSONObject.optString("deviceBrand");
        bVar.SR = optString15;
        if (optString15 == JSONObject.NULL) {
            bVar.SR = "";
        }
        String optString16 = jSONObject.optString("deviceSig");
        bVar.aln = optString16;
        if (optString16 == JSONObject.NULL) {
            bVar.aln = "";
        }
        String optString17 = jSONObject.optString("eGid");
        bVar.alo = optString17;
        if (optString17 == JSONObject.NULL) {
            bVar.alo = "";
        }
        bVar.alp = jSONObject.optJSONArray("appPackageName");
        String optString18 = jSONObject.optString("arch");
        bVar.alq = optString18;
        if (optString18 == JSONObject.NULL) {
            bVar.alq = "";
        }
        bVar.alr = jSONObject.optInt("screenDirection");
        String optString19 = jSONObject.optString("kwaiVersionName");
        bVar.als = optString19;
        if (optString19 == JSONObject.NULL) {
            bVar.als = "";
        }
        String optString20 = jSONObject.optString("kwaiNebulaVersionName");
        bVar.alt = optString20;
        if (optString20 == JSONObject.NULL) {
            bVar.alt = "";
        }
        String optString21 = jSONObject.optString("wechatVersionName");
        bVar.alu = optString21;
        if (optString21 == JSONObject.NULL) {
            bVar.alu = "";
        }
        bVar.alv = jSONObject.optLong("sourceFlag");
        String optString22 = jSONObject.optString("systemBootTime");
        bVar.alw = optString22;
        if (optString22 == JSONObject.NULL) {
            bVar.alw = "";
        }
        String optString23 = jSONObject.optString("systemUpdateTime");
        bVar.alx = optString23;
        if (optString23 == JSONObject.NULL) {
            bVar.alx = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = bVar.adV;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei", bVar.adV);
        }
        String str2 = bVar.ala;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei1", bVar.ala);
        }
        String str3 = bVar.alb;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "imei2", bVar.alb);
        }
        String str4 = bVar.alc;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "meid", bVar.alc);
        }
        String str5 = bVar.adW;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "oaid", bVar.adW);
        }
        String str6 = bVar.ald;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appMkt", bVar.ald);
        }
        String str7 = bVar.ale;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appMktParam", bVar.ale);
        }
        String str8 = bVar.OK;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "romName", bVar.OK);
        }
        int i2 = bVar.SS;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osType", i2);
        }
        int i3 = bVar.SU;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osApi", i3);
        }
        String str9 = bVar.alf;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "osVersion", bVar.alf);
        }
        String str10 = bVar.SV;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.umeng.analytics.pro.am.N, bVar.SV);
        }
        int i4 = bVar.SX;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenWidth", i4);
        }
        int i5 = bVar.SY;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenHeight", i5);
        }
        int i6 = bVar.alg;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceWidth", i6);
        }
        int i7 = bVar.alh;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceHeight", i7);
        }
        String str11 = bVar.ali;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "androidId", bVar.ali);
        }
        String str12 = bVar.alj;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, com.alipay.mobilesecuritysdk.deviceID.c.w, bVar.alj);
        }
        String str13 = bVar.alk;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceVendor", bVar.alk);
        }
        int i8 = bVar.all;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "platform", i8);
        }
        String str14 = bVar.alm;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceModel", bVar.alm);
        }
        String str15 = bVar.SR;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceBrand", bVar.SR);
        }
        String str16 = bVar.aln;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deviceSig", bVar.aln);
        }
        String str17 = bVar.alo;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "eGid", bVar.alo);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appPackageName", bVar.alp);
        String str18 = bVar.alq;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "arch", bVar.alq);
        }
        int i9 = bVar.alr;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "screenDirection", i9);
        }
        String str19 = bVar.als;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kwaiVersionName", bVar.als);
        }
        String str20 = bVar.alt;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "kwaiNebulaVersionName", bVar.alt);
        }
        String str21 = bVar.alu;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "wechatVersionName", bVar.alu);
        }
        long j2 = bVar.alv;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sourceFlag", j2);
        }
        String str22 = bVar.alw;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemBootTime", bVar.alw);
        }
        String str23 = bVar.alx;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "systemUpdateTime", bVar.alx);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.request.model.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
