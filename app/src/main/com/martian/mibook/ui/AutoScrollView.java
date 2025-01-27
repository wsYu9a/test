package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* loaded from: classes3.dex */
public class AutoScrollView extends ScrollView {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15804b;

    public AutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        boolean z10 = !this.f15804b;
        this.f15804b = z10;
        if (z10) {
            computeScroll();
        }
    }

    public void b() {
        this.f15804b = true;
        computeScroll();
    }

    public void c() {
        this.f15804b = false;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f15804b) {
            scrollBy(0, 1);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c();
        return super.onTouchEvent(motionEvent);
    }

    public AutoScrollView(Context context) {
        super(context);
    }

    public AutoScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
