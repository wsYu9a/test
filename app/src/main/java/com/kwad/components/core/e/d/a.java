package com.kwad.components.core.e.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.webview.tachikoma.a.k;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.n.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a {
    private static List<WeakReference<k.b>> Mr;

    /* renamed from: com.kwad.components.core.e.d.a$a */
    public static class C0427a {
        private c MA;
        private boolean MC;
        private boolean MD;
        private long ME;
        private boolean MF;
        private boolean MG;
        public String MI;
        public a.C0484a MJ;
        private JSONObject MM;
        private boolean MO;
        private int MP;
        private int MQ;
        private int MR;
        private int MS;
        private Callable<String> MT;
        private String MU;
        private boolean Ms;
        private boolean Mt;
        private boolean Mu;
        private boolean Mv;
        private boolean Mw;
        private boolean Mx;
        private boolean My;
        private b Mz;
        private AdTemplate adTemplate;
        private final Context context;
        public ag.a lB;
        private int lx;
        private int lz;

        /* renamed from: xc */
        public long f11923xc;
        public int MH = -1;
        public int MK = 0;
        public int ML = -1;
        private boolean MN = false;

        public C0427a(Context context) {
            this.context = context;
        }

        public final C0427a a(@Nullable Callable<String> callable) {
            this.MT = callable;
            return this;
        }

        public final C0427a ah(String str) {
            this.MU = str;
            return this;
        }

        public final C0427a ai(String str) {
            this.MI = str;
            return this;
        }

        public final void al(boolean z10) {
            this.MD = true;
        }

        public final C0427a am(int i10) {
            this.MS = i10;
            return this;
        }

        public final C0427a an(int i10) {
            this.lz = i10;
            return this;
        }

        public final C0427a ao(boolean z10) {
            this.Mw = true;
            return this;
        }

        public final C0427a ap(boolean z10) {
            this.MC = z10;
            return this;
        }

        public final C0427a aq(boolean z10) {
            this.MF = z10;
            return this;
        }

        public final C0427a ar(boolean z10) {
            this.MG = z10;
            return this;
        }

        public final C0427a as(boolean z10) {
            this.MN = z10;
            return this;
        }

        public final C0427a at(boolean z10) {
            this.Mt = z10;
            return this;
        }

        public final C0427a au(AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
            return this;
        }

        public final C0427a av(boolean z10) {
            this.Ms = z10;
            return this;
        }

        public final C0427a aw(boolean z10) {
            this.MO = z10;
            return this;
        }

        public final C0427a ax(boolean z10) {
            this.Mu = true;
            return this;
        }

        public final C0427a b(c cVar) {
            this.MA = cVar;
            return this;
        }

        public final C0427a c(JSONObject jSONObject) {
            this.MM = jSONObject;
            return this;
        }

        public final C0427a d(ag.a aVar) {
            this.lB = aVar;
            return this;
        }

        public final int dq() {
            return this.lx;
        }

        public final int dt() {
            return this.lz;
        }

        public final AdTemplate getAdTemplate() {
            return this.adTemplate;
        }

        public final Context getContext() {
            return this.context;
        }

        public final JSONObject hI() {
            return this.MM;
        }

        public final c hu() {
            return this.MA;
        }

        public final boolean oA() {
            return this.MN;
        }

        public final boolean oB() {
            return this.Mt;
        }

        public final boolean oC() {
            return this.Mv;
        }

        public final boolean oD() {
            return this.Ms;
        }

        public final boolean oE() {
            return this.MO;
        }

        public final int oF() {
            return this.MP;
        }

        public final int oG() {
            return this.MR;
        }

        public final boolean oH() {
            return this.Mu;
        }

        public final String om() {
            return this.MU;
        }

        public final Callable<String> on() {
            return this.MT;
        }

        public final boolean oo() {
            return this.MD;
        }

        public final int op() {
            return this.MQ;
        }

        public final b oq() {
            return this.Mz;
        }

        public final boolean or() {
            return this.Mw;
        }

        public final int os() {
            return this.MS;
        }

        public final boolean ot() {
            return this.Mx;
        }

        public final boolean ou() {
            return this.My;
        }

        public final boolean ov() {
            return this.MC;
        }

        public final long ow() {
            return this.ME;
        }

        public final boolean ox() {
            return this.MF;
        }

        public final boolean oy() {
            return this.MG;
        }

        public final com.kwad.sdk.core.adlog.c.a oz() {
            return com.kwad.sdk.core.adlog.c.a.CP().cF(this.lz).dn(this.MI).e(this.lB).cG(this.MK).cH(this.ML).ao(this.f11923xc).a(this.MJ).cI(this.MH);
        }

        public final C0427a v(long j10) {
            this.ME = j10;
            return this;
        }

        public final C0427a w(long j10) {
            this.f11923xc = j10;
            return this;
        }

        public final C0427a a(b bVar) {
            this.Mz = bVar;
            return this;
        }

        public final void al(int i10) {
            this.MQ = i10;
        }

        public final C0427a am(boolean z10) {
            this.Mx = z10;
            return this;
        }

        public final C0427a an(boolean z10) {
            this.My = true;
            return this;
        }

        public final C0427a ao(int i10) {
            this.lx = i10;
            return this;
        }

        public final C0427a ap(int i10) {
            this.MK = i10;
            return this;
        }

        public final C0427a aq(int i10) {
            this.ML = i10;
            return this;
        }

        public final C0427a ar(int i10) {
            this.MP = i10;
            return this;
        }

        public final C0427a as(int i10) {
            this.MR = i10;
            return this;
        }

        public final C0427a au(boolean z10) {
            this.Mv = true;
            return this;
        }

        public final C0427a a(String str, String str2, com.kwad.sdk.f.a<AdTrackLog> aVar) {
            if (this.MJ == null) {
                this.MJ = new a.C0484a();
            }
            this.MJ.a(this.adTemplate, null, null, null);
            return this;
        }
    }

    public interface b {
        void onAdClicked();
    }

    public static int a(@NonNull Context context, @NonNull AdTemplate adTemplate, @NonNull b bVar, @Nullable c cVar, boolean z10, boolean z11, boolean z12, boolean z13) {
        com.kwad.sdk.commercial.d.a.f(adTemplate, true);
        adTemplate.converted = true;
        d.ay(false);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        C0427a as = new C0427a(context).au(adTemplate).a(bVar).b(cVar).ap(z10).aq(z11).am(z13).as(false);
        int an = com.kwad.sdk.core.response.b.a.an(eb2);
        if (!z12 && as.oG() != 2 && as.oG() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(eb2)) && !as.oC()) {
            if (an == 1) {
                return com.kwad.sdk.core.response.b.a.bh(eb2) ? k(as) : l(as);
            }
            if (an == 2) {
                int h10 = h(as);
                if (h10 == 1) {
                    return 13;
                }
                if (h10 == 2) {
                    return 16;
                }
                return com.kwad.sdk.core.response.b.a.bh(eb2) ? k(as) : l(as);
            }
        }
        int h11 = h(as);
        if (h11 == 1) {
            return 13;
        }
        if (h11 == 2) {
            return 16;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(eb2)) {
            if (j(as)) {
                return 11;
            }
            return l(as);
        }
        int m10 = m(as);
        int i10 = eb2.status;
        if (i10 != 2 && i10 != 3) {
            e(as);
        }
        return m10;
    }

    private static int b(C0427a c0427a) {
        Context context = c0427a.getContext();
        AdTemplate adTemplate = c0427a.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        Activity dH = m.dH(context);
        if (dH == null || !com.kwad.sdk.core.response.b.a.V(eb2) || c0427a.oo() || c0427a.ot()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0438a().av(com.kwad.sdk.core.response.b.b.cJ(adTemplate)).aw(adTemplate).aE(true).qa());
            d(adTemplate, 20);
            return 20;
        }
        c0427a.al(2);
        com.kwad.components.core.e.e.e.a(dH, c0427a);
        d(adTemplate, 19);
        return 19;
    }

    private static boolean c(C0427a c0427a) {
        return com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.eb(c0427a.getAdTemplate())) ? !c0427a.oE() && c.A(c0427a) == 3 : d(c0427a) == 1;
    }

    private static int d(C0427a c0427a) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(c0427a.getAdTemplate());
        if (eb2.unDownloadConf.unDownloadRegionConf == null) {
            return 0;
        }
        int dq = c0427a.dq();
        return dq != 2 ? dq != 3 ? eb2.unDownloadConf.unDownloadRegionConf.actionBarType : eb2.unDownloadConf.unDownloadRegionConf.materialJumpType : eb2.unDownloadConf.unDownloadRegionConf.describeBarType;
    }

    private static void e(C0427a c0427a) {
        if (c0427a.oo()) {
            return;
        }
        g(c0427a);
        f(c0427a);
        if (c0427a.oq() != null) {
            try {
                c0427a.oq().onAdClicked();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
        com.kwad.sdk.commercial.d.a.bj(c0427a.getAdTemplate());
    }

    private static void f(C0427a c0427a) {
        if (c0427a.oy()) {
            com.kwad.sdk.core.adlog.c.a(c0427a.adTemplate, c0427a.oz(), c0427a.hI());
        }
    }

    private static void g(C0427a c0427a) {
        k.b bVar;
        List<WeakReference<k.b>> list = Mr;
        if (list == null || list.isEmpty() || c0427a.adTemplate == null) {
            return;
        }
        for (WeakReference<k.b> weakReference : Mr) {
            if (weakReference != null && (bVar = weakReference.get()) != null) {
                bVar.M(com.kwad.sdk.core.response.b.e.el(c0427a.adTemplate));
            }
        }
    }

    private static int h(C0427a c0427a) {
        AdTemplate adTemplate = c0427a.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        int a10 = d.a(c0427a, 1);
        if (a10 == 1) {
            d.ay(true);
            e(c0427a);
            if ((com.kwad.sdk.core.response.b.a.cR(eb2) || com.kwad.sdk.core.response.b.a.cS(eb2)) && !c0427a.oH()) {
                com.kwad.sdk.core.adlog.c.m(c0427a.getAdTemplate(), (int) Math.ceil(c0427a.ow() / 1000.0f));
            }
            d(adTemplate, 13);
        } else if (a10 == 2) {
            e(c0427a);
            d(adTemplate, 16);
        }
        return a10;
    }

    private static int i(C0427a c0427a) {
        Context context = c0427a.getContext();
        AdTemplate adTemplate = c0427a.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(c0427a.getAdTemplate());
        Activity dH = m.dH(c0427a.getContext());
        if (dH == null || !com.kwad.sdk.core.response.b.a.T(eb2) || c0427a.oo() || !e.E(eb2) || c0427a.ot()) {
            int e10 = e.e(context, adTemplate);
            if (e10 == 1) {
                e(c0427a);
                d(adTemplate, 12);
            }
            return e10;
        }
        c0427a.al(1);
        com.kwad.components.core.e.e.e.a(dH, c0427a);
        e(c0427a);
        d(adTemplate, 17);
        return 2;
    }

    private static boolean j(C0427a c0427a) {
        AdTemplate adTemplate = c0427a.getAdTemplate();
        boolean i10 = com.kwad.sdk.utils.e.i(c0427a.getContext(), adTemplate);
        if (i10) {
            e(c0427a);
            com.kwad.sdk.core.adlog.c.k(adTemplate, 0);
            d(adTemplate, 11);
        }
        return i10;
    }

    private static int k(C0427a c0427a) {
        e(c0427a);
        AdTemplate adTemplate = c0427a.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(c0427a.getAdTemplate());
        Activity dH = m.dH(c0427a.getContext());
        if (dH == null || !com.kwad.sdk.core.response.b.a.V(eb2) || c0427a.oo() || c0427a.ot()) {
            AdWebViewVideoActivityProxy.launch(c0427a.getContext(), adTemplate);
            d(adTemplate, 15);
            return 15;
        }
        c0427a.al(2);
        com.kwad.components.core.e.e.e.a(dH, c0427a);
        d(adTemplate, 19);
        return 19;
    }

    private static int l(C0427a c0427a) {
        e(c0427a);
        Context context = c0427a.getContext();
        AdTemplate adTemplate = c0427a.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        Activity dH = m.dH(context);
        if (dH == null || !com.kwad.sdk.core.response.b.a.V(eb2) || c0427a.oo() || c0427a.ot()) {
            AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0438a().av(com.kwad.sdk.core.response.b.b.cJ(adTemplate)).aw(adTemplate).aF(c0427a.or()).aA(1).qa());
            d(adTemplate, 14);
            return 14;
        }
        c0427a.al(2);
        com.kwad.components.core.e.e.e.a(dH, c0427a);
        d(adTemplate, 19);
        return 19;
    }

    private static int m(C0427a c0427a) {
        c hu = c0427a.hu();
        if (hu == null) {
            hu = new c(c0427a.adTemplate);
            c0427a.b(hu);
        }
        int r10 = hu.r(c0427a);
        d(c0427a.getAdTemplate(), r10);
        return r10;
    }

    private static int n(C0427a c0427a) {
        AdTemplate adTemplate = c0427a.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (j(c0427a)) {
            return 11;
        }
        return (!com.kwad.sdk.core.response.b.a.b(eb2, com.kwad.sdk.core.config.d.Dr()) || adTemplate.mAdWebVideoPageShowing) ? l(c0427a) : k(c0427a);
    }

    private static void d(AdTemplate adTemplate, int i10) {
        switch (i10) {
            case 0:
                com.kwad.sdk.commercial.d.a.bz(adTemplate);
                break;
            case 1:
                com.kwad.sdk.commercial.d.a.bo(adTemplate);
                break;
            case 2:
                com.kwad.sdk.commercial.d.a.by(adTemplate);
                break;
            case 3:
                com.kwad.sdk.commercial.d.a.bq(adTemplate);
                break;
            case 4:
                com.kwad.sdk.commercial.d.a.bw(adTemplate);
                break;
            case 5:
                com.kwad.sdk.commercial.d.a.bx(adTemplate);
                break;
            case 6:
                com.kwad.sdk.commercial.d.a.br(adTemplate);
                break;
            case 7:
                com.kwad.sdk.commercial.d.a.bs(adTemplate);
                break;
            case 8:
                com.kwad.sdk.commercial.d.a.bt(adTemplate);
                break;
            case 9:
                com.kwad.sdk.commercial.d.a.bv(adTemplate);
                break;
            case 10:
                com.kwad.sdk.commercial.d.a.bu(adTemplate);
                break;
            case 11:
                com.kwad.sdk.commercial.d.a.bn(adTemplate);
                break;
            case 12:
                com.kwad.sdk.commercial.d.a.bm(adTemplate);
                break;
            case 13:
                com.kwad.sdk.commercial.d.a.bl(adTemplate);
                break;
            case 14:
                com.kwad.sdk.commercial.d.a.bk(adTemplate);
                break;
            case 15:
                com.kwad.sdk.commercial.d.a.bp(adTemplate);
                break;
            case 16:
                com.kwad.sdk.commercial.d.a.bB(adTemplate);
                break;
            case 17:
                com.kwad.sdk.commercial.d.a.bE(adTemplate);
                break;
            case 18:
                com.kwad.sdk.commercial.d.a.bA(adTemplate);
                break;
            case 19:
                com.kwad.sdk.commercial.d.a.bC(adTemplate);
                break;
            case 20:
                com.kwad.sdk.commercial.d.a.bD(adTemplate);
                break;
        }
    }

    public static void b(k.b bVar) {
        if (Mr == null) {
            return;
        }
        int i10 = 0;
        while (true) {
            if (i10 >= Mr.size()) {
                i10 = -1;
                break;
            }
            WeakReference<k.b> weakReference = Mr.get(i10);
            if (weakReference != null && weakReference.get() != null && bVar == weakReference.get()) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 != -1) {
            Mr.remove(i10);
        }
    }

    public static int a(C0427a c0427a) {
        Context context = c0427a.getContext();
        AdTemplate adTemplate = c0427a.getAdTemplate();
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        d.ay(false);
        if (c0427a.ou()) {
            return b(c0427a);
        }
        if (c0427a.oD()) {
            return a(context, adTemplate, c0427a.oq(), c0427a.hu(), c0427a.MC, c0427a.ox(), false, c0427a.ot());
        }
        com.kwad.sdk.commercial.d.a.f(adTemplate, false);
        if (c(c0427a)) {
            d(adTemplate, 1);
            return 1;
        }
        adTemplate.converted = true;
        com.kwad.sdk.components.d.f(com.kwad.components.a.a.a.class);
        int an = com.kwad.sdk.core.response.b.a.an(eb2);
        if (c0427a.oG() != 2 && c0427a.oG() != 1 && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(eb2)) && !c0427a.oC()) {
            if (an == 1) {
                if (com.kwad.sdk.core.response.b.a.bh(eb2)) {
                    return k(c0427a);
                }
                return l(c0427a);
            }
            if (an == 2) {
                int h10 = h(c0427a);
                if (h10 == 1) {
                    return 13;
                }
                if (h10 == 2) {
                    return 16;
                }
                if (com.kwad.sdk.core.response.b.a.bh(eb2)) {
                    return k(c0427a);
                }
                return l(c0427a);
            }
        }
        int h11 = h(c0427a);
        if (h11 == 1) {
            return 13;
        }
        if (h11 == 2) {
            return 16;
        }
        int i10 = i(c0427a);
        if (i10 == 1) {
            return 12;
        }
        if (i10 == 2) {
            return 17;
        }
        if (c0427a.oB() && !com.kwad.sdk.core.response.b.a.aF(eb2)) {
            return n(c0427a);
        }
        if (!com.kwad.sdk.core.response.b.a.aF(eb2)) {
            if (adTemplate.isWebViewDownload) {
                return m(c0427a);
            }
            if (j(c0427a)) {
                return 11;
            }
            return l(c0427a);
        }
        if (c0427a.oG() != 2 && c0427a.oG() != 1) {
            if (c0427a.oB() && com.kwad.sdk.core.response.b.a.b(eb2, com.kwad.sdk.core.config.d.Dr()) && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aS(eb2)) && !AdWebViewVideoActivityProxy.showingAdWebViewVideoActivity) {
                int q10 = c0427a.hu().q(c0427a);
                if (q10 == 0) {
                    return k(c0427a);
                }
                e(c0427a);
                d(adTemplate, q10);
                return q10;
            }
            e(c0427a);
            c0427a.as(true);
            return m(c0427a);
        }
        c0427a.as(false);
        e(c0427a);
        return m(c0427a);
    }

    public static void a(k.b bVar) {
        if (Mr == null) {
            Mr = new CopyOnWriteArrayList();
        }
        Mr.add(new WeakReference<>(bVar));
    }
}
