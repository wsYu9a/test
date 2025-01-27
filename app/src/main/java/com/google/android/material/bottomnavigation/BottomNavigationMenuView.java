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
import com.google.android.material.internal.TextScale;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;

    @NonNull
    private SparseArray<BadgeDrawable> badgeDrawables;

    @Nullable
    private BottomNavigationItemView[] buttons;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;

    @Dimension
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private final Pools.Pool<BottomNavigationItemView> itemPool;

    @StyleRes
    private int itemTextAppearanceActive;

    @StyleRes
    private int itemTextAppearanceInactive;

    @Nullable
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;

    @NonNull
    private final View.OnClickListener onClickListener;
    private BottomNavigationPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;

    @NonNull
    private final TransitionSet set;
    private int[] tempChildWidths;

    /* renamed from: com.google.android.material.bottomnavigation.BottomNavigationMenuView$1 */
    public class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
            if (BottomNavigationMenuView.this.menu.performItemAction(itemData, BottomNavigationMenuView.this.presenter, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public BottomNavigationMenuView(Context context) {
        this(context, null);
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.itemPool.acquire();
        return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
    }

    private boolean isShifting(int i10, int i11) {
        if (i10 == -1) {
            if (i11 <= 3) {
                return false;
            }
        } else if (i10 != 0) {
            return false;
        }
        return true;
    }

    private boolean isValidId(int i10) {
        return i10 != -1;
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.menu.size(); i10++) {
            hashSet.add(Integer.valueOf(this.menu.getItem(i10).getItemId()));
        }
        for (int i11 = 0; i11 < this.badgeDrawables.size(); i11++) {
            int keyAt = this.badgeDrawables.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        int id2 = bottomNavigationItemView.getId();
        if (isValidId(id2) && (badgeDrawable = this.badgeDrawables.get(id2)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }

    private void validateMenuItemId(int i10) {
        if (isValidId(i10)) {
            return;
        }
        throw new IllegalArgumentException(i10 + " is not a valid view id");
    }

    public void buildMenuView() {
        removeAllViews();
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                if (bottomNavigationItemView != null) {
                    this.itemPool.release(bottomNavigationItemView);
                    bottomNavigationItemView.removeBadge();
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        removeUnusedBadges();
        this.buttons = new BottomNavigationItemView[this.menu.size()];
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i10 = 0; i10 < this.menu.size(); i10++) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(i10).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            BottomNavigationItemView newItem = getNewItem();
            this.buttons[i10] = newItem;
            newItem.setIconTintList(this.itemIconTint);
            newItem.setIconSize(this.itemIconSize);
            newItem.setTextColor(this.itemTextColorDefault);
            newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
            newItem.setTextColor(this.itemTextColorFromUser);
            Drawable drawable = this.itemBackground;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.itemBackgroundRes);
            }
            newItem.setShifting(isShifting);
            newItem.setLabelVisibilityMode(this.labelVisibilityMode);
            newItem.initialize((MenuItemImpl) this.menu.getItem(i10), 0);
            newItem.setItemPosition(i10);
            newItem.setOnClickListener(this.onClickListener);
            if (this.selectedItemId != 0 && this.menu.getItem(i10).getItemId() == this.selectedItemId) {
                this.selectedItemPosition = i10;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = min;
        this.menu.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    @Nullable
    @VisibleForTesting
    public BottomNavigationItemView findItemView(int i10) {
        validateMenuItemId(i10);
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr == null) {
            return null;
        }
        for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
            if (bottomNavigationItemView.getId() == i10) {
                return bottomNavigationItemView;
            }
        }
        return null;
    }

    @Nullable
    public BadgeDrawable getBadge(int i10) {
        return this.badgeDrawables.get(i10);
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    @Nullable
    public Drawable getItemBackground() {
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        return (bottomNavigationItemViewArr == null || bottomNavigationItemViewArr.length <= 0) ? this.itemBackground : bottomNavigationItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public BadgeDrawable getOrCreateBadge(int i10) {
        validateMenuItemId(i10);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i10);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i10, badgeDrawable);
        }
        BottomNavigationItemView findItemView = findItemView(i10);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i18 = i14 - i16;
                    childAt.layout(i18 - childAt.getMeasuredWidth(), 0, i18, i15);
                } else {
                    childAt.layout(i16, 0, childAt.getMeasuredWidth() + i16, i15);
                }
                i16 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        int size2 = this.menu.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
        if (isShifting(this.labelVisibilityMode, size2) && this.itemHorizontalTranslationEnabled) {
            View childAt = getChildAt(this.selectedItemPosition);
            int i12 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i12 = Math.max(i12, childAt.getMeasuredWidth());
            }
            int i13 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.inactiveItemMinWidth * i13), Math.min(i12, this.activeItemMaxWidth));
            int i14 = size - min;
            int min2 = Math.min(i14 / (i13 != 0 ? i13 : 1), this.inactiveItemMaxWidth);
            int i15 = i14 - (i13 * min2);
            int i16 = 0;
            while (i16 < childCount) {
                if (getChildAt(i16).getVisibility() != 8) {
                    int[] iArr = this.tempChildWidths;
                    int i17 = i16 == this.selectedItemPosition ? min : min2;
                    iArr[i16] = i17;
                    if (i15 > 0) {
                        iArr[i16] = i17 + 1;
                        i15--;
                    }
                } else {
                    this.tempChildWidths[i16] = 0;
                }
                i16++;
            }
        } else {
            int min3 = Math.min(size / (size2 != 0 ? size2 : 1), this.activeItemMaxWidth);
            int i18 = size - (size2 * min3);
            for (int i19 = 0; i19 < childCount; i19++) {
                if (getChildAt(i19).getVisibility() != 8) {
                    int[] iArr2 = this.tempChildWidths;
                    iArr2[i19] = min3;
                    if (i18 > 0) {
                        iArr2[i19] = min3 + 1;
                        i18--;
                    }
                } else {
                    this.tempChildWidths[i19] = 0;
                }
            }
        }
        int i20 = 0;
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i21], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i20 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i20, View.MeasureSpec.makeMeasureSpec(i20, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, makeMeasureSpec, 0));
    }

    public void removeBadge(int i10) {
        validateMenuItemId(i10);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i10);
        BottomNavigationItemView findItemView = findItemView(i10);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        if (badgeDrawable != null) {
            this.badgeDrawables.remove(i10);
        }
    }

    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.badgeDrawables = sparseArray;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.itemBackgroundRes = i10;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setItemBackground(i10);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.itemHorizontalTranslationEnabled = z10;
    }

    public void setItemIconSize(@Dimension int i10) {
        this.itemIconSize = i10;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setIconSize(i10);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i10) {
        this.itemTextAppearanceActive = i10;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceActive(i10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i10) {
        this.itemTextAppearanceInactive = i10;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextAppearanceInactive(i10);
                ColorStateList colorStateList = this.itemTextColorFromUser;
                if (colorStateList != null) {
                    bottomNavigationItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        BottomNavigationItemView[] bottomNavigationItemViewArr = this.buttons;
        if (bottomNavigationItemViewArr != null) {
            for (BottomNavigationItemView bottomNavigationItemView : bottomNavigationItemViewArr) {
                bottomNavigationItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.labelVisibilityMode = i10;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.presenter = bottomNavigationPresenter;
    }

    public void tryRestoreSelectedItemId(int i10) {
        int size = this.menu.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.menu.getItem(i11);
            if (i10 == item.getItemId()) {
                this.selectedItemId = i10;
                this.selectedItemPosition = i11;
                item.setChecked(true);
                return;
            }
        }
    }

    public void updateMenuView() {
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder == null || this.buttons == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.buttons.length) {
            buildMenuView();
            return;
        }
        int i10 = this.selectedItemId;
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.menu.getItem(i11);
            if (item.isChecked()) {
                this.selectedItemId = item.getItemId();
                this.selectedItemPosition = i11;
            }
        }
        if (i10 != this.selectedItemId) {
            TransitionManager.beginDelayedTransition(this, this.set);
        }
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i12 = 0; i12 < size; i12++) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[i12].setLabelVisibilityMode(this.labelVisibilityMode);
            this.buttons[i12].setShifting(isShifting);
            this.buttons[i12].initialize((MenuItemImpl) this.menu.getItem(i12), 0);
            this.presenter.setUpdateSuspended(false);
        }
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray<>(5);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = resources.getDimensionPixelSize(com.google.android.material.R.dimen.design_bottom_navigation_height);
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        AutoTransition autoTransition = new AutoTransition();
        this.set = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(ACTIVE_ANIMATION_DURATION_MS);
        autoTransition.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        autoTransition.addTransition(new TextScale());
        this.onClickListener = new View.OnClickListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationMenuView.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                if (BottomNavigationMenuView.this.menu.performItemAction(itemData, BottomNavigationMenuView.this.presenter, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        this.tempChildWidths = new int[5];
        ViewCompat.setImportantForAccessibility(this, 1);
    }
}
