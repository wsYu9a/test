package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.k;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e {
    private static long rW;

    /* renamed from: com.kwad.components.ad.reward.presenter.e$1 */
    static class AnonymousClass1 extends k.b {
        final /* synthetic */ com.kwad.components.ad.reward.j os;

        AnonymousClass1(com.kwad.components.ad.reward.j jVar) {
            jVar = jVar;
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void J(boolean z) {
            super.J(z);
            if (com.kwad.components.ad.reward.kwai.b.l(AdInfo.this)) {
                jVar.hq();
            } else if (com.kwad.sdk.core.response.a.a.bF(AdInfo.this)) {
                jVar.release();
                jVar.hq();
            } else {
                e.r(jVar);
                com.kwad.components.ad.reward.m.m(jVar);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.e$2 */
    static class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.s(com.kwad.components.ad.reward.j.this);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.e$3 */
    static class AnonymousClass3 extends k.b {
        final /* synthetic */ AdTemplate eI;

        AnonymousClass3(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void J(boolean z) {
            com.kwad.components.ad.reward.j.this.H(false);
            if (!z) {
                com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META);
            }
            e.w(com.kwad.components.ad.reward.j.this);
            com.kwad.components.ad.reward.j.this.hq();
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void fZ() {
            com.kwad.components.ad.reward.j.this.H(true);
            com.kwad.sdk.core.report.a.b(adTemplate, 149, com.kwad.components.ad.reward.j.this.mReportExtData);
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void gh() {
            com.kwad.components.ad.reward.j.this.H(false);
            com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.e$4 */
    static class AnonymousClass4 extends k.b {
        final /* synthetic */ AdTemplate eI;
        final /* synthetic */ k.c pS;
        final /* synthetic */ JSONObject rY;
        final /* synthetic */ k.b rZ;

        AnonymousClass4(k.c cVar, AdTemplate adTemplate, JSONObject jSONObject, k.b bVar) {
            a2 = cVar;
            adTemplate = adTemplate;
            jSONObject = jSONObject;
            bVar = bVar;
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void J(boolean z) {
            com.kwad.components.ad.reward.j.this.H(false);
            if (!z) {
                com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META);
            }
            k.b bVar = bVar;
            if (bVar != null) {
                bVar.J(z);
            }
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void fZ() {
            com.kwad.components.ad.reward.j.this.oN.pause();
            com.kwad.components.ad.reward.j.this.H(true);
            if (a2.getStyle() == 0) {
                com.kwad.sdk.core.report.a.j(adTemplate, jSONObject);
            } else {
                com.kwad.sdk.core.report.a.b(adTemplate, 149, jSONObject);
            }
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
        public final void g(int i2, int i3) {
            super.g(i2, i3);
            com.kwad.components.ad.reward.j jVar = com.kwad.components.ad.reward.j.this;
            jVar.a(1, jVar.mContext, i2, i3);
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
        public final void gf() {
            super.gf();
            com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
            com.kwad.components.ad.reward.j jVar = com.kwad.components.ad.reward.j.this;
            jVar.a(1, jVar.mContext, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 1);
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void gg() {
            super.gg();
            com.kwad.components.ad.reward.j.this.H(false);
        }

        @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
        public final void gh() {
            com.kwad.components.ad.reward.j.this.H(false);
            com.kwad.components.ad.reward.j.this.oN.resume();
            if (a2.getStyle() == 1 || a2.getStyle() == 2 || a2.getStyle() == 5 || a2.getStyle() == 8) {
                com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
            } else {
                com.kwad.sdk.core.report.a.k(adTemplate, jSONObject);
            }
        }
    }

    public interface a {
        void gt();
    }

    private static boolean W(String str) {
        if (!com.kwad.components.ad.reward.kwai.b.gI()) {
            com.kwad.sdk.core.d.b.e(str, "isEnable false");
            return true;
        }
        int gH = com.kwad.components.ad.reward.kwai.b.gH();
        com.kwad.sdk.core.d.b.d(str, "JumpDirectMaxCount " + gH);
        return gH <= 0 || com.kwad.components.ad.reward.e.a.cO() >= gH;
    }

    private static void a(com.kwad.components.ad.reward.j jVar, @NonNull k.b bVar) {
        String str;
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        JSONObject jSONObject = jVar.mReportExtData;
        long U = com.kwad.sdk.core.response.a.a.U(cb);
        if (U <= 0 || com.kwad.sdk.core.response.a.a.F(cb) <= U) {
            str = "观看完整视频即可获取奖励";
        } else {
            str = "观看视频" + U + "s即可获取奖励";
        }
        k.c a2 = com.kwad.components.ad.reward.k.a(jVar, str);
        com.kwad.components.ad.reward.j.a(jVar, a2, new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.4
            final /* synthetic */ AdTemplate eI;
            final /* synthetic */ k.c pS;
            final /* synthetic */ JSONObject rY;
            final /* synthetic */ k.b rZ;

            AnonymousClass4(k.c a22, AdTemplate adTemplate2, JSONObject jSONObject2, k.b bVar2) {
                a2 = a22;
                adTemplate = adTemplate2;
                jSONObject = jSONObject2;
                bVar = bVar2;
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void J(boolean z) {
                com.kwad.components.ad.reward.j.this.H(false);
                if (!z) {
                    com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META);
                }
                k.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.J(z);
                }
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void fZ() {
                com.kwad.components.ad.reward.j.this.oN.pause();
                com.kwad.components.ad.reward.j.this.H(true);
                if (a2.getStyle() == 0) {
                    com.kwad.sdk.core.report.a.j(adTemplate, jSONObject);
                } else {
                    com.kwad.sdk.core.report.a.b(adTemplate, 149, jSONObject);
                }
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
            public final void g(int i2, int i3) {
                super.g(i2, i3);
                com.kwad.components.ad.reward.j jVar2 = com.kwad.components.ad.reward.j.this;
                jVar2.a(1, jVar2.mContext, i2, i3);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.ad.reward.k.a
            public final void gf() {
                super.gf();
                com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
                com.kwad.components.ad.reward.j jVar2 = com.kwad.components.ad.reward.j.this;
                jVar2.a(1, jVar2.mContext, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_TINKER_ID_NOT_EQUAL, 1);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gg() {
                super.gg();
                com.kwad.components.ad.reward.j.this.H(false);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gh() {
                com.kwad.components.ad.reward.j.this.H(false);
                com.kwad.components.ad.reward.j.this.oN.resume();
                if (a2.getStyle() == 1 || a2.getStyle() == 2 || a2.getStyle() == 5 || a2.getStyle() == 8) {
                    com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
                } else {
                    com.kwad.sdk.core.report.a.k(adTemplate, jSONObject);
                }
            }
        });
    }

    public static void a(com.kwad.components.ad.reward.j jVar, a aVar) {
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (jVar.pf) {
            int fJ = jVar.fJ();
            if (!o(adTemplate) && !p(adTemplate)) {
                if (com.kwad.sdk.core.response.a.b.bF(jVar.mAdTemplate) && jVar.mAdTemplate.mPlayAgain != null && !jVar.fT() && !jVar.fU() && !jVar.fM() && jVar.fX() && fJ == 2) {
                    if (aVar != null) {
                        aVar.gt();
                        return;
                    }
                    return;
                }
                long X = com.kwad.sdk.core.response.a.a.X(cb);
                if (!jVar.pC && jVar.pB < X) {
                    r4 = false;
                }
                if (r4) {
                    x(jVar);
                }
                w(jVar);
                jVar.hq();
                return;
            }
            q(jVar);
            if ((jVar.fX() || !w(jVar.mAdTemplate) || jVar.pk) ? false : true) {
                v(jVar);
                return;
            }
        }
        w(jVar);
        jVar.hq();
    }

    public static void a(com.kwad.components.ad.reward.j jVar, boolean z) {
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (!jVar.pf) {
            jVar.mAdOpenInteractionListener.onSkippedVideo();
            if (com.kwad.sdk.core.response.a.a.bE(cb)) {
                jVar.release();
                jVar.hq();
                return;
            } else {
                if (jVar.ph) {
                    r(jVar);
                    return;
                }
                com.kwad.sdk.core.report.a.i(adTemplate, jVar.mReportExtData);
                jVar.oN.release();
                jVar.fH();
                u(jVar);
                return;
            }
        }
        q(jVar);
        boolean z2 = !jVar.fX() && w(jVar.mAdTemplate);
        if (o(adTemplate) || p(adTemplate) || jVar.pB < com.kwad.sdk.core.response.a.a.X(cb)) {
            if (z2) {
                a(jVar, new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.1
                    final /* synthetic */ com.kwad.components.ad.reward.j os;

                    AnonymousClass1(com.kwad.components.ad.reward.j jVar2) {
                        jVar = jVar2;
                    }

                    @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
                    public final void J(boolean z3) {
                        super.J(z3);
                        if (com.kwad.components.ad.reward.kwai.b.l(AdInfo.this)) {
                            jVar.hq();
                        } else if (com.kwad.sdk.core.response.a.a.bF(AdInfo.this)) {
                            jVar.release();
                            jVar.hq();
                        } else {
                            e.r(jVar);
                            com.kwad.components.ad.reward.m.m(jVar);
                        }
                    }
                });
                return;
            } else if (com.kwad.sdk.core.response.a.a.bF(cb)) {
                jVar2.release();
                jVar2.hq();
                return;
            } else {
                r(jVar2);
                com.kwad.components.ad.reward.m.m(jVar2);
                return;
            }
        }
        if (jVar2.pv) {
            jVar2.hq();
            return;
        }
        if (!jVar2.pC && jVar2.pB < com.kwad.sdk.core.response.a.a.X(cb)) {
            if (z) {
                jVar2.hq();
                return;
            }
            return;
        }
        if (jVar2.pC) {
            jVar2.N(2);
        } else {
            jVar2.N(1);
        }
        x(jVar2);
        if (com.kwad.sdk.core.response.a.a.bF(cb)) {
            jVar2.release();
            jVar2.hq();
        } else {
            r(jVar2);
            com.kwad.components.ad.reward.m.m(jVar2);
        }
    }

    private static boolean a(String str, AdTemplate adTemplate, AdInfo adInfo) {
        String str2;
        if (com.kwad.sdk.core.response.a.a.bv(adInfo)) {
            str2 = "is playable return";
        } else if (!com.kwad.sdk.core.response.a.a.ax(adInfo)) {
            str2 = "is not Download type";
        } else if (adTemplate.mPlayAgain != null) {
            str2 = "is playAgain return";
        } else if (com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(adInfo))) {
            str2 = "isRewardLaunchAppTask";
        } else {
            if (!com.kwad.components.ad.reward.j.h(adInfo)) {
                return false;
            }
            str2 = "is Aggregation return";
        }
        com.kwad.sdk.core.d.b.i(str, str2);
        return true;
    }

    private static boolean o(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.g(adTemplate, com.kwad.components.ad.reward.kwai.b.l(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
    }

    private static boolean p(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.d.p(adTemplate);
    }

    private static void q(com.kwad.components.ad.reward.j jVar) {
        long j2 = jVar.pA;
        int i2 = j2 != 0 ? (int) (j2 / 1000) : 0;
        long j3 = jVar.pB;
        int i3 = j3 != 0 ? (int) (j3 / 1000) : 0;
        y.b bVar = new y.b();
        bVar.aki = 69;
        bVar.aky = i2;
        bVar.akz = i3;
        com.kwad.sdk.core.report.a.b(jVar.mAdTemplate, 141, bVar, jVar.mReportExtData);
    }

    public static void r(com.kwad.components.ad.reward.j jVar) {
        long j2 = jVar.pB;
        int i2 = j2 != 0 ? (int) (j2 / 1000) : 0;
        jVar.pk = true;
        AdTemplate adTemplate = jVar.mAdTemplate;
        com.kwad.sdk.core.report.a.d(adTemplate, com.kwad.sdk.core.response.a.a.V(com.kwad.sdk.core.response.a.d.cb(adTemplate)), i2);
        if (h.y(jVar)) {
            bi.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.e.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    e.s(com.kwad.components.ad.reward.j.this);
                }
            }, 200L);
        } else {
            s(jVar);
        }
    }

    public static void s(com.kwad.components.ad.reward.j jVar) {
        jVar.oN.skipToEnd();
    }

    public static void t(com.kwad.components.ad.reward.j jVar) {
        w(jVar);
        jVar.hq();
    }

    public static void u(com.kwad.components.ad.reward.j jVar) {
        com.kwad.sdk.core.d.b.d("openAppMarket", "tryOpenAppMarket");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - rW < 300) {
            com.kwad.sdk.core.d.b.d("openAppMarket", "连续点击");
            return;
        }
        rW = elapsedRealtime;
        if (W("openAppMarket")) {
            return;
        }
        AdTemplate adTemplate = jVar.mAdTemplate;
        Context context = jVar.mContext;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (a("openAppMarket", adTemplate, cb)) {
            return;
        }
        String cu = com.kwad.sdk.core.response.a.a.cu(cb);
        com.kwad.sdk.core.d.b.i("openAppMarket", "tryOpenMiAppStore url：" + cu);
        com.kwad.sdk.core.report.i bs = new com.kwad.sdk.core.report.i().bj(TinkerReport.KEY_APPLIED_DEX_EXTRACT).bs(8);
        if (com.kwad.sdk.utils.d.a(context, cu, adTemplate)) {
            com.kwad.sdk.core.report.a.a(adTemplate, bs, (JSONObject) null);
            com.kwad.sdk.core.report.a.c(adTemplate, 1, 8);
            com.kwad.components.ad.reward.e.a.J(context);
        } else {
            if (!com.kwad.sdk.utils.d.f(context, cu, com.kwad.sdk.core.response.a.a.aq(cb))) {
                com.kwad.sdk.core.d.b.i("openAppMarket", "tryOpenMiAppStore failed");
                return;
            }
            com.kwad.sdk.core.report.a.a(adTemplate, bs, (JSONObject) null);
            com.kwad.sdk.core.report.a.c(adTemplate, 0, 8);
            com.kwad.components.ad.reward.e.a.J(context);
        }
    }

    private static void v(com.kwad.components.ad.reward.j jVar) {
        com.kwad.components.ad.reward.j.a(jVar, com.kwad.components.ad.reward.k.a(jVar, (String) null), new k.b() { // from class: com.kwad.components.ad.reward.presenter.e.3
            final /* synthetic */ AdTemplate eI;

            AnonymousClass3(AdTemplate adTemplate) {
                adTemplate = adTemplate;
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void J(boolean z) {
                com.kwad.components.ad.reward.j.this.H(false);
                if (!z) {
                    com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_DEX_META);
                }
                e.w(com.kwad.components.ad.reward.j.this);
                com.kwad.components.ad.reward.j.this.hq();
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void fZ() {
                com.kwad.components.ad.reward.j.this.H(true);
                com.kwad.sdk.core.report.a.b(adTemplate, 149, com.kwad.components.ad.reward.j.this.mReportExtData);
            }

            @Override // com.kwad.components.ad.reward.k.b, com.kwad.components.core.webview.a.d.c
            public final void gh() {
                com.kwad.components.ad.reward.j.this.H(false);
                com.kwad.sdk.core.report.a.q(adTemplate, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_SIGNATURE);
            }
        });
    }

    public static void w(com.kwad.components.ad.reward.j jVar) {
        jVar.mAdOpenInteractionListener.h(false);
    }

    private static boolean w(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.a.a.ab(com.kwad.sdk.core.response.a.d.cb(adTemplate));
    }

    private static void x(com.kwad.components.ad.reward.j jVar) {
        jVar.mAdOpenInteractionListener.onRewardVerify();
    }
}
