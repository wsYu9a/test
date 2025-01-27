package com.opos.mobad.model.d;

import android.content.Context;
import com.martian.rpauth.MartianRPUserManager;
import com.opos.mobad.b.a.y;
import com.opos.mobad.model.d.m;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.CustomInfoData;
import com.opos.mobad.model.data.MaterialData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public abstract class a extends b {

    /* renamed from: a */
    protected i f21535a;

    /* renamed from: b */
    private Context f21536b;

    /* renamed from: c */
    private String f21537c;

    /* renamed from: d */
    private boolean f21538d;

    /* renamed from: e */
    private o f21539e;

    /* renamed from: f */
    private com.opos.mobad.model.b.c f21540f;

    /* renamed from: g */
    private com.opos.mobad.model.b.d f21541g;

    /* renamed from: h */
    private AdData f21542h;

    /* renamed from: i */
    private Set<String> f21543i;

    /* renamed from: j */
    private Set<com.opos.mobad.model.b.e> f21544j;
    private Set<com.opos.mobad.model.b.e> k;

    /* renamed from: com.opos.mobad.model.d.a$1 */
    class AnonymousClass1 implements Callable<Boolean> {

        /* renamed from: a */
        final /* synthetic */ Set f21545a;

        /* renamed from: b */
        final /* synthetic */ Set f21546b;

        /* renamed from: c */
        final /* synthetic */ AdData f21547c;

        /* renamed from: d */
        final /* synthetic */ com.opos.mobad.model.b.d f21548d;

        AnonymousClass1(Set set, Set set2, AdData adData, com.opos.mobad.model.b.d dVar) {
            hashSet = set;
            hashSet2 = set2;
            a2 = adData;
            dVar = dVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            a.this.f21544j = hashSet;
            a.this.k = hashSet2;
            a.this.f21542h = a2;
            a.this.f21541g = dVar;
            return Boolean.TRUE;
        }
    }

    /* renamed from: com.opos.mobad.model.d.a$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean a2 = (a.this.f21544j == null || a.this.f21544j.size() <= 0) ? true : a.this.f21539e.a(a.this.f21544j, a.this.f21535a, new CustomInfoData(a.this.f21541g.r()));
            a.this.f21535a.d();
            if (a2) {
                a.this.k();
                return;
            }
            AdData adData = new AdData(10011, "download material failed", a.this.f21542h.g(), a.this.f21542h.c());
            a aVar = a.this;
            aVar.f21535a.a(aVar.f21536b, adData.d());
            a.this.b(adData);
        }
    }

    /* renamed from: com.opos.mobad.model.d.a$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ i f21551a;

        AnonymousClass3(i iVar) {
            iVar = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f21539e.a(a.this.k, null);
            i iVar = iVar;
            if (iVar != null) {
                iVar.e();
                iVar.b(a.this.f21536b);
            }
        }
    }

    /* renamed from: com.opos.mobad.model.d.a$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f21553a;

        /* renamed from: b */
        final /* synthetic */ boolean f21554b;

        AnonymousClass4(List list, boolean z) {
            h2 = list;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            y yVar;
            com.opos.cmn.an.f.a.b("ALoader", "cache list");
            ArrayList arrayList = new ArrayList();
            for (com.opos.mobad.b.a.b bVar : h2) {
                List<y> list = bVar.A;
                if (list != null && list.size() > 0 && (yVar = bVar.A.get(0)) != null && (!z || !a.this.f21543i.contains(yVar.aU))) {
                    a aVar = a.this;
                    if (aVar.a(aVar.f21540f.e(), bVar, yVar, true, null)) {
                        arrayList.add(bVar);
                        if (arrayList.size() >= a.this.f21541g.b()) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            c.a(a.this.f21536b).a(a.this.f21537c, a.this.f21541g, arrayList);
        }
    }

    public a(Context context, String str, com.opos.mobad.model.b.c cVar, boolean z, i iVar, m.a aVar) {
        super(aVar);
        this.f21543i = new HashSet();
        this.f21536b = context;
        this.f21537c = str;
        this.f21540f = cVar;
        this.f21538d = z;
        this.f21535a = iVar;
        this.f21539e = new j(context);
    }

    private AdData a(com.opos.mobad.model.b.c cVar, com.opos.mobad.model.b.d dVar, boolean z, q qVar, Set<com.opos.mobad.model.b.e> set, Set<com.opos.mobad.model.b.e> set2) {
        List<y> list;
        y yVar;
        int i2;
        CustomInfoData customInfoData;
        try {
            if (dVar == null) {
                return new AdData(10001, "net response is null.");
            }
            if (dVar.f() != 0) {
                return new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
            }
            List<com.opos.mobad.b.a.b> h2 = dVar.h();
            if (h2 != null && h2.size() > 0) {
                if (dVar.i() <= System.currentTimeMillis()) {
                    return new AdData(10003, com.opos.mobad.ad.a.a(10003), dVar.l(), dVar.m());
                }
                ArrayList arrayList = new ArrayList();
                int max = Math.max(1, dVar.e());
                CustomInfoData customInfoData2 = new CustomInfoData(dVar.r());
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                while (i5 < h2.size() && i4 < max) {
                    com.opos.mobad.b.a.b bVar = h2.get(i5);
                    if (bVar != null && (list = bVar.A) != null && list.size() > 0 && (yVar = list.get(i3)) != null && a(cVar.e(), bVar, yVar, false, qVar)) {
                        this.f21543i.add(yVar.aU);
                        qVar.a(yVar, bVar.D);
                        int i6 = i4;
                        i2 = i5;
                        customInfoData = customInfoData2;
                        AdItemData adItemData = new AdItemData(bVar, d.a(this.f21536b, yVar, set, set2, z, qVar), d.a(this.f21536b, bVar, set, z, qVar), dVar.k(), dVar.i(), dVar.j(), cVar.a(), customInfoData, cVar.e(), cVar.i(), dVar.s());
                        if (dVar.a()) {
                            adItemData.H();
                        }
                        arrayList.add(adItemData);
                        i4 = i6 + 1;
                        i5 = i2 + 1;
                        customInfoData2 = customInfoData;
                        i3 = 0;
                    }
                    i2 = i5;
                    customInfoData = customInfoData2;
                    i4 = i4;
                    i5 = i2 + 1;
                    customInfoData2 = customInfoData;
                    i3 = 0;
                }
                if (arrayList.size() <= 0) {
                    return new AdData(MartianRPUserManager.f14920g, "adItemList is null.", dVar.l(), dVar.m());
                }
                AdData adData = new AdData(dVar.f(), dVar.g(), dVar.l(), dVar.m());
                adData.a(dVar.i());
                adData.a(dVar.o());
                adData.d(dVar.n());
                adData.a(arrayList);
                adData.b(10000);
                adData.a("ok.");
                return adData;
            }
            return new AdData(10002, "response ad list is null.", dVar.l(), dVar.m());
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("ALoader", "", (Throwable) e2);
            return new AdData(-1, "unknown error.");
        }
    }

    private void a(List<AdItemData> list) {
        MaterialData materialData;
        com.opos.cmn.an.f.a.b("ALoader", "prepare web" + list);
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdItemData> it = list.iterator();
        while (it.hasNext()) {
            List<MaterialData> i2 = it.next().i();
            if (i2 != null && i2.size() > 0 && (materialData = i2.get(0)) != null) {
                u.a(this.f21536b, materialData.f21725i, materialData.f21724h);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0095, code lost:
    
        if (r8 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r8 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r8.b(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r4, com.opos.mobad.b.a.b r5, com.opos.mobad.b.a.y r6, boolean r7, com.opos.mobad.model.d.q r8) {
        /*
            r3 = this;
            android.content.Context r0 = r3.f21536b
            boolean r0 = com.opos.mobad.model.d.d.a(r0, r6, r8)
            r1 = 0
            if (r0 != 0) goto Lc
        L9:
            r7 = 0
            goto L99
        Lc:
            boolean r0 = b(r6)
            if (r0 != 0) goto L18
            if (r8 == 0) goto L9
        L14:
            r8.b(r6)
            goto L9
        L18:
            boolean r0 = com.opos.mobad.model.d.d.b(r6)
            if (r0 == 0) goto L2c
            android.content.Context r0 = r3.f21536b
            boolean r0 = com.opos.mobad.cmn.a.b.h.a(r0)
            if (r0 != 0) goto L2c
            if (r8 == 0) goto L9
            r8.c(r6)
            goto L9
        L2c:
            boolean r0 = com.opos.mobad.model.d.d.a(r6)
            if (r0 == 0) goto L74
            java.util.List<com.opos.mobad.b.a.x> r0 = r6.aq
            if (r0 == 0) goto L6e
            int r2 = r0.size()
            if (r2 > 0) goto L3d
            goto L6e
        L3d:
            r2 = 3
            if (r4 == r2) goto L43
            r2 = 6
            if (r4 != r2) goto L5b
        L43:
            com.opos.mobad.b.a.b$c r4 = r5.M
            if (r4 == 0) goto L5b
            com.opos.mobad.b.a.b$c r4 = com.opos.mobad.b.a.b.c.PLAY_CACHE
            int r4 = r4.a()
            com.opos.mobad.b.a.b$c r2 = r5.M
            int r2 = r2.a()
            if (r4 == r2) goto L5b
            if (r8 == 0) goto L9
            r8.f(r6)
            goto L9
        L5b:
            android.content.Context r4 = r3.f21536b
            boolean r4 = com.opos.mobad.model.d.d.a(r4, r5, r0)
            if (r4 != 0) goto L93
            if (r8 == 0) goto L68
            r8.e(r6)
        L68:
            if (r7 != 0) goto L99
            r3.a(r6)
            goto L99
        L6e:
            if (r8 == 0) goto L9
            r8.d(r6)
            goto L9
        L74:
            java.util.List<com.opos.mobad.b.a.x> r4 = r6.V
            if (r4 == 0) goto L7e
            int r4 = r4.size()
            if (r4 > 0) goto L93
        L7e:
            java.util.List<com.opos.mobad.b.a.x> r4 = r6.S
            if (r4 == 0) goto L88
            int r4 = r4.size()
            if (r4 > 0) goto L93
        L88:
            java.util.List<com.opos.mobad.b.a.x> r4 = r6.ba
            if (r4 == 0) goto L95
            int r4 = r4.size()
            if (r4 > 0) goto L93
            goto L95
        L93:
            r7 = 1
            goto L99
        L95:
            if (r8 == 0) goto L9
            goto L14
        L99:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.d.a.a(int, com.opos.mobad.b.a.b, com.opos.mobad.b.a.y, boolean, com.opos.mobad.model.d.q):boolean");
    }

    private boolean a(i iVar) {
        Set<com.opos.mobad.model.b.e> set = this.k;
        if (set == null || set.size() <= 0) {
            return false;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.a.3

            /* renamed from: a */
            final /* synthetic */ i f21551a;

            AnonymousClass3(i iVar2) {
                iVar = iVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f21539e.a(a.this.k, null);
                i iVar2 = iVar;
                if (iVar2 != null) {
                    iVar2.e();
                    iVar.b(a.this.f21536b);
                }
            }
        });
        return true;
    }

    private static boolean b(y yVar) {
        String str;
        y.c cVar;
        y.c cVar2;
        if (!c(yVar) || (cVar = yVar.ax) != (cVar2 = y.c.DOWNLOADER)) {
            str = "is not downloader mat";
        } else {
            if (cVar != cVar2) {
                com.opos.cmn.an.f.a.b("ALoader", "is invalid downloader mat");
                return false;
            }
            str = "is downloader mat";
        }
        com.opos.cmn.an.f.a.b("ALoader", str);
        return true;
    }

    private static boolean c(y yVar) {
        y.h hVar = yVar.R;
        y.h hVar2 = y.h.DOWNLOAD;
        return hVar == hVar2 || yVar.au == hVar2 || yVar.av == hVar2 || yVar.aI == hVar2 || yVar.aJ == hVar2;
    }

    public void k() {
        if (!a(this.f21535a)) {
            this.f21535a.b(this.f21536b);
        }
        c(this.f21542h);
    }

    @Override // com.opos.mobad.model.d.b
    public void a() {
        Set<com.opos.mobad.model.b.e> set = this.f21544j;
        if (set != null && set.size() > 0) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.a.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean a2 = (a.this.f21544j == null || a.this.f21544j.size() <= 0) ? true : a.this.f21539e.a(a.this.f21544j, a.this.f21535a, new CustomInfoData(a.this.f21541g.r()));
                    a.this.f21535a.d();
                    if (a2) {
                        a.this.k();
                        return;
                    }
                    AdData adData = new AdData(10011, "download material failed", a.this.f21542h.g(), a.this.f21542h.c());
                    a aVar = a.this;
                    aVar.f21535a.a(aVar.f21536b, adData.d());
                    a.this.b(adData);
                }
            });
            return;
        }
        com.opos.cmn.an.f.a.b("ALoader", "resource available");
        this.f21535a.d();
        k();
    }

    protected abstract void a(y yVar);

    protected abstract void a(com.opos.mobad.model.b.c cVar);

    protected final void a(com.opos.mobad.model.b.d dVar) {
        this.f21535a.b();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        AdData a2 = a(this.f21540f, dVar, !this.f21538d, this.f21535a, hashSet, hashSet2);
        this.f21535a.c();
        com.opos.cmn.an.f.a.b("ALoader", "load data:" + a2);
        if (a2 == null || a2.d() != 10000) {
            this.f21535a.a(this.f21536b, a2 != null ? a2.d() : -1);
            a(a2);
        } else {
            a(new Callable<Boolean>() { // from class: com.opos.mobad.model.d.a.1

                /* renamed from: a */
                final /* synthetic */ Set f21545a;

                /* renamed from: b */
                final /* synthetic */ Set f21546b;

                /* renamed from: c */
                final /* synthetic */ AdData f21547c;

                /* renamed from: d */
                final /* synthetic */ com.opos.mobad.model.b.d f21548d;

                AnonymousClass1(Set hashSet3, Set hashSet22, AdData a22, com.opos.mobad.model.b.d dVar2) {
                    hashSet = hashSet3;
                    hashSet2 = hashSet22;
                    a2 = a22;
                    dVar = dVar2;
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    a.this.f21544j = hashSet;
                    a.this.k = hashSet2;
                    a.this.f21542h = a2;
                    a.this.f21541g = dVar;
                    return Boolean.TRUE;
                }
            });
            if (j() == 8) {
                this.f21535a.a(this.f21536b);
            }
        }
    }

    public void a(boolean z) {
        List<com.opos.mobad.b.a.b> h2;
        com.opos.cmn.an.f.a.b("ALoader", this + ",cache:" + z);
        com.opos.mobad.model.b.d dVar = this.f21541g;
        if (dVar != null && (h2 = dVar.h()) != null && h2.size() > 0 && this.f21541g.b() > 0) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.model.d.a.4

                /* renamed from: a */
                final /* synthetic */ List f21553a;

                /* renamed from: b */
                final /* synthetic */ boolean f21554b;

                AnonymousClass4(List h22, boolean z2) {
                    h2 = h22;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    y yVar;
                    com.opos.cmn.an.f.a.b("ALoader", "cache list");
                    ArrayList arrayList = new ArrayList();
                    for (com.opos.mobad.b.a.b bVar : h2) {
                        List<y> list = bVar.A;
                        if (list != null && list.size() > 0 && (yVar = bVar.A.get(0)) != null && (!z || !a.this.f21543i.contains(yVar.aU))) {
                            a aVar = a.this;
                            if (aVar.a(aVar.f21540f.e(), bVar, yVar, true, null)) {
                                arrayList.add(bVar);
                                if (arrayList.size() >= a.this.f21541g.b()) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    c.a(a.this.f21536b).a(a.this.f21537c, a.this.f21541g, arrayList);
                }
            });
        }
    }

    @Override // com.opos.mobad.model.d.b
    protected void b() {
        if (j() != 3) {
            return;
        }
        this.f21535a.a(this.f21536b);
    }

    public void c() {
        AdData adData;
        if (j() != 6 || (adData = this.f21542h) == null) {
            return;
        }
        a(adData.f());
    }

    public boolean d() {
        StringBuilder sb = new StringBuilder();
        sb.append("resource size:");
        Set<com.opos.mobad.model.b.e> set = this.f21544j;
        sb.append(set == null ? 0 : set.size());
        com.opos.cmn.an.f.a.b("ALoader", sb.toString());
        Set<com.opos.mobad.model.b.e> set2 = this.f21544j;
        return set2 == null || set2.size() <= 0;
    }

    @Override // com.opos.mobad.model.d.b
    protected void e() {
        a(this.f21540f);
    }
}
