package com.kwad.components.ad.feed.monitor;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.x;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b {
    public static void a(AdTemplate adTemplate, int i10, int i11, String str, String str2, long j10) {
        if (i11 == 1 && adTemplate.mHasReportVideoLoad) {
            return;
        }
        if (i11 == 1) {
            adTemplate.mHasReportVideoLoad = true;
        }
        a(new FeedPageInfo().setStatus(3).setType(adTemplate.type).setLoadStatus(i10).setResourceLoadDuration(j10).setMaterialType(i11).setMaterialUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate), i10 == 2);
    }

    private static void b(com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(c.Cg().cB(ILoggerReporter.Category.APM_LOG).i(0.01d).N("ad_sdk_feed_callback", "callback_type").a(BusinessType.AD_FEED).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("reportFeedCallback", e10.toString());
        }
    }

    public static void bA() {
        a("ad_sdk_feed_adnum_monitor", new FeedErrorInfo(), 1.0E-4d);
    }

    public static void bB() {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_init").setSceneId("ad_feed"));
    }

    private static List<FeedPageInfo.a> c(List<KsFeedAd> list) {
        ArrayList arrayList = new ArrayList();
        for (KsFeedAd ksFeedAd : list) {
            if (ksFeedAd instanceof com.kwad.components.ad.feed.c) {
                AdInfo eb2 = e.eb(((com.kwad.components.ad.feed.c) ksFeedAd).getAdTemplate());
                arrayList.add(new FeedPageInfo.a().e(com.kwad.sdk.core.response.b.a.J(eb2)).u(com.kwad.sdk.core.response.b.a.be(eb2)).q(com.kwad.sdk.core.response.b.a.bb(eb2)));
            }
        }
        return arrayList;
    }

    public static void e(int i10, String str) {
        a((com.kwad.sdk.commercial.c.a) new FeedPageInfo().setStatus(9).setErrorCode(i10).setErrorMsg(str), true);
    }

    public static void f(int i10, String str) {
        a(new FeedPageInfo().setStatus(10).setLoadStatus(i10).setErrorMsg(str), i10 == 2);
    }

    public static void g(int i10, String str) {
        a("ad_sdk_feed_request_monitor", (FeedErrorInfo) new FeedErrorInfo().setErrorCode(i10).setErrorMsg(str), 1.0d);
    }

    public static void i(AdTemplate adTemplate) {
        a(new FeedPageInfo().setStatus(11).setAdTemplate(adTemplate));
    }

    public static void j(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("ad_show").setSceneId("ad_feed").setAdTemplate(adTemplate));
    }

    public static void s(int i10) {
        a(new FeedPageInfo().setStatus(1).setAdNum(i10));
    }

    public static void t(int i10) {
        a(new FeedPageInfo().setStatus(2).setAdNum(i10));
    }

    public static void b(int i10, int i11, AdTemplate adTemplate) {
        a("ad_sdk_feed_showType_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i10).setFeedType(i11).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(AdTemplate adTemplate, int i10, int i11, long j10, String str) {
        a(new FeedPageInfo().setStatus(5).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.eb(adTemplate))).setRenderType(i10).setLoadType(adTemplate.loadType).setExpectedRenderType(i11).setErrorMsg(str).setRenderDuration(j10).setAdTemplate(adTemplate), (i10 == 2 || i10 == 3) ? false : true);
    }

    public static void a(int i10, long j10) {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "feedLoadOptimizeType", d.CU());
        x.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.CX());
        x.putValue(jSONObject, "isExternal", l.At().zB());
        a(new FeedPageInfo().setStatus(6).setAdNum(i10).setLoadDataDuration(j10).setAbParams(jSONObject.toString()));
    }

    public static void a(AdTemplate adTemplate, int i10, int i11) {
        JSONObject jSONObject = new JSONObject();
        x.putValue(jSONObject, "feedLoadOptimizeType", d.CU());
        x.putValue(jSONObject, "feedLoadOptimizeExternalEnable", d.CX());
        x.putValue(jSONObject, "isExternal", l.At().zB());
        a(new FeedPageInfo().setStatus(7).setType(adTemplate.type).setLoadType(adTemplate.loadType).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.eb(adTemplate))).setRenderType(i10).setExpectedRenderType(i11).setAbParams(jSONObject.toString()).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i10, long j10) {
        a(new FeedPageInfo().setStatus(8).setType(adTemplate.type).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.eb(adTemplate))).setRenderType(i10).setConvertDuration(j10).setAdTemplate(adTemplate));
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar) {
        a(aVar, false);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z10) {
        try {
            com.kwad.sdk.commercial.b.d(c.Cg().cB(z10 ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).i(z10 ? 0.01d : 0.001d).N("ad_sdk_feed_load", "status").a(BusinessType.AD_FEED).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aYu));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.e("reportFeedPageLineLog", e10.toString());
        }
    }

    public static void a(int i10, AdTemplate adTemplate, String str, int i11) {
        b(new FeedPageInfo().setCallbackType(i10).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.eb(adTemplate))).setMaterialUrl(str).setRenderType(i11).setAdTemplate(adTemplate));
    }

    public static void a(long j10, List<KsFeedAd> list) {
        if (list == null || list.size() == 0 || !(list.get(0) instanceof com.kwad.components.ad.feed.c)) {
            return;
        }
        b(new FeedPageInfo().setCallbackType(1).setPosId(j10).setMaterialInfoList(c(list)).setAdTemplate(((com.kwad.components.ad.feed.c) list.get(0)).getAdTemplate()));
    }

    private static void a(String str, FeedErrorInfo feedErrorInfo, double d10) {
        try {
            com.kwad.sdk.commercial.b.d(c.Cg().cB(ILoggerReporter.Category.ERROR_LOG).a(BusinessType.AD_FEED).N(str, DownloadSettingKeys.BugFix.DEFAULT).cC(str).a(com.kwai.adclient.kscommerciallogger.model.a.aYu).u(feedErrorInfo).i(d10));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.d("reportFeedError", e10.toString());
        }
    }

    public static void a(long j10, int i10, int i11, AdTemplate adTemplate) {
        a("ad_sdk_feed_width_monitor", (FeedErrorInfo) new FeedErrorInfo().setWidth(j10).setMaterialType(i10).setFeedType(i11).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(int i10, int i11, AdTemplate adTemplate, int i12) {
        a("ad_sdk_feed_h5_monitor", (FeedErrorInfo) new FeedErrorInfo().setMaterialType(i11).setErrorType(i12).setErrorCode(i10).setAdTemplate(adTemplate), 1.0d);
    }

    public static void a(AdTemplate adTemplate, String str) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_load_url").setSceneId("ad_feed").setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j10, int i10) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_timeout").setSceneId("ad_feed").setTimeType(i10).setDurationMs(j10).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, String str, long j10) {
        com.kwad.sdk.commercial.b.f(new FeedWebViewInfo().setEvent("webview_load_finish").setSceneId("ad_feed").setDurationMs(j10).setUrl(str).setAdTemplate(adTemplate));
    }
}
