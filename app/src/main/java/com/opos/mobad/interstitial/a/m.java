package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.o.c.a;

/* loaded from: classes4.dex */
public class m implements com.opos.mobad.n.a {

    /* renamed from: a */
    private Activity f21065a;

    /* renamed from: b */
    private a.InterfaceC0458a f21066b;

    /* renamed from: c */
    private AdItemData f21067c;

    /* renamed from: d */
    private MaterialData f21068d;

    /* renamed from: e */
    private com.opos.mobad.n.a f21069e;

    /* renamed from: f */
    private FrameLayout f21070f;

    /* renamed from: g */
    private com.opos.mobad.o.c.a f21071g;

    /* renamed from: h */
    private a.InterfaceC0471a f21072h = new a.InterfaceC0471a() { // from class: com.opos.mobad.interstitial.a.m.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.c.a.InterfaceC0471a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = m.this.f21066b;
            if (interfaceC0458a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0458a).a_(view, iArr);
            }
        }
    };

    /* renamed from: com.opos.mobad.interstitial.a.m$1 */
    class AnonymousClass1 implements a.InterfaceC0471a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.c.a.InterfaceC0471a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = m.this.f21066b;
            if (interfaceC0458a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0458a).a_(view, iArr);
            }
        }
    }

    public m(Activity activity, AdItemData adItemData, com.opos.mobad.n.a aVar) {
        this.f21065a = activity;
        this.f21070f = new FrameLayout(activity);
        this.f21067c = adItemData;
        this.f21068d = adItemData.i().get(0);
        this.f21069e = aVar;
    }

    private void a(MaterialData materialData) {
        if (materialData == null || materialData.ab() == null || materialData.ab().a() == null || TextUtils.isEmpty(materialData.ab().a().a())) {
            return;
        }
        com.opos.mobad.o.c.a aVar = this.f21071g;
        if (aVar == null || this.f21070f.indexOfChild(aVar.a()) < 0) {
            com.opos.cmn.an.f.a.b("InterstitialWidgetImpl", "add pendant");
            com.opos.mobad.o.c.a aVar2 = new com.opos.mobad.o.c.a(this.f21065a, this.f21072h);
            this.f21071g = aVar2;
            aVar2.a(new a.b(materialData.ab().a().a(), 75, 75));
            View a2 = this.f21071g.a();
            a2.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21065a, 75.0f), com.opos.cmn.an.h.f.a.a(this.f21065a, 75.0f));
            if (materialData.ab().c() == 0) {
                layoutParams.gravity = 5;
                if (com.opos.cmn.an.h.f.a.d(this.f21065a)) {
                    layoutParams.gravity |= 80;
                    layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21065a, 16.0f);
                    layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f21065a, 140.0f);
                } else {
                    layoutParams.gravity |= 16;
                    layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21065a, 37.0f);
                }
            } else {
                layoutParams.gravity = 3;
                if (com.opos.cmn.an.h.f.a.d(this.f21065a)) {
                    layoutParams.gravity = 48;
                    layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21065a, 16.0f);
                    layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f21065a, 140.0f);
                } else {
                    layoutParams.gravity |= 16;
                    layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21065a, 37.0f);
                }
            }
            this.f21070f.addView(a2, layoutParams);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f21066b = interfaceC0458a;
        this.f21069e.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.cmn.an.f.a.b("InterstitialWidgetImpl", "getRenderView ");
        if (this.f21067c == null || this.f21068d == null) {
            return;
        }
        com.opos.mobad.n.a aVar = this.f21069e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.d("InterstitialWidgetImpl", "unknow creativeType, please check if your creativeType is video or template");
            a.InterfaceC0458a interfaceC0458a = this.f21066b;
            if (interfaceC0458a != null) {
                interfaceC0458a.b(1);
                return;
            }
            return;
        }
        aVar.a(hVar);
        View c2 = this.f21069e.c();
        if (this.f21070f.indexOfChild(c2) < 0) {
            this.f21070f.removeAllViews();
            this.f21070f.addView(c2, new FrameLayout.LayoutParams(-1, -1));
            if (this.f21068d.ac()) {
                a(this.f21068d);
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f21070f;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            com.opos.mobad.n.a aVar = this.f21069e;
            if (aVar != null) {
                aVar.d();
            }
            com.opos.mobad.o.c.a aVar2 = this.f21071g;
            if (aVar2 != null) {
                aVar2.b();
            }
            this.f21070f.removeAllViews();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterstitialWidgetImpl", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.f21069e;
        if (aVar == null) {
            return 0;
        }
        return aVar.e();
    }
}
