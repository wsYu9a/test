package com.kwad.components.core.r;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: com.kwad.components.core.r.m$1 */
    static class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View fn;

        AnonymousClass1(View view) {
            view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            m.k(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    /* renamed from: com.kwad.components.core.r.m$2 */
    static class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View fn;

        AnonymousClass2(View view) {
            view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: com.kwad.components.core.r.m$3 */
    static class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean Qg;
        final /* synthetic */ View fn;

        AnonymousClass3(boolean z, View view) {
            z = z;
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (z) {
                return;
            }
            view.setAlpha(0.0f);
            view.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            if (z) {
                view.setAlpha(0.0f);
                view.setVisibility(0);
            }
        }
    }

    /* renamed from: com.kwad.components.core.r.m$4 */
    static class AnonymousClass4 extends AnimatorListenerAdapter {
        final /* synthetic */ int Qh;
        final /* synthetic */ View fn;

        AnonymousClass4(View view, int i2) {
            view = view;
            i3 = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            m.k(view, i3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            m.k(view, i3);
        }
    }

    /* renamed from: com.kwad.components.core.r.m$5 */
    static class AnonymousClass5 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View Qi;

        AnonymousClass5(View view) {
            view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            view.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public static Animator a(View view, @Nullable Interpolator interpolator, float f2, float f3) {
        if (view == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", f2, f3);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(create);
        return ofFloat;
    }

    public static Animator a(View view, @Nullable Interpolator interpolator, long j2, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        Interpolator create = interpolator == null ? PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f) : interpolator;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f);
        ofFloat.setDuration(300L);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "rotation", 0.0f, f2).setDuration(j2);
        float f3 = -f2;
        long j3 = j2 * 2;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j3);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "rotation", f3, f2).setDuration(j3);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "rotation", f2, f3).setDuration(j3);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(ofFloat, duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "rotation", f3, 0.0f).setDuration(j2));
        return animatorSet;
    }

    public static ValueAnimator b(View view, int i2, int i3) {
        k(view, i2);
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.r.m.1
            final /* synthetic */ View fn;

            AnonymousClass1(View view2) {
                view = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                m.k(view, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.r.m.4
            final /* synthetic */ int Qh;
            final /* synthetic */ View fn;

            AnonymousClass4(View view2, int i32) {
                view = view2;
                i3 = i32;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                m.k(view, i3);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                m.k(view, i3);
            }
        });
        return ofInt;
    }

    public static ValueAnimator c(View view, int i2, int i3) {
        ValueAnimator ofInt = ObjectAnimator.ofInt(i2, i3);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.r.m.5
            final /* synthetic */ View Qi;

            AnonymousClass5(View view2) {
                view = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationY(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        return ofInt;
    }

    public static ValueAnimator h(View view, boolean z) {
        float[] fArr = new float[2];
        fArr[0] = z ? 0.0f : 1.0f;
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.45f, 0.0f, 0.6f, 1.0f));
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.r.m.2
            final /* synthetic */ View fn;

            AnonymousClass2(View view2) {
                view = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.r.m.3
            final /* synthetic */ boolean Qg;
            final /* synthetic */ View fn;

            AnonymousClass3(boolean z2, View view2) {
                z = z2;
                view = view2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                view.setAlpha(0.0f);
                view.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    view.setAlpha(0.0f);
                    view.setVisibility(0);
                }
            }
        });
        return ofFloat;
    }

    public static void k(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }
}
