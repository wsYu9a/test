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
import uk.d;
import uk.e;
import uk.f;
import xk.c;

/* loaded from: classes5.dex */
public class PullToRefreshLayout extends FrameLayout {

    /* renamed from: c */
    public static final boolean f31144c = false;

    /* renamed from: d */
    public static final String f31145d = "PullToRefreshLayout";

    /* renamed from: b */
    public f f31146b;

    public static class a extends FrameLayout.LayoutParams {

        /* renamed from: a */
        public final String f31147a;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefreshView);
            this.f31147a = obtainStyledAttributes.getString(0);
            obtainStyledAttributes.recycle();
        }

        public String a() {
            return this.f31147a;
        }
    }

    public PullToRefreshLayout(Context context) {
        this(context, null);
    }

    public void a() {
        f();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            d(getChildAt(i10));
        }
    }

    public void b(int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (findViewById(iArr[i10]) != null) {
                d(findViewById(iArr[i10]));
            }
        }
    }

    public void c(View[] viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                d(view);
            }
        }
    }

    public void d(View view) {
        f fVar = this.f31146b;
        if (fVar != null) {
            fVar.d(view, g(view));
        }
    }

    public f e(Activity activity, b bVar) {
        if (bVar == null) {
            bVar = new b();
        }
        return new f(activity, bVar);
    }

    public final void f() {
        if (this.f31146b == null) {
            throw new IllegalStateException("You need to setup the PullToRefreshLayout before using it");
        }
    }

    public c g(View view) {
        if (view == null || !(view.getLayoutParams() instanceof a)) {
            return null;
        }
        String a10 = ((a) view.getLayoutParams()).a();
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        int indexOf = a10.indexOf(46);
        if (indexOf == -1) {
            a10 = getContext().getPackageName() + p1.b.f29697h + a10;
        } else if (indexOf == 0) {
            a10 = getContext().getPackageName() + a10;
        }
        return (c) e.d(getContext(), a10);
    }

    public d getHeaderTransformer() {
        f();
        return this.f31146b.l();
    }

    public final View getHeaderView() {
        f();
        return this.f31146b.m();
    }

    public final boolean h() {
        f();
        return this.f31146b.q();
    }

    public final void i() {
        f();
        this.f31146b.E();
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        f fVar = this.f31146b;
        if (fVar != null) {
            fVar.t(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        f fVar = this.f31146b;
        if (fVar != null) {
            fVar.j();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.f31146b == null || getChildCount() <= 0) {
            return false;
        }
        return this.f31146b.u(motionEvent);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        f fVar;
        return (!isEnabled() || (fVar = this.f31146b) == null) ? super.onTouchEvent(motionEvent) : fVar.y(motionEvent);
    }

    public final void setHeaderViewListener(vk.a aVar) {
        f();
        this.f31146b.C(aVar);
    }

    public void setPullToRefreshAttacher(f fVar) {
        f fVar2 = this.f31146b;
        if (fVar2 != null) {
            fVar2.j();
        }
        this.f31146b = fVar;
    }

    public final void setRefreshing(boolean z10) {
        f();
        this.f31146b.F(z10);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public PullToRefreshLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
