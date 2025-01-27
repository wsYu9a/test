package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes3.dex */
public class LockableViewPager extends ViewPager {

    /* renamed from: b */
    public boolean f15844b;

    public LockableViewPager(@NonNull Context context) {
        super(context);
        this.f15844b = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f15844b) {
            try {
                if (motionEvent.getActionIndex() >= motionEvent.getPointerCount()) {
                    return false;
                }
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f15844b && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z10) {
        this.f15844b = z10;
    }

    public LockableViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15844b = true;
    }
}
