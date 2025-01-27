package com.kwad.components.core.d.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.a.kwai.k;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class a {
    private static List<WeakReference<k.b>> IH;

    /* renamed from: com.kwad.components.core.d.b.a$a */
    public static class C0172a {
        private boolean II;
        private boolean IJ;
        private boolean IK;
        private b IL;
        private c IM;
        private boolean IN;
        private long IO;
        private boolean IP;
        private boolean IQ;
        private y.b IR;
        private JSONObject IS;
        private boolean IT = false;
        private boolean IU;
        private int IV;
        private int IW;
        private int IX;
        private String IY;
        private AdTemplate adTemplate;
        private final Context context;
        private IAdLivePlayModule eV;
        private int jS;
        private int jU;

        public C0172a(Context context) {
            this.context = context;
        }

        public final C0172a I(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0172a a(b bVar) {
            this.IL = bVar;
            return this;
        }

        public final C0172a a(y.b bVar) {
            this.IR = bVar;
            return this;
        }

        public final C0172a an(int i2) {
            this.IX = i2;
            return this;
        }

        public final C0172a ao(int i2) {
            this.jU = i2;
            return this;
        }

        public final C0172a ao(boolean z) {
            this.IN = z;
            return this;
        }

        public final C0172a ap(int i2) {
            this.jS = i2;
            return this;
        }

        public final C0172a ap(String str) {
            this.IY = str;
            return this;
        }

        public final C0172a ap(boolean z) {
            this.IP = z;
            return this;
        }

        public final C0172a aq(int i2) {
            this.IV = i2;
            return this;
        }

        public final C0172a aq(boolean z) {
            this.IQ = z;
            return this;
        }

        public final C0172a ar(int i2) {
            this.IW = i2;
            return this;
        }

        public final C0172a ar(boolean z) {
            this.IT = z;
            return this;
        }

        public final C0172a as(boolean z) {
            this.IJ = z;
            return this;
        }

        public final C0172a at(boolean z) {
            this.IK = true;
            return this;
        }

        public final C0172a au(boolean z) {
            this.II = z;
            return this;
        }

        public final C0172a av(boolean z) {
            this.IU = z;
            return this;
        }

        public final C0172a b(c cVar) {
            this.IM = cVar;
            return this;
        }

        public final C0172a b(@Nullable IAdLivePlayModule iAdLivePlayModule) {
            this.eV = iAdLivePlayModule;
            return this;
        }

        public final C0172a d(JSONObject jSONObject) {
            this.IS = jSONObject;
            return this;
        }

        public final int db() {
            return this.jS;
        }

        public final int de() {
            return this.jU;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final y.b getClientParams() {
            return this.IR;
        }

        public final Context getContext() {
            return this.context;
        }

        public final c hb() {
            return this.IM;
        }

        public final JSONObject ho() {
            return this.IS;
        }

        public final IAdLivePlayModule jG() {
            return this.eV;
        }

        public final String mM() {
            return this.IY;
        }

        public final b mN() {
            return this.IL;
        }

        public final int mO() {
            return this.IX;
        }

        public final boolean mP() {
            return this.IN;
        }

        public final long mQ() {
            return this.IO;
        }

        public final boolean mR() {
            return this.IP;
        }

        public final boolean mS() {
            return this.IQ;
        }

        public final boolean mT() {
            return this.IT;
        }

        public final boolean mU() {
            return this.IJ;
        }

        public final boolean mV() {
            return this.IK;
        }

        public final boolean mW() {
            return this.II;
        }

        public final boolean mX() {
            return this.IU;
        }

        public final int mY() {
            return this.IV;
        }

        public final int mZ() {
            return this.IW;
        }

        public final C0172a q(long j2) {
            this.IO = j2;
            return this;
        }
    }

    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z, boolean z2, boolean z3) {
        adTemplate.converted = true;
        d.aw(false);
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        C0172a I = new C0172a(context).I(adTemplate);
        int ae = com.kwad.sdk.core.response.a.a.ae(cb);
        if (!(z3 || I.mZ() == 2 || I.mZ() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aK(cb)) && !I.mV()) {
            if (ae == 1) {
                boolean aZ = com.kwad.sdk.core.response.a.a.aZ(cb);
                bVar.onAdClicked();
                if (aZ) {
                    d(I.getContext(), adTemplate);
                } else {
                    a(I.getContext(), new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).oc());
                }
                return 0;
            }
            if (ae == 2) {
                if (a(I, 1) != 1) {
                    boolean aZ2 = com.kwad.sdk.core.response.a.a.aZ(cb);
                    bVar.onAdClicked();
                    if (aZ2) {
                        d(I.getContext(), adTemplate);
                    } else {
                        a(I.getContext(), new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).oc());
                    }
                    return 0;
                }
                d.aw(true);
                bVar.onAdClicked();
                return 0;
            }
        }
        if (a(I, 1) != 1) {
            if (!com.kwad.sdk.core.response.a.a.ax(cb)) {
                bVar.onAdClicked();
                if (com.kwad.sdk.utils.d.f(context, com.kwad.sdk.core.response.a.a.cu(cb), com.kwad.sdk.core.response.a.a.aq(cb))) {
                    com.kwad.sdk.core.report.a.l(adTemplate, 0);
                } else {
                    a(context, new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(adTemplate)).L(adTemplate).oc());
                }
                return 0;
            }
            if (cVar == null) {
                return 0;
            }
            int m = cVar.m(new C0172a(context).ao(z).I(adTemplate).ap(z2).ar(false));
            int i2 = cb.status;
            if (i2 != 2 && i2 != 3) {
                bVar.onAdClicked();
            }
            return m;
        }
        d.aw(true);
        bVar.onAdClicked();
        return 0;
    }

    public static int a(C0172a c0172a) {
        d.aw(false);
        BusinessType businessType = c0172a.adTemplate != null ? c0172a.adTemplate.getBusinessType() : null;
        KSLoggerReporter.ReportClient reportClient = KSLoggerReporter.ReportClient.CORE_CONVERT;
        reportClient.buildMethodCheck(businessType, "adClick").report();
        if (c0172a.mW()) {
            a(c0172a.getContext(), c0172a.getAdTemplate(), c0172a.mN(), c0172a.hb(), c0172a.IN, c0172a.mR(), false);
            return 0;
        }
        if (b(c0172a)) {
            return 0;
        }
        c0172a.getAdTemplate().converted = true;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(c0172a.getAdTemplate());
        com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
        int ae = com.kwad.sdk.core.response.a.a.ae(cb);
        if (!(c0172a.mZ() == 2 || c0172a.mZ() == 1) && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aK(cb)) && !c0172a.mV()) {
            if (ae == 1) {
                boolean aZ = com.kwad.sdk.core.response.a.a.aZ(cb);
                e(c0172a);
                if (aZ) {
                    d(c0172a.getContext(), c0172a.getAdTemplate());
                } else {
                    a(c0172a.getContext(), new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(c0172a.getAdTemplate())).L(c0172a.getAdTemplate()).oc());
                }
                return 0;
            }
            if (ae == 2) {
                if (a(c0172a, 1) == 1) {
                    if (com.kwad.sdk.core.response.a.a.cp(cb)) {
                        com.kwad.sdk.core.report.a.n(c0172a.getAdTemplate(), (int) Math.ceil(c0172a.mQ() / 1000.0f));
                    }
                    d.aw(true);
                    e(c0172a);
                    return 0;
                }
                boolean aZ2 = com.kwad.sdk.core.response.a.a.aZ(cb);
                e(c0172a);
                if (aZ2) {
                    d(c0172a.getContext(), c0172a.getAdTemplate());
                } else {
                    a(c0172a.getContext(), new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(c0172a.getAdTemplate())).L(c0172a.getAdTemplate()).oc());
                }
                return 0;
            }
        }
        if (a(c0172a, 1) == 1) {
            if (com.kwad.sdk.core.response.a.a.cp(cb) || com.kwad.sdk.core.response.a.a.cq(cb)) {
                com.kwad.sdk.core.report.a.n(c0172a.getAdTemplate(), (int) Math.ceil(c0172a.mQ() / 1000.0f));
            }
            d.aw(true);
            e(c0172a);
            return 0;
        }
        if (e.f(c0172a.getContext(), c0172a.getAdTemplate()) == 1) {
            e(c0172a);
            reportClient.buildMethodCheck(businessType, "smallAppSuccess").report();
            return 0;
        }
        if (c0172a.mU() && !com.kwad.sdk.core.response.a.a.ax(cb)) {
            e(c0172a);
            i(c0172a);
            return 0;
        }
        if (!com.kwad.sdk.core.response.a.a.ax(cb)) {
            if (c0172a.getAdTemplate().isWebViewDownload) {
                return h(c0172a);
            }
            boolean f2 = com.kwad.sdk.utils.d.f(c0172a.getContext(), com.kwad.sdk.core.response.a.a.cu(cb), com.kwad.sdk.core.response.a.a.aq(cb));
            e(c0172a);
            if (f2) {
                com.kwad.sdk.core.report.a.l(c0172a.getAdTemplate(), 0);
                return 0;
            }
            a(c0172a.getContext(), new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(c0172a.getAdTemplate())).L(c0172a.getAdTemplate()).oc());
            return 0;
        }
        if (com.kwad.sdk.core.response.a.a.ax(cb)) {
            if (c0172a.mZ() == 2 || c0172a.mZ() == 1) {
                c0172a.ar(false);
                e(c0172a);
            } else {
                e(c0172a);
                if (!c(c0172a)) {
                    c0172a.ar(true);
                }
            }
            return h(c0172a);
        }
        return 0;
    }

    private static int a(C0172a c0172a, int i2) {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = c0172a.getAdTemplate();
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck((adTemplate == null || (sceneImpl = adTemplate.mAdScene) == null) ? null : KSLoggerReporter.bv(sceneImpl.getAdStyle()), "dplinkStart").report();
        boolean z = true;
        int b2 = d.b(c0172a, 1);
        String a2 = d.a(c0172a, adTemplate);
        if (!TextUtils.isEmpty(a2) && !a2.contains(" ")) {
            z = false;
        }
        if (z) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_convert").aF(adTemplate).J("dpLinkError", a2).report();
        }
        return b2;
    }

    private static void a(Context context, AdWebViewActivityProxy.a aVar) {
        AdWebViewActivityProxy.launch(context, aVar);
    }

    public static void a(k.b bVar) {
        if (IH == null) {
            IH = new CopyOnWriteArrayList();
        }
        IH.add(new WeakReference<>(bVar));
    }

    public static void b(k.b bVar) {
        if (IH == null) {
            return;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= IH.size()) {
                i2 = -1;
                break;
            }
            WeakReference<k.b> weakReference = IH.get(i2);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 != -1) {
            IH.remove(i2);
        }
    }

    private static boolean b(C0172a c0172a) {
        return com.kwad.sdk.core.response.a.a.ax(com.kwad.sdk.core.response.a.d.cb(c0172a.getAdTemplate())) ? !c0172a.mX() && c.s(c0172a) == 3 : d(c0172a) == 1;
    }

    private static boolean c(C0172a c0172a) {
        AdTemplate adTemplate = c0172a.getAdTemplate();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (!c0172a.mU() || !com.kwad.sdk.core.response.a.a.b(cb, com.kwad.sdk.core.config.d.un()) || TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.aK(cb)) || AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity || c0172a.hb().nh()) {
            return false;
        }
        d(c0172a.getContext(), adTemplate);
        return true;
    }

    private static int d(C0172a c0172a) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(c0172a.getAdTemplate());
        if (cb.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int db = c0172a.db();
        return db != 2 ? db != 3 ? cb.unDownloadConf.unDownloadRegionConf.actionBarType : cb.unDownloadConf.unDownloadRegionConf.materialJumpType : cb.unDownloadConf.unDownloadRegionConf.describeBarType;
    }

    private static void d(Context context, AdTemplate adTemplate) {
        AdWebViewVideoActivityProxy.launch(context, adTemplate);
        SceneImpl sceneImpl = adTemplate.mAdScene;
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(sceneImpl != null ? KSLoggerReporter.bv(sceneImpl.getAdStyle()) : null, "toVideoH5Web").report();
    }

    private static void e(C0172a c0172a) {
        g(c0172a);
        f(c0172a);
        if (c0172a.mN() != null) {
            c0172a.mN().onAdClicked();
        }
    }

    private static void f(C0172a c0172a) {
        if (c0172a.mS()) {
            com.kwad.sdk.core.report.a.a(c0172a.adTemplate, c0172a.IR, c0172a.ho());
        }
    }

    private static void g(C0172a c0172a) {
        k.b bVar;
        List<WeakReference<k.b>> list = IH;
        if (list == null || list.isEmpty() || c0172a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : IH) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.z(com.kwad.sdk.core.response.a.d.cl(c0172a.adTemplate));
            }
        }
    }

    private static int h(C0172a c0172a) {
        c hb = c0172a.hb();
        if (hb == null) {
            hb = new c(c0172a.adTemplate);
            c0172a.b(hb);
        }
        int m = hb.m(c0172a);
        AdTemplate adTemplate = c0172a.getAdTemplate();
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(adTemplate.getBusinessType(), "toDownload").report();
        String ce = com.kwad.sdk.core.response.a.d.ce(c0172a.getAdTemplate());
        boolean isEmpty = TextUtils.isEmpty(ce);
        if (!isEmpty) {
            isEmpty = ce.contains(" ");
        }
        if (!isEmpty) {
            isEmpty = ce.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
        }
        if (isEmpty) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_convert").aF(adTemplate).J("downloadUrlError", ce).report();
        }
        return m;
    }

    private static void i(C0172a c0172a) {
        AdTemplate adTemplate = c0172a.getAdTemplate();
        Context context = c0172a.getContext();
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (com.kwad.sdk.utils.d.f(context, com.kwad.sdk.core.response.a.a.cu(cb), com.kwad.sdk.core.response.a.a.aq(cb))) {
            com.kwad.sdk.core.report.a.l(adTemplate, 0);
        } else if (!com.kwad.sdk.core.response.a.a.b(cb, com.kwad.sdk.core.config.d.un()) || adTemplate.mAdWebVideoPageShowing) {
            a(context, new AdWebViewActivityProxy.a.C0182a().av(com.kwad.sdk.core.response.a.b.bg(c0172a.getAdTemplate())).L(c0172a.getAdTemplate()).oc());
        } else {
            d(context, adTemplate);
        }
    }
}
