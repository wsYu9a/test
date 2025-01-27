package com.kwad.sdk.core.response.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    private static Random alN = new Random();

    @NonNull
    public static AdMatrixInfo aJ(@NonNull AdTemplate adTemplate) {
        return d.bT(adTemplate) ? d.cb(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static FeedSlideConf aK(@NonNull AdTemplate adTemplate) {
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData d2 = d(adTemplate, bh(adTemplate).templateId);
        try {
            JSONObject optJSONObject = new JSONObject(d2 != null ? d2.data : "").optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("angle")) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean aL(@NonNull AdTemplate adTemplate) {
        return f(adTemplate, aM(adTemplate).templateId);
    }

    @NonNull
    private static AdMatrixInfo.InterstitialCardInfo aM(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String aN(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, aJ(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.ActionBarInfoNew aO(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    public static String aP(@NonNull AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        int bV = d.bV(adTemplate);
        boolean z = bV == 3 || bV == 2;
        if (a.cq(cb)) {
            return "";
        }
        if (z && a.ck(cb)) {
            return cE(cb);
        }
        if (z && a.aI(adTemplate)) {
            AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bI(adTemplate).templateId);
            return b2 != null ? b2.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate b3 = b(adTemplate, aO(adTemplate).templateId);
        return b3 != null ? b3.templateUrl : "";
    }

    public static long aQ(@NonNull AdTemplate adTemplate) {
        return aO(adTemplate).maxTimeOut;
    }

    public static boolean aR(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(aP(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.AggregationCardInfo aS(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    public static String aT(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, aS(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static long aU(@NonNull AdTemplate adTemplate) {
        return e(adTemplate, aS(adTemplate).templateId);
    }

    public static long aV(@NonNull AdTemplate adTemplate) {
        return aS(adTemplate).changeTime * 1000;
    }

    public static int aW(@NonNull AdTemplate adTemplate) {
        return aS(adTemplate).maxTimesPerDay;
    }

    public static long aX(@NonNull AdTemplate adTemplate) {
        return aS(adTemplate).intervalTime;
    }

    public static boolean aY(@NonNull AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        return !a.ax(cb) && a.ak(cb);
    }

    public static boolean aZ(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(aT(adTemplate)) && aU(adTemplate) > 0) {
            return ai.DM();
        }
        return false;
    }

    private static boolean am(@NonNull AdInfo adInfo) {
        return adInfo.adBaseInfo.taskType == 4;
    }

    @Nullable
    private static AdMatrixInfo.MatrixTemplate b(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : aJ(adTemplate).styles.templateList) {
            if (bb.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_tk").aF(adTemplate).a(BusinessType.TACHIKOMA).J("TkTemplateDataLost", str).report();
        return null;
    }

    @Nullable
    public static String bA(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bz(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static boolean bB(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bA(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate bC(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String bD(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bC(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static boolean bE(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bD(adTemplate));
    }

    public static boolean bF(@NonNull AdTemplate adTemplate) {
        List<AdInfo> list = adTemplate.adInfoList;
        if (list != null && list.size() != 0) {
            AdInfo adInfo = adTemplate.adInfoList.get(0);
            if (!a.cv(adInfo) && !a.bv(adInfo) && adInfo.adBaseInfo.taskType == 4) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate bG(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.rewardWatchOnceInfo;
    }

    @Nullable
    public static String bH(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bG(adTemplate).templateId);
        if (b2 != null) {
            return b2.templateUrl;
        }
        return null;
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo bI(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo bJ(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.fullScreenInfo;
    }

    public static boolean bK(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        if (h(cb) || d.co(adTemplate)) {
            return false;
        }
        return !(aO(adTemplate).cardType == 4) && d.cb(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType <= 0 && cb.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean bL(AdTemplate adTemplate) {
        AdInfo cb = d.cb(adTemplate);
        if (h(cb) || d.co(adTemplate)) {
            return false;
        }
        return ((aO(adTemplate).cardType == 4) || d.cb(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || cb.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    @Nullable
    public static AdMatrixInfo.PreLandingPageTKInfo bM(@NonNull AdTemplate adTemplate) {
        return d.cb(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate ba(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String bb(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, ba(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.EndCardInfo bc(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    public static String bd(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bc(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static boolean be(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bd(adTemplate));
    }

    @Nullable
    private static String bf(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, d.cb(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static String bg(@NonNull AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || !cK(d.cb(adTemplate))) ? a.aK(d.cb(adTemplate)) : bf(adTemplate);
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo bh(@NonNull AdTemplate adTemplate) {
        boolean bi = bi(adTemplate);
        AdMatrixInfo.AdDataV2 adDataV2 = aJ(adTemplate).adDataV2;
        return bi ? adDataV2.adUnionFeedLiveTemplateInfo : adDataV2.feedInfo;
    }

    private static boolean bi(@NonNull AdTemplate adTemplate) {
        return a.cq(d.cb(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo bj(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String bk(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bh(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    @Nullable
    public static String bl(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bj(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    @Nullable
    public static boolean bm(@NonNull AdTemplate adTemplate) {
        return bh(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    @Nullable
    public static boolean bn(@NonNull AdTemplate adTemplate) {
        return bh(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int bo(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = bh(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    public static double bp(@NonNull AdTemplate adTemplate) {
        return d.cb(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean bq(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bk(adTemplate));
    }

    public static boolean br(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(bl(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.InterstitialCardInfo bs(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.interstitialCardInfo;
    }

    public static float bt(@NonNull AdTemplate adTemplate) {
        int i2;
        try {
            i2 = d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        if (i2 > 0) {
            return i2;
        }
        return 7.0f;
    }

    public static boolean bu(@NonNull AdTemplate adTemplate) {
        try {
            return d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return false;
        }
    }

    public static int bv(@NonNull AdTemplate adTemplate) {
        return d.cb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType;
    }

    @Nullable
    public static String bw(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate b2 = b(adTemplate, bs(adTemplate).templateId);
        return b2 != null ? b2.templateUrl : "";
    }

    public static float bx(@NonNull AdTemplate adTemplate) {
        int i2;
        try {
            i2 = d.cb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        return i2;
    }

    public static AdMatrixInfo.RotateInfo by(@NonNull AdTemplate adTemplate) {
        try {
            return d.cb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate bz(@NonNull AdTemplate adTemplate) {
        return aJ(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate c(@NonNull AdTemplate adTemplate, String str) {
        return b(adTemplate, str);
    }

    @Nullable
    @Deprecated
    private static String cE(AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        String str = adInfo.adStyleInfo.playDetailInfo.detailWebCardInfo.cardUrl;
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).aY(str)) {
            return str;
        }
        return null;
    }

    public static boolean cF(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean cG(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean cH(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean cI(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean cI(String str) {
        try {
            return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).aY(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean cJ(@NonNull AdInfo adInfo) {
        if (cK(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean cK(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static AdMatrixInfo.DownloadTexts cL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts cM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.slideInfo.downloadTexts;
    }

    public static String cN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static long cO(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String cP(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static AdMatrixInfo.DownloadTexts cQ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static String cR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean cS(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static String cT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    public static String cU(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    public static String cV(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    public static int cW(@NonNull AdInfo adInfo) {
        try {
            int i2 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i2 != 2) {
                return 1;
            }
            return i2;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 1;
        }
    }

    public static boolean cX(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean cY(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static boolean cZ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    @Nullable
    private static AdMatrixInfo.TemplateData d(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : aJ(adTemplate).adDataV2.templateDataList) {
            if (bb.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    public static boolean da(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean db(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean dc(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean dd(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean de(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean df(@NonNull AdInfo adInfo) {
        try {
            int i2 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            return i2 == 4 || i2 == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dg(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 0;
    }

    public static boolean dh(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean di(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static long dj(@NonNull AdInfo adInfo) {
        try {
            long j2 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            if (j2 <= 0) {
                return 1500L;
            }
            return j2;
        } catch (Exception unused) {
            return 1500L;
        }
    }

    public static boolean dk(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static float dl(@NonNull AdInfo adInfo) {
        int i2;
        try {
            i2 = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        return i2;
    }

    public static float dm(@NonNull AdInfo adInfo) {
        int i2;
        try {
            i2 = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            i2 = 7;
        }
        return i2;
    }

    public static String dn(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    /* renamed from: do */
    public static String m59do(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String dp(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String dq(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts dr(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts ds(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean dt(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean du(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static boolean dv(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId);
    }

    private static long e(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData d2 = d(adTemplate, str);
        if (d2 != null) {
            return d2.templateDelayTime;
        }
        return 0L;
    }

    private static boolean f(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData d2 = d(adTemplate, str);
        try {
            JSONObject optJSONObject = new JSONObject(d2 != null ? d2.data : "").optJSONObject("autoCallAppInfo");
            if (optJSONObject != null) {
                return !TextUtils.isEmpty(optJSONObject.optString("adTitle"));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(@NonNull AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || am(adInfo) || a.cv(adInfo) || a.bv(adInfo)) ? false : true;
    }
}
