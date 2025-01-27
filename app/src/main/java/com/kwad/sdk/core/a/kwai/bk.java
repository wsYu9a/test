package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.y;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class bk implements com.kwad.sdk.core.d<y.b> {
    /* renamed from: a */
    private static void a2(y.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.akf = jSONObject.optInt("photoPlaySecond");
        bVar.akg = jSONObject.optInt("awardReceiveStage");
        bVar.jU = jSONObject.optInt("itemClickType");
        bVar.akh = jSONObject.optInt("itemCloseType");
        bVar.aki = jSONObject.optInt("elementType");
        String optString = jSONObject.optString("adRenderArea");
        bVar.akj = optString;
        if (optString == JSONObject.NULL) {
            bVar.akj = "";
        }
        bVar.akk = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        bVar.akl = jSONObject.optInt("impFailReason");
        bVar.akm = jSONObject.optLong("winEcpm");
        bVar.adnType = jSONObject.optInt("adnType");
        String optString2 = jSONObject.optString("adnName");
        bVar.adnName = optString2;
        if (optString2 == JSONObject.NULL) {
            bVar.adnName = "";
        }
        bVar.akn = jSONObject.optInt("retainCodeType");
        bVar.ako = jSONObject.optInt("photoSizeStyle");
        String optString3 = jSONObject.optString("payload");
        bVar.Ts = optString3;
        if (optString3 == JSONObject.NULL) {
            bVar.Ts = "";
        }
        bVar.akp = jSONObject.optInt("deeplinkType");
        String optString4 = jSONObject.optString("deeplinkAppName");
        bVar.akq = optString4;
        if (optString4 == JSONObject.NULL) {
            bVar.akq = "";
        }
        bVar.akr = jSONObject.optInt("deeplinkFailedReason");
        bVar.downloadSource = jSONObject.optInt("downloadSource");
        bVar.aks = jSONObject.optInt("isPackageChanged");
        String optString5 = jSONObject.optString("installedFrom");
        bVar.akt = optString5;
        if (optString5 == JSONObject.NULL) {
            bVar.akt = "";
        }
        String optString6 = jSONObject.optString("downloadFailedReason");
        bVar.aku = optString6;
        if (optString6 == JSONObject.NULL) {
            bVar.aku = "";
        }
        bVar.akv = jSONObject.optInt("isChangedEndcard");
        bVar.aiQ = jSONObject.optInt("adAggPageSource");
        String optString7 = jSONObject.optString("serverPackageName");
        bVar.akw = optString7;
        if (optString7 == JSONObject.NULL) {
            bVar.akw = "";
        }
        String optString8 = jSONObject.optString("installedPackageName");
        bVar.akx = optString8;
        if (optString8 == JSONObject.NULL) {
            bVar.akx = "";
        }
        bVar.aky = jSONObject.optInt("closeButtonImpressionTime");
        bVar.akz = jSONObject.optInt("closeButtonClickTime");
        bVar.akA = jSONObject.optLong("landingPageLoadedDuration");
        bVar.Jm = jSONObject.optLong("leaveTime");
        bVar.akB = jSONObject.optLong("adItemClickBackDuration");
        bVar.akC = jSONObject.optInt("appStorePageType");
        bVar.akD = jSONObject.optInt("installStatus");
        bVar.akE = jSONObject.optInt("downloadStatus");
        bVar.akF = jSONObject.optInt("downloadCardType");
        y.a aVar = new y.a();
        bVar.akG = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExtData"));
        bVar.akH = jSONObject.optInt("landingPageType");
        bVar.uV = jSONObject.optLong("playedDuration");
        bVar.akI = jSONObject.optInt("playedRate");
        bVar.akJ = jSONObject.optInt("adOrder");
        bVar.akK = jSONObject.optInt("adInterstitialSource");
        bVar.jX = jSONObject.optDouble("splashShakeAcceleration");
        bVar.akL = jSONObject.optInt("universeSecondAd");
        String optString9 = jSONObject.optString("splashInteractionRotateAngle");
        bVar.akM = optString9;
        if (optString9 == JSONObject.NULL) {
            bVar.akM = "";
        }
        bVar.akN = jSONObject.optInt("downloadInstallType");
        bVar.akO = jSONObject.optInt("businessSceneType");
        bVar.adxResult = jSONObject.optInt("adxResult");
        bVar.akP = jSONObject.optInt("fingerSwipeType");
        bVar.akQ = jSONObject.optInt("fingerSwipeDistance");
        bVar.akR = jSONObject.optInt("triggerType");
        bVar.akS = jSONObject.optInt("cardCloseType");
        String optString10 = jSONObject.optString("clientPkFailAdInfo");
        bVar.akT = optString10;
        if (optString10 == JSONObject.NULL) {
            bVar.akT = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(y.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i2 = bVar.akf;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoPlaySecond", i2);
        }
        int i3 = bVar.akg;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "awardReceiveStage", i3);
        }
        int i4 = bVar.jU;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemClickType", i4);
        }
        int i5 = bVar.akh;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "itemCloseType", i5);
        }
        int i6 = bVar.aki;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "elementType", i6);
        }
        String str = bVar.akj;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adRenderArea", bVar.akj);
        }
        long j2 = bVar.akk;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j2);
        }
        int i7 = bVar.akl;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "impFailReason", i7);
        }
        long j3 = bVar.akm;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "winEcpm", j3);
        }
        int i8 = bVar.adnType;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnType", i8);
        }
        String str2 = bVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adnName", bVar.adnName);
        }
        int i9 = bVar.akn;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "retainCodeType", i9);
        }
        int i10 = bVar.ako;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSizeStyle", i10);
        }
        String str3 = bVar.Ts;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", bVar.Ts);
        }
        int i11 = bVar.akp;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkType", i11);
        }
        String str4 = bVar.akq;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkAppName", bVar.akq);
        }
        int i12 = bVar.akr;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "deeplinkFailedReason", i12);
        }
        int i13 = bVar.downloadSource;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadSource", i13);
        }
        int i14 = bVar.aks;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isPackageChanged", i14);
        }
        String str5 = bVar.akt;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedFrom", bVar.akt);
        }
        String str6 = bVar.aku;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadFailedReason", bVar.aku);
        }
        int i15 = bVar.akv;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isChangedEndcard", i15);
        }
        int i16 = bVar.aiQ;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i16);
        }
        String str7 = bVar.akw;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPackageName", bVar.akw);
        }
        String str8 = bVar.akx;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installedPackageName", bVar.akx);
        }
        int i17 = bVar.aky;
        if (i17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonImpressionTime", i17);
        }
        int i18 = bVar.akz;
        if (i18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "closeButtonClickTime", i18);
        }
        long j4 = bVar.akA;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageLoadedDuration", j4);
        }
        long j5 = bVar.Jm;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "leaveTime", j5);
        }
        long j6 = bVar.akB;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adItemClickBackDuration", j6);
        }
        int i19 = bVar.akC;
        if (i19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStorePageType", i19);
        }
        int i20 = bVar.akD;
        if (i20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "installStatus", i20);
        }
        int i21 = bVar.akE;
        if (i21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadStatus", i21);
        }
        int i22 = bVar.akF;
        if (i22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadCardType", i22);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "clientExtData", bVar.akG);
        int i23 = bVar.akH;
        if (i23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "landingPageType", i23);
        }
        long j7 = bVar.uV;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedDuration", j7);
        }
        int i24 = bVar.akI;
        if (i24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playedRate", i24);
        }
        int i25 = bVar.akJ;
        if (i25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adOrder", i25);
        }
        int i26 = bVar.akK;
        if (i26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adInterstitialSource", i26);
        }
        double d2 = bVar.jX;
        if (d2 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashShakeAcceleration", d2);
        }
        int i27 = bVar.akL;
        if (i27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "universeSecondAd", i27);
        }
        String str9 = bVar.akM;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "splashInteractionRotateAngle", bVar.akM);
        }
        int i28 = bVar.akN;
        if (i28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadInstallType", i28);
        }
        int i29 = bVar.akO;
        if (i29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "businessSceneType", i29);
        }
        int i30 = bVar.adxResult;
        if (i30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adxResult", i30);
        }
        int i31 = bVar.akP;
        if (i31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeType", i31);
        }
        int i32 = bVar.akQ;
        if (i32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "fingerSwipeDistance", i32);
        }
        int i33 = bVar.akR;
        if (i33 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "triggerType", i33);
        }
        int i34 = bVar.akS;
        if (i34 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardCloseType", i34);
        }
        String str10 = bVar.akT;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clientPkFailAdInfo", bVar.akT);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(y.b bVar, JSONObject jSONObject) {
        a2(bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(y.b bVar, JSONObject jSONObject) {
        return b2(bVar, jSONObject);
    }
}
