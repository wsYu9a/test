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

    /* renamed from: a, reason: collision with root package name */
    private static final int f10494a = 12;

    /* renamed from: b, reason: collision with root package name */
    private static final int f10495b = 12;

    /* renamed from: c, reason: collision with root package name */
    private View[] f10496c;

    /* renamed from: d, reason: collision with root package name */
    private int f10497d;

    /* renamed from: e, reason: collision with root package name */
    private SurfaceHolder f10498e;

    public FakeViewGroup(Context context) {
        super(context);
        i();
    }

    private void a(View child, int index) {
        View[] viewArr = this.f10496c;
        int i2 = this.f10497d;
        int length = viewArr.length;
        if (index == i2) {
            if (length == i2) {
                View[] viewArr2 = new View[length + 12];
                this.f10496c = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.f10496c;
            }
            int i3 = this.f10497d;
            this.f10497d = i3 + 1;
            viewArr[i3] = child;
            return;
        }
        if (index >= i2) {
            throw new IndexOutOfBoundsException("index=" + index + " count=" + i2);
        }
        if (length == i2) {
            View[] viewArr3 = new View[length + 12];
            this.f10496c = viewArr3;
            System.arraycopy(viewArr, 0, viewArr3, 0, index);
            System.arraycopy(viewArr, index, this.f10496c, index + 1, i2 - index);
            viewArr = this.f10496c;
        } else {
            System.arraycopy(viewArr, index, viewArr, index + 1, i2 - index);
        }
        viewArr[index] = child;
        this.f10497d++;
    }

    private void e(View child, int index, ViewGroup.LayoutParams params) {
        if (index < 0) {
            index = this.f10497d;
        }
        a(child, index);
    }

    private void i() {
        this.f10496c = new View[12];
        this.f10497d = 0;
        SurfaceHolder holder = getHolder();
        this.f10498e = holder;
        holder.addCallback(this);
    }

    private void k() {
        int i2 = this.f10497d;
        if (i2 <= 0) {
            return;
        }
        View[] viewArr = this.f10496c;
        this.f10497d = 0;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            viewArr[i3] = null;
        }
    }

    private void l(int index) {
        View[] viewArr = this.f10496c;
        int i2 = this.f10497d;
        if (index == i2 - 1) {
            int i3 = i2 - 1;
            this.f10497d = i3;
            viewArr[i3] = null;
        } else {
            if (index < 0 || index >= i2) {
                throw new IndexOutOfBoundsException();
            }
            System.arraycopy(viewArr, index + 1, viewArr, index, (i2 - index) - 1);
            int i4 = this.f10497d - 1;
            this.f10497d = i4;
            viewArr[i4] = null;
        }
    }

    private void n(int index, View view) {
        l(index);
    }

    private void o(View view) {
        int h2 = h(view);
        if (h2 >= 0) {
            n(h2, view);
        }
    }

    public void b(View child) {
        c(child, -1);
    }

    public void c(View child, int index) {
        ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
        if (layoutParams == null && (layoutParams = f()) == null) {
            throw new IllegalArgumentException("generateDefaultLayoutParams() cannot return null");
        }
        d(child, index, layoutParams);
    }

    public void d(View child, int index, ViewGroup.LayoutParams params) {
        requestLayout();
        invalidate();
        e(child, index, params);
    }

    protected ViewGroup.LayoutParams f() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public View g(int index) {
        if (index < 0 || index >= this.f10497d) {
            return null;
        }
        return this.f10496c[index];
    }

    public int getChildCount() {
        return this.f10497d;
    }

    public int h(View child) {
        int i2 = this.f10497d;
        View[] viewArr = this.f10496c;
        for (int i3 = 0; i3 < i2; i3++) {
            if (viewArr[i3] == child) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        surfaceCreated(this.f10498e);
    }

    public void j() {
        k();
        requestLayout();
        invalidate();
    }

    public void m(View child) {
        o(child);
        requestLayout();
        invalidate();
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b2) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View g2 = g(i2);
            g2.layout(0, 0, g2.getMeasuredWidth(), g2.getMeasuredHeight());
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            g(i2).measure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    public void p(Canvas canvas) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas lockCanvas = holder.lockCanvas();
        if (lockCanvas == null) {
            return;
        }
        p(lockCanvas);
        holder.unlockCanvasAndPost(lockCanvas);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public FakeViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        i();
    }

    public FakeViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        i();
    }
}
