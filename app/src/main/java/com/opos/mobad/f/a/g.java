package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.f.a.a.o;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class g extends com.opos.mobad.l.g {

    /* renamed from: b */
    private String f20723b;

    /* renamed from: c */
    private String f20724c;

    /* renamed from: d */
    private o<com.opos.mobad.ad.c.n, p> f20725d;

    /* renamed from: com.opos.mobad.f.a.g$1 */
    class AnonymousClass1 implements com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.n> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20726a;

        /* renamed from: b */
        final /* synthetic */ Context f20727b;

        /* renamed from: c */
        final /* synthetic */ s f20728c;

        /* renamed from: d */
        final /* synthetic */ String f20729d;

        AnonymousClass1(com.opos.mobad.f.b bVar, Context context, s sVar, String str) {
            bVar = bVar;
            context = context;
            sVar = sVar;
            str = str;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.c.n b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar.b(aVar.f23520a);
            if (b2 == null) {
                return null;
            }
            return b2.a(context, new s.a().a(sVar.f19482a).b(sVar.f19483b).a(), str, aVar.f23521b, g.this.new a(aVar.f23520a, nVar));
        }
    }

    /* renamed from: com.opos.mobad.f.a.g$2 */
    class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            List h2 = g.this.f20725d.h();
            g gVar = g.this;
            gVar.a(gVar.a((List<p>) h2, gVar.f20725d.j()));
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("dispatcher NT", "onAdFailed code=" + i2 + ",msg =" + str);
            g.this.a(com.opos.mobad.f.a.a.l.a(i2), str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
        }
    }

    public class a extends com.opos.mobad.f.a.a.p<p> implements com.opos.mobad.ad.c.o {

        /* renamed from: c */
        private int f20733c;

        public a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
            this.f20733c = i2;
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            if (this.f20733c == g.this.f20725d.j()) {
                com.opos.mobad.service.j.n.a().b(g.this.f20723b);
                g.this.a(pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            if (this.f20733c == g.this.f20725d.j()) {
                g.this.a(qVar, pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            if (this.f20733c == g.this.f20725d.j()) {
                com.opos.mobad.service.j.n.a().a(g.this.f20723b);
                g.this.b(pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            if (this.f20733c == g.this.f20725d.j()) {
                g.this.c(pVar);
            }
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            if (this.f20733c == g.this.f20725d.j()) {
                g.this.d(pVar);
            }
        }
    }

    private static class b implements p {

        /* renamed from: a */
        private String f20734a;

        /* renamed from: b */
        private String f20735b;

        /* renamed from: c */
        private int f20736c;

        /* renamed from: d */
        private boolean f20737d = false;

        /* renamed from: e */
        private p f20738e;

        /* renamed from: f */
        private int f20739f;

        public b(p pVar, String str, String str2, int i2, int i3) {
            this.f20738e = pVar;
            this.f20734a = str;
            this.f20735b = str2;
            this.f20736c = i2;
            this.f20739f = i3;
        }

        @Override // com.opos.mobad.ad.c.p
        public View a() {
            return this.f20738e.a();
        }

        @Override // com.opos.mobad.ad.g
        public void a(int i2, String str, int i3) {
            if (!com.opos.mobad.service.f.b().b(this.f20734a) || this.f20737d) {
                return;
            }
            this.f20737d = true;
            com.opos.mobad.service.i.d.a().a(this.f20734a, this.f20735b, i2, str, this.f20736c, this.f20739f, i3);
        }

        @Override // com.opos.mobad.ad.c.p
        public void a(Object obj) {
            this.f20738e.a(obj);
        }

        @Override // com.opos.mobad.ad.c.p
        public void b() {
            this.f20738e.b();
        }

        @Override // com.opos.mobad.ad.g
        public void b(int i2) {
            if (!com.opos.mobad.service.f.b().b(this.f20734a) || this.f20737d) {
                return;
            }
            this.f20737d = true;
            com.opos.mobad.service.i.d.a().a(this.f20734a, this.f20735b, this.f20736c, this.f20739f, i2);
        }

        @Override // com.opos.mobad.ad.c.p
        public void c() {
            this.f20738e.c();
        }

        @Override // com.opos.mobad.ad.g
        public void c(int i2) {
            if (!com.opos.mobad.service.f.b().b(this.f20734a) || this.f20737d) {
                return;
            }
            this.f20738e.c(i2);
        }

        @Override // com.opos.mobad.ad.c.p
        public Object d() {
            return this.f20738e.d();
        }

        @Override // com.opos.mobad.ad.g
        public int f() {
            return 0;
        }

        @Override // com.opos.mobad.ad.g
        public int g() {
            if (com.opos.mobad.service.f.b().b(this.f20734a)) {
                return this.f20739f;
            }
            return 0;
        }
    }

    public g(Context context, s sVar, String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.c.o oVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.b bVar) {
        super(oVar);
        this.f20723b = str;
        this.f20725d = a(str, aVar, list, aVar2, j2, new com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.n>() { // from class: com.opos.mobad.f.a.g.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.f.b f20726a;

            /* renamed from: b */
            final /* synthetic */ Context f20727b;

            /* renamed from: c */
            final /* synthetic */ s f20728c;

            /* renamed from: d */
            final /* synthetic */ String f20729d;

            AnonymousClass1(com.opos.mobad.f.b bVar2, Context context2, s sVar2, String str2) {
                bVar = bVar2;
                context = context2;
                sVar = sVar2;
                str = str2;
            }

            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.c.n b(e.a aVar3, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar.b(aVar3.f23520a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(context, new s.a().a(sVar.f19482a).b(sVar.f19483b).a(), str, aVar3.f23521b, g.this.new a(aVar3.f23520a, nVar));
            }
        }, new com.opos.mobad.f.a.c.a(context2));
    }

    private o<com.opos.mobad.ad.c.n, p> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.n> cVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j2, cVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.g.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a() {
                List h2 = g.this.f20725d.h();
                g gVar = g.this;
                gVar.a(gVar.a((List<p>) h2, gVar.f20725d.j()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i2, String str2) {
                com.opos.cmn.an.f.a.b("dispatcher NT", "onAdFailed code=" + i2 + ",msg =" + str2);
                g.this.a(com.opos.mobad.f.a.a.l.a(i2), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
            }
        });
    }

    public List<p> a(List<p> list, int i2) {
        e.a k;
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (p pVar : list) {
            if (pVar != null) {
                int g2 = pVar.g();
                arrayList.add(new b(pVar, this.f20723b, this.f20724c, i2, (g2 > 0 || ((k = this.f20725d.k()) != null && (g2 = k.f23526g) > 0)) ? g2 : 0));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().u());
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f20725d.b();
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str, int i2) {
        this.f20724c = str;
        this.f20725d.a(str, i2);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return 0;
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public boolean e() {
        return false;
    }
}
