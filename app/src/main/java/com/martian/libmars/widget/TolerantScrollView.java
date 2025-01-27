package com.martian.libmars.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import n9.l;

/* loaded from: classes3.dex */
public class TolerantScrollView extends ScrollView {

    /* renamed from: b */
    public final GestureDetector f12698b;

    /* renamed from: c */
    public View.OnTouchListener f12699c;

    /* renamed from: d */
    public l f12700d;

    public static class a extends GestureDetector.SimpleOnGestureListener {
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return Math.abs(f11) > Math.abs(f10);
        }
    }

    public TolerantScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12698b = new GestureDetector(context, new a());
        setFadingEdgeLength(0);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent) && this.f12698b.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onScrollChanged(int i10, int i11, int i12, int i13) {
        super.onScrollChanged(i10, i11, i12, i13);
        l lVar = this.f12700d;
        if (lVar != null) {
            lVar.onScrollChanged(i10, i11, i12, i13);
        }
    }

    public void setOnScrollChangedListener(l lVar) {
        this.f12700d = lVar;
    }
}
