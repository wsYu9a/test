package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.ad.b;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.f.a.a.o;
import com.opos.mobad.f.a.a.p;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends com.opos.mobad.l.e {

    /* renamed from: b */
    private o<com.opos.mobad.ad.c.g, com.opos.mobad.ad.c.h> f20707b;

    /* renamed from: c */
    private String f20708c;

    /* renamed from: d */
    private String f20709d;

    /* renamed from: com.opos.mobad.f.a.f$1 */
    class AnonymousClass1 implements com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.g> {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.f.b f20710a;

        /* renamed from: b */
        final /* synthetic */ Context f20711b;

        /* renamed from: c */
        final /* synthetic */ String f20712c;

        /* renamed from: d */
        final /* synthetic */ com.opos.mobad.ad.privacy.a f20713d;

        AnonymousClass1(com.opos.mobad.f.b bVar, Context context, String str, com.opos.mobad.ad.privacy.a aVar) {
            bVar = bVar;
            context = context;
            str = str;
            aVar3 = aVar;
        }

        @Override // com.opos.mobad.f.a.b.a
        /* renamed from: a */
        public com.opos.mobad.ad.c.g b(e.a aVar, com.opos.mobad.f.a.a.n nVar) {
            com.opos.mobad.ad.c b2 = bVar.b(aVar.f23520a);
            if (b2 == null) {
                return null;
            }
            return b2.a(context, str, aVar.f23521b, aVar.f23524e, aVar.f23523d, f.this.new a(aVar.f23520a, nVar), aVar3);
        }
    }

    /* renamed from: com.opos.mobad.f.a.f$2 */
    class AnonymousClass2 implements b.a {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.b.a
        public void a() {
            List h2 = f.this.f20707b.h();
            f fVar = f.this;
            fVar.a(fVar.a((List<com.opos.mobad.ad.c.h>) h2, fVar.f20707b.j()));
        }

        @Override // com.opos.mobad.ad.b.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("delegator NA", "onAdFailed code=" + i2 + ",msg =" + str);
            f.this.a(com.opos.mobad.f.a.a.l.a(i2), str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void b() {
        }
    }

    public class a extends p<com.opos.mobad.ad.c.h> implements com.opos.mobad.ad.c.j {
        public a(int i2, com.opos.mobad.f.a.a.n nVar) {
            super(i2, nVar);
        }
    }

    private static class b implements com.opos.mobad.ad.c.h {

        /* renamed from: a */
        private com.opos.mobad.ad.c.h f20717a;

        /* renamed from: b */
        private String f20718b;

        /* renamed from: c */
        private String f20719c;

        /* renamed from: d */
        private boolean f20720d = false;

        /* renamed from: e */
        private int f20721e;

        /* renamed from: f */
        private int f20722f;

        public b(com.opos.mobad.ad.c.h hVar, String str, String str2, int i2, int i3) {
            this.f20717a = hVar;
            this.f20718b = str;
            this.f20719c = str2;
            this.f20721e = i2;
            this.f20722f = i3;
        }

        @Override // com.opos.mobad.ad.c.h
        public String a() {
            return this.f20717a.a();
        }

        @Override // com.opos.mobad.ad.g
        public void a(int i2, String str, int i3) {
            if (!com.opos.mobad.service.f.b().b(this.f20718b) || this.f20720d) {
                return;
            }
            this.f20720d = true;
            com.opos.mobad.service.i.d.a().a(this.f20718b, this.f20719c, i2, str, this.f20721e, this.f20722f, i3);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(Context context, FrameLayout frameLayout, com.opos.mobad.ad.c.k kVar) {
            this.f20717a.a(context, frameLayout, kVar);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(Context context, FrameLayout frameLayout, List<View> list) {
            this.f20717a.a(context, frameLayout, list);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
            this.f20717a.a(context, list, aVar, list2, aVar2);
        }

        @Override // com.opos.mobad.ad.c.h
        public void a(com.opos.mobad.ad.c.i iVar) {
            this.f20717a.a(iVar);
        }

        @Override // com.opos.mobad.ad.c.h
        public String b() {
            return this.f20717a.b();
        }

        @Override // com.opos.mobad.ad.g
        public void b(int i2) {
            if (!com.opos.mobad.service.f.b().b(this.f20718b) || this.f20720d) {
                return;
            }
            this.f20720d = true;
            com.opos.mobad.service.i.d.a().a(this.f20718b, this.f20719c, this.f20721e, this.f20722f, i2);
        }

        @Override // com.opos.mobad.ad.c.h
        public List<com.opos.mobad.ad.c.e> c() {
            return this.f20717a.c();
        }

        @Override // com.opos.mobad.ad.g
        public void c(int i2) {
            this.f20717a.c(i2);
        }

        @Override // com.opos.mobad.ad.c.h
        public List<com.opos.mobad.ad.c.e> d() {
            return this.f20717a.d();
        }

        @Override // com.opos.mobad.ad.c.h
        public int e() {
            return this.f20717a.e();
        }

        @Override // com.opos.mobad.ad.g
        public int f() {
            return 0;
        }

        @Override // com.opos.mobad.ad.g
        public int g() {
            if (com.opos.mobad.service.f.b().b(this.f20718b)) {
                return this.f20722f;
            }
            return 0;
        }

        @Override // com.opos.mobad.ad.c.h
        public int h() {
            return this.f20717a.h();
        }

        @Override // com.opos.mobad.ad.c.h
        public com.opos.mobad.ad.c.e i() {
            return this.f20717a.i();
        }

        @Override // com.opos.mobad.ad.c.h
        public boolean j() {
            return this.f20717a.j();
        }

        @Override // com.opos.mobad.ad.c.h
        public String k() {
            return this.f20717a.k();
        }

        @Override // com.opos.mobad.ad.c.h
        public String l() {
            return this.f20717a.l();
        }

        @Override // com.opos.mobad.ad.c.h
        public void m() {
            this.f20717a.m();
        }

        @Override // com.opos.mobad.ad.c.h
        public com.opos.mobad.ad.c.b n() {
            return this.f20717a.n();
        }
    }

    public f(Context context, String str, com.opos.mobad.f.a.d.a aVar, com.opos.mobad.ad.c.j jVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.b bVar, com.opos.mobad.ad.privacy.a aVar3) {
        super(jVar);
        this.f20709d = str;
        this.f20707b = a(str, aVar, list, aVar2, j2, new com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.g>() { // from class: com.opos.mobad.f.a.f.1

            /* renamed from: a */
            final /* synthetic */ com.opos.mobad.f.b f20710a;

            /* renamed from: b */
            final /* synthetic */ Context f20711b;

            /* renamed from: c */
            final /* synthetic */ String f20712c;

            /* renamed from: d */
            final /* synthetic */ com.opos.mobad.ad.privacy.a f20713d;

            AnonymousClass1(com.opos.mobad.f.b bVar2, Context context2, String str2, com.opos.mobad.ad.privacy.a aVar32) {
                bVar = bVar2;
                context = context2;
                str = str2;
                aVar3 = aVar32;
            }

            @Override // com.opos.mobad.f.a.b.a
            /* renamed from: a */
            public com.opos.mobad.ad.c.g b(e.a aVar4, com.opos.mobad.f.a.a.n nVar) {
                com.opos.mobad.ad.c b2 = bVar.b(aVar4.f23520a);
                if (b2 == null) {
                    return null;
                }
                return b2.a(context, str, aVar4.f23521b, aVar4.f23524e, aVar4.f23523d, f.this.new a(aVar4.f23520a, nVar), aVar3);
            }
        }, new com.opos.mobad.f.a.c.a(context2));
    }

    private o<com.opos.mobad.ad.c.g, com.opos.mobad.ad.c.h> a(String str, com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j2, com.opos.mobad.f.a.b.c<com.opos.mobad.ad.c.g> cVar, com.opos.mobad.f.a.c.a aVar3) {
        return com.opos.mobad.f.a.a.k.a(str, aVar, list, aVar2, j2, cVar, aVar3, new b.a() { // from class: com.opos.mobad.f.a.f.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.ad.b.a
            public void a() {
                List h2 = f.this.f20707b.h();
                f fVar = f.this;
                fVar.a(fVar.a((List<com.opos.mobad.ad.c.h>) h2, fVar.f20707b.j()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i2, String str2) {
                com.opos.cmn.an.f.a.b("delegator NA", "onAdFailed code=" + i2 + ",msg =" + str2);
                f.this.a(com.opos.mobad.f.a.a.l.a(i2), str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
            }
        });
    }

    public List<com.opos.mobad.ad.c.h> a(List<com.opos.mobad.ad.c.h> list, int i2) {
        e.a k;
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (com.opos.mobad.ad.c.h hVar : list) {
            if (hVar != null) {
                int g2 = hVar.g();
                arrayList.add(new b(hVar, this.f20709d, this.f20708c, i2, (g2 > 0 || ((k = this.f20707b.k()) != null && (g2 = k.f23526g) > 0)) ? g2 : 0));
            }
        }
        return arrayList;
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void a() {
        a(com.opos.mobad.service.f.b().s());
    }

    @Override // com.opos.mobad.l.f, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f20707b.b();
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str, int i2) {
        this.f20708c = str;
        this.f20707b.a(str, i2);
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
