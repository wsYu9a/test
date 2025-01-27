package com.kwad.components.ad.draw.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.kwad.components.ad.draw.b.b.a;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.k;
import com.kwad.components.core.video.l;
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
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.draw.a.a {
    private ViewGroup dC;
    private KsAdWebView dY;
    private ak.a dZ;

    /* renamed from: ea */
    private com.kwad.components.core.webview.a f11425ea;

    /* renamed from: eb */
    private com.kwad.sdk.core.webview.b f11426eb;

    /* renamed from: ed */
    private ay f11428ed;

    /* renamed from: ei */
    private ValueAnimator f11433ei;

    /* renamed from: ej */
    private ValueAnimator f11434ej;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: ec */
    private int f11427ec = -1;
    private k mVideoPlayStateListener = new l() { // from class: com.kwad.components.ad.draw.b.b.c.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            c.this.release();
        }
    };
    private a.b dT = new a.b() { // from class: com.kwad.components.ad.draw.b.b.c.2
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.draw.b.b.a.b
        public final boolean aQ() {
            return c.this.ba();
        }
    };

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11429ee = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.b.b.c.3
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (c.this.f11413df.f11414de != null) {
                c.this.f11413df.f11414de.onAdClicked();
            }
        }
    };

    /* renamed from: ef */
    private ak.b f11430ef = new ak.b() { // from class: com.kwad.components.ad.draw.b.b.c.4
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            c.this.dZ = aVar;
            c.this.dY.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };

    /* renamed from: eg */
    private aj.b f11431eg = new aj.b() { // from class: com.kwad.components.ad.draw.b.b.c.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            c.this.bd();
        }
    };

    /* renamed from: eh */
    private ar.b f11432eh = new ar.b() { // from class: com.kwad.components.ad.draw.b.b.c.6
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            c.this.f11427ec = aVar.status;
            com.kwad.sdk.core.d.c.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    };

    /* renamed from: com.kwad.components.ad.draw.b.b.c$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            c.this.release();
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.c$2 */
    public class AnonymousClass2 implements a.b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.draw.b.b.a.b
        public final boolean aQ() {
            return c.this.ba();
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.c$3 */
    public class AnonymousClass3 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (c.this.f11413df.f11414de != null) {
                c.this.f11413df.f11414de.onAdClicked();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.c$4 */
    public class AnonymousClass4 implements ak.b {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            c.this.dZ = aVar;
            c.this.dY.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.c$5 */
    public class AnonymousClass5 implements aj.b {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.core.webview.jshandler.aj.b
        public final void a(aj.a aVar) {
            c.this.bd();
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.c$6 */
    public class AnonymousClass6 implements ar.b {
        public AnonymousClass6() {
        }

        @Override // com.kwad.components.core.webview.jshandler.ar.b
        public final void a(ar.a aVar) {
            c.this.f11427ec = aVar.status;
            com.kwad.sdk.core.d.c.i("DrawPlayWebCard", "updatePageStatus mPageState: " + aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.c$7 */
    public class AnonymousClass7 extends AnimatorListenerAdapter {
        public AnonymousClass7() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (c.this.f11428ed != null) {
                c.this.f11428ed.tv();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (c.this.f11428ed != null) {
                c.this.f11428ed.tu();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.draw.b.b.c$8 */
    public class AnonymousClass8 extends AnimatorListenerAdapter {
        public AnonymousClass8() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.dY.setVisibility(4);
            c.this.dC.setVisibility(0);
            if (c.this.f11428ed != null) {
                c.this.f11428ed.tx();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (c.this.f11428ed != null) {
                c.this.f11428ed.tw();
            }
        }
    }

    private void aW() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.f11426eb = bVar;
        bVar.setAdTemplate(this.f11413df.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.f11426eb;
        bVar2.mScreenOrientation = 0;
        AdBaseFrameLayout adBaseFrameLayout = this.f11413df.mRootContainer;
        bVar2.aIc = adBaseFrameLayout;
        bVar2.QI = adBaseFrameLayout;
        bVar2.Qc = this.dY;
    }

    private void aX() {
        this.f11427ec = -1;
        aY();
        this.dY.setBackgroundColor(0);
        this.dY.getBackground().setAlpha(0);
        this.dY.setVisibility(4);
        this.dY.loadUrl(com.kwad.sdk.core.response.b.b.cs(this.mAdTemplate));
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void aY() {
        aZ();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.dY);
        this.f11425ea = aVar;
        a(aVar);
        this.dY.addJavascriptInterface(this.f11425ea, "KwaiAd");
    }

    private void aZ() {
        com.kwad.components.core.webview.a aVar = this.f11425ea;
        if (aVar != null) {
            aVar.destroy();
            this.f11425ea = null;
        }
    }

    public boolean ba() {
        if (this.f11427ec == 1) {
            bb();
            return true;
        }
        bg();
        return false;
    }

    private void bb() {
        if (this.dZ == null) {
            bc();
            return;
        }
        bf();
        this.dC.setVisibility(8);
        this.dY.setVisibility(0);
        KsAdWebView ksAdWebView = this.dY;
        ak.a aVar = this.dZ;
        ValueAnimator c10 = n.c(ksAdWebView, aVar.height + aVar.bottomMargin, 0);
        this.f11433ei = c10;
        c10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f11433ei.setDuration(300L);
        this.f11433ei.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.b.b.c.7
            public AnonymousClass7() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (c.this.f11428ed != null) {
                    c.this.f11428ed.tv();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.f11428ed != null) {
                    c.this.f11428ed.tu();
                }
            }
        });
        this.f11433ei.start();
    }

    private void bc() {
        ay ayVar = this.f11428ed;
        if (ayVar != null) {
            ayVar.tu();
        }
        this.dC.setVisibility(8);
        this.dY.setVisibility(0);
        ay ayVar2 = this.f11428ed;
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
        this.f11434ej = c10;
        c10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f11434ej.setDuration(300L);
        this.f11434ej.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.draw.b.b.c.8
            public AnonymousClass8() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.dY.setVisibility(4);
                c.this.dC.setVisibility(0);
                if (c.this.f11428ed != null) {
                    c.this.f11428ed.tx();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (c.this.f11428ed != null) {
                    c.this.f11428ed.tw();
                }
            }
        });
        this.f11434ej.start();
    }

    private void be() {
        if (this.dY.getVisibility() != 0) {
            return;
        }
        ay ayVar = this.f11428ed;
        if (ayVar != null) {
            ayVar.tw();
        }
        this.dY.setVisibility(4);
        this.dC.setVisibility(0);
        ay ayVar2 = this.f11428ed;
        if (ayVar2 != null) {
            ayVar2.tx();
        }
    }

    private void bf() {
        ValueAnimator valueAnimator = this.f11433ei;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f11433ei.cancel();
        }
        ValueAnimator valueAnimator2 = this.f11434ej;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.f11434ej.cancel();
        }
    }

    private void bg() {
        int i10 = this.f11427ec;
        com.kwad.sdk.core.d.c.w("DrawPlayWebCard", "show webCard fail, reason: " + (i10 == -1 ? "timeout" : i10 != 1 ? "h5error" : "others"));
    }

    public void release() {
        this.f11427ec = -1;
        this.dY.setVisibility(8);
        aZ();
    }

    @Override // com.kwad.components.ad.draw.a.a, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        com.kwad.components.ad.draw.a.b bVar = this.f11413df;
        this.mAdTemplate = bVar.mAdTemplate;
        bVar.dv.a(this.dT);
        com.kwad.components.ad.draw.a.b bVar2 = this.f11413df;
        this.mApkDownloadHelper = bVar2.mApkDownloadHelper;
        bVar2.f11415dg.b(this.mVideoPlayStateListener);
        aW();
        aX();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dC = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.dY = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f11413df.dv.a((a.b) null);
        this.f11413df.f11415dg.a(this.mVideoPlayStateListener);
        bf();
        release();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ab(this.f11426eb, this.mApkDownloadHelper, this.f11429ee, (byte) 0));
        aVar.a(new y(this.f11426eb, this.mApkDownloadHelper, this.f11429ee));
        aVar.a(new ae(this.f11426eb));
        aVar.a(new ah(this.f11426eb));
        aVar.a(new ad(this.f11426eb));
        aVar.a(new ak(this.f11426eb, this.f11430ef));
        aVar.a(new ar(this.f11432eh, com.kwad.sdk.core.response.b.b.cs(this.mAdTemplate)));
        ay ayVar = new ay();
        this.f11428ed = ayVar;
        aVar.a(ayVar);
        aVar.a(new bb(this.f11426eb, this.mApkDownloadHelper));
        aVar.a(new aj(this.f11431eg));
        aVar.a(new al(this.f11426eb));
        aVar.b(new com.kwad.components.core.webview.jshandler.n(this.f11426eb));
        aVar.b(new m(this.f11426eb));
    }
}
