package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.internal.u;
import com.google.android.material.j.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a */
    public static final int f6832a = 1;

    /* renamed from: b */
    public static final int f6833b = 2;

    /* renamed from: c */
    public static final int f6834c = 3;

    /* renamed from: d */
    public static final int f6835d = 4;

    /* renamed from: e */
    public static final int f6836e = 5;

    /* renamed from: f */
    public static final int f6837f = 6;

    /* renamed from: g */
    public static final int f6838g = -1;

    /* renamed from: h */
    public static final int f6839h = 1;

    /* renamed from: i */
    public static final int f6840i = 2;

    /* renamed from: j */
    public static final int f6841j = 4;
    public static final int k = 8;
    public static final int l = -1;
    public static final int m = 0;
    private static final String n = "BottomSheetBehavior";
    private static final int o = 500;
    private static final float p = 0.5f;
    private static final float q = 0.1f;
    private static final int r = 500;
    private static final int s = R.style.Widget_Design_BottomSheet_Modal;
    private int A;
    private boolean B;
    private com.google.android.material.j.j C;
    private int D;
    private boolean E;
    private o F;
    private boolean G;
    private BottomSheetBehavior<V>.i H;

    @Nullable
    private ValueAnimator I;
    int J;
    int K;
    int L;
    float M;
    int N;
    float O;
    boolean P;
    private boolean Q;
    private boolean R;
    int S;

    @Nullable
    ViewDragHelper T;
    private boolean U;
    private int V;
    private boolean W;
    private int X;
    int Y;
    int Z;

    @Nullable
    WeakReference<V> a0;

    @Nullable
    WeakReference<View> b0;

    @NonNull
    private final ArrayList<f> c0;

    @Nullable
    private VelocityTracker d0;
    int e0;
    private int f0;
    boolean g0;

    @Nullable
    private Map<View, Integer> h0;
    private final ViewDragHelper.Callback i0;
    private int t;
    private boolean u;
    private boolean v;
    private float w;
    private int x;
    private boolean y;
    private int z;

    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f6842a;

        /* renamed from: b */
        final /* synthetic */ int f6843b;

        a(View view, int i2) {
            this.f6842a = view;
            this.f6843b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.X(this.f6842a, this.f6843b);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.C != null) {
                BottomSheetBehavior.this.C.o0(floatValue);
            }
        }
    }

    class c implements u.e {
        c() {
        }

        @Override // com.google.android.material.internal.u.e
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, u.f fVar) {
            BottomSheetBehavior.this.D = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
            BottomSheetBehavior.this.e0(false);
            return windowInsetsCompat;
        }
    }

    class d extends ViewDragHelper.Callback {
        d() {
        }

        private boolean a(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.Z + bottomSheetBehavior.t()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int t = BottomSheetBehavior.this.t();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i2, t, bottomSheetBehavior.P ? bottomSheetBehavior.Z : bottomSheetBehavior.N);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return bottomSheetBehavior.P ? bottomSheetBehavior.Z : bottomSheetBehavior.N;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.R) {
                BottomSheetBehavior.this.U(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.q(i3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int i2;
            int i3 = 4;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.u) {
                    i2 = BottomSheetBehavior.this.K;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior.L;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = bottomSheetBehavior.J;
                    }
                }
                i3 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.P && bottomSheetBehavior2.Z(view, f3)) {
                    if ((Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) && !a(view)) {
                        if (BottomSheetBehavior.this.u) {
                            i2 = BottomSheetBehavior.this.K;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.J) < Math.abs(view.getTop() - BottomSheetBehavior.this.L)) {
                            i2 = BottomSheetBehavior.this.J;
                        } else {
                            i2 = BottomSheetBehavior.this.L;
                            i3 = 6;
                        }
                        i3 = 3;
                    } else {
                        i2 = BottomSheetBehavior.this.Z;
                        i3 = 5;
                    }
                } else if (f3 == 0.0f || Math.abs(f2) > Math.abs(f3)) {
                    int top2 = view.getTop();
                    if (!BottomSheetBehavior.this.u) {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i5 = bottomSheetBehavior3.L;
                        if (top2 < i5) {
                            if (top2 < Math.abs(top2 - bottomSheetBehavior3.N)) {
                                i2 = BottomSheetBehavior.this.J;
                                i3 = 3;
                            } else {
                                i2 = BottomSheetBehavior.this.L;
                            }
                        } else if (Math.abs(top2 - i5) < Math.abs(top2 - BottomSheetBehavior.this.N)) {
                            i2 = BottomSheetBehavior.this.L;
                        } else {
                            i2 = BottomSheetBehavior.this.N;
                        }
                        i3 = 6;
                    } else if (Math.abs(top2 - BottomSheetBehavior.this.K) < Math.abs(top2 - BottomSheetBehavior.this.N)) {
                        i2 = BottomSheetBehavior.this.K;
                        i3 = 3;
                    } else {
                        i2 = BottomSheetBehavior.this.N;
                    }
                } else if (BottomSheetBehavior.this.u) {
                    i2 = BottomSheetBehavior.this.N;
                } else {
                    int top3 = view.getTop();
                    if (Math.abs(top3 - BottomSheetBehavior.this.L) < Math.abs(top3 - BottomSheetBehavior.this.N)) {
                        i2 = BottomSheetBehavior.this.L;
                        i3 = 6;
                    } else {
                        i2 = BottomSheetBehavior.this.N;
                    }
                }
            }
            BottomSheetBehavior.this.a0(view, i3, i2, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.S;
            if (i3 == 1 || bottomSheetBehavior.g0) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.e0 == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.b0;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.a0;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    class e implements AccessibilityViewCommand {

        /* renamed from: a */
        final /* synthetic */ int f6848a;

        e(int i2) {
            this.f6848a = i2;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.T(this.f6848a);
            return true;
        }
    }

    public static abstract class f {
        public abstract void a(@NonNull View view, float f2);

        public abstract void b(@NonNull View view, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface g {
    }

    protected static class h extends AbsSavedState {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: b */
        final int f6850b;

        /* renamed from: c */
        int f6851c;

        /* renamed from: d */
        boolean f6852d;

        /* renamed from: e */
        boolean f6853e;

        /* renamed from: f */
        boolean f6854f;

        static class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public h createFromParcel(@NonNull Parcel parcel) {
                return new h(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public h createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public h[] newArray(int i2) {
                return new h[i2];
            }
        }

        public h(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f6850b);
            parcel.writeInt(this.f6851c);
            parcel.writeInt(this.f6852d ? 1 : 0);
            parcel.writeInt(this.f6853e ? 1 : 0);
            parcel.writeInt(this.f6854f ? 1 : 0);
        }

        public h(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6850b = parcel.readInt();
            this.f6851c = parcel.readInt();
            this.f6852d = parcel.readInt() == 1;
            this.f6853e = parcel.readInt() == 1;
            this.f6854f = parcel.readInt() == 1;
        }

        public h(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f6850b = bottomSheetBehavior.S;
            this.f6851c = ((BottomSheetBehavior) bottomSheetBehavior).x;
            this.f6852d = ((BottomSheetBehavior) bottomSheetBehavior).u;
            this.f6853e = bottomSheetBehavior.P;
            this.f6854f = ((BottomSheetBehavior) bottomSheetBehavior).Q;
        }

        @Deprecated
        public h(Parcelable parcelable, int i2) {
            super(parcelable);
            this.f6850b = i2;
        }
    }

    private class i implements Runnable {

        /* renamed from: a */
        private final View f6855a;

        /* renamed from: b */
        private boolean f6856b;

        /* renamed from: c */
        int f6857c;

        i(View view, int i2) {
            this.f6855a = view;
            this.f6857c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.T;
            if (viewDragHelper == null || !viewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.U(this.f6857c);
            } else {
                ViewCompat.postOnAnimation(this.f6855a, this);
            }
            this.f6856b = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface j {
    }

    public BottomSheetBehavior() {
        this.t = 0;
        this.u = true;
        this.v = false;
        this.H = null;
        this.M = 0.5f;
        this.O = -1.0f;
        this.R = true;
        this.S = 4;
        this.c0 = new ArrayList<>();
        this.i0 = new d();
    }

    private float A() {
        VelocityTracker velocityTracker = this.d0;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.w);
        return this.d0.getYVelocity(this.e0);
    }

    private void G() {
        this.e0 = -1;
        VelocityTracker velocityTracker = this.d0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.d0 = null;
        }
    }

    private void H(@NonNull h hVar) {
        int i2 = this.t;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1 || (i2 & 1) == 1) {
            this.x = hVar.f6851c;
        }
        if (i2 == -1 || (i2 & 2) == 2) {
            this.u = hVar.f6852d;
        }
        if (i2 == -1 || (i2 & 4) == 4) {
            this.P = hVar.f6853e;
        }
        if (i2 == -1 || (i2 & 8) == 8) {
            this.Q = hVar.f6854f;
        }
    }

    private void V(@NonNull View view) {
        if (Build.VERSION.SDK_INT < 29 || D() || this.y) {
            return;
        }
        u.c(view, new c());
    }

    private void Y(int i2) {
        V v = this.a0.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new a(v, i2));
        } else {
            X(v, i2);
        }
    }

    private void b0() {
        V v;
        WeakReference<V> weakReference = this.a0;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        if (this.P && this.S != 5) {
            h(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i2 = this.S;
        if (i2 == 3) {
            h(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.u ? 4 : 6);
            return;
        }
        if (i2 == 4) {
            h(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.u ? 3 : 6);
        } else {
            if (i2 != 6) {
                return;
            }
            h(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            h(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void c0(int i2) {
        ValueAnimator valueAnimator;
        if (i2 == 2) {
            return;
        }
        boolean z = i2 == 3;
        if (this.G != z) {
            this.G = z;
            if (this.C == null || (valueAnimator = this.I) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.I.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.I.setFloatValues(1.0f - f2, f2);
            this.I.start();
        }
    }

    private void d0(boolean z) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.a0;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.h0 != null) {
                    return;
                } else {
                    this.h0 = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.a0.get()) {
                    if (z) {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.h0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.v) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.v && (map = this.h0) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.h0.get(childAt).intValue());
                    }
                }
            }
            if (z) {
                return;
            }
            this.h0 = null;
        }
    }

    public void e0(boolean z) {
        V v;
        if (this.a0 != null) {
            j();
            if (this.S != 4 || (v = this.a0.get()) == null) {
                return;
            }
            if (z) {
                Y(this.S);
            } else {
                v.requestLayout();
            }
        }
    }

    private void h(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, new e(i2));
    }

    private void j() {
        int l2 = l();
        if (this.u) {
            this.N = Math.max(this.Z - l2, this.K);
        } else {
            this.N = this.Z - l2;
        }
    }

    private void k() {
        this.L = (int) (this.Z * (1.0f - this.M));
    }

    private int l() {
        int i2;
        return this.y ? Math.min(Math.max(this.z, this.Z - ((this.Y * 9) / 16)), this.X) : (this.E || (i2 = this.D) <= 0) ? this.x : Math.max(this.x, i2 + this.A);
    }

    private void m(@NonNull Context context, AttributeSet attributeSet, boolean z) {
        n(context, attributeSet, z, null);
    }

    private void n(@NonNull Context context, AttributeSet attributeSet, boolean z, @Nullable ColorStateList colorStateList) {
        if (this.B) {
            this.F = o.e(context, attributeSet, R.attr.bottomSheetStyle, s).m();
            com.google.android.material.j.j jVar = new com.google.android.material.j.j(this.F);
            this.C = jVar;
            jVar.Y(context);
            if (z && colorStateList != null) {
                this.C.n0(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
            this.C.setTint(typedValue.data);
        }
    }

    private void o() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.I = ofFloat;
        ofFloat.setDuration(500L);
        this.I.addUpdateListener(new b());
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> s(@NonNull V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public boolean B() {
        return this.R;
    }

    public boolean C() {
        return this.u;
    }

    public boolean D() {
        return this.E;
    }

    public boolean E() {
        return this.P;
    }

    public void F(@NonNull f fVar) {
        this.c0.remove(fVar);
    }

    @Deprecated
    public void I(f fVar) {
        Log.w(n, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.c0.clear();
        if (fVar != null) {
            this.c0.add(fVar);
        }
    }

    public void J(boolean z) {
        this.R = z;
    }

    public void K(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.J = i2;
    }

    public void L(boolean z) {
        if (this.u == z) {
            return;
        }
        this.u = z;
        if (this.a0 != null) {
            j();
        }
        U((this.u && this.S == 6) ? 3 : this.S);
        b0();
    }

    public void M(boolean z) {
        this.E = z;
    }

    public void N(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.M = f2;
        if (this.a0 != null) {
            k();
        }
    }

    public void O(boolean z) {
        if (this.P != z) {
            this.P = z;
            if (!z && this.S == 5) {
                T(4);
            }
            b0();
        }
    }

    public void P(int i2) {
        Q(i2, false);
    }

    public final void Q(int i2, boolean z) {
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.y) {
                this.y = true;
            }
            z2 = false;
        } else {
            if (this.y || this.x != i2) {
                this.y = false;
                this.x = Math.max(0, i2);
            }
            z2 = false;
        }
        if (z2) {
            e0(z);
        }
    }

    public void R(int i2) {
        this.t = i2;
    }

    public void S(boolean z) {
        this.Q = z;
    }

    public void T(int i2) {
        if (i2 == this.S) {
            return;
        }
        if (this.a0 != null) {
            Y(i2);
            return;
        }
        if (i2 == 4 || i2 == 3 || i2 == 6 || (this.P && i2 == 5)) {
            this.S = i2;
        }
    }

    void U(int i2) {
        V v;
        if (this.S == i2) {
            return;
        }
        this.S = i2;
        WeakReference<V> weakReference = this.a0;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            d0(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            d0(false);
        }
        c0(i2);
        for (int i3 = 0; i3 < this.c0.size(); i3++) {
            this.c0.get(i3).b(v, i2);
        }
        b0();
    }

    public void W(boolean z) {
        this.v = z;
    }

    void X(@NonNull View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.N;
        } else if (i2 == 6) {
            int i5 = this.L;
            if (!this.u || i5 > (i4 = this.K)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = t();
        } else {
            if (!this.P || i2 != 5) {
                throw new IllegalArgumentException("Illegal state argument: " + i2);
            }
            i3 = this.Z;
        }
        a0(view, i2, i3, false);
    }

    boolean Z(@NonNull View view, float f2) {
        if (this.Q) {
            return true;
        }
        if (view.getTop() < this.N) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * q)) - ((float) this.N)) / ((float) l()) > 0.5f;
    }

    void a0(View view, int i2, int i3, boolean z) {
        ViewDragHelper viewDragHelper = this.T;
        if (!(viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i3) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i3)))) {
            U(i2);
            return;
        }
        U(2);
        c0(i2);
        if (this.H == null) {
            this.H = new i(view, i2);
        }
        if (((i) this.H).f6856b) {
            this.H.f6857c = i2;
            return;
        }
        BottomSheetBehavior<V>.i iVar = this.H;
        iVar.f6857c = i2;
        ViewCompat.postOnAnimation(view, iVar);
        ((i) this.H).f6856b = true;
    }

    public void i(@NonNull f fVar) {
        if (this.c0.contains(fVar)) {
            return;
        }
        this.c0.add(fVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.a0 = null;
        this.T = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.a0 = null;
        this.T = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!v.isShown() || !this.R) {
            this.U = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            G();
        }
        if (this.d0 == null) {
            this.d0 = VelocityTracker.obtain();
        }
        this.d0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.f0 = (int) motionEvent.getY();
            if (this.S != 2) {
                WeakReference<View> weakReference = this.b0;
                View view = weakReference != null ? weakReference.get() : null;
                if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.f0)) {
                    this.e0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.g0 = true;
                }
            }
            this.U = this.e0 == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.f0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.g0 = false;
            this.e0 = -1;
            if (this.U) {
                this.U = false;
                return false;
            }
        }
        if (!this.U && (viewDragHelper = this.T) != null && viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.b0;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.U || this.S == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.T == null || Math.abs(((float) this.f0) - motionEvent.getY()) <= ((float) this.T.getTouchSlop())) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        com.google.android.material.j.j jVar;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.a0 == null) {
            this.z = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            V(v);
            this.a0 = new WeakReference<>(v);
            if (this.B && (jVar = this.C) != null) {
                ViewCompat.setBackground(v, jVar);
            }
            com.google.android.material.j.j jVar2 = this.C;
            if (jVar2 != null) {
                float f2 = this.O;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.getElevation(v);
                }
                jVar2.m0(f2);
                boolean z = this.S == 3;
                this.G = z;
                this.C.o0(z ? 0.0f : 1.0f);
            }
            b0();
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
            }
        }
        if (this.T == null) {
            this.T = ViewDragHelper.create(coordinatorLayout, this.i0);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i2);
        this.Y = coordinatorLayout.getWidth();
        this.Z = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.X = height;
        this.K = Math.max(0, this.Z - height);
        k();
        j();
        int i3 = this.S;
        if (i3 == 3) {
            ViewCompat.offsetTopAndBottom(v, t());
        } else if (i3 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.L);
        } else if (this.P && i3 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.Z);
        } else if (i3 == 4) {
            ViewCompat.offsetTopAndBottom(v, this.N);
        } else if (i3 == 1 || i3 == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        this.b0 = new WeakReference<>(r(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3) {
        WeakReference<View> weakReference = this.b0;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.S != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f2, f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.b0;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < t()) {
                iArr[1] = top - t();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                U(3);
            } else {
                if (!this.R) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                U(1);
            }
        } else if (i3 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.N;
            if (i5 > i6 && !this.P) {
                iArr[1] = top - i6;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                U(4);
            } else {
                if (!this.R) {
                    return;
                }
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                U(1);
            }
        }
        q(v.getTop());
        this.V = i3;
        this.W = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, hVar.getSuperState());
        H(hVar);
        int i2 = hVar.f6850b;
        if (i2 == 1 || i2 == 2) {
            this.S = 4;
        } else {
            this.S = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        return new h(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        this.V = 0;
        this.W = false;
        return (i2 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2) {
        int i3;
        int i4 = 3;
        if (v.getTop() == t()) {
            U(3);
            return;
        }
        WeakReference<View> weakReference = this.b0;
        if (weakReference != null && view == weakReference.get() && this.W) {
            if (this.V > 0) {
                if (this.u) {
                    i3 = this.K;
                } else {
                    int top = v.getTop();
                    int i5 = this.L;
                    if (top > i5) {
                        i3 = i5;
                        i4 = 6;
                    } else {
                        i3 = this.J;
                    }
                }
            } else if (this.P && Z(v, A())) {
                i3 = this.Z;
                i4 = 5;
            } else if (this.V == 0) {
                int top2 = v.getTop();
                if (!this.u) {
                    int i6 = this.L;
                    if (top2 < i6) {
                        if (top2 < Math.abs(top2 - this.N)) {
                            i3 = this.J;
                        } else {
                            i3 = this.L;
                        }
                    } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.N)) {
                        i3 = this.L;
                    } else {
                        i3 = this.N;
                        i4 = 4;
                    }
                    i4 = 6;
                } else if (Math.abs(top2 - this.K) < Math.abs(top2 - this.N)) {
                    i3 = this.K;
                } else {
                    i3 = this.N;
                    i4 = 4;
                }
            } else {
                if (this.u) {
                    i3 = this.N;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.L) < Math.abs(top3 - this.N)) {
                        i3 = this.L;
                        i4 = 6;
                    } else {
                        i3 = this.N;
                    }
                }
                i4 = 4;
            }
            a0(v, i4, i3, false);
            this.W = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.S == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.T;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            G();
        }
        if (this.d0 == null) {
            this.d0 = VelocityTracker.obtain();
        }
        this.d0.addMovement(motionEvent);
        if (this.T != null && actionMasked == 2 && !this.U && Math.abs(this.f0 - motionEvent.getY()) > this.T.getTouchSlop()) {
            this.T.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.U;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void p() {
        this.I = null;
    }

    void q(int i2) {
        float f2;
        float f3;
        V v = this.a0.get();
        if (v == null || this.c0.isEmpty()) {
            return;
        }
        int i3 = this.N;
        if (i2 > i3 || i3 == t()) {
            int i4 = this.N;
            f2 = i4 - i2;
            f3 = this.Z - i4;
        } else {
            int i5 = this.N;
            f2 = i5 - i2;
            f3 = i5 - t();
        }
        float f4 = f2 / f3;
        for (int i6 = 0; i6 < this.c0.size(); i6++) {
            this.c0.get(i6).a(v, f4);
        }
    }

    @Nullable
    @VisibleForTesting
    View r(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View r2 = r(viewGroup.getChildAt(i2));
            if (r2 != null) {
                return r2;
            }
        }
        return null;
    }

    public int t() {
        return this.u ? this.K : this.J;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float u() {
        return this.M;
    }

    public int v() {
        if (this.y) {
            return -1;
        }
        return this.x;
    }

    @VisibleForTesting
    int w() {
        return this.z;
    }

    public int x() {
        return this.t;
    }

    public boolean y() {
        return this.Q;
    }

    public int z() {
        return this.S;
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.t = 0;
        this.u = true;
        this.v = false;
        this.H = null;
        this.M = 0.5f;
        this.O = -1.0f;
        this.R = true;
        this.S = 4;
        this.c0 = new ArrayList<>();
        this.i0 = new d();
        this.A = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.B = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i3 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i3);
        if (hasValue) {
            n(context, attributeSet, hasValue, com.google.android.material.g.c.a(context, obtainStyledAttributes, i3));
        } else {
            m(context, attributeSet, hasValue);
        }
        o();
        if (Build.VERSION.SDK_INT >= 21) {
            this.O = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        int i4 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i4);
        if (peekValue != null && (i2 = peekValue.data) == -1) {
            P(i2);
        } else {
            P(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        }
        O(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        M(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        L(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        S(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        J(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        R(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        N(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i5 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i5);
        if (peekValue2 != null && peekValue2.type == 16) {
            K(peekValue2.data);
        } else {
            K(obtainStyledAttributes.getDimensionPixelOffset(i5, 0));
        }
        obtainStyledAttributes.recycle();
        this.w = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
