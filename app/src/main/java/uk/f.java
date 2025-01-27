package uk;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
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
public class f {
    public static final String A = "PullToRefreshAttacher";

    /* renamed from: z */
    public static final boolean f31180z = false;

    /* renamed from: a */
    public uk.c f31181a;

    /* renamed from: b */
    public d f31182b;

    /* renamed from: c */
    public vk.b f31183c;

    /* renamed from: d */
    public Activity f31184d;

    /* renamed from: e */
    public View f31185e;

    /* renamed from: f */
    public vk.a f31186f;

    /* renamed from: g */
    public final int f31187g;

    /* renamed from: h */
    public final float f31188h;

    /* renamed from: i */
    public float f31189i;

    /* renamed from: j */
    public float f31190j;

    /* renamed from: k */
    public float f31191k;

    /* renamed from: l */
    public float f31192l;

    /* renamed from: m */
    public boolean f31193m;

    /* renamed from: n */
    public boolean f31194n;

    /* renamed from: o */
    public boolean f31195o;

    /* renamed from: p */
    public View f31196p;

    /* renamed from: q */
    public final WeakHashMap<View, xk.c> f31197q;

    /* renamed from: r */
    public final boolean f31198r;

    /* renamed from: s */
    public final int f31199s;

    /* renamed from: t */
    public final boolean f31200t;

    /* renamed from: x */
    public final c f31204x;

    /* renamed from: u */
    public boolean f31201u = false;

    /* renamed from: v */
    public final int[] f31202v = new int[2];

    /* renamed from: w */
    public final Rect f31203w = new Rect();

    /* renamed from: y */
    public final Runnable f31205y = new b();

    public class a implements uk.c {
        public a() {
        }

        @Override // uk.c
        public Context a(Activity activity) {
            ActionBar actionBar = activity.getActionBar();
            Context themedContext = actionBar != null ? actionBar.getThemedContext() : null;
            return themedContext == null ? activity : themedContext;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.s();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void a() {
            b().removeCallbacks(this);
        }

        public final View b() {
            return f.this.k().getWindow().getDecorView();
        }

        public void c() {
            b().post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.p()) {
                return;
            }
            if (b().getWindowToken() == null) {
                c();
            } else {
                f fVar = f.this;
                fVar.c(fVar.f31185e);
            }
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this();
        }
    }

    public f(Activity activity, uk.co.senab.actionbarpulltorefresh.library.b bVar) {
        if (activity == null) {
            throw new IllegalArgumentException("activity cannot be null");
        }
        if (bVar == null) {
            Log.i(A, "Given null options so using default options.");
            bVar = new uk.co.senab.actionbarpulltorefresh.library.b();
        }
        this.f31184d = activity;
        this.f31197q = new WeakHashMap<>();
        this.f31188h = bVar.f31171d;
        this.f31198r = bVar.f31172e;
        this.f31199s = bVar.f31173f;
        this.f31200t = bVar.f31174g;
        uk.c cVar = bVar.f31168a;
        this.f31181a = cVar == null ? h() : cVar;
        d dVar = bVar.f31170c;
        this.f31182b = dVar == null ? i() : dVar;
        this.f31187g = ViewConfiguration.get(activity).getScaledTouchSlop();
        View inflate = LayoutInflater.from(this.f31181a.a(activity)).inflate(bVar.f31169b, (ViewGroup) activity.getWindow().getDecorView(), false);
        this.f31185e = inflate;
        if (inflate == null) {
            throw new IllegalArgumentException("Must supply valid layout id for header.");
        }
        inflate.setVisibility(4);
        this.f31182b.h(activity, this.f31185e);
        c cVar2 = new c(this, null);
        this.f31204x = cVar2;
        cVar2.c();
    }

    public final void A(boolean z10) {
        this.f31194n = false;
        if (this.f31200t) {
            m().removeCallbacks(this.f31205y);
        }
        o();
    }

    public void B() {
        this.f31193m = false;
        this.f31195o = false;
        this.f31191k = -1.0f;
        this.f31190j = -1.0f;
        this.f31189i = -1.0f;
    }

