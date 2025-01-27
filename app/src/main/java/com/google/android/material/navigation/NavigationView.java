package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.f;
import com.google.android.material.j.j;
import com.google.android.material.j.k;
import com.google.android.material.j.o;

/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: f */
    private static final int[] f7696f = {R.attr.state_checked};

    /* renamed from: g */
    private static final int[] f7697g = {-16842910};

    /* renamed from: h */
    private static final int f7698h = com.google.android.material.R.style.Widget_Design_NavigationView;

    /* renamed from: i */
    private static final int f7699i = 1;

    /* renamed from: j */
    @NonNull
    private final NavigationMenu f7700j;
    private final f k;
    c l;
    private final int m;
    private final int[] n;
    private MenuInflater o;
    private ViewTreeObserver.OnGlobalLayoutListener p;

    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            c cVar = NavigationView.this.l;
            return cVar != null && cVar.onNavigationItemSelected(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.n);
            boolean z = NavigationView.this.n[1] == 0;
            NavigationView.this.k.p(z);
            NavigationView.this.setDrawTopInsetForeground(z);
            Activity activity = com.google.android.material.internal.b.getActivity(NavigationView.this.getContext());
            if (activity == null || Build.VERSION.SDK_INT < 21) {
                return;
            }
            NavigationView.this.setDrawBottomInsetForeground((activity.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(activity.getWindow().getNavigationBarColor()) != 0));
        }
    }

    public interface c {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private ColorStateList e(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = f7697g;
        return new ColorStateList(new int[][]{iArr, f7696f, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    @NonNull
    private final Drawable f(@NonNull TintTypedArray tintTypedArray) {
        j jVar = new j(o.b(getContext(), tintTypedArray.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        jVar.n0(com.google.android.material.g.c.b(getContext(), tintTypedArray, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) jVar, tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.o == null) {
            this.o = new SupportMenuInflater(getContext());
        }
        return this.o;
    }

    private boolean h(@NonNull TintTypedArray tintTypedArray) {
        return tintTypedArray.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void l() {
        this.p = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.p);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.k.c(windowInsetsCompat);
    }

    public void d(@NonNull View view) {
        this.k.b(view);
    }

    public View g(int i2) {
        return this.k.f(i2);
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.k.d();
    }

    public int getHeaderCount() {
        return this.k.e();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.k.g();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.k.h();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.k.i();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.k.l();
    }

    public int getItemMaxLines() {
        return this.k.j();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.k.k();
    }

    @NonNull
    public Menu getMenu() {
        return this.f7700j;
    }

    public View i(@LayoutRes int i2) {
        return this.k.m(i2);
    }

    public void j(int i2) {
        this.k.B(true);
        getMenuInflater().inflate(i2, this.f7700j);
        this.k.B(false);
        this.k.updateMenuView(false);
    }

    public void k(@NonNull View view) {
        this.k.o(view);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.p);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.m), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.m, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        this.f7700j.restorePresenterStates(dVar.f7703b);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        dVar.f7703b = bundle;
        this.f7700j.savePresenterStates(bundle);
        return dVar;
    }

    public void setCheckedItem(@IdRes int i2) {
        MenuItem findItem = this.f7700j.findItem(i2);
        if (findItem != null) {
            this.k.q((MenuItemImpl) findItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        k.d(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.k.s(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemHorizontalPadding(@Dimension int i2) {
        this.k.t(i2);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i2) {
        this.k.t(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(@Dimension int i2) {
        this.k.u(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.k.u(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(@Dimension int i2) {
        this.k.v(i2);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.k.w(colorStateList);
    }

    public void setItemMaxLines(int i2) {
        this.k.x(i2);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        this.k.y(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.k.z(colorStateList);
    }

    public void setNavigationItemSelectedListener(@Nullable c cVar) {
        this.l = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        f fVar = this.k;
        if (fVar != null) {
            fVar.A(i2);
        }
    }

    public static class d extends AbsSavedState {
        public static final Parcelable.Creator<d> CREATOR = new a();

        /* renamed from: b */
        @Nullable
        public Bundle f7703b;

        static class a implements Parcelable.ClassLoaderCreator<d> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public d createFromParcel(@NonNull Parcel parcel) {
                return new d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public d createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public d[] newArray(int i2) {
                return new d[i2];
            }
        }

        public d(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f7703b = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f7703b);
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.f7700j.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.k.q((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
