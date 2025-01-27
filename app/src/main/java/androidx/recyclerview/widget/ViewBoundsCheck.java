package androidx.recyclerview.widget;

import android.view.View;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
class ViewBoundsCheck {

    /* renamed from: a, reason: collision with root package name */
    static final int f3530a = 1;

    /* renamed from: b, reason: collision with root package name */
    static final int f3531b = 2;

    /* renamed from: c, reason: collision with root package name */
    static final int f3532c = 4;

    /* renamed from: d, reason: collision with root package name */
    static final int f3533d = 0;

    /* renamed from: e, reason: collision with root package name */
    static final int f3534e = 1;

    /* renamed from: f, reason: collision with root package name */
    static final int f3535f = 2;

    /* renamed from: g, reason: collision with root package name */
    static final int f3536g = 4;

    /* renamed from: h, reason: collision with root package name */
    static final int f3537h = 4;

    /* renamed from: i, reason: collision with root package name */
    static final int f3538i = 16;

    /* renamed from: j, reason: collision with root package name */
    static final int f3539j = 32;
    static final int k = 64;
    static final int l = 8;
    static final int m = 256;
    static final int n = 512;
    static final int o = 1024;
    static final int p = 12;
    static final int q = 4096;
    static final int r = 8192;
    static final int s = 16384;
    static final int t = 7;
    final Callback u;
    BoundFlags v = new BoundFlags();

    static class BoundFlags {

        /* renamed from: a, reason: collision with root package name */
        int f3540a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f3541b;

        /* renamed from: c, reason: collision with root package name */
        int f3542c;

        /* renamed from: d, reason: collision with root package name */
        int f3543d;

        /* renamed from: e, reason: collision with root package name */
        int f3544e;

        BoundFlags() {
        }

        void a(int i2) {
            this.f3540a = i2 | this.f3540a;
        }

        boolean b() {
            int i2 = this.f3540a;
            if ((i2 & 7) != 0 && (i2 & (c(this.f3543d, this.f3541b) << 0)) == 0) {
                return false;
            }
            int i3 = this.f3540a;
            if ((i3 & 112) != 0 && (i3 & (c(this.f3543d, this.f3542c) << 4)) == 0) {
                return false;
            }
            int i4 = this.f3540a;
            if ((i4 & 1792) != 0 && (i4 & (c(this.f3544e, this.f3541b) << 8)) == 0) {
                return false;
            }
            int i5 = this.f3540a;
            return (i5 & 28672) == 0 || (i5 & (c(this.f3544e, this.f3542c) << 12)) != 0;
        }

        int c(int i2, int i3) {
            if (i2 > i3) {
                return 1;
            }
            return i2 == i3 ? 2 : 4;
        }

        void d() {
            this.f3540a = 0;
        }

        void e(int i2, int i3, int i4, int i5) {
            this.f3541b = i2;
            this.f3542c = i3;
            this.f3543d = i4;
            this.f3544e = i5;
        }
    }

    interface Callback {
        View getChildAt(int i2);

        int getChildEnd(View view);

        int getChildStart(View view);

        int getParentEnd();

        int getParentStart();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewBounds {
    }

    ViewBoundsCheck(Callback callback) {
        this.u = callback;
    }

    View a(int i2, int i3, int i4, int i5) {
        int parentStart = this.u.getParentStart();
        int parentEnd = this.u.getParentEnd();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View childAt = this.u.getChildAt(i2);
            this.v.e(parentStart, parentEnd, this.u.getChildStart(childAt), this.u.getChildEnd(childAt));
            if (i4 != 0) {
                this.v.d();
                this.v.a(i4);
                if (this.v.b()) {
                    return childAt;
                }
            }
            if (i5 != 0) {
                this.v.d();
                this.v.a(i5);
                if (this.v.b()) {
                    view = childAt;
                }
            }
            i2 += i6;
        }
        return view;
    }

    boolean b(View view, int i2) {
        this.v.e(this.u.getParentStart(), this.u.getParentEnd(), this.u.getChildStart(view), this.u.getChildEnd(view));
        if (i2 == 0) {
            return false;
        }
        this.v.d();
        this.v.a(i2);
        return this.v.b();
    }
}
