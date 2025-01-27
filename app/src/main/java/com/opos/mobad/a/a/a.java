package com.opos.mobad.a.a;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.c.d.a;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.h;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.n.a {

    /* renamed from: a */
    private com.opos.mobad.a.b f19332a;

    /* renamed from: b */
    private Context f19333b;

    /* renamed from: c */
    private com.opos.mobad.n.a f19334c;

    /* renamed from: d */
    private com.opos.mobad.c.d.a f19335d;

    /* renamed from: com.opos.mobad.a.a.a$1 */
    class AnonymousClass1 implements a.InterfaceC0428a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (a.this.f19332a != null) {
                a.this.f19332a.a(z);
            }
        }
    }

    public a(Context context, com.opos.mobad.n.a aVar) {
        this.f19333b = context.getApplicationContext();
        com.opos.mobad.c.d.a aVar2 = new com.opos.mobad.c.d.a(context);
        this.f19335d = aVar2;
        aVar2.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.a.a.a.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.c.d.a.InterfaceC0428a
            public void a(boolean z) {
                if (a.this.f19332a != null) {
                    a.this.f19332a.a(z);
                }
            }
        });
        this.f19334c = aVar;
        this.f19335d.addView(aVar.c(), new RelativeLayout.LayoutParams(-1, -2));
        if (Build.VERSION.SDK_INT >= 29) {
            this.f19335d.setForceDarkAllowed(false);
        }
    }

    @Override // com.opos.mobad.n.a
    public void a() {
    }

    @Override // com.opos.mobad.n.a
    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f19332a = (com.opos.mobad.a.b) interfaceC0458a;
        this.f19334c.a(interfaceC0458a);
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        com.opos.mobad.n.a aVar;
        if (hVar != null && (aVar = this.f19334c) != null) {
            aVar.a(hVar);
            return;
        }
        com.opos.cmn.an.f.a.b("BannerNewTemplate", "render fail for null =" + this.f19334c);
        com.opos.mobad.a.b bVar = this.f19332a;
        if (bVar != null) {
            bVar.b(1);
        }
    }

    @Override // com.opos.mobad.n.a
    public void b() {
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f19335d;
    }

    @Override // com.opos.mobad.n.a
    public void d() {
        com.opos.mobad.n.a aVar = this.f19334c;
        if (aVar != null) {
            aVar.d();
        }
        this.f19335d.removeAllViews();
    }

    @Override // com.opos.mobad.n.a
    public int e() {
        com.opos.mobad.n.a aVar = this.f19334c;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }
}
