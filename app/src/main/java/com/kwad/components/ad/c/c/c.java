package com.kwad.components.ad.c.c;

import android.animation.ObjectAnimator;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.c.b.a;
import com.kwad.components.ad.c.f;
import com.kwad.components.core.e.d.a;
import com.kwad.components.core.request.i;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.components.core.widget.a;
import com.kwad.sdk.R;
import com.kwad.sdk.core.adlog.a;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.j;
import com.sigmob.sdk.base.mta.PointType;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends a {
    private com.kwad.components.ad.c.b.a cB;
    private com.kwad.components.ad.c.b.a cC;
    private FrameLayout cD;
    private boolean cE;
    private boolean cF;
    private boolean cG;
    private long cH;
    private boolean cI;
    boolean cM;
    private long startTime;
    private Handler handler = new Handler();
    private boolean cJ = true;
    private bd cK = new bd() { // from class: com.kwad.components.ad.c.c.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (c.this.cJ) {
                c.this.cH = System.currentTimeMillis() - c.this.startTime;
                if (!c.this.cF || (c.this.cH >= d.Ej() && com.kwad.sdk.core.response.b.a.du(e.eb(c.this.cA.mAdTemplate)))) {
                    c.this.av();
                    c.this.cG = true;
                    c.b(c.this, true);
                    if (c.this.cH >= d.Ej()) {
                        c.this.startTime = System.currentTimeMillis();
                    }
                }
                if (com.kwad.sdk.core.response.b.a.du(e.eb(c.this.cA.mAdTemplate))) {
                    c.this.handler.postDelayed(this, 1000L);
                }
            }
        }
    };
    private int cL = 0;

    /* renamed from: com.kwad.components.ad.c.c.c$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (c.this.cJ) {
                c.this.cH = System.currentTimeMillis() - c.this.startTime;
                if (!c.this.cF || (c.this.cH >= d.Ej() && com.kwad.sdk.core.response.b.a.du(e.eb(c.this.cA.mAdTemplate)))) {
                    c.this.av();
                    c.this.cG = true;
                    c.b(c.this, true);
                    if (c.this.cH >= d.Ej()) {
                        c.this.startTime = System.currentTimeMillis();
                    }
                }
                if (com.kwad.sdk.core.response.b.a.du(e.eb(c.this.cA.mAdTemplate))) {
                    c.this.handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    /* renamed from: com.kwad.components.ad.c.c.c$2 */
    public class AnonymousClass2 implements a.InterfaceC0457a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void Z() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void aa() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void ax() {
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void c(View view) {
            c.this.at();
        }

        @Override // com.kwad.components.core.widget.a.InterfaceC0457a
        public final void onWindowFocusChanged(boolean z10) {
            if (!z10) {
                c.this.cJ = false;
                c.this.au();
            } else {
                c.this.cJ = true;
                c.this.startTime = System.currentTimeMillis() - c.this.cH;
                c.this.at();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.c.c.c$3 */
    public class AnonymousClass3 implements a.InterfaceC0362a {

        /* renamed from: com.kwad.components.ad.c.c.c$3$1 */
        public class AnonymousClass1 implements a.b {
            final /* synthetic */ int cO;
            final /* synthetic */ AdTemplate cP;

            public AnonymousClass1(int i10, AdTemplate adTemplate) {
                i10 = i10;
                adTemplate = adTemplate;
            }

            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                a.C0484a c0484a = new a.C0484a();
                aVar.MJ = c0484a;
                c0484a.templateId = PointType.ANTI_SPAM;
                aVar.lz = i10;
                com.kwad.sdk.core.adlog.c.a(adTemplate, aVar, (JSONObject) null);
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
        public final void a(int i10, int i11, AdTemplate adTemplate) {
            com.kwad.components.core.e.d.a.a(new a.C0427a(c.this.getContext()).au(adTemplate).au(true).b(new com.kwad.components.core.e.d.c(adTemplate)).ar(false).ao(i11).an(i10).a(new a.b() { // from class: com.kwad.components.ad.c.c.c.3.1
                final /* synthetic */ int cO;
                final /* synthetic */ AdTemplate cP;

                public AnonymousClass1(int i102, AdTemplate adTemplate2) {
                    i10 = i102;
                    adTemplate = adTemplate2;
                }

                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                    a.C0484a c0484a = new a.C0484a();
                    aVar.MJ = c0484a;
                    c0484a.templateId = PointType.ANTI_SPAM;
                    aVar.lz = i10;
                    com.kwad.sdk.core.adlog.c.a(adTemplate, aVar, (JSONObject) null);
                }
            }));
            c.this.cA.W();
        }

        @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
        public final void ar() {
            c.this.cA.c(0, "onMediaPlayError");
        }

        @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
        public final void c(AdTemplate adTemplate) {
            if (adTemplate.mPvReported) {
                return;
            }
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            a.C0484a c0484a = new a.C0484a();
            c0484a.templateId = PointType.ANTI_SPAM;
            c0484a.asI = com.kwad.sdk.core.response.b.a.du(e.eb(c.this.cA.mAdTemplate)) ? 1 : 2;
            bVar.b(c0484a);
            com.kwad.components.core.s.b.sc().a(adTemplate, null, bVar);
            c.this.cA.V();
        }

        @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
        public final void d(AdTemplate adTemplate) {
            com.kwad.sdk.core.adlog.c.h(adTemplate, (JSONObject) null);
            c.this.cA.X();
            c.this.cA.bG.removeAllViews();
            c.this.handler.removeCallbacksAndMessages(null);
            c.this.onDestroy();
        }
    }

    /* renamed from: com.kwad.components.ad.c.c.c$4 */
    public class AnonymousClass4 extends bd {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (c.this.cC != null) {
                c.this.cD.removeView(c.this.cC);
            }
            c.this.cG = false;
        }
    }

    /* renamed from: com.kwad.components.ad.c.c.c$5 */
    public class AnonymousClass5 extends bd {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (c.this.cB != null) {
                c.this.cD.removeView(c.this.cB);
            }
            c.this.cG = false;
        }
    }

    /* renamed from: com.kwad.components.ad.c.c.c$6 */
    public class AnonymousClass6 extends com.kwad.components.core.request.d {

        /* renamed from: com.kwad.components.ad.c.c.c$6$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (c.this.cI) {
                    c.this.cG = true;
                } else {
                    c.this.aw();
                    c.d(c.this, true);
                }
            }
        }

        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
        public final void a(@NonNull AdResultData adResultData, boolean z10) {
            c.this.cA.bJ = adResultData.getAdTemplateList();
            if (c.this.cA.bJ.isEmpty()) {
                onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                j.ao("bannerAd_", "数据为空");
            }
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            c.this.handler.postDelayed(new bd() { // from class: com.kwad.components.ad.c.c.c.6.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (c.this.cI) {
                        c.this.cG = true;
                    } else {
                        c.this.aw();
                        c.d(c.this, true);
                    }
                }
            }, d.Ej());
        }
    }

    /* renamed from: com.kwad.components.ad.c.c.c$7 */
    public class AnonymousClass7 implements i {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.core.request.i
        @WorkerThread
        public final void ag() {
        }
    }

    public void at() {
        this.handler.removeCallbacksAndMessages(this.cK);
        this.handler.post(this.cK);
    }

    public void au() {
        this.handler.removeCallbacksAndMessages(this.cK);
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.cD = (FrameLayout) findViewById(R.id.ksad_banner_base_content);
        this.startTime = System.currentTimeMillis();
        at();
        a(this.cD);
    }

    public final void av() {
        if (this.cG || this.cA.bJ.isEmpty()) {
            return;
        }
        try {
            com.kwad.components.ad.c.b.a aVar = new com.kwad.components.ad.c.b.a(getContext(), this.cA.bJ.get(this.cL), new a.InterfaceC0362a() { // from class: com.kwad.components.ad.c.c.c.3

                /* renamed from: com.kwad.components.ad.c.c.c$3$1 */
                public class AnonymousClass1 implements a.b {
                    final /* synthetic */ int cO;
                    final /* synthetic */ AdTemplate cP;

                    public AnonymousClass1(int i102, AdTemplate adTemplate2) {
                        i10 = i102;
                        adTemplate = adTemplate2;
                    }

                    @Override // com.kwad.components.core.e.d.a.b
                    public final void onAdClicked() {
                        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                        a.C0484a c0484a = new a.C0484a();
                        aVar.MJ = c0484a;
                        c0484a.templateId = PointType.ANTI_SPAM;
                        aVar.lz = i10;
                        com.kwad.sdk.core.adlog.c.a(adTemplate, aVar, (JSONObject) null);
                    }
                }

                public AnonymousClass3() {
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
                public final void a(int i102, int i11, AdTemplate adTemplate2) {
                    com.kwad.components.core.e.d.a.a(new a.C0427a(c.this.getContext()).au(adTemplate2).au(true).b(new com.kwad.components.core.e.d.c(adTemplate2)).ar(false).ao(i11).an(i102).a(new a.b() { // from class: com.kwad.components.ad.c.c.c.3.1
                        final /* synthetic */ int cO;
                        final /* synthetic */ AdTemplate cP;

                        public AnonymousClass1(int i1022, AdTemplate adTemplate22) {
                            i10 = i1022;
                            adTemplate = adTemplate22;
                        }

                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
                            a.C0484a c0484a = new a.C0484a();
                            aVar2.MJ = c0484a;
                            c0484a.templateId = PointType.ANTI_SPAM;
                            aVar2.lz = i10;
                            com.kwad.sdk.core.adlog.c.a(adTemplate, aVar2, (JSONObject) null);
                        }
                    }));
                    c.this.cA.W();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
                public final void ar() {
                    c.this.cA.c(0, "onMediaPlayError");
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
                public final void c(AdTemplate adTemplate) {
                    if (adTemplate.mPvReported) {
                        return;
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    a.C0484a c0484a = new a.C0484a();
                    c0484a.templateId = PointType.ANTI_SPAM;
                    c0484a.asI = com.kwad.sdk.core.response.b.a.du(e.eb(c.this.cA.mAdTemplate)) ? 1 : 2;
                    bVar.b(c0484a);
                    com.kwad.components.core.s.b.sc().a(adTemplate, null, bVar);
                    c.this.cA.V();
                }

                @Override // com.kwad.components.ad.c.b.a.InterfaceC0362a
                public final void d(AdTemplate adTemplate) {
                    com.kwad.sdk.core.adlog.c.h(adTemplate, (JSONObject) null);
                    c.this.cA.X();
                    c.this.cA.bG.removeAllViews();
                    c.this.handler.removeCallbacksAndMessages(null);
                    c.this.onDestroy();
                }
            });
            aVar.a(this.cA.bI);
            if (this.cE) {
                this.cC = aVar;
                this.cD.addView(aVar);
                this.cC.an();
                this.handler.postDelayed(new bd() { // from class: com.kwad.components.ad.c.c.c.5
                    public AnonymousClass5() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (c.this.cB != null) {
                            c.this.cD.removeView(c.this.cB);
                        }
                        c.this.cG = false;
                    }
                }, 500L);
                this.cE = false;
            } else {
                this.cB = aVar;
                this.cD.addView(aVar);
                this.cB.an();
                this.handler.postDelayed(new bd() { // from class: com.kwad.components.ad.c.c.c.4
                    public AnonymousClass4() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (c.this.cC != null) {
                            c.this.cD.removeView(c.this.cC);
                        }
                        c.this.cG = false;
                    }
                }, 500L);
                this.cE = true;
            }
            int i10 = this.cL + 1;
            this.cL = i10;
            if (i10 == this.cA.bJ.size()) {
                aw();
                this.cL = 0;
            }
            if (!this.cM) {
                this.cM = true;
                return;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(aVar, "translationX", this.cD.getWidth(), 0.0f);
            ofFloat.setDuration(300L);
            ofFloat.start();
        } catch (Exception e10) {
            com.kwad.components.core.d.a.reportSdkCaughtException(e10);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }

    public final void aw() {
        SceneImpl covert = SceneImpl.covert(f.bT);
        covert.setBidResponse(null);
        covert.setBidResponseV2(null);
        com.kwad.sdk.commercial.d.d.b(covert);
        boolean a10 = m.si().a(covert, "loadBannerAd");
        covert.setAdStyle(5);
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new i() { // from class: com.kwad.components.ad.c.c.c.7
            public AnonymousClass7() {
            }

            @Override // com.kwad.components.core.request.i
            @WorkerThread
            public final void ag() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.c.c.6

            /* renamed from: com.kwad.components.ad.c.c.c$6$1 */
            public class AnonymousClass1 extends bd {
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (c.this.cI) {
                        c.this.cG = true;
                    } else {
                        c.this.aw();
                        c.d(c.this, true);
                    }
                }
            }

            public AnonymousClass6() {
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z10) {
                c.this.cA.bJ = adResultData.getAdTemplateList();
                if (c.this.cA.bJ.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                    j.ao("bannerAd_", "数据为空");
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(int i10, String str) {
                c.this.handler.postDelayed(new bd() { // from class: com.kwad.components.ad.c.c.c.6.1
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (c.this.cI) {
                            c.this.cG = true;
                        } else {
                            c.this.aw();
                            c.d(c.this, true);
                        }
                    }
                }, d.Ej());
            }
        }).rA());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
    }

    public static /* synthetic */ boolean d(c cVar, boolean z10) {
        cVar.cI = true;
        return true;
    }

    public static /* synthetic */ boolean b(c cVar, boolean z10) {
        cVar.cF = true;
        return true;
    }

    private void a(ViewGroup viewGroup) {
        if (d.DN() || d.DM() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new a.InterfaceC0457a() { // from class: com.kwad.components.ad.c.c.c.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void Z() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void aa() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void ax() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void c(View view) {
                c.this.at();
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC0457a
            public final void onWindowFocusChanged(boolean z10) {
                if (!z10) {
                    c.this.cJ = false;
                    c.this.au();
                } else {
                    c.this.cJ = true;
                    c.this.startTime = System.currentTimeMillis() - c.this.cH;
                    c.this.at();
                }
            }
        });
        aVar.up();
    }
}
