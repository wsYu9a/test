package com.opos.mobad.a.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.h;

/* loaded from: classes4.dex */
public class b implements com.opos.mobad.n.a {

    /* renamed from: a */
    private FrameLayout f19337a;

    /* renamed from: b */
    private com.opos.mobad.n.a f19338b;

    public b(Context context) {
        this.f19337a = new FrameLayout(context);
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.mobad.n.a aVar = this.f19338b;
        if (aVar == null) {
            return;
        }
        aVar.a(interfaceC0458a);
    }

    public void a(com.opos.mobad.n.a aVar) {
        this.f19338b = aVar;
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.a aVar = this.f19338b;
        if (aVar == null) {
            return;
        }
        aVar.a(hVar);
        View c2 = this.f19338b.c();
        if (c2 == null || this.f19337a.indexOfChild(c2) >= 0) {
            return;
        }
        this.f19337a.removeAllViews();
        this.f19337a.addView(c2, new FrameLayout.LayoutParams(-1, -2));
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f19337a;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.mobad.n.a aVar = this.f19338b;
        if (aVar == null) {
            return;
        }
        aVar.d();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.f19338b;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }
}
