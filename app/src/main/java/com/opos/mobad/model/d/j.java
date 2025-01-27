package com.opos.mobad.model.d;

import android.content.Context;
import com.opos.cmn.func.b.b.d;
import com.opos.mobad.c.a.a;
import com.opos.mobad.i.a;
import com.opos.mobad.model.data.CustomInfoData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class j implements o {

    /* renamed from: a */
    private Context f21622a;

    /* renamed from: b */
    private com.opos.mobad.model.a.c f21623b;

    /* renamed from: com.opos.mobad.model.d.j$1 */
    class AnonymousClass1 implements a.InterfaceC0427a {

        /* renamed from: a */
        final /* synthetic */ AtomicInteger f21624a;

        /* renamed from: b */
        final /* synthetic */ q f21625b;

        /* renamed from: c */
        final /* synthetic */ CountDownLatch f21626c;

        AnonymousClass1(AtomicInteger atomicInteger, q qVar, CountDownLatch countDownLatch) {
            atomicInteger = atomicInteger;
            qVar = qVar;
            countDownLatch = countDownLatch;
        }

        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
        public void a() {
            countDownLatch.countDown();
        }

        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
        public void a(String str) {
        }

        @Override // com.opos.mobad.c.a.a.InterfaceC0427a
        public void a(String str, int i2) {
            com.opos.cmn.an.f.a.b("FetchMaterialTask", "load:" + str + "," + i2);
            if (i2 == 1 || i2 == 0) {
                atomicInteger.incrementAndGet();
            }
            j.this.a(str, i2, qVar);
        }
    }

    public j(Context context) {
        this.f21622a = context;
        this.f21623b = new com.opos.mobad.model.a.a.c(context);
    }

    private com.opos.mobad.i.a a(com.opos.mobad.model.b.e eVar) {
        try {
            return new a.C0449a().a(new d.a().a("GET").b(eVar.a()).a()).a(eVar.b()).b(eVar.c()).a(0).a();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e2);
            return null;
        }
    }

    public void a(String str, int i2, q qVar) {
        if (qVar == null) {
            return;
        }
        int i3 = 1;
        if (i2 != 0) {
            if (i2 == 1) {
                qVar.a(str, 2);
                return;
            }
            i3 = 3;
            if (i2 != 2 && i2 != 3) {
                return;
            }
        }
        qVar.a(str, i3);
    }

    private boolean a(com.opos.mobad.model.b.f fVar, com.opos.mobad.model.b.g gVar, q qVar) {
        com.opos.cmn.func.b.b.d dVar;
        com.opos.cmn.func.b.b.d dVar2;
        if (fVar != null && gVar != null) {
            try {
                ConcurrentHashMap<String, com.opos.mobad.i.a> a2 = fVar.a();
                ConcurrentHashMap<String, com.opos.mobad.i.b> a3 = gVar.a();
                if (a2 != null && a2.size() > 0 && a3 != null && a3.size() > 0) {
                    int i2 = 0;
                    for (String str : a2.keySet()) {
                        if (!com.opos.cmn.an.c.a.a(str)) {
                            com.opos.mobad.i.a aVar = a2.get(str);
                            com.opos.mobad.i.b bVar = a3.get(str);
                            if (bVar == null || !bVar.f21012a) {
                                if (qVar != null && aVar != null && (dVar = aVar.f20981a) != null) {
                                    qVar.a(dVar.f17154b, 3);
                                }
                                com.opos.cmn.an.f.a.c("FetchMaterialTask", "downloadResponse fail=", bVar);
                            } else {
                                if (qVar != null && aVar != null && (dVar2 = aVar.f20981a) != null) {
                                    qVar.a(dVar2.f17154b, 1);
                                }
                                i2++;
                            }
                        }
                    }
                    if (a2.size() == i2) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e2);
            }
        }
        return false;
    }

    private boolean a(Set<com.opos.mobad.model.b.e> set, q qVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (com.opos.mobad.model.b.e eVar : set) {
            if (!hashSet.contains(eVar.a())) {
                hashSet.add(eVar.a());
                arrayList.add(new a.b(eVar.a(), z ? eVar.b() : ""));
            }
        }
        if (hashSet.size() > 0) {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            com.opos.mobad.d.d.a().a(arrayList, new a.InterfaceC0427a() { // from class: com.opos.mobad.model.d.j.1

                /* renamed from: a */
                final /* synthetic */ AtomicInteger f21624a;

                /* renamed from: b */
                final /* synthetic */ q f21625b;

                /* renamed from: c */
                final /* synthetic */ CountDownLatch f21626c;

                AnonymousClass1(AtomicInteger atomicInteger2, q qVar2, CountDownLatch countDownLatch2) {
                    atomicInteger = atomicInteger2;
                    qVar = qVar2;
                    countDownLatch = countDownLatch2;
                }

                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                public void a() {
                    countDownLatch.countDown();
                }

                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                public void a(String str) {
                }

                @Override // com.opos.mobad.c.a.a.InterfaceC0427a
                public void a(String str, int i2) {
                    com.opos.cmn.an.f.a.b("FetchMaterialTask", "load:" + str + "," + i2);
                    if (i2 == 1 || i2 == 0) {
                        atomicInteger.incrementAndGet();
                    }
                    j.this.a(str, i2, qVar);
                }
            });
            try {
                countDownLatch2.await(30L, TimeUnit.SECONDS);
                if (atomicInteger2.get() != hashSet.size()) {
                    return false;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("FetchMaterialTask", "fetch" + e2);
                return false;
            }
        }
        return true;
    }

    private com.opos.mobad.model.b.f b(Set<com.opos.mobad.model.b.e> set) {
        Exception e2;
        com.opos.mobad.model.b.f fVar;
        if (set == null || set.size() <= 0) {
            return null;
        }
        ConcurrentHashMap<String, com.opos.mobad.i.a> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            for (com.opos.mobad.model.b.e eVar : set) {
                if (eVar != null && !com.opos.cmn.an.c.a.a(eVar.a())) {
                    concurrentHashMap.put(com.opos.cmn.d.c.a(eVar.a()), a(eVar));
                }
            }
        } catch (Exception e3) {
            e2 = e3;
            fVar = null;
        }
        if (concurrentHashMap.size() <= 0) {
            return null;
        }
        fVar = new com.opos.mobad.model.b.f();
        try {
            fVar.a(concurrentHashMap);
        } catch (Exception e4) {
            e2 = e4;
            com.opos.cmn.an.f.a.a("FetchMaterialTask", "", (Throwable) e2);
            return fVar;
        }
        return fVar;
    }

    public boolean a(Set<com.opos.mobad.model.b.e> set) {
        return a(set, null);
    }

    @Override // com.opos.mobad.model.d.o
    public boolean a(Set<com.opos.mobad.model.b.e> set, q qVar) {
        return a(set, qVar, (CustomInfoData) null);
    }

    @Override // com.opos.mobad.model.d.o
    public boolean a(Set<com.opos.mobad.model.b.e> set, q qVar, CustomInfoData customInfoData) {
        if (set == null || set.size() <= 0) {
            return false;
        }
        if (customInfoData != null) {
            try {
                boolean z = true;
                if (customInfoData.b() == 1 || customInfoData.b() == 2) {
                    if (customInfoData.b() != 1) {
                        z = false;
                    }
                    return a(set, qVar, z);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("FetchMaterialTask", "fetchMaterial", (Throwable) e2);
                return false;
            }
        }
        com.opos.mobad.model.b.f b2 = b(set);
        if (b2 != null) {
            return a(b2, this.f21623b.a(b2), qVar);
        }
        return false;
    }
}
