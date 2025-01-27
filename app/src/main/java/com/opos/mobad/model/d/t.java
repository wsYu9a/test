package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.m;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class t extends a {

    /* renamed from: b */
    private com.opos.mobad.model.a.a f21662b;

    /* renamed from: c */
    private String f21663c;

    /* renamed from: d */
    private List<y> f21664d;

    /* renamed from: e */
    private Context f21665e;

    /* renamed from: com.opos.mobad.model.d.t$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21666a;

        /* renamed from: b */
        final /* synthetic */ com.opos.mobad.model.b.c f21667b;

        AnonymousClass1(String str, com.opos.mobad.model.b.c cVar) {
            str = str;
            cVar = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.mobad.model.b.d a2 = t.this.f21662b.a(str, cVar, ((a) t.this).f21535a);
            com.opos.cmn.an.f.a.b("sLoader", "response:" + a2);
            com.opos.mobad.model.e.d.a(t.this.f21665e, str, a2.d());
            if (a2.p()) {
                com.opos.mobad.service.i.d.a().b();
            }
            if (a2.q()) {
                com.opos.mobad.service.f.b().a();
            }
            if (a2.f() == 1035) {
                com.opos.mobad.service.f.c().a(str, false, a2.l());
            }
            t.this.a(a2);
        }
    }

    public t(Context context, String str, String str2, com.opos.mobad.model.b.c cVar, boolean z, m.a aVar, com.opos.mobad.model.a.b bVar) {
        super(context, str, cVar, z, new i(str, str2, false), aVar);
        this.f21664d = new ArrayList();
        this.f21665e = context;
        this.f21663c = str;
        this.f21662b = new com.opos.mobad.model.a.a.a(context, bVar);
    }

    private void a(String str, com.opos.mobad.model.b.c cVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.t.1

            /* renamed from: a */
            final /* synthetic */ String f21666a;

            /* renamed from: b */
            final /* synthetic */ com.opos.mobad.model.b.c f21667b;

            AnonymousClass1(String str2, com.opos.mobad.model.b.c cVar2) {
                str = str2;
                cVar = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.mobad.model.b.d a2 = t.this.f21662b.a(str, cVar, ((a) t.this).f21535a);
                com.opos.cmn.an.f.a.b("sLoader", "response:" + a2);
                com.opos.mobad.model.e.d.a(t.this.f21665e, str, a2.d());
                if (a2.p()) {
                    com.opos.mobad.service.i.d.a().b();
                }
                if (a2.q()) {
                    com.opos.mobad.service.f.b().a();
                }
                if (a2.f() == 1035) {
                    com.opos.mobad.service.f.c().a(str, false, a2.l());
                }
                t.this.a(a2);
            }
        });
    }

    private void k() {
        if (this.f21664d.size() <= 0) {
            return;
        }
        int i2 = 0;
        for (y yVar : this.f21664d) {
            if (i2 >= 1) {
                return;
            }
            com.opos.mobad.model.e.e.a(this.f21665e, yVar);
            i2++;
        }
    }

    @Override // com.opos.mobad.model.d.a
    protected void a(y yVar) {
        if (yVar != null) {
            this.f21664d.add(yVar);
        }
    }

    @Override // com.opos.mobad.model.d.a
    public void a(com.opos.mobad.model.b.c cVar) {
        a(this.f21663c, cVar);
    }

    @Override // com.opos.mobad.model.d.a, com.opos.mobad.model.d.b
    protected void b() {
        k();
        super.b();
    }
}
