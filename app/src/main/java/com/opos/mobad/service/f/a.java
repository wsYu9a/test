package com.opos.mobad.service.f;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cdo.oaps.ad.af;
import com.opos.cmn.i.a;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public static final String f23621a = com.opos.cmn.an.a.b.a(com.cdo.oaps.ad.a.f6500b);

    /* renamed from: b */
    private static a f23622b;

    /* renamed from: c */
    private Context f23623c;

    /* renamed from: d */
    private c f23624d;

    /* renamed from: e */
    private g f23625e;

    /* renamed from: f */
    private InterfaceC0485a f23626f;

    /* renamed from: g */
    private f f23627g;

    /* renamed from: h */
    private e f23628h;

    /* renamed from: i */
    private String f23629i;

    /* renamed from: j */
    private String f23630j;
    private String k;
    private com.opos.cmn.i.a l;
    private com.opos.cmn.i.a m;
    private com.opos.cmn.i.a n;
    private com.opos.cmn.i.a o;
    private String p;
    private String q;
    private volatile d r;
    private b s;
    private volatile String t = "";
    private volatile String u = "";

    /* renamed from: com.opos.mobad.service.f.a$1 */
    class AnonymousClass1 implements a.b {

        /* renamed from: com.opos.mobad.service.f.a$1$1 */
        class RunnableC04841 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23632a;

            RunnableC04841(a.InterfaceC0395a interfaceC0395a) {
                interfaceC0395a = interfaceC0395a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f23624d.d();
                    a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                    if (interfaceC0395a != null) {
                        interfaceC0395a.a();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                    a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                    if (interfaceC0395a2 != null) {
                        interfaceC0395a2.b();
                    }
                }
            }
        }

        AnonymousClass1() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            com.opos.cmn.an.f.a.b("infoManager", "init instant");
            if (a.this.f23624d == null) {
                interfaceC0395a.b();
            } else {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.1.1

                    /* renamed from: a */
                    final /* synthetic */ a.InterfaceC0395a f23632a;

                    RunnableC04841(a.InterfaceC0395a interfaceC0395a2) {
                        interfaceC0395a = interfaceC0395a2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.f23624d.d();
                            a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                            if (interfaceC0395a2 != null) {
                                interfaceC0395a2.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                            if (interfaceC0395a22 != null) {
                                interfaceC0395a22.b();
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.service.f.a$2 */
    class AnonymousClass2 implements a.b {

        /* renamed from: com.opos.mobad.service.f.a$2$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23635a;

            AnonymousClass1(a.InterfaceC0395a interfaceC0395a) {
                interfaceC0395a = interfaceC0395a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f23625e.d();
                    a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                    if (interfaceC0395a != null) {
                        interfaceC0395a.a();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                    a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                    if (interfaceC0395a2 != null) {
                        interfaceC0395a2.b();
                    }
                }
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            com.opos.cmn.an.f.a.b("infoManager", "init xgame");
            if (a.this.f23625e == null) {
                interfaceC0395a.b();
            } else {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.2.1

                    /* renamed from: a */
                    final /* synthetic */ a.InterfaceC0395a f23635a;

                    AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                        interfaceC0395a = interfaceC0395a2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.f23625e.d();
                            a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                            if (interfaceC0395a2 != null) {
                                interfaceC0395a2.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                            if (interfaceC0395a22 != null) {
                                interfaceC0395a22.b();
                            }
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.opos.mobad.service.f.a$3 */
    class AnonymousClass3 implements a.b {

        /* renamed from: com.opos.mobad.service.f.a$3$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23638a;

            AnonymousClass1(a.InterfaceC0395a interfaceC0395a) {
                interfaceC0395a = interfaceC0395a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.A();
                    a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                    if (interfaceC0395a != null) {
                        interfaceC0395a.a();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                    a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                    if (interfaceC0395a2 != null) {
                        interfaceC0395a2.b();
                    }
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            com.opos.cmn.an.f.a.b("infoManager", "init market");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.3.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23638a;

                AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.A();
                        a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                        if (interfaceC0395a2 != null) {
                            interfaceC0395a2.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                        a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                        if (interfaceC0395a22 != null) {
                            interfaceC0395a22.b();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.service.f.a$4 */
    class AnonymousClass4 implements a.b {

        /* renamed from: com.opos.mobad.service.f.a$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ a.InterfaceC0395a f23641a;

            AnonymousClass1(a.InterfaceC0395a interfaceC0395a) {
                interfaceC0395a = interfaceC0395a;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a aVar = a.this;
                    aVar.p = com.opos.cmn.an.h.e.a.e(aVar.f23623c);
                    a.InterfaceC0395a interfaceC0395a = interfaceC0395a;
                    if (interfaceC0395a != null) {
                        interfaceC0395a.a();
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                    a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                    if (interfaceC0395a2 != null) {
                        interfaceC0395a2.b();
                    }
                }
            }
        }

        AnonymousClass4() {
        }

        @Override // com.opos.cmn.i.a.b
        public void a(a.InterfaceC0395a interfaceC0395a) {
            com.opos.cmn.an.f.a.b("infoManager", "init operator");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.4.1

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23641a;

                AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar = a.this;
                        aVar.p = com.opos.cmn.an.h.e.a.e(aVar.f23623c);
                        a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                        if (interfaceC0395a2 != null) {
                            interfaceC0395a2.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                        a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                        if (interfaceC0395a22 != null) {
                            interfaceC0395a22.b();
                        }
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.service.f.a$a */
    public interface InterfaceC0485a {
        String a();

        String b();

        String c();
    }

    public interface b {
        String a();
    }

    public interface c {
        String a();

        String b();

        boolean c();

        void d();
    }

    public static class d {

        /* renamed from: a */
        public final int f23643a;

        /* renamed from: b */
        public final String f23644b;

        public d(int i2, String str) {
            this.f23643a = i2;
            this.f23644b = str;
        }
    }

    public interface e {
        String a();

        long b();
    }

    public interface f {
        int a();

        String b();

        int c();
    }

    public interface g {
        String a();

        String b();

        boolean c();

        void d();
    }

    private a() {
    }

    public d A() {
        this.r = new d(b(this.f23623c), a(this.f23623c));
        return this.r;
    }

    public static final a a() {
        a aVar = f23622b;
        if (aVar == null) {
            synchronized (a.class) {
                if (f23622b == null) {
                    f23622b = new a();
                }
                aVar = f23622b;
            }
        }
        return aVar;
    }

    private String a(Context context) {
        String str = af.f6508e;
        if (!com.opos.cmn.an.h.d.a.d(context, af.f6508e)) {
            str = f23621a;
        }
        return com.opos.cmn.an.h.d.a.c(context, str);
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && "CHILD".equals(str);
    }

    private int b(Context context) {
        String str = af.f6508e;
        if (!com.opos.cmn.an.h.d.a.d(context, af.f6508e)) {
            str = f23621a;
        }
        return com.opos.cmn.an.h.d.a.b(context, str);
    }

    private void z() {
        this.n = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.1

            /* renamed from: com.opos.mobad.service.f.a$1$1 */
            class RunnableC04841 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23632a;

                RunnableC04841(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f23624d.d();
                        a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                        if (interfaceC0395a2 != null) {
                            interfaceC0395a2.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                        a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                        if (interfaceC0395a22 != null) {
                            interfaceC0395a22.b();
                        }
                    }
                }
            }

            AnonymousClass1() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a2) {
                com.opos.cmn.an.f.a.b("infoManager", "init instant");
                if (a.this.f23624d == null) {
                    interfaceC0395a2.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.1.1

                        /* renamed from: a */
                        final /* synthetic */ a.InterfaceC0395a f23632a;

                        RunnableC04841(a.InterfaceC0395a interfaceC0395a22) {
                            interfaceC0395a = interfaceC0395a22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.f23624d.d();
                                a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                                if (interfaceC0395a22 != null) {
                                    interfaceC0395a22.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                a.InterfaceC0395a interfaceC0395a222 = interfaceC0395a;
                                if (interfaceC0395a222 != null) {
                                    interfaceC0395a222.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, 120000);
        this.o = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.2

            /* renamed from: com.opos.mobad.service.f.a$2$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23635a;

                AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f23625e.d();
                        a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                        if (interfaceC0395a2 != null) {
                            interfaceC0395a2.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                        a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                        if (interfaceC0395a22 != null) {
                            interfaceC0395a22.b();
                        }
                    }
                }
            }

            AnonymousClass2() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a2) {
                com.opos.cmn.an.f.a.b("infoManager", "init xgame");
                if (a.this.f23625e == null) {
                    interfaceC0395a2.b();
                } else {
                    com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.2.1

                        /* renamed from: a */
                        final /* synthetic */ a.InterfaceC0395a f23635a;

                        AnonymousClass1(a.InterfaceC0395a interfaceC0395a22) {
                            interfaceC0395a = interfaceC0395a22;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a.this.f23625e.d();
                                a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                                if (interfaceC0395a22 != null) {
                                    interfaceC0395a22.a();
                                }
                            } catch (Exception e2) {
                                com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                                a.InterfaceC0395a interfaceC0395a222 = interfaceC0395a;
                                if (interfaceC0395a222 != null) {
                                    interfaceC0395a222.b();
                                }
                            }
                        }
                    });
                }
            }
        }, Integer.MAX_VALUE, 120000);
        this.l = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.3

            /* renamed from: com.opos.mobad.service.f.a$3$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23638a;

                AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.A();
                        a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                        if (interfaceC0395a2 != null) {
                            interfaceC0395a2.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                        a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                        if (interfaceC0395a22 != null) {
                            interfaceC0395a22.b();
                        }
                    }
                }
            }

            AnonymousClass3() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a2) {
                com.opos.cmn.an.f.a.b("infoManager", "init market");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.3.1

                    /* renamed from: a */
                    final /* synthetic */ a.InterfaceC0395a f23638a;

                    AnonymousClass1(a.InterfaceC0395a interfaceC0395a22) {
                        interfaceC0395a = interfaceC0395a22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a.this.A();
                            a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                            if (interfaceC0395a22 != null) {
                                interfaceC0395a22.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0395a interfaceC0395a222 = interfaceC0395a;
                            if (interfaceC0395a222 != null) {
                                interfaceC0395a222.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 120000);
        this.m = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.service.f.a.4

            /* renamed from: com.opos.mobad.service.f.a$4$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ a.InterfaceC0395a f23641a;

                AnonymousClass1(a.InterfaceC0395a interfaceC0395a2) {
                    interfaceC0395a = interfaceC0395a2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar = a.this;
                        aVar.p = com.opos.cmn.an.h.e.a.e(aVar.f23623c);
                        a.InterfaceC0395a interfaceC0395a2 = interfaceC0395a;
                        if (interfaceC0395a2 != null) {
                            interfaceC0395a2.a();
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                        a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                        if (interfaceC0395a22 != null) {
                            interfaceC0395a22.b();
                        }
                    }
                }
            }

            AnonymousClass4() {
            }

            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0395a interfaceC0395a2) {
                com.opos.cmn.an.f.a.b("infoManager", "init operator");
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.a.4.1

                    /* renamed from: a */
                    final /* synthetic */ a.InterfaceC0395a f23641a;

                    AnonymousClass1(a.InterfaceC0395a interfaceC0395a22) {
                        interfaceC0395a = interfaceC0395a22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar = a.this;
                            aVar.p = com.opos.cmn.an.h.e.a.e(aVar.f23623c);
                            a.InterfaceC0395a interfaceC0395a22 = interfaceC0395a;
                            if (interfaceC0395a22 != null) {
                                interfaceC0395a22.a();
                            }
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("infoManager", "init error" + e2);
                            a.InterfaceC0395a interfaceC0395a222 = interfaceC0395a;
                            if (interfaceC0395a222 != null) {
                                interfaceC0395a222.b();
                            }
                        }
                    }
                });
            }
        }, Integer.MAX_VALUE, 180000);
    }

    public void a(Context context, c cVar, g gVar, InterfaceC0485a interfaceC0485a, f fVar, e eVar, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f23623c = applicationContext;
        this.q = applicationContext.getPackageName();
        this.f23624d = cVar;
        this.f23625e = gVar;
        this.f23626f = interfaceC0485a;
        this.f23627g = fVar;
        this.f23628h = eVar;
        this.s = bVar;
        z();
    }

    public String b() {
        c cVar = this.f23624d;
        if (cVar == null) {
            return "";
        }
        this.n.a();
        return cVar.b();
    }

    public boolean c() {
        c cVar = this.f23624d;
        if (cVar == null) {
            return false;
        }
        this.n.a();
        return cVar.c();
    }

    public String d() {
        c cVar = this.f23624d;
        if (cVar == null) {
            return "";
        }
        this.n.a();
        return cVar.a();
    }

    public boolean e() {
        g gVar = this.f23625e;
        if (gVar == null) {
            return false;
        }
        this.o.a();
        return gVar.c();
    }

    public String f() {
        g gVar = this.f23625e;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.a();
    }

    public String g() {
        g gVar = this.f23625e;
        if (gVar == null) {
            return "";
        }
        this.o.a();
        return gVar.b();
    }

    public String h() {
        if (TextUtils.isEmpty(this.f23629i)) {
            this.f23629i = com.opos.cmn.an.b.d.b();
        }
        return this.f23629i;
    }

    public String i() {
        if (TextUtils.isEmpty(this.f23630j)) {
            this.f23630j = com.opos.cmn.an.b.d.a();
        }
        return this.f23630j;
    }

    public String j() {
        if (TextUtils.isEmpty(this.k)) {
            this.k = com.opos.cmn.an.b.c.c();
        }
        return this.k;
    }

    public String k() {
        InterfaceC0485a interfaceC0485a = this.f23626f;
        return interfaceC0485a == null ? "" : interfaceC0485a.b();
    }

    public String l() {
        InterfaceC0485a interfaceC0485a = this.f23626f;
        return interfaceC0485a == null ? "" : interfaceC0485a.a();
    }

    public String m() {
        InterfaceC0485a interfaceC0485a = this.f23626f;
        return interfaceC0485a == null ? "" : interfaceC0485a.c();
    }

    public d n() {
        d dVar = this.r;
        if (dVar != null) {
            this.l.a();
            return dVar;
        }
        d A = A();
        this.r = A;
        return A;
    }

    public int o() {
        return this.f23627g.a();
    }

    public String p() {
        return this.f23627g.b();
    }

    public int q() {
        return this.f23627g.c();
    }

    public String r() {
        e eVar = this.f23628h;
        return eVar == null ? "" : eVar.a();
    }

    public long s() {
        e eVar = this.f23628h;
        if (eVar == null) {
            return 0L;
        }
        return eVar.b();
    }

    public String t() {
        if (!TextUtils.isEmpty(this.p)) {
            this.m.a();
            return this.p;
        }
        String e2 = com.opos.cmn.an.h.e.a.e(this.f23623c);
        this.p = e2;
        return e2;
    }

    public String u() {
        return this.q;
    }

    public String v() {
        if (this.s == null) {
            return "";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.u = this.s.a();
        if (TextUtils.isEmpty(this.u) || (!"ADULT".equals(this.u) && !"CHILD".equals(this.u) && !"TEEN".equals(this.u))) {
            this.u = "UNKNOWN";
        }
        com.opos.cmn.an.f.a.b("infoManager", "age provider =" + this.u + ", time = " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        return this.u;
    }

    public String w() {
        if (this.s == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.u)) {
            v();
        }
        return this.u;
    }

    public String x() {
        return this.t;
    }

    public void y() {
        this.f23626f = null;
        this.f23628h = null;
        this.s = null;
        this.f23624d = null;
        this.f23625e = null;
        this.t = "";
    }
}
