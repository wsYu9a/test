package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
class ViewOffsetHelper {
    private int layoutLeft;
    private int layoutTop;
    private int offsetLeft;
    private int offsetTop;
    private final View view;
    private boolean verticalOffsetEnabled = true;
    private boolean horizontalOffsetEnabled = true;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    public void applyOffsets() {
        View view = this.view;
        ViewCompat.offsetTopAndBottom(view, this.offsetTop - (view.getTop() - this.layoutTop));
        View view2 = this.view;
        ViewCompat.offsetLeftAndRight(view2, this.offsetLeft - (view2.getLeft() - this.layoutLeft));
    }

    public int getLayoutLeft() {
        return this.layoutLeft;
    }

    public int getLayoutTop() {
        return this.layoutTop;
    }

    public int getLeftAndRightOffset() {
        return this.offsetLeft;
    }

    public int getTopAndBottomOffset() {
        return this.offsetTop;
    }

    public boolean isHorizontalOffsetEnabled() {
        return this.horizontalOffsetEnabled;
    }

    public boolean isVerticalOffsetEnabled() {
        return this.verticalOffsetEnabled;
    }

    public void onViewLayout() {
        this.layoutTop = this.view.getTop();
        this.layoutLeft = this.view.getLeft();
    }

    public void setHorizontalOffsetEnabled(boolean z10) {
        this.horizontalOffsetEnabled = z10;
    }

    public boolean setLeftAndRightOffset(int i10) {
        if (!this.horizontalOffsetEnabled || this.offsetLeft == i10) {
            return false;
        }
        this.offsetLeft = i10;
        applyOffsets();
        return true;
    }

    public boolean setTopAndBottomOffset(int i10) {
        if (!this.verticalOffsetEnabled || this.offsetTop == i10) {
            return false;
        }
        this.offsetTop = i10;
        applyOffsets();
        return true;
    }

    public void setVerticalOffsetEnabled(boolean z10) {
        this.verticalOffsetEnabled = z10;
    }
}
