package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.u;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {

    /* renamed from: b */
    @Dimension(unit = 0)
    private static final int f7808b = 72;

    /* renamed from: c */
    @Dimension(unit = 0)
    static final int f7809c = 8;

    /* renamed from: d */
    @Dimension(unit = 0)
    private static final int f7810d = 48;

    /* renamed from: e */
    @Dimension(unit = 0)
    private static final int f7811e = 56;

    /* renamed from: f */
    @Dimension(unit = 0)
    private static final int f7812f = 24;

    /* renamed from: g */
    @Dimension(unit = 0)
    static final int f7813g = 16;

    /* renamed from: h */
    private static final int f7814h = -1;

    /* renamed from: i */
    private static final int f7815i = 300;
    private static final String k = "TabLayout";
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 0;
    public static final int r = 1;
    public static final int s = 2;
    public static final int t = 0;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;

    @NonNull
    final h A;
    int B;
    int C;
    int D;
    int E;
    int F;
    ColorStateList G;
    ColorStateList H;
    ColorStateList I;

    @Nullable
    Drawable J;
    PorterDuff.Mode K;
    float L;
    float M;
    final int N;
    int O;
    private final int P;
    private final int Q;
    private final int R;
    private int S;
    int T;
    int U;
    int V;
    int W;
    boolean a0;
    boolean b0;
    boolean c0;

    @Nullable
    private c d0;
    private final ArrayList<c> e0;

    @Nullable
    private c f0;
    private ValueAnimator g0;

    @Nullable
    ViewPager h0;

    @Nullable
    private PagerAdapter i0;
    private DataSetObserver j0;
    private l k0;
    private b l0;
    private boolean m0;
    private final Pools.Pool<m> n0;
    private final ArrayList<i> x;

    @Nullable
    private i y;
    private final RectF z;

    /* renamed from: a */
    private static final int f7807a = R.style.Widget_Design_TabLayout;

    /* renamed from: j */
    private static final Pools.Pool<i> f7816j = new Pools.SynchronizedPool(16);

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    private class b implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a */
        private boolean f7818a;

        b() {
        }

        void a(boolean z) {
            this.f7818a = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.h0 == viewPager) {
                tabLayout.N(pagerAdapter2, this.f7818a);
            }
        }
    }

    @Deprecated
    public interface c<T extends i> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface e {
    }

    public interface f extends c<i> {
    }

    private class g extends DataSetObserver {
        g() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.D();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.D();
        }
    }

    class h extends LinearLayout {

        /* renamed from: a */
        private int f7821a;

        /* renamed from: b */
        @NonNull
        private final Paint f7822b;

        /* renamed from: c */
        @NonNull
        private final GradientDrawable f7823c;

        /* renamed from: d */
        int f7824d;

        /* renamed from: e */
        float f7825e;

        /* renamed from: f */
        private int f7826f;

        /* renamed from: g */
        int f7827g;

        /* renamed from: h */
        int f7828h;

        /* renamed from: i */
        ValueAnimator f7829i;

        /* renamed from: j */
        private int f7830j;
        private int k;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a */
            final /* synthetic */ int f7831a;

            /* renamed from: b */
            final /* synthetic */ int f7832b;

            a(int i2, int i3) {
                this.f7831a = i2;
                this.f7832b = i3;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                h hVar = h.this;
                hVar.g(com.google.android.material.a.a.b(hVar.f7830j, this.f7831a, animatedFraction), com.google.android.material.a.a.b(h.this.k, this.f7832b, animatedFraction));
            }
        }

        class b extends AnimatorListenerAdapter {

            /* renamed from: a */
            final /* synthetic */ int f7834a;

            b(int i2) {
                this.f7834a = i2;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h hVar = h.this;
                hVar.f7824d = this.f7834a;
                hVar.f7825e = 0.0f;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                h.this.f7824d = this.f7834a;
            }
        }

        h(Context context) {
            super(context);
            this.f7824d = -1;
            this.f7826f = -1;
            this.f7827g = -1;
            this.f7828h = -1;
            this.f7830j = -1;
            this.k = -1;
            setWillNotDraw(false);
            this.f7822b = new Paint();
            this.f7823c = new GradientDrawable();
        }

        private void d(@NonNull m mVar, @NonNull RectF rectF) {
            int contentWidth = mVar.getContentWidth();
            int d2 = (int) u.d(getContext(), 24);
            if (contentWidth < d2) {
                contentWidth = d2;
            }
            int left = (mVar.getLeft() + mVar.getRight()) / 2;
            int i2 = contentWidth / 2;
            rectF.set(left - i2, 0.0f, left + i2, 0.0f);
        }

        private void k() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f7824d);
            if (childAt == null || childAt.getWidth() <= 0) {
                i2 = -1;
                i3 = -1;
            } else {
                i2 = childAt.getLeft();
                i3 = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.b0 && (childAt instanceof m)) {
                    d((m) childAt, tabLayout.z);
                    i2 = (int) TabLayout.this.z.left;
                    i3 = (int) TabLayout.this.z.right;
                }
                if (this.f7825e > 0.0f && this.f7824d < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f7824d + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.b0 && (childAt2 instanceof m)) {
                        d((m) childAt2, tabLayout2.z);
                        left = (int) TabLayout.this.z.left;
                        right = (int) TabLayout.this.z.right;
                    }
                    float f2 = this.f7825e;
                    i2 = (int) ((left * f2) + ((1.0f - f2) * i2));
                    i3 = (int) ((right * f2) + ((1.0f - f2) * i3));
                }
            }
            g(i2, i3);
        }

        private void l(boolean z, int i2, int i3) {
            View childAt = getChildAt(i2);
            if (childAt == null) {
                k();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.b0 && (childAt instanceof m)) {
                d((m) childAt, tabLayout.z);
                left = (int) TabLayout.this.z.left;
                right = (int) TabLayout.this.z.right;
            }
            int i4 = this.f7827g;
            int i5 = this.f7828h;
            if (i4 == left && i5 == right) {
                return;
            }
            if (z) {
                this.f7830j = i4;
                this.k = i5;
            }
            a aVar = new a(left, right);
            if (!z) {
                this.f7829i.removeAllUpdateListeners();
                this.f7829i.addUpdateListener(aVar);
                return;
            }
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f7829i = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.a.a.f6608b);
            valueAnimator.setDuration(i3);
            valueAnimator.setFloatValues(0.0f, 1.0f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.addListener(new b(i2));
            valueAnimator.start();
        }

        void c(int i2, int i3) {
            ValueAnimator valueAnimator = this.f7829i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f7829i.cancel();
            }
            l(true, i2, i3);
        }

        @Override // android.view.View
        public void draw(@NonNull Canvas canvas) {
            Drawable drawable = TabLayout.this.J;
            int i2 = 0;
            int intrinsicHeight = drawable != null ? drawable.getIntrinsicHeight() : 0;
            int i3 = this.f7821a;
            if (i3 >= 0) {
                intrinsicHeight = i3;
            }
            int i4 = TabLayout.this.V;
            if (i4 == 0) {
                i2 = getHeight() - intrinsicHeight;
                intrinsicHeight = getHeight();
            } else if (i4 == 1) {
                i2 = (getHeight() - intrinsicHeight) / 2;
                intrinsicHeight = (getHeight() + intrinsicHeight) / 2;
            } else if (i4 != 2) {
                intrinsicHeight = i4 != 3 ? 0 : getHeight();
            }
            int i5 = this.f7827g;
            if (i5 >= 0 && this.f7828h > i5) {
                Drawable drawable2 = TabLayout.this.J;
                if (drawable2 == null) {
                    drawable2 = this.f7823c;
                }
                Drawable mutate = DrawableCompat.wrap(drawable2).mutate();
                mutate.setBounds(this.f7827g, i2, this.f7828h, intrinsicHeight);
                Paint paint = this.f7822b;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        mutate.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.setTint(mutate, paint.getColor());
                    }
                }
                mutate.draw(canvas);
            }
            super.draw(canvas);
        }

        boolean e() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        float f() {
            return this.f7824d + this.f7825e;
        }

        void g(int i2, int i3) {
            if (i2 == this.f7827g && i3 == this.f7828h) {
                return;
            }
            this.f7827g = i2;
            this.f7828h = i3;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        void h(int i2, float f2) {
            ValueAnimator valueAnimator = this.f7829i;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f7829i.cancel();
            }
            this.f7824d = i2;
            this.f7825e = f2;
            k();
        }

        void i(int i2) {
            if (this.f7822b.getColor() != i2) {
                this.f7822b.setColor(i2);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void j(int i2) {
            if (this.f7821a != i2) {
                this.f7821a = i2;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f7829i;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                k();
            } else {
                l(false, this.f7824d, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.T == 1 || tabLayout.W == 2) {
                int childCount = getChildCount();
                int i4 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getVisibility() == 0) {
                        i4 = Math.max(i4, childAt.getMeasuredWidth());
                    }
                }
                if (i4 <= 0) {
                    return;
                }
                if (i4 * childCount <= getMeasuredWidth() - (((int) u.d(getContext(), 16)) * 2)) {
                    boolean z2 = false;
                    for (int i6 = 0; i6 < childCount; i6++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                        if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.T = 0;
                    tabLayout2.V(false);
                }
                if (z) {
                    super.onMeasure(i2, i3);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT >= 23 || this.f7826f == i2) {
                return;
            }
            requestLayout();
            this.f7826f = i2;
        }
    }

    public static class i {

        /* renamed from: a */
        public static final int f7836a = -1;

        /* renamed from: b */
        @Nullable
        private Object f7837b;

        /* renamed from: c */
        @Nullable
        private Drawable f7838c;

        /* renamed from: d */
        @Nullable
        private CharSequence f7839d;

        /* renamed from: e */
        @Nullable
        private CharSequence f7840e;

        /* renamed from: g */
        @Nullable
        private View f7842g;

        /* renamed from: i */
        @Nullable
        public TabLayout f7844i;

        /* renamed from: j */
        @NonNull
        public m f7845j;

        /* renamed from: f */
        private int f7841f = -1;

        /* renamed from: h */
        @d
        private int f7843h = 1;

        @NonNull
        public i A(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f7840e) && !TextUtils.isEmpty(charSequence)) {
                this.f7845j.setContentDescription(charSequence);
            }
            this.f7839d = charSequence;
            B();
            return this;
        }

        void B() {
            m mVar = this.f7845j;
            if (mVar != null) {
                mVar.update();
            }
        }

        @Nullable
        public BadgeDrawable d() {
            return this.f7845j.getBadge();
        }

        @Nullable
        public CharSequence e() {
            m mVar = this.f7845j;
            if (mVar == null) {
                return null;
            }
            return mVar.getContentDescription();
        }

        @Nullable
        public View f() {
            return this.f7842g;
        }

        @Nullable
        public Drawable g() {
            return this.f7838c;
        }

        @NonNull
        public BadgeDrawable h() {
            return this.f7845j.getOrCreateBadge();
        }

        public int i() {
            return this.f7841f;
        }

        @d
        public int j() {
            return this.f7843h;
        }

        @Nullable
        public Object k() {
            return this.f7837b;
        }

        @Nullable
        public CharSequence l() {
            return this.f7839d;
        }

        public boolean m() {
            TabLayout tabLayout = this.f7844i;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.f7841f;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void n() {
            this.f7845j.s();
        }

        void o() {
            this.f7844i = null;
            this.f7845j = null;
            this.f7837b = null;
            this.f7838c = null;
            this.f7839d = null;
            this.f7840e = null;
            this.f7841f = -1;
            this.f7842g = null;
        }

        public void p() {
            TabLayout tabLayout = this.f7844i;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.L(this);
        }

        @NonNull
        public i q(@StringRes int i2) {
            TabLayout tabLayout = this.f7844i;
            if (tabLayout != null) {
                return r(tabLayout.getResources().getText(i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public i r(@Nullable CharSequence charSequence) {
            this.f7840e = charSequence;
            B();
            return this;
        }

        @NonNull
        public i s(@LayoutRes int i2) {
            return t(LayoutInflater.from(this.f7845j.getContext()).inflate(i2, (ViewGroup) this.f7845j, false));
        }

        @NonNull
        public i t(@Nullable View view) {
            this.f7842g = view;
            B();
            return this;
        }

        @NonNull
        public i u(@DrawableRes int i2) {
            TabLayout tabLayout = this.f7844i;
            if (tabLayout != null) {
                return v(AppCompatResources.getDrawable(tabLayout.getContext(), i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public i v(@Nullable Drawable drawable) {
            this.f7838c = drawable;
            TabLayout tabLayout = this.f7844i;
            if (tabLayout.T == 1 || tabLayout.W == 2) {
                tabLayout.V(true);
            }
            B();
            if (com.google.android.material.badge.a.f6732a && this.f7845j.p() && this.f7845j.f7853e.isVisible()) {
                this.f7845j.invalidate();
            }
            return this;
        }

        void w(int i2) {
            this.f7841f = i2;
        }

        @NonNull
        public i x(@d int i2) {
            this.f7843h = i2;
            TabLayout tabLayout = this.f7844i;
            if (tabLayout.T == 1 || tabLayout.W == 2) {
                tabLayout.V(true);
            }
            B();
            if (com.google.android.material.badge.a.f6732a && this.f7845j.p() && this.f7845j.f7853e.isVisible()) {
                this.f7845j.invalidate();
            }
            return this;
        }

        @NonNull
        public i y(@Nullable Object obj) {
            this.f7837b = obj;
            return this;
        }

        @NonNull
        public i z(@StringRes int i2) {
            TabLayout tabLayout = this.f7844i;
            if (tabLayout != null) {
                return A(tabLayout.getResources().getText(i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface j {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface k {
    }

    public static class l implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        @NonNull
        private final WeakReference<TabLayout> f7846a;

        /* renamed from: b */
        private int f7847b;

        /* renamed from: c */
        private int f7848c;

        public l(TabLayout tabLayout) {
            this.f7846a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.f7848c = 0;
            this.f7847b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            this.f7847b = this.f7848c;
            this.f7848c = i2;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.f7846a.get();
            if (tabLayout != null) {
                int i4 = this.f7848c;
                tabLayout.P(i2, f2, i4 != 2 || this.f7847b == 1, (i4 == 2 && this.f7847b == 0) ? false : true);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.f7846a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i2 || i2 >= tabLayout.getTabCount()) {
                return;
            }
            int i3 = this.f7848c;
            tabLayout.M(tabLayout.y(i2), i3 == 0 || (i3 == 2 && this.f7847b == 0));
        }
    }

    public final class m extends LinearLayout {

        /* renamed from: a */
        private i f7849a;

        /* renamed from: b */
        private TextView f7850b;

        /* renamed from: c */
        private ImageView f7851c;

        /* renamed from: d */
        @Nullable
        private View f7852d;

        /* renamed from: e */
        @Nullable
        private BadgeDrawable f7853e;

        /* renamed from: f */
        @Nullable
        private View f7854f;

        /* renamed from: g */
        @Nullable
        private TextView f7855g;

        /* renamed from: h */
        @Nullable
        private ImageView f7856h;

        /* renamed from: i */
        @Nullable
        private Drawable f7857i;

        /* renamed from: j */
        private int f7858j;

        class a implements View.OnLayoutChangeListener {

            /* renamed from: a */
            final /* synthetic */ View f7859a;

            a(View view) {
                this.f7859a = view;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                if (this.f7859a.getVisibility() == 0) {
                    m.this.x(this.f7859a);
                }
            }
        }

        public m(@NonNull Context context) {
            super(context);
            this.f7858j = 2;
            y(context);
            ViewCompat.setPaddingRelative(this, TabLayout.this.B, TabLayout.this.C, TabLayout.this.D, TabLayout.this.E);
            setGravity(17);
            setOrientation(!TabLayout.this.a0 ? 1 : 0);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private void A(@Nullable TextView textView, @Nullable ImageView imageView) {
            i iVar = this.f7849a;
            Drawable mutate = (iVar == null || iVar.g() == null) ? null : DrawableCompat.wrap(this.f7849a.g()).mutate();
            i iVar2 = this.f7849a;
            CharSequence l = iVar2 != null ? iVar2.l() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(l);
            if (textView != null) {
                if (z) {
                    textView.setText(l);
                    if (this.f7849a.f7843h == 1) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int d2 = (z && imageView.getVisibility() == 0) ? (int) u.d(getContext(), 8) : 0;
                if (TabLayout.this.a0) {
                    if (d2 != MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) {
                        MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, d2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (d2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = d2;
                    MarginLayoutParamsCompat.setMarginEnd(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            i iVar3 = this.f7849a;
            TooltipCompat.setTooltipText(this, z ? null : iVar3 != null ? iVar3.f7840e : null);
        }

        @Nullable
        public BadgeDrawable getBadge() {
            return this.f7853e;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f7850b, this.f7851c, this.f7854f};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.f7853e == null) {
                this.f7853e = BadgeDrawable.d(getContext());
            }
            w();
            BadgeDrawable badgeDrawable = this.f7853e;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void j(@Nullable View view) {
            if (view == null) {
                return;
            }
            view.addOnLayoutChangeListener(new a(view));
        }

        private float k(@NonNull Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        private void l(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        @NonNull
        private FrameLayout m() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        public void n(@NonNull Canvas canvas) {
            Drawable drawable = this.f7857i;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f7857i.draw(canvas);
            }
        }

        @Nullable
        private FrameLayout o(@NonNull View view) {
            if ((view == this.f7851c || view == this.f7850b) && com.google.android.material.badge.a.f6732a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        public boolean p() {
            return this.f7853e != null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void q() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.a.f6732a) {
                frameLayout = m();
                addView(frameLayout, 0);
            } else {
                frameLayout = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) frameLayout, false);
            this.f7851c = imageView;
            frameLayout.addView(imageView, 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void r() {
            FrameLayout frameLayout;
            if (com.google.android.material.badge.a.f6732a) {
                frameLayout = m();
                addView(frameLayout);
            } else {
                frameLayout = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) frameLayout, false);
            this.f7850b = textView;
            frameLayout.addView(textView);
        }

        public void s() {
            if (this.f7852d != null) {
                v();
            }
            this.f7853e = null;
        }

        private void u(@Nullable View view) {
            if (p() && view != null) {
                l(false);
                com.google.android.material.badge.a.a(this.f7853e, view, o(view));
                this.f7852d = view;
            }
        }

        private void v() {
            if (p()) {
                l(true);
                View view = this.f7852d;
                if (view != null) {
                    com.google.android.material.badge.a.d(this.f7853e, view, o(view));
                    this.f7852d = null;
                }
            }
        }

        private void w() {
            i iVar;
            i iVar2;
            if (p()) {
                if (this.f7854f != null) {
                    v();
                    return;
                }
                if (this.f7851c != null && (iVar2 = this.f7849a) != null && iVar2.g() != null) {
                    View view = this.f7852d;
                    ImageView imageView = this.f7851c;
                    if (view == imageView) {
                        x(imageView);
                        return;
                    } else {
                        v();
                        u(this.f7851c);
                        return;
                    }
                }
                if (this.f7850b == null || (iVar = this.f7849a) == null || iVar.j() != 1) {
                    v();
                    return;
                }
                View view2 = this.f7852d;
                TextView textView = this.f7850b;
                if (view2 == textView) {
                    x(textView);
                } else {
                    v();
                    u(this.f7850b);
                }
            }
        }

        public void x(@NonNull View view) {
            if (p() && view == this.f7852d) {
                com.google.android.material.badge.a.e(this.f7853e, view, o(view));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.drawable.RippleDrawable] */
        /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.LayerDrawable] */
        public void y(Context context) {
            int i2 = TabLayout.this.N;
            if (i2 != 0) {
                Drawable drawable = AppCompatResources.getDrawable(context, i2);
                this.f7857i = drawable;
                if (drawable != null && drawable.isStateful()) {
                    this.f7857i.setState(getDrawableState());
                }
            } else {
                this.f7857i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (TabLayout.this.I != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a2 = com.google.android.material.h.b.a(TabLayout.this.I);
                if (Build.VERSION.SDK_INT >= 21) {
                    boolean z = TabLayout.this.c0;
                    if (z) {
                        gradientDrawable = null;
                    }
                    gradientDrawable = new RippleDrawable(a2, gradientDrawable, z ? null : gradientDrawable2);
                } else {
                    Drawable wrap = DrawableCompat.wrap(gradientDrawable2);
                    DrawableCompat.setTintList(wrap, a2);
                    gradientDrawable = new LayerDrawable(new Drawable[]{gradientDrawable, wrap});
                }
            }
            ViewCompat.setBackground(this, gradientDrawable);
            TabLayout.this.invalidate();
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f7857i;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.f7857i.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        @Nullable
        public i getTab() {
            return this.f7849a;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.f7853e;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.f7853e.m()));
            }
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, this.f7849a.i(), 1, false, isSelected()));
            if (isSelected()) {
                wrap.setClickable(false);
                wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
            }
            wrap.setRoleDescription("Tab");
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.O, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f7850b != null) {
                float f2 = TabLayout.this.L;
                int i4 = this.f7858j;
                ImageView imageView = this.f7851c;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f7850b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.M;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f7850b.getTextSize();
                int lineCount = this.f7850b.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.f7850b);
                if (f2 != textSize || (maxLines >= 0 && i4 != maxLines)) {
                    if (TabLayout.this.W == 1 && f2 > textSize && lineCount == 1 && ((layout = this.f7850b.getLayout()) == null || k(layout, 0, f2) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.f7850b.setTextSize(0, f2);
                        this.f7850b.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f7849a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f7849a.p();
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.f7850b;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.f7851c;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.f7854f;
            if (view != null) {
                view.setSelected(z);
            }
        }

        void setTab(@Nullable i iVar) {
            if (iVar != this.f7849a) {
                this.f7849a = iVar;
                update();
            }
        }

        void t() {
            setTab(null);
            setSelected(false);
        }

        final void update() {
            i iVar = this.f7849a;
            Drawable drawable = null;
            View f2 = iVar != null ? iVar.f() : null;
            if (f2 != null) {
                ViewParent parent = f2.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(f2);
                    }
                    addView(f2);
                }
                this.f7854f = f2;
                TextView textView = this.f7850b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f7851c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f7851c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) f2.findViewById(android.R.id.text1);
                this.f7855g = textView2;
                if (textView2 != null) {
                    this.f7858j = TextViewCompat.getMaxLines(textView2);
                }
                this.f7856h = (ImageView) f2.findViewById(android.R.id.icon);
            } else {
                View view = this.f7854f;
                if (view != null) {
                    removeView(view);
                    this.f7854f = null;
                }
                this.f7855g = null;
                this.f7856h = null;
            }
            if (this.f7854f == null) {
                if (this.f7851c == null) {
                    q();
                }
                if (iVar != null && iVar.g() != null) {
                    drawable = DrawableCompat.wrap(iVar.g()).mutate();
                }
                if (drawable != null) {
                    DrawableCompat.setTintList(drawable, TabLayout.this.H);
                    PorterDuff.Mode mode = TabLayout.this.K;
                    if (mode != null) {
                        DrawableCompat.setTintMode(drawable, mode);
                    }
                }
                if (this.f7850b == null) {
                    r();
                    this.f7858j = TextViewCompat.getMaxLines(this.f7850b);
                }
                TextViewCompat.setTextAppearance(this.f7850b, TabLayout.this.F);
                ColorStateList colorStateList = TabLayout.this.G;
                if (colorStateList != null) {
                    this.f7850b.setTextColor(colorStateList);
                }
                A(this.f7850b, this.f7851c);
                w();
                j(this.f7851c);
                j(this.f7850b);
            } else {
                TextView textView3 = this.f7855g;
                if (textView3 != null || this.f7856h != null) {
                    A(textView3, this.f7856h);
                }
            }
            if (iVar != null && !TextUtils.isEmpty(iVar.f7840e)) {
                setContentDescription(iVar.f7840e);
            }
            setSelected(iVar != null && iVar.m());
        }

        final void z() {
            setOrientation(!TabLayout.this.a0 ? 1 : 0);
            TextView textView = this.f7855g;
            if (textView == null && this.f7856h == null) {
                A(this.f7850b, this.f7851c);
            } else {
                A(textView, this.f7856h);
            }
        }
    }

    public static class n implements f {

        /* renamed from: a */
        private final ViewPager f7861a;

        public n(ViewPager viewPager) {
            this.f7861a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(@NonNull i iVar) {
            this.f7861a.setCurrentItem(iVar.i());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(i iVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(i iVar) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, null);
    }

    private void K(int i2) {
        m mVar = (m) this.A.getChildAt(i2);
        this.A.removeViewAt(i2);
        if (mVar != null) {
            mVar.t();
            this.n0.release(mVar);
        }
        requestLayout();
    }

    private void S(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.h0;
        if (viewPager2 != null) {
            l lVar = this.k0;
            if (lVar != null) {
                viewPager2.removeOnPageChangeListener(lVar);
            }
            b bVar = this.l0;
            if (bVar != null) {
                this.h0.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.f0;
        if (cVar != null) {
            G(cVar);
            this.f0 = null;
        }
        if (viewPager != null) {
            this.h0 = viewPager;
            if (this.k0 == null) {
                this.k0 = new l(this);
            }
            this.k0.a();
            viewPager.addOnPageChangeListener(this.k0);
            n nVar = new n(viewPager);
            this.f0 = nVar;
            b(nVar);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                N(adapter, z);
            }
            if (this.l0 == null) {
                this.l0 = new b();
            }
            this.l0.a(z);
            viewPager.addOnAdapterChangeListener(this.l0);
            O(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.h0 = null;
            N(null, false);
        }
        this.m0 = z2;
    }

    private void T() {
        int size = this.x.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.x.get(i2).B();
        }
    }

    private void U(@NonNull LinearLayout.LayoutParams layoutParams) {
        if (this.W == 1 && this.T == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.x.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                i iVar = this.x.get(i2);
                if (iVar != null && iVar.g() != null && !TextUtils.isEmpty(iVar.l())) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.a0) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.P;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.W;
        if (i3 == 0 || i3 == 2) {
            return this.R;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.A.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(@NonNull TabItem tabItem) {
        i C = C();
        CharSequence charSequence = tabItem.f7804a;
        if (charSequence != null) {
            C.A(charSequence);
        }
        Drawable drawable = tabItem.f7805b;
        if (drawable != null) {
            C.v(drawable);
        }
        int i2 = tabItem.f7806c;
        if (i2 != 0) {
            C.s(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            C.r(tabItem.getContentDescription());
        }
        d(C);
    }

    private void i(@NonNull i iVar) {
        m mVar = iVar.f7845j;
        mVar.setSelected(false);
        mVar.setActivated(false);
        this.A.addView(mVar, iVar.i(), r());
    }

    private void j(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        h((TabItem) view);
    }

    private void k(int i2) {
        if (i2 == -1) {
            return;
        }
        if (getWindowToken() == null || !ViewCompat.isLaidOut(this) || this.A.e()) {
            O(i2, 0.0f, true);
            return;
        }
        int scrollX = getScrollX();
        int n2 = n(i2, 0.0f);
        if (scrollX != n2) {
            x();
            this.g0.setIntValues(scrollX, n2);
            this.g0.start();
        }
        this.A.c(i2, this.U);
    }

    private void l(int i2) {
        if (i2 == 0) {
            Log.w(k, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
        } else if (i2 == 1) {
            this.A.setGravity(1);
            return;
        } else if (i2 != 2) {
            return;
        }
        this.A.setGravity(8388611);
    }

    private void m() {
        int i2 = this.W;
        ViewCompat.setPaddingRelative(this.A, (i2 == 0 || i2 == 2) ? Math.max(0, this.S - this.B) : 0, 0, 0, 0);
        int i3 = this.W;
        if (i3 == 0) {
            l(this.T);
        } else if (i3 == 1 || i3 == 2) {
            if (this.T == 2) {
                Log.w(k, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.A.setGravity(1);
        }
        V(true);
    }

    private int n(int i2, float f2) {
        int i3 = this.W;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.A.getChildAt(i2);
        int i4 = i2 + 1;
        View childAt2 = i4 < this.A.getChildCount() ? this.A.getChildAt(i4) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i5 = (int) ((width + width2) * 0.5f * f2);
        return ViewCompat.getLayoutDirection(this) == 0 ? left + i5 : left - i5;
    }

    private void p(@NonNull i iVar, int i2) {
        iVar.w(i2);
        this.x.add(i2, iVar);
        int size = this.x.size();
        while (true) {
            i2++;
            if (i2 >= size) {
                return;
            } else {
                this.x.get(i2).w(i2);
            }
        }
    }

    @NonNull
    private static ColorStateList q(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    @NonNull
    private LinearLayout.LayoutParams r() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        U(layoutParams);
        return layoutParams;
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.A.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.A.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    @NonNull
    private m t(@NonNull i iVar) {
        Pools.Pool<m> pool = this.n0;
        m acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new m(getContext());
        }
        acquire.setTab(iVar);
        acquire.setFocusable(true);
        acquire.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(iVar.f7840e)) {
            acquire.setContentDescription(iVar.f7839d);
        } else {
            acquire.setContentDescription(iVar.f7840e);
        }
        return acquire;
    }

    private void u(@NonNull i iVar) {
        for (int size = this.e0.size() - 1; size >= 0; size--) {
            this.e0.get(size).c(iVar);
        }
    }

    private void v(@NonNull i iVar) {
        for (int size = this.e0.size() - 1; size >= 0; size--) {
            this.e0.get(size).a(iVar);
        }
    }

    private void w(@NonNull i iVar) {
        for (int size = this.e0.size() - 1; size >= 0; size--) {
            this.e0.get(size).b(iVar);
        }
    }

    private void x() {
        if (this.g0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.g0 = valueAnimator;
            valueAnimator.setInterpolator(com.google.android.material.a.a.f6608b);
            this.g0.setDuration(this.U);
            this.g0.addUpdateListener(new a());
        }
    }

    public boolean A() {
        return this.a0;
    }

    public boolean B() {
        return this.b0;
    }

    @NonNull
    public i C() {
        i s2 = s();
        s2.f7844i = this;
        s2.f7845j = t(s2);
        return s2;
    }

    void D() {
        int currentItem;
        F();
        PagerAdapter pagerAdapter = this.i0;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                g(C().A(this.i0.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.h0;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            L(y(currentItem));
        }
    }

    protected boolean E(i iVar) {
        return f7816j.release(iVar);
    }

    public void F() {
        for (int childCount = this.A.getChildCount() - 1; childCount >= 0; childCount--) {
            K(childCount);
        }
        Iterator<i> it = this.x.iterator();
        while (it.hasNext()) {
            i next = it.next();
            it.remove();
            next.o();
            E(next);
        }
        this.y = null;
    }

    @Deprecated
    public void G(@Nullable c cVar) {
        this.e0.remove(cVar);
    }

    public void H(@NonNull f fVar) {
        G(fVar);
    }

    public void I(@NonNull i iVar) {
        if (iVar.f7844i != this) {
            throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
        }
        J(iVar.i());
    }

    public void J(int i2) {
        i iVar = this.y;
        int i3 = iVar != null ? iVar.i() : 0;
        K(i2);
        i remove = this.x.remove(i2);
        if (remove != null) {
            remove.o();
            E(remove);
        }
        int size = this.x.size();
        for (int i4 = i2; i4 < size; i4++) {
            this.x.get(i4).w(i4);
        }
        if (i3 == i2) {
            L(this.x.isEmpty() ? null : this.x.get(Math.max(0, i2 - 1)));
        }
    }

    public void L(@Nullable i iVar) {
        M(iVar, true);
    }

    public void M(@Nullable i iVar, boolean z) {
        i iVar2 = this.y;
        if (iVar2 == iVar) {
            if (iVar2 != null) {
                u(iVar);
                k(iVar.i());
                return;
            }
            return;
        }
        int i2 = iVar != null ? iVar.i() : -1;
        if (z) {
            if ((iVar2 == null || iVar2.i() == -1) && i2 != -1) {
                O(i2, 0.0f, true);
            } else {
                k(i2);
            }
            if (i2 != -1) {
                setSelectedTabView(i2);
            }
        }
        this.y = iVar;
        if (iVar2 != null) {
            w(iVar2);
        }
        if (iVar != null) {
            v(iVar);
        }
    }

    void N(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.i0;
        if (pagerAdapter2 != null && (dataSetObserver = this.j0) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.i0 = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.j0 == null) {
                this.j0 = new g();
            }
            pagerAdapter.registerDataSetObserver(this.j0);
        }
        D();
    }

    public void O(int i2, float f2, boolean z) {
        P(i2, f2, z, true);
    }

    public void P(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(i2 + f2);
        if (round < 0 || round >= this.A.getChildCount()) {
            return;
        }
        if (z2) {
            this.A.h(i2, f2);
        }
        ValueAnimator valueAnimator = this.g0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.g0.cancel();
        }
        scrollTo(n(i2, f2), 0);
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void Q(int i2, int i3) {
        setTabTextColors(q(i2, i3));
    }

    public void R(@Nullable ViewPager viewPager, boolean z) {
        S(viewPager, z, false);
    }

    void V(boolean z) {
        for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
            View childAt = this.A.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            U((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        j(view);
    }

    @Deprecated
    public void b(@Nullable c cVar) {
        if (this.e0.contains(cVar)) {
            return;
        }
        this.e0.add(cVar);
    }

    public void c(@NonNull f fVar) {
        b(fVar);
    }

    public void d(@NonNull i iVar) {
        g(iVar, this.x.isEmpty());
    }

    public void e(@NonNull i iVar, int i2) {
        f(iVar, i2, this.x.isEmpty());
    }

    public void f(@NonNull i iVar, int i2, boolean z) {
        if (iVar.f7844i != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        p(iVar, i2);
        i(iVar);
        if (z) {
            iVar.p();
        }
    }

    public void g(@NonNull i iVar, boolean z) {
        f(iVar, this.x.size(), z);
    }

    public int getSelectedTabPosition() {
        i iVar = this.y;
        if (iVar != null) {
            return iVar.i();
        }
        return -1;
    }

    public int getTabCount() {
        return this.x.size();
    }

    public int getTabGravity() {
        return this.T;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.H;
    }

    public int getTabIndicatorGravity() {
        return this.V;
    }

    int getTabMaxWidth() {
        return this.O;
    }

    public int getTabMode() {
        return this.W;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.I;
    }

    @Nullable
    public Drawable getTabSelectedIndicator() {
        return this.J;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.G;
    }

    public void o() {
        this.e0.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.j.k.e(this);
        if (this.h0 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                S((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.m0) {
            setupWithViewPager(null);
            this.m0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
            View childAt = this.A.getChildAt(i2);
            if (childAt instanceof m) {
                ((m) childAt).n(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        if (r0 != 2) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007e, code lost:
    
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L67;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.getContext()
            int r1 = r6.getDefaultHeight()
            float r0 = com.google.android.material.internal.u.d(r0, r1)
            int r0 = java.lang.Math.round(r0)
            int r1 = android.view.View.MeasureSpec.getMode(r8)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L2e
            if (r1 == 0) goto L1f
            goto L41
        L1f:
            int r8 = r6.getPaddingTop()
            int r0 = r0 + r8
            int r8 = r6.getPaddingBottom()
            int r0 = r0 + r8
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L41
        L2e:
            int r1 = r6.getChildCount()
            if (r1 != r5) goto L41
            int r1 = android.view.View.MeasureSpec.getSize(r8)
            if (r1 < r0) goto L41
            android.view.View r1 = r6.getChildAt(r4)
            r1.setMinimumHeight(r0)
        L41:
            int r0 = android.view.View.MeasureSpec.getSize(r7)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            if (r1 == 0) goto L5f
            int r1 = r6.Q
            if (r1 <= 0) goto L50
            goto L5d
        L50:
            float r0 = (float) r0
            android.content.Context r1 = r6.getContext()
            r2 = 56
            float r1 = com.google.android.material.internal.u.d(r1, r2)
            float r0 = r0 - r1
            int r1 = (int) r0
        L5d:
            r6.O = r1
        L5f:
            super.onMeasure(r7, r8)
            int r7 = r6.getChildCount()
            if (r7 != r5) goto Lad
            android.view.View r7 = r6.getChildAt(r4)
            int r0 = r6.W
            if (r0 == 0) goto L82
            if (r0 == r5) goto L76
            r1 = 2
            if (r0 == r1) goto L82
            goto L8d
        L76:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 == r1) goto L8d
        L80:
            r4 = 1
            goto L8d
        L82:
            int r0 = r7.getMeasuredWidth()
            int r1 = r6.getMeasuredWidth()
            if (r0 >= r1) goto L8d
            goto L80
        L8d:
            if (r4 == 0) goto Lad
            int r0 = r6.getPaddingTop()
            int r1 = r6.getPaddingBottom()
            int r0 = r0 + r1
            android.view.ViewGroup$LayoutParams r1 = r7.getLayoutParams()
            int r1 = r1.height
            int r8 = android.widget.HorizontalScrollView.getChildMeasureSpec(r8, r0, r1)
            int r0 = r6.getMeasuredWidth()
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            r7.measure(r0, r8)
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    protected i s() {
        i acquire = f7816j.acquire();
        return acquire == null ? new i() : acquire;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        com.google.android.material.j.k.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.a0 != z) {
            this.a0 = z;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof m) {
                    ((m) childAt).z();
                }
            }
            m();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable f fVar) {
        setOnTabSelectedListener((c) fVar);
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        x();
        this.g0.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (this.J != drawable) {
            this.J = drawable;
            ViewCompat.postInvalidateOnAnimation(this.A);
        }
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.A.i(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.V != i2) {
            this.V = i2;
            ViewCompat.postInvalidateOnAnimation(this.A);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.A.j(i2);
    }

    public void setTabGravity(int i2) {
        if (this.T != i2) {
            this.T = i2;
            m();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.H != colorStateList) {
            this.H = colorStateList;
            T();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.b0 = z;
        ViewCompat.postInvalidateOnAnimation(this.A);
    }

    public void setTabMode(int i2) {
        if (i2 != this.W) {
            this.W = i2;
            m();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof m) {
                    ((m) childAt).y(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.getColorStateList(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.G != colorStateList) {
            this.G = colorStateList;
            T();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        N(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.c0 != z) {
            this.c0 = z;
            for (int i2 = 0; i2 < this.A.getChildCount(); i2++) {
                View childAt = this.A.getChildAt(i2);
                if (childAt instanceof m) {
                    ((m) childAt).y(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        R(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Nullable
    public i y(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.x.get(i2);
    }

    public boolean z() {
        return this.c0;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.tabStyle);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        j(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable c cVar) {
        c cVar2 = this.d0;
        if (cVar2 != null) {
            G(cVar2);
        }
        this.d0 = cVar;
        if (cVar != null) {
            b(cVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r12, @androidx.annotation.Nullable android.util.AttributeSet r13, int r14) {
        /*
            Method dump skipped, instructions count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        j(view);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
