package com.kwad.components.core.d.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d extends com.kwad.sdk.core.download.kwai.b {
    private static boolean Ji = false;
    private static final b Jj = new b() { // from class: com.kwad.components.core.d.b.d.2
        long Jm;

        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Jm = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Jm != 0) {
                com.kwad.sdk.core.report.a.j(getAdTemplate(), System.currentTimeMillis() - this.Jm);
            }
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.core.b.b.b(d.Jj);
            setAdTemplate(null);
            this.Jm = 0L;
        }
    };

    /* renamed from: com.kwad.components.core.d.b.d$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ int Jl;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            SceneImpl sceneImpl;
            d.ax(false);
            com.kwad.sdk.core.b.b.vS();
            if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                return;
            }
            com.kwad.sdk.core.report.a.a(AdTemplate.this, "", i2);
            BusinessType businessType = null;
            AdTemplate adTemplate = AdTemplate.this;
            if (adTemplate != null && (sceneImpl = adTemplate.mAdScene) != null) {
                businessType = KSLoggerReporter.bv(sceneImpl.getAdStyle());
            }
            KSLoggerReporter.ReportClient.CONVERT_DPLINK.buildMethodCheck(businessType, "trueDplinkSuccess");
        }
    }

    /* renamed from: com.kwad.components.core.d.b.d$2 */
    static class AnonymousClass2 extends b {
        long Jm;

        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToBackground() {
            super.onBackToBackground();
            this.Jm = System.currentTimeMillis();
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            if (this.Jm != 0) {
                com.kwad.sdk.core.report.a.j(getAdTemplate(), System.currentTimeMillis() - this.Jm);
            }
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.core.b.b.b(d.Jj);
            setAdTemplate(null);
            this.Jm = 0L;
        }
    }

    private static String a(a.C0172a c0172a, AdInfo adInfo, String str) {
        String str2;
        if (!com.kwad.sdk.core.response.a.a.ba(adInfo)) {
            return str;
        }
        String mM = (c0172a.jG() == null || c0172a.jG().getCurrentShowShopItemInfo() == null) ? c0172a.mM() : c0172a.jG().getCurrentShowShopItemInfo().itemId;
        if (TextUtils.isEmpty(mM)) {
            return (str.contains("__itemId__") || str.contains("__simpleItemId__")) ? com.kwad.sdk.core.response.a.a.cs(adInfo) : str;
        }
        try {
            str2 = String.valueOf(com.kwad.components.core.d.kwai.a.am(mM));
        } catch (Throwable unused) {
            str2 = mM;
        }
        return str.replaceAll("__itemId__", mM).replaceAll("__simpleItemId__", str2);
    }

    public static String a(a.C0172a c0172a, AdTemplate adTemplate) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        for (AdInfo.AdConversionInfo.DeeplinkItemInfo deeplinkItemInfo : cb.adConversionInfo.deeplinkConf) {
            boolean contains = deeplinkItemInfo.areaConf.contains(Integer.valueOf(c0172a.de()));
            boolean contains2 = deeplinkItemInfo.sceneConf.contains(Integer.valueOf(c0172a.mO()));
            if ((contains && contains2) || ((contains && deeplinkItemInfo.sceneConf.size() == 0) || (contains2 && deeplinkItemInfo.areaConf.size() == 0))) {
                if (!TextUtils.isEmpty(deeplinkItemInfo.url)) {
                    return deeplinkItemInfo.url + cb.adConversionInfo.deeplinkExtra;
                }
            }
        }
        return com.kwad.sdk.core.response.a.a.cs(cb);
    }

    private static String a(String str, int i2, String str2) {
        return TextUtils.isEmpty(str2) ? str : (i2 == 0 || i2 == 3) ? g(str, str2) : str;
    }

    private static String a(String str, Context context, SceneImpl sceneImpl) {
        if (sceneImpl == null) {
            return "";
        }
        int i2 = 0;
        if (!ak.ah(context, "com.smile.gifmaker") && ak.ah(context, "com.kuaishou.nebula")) {
            i2 = 3;
        }
        String backUrl = sceneImpl.getBackUrl();
        return a(str, i2, TextUtils.isEmpty(backUrl) ? "" : backUrl);
    }

    private static String a(String str, a.C0172a c0172a, AdInfo adInfo) {
        AdTemplate adTemplate = c0172a.getAdTemplate();
        if (com.kwad.sdk.core.response.a.a.bb(adInfo)) {
            str = b(c0172a, adInfo, str);
        }
        if (com.kwad.sdk.core.response.a.a.cq(adInfo)) {
            str = a(c0172a, adInfo, str);
        }
        return ((com.kwad.sdk.core.response.a.a.ci(adInfo) || com.kwad.sdk.core.response.a.a.co(adInfo)) && adTemplate.mAdScene != null) ? a(str, c0172a.getContext(), adTemplate.mAdScene) : str;
    }

    private static JSONObject ar(String str) {
        try {
            return new JSONObject(Uri.parse(str).getQueryParameter("universeClientInfo"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void aw(boolean z) {
        com.kwad.sdk.core.report.a.ahR = z;
    }

    public static void ax(boolean z) {
        Ji = z;
    }

    public static int b(a.C0172a c0172a, int i2) {
        Context context = c0172a.getContext();
        AdTemplate adTemplate = c0172a.getAdTemplate();
        if (adTemplate == null || context == null) {
            return 0;
        }
        b bVar = Jj;
        bVar.setAdTemplate(adTemplate);
        com.kwad.sdk.core.b.b.vS();
        com.kwad.sdk.core.b.b.a(bVar);
        String a2 = a(a(c0172a, adTemplate), c0172a, com.kwad.sdk.core.response.a.d.cb(adTemplate));
        com.kwad.sdk.core.report.a.ahQ = ar(a2);
        int g2 = com.kwad.sdk.core.download.kwai.b.g(context, a2);
        BusinessType businessType = null;
        if (g2 == 1) {
            if (c0172a.getAdTemplate() != null && c0172a.getAdTemplate().mAdScene != null) {
                businessType = KSLoggerReporter.bv(c0172a.getAdTemplate().mAdScene.getAdStyle());
            }
            KSLoggerReporter.ReportClient.CONVERT_DPLINK.buildMethodCheck(businessType, "dplinkSuccess");
            com.kwad.sdk.core.report.a.a(adTemplate, "", i2, c0172a.getClientParams());
            e(adTemplate, i2);
        } else if (g2 == -1) {
            com.kwad.sdk.core.report.a.b(adTemplate, "", i2, (y.b) null);
        }
        return g2;
    }

    private static String b(a.C0172a c0172a, AdInfo adInfo, String str) {
        long j2 = c0172a.getAdTemplate().getmCurPlayTime();
        if (j2 > 0) {
            j2 = Math.max(j2 - com.kwad.sdk.core.response.a.a.bc(adInfo), 0L);
        }
        return Uri.parse(str).buildUpon().appendQueryParameter("playStartTime", String.valueOf(j2)).toString();
    }

    private static void e(AdTemplate adTemplate, int i2) {
        if (nr()) {
            return;
        }
        ax(true);
        int uo = com.kwad.sdk.core.config.d.uo();
        com.kwad.sdk.core.config.d.up();
        if (Math.abs(uo) > 0) {
            bi.a(new Runnable() { // from class: com.kwad.components.core.d.b.d.1
                final /* synthetic */ int Jl;

                AnonymousClass1(int i22) {
                    i2 = i22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    SceneImpl sceneImpl;
                    d.ax(false);
                    com.kwad.sdk.core.b.b.vS();
                    if (com.kwad.sdk.core.b.b.isAppOnForeground()) {
                        return;
                    }
                    com.kwad.sdk.core.report.a.a(AdTemplate.this, "", i2);
                    BusinessType businessType = null;
                    AdTemplate adTemplate2 = AdTemplate.this;
                    if (adTemplate2 != null && (sceneImpl = adTemplate2.mAdScene) != null) {
                        businessType = KSLoggerReporter.bv(sceneImpl.getAdStyle());
                    }
                    KSLoggerReporter.ReportClient.CONVERT_DPLINK.buildMethodCheck(businessType, "trueDplinkSuccess");
                }
            }, null, r0 * 1000);
        } else {
            ax(false);
        }
    }

    private static String g(String str, String str2) {
        Uri.Builder appendQueryParameter = Uri.parse(str).buildUpon().appendQueryParameter("returnBack", "liveunion_" + KsAdSDKImpl.get().getAppId());
        if (TextUtils.isEmpty(str2)) {
            str2 = "0";
        }
        return appendQueryParameter.appendQueryParameter("back_url", str2).toString();
    }

    private static boolean nr() {
        return Ji;
    }
}
