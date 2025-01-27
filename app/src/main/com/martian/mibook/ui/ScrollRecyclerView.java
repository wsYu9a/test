package com.martian.mibook.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class ScrollRecyclerView extends RecyclerView {

    /* renamed from: b */
    public float f15845b;

    /* renamed from: c */
    public float f15846c;

    public ScrollRecyclerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f15845b = motionEvent.getX();
            this.f15846c = motionEvent.getY();
            return onInterceptTouchEvent;
        }
        if (action == 1) {
            return false;
        }
        if (action != 2) {
            return onInterceptTouchEvent;
        }
        float abs = Math.abs(motionEvent.getX() - this.f15845b);
        float abs2 = Math.abs(motionEvent.getY() - this.f15846c);
        if ((abs <= 0.0f && abs2 <= 0.0f) || abs <= abs2) {
            return onInterceptTouchEvent;
        }
        requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScrollRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
