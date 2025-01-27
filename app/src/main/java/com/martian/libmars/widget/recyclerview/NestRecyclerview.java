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

/* loaded from: classes2.dex */
public class NestRecyclerview extends RecyclerView {

    /* renamed from: a */
    private static final int f10455a = -1;

    /* renamed from: b */
    private int f10456b;

    /* renamed from: c */
    private int f10457c;

    /* renamed from: d */
    private int f10458d;

    /* renamed from: e */
    private int f10459e;

    public NestRecyclerview(@NonNull Context context) {
        super(context, null);
        this.f10456b = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent e2) {
        boolean z;
        int actionMasked = MotionEventCompat.getActionMasked(e2);
        int actionIndex = MotionEventCompat.getActionIndex(e2);
        if (actionMasked == 0) {
            this.f10456b = MotionEventCompat.getPointerId(e2, 0);
            this.f10457c = (int) (e2.getX() + 0.5f);
            this.f10458d = (int) (e2.getY() + 0.5f);
            return super.onInterceptTouchEvent(e2);
        }
        if (actionMasked != 2) {
            if (actionMasked != 5) {
                return super.onInterceptTouchEvent(e2);
            }
            this.f10456b = MotionEventCompat.getPointerId(e2, actionIndex);
            this.f10457c = (int) (MotionEventCompat.getX(e2, actionIndex) + 0.5f);
            this.f10458d = (int) (MotionEventCompat.getY(e2, actionIndex) + 0.5f);
            return super.onInterceptTouchEvent(e2);
        }
        int findPointerIndex = MotionEventCompat.findPointerIndex(e2, this.f10456b);
        if (findPointerIndex < 0) {
            return false;
        }
        int x = (int) (MotionEventCompat.getX(e2, findPointerIndex) + 0.5f);
        int y = (int) (MotionEventCompat.getY(e2, findPointerIndex) + 0.5f);
        if (getScrollState() == 1) {
            return super.onInterceptTouchEvent(e2);
        }
        int i2 = x - this.f10457c;
        int i3 = y - this.f10458d;
        if (getLayoutManager() != null) {
            boolean canScrollHorizontally = getLayoutManager().canScrollHorizontally();
            boolean canScrollVertically = getLayoutManager().canScrollVertically();
            z = canScrollHorizontally && Math.abs(i2) > this.f10459e && (Math.abs(i2) >= Math.abs(i3) || canScrollVertically);
            if (canScrollVertically && Math.abs(i3) > this.f10459e && (Math.abs(i3) >= Math.abs(i2) || canScrollHorizontally)) {
                z = true;
            }
        } else {
            z = false;
        }
        return z && super.onInterceptTouchEvent(e2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int slopConstant) {
        super.setScrollingTouchSlop(slopConstant);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (slopConstant == 0) {
            this.f10459e = viewConfiguration.getScaledTouchSlop();
        } else {
            if (slopConstant != 1) {
                return;
            }
            this.f10459e = ViewConfigurationCompat.getScaledPagingTouchSlop(viewConfiguration);
        }
    }

    public NestRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        this.f10456b = -1;
    }

    public NestRecyclerview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f10456b = -1;
        this.f10459e = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
