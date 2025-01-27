package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.f.b.i;
import com.opos.mobad.g;
import com.opos.mobad.service.a.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    private c.a f20532a = new c.a(true, "");

    /* renamed from: c */
    private AtomicBoolean f20534c = new AtomicBoolean(false);

    /* renamed from: d */
    private boolean f20535d = false;

    /* renamed from: b */
    private b f20533b = new b();

    /* renamed from: e */
    private com.opos.mobad.ad.privacy.a f20536e = new com.opos.mobad.cmn.b.d(new g());

    /* renamed from: com.opos.mobad.f.a$1 */
    class AnonymousClass1 implements e.d {

        /* renamed from: a */
        final /* synthetic */ Context f20537a;

        /* renamed from: b */
        final /* synthetic */ boolean f20538b;

        AnonymousClass1(Context context, boolean z) {
            context = context;
            z = z;
        }

        @Override // com.opos.mobad.service.a.e.d
        public void a() {
            a.this.f20533b.a(context, com.opos.mobad.service.f.b(), z);
        }
    }

    protected a() {
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, e.a aVar2, com.opos.mobad.ad.c cVar) {
        if (aVar instanceof com.opos.mobad.f.b.b) {
            com.opos.mobad.f.b.b bVar = (com.opos.mobad.f.b.b) aVar;
            return cVar.a((Activity) bVar.f20805d, bVar.f20799a, aVar2.f23521b, bVar.f20801c, (com.opos.mobad.ad.a.b) bVar.f20806e);
        }
        if (aVar instanceof com.opos.mobad.f.b.d) {
            com.opos.mobad.f.b.d dVar = (com.opos.mobad.f.b.d) aVar;
            return cVar.a((Activity) dVar.f20805d, dVar.f20799a, aVar2.f23521b, com.opos.mobad.service.f.b().a(dVar.f20799a) == com.opos.mobad.service.a.e.f23504b, (com.opos.mobad.ad.b.d) dVar.f20806e);
        }
        if (aVar instanceof com.opos.mobad.f.b.c) {
            com.opos.mobad.f.b.c cVar2 = (com.opos.mobad.f.b.c) aVar;
            return cVar.a((Activity) cVar2.f20805d, cVar2.f20799a, aVar2.f23521b, (com.opos.mobad.ad.b.b) cVar2.f20806e);
        }
        if (aVar instanceof com.opos.mobad.f.b.e) {
            com.opos.mobad.f.b.e eVar = (com.opos.mobad.f.b.e) aVar;
            return cVar.a(eVar.f20802c, eVar.f20799a, aVar2.f23521b, aVar2.f23524e, aVar2.f23523d, (j) eVar.f20803d, this.f20536e);
        }
        if (aVar instanceof com.opos.mobad.f.b.g) {
            com.opos.mobad.f.b.g gVar = (com.opos.mobad.f.b.g) aVar;
            return cVar.a(gVar.f20802c, gVar.f20804e, gVar.f20799a, aVar2.f23521b, (o) gVar.f20803d);
        }
        if (aVar instanceof i) {
            i iVar = (i) aVar;
            return cVar.a(iVar.f20805d, iVar.f20799a, aVar2.f23521b, com.opos.mobad.service.f.b().a(iVar.f20799a) == com.opos.mobad.service.a.e.f23504b, (com.opos.mobad.ad.d.b) iVar.f20806e);
        }
        if (aVar instanceof com.opos.mobad.f.b.j) {
            com.opos.mobad.f.b.j jVar = (com.opos.mobad.f.b.j) aVar;
            f fVar = new f();
            com.opos.mobad.ad.e.b a2 = cVar.a((Activity) jVar.f20805d, jVar.f20799a, aVar2.f23521b, jVar.f20807c, (com.opos.mobad.ad.e.c) jVar.f20806e);
            fVar.a(a2);
            return a2;
        }
        com.opos.cmn.an.f.a.b("AdBaseFactory", "fail create:" + aVar);
        return null;
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, List<e.a> list, e.a aVar2, long j2, int i2) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create ssp posId:" + aVar.f20799a + "," + list + ",reserve =" + aVar2 + "," + i2);
        return a(aVar, a(aVar.f20799a, list.get(0)), new d(new com.opos.mobad.f.a.d.c(i2, aVar.f20800b), list, aVar2, j2, this.f20533b));
    }

    private com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar, List<e.a> list, e.a aVar2, long j2, long j3) {
        e.a a2 = a(aVar.f20799a, list, aVar2, j2);
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create delegator posId:" + aVar.f20799a + "," + list + "," + a2);
        return a(aVar, b(aVar.f20799a, list.get(0)), new d(new com.opos.mobad.f.a.d.b(aVar.f20800b), list, a2, j3, this.f20533b));
    }

    private e.a a(String str) {
        return new e.a(1, str, 100, 30000L, 0, 0);
    }

    private e.a a(String str, e.a aVar) {
        return new e.a(1, str, 100, 30000L, aVar.f23523d, aVar.f23524e);
    }

    private e.a a(String str, List<e.a> list, e.a aVar, long j2) {
        boolean z;
        boolean z2 = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (true) {
            z = false;
            for (e.a aVar2 : list) {
                i3 = aVar2.f23523d;
                i4 = aVar2.f23524e;
                int i5 = aVar2.f23525f;
                i2 += i5;
                z2 = z2 || 1 == aVar2.f23520a;
                if (z || (aVar != null && aVar.f23520a == aVar2.f23520a && i5 > 0)) {
                    z = true;
                }
            }
            break loop0;
        }
        if (!z2 && i2 < 100) {
            list.add(new e.a(1, str, 100 - i2, j2, i3, i4));
            z2 = true;
        }
        if (!z && aVar != null) {
            return aVar;
        }
        if (z2) {
            return null;
        }
        return new e.a(1, str, 100, j2, i3, i4);
    }

    private e.a a(List<e.a> list, String str, long j2) {
        List<e.a> arrayList = list == null ? new ArrayList<>() : list;
        e.a aVar = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (e.a aVar2 : arrayList) {
            if (1 == aVar2.f23520a) {
                aVar = aVar2;
            }
            i3 = aVar2.f23523d;
            i4 = aVar2.f23524e;
            i2 += aVar2.f23525f;
        }
        if (aVar != null) {
            return aVar;
        }
        e.a aVar3 = new e.a(1, str, Math.max(0, 100 - i2), j2, i3, i4);
        arrayList.add(aVar3);
        return aVar3;
    }

    private com.opos.mobad.ad.b b(com.opos.mobad.f.b.a aVar) {
        com.opos.cmn.an.f.a.a("AdBaseFactory", "create default posId:" + aVar.f20799a);
        ArrayList arrayList = new ArrayList();
        e.a a2 = a(aVar.f20799a);
        return a(aVar, a2, new d(new com.opos.mobad.f.a.d.b(aVar.f20800b), arrayList, a2, 0L, this.f20533b));
    }

    private e.a b(String str, e.a aVar) {
        return new e.a(1, str, 100, 30000L, aVar.f23523d, aVar.f23524e);
    }

    private boolean d() {
        if (this.f20532a.f19473a || !com.opos.cmn.a.a.a()) {
            return com.opos.mobad.service.f.b().b();
        }
        com.opos.cmn.an.f.a.b("AdBaseFactory", "check result fail:" + this.f20532a.f19474b);
        return false;
    }

    public com.opos.mobad.ad.a.a a(Activity activity, String str, com.opos.mobad.ad.a.b bVar) {
        return (com.opos.mobad.ad.a.a) a(new com.opos.mobad.f.b.b(activity, str, com.opos.mobad.service.f.b().i(), true, bVar));
    }

    public com.opos.mobad.ad.b.a a(Activity activity, String str, com.opos.mobad.ad.b.b bVar) {
        return (com.opos.mobad.ad.b.a) a(new com.opos.mobad.f.b.c(activity, str, com.opos.mobad.service.f.b().n(), bVar));
    }

    public com.opos.mobad.ad.b.c a(Activity activity, String str, com.opos.mobad.ad.b.d dVar) {
        return (com.opos.mobad.ad.b.c) a(new com.opos.mobad.f.b.d(activity, str, com.opos.mobad.service.f.b().p(), dVar));
    }

    protected com.opos.mobad.ad.b a(com.opos.mobad.f.b.a aVar) {
        List<e.a> list;
        e.b a2 = d() ? com.opos.mobad.service.f.b().a(aVar.f20799a, true) : null;
        if (a2 == null || (list = a2.f23527a) == null || list.size() <= 0) {
            return b(aVar);
        }
        com.opos.mobad.f.b.a bVar = aVar instanceof com.opos.mobad.f.b.b ? new com.opos.mobad.f.b.b((Activity) ((com.opos.mobad.f.b.b) aVar).f20805d, aVar.f20799a, aVar.f20800b, false, (com.opos.mobad.ad.a.b) ((com.opos.mobad.f.b.b) aVar).f20806e) : aVar;
        if (a2.f23531e == 1) {
            return a(bVar, a2.f23527a, a2.f23528b, a2.f23529c, a2.f23530d);
        }
        List<e.a> list2 = a2.f23527a;
        return a(bVar, list2, a(list2, aVar.f20799a, a2.f23529c), a2.f23530d, a2.f23531e);
    }

    public c.a a() {
        return this.f20532a;
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, int i2, m mVar) {
        com.opos.mobad.ad.c b2;
        b bVar = this.f20533b;
        if (bVar == null || (b2 = bVar.b(1)) == null || !(b2 instanceof com.opos.mobad.f)) {
            return null;
        }
        return ((com.opos.mobad.f) b2).a(context, str, str, i2, mVar);
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, com.opos.mobad.ad.c.f fVar) {
        com.opos.mobad.ad.c b2;
        b bVar = this.f20533b;
        if (bVar == null || (b2 = bVar.b(1)) == null) {
            return null;
        }
        return b2.a(context, str, str, fVar);
    }

    public com.opos.mobad.ad.c.g a(Context context, String str, j jVar) {
        return (com.opos.mobad.ad.c.g) a(new com.opos.mobad.f.b.e(context, str, com.opos.mobad.service.f.b().s(), jVar));
    }

    public n a(Context context, String str, s sVar, o oVar) {
        return (n) a(new com.opos.mobad.f.b.g(context, str, com.opos.mobad.service.f.b().u(), sVar, oVar));
    }

    public com.opos.mobad.ad.d.a a(Context context, String str, com.opos.mobad.ad.d.b bVar) {
        return (com.opos.mobad.ad.d.a) a(new i(context, str, com.opos.mobad.service.f.b().q(), bVar));
    }

    public com.opos.mobad.ad.e.a a(Context context, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        a(context);
        return new com.opos.mobad.f.a.c(context, str, fVar, cVar, this.f20533b);
    }

    public com.opos.mobad.ad.e.b a(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        a(activity);
        return new com.opos.mobad.f.a.j(activity, str, fVar, cVar, this.f20533b);
    }

    protected void a(Context context) {
        this.f20533b.a(context.getApplicationContext(), com.opos.mobad.service.f.b(), this.f20535d);
    }

    protected void a(Context context, Integer num, com.opos.mobad.ad.c cVar) {
        c.a a2 = this.f20533b.a(context, num, cVar);
        if (a2.f19473a) {
            return;
        }
        this.f20532a = a2;
    }

    protected void a(Context context, boolean z) {
        this.f20535d = z;
        com.opos.mobad.service.f.b().a(new e.d() { // from class: com.opos.mobad.f.a.1

            /* renamed from: a */
            final /* synthetic */ Context f20537a;

            /* renamed from: b */
            final /* synthetic */ boolean f20538b;

            AnonymousClass1(Context context2, boolean z2) {
                context = context2;
                z = z2;
            }

            @Override // com.opos.mobad.service.a.e.d
            public void a() {
                a.this.f20533b.a(context, com.opos.mobad.service.f.b(), z);
            }
        });
        this.f20533b.a(context2, com.opos.mobad.service.f.b(), z2);
    }

    public com.opos.mobad.ad.e.b b(Activity activity, String str, com.opos.mobad.ad.e.c cVar, com.opos.mobad.ad.e.f fVar) {
        a(activity);
        return new com.opos.mobad.f.a.j(activity, str, fVar, cVar, this.f20533b);
    }

    public boolean b() {
        return this.f20533b.a();
    }

    protected void c() {
        b bVar = this.f20533b;
        if (bVar != null) {
            bVar.b();
        }
    }
}
