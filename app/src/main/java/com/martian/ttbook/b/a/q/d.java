package com.martian.ttbook.b.a.q;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes4.dex */
public class d extends FrameLayout {

    /* renamed from: a */
    private com.martian.ttbook.b.a.p.d f15150a;

    /* renamed from: b */
    private com.martian.ttbook.b.a.p.a f15151b;

    /* renamed from: c */
    private int f15152c;

    /* renamed from: d */
    private int f15153d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.e();
        }
    }

    public d(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        this.f15152c = com.martian.ttbook.b.a.k.b.a(context);
        this.f15153d = com.martian.ttbook.b.a.k.b.b(context, 200.0d);
        this.f15150a = new com.martian.ttbook.b.a.p.d(context);
        this.f15151b = new com.martian.ttbook.b.a.p.b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f15150a, layoutParams);
        this.f15150a.x(true);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f15151b.setVisibility(8);
        addView(this.f15151b, layoutParams2);
        this.f15150a.l(this.f15151b);
        post(new a());
    }

    public void e() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            Log.i("xxx", "updateLayoutParams null");
            new Exception("test").printStackTrace();
            return;
        }
        boolean z = false;
        boolean z2 = true;
        if (layoutParams.height == -2) {
            layoutParams.height = this.f15153d;
            z = true;
        }
        if (layoutParams.width == -2) {
            layoutParams.width = this.f15152c;
        } else {
            z2 = z;
        }
        if (z2) {
            Log.i("xxx", "updateLayoutParams width " + layoutParams.width + ", height " + layoutParams.height);
            postInvalidate();
        }
    }

    public com.martian.ttbook.b.a.p.a a() {
        return this.f15151b;
    }

    public com.martian.ttbook.b.a.p.d d() {
        return this.f15150a;
    }
}
