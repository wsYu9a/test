package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f {
    private static long tJ;

    /* renamed from: com.kwad.components.ad.reward.presenter.f$1 */
    public class AnonymousClass1 implements com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a> {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(com.kwad.components.ad.reward.k.a aVar) {
            aVar.jg();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f$2 */
    public class AnonymousClass2 extends h.b {
        final /* synthetic */ com.kwad.components.ad.reward.g pP;

        public AnonymousClass2(com.kwad.components.ad.reward.g gVar) {
            gVar = gVar;
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void G(boolean z10) {
            super.G(z10);
            if (com.kwad.components.ad.reward.a.b.k(AdInfo.this)) {
                gVar.hK();
            } else if (com.kwad.sdk.core.response.b.a.bV(AdInfo.this)) {
                f.p(gVar);
            } else {
                f.r(gVar);
                com.kwad.components.ad.reward.l.j(gVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f$3 */
    public class AnonymousClass3 extends bd {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.components.ad.reward.g.this.gi();
            com.kwad.components.ad.reward.g gVar = com.kwad.components.ad.reward.g.this;
            gVar.f11688qe.onVideoSkipToEnd(gVar.qT);
            com.kwad.components.ad.reward.g.this.release();
            com.kwad.components.ad.reward.g.this.hK();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.s(com.kwad.components.ad.reward.g.this);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f$5 */
    public class AnonymousClass5 implements com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a> {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: c */
        public void accept(com.kwad.components.ad.reward.k.a aVar) {
            aVar.jg();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f$6 */
    public class AnonymousClass6 extends h.b {
        final /* synthetic */ AdTemplate cP;

        public AnonymousClass6(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void G(boolean z10) {
            com.kwad.components.ad.reward.g.this.E(false);
            if (!z10) {
                com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
            }
            f.x(com.kwad.components.ad.reward.g.this);
            com.kwad.components.ad.reward.g.this.hK();
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gl() {
            com.kwad.components.ad.reward.g.this.E(true);
            com.kwad.sdk.core.adlog.c.b(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, com.kwad.components.ad.reward.g.this.mReportExtData);
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gu() {
            com.kwad.components.ad.reward.g.this.E(false);
            com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.f$7 */
    public class AnonymousClass7 extends h.b {
        final /* synthetic */ AdTemplate cP;
        final /* synthetic */ h.c rl;
        final /* synthetic */ JSONObject tL;
        final /* synthetic */ h.b tM;

        public AnonymousClass7(h.c cVar, AdTemplate adTemplate, JSONObject jSONObject, h.b bVar) {
            a10 = cVar;
            adTemplate = adTemplate;
            jSONObject = jSONObject;
            bVar = bVar;
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void G(boolean z10) {
            com.kwad.components.ad.reward.g.this.E(false);
            if (!z10) {
                com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
            }
            h.b bVar = bVar;
            if (bVar != null) {
                bVar.G(z10);
            }
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
        public final void g(int i10, int i11) {
            super.g(i10, i11);
            com.kwad.components.ad.reward.g gVar = com.kwad.components.ad.reward.g.this;
            gVar.a(1, gVar.mContext, i10, i11);
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gl() {
            com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.f11689qf;
            if (eVar != null) {
                eVar.pause();
            }
            com.kwad.components.ad.reward.g.this.E(true);
            if (a10.getStyle() == 0) {
                com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
            } else {
                com.kwad.sdk.core.adlog.c.b(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, jSONObject);
            }
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
        public final void gs() {
            super.gs();
            com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
            com.kwad.components.ad.reward.g gVar = com.kwad.components.ad.reward.g.this;
            gVar.a(1, gVar.mContext, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 1);
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gt() {
            super.gt();
            com.kwad.components.ad.reward.g.this.E(false);
        }

        @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
        public final void gu() {
            com.kwad.components.ad.reward.g.this.E(false);
            com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.f11689qf;
            if (eVar != null) {
                eVar.resume();
            }
            if (a10.getStyle() == 1 || a10.getStyle() == 2 || a10.getStyle() == 5 || a10.getStyle() == 8) {
                com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
            } else {
                com.kwad.sdk.core.adlog.c.k(adTemplate, jSONObject);
            }
        }
    }

    private static boolean I(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
    }

    private static boolean J(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.J(adTemplate);
    }

    private static boolean Q(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.a.ak(com.kwad.sdk.core.response.b.e.eb(adTemplate));
    }

    public static void a(com.kwad.components.ad.reward.g gVar, boolean z10) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (!gVar.qu) {
            o(gVar);
            return;
        }
        q(gVar);
        boolean z11 = !gVar.gh() && Q(gVar.mAdTemplate);
        if (I(adTemplate) || J(adTemplate) || gVar.qT < com.kwad.sdk.core.response.b.a.ag(eb2)) {
            if (z11) {
                a(gVar, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.2
                    final /* synthetic */ com.kwad.components.ad.reward.g pP;

                    public AnonymousClass2(com.kwad.components.ad.reward.g gVar2) {
                        gVar = gVar2;
                    }

                    @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
                    public final void G(boolean z102) {
                        super.G(z102);
                        if (com.kwad.components.ad.reward.a.b.k(AdInfo.this)) {
                            gVar.hK();
                        } else if (com.kwad.sdk.core.response.b.a.bV(AdInfo.this)) {
                            f.p(gVar);
                        } else {
                            f.r(gVar);
                            com.kwad.components.ad.reward.l.j(gVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.b.a.bV(eb2)) {
                p(gVar2);
                return;
            } else {
                r(gVar2);
                com.kwad.components.ad.reward.l.j(gVar2);
                return;
            }
        }
        if (gVar2.qN) {
            gVar2.hK();
            return;
        }
        if (!gVar2.qU && gVar2.qT < com.kwad.sdk.core.response.b.a.ag(eb2)) {
            if (z10) {
                gVar2.hK();
                return;
            }
            return;
        }
        if (gVar2.qU) {
            gVar2.M(2);
        } else {
            gVar2.M(1);
        }
        y(gVar2);
        if (com.kwad.sdk.core.response.b.a.bV(eb2)) {
            p(gVar2);
        } else {
            r(gVar2);
            com.kwad.components.ad.reward.l.j(gVar2);
        }
    }

    private static void o(com.kwad.components.ad.reward.g gVar) {
        if (com.kwad.sdk.core.response.b.a.bU(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate))) {
            p(gVar);
            return;
        }
        if (gVar.qw) {
            r(gVar);
            return;
        }
        gVar.qz = true;
        com.kwad.components.ad.reward.g.a(gVar.qn, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jg();
            }
        });
        gVar.f11688qe.onVideoSkipToEnd(0L);
        com.kwad.sdk.core.adlog.c.i(gVar.mAdTemplate, gVar.mReportExtData);
        com.kwad.components.ad.reward.m.e eVar = gVar.f11689qf;
        if (eVar != null) {
            eVar.release();
        }
        gVar.fV();
        u(gVar);
    }

    public static void p(com.kwad.components.ad.reward.g gVar) {
        bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.presenter.f.3
            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.ad.reward.g.this.gi();
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.f11688qe.onVideoSkipToEnd(gVar2.qT);
                com.kwad.components.ad.reward.g.this.release();
                com.kwad.components.ad.reward.g.this.hK();
            }
        });
    }

    private static void q(com.kwad.components.ad.reward.g gVar) {
        long j10 = gVar.qS;
        int i10 = j10 != 0 ? (int) (j10 / 1000) : 0;
        long j11 = gVar.qT;
        com.kwad.sdk.core.adlog.c.e(gVar.mAdTemplate, gVar.mReportExtData, new com.kwad.sdk.core.adlog.c.b().cN(69).cQ(i10).cR(j11 != 0 ? (int) (j11 / 1000) : 0));
    }

    public static void r(com.kwad.components.ad.reward.g gVar) {
        gVar.qz = true;
        gVar.gi();
        if (i.z(gVar)) {
            bt.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.f.4
                public AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    f.s(com.kwad.components.ad.reward.g.this);
                }
            }, 200L);
        } else {
            s(gVar);
        }
    }

    public static void s(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar.qn, new com.kwad.sdk.f.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.5
            public AnonymousClass5() {
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: c */
            public void accept(com.kwad.components.ad.reward.k.a aVar) {
                aVar.jg();
            }
        });
        com.kwad.components.ad.reward.m.e eVar = gVar.f11689qf;
        if (eVar != null) {
            eVar.skipToEnd();
        }
    }

    public static void t(com.kwad.components.ad.reward.g gVar) {
        x(gVar);
        gVar.hK();
    }

    public static void u(com.kwad.components.ad.reward.g gVar) {
        com.kwad.sdk.core.d.c.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - tJ < 300) {
            com.kwad.sdk.core.d.c.d("openAppMarket", "连续点击");
            return;
        }
        tJ = elapsedRealtime;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (a(eb2, "openAppMarket")) {
            return;
        }
        Context context = gVar.mContext;
        if (a("openAppMarket", adTemplate, eb2)) {
            return;
        }
        com.kwad.sdk.core.adlog.c.b cX = new com.kwad.sdk.core.adlog.c.b().cL(TinkerReport.KEY_APPLIED_DEX_EXTRACT).cX(8);
        boolean z10 = com.kwad.sdk.core.download.a.b.E(context, com.kwad.sdk.core.response.b.a.cU(eb2)) == 1;
        com.kwad.sdk.core.d.c.i("openAppMarket", "handleDeepLink dpSuccess: " + z10);
        if (z10) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cX, (JSONObject) null);
            com.kwad.components.ad.reward.h.a.I(context);
            return;
        }
        String cX2 = com.kwad.sdk.core.response.b.a.cX(eb2);
        com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore url：" + cX2);
        if (com.kwad.sdk.utils.e.a(context, cX2, adTemplate)) {
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cX, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.e(adTemplate, 1, 8);
            com.kwad.components.ad.reward.h.a.I(context);
        } else {
            if (!com.kwad.sdk.utils.e.i(context, adTemplate)) {
                com.kwad.sdk.core.d.c.i("openAppMarket", "tryOpenMiAppStore failed");
                return;
            }
            com.kwad.components.ad.reward.j.b.a(adTemplate, "native_id", "autoLaunchMarket", cX, (JSONObject) null);
            com.kwad.sdk.core.adlog.c.e(adTemplate, 0, 8);
            com.kwad.components.ad.reward.h.a.I(context);
        }
    }

    public static void v(com.kwad.components.ad.reward.g gVar) {
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (!gVar.qu) {
            x(gVar);
            gVar.hK();
            return;
        }
        if (!I(adTemplate) && !J(adTemplate)) {
            long ag2 = com.kwad.sdk.core.response.b.a.ag(eb2);
            if (gVar.qU || gVar.qT >= ag2) {
                y(gVar);
            }
            x(gVar);
            gVar.hK();
            return;
        }
        q(gVar);
        if (!gVar.gh() && Q(gVar.mAdTemplate) && !gVar.qz) {
            w(gVar);
        } else {
            x(gVar);
            gVar.hK();
        }
    }

    private static void w(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.ad.reward.g.a(gVar, com.kwad.components.ad.reward.h.a(gVar, (String) null), new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.6
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass6(AdTemplate adTemplate) {
                adTemplate = adTemplate;
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void G(boolean z10) {
                com.kwad.components.ad.reward.g.this.E(false);
                if (!z10) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
                }
                f.x(com.kwad.components.ad.reward.g.this);
                com.kwad.components.ad.reward.g.this.hK();
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void gl() {
                com.kwad.components.ad.reward.g.this.E(true);
                com.kwad.sdk.core.adlog.c.b(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, com.kwad.components.ad.reward.g.this.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void gu() {
                com.kwad.components.ad.reward.g.this.E(false);
                com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
            }
        });
    }

    public static void x(com.kwad.components.ad.reward.g gVar) {
        gVar.f11688qe.i(false);
    }

    private static void y(com.kwad.components.ad.reward.g gVar) {
        gVar.f11688qe.onRewardVerify();
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.b.a.bJ(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is playable return");
            return true;
        }
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo)) {
            com.kwad.sdk.core.d.c.i(str, "is not Download type");
            return true;
        }
        if (com.kwad.sdk.core.response.b.e.k(adTemplate, com.kwad.components.ad.reward.a.b.k(adInfo))) {
            com.kwad.sdk.core.d.c.i(str, "isRewardLaunchAppTask");
            return true;
        }
        if (!com.kwad.components.ad.reward.g.g(adInfo)) {
            return false;
        }
        com.kwad.sdk.core.d.c.i(str, "is Aggregation return");
        return true;
    }

    private static boolean a(AdInfo adInfo, String str) {
        if (!com.kwad.components.ad.reward.a.b.gW()) {
            com.kwad.sdk.core.d.c.e(str, "isEnable false");
            return true;
        }
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.cX(adInfo))) {
            return true;
        }
        int gV = com.kwad.components.ad.reward.a.b.gV();
        com.kwad.sdk.core.d.c.d(str, "JumpDirectMaxCount " + gV);
        return gV <= 0 || com.kwad.components.ad.reward.h.a.di() >= gV;
    }

    private static void a(com.kwad.components.ad.reward.g gVar, @NonNull h.b bVar) {
        String str;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        JSONObject jSONObject = gVar.mReportExtData;
        long ad2 = com.kwad.sdk.core.response.b.a.ad(eb2);
        if (ad2 > 0 && com.kwad.sdk.core.response.b.a.L(eb2) > ad2) {
            str = "观看视频" + ad2 + "s即可获取奖励";
        } else {
            str = "观看完整视频即可获取奖励";
        }
        h.c a10 = com.kwad.components.ad.reward.h.a(gVar, str);
        com.kwad.components.ad.reward.g.a(gVar, a10, new h.b() { // from class: com.kwad.components.ad.reward.presenter.f.7
            final /* synthetic */ AdTemplate cP;
            final /* synthetic */ h.c rl;
            final /* synthetic */ JSONObject tL;
            final /* synthetic */ h.b tM;

            public AnonymousClass7(h.c a102, AdTemplate adTemplate2, JSONObject jSONObject2, h.b bVar2) {
                a10 = a102;
                adTemplate = adTemplate2;
                jSONObject = jSONObject2;
                bVar = bVar2;
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void G(boolean z10) {
                com.kwad.components.ad.reward.g.this.E(false);
                if (!z10) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 151);
                }
                h.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.G(z10);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void g(int i10, int i11) {
                super.g(i10, i11);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, i10, i11);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void gl() {
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.f11689qf;
                if (eVar != null) {
                    eVar.pause();
                }
                com.kwad.components.ad.reward.g.this.E(true);
                if (a10.getStyle() == 0) {
                    com.kwad.sdk.core.adlog.c.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.adlog.c.b(adTemplate, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_CODE, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.ad.reward.h.a
            public final void gs() {
                super.gs();
                com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
                com.kwad.components.ad.reward.g gVar2 = com.kwad.components.ad.reward.g.this;
                gVar2.a(1, gVar2.mContext, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 1);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void gt() {
                super.gt();
                com.kwad.components.ad.reward.g.this.E(false);
            }

            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.e.c
            public final void gu() {
                com.kwad.components.ad.reward.g.this.E(false);
                com.kwad.components.ad.reward.m.e eVar = com.kwad.components.ad.reward.g.this.f11689qf;
                if (eVar != null) {
                    eVar.resume();
                }
                if (a10.getStyle() == 1 || a10.getStyle() == 2 || a10.getStyle() == 5 || a10.getStyle() == 8) {
                    com.kwad.sdk.core.adlog.c.p(adTemplate, 150);
                } else {
                    com.kwad.sdk.core.adlog.c.k(adTemplate, jSONObject);
                }
            }
        });
    }
}
