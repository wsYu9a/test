package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class d extends ViewPager {
    private int aDm;
    private boolean aDn;

    public d(@NonNull Context context) {
        super(context);
        this.aDn = false;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aDn = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.aDn) {
            return super.canScrollHorizontally(i2);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z;
        if (!this.aDn) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2) {
                int i2 = x - this.aDm;
                if (getCurrentItem() == 0 && i2 > 0) {
                    parent = getParent();
                    z = false;
                }
            }
            this.aDm = x;
            return super.dispatchTouchEvent(motionEvent);
        }
        parent = getParent();
        z = true;
        parent.requestDisallowInterceptTouchEvent(z);
        this.aDm = x;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.aDn && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.aDn && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.aDn = z;
    }
}
