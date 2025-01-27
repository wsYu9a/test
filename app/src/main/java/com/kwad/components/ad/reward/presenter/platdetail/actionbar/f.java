package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h.q;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.r.m;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.an;
import com.kwad.components.core.webview.jshandler.aq;
import com.kwad.components.core.webview.jshandler.s;
import com.kwad.components.core.webview.jshandler.u;
import com.kwad.components.core.webview.jshandler.v;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes2.dex */
public final class f extends com.kwad.components.ad.reward.presenter.a {

    @Nullable
    private KsAdWebView cS;
    private ab.a cT;
    private com.kwad.components.core.webview.a cU;
    private com.kwad.sdk.core.webview.b cV;
    private ValueAnimator da;
    private ValueAnimator db;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private an mCardLifecycleHandler;
    private String mUrl;
    private RewardActionBarControl oQ;
    private KsLogoView sh;
    private boolean uw;
    private long ux;
    private int cW = -1;
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-bottom-card-v2", f.this.qt.mAdTemplate).equals(str)) {
                f.this.cc();
            }
        }
    };
    private RewardActionBarControl.e uc = new RewardActionBarControl.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.e
        public final boolean g(a aVar) {
            f fVar = f.this;
            fVar.uw = fVar.g(aVar);
            return f.this.uw;
        }
    };
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            f.this.release();
        }
    };
    private com.kwad.sdk.core.webview.c.kwai.a mWebCardClickListener = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            f.this.qt.mAdOpenInteractionListener.bN();
        }
    };
    private ab.b cX = new ab.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
            f.this.cT = aVar;
            f.this.cS.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private aa.b cY = new aa.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            f.this.uw = false;
            f.this.aM();
        }
    };
    private ai.b cZ = new ai.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            f.this.cW = aVar.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - f.this.ux;
            com.kwad.sdk.core.d.b.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + f.this.cW);
            if (f.this.cW == 1) {
                com.kwad.components.core.m.a.pb().d(f.this.qt.mAdTemplate, elapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.a.a(f.this.qt.pf, "play_card", com.kwad.sdk.core.response.a.b.aP(f.this.qt.mAdTemplate), System.currentTimeMillis() - f.this.cS.getLoadTime(), 3);
            }
            if (f.this.qt.fK()) {
                return;
            }
            f.this.oQ.hZ();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$1 */
    final class AnonymousClass1 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-bottom-card-v2", f.this.qt.mAdTemplate).equals(str)) {
                f.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$10 */
    final class AnonymousClass10 extends AnimatorListenerAdapter {

        /* renamed from: uk */
        final /* synthetic */ a f9540uk;

        AnonymousClass10(a aVar) {
            aVar = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (f.this.mCardLifecycleHandler != null) {
                f.this.mCardLifecycleHandler.ra();
            }
            a aVar = aVar;
            if (aVar != null) {
                aVar.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.cS);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (f.this.mCardLifecycleHandler != null) {
                f.this.mCardLifecycleHandler.qZ();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$2 */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.this.cS.setVisibility(4);
            if (f.this.mCardLifecycleHandler != null) {
                f.this.mCardLifecycleHandler.rc();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (f.this.mCardLifecycleHandler != null) {
                f.this.mCardLifecycleHandler.rb();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$3 */
    final class AnonymousClass3 implements RewardActionBarControl.e {
        AnonymousClass3() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.e
        public final boolean g(a aVar) {
            f fVar = f.this;
            fVar.uw = fVar.g(aVar);
            return f.this.uw;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$4 */
    final class AnonymousClass4 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            f.this.release();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$5 */
    final class AnonymousClass5 implements com.kwad.sdk.core.webview.c.kwai.a {
        AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            f.this.qt.mAdOpenInteractionListener.bN();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$6 */
    final class AnonymousClass6 implements KsAdWebView.d {
        AnonymousClass6() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageFinished() {
            com.kwad.components.ad.reward.monitor.a.a(f.this.qt.pf, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.cS.getLoadTime());
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.d
        public final void onReceivedHttpError(int i2, String str, String str2) {
            com.kwad.components.ad.reward.monitor.a.a(f.this.qt.pf, "play_card", com.kwad.sdk.core.response.a.b.aP(f.this.qt.mAdTemplate), System.currentTimeMillis() - f.this.cS.getLoadTime(), 2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$7 */
    final class AnonymousClass7 implements ab.b {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ab.b
        public final void a(ab.a aVar) {
            f.this.cT = aVar;
            f.this.cS.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$8 */
    final class AnonymousClass8 implements aa.b {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aa.b
        public final void a(aa.a aVar) {
            f.this.uw = false;
            f.this.aM();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$9 */
    final class AnonymousClass9 implements ai.b {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ai.b
        public final void a(ai.a aVar) {
            f.this.cW = aVar.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - f.this.ux;
            com.kwad.sdk.core.d.b.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + f.this.cW);
            if (f.this.cW == 1) {
                com.kwad.components.core.m.a.pb().d(f.this.qt.mAdTemplate, elapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.a.a(f.this.qt.pf, "play_card", com.kwad.sdk.core.response.a.b.aP(f.this.qt.mAdTemplate), System.currentTimeMillis() - f.this.cS.getLoadTime(), 3);
            }
            if (f.this.qt.fK()) {
                return;
            }
            f.this.oQ.hZ();
        }
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new s(this.cV, this.mApkDownloadHelper, this.mWebCardClickListener));
        aVar.a(new com.kwad.components.core.webview.a.kwai.f());
        aVar.a(new q(this.cV, this.mApkDownloadHelper, this.qt, -1L, this.mWebCardClickListener, null));
        aVar.a(new v(this.cV));
        aVar.a(new y(this.cV));
        aVar.a(new u(this.cV));
        aVar.a(new ab(this.cV, this.cX));
        aVar.a(new ai(this.cZ, com.kwad.sdk.core.response.a.b.aP(this.qt.mAdTemplate)));
        an anVar = new an();
        this.mCardLifecycleHandler = anVar;
        aVar.a(anVar);
        aVar.a(new aq(this.cV, this.mApkDownloadHelper));
        aVar.a(new aa(this.cY));
        aVar.a(new ac(this.cV));
        aVar.a(new com.kwad.components.ad.reward.f.b(getContext(), this.qt.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }

    private void aF() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.cV = bVar;
        bVar.setAdTemplate(this.qt.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.cV;
        com.kwad.components.ad.reward.j jVar = this.qt;
        bVar2.mScreenOrientation = jVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = jVar.mRootContainer;
        bVar2.app = adBaseFrameLayout;
        bVar2.LD = adBaseFrameLayout;
        bVar2.Lc = this.cS;
    }

    private void aG() {
        this.cW = -1;
        aH();
        this.cS.setBackgroundColor(0);
        this.cS.getBackground().setAlpha(0);
        this.cS.setVisibility(4);
        this.cS.setClientConfig(this.cS.getClientConfig().ct(this.qt.mAdTemplate).b(getWebListener()));
        this.ux = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.a.b.aP(this.qt.mAdTemplate);
        com.kwad.sdk.core.d.b.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.monitor.a.a(this.qt.pf, "play_card", this.mUrl);
        this.cS.loadUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aH() {
        aI();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.cS);
        this.cU = aVar;
        a(aVar);
        this.cS.addJavascriptInterface(this.cU, "KwaiAd");
    }

    private void aI() {
        com.kwad.components.core.webview.a aVar = this.cU;
        if (aVar != null) {
            aVar.destroy();
            this.cU = null;
        }
    }

    private void aL() {
        y(this.qt.mAdTemplate);
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.qZ();
        }
        this.cS.setVisibility(0);
        an anVar2 = this.mCardLifecycleHandler;
        if (anVar2 != null) {
            anVar2.ra();
        }
    }

    public void aM() {
        if (this.cS.getVisibility() != 0) {
            return;
        }
        if (this.cT == null) {
            aN();
            return;
        }
        aO();
        KsAdWebView ksAdWebView = this.cS;
        ab.a aVar = this.cT;
        ValueAnimator c2 = m.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.db = c2;
        c2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.db.setDuration(300L);
        this.db.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
            AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.cS.setVisibility(4);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.rc();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.rb();
                }
            }
        });
        this.db.start();
    }

    private void aN() {
        if (this.cS.getVisibility() != 0) {
            return;
        }
        an anVar = this.mCardLifecycleHandler;
        if (anVar != null) {
            anVar.rb();
        }
        this.cS.setVisibility(4);
        an anVar2 = this.mCardLifecycleHandler;
        if (anVar2 != null) {
            anVar2.rc();
        }
    }

    private void aO() {
        ValueAnimator valueAnimator = this.da;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.da.cancel();
        }
        ValueAnimator valueAnimator2 = this.db;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.db.cancel();
        }
    }

    private void aP() {
        int i2 = this.cW;
        com.kwad.sdk.core.d.b.w("RewardActionBarWeb", "show webCard fail, reason: " + (i2 == -1 ? "timeout" : i2 != 1 ? "h5error" : "others"));
    }

    public void cc() {
        if (this.cS == null || !com.kwad.sdk.core.response.a.b.aR(this.qt.mAdTemplate)) {
            return;
        }
        this.mApkDownloadHelper = this.qt.mApkDownloadHelper;
        aF();
        aG();
        this.qt.b(this.mPlayEndPageListener);
    }

    public boolean g(a aVar) {
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.cW == 1) {
            h(aVar);
            return true;
        }
        aP();
        return false;
    }

    private KsAdWebView.d getWebListener() {
        return new KsAdWebView.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
            AnonymousClass6() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.a.a(f.this.qt.pf, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.cS.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.d
            public final void onReceivedHttpError(int i2, String str, String str2) {
                com.kwad.components.ad.reward.monitor.a.a(f.this.qt.pf, "play_card", com.kwad.sdk.core.response.a.b.aP(f.this.qt.mAdTemplate), System.currentTimeMillis() - f.this.cS.getLoadTime(), 2);
            }
        };
    }

    private void h(a aVar) {
        if (this.cT == null) {
            aL();
            return;
        }
        y(this.qt.mAdTemplate);
        aO();
        this.cS.setVisibility(0);
        KsAdWebView ksAdWebView = this.cS;
        ab.a aVar2 = this.cT;
        ValueAnimator c2 = m.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
        this.da = c2;
        c2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.da.setDuration(500L);
        this.da.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.10

            /* renamed from: uk */
            final /* synthetic */ a f9540uk;

            AnonymousClass10(a aVar3) {
                aVar = aVar3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.ra();
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.cS);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.mCardLifecycleHandler != null) {
                    f.this.mCardLifecycleHandler.qZ();
                }
            }
        });
        this.da.start();
    }

    public void release() {
        this.cW = -1;
        KsAdWebView ksAdWebView = this.cS;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        aI();
    }

    private void y(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!com.kwad.sdk.core.response.a.a.ck(com.kwad.sdk.core.response.a.d.cb(adTemplate)) || com.kwad.sdk.utils.ai.DM() || (ksLogoView = this.sh) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.ad.reward.monitor.a.a(this.qt.pf, "play_card");
        RewardActionBarControl rewardActionBarControl = this.qt.oQ;
        this.oQ = rewardActionBarControl;
        rewardActionBarControl.a(this.uc);
        if (com.kwad.components.ad.reward.j.d(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        } else {
            cc();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cS = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
        this.sh = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.oQ;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.e) null);
        }
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.c(this.mPlayEndPageListener);
        aO();
        release();
    }
}
