package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class MartianNonSwipeableViewPager extends ViewPager {
    public MartianNonSwipeableViewPager(Context context) {
        super(context);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    public MartianNonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
