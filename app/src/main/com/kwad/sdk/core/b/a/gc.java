package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.commercial.j.a;
import com.kwad.sdk.commercial.model.HybridLoadMsg;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.commercial.model.WebViewCommercialMsg;
import com.kwad.sdk.commercial.model.WebViewLoadMsg;
import com.kwad.sdk.core.g.a;
import com.kwad.sdk.core.imageloader.ImageLoaderInfo;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.core.response.model.ABParams;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdStatusInfo;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.core.response.model.HttpDnsInfo;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.internal.api.AdLabelImpl;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import com.kwad.sdk.n.l;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class gc {
    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> azc;

    static {
        HashMap hashMap = new HashMap();
        azc = hashMap;
        hashMap.put(TKAdLiveShopItemInfo.class, new ki());
        azc.put(AdStyleInfo.ExposeTagInfo.class, new du());
        azc.put(AdInfo.UnDownloadConf.class, new kx());
        azc.put(AdMatrixInfo.SplashEndCardTKInfo.class, new jo());
        azc.put(com.kwad.sdk.commercial.f.b.class, new dd());
        azc.put(AdInfo.AdPreloadInfo.class, new al());
        azc.put(AdInfo.UnDownloadRegionConf.class, new ky());
        azc.put(FeedSlideConf.class, new ed());
        azc.put(AdMatrixInfo.AdDataV2.class, new r());
        azc.put(AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo.class, new df());
        azc.put(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo.class, new gj());
        azc.put(com.kwad.sdk.commercial.e.b.class, new p());
        azc.put(AdMatrixInfo.class, new aj());
        azc.put(AdMatrixInfo.ShakeInfo.class, new jc());
        azc.put(SplashExtraDataImpl.class, new jp());
        azc.put(com.kwad.sdk.utils.b.a.class, new gg());
        azc.put(AdMatrixInfo.DownloadTexts.class, new dm());
        azc.put(AdInfo.PlayableStyleInfo.class, new ie());
        azc.put(AdMatrixInfo.MerchantLiveReservationInfo.class, new gu());
        azc.put(AdInfo.AdDrawInfo.class, new s());
        azc.put(AdMatrixInfo.SplashPlayCardTKInfo.class, new jt());
        azc.put(AdMatrixInfo.SplashActionBarInfo.class, new jm());
        azc.put(AdMatrixInfo.AdInteractionInfo.class, new z());
        azc.put(StatusInfo.SplashStyleControl.class, new jy());
        azc.put(AdInfo.CallBackStrategyInfo.class, new cb());
        azc.put(com.kwad.sdk.g.a.a.class, new hp());
        azc.put(AdStyleInfo.AdBrowseInfo.class, new l());
        azc.put(PhotoInfo.class, new hx());
        azc.put(AdInfo.AdConversionInfo.class, new m());
        azc.put(com.kwad.sdk.commercial.a.b.class, new bf());
        azc.put(com.kwad.sdk.commercial.c.a.class, new bu());
        azc.put(HybridLoadMsg.class, new ff());
        azc.put(AdMatrixInfo.BaseMatrixTemplate.class, new bv());
        azc.put(PageInfo.class, new hs());
        azc.put(AdInfo.AdBaseInfo.class, new j());
        azc.put(AdMatrixInfo.TemplateData.class, new kq());
        azc.put(SceneImpl.class, new jb());
        azc.put(AdMatrixInfo.RewardWebTaskCloseInfo.class, new it());
        azc.put(AdMatrixInfo.PreLandingPageTKInfo.class, new ig());
        azc.put(AdInfo.AdInsertScreenInfo.class, new y());
        azc.put(AdInfo.AdTrackInfo.class, new av());
        azc.put(PhotoInfo.VideoInfo.class, new le());
        azc.put(AdInfo.MaterialSize.class, new gr());
        azc.put(com.kwad.sdk.commercial.smallApp.b.class, new jk());
        azc.put(AdMatrixInfo.ActivityMiddlePageInfo.class, new g());
        azc.put(AdMatrixInfo.StyleInfo.class, new kg());
        azc.put(com.kwad.sdk.core.network.j.class, new hk());
        azc.put(com.kwad.sdk.core.request.model.f.class, new km());
        azc.put(AdMatrixInfo.InterstitialCardInfo.class, new fs());
        azc.put(SDKInitMsg.class, new ix());
        azc.put(AdMatrixInfo.ActionBarInfoNew.class, new d());
        azc.put(ImageLoaderInfo.class, new fi());
        azc.put(AdInfo.AdFeedInfo.class, new t());
        azc.put(HttpDnsInfo.IpInfo.class, new fw());
        azc.put(AdStyleInfo.PlayDetailInfo.WidgetAdInfo.class, new lq());
        azc.put(AdInfo.NativeAdInfo.class, new gz());
        azc.put(AdMatrixInfo.RewardVideoInteractInfo.class, new ir());
        azc.put(AdInfo.class, new x());
        azc.put(URLPackage.class, new kw());
        azc.put(AdVideoPreCacheConfig.class, new ay());
        azc.put(com.kwad.sdk.commercial.d.b.class, new n());
        azc.put(AdMatrixInfo.MatrixTemplate.class, new gt());
        azc.put(StatusInfo.NativeAdRequestInfo.class, new ha());
        azc.put(AdInfo.AdAggregateInfo.class, new h());
        azc.put(AdInfo.AdvertiserInfo.class, new ba());
        azc.put(AdMatrixInfo.EndCardInfo.class, new dp());
        azc.put(AdMatrixInfo.NeoVideoInfo.class, new hh());
        azc.put(com.kwad.sdk.commercial.b.b.class, new bj());
        azc.put(AdStyleInfo.PlayDetailInfo.ActionBarInfo.class, new c());
        azc.put(AdLabelImpl.class, new aa());
        azc.put(AdStyleInfo.PlayDetailInfo.DrawAdInfo.class, new dn());
        azc.put(AdMatrixInfo.RewardVideoTaskInfo.class, new is());
        azc.put(AdProductInfo.SpikeInfo.class, new jl());
        azc.put(StatusInfo.NativeAdStyleControl.class, new hc());
        azc.put(AdInfo.AdShowVideoH5Info.class, new ao());
        azc.put(com.kwad.sdk.commercial.e.c.class, new q());
        azc.put(AdInfo.NativeAdShakeInfo.class, new hb());
        azc.put(StatusInfo.class, new ke());
        azc.put(AdMatrixInfo.DynamicAdStyleInfo.class, new Cdo());
        azc.put(AdMatrixInfo.CycleAggregateInfo.class, new da());
        azc.put(AdStyleInfo.PlayDetailInfo.DetailCommonInfo.class, new de());
        azc.put(com.kwad.sdk.commercial.i.a.class, new gn());
        azc.put(AdStyleInfo.FeedAdInfo.class, new dy());
        azc.put(AdStyleInfo.class, new as());
        azc.put(AdStyleInfo.ExtraDisplayInfo.class, new dw());
        azc.put(AdInfo.DownloadSafeInfo.class, new dk());
        azc.put(com.kwad.sdk.core.network.i.class, new hj());
        azc.put(ABParams.class, new a());
        azc.put(AdMatrixInfo.SplashSlideInfo.class, new jx());
        azc.put(AdStyleInfo.PlayEndInfo.class, new ia());
        azc.put(l.a.class, new lr());
        azc.put(com.kwad.sdk.core.threads.b.class, new kr());
        azc.put(a.C0496a.class, new kk());
        azc.put(AdInfo.AdConversionInfo.DeeplinkItemInfo.class, new dc());
        azc.put(HttpDnsInfo.class, new fe());
        azc.put(AdMatrixInfo.InstalledActivateInfo.class, new fp());
        azc.put(AdInfo.AdBannerInfo.class, new i());
        azc.put(com.kwad.sdk.core.request.model.g.class, new lc());
        azc.put(AdStyleInfo.PlayDetailInfo.DetailWebCardInfo.class, new dg());
        azc.put(AdStyleInfo.PlayDetailInfo.PatchEcInfo.class, new hw());
        azc.put(WebCloseStatus.class, new ln());
        azc.put(CouponInfo.class, new cw());
        azc.put(StatusInfo.SplashAdInfo.class, new jn());
        azc.put(com.kwad.sdk.core.request.model.b.class, new dh());
        azc.put(PhotoInfo.BaseInfo.class, new bt());
        azc.put(AdMatrixInfo.MatrixTag.class, new gs());
        azc.put(com.kwad.sdk.core.threads.d.class, new ks());
        azc.put(AdInfo.H5Config.class, new ex());
        azc.put(AdInfo.ComplianceInfo.class, new cm());
        azc.put(AdMatrixInfo.RotateInfo.class, new iw());
        azc.put(WebViewLoadMsg.class, new lp());
        azc.put(a.C0482a.class, new kv());
        azc.put(com.kwad.sdk.core.request.model.d.class, new hi());
        azc.put(AdMatrixInfo.BottomBannerInfo.class, new bz());
        azc.put(AdInfo.AdMaterialInfo.class, new ai());
        azc.put(AdInfo.AdStyleConfInfo.class, new ar());
        azc.put(AdStyleInfo.PlayDetailInfo.class, new hy());
        azc.put(TemplateConfig.class, new ko());
        azc.put(com.kwad.sdk.g.a.b.class, new hq());
        azc.put(AdInfo.RewardFraudVerifyInfo.class, new in());
        azc.put(AdStyleInfo.PlayEndInfo.AdWebCardInfo.class, new az());
        azc.put(AdMatrixInfo.SlideInfo.class, new ji());
        azc.put(AdStatusInfo.class, new aq());
        azc.put(AdMatrixInfo.RotateDegreeInfo.class, new iv());
        azc.put(com.kwad.sdk.commercial.j.b.class, new ax());
        azc.put(NativeAdExtraDataImpl.class, new gy());
        azc.put(com.kwad.sdk.core.report.j.class, new dr());
        azc.put(AdMatrixInfo.Styles.class, new kh());
        azc.put(AdTemplate.class, new au());
        azc.put(AdProductInfo.class, new am());
        azc.put(AdMatrixInfo.FullScreenInfo.class, new em());
        azc.put(VideoPlayerStatus.class, new li());
        azc.put(AdMatrixInfo.AggregationCardInfo.class, new bb());
        azc.put(WebViewCommercialMsg.class, new lo());
        azc.put(AdStyleInfo.PlayEndInfo.EndTopToolBarInfo.class, new dq());
        azc.put(com.kwad.sdk.commercial.g.b.class, new fa());
        azc.put(AdInfo.AdRewardInfo.class, new an());
        azc.put(AdMatrixInfo.FeedInfo.class, new ea());
        azc.put(AdMatrixInfo.SplashInfo.class, new jq());
        azc.put(AdGlobalConfigInfo.class, new v());
        azc.put(AdInfo.FullScreenVideoInfo.class, new en());
        azc.put(AdInfo.AdMaterialInfo.MaterialFeature.class, new gp());
        azc.put(AdGlobalConfigInfo.NeoScanAggregationSceneInfo.class, new hf());
        azc.put(AdInfo.CutRuleInfo.class, new cz());
        azc.put(AdInfo.AdSplashInfo.class, new ap());
        azc.put(l.a.C0513a.class, new ka());
        azc.put(AdInfo.SmallAppJumpInfo.class, new jj());
        azc.put(AdStyleInfo.PlayDetailInfo.PatchAdInfo.class, new hv());
        Fe();
    }

    @ForInvoker(methodId = "registerHolder")
    private static void Fe() {
        cn.Fe();
        co.Fe();
        cp.Fe();
        cq.Fe();
        cr.Fe();
        cs.Fe();
        ct.Fe();
        cu.Fe();
        ef.Fe();
        eg.Fe();
        eh.Fe();
        ei.Fe();
        ej.Fe();
        ek.Fe();
    }

    public static Map<Class<? extends com.kwad.sdk.core.response.a.a>, com.kwad.sdk.core.d> Ff() {
        return azc;
    }

    public static com.kwad.sdk.core.d getHolder(Class<? extends com.kwad.sdk.core.response.a.a> cls) {
        return azc.get(cls);
    }
}
