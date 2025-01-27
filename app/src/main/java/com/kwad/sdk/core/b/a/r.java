package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class r implements com.kwad.sdk.core.d<AdMatrixInfo.AdDataV2> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        a2(adDataV2, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        return b2(adDataV2, jSONObject);
    }

    /* renamed from: a */
    private static void a2(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adDataV2.templateDataList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("templateDatas");
        if (optJSONArray != null) {
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                AdMatrixInfo.TemplateData templateData = new AdMatrixInfo.TemplateData();
                templateData.parseJson(optJSONArray.optJSONObject(i10));
                adDataV2.templateDataList.add(templateData);
            }
        }
        AdMatrixInfo.BottomBannerInfo bottomBannerInfo = new AdMatrixInfo.BottomBannerInfo();
        adDataV2.bottomBannerInfo = bottomBannerInfo;
        bottomBannerInfo.parseJson(jSONObject.optJSONObject("bottomBannerInfo"));
        AdMatrixInfo.ActionBarInfoNew actionBarInfoNew = new AdMatrixInfo.ActionBarInfoNew();
        adDataV2.actionBarInfo = actionBarInfoNew;
        actionBarInfoNew.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        AdMatrixInfo.AggregationCardInfo aggregationCardInfo = new AdMatrixInfo.AggregationCardInfo();
        adDataV2.aggregationCardInfo = aggregationCardInfo;
        aggregationCardInfo.parseJson(jSONObject.optJSONObject("aggregationCardInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.halfCardInfo = baseMatrixTemplate;
        baseMatrixTemplate.parseJson(jSONObject.optJSONObject("halfCardInfo"));
        AdMatrixInfo.EndCardInfo endCardInfo = new AdMatrixInfo.EndCardInfo();
        adDataV2.endCardInfo = endCardInfo;
        endCardInfo.parseJson(jSONObject.optJSONObject("endCardInfo"));
        AdMatrixInfo.InterstitialCardInfo interstitialCardInfo = new AdMatrixInfo.InterstitialCardInfo();
        adDataV2.interstitialCardInfo = interstitialCardInfo;
        interstitialCardInfo.parseJson(jSONObject.optJSONObject("interstitialCardInfo"));
        AdMatrixInfo.FeedInfo feedInfo = new AdMatrixInfo.FeedInfo();
        adDataV2.feedInfo = feedInfo;
        feedInfo.parseJson(jSONObject.optJSONObject("feedInfo"));
        AdMatrixInfo.FeedTKInfo feedTKInfo = new AdMatrixInfo.FeedTKInfo();
        adDataV2.feedTKCardInfo = feedTKInfo;
        feedTKInfo.parseJson(jSONObject.optJSONObject("feedTKCardInfo"));
        AdMatrixInfo.FeedInfo feedInfo2 = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveMediaInfo = feedInfo2;
        feedInfo2.parseJson(jSONObject.optJSONObject("adUnionFeedLiveMediaInfo"));
        AdMatrixInfo.FeedInfo feedInfo3 = new AdMatrixInfo.FeedInfo();
        adDataV2.adUnionFeedLiveTemplateInfo = feedInfo3;
        feedInfo3.parseJson(jSONObject.optJSONObject("adUnionFeedLiveTemplateInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate2 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.complianceCardInfo = baseMatrixTemplate2;
        baseMatrixTemplate2.parseJson(jSONObject.optJSONObject("complianceCardInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate3 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.downloadConfirmCardInfo = baseMatrixTemplate3;
        baseMatrixTemplate3.parseJson(jSONObject.optJSONObject("downloadConfirmCardInfo"));
        AdMatrixInfo.SplashInfo splashInfo = new AdMatrixInfo.SplashInfo();
        adDataV2.splashInfo = splashInfo;
        splashInfo.parseJson(jSONObject.optJSONObject("splashInfo"));
        AdMatrixInfo.NeoVideoInfo neoVideoInfo = new AdMatrixInfo.NeoVideoInfo();
        adDataV2.neoVideoInfo = neoVideoInfo;
        neoVideoInfo.parseJson(jSONObject.optJSONObject("neoVideoInfo"));
        AdMatrixInfo.FullScreenInfo fullScreenInfo = new AdMatrixInfo.FullScreenInfo();
        adDataV2.fullScreenInfo = fullScreenInfo;
        fullScreenInfo.parseJson(jSONObject.optJSONObject("fullScreenInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate4 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.middleTKCardInfo = baseMatrixTemplate4;
        baseMatrixTemplate4.parseJson(jSONObject.optJSONObject("middleTKCardInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate5 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.actionBarTKInfo = baseMatrixTemplate5;
        baseMatrixTemplate5.parseJson(jSONObject.optJSONObject("actionBarTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate6 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.topBarTKInfo = baseMatrixTemplate6;
        baseMatrixTemplate6.parseJson(jSONObject.optJSONObject("topBarTKInfo"));
        AdMatrixInfo.SplashPlayCardTKInfo splashPlayCardTKInfo = new AdMatrixInfo.SplashPlayCardTKInfo();
        adDataV2.splashPlayCardTKInfo = splashPlayCardTKInfo;
        splashPlayCardTKInfo.parseJson(jSONObject.optJSONObject("splashPlayCardTKInfo"));
        AdMatrixInfo.SplashEndCardTKInfo splashEndCardTKInfo = new AdMatrixInfo.SplashEndCardTKInfo();
        adDataV2.splashEndCardTKInfo = splashEndCardTKInfo;
        splashEndCardTKInfo.parseJson(jSONObject.optJSONObject("splashEndCardTKInfo"));
        AdMatrixInfo.TopFloorTKInfo topFloorTKInfo = new AdMatrixInfo.TopFloorTKInfo();
        adDataV2.topFloorTKInfo = topFloorTKInfo;
        topFloorTKInfo.parseJson(jSONObject.optJSONObject("topFloorTKInfo"));
        AdMatrixInfo.ActivityMiddlePageInfo activityMiddlePageInfo = new AdMatrixInfo.ActivityMiddlePageInfo();
        adDataV2.activityMiddlePageInfo = activityMiddlePageInfo;
        activityMiddlePageInfo.parseJson(jSONObject.optJSONObject("activityMiddlePageInfo"));
        AdMatrixInfo.AdBannerTKInfo adBannerTKInfo = new AdMatrixInfo.AdBannerTKInfo();
        adDataV2.bannerTKInfo = adBannerTKInfo;
        adBannerTKInfo.parseJson(jSONObject.optJSONObject("bannerTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate7 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.confirmTKInfo = baseMatrixTemplate7;
        baseMatrixTemplate7.parseJson(jSONObject.optJSONObject("confirmTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate8 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.playendTKInfo = baseMatrixTemplate8;
        baseMatrixTemplate8.parseJson(jSONObject.optJSONObject("playendTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate9 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.activityTKInfo = baseMatrixTemplate9;
        baseMatrixTemplate9.parseJson(jSONObject.optJSONObject("activityTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate10 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.neoTKInfo = baseMatrixTemplate10;
        baseMatrixTemplate10.parseJson(jSONObject.optJSONObject("neoTKInfo"));
        AdMatrixInfo.RewardVideoInteractInfo rewardVideoInteractInfo = new AdMatrixInfo.RewardVideoInteractInfo();
        adDataV2.rewardVideoInteractInfo = rewardVideoInteractInfo;
        rewardVideoInteractInfo.parseJson(jSONObject.optJSONObject("rewardVideoInteractInfo"));
        AdMatrixInfo.RewardVideoTaskInfo rewardVideoTaskInfo = new AdMatrixInfo.RewardVideoTaskInfo();
        adDataV2.rewardVideoTaskInfo = rewardVideoTaskInfo;
        rewardVideoTaskInfo.parseJson(jSONObject.optJSONObject("rewardVideoTaskInfo"));
        AdMatrixInfo.RewardWebTaskCloseInfo rewardWebTaskCloseInfo = new AdMatrixInfo.RewardWebTaskCloseInfo();
        adDataV2.rewardWebTaskCloseInfo = rewardWebTaskCloseInfo;
        rewardWebTaskCloseInfo.parseJson(jSONObject.optJSONObject("rewardWebTaskCloseInfo"));
        AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo = new AdMatrixInfo.MerchantLiveReservationInfo();
        adDataV2.merchantLiveReservationInfo = merchantLiveReservationInfo;
        merchantLiveReservationInfo.parseJson(jSONObject.optJSONObject("merchantLiveReservationInfo"));
        AdMatrixInfo.PushTKInfo pushTKInfo = new AdMatrixInfo.PushTKInfo();
        adDataV2.pushTKInfo = pushTKInfo;
        pushTKInfo.parseJson(jSONObject.optJSONObject("pushTKInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate11 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.splashActionBarInfo = baseMatrixTemplate11;
        baseMatrixTemplate11.parseJson(jSONObject.optJSONObject("splashActionBarInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate12 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.videoLiveTKInfo = baseMatrixTemplate12;
        baseMatrixTemplate12.parseJson(jSONObject.optJSONObject("videoLiveTKInfo"));
        AdMatrixInfo.PreLandingPageTKInfo preLandingPageTKInfo = new AdMatrixInfo.PreLandingPageTKInfo();
        adDataV2.preLandingPageTKInfo = preLandingPageTKInfo;
        preLandingPageTKInfo.parseJson(jSONObject.optJSONObject("preLandingPageTKInfo"));
        AdMatrixInfo.InstalledActivateInfo installedActivateInfo = new AdMatrixInfo.InstalledActivateInfo();
        adDataV2.installedActivateInfo = installedActivateInfo;
        installedActivateInfo.parseJson(jSONObject.optJSONObject("installedActivateInfo"));
        AdMatrixInfo.BaseMatrixTemplate baseMatrixTemplate13 = new AdMatrixInfo.BaseMatrixTemplate();
        adDataV2.videoImageTKInfo = baseMatrixTemplate13;
        baseMatrixTemplate13.parseJson(jSONObject.optJSONObject("videoImageTKInfo"));
        AdMatrixInfo.DynamicAdStyleInfo dynamicAdStyleInfo = new AdMatrixInfo.DynamicAdStyleInfo();
        adDataV2.dynamicAdStyleInfo = dynamicAdStyleInfo;
        dynamicAdStyleInfo.parseJson(jSONObject.optJSONObject("dynamicAdStyleInfo"));
    }

    /* renamed from: b */
    private static JSONObject b2(AdMatrixInfo.AdDataV2 adDataV2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.x.putValue(jSONObject, "templateDatas", adDataV2.templateDataList);
        com.kwad.sdk.utils.x.a(jSONObject, "bottomBannerInfo", adDataV2.bottomBannerInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "actionBarInfo", adDataV2.actionBarInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "aggregationCardInfo", adDataV2.aggregationCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "halfCardInfo", adDataV2.halfCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "endCardInfo", adDataV2.endCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "interstitialCardInfo", adDataV2.interstitialCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "feedInfo", adDataV2.feedInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "feedTKCardInfo", adDataV2.feedTKCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "adUnionFeedLiveMediaInfo", adDataV2.adUnionFeedLiveMediaInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "adUnionFeedLiveTemplateInfo", adDataV2.adUnionFeedLiveTemplateInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "complianceCardInfo", adDataV2.complianceCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "downloadConfirmCardInfo", adDataV2.downloadConfirmCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "splashInfo", adDataV2.splashInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "neoVideoInfo", adDataV2.neoVideoInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "fullScreenInfo", adDataV2.fullScreenInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "middleTKCardInfo", adDataV2.middleTKCardInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "actionBarTKInfo", adDataV2.actionBarTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "topBarTKInfo", adDataV2.topBarTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "splashPlayCardTKInfo", adDataV2.splashPlayCardTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "splashEndCardTKInfo", adDataV2.splashEndCardTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "topFloorTKInfo", adDataV2.topFloorTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "activityMiddlePageInfo", adDataV2.activityMiddlePageInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "bannerTKInfo", adDataV2.bannerTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "confirmTKInfo", adDataV2.confirmTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "playendTKInfo", adDataV2.playendTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "activityTKInfo", adDataV2.activityTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "neoTKInfo", adDataV2.neoTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "rewardVideoInteractInfo", adDataV2.rewardVideoInteractInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "rewardVideoTaskInfo", adDataV2.rewardVideoTaskInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "rewardWebTaskCloseInfo", adDataV2.rewardWebTaskCloseInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "merchantLiveReservationInfo", adDataV2.merchantLiveReservationInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "pushTKInfo", adDataV2.pushTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "splashActionBarInfo", adDataV2.splashActionBarInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "videoLiveTKInfo", adDataV2.videoLiveTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "preLandingPageTKInfo", adDataV2.preLandingPageTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "installedActivateInfo", adDataV2.installedActivateInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "videoImageTKInfo", adDataV2.videoImageTKInfo);
        com.kwad.sdk.utils.x.a(jSONObject, "dynamicAdStyleInfo", adDataV2.dynamicAdStyleInfo);
        return jSONObject;
    }
}
