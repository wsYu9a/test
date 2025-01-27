package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String U = "android:visibility:screenLocation";
    private int W;
    static final String S = "android:visibility:visibility";
    private static final String T = "android:visibility:parent";
    private static final String[] V = {S, T};

    /* renamed from: androidx.transition.Visibility$1 */
    class AnonymousClass1 extends TransitionListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f3902a;

        /* renamed from: b */
        final /* synthetic */ View f3903b;

        /* renamed from: c */
        final /* synthetic */ View f3904c;

        AnonymousClass1(ViewGroup viewGroup, View view, View view2) {
            r2 = viewGroup;
            r3 = view;
            r4 = view2;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            r4.setTag(R.id.save_overlay_view, null);
            ViewGroupUtils.b(r2).remove(r3);
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            ViewGroupUtils.b(r2).remove(r3);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            if (r3.getParent() == null) {
                ViewGroupUtils.b(r2).add(r3);
            } else {
                Visibility.this.cancel();
            }
        }
    }

    private static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener, AnimatorUtils.AnimatorPauseListenerCompat {

        /* renamed from: a */
        private final View f3906a;

        /* renamed from: b */
        private final int f3907b;

        /* renamed from: c */
        private final ViewGroup f3908c;

        /* renamed from: d */
        private final boolean f3909d;

        /* renamed from: e */
        private boolean f3910e;

        /* renamed from: f */
        boolean f3911f = false;

        DisappearListener(View view, int i2, boolean z) {
            this.f3906a = view;
            this.f3907b = i2;
            this.f3908c = (ViewGroup) view.getParent();
            this.f3909d = z;
            b(true);
        }

        private void a() {
            if (!this.f3911f) {
                ViewUtils.i(this.f3906a, this.f3907b);
                ViewGroup viewGroup = this.f3908c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            b(false);
        }

        private void b(boolean z) {
            ViewGroup viewGroup;
            if (!this.f3909d || this.f3910e == z || (viewGroup = this.f3908c) == null) {
                return;
            }
            this.f3910e = z;
            ViewGroupUtils.d(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3911f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationPause(Animator animator) {
            if (this.f3911f) {
                return;
            }
            ViewUtils.i(this.f3906a, this.f3907b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, androidx.transition.AnimatorUtils.AnimatorPauseListenerCompat
        public void onAnimationResume(Animator animator) {
            if (this.f3911f) {
                return;
            }
            ViewUtils.i(this.f3906a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            a();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            b(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            b(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(@NonNull Transition transition) {
        }
    }

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Mode {
    }

    private static class VisibilityInfo {

        /* renamed from: a */
        boolean f3912a;

        /* renamed from: b */
        boolean f3913b;

        /* renamed from: c */
        int f3914c;

        /* renamed from: d */
        int f3915d;

        /* renamed from: e */
        ViewGroup f3916e;

        /* renamed from: f */
        ViewGroup f3917f;

        VisibilityInfo() {
        }
    }

    public Visibility() {
        this.W = 3;
    }

    private void H(TransitionValues transitionValues) {
        transitionValues.values.put(S, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(T, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(U, iArr);
    }

    private VisibilityInfo I(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f3912a = false;
        visibilityInfo.f3913b = false;
        if (transitionValues == null || !transitionValues.values.containsKey(S)) {
            visibilityInfo.f3914c = -1;
            visibilityInfo.f3916e = null;
        } else {
            visibilityInfo.f3914c = ((Integer) transitionValues.values.get(S)).intValue();
            visibilityInfo.f3916e = (ViewGroup) transitionValues.values.get(T);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(S)) {
            visibilityInfo.f3915d = -1;
            visibilityInfo.f3917f = null;
        } else {
            visibilityInfo.f3915d = ((Integer) transitionValues2.values.get(S)).intValue();
            visibilityInfo.f3917f = (ViewGroup) transitionValues2.values.get(T);
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i2 = visibilityInfo.f3914c;
            int i3 = visibilityInfo.f3915d;
            if (i2 == i3 && visibilityInfo.f3916e == visibilityInfo.f3917f) {
                return visibilityInfo;
            }
            if (i2 != i3) {
                if (i2 == 0) {
                    visibilityInfo.f3913b = false;
                    visibilityInfo.f3912a = true;
                } else if (i3 == 0) {
                    visibilityInfo.f3913b = true;
                    visibilityInfo.f3912a = true;
                }
            } else if (visibilityInfo.f3917f == null) {
                visibilityInfo.f3913b = false;
                visibilityInfo.f3912a = true;
            } else if (visibilityInfo.f3916e == null) {
                visibilityInfo.f3913b = true;
                visibilityInfo.f3912a = true;
            }
        } else if (transitionValues == null && visibilityInfo.f3915d == 0) {
            visibilityInfo.f3913b = true;
            visibilityInfo.f3912a = true;
        } else if (transitionValues2 == null && visibilityInfo.f3914c == 0) {
            visibilityInfo.f3913b = false;
            visibilityInfo.f3912a = true;
        }
        return visibilityInfo;
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
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        VisibilityInfo I = I(transitionValues, transitionValues2);
        if (!I.f3912a) {
            return null;
        }
        if (I.f3916e == null && I.f3917f == null) {
            return null;
        }
        return I.f3913b ? onAppear(viewGroup, transitionValues, I.f3914c, transitionValues2, I.f3915d) : onDisappear(viewGroup, transitionValues, I.f3914c, transitionValues2, I.f3915d);
    }

    public int getMode() {
        return this.W;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return V;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey(S) != transitionValues.values.containsKey(S)) {
            return false;
        }
        VisibilityInfo I = I(transitionValues, transitionValues2);
        if (I.f3912a) {
            return I.f3914c == 0 || I.f3915d == 0;
        }
        return false;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((Integer) transitionValues.values.get(S)).intValue() == 0 && ((View) transitionValues.values.get(T)) != null;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i2, TransitionValues transitionValues2, int i3) {
        if ((this.W & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (I(p(view, false), getTransitionValues(view, false)).f3912a) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
    
        if (r17.H != false) goto L104;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator onDisappear(android.view.ViewGroup r18, androidx.transition.TransitionValues r19, int r20, androidx.transition.TransitionValues r21, int r22) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void setMode(int i2) {
        if ((i2 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.W = i2;
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.W = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3808e);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }
}
