package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;

/* loaded from: classes.dex */
class TranslationAnimationCreator {

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* renamed from: a */
        private final View f3860a;

        /* renamed from: b */
        private final View f3861b;

        /* renamed from: c */
        private final int f3862c;

        /* renamed from: d */
        private final int f3863d;

        /* renamed from: e */
        private int[] f3864e;

        /* renamed from: f */
        private float f3865f;

        /* renamed from: g */
        private float f3866g;

        /* renamed from: h */
        private final float f3867h;

        /* renamed from: i */
        private final float f3868i;

        TransitionPositionListener(View view, View view2, int i2, int i3, float f2, float f3) {
            this.f3861b = view;
            this.f3860a = view2;
            this.f3862c = i2 - Math.round(view.getTranslationX());
            this.f3863d = i3 - Math.round(view.getTranslationY());
            this.f3867h = f2;
            this.f3868i = f3;
            int i4 = R.id.transition_position;
            int[] iArr = (int[]) view2.getTag(i4);
            this.f3864e = iArr;
            if (iArr != null) {
                view2.setTag(i4, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f3864e == null) {
                this.f3864e = new int[2];
            }
            this.f3864e[0] = Math.round(this.f3862c + this.f3861b.getTranslationX());
            this.f3864e[1] = Math.round(this.f3863d + this.f3861b.getTranslationY());
            this.f3860a.setTag(R.id.transition_position, this.f3864e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f3865f = this.f3861b.getTranslationX();
            this.f3866g = this.f3861b.getTranslationY();
            this.f3861b.setTranslationX(this.f3867h);
            this.f3861b.setTranslationY(this.f3868i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.f3861b.setTranslationX(this.f3865f);
            this.f3861b.setTranslationY(this.f3866g);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            this.f3861b.setTranslationX(this.f3867h);
            this.f3861b.setTranslationY(this.f3868i);
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
        }
    }

    private TranslationAnimationCreator() {
    }

    @Nullable
    static Animator a(@NonNull View view, @NonNull TransitionValues transitionValues, int i2, int i3, float f2, float f3, float f4, float f5, @Nullable TimeInterpolator timeInterpolator, @NonNull Transition transition) {
        float f6;
        float f7;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(R.id.transition_position)) != null) {
            f6 = (r4[0] - i2) + translationX;
            f7 = (r4[1] - i3) + translationY;
        } else {
            f6 = f2;
            f7 = f3;
        }
        int round = i2 + Math.round(f6 - translationX);
        int round2 = i3 + Math.round(f7 - translationY);
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        if (f6 == f4 && f7 == f5) {
            return null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f6, f4), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f7, f5));
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, round, round2, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofPropertyValuesHolder.addListener(transitionPositionListener);
        AnimatorUtils.a(ofPropertyValuesHolder, transitionPositionListener);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
