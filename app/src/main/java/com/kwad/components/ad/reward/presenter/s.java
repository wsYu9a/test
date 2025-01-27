package com.kwad.components.ad.reward.presenter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.m.b;
import com.kwad.components.ad.reward.presenter.RewardPreEndCardPresenter;
import com.kwad.components.core.i.a;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class s extends b implements com.kwad.components.ad.reward.e.g, a.InterfaceC0432a, x.b {
    private List<com.kwad.components.core.i.c> bJ;

    @Nullable
    private com.kwad.components.ad.reward.d ql;
    private ImageView tF;
    private View uG;
    private KsLogoView uH;
    private DetailVideoView uI;
    private int uJ;
    private View uK;
    private FrameLayout uL;
    private Animator uM;
    private Animator uN;
    private Animator uO;
    private AdTemplate uP;
    private boolean uX;

    @RewardPreEndCardPresenter.PreEndPageStatus
    private int uF = 1;
    private long uQ = 500;
    private long uR = 50;
    private float uS = 1.2254902f;
    private float uT = 0.80472106f;
    private float uU = 0.0f;
    private boolean uV = false;
    private long showTime = -1;
    private long uW = -1;

    /* renamed from: ia */
    private com.kwad.components.core.video.l f11860ia = new com.kwad.components.core.video.l() { // from class: com.kwad.components.ad.reward.presenter.s.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            s.this.g(j11);
        }
    };

    /* renamed from: ee */
    private com.kwad.sdk.core.webview.d.a.a f11859ee = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.s.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar == null || com.kwad.sdk.core.response.b.e.c(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                s.this.rO.f11688qe.cg();
                return;
            }
            com.kwad.components.core.i.c a10 = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.i.c>) s.this.bJ, aVar.creativeId);
            if (a10 != null) {
                s.this.rO.a(a10);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.s$1 */
    public class AnonymousClass1 extends com.kwad.components.core.video.l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            s.this.g(j11);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$2 */
    public class AnonymousClass2 implements b.InterfaceC0390b {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.ad.m.b.InterfaceC0390b
        public final void ie() {
            com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
            s.this.rO.qN = true;
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$3 */
    public class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ ViewGroup.LayoutParams uZ;

        public AnonymousClass3(ViewGroup.LayoutParams layoutParams) {
            layoutParams = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
            s.this.uG.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$4 */
    public class AnonymousClass4 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: va */
        final /* synthetic */ ViewGroup.LayoutParams f11861va;

        public AnonymousClass4(ViewGroup.LayoutParams layoutParams) {
            layoutParams2 = layoutParams;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = layoutParams2;
            if (layoutParams != null) {
                layoutParams.height = intValue;
                s.this.tF.setLayoutParams(layoutParams2);
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.s$5 */
    public class AnonymousClass5 implements com.kwad.sdk.core.webview.d.a.a {
        public AnonymousClass5() {
        }

        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (aVar == null || com.kwad.sdk.core.response.b.e.c(s.this.mAdTemplate, aVar.creativeId, aVar.adStyle)) {
                s.this.rO.f11688qe.cg();
                return;
            }
            com.kwad.components.core.i.c a10 = com.kwad.components.ad.reward.g.a((List<com.kwad.components.core.i.c>) s.this.bJ, aVar.creativeId);
            if (a10 != null) {
                s.this.rO.a(a10);
            }
        }
    }

    private boolean J(boolean z10) {
        int b10 = b(ic());
        O(b10);
        com.kwad.components.ad.reward.d dVar = this.ql;
        boolean aQ = dVar != null ? dVar.aQ() : false;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "webLoadSuccess: " + aQ);
        if (!aQ) {
            return false;
        }
        int a10 = a(ic());
        float f10 = -b10;
        this.uU = f10;
        Animator a11 = a(true, f10, a10, true, z10);
        this.uM = a11;
        a11.start();
        Animator ib2 = ib();
        this.uO = ib2;
        ib2.start();
        this.uF = 2;
        return true;
    }

    private void K(boolean z10) {
        Animator a10 = a(false, (ic() - id()) + this.uU, a(id()), false, z10);
        this.uN = a10;
        a10.start();
        com.kwad.sdk.core.local.a.Fk();
        com.kwad.sdk.core.local.a.cc(this.uP);
        this.uF = 3;
        com.kwad.components.ad.reward.d dVar = this.ql;
        if (dVar != null) {
            dVar.fF();
        }
    }

    private void O(int i10) {
        ViewGroup.LayoutParams layoutParams = this.uG.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.height = i10;
            layoutParams2.bottomMargin = -i10;
        } else {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, i10);
            layoutParams3.height = i10;
            layoutParams3.bottomMargin = -i10;
            this.uG.setLayoutParams(layoutParams3);
        }
    }

    private void f(List<AdTemplate> list) {
        com.kwad.components.ad.reward.d dVar = new com.kwad.components.ad.reward.d(list, this.rO.mReportExtData, this);
        this.ql = dVar;
        this.rO.ql = dVar;
        dVar.setShowLandingPage(com.kwad.sdk.core.response.b.b.cB(this.mAdTemplate));
        this.ql.a(this.f11859ee);
        com.kwad.components.ad.reward.d dVar2 = this.ql;
        FrameLayout frameLayout = this.uL;
        com.kwad.components.ad.reward.g gVar = this.rO;
        dVar2.a(frameLayout, gVar.mRootContainer, this.mAdTemplate, gVar.mApkDownloadHelper, gVar.mScreenOrientation);
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "startPreloadWebView");
        this.ql.a(new b.InterfaceC0390b() { // from class: com.kwad.components.ad.reward.presenter.s.2
            public AnonymousClass2() {
            }

            @Override // com.kwad.components.ad.m.b.InterfaceC0390b
            public final void ie() {
                com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onPreloadSuccess");
                s.this.rO.qN = true;
            }
        });
    }

    public void g(long j10) {
        AdTemplate adTemplate = this.uP;
        if (adTemplate == null || this.uX) {
            return;
        }
        if (this.showTime <= 0) {
            this.showTime = com.kwad.sdk.core.response.b.b.cy(adTemplate);
            this.uW = com.kwad.sdk.core.response.b.b.cx(this.uP) + this.showTime;
        }
        long j11 = this.showTime;
        if (j11 > 0 && !this.uV && j10 > j11) {
            this.uX = !J(true);
            com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "showError: " + this.uX);
            if (this.uX) {
                return;
            } else {
                this.uV = true;
            }
        }
        boolean z10 = this.uF == 3;
        long j12 = this.uW;
        if (j12 <= 0 || z10 || j10 <= j12) {
            return;
        }
        K(true);
    }

    private Animator ib() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.uK, "alpha", 255.0f, 0.0f);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.25f, 0.1f, 0.25f, 1.0f));
        ofFloat.setDuration(200L);
        return ofFloat;
    }

    private float ic() {
        return com.kwad.sdk.c.a.a.f(getActivity()) / this.uS;
    }

    private float id() {
        return com.kwad.sdk.c.a.a.f(getActivity()) / this.uT;
    }

    @Override // com.kwad.components.core.webview.jshandler.x.b
    public final void R(AdTemplate adTemplate) {
        com.kwad.components.core.i.c cVar = new com.kwad.components.core.i.c(adTemplate, com.kwad.components.core.i.e.AGGREGATION);
        com.kwad.components.ad.reward.g gVar = this.rO;
        if (gVar != null) {
            gVar.b(cVar);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.f11689qf.a(this.f11860ia);
        this.rO.b((com.kwad.components.ad.reward.e.g) this);
        this.rO.a(this);
        this.uJ = com.kwad.sdk.c.a.a.H(this.uI);
        com.kwad.sdk.c.a.a.n(this.uI, 49);
        this.uH.aK(this.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void ch() {
        int i10;
        if (this.uP == null || (i10 = this.uF) == 3) {
            return;
        }
        if (i10 == 1) {
            J(false);
            K(false);
        } else if (i10 == 2) {
            K(true);
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "onInnerAdLoad: " + list);
        if (list == null || list.size() == 0) {
            return;
        }
        this.uP = list.get(0).getAdTemplate();
        this.bJ = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mAdTemplate);
        arrayList.addAll(com.kwad.components.core.i.c.m(list));
        f(arrayList);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.uG = findViewById(R.id.ksad_middle_end_card);
        this.uI = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.uH = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.tF = (ImageView) findViewById(R.id.ksad_blur_video_cover);
        this.uK = findViewById(R.id.ksad_play_web_card_webView);
        this.uL = (FrameLayout) findViewById(R.id.ksad_middle_end_card_webview_container);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void onError(int i10, String str) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onError : msg " + str);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void onRequestResult(int i10) {
        com.kwad.sdk.core.d.c.w("RewardPreEndCardPresenter", "onRequestResult : adNumber " + i10);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.g gVar = this.rO;
        gVar.qN = false;
        gVar.f11689qf.b(this.f11860ia);
        this.rO.c(this);
        this.rO.b((a.InterfaceC0432a) this);
        com.kwad.components.ad.reward.d dVar = this.ql;
        if (dVar != null) {
            dVar.mM();
        }
        Animator animator = this.uO;
        if (animator != null) {
            animator.cancel();
        }
        DetailVideoView detailVideoView = this.uI;
        if (detailVideoView != null) {
            com.kwad.sdk.c.a.a.n(detailVideoView, this.uJ);
        }
        Animator animator2 = this.uM;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.uO = null;
        this.uM = null;
    }

    private int b(float f10) {
        return (int) (f10 + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_height) + getContext().getResources().getDimensionPixelSize(R.dimen.ksad_reward_middle_end_card_logo_view_margin_bottom));
    }

    private Animator a(boolean z10, float f10, int i10, boolean z11, boolean z12) {
        ValueAnimator ofFloat;
        com.kwad.sdk.core.d.c.d("RewardPreEndCardPresenter", "getUpAnimator: translationY0: " + f10 + ", videoTargetHeight: " + i10);
        if (z10) {
            ofFloat = ObjectAnimator.ofFloat(this.uG, "translationY", f10);
        } else {
            int height = this.uG.getHeight();
            ViewGroup.LayoutParams layoutParams = this.uG.getLayoutParams();
            ofFloat = ValueAnimator.ofFloat(height, Math.abs(f10));
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.3
                final /* synthetic */ ViewGroup.LayoutParams uZ;

                public AnonymousClass3(ViewGroup.LayoutParams layoutParams2) {
                    layoutParams = layoutParams2;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    layoutParams.height = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    s.this.uG.setLayoutParams(layoutParams);
                }
            });
        }
        ObjectAnimator ofFloat2 = z11 ? ObjectAnimator.ofFloat(this.uH, "alpha", 0.0f, 255.0f) : null;
        ValueAnimator a10 = this.uI.a(this.mAdTemplate, i10, new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.s.4

            /* renamed from: va */
            final /* synthetic */ ViewGroup.LayoutParams f11861va;

            public AnonymousClass4(ViewGroup.LayoutParams layoutParams2) {
                layoutParams2 = layoutParams2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams2 = layoutParams2;
                if (layoutParams2 != null) {
                    layoutParams2.height = intValue;
                    s.this.tF.setLayoutParams(layoutParams2);
                }
            }
        });
        long j10 = z12 ? this.uQ : this.uR;
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(create);
        if (ofFloat2 != null) {
            if (z12) {
                animatorSet.playTogether(ofFloat, ofFloat2, a10);
            } else {
                animatorSet.playTogether(ofFloat, ofFloat2);
            }
        } else if (z12) {
            animatorSet.playTogether(ofFloat, a10);
        } else {
            animatorSet.playTogether(ofFloat);
        }
        return animatorSet;
    }

    private int a(float f10) {
        return (int) (com.kwad.sdk.c.a.a.g(getActivity()) - f10);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
