package com.opos.mobad.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.e.a;
import com.opos.mobad.q.a.m;

/* loaded from: classes4.dex */
public class c extends m implements b {

    /* renamed from: a */
    private Context f19339a;

    /* renamed from: b */
    private Activity f19340b;

    /* renamed from: c */
    private com.opos.mobad.o.a.a f19341c;

    /* renamed from: d */
    private a.C0457a f19342d;

    /* renamed from: e */
    private boolean f19343e;

    /* renamed from: f */
    private com.opos.mobad.ad.privacy.b f19344f;

    /* renamed from: g */
    private boolean f19345g;

    /* renamed from: h */
    private boolean f19346h;

    /* renamed from: i */
    private a f19347i;

    /* renamed from: j */
    private com.opos.mobad.a.a.b f19348j;

    /* renamed from: com.opos.mobad.a.c$1 */
    class AnonymousClass1 implements com.opos.mobad.o.a.b {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.o.a.b
        public void a(int i2) {
            ((m) c.this).l.c(i2);
            c.this.f19343e = false;
            c.this.f19348j.a(com.opos.mobad.model.a.a(c.this.f19339a, c.this.f19342d, c.this.f19345g, c.this.f19343e));
            if (c.b(c.this.f19342d.f21745c)) {
                c.this.d((View) null, (int[]) null);
            }
        }

        @Override // com.opos.mobad.o.a.b
        public void a(boolean z) {
            if (z) {
                c.this.f19343e = false;
                c.this.f19348j.a(com.opos.mobad.model.a.a(c.this.f19339a, c.this.f19342d, c.this.f19345g, c.this.f19343e));
                if (c.b(c.this.f19342d.f21745c)) {
                    c.this.d((View) null, (int[]) null);
                }
            }
        }
    }

    public c(Activity activity, String str, com.opos.mobad.cmn.a.a aVar, com.opos.mobad.o.a.a aVar2, com.opos.mobad.ad.privacy.b bVar, b.InterfaceC0437b interfaceC0437b, a aVar3, com.opos.mobad.a.a.b bVar2) {
        super(activity.getApplicationContext(), str, aVar, interfaceC0437b, aVar3);
        this.f19343e = false;
        this.f19345g = false;
        this.f19346h = false;
        this.f19340b = activity;
        this.f19339a = activity.getApplicationContext();
        this.f19344f = bVar;
        this.f19341c = aVar2;
        aVar2.a(new com.opos.mobad.o.a.b() { // from class: com.opos.mobad.a.c.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.o.a.b
            public void a(int i2) {
                ((m) c.this).l.c(i2);
                c.this.f19343e = false;
                c.this.f19348j.a(com.opos.mobad.model.a.a(c.this.f19339a, c.this.f19342d, c.this.f19345g, c.this.f19343e));
                if (c.b(c.this.f19342d.f21745c)) {
                    c.this.d((View) null, (int[]) null);
                }
            }

            @Override // com.opos.mobad.o.a.b
            public void a(boolean z) {
                if (z) {
                    c.this.f19343e = false;
                    c.this.f19348j.a(com.opos.mobad.model.a.a(c.this.f19339a, c.this.f19342d, c.this.f19345g, c.this.f19343e));
                    if (c.b(c.this.f19342d.f21745c)) {
                        c.this.d((View) null, (int[]) null);
                    }
                }
            }
        });
        this.f19347i = aVar3;
        this.f19348j = bVar2;
    }

    public static boolean b(MaterialData materialData) {
        return materialData != null && materialData.b() == 0;
    }

    public View a() {
        com.opos.mobad.a.a.b bVar = this.f19348j;
        if (bVar == null) {
            return null;
        }
        return bVar.c();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void a(View view, int[] iArr) {
        if (this.f19346h || b(this.f19342d.f21745c)) {
            return;
        }
        this.f19341c.a(view);
    }

    protected void a(a.C0457a c0457a, com.opos.mobad.n.a aVar) {
        if (aVar == null || c0457a == null) {
            com.opos.cmn.an.f.a.b("InterBannerPresenter", "render fail null data or template = " + aVar);
            b(1);
            return;
        }
        this.f19342d = c0457a;
        a(c0457a.f21744b, c0457a.f21745c, aVar.e());
        this.f19343e = c0457a.f21745c.Z();
        this.f19345g = false;
        this.f19348j.a(aVar);
        this.f19348j.a(this);
        this.f19348j.a(com.opos.mobad.model.a.a(this.f19339a, c0457a, this.f19345g, this.f19343e));
    }

    @Override // com.opos.mobad.a.b
    public void a(boolean z) {
        a aVar = this.f19347i;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b() {
        super.a(this.f19348j.c());
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void b(View view, int[] iArr) {
        if (this.f19346h) {
            return;
        }
        this.f19344f.a(this.f19340b, 0, com.opos.mobad.cmn.a.e.a(this.f19342d.f21744b), null);
    }

    @Override // com.opos.mobad.q.a.m
    public void c() {
        this.f19346h = true;
        this.f19340b = null;
        com.opos.mobad.a.a.b bVar = this.f19348j;
        if (bVar != null) {
            bVar.d();
        }
        com.opos.mobad.ad.privacy.b bVar2 = this.f19344f;
        if (bVar2 != null) {
            bVar2.a();
        }
        super.c();
    }

    @Override // com.opos.mobad.n.a.InterfaceC0458a
    public void c(View view, int[] iArr) {
        if (this.f19346h) {
            return;
        }
        this.f19344f.a(this.f19340b, 1, com.opos.mobad.cmn.a.e.a(this.f19342d.f21744b), null);
    }

    public void d() {
        com.opos.mobad.a.a.b bVar;
        if (this.f19346h || (bVar = this.f19348j) == null) {
            return;
        }
        this.f19345g = true;
        bVar.a(com.opos.mobad.model.a.a(this.f19339a, this.f19342d, true, this.f19343e));
    }

    @Override // com.opos.mobad.q.a.m, com.opos.mobad.n.a.InterfaceC0458a
    public void d(View view, int[] iArr) {
        if (this.f19346h) {
            return;
        }
        if (this.f19343e && b(this.f19342d.f21745c)) {
            this.f19341c.a(view);
        } else {
            super.d(view, iArr);
        }
    }
}
