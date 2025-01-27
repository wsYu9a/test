package com.google.android.material.bottomnavigation;

import android.R;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.m;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {

    /* renamed from: a */
    private static final long f6799a = 115;

    /* renamed from: b */
    private static final int f6800b = 5;

    /* renamed from: c */
    private static final int[] f6801c = {R.attr.state_checked};

    /* renamed from: d */
    private static final int[] f6802d = {-16842910};

    @NonNull
    private SparseArray<BadgeDrawable> A;
    private com.google.android.material.bottomnavigation.a B;
    private MenuBuilder C;

    /* renamed from: e */
    @NonNull
    private final TransitionSet f6803e;

    /* renamed from: f */
    private final int f6804f;

    /* renamed from: g */
    private final int f6805g;

    /* renamed from: h */
    private final int f6806h;

    /* renamed from: i */
    private final int f6807i;

    /* renamed from: j */
    private final int f6808j;

    @NonNull
    private final View.OnClickListener k;
    private final Pools.Pool<BottomNavigationItemView> l;
    private boolean m;
    private int n;

    @Nullable
    private BottomNavigationItemView[] o;
    private int p;
    private int q;
    private ColorStateList r;

    @Dimension
    private int s;
    private ColorStateList t;

    @Nullable
    private final ColorStateList u;

    @StyleRes
    private int v;

    @StyleRes
    private int w;
    private Drawable x;
    private int y;
    private int[] z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
            if (BottomNavigationMenuView.this.C.performItemAction(itemData, BottomNavigationMenuView.this.B, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.l.acquire();
        return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
    }

    private boolean i(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    private boolean j(int i2) {
        return i2 != -1;
    }

    private void l() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.C.size(); i2++) {
            hashSet.add(Integer.valueOf(this.C.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.A.size(); i3++) {
            int keyAt = this.A.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.A.delete(keyAt);
            }
        }
    }

    private void o(int i2) {
        if (j(i2)) {
            return;
        }
        throw new IllegalArgumentException(i2 + " is not a valid view id");
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        int id = bottomNavigationItemView.getId();
        if (j(id) && (badgeDrawable = this.A.get(id)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }

    public void c() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.l.release(bottomNavigationItemView);
                    bottomNavigationItemView.f();
                }
            }
        }
        if (this.C.size() == 0) {
            this.p = 0;
            this.q = 0;
            this.o = null;
            return;
        }
        l();
        this.o = new BottomNavigationItemView[this.C.size()];
        boolean i2 = i(this.n, this.C.getVisibleItems().size());
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            this.B.c(true);
            this.C.getItem(i3).setCheckable(true);
            this.B.c(false);
            BottomNavigationItemView newItem = getNewItem();
            this.o[i3] = newItem;
            newItem.setIconTintList(this.r);
            newItem.setIconSize(this.s);
            newItem.setTextColor(this.u);
            newItem.setTextAppearanceInactive(this.v);
            newItem.setTextAppearanceActive(this.w);
            newItem.setTextColor(this.t);
            Drawable drawable = this.x;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.y);
            }
            newItem.setShifting(i2);
            newItem.setLabelVisibilityMode(this.n);
            newItem.initialize((MenuItemImpl) this.C.getItem(i3), 0);
            newItem.setItemPosition(i3);
            newItem.setOnClickListener(this.k);
            if (this.p != 0 && this.C.getItem(i3).getItemId() == this.p) {
                this.q = i3;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.C.size() - 1, this.q);
        this.q = min;
        this.C.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList d(int i2) {
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
        int[] iArr = f6802d;
        return new ColorStateList(new int[][]{iArr, f6801c, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    @Nullable
    @VisibleForTesting
    BottomNavigationItemView e(int i2) {
        o(i2);
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr == null) {
            return null;
        }
        for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
            if (bottomNavigationItemView.getId() == i2) {
                return bottomNavigationItemView;
            }
        }
        return null;
    }

    @Nullable
    BadgeDrawable f(int i2) {
        return this.A.get(i2);
    }

    BadgeDrawable g(int i2) {
        o(i2);
        BadgeDrawable badgeDrawable = this.A.get(i2);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.d(getContext());
            this.A.put(i2, badgeDrawable);
        }
        BottomNavigationItemView e2 = e(i2);
        if (e2 != null) {
            e2.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.A;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.r;
    }

    @Nullable
    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        return (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) ? this.x : bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.y;
    }

    @Dimension
    public int getItemIconSize() {
        return this.s;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.w;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.v;
    }

    public ColorStateList getItemTextColor() {
        return this.t;
    }

    public int getLabelVisibilityMode() {
        return this.n;
    }

    public int getSelectedItemId() {
        return this.p;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public boolean h() {
        return this.m;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.C = menuBuilder;
    }

    void k(int i2) {
        o(i2);
        BadgeDrawable badgeDrawable = this.A.get(i2);
        BottomNavigationItemView e2 = e(i2);
        if (e2 != null) {
            e2.f();
        }
        if (badgeDrawable != null) {
            this.A.remove(i2);
        }
    }

    void m(int i2) {
        int size = this.C.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.C.getItem(i3);
            if (i2 == item.getItemId()) {
                this.p = i2;
                this.q = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void n() {
        MenuBuilder menuBuilder = this.C;
        if (menuBuilder == null || this.o == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.o.length) {
            c();
            return;
        }
        int i2 = this.p;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.C.getItem(i3);
            if (item.isChecked()) {
                this.p = item.getItemId();
                this.q = i3;
            }
        }
        if (i2 != this.p) {
            TransitionManager.beginDelayedTransition(this, this.f6803e);
        }
        boolean i4 = i(this.n, this.C.getVisibleItems().size());
        for (int i5 = 0; i5 < size; i5++) {
            this.B.c(true);
            this.o[i5].setLabelVisibilityMode(this.n);
            this.o[i5].setShifting(i4);
            this.o[i5].initialize((MenuItemImpl) this.C.getItem(i5), 0);
            this.B.c(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.C.getVisibleItems().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.C.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f6808j, 1073741824);
        if (i(this.n, size2) && this.m) {
            View childAt = getChildAt(this.q);
            int i4 = this.f6807i;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f6806h, Integer.MIN_VALUE), makeMeasureSpec);
                i4 = Math.max(i4, childAt.getMeasuredWidth());
            }
            int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.f6805g * i5), Math.min(i4, this.f6806h));
            int i6 = size - min;
            int min2 = Math.min(i6 / (i5 == 0 ? 1 : i5), this.f6804f);
            int i7 = i6 - (i5 * min2);
            int i8 = 0;
            while (i8 < childCount) {
                if (getChildAt(i8).getVisibility() != 8) {
                    int[] iArr = this.z;
                    iArr[i8] = i8 == this.q ? min : min2;
                    if (i7 > 0) {
                        iArr[i8] = iArr[i8] + 1;
                        i7--;
                    }
                } else {
                    this.z[i8] = 0;
                }
                i8++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f6806h);
            int i9 = size - (size2 * min3);
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getVisibility() != 8) {
                    int[] iArr2 = this.z;
                    iArr2[i10] = min3;
                    if (i9 > 0) {
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.z[i10] = 0;
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.z[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.f6808j, makeMeasureSpec, 0));
    }

    void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.A = sparseArray;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.x = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.y = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.m = z;
    }

    public void setItemIconSize(@Dimension int i2) {
        this.s = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.w = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.t;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.v = i2;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.t;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.t = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.o;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.n = i2;
    }

    public void setPresenter(com.google.android.material.bottomnavigation.a aVar) {
        this.B = aVar;
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new Pools.SynchronizedPool(5);
        this.p = 0;
        this.q = 0;
        this.A = new SparseArray<>(5);
        Resources resources = getResources();
        this.f6804f = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_max_width);
        this.f6805g = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_min_width);
        this.f6806h = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_max_width);
        this.f6807i = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_min_width);
        this.f6808j = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_height);
        this.u = d(R.attr.textColorSecondary);
        AutoTransition autoTransition = new AutoTransition();
        this.f6803e = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(f6799a);
        autoTransition.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        autoTransition.addTransition(new m());
        this.k = new a();
        this.z = new int[5];
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
