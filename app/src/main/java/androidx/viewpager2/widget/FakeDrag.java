package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
final class FakeDrag {

    /* renamed from: a */
    private final ViewPager2 f4103a;

    /* renamed from: b */
    private final ScrollEventAdapter f4104b;

    /* renamed from: c */
    private final RecyclerView f4105c;

    /* renamed from: d */
    private VelocityTracker f4106d;

    /* renamed from: e */
    private int f4107e;

    /* renamed from: f */
    private float f4108f;

    /* renamed from: g */
    private int f4109g;

    /* renamed from: h */
    private long f4110h;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f4103a = viewPager2;
        this.f4104b = scrollEventAdapter;
        this.f4105c = recyclerView;
    }

    private void a(long j2, int i2, float f2, float f3) {
        MotionEvent obtain = MotionEvent.obtain(this.f4110h, j2, i2, f2, f3, 0);
        this.f4106d.addMovement(obtain);
        obtain.recycle();
    }

    private void c() {
        VelocityTracker velocityTracker = this.f4106d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f4106d = VelocityTracker.obtain();
            this.f4107e = ViewConfiguration.get(this.f4103a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    @UiThread
    boolean b() {
        if (this.f4104b.p()) {
            return false;
        }
        this.f4109g = 0;
        this.f4108f = 0;
        this.f4110h = SystemClock.uptimeMillis();
        c();
        this.f4104b.t();
        if (!this.f4104b.r()) {
            this.f4105c.stopScroll();
        }
        a(this.f4110h, 0, 0.0f, 0.0f);
        return true;
    }

    @UiThread
    boolean d() {
        if (!this.f4104b.q()) {
            return false;
        }
        this.f4104b.v();
        VelocityTracker velocityTracker = this.f4106d;
        velocityTracker.computeCurrentVelocity(1000, this.f4107e);
        if (this.f4105c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f4103a.h();
        return true;
    }

    @UiThread
    boolean e(float f2) {
        if (!this.f4104b.q()) {
            return false;
        }
        float f3 = this.f4108f - f2;
        this.f4108f = f3;
        int round = Math.round(f3 - this.f4109g);
        this.f4109g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = this.f4103a.getOrientation() == 0;
        int i2 = z ? round : 0;
        int i3 = z ? 0 : round;
        float f4 = z ? this.f4108f : 0.0f;
        float f5 = z ? 0.0f : this.f4108f;
        this.f4105c.scrollBy(i2, i3);
        a(uptimeMillis, 2, f4, f5);
        return true;
    }

    boolean f() {
        return this.f4104b.q();
    }
}
