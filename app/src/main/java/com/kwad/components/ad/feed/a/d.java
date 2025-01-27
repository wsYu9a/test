package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class d extends FrameLayout {
    private int count;
    private ImageView ff;
    private ImageView fg;
    private ImageView fh;
    private Animator fi;
    private Animator fj;
    private Animation fk;
    private Animation fl;

    /* renamed from: com.kwad.components.ad.feed.a.d$1 */
    final class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            d.this.ff.startAnimation(d.this.fk);
            d.this.fg.startAnimation(d.this.fl);
            d.this.fj.start();
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.d$2 */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            d.f(d.this);
            if (d.this.count >= 5) {
                return;
            }
            d.this.fi.start();
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.d$3 */
    final class AnonymousClass3 implements Animation.AnimationListener {
        final /* synthetic */ View fn;

        AnonymousClass3(View view) {
            view = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation animation) {
            view.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation animation) {
            view.setVisibility(0);
        }
    }

    public d(@NonNull Context context) {
        this(context, null);
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        this.count = 0;
        D(context);
    }

    private void D(Context context) {
        com.kwad.sdk.j.k.inflate(context, R.layout.ksad_promote_ad_click, this);
        this.ff = (ImageView) findViewById(R.id.ksad_inside_circle);
        this.fg = (ImageView) findViewById(R.id.ksad_outside_circle);
        this.fh = (ImageView) findViewById(R.id.ksad_hand);
    }

    private Animation a(View view, float f2, int i2) {
        float a2 = com.kwad.sdk.c.kwai.a.a(getContext(), 10.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, 0.0f);
        float f3 = i2 / a2;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f3, 1.0f, f3, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.a.d.3
            final /* synthetic */ View fn;

            AnonymousClass3(View view2) {
                view = view2;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(4);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        return animationSet;
    }

    private void bw() {
        this.fi = d(this.fh);
        this.fj = e(this.fh);
        this.fk = a(this.ff, 0.45f, com.kwad.sdk.c.kwai.a.a(getContext(), 34.0f));
        this.fl = a(this.fg, 0.5f, com.kwad.sdk.c.kwai.a.a(getContext(), 50.0f));
        this.fi.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.d.1
            AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.ff.startAnimation(d.this.fk);
                d.this.fg.startAnimation(d.this.fl);
                d.this.fj.start();
            }
        });
        this.fj.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.d.2
            AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.fi.start();
            }
        });
    }

    private Animator d(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -com.kwad.sdk.c.kwai.a.a(getContext(), 9.5f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -com.kwad.sdk.c.kwai.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private Animator e(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", -10.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", -com.kwad.sdk.c.kwai.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", -com.kwad.sdk.c.kwai.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    static /* synthetic */ int f(d dVar) {
        int i2 = dVar.count;
        dVar.count = i2 + 1;
        return i2;
    }

    public final void bu() {
        bw();
        this.fi.start();
    }

    public final void bv() {
        Animator animator = this.fi;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.fj;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.fk;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.fl;
        if (animation2 != null) {
            animation2.cancel();
        }
    }
}
