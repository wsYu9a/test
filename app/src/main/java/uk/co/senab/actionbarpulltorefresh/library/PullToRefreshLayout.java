package uk.co.senab.actionbarpulltorefresh.library;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes5.dex */
public class PullToRefreshLayout extends FrameLayout {

    /* renamed from: a */
    private static final boolean f37128a = false;

    /* renamed from: b */
    private static final String f37129b = "PullToRefreshLayout";

    /* renamed from: c */
    private h f37130c;

    static class a extends FrameLayout.LayoutParams {

        /* renamed from: a */
        private final String f37131a;

        a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefreshView);
            this.f37131a = obtainStyledAttributes.getString(0);
            obtainStyledAttributes.recycle();
        }

        String a() {
            return this.f37131a;
        }
    }

    public PullToRefreshLayout(Context context) {
        this(context, null);
    }

    private void f() {
        if (this.f37130c == null) {
            throw new IllegalStateException("You need to setup the PullToRefreshLayout before using it");
        }
    }

    void a() {
        f();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            d(getChildAt(i2));
        }
    }

    void b(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findViewById(iArr[i2]) != null) {
                d(findViewById(iArr[i2]));
            }
        }
    }

    void c(View[] viewArr) {
        int length = viewArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (viewArr[i2] != null) {
                d(viewArr[i2]);
            }
        }
    }

    void d(View view) {
        h hVar = this.f37130c;
        if (hVar != null) {
            hVar.d(view, g(view));
        }
    }

    protected h e(Activity activity, g gVar) {
        if (gVar == null) {
            gVar = new g();
        }
        return new h(activity, gVar);
    }

    uk.co.senab.actionbarpulltorefresh.library.k.c g(View view) {
        if (view == null || !(view.getLayoutParams() instanceof a)) {
            return null;
        }
        String a2 = ((a) view.getLayoutParams()).a();
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        int indexOf = a2.indexOf(46);
        if (indexOf == -1) {
            a2 = getContext().getPackageName() + "." + a2;
        } else if (indexOf == 0) {
            a2 = getContext().getPackageName() + a2;
        }
        return (uk.co.senab.actionbarpulltorefresh.library.k.c) f.d(getContext(), a2);
    }

    public e getHeaderTransformer() {
        f();
        return this.f37130c.l();
    }

    public final View getHeaderView() {
        f();
        return this.f37130c.m();
    }

    public final boolean h() {
        f();
        return this.f37130c.q();
    }

    public final void i() {
        f();
        this.f37130c.E();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        h hVar = this.f37130c;
        if (hVar != null) {
            hVar.t(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        h hVar = this.f37130c;
        if (hVar != null) {
            hVar.j();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.f37130c == null || getChildCount() <= 0) {
            return false;
        }
        return this.f37130c.u(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        h hVar;
        return (!isEnabled() || (hVar = this.f37130c) == null) ? super.onTouchEvent(motionEvent) : hVar.y(motionEvent);
    }

    public final void setHeaderViewListener(uk.co.senab.actionbarpulltorefresh.library.i.a aVar) {
        f();
        this.f37130c.C(aVar);
    }

    void setPullToRefreshAttacher(h hVar) {
        h hVar2 = this.f37130c;
        if (hVar2 != null) {
            hVar2.j();
        }
        this.f37130c = hVar;
    }

    public final void setRefreshing(boolean z) {
        f();
        this.f37130c.F(z);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
