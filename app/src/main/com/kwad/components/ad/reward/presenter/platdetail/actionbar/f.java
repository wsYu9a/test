package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.s.n;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ad;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ah;
import com.kwad.components.core.webview.jshandler.aj;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b {

    @Nullable
    private KsAdWebView dY;
    private ak.a dZ;

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11842ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11843eb;

    /* renamed from: ed */
    private ay f11845ed;

    /* renamed from: ei */
    private ValueAnimator f11850ei;

    /* renamed from: ej */
    private ValueAnimator f11851ej;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private String mUrl;

    /* renamed from: qi */
    private RewardActionBarControl f11852qi;
    private KsLogoView tU;
    private boolean wC;
    private long wD;

    /* renamed from: ec */
    private int f11844ec = -1;

    /* renamed from: wk */
    private RewardActionBarControl.d f11853wk = new RewardActionBarControl.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public final boolean f(a aVar) {
            f fVar = f.this;
            fVar.wC = fVar.f(aVar);
            return f.this.wC;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            f.this.release();
        }
    };

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11846ee = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            f.this.rO.f11688qe.cg();
        }
    };

    /* renamed from: ef */
    private ak.b f11847ef = new ak.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            f.this.dZ = aVar;
            f.this.dY.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };

    /* renamed from: eg */
    private aj.b f11848eg = new aj.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            f.this.wC = false;
            f.this.bd();
        }
    };

    /* renamed from: eh */
    private ar.b f11849eh = new ar.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            f.this.f11844ec = aVar.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - f.this.wD;
            com.kwad.sdk.core.d.c.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + f.this.f11844ec);
            if (f.this.f11844ec == 1) {
                com.kwad.components.core.o.a.ri().h(f.this.rO.mAdTemplate, elapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.c.a(f.this.rO.mAdTemplate, f.this.rO.qu, "play_card", com.kwad.sdk.core.response.b.b.cs(f.this.rO.mAdTemplate), System.currentTimeMillis() - f.this.dY.getLoadTime(), 3);
            }
            if (f.this.rO.fX()) {
                return;
            }
            f.this.f11852qi.iA();
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$1 */
    public class AnonymousClass1 implements RewardActionBarControl.d {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public final boolean f(a aVar) {
            f fVar = f.this;
            fVar.wC = fVar.f(aVar);
            return f.this.wC;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$2 */
    public class AnonymousClass2 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            f.this.release();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$3 */
    public class AnonymousClass3 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            f.this.rO.f11688qe.cg();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$4 */
    public class AnonymousClass4 implements KsAdWebView.e {
        public AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageFinished() {
            com.kwad.components.ad.reward.monitor.c.a(f.this.rO.qu, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.dY.getLoadTime());
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onPageStart() {
        }

        @Override // com.kwad.sdk.core.webview.KsAdWebView.e
        public final void onReceivedHttpError(int i10, String str, String str2) {
            com.kwad.components.ad.reward.monitor.c.a(f.this.rO.mAdTemplate, f.this.rO.qu, "play_card", com.kwad.sdk.core.response.b.b.cs(f.this.rO.mAdTemplate), System.currentTimeMillis() - f.this.dY.getLoadTime(), 2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$5 */
    public class AnonymousClass5 implements ak.b {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            f.this.dZ = aVar;
            f.this.dY.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$6 */
    public class AnonymousClass6 implements aj.b {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            f.this.wC = false;
            f.this.bd();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$7 */
    public class AnonymousClass7 implements ar.b {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            f.this.f11844ec = aVar.status;
            long elapsedRealtime = SystemClock.elapsedRealtime() - f.this.wD;
            com.kwad.sdk.core.d.c.i("RewardActionBarWeb", "load time:" + elapsedRealtime + ", pageStatus: " + f.this.f11844ec);
            if (f.this.f11844ec == 1) {
                com.kwad.components.core.o.a.ri().h(f.this.rO.mAdTemplate, elapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.c.a(f.this.rO.mAdTemplate, f.this.rO.qu, "play_card", com.kwad.sdk.core.response.b.b.cs(f.this.rO.mAdTemplate), System.currentTimeMillis() - f.this.dY.getLoadTime(), 3);
            }
            if (f.this.rO.fX()) {
                return;
            }
            f.this.f11852qi.iA();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$8 */
    public class AnonymousClass8 extends AnimatorListenerAdapter {
        final /* synthetic */ a wr;

        public AnonymousClass8(a aVar) {
            aVar = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (f.this.f11845ed != null) {
                f.this.f11845ed.tv();
            }
            a aVar = aVar;
            if (aVar != null) {
                aVar.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.dY);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (f.this.f11845ed != null) {
                f.this.f11845ed.tu();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f$9 */
    public class AnonymousClass9 extends AnimatorListenerAdapter {
        public AnonymousClass9() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            f.this.dY.setVisibility(4);
            if (f.this.f11845ed != null) {
                f.this.f11845ed.tx();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (f.this.f11845ed != null) {
                f.this.f11845ed.tw();
            }
        }
    }

    private void S(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!com.kwad.sdk.core.response.b.a.cM(com.kwad.sdk.core.response.b.e.eb(adTemplate)) || an.isOrientationPortrait() || (ksLogoView = this.tU) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11843eb = bVar;
        bVar.setAdTemplate(this.rO.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11843eb;
        com.kwad.components.ad.reward.g gVar = this.rO;
        bVar2.mScreenOrientation = gVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = gVar.mRootContainer;
        bVar2.aIc = adBaseFrameLayout;
        bVar2.QI = adBaseFrameLayout;
        bVar2.Qc = this.dY;
    }

    private void aX() {
        this.f11844ec = -1;
        aY();
        this.dY.setBackgroundColor(0);
        this.dY.getBackground().setAlpha(0);
        this.dY.setVisibility(4);
        this.dY.setClientConfig(this.dY.getClientConfig().ex(this.rO.mAdTemplate).b(iF()));
        this.wD = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.b.b.cs(this.rO.mAdTemplate);
        com.kwad.sdk.core.d.c.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.g gVar = this.rO;
        com.kwad.components.ad.reward.monitor.c.a(gVar.mAdTemplate, gVar.qu, "play_card", this.mUrl);
        this.dY.loadUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aY() {
        aZ();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.dY);
        this.f11842ea = aVar;
        a(aVar);
        this.dY.addJavascriptInterface(this.f11842ea, "KwaiAd");
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11842ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11842ea = null;
        }
    }

    private void bc() {
        S(this.rO.mAdTemplate);
        ay ayVar = this.f11845ed;
        if (ayVar != null) {
            ayVar.tu();
        }
        this.dY.setVisibility(0);
        ay ayVar2 = this.f11845ed;
        if (ayVar2 != null) {
            ayVar2.tv();
        }
    }

    public void bd() {
        if (this.dY.getVisibility() != 0) {
            return;
        }
        if (this.dZ == null) {
            be();
            return;
        }
        bf();
        KsAdWebView ksAdWebView = this.dY;
        ak.a aVar = this.dZ;
        ValueAnimator c10 = n.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.f11851ej = c10;
        c10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f11851ej.setDuration(300L);
        this.f11851ej.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            public AnonymousClass9() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.dY.setVisibility(4);
                if (f.this.f11845ed != null) {
                    f.this.f11845ed.tx();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.f11845ed != null) {
                    f.this.f11845ed.tw();
                }
            }
        });
        this.f11851ej.start();
    }

    private void be() {
        if (this.dY.getVisibility() != 0) {
            return;
        }
        ay ayVar = this.f11845ed;
        if (ayVar != null) {
            ayVar.tw();
        }
        this.dY.setVisibility(4);
        ay ayVar2 = this.f11845ed;
        if (ayVar2 != null) {
            ayVar2.tx();
        }
    }

    private void bf() {
        ValueAnimator valueAnimator = this.f11850ei;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f11850ei.cancel();
        }
        ValueAnimator valueAnimator2 = this.f11851ej;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.f11851ej.cancel();
        }
    }

    private void bg() {
        int i10 = this.f11844ec;
        com.kwad.sdk.core.d.c.w("RewardActionBarWeb", "show webCard fail, reason: " + (i10 == -1 ? "timeout" : i10 != 1 ? "h5error" : "others"));
    }

    private void cw() {
        if (this.dY == null || !com.kwad.sdk.core.response.b.b.cu(this.rO.mAdTemplate)) {
            return;
        }
        this.mApkDownloadHelper = this.rO.mApkDownloadHelper;
        aW();
        aX();
        this.rO.b(this.mPlayEndPageListener);
    }

    private KsAdWebView.e iF() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            public AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.c.a(f.this.rO.qu, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.dY.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i10, String str, String str2) {
                com.kwad.components.ad.reward.monitor.c.a(f.this.rO.mAdTemplate, f.this.rO.qu, "play_card", com.kwad.sdk.core.response.b.b.cs(f.this.rO.mAdTemplate), System.currentTimeMillis() - f.this.dY.getLoadTime(), 2);
            }
        };
    }

    public void release() {
        this.f11844ec = -1;
        KsAdWebView ksAdWebView = this.dY;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        aZ();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.reward.monitor.c.a(this.rO.qu, "play_card");
        RewardActionBarControl rewardActionBarControl = this.rO.f11692qi;
        this.f11852qi = rewardActionBarControl;
        rewardActionBarControl.a(this.f11853wk);
        cw();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dY = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
        this.tU = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.f11852qi;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.d) null);
        }
        this.rO.c(this.mPlayEndPageListener);
        bf();
        release();
    }

    public boolean f(a aVar) {
        KsAdWebView ksAdWebView = this.dY;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.f11844ec == 1) {
            g(aVar);
            return true;
        }
        bg();
        return false;
    }

    private void g(a aVar) {
        if (this.dZ == null) {
            bc();
            return;
        }
        S(this.rO.mAdTemplate);
        bf();
        this.dY.setVisibility(0);
        KsAdWebView ksAdWebView = this.dY;
        ak.a aVar2 = this.dZ;
        ValueAnimator c10 = n.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
        this.f11850ei = c10;
        c10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f11850ei.setDuration(500L);
        this.f11850ei.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            final /* synthetic */ a wr;

            public AnonymousClass8(a aVar3) {
                aVar = aVar3;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.f11845ed != null) {
                    f.this.f11845ed.tv();
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.dY);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.f11845ed != null) {
                    f.this.f11845ed.tu();
                }
            }
        });
        this.f11850ei.start();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ab(this.f11843eb, this.mApkDownloadHelper, this.f11846ee, (byte) 0));
        aVar.a(new com.kwad.components.core.webview.tachikoma.a.f());
        aVar.a(new q(this.f11843eb, this.mApkDownloadHelper, this.rO, -1L, this.f11846ee, null));
        aVar.a(new ae(this.f11843eb));
        aVar.a(new ah(this.f11843eb));
        aVar.a(new ad(this.f11843eb));
        aVar.a(new ak(this.f11843eb, this.f11847ef));
        aVar.a(new ar(this.f11849eh, com.kwad.sdk.core.response.b.b.cs(this.rO.mAdTemplate)));
        ay ayVar = new ay();
        this.f11845ed = ayVar;
        aVar.a(ayVar);
        aVar.a(new bb(this.f11843eb, this.mApkDownloadHelper));
        aVar.a(new aj(this.f11848eg));
        aVar.a(new al(this.f11843eb));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.f11843eb));
        aVar.b(new m(this.f11843eb));
        aVar.a(new com.kwad.components.ad.reward.i.b(getContext(), this.rO.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }
}
