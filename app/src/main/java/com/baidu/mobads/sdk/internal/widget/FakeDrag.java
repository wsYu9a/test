package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class FakeDrag {

    /* renamed from: a */
    private final ViewPager2 f5872a;

    /* renamed from: b */
    private final ScrollEventAdapter f5873b;

    /* renamed from: c */
    private final RecyclerView f5874c;

    /* renamed from: d */
    private VelocityTracker f5875d;

    /* renamed from: e */
    private int f5876e;

    /* renamed from: f */
    private float f5877f;

    /* renamed from: g */
    private int f5878g;

    /* renamed from: h */
    private long f5879h;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f5872a = viewPager2;
        this.f5873b = scrollEventAdapter;
        this.f5874c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.f5875d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f5875d = VelocityTracker.obtain();
            this.f5876e = ViewConfiguration.get(this.f5872a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    boolean a() {
        return this.f5873b.g();
    }

    @UiThread
    boolean b() {
        if (this.f5873b.f()) {
            return false;
        }
        this.f5878g = 0;
        this.f5877f = 0;
        this.f5879h = SystemClock.uptimeMillis();
        d();
        this.f5873b.b();
        if (!this.f5873b.e()) {
            this.f5874c.stopScroll();
        }
        a(this.f5879h, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    boolean c() {
        if (!this.f5873b.g()) {
            return false;
        }
        this.f5873b.c();
        VelocityTracker velocityTracker = this.f5875d;
        velocityTracker.computeCurrentVelocity(1000, this.f5876e);
        if (this.f5874c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f5872a.d();
        return true;
    }

    @UiThread
    boolean a(float f2) {
        if (!this.f5873b.g()) {
            return false;
        }
        float f3 = this.f5877f - f2;
        this.f5877f = f3;
        int round = Math.round(f3 - this.f5878g);
        this.f5878g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = this.f5872a.getOrientation() == 0;
        int i2 = z ? round : 0;
        int i3 = z ? 0 : round;
        float f4 = z ? this.f5877f : 0.0f;
        float f5 = z ? 0.0f : this.f5877f;
        this.f5874c.scrollBy(i2, i3);
        a(uptimeMillis, 2, f4, f5);
        return true;
    }

    private void a(long j2, int i2, float f2, float f3) {
        MotionEvent obtain = MotionEvent.obtain(this.f5879h, j2, i2, f2, f3, 0);
        this.f5875d.addMovement(obtain);
        obtain.recycle();
    }
}
