package com.martian.libsliding;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes3.dex */
public class FakeViewGroup extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: e, reason: collision with root package name */
    public static final int f12909e = 12;

    /* renamed from: f, reason: collision with root package name */
    public static final int f12910f = 12;

    /* renamed from: b, reason: collision with root package name */
    public View[] f12911b;

    /* renamed from: c, reason: collision with root package name */
    public int f12912c;

    /* renamed from: d, reason: collision with root package name */
    public SurfaceHolder f12913d;

    public FakeViewGroup(Context context) {
        super(context);
        i();
    }

    public final void a(View view, int i10) {
        View[] viewArr = this.f12911b;
        int i11 = this.f12912c;
        int length = viewArr.length;
        if (i10 == i11) {
            if (length == i11) {
                View[] viewArr2 = new View[length + 12];
                this.f12911b = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.f12911b;
            }
            int i12 = this.f12912c;
            this.f12912c = i12 + 1;
            viewArr[i12] = view;
            return;
        }
        if (i10 >= i11) {
            throw new IndexOutOfBoundsException("index=" + i10 + " count=" + i11);
        }
        if (length == i11) {
            View[] viewArr3 = new View[length + 12];
            this.f12911b = viewArr3;
            System.arraycopy(viewArr, 0, viewArr3, 0, i10);
            System.arraycopy(viewArr, i10, this.f12911b, i10 + 1, i11 - i10);
            viewArr = this.f12911b;
        } else {
            System.arraycopy(viewArr, i10, viewArr, i10 + 1, i11 - i10);
        }
        viewArr[i10] = view;
        this.f12912c++;
    }

    public void b(View view) {
        c(view, -1);
    }

    public void c(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null && (layoutParams = f()) == null) {
            throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
        }
        d(view, i10, layoutParams);
    }

    public void d(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        requestLayout();
        invalidate();
        e(view, i10, layoutParams);
    }

    public final void e(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (i10 < 0) {
            i10 = this.f12912c;
        }
        a(view, i10);
    }

    public ViewGroup.LayoutParams f() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public View g(int i10) {
        if (i10 < 0 || i10 >= this.f12912c) {
            return null;
        }
        return this.f12911b[i10];
    }

    public int getChildCount() {
        return this.f12912c;
    }

    public int h(View view) {
        int i10 = this.f12912c;
        View[] viewArr = this.f12911b;
        for (int i11 = 0; i11 < i10; i11++) {
            if (viewArr[i11] == view) {
                return i11;
            }
        }
        return -1;
    }

    public final void i() {
        this.f12911b = new View[12];
        this.f12912c = 0;
        SurfaceHolder holder = getHolder();
        this.f12913d = holder;
        holder.addCallback(this);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        surfaceCreated(this.f12913d);
    }

    public void j() {
        k();
        requestLayout();
        invalidate();
    }

    public final void k() {
        int i10 = this.f12912c;
        if (i10 <= 0) {
            return;
        }
        View[] viewArr = this.f12911b;
        this.f12912c = 0;
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            viewArr[i11] = null;
        }
    }

    public final void l(int i10) {
        View[] viewArr = this.f12911b;
        int i11 = this.f12912c;
        if (i10 == i11 - 1) {
            int i12 = i11 - 1;
            this.f12912c = i12;
            viewArr[i12] = null;
        } else {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException();
            }
            System.arraycopy(viewArr, i10 + 1, viewArr, i10, (i11 - i10) - 1);
            int i13 = this.f12912c - 1;
            this.f12912c = i13;
            viewArr[i13] = null;
        }
    }

    public void m(View view) {
        o(view);
        requestLayout();
        invalidate();
    }

    public final void n(int i10, View view) {
        l(i10);
    }

    public final void o(View view) {
        int h10 = h(view);
        if (h10 >= 0) {
            n(h10, view);
        }
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        for (int i14 = 0; i14 < getChildCount(); i14++) {
            View g10 = g(i14);
            g10.layout(0, 0, g10.getMeasuredWidth(), g10.getMeasuredHeight());
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            g(i12).measure(i10, i11);
        }
    }

    public void p(Canvas canvas) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i10, int i11, int i12) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        if (lockCanvas == null) {
            return;
        }
        p(lockCanvas);
        surfaceHolder.unlockCanvasAndPost(lockCanvas);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    public FakeViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i();
    }

    public FakeViewGroup(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i();
    }
}
