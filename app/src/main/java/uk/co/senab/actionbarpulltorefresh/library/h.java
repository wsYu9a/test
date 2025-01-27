package uk.co.senab.actionbarpulltorefresh.library;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.WeakHashMap;

@TargetApi(14)
/* loaded from: classes5.dex */
public class h {

    /* renamed from: a */
    private static final boolean f37171a = false;

    /* renamed from: b */
    private static final String f37172b = "PullToRefreshAttacher";

    /* renamed from: c */
    private d f37173c;

    /* renamed from: d */
    private e f37174d;

    /* renamed from: e */
    private uk.co.senab.actionbarpulltorefresh.library.i.b f37175e;

    /* renamed from: f */
    private Activity f37176f;

    /* renamed from: g */
    private View f37177g;

    /* renamed from: h */
    private uk.co.senab.actionbarpulltorefresh.library.i.a f37178h;

    /* renamed from: i */
    private final int f37179i;

    /* renamed from: j */
    private final float f37180j;
    private float k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private boolean p;
    private boolean q;
    private View r;
    private final WeakHashMap<View, uk.co.senab.actionbarpulltorefresh.library.k.c> s;
    private final boolean t;
    private final int u;
    private final boolean v;
    private final c z;
    private boolean w = false;
    private final int[] x = new int[2];
    private final Rect y = new Rect();
    private final Runnable A = new b();

    class a implements d {
        a() {
        }

        @Override // uk.co.senab.actionbarpulltorefresh.library.d
        public Context a(Activity activity) {
            ActionBar actionBar;
            Context themedContext = (Build.VERSION.SDK_INT < 14 || (actionBar = activity.getActionBar()) == null) ? null : actionBar.getThemedContext();
            return themedContext == null ? activity : themedContext;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.s();
        }
    }

    private class c implements Runnable {
        private c() {
        }

        private View d() {
            return h.this.k().getWindow().getDecorView();
        }

        public void c() {
            d().removeCallbacks(this);
        }

        public void e() {
            d().post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.p()) {
                return;
            }
            if (d().getWindowToken() == null) {
                e();
            } else {
                h hVar = h.this;
                hVar.c(hVar.f37177g);
            }
        }

