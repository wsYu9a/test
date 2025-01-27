package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: a */
    private static final int f6668a = R.style.Widget_Design_CollapsingToolbar;

    /* renamed from: b */
    private static final int f6669b = 600;

    /* renamed from: c */
    private boolean f6670c;

    /* renamed from: d */
    private int f6671d;

    /* renamed from: e */
    @Nullable
    private Toolbar f6672e;

    /* renamed from: f */
    @Nullable
    private View f6673f;

    /* renamed from: g */
    private View f6674g;

    /* renamed from: h */
    private int f6675h;

    /* renamed from: i */
    private int f6676i;

    /* renamed from: j */
    private int f6677j;
    private int k;
    private final Rect l;

    @NonNull
    final com.google.android.material.internal.a m;
    private boolean n;
    private boolean o;

    @Nullable
    private Drawable p;

    @Nullable
    Drawable q;
    private int r;
    private boolean s;
    private ValueAnimator t;
    private long u;
    private int v;
    private AppBarLayout.d w;
    int x;

    @Nullable
    WindowInsetsCompat y;

    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            return CollapsingToolbarLayout.this.k(windowInsetsCompat);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private class c implements AppBarLayout.d {
        c() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.d, com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i2) {
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.x = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.y;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                com.google.android.material.appbar.a h2 = CollapsingToolbarLayout.h(childAt);
                int i4 = layoutParams.f6682e;
                if (i4 == 1) {
                    h2.k(MathUtils.clamp(-i2, 0, CollapsingToolbarLayout.this.g(childAt)));
                } else if (i4 == 2) {
                    h2.k(Math.round((-i2) * layoutParams.f6683f));
                }
            }
            CollapsingToolbarLayout.this.p();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.q != null && systemWindowInsetTop > 0) {
                ViewCompat.postInvalidateOnAnimation(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.m.h0(Math.abs(i2) / ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this)) - systemWindowInsetTop));
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }

    private void a(int i2) {
        b();
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.t = valueAnimator2;
            valueAnimator2.setDuration(this.u);
            this.t.setInterpolator(i2 > this.r ? com.google.android.material.a.a.f6609c : com.google.android.material.a.a.f6610d);
            this.t.addUpdateListener(new b());
        } else if (valueAnimator.isRunning()) {
            this.t.cancel();
        }
        this.t.setIntValues(this.r, i2);
        this.t.start();
    }

    private void b() {
        if (this.f6670c) {
            Toolbar toolbar = null;
            this.f6672e = null;
            this.f6673f = null;
            int i2 = this.f6671d;
            if (i2 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i2);
                this.f6672e = toolbar2;
                if (toolbar2 != null) {
                    this.f6673f = c(toolbar2);
                }
            }
            if (this.f6672e == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i3++;
                }
                this.f6672e = toolbar;
            }
            o();
            this.f6670c = false;
        }
    }

    @NonNull
    private View c(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    private static int f(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @NonNull
    static com.google.android.material.appbar.a h(@NonNull View view) {
        int i2 = R.id.view_offset_helper;
        com.google.android.material.appbar.a aVar = (com.google.android.material.appbar.a) view.getTag(i2);
        if (aVar != null) {
            return aVar;
        }
        com.google.android.material.appbar.a aVar2 = new com.google.android.material.appbar.a(view);
        view.setTag(i2, aVar2);
        return aVar2;
    }

    private boolean j(View view) {
        View view2 = this.f6673f;
        if (view2 == null || view2 == this) {
            if (view == this.f6672e) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void n() {
        setContentDescription(getTitle());
    }

    private void o() {
        View view;
        if (!this.n && (view = this.f6674g) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f6674g);
            }
        }
        if (!this.n || this.f6672e == null) {
            return;
        }
        if (this.f6674g == null) {
            this.f6674g = new View(getContext());
        }
        if (this.f6674g.getParent() == null) {
            this.f6672e.addView(this.f6674g, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: d */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f6672e == null && (drawable = this.p) != null && this.r > 0) {
            drawable.mutate().setAlpha(this.r);
            this.p.draw(canvas);
        }
        if (this.n && this.o) {
            this.m.j(canvas);
        }
        if (this.q == null || this.r <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.q.setBounds(0, -this.x, getWidth(), systemWindowInsetTop - this.x);
            this.q.mutate().setAlpha(this.r);
            this.q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.p == null || this.r <= 0 || !j(view)) {
            z = false;
        } else {
            this.p.mutate().setAlpha(this.r);
            this.p.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j2) || z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.p;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.a aVar = this.m;
        if (aVar != null) {
            z |= aVar.l0(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    /* renamed from: e */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    final int g(@NonNull View view) {
        return ((getHeight() - h(view).c()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public int getCollapsedTitleGravity() {
        return this.m.o();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.m.t();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.p;
    }

    public int getExpandedTitleGravity() {
        return this.m.y();
    }

    public int getExpandedTitleMarginBottom() {
        return this.k;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f6677j;
    }

    public int getExpandedTitleMarginStart() {
        return this.f6675h;
    }

    public int getExpandedTitleMarginTop() {
        return this.f6676i;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.m.B();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.m.D();
    }

    int getScrimAlpha() {
        return this.r;
    }

    public long getScrimAnimationDuration() {
        return this.u;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.v;
        if (i2 >= 0) {
            return i2;
        }
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.q;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.n) {
            return this.m.E();
        }
        return null;
    }

    public boolean i() {
        return this.n;
    }

    WindowInsetsCompat k(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.y, windowInsetsCompat2)) {
            this.y = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void l(int i2, int i3, int i4, int i5) {
        this.f6675h = i2;
        this.f6676i = i3;
        this.f6677j = i4;
        this.k = i5;
        requestLayout();
    }

    public void m(boolean z, boolean z2) {
        if (this.s != z) {
            if (z2) {
                a(z ? 255 : 0);
            } else {
                setScrimAlpha(z ? 255 : 0);
            }
            this.s = z;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View) parent));
            if (this.w == null) {
                this.w = new c();
            }
            ((AppBarLayout) parent).b(this.w);
            ViewCompat.requestApplyInsets(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.d dVar = this.w;
        if (dVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).p(dVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.y;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!ViewCompat.getFitsSystemWindows(childAt) && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            h(getChildAt(i7)).h();
        }
        if (this.n && (view = this.f6674g) != null) {
            boolean z2 = ViewCompat.isAttachedToWindow(view) && this.f6674g.getVisibility() == 0;
            this.o = z2;
            if (z2) {
                boolean z3 = ViewCompat.getLayoutDirection(this) == 1;
                View view2 = this.f6673f;
                if (view2 == null) {
                    view2 = this.f6672e;
                }
                int g2 = g(view2);
                com.google.android.material.internal.c.a(this, this.f6674g, this.l);
                this.m.P(this.l.left + (z3 ? this.f6672e.getTitleMarginEnd() : this.f6672e.getTitleMarginStart()), this.l.top + g2 + this.f6672e.getTitleMarginTop(), this.l.right - (z3 ? this.f6672e.getTitleMarginStart() : this.f6672e.getTitleMarginEnd()), (this.l.bottom + g2) - this.f6672e.getTitleMarginBottom());
                this.m.Y(z3 ? this.f6677j : this.f6675h, this.l.top + this.f6676i, (i4 - i2) - (z3 ? this.f6675h : this.f6677j), (i5 - i3) - this.k);
                this.m.N();
            }
        }
        if (this.f6672e != null) {
            if (this.n && TextUtils.isEmpty(this.m.E())) {
                setTitle(this.f6672e.getTitle());
            }
            View view3 = this.f6673f;
            if (view3 == null || view3 == this) {
                setMinimumHeight(f(this.f6672e));
            } else {
                setMinimumHeight(f(view3));
            }
        }
        p();
        int childCount3 = getChildCount();
        for (int i8 = 0; i8 < childCount3; i8++) {
            h(getChildAt(i8)).a();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        WindowInsetsCompat windowInsetsCompat = this.y;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (mode != 0 || systemWindowInsetTop <= 0) {
            return;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, 1073741824));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    final void p() {
        if (this.p == null && this.q == null) {
            return;
        }
        setScrimsShown(getHeight() + this.x < getScrimVisibleHeightTrigger());
    }

    public void setCollapsedTitleGravity(int i2) {
        this.m.U(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.m.R(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.m.W(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.p = mutate;
            if (mutate != null) {
                mutate.setBounds(0, 0, getWidth(), getHeight());
                this.p.setCallback(this);
                this.p.setAlpha(this.r);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.m.d0(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.k = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f6677j = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f6675h = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f6676i = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.m.a0(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.m.c0(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.m.f0(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        this.m.j0(i2);
    }

    void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.r) {
            if (this.p != null && (toolbar = this.f6672e) != null) {
                ViewCompat.postInvalidateOnAnimation(toolbar);
            }
            this.r = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.u = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.v != i2) {
            this.v = i2;
            p();
        }
    }

    public void setScrimsShown(boolean z) {
        m(z, ViewCompat.isLaidOut(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.q = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.q, ViewCompat.getLayoutDirection(this));
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
                this.q.setAlpha(this.r);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.m.m0(charSequence);
        n();
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            n();
            o();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.q;
        if (drawable != null && drawable.isVisible() != z) {
            this.q.setVisible(z, false);
        }
        Drawable drawable2 = this.p;
        if (drawable2 == null || drawable2.isVisible() == z) {
            return;
        }
        this.p.setVisible(z, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p || drawable == this.q;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.m.T(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a */
        private static final float f6678a = 0.5f;

        /* renamed from: b */
        public static final int f6679b = 0;

        /* renamed from: c */
        public static final int f6680c = 1;

        /* renamed from: d */
        public static final int f6681d = 2;

        /* renamed from: e */
        int f6682e;

        /* renamed from: f */
        float f6683f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6682e = 0;
            this.f6683f = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.f6682e = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            d(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f6682e;
        }

        public float b() {
            return this.f6683f;
        }

        public void c(int i2) {
            this.f6682e = i2;
        }

        public void d(float f2) {
            this.f6683f = f2;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f6682e = 0;
            this.f6683f = 0.5f;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3, i4);
            this.f6682e = 0;
            this.f6683f = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6682e = 0;
            this.f6683f = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6682e = 0;
            this.f6683f = 0.5f;
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6682e = 0;
            this.f6683f = 0.5f;
        }
    }
}
