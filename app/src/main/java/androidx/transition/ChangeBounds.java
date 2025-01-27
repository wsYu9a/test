package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.util.Map;

/* loaded from: classes.dex */
public class ChangeBounds extends Transition {
    private int[] f0;
    private boolean g0;
    private boolean h0;
    private static final String S = "android:changeBounds:bounds";
    private static final String T = "android:changeBounds:clip";
    private static final String U = "android:changeBounds:parent";
    private static final String V = "android:changeBounds:windowX";
    private static final String W = "android:changeBounds:windowY";
    private static final String[] X = {S, T, U, V, W};
    private static final Property<Drawable, PointF> Y = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: androidx.transition.ChangeBounds.1

        /* renamed from: a */
        private Rect f3689a = new Rect();

        AnonymousClass1(Class cls, String str) {
            super(cls, str);
            this.f3689a = new Rect();
        }

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f3689a);
            Rect rect = this.f3689a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f3689a);
            this.f3689a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f3689a);
        }
    };
    private static final Property<ViewBounds, PointF> Z = new Property<ViewBounds, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.2
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.c(pointF);
        }
    };
    private static final Property<ViewBounds, PointF> a0 = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.3
        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.a(pointF);
        }
    };
    private static final Property<View, PointF> b0 = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: androidx.transition.ChangeBounds.4
        AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };
    private static final Property<View, PointF> c0 = new Property<View, PointF>(PointF.class, "topLeft") { // from class: androidx.transition.ChangeBounds.5
        AnonymousClass5(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };
    private static final Property<View, PointF> d0 = new Property<View, PointF>(PointF.class, "position") { // from class: androidx.transition.ChangeBounds.6
        AnonymousClass6(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    };
    private static RectEvaluator e0 = new RectEvaluator();

    /* renamed from: androidx.transition.ChangeBounds$1 */
    static class AnonymousClass1 extends Property<Drawable, PointF> {

        /* renamed from: a */
        private Rect f3689a = new Rect();

        AnonymousClass1(Class cls, String str) {
            super(cls, str);
            this.f3689a = new Rect();
        }

        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f3689a);
            Rect rect = this.f3689a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f3689a);
            this.f3689a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f3689a);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$10 */
    class AnonymousClass10 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewGroup f3690a;

        /* renamed from: b */
        final /* synthetic */ BitmapDrawable f3691b;

        /* renamed from: c */
        final /* synthetic */ View f3692c;

        /* renamed from: d */
        final /* synthetic */ float f3693d;

        AnonymousClass10(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            viewGroup = viewGroup;
            bitmapDrawable = bitmapDrawable;
            view2 = view;
            c3 = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ViewUtils.b(viewGroup).remove(bitmapDrawable);
            ViewUtils.h(view2, c3);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$2 */
    static class AnonymousClass2 extends Property<ViewBounds, PointF> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.c(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$3 */
    static class AnonymousClass3 extends Property<ViewBounds, PointF> {
        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            viewBounds.a(pointF);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$4 */
    static class AnonymousClass4 extends Property<View, PointF> {
        AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.g(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$5 */
    static class AnonymousClass5 extends Property<View, PointF> {
        AnonymousClass5(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            ViewUtils.g(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$6 */
    static class AnonymousClass6 extends Property<View, PointF> {
        AnonymousClass6(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            ViewUtils.g(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$7 */
    class AnonymousClass7 extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ ViewBounds f3695a;
        private ViewBounds mViewBounds;

        AnonymousClass7(ViewBounds viewBounds) {
            this.f3695a = viewBounds;
            this.mViewBounds = viewBounds;
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$8 */
    class AnonymousClass8 extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f3697a;

        /* renamed from: b */
        final /* synthetic */ View f3698b;

        /* renamed from: c */
        final /* synthetic */ Rect f3699c;

        /* renamed from: d */
        final /* synthetic */ int f3700d;

        /* renamed from: e */
        final /* synthetic */ int f3701e;

        /* renamed from: f */
        final /* synthetic */ int f3702f;

        /* renamed from: g */
        final /* synthetic */ int f3703g;

        AnonymousClass8(View view, Rect rect, int i2, int i3, int i4, int i5) {
            view = view;
            rect5 = rect;
            i5 = i2;
            i7 = i3;
            i9 = i4;
            i11 = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3697a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3697a) {
                return;
            }
            ViewCompat.setClipBounds(view, rect5);
            ViewUtils.g(view, i5, i7, i9, i11);
        }
    }

    /* renamed from: androidx.transition.ChangeBounds$9 */
    class AnonymousClass9 extends TransitionListenerAdapter {

        /* renamed from: a */
        boolean f3705a = false;

        /* renamed from: b */
        final /* synthetic */ ViewGroup f3706b;

        AnonymousClass9(ViewGroup viewGroup) {
            viewGroup4 = viewGroup;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(@NonNull Transition transition) {
            ViewGroupUtils.d(viewGroup4, false);
            this.f3705a = true;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            if (!this.f3705a) {
                ViewGroupUtils.d(viewGroup4, false);
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            ViewGroupUtils.d(viewGroup4, false);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            ViewGroupUtils.d(viewGroup4, true);
        }
    }

    private static class ViewBounds {

        /* renamed from: a */
        private int f3708a;

        /* renamed from: b */
        private int f3709b;

        /* renamed from: c */
        private int f3710c;

        /* renamed from: d */
        private int f3711d;

        /* renamed from: e */
        private View f3712e;

        /* renamed from: f */
        private int f3713f;

        /* renamed from: g */
        private int f3714g;

        ViewBounds(View view) {
            this.f3712e = view;
        }

        private void b() {
            ViewUtils.g(this.f3712e, this.f3708a, this.f3709b, this.f3710c, this.f3711d);
            this.f3713f = 0;
            this.f3714g = 0;
        }

        void a(PointF pointF) {
            this.f3710c = Math.round(pointF.x);
            this.f3711d = Math.round(pointF.y);
            int i2 = this.f3714g + 1;
            this.f3714g = i2;
            if (this.f3713f == i2) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f3708a = Math.round(pointF.x);
            this.f3709b = Math.round(pointF.y);
            int i2 = this.f3713f + 1;
            this.f3713f = i2;
            if (i2 == this.f3714g) {
                b();
            }
        }
    }

    public ChangeBounds() {
        this.f0 = new int[2];
        this.g0 = false;
        this.h0 = false;
    }

    private void H(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (!ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.values.put(S, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.values.put(U, transitionValues.view.getParent());
        if (this.h0) {
            transitionValues.view.getLocationInWindow(this.f0);
            transitionValues.values.put(V, Integer.valueOf(this.f0[0]));
            transitionValues.values.put(W, Integer.valueOf(this.f0[1]));
        }
        if (this.g0) {
            transitionValues.values.put(T, ViewCompat.getClipBounds(view));
        }
    }

    private boolean I(View view, View view2) {
        if (!this.h0) {
            return true;
        }
        TransitionValues p = p(view, true);
        if (p == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == p.view) {
            return true;
        }
        return false;
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
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c2;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get(U);
        ViewGroup viewGroup3 = (ViewGroup) map2.get(U);
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues2.view;
        if (!I(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) transitionValues.values.get(V)).intValue();
            int intValue2 = ((Integer) transitionValues.values.get(W)).intValue();
            int intValue3 = ((Integer) transitionValues2.values.get(V)).intValue();
            int intValue4 = ((Integer) transitionValues2.values.get(W)).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f0);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c3 = ViewUtils.c(view2);
            ViewUtils.h(view2, 0.0f);
            ViewUtils.b(viewGroup).add(bitmapDrawable);
            PathMotion pathMotion = getPathMotion();
            int[] iArr = this.f0;
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.a(Y, pathMotion.getPath(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
            ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.10

                /* renamed from: a */
                final /* synthetic */ ViewGroup f3690a;

                /* renamed from: b */
                final /* synthetic */ BitmapDrawable f3691b;

                /* renamed from: c */
                final /* synthetic */ View f3692c;

                /* renamed from: d */
                final /* synthetic */ float f3693d;

                AnonymousClass10(ViewGroup viewGroup4, BitmapDrawable bitmapDrawable2, View view22, float c32) {
                    viewGroup = viewGroup4;
                    bitmapDrawable = bitmapDrawable2;
                    view2 = view22;
                    c3 = c32;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewUtils.b(viewGroup).remove(bitmapDrawable);
                    ViewUtils.h(view2, c3);
                }
            });
            return ofPropertyValuesHolder;
        }
        Rect rect2 = (Rect) transitionValues.values.get(S);
        Rect rect3 = (Rect) transitionValues2.values.get(S);
        int i4 = rect2.left;
        int i5 = rect3.left;
        int i6 = rect2.top;
        int i7 = rect3.top;
        int i8 = rect2.right;
        int i9 = rect3.right;
        int i10 = rect2.bottom;
        int i11 = rect3.bottom;
        int i12 = i8 - i4;
        int i13 = i10 - i6;
        int i14 = i9 - i5;
        int i15 = i11 - i7;
        Rect rect4 = (Rect) transitionValues.values.get(T);
        Rect rect5 = (Rect) transitionValues2.values.get(T);
        if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
            i2 = 0;
        } else {
            i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
            if (i8 != i9 || i10 != i11) {
                i2++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i2++;
        }
        if (i2 <= 0) {
            return null;
        }
        if (this.g0) {
            view = view22;
            ViewUtils.g(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
            ObjectAnimator a2 = (i4 == i5 && i6 == i7) ? null : ObjectAnimatorUtils.a(view, d0, getPathMotion().getPath(i4, i6, i5, i7));
            if (rect4 == null) {
                i3 = 0;
                rect = new Rect(0, 0, i12, i13);
            } else {
                i3 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                ViewCompat.setClipBounds(view, rect);
                RectEvaluator rectEvaluator = e0;
                Object[] objArr = new Object[2];
                objArr[i3] = rect;
                objArr[1] = rect6;
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                ofObject.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.ChangeBounds.8

                    /* renamed from: a */
                    private boolean f3697a;

                    /* renamed from: b */
                    final /* synthetic */ View f3698b;

                    /* renamed from: c */
                    final /* synthetic */ Rect f3699c;

                    /* renamed from: d */
                    final /* synthetic */ int f3700d;

                    /* renamed from: e */
                    final /* synthetic */ int f3701e;

                    /* renamed from: f */
                    final /* synthetic */ int f3702f;

                    /* renamed from: g */
                    final /* synthetic */ int f3703g;

                    AnonymousClass8(View view3, Rect rect52, int i52, int i72, int i92, int i112) {
                        view = view3;
                        rect5 = rect52;
                        i5 = i52;
                        i7 = i72;
                        i9 = i92;
                        i11 = i112;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.f3697a = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (this.f3697a) {
                            return;
                        }
                        ViewCompat.setClipBounds(view, rect5);
                        ViewUtils.g(view, i5, i7, i9, i11);
                    }
                });
                objectAnimator = ofObject;
            }
            c2 = TransitionUtils.c(a2, objectAnimator);
        } else {
            view3 = view22;
            ViewUtils.g(view3, i4, i6, i8, i10);
            if (i2 != 2) {
                c2 = (i4 == i52 && i6 == i72) ? ObjectAnimatorUtils.a(view3, b0, getPathMotion().getPath(i8, i10, i92, i112)) : ObjectAnimatorUtils.a(view3, c0, getPathMotion().getPath(i4, i6, i52, i72));
            } else if (i12 == i14 && i13 == i15) {
                c2 = ObjectAnimatorUtils.a(view3, d0, getPathMotion().getPath(i4, i6, i52, i72));
            } else {
                ViewBounds viewBounds = new ViewBounds(view3);
                ObjectAnimator a3 = ObjectAnimatorUtils.a(viewBounds, Z, getPathMotion().getPath(i4, i6, i52, i72));
                ObjectAnimator a4 = ObjectAnimatorUtils.a(viewBounds, a0, getPathMotion().getPath(i8, i10, i92, i112));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(a3, a4);
                animatorSet.addListener(new AnimatorListenerAdapter(viewBounds) { // from class: androidx.transition.ChangeBounds.7

                    /* renamed from: a */
                    final /* synthetic */ ViewBounds f3695a;
                    private ViewBounds mViewBounds;

                    AnonymousClass7(ViewBounds viewBounds2) {
                        this.f3695a = viewBounds2;
                        this.mViewBounds = viewBounds2;
                    }
                });
                c2 = animatorSet;
            }
        }
        if (view3.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view3.getParent();
            ViewGroupUtils.d(viewGroup4, true);
            addListener(new TransitionListenerAdapter() { // from class: androidx.transition.ChangeBounds.9

                /* renamed from: a */
                boolean f3705a = false;

                /* renamed from: b */
                final /* synthetic */ ViewGroup f3706b;

                AnonymousClass9(ViewGroup viewGroup42) {
                    viewGroup4 = viewGroup42;
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionCancel(@NonNull Transition transition) {
                    ViewGroupUtils.d(viewGroup4, false);
                    this.f3705a = true;
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionEnd(@NonNull Transition transition) {
                    if (!this.f3705a) {
                        ViewGroupUtils.d(viewGroup4, false);
                    }
                    transition.removeListener(this);
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionPause(@NonNull Transition transition) {
                    ViewGroupUtils.d(viewGroup4, false);
                }

                @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
                public void onTransitionResume(@NonNull Transition transition) {
                    ViewGroupUtils.d(viewGroup4, true);
                }
            });
        }
        return c2;
    }

    public boolean getResizeClip() {
        return this.g0;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return X;
    }

    public void setResizeClip(boolean z) {
        this.g0 = z;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f0 = new int[2];
        this.g0 = false;
        this.h0 = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f3807d);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(obtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        obtainStyledAttributes.recycle();
        setResizeClip(namedBoolean);
    }
}
