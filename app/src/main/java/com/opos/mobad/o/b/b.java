package com.opos.mobad.o.b;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a */
    protected Context f23010a;

    /* renamed from: b */
    protected e f23011b;

    /* renamed from: c */
    protected RelativeLayout f23012c;

    /* renamed from: d */
    protected RelativeLayout f23013d;

    public b(Context context, e eVar) {
        this.f23010a = context;
        this.f23011b = eVar;
        d();
    }

    private void d() {
        this.f23012c = new RelativeLayout(this.f23010a);
        a();
        this.f23013d = new RelativeLayout(this.f23010a);
        b();
        c();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.f23012c.addView(this.f23013d, layoutParams);
    }

    protected abstract void a();

    protected abstract void b();

    protected abstract void c();
}
