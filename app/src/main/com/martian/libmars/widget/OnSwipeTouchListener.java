package com.martian.libmars.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import n9.m;

/* loaded from: classes3.dex */
public class OnSwipeTouchListener implements View.OnTouchListener {

    /* renamed from: b */
    public final GestureDetector f12662b;

    public final class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: c */
        public static final int f12663c = 100;

        /* renamed from: d */
        public static final int f12664d = 100;

        public /* synthetic */ a(OnSwipeTouchListener onSwipeTouchListener, m mVar) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (motionEvent != null && motionEvent2 != null) {
                float x10 = motionEvent2.getX() - motionEvent.getX();
                if (Math.abs(x10) > Math.abs(motionEvent2.getY() - motionEvent.getY()) && Math.abs(x10) > 100.0f && Math.abs(f10) > 100.0f) {
                    if (x10 > 0.0f) {
                        OnSwipeTouchListener.this.c();
                        return true;
                    }
                    OnSwipeTouchListener.this.b();
                    return true;
                }
            }
            return false;
        }

        public a() {
        }
    }

    public OnSwipeTouchListener(Context context) {
        this.f12662b = new GestureDetector(context, new a());
    }

    public GestureDetector a() {
        return this.f12662b;
    }

    public void b() {
    }

    public void c() {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f12662b.onTouchEvent(motionEvent);
    }
}
