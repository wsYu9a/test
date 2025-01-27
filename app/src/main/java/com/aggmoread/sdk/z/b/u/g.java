package com.aggmoread.sdk.z.b.u;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class g extends FrameLayout {

    /* renamed from: a */
    private com.aggmoread.sdk.z.b.t.f f5050a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.t.a f5051b;

    /* renamed from: c */
    private int f5052c;

    /* renamed from: d */
    private int f5053d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.d();
        }
    }

    public g(Context context) {
        super(context);
        a(context);
    }

    public void d() {
        boolean z10;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            Log.i("ApiMediaViewTAG", "updateLayoutParams null");
            new Exception("test").printStackTrace();
            return;
        }
        boolean z11 = true;
        if (layoutParams.height == -2) {
            layoutParams.height = this.f5053d;
            z10 = true;
        } else {
            z10 = false;
        }
        if (layoutParams.width == -2) {
            layoutParams.width = this.f5052c;
        } else {
            z11 = z10;
        }
        if (z11) {
            Log.i("ApiMediaViewTAG", "updateLayoutParams width " + layoutParams.width + ", height " + layoutParams.height);
            postInvalidate();
        }
    }

    public com.aggmoread.sdk.z.b.t.a a() {
        return this.f5051b;
    }

    public com.aggmoread.sdk.z.b.t.f b() {
        return this.f5050a;
    }

    public void c() {
        com.aggmoread.sdk.z.b.t.f fVar = this.f5050a;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (this.f5050a != null) {
            Log.i("ApiMediaViewTAG", "onWindowVisibilityChanged visibility " + i10);
            if (i10 != 0) {
                c();
            }
        }
    }

    private void a(Context context) {
        this.f5052c = com.aggmoread.sdk.z.b.m.b.a(context);
        this.f5053d = com.aggmoread.sdk.z.b.m.b.a(context, 200.0d);
        this.f5050a = new com.aggmoread.sdk.z.b.t.f(context);
        this.f5051b = new com.aggmoread.sdk.z.b.t.b(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f5050a, layoutParams);
        this.f5050a.d(true);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f5051b.setVisibility(8);
        addView(this.f5051b, layoutParams2);
        this.f5050a.a(this.f5051b);
        post(new a());
    }
}
