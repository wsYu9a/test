package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.k.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.r.m;
import com.kwad.components.core.webview.a.j;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.a {

    @Nullable
    private ValueAnimator da;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.d.b.c mApkDownloadHelper;
    private RewardActionBarControl oQ;
    private KsLogoView sh;
    private ActionBarAppLandscape tP;
    private ActionBarAppPortrait tQ;
    private ActionBarH5 tR;
    private boolean tT;

    @Nullable
    private ViewGroup tU;

    @Nullable
    private ViewGroup tV;

    @Nullable
    private ViewGroup tW;
    private r tX;
    private boolean tY;
    private boolean tS = false;
    private final AdLivePlayStateListener mAdLivePlayStateListener = new AdLivePlayStateListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.tY = true;
            if (!com.kwad.sdk.core.response.a.a.cq(b.this.mAdInfo) || b.this.tW == null) {
                return;
            }
            b.this.tW.setVisibility(8);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            b.this.tY = false;
            if (!com.kwad.sdk.core.response.a.a.cq(b.this.mAdInfo) || b.this.tW == null) {
                return;
            }
            b.this.tW.setVisibility(0);
        }
    };
    private com.kwad.components.core.webview.a.d.e gG = new com.kwad.components.core.webview.a.d.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-bottom-card-v2", b.this.qt.mAdTemplate).equals(str)) {
                b.this.cc();
            }
        }
    };
    private RewardActionBarControl.b tZ = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        AnonymousClass5() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z, a aVar) {
            b.this.tT = true;
            b.this.a(z, aVar);
        }
    };
    private com.kwad.components.ad.reward.d.f ua = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
        AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            b.this.tT = false;
            b.this.Q(false);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$1 */
    final class AnonymousClass1 extends AdLivePlayStateListenerAdapter {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.tY = true;
            if (!com.kwad.sdk.core.response.a.a.cq(b.this.mAdInfo) || b.this.tW == null) {
                return;
            }
            b.this.tW.setVisibility(8);
        }

        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListenerAdapter, com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
        public final void onLivePlayStart() {
            super.onLivePlayStart();
            b.this.tY = false;
            if (!com.kwad.sdk.core.response.a.a.cq(b.this.mAdInfo) || b.this.tW == null) {
                return;
            }
            b.this.tW.setVisibility(0);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$10 */
    final class AnonymousClass10 implements ActionBarH5.a {
        AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
        public final void R(boolean z) {
            b.this.L(z);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$11 */
    final class AnonymousClass11 extends AnimatorListenerAdapter {
        final /* synthetic */ View fe;

        AnonymousClass11(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(0);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$2 */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ View fe;

        AnonymousClass2(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(0);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$3 */
    final class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ View fe;

        AnonymousClass3(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$4 */
    final class AnonymousClass4 extends com.kwad.components.core.webview.a.d.e {
        AnonymousClass4() {
        }

        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (j.b("ksad-video-bottom-card-v2", b.this.qt.mAdTemplate).equals(str)) {
                b.this.cc();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$5 */
    final class AnonymousClass5 implements RewardActionBarControl.b {
        AnonymousClass5() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z, a aVar) {
            b.this.tT = true;
            b.this.a(z, aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$6 */
    final class AnonymousClass6 extends com.kwad.components.ad.reward.d.a {
        AnonymousClass6() {
        }

        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            b.this.tT = false;
            b.this.Q(false);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$7 */
    final class AnonymousClass7 implements r.a {
        AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.k.r.a
        public final void hV() {
        }

        @Override // com.kwad.components.ad.reward.k.r.a
        public final void hW() {
            com.kwad.components.ad.reward.b.ff().c(PlayableSource.ACTIONBAR_CLICK, new com.kwad.components.ad.reward.f.a(b.this.getContext()));
            com.kwad.sdk.core.report.a.q(b.this.qt.mAdTemplate, 67);
        }

        @Override // com.kwad.components.ad.reward.k.r.a
        public final void hX() {
            b.this.qt.a(1, b.this.getContext(), 1, 1);
        }

        @Override // com.kwad.components.ad.reward.k.r.a
        public final void hY() {
            b.this.qt.a(1, b.this.getContext(), 1, 2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$8 */
    final class AnonymousClass8 implements ActionBarAppLandscape.a {
        AnonymousClass8() {
        }

        @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
        public final void R(boolean z) {
            b.this.L(z);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$9 */
    final class AnonymousClass9 implements ActionBarAppPortrait.a {
        AnonymousClass9() {
        }

        @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
        public final void R(boolean z) {
            b.this.L(z);
        }
    }

    public void Q(boolean z) {
        View view;
        if (this.tS) {
            this.tS = false;
            this.sh.setVisibility(8);
            ViewGroup viewGroup = this.tU;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.tW;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (com.kwad.sdk.core.response.a.a.ax(this.mAdInfo)) {
                if (this.qt.mScreenOrientation == 1) {
                    if (z) {
                        hT();
                        return;
                    } else {
                        hU();
                        return;
                    }
                }
                if (!z) {
                    ActionBarAppPortrait actionBarAppPortrait = this.tQ;
                    if (actionBarAppPortrait != null) {
                        actionBarAppPortrait.setVisibility(8);
                        return;
                    }
                    return;
                }
                view = this.tQ;
                if (view == null) {
                    return;
                }
            } else {
                if (!z) {
                    this.tR.setVisibility(8);
                    return;
                }
                view = this.tR;
            }
            g(view, com.kwad.sdk.c.kwai.a.a(getContext(), 90.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r5, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a r6) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.a(boolean, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a):void");
    }

    private void aO() {
        ValueAnimator valueAnimator = this.da;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.da.cancel();
        }
    }

    private void b(boolean z, a aVar) {
        hR();
        this.tP.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            AnonymousClass8() {
            }

            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void R(boolean z2) {
                b.this.L(z2);
            }
        });
        if (z) {
            f(this.tP, com.kwad.sdk.c.kwai.a.a(getContext(), 90.0f));
        } else {
            this.tP.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.tP, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z, a aVar) {
        hS();
        this.tQ.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            AnonymousClass9() {
            }

            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void R(boolean z2) {
                b.this.L(z2);
            }
        });
        if (z) {
            f(this.tQ, com.kwad.sdk.c.kwai.a.a(getContext(), 90.0f));
        } else {
            this.tQ.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.tQ, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    public void cc() {
        AdTemplate adTemplate = this.qt.mAdTemplate;
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.mAdInfo = cb;
        if (com.kwad.sdk.core.response.a.a.ck(cb)) {
            this.tU = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.sh.S(this.mAdTemplate);
        com.kwad.components.ad.reward.j jVar = this.qt;
        this.mApkDownloadHelper = jVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = jVar.oQ;
        this.oQ = rewardActionBarControl;
        rewardActionBarControl.a(this.tZ);
        this.qt.b(this.ua);
    }

    private void d(boolean z, a aVar) {
        this.tR.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            AnonymousClass10() {
            }

            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void R(boolean z2) {
                b.this.L(z2);
            }
        });
        if (z) {
            f(this.tR, com.kwad.sdk.c.kwai.a.a(getContext(), 90.0f));
        } else {
            this.tR.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.tR, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void e(View view, int i2) {
        aO();
        view.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator c2 = m.c(view, i2, 0);
        this.da = c2;
        c2.setInterpolator(create);
        this.da.setDuration(500L);
        this.da.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            final /* synthetic */ View fe;

            AnonymousClass11(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.da.start();
    }

    @Deprecated
    private void f(View view, int i2) {
        aO();
        view.setVisibility(0);
        ValueAnimator b2 = m.b(view, 0, i2);
        this.da = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.da.setDuration(500L);
        this.da.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            final /* synthetic */ View fe;

            AnonymousClass2(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.da.start();
    }

    private void g(View view, int i2) {
        aO();
        view.setVisibility(0);
        ValueAnimator b2 = m.b(view, i2, 0);
        this.da = b2;
        b2.setInterpolator(new DecelerateInterpolator(2.0f));
        this.da.setDuration(300L);
        this.da.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            final /* synthetic */ View fe;

            AnonymousClass3(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.da.start();
    }

    private void hR() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        this.tP = (ActionBarAppLandscape) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_video_play_bar_app_landscape));
    }

    private void hS() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        this.tQ = (ActionBarAppPortrait) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_video_play_bar_app_portrait));
    }

    private void hT() {
        hS();
        f(this.tQ, com.kwad.sdk.c.kwai.a.a(getContext(), 90.0f));
    }

    private void hU() {
        ActionBarAppPortrait actionBarAppPortrait = this.tQ;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (com.kwad.components.ad.reward.j.d(this.qt)) {
            com.kwad.components.core.webview.a.c.a.rn().a(this.gG);
        } else {
            this.qt.oN.a(null, this.mAdLivePlayStateListener);
            cc();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sh = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.tR = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.oQ;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.qt.oN.b(null, this.mAdLivePlayStateListener);
        com.kwad.components.core.webview.a.c.a.rn().b(this.gG);
        this.qt.c(this.ua);
        aO();
    }
}
