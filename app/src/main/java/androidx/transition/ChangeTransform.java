package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class ChangeTransform extends Transition {
    private static final String U = "android:changeTransform:parent";
    private static final String W = "android:changeTransform:intermediateParentMatrix";
    private static final String X = "android:changeTransform:intermediateMatrix";
    private static final boolean b0;
    boolean c0;
    private boolean d0;
    private Matrix e0;
    private static final String S = "android:changeTransform:matrix";
    private static final String T = "android:changeTransform:transforms";
    private static final String V = "android:changeTransform:parentMatrix";
    private static final String[] Y = {S, T, V};
    private static final Property<PathAnimatorMatrix, float[]> Z = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") { // from class: androidx.transition.ChangeTransform.1
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.d(fArr);
        }
    };
    private static final Property<PathAnimatorMatrix, PointF> a0 = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") { // from class: androidx.transition.ChangeTransform.2
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.c(pointF);
        }
    };

    /* renamed from: androidx.transition.ChangeTransform$1 */
    static class AnonymousClass1 extends Property<PathAnimatorMatrix, float[]> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public float[] get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, float[] fArr) {
            pathAnimatorMatrix.d(fArr);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$2 */
    static class AnonymousClass2 extends Property<PathAnimatorMatrix, PointF> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(PathAnimatorMatrix pathAnimatorMatrix) {
            return null;
        }

        @Override // android.util.Property
        public void set(PathAnimatorMatrix pathAnimatorMatrix, PointF pointF) {
            pathAnimatorMatrix.c(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$3 */
    class AnonymousClass3 extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f3718a;

        /* renamed from: b */
        private Matrix f3719b = new Matrix();

        /* renamed from: c */
        final /* synthetic */ boolean f3720c;

        /* renamed from: d */
        final /* synthetic */ Matrix f3721d;

        /* renamed from: e */
        final /* synthetic */ View f3722e;

        /* renamed from: f */
        final /* synthetic */ Transforms f3723f;

        /* renamed from: g */
        final /* synthetic */ PathAnimatorMatrix f3724g;

        AnonymousClass3(boolean z, Matrix matrix, View view, Transforms transforms, PathAnimatorMatrix pathAnimatorMatrix) {
            z = z;
            matrix3 = matrix;
            view = view;
            transforms = transforms;
            pathAnimatorMatrix = pathAnimatorMatrix;
        }

        private void a(Matrix matrix) {
            this.f3719b.set(matrix);
            view.setTag(R.id.transition_transform, this.f3719b);
            transforms.restore(view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3718a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f3718a) {
                if (z && ChangeTransform.this.c0) {
                    a(matrix3);
                } else {
                    view.setTag(R.id.transition_transform, null);
                    view.setTag(R.id.parent_matrix, null);
                }
            }
            ViewUtils.f(view, null);
            transforms.restore(view);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            a(pathAnimatorMatrix.a());
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            ChangeTransform.L(view);
        }
    }

    private static class GhostListener extends TransitionListenerAdapter {

        /* renamed from: a */
        private View f3726a;

        /* renamed from: b */
        private GhostView f3727b;

        GhostListener(View view, GhostView ghostView) {
            this.f3726a = view;
            this.f3727b = ghostView;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            transition.removeListener(this);
            GhostViewUtils.b(this.f3726a);
            this.f3726a.setTag(R.id.transition_transform, null);
            this.f3726a.setTag(R.id.parent_matrix, null);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            this.f3727b.setVisibility(4);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            this.f3727b.setVisibility(0);
        }
    }

    private static class PathAnimatorMatrix {

        /* renamed from: a */
        private final Matrix f3728a = new Matrix();

        /* renamed from: b */
        private final View f3729b;

        /* renamed from: c */
        private final float[] f3730c;

        /* renamed from: d */
        private float f3731d;

        /* renamed from: e */
        private float f3732e;

        PathAnimatorMatrix(View view, float[] fArr) {
            this.f3729b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f3730c = fArr2;
            this.f3731d = fArr2[2];
            this.f3732e = fArr2[5];
            b();
        }

        private void b() {
            float[] fArr = this.f3730c;
            fArr[2] = this.f3731d;
            fArr[5] = this.f3732e;
            this.f3728a.setValues(fArr);
            ViewUtils.f(this.f3729b, this.f3728a);
        }

        Matrix a() {
            return this.f3728a;
        }

        void c(PointF pointF) {
            this.f3731d = pointF.x;
            this.f3732e = pointF.y;
            b();
        }

        void d(float[] fArr) {
            System.arraycopy(fArr, 0, this.f3730c, 0, fArr.length);
            b();
        }
    }

    private static class Transforms {

        /* renamed from: a */
        final float f3733a;

        /* renamed from: b */
        final float f3734b;

        /* renamed from: c */
        final float f3735c;

        /* renamed from: d */
        final float f3736d;

        /* renamed from: e */
        final float f3737e;

        /* renamed from: f */
        final float f3738f;

        /* renamed from: g */
        final float f3739g;

        /* renamed from: h */
        final float f3740h;

        Transforms(View view) {
            this.f3733a = view.getTranslationX();
            this.f3734b = view.getTranslationY();
            this.f3735c = ViewCompat.getTranslationZ(view);
            this.f3736d = view.getScaleX();
            this.f3737e = view.getScaleY();
            this.f3738f = view.getRotationX();
            this.f3739g = view.getRotationY();
            this.f3740h = view.getRotation();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Transforms)) {
                return false;
            }
            Transforms transforms = (Transforms) obj;
            return transforms.f3733a == this.f3733a && transforms.f3734b == this.f3734b && transforms.f3735c == this.f3735c && transforms.f3736d == this.f3736d && transforms.f3737e == this.f3737e && transforms.f3738f == this.f3738f && transforms.f3739g == this.f3739g && transforms.f3740h == this.f3740h;
        }

        public int hashCode() {
            float f2 = this.f3733a;
            int floatToIntBits = (f2 != 0.0f ? Float.floatToIntBits(f2) : 0) * 31;
            float f3 = this.f3734b;
            int floatToIntBits2 = (floatToIntBits + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f3735c;
            int floatToIntBits3 = (floatToIntBits2 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f3736d;
            int floatToIntBits4 = (floatToIntBits3 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f3737e;
            int floatToIntBits5 = (floatToIntBits4 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f3738f;
            int floatToIntBits6 = (floatToIntBits5 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f3739g;
            int floatToIntBits7 = (floatToIntBits6 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0)) * 31;
            float f9 = this.f3740h;
            return floatToIntBits7 + (f9 != 0.0f ? Float.floatToIntBits(f9) : 0);
        }

        public void restore(View view) {
            ChangeTransform.N(view, this.f3733a, this.f3734b, this.f3735c, this.f3736d, this.f3737e, this.f3738f, this.f3739g, this.f3740h);
        }
    }

    static {
        b0 = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.c0 = true;
        this.d0 = true;
        this.e0 = new Matrix();
    }

    private void H(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        transitionValues.values.put(U, view.getParent());
        transitionValues.values.put(T, new Transforms(view));
        Matrix matrix = view.getMatrix();
        transitionValues.values.put(S, (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.d0) {
            Matrix matrix2 = new Matrix();
            ViewUtils.j((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            transitionValues.values.put(V, matrix2);
            transitionValues.values.put(X, view.getTag(R.id.transition_transform));
            transitionValues.values.put(W, view.getTag(R.id.parent_matrix));
        }
    }

    private void I(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.view;
        Matrix matrix = new Matrix((Matrix) transitionValues2.values.get(V));
        ViewUtils.k(viewGroup, matrix);
        GhostView a2 = GhostViewUtils.a(view, viewGroup, matrix);
        if (a2 == null) {
            return;
        }
        a2.reserveEndViewTransition((ViewGroup) transitionValues.values.get(U), transitionValues.view);
        Transition transition = this;
        while (true) {
            Transition transition2 = transition.C;
            if (transition2 == null) {
                break;
            } else {
                transition = transition2;
            }
        }
        transition.addListener(new GhostListener(view, a2));
        if (b0) {
            View view2 = transitionValues.view;
            if (view2 != transitionValues2.view) {
                ViewUtils.h(view2, 0.0f);
            }
            ViewUtils.h(view, 1.0f);
        }
    }

    private ObjectAnimator J(TransitionValues transitionValues, TransitionValues transitionValues2, boolean z) {
        Matrix matrix = (Matrix) transitionValues.values.get(S);
        Matrix matrix2 = (Matrix) transitionValues2.values.get(S);
        if (matrix == null) {
            matrix = MatrixUtils.f3785a;
        }
        if (matrix2 == null) {
            matrix2 = MatrixUtils.f3785a;
        }
        Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        Transforms transforms = (Transforms) transitionValues2.values.get(T);
        View view = transitionValues2.view;
        L(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, fArr);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, PropertyValuesHolder.ofObject(Z, new FloatArrayEvaluator(new float[9]), fArr, fArr2), PropertyValuesHolderUtils.a(a0, getPathMotion().getPath(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        AnonymousClass3 anonymousClass3 = new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeTransform.3

            /* renamed from: a */
            private boolean f3718a;

            /* renamed from: b */
            private Matrix f3719b = new Matrix();

            /* renamed from: c */
            final /* synthetic */ boolean f3720c;

            /* renamed from: d */
            final /* synthetic */ Matrix f3721d;

            /* renamed from: e */
            final /* synthetic */ View f3722e;

            /* renamed from: f */
            final /* synthetic */ Transforms f3723f;

            /* renamed from: g */
            final /* synthetic */ PathAnimatorMatrix f3724g;

            AnonymousClass3(boolean z2, Matrix matrix32, View view2, Transforms transforms2, PathAnimatorMatrix pathAnimatorMatrix2) {
                z = z2;
                matrix3 = matrix32;
                view = view2;
                transforms = transforms2;
                pathAnimatorMatrix = pathAnimatorMatrix2;
            }

            private void a(Matrix matrix4) {
                this.f3719b.set(matrix4);
                view.setTag(R.id.transition_transform, this.f3719b);
                transforms.restore(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f3718a = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.f3718a) {
                    if (z && ChangeTransform.this.c0) {
                        a(matrix3);
                    } else {
                        view.setTag(R.id.transition_transform, null);
                        view.setTag(R.id.parent_matrix, null);
                    }
                }
                ViewUtils.f(view, null);
                transforms.restore(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                a(pathAnimatorMatrix.a());
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                ChangeTransform.L(view);
            }
        };
        ofPropertyValuesHolder.addListener(anonymousClass3);
        AnimatorUtils.a(ofPropertyValuesHolder, anonymousClass3);
        return ofPropertyValuesHolder;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001a, code lost:
    
        if (r4 == r5) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r5 == r4.view) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001d, code lost:
    
        r1 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean K(android.view.ViewGroup r4, android.view.ViewGroup r5) {
        /*
            r3 = this;
            boolean r0 = r3.s(r4)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1a
            boolean r0 = r3.s(r5)
            if (r0 != 0) goto Lf
            goto L1a
        Lf:
            androidx.transition.TransitionValues r4 = r3.p(r4, r1)
            if (r4 == 0) goto L1f
            android.view.View r4 = r4.view
            if (r5 != r4) goto L1d
            goto L1e
        L1a:
            if (r4 != r5) goto L1d
            goto L1e
        L1d:
            r1 = 0
        L1e:
            r2 = r1
        L1f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.K(android.view.ViewGroup, android.view.ViewGroup):boolean");
    }

    static void L(View view) {
        N(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void M(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Matrix matrix = (Matrix) transitionValues2.values.get(V);
        transitionValues2.view.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.e0;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) transitionValues.values.get(S);
        if (matrix3 == null) {
            matrix3 = new Matrix();
            transitionValues.values.put(S, matrix3);
        }
        matrix3.postConcat((Matrix) transitionValues.values.get(V));
        matrix3.postConcat(matrix2);
    }

    static void N(View view, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        view.setTranslationX(f2);
        view.setTranslationY(f3);
        ViewCompat.setTranslationZ(view, f4);
        view.setScaleX(f5);
        view.setScaleY(f6);
        view.setRotationX(f7);
        view.setRotationY(f8);
        view.setRotation(f9);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        H(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        H(transitionValues);
        if (b0) {
            return;
        }
        ((ViewGroup) transitionValues.view.getParent()).startViewTransition(transitionValues.view);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(@NonNull ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null || !transitionValues.values.containsKey(U) || !transitionValues2.values.containsKey(U)) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) transitionValues.values.get(U);
        boolean z = this.d0 && !K(viewGroup2, (ViewGroup) transitionValues2.values.get(U));
        Matrix matrix = (Matrix) transitionValues.values.get(X);
        if (matrix != null) {
            transitionValues.values.put(S, matrix);
        }
        Matrix matrix2 = (Matrix) transitionValues.values.get(W);
        if (matrix2 != null) {
            transitionValues.values.put(V, matrix2);
        }
        if (z) {
            M(transitionValues, transitionValues2);
        }
        ObjectAnimator J = J(transitionValues, transitionValues2, z);
        if (z && J != null && this.c0) {
            I(viewGroup, transitionValues, transitionValues2);
        } else if (!b0) {
            viewGroup2.endViewTransition(transitionValues.view);
        }
        return J;
    }

    public boolean getReparent() {
        return this.d0;
    }

    public boolean getReparentWithOverlay() {
        return this.c0;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return Y;
    }

    public void setReparent(boolean z) {
        this.d0 = z;
    }

    public void setReparentWithOverlay(boolean z) {
        this.c0 = z;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c0 = true;
        this.d0 = true;
        this.e0 = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3810g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.c0 = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.d0 = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
