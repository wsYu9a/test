package com.opos.mobad.service.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.func.b.b.d;
import com.opos.cmn.i.a;
import com.opos.mobad.b.a.i;
import com.opos.mobad.b.a.j;
import com.opos.mobad.b.a.l;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.provider.record.ControlEntity;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static c f23481a;

    /* renamed from: b */
    private Context f23482b;

    /* renamed from: c */
    private String f23483c;

    /* renamed from: d */
    private int f23484d;

    /* renamed from: e */
    private int f23485e;

    /* renamed from: f */
    private com.opos.mobad.provider.record.a f23486f;

    /* renamed from: g */
    private AtomicReference<ControlEntity> f23487g = new AtomicReference<>(null);

    /* renamed from: h */
    private com.opos.cmn.i.a f23488h = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.a.c.1
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            if (c.this.f23486f == null) {
                interfaceC0395a.b();
            } else {
                c.this.a(interfaceC0395a);
            }
        }
    }, 10000, 0);

    /* renamed from: com.opos.mobad.service.a.c$1 */
    class AnonymousClass1 implements a.b {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            if (c.this.f23486f == null) {
                interfaceC0395a.b();
            } else {
                c.this.a(interfaceC0395a);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.a.c$2 */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.f23487g.get() == null) {
                    ControlEntity d2 = c.this.f23486f.d();
                    c.this.f23487g.compareAndSet(null, d2);
                    com.opos.cmn.an.f.a.b("", "control local:" + d2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "loal fail", e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.service.a.c$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ a.InterfaceC0395a f23491a;

        AnonymousClass3(a.InterfaceC0395a interfaceC0395a) {
            interfaceC0395a = interfaceC0395a;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.b(interfaceC0395a);
        }
    }

    private c() {
    }

    public static final c a() {
        c cVar = f23481a;
        if (cVar == null) {
            synchronized (c.class) {
                if (f23481a == null) {
                    f23481a = new c();
                }
                cVar = f23481a;
            }
        }
        return cVar;
    }

    public void a(a.InterfaceC0395a interfaceC0395a) {
        if (this.f23487g.get() == null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.c.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.f23487g.get() == null) {
                            ControlEntity d2 = c.this.f23486f.d();
                            c.this.f23487g.compareAndSet(null, d2);
                            com.opos.cmn.an.f.a.b("", "control local:" + d2);
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("", "loal fail", e2);
                    }
                }
            });
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.a.c.3

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23491a;

            AnonymousClass3(a.InterfaceC0395a interfaceC0395a2) {
                interfaceC0395a = interfaceC0395a2;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.b(interfaceC0395a);
            }
        });
    }

    public void b(a.InterfaceC0395a interfaceC0395a) {
        try {
            m b2 = new m.a().a(new l.a().b(com.opos.mobad.service.e.a.a().e()).a(com.opos.mobad.service.e.a.a().k()).c(com.opos.cmn.f.a.a(this.f23482b)).g(com.opos.mobad.service.e.a.a().f()).h(com.opos.mobad.service.e.a.a().g()).i(com.opos.mobad.service.e.a.a().h()).b()).a(new n.a().c(com.opos.cmn.an.b.c.c()).a(com.opos.cmn.an.b.d.b()).b(com.opos.cmn.an.b.d.a()).b()).c(com.opos.cmn.an.b.a.a(this.f23482b)).a(com.opos.cmn.an.b.c.a()).b();
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-protobuf");
            hashMap.put("Route-Data", com.opos.cmn.biz.a.e.a(this.f23482b));
            d.a b3 = new d.a().a(i.f19721c.b((com.heytap.nearx.a.a.e<i>) new i.a().a(this.f23483c).a(b2).b(this.f23482b.getPackageName()).b(Integer.valueOf(this.f23484d)).a(Integer.valueOf(this.f23485e)).a(Boolean.valueOf(com.opos.mobad.service.e.a.a().j())).b(Boolean.valueOf(com.opos.mobad.service.e.a.a().d())).b())).a(hashMap).b(h());
            b3.a("POST");
            com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(this.f23482b, b3.a());
            if (a2 == null || 200 != a2.f17168a) {
                interfaceC0395a.b();
                return;
            }
            j a3 = j.f19736c.a(a2.f17170c);
            com.opos.cmn.an.f.a.b("", "control succ:", a3);
            Boolean bool = a3.n;
            if (bool == null) {
                bool = j.f19738e;
            }
            boolean booleanValue = bool.booleanValue();
            Boolean bool2 = a3.o;
            if (bool2 == null) {
                bool2 = j.f19739f;
            }
            boolean booleanValue2 = bool2.booleanValue();
            Boolean bool3 = a3.p;
            if (bool3 == null) {
                bool3 = j.f19740g;
            }
            boolean booleanValue3 = bool3.booleanValue();
            Boolean bool4 = a3.q;
            if (bool4 == null) {
                bool4 = j.f19741h;
            }
            boolean booleanValue4 = bool4.booleanValue();
            Boolean bool5 = a3.r;
            if (bool5 == null) {
                bool5 = j.f19742i;
            }
            boolean booleanValue5 = bool5.booleanValue();
            Boolean bool6 = a3.s;
            if (bool6 == null) {
                bool6 = j.f19743j;
            }
            boolean booleanValue6 = bool6.booleanValue();
            Boolean bool7 = a3.t;
            if (bool7 == null) {
                bool7 = j.k;
            }
            ControlEntity controlEntity = new ControlEntity(booleanValue, booleanValue2, booleanValue3, booleanValue4, booleanValue5, booleanValue6, System.currentTimeMillis(), bool7.booleanValue());
            this.f23487g.set(controlEntity);
            try {
                this.f23486f.a(controlEntity);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("", "set local fail", e2);
            }
            interfaceC0395a.a();
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("", "refresh fail", th);
            interfaceC0395a.b();
        }
    }

    private String h() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/ability/select";
    }

    public void a(Context context, String str, int i2, int i3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f23482b = context;
        this.f23483c = str;
        this.f23486f = new com.opos.mobad.provider.record.a(context);
        this.f23484d = i2;
        this.f23485e = i3;
        this.f23488h.a();
    }

    public boolean b() {
        ControlEntity controlEntity = this.f23487g.get();
        if (controlEntity != null) {
            return controlEntity.f23141a;
        }
        this.f23488h.a();
        return j.f19738e.booleanValue();
    }

    public boolean c() {
        ControlEntity controlEntity = this.f23487g.get();
        if (controlEntity != null) {
            return controlEntity.f23142b;
        }
        this.f23488h.a();
        return j.f19739f.booleanValue();
    }

    public boolean d() {
        ControlEntity controlEntity = this.f23487g.get();
        if (controlEntity != null) {
            return controlEntity.f23143c;
        }
        this.f23488h.a();
        return j.f19740g.booleanValue();
    }

    public boolean e() {
        ControlEntity controlEntity = this.f23487g.get();
        if (controlEntity != null) {
            return controlEntity.f23145e;
        }
        this.f23488h.a();
        return j.f19741h.booleanValue();
    }

    public boolean f() {
        ControlEntity controlEntity = this.f23487g.get();
        if (controlEntity != null) {
            return controlEntity.f23146f;
        }
        this.f23488h.a();
        return j.f19742i.booleanValue();
    }

    public boolean g() {
        ControlEntity controlEntity = this.f23487g.get();
        if (controlEntity != null) {
            return controlEntity.f23148h;
        }
        this.f23488h.a();
        return j.k.booleanValue();
    }
}
