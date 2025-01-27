package com.baidu.mobads.sdk.internal.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
final class FakeDrag {

    /* renamed from: a */
    private final ViewPager2 f7256a;

    /* renamed from: b */
    private final ScrollEventAdapter f7257b;

    /* renamed from: c */
    private final RecyclerView f7258c;

    /* renamed from: d */
    private VelocityTracker f7259d;

    /* renamed from: e */
    private int f7260e;

    /* renamed from: f */
    private float f7261f;

    /* renamed from: g */
    private int f7262g;

    /* renamed from: h */
    private long f7263h;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f7256a = viewPager2;
        this.f7257b = scrollEventAdapter;
        this.f7258c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.f7259d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f7259d = VelocityTracker.obtain();
            this.f7260e = ViewConfiguration.get(this.f7256a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    public boolean a() {
        return this.f7257b.g();
    }

    @UiThread
    public boolean b() {
        if (this.f7257b.f()) {
            return false;
        }
        this.f7262g = 0;
        this.f7261f = 0;
        this.f7263h = SystemClock.uptimeMillis();
        d();
        this.f7257b.b();
        if (!this.f7257b.e()) {
            this.f7258c.stopScroll();
        }
        a(this.f7263h, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    public boolean c() {
        if (!this.f7257b.g()) {
            return false;
        }
        this.f7257b.c();
        VelocityTracker velocityTracker = this.f7259d;
        velocityTracker.computeCurrentVelocity(1000, this.f7260e);
        if (this.f7258c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f7256a.d();
        return true;
    }

    @UiThread
    public boolean a(float f10) {
        if (!this.f7257b.g()) {
            return false;
        }
        float f11 = this.f7261f - f10;
        this.f7261f = f11;
        int round = Math.round(f11 - this.f7262g);
        this.f7262g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z10 = this.f7256a.getOrientation() == 0;
        int i10 = z10 ? round : 0;
        int i11 = z10 ? 0 : round;
        float f12 = z10 ? this.f7261f : 0.0f;
        float f13 = z10 ? 0.0f : this.f7261f;
        this.f7258c.scrollBy(i10, i11);
        a(uptimeMillis, 2, f12, f13);
        return true;
    }

    private void a(long j10, int i10, float f10, float f11) {
        MotionEvent obtain = MotionEvent.obtain(this.f7263h, j10, i10, f10, f11, 0);
        this.f7259d.addMovement(obtain);
        obtain.recycle();
    }
}