    public final void C(vk.a aVar) {
        this.f31186f = aVar;
    }

    public void D(vk.b bVar) {
        this.f31183c = bVar;
    }

    public final void E() {
        G(null, false, false);
    }

    public final void F(boolean z10) {
        G(null, z10, false);
    }

    public final void G(View view, boolean z10, boolean z11) {
        if (p() || this.f31194n == z10) {
            return;
        }
        B();
        if (z10 && e(z11)) {
            I(view, z11);
        } else {
            A(z11);
        }
    }

    public void H() {
        vk.a aVar;
        J(this.f31185e);
        if (!this.f31182b.i() || (aVar = this.f31186f) == null) {
            return;
        }
        aVar.a(this.f31185e, 0);
    }

    public final void I(View view, boolean z10) {
        vk.b bVar;
        this.f31194n = true;
        if (z10 && (bVar = this.f31183c) != null) {
            bVar.a(view);
        }
        this.f31182b.e();
        H();
        if (this.f31200t) {
            if (this.f31199s > 0) {
                m().postDelayed(this.f31205y, this.f31199s);
            } else {
                m().post(this.f31205y);
            }
        }
    }

    public void J(View view) {
        this.f31184d.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f31203w);
        WindowManager.LayoutParams layoutParams = view.getLayoutParams() instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) view.getLayoutParams() : view.getTag() instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) view.getTag() : null;
        if (layoutParams != null) {
            int i10 = layoutParams.y;
            int i11 = this.f31203w.top;
            if (i10 != i11) {
                layoutParams.y = i11;
                this.f31184d.getWindowManager().updateViewLayout(view, layoutParams);
            }
        }
    }

    public void K(Class<?> cls, xk.c cVar) {
        for (View view : this.f31197q.keySet()) {
            if (cls.isInstance(view)) {
                this.f31197q.put(view, cVar);
            }
        }
    }

    public void c(View view) {
        int i10;
        int i11;
        this.f31184d.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f31203w);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int i12 = layoutParams.width;
            i11 = layoutParams.height;
            i10 = i12;
        } else {
            i10 = -1;
            i11 = -2;
        }
        WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i10, i11, 1000, 280, -3);
        layoutParams2.x = 0;
        layoutParams2.y = this.f31203w.top;
        layoutParams2.gravity = 48;
        view.setTag(layoutParams2);
        this.f31184d.getWindowManager().addView(view, layoutParams2);
    }

    public void d(View view, xk.c cVar) {
        if (p()) {
            return;
        }
        if (view == null) {
            Log.i(A, "Refreshable View is null.");
            return;
        }
        if (cVar == null) {
            cVar = e.b(view);
        }
        this.f31197q.put(view, cVar);
    }

    public final boolean e(boolean z10) {
        return (this.f31194n || (z10 && this.f31183c == null)) ? false : true;
    }

    public final boolean f(View view) {
        if (!this.f31193m || !this.f31198r || view == null || this.f31190j - this.f31191k < n(view)) {
            return false;
        }
        G(view, true, true);
        return true;
    }

    public void g() {
        this.f31197q.clear();
    }

    public uk.c h() {
        return new a();
    }

    public d i() {
        return new uk.co.senab.actionbarpulltorefresh.library.a();
    }

    public void j() {
        if (this.f31201u) {
            return;
        }
        z(this.f31185e);
        g();
        this.f31184d = null;
        this.f31185e = null;
        this.f31186f = null;
        this.f31181a = null;
        this.f31182b = null;
        this.f31201u = true;
    }

    public final Activity k() {
        return this.f31184d;
    }

    public d l() {
        return this.f31182b;
    }

    public final View m() {
        return this.f31185e;
    }

    public final float n(View view) {
        return view.getHeight() * this.f31188h;
    }

    public void o() {
        vk.a aVar;
        if (!this.f31182b.a() || (aVar = this.f31186f) == null) {
            return;
        }
        aVar.a(this.f31185e, 2);
    }

    public final boolean p() {
        if (this.f31201u) {
            Log.i(A, "PullToRefreshAttacher is destroyed.");
        }
        return this.f31201u;
    }

    public final boolean q() {
        return this.f31194n;
    }

    public final boolean r(View view, MotionEvent motionEvent) {
        xk.c cVar;
        if (view.isShown() && this.f31197q.containsKey(view)) {
            view.getLocationOnScreen(this.f31202v);
            int[] iArr = this.f31202v;
            int i10 = iArr[0];
            int i11 = iArr[1];
            this.f31203w.set(i10, i11, view.getWidth() + i10, view.getHeight() + i11);
            if (this.f31203w.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY()) && (cVar = this.f31197q.get(view)) != null) {
                Rect rect = this.f31203w;
                return cVar.a(view, r0 - rect.left, r8 - rect.top);
            }
        }
        return false;
    }

    public void s() {
        if (p()) {
            return;
        }
        this.f31182b.d();
        vk.a aVar = this.f31186f;
        if (aVar != null) {
            aVar.a(this.f31185e, 1);
        }
    }

    public void t(Configuration configuration) {
        this.f31182b.b(this.f31184d, configuration);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r2 != 3) goto L119;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean u(android.view.MotionEvent r6) {
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
            boolean r6 = r5.f31193m
            if (r6 != 0) goto L82
            float r6 = r5.f31189i
            r2 = 0
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L82
            float r6 = r1 - r6
            float r2 = r5.f31192l
            float r0 = r0 - r2
            float r2 = java.lang.Math.abs(r6)
            float r0 = java.lang.Math.abs(r0)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L49
            int r0 = r5.f31187g
            float r0 = (float) r0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L49
            r5.f31193m = r3
            r5.x(r1)
            goto L82
        L49:
            int r0 = r5.f31187g
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
            java.util.WeakHashMap<android.view.View, xk.c> r2 = r5.f31197q
            java.util.Set r2 = r2.keySet()
            java.util.Iterator r2 = r2.iterator()
        L69:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L82
            java.lang.Object r3 = r2.next()
            android.view.View r3 = (android.view.View) r3
            boolean r4 = r5.r(r3, r6)
            if (r4 == 0) goto L69
            r5.f31192l = r0
            r5.f31189i = r1
            r5.f31196p = r3
            goto L69
        L82:
            boolean r6 = r5.f31193m
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.f.u(android.view.MotionEvent):boolean");
    }

    public void v(View view, float f10) {
        float n10 = n(view);
        float f11 = f10 - this.f31191k;
        if (f11 < n10) {
            this.f31182b.c(f11 / n10);
        } else if (this.f31198r) {
            this.f31182b.f();
        } else {
            G(view, true, true);
        }
    }

    public void w() {
        if (this.f31194n) {
            return;
        }
        A(true);
    }

    public void x(float f10) {
        H();
        this.f31191k = f10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0025, code lost:
    
        if (r0 != 3) goto L116;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean y(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            if (r0 != 0) goto L9
            r4.f31195o = r1
        L9:
            boolean r0 = r4.f31195o
            if (r0 == 0) goto L15
            boolean r0 = r4.f31193m
            if (r0 != 0) goto L15
            r4.u(r5)
            return r1
        L15:
            android.view.View r0 = r4.f31196p
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
            boolean r0 = r4.f31193m
            if (r0 == 0) goto L6a
            float r0 = r4.f31190j
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 == 0) goto L6a
            float r0 = r5 - r0
            int r2 = r4.f31187g
            int r2 = -r2
            float r2 = (float) r2
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L54
            android.view.View r2 = r4.f31196p
            r4.v(r2, r5)
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L6a
            r4.f31190j = r5
            goto L6a
        L54:
            r4.w()
            r4.B()
            goto L6a
        L5b:
            android.view.View r5 = r4.f31196p
            r4.f(r5)
            boolean r5 = r4.f31193m
            if (r5 == 0) goto L67
            r4.w()
        L67:
            r4.B()
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.f.y(android.view.MotionEvent):boolean");
    }

    public void z(View view) {
        this.f31204x.a();
        if (view.getWindowToken() != null) {
            this.f31184d.getWindowManager().removeViewImmediate(view);
        }
    }
}
