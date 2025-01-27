package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes2.dex */
public class VerticalSwipeRefreshLayout extends SwipeRefreshLayout {
    private final int h0;
    private float i0;

    public VerticalSwipeRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.h0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            this.i0 = event.getX();
        } else if (action == 2 && Math.abs(event.getX() - this.i0) > this.h0 + 60) {
            return false;
        }
        return super.onInterceptTouchEvent(event);
    }
}
