package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.scene.URLPackage;
import com.oplus.quickgame.sdk.hall.Constant;
import com.opos.mobad.activity.VideoActivity;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class gv implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.q> {
    /* renamed from: a */
    private static void a2(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        qVar.timestamp = jSONObject.optLong("timestamp");
        String optString = jSONObject.optString("sessionId");
        qVar.sessionId = optString;
        if (optString == JSONObject.NULL) {
            qVar.sessionId = "";
        }
        qVar.Ht = jSONObject.optLong("seq");
        qVar.aiF = jSONObject.optLong("listId");
        qVar.aiG = jSONObject.optLong(VideoActivity.EXTRA_KEY_ACTION_TYPE);
        String optString2 = jSONObject.optString("payload");
        qVar.Ts = optString2;
        if (optString2 == JSONObject.NULL) {
            qVar.Ts = "";
        }
        qVar.llsid = jSONObject.optLong("llsid");
        qVar.aiH = jSONObject.optJSONObject("extra");
        qVar.aiI = jSONObject.optJSONObject("impAdExtra");
        qVar.posId = jSONObject.optLong("posId");
        qVar.contentType = jSONObject.optInt("contentType");
        qVar.realShowType = jSONObject.optInt("realShowType");
        qVar.photoId = jSONObject.optLong("photoId");
        qVar.position = jSONObject.optLong("position");
        qVar.aiJ = jSONObject.optLong("serverPosition");
        qVar.aiK = jSONObject.optLong("photoDuration");
        qVar.aiL = jSONObject.optLong("effectivePlayDuration");
        qVar.Vl = jSONObject.optLong("playDuration");
        qVar.blockDuration = jSONObject.optLong("blockDuration");
        qVar.aiM = jSONObject.optLong("intervalDuration");
        qVar.aiN = jSONObject.optLong("allIntervalDuration");
        qVar.aiO = jSONObject.optLong("flowSdk");
        qVar.aiP = jSONObject.optLong("blockTimes");
        qVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        qVar.aiQ = jSONObject.optInt("adAggPageSource");
        String optString3 = jSONObject.optString("entryPageSource");
        qVar.entryPageSource = optString3;
        if (optString3 == JSONObject.NULL) {
            qVar.entryPageSource = "";
        }
        URLPackage uRLPackage = new URLPackage();
        qVar.urlPackage = uRLPackage;
        uRLPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        URLPackage uRLPackage2 = new URLPackage();
        qVar.aiR = uRLPackage2;
        uRLPackage2.parseJson(jSONObject.optJSONObject("referURLPackage"));
        qVar.Pa = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        String optString4 = jSONObject.optString("photoSize");
        qVar.aiS = optString4;
        if (optString4 == JSONObject.NULL) {
            qVar.aiS = "";
        }
        qVar.aiT = jSONObject.optJSONArray("appInstalled");
        qVar.aiU = jSONObject.optJSONArray("appUninstalled");
        q.a aVar = new q.a();
        qVar.aiV = aVar;
        aVar.parseJson(jSONObject.optJSONObject("clientExt"));
        qVar.aiW = jSONObject.optInt("playerType");
        qVar.aiX = jSONObject.optInt("uiType");
        qVar.aiY = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        qVar.Tt = jSONObject.optInt("refreshType");
        qVar.aiZ = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        String optString5 = jSONObject.optString("failUrl");
        qVar.failUrl = optString5;
        if (optString5 == JSONObject.NULL) {
            qVar.failUrl = "";
        }
        String optString6 = jSONObject.optString("errorMsg");
        qVar.errorMsg = optString6;
        if (optString6 == JSONObject.NULL) {
            qVar.errorMsg = "";
        }
        qVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        qVar.creativeId = jSONObject.optLong("creativeId");
        String optString7 = jSONObject.optString("cacheFailedReason");
        qVar.ajc = optString7;
        if (optString7 == JSONObject.NULL) {
            qVar.ajc = "";
        }
        qVar.ajd = jSONObject.optJSONObject("appExt");
        qVar.aje = jSONObject.optJSONArray("appRunningInfoList");
        qVar.downloadDuration = jSONObject.optLong("downloadDuration");
        qVar.pageType = jSONObject.optInt(Constant.Param.KEY_RPK_PAGE_TYPE, new Integer("0").intValue());
        qVar.ajf = jSONObject.optInt("speedLimitStatus");
        qVar.ajg = jSONObject.optInt("speedLimitThreshold");
        qVar.ajh = jSONObject.optInt("currentRealDownloadSpeed");
        qVar.ajj = jSONObject.optJSONArray("sdkPlatform");
        qVar.ajk = jSONObject.optBoolean("isKsUnion");
        String optString8 = jSONObject.optString("trackMethodName");
        qVar.ajl = optString8;
        if (optString8 == JSONObject.NULL) {
            qVar.ajl = "";
        }
        qVar.ajm = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        qVar.clickTime = jSONObject.optLong("clickTime");
        qVar.ajo = jSONObject.optLong("frameRenderTime");
        qVar.ajp = jSONObject.optInt("playerEnterAction");
        String optString9 = jSONObject.optString("requestUrl");
        qVar.ajq = optString9;
        if (optString9 == JSONObject.NULL) {
            qVar.ajq = "";
        }
        qVar.ajr = jSONObject.optLong("requestTotalTime");
        qVar.ajs = jSONObject.optLong("requestResponseTime");
        qVar.ajt = jSONObject.optLong("requestParseDataTime");
        qVar.aju = jSONObject.optLong("requestCallbackTime");
        String optString10 = jSONObject.optString("requestFailReason");
        qVar.ajv = optString10;
        if (optString10 == JSONObject.NULL) {
            qVar.ajv = "";
        }
        String optString11 = jSONObject.optString("pageName");
        qVar.NY = optString11;
        if (optString11 == JSONObject.NULL) {
            qVar.NY = "";
        }
        qVar.Of = jSONObject.optLong("pageCreateTime");
        qVar.Og = jSONObject.optLong("pageResumeTime");
        qVar.ajw = jSONObject.optInt("trackUrlType");
        qVar.ajx = jSONObject.optJSONArray("trackUrlList");
        qVar.Oe = jSONObject.optLong("pageLaunchTime");
        qVar.ajA = jSONObject.optJSONArray("appAuthorityInfoList");
        String optString12 = jSONObject.optString("tkVersion");
        qVar.ajB = optString12;
        if (optString12 == JSONObject.NULL) {
            qVar.ajB = "";
        }
        String optString13 = jSONObject.optString("jsVersion");
        qVar.ajC = optString13;
        if (optString13 == JSONObject.NULL) {
            qVar.ajC = "";
        }
        String optString14 = jSONObject.optString("jsFileName");
        qVar.ajD = optString14;
        if (optString14 == JSONObject.NULL) {
            qVar.ajD = "";
        }
        String optString15 = jSONObject.optString("jsErrorMsg");
        qVar.ajE = optString15;
        if (optString15 == JSONObject.NULL) {
            qVar.ajE = "";
        }
        String optString16 = jSONObject.optString("jsConfig");
        qVar.ajF = optString16;
        if (optString16 == JSONObject.NULL) {
            qVar.ajF = "";
        }
        qVar.ajG = jSONObject.optInt("adBizType");
        String optString17 = jSONObject.optString("customKey");
        qVar.ajH = optString17;
        if (optString17 == JSONObject.NULL) {
            qVar.ajH = "";
        }
        String optString18 = jSONObject.optString("customValue");
        qVar.ajI = optString18;
        if (optString18 == JSONObject.NULL) {
            qVar.ajI = "";
        }
        String optString19 = jSONObject.optString("trace");
        qVar.trace = optString19;
        if (optString19 == JSONObject.NULL) {
            qVar.trace = "";
        }
        qVar.ajJ = jSONObject.optInt("filterCode");
        qVar.ajK = jSONObject.optInt("sdkVersionCode");
        String optString20 = jSONObject.optString("sdkVersion");
        qVar.sdkVersion = optString20;
        if (optString20 == JSONObject.NULL) {
            qVar.sdkVersion = "";
        }
        String optString21 = jSONObject.optString("sdkApiVersion");
        qVar.SM = optString21;
        if (optString21 == JSONObject.NULL) {
            qVar.SM = "";
        }
        qVar.SO = jSONObject.optInt("sdkType");
        qVar.ajL = jSONObject.optLong("appUseDuration");
        qVar.ajM = jSONObject.optLong("appStartType");
        qVar.aeM = jSONObject.optLong("sequenceNumber");
        String optString22 = jSONObject.optString("appColdStart");
        qVar.Hq = optString22;
        if (optString22 == JSONObject.NULL) {
            qVar.Hq = "";
        }
        String optString23 = jSONObject.optString("appStart");
        qVar.Hr = optString23;
        if (optString23 == JSONObject.NULL) {
            qVar.Hr = "";
        }
    }

    /* renamed from: b */
    private static JSONObject b2(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = qVar.timestamp;
        if (j2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j2);
        }
        String str = qVar.sessionId;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sessionId", qVar.sessionId);
        }
        long j3 = qVar.Ht;
        if (j3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "seq", j3);
        }
        long j4 = qVar.aiF;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "listId", j4);
        }
        long j5 = qVar.aiG;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, VideoActivity.EXTRA_KEY_ACTION_TYPE, j5);
        }
        String str2 = qVar.Ts;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", qVar.Ts);
        }
        long j6 = qVar.llsid;
        if (j6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "llsid", j6);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "extra", qVar.aiH);
        com.kwad.sdk.utils.t.putValue(jSONObject, "impAdExtra", qVar.aiI);
        long j7 = qVar.posId;
        if (j7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "posId", j7);
        }
        int i2 = qVar.contentType;
        if (i2 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "contentType", i2);
        }
        int i3 = qVar.realShowType;
        if (i3 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "realShowType", i3);
        }
        long j8 = qVar.photoId;
        if (j8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoId", j8);
        }
        long j9 = qVar.position;
        if (j9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "position", j9);
        }
        long j10 = qVar.aiJ;
        if (j10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "serverPosition", j10);
        }
        long j11 = qVar.aiK;
        if (j11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoDuration", j11);
        }
        long j12 = qVar.aiL;
        if (j12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "effectivePlayDuration", j12);
        }
        long j13 = qVar.Vl;
        if (j13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playDuration", j13);
        }
        long j14 = qVar.blockDuration;
        if (j14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockDuration", j14);
        }
        long j15 = qVar.aiM;
        if (j15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "intervalDuration", j15);
        }
        long j16 = qVar.aiN;
        if (j16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "allIntervalDuration", j16);
        }
        long j17 = qVar.aiO;
        if (j17 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "flowSdk", j17);
        }
        long j18 = qVar.aiP;
        if (j18 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "blockTimes", j18);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "contentSourceType", qVar.contentSourceType);
        int i4 = qVar.aiQ;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adAggPageSource", i4);
        }
        String str3 = qVar.entryPageSource;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "entryPageSource", qVar.entryPageSource);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "urlPackage", qVar.urlPackage);
        com.kwad.sdk.utils.t.a(jSONObject, "referURLPackage", qVar.aiR);
        long j19 = qVar.Pa;
        if (j19 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, j19);
        }
        String str4 = qVar.aiS;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "photoSize", qVar.aiS);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appInstalled", qVar.aiT);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appUninstalled", qVar.aiU);
        com.kwad.sdk.utils.t.a(jSONObject, "clientExt", qVar.aiV);
        int i5 = qVar.aiW;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerType", i5);
        }
        int i6 = qVar.aiX;
        if (i6 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "uiType", i6);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "isLeftSlipStatus", qVar.aiY);
        int i7 = qVar.Tt;
        if (i7 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", i7);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "photoResponseType", qVar.aiZ);
        String str5 = qVar.failUrl;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "failUrl", qVar.failUrl);
        }
        String str6 = qVar.errorMsg;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "errorMsg", qVar.errorMsg);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "errorCode", qVar.errorCode);
        long j20 = qVar.creativeId;
        if (j20 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j20);
        }
        String str7 = qVar.ajc;
        if (str7 != null && !str7.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cacheFailedReason", qVar.ajc);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appExt", qVar.ajd);
        com.kwad.sdk.utils.t.putValue(jSONObject, "appRunningInfoList", qVar.aje);
        long j21 = qVar.downloadDuration;
        if (j21 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "downloadDuration", j21);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, Constant.Param.KEY_RPK_PAGE_TYPE, qVar.pageType);
        int i8 = qVar.ajf;
        if (i8 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitStatus", i8);
        }
        int i9 = qVar.ajg;
        if (i9 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "speedLimitThreshold", i9);
        }
        int i10 = qVar.ajh;
        if (i10 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "currentRealDownloadSpeed", i10);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "sdkPlatform", qVar.ajj);
        boolean z = qVar.ajk;
        if (z) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "isKsUnion", z);
        }
        String str8 = qVar.ajl;
        if (str8 != null && !str8.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackMethodName", qVar.ajl);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "viewModeType", qVar.ajm);
        long j22 = qVar.clickTime;
        if (j22 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "clickTime", j22);
        }
        long j23 = qVar.ajo;
        if (j23 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "frameRenderTime", j23);
        }
        int i11 = qVar.ajp;
        if (i11 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "playerEnterAction", i11);
        }
        String str9 = qVar.ajq;
        if (str9 != null && !str9.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestUrl", qVar.ajq);
        }
        long j24 = qVar.ajr;
        if (j24 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestTotalTime", j24);
        }
        long j25 = qVar.ajs;
        if (j25 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestResponseTime", j25);
        }
        long j26 = qVar.ajt;
        if (j26 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestParseDataTime", j26);
        }
        long j27 = qVar.aju;
        if (j27 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestCallbackTime", j27);
        }
        String str10 = qVar.ajv;
        if (str10 != null && !str10.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "requestFailReason", qVar.ajv);
        }
        String str11 = qVar.NY;
        if (str11 != null && !str11.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageName", qVar.NY);
        }
        long j28 = qVar.Of;
        if (j28 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageCreateTime", j28);
        }
        long j29 = qVar.Og;
        if (j29 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageResumeTime", j29);
        }
        int i12 = qVar.ajw;
        if (i12 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlType", i12);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "trackUrlList", qVar.ajx);
        long j30 = qVar.Oe;
        if (j30 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageLaunchTime", j30);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "appAuthorityInfoList", qVar.ajA);
        String str12 = qVar.ajB;
        if (str12 != null && !str12.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "tkVersion", qVar.ajB);
        }
        String str13 = qVar.ajC;
        if (str13 != null && !str13.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsVersion", qVar.ajC);
        }
        String str14 = qVar.ajD;
        if (str14 != null && !str14.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsFileName", qVar.ajD);
        }
        String str15 = qVar.ajE;
        if (str15 != null && !str15.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsErrorMsg", qVar.ajE);
        }
        String str16 = qVar.ajF;
        if (str16 != null && !str16.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "jsConfig", qVar.ajF);
        }
        int i13 = qVar.ajG;
        if (i13 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "adBizType", i13);
        }
        String str17 = qVar.ajH;
        if (str17 != null && !str17.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customKey", qVar.ajH);
        }
        String str18 = qVar.ajI;
        if (str18 != null && !str18.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "customValue", qVar.ajI);
        }
        String str19 = qVar.trace;
        if (str19 != null && !str19.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "trace", qVar.trace);
        }
        int i14 = qVar.ajJ;
        if (i14 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "filterCode", i14);
        }
        int i15 = qVar.ajK;
        if (i15 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersionCode", i15);
        }
        String str20 = qVar.sdkVersion;
        if (str20 != null && !str20.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkVersion", qVar.sdkVersion);
        }
        String str21 = qVar.SM;
        if (str21 != null && !str21.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkApiVersion", qVar.SM);
        }
        int i16 = qVar.SO;
        if (i16 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sdkType", i16);
        }
        long j31 = qVar.ajL;
        if (j31 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appUseDuration", j31);
        }
        long j32 = qVar.ajM;
        if (j32 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStartType", j32);
        }
        long j33 = qVar.aeM;
        if (j33 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "sequenceNumber", j33);
        }
        String str22 = qVar.Hq;
        if (str22 != null && !str22.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appColdStart", qVar.Hq);
        }
        String str23 = qVar.Hr;
        if (str23 != null && !str23.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "appStart", qVar.Hr);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        a2(qVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.report.q qVar, JSONObject jSONObject) {
        return b2(qVar, jSONObject);
    }
}
