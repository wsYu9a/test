package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.n;
import com.google.android.material.internal.u;
import com.google.android.material.j.j;
import com.google.android.material.j.k;

/* loaded from: classes.dex */
public class BottomNavigationView extends FrameLayout {

    /* renamed from: a */
    private static final int f6810a = R.style.Widget_Design_BottomNavigationView;

    /* renamed from: b */
    private static final int f6811b = 1;

    /* renamed from: c */
    @NonNull
    private final MenuBuilder f6812c;

    /* renamed from: d */
    @NonNull
    @VisibleForTesting
    final BottomNavigationMenuView f6813d;

    /* renamed from: e */
    private final com.google.android.material.bottomnavigation.a f6814e;

    /* renamed from: f */
    @Nullable
    private ColorStateList f6815f;

    /* renamed from: g */
    private MenuInflater f6816g;

    /* renamed from: h */
    private d f6817h;

    /* renamed from: i */
    private c f6818i;

    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            if (BottomNavigationView.this.f6818i == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                return (BottomNavigationView.this.f6817h == null || BottomNavigationView.this.f6817h.onNavigationItemSelected(menuItem)) ? false : true;
            }
            BottomNavigationView.this.f6818i.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    class b implements u.e {
        b() {
        }

        @Override // com.google.android.material.internal.u.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull u.f fVar) {
            fVar.f7397d += windowInsetsCompat.getSystemWindowInsetBottom();
            fVar.a(view);
            return windowInsetsCompat;
        }
    }

    public interface c {
        void a(@NonNull MenuItem menuItem);
    }

    public interface d {
        boolean onNavigationItemSelected(@NonNull MenuItem menuItem);
    }

    static class e extends AbsSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: b */
        @Nullable
        Bundle f6821b;

        static class a implements Parcelable.ClassLoaderCreator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public e createFromParcel(@NonNull Parcel parcel) {
                return new e(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public e createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public e[] newArray(int i2) {
                return new e[i2];
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.f6821b = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f6821b);
        }

        public e(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private void c(Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private void d() {
        u.c(this, new b());
    }

    @NonNull
    private j e(Context context) {
        j jVar = new j();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            jVar.n0(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        jVar.Y(context);
        return jVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.f6816g == null) {
            this.f6816g = new SupportMenuInflater(getContext());
        }
        return this.f6816g;
    }

    @Nullable
    public BadgeDrawable f(int i2) {
        return this.f6813d.f(i2);
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f6813d.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f6813d.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f6813d.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f6813d.getIconTintList();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f6815f;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f6813d.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f6813d.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f6813d.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f6813d.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    @NonNull
    public Menu getMenu() {
        return this.f6812c;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.f6813d.getSelectedItemId();
    }

    public BadgeDrawable h(int i2) {
        return this.f6813d.g(i2);
    }

    public void i(int i2) {
        this.f6814e.c(true);
        getMenuInflater().inflate(i2, this.f6812c);
        this.f6814e.c(false);
        this.f6814e.updateMenuView(true);
    }

    public boolean j() {
        return this.f6813d.h();
    }

    public void k(int i2) {
        this.f6813d.k(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        k.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.f6812c.restorePresenterStates(eVar.f6821b);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        eVar.f6821b = bundle;
        this.f6812c.savePresenterStates(bundle);
        return eVar;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        k.d(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f6813d.setItemBackground(drawable);
        this.f6815f = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        this.f6813d.setItemBackgroundRes(i2);
        this.f6815f = null;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f6813d.h() != z) {
            this.f6813d.setItemHorizontalTranslationEnabled(z);
            this.f6814e.updateMenuView(false);
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f6813d.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f6813d.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f6815f == colorStateList) {
            if (colorStateList != null || this.f6813d.getItemBackground() == null) {
                return;
            }
            this.f6813d.setItemBackground(null);
            return;
        }
        this.f6815f = colorStateList;
        if (colorStateList == null) {
            this.f6813d.setItemBackground(null);
            return;
        }
        ColorStateList a2 = com.google.android.material.h.b.a(colorStateList);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f6813d.setItemBackground(new RippleDrawable(a2, null, null));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        Drawable wrap = DrawableCompat.wrap(gradientDrawable);
        DrawableCompat.setTintList(wrap, a2);
        this.f6813d.setItemBackground(wrap);
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.f6813d.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.f6813d.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f6813d.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f6813d.getLabelVisibilityMode() != i2) {
            this.f6813d.setLabelVisibilityMode(i2);
            this.f6814e.updateMenuView(false);
        }
    }

    public void setOnNavigationItemReselectedListener(@Nullable c cVar) {
        this.f6818i = cVar;
    }

    public void setOnNavigationItemSelectedListener(@Nullable d dVar) {
        this.f6817h = dVar;
    }

    public void setSelectedItemId(@IdRes int i2) {
        MenuItem findItem = this.f6812c.findItem(i2);
        if (findItem == null || this.f6812c.performItemAction(findItem, this.f6814e, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, f6810a), attributeSet, i2);
        com.google.android.material.bottomnavigation.a aVar = new com.google.android.material.bottomnavigation.a();
        this.f6814e = aVar;
        Context context2 = getContext();
        MenuBuilder bottomNavigationMenu = new BottomNavigationMenu(context2);
        this.f6812c = bottomNavigationMenu;
        BottomNavigationMenuView bottomNavigationMenuView = new BottomNavigationMenuView(context2);
        this.f6813d = bottomNavigationMenuView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        bottomNavigationMenuView.setLayoutParams(layoutParams);
        aVar.a(bottomNavigationMenuView);
        aVar.b(1);
        bottomNavigationMenuView.setPresenter(aVar);
        bottomNavigationMenu.addMenuPresenter(aVar);
        aVar.initForMenu(getContext(), bottomNavigationMenu);
        int[] iArr = R.styleable.BottomNavigationView;
        int i3 = R.style.Widget_Design_BottomNavigationView;
        int i4 = R.styleable.BottomNavigationView_itemTextAppearanceInactive;
        int i5 = R.styleable.BottomNavigationView_itemTextAppearanceActive;
        TintTypedArray k = n.k(context2, attributeSet, iArr, i2, i3, i4, i5);
        int i6 = R.styleable.BottomNavigationView_itemIconTint;
        if (k.hasValue(i6)) {
            bottomNavigationMenuView.setIconTintList(k.getColorStateList(i6));
        } else {
            bottomNavigationMenuView.setIconTintList(bottomNavigationMenuView.d(android.R.attr.textColorSecondary));
        }
        setItemIconSize(k.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
        if (k.hasValue(i4)) {
            setItemTextAppearanceInactive(k.getResourceId(i4, 0));
        }
        if (k.hasValue(i5)) {
            setItemTextAppearanceActive(k.getResourceId(i5, 0));
        }
        int i7 = R.styleable.BottomNavigationView_itemTextColor;
        if (k.hasValue(i7)) {
            setItemTextColor(k.getColorStateList(i7));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, e(context2));
        }
        if (k.hasValue(R.styleable.BottomNavigationView_elevation)) {
            ViewCompat.setElevation(this, k.getDimensionPixelSize(r2, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), com.google.android.material.g.c.b(context2, k, R.styleable.BottomNavigationView_backgroundTint));
        setLabelVisibilityMode(k.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
        setItemHorizontalTranslationEnabled(k.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        int resourceId = k.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
        if (resourceId != 0) {
            bottomNavigationMenuView.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(com.google.android.material.g.c.b(context2, k, R.styleable.BottomNavigationView_itemRippleColor));
        }
        int i8 = R.styleable.BottomNavigationView_menu;
        if (k.hasValue(i8)) {
            i(k.getResourceId(i8, 0));
        }
        k.recycle();
        addView(bottomNavigationMenuView, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            c(context2);
        }
        bottomNavigationMenu.setCallback(new a());
        d();
    }
}
