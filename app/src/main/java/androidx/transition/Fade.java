package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class Fade extends Visibility {
    public static final int IN = 1;
    public static final int OUT = 2;
    private static final String X = "android:fade:transitionAlpha";
    private static final String Y = "Fade";

    /* renamed from: androidx.transition.Fade$1 */
    class AnonymousClass1 extends TransitionListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ View f3742a;

        AnonymousClass1(View view) {
            view = view;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            ViewUtils.h(view, 1.0f);
            ViewUtils.a(view);
            transition.removeListener(this);
        }
    }

    private static class FadeAnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a */
        private final View f3744a;

        /* renamed from: b */
        private boolean f3745b = false;

        FadeAnimatorListener(View view) {
            this.f3744a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.h(this.f3744a, 1.0f);
            if (this.f3745b) {
                this.f3744a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (ViewCompat.hasOverlappingRendering(this.f3744a) && this.f3744a.getLayerType() == 0) {
                this.f3745b = true;
                this.f3744a.setLayerType(2, null);
            }
        }
    }

    public Fade(int i2) {
        setMode(i2);
    }

    private Animator J(View view, float f2, float f3) {
        if (f2 == f3) {
            return null;
        }
        ViewUtils.h(view, f2);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.f3890c, f3);
        ofFloat.addListener(new FadeAnimatorListener(view));
        addListener(new TransitionListenerAdapter() { // from class: androidx.transition.Fade.1

            /* renamed from: a */
            final /* synthetic */ View f3742a;

            AnonymousClass1(View view2) {
                view = view2;
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                ViewUtils.h(view, 1.0f);
                ViewUtils.a(view);
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }

    private static float K(TransitionValues transitionValues, float f2) {
        Float f3;
        return (transitionValues == null || (f3 = (Float) transitionValues.values.get(X)) == null) ? f2 : f3.floatValue();
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(X, Float.valueOf(ViewUtils.c(transitionValues.view)));
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float K = K(transitionValues, 0.0f);
        return J(view, K != 1.0f ? K : 0.0f, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.e(view);
        return J(view, K(transitionValues, 1.0f), 0.0f);
    }

    public Fade() {
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3809f);
        setMode(TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, getMode()));
        obtainStyledAttributes.recycle();
    }
}
