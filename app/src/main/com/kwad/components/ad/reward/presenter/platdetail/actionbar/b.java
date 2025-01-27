package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.n.h;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.s.n;
import com.kwad.components.core.video.l;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {

    /* renamed from: ei */
    @Nullable
    private ValueAnimator f11820ei;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    /* renamed from: qi */
    private RewardActionBarControl f11821qi;
    private KsLogoView tU;
    private ActionBarAppLandscape vW;
    private ActionBarAppPortrait vX;
    private ActionBarH5 vY;

    /* renamed from: wa */
    private boolean f11822wa;

    /* renamed from: wb */
    @Nullable
    private ViewGroup f11823wb;

    /* renamed from: wc */
    @Nullable
    private ViewGroup f11824wc;

    /* renamed from: wd */
    @Nullable
    private ViewGroup f11825wd;

    /* renamed from: we */
    private h f11826we;

    /* renamed from: wf */
    private boolean f11827wf;
    private boolean vZ = false;
    private final l tY = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.f11827wf = true;
            if (!com.kwad.sdk.core.response.b.a.cS(b.this.mAdInfo) || b.this.f11825wd == null) {
                return;
            }
            b.this.f11825wd.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.f11827wf = false;
            if (!com.kwad.sdk.core.response.b.a.cS(b.this.mAdInfo) || b.this.f11825wd == null) {
                return;
            }
            b.this.f11825wd.setVisibility(0);
        }
    };

    /* renamed from: wg */
    private RewardActionBarControl.b f11828wg = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z10, a aVar) {
            b.this.f11822wa = true;
            b.this.a(z10, aVar);
        }
    };

    /* renamed from: wh */
    private g f11829wh = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            b.this.f11822wa = false;
            b.this.M(false);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$1 */
    public class AnonymousClass1 extends l {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.g
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.f11827wf = true;
            if (!com.kwad.sdk.core.response.b.a.cS(b.this.mAdInfo) || b.this.f11825wd == null) {
                return;
            }
            b.this.f11825wd.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.f11827wf = false;
            if (!com.kwad.sdk.core.response.b.a.cS(b.this.mAdInfo) || b.this.f11825wd == null) {
                return;
            }
            b.this.f11825wd.setVisibility(0);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$10 */
    public class AnonymousClass10 implements ActionBarH5.a {
        public AnonymousClass10() {
        }

        @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
        public final void O(boolean z10) {
            b.this.N(z10);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$11 */
    public class AnonymousClass11 extends AnimatorListenerAdapter {
        final /* synthetic */ View gv;

        public AnonymousClass11(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(0);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ View gv;

        public AnonymousClass2(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(0);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$3 */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ View gv;

        public AnonymousClass3(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(8);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$4 */
    public class AnonymousClass4 implements RewardActionBarControl.b {
        public AnonymousClass4() {
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z10, a aVar) {
            b.this.f11822wa = true;
            b.this.a(z10, aVar);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$5 */
    public class AnonymousClass5 extends com.kwad.components.ad.reward.e.a {
        public AnonymousClass5() {
        }

        @Override // com.kwad.components.ad.reward.e.g
        public final void ch() {
            b.this.f11822wa = false;
            b.this.M(false);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$6 */
    public class AnonymousClass6 extends h {

        /* renamed from: wj */
        final /* synthetic */ boolean f11838wj;

        public AnonymousClass6(boolean z10) {
            z11 = z10;
        }

        @Override // com.kwad.components.ad.reward.n.h
        public final int it() {
            return z11 ? R.id.ksad_common_app_card_land_stub : super.it();
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$7 */
    public class AnonymousClass7 implements h.a {
        public AnonymousClass7() {
        }

        @Override // com.kwad.components.ad.reward.n.h.a
        public final void iu() {
            b.this.rO.a(1, b.this.getContext(), 29, 1);
        }

        @Override // com.kwad.components.ad.reward.n.h.a
        public final void iv() {
            b.this.rO.a(1, b.this.getContext(), 30, 2);
        }

        @Override // com.kwad.components.ad.reward.n.h.a
        public final void iw() {
            b.this.rO.a(1, b.this.getContext(), 31, 2);
        }

        @Override // com.kwad.components.ad.reward.n.h.a
        public final void ix() {
            b.this.rO.a(1, b.this.getContext(), 32, 2);
        }

        @Override // com.kwad.components.ad.reward.n.h.a
        public final void iy() {
            b.this.rO.a(1, b.this.getContext(), 84, 2);
        }

        @Override // com.kwad.components.ad.reward.n.h.a
        public final void iz() {
            b.this.rO.a(1, b.this.getContext(), 53, 2);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$8 */
    public class AnonymousClass8 implements ActionBarAppLandscape.a {
        public AnonymousClass8() {
        }

        @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
        public final void O(boolean z10) {
            b.this.N(z10);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b$9 */
    public class AnonymousClass9 implements ActionBarAppPortrait.a {
        public AnonymousClass9() {
        }

        @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
        public final void O(boolean z10) {
            b.this.N(z10);
        }
    }

    public void M(boolean z10) {
        if (this.vZ) {
            this.vZ = false;
            this.tU.setVisibility(8);
            ViewGroup viewGroup = this.f11823wb;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.f11825wd;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
                if (z10) {
                    g(this.vY, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                } else {
                    this.vY.setVisibility(8);
                    return;
                }
            }
            if (this.rO.mScreenOrientation == 1) {
                if (z10) {
                    ir();
                    return;
                } else {
                    is();
                    return;
                }
            }
            if (z10) {
                ActionBarAppPortrait actionBarAppPortrait = this.vX;
                if (actionBarAppPortrait != null) {
                    g(actionBarAppPortrait, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                }
                return;
            }
            ActionBarAppPortrait actionBarAppPortrait2 = this.vX;
            if (actionBarAppPortrait2 != null) {
                actionBarAppPortrait2.setVisibility(8);
            }
        }
    }

    private void bf() {
        ValueAnimator valueAnimator = this.f11820ei;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f11820ei.cancel();
        }
    }

    private void cw() {
        if (com.kwad.sdk.core.response.b.a.cM(this.mAdInfo)) {
            this.f11823wb = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.tU.aK(this.mAdTemplate);
        com.kwad.components.ad.reward.g gVar = this.rO;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = gVar.f11692qi;
        this.f11821qi = rewardActionBarControl;
        rewardActionBarControl.a(this.f11828wg);
        this.rO.b(this.f11829wh);
    }

    private void ip() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        if (viewStub != null) {
            this.vW = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.vW = (ActionBarAppLandscape) findViewById(R.id.ksad_video_play_bar_app_landscape);
        }
    }

    private void iq() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        if (viewStub != null) {
            this.vX = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.vX = (ActionBarAppPortrait) findViewById(R.id.ksad_video_play_bar_app_portrait);
        }
    }

    private void ir() {
        iq();
        f(this.vX, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
    }

    private void is() {
        ActionBarAppPortrait actionBarAppPortrait = this.vX;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    public final void N(boolean z10) {
        com.kwad.sdk.core.adlog.c.b cL = new com.kwad.sdk.core.adlog.c.b().f(this.rO.mRootContainer.getTouchCoords()).cL(z10 ? 1 : 153);
        com.kwad.components.ad.reward.g gVar = this.rO;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", (String) null, cL, gVar.mReportExtData);
        this.rO.f11688qe.cg();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        AdTemplate adTemplate = this.rO.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.rO.f11689qf.a(this.tY);
        cw();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tU = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.vY = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.f11821qi;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.rO.f11689qf.b(this.tY);
        this.rO.c(this.f11829wh);
        bf();
    }

    private void d(boolean z10, a aVar) {
        this.vY.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            public AnonymousClass10() {
            }

            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void O(boolean z102) {
                b.this.N(z102);
            }
        });
        if (z10) {
            f(this.vY, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.vY.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.vY, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void e(View view, int i10) {
        bf();
        view.setVisibility(0);
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator c10 = n.c(view, i10, 0);
        this.f11820ei = c10;
        c10.setInterpolator(create);
        this.f11820ei.setDuration(500L);
        this.f11820ei.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            final /* synthetic */ View gv;

            public AnonymousClass11(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.f11820ei.start();
    }

    @Deprecated
    private void f(View view, int i10) {
        bf();
        view.setVisibility(0);
        ValueAnimator b10 = n.b(view, 0, i10);
        this.f11820ei = b10;
        b10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f11820ei.setDuration(500L);
        this.f11820ei.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            final /* synthetic */ View gv;

            public AnonymousClass2(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.f11820ei.start();
    }

    private void g(View view, int i10) {
        bf();
        view.setVisibility(0);
        ValueAnimator b10 = n.b(view, i10, 0);
        this.f11820ei = b10;
        b10.setInterpolator(new DecelerateInterpolator(2.0f));
        this.f11820ei.setDuration(300L);
        this.f11820ei.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            final /* synthetic */ View gv;

            public AnonymousClass3(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.f11820ei.start();
    }

    private void b(boolean z10, a aVar) {
        ip();
        this.vW.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            public AnonymousClass8() {
            }

            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void O(boolean z102) {
                b.this.N(z102);
            }
        });
        if (z10) {
            f(this.vW, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.vW.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.vW, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z10, a aVar) {
        iq();
        this.vX.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            public AnonymousClass9() {
            }

            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void O(boolean z102) {
                b.this.N(z102);
            }
        });
        if (z10) {
            f(this.vX, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.vX.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.vX, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    public void a(boolean z10, a aVar) {
        ViewGroup viewGroup;
        if (this.vZ) {
            return;
        }
        this.vZ = true;
        this.tU.setVisibility(com.kwad.sdk.core.response.b.a.cS(this.mAdInfo) ? 8 : 0);
        getContext();
        boolean z11 = !an.NS();
        if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            if (this.f11826we == null) {
                AnonymousClass6 anonymousClass6 = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6

                    /* renamed from: wj */
                    final /* synthetic */ boolean f11838wj;

                    public AnonymousClass6(boolean z112) {
                        z11 = z112;
                    }

                    @Override // com.kwad.components.ad.reward.n.h
                    public final int it() {
                        return z11 ? R.id.ksad_common_app_card_land_stub : super.it();
                    }
                };
                this.f11826we = anonymousClass6;
                anonymousClass6.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    public AnonymousClass7() {
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void iu() {
                        b.this.rO.a(1, b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void iv() {
                        b.this.rO.a(1, b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void iw() {
                        b.this.rO.a(1, b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void ix() {
                        b.this.rO.a(1, b.this.getContext(), 32, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void iy() {
                        b.this.rO.a(1, b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void iz() {
                        b.this.rO.a(1, b.this.getContext(), 53, 2);
                    }
                });
                this.f11826we.f((ViewGroup) getRootView());
                this.f11826we.b(r.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.f11826we.show();
            RewardActionBarControl.a(aVar, this.f11826we.ha(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cg(this.mAdInfo) == 1 && (viewGroup = this.f11823wb) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.a(aVar, this.f11823wb, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
            return;
        }
        if (com.kwad.sdk.core.response.b.a.cS(this.mAdInfo)) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_origin_live_root);
            this.f11825wd = viewGroup2;
            if (viewGroup2 != null) {
                if (!this.f11827wf) {
                    viewGroup2.setVisibility(0);
                }
                RewardActionBarControl.a(aVar, this.f11825wd, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.cj(this.mAdTemplate)) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.ksad_reward_live_subscribe_root);
            this.f11824wc = viewGroup3;
            if (viewGroup3 != null) {
                Resources resources = viewGroup3.getResources();
                e(this.f11824wc, (int) (resources.getDimension(R.dimen.ksad_live_subscribe_card_full_height) + resources.getDimension(R.dimen.ksad_live_subscribe_card_margin)));
                RewardActionBarControl.a(aVar, this.f11824wc, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.b.a.aF(this.mAdInfo)) {
            if (this.rO.mScreenOrientation == 1) {
                b(z10, aVar);
                return;
            } else {
                c(z10, aVar);
                return;
            }
        }
        d(z10, aVar);
    }
}
