package com.opos.mobad.h;

import android.content.Context;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.p;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.l.g;
import com.opos.mobad.model.b;
import com.opos.mobad.model.data.AdData;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.e.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class e extends g {

    /* renamed from: b */
    private int f20969b;

    /* renamed from: c */
    private s f20970c;

    /* renamed from: d */
    private Context f20971d;

    /* renamed from: e */
    private String f20972e;

    /* renamed from: f */
    private com.opos.mobad.cmn.a.a f20973f;

    /* renamed from: g */
    private com.opos.mobad.cmn.b.c f20974g;

    /* renamed from: h */
    private o f20975h;

    /* renamed from: com.opos.mobad.h.e$1 */
    class AnonymousClass1 implements b.a {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, a.C0457a c0457a) {
            String b2;
            String str;
            String c2;
            String a2;
            Map map;
            String str2;
            if (c0457a != null && c0457a.f21743a.a() == 1) {
                com.opos.mobad.service.a.a().a(e.this.f20972e, 4, c0457a.f21744b.f(), c0457a.f21744b.b(), c0457a.f21745c.aa(), c0457a.f21744b.a(), c0457a.f21744b.J());
                e.this.f20969b = c0457a.f21743a.c();
                e.this.a(-1, com.opos.mobad.ad.a.a(-1));
                return;
            }
            e.this.f20969b = i2;
            List a3 = e.this.a(c0457a);
            if (a3 != null) {
                e.this.a(a3);
                return;
            }
            Context context = e.this.f20971d;
            if (c0457a == null) {
                str = e.this.f20972e;
                map = null;
                b2 = "";
                str2 = "4";
                c2 = "";
                a2 = "";
            } else {
                b2 = c0457a.f21744b.b();
                str = e.this.f20972e;
                c2 = c0457a.f21744b.c();
                a2 = c0457a.f21744b.a();
                map = null;
                str2 = "4";
            }
            com.opos.mobad.cmn.a.b.d.a(context, b2, str, str2, c2, a2, (Map<String, String>) map);
            e.this.a(10301, "render ad failed,ad item data is null.");
        }

        @Override // com.opos.mobad.model.b.a
        public void a(int i2, String str, AdData adData) {
            if (adData != null) {
                e.this.f20969b = adData.c();
            }
            e.this.a(i2, str);
        }
    }

    /* renamed from: com.opos.mobad.h.e$2 */
    class AnonymousClass2 implements o {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(int i2, String str) {
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(p pVar) {
            e.this.a(pVar);
        }

        @Override // com.opos.mobad.ad.c.o
        public void a(q qVar, p pVar) {
            e.this.a(qVar, pVar);
        }

        @Override // com.opos.mobad.ad.c.a
        public void a(List<p> list) {
        }

        @Override // com.opos.mobad.ad.c.o
        public void b(p pVar) {
            e.this.b(pVar);
        }

        @Override // com.opos.mobad.ad.c.o
        public void c(p pVar) {
            e.this.c(pVar);
        }

        @Override // com.opos.mobad.ad.c.o
        public void d(p pVar) {
            e.this.d(pVar);
        }
    }

    public e(Context context, String str, s sVar, com.opos.mobad.cmn.a.d dVar, o oVar, com.opos.mobad.cmn.b.c cVar) {
        super(oVar);
        this.f20969b = 0;
        this.f20975h = new o() { // from class: com.opos.mobad.h.e.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.ad.c.a
            public void a(int i2, String str2) {
            }

            @Override // com.opos.mobad.ad.c.o
            public void a(p pVar) {
                e.this.a(pVar);
            }

            @Override // com.opos.mobad.ad.c.o
            public void a(q qVar, p pVar) {
                e.this.a(qVar, pVar);
            }

            @Override // com.opos.mobad.ad.c.a
            public void a(List<p> list) {
            }

            @Override // com.opos.mobad.ad.c.o
            public void b(p pVar) {
                e.this.b(pVar);
            }

            @Override // com.opos.mobad.ad.c.o
            public void c(p pVar) {
                e.this.c(pVar);
            }

            @Override // com.opos.mobad.ad.c.o
            public void d(p pVar) {
                e.this.d(pVar);
            }
        };
        this.f20971d = context;
        this.f20970c = sVar;
        this.f20972e = str;
        this.f20973f = new com.opos.mobad.cmn.a.a(context, str, dVar);
        this.f20974g = cVar;
    }

    public List<p> a(a.C0457a c0457a) {
        p b2;
        ArrayList arrayList = null;
        if (c0457a != null) {
            try {
                List<AdItemData> f2 = c0457a.f21743a.f();
                if (f2 != null && f2.size() > 0) {
                    Iterator<AdItemData> it = f2.iterator();
                    while (it.hasNext()) {
                        if (it.next() != null && (b2 = b(c0457a)) != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(b2);
                        }
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterNativeTempletAd", "", (Throwable) e2);
            }
        }
        return arrayList;
    }

    private p b(a.C0457a c0457a) {
        try {
            com.opos.mobad.n.a a2 = com.opos.mobad.h.d.e.a(this.f20971d, c0457a, null);
            if (a2 == null) {
                return null;
            }
            return new com.opos.mobad.h.b.e(this.f20971d, c0457a, this.f20972e, this.f20973f, a2, this.f20975h, this.f20974g);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterNativeTempletAd", "", (Throwable) e2);
            return null;
        }
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str) {
        return false;
    }

    @Override // com.opos.mobad.l.f
    protected boolean b(String str, int i2) {
        this.f20969b = 0;
        com.opos.mobad.model.b.a(this.f20971d.getApplicationContext()).a(this.f20971d, this.f20972e, 4, str, i2, new b.a() { // from class: com.opos.mobad.h.e.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, a.C0457a c0457a) {
                String b2;
                String str2;
                String c2;
                String a2;
                Map map;
                String str22;
                if (c0457a != null && c0457a.f21743a.a() == 1) {
                    com.opos.mobad.service.a.a().a(e.this.f20972e, 4, c0457a.f21744b.f(), c0457a.f21744b.b(), c0457a.f21745c.aa(), c0457a.f21744b.a(), c0457a.f21744b.J());
                    e.this.f20969b = c0457a.f21743a.c();
                    e.this.a(-1, com.opos.mobad.ad.a.a(-1));
                    return;
                }
                e.this.f20969b = i22;
                List a3 = e.this.a(c0457a);
                if (a3 != null) {
                    e.this.a(a3);
                    return;
                }
                Context context = e.this.f20971d;
                if (c0457a == null) {
                    str2 = e.this.f20972e;
                    map = null;
                    b2 = "";
                    str22 = "4";
                    c2 = "";
                    a2 = "";
                } else {
                    b2 = c0457a.f21744b.b();
                    str2 = e.this.f20972e;
                    c2 = c0457a.f21744b.c();
                    a2 = c0457a.f21744b.a();
                    map = null;
                    str22 = "4";
                }
                com.opos.mobad.cmn.a.b.d.a(context, b2, str2, str22, c2, a2, (Map<String, String>) map);
                e.this.a(10301, "render ad failed,ad item data is null.");
            }

            @Override // com.opos.mobad.model.b.a
            public void a(int i22, String str2, AdData adData) {
                if (adData != null) {
                    e.this.f20969b = adData.c();
                }
                e.this.a(i22, str2);
            }
        }, com.opos.mobad.model.b.f21485c);
        return true;
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f20969b;
    }
}
