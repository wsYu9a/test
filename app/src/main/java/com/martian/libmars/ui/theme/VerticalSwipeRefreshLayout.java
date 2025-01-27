package com.martian.libmars.ui.theme;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* loaded from: classes3.dex */
public class VerticalSwipeRefreshLayout extends SwipeRefreshLayout {

    /* renamed from: e */
    public final int f12393e;

    /* renamed from: f */
    public float f12394f;

    public VerticalSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12393e = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12394f = motionEvent.getX();
        } else if (action == 2 && Math.abs(motionEvent.getX() - this.f12394f) > this.f12393e + 60) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
