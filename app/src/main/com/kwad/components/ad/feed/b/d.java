package com.kwad.components.ad.feed.b;

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

/* loaded from: classes2.dex */
public final class d extends FrameLayout {
    private int count;
    private Animator gA;
    private Animation gB;
    private Animation gC;
    private ImageView gw;
    private ImageView gx;
    private ImageView gy;
    private Animator gz;

    /* renamed from: com.kwad.components.ad.feed.b.d$1 */
    public class AnonymousClass1 extends AnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            d.this.gw.startAnimation(d.this.gB);
            d.this.gx.startAnimation(d.this.gC);
            d.this.gA.start();
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.d$2 */
    public class AnonymousClass2 extends AnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            d.f(d.this);
            if (d.this.count >= 5) {
                return;
            }
            d.this.gz.start();
        }
    }

    /* renamed from: com.kwad.components.ad.feed.b.d$3 */
    public class AnonymousClass3 implements Animation.AnimationListener {
        final /* synthetic */ View gE;

        public AnonymousClass3(View view) {
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

    private void A(Context context) {
        com.kwad.sdk.n.m.inflate(context, R.layout.ksad_promote_ad_click, this);
        this.gw = (ImageView) findViewById(R.id.ksad_inside_circle);
        this.gx = (ImageView) findViewById(R.id.ksad_outside_circle);
        this.gy = (ImageView) findViewById(R.id.ksad_hand);
    }

    private void bP() {
        this.gz = e(this.gy);
        this.gA = f(this.gy);
        this.gB = a(this.gw, 0.45f, com.kwad.sdk.c.a.a.a(getContext(), 34.0f));
        this.gC = a(this.gx, 0.5f, com.kwad.sdk.c.a.a.a(getContext(), 50.0f));
        this.gz.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.d.1
            public AnonymousClass1() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.this.gw.startAnimation(d.this.gB);
                d.this.gx.startAnimation(d.this.gC);
                d.this.gA.start();
            }
        });
        this.gA.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.b.d.2
            public AnonymousClass2() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                d.f(d.this);
                if (d.this.count >= 5) {
                    return;
                }
                d.this.gz.start();
            }
        });
    }

    public static /* synthetic */ int f(d dVar) {
        int i10 = dVar.count;
        dVar.count = i10 + 1;
        return i10;
    }

    public final void bN() {
        bP();
        this.gz.start();
    }

    public final void bO() {
        Animator animator = this.gz;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.gA;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animation animation = this.gB;
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = this.gC;
        if (animation2 != null) {
            animation2.cancel();
        }
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private Animation a(View view, float f10, int i10) {
        float a10 = com.kwad.sdk.c.a.a.a(getContext(), 10.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f10, 0.0f);
        float f11 = i10 / a10;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f11, 1.0f, f11, 1, 0.5f, 1, 0.5f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(200L);
        animationSet.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.components.ad.feed.b.d.3
            final /* synthetic */ View gE;

            public AnonymousClass3(View view2) {
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

    private Animator e(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", 0.0f, -10.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -com.kwad.sdk.c.a.a.a(getContext(), 9.5f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private Animator f(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", -10.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationX", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "translationY", -com.kwad.sdk.c.a.a.a(getContext(), 9.5f), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(250L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    private d(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, 0);
        this.count = 0;
        A(context);
    }
}