        /* synthetic */ c(h hVar, a aVar) {
            this();
        }
    }

    protected h(Activity activity, g gVar) {
        if (activity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        if (gVar == null) {
            Log.i(f37172b, "Given null options so using default options.");
            gVar = new g();
        }
        this.f37176f = activity;
        this.s = new WeakHashMap<>();
        this.f37180j = gVar.f37168i;
        this.t = gVar.f37169j;
        this.u = gVar.k;
        this.v = gVar.l;
        d dVar = gVar.f37165f;
        this.f37173c = dVar == null ? h() : dVar;
        e eVar = gVar.f37167h;
        this.f37174d = eVar == null ? i() : eVar;
        this.f37179i = ViewConfiguration.get(activity).getScaledTouchSlop();
        View inflate = LayoutInflater.from(this.f37173c.a(activity)).inflate(gVar.f37166g, (ViewGroup) activity.getWindow().getDecorView(), false);
        this.f37177g = inflate;
        if (inflate == null) {
            throw new IllegalArgumentException("Must supply valid layout id for header.");
        }
        inflate.setVisibility(4);
        this.f37174d.h(activity, this.f37177g);
        c cVar = new c(this, null);
        this.z = cVar;
        cVar.e();
    }

    private void A(boolean z) {
        this.p = false;
        if (this.v) {
            m().removeCallbacks(this.A);
        }
        o();
    }

    private void G(View view, boolean z, boolean z2) {
        if (p() || this.p == z) {
            return;
        }
        B();
        if (z && e(z2)) {
            I(view, z2);
        } else {
            A(z2);
        }
    }

    private void I(View view, boolean z) {
        uk.co.senab.actionbarpulltorefresh.library.i.b bVar;
        this.p = true;
        if (z && (bVar = this.f37175e) != null) {
            bVar.a(view);
        }
        this.f37174d.e();
        H();
        if (this.v) {
            if (this.u > 0) {
                m().postDelayed(this.A, this.u);
            } else {
                m().post(this.A);
            }
        }
    }

    private boolean e(boolean z) {
        return (this.p || (z && this.f37175e == null)) ? false : true;
    }

    private boolean f(View view) {
        if (!this.o || !this.t || view == null || this.l - this.m < n(view)) {
            return false;
        }
        G(view, true, true);
        return true;
    }

    private float n(View view) {
        return view.getHeight() * this.f37180j;
    }

    public boolean p() {
        if (this.w) {
            Log.i(f37172b, "PullToRefreshAttacher is destroyed.");
        }
        return this.w;
    }

    void B() {
        this.o = false;
        this.q = false;
        this.m = -1.0f;
        this.l = -1.0f;
        this.k = -1.0f;
    }

    final void C(uk.co.senab.actionbarpulltorefresh.library.i.a aVar) {
        this.f37178h = aVar;
    }

    void D(uk.co.senab.actionbarpulltorefresh.library.i.b bVar) {
        this.f37175e = bVar;
    }

    final void E() {
        G(null, false, false);
    }

    final void F(boolean z) {
        G(null, z, false);
    }

    void H() {
        uk.co.senab.actionbarpulltorefresh.library.i.a aVar;
        J(this.f37177g);
        if (!this.f37174d.i() || (aVar = this.f37178h) == null) {
            return;
        }
        aVar.a(this.f37177g, 0);
    }

    protected void J(View view) {
        this.f37176f.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.y);
        WindowManager.LayoutParams layoutParams = view.getLayoutParams() instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) view.getLayoutParams() : view.getTag() instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) view.getTag() : null;
        if (layoutParams != null) {
            int i2 = layoutParams.y;
            int i3 = this.y.top;
            if (i2 != i3) {
                layoutParams.y = i3;
                this.f37176f.getWindowManager().updateViewLayout(view, layoutParams);
            }
        }
    }

    void K(Class<?> cls, uk.co.senab.actionbarpulltorefresh.library.k.c cVar) {
        for (View view : this.s.keySet()) {
            if (cls.isInstance(view)) {
                this.s.put(view, cVar);
            }
        }
    }

    protected void c(View view) {
        int i2;
        int i3;
        this.f37176f.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.y);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int i4 = layoutParams.width;
            i3 = layoutParams.height;
            i2 = i4;
        } else {
            i2 = -1;
            i3 = -2;
        }
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, i3, 1000, 280, -3);
        layoutParams2.x = 0;
        layoutParams2.y = this.y.top;
        layoutParams2.gravity = 48;
        view.setTag(layoutParams2);
        this.f37176f.getWindowManager().addView(view, layoutParams2);
    }

    void d(View view, uk.co.senab.actionbarpulltorefresh.library.k.c cVar) {
        if (p()) {
            return;
        }
        if (view == null) {
            Log.i(f37172b, "Refreshable View is null.");
            return;
        }
        if (cVar == null) {
            cVar = f.b(view);
        }
        this.s.put(view, cVar);
    }

    void g() {
        this.s.clear();
    }

    protected d h() {
        return new a();
    }

    protected e i() {
        return new uk.co.senab.actionbarpulltorefresh.library.c();
    }

    void j() {
        if (this.w) {
            return;
        }
        z(this.f37177g);
        g();
        this.f37176f = null;
        this.f37177g = null;
        this.f37178h = null;
        this.f37173c = null;
        this.f37174d = null;
        this.w = true;
    }

    protected final Activity k() {
        return this.f37176f;
    }

    e l() {
        return this.f37174d;
    }

    final View m() {
        return this.f37177g;
    }

    void o() {
        uk.co.senab.actionbarpulltorefresh.library.i.a aVar;
        if (!this.f37174d.a() || (aVar = this.f37178h) == null) {
            return;
        }
        aVar.a(this.f37177g, 2);
    }

    final boolean q() {
        return this.p;
    }

    final boolean r(View view, MotionEvent motionEvent) {
        uk.co.senab.actionbarpulltorefresh.library.k.c cVar;
        if (view.isShown() && this.s.containsKey(view)) {
            view.getLocationOnScreen(this.x);
            int[] iArr = this.x;
            int i2 = iArr[0];
            int i3 = iArr[1];
            this.y.set(i2, i3, view.getWidth() + i2, view.getHeight() + i3);
            if (this.y.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && (cVar = this.s.get(view)) != null) {
                Rect rect = this.y;
                return cVar.a(view, r0 - rect.left, r8 - rect.top);
            }
        }
        return false;
    }

    void s() {
        if (p()) {
            return;
        }
        this.f37174d.d();
        uk.co.senab.actionbarpulltorefresh.library.i.a aVar = this.f37178h;
        if (aVar != null) {
            aVar.a(this.f37177g, 1);
        }
    }

    public void t(Configuration configuration) {
        this.f37174d.b(this.f37176f, configuration);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r2 != 3) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean u(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.q()
            if (r0 == 0) goto L8
            r6 = 0
            return r6
        L8:
            float r0 = r6.getX()
            float r1 = r6.getY()
            int r2 = r6.getAction()
            r3 = 1
            if (r2 == 0) goto L59
            if (r2 == r3) goto L55
            r6 = 2
            if (r2 == r6) goto L20
            r6 = 3
            if (r2 == r6) goto L55
            goto L82
        L20:
            boolean r6 = r5.o
            if (r6 != 0) goto L82
            float r6 = r5.k
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L82
            float r6 = r1 - r6
            float r2 = r5.n
            float r0 = r0 - r2
            float r2 = java.lang.Math.abs(r6)
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L49
            int r0 = r5.f37179i
            float r0 = (float) r0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L49
            r5.o = r3
            r5.x(r1)
            goto L82
        L49:
            int r0 = r5.f37179i
            int r0 = -r0
            float r0 = (float) r0
            int r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r6 >= 0) goto L82
            r5.B()
            goto L82
        L55:
            r5.B()
            goto L82
        L59:
            boolean r2 = r5.e(r3)
            if (r2 == 0) goto L82
            java.util.WeakHashMap<android.view.View, uk.co.senab.actionbarpulltorefresh.library.k.c> r2 = r5.s
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L69:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L82
            java.lang.Object r3 = r2.next()
            android.view.View r3 = (android.view.View) r3
            boolean r4 = r5.r(r3, r6)
            if (r4 == 0) goto L69
            r5.n = r0
            r5.k = r1
            r5.r = r3
            goto L69
        L82:
            boolean r6 = r5.o
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.actionbarpulltorefresh.library.h.u(android.view.MotionEvent):boolean");
    }

    void v(View view, float f2) {
        float n = n(view);
        float f3 = f2 - this.m;
        if (f3 < n) {
            this.f37174d.c(f3 / n);
        } else if (this.t) {
            this.f37174d.f();
        } else {
            G(view, true, true);
        }
    }

    void w() {
        if (this.p) {
            return;
        }
        A(true);
    }

    void x(float f2) {
        H();
        this.m = f2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:
    
        if (r0 != 3) goto L77;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean y(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            if (r0 != 0) goto L9
            r4.q = r1
        L9:
            boolean r0 = r4.q
            if (r0 == 0) goto L15
            boolean r0 = r4.o
            if (r0 != 0) goto L15
            r4.u(r5)
            return r1
        L15:
            android.view.View r0 = r4.r
            r2 = 0
            if (r0 != 0) goto L1b
            return r2
        L1b:
            int r0 = r5.getAction()
            if (r0 == r1) goto L5b
            r3 = 2
            if (r0 == r3) goto L28
            r5 = 3
            if (r0 == r5) goto L5b
            goto L6a
        L28:
            boolean r0 = r4.q()
            if (r0 == 0) goto L2f
            return r2
        L2f:
            float r5 = r5.getY()
            boolean r0 = r4.o
            if (r0 == 0) goto L6a
            float r0 = r4.l
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 == 0) goto L6a
            float r0 = r5 - r0
            int r2 = r4.f37179i
            int r2 = -r2
            float r2 = (float) r2
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L54
            android.view.View r2 = r4.r
            r4.v(r2, r5)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L6a
            r4.l = r5
            goto L6a
        L54:
            r4.w()
            r4.B()
            goto L6a
        L5b:
            android.view.View r5 = r4.r
            r4.f(r5)
            boolean r5 = r4.o
            if (r5 == 0) goto L67
            r4.w()
        L67:
            r4.B()
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.actionbarpulltorefresh.library.h.y(android.view.MotionEvent):boolean");
    }

    protected void z(View view) {
        this.z.c();
        if (view.getWindowToken() != null) {
            this.f37176f.getWindowManager().removeViewImmediate(view);
        }
    }
}
