package com.opos.cmn.e.a.b.e;

import android.app.Activity;
import android.view.View;

/* loaded from: classes4.dex */
public class b extends a {

    /* renamed from: c */
    private com.opos.cmn.e.a.b.f.a f16972c;

    public b(Activity activity, com.opos.cmn.e.a.b.d.a aVar) {
        super(activity, aVar);
        this.f16970a = activity;
        this.f16971b = aVar;
        this.f16972c = (aVar == null || aVar.f16964a == 0) ? new com.opos.cmn.e.a.b.f.a(activity, aVar) : new com.opos.cmn.e.a.b.f.a(activity, aVar.f16964a, aVar);
        com.opos.cmn.e.a.d.a.a(activity, this.f16972c);
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void a(View view) {
        if (view != null) {
            this.f16972c.setContentView(view);
        }
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public boolean a() {
        return this.f16972c.isShowing();
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void b() {
        this.f16972c.show();
    }

    @Override // com.opos.cmn.e.a.b.e.c
    public void c() {
        this.f16972c.dismiss();
    }
}
