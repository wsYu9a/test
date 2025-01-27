package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.scene.URLPackage;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ik implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        a2(nVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        return b2(nVar, jSONObject);
    }

    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong(o3.a.f29032k);
        nVar.sessionId = jSONObject.optString("sessionId");
        Object obj = JSONObject.NULL;
        if (obj.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.KE = jSONObject.optLong("seq");
        nVar.aBT = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong("actionType");
        nVar.MI = jSONObject.optString("payload");
        if (obj.toString().equals(nVar.MI)) {
            nVar.MI = "";
        }
        nVar.llsid = jSONObject.optLong("llsid");
        nVar.aBU = jSONObject.optJSONObject("extra");
        nVar.aBV = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong(id.c.f26972i);
        nVar.aBW = jSONObject.optLong("serverPosition");
        nVar.aBX = jSONObject.optLong("photoDuration");
        nVar.aBY = jSONObject.optLong("effectivePlayDuration");
        nVar.YF = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.aBZ = jSONObject.optLong("intervalDuration");
        nVar.aCa = jSONObject.optLong("allIntervalDuration");
        nVar.aCb = jSONObject.optLong("flowSdk");
        nVar.aCc = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.atE = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (obj.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        nVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        nVar.aCd = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.UK = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.aCe = jSONObject.optString("photoSize");
        if (obj.toString().equals(nVar.aCe)) {
            nVar.aCe = "";
        }
        nVar.aCf = jSONObject.optJSONArray("appInstalled");
        nVar.aCg = jSONObject.optJSONArray("appUninstalled");
        n.a aVar = new n.a();
        nVar.aCh = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.aCi = jSONObject.optInt("playerType");
        nVar.aCj = jSONObject.optInt("uiType");
        nVar.aCk = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.aag = jSONObject.optInt("refreshType");
        nVar.aCl = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.aCm = jSONObject.optString("failUrl");
        if (obj.toString().equals(nVar.aCm)) {
            nVar.aCm = "";
        }
        nVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (obj.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt(MediationConstant.KEY_ERROR_CODE, new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.aCp = jSONObject.optString("cacheFailedReason");
        if (obj.toString().equals(nVar.aCp)) {
            nVar.aCp = "";
        }
        nVar.aCq = jSONObject.optJSONObject("appExt");
        nVar.aCr = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        nVar.aCs = jSONObject.optInt("speedLimitStatus");
        nVar.aCt = jSONObject.optInt("speedLimitThreshold");
        nVar.aCu = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.aCw = jSONObject.optJSONArray("sdkPlatform");
        nVar.aCx = jSONObject.optBoolean("isKsUnion");
        nVar.aCy = jSONObject.optString("trackMethodName");
        if (obj.toString().equals(nVar.aCy)) {
            nVar.aCy = "";
        }
        nVar.aCz = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.aCB = jSONObject.optLong("frameRenderTime");
        nVar.aCC = jSONObject.optInt("playerEnterAction");
        nVar.aCD = jSONObject.optString("requestUrl");
        if (obj.toString().equals(nVar.aCD)) {
            nVar.aCD = "";
        }
        nVar.aCE = jSONObject.optLong("requestTotalTime");
        nVar.aCF = jSONObject.optLong("requestResponseTime");
        nVar.aCG = jSONObject.optLong("requestParseDataTime");
        nVar.aCH = jSONObject.optLong("requestCallbackTime");
        nVar.aCI = jSONObject.optString("requestFailReason");
        if (obj.toString().equals(nVar.aCI)) {
            nVar.aCI = "";
        }
        nVar.TH = jSONObject.optString("pageName");
        if (obj.toString().equals(nVar.TH)) {
            nVar.TH = "";
        }
        nVar.TP = jSONObject.optLong("pageCreateTime");
        nVar.TQ = jSONObject.optLong("pageResumeTime");
        nVar.aCJ = jSONObject.optInt("trackUrlType");
        nVar.aCK = jSONObject.optJSONArray("trackUrlList");
        nVar.TO = jSONObject.optLong("pageLaunchTime");
        nVar.aCN = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.aCO = jSONObject.optString("tkVersion");
        if (obj.toString().equals(nVar.aCO)) {
            nVar.aCO = "";
        }
        nVar.aCP = jSONObject.optString("jsVersion");
        if (obj.toString().equals(nVar.aCP)) {
            nVar.aCP = "";
        }
        nVar.aCQ = jSONObject.optString("jsFileName");
        if (obj.toString().equals(nVar.aCQ)) {
            nVar.aCQ = "";
        }
        nVar.aCR = jSONObject.optString("jsErrorMsg");
        if (obj.toString().equals(nVar.aCR)) {
            nVar.aCR = "";
        }
        nVar.aCS = jSONObject.optString("jsConfig");
        if (obj.toString().equals(nVar.aCS)) {
            nVar.aCS = "";
        }
        nVar.aCT = jSONObject.optInt("adBizType");
        nVar.aCU = jSONObject.optString("customKey");
        if (obj.toString().equals(nVar.aCU)) {
            nVar.aCU = "";
        }
        nVar.aCV = jSONObject.optString("customValue");
        if (obj.toString().equals(nVar.aCV)) {
            nVar.aCV = "";
        }
        nVar.trace = jSONObject.optString("trace");
        if (obj.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.aCW = jSONObject.optInt("filterCode");
        nVar.aCX = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString(b7.b.f1305b0);
        if (obj.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.aCY = jSONObject.optString("adSdkVersion");
        if (obj.toString().equals(nVar.aCY)) {
            nVar.aCY = "";
        }
        nVar.ZC = jSONObject.optString("sdkApiVersion");
        if (obj.toString().equals(nVar.ZC)) {
            nVar.ZC = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.aCZ = jSONObject.optLong("appUseDuration");
        nVar.aDa = jSONObject.optLong("appStartType");
        nVar.axZ = jSONObject.optLong("sequenceNumber");
        nVar.KB = jSONObject.optString("appColdStart");
        if (obj.toString().equals(nVar.KB)) {
            nVar.KB = "";
        }
        nVar.KC = jSONObject.optString("appStart");
        if (obj.toString().equals(nVar.KC)) {
            nVar.KC = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j10 = nVar.timestamp;
        if (j10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, o3.a.f29032k, j10);
        }
        String str = nVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        long j11 = nVar.KE;
        if (j11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "seq", j11);
        }
        long j12 = nVar.aBT;
        if (j12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "listId", j12);
        }
        long j13 = nVar.actionType;
        if (j13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "actionType", j13);
        }
        String str2 = nVar.MI;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "payload", nVar.MI);
        }
        long j14 = nVar.llsid;
        if (j14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "llsid", j14);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "extra", nVar.aBU);
        com.kwad.sdk.utils.x.putValue(jSONObject, "impAdExtra", nVar.aBV);
        long j15 = nVar.posId;
        if (j15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "posId", j15);
        }
        int i10 = nVar.contentType;
        if (i10 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "contentType", i10);
        }
        int i11 = nVar.realShowType;
        if (i11 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "realShowType", i11);
        }
        long j16 = nVar.photoId;
        if (j16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoId", j16);
        }
        long j17 = nVar.position;
        if (j17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, id.c.f26972i, j17);
        }
        long j18 = nVar.aBW;
        if (j18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "serverPosition", j18);
        }
        long j19 = nVar.aBX;
        if (j19 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoDuration", j19);
        }
        long j20 = nVar.aBY;
        if (j20 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "effectivePlayDuration", j20);
        }
        long j21 = nVar.YF;
        if (j21 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playDuration", j21);
        }
        long j22 = nVar.blockDuration;
        if (j22 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "blockDuration", j22);
        }
        long j23 = nVar.aBZ;
        if (j23 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "intervalDuration", j23);
        }
        long j24 = nVar.aCa;
        if (j24 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "allIntervalDuration", j24);
        }
        long j25 = nVar.aCb;
        if (j25 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "flowSdk", j25);
        }
        long j26 = nVar.aCc;
        if (j26 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "blockTimes", j26);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        int i12 = nVar.atE;
        if (i12 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adAggPageSource", i12);
        }
        String str3 = nVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.x.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.x.a(jSONObject, "referURLPackage", nVar.aCd);
        long j27 = nVar.UK;
        if (j27 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j27);
        }
        String str4 = nVar.aCe;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "photoSize", nVar.aCe);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "appInstalled", nVar.aCf);
        com.kwad.sdk.utils.x.putValue(jSONObject, "appUninstalled", nVar.aCg);
        com.kwad.sdk.utils.x.a(jSONObject, "clientExt", nVar.aCh);
        int i13 = nVar.aCi;
        if (i13 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playerType", i13);
        }
        int i14 = nVar.aCj;
        if (i14 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "uiType", i14);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "isLeftSlipStatus", nVar.aCk);
        int i15 = nVar.aag;
        if (i15 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "refreshType", i15);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "photoResponseType", nVar.aCl);
        String str5 = nVar.aCm;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "failUrl", nVar.aCm);
        }
        String str6 = nVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, nVar.errorMsg);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, MediationConstant.KEY_ERROR_CODE, nVar.errorCode);
        long j28 = nVar.creativeId;
        if (j28 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", j28);
        }
        String str7 = nVar.aCp;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "cacheFailedReason", nVar.aCp);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "appExt", nVar.aCq);
        com.kwad.sdk.utils.x.putValue(jSONObject, "appRunningInfoList", nVar.aCr);
        long j29 = nVar.downloadDuration;
        if (j29 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "downloadDuration", j29);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "pageType", nVar.pageType);
        int i16 = nVar.aCs;
        if (i16 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "speedLimitStatus", i16);
        }
        int i17 = nVar.aCt;
        if (i17 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "speedLimitThreshold", i17);
        }
        int i18 = nVar.aCu;
        if (i18 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "currentRealDownloadSpeed", i18);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "sdkPlatform", nVar.aCw);
        boolean z10 = nVar.aCx;
        if (z10) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "isKsUnion", z10);
        }
        String str8 = nVar.aCy;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "trackMethodName", nVar.aCy);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "viewModeType", nVar.aCz);
        long j30 = nVar.clickTime;
        if (j30 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "clickTime", j30);
        }
        long j31 = nVar.aCB;
        if (j31 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "frameRenderTime", j31);
        }
        int i19 = nVar.aCC;
        if (i19 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "playerEnterAction", i19);
        }
        String str9 = nVar.aCD;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "requestUrl", nVar.aCD);
        }
        long j32 = nVar.aCE;
        if (j32 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "requestTotalTime", j32);
        }
        long j33 = nVar.aCF;
        if (j33 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "requestResponseTime", j33);
        }
        long j34 = nVar.aCG;
        if (j34 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "requestParseDataTime", j34);
        }
        long j35 = nVar.aCH;
        if (j35 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "requestCallbackTime", j35);
        }
        String str10 = nVar.aCI;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "requestFailReason", nVar.aCI);
        }
        String str11 = nVar.TH;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pageName", nVar.TH);
        }
        long j36 = nVar.TP;
        if (j36 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pageCreateTime", j36);
        }
        long j37 = nVar.TQ;
        if (j37 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pageResumeTime", j37);
        }
        int i20 = nVar.aCJ;
        if (i20 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "trackUrlType", i20);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "trackUrlList", nVar.aCK);
        long j38 = nVar.TO;
        if (j38 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "pageLaunchTime", j38);
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "appAuthorityInfoList", nVar.aCN);
        String str12 = nVar.aCO;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "tkVersion", nVar.aCO);
        }
        String str13 = nVar.aCP;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "jsVersion", nVar.aCP);
        }
        String str14 = nVar.aCQ;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "jsFileName", nVar.aCQ);
        }
        String str15 = nVar.aCR;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "jsErrorMsg", nVar.aCR);
        }
        String str16 = nVar.aCS;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "jsConfig", nVar.aCS);
        }
        int i21 = nVar.aCT;
        if (i21 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adBizType", i21);
        }
        String str17 = nVar.aCU;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "customKey", nVar.aCU);
        }
        String str18 = nVar.aCV;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "customValue", nVar.aCV);
        }
        String str19 = nVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "trace", nVar.trace);
        }
        int i22 = nVar.aCW;
        if (i22 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "filterCode", i22);
        }
        int i23 = nVar.aCX;
        if (i23 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkVersionCode", i23);
        }
        String str20 = nVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, b7.b.f1305b0, nVar.sdkVersion);
        }
        String str21 = nVar.aCY;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "adSdkVersion", nVar.aCY);
        }
        String str22 = nVar.ZC;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkApiVersion", nVar.ZC);
        }
        int i24 = nVar.sdkType;
        if (i24 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sdkType", i24);
        }
        long j39 = nVar.aCZ;
        if (j39 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appUseDuration", j39);
        }
        long j40 = nVar.aDa;
        if (j40 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appStartType", j40);
        }
        long j41 = nVar.axZ;
        if (j41 != 0) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "sequenceNumber", j41);
        }
        String str23 = nVar.KB;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appColdStart", nVar.KB);
        }
        String str24 = nVar.KC;
        if (str24 != null && !str24.equals("")) {
            com.kwad.sdk.utils.x.putValue(jSONObject, "appStart", nVar.KC);
        }
        return jSONObject;
    }
}
