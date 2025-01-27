package com.opos.mobad.n.c;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes4.dex */
public class n extends ViewPager {

    private class a implements ViewPager.PageTransformer {
        private a() {
        }

        /* synthetic */ a(n nVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f2) {
            if (f2 < -1.0f || f2 > 1.0f) {
                view.setAlpha(0.0f);
                return;
            }
            view.setAlpha(1.0f);
            view.setTranslationX(view.getWidth() * (-f2));
            view.setTranslationY(view.getHeight() * f2);
        }
    }

    public n(Context context) {
        super(context);
        a();
    }

    private MotionEvent a(MotionEvent motionEvent) {
        float width = getWidth();
        float height = getHeight();
        motionEvent.setLocation((motionEvent.getY() / height) * width, (motionEvent.getX() / width) * height);
        return motionEvent;
    }

    private void a() {
        setPageTransformer(true, new a());
        setOverScrollMode(2);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(a(motionEvent));
        a(motionEvent);
        return onInterceptTouchEvent;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(a(motionEvent));
    }
}
