package com.martian.libmars.widget.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class NestRecyclerview extends RecyclerView {

    /* renamed from: f */
    public static final int f12811f = -1;

    /* renamed from: b */
    public int f12812b;

    /* renamed from: c */
    public int f12813c;

    /* renamed from: d */
    public int f12814d;

    /* renamed from: e */
    public int f12815e;

    public NestRecyclerview(@NonNull Context context) {
        super(context, null);
        this.f12812b = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            this.f12812b = MotionEventCompat.getPointerId(motionEvent, 0);
            this.f12813c = (int) (motionEvent.getX() + 0.5f);
            this.f12814d = (int) (motionEvent.getY() + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked != 2) {
            if (actionMasked != 5) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f12812b = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            this.f12813c = (int) (MotionEventCompat.getX(motionEvent, actionIndex) + 0.5f);
            this.f12814d = (int) (MotionEventCompat.getY(motionEvent, actionIndex) + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f12812b);
        if (findPointerIndex < 0) {
            return false;
        }
        int x10 = (int) (MotionEventCompat.getX(motionEvent, findPointerIndex) + 0.5f);
        int y10 = (int) (MotionEventCompat.getY(motionEvent, findPointerIndex) + 0.5f);
        if (getScrollState() == 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int i10 = x10 - this.f12813c;
        int i11 = y10 - this.f12814d;
        if (getLayoutManager() != null) {
            boolean canScrollHorizontally = getLayoutManager().canScrollHorizontally();
            boolean canScrollVertically = getLayoutManager().canScrollVertically();
            z10 = canScrollHorizontally && Math.abs(i10) > this.f12815e && (Math.abs(i10) >= Math.abs(i11) || canScrollVertically);
            if (canScrollVertically && Math.abs(i11) > this.f12815e && (Math.abs(i11) >= Math.abs(i10) || canScrollHorizontally)) {
                z10 = true;
            }
        } else {
            z10 = false;
        }
        return z10 && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i10) {
        super.setScrollingTouchSlop(i10);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i10 == 0) {
            this.f12815e = viewConfiguration.getScaledTouchSlop();
        } else {
            if (i10 != 1) {
                return;
            }
            this.f12815e = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    public NestRecyclerview(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f12812b = -1;
    }

    public NestRecyclerview(@NonNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f12812b = -1;
        this.f12815e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
