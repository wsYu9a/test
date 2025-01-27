package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes4.dex */
public class MyViewPager extends ViewPager {

    /* renamed from: a */
    private boolean f14163a;

    public MyViewPager(@NonNull Context context) {
        super(context);
        this.f14163a = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return this.f14163a && super.onInterceptTouchEvent(ev);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        return this.f14163a && super.onTouchEvent(ev);
    }

    public void setScrollable(boolean scrollable) {
        this.f14163a = scrollable;
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.f14163a = true;
    }
}
