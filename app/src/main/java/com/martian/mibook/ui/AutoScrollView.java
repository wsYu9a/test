package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/* loaded from: classes4.dex */
public class AutoScrollView extends ScrollView {

    /* renamed from: a, reason: collision with root package name */
    private boolean f14139a;

    /* renamed from: b, reason: collision with root package name */
    private int f14140b;

    /* renamed from: c, reason: collision with root package name */
    private long f14141c;

    public AutoScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void a() {
        boolean z = !this.f14139a;
        this.f14139a = z;
        if (z) {
            computeScroll();
        }
    }

    public void b() {
        this.f14139a = true;
        computeScroll();
    }

    public void c() {
        this.f14139a = false;
    }

    @Override // android.widget.ScrollView, android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.f14139a) {
            scrollBy(0, 1);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent ev) {
        c();
        return super.onTouchEvent(ev);
    }

    public AutoScrollView(Context context) {
        super(context);
    }

    public AutoScrollView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
}
