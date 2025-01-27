package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ChangeClipBounds extends Transition {
    private static final String T = "android:clipBounds:bounds";
    private static final String S = "android:clipBounds:clip";
    private static final String[] U = {S};

    /* renamed from: androidx.transition.ChangeClipBounds$1 */
    class AnonymousClass1 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ View f3715a;

        AnonymousClass1(View view) {
            view = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewCompat.setClipBounds(view, null);
        }
    }

    public ChangeClipBounds() {
    }

    private void H(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect clipBounds = ViewCompat.getClipBounds(view);
        transitionValues.values.put(S, clipBounds);
        if (clipBounds == null) {
            transitionValues.values.put(T, new Rect(0, 0, view.getWidth(), view.getHeight()));
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        H(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        H(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ObjectAnimator objectAnimator = null;
        if (transitionValues != null && transitionValues2 != null && transitionValues.values.containsKey(S) && transitionValues2.values.containsKey(S)) {
            Rect rect = (Rect) transitionValues.values.get(S);
            Rect rect2 = (Rect) transitionValues2.values.get(S);
            boolean z = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                rect = (Rect) transitionValues.values.get(T);
            } else if (rect2 == null) {
                rect2 = (Rect) transitionValues2.values.get(T);
            }
            if (rect.equals(rect2)) {
                return null;
            }
            ViewCompat.setClipBounds(transitionValues2.view, rect);
            objectAnimator = ObjectAnimator.ofObject(transitionValues2.view, (Property<View, V>) ViewUtils.f3891d, (TypeEvaluator) new RectEvaluator(new Rect()), (Object[]) new Rect[]{rect, rect2});
            if (z) {
                objectAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeClipBounds.1

                    /* renamed from: a */
                    final /* synthetic */ View f3715a;

                    AnonymousClass1(View view) {
                        view = view;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        ViewCompat.setClipBounds(view, null);
                    }
                });
            }
        }
        return objectAnimator;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return U;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
