package com.opos.cmn.e.a.b.b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a */
    protected Context f16938a;

    /* renamed from: b */
    protected com.opos.cmn.e.a.b.a.a f16939b;

    /* renamed from: c */
    protected RelativeLayout f16940c;

    /* renamed from: d */
    protected ImageView f16941d;

    public b(Context context) {
        this.f16938a = context;
        f();
        b();
        g();
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f16938a);
        this.f16940c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        a();
    }

    private void g() {
        this.f16939b = new com.opos.cmn.e.a.b.a.b(this.f16941d);
    }

    protected abstract void a();

    protected abstract void b();

    public View c() {
        return this.f16940c;
    }

    public void d() {
        this.f16939b.a();
    }

    public void e() {
        this.f16939b.b();
    }
}
