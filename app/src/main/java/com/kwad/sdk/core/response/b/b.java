package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bm;
import com.martian.mibook.ui.colorpicker.ColorPicker;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    private static Random aEe = new Random();

    public static int a(boolean z10, @NonNull AdInfo adInfo) {
        return z10 ? adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType : adInfo.adMatrixInfo.adDataV2.fullScreenInfo.renderType;
    }

    public static long cA(@NonNull AdTemplate adTemplate) {
        return cv(adTemplate).intervalTime;
    }

    public static boolean cB(@NonNull AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        return !a.aF(eb2) && a.at(eb2);
    }

    public static boolean cC(@NonNull AdTemplate adTemplate) {
        if (!TextUtils.isEmpty(cw(adTemplate)) && cx(adTemplate) > 0) {
            return an.isOrientationPortrait();
        }
        return false;
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate cD(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.halfCardInfo;
    }

    @Nullable
    public static String cE(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cD(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.EndCardInfo cF(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.endCardInfo;
    }

    @Nullable
    public static String cG(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cF(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static boolean cH(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cG(adTemplate));
    }

    @Nullable
    private static String cI(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, e.eb(adTemplate).adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static String cJ(@NonNull AdTemplate adTemplate) {
        return cK(adTemplate) ? cI(adTemplate) : a.aS(e.eb(adTemplate));
    }

    private static boolean cK(@NonNull AdTemplate adTemplate) {
        return (adTemplate.mIsForceJumpLandingPage || a.ch(adTemplate) || !dA(e.eb(adTemplate))) ? false : true;
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cL(@NonNull AdTemplate adTemplate) {
        return cM(adTemplate) ? ck(adTemplate).adDataV2.adUnionFeedLiveTemplateInfo : ck(adTemplate).adDataV2.feedInfo;
    }

    private static boolean cM(@NonNull AdTemplate adTemplate) {
        return a.cS(e.eb(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.FeedInfo cN(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.adUnionFeedLiveMediaInfo;
    }

    @Nullable
    public static String cO(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cL(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    private static AdMatrixInfo.FeedTKInfo cP(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.feedTKCardInfo;
    }

    @Nullable
    public static String cQ(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cN(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    @Nullable
    public static boolean cR(@NonNull AdTemplate adTemplate) {
        return cL(adTemplate).interactionInfo.interactiveStyle == 2;
    }

    @Nullable
    public static boolean cS(@NonNull AdTemplate adTemplate) {
        return cL(adTemplate).interactionInfo.shakeInfo.clickDisabled;
    }

    @Nullable
    public static int cT(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.ShakeInfo shakeInfo;
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = cL(adTemplate).interactionInfo;
        if (adInteractionInfo == null || (shakeInfo = adInteractionInfo.shakeInfo) == null) {
            return 0;
        }
        return shakeInfo.acceleration;
    }

    public static double cU(@NonNull AdTemplate adTemplate) {
        return e.eb(adTemplate).adStyleInfo.feedAdInfo.heightRatio;
    }

    public static boolean cV(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cO(adTemplate));
    }

    public static boolean cW(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cP(adTemplate).templateId);
    }

    public static String cX(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.FeedTKInfo cP = cP(adTemplate);
        return TextUtils.isEmpty(cP.templateId) ? "ksad-feed-card" : cP.templateId;
    }

    public static boolean cY(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cQ(adTemplate));
    }

    public static float cZ(@NonNull AdTemplate adTemplate) {
        int i10;
        try {
            i10 = e.eb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            i10 = 7;
        }
        if (i10 > 0) {
            return i10;
        }
        return 7.0f;
    }

    @NonNull
    public static AdMatrixInfo ck(@NonNull AdTemplate adTemplate) {
        return e.dT(adTemplate) ? e.eb(adTemplate).adMatrixInfo : new AdMatrixInfo();
    }

    public static List<AdMatrixInfo.MatrixTemplate> cl(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).styles.templateList;
    }

    @NonNull
    public static AdMatrixInfo.AdDataV2 cm(@NonNull AdTemplate adTemplate) {
        return e.eb(adTemplate).adMatrixInfo.adDataV2;
    }

    public static FeedSlideConf cn(@NonNull AdTemplate adTemplate) {
        JSONArray optJSONArray;
        AdMatrixInfo.TemplateData l10 = l(adTemplate, cL(adTemplate).templateId);
        try {
            JSONObject optJSONObject = new JSONObject(l10 != null ? l10.data : "").optJSONObject("slideInfo");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray(ColorPicker.K)) != null && optJSONArray.length() > 1) {
                FeedSlideConf feedSlideConf = new FeedSlideConf();
                feedSlideConf.minRange = ((Integer) optJSONArray.get(0)).intValue();
                feedSlideConf.maxRange = ((Integer) optJSONArray.get(1)).intValue();
                return feedSlideConf;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static boolean co(@NonNull AdTemplate adTemplate) {
        return n(adTemplate, cp(adTemplate).templateId);
    }

    @NonNull
    public static AdMatrixInfo.InterstitialCardInfo cp(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.interstitialCardInfo;
    }

    @Nullable
    public static String cq(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, ck(adTemplate).adDataV2.splashActionBarInfo.templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    @NonNull
    private static AdMatrixInfo.ActionBarInfoNew cr(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.actionBarInfo;
    }

    @Nullable
    public static String cs(@NonNull AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        boolean z10 = e.ev(adTemplate) || e.dV(adTemplate) == 2;
        if (a.cS(eb2)) {
            return "";
        }
        if (z10 && a.cj(adTemplate)) {
            AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, dk(adTemplate).templateId);
            return k10 != null ? k10.templateUrl : "";
        }
        AdMatrixInfo.MatrixTemplate k11 = k(adTemplate, cr(adTemplate).templateId);
        return k11 != null ? k11.templateUrl : "";
    }

    public static long ct(@NonNull AdTemplate adTemplate) {
        return cr(adTemplate).maxTimeOut;
    }

    public static boolean cu(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(cs(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.AggregationCardInfo cv(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.aggregationCardInfo;
    }

    @Nullable
    public static String cw(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, cv(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static long cx(@NonNull AdTemplate adTemplate) {
        return m(adTemplate, cv(adTemplate).templateId);
    }

    public static long cy(@NonNull AdTemplate adTemplate) {
        return cv(adTemplate).changeTime * 1000;
    }

    public static int cz(@NonNull AdTemplate adTemplate) {
        return cv(adTemplate).maxTimesPerDay;
    }

    public static boolean dA(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.templateId);
    }

    public static String dB(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.title;
    }

    public static long dC(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.tkDefaultTimeout;
    }

    public static String dD(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo.subTitle;
    }

    public static String dE(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.splashActionBarInfo.title;
    }

    public static boolean dF(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.interactionInfo.interactiveStyle == 2;
    }

    public static String dG(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.cutIconUrl;
    }

    public static String dH(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.refreshIconUrl;
    }

    public static String dI(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.interstitialCardInfo.cycleAggregateInfo.convertIconUrl;
    }

    public static int dJ(@NonNull AdInfo adInfo) {
        try {
            int i10 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.componentIndex;
            if (i10 != 2) {
                return 1;
            }
            return i10;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return 1;
        }
    }

    public static boolean dK(@NonNull AdInfo adInfo) {
        AdMatrixInfo.AdInteractionInfo adInteractionInfo = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo;
        return adInteractionInfo.isMediaDisable && adInteractionInfo.interactiveStyle == 4;
    }

    public static boolean dL(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 2;
    }

    public static int dM(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
    }

    public static int dN(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle;
    }

    public static boolean dO(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 2;
    }

    public static boolean dP(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 1;
    }

    public static boolean dQ(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 1;
    }

    public static boolean dR(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 3;
    }

    public static boolean dS(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 10;
    }

    public static boolean dT(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactivityDefaultStyle == 3;
    }

    public static boolean dU(@NonNull AdInfo adInfo) {
        try {
            int i10 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle;
            return i10 == 4 || i10 == 9;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dV(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.interactiveStyle == 4;
    }

    public static boolean dW(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static long dX(@NonNull AdInfo adInfo) {
        try {
            long j10 = adInfo.adMatrixInfo.adDataV2.splashInfo.interactionInfo.switchDefaultTime;
            return j10 <= 0 ? qe.a.f30009d : j10;
        } catch (Exception unused) {
            return qe.a.f30009d;
        }
    }

    public static boolean dY(@NonNull AdInfo adInfo) {
        return !adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.clickDisabled;
    }

    public static float dZ(@NonNull AdInfo adInfo) {
        int i10;
        try {
            i10 = adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            i10 = 7;
        }
        return i10;
    }

    public static boolean da(@NonNull AdTemplate adTemplate) {
        try {
            return e.eb(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType == 1;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return false;
        }
    }

    public static float db(@NonNull AdTemplate adTemplate) {
        int i10;
        try {
            i10 = e.eb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            i10 = 7;
        }
        return i10;
    }

    public static AdMatrixInfo.RotateInfo dc(@NonNull AdTemplate adTemplate) {
        try {
            return e.eb(adTemplate).adMatrixInfo.adDataV2.splashInfo.interactionInfo.rotateInfo;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return null;
        }
    }

    public static AdMatrixInfo.RotateInfo dd(@NonNull AdTemplate adTemplate) {
        try {
            AdMatrixInfo.AdInteractionInfo adInteractionInfo = cL(adTemplate).interactionInfo;
            if (adInteractionInfo != null) {
                return adInteractionInfo.rotateInfo;
            }
            return null;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return null;
        }
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate de(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.complianceCardInfo;
    }

    @Nullable
    public static String df(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, de(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static boolean dg(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(df(adTemplate));
    }

    @NonNull
    private static AdMatrixInfo.BaseMatrixTemplate dh(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.downloadConfirmCardInfo;
    }

    @Nullable
    public static String di(@NonNull AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate k10 = k(adTemplate, dh(adTemplate).templateId);
        return k10 != null ? k10.templateUrl : "";
    }

    public static boolean dj(@NonNull AdTemplate adTemplate) {
        return !TextUtils.isEmpty(di(adTemplate));
    }

    public static AdMatrixInfo.MerchantLiveReservationInfo dk(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.merchantLiveReservationInfo;
    }

    public static AdMatrixInfo.FullScreenInfo dl(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.fullScreenInfo;
    }

    public static AdMatrixInfo.SplashPlayCardTKInfo dm(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.splashPlayCardTKInfo;
    }

    public static long dn(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.splashPlayCardTKInfo.tkTimeout;
    }

    /* renamed from: do */
    public static int m38do(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.splashPlayCardTKInfo.renderType;
    }

    public static AdMatrixInfo.AdBannerTKInfo dp(@NonNull AdTemplate adTemplate) {
        return ck(adTemplate).adDataV2.bannerTKInfo;
    }

    public static boolean dq(AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        return (g(eb2) || e.en(adTemplate) || cr(adTemplate).cardType == 4 || e.eb(adTemplate).adStyleInfo2.playDetailInfo.detailCommonInfo.rewardInteractionType > 0 || eb2.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    public static boolean dr(AdTemplate adTemplate) {
        AdInfo eb2 = e.eb(adTemplate);
        return (g(eb2) || e.en(adTemplate) || cr(adTemplate).cardType == 4 || e.eb(adTemplate).adStyleInfo2.playDetailInfo.detailWebCardInfo.cardType == 4 || eb2.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.interactiveStyle != 2) ? false : true;
    }

    @Nullable
    public static AdMatrixInfo.PreLandingPageTKInfo ds(@NonNull AdTemplate adTemplate) {
        return e.eb(adTemplate).adMatrixInfo.adDataV2.preLandingPageTKInfo;
    }

    public static boolean dt(@NonNull AdTemplate adTemplate) {
        return cm(adTemplate).installedActivateInfo.cardSwitch;
    }

    public static long du(@NonNull AdTemplate adTemplate) {
        long j10 = cm(adTemplate).installedActivateInfo.showTime;
        if (j10 > 0) {
            return j10;
        }
        return 0L;
    }

    public static boolean dv(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.templateId);
    }

    public static boolean dw(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardFullScreenClick;
    }

    public static boolean dx(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.topFloorTKInfo.templateId);
    }

    public static boolean dy(@NonNull AdInfo adInfo) {
        return !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.splashPlayCardTKInfo.templateId);
    }

    public static boolean dz(@NonNull AdInfo adInfo) {
        if (dA(adInfo)) {
            return adInfo.adMatrixInfo.adDataV2.activityMiddlePageInfo.showHeaderBar;
        }
        return true;
    }

    public static boolean eB(String str) {
        try {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).cb(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public static float ea(@NonNull AdInfo adInfo) {
        int i10;
        try {
            i10 = adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.acceleration;
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            i10 = 7;
        }
        return i10;
    }

    public static String eb(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.title;
    }

    public static String ec(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.title;
    }

    public static String ed(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static String ee(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.shakeInfo.subtitle;
    }

    public static AdMatrixInfo.DownloadTexts ef(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.fullScreenInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static AdMatrixInfo.DownloadTexts eg(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoVideoInfo.interactionInfo.splashActionBarInfo.downloadTexts;
    }

    public static boolean eh(@NonNull AdInfo adInfo) {
        for (AdMatrixInfo.MatrixTag matrixTag : adInfo.adMatrixInfo.tag) {
            if ("playEndClose".equals(matrixTag.type)) {
                return matrixTag.isHide;
            }
        }
        return false;
    }

    public static boolean ei(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.neoTKInfo.renderType == 1;
    }

    public static boolean ej(@NonNull AdInfo adInfo) {
        return (a.bJ(adInfo) || TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.templateId)) ? false : true;
    }

    public static int ek(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.preLandingPageTKInfo.preLandingPageShowType;
    }

    public static String el(@NonNull AdInfo adInfo) {
        return adInfo.adMatrixInfo.adDataV2.videoLiveTKInfo.templateId;
    }

    public static boolean em(@NonNull AdInfo adInfo) {
        return a.bd(adInfo) && !TextUtils.isEmpty(adInfo.adMatrixInfo.adDataV2.videoImageTKInfo.templateId);
    }

    public static boolean g(@NonNull AdInfo adInfo) {
        return (!adInfo.adRewardInfo.recommendAggregateSwitch || a.cY(adInfo) || a.bJ(adInfo)) ? false : true;
    }

    @Nullable
    public static AdMatrixInfo.MatrixTemplate k(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.MatrixTemplate matrixTemplate : ck(adTemplate).styles.templateList) {
            if (bm.isEquals(str, matrixTemplate.templateId)) {
                return matrixTemplate;
            }
        }
        return null;
    }

    @Nullable
    private static AdMatrixInfo.TemplateData l(@NonNull AdTemplate adTemplate, String str) {
        for (AdMatrixInfo.TemplateData templateData : ck(adTemplate).adDataV2.templateDataList) {
            if (bm.isEquals(str, templateData.templateId)) {
                return templateData;
            }
        }
        return null;
    }

    private static long m(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l10 = l(adTemplate, str);
        if (l10 != null) {
            return l10.templateDelayTime;
        }
        return 0L;
    }

    private static boolean n(@NonNull AdTemplate adTemplate, String str) {
        AdMatrixInfo.TemplateData l10 = l(adTemplate, str);
        try {
            JSONObject optJSONObject = new JSONObject(l10 != null ? l10.data : "").optJSONObject("autoCallAppInfo");
            if (optJSONObject != null) {
                return !TextUtils.isEmpty(optJSONObject.optString("adTitle"));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String dA(AdTemplate adTemplate) {
        return cm(adTemplate).rewardVideoTaskInfo.templateId;
    }

    public static String dB(AdTemplate adTemplate) {
        return cm(adTemplate).splashPlayCardTKInfo.templateId;
    }

    public static String dC(AdTemplate adTemplate) {
        return cm(adTemplate).splashEndCardTKInfo.templateId;
    }

    public static String dD(AdTemplate adTemplate) {
        return cm(adTemplate).bannerTKInfo.templateId;
    }

    public static String dE(AdTemplate adTemplate) {
        return cm(adTemplate).interstitialCardInfo.templateId;
    }

    public static String dF(AdTemplate adTemplate) {
        return cm(adTemplate).confirmTKInfo.templateId;
    }

    public static String dG(AdTemplate adTemplate) {
        return cm(adTemplate).activityTKInfo.templateId;
    }

    public static String dH(AdTemplate adTemplate) {
        return cm(adTemplate).rewardWebTaskCloseInfo.templateId;
    }

    public static String dI(AdTemplate adTemplate) {
        return cm(adTemplate).rewardVideoInteractInfo.templateId;
    }

    public static String dK(AdTemplate adTemplate) {
        return cm(adTemplate).preLandingPageTKInfo.templateId;
    }

    public static String dL(AdTemplate adTemplate) {
        return cm(adTemplate).feedTKCardInfo.templateId;
    }

    public static String dv(AdTemplate adTemplate) {
        return cm(adTemplate).topFloorTKInfo.templateId;
    }

    public static String dw(AdTemplate adTemplate) {
        return cm(adTemplate).neoTKInfo.templateId;
    }

    public static String dx(AdTemplate adTemplate) {
        return cm(adTemplate).videoLiveTKInfo.templateId;
    }

    public static String dy(AdTemplate adTemplate) {
        return cm(adTemplate).videoImageTKInfo.templateId;
    }

    public static String dJ(AdTemplate adTemplate) {
        return cm(adTemplate).pushTKInfo.templateId;
    }

    public static String dz(AdTemplate adTemplate) {
        return cm(adTemplate).fullScreenInfo.templateId;
    }
}
