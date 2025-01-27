package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
public class ScrollRecyclerView extends RecyclerView {

    /* renamed from: a */
    private float f14164a;

    /* renamed from: b */
    private float f14165b;

    public ScrollRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e2) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(e2);
        int action = e2.getAction();
        if (action == 0) {
            this.f14164a = e2.getX();
            this.f14165b = e2.getY();
            return onInterceptTouchEvent;
        }
        if (action == 1) {
            return false;
        }
        if (action != 2) {
            return onInterceptTouchEvent;
        }
        float abs = Math.abs(e2.getX() - this.f14164a);
        float abs2 = Math.abs(e2.getY() - this.f14165b);
        if ((abs <= 0.0f && abs2 <= 0.0f) || abs <= abs2) {
            return onInterceptTouchEvent;
        }
        requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
