package com.kwad.components.ad.feed.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class e extends FrameLayout {
    private View fo;
    private ImageView fp;

    @Nullable
    private Animator fq;

    /* renamed from: fr */
    private com.kwad.sdk.widget.c f9536fr;

    /* renamed from: com.kwad.components.ad.feed.a.e$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ AnimatorListenerAdapter fs;

        AnonymousClass1(AnimatorListenerAdapter animatorListenerAdapter) {
            animatorListenerAdapter = animatorListenerAdapter;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e eVar = e.this;
            eVar.fq = eVar.bx();
            if (e.this.fq == null) {
                animatorListenerAdapter.onAnimationEnd(null);
            } else {
                e.this.fq.addListener(animatorListenerAdapter);
                e.this.fq.start();
            }
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.e$2 */
    final class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ View fn;

        AnonymousClass2(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            view.setVisibility(0);
            view.setClickable(true);
            new com.kwad.sdk.widget.f(view, e.this.f9536fr);
        }
    }

    /* renamed from: com.kwad.components.ad.feed.a.e$3 */
    final class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ View fn;

        AnonymousClass3(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            view.setVisibility(8);
        }
    }

    public e(@NonNull Context context) {
        this(context, null);
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    private e(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, 0);
        init(context);
    }

    private Animator a(View view, long j2, float f2) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
        this.fp.setPivotX(view.getWidth());
        this.fp.setPivotY(view.getHeight());
        Animator a2 = com.kwad.components.core.r.m.a(view, create, 100L, 16.0f);
        Animator a3 = com.kwad.components.core.r.m.a(view, create, 100L, 16.0f);
        Animator a4 = com.kwad.components.core.r.m.a(view, create, 100L, 16.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(a2, a3, a4);
        return animatorSet;
    }

    private Animator b(View view, int i2) {
        if (view == null) {
            return null;
        }
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getHeight() / 2.0f);
        float min = i2 / Math.min(view.getHeight(), view.getWidth());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", min, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", min, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.e.2
            final /* synthetic */ View fn;

            AnonymousClass2(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                view.setVisibility(0);
                view.setClickable(true);
                new com.kwad.sdk.widget.f(view, e.this.f9536fr);
            }
        });
        return animatorSet;
    }

    public Animator bx() {
        View view = this.fo;
        if (view == null || this.fp == null || view.getWidth() + this.fo.getHeight() == 0 || this.fp.getWidth() + this.fp.getHeight() == 0) {
            return null;
        }
        Animator by = by();
        Animator a2 = a(this.fp, 100L, 16.0f);
        Animator bz = bz();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(by, a2, bz);
        return animatorSet;
    }

    private Animator by() {
        Animator b2 = b(this.fo, com.kwad.sdk.c.kwai.a.a(getContext(), 128.0f));
        Animator b3 = b(this.fp, com.kwad.sdk.c.kwai.a.a(getContext(), 71.11f));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(b2, b3);
        return animatorSet;
    }

    private Animator bz() {
        Animator f2 = f(this.fo);
        Animator f3 = f(this.fp);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.playTogether(f2, f3);
        return animatorSet;
    }

    private Animator f(View view) {
        if (view == null) {
            return null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.setDuration(500L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.feed.a.e.3
            final /* synthetic */ View fn;

            AnonymousClass3(View view2) {
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        return animatorSet;
    }

    private void init(Context context) {
        com.kwad.sdk.j.k.inflate(context, R.layout.ksad_feed_shake, this);
        setClickable(false);
        this.fo = findViewById(R.id.ksad_feed_shake_bg);
        this.fp = (ImageView) findViewById(R.id.ksad_feed_shake_icon);
    }

    @MainThread
    public final void a(AnimatorListenerAdapter animatorListenerAdapter) {
        Animator animator = this.fq;
        if (animator != null) {
            animator.cancel();
            this.fq = null;
        }
        this.fp.post(new Runnable() { // from class: com.kwad.components.ad.feed.a.e.1
            final /* synthetic */ AnimatorListenerAdapter fs;

            AnonymousClass1(AnimatorListenerAdapter animatorListenerAdapter2) {
                animatorListenerAdapter = animatorListenerAdapter2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                e eVar = e.this;
                eVar.fq = eVar.bx();
                if (e.this.fq == null) {
                    animatorListenerAdapter.onAnimationEnd(null);
                } else {
                    e.this.fq.addListener(animatorListenerAdapter);
                    e.this.fq.start();
                }
            }
        });
    }

    public final void setOnViewEventListener(com.kwad.sdk.widget.c cVar) {
        this.f9536fr = cVar;
    }
}
