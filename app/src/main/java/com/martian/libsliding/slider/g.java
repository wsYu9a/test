package com.martian.libsliding.slider;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes.dex */
public interface g {
    boolean a(Canvas canvas);

    boolean b(boolean changed, int l, int t, int r, int b2);

    void c(boolean fromTouch);

    void d();

    void e(SlidingLayout slidingLayout);

    void f(boolean fromTouch);

    void g();

    boolean h(MotionEvent event);

    boolean onTouchEvent(MotionEvent event);
}
