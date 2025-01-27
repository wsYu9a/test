package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class TolerantScrollView extends ScrollView {

    /* renamed from: a */
    private final GestureDetector f10382a;

    /* renamed from: b */
    View.OnTouchListener f10383b;

    /* renamed from: c */
    private l f10384c;

    static class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceY) > Math.abs(distanceX);
        }
    }

    public TolerantScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f10382a = new GestureDetector(context, new a());
        setFadingEdgeLength(0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev) && this.f10382a.onTouchEvent(ev);
    }

    @Override // android.view.View
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        l lVar = this.f10384c;
        if (lVar != null) {
            lVar.onScrollChanged(l, t, oldl, oldt);
        }
    }

    public void setOnScrollChangedListener(l onScrollChangedListener) {
        this.f10384c = onScrollChangedListener;
    }
}
