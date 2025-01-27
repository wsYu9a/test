package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.util.List;

/* loaded from: classes.dex */
abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d */
    final Rect f6697d;

    /* renamed from: e */
    final Rect f6698e;

    /* renamed from: f */
    private int f6699f;

    /* renamed from: g */
    private int f6700g;

    public HeaderScrollingViewBehavior() {
        this.f6697d = new Rect();
        this.f6698e = new Rect();
        this.f6699f = 0;
    }

    private static int p(int i2) {
        return i2 == 0 ? BadgeDrawable.f6713b : i2;
    }

    @Override // com.google.android.material.appbar.ViewOffsetBehavior
    protected void e(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
        View j2 = j(coordinatorLayout.getDependencies(view));
        if (j2 == null) {
            super.e(coordinatorLayout, view, i2);
            this.f6699f = 0;
            return;
        }
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        Rect rect = this.f6697d;
        rect.set(coordinatorLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, j2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, ((coordinatorLayout.getHeight() + j2.getBottom()) - coordinatorLayout.getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
        if (lastWindowInsets != null && ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(view)) {
            rect.left += lastWindowInsets.getSystemWindowInsetLeft();
            rect.right -= lastWindowInsets.getSystemWindowInsetRight();
        }
        Rect rect2 = this.f6698e;
        GravityCompat.apply(p(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
        int k = k(j2);
        view.layout(rect2.left, rect2.top - k, rect2.right, rect2.bottom - k);
        this.f6699f = rect2.top - j2.getBottom();
    }

    @Nullable
    abstract View j(List<View> list);

    final int k(View view) {
        if (this.f6700g == 0) {
            return 0;
        }
        float l = l(view);
        int i2 = this.f6700g;
        return MathUtils.clamp((int) (l * i2), 0, i2);
    }

    float l(View view) {
        return 1.0f;
    }

    public final int m() {
        return this.f6700g;
    }

    int n(@NonNull View view) {
        return view.getMeasuredHeight();
    }

    final int o() {
        return this.f6699f;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
        View j2;
        WindowInsetsCompat lastWindowInsets;
        int i6 = view.getLayoutParams().height;
        if ((i6 != -1 && i6 != -2) || (j2 = j(coordinatorLayout.getDependencies(view))) == null) {
            return false;
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size <= 0) {
            size = coordinatorLayout.getHeight();
        } else if (ViewCompat.getFitsSystemWindows(j2) && (lastWindowInsets = coordinatorLayout.getLastWindowInsets()) != null) {
            size += lastWindowInsets.getSystemWindowInsetTop() + lastWindowInsets.getSystemWindowInsetBottom();
        }
        int n = size + n(j2);
        int measuredHeight = j2.getMeasuredHeight();
        if (r()) {
            view.setTranslationY(-measuredHeight);
        } else {
            n -= measuredHeight;
        }
        coordinatorLayout.onMeasureChild(view, i2, i3, View.MeasureSpec.makeMeasureSpec(n, i6 == -1 ? 1073741824 : Integer.MIN_VALUE), i5);
        return true;
    }

    public final void q(int i2) {
        this.f6700g = i2;
    }

    protected boolean r() {
        return false;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6697d = new Rect();
        this.f6698e = new Rect();
        this.f6699f = 0;
    }
}
