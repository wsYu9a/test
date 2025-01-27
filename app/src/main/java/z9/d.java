package z9;

import android.os.Bundle;
import android.view.View;
import com.martian.libsliding.SlidingLayout;

/* loaded from: classes3.dex */
public abstract class d<T> {

    /* renamed from: a */
    public final View[] f33717a = new View[3];

    /* renamed from: b */
    public int f33718b = 0;

    /* renamed from: c */
    public SlidingLayout f33719c;

    public void A(SlidingLayout slidingLayout) {
        this.f33719c = slidingLayout;
    }

    public final void B(int i10, View view) {
        this.f33717a[(i10 + 3) % 3] = view;
    }

    public abstract void b();

    public abstract void c();

    public abstract T d();

    public View e() {
        View view = this.f33717a[this.f33718b];
        if (view != null) {
            return view;
        }
        View o10 = o(null, d());
        this.f33717a[this.f33718b] = o10;
        return o10;
    }

    public abstract T f();

    public View g() {
        return n(this.f33718b + 1);
    }

    public abstract T h();

    public View i() {
        return n(this.f33718b - 1);
    }

    public SlidingLayout j() {
        return this.f33719c;
    }

    public View k() {
        View view = this.f33717a[this.f33718b];
        if (view == null) {
            View o10 = o(null, d());
            this.f33717a[this.f33718b] = o10;
            return o10;
        }
        View o11 = o(view, d());
        if (view == o11) {
            return view;
        }
        this.f33717a[this.f33718b] = o11;
        return o11;
    }

    public View l() {
        View o10;
        View n10 = n(this.f33718b + 1);
        boolean p10 = p();
        if (n10 == null && p10) {
            View o11 = o(null, f());
            B(this.f33718b + 1, o11);
            return o11;
        }
        if (!p10 || (o10 = o(n10, f())) == n10) {
            return n10;
        }
        B(this.f33718b + 1, o10);
        return o10;
    }

    public View m() {
        View o10;
        View n10 = n(this.f33718b - 1);
        boolean q10 = q();
        if (n10 == null && q10) {
            View o11 = o(null, h());
            B(this.f33718b - 1, o11);
            return o11;
        }
        if (!q10 || (o10 = o(n10, h())) == n10) {
            return n10;
        }
        B(this.f33718b - 1, o10);
        return o10;
    }

    public View n(int i10) {
        return this.f33717a[(i10 + 3) % 3];
    }

    public abstract View o(View view, T t10);

    public abstract boolean p();

    public abstract boolean q();

    public final /* synthetic */ void r() {
        if (this.f33719c.getSlider() != null) {
            this.f33719c.getSlider().a();
        }
        this.f33719c.invalidate();
    }

    public void s() {
        if (p()) {
            b();
            this.f33718b = (this.f33718b + 1) % 3;
        }
    }

    public void t() {
        if (q()) {
            c();
            this.f33718b = (this.f33718b + 2) % 3;
        }
    }

    public void u() {
        SlidingLayout slidingLayout = this.f33719c;
        if (slidingLayout != null) {
            slidingLayout.post(new Runnable() { // from class: z9.c
                public /* synthetic */ c() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.this.r();
                }
            });
        }
    }

    public void w() {
        this.f33718b = 0;
        View[] viewArr = this.f33717a;
        viewArr[0] = null;
        viewArr[1] = null;
        viewArr[2] = null;
    }

    public Bundle x() {
        return null;
    }

    public void y(View view) {
        B(this.f33718b + 1, view);
    }

    public void z(View view) {
        B(this.f33718b - 1, view);
    }

    public void v() {
    }
}
