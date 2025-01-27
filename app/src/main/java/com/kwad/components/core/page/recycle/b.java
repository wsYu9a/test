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

/* loaded from: classes2.dex */
public class b extends g {
    private Rect Mo;
    private int Mp;
    private int Mq;
    private boolean Mr;
    private int Ms;
    private a Mt;
    private boolean Mu;
    private boolean Mv;

    public interface a {
        boolean oJ();
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Ms = Integer.MIN_VALUE;
        this.Mv = false;
    }

    private void a(int i2, int i3, int i4) {
        while (true) {
            if (this.Ms == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.Ms = iArr[1];
            }
            int findFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
                return;
            }
            if (i2 >= findFirstVisibleItemPosition && i2 <= findLastVisibleItemPosition) {
                int i5 = i2 - findFirstVisibleItemPosition;
                if (getChildCount() > i5) {
                    int[] iArr2 = new int[2];
                    getChildAt(i5).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.Ms) - i4);
                    return;
                }
                return;
            }
            if (i2 > findLastVisibleItemPosition) {
                scrollBy(0, i3);
                a(i2, i3, i4);
                return;
            }
            scrollBy(0, -i3);
        }
    }

    private void oH() {
        Rect rect = this.Mo;
        if (rect == null) {
            this.Mo = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                this.Mo.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void oI() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).oM();
        }
    }

    private void scrollToPositionWithOffset(int i2, int i3) {
        a(i2, getHeight(), 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        oI();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.Mp != 0) {
            oH();
            Rect rect = this.Mo;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.Mo);
                canvas.drawColor(this.Mp);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Mu) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.Mv) {
            stopScroll();
        }
        a aVar = this.Mt;
        if (aVar == null || !aVar.oJ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int i4 = this.Mq;
        if (i4 > 0 && i4 < size) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.Mq, View.MeasureSpec.getMode(i3));
        }
        super.onMeasure(i2, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.Mu) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i2) {
        if (this.Mr) {
            scrollToPositionWithOffset(i2, 0);
        } else {
            super.scrollToPosition(i2);
        }
    }

    public void setDisableScroll(boolean z) {
        this.Mu = z;
    }

    public void setDownStop(boolean z) {
        this.Mv = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.Mt = aVar;
    }

    public void setUnderneathColor(int i2) {
        this.Mp = i2;
        oH();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.Mr = z;
    }
}
