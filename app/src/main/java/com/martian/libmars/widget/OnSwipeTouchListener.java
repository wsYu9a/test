package com.martian.libmars.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public class OnSwipeTouchListener implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private final GestureDetector f10356a;

    private final class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        private static final int f10357a = 100;

        /* renamed from: b, reason: collision with root package name */
        private static final int f10358b = 100;

        private b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent e2) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1 != null && e2 != null) {
                float x = e2.getX() - e1.getX();
                if (Math.abs(x) > Math.abs(e2.getY() - e1.getY()) && Math.abs(x) > 100.0f && Math.abs(velocityX) > 100.0f) {
                    if (x > 0.0f) {
                        OnSwipeTouchListener.this.c();
                        return true;
                    }
                    OnSwipeTouchListener.this.b();
                    return true;
                }
            }
            return false;
        }
    }

    public OnSwipeTouchListener(Context ctx) {
        this.f10356a = new GestureDetector(ctx, new b());
    }

    public GestureDetector a() {
        return this.f10356a;
    }

    public void b() {
    }

    public void c() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        return this.f10356a.onTouchEvent(event);
    }
}
