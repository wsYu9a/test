package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class b extends g {
    private int RA;
    private int RB;
    private boolean RC;
    private int RD;
    private a RE;
    private boolean RF;
    private boolean RG;
    private Rect Rz;

    public interface a {
        boolean qH();
    }

    public b(Context context) {
        this(context, null);
    }

    private void a(int i10, int i11, int i12) {
        while (true) {
            if (this.RD == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.RD = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i10 >= findFirstVisibleItemPosition && i10 <= findLastVisibleItemPosition) {
                int i13 = i10 - findFirstVisibleItemPosition;
                if (getChildCount() > i13) {
                    int[] iArr2 = new int[2];
                    getChildAt(i13).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.RD) - i12);
                    return;
                }
                return;
            }
            if (i10 > findLastVisibleItemPosition) {
                scrollBy(0, i11);
                a(i10, i11, i12);
                return;
            }
            scrollBy(0, -i11);
        }
    }

    private void qF() {
        Rect rect = this.Rz;
        if (rect == null) {
            this.Rz = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                this.Rz.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void qG() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).qK();
        }
    }

    private void scrollToPositionWithOffset(int i10, int i11) {
        a(i10, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qG();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.RA != 0) {
            qF();
            Rect rect = this.Rz;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Rz);
                canvas.drawColor(this.RA);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.RF) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.RG) {
            stopScroll();
        }
        a aVar = this.RE;
        if (aVar == null || !aVar.qH()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        int i12 = this.RB;
        if (i12 > 0 && i12 < size) {
            i11 = View.MeasureSpec.makeMeasureSpec(this.RB, View.MeasureSpec.getMode(i11));
        }
        super.onMeasure(i10, i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.RF) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i10) {
        if (this.RC) {
            scrollToPositionWithOffset(i10, 0);
        } else {
            super.scrollToPosition(i10);
        }
    }

    public void setDisableScroll(boolean z10) {
        this.RF = z10;
    }

    public void setDownStop(boolean z10) {
        this.RG = z10;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.RE = aVar;
    }

    public void setUnderneathColor(int i10) {
        this.RA = i10;
        qF();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z10) {
        this.RC = z10;
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.RD = Integer.MIN_VALUE;
        this.RG = false;
    }
}
