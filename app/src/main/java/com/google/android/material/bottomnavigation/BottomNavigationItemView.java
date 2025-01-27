package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.badge.BadgeDrawable;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class BottomNavigationItemView extends FrameLayout implements MenuView.ItemView {

    /* renamed from: a */
    public static final int f6788a = -1;

    /* renamed from: b */
    private static final int[] f6789b = {R.attr.state_checked};

    /* renamed from: c */
    private final int f6790c;

    /* renamed from: d */
    private float f6791d;

    /* renamed from: e */
    private float f6792e;

    /* renamed from: f */
    private float f6793f;

    /* renamed from: g */
    private int f6794g;

    /* renamed from: h */
    private boolean f6795h;

    /* renamed from: i */
    private ImageView f6796i;

    /* renamed from: j */
    private final TextView f6797j;
    private final TextView k;
    private int l;

    @Nullable
    private MenuItemImpl m;

    @Nullable
    private ColorStateList n;

    @Nullable
    private Drawable o;

    @Nullable
    private Drawable p;

    @Nullable
    private BadgeDrawable q;

    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (BottomNavigationItemView.this.f6796i.getVisibility() == 0) {
                BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                bottomNavigationItemView.k(bottomNavigationItemView.f6796i);
            }
        }
    }

    public BottomNavigationItemView(@NonNull Context context) {
        this(context, null);
    }

    private void c(float f2, float f3) {
        this.f6791d = f2 - f3;
        this.f6792e = (f3 * 1.0f) / f2;
        this.f6793f = (f2 * 1.0f) / f3;
    }

    @Nullable
    private FrameLayout d(View view) {
        ImageView imageView = this.f6796i;
        if (view == imageView && com.google.android.material.badge.a.f6732a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private boolean e() {
        return this.q != null;
    }

    private void g(@NonNull View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private void h(@NonNull View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    private void i(@Nullable View view) {
        if (e() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.a.a(this.q, view, d(view));
        }
    }

    private void j(@Nullable View view) {
        if (e()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.a.d(this.q, view, d(view));
            }
            this.q = null;
        }
    }

    public void k(View view) {
        if (e()) {
            com.google.android.material.badge.a.e(this.q, view, d(view));
        }
    }

    void f() {
        j(this.f6796i);
    }

    @Nullable
    BadgeDrawable getBadge() {
        return this.q;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.m;
    }

    public int getItemPosition() {
        return this.l;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        this.m = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        TooltipCompat.setTooltipText(this, !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.m.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f6789b);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.q;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.m.getTitle();
            if (!TextUtils.isEmpty(this.m.getContentDescription())) {
                title = this.m.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.q.m()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemPosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        this.q = badgeDrawable;
        ImageView imageView = this.f6796i;
        if (imageView != null) {
            i(imageView);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        this.k.setPivotX(r0.getWidth() / 2);
        this.k.setPivotY(r0.getBaseline());
        this.f6797j.setPivotX(r0.getWidth() / 2);
        this.f6797j.setPivotY(r0.getBaseline());
        int i2 = this.f6794g;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    g(this.f6796i, this.f6790c, 49);
                    h(this.k, 1.0f, 1.0f, 0);
                } else {
                    g(this.f6796i, this.f6790c, 17);
                    h(this.k, 0.5f, 0.5f, 4);
                }
                this.f6797j.setVisibility(4);
            } else if (i2 != 1) {
                if (i2 == 2) {
                    g(this.f6796i, this.f6790c, 17);
                    this.k.setVisibility(8);
                    this.f6797j.setVisibility(8);
                }
            } else if (z) {
                g(this.f6796i, (int) (this.f6790c + this.f6791d), 49);
                h(this.k, 1.0f, 1.0f, 0);
                TextView textView = this.f6797j;
                float f2 = this.f6792e;
                h(textView, f2, f2, 4);
            } else {
                g(this.f6796i, this.f6790c, 49);
                TextView textView2 = this.k;
                float f3 = this.f6793f;
                h(textView2, f3, f3, 4);
                h(this.f6797j, 1.0f, 1.0f, 0);
            }
        } else if (this.f6795h) {
            if (z) {
                g(this.f6796i, this.f6790c, 49);
                h(this.k, 1.0f, 1.0f, 0);
            } else {
                g(this.f6796i, this.f6790c, 17);
                h(this.k, 0.5f, 0.5f, 4);
            }
            this.f6797j.setVisibility(4);
        } else if (z) {
            g(this.f6796i, (int) (this.f6790c + this.f6791d), 49);
            h(this.k, 1.0f, 1.0f, 0);
            TextView textView3 = this.f6797j;
            float f4 = this.f6792e;
            h(textView3, f4, f4, 4);
        } else {
            g(this.f6796i, this.f6790c, 49);
            TextView textView4 = this.k;
            float f5 = this.f6793f;
            h(textView4, f5, f5, 4);
            h(this.f6797j, 1.0f, 1.0f, 0);
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f6797j.setEnabled(z);
        this.k.setEnabled(z);
        this.f6796i.setEnabled(z);
        if (z) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.o) {
            return;
        }
        this.o = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.p = drawable;
            ColorStateList colorStateList = this.n;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.f6796i.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f6796i.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f6796i.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.n = colorStateList;
        if (this.m == null || (drawable = this.p) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorStateList);
        this.p.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemPosition(int i2) {
        this.l = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f6794g != i2) {
            this.f6794g = i2;
            MenuItemImpl menuItemImpl = this.m;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f6795h != z) {
            this.f6795h = z;
            MenuItemImpl menuItemImpl = this.m;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c2) {
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.k, i2);
        c(this.f6797j.getTextSize(), this.k.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f6797j, i2);
        c(this.f6797j.getTextSize(), this.k.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f6797j.setTextColor(colorStateList);
            this.k.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f6797j.setText(charSequence);
        this.k.setText(charSequence);
        MenuItemImpl menuItemImpl = this.m;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.m;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.m.getTooltipText();
        }
        TooltipCompat.setTooltipText(this, charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.l = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(com.google.android.material.R.drawable.design_bottom_navigation_item_background);
        this.f6790c = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_margin);
        this.f6796i = (ImageView) findViewById(com.google.android.material.R.id.icon);
        TextView textView = (TextView) findViewById(com.google.android.material.R.id.smallLabel);
        this.f6797j = textView;
        TextView textView2 = (TextView) findViewById(com.google.android.material.R.id.largeLabel);
        this.k = textView2;
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        c(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.f6796i;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }
}
