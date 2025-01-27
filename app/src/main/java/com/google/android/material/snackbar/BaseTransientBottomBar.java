package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {

    /* renamed from: a */
    public static final int f7735a = 0;

    /* renamed from: b */
    public static final int f7736b = 1;

    /* renamed from: c */
    public static final int f7737c = -2;

    /* renamed from: d */
    public static final int f7738d = -1;

    /* renamed from: e */
    public static final int f7739e = 0;

    /* renamed from: f */
    static final int f7740f = 250;

    /* renamed from: g */
    static final int f7741g = 180;

    /* renamed from: h */
    private static final int f7742h = 150;

    /* renamed from: i */
    private static final int f7743i = 75;

    /* renamed from: j */
    private static final float f7744j = 0.8f;

    @NonNull
    static final Handler k;
    static final int l = 0;
    static final int m = 1;
    private static final boolean n;
    private static final int[] o;
    private static final String p;
    private int A;
    private int B;
    private int C;
    private int D;
    private List<s<B>> E;
    private Behavior F;

    @Nullable
    private final AccessibilityManager G;

    @NonNull
    private final ViewGroup q;
    private final Context r;

    @NonNull
    protected final y s;

    @NonNull
    private final com.google.android.material.snackbar.a t;
    private int u;
    private boolean v;

    @Nullable
    private View w;

    @Nullable
    private Rect y;
    private int z;

    @RequiresApi(29)
    private final Runnable x = new j();

    @NonNull
    b.InterfaceC0099b H = new m();

    public static class Behavior extends SwipeDismissBehavior<View> {

        @NonNull
        private final t t = new t(this);

        public void p(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.t.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean a(View view) {
            return this.t.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            this.t.b(coordinatorLayout, view, motionEvent);
            return super.onInterceptTouchEvent(coordinatorLayout, view, motionEvent);
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.O();
        }
    }

    class b extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ int f7746a;

        b(int i2) {
            this.f7746a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.N(this.f7746a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.s.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.s.setScaleX(floatValue);
            BaseTransientBottomBar.this.s.setScaleY(floatValue);
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.O();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.t.a(70, 180);
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        private int f7751a;

        /* renamed from: b */
        final /* synthetic */ int f7752b;

        f(int i2) {
            this.f7752b = i2;
            this.f7751a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.n) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.s, intValue - this.f7751a);
            } else {
                BaseTransientBottomBar.this.s.setTranslationY(intValue);
            }
            this.f7751a = intValue;
        }
    }

    class g extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ int f7754a;

        g(int i2) {
            this.f7754a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.N(this.f7754a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.t.b(0, 180);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        private int f7756a = 0;

        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.n) {
                ViewCompat.offsetTopAndBottom(BaseTransientBottomBar.this.s, intValue - this.f7756a);
            } else {
                BaseTransientBottomBar.this.s.setTranslationY(intValue);
            }
            this.f7756a = intValue;
        }
    }

    static class i implements Handler.Callback {
        i() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).a0();
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).I(message.arg1);
            return true;
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int C;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.s == null || baseTransientBottomBar.r == null || (C = (BaseTransientBottomBar.this.C() - BaseTransientBottomBar.this.G()) + ((int) BaseTransientBottomBar.this.s.getTranslationY())) >= BaseTransientBottomBar.this.C) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.s.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.p, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.C - C;
            BaseTransientBottomBar.this.s.requestLayout();
        }
    }

    class k implements OnApplyWindowInsetsListener {
        k() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            BaseTransientBottomBar.this.z = windowInsetsCompat.getSystemWindowInsetBottom();
            BaseTransientBottomBar.this.A = windowInsetsCompat.getSystemWindowInsetLeft();
            BaseTransientBottomBar.this.B = windowInsetsCompat.getSystemWindowInsetRight();
            BaseTransientBottomBar.this.g0();
            return windowInsetsCompat;
        }
    }

    class l extends AccessibilityDelegateCompat {
        l() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(1048576);
            accessibilityNodeInfoCompat.setDismissable(true);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 != 1048576) {
                return super.performAccessibilityAction(view, i2, bundle);
            }
            BaseTransientBottomBar.this.t();
            return true;
        }
    }

    class m implements b.InterfaceC0099b {
        m() {
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0099b
        public void a(int i2) {
            Handler handler = BaseTransientBottomBar.k;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0099b
        public void show() {
            Handler handler = BaseTransientBottomBar.k;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    class n implements w {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.N(3);
            }
        }

        n() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.s.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.C = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.g0();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.w
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.L()) {
                BaseTransientBottomBar.k.post(new a());
            }
        }
    }

    class o implements x {
        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.x
        public void a(View view, int i2, int i3, int i4, int i5) {
            BaseTransientBottomBar.this.s.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.b0();
        }
    }

    class p implements SwipeDismissBehavior.c {
        p() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(@NonNull View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.u(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i2) {
            if (i2 == 0) {
                com.google.android.material.snackbar.b.c().l(BaseTransientBottomBar.this.H);
            } else if (i2 == 1 || i2 == 2) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.H);
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            y yVar = BaseTransientBottomBar.this.s;
            if (yVar == null) {
                return;
            }
            yVar.setVisibility(0);
            if (BaseTransientBottomBar.this.s.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.c0();
            } else {
                BaseTransientBottomBar.this.e0();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface r {
    }

    public static abstract class s<B> {

        /* renamed from: a */
        public static final int f7767a = 0;

        /* renamed from: b */
        public static final int f7768b = 1;

        /* renamed from: c */
        public static final int f7769c = 2;

        /* renamed from: d */
        public static final int f7770d = 3;

        /* renamed from: e */
        public static final int f7771e = 4;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface a {
        }

        public void a(B b2, int i2) {
        }

        public void b(B b2) {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class t {

        /* renamed from: a */
        private b.InterfaceC0099b f7772a;

        public t(@NonNull SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.l(0.1f);
            swipeDismissBehavior.i(0.6f);
            swipeDismissBehavior.m(0);
        }

        public boolean a(View view) {
            return view instanceof y;
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.isPointInChildBounds(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().k(this.f7772a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().l(this.f7772a);
            }
        }

        public void c(@NonNull BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f7772a = baseTransientBottomBar.H;
        }
    }

    @Deprecated
    public interface u extends com.google.android.material.snackbar.a {
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface v {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected interface w {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected interface x {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected static class y extends FrameLayout {

        /* renamed from: a */
        private static final View.OnTouchListener f7773a = new a();

        /* renamed from: b */
        private x f7774b;

        /* renamed from: c */
        private w f7775c;

        /* renamed from: d */
        private int f7776d;

        /* renamed from: e */
        private final float f7777e;

        /* renamed from: f */
        private final float f7778f;

        /* renamed from: g */
        private ColorStateList f7779g;

        /* renamed from: h */
        private PorterDuff.Mode f7780h;

        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected y(@NonNull Context context) {
            this(context, null);
        }

        @NonNull
        private Drawable a() {
            float dimension = getResources().getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(com.google.android.material.c.a.i(this, R.attr.colorSurface, R.attr.colorOnSurface, getBackgroundOverlayColorAlpha()));
            if (this.f7779g == null) {
                return DrawableCompat.wrap(gradientDrawable);
            }
            Drawable wrap = DrawableCompat.wrap(gradientDrawable);
            DrawableCompat.setTintList(wrap, this.f7779g);
            return wrap;
        }

        float getActionTextColorAlpha() {
            return this.f7778f;
        }

        int getAnimationMode() {
            return this.f7776d;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f7777e;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            w wVar = this.f7775c;
            if (wVar != null) {
                wVar.onViewAttachedToWindow(this);
            }
            ViewCompat.requestApplyInsets(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            w wVar = this.f7775c;
            if (wVar != null) {
                wVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            x xVar = this.f7774b;
            if (xVar != null) {
                xVar.a(this, i2, i3, i4, i5);
            }
        }

        void setAnimationMode(int i2) {
            this.f7776d = i2;
        }

        @Override // android.view.View
        public void setBackground(@Nullable Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(@Nullable Drawable drawable) {
            if (drawable != null && this.f7779g != null) {
                drawable = DrawableCompat.wrap(drawable.mutate());
                DrawableCompat.setTintList(drawable, this.f7779g);
                DrawableCompat.setTintMode(drawable, this.f7780h);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            this.f7779g = colorStateList;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintList(wrap, colorStateList);
                DrawableCompat.setTintMode(wrap, this.f7780h);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            this.f7780h = mode;
            if (getBackground() != null) {
                Drawable wrap = DrawableCompat.wrap(getBackground().mutate());
                DrawableCompat.setTintMode(wrap, mode);
                if (wrap != getBackground()) {
                    super.setBackgroundDrawable(wrap);
                }
            }
        }

        void setOnAttachStateChangeListener(w wVar) {
            this.f7775c = wVar;
        }

        @Override // android.view.View
        public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f7773a);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(x xVar) {
            this.f7774b = xVar;
        }

        protected y(@NonNull Context context, AttributeSet attributeSet) {
            super(com.google.android.material.theme.a.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(R.styleable.SnackbarLayout_elevation)) {
                ViewCompat.setElevation(this, obtainStyledAttributes.getDimensionPixelSize(r1, 0));
            }
            this.f7776d = obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_animationMode, 0);
            this.f7777e = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(com.google.android.material.g.c.a(context2, obtainStyledAttributes, R.styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(com.google.android.material.internal.u.j(obtainStyledAttributes.getInt(R.styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f7778f = obtainStyledAttributes.getFloat(R.styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f7773a);
            setFocusable(true);
            if (getBackground() == null) {
                ViewCompat.setBackground(this, a());
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        n = i2 >= 16 && i2 <= 19;
        o = new int[]{R.attr.snackbarStyle};
        p = BaseTransientBottomBar.class.getSimpleName();
        k = new Handler(Looper.getMainLooper(), new i());
    }

    protected BaseTransientBottomBar(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.q = viewGroup;
        this.t = aVar;
        Context context = viewGroup.getContext();
        this.r = context;
        com.google.android.material.internal.n.a(context);
        y yVar = (y) LayoutInflater.from(context).inflate(D(), viewGroup, false);
        this.s = yVar;
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).c(yVar.getActionTextColorAlpha());
        }
        yVar.addView(view);
        ViewGroup.LayoutParams layoutParams = yVar.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.y = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        ViewCompat.setAccessibilityLiveRegion(yVar, 1);
        ViewCompat.setImportantForAccessibility(yVar, 1);
        ViewCompat.setFitsSystemWindows(yVar, true);
        ViewCompat.setOnApplyWindowInsetsListener(yVar, new k());
        ViewCompat.setAccessibilityDelegate(yVar, new l());
        this.G = (AccessibilityManager) context.getSystemService("accessibility");
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.a.a.f6610d);
        ofFloat.addUpdateListener(new d());
        return ofFloat;
    }

    @RequiresApi(17)
    public int C() {
        WindowManager windowManager = (WindowManager) this.r.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int E() {
        int height = this.s.getHeight();
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public int G() {
        int[] iArr = new int[2];
        this.s.getLocationOnScreen(iArr);
        return iArr[1] + this.s.getHeight();
    }

    private boolean M() {
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof SwipeDismissBehavior);
    }

    private void W(CoordinatorLayout.LayoutParams layoutParams) {
        SwipeDismissBehavior<? extends View> swipeDismissBehavior = this.F;
        if (swipeDismissBehavior == null) {
            swipeDismissBehavior = A();
        }
        if (swipeDismissBehavior instanceof Behavior) {
            ((Behavior) swipeDismissBehavior).p(this);
        }
        swipeDismissBehavior.j(new p());
        layoutParams.setBehavior(swipeDismissBehavior);
        if (this.w == null) {
            layoutParams.insetEdge = 80;
        }
    }

    private boolean Y() {
        return this.C > 0 && !this.v && M();
    }

    public void b0() {
        if (X()) {
            q();
        } else {
            this.s.setVisibility(0);
            O();
        }
    }

    public void c0() {
        ValueAnimator v2 = v(0.0f, 1.0f);
        ValueAnimator B = B(f7744j, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(v2, B);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    private void d0(int i2) {
        ValueAnimator v2 = v(1.0f, 0.0f);
        v2.setDuration(75L);
        v2.addListener(new b(i2));
        v2.start();
    }

    public void e0() {
        int E = E();
        if (n) {
            ViewCompat.offsetTopAndBottom(this.s, E);
        } else {
            this.s.setTranslationY(E);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(E, 0);
        valueAnimator.setInterpolator(com.google.android.material.a.a.f6608b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new e());
        valueAnimator.addUpdateListener(new f(E));
        valueAnimator.start();
    }

    private void f0(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, E());
        valueAnimator.setInterpolator(com.google.android.material.a.a.f6608b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new g(i2));
        valueAnimator.addUpdateListener(new h());
        valueAnimator.start();
    }

    public void g0() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.y) == null) {
            Log.w(p, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + (this.w != null ? this.D : this.z);
        marginLayoutParams.leftMargin = rect.left + this.A;
        marginLayoutParams.rightMargin = rect.right + this.B;
        this.s.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !Y()) {
            return;
        }
        this.s.removeCallbacks(this.x);
        this.s.post(this.x);
    }

    private void r(int i2) {
        if (this.s.getAnimationMode() == 1) {
            d0(i2);
        } else {
            f0(i2);
        }
    }

    private int s() {
        View view = this.w;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.q.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.q.getHeight()) - i2;
    }

    private ValueAnimator v(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(com.google.android.material.a.a.f6607a);
        ofFloat.addUpdateListener(new c());
        return ofFloat;
    }

    @NonNull
    protected SwipeDismissBehavior<? extends View> A() {
        return new Behavior();
    }

    @LayoutRes
    protected int D() {
        return H() ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar;
    }

    @NonNull
    public View F() {
        return this.s;
    }

    protected boolean H() {
        TypedArray obtainStyledAttributes = this.r.obtainStyledAttributes(o);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void I(int i2) {
        if (X() && this.s.getVisibility() == 0) {
            r(i2);
        } else {
            N(i2);
        }
    }

    public boolean J() {
        return this.v;
    }

    public boolean K() {
        return com.google.android.material.snackbar.b.c().e(this.H);
    }

    public boolean L() {
        return com.google.android.material.snackbar.b.c().f(this.H);
    }

    void N(int i2) {
        com.google.android.material.snackbar.b.c().i(this.H);
        List<s<B>> list = this.E;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.E.get(size).a(this, i2);
            }
        }
        ViewParent parent = this.s.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.s);
        }
    }

    void O() {
        com.google.android.material.snackbar.b.c().j(this.H);
        List<s<B>> list = this.E;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.E.get(size).b(this);
            }
        }
    }

    @NonNull
    public B P(@Nullable s<B> sVar) {
        List<s<B>> list;
        if (sVar == null || (list = this.E) == null) {
            return this;
        }
        list.remove(sVar);
        return this;
    }

    @NonNull
    public B Q(@IdRes int i2) {
        View findViewById = this.q.findViewById(i2);
        this.w = findViewById;
        if (findViewById != null) {
            return this;
        }
        throw new IllegalArgumentException("Unable to find anchor view with id: " + i2);
    }

    @NonNull
    public B R(@Nullable View view) {
        this.w = view;
        return this;
    }

    @NonNull
    public B S(int i2) {
        this.s.setAnimationMode(i2);
        return this;
    }

    @NonNull
    public B T(Behavior behavior) {
        this.F = behavior;
        return this;
    }

    @NonNull
    public B U(int i2) {
        this.u = i2;
        return this;
    }

    @NonNull
    public B V(boolean z) {
        this.v = z;
        return this;
    }

    boolean X() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.G.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void Z() {
        com.google.android.material.snackbar.b.c().n(z(), this.H);
    }

    final void a0() {
        this.s.setOnAttachStateChangeListener(new n());
        if (this.s.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                W((CoordinatorLayout.LayoutParams) layoutParams);
            }
            this.D = s();
            g0();
            this.s.setVisibility(4);
            this.q.addView(this.s);
        }
        if (ViewCompat.isLaidOut(this.s)) {
            b0();
        } else {
            this.s.setOnLayoutChangeListener(new o());
        }
    }

    @NonNull
    public Context getContext() {
        return this.r;
    }

    @NonNull
    public B p(@Nullable s<B> sVar) {
        if (sVar == null) {
            return this;
        }
        if (this.E == null) {
            this.E = new ArrayList();
        }
        this.E.add(sVar);
        return this;
    }

    void q() {
        this.s.post(new q());
    }

    public void t() {
        u(3);
    }

    protected void u(int i2) {
        com.google.android.material.snackbar.b.c().b(this.H, i2);
    }

    @Nullable
    public View w() {
        return this.w;
    }

    public int x() {
        return this.s.getAnimationMode();
    }

    public Behavior y() {
        return this.F;
    }

    public int z() {
        return this.u;
    }
}
