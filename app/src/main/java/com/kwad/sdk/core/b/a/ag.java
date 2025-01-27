package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.qq.e.comm.pi.IBidding;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ag implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdTemplate adTemplate = new AdTemplate();
        aVar.adTemplate = adTemplate;
        adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.ati = jSONObject.optJSONObject("extData");
        aVar.asm = jSONObject.optInt("adActionType");
        aVar.atj = jSONObject.optInt("photoPlaySecond");
        aVar.atk = jSONObject.optInt("awardReceiveStage");
        aVar.lz = jSONObject.optInt("itemClickType");
        aVar.atl = jSONObject.optInt("itemCloseType");
        aVar.atm = jSONObject.optInt("elementType");
        aVar.atn = jSONObject.optString("adRenderArea");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(aVar.atn)) {
            aVar.atn = "";
        }
        aVar.ato = jSONObject.optLong(IBidding.HIGHEST_LOSS_PRICE);
        aVar.atp = jSONObject.optInt("impFailReason");
        aVar.atq = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString(MediationConstant.KEY_ADN_NAME);
        if (obj.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.atr = jSONObject.optString("adnAdvertiser");
        if (obj.toString().equals(aVar.atr)) {
            aVar.atr = "";
        }
        aVar.ats = jSONObject.optString("adnTitle");
        if (obj.toString().equals(aVar.ats)) {
            aVar.ats = "";
        }
        aVar.att = jSONObject.optString("adnRequestId");
        if (obj.toString().equals(aVar.att)) {
            aVar.att = "";
        }
        aVar.atu = jSONObject.optInt("adnShowType");
        aVar.atv = jSONObject.optInt("adnClickType");
        aVar.atw = jSONObject.optInt("retainCodeType");
        aVar.MK = jSONObject.optInt("photoSizeStyle");
        aVar.MI = jSONObject.optString("payload");
        if (obj.toString().equals(aVar.MI)) {
            aVar.MI = "";
        }
        aVar.atx = jSONObject.optInt("deeplinkType");
        aVar.aty = jSONObject.optString("deeplinkAppName");
        if (obj.toString().equals(aVar.aty)) {
            aVar.aty = "";
        }
        aVar.atz = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt("downloadSource");
        aVar.atA = jSONObject.optInt("isPackageChanged");
        aVar.atB = jSONObject.optString("installedFrom");
        if (obj.toString().equals(aVar.atB)) {
            aVar.atB = "";
        }
        aVar.atC = jSONObject.optString("downloadFailedReason");
        if (obj.toString().equals(aVar.atC)) {
            aVar.atC = "";
        }
        aVar.atD = jSONObject.optInt("isChangedEndcard");
        aVar.atE = jSONObject.optInt("adAggPageSource");
        aVar.atF = jSONObject.optString("serverPackageName");
        if (obj.toString().equals(aVar.atF)) {
            aVar.atF = "";
        }
        aVar.atG = jSONObject.optString("installedPackageName");
        if (obj.toString().equals(aVar.atG)) {
            aVar.atG = "";
        }
        aVar.atH = jSONObject.optInt("closeButtonImpressionTime");
        aVar.atI = jSONObject.optInt("closeButtonClickTime");
        aVar.atJ = jSONObject.optLong("landingPageLoadedDuration");
        aVar.Nk = jSONObject.optLong("leaveTime");
        aVar.atK = jSONObject.optLong("adItemClickBackDuration");
        aVar.atL = jSONObject.optInt("appStorePageType");
        aVar.atM = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.atN = jSONObject.optInt("downloadCardType");
        a.C0484a c0484a = new a.C0484a();
        aVar.MJ = c0484a;
        c0484a.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.Qq = jSONObject.optInt("landingPageType");
        aVar.f11968xc = jSONObject.optLong("playedDuration");
        aVar.atO = jSONObject.optInt("playedRate");
        aVar.atP = jSONObject.optInt("adOrder");
        aVar.MH = jSONObject.optInt("adInterstitialSource");
        aVar.lC = jSONObject.optDouble("splashShakeAcceleration");
        aVar.atQ = jSONObject.optString("splashInteractionRotateAngle");
        if (obj.toString().equals(aVar.atQ)) {
            aVar.atQ = "";
        }
        aVar.atR = jSONObject.optInt("downloadInstallType");
        aVar.atS = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.atT = jSONObject.optInt("fingerSwipeType");
        aVar.atU = jSONObject.optInt("fingerSwipeDistance");
        aVar.atV = jSONObject.optInt("finger_swipe_angle");
        aVar.ML = jSONObject.optInt("triggerType");
        aVar.atW = jSONObject.optInt("cardCloseType");
        aVar.atX = jSONObject.optString("clientPkFailAdInfo");
        if (obj.toString().equals(aVar.atX)) {
            aVar.atX = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.x.putValue(jSONObject, "extData", aVar.ati);
        int i10 = aVar.asm;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adActionType", i10);
        }
        int i11 = aVar.atj;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoPlaySecond", i11);
        }
        int i12 = aVar.atk;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "awardReceiveStage", i12);
        }
        int i13 = aVar.lz;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "itemClickType", i13);
        }
        int i14 = aVar.atl;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "itemCloseType", i14);
        }
        int i15 = aVar.atm;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "elementType", i15);
        }
        String str = aVar.atn;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adRenderArea", aVar.atn);
        }
        long j10 = aVar.ato;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, IBidding.HIGHEST_LOSS_PRICE, j10);
        }
        int i16 = aVar.atp;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "impFailReason", i16);
        }
        long j11 = aVar.atq;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "winEcpm", j11);
        }
        int i17 = aVar.adnType;
        if (i17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adnType", i17);
        }
        String str2 = aVar.adnName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        String str3 = aVar.atr;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adnAdvertiser", aVar.atr);
        }
        String str4 = aVar.ats;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adnTitle", aVar.ats);
        }
        String str5 = aVar.att;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adnRequestId", aVar.att);
        }
        int i18 = aVar.atu;
        if (i18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adnShowType", i18);
        }
        int i19 = aVar.atv;
        if (i19 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adnClickType", i19);
        }
        int i20 = aVar.atw;
        if (i20 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "retainCodeType", i20);
        }
        int i21 = aVar.MK;
        if (i21 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoSizeStyle", i21);
        }
        String str6 = aVar.MI;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "payload", aVar.MI);
        }
        int i22 = aVar.atx;
        if (i22 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deeplinkType", i22);
        }
        String str7 = aVar.aty;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deeplinkAppName", aVar.aty);
        }
        int i23 = aVar.atz;
        if (i23 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "deeplinkFailedReason", i23);
        }
        int i24 = aVar.downloadSource;
        if (i24 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "downloadSource", i24);
        }
        int i25 = aVar.atA;
        if (i25 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isPackageChanged", i25);
        }
        String str8 = aVar.atB;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "installedFrom", aVar.atB);
        }
        String str9 = aVar.atC;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "downloadFailedReason", aVar.atC);
        }
        int i26 = aVar.atD;
        if (i26 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isChangedEndcard", i26);
        }
        int i27 = aVar.atE;
        if (i27 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adAggPageSource", i27);
        }
        String str10 = aVar.atF;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "serverPackageName", aVar.atF);
        }
        String str11 = aVar.atG;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "installedPackageName", aVar.atG);
        }
        int i28 = aVar.atH;
        if (i28 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "closeButtonImpressionTime", i28);
        }
        int i29 = aVar.atI;
        if (i29 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "closeButtonClickTime", i29);
        }
        long j12 = aVar.atJ;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "landingPageLoadedDuration", j12);
        }
        long j13 = aVar.Nk;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "leaveTime", j13);
        }
        long j14 = aVar.atK;
        if (j14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adItemClickBackDuration", j14);
        }
        int i30 = aVar.atL;
        if (i30 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appStorePageType", i30);
        }
        int i31 = aVar.atM;
        if (i31 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "installStatus", i31);
        }
        int i32 = aVar.downloadStatus;
        if (i32 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "downloadStatus", i32);
        }
        int i33 = aVar.atN;
        if (i33 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "downloadCardType", i33);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "clientExtData", aVar.MJ);
        int i34 = aVar.Qq;
        if (i34 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "landingPageType", i34);
        }
        long j15 = aVar.f11968xc;
        if (j15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playedDuration", j15);
        }
        int i35 = aVar.atO;
        if (i35 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playedRate", i35);
        }
        int i36 = aVar.atP;
        if (i36 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adOrder", i36);
        }
        int i37 = aVar.MH;
        if (i37 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adInterstitialSource", i37);
        }
        double d10 = aVar.lC;
        if (d10 != l5.c.f27899e) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "splashShakeAcceleration", d10);
        }
        String str12 = aVar.atQ;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "splashInteractionRotateAngle", aVar.atQ);
        }
        int i38 = aVar.atR;
        if (i38 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "downloadInstallType", i38);
        }
        int i39 = aVar.atS;
        if (i39 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "businessSceneType", i39);
        }
        int i40 = aVar.adxResult;
        if (i40 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adxResult", i40);
        }
        int i41 = aVar.atT;
        if (i41 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fingerSwipeType", i41);
        }
        int i42 = aVar.atU;
        if (i42 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "fingerSwipeDistance", i42);
        }
        int i43 = aVar.atV;
        if (i43 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "finger_swipe_angle", i43);
        }
        int i44 = aVar.ML;
        if (i44 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "triggerType", i44);
        }
        int i45 = aVar.atW;
        if (i45 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "cardCloseType", i45);
        }
        String str13 = aVar.atX;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "clientPkFailAdInfo", aVar.atX);
        }
        return jSONObject;
    }
}
