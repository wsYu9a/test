package com.kwad.components.ad.reward.presenter.platdetail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bj;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {
    private View vE;
    private View vF;
    private View vG;
    private View vH;
    private Animator vK;
    private Animator vL;
    private Animator vM;
    private bj vP;
    private bj vQ;
    private final long vB = 1600;
    private final long vC = 3000;
    private final long vD = 5000;
    private boolean vI = false;
    private boolean vJ = false;
    private Animator vN = null;
    private long vO = 3000;
    private Interpolator vR = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);

    /* renamed from: ia */
    private l f11854ia = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.1
        private boolean vS = false;

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.vI = true;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            if (j11 < b.this.vO || this.vS) {
                return;
            }
            this.vS = true;
            b.this.io();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.vI = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.vI = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.vN == null || b.this.vN.isRunning()) {
                return;
            }
            b.this.vN.start();
            b.a(b.this, (Animator) null);
        }
    };

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.b$1 */
    public class AnonymousClass1 extends l {
        private boolean vS = false;

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayPaused() {
            super.onMediaPlayPaused();
            b.this.vI = true;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayPaused : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayProgress(long j10, long j11) {
            super.onMediaPlayProgress(j10, j11);
            if (j11 < b.this.vO || this.vS) {
                return;
            }
            this.vS = true;
            b.this.io();
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.vI = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlayStart : ");
        }

        @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
        public final void onMediaPlaying() {
            super.onMediaPlaying();
            b.this.vI = false;
            com.kwad.sdk.core.d.c.d("RewardImagePlayerPresenter", "onMediaPlaying : ");
            if (b.this.vN == null || b.this.vN.isRunning()) {
                return;
            }
            b.this.vN.start();
            b.a(b.this, (Animator) null);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.b$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b.q(b.this.vF);
            b.b(b.this, (View) null);
            if (b.this.vJ) {
                return;
            }
            b bVar = b.this;
            bVar.a(bVar.vL);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.b$3 */
    public class AnonymousClass3 extends AnimatorListenerAdapter {
        public AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b bVar = b.this;
            bVar.a(bVar.vM);
            b.q(b.this.vG);
            b.q(b.this.vH);
            b.c(b.this, null);
            b.d(b.this, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            b.b(b.this, true);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.b$4 */
    public class AnonymousClass4 extends AnimatorListenerAdapter {
        public AnonymousClass4() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            b bVar = b.this;
            bVar.a(bVar.vM);
        }
    }

    public static /* synthetic */ View b(b bVar, View view) {
        bVar.vF = null;
        return null;
    }

    private void im() {
        this.vP = new bj(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_start), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_start));
        this.vQ = new bj(getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_width_end), getContext().getResources().getDimensionPixelSize(R.dimen.ksad_image_player_sweep_wave_height_end));
    }

    private View in() {
        ImageView imageView = new ImageView(getContext());
        imageView.setClickable(false);
        imageView.setFocusable(false);
        imageView.setFocusableInTouchMode(false);
        imageView.setLongClickable(false);
        imageView.setBackgroundColor(Color.parseColor("#222222"));
        imageView.setAlpha(0.2f);
        return imageView;
    }

    public void io() {
        this.vK = a(this.vE, 1600L);
        this.vL = a(this.vG, this.vH);
        this.vM = b(this.vE, 1600L);
        this.vK.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.2
            public AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.q(b.this.vF);
                b.b(b.this, (View) null);
                if (b.this.vJ) {
                    return;
                }
                b bVar = b.this;
                bVar.a(bVar.vL);
            }
        });
        this.vL.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.3
            public AnonymousClass3() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.vM);
                b.q(b.this.vG);
                b.q(b.this.vH);
                b.c(b.this, null);
                b.d(b.this, null);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                b.b(b.this, true);
            }
        });
        this.vM.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.b.4
            public AnonymousClass4() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b bVar = b.this;
                bVar.a(bVar.vM);
            }
        });
        a(this.vK);
    }

    private Animator p(View view) {
        if (this.vP == null || this.vQ == null) {
            im();
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", -(com.kwad.sdk.c.a.a.getScreenHeight(getContext()) + ((this.vQ.getHeight() + this.vP.getHeight()) / 2)));
        float OF = this.vQ.OF() / this.vP.OF();
        float OG = this.vQ.OG() / this.vP.OG();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, OF);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, OG);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.8f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(3000L);
        animatorSet.playTogether(ofFloat2, ofFloat3, ofFloat, ofFloat4);
        animatorSet.setInterpolator(this.vR);
        return animatorSet;
    }

    public static void q(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
            }
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.f11689qf.a(this.f11854ia);
        FrameLayout Q = this.rO.f11689qf.kj().Q(getContext());
        this.vE = Q;
        if (Q.getParent() != null) {
            return;
        }
        ((FrameLayout) findViewById(R.id.ksad_reward_play_layout)).addView(this.vE, -1, -1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 81;
        layoutParams.bottomMargin = -this.vP.getHeight();
        ViewGroup viewGroup = (FrameLayout) findViewById(R.id.ksad_root_container);
        View in = in();
        this.vF = in;
        viewGroup.addView(in, -1, -1);
        View a10 = a(R.drawable.ksad_image_player_sweep1, viewGroup);
        this.vG = a10;
        viewGroup.addView(a10, layoutParams);
        View a11 = a(R.drawable.ksad_image_player_sweep2, viewGroup);
        this.vH = a11;
        viewGroup.addView(a11, layoutParams);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        im();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.vE = null;
        com.kwad.components.ad.reward.m.b kj2 = this.rO.f11689qf.kj();
        if (kj2 != null) {
            kj2.release();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.vI = true;
        Animator animator = this.vL;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.vK;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator animator3 = this.vM;
        if (animator3 != null) {
            animator3.cancel();
        }
        this.rO.f11689qf.b(this.f11854ia);
    }

    public static /* synthetic */ Animator a(b bVar, Animator animator) {
        bVar.vN = null;
        return null;
    }

    public static /* synthetic */ View c(b bVar, View view) {
        bVar.vG = null;
        return null;
    }

    public static /* synthetic */ View d(b bVar, View view) {
        bVar.vH = null;
        return null;
    }

    public static /* synthetic */ boolean b(b bVar, boolean z10) {
        bVar.vJ = true;
        return true;
    }

    private View a(@DrawableRes int i10, ViewGroup viewGroup) {
        ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.ksad_image_player_sweep, viewGroup, false);
        imageView.setImageDrawable(getContext().getResources().getDrawable(i10));
        return imageView;
    }

    private Animator b(View view, long j10) {
        Animator a10 = a(view, 1600L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f);
        ofFloat.setDuration(5000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a10, ofFloat);
        animatorSet.setDuration(1600L);
        return animatorSet;
    }

    public void a(@NonNull Animator animator) {
        if (!this.vI) {
            animator.start();
        } else {
            this.vN = animator;
        }
    }

    private Animator a(View view, View view2) {
        Animator p10 = p(view);
        Animator p11 = p(view2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f);
        ofFloat.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, p11);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(p10, animatorSet);
        return animatorSet2;
    }

    private Animator a(View view, long j10) {
        float[] fArr = {1.0f, 1.106f, 1.0f, 1.106f, 1.0f};
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", fArr);
        AnimatorSet animatorSet = new AnimatorSet();
        View view2 = this.vF;
        if (view2 != null) {
            animatorSet.playTogether(ofFloat, ofFloat2, ObjectAnimator.ofFloat(view2, "alpha", 0.2f, 0.0f));
        } else {
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        animatorSet.setDuration(j10);
        animatorSet.setInterpolator(this.vR);
        return animatorSet;
    }
}
