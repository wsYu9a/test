package com.opos.mobad.interstitial.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.o.c.a;

/* loaded from: classes4.dex */
public class k implements com.opos.mobad.n.a, com.opos.mobad.q.a.f {

    /* renamed from: a */
    private Activity f21052a;

    /* renamed from: b */
    private a.InterfaceC0458a f21053b;

    /* renamed from: c */
    private AdItemData f21054c;

    /* renamed from: d */
    private MaterialData f21055d;

    /* renamed from: e */
    private com.opos.mobad.n.a f21056e;

    /* renamed from: f */
    private com.opos.mobad.o.c.a f21057f;

    /* renamed from: g */
    private com.opos.mobad.n.f.a f21058g;

    /* renamed from: h */
    private com.opos.mobad.activity.webview.b f21059h;

    /* renamed from: i */
    private a.InterfaceC0471a f21060i = new a.InterfaceC0471a() { // from class: com.opos.mobad.interstitial.a.k.1
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.c.a.InterfaceC0471a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = k.this.f21053b;
            if (interfaceC0458a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0458a).a_(view, iArr);
            }
        }
    };

    /* renamed from: com.opos.mobad.interstitial.a.k$1 */
    class AnonymousClass1 implements a.InterfaceC0471a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.c.a.InterfaceC0471a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = k.this.f21053b;
            if (interfaceC0458a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0458a).a_(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.k$2 */
    class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.activity.webview.b.a
        public void a() {
            if (k.this.f21053b != null) {
                k.this.f21053b.d((View) null, (int[]) null);
            }
        }
    }

    /* renamed from: com.opos.mobad.interstitial.a.k$3 */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.f21059h.a();
            k.this.f21058g.b(k.this.f21059h.c());
            k.this.f21058g.b();
            k.this.a();
        }
    }

    public k(Activity activity, AdItemData adItemData, com.opos.mobad.activity.webview.b bVar, com.opos.mobad.n.a aVar) {
        this.f21052a = activity;
        this.f21054c = adItemData;
        MaterialData materialData = adItemData.i().get(0);
        this.f21055d = materialData;
        this.f21058g = b(materialData);
        this.f21056e = aVar;
        if (aVar != null) {
            aVar.a(this.f21053b);
            this.f21058g.a(this.f21056e.c());
        }
        this.f21059h = bVar;
        if (bVar != null) {
            bVar.a(new b.a() { // from class: com.opos.mobad.interstitial.a.k.2
                AnonymousClass2() {
                }

                @Override // com.opos.mobad.activity.webview.b.a
                public void a() {
                    if (k.this.f21053b != null) {
                        k.this.f21053b.d((View) null, (int[]) null);
                    }
                }
            });
        }
    }

    private void a(MaterialData materialData) {
        if (materialData == null || materialData.ab() == null || materialData.ab().a() == null || TextUtils.isEmpty(materialData.ab().a().a())) {
            return;
        }
        if (this.f21057f != null && this.f21058g.a().indexOfChild(this.f21057f.a()) >= 0) {
            this.f21057f.a().setVisibility(0);
            return;
        }
        com.opos.cmn.an.f.a.b("InterstitialNewTemplate", "add pendant");
        com.opos.mobad.o.c.a aVar = new com.opos.mobad.o.c.a(this.f21052a, this.f21060i);
        this.f21057f = aVar;
        aVar.a(new a.b(materialData.ab().a().a(), 75, 75));
        View a2 = this.f21057f.a();
        a2.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f21052a, 75.0f), com.opos.cmn.an.h.f.a.a(this.f21052a, 75.0f));
        if (materialData.ab().c() == 0) {
            layoutParams.addRule(11);
            if (com.opos.cmn.an.h.f.a.d(this.f21052a)) {
                layoutParams.addRule(12);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21052a, 16.0f);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f21052a, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f21052a, 37.0f);
            }
        } else {
            layoutParams.addRule(9);
            if (com.opos.cmn.an.h.f.a.d(this.f21052a)) {
                layoutParams.addRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21052a, 16.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f21052a, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f21052a, 37.0f);
            }
        }
        this.f21058g.a().addView(a2, layoutParams);
    }

    private com.opos.mobad.n.f.a b(MaterialData materialData) {
        switch (materialData.b()) {
            case 5:
            case 7:
            case 8:
            case 9:
                return com.opos.mobad.n.f.l.a(this.f21052a.getApplicationContext(), 0, false);
            case 6:
            case 10:
            case 11:
            default:
                return com.opos.mobad.n.f.l.a(this.f21052a.getApplicationContext(), 1, false);
            case 12:
            case 14:
                return com.opos.mobad.n.f.l.a(this.f21052a.getApplicationContext(), 0, true);
            case 13:
            case 15:
                return com.opos.mobad.n.f.l.a(this.f21052a.getApplicationContext(), 1, true);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
        com.opos.mobad.n.a aVar = this.f21056e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f21053b = interfaceC0458a;
        com.opos.mobad.n.a aVar = this.f21056e;
        if (aVar != null) {
            aVar.a(interfaceC0458a);
        }
        this.f21058g.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.a
    public void a(com.opos.mobad.n.d.h hVar) {
        com.opos.cmn.an.f.a.b("InterstitialNewTemplate", "render ");
        if (hVar != null) {
            if (this.f21056e != null) {
                this.f21058g.a(hVar);
                this.f21056e.a(hVar);
                if (this.f21055d.ac()) {
                    a(this.f21055d);
                    return;
                }
                return;
            }
            com.opos.cmn.an.f.a.d("InterstitialNewTemplate", "unknow creativeType, please check if your creativeType is video or template");
            a.InterfaceC0458a interfaceC0458a = this.f21053b;
            if (interfaceC0458a != null) {
                interfaceC0458a.b(1);
            }
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
        com.opos.mobad.n.a aVar = this.f21056e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f21058g.a();
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        try {
            com.opos.mobad.n.a aVar = this.f21056e;
            if (aVar != null) {
                aVar.d();
            }
            com.opos.mobad.o.c.a aVar2 = this.f21057f;
            if (aVar2 != null) {
                aVar2.b();
            }
            com.opos.mobad.activity.webview.b bVar = this.f21059h;
            if (bVar != null) {
                bVar.d();
            }
            this.f21058g.a().removeAllViews();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterstitialNewTemplate", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.f21056e;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }

    @Override // com.opos.mobad.q.a.f
    public void f() {
        if (this.f21059h == null) {
            return;
        }
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.interstitial.a.k.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.f21059h.a();
                k.this.f21058g.b(k.this.f21059h.c());
                k.this.f21058g.b();
                k.this.a();
            }
        });
    }
}
