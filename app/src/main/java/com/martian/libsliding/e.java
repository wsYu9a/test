package com.martian.libsliding;

import android.os.Bundle;
import android.view.View;

/* loaded from: classes3.dex */
public abstract class e<T> {

    /* renamed from: a */
    private final View[] f10517a = new View[3];

    /* renamed from: b */
    private int f10518b = 0;

    /* renamed from: c */
    private SlidingLayout f10519c;

    private void C(int index, View view) {
        this.f10517a[(index + 3) % 3] = view;
    }

    private View m(int index) {
        return this.f10517a[(index + 3) % 3];
    }

    /* renamed from: q */
    public /* synthetic */ void r() {
        this.f10519c.s();
    }

    public void A(View view) {
        C(this.f10518b - 1, view);
    }

    public void B(SlidingLayout slidingLayout) {
        this.f10519c = slidingLayout;
    }

    protected abstract void a();

    protected abstract void b();

    public abstract T c();

    public View d() {
        View view = this.f10517a[this.f10518b];
        if (view != null) {
            return view;
        }
        View n = n(null, c());
        this.f10517a[this.f10518b] = n;
        return n;
    }

    public abstract T e();

    public View f() {
        View m = m(this.f10518b + 1);
        if (m != null || !o()) {
            return m;
        }
        View n = n(null, e());
        C(this.f10518b + 1, n);
        return n;
    }

    public abstract T g();

    public View h() {
        View m = m(this.f10518b - 1);
        if (m != null || !p()) {
            return m;
        }
        View n = n(null, g());
        C(this.f10518b - 1, n);
        return n;
    }

    public SlidingLayout i() {
        return this.f10519c;
    }

    public View j() {
        View view = this.f10517a[this.f10518b];
        if (view == null) {
            View n = n(null, c());
            this.f10517a[this.f10518b] = n;
            return n;
        }
        View n2 = n(view, c());
        if (view == n2) {
            return view;
        }
        this.f10517a[this.f10518b] = n2;
        return n2;
    }

    public View k() {
        View n;
        View m = m(this.f10518b + 1);
        boolean o = o();
        if (m == null && o) {
            View n2 = n(null, e());
            C(this.f10518b + 1, n2);
            return n2;
        }
        if (!o || (n = n(m, e())) == m) {
            return m;
        }
        C(this.f10518b + 1, n);
        return n;
    }

    public View l() {
        View n;
        View m = m(this.f10518b - 1);
        boolean p = p();
        if (m == null && p) {
            View n2 = n(null, g());
            C(this.f10518b - 1, n2);
            return n2;
        }
        if (!p || (n = n(m, g())) == m) {
            return m;
        }
        C(this.f10518b - 1, n);
        return n;
    }

    public abstract View n(View contentView, T t);

    public abstract boolean o();

    public abstract boolean p();

    public boolean s() {
        if (!o()) {
            return false;
        }
        a();
        this.f10518b = (this.f10518b + 1) % 3;
        return true;
    }

    public boolean t() {
        if (!p()) {
            return false;
        }
        b();
        this.f10518b = (this.f10518b + 2) % 3;
        return true;
    }

    public void u() {
        SlidingLayout slidingLayout = this.f10519c;
        if (slidingLayout != null) {
            slidingLayout.post(new Runnable() { // from class: com.martian.libsliding.a
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.r();
                }
            });
        }
    }

    public void v() {
    }

    public void w() {
        this.f10518b = 0;
        View[] viewArr = this.f10517a;
        viewArr[0] = null;
        viewArr[1] = null;
        viewArr[2] = null;
    }

    public Bundle x() {
        return null;
    }

    public void y(View view) {
        C(this.f10518b, view);
    }

    public void z(View view) {
        C(this.f10518b + 1, view);
    }
}
