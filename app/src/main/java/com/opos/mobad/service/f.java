package com.opos.mobad.service;

import android.content.Context;
import android.util.Log;
import com.opos.acs.st.STManager;
import com.opos.mobad.service.f.a;
import com.opos.mobad.service.j.n;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static volatile f f23609a = new f();

    /* renamed from: b */
    private boolean f23610b = false;

    /* renamed from: c */
    private com.opos.mobad.service.a.e f23611c = new com.opos.mobad.service.a.e();

    /* renamed from: d */
    private com.opos.mobad.service.d.a f23612d = new com.opos.mobad.service.d.a();

    /* renamed from: e */
    private com.opos.mobad.service.a.b f23613e = new com.opos.mobad.service.a.b();

    /* renamed from: g */
    private com.opos.mobad.service.b.a f23615g = new com.opos.mobad.service.b.a();

    /* renamed from: f */
    private g f23614f = new g("");

    /* renamed from: h */
    private com.opos.mobad.service.tasks.c f23616h = new com.opos.mobad.service.tasks.c();

    /* renamed from: com.opos.mobad.service.f$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f23617a;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.func.b.b.b.a().a(context);
        }
    }

    /* renamed from: com.opos.mobad.service.f$2 */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f23618a;

        /* renamed from: b */
        final /* synthetic */ boolean f23619b;

        /* renamed from: c */
        final /* synthetic */ boolean f23620c;

        AnonymousClass2(Context context, boolean z, boolean z2) {
            context = context;
            z = z;
            z2 = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new com.opos.mobad.provider.init.a(context).a(z, z2);
            } catch (com.opos.process.bridge.provider.b | com.opos.process.bridge.provider.c e2) {
                com.opos.cmn.an.f.a.d("ServiceManager", "", e2);
            }
        }
    }

    private f() {
    }

    public static final com.opos.mobad.service.a.b a() {
        return f23609a.f23613e;
    }

    private static void a(Context context) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.1

            /* renamed from: a */
            final /* synthetic */ Context f23617a;

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.func.b.b.b.a().a(context);
            }
        });
    }

    private void a(Context context, String str, String str2, int i2, int i3, long j2) {
        com.opos.mobad.service.c.b.a().a(context);
        this.f23611c.a(context, str, str2, i3, i2, j2);
        this.f23612d.a(context, str, str2, i3, i2);
        com.opos.mobad.service.a.c.a().a(context, str, i2, i3);
    }

    private static void a(Context context, boolean z, boolean z2) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.f.2

            /* renamed from: a */
            final /* synthetic */ Context f23618a;

            /* renamed from: b */
            final /* synthetic */ boolean f23619b;

            /* renamed from: c */
            final /* synthetic */ boolean f23620c;

            AnonymousClass2(Context context2, boolean z3, boolean z22) {
                context = context2;
                z = z3;
                z2 = z22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.opos.mobad.provider.init.a(context).a(z, z2);
                } catch (com.opos.process.bridge.provider.b | com.opos.process.bridge.provider.c e2) {
                    com.opos.cmn.an.f.a.d("ServiceManager", "", e2);
                }
            }
        });
    }

    public static final void a(Context context, boolean z, boolean z2, boolean z3, int i2, a.c cVar, a.g gVar, a.InterfaceC0485a interfaceC0485a, a.f fVar, a.b bVar) {
        f23609a.b(context, z, z2, z3, i2, cVar, gVar, interfaceC0485a, fVar, bVar);
    }

    public static final com.opos.mobad.service.a.e b() {
        return f23609a.f23611c;
    }

    private void b(Context context, boolean z, boolean z2, boolean z3, int i2, a.c cVar, a.g gVar, a.InterfaceC0485a interfaceC0485a, a.f fVar, a.b bVar) {
        synchronized (this) {
            if (!this.f23610b) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    com.opos.cmn.c.a.a(applicationContext, z, z3);
                    a(applicationContext, z, z3);
                    this.f23615g.a();
                    com.opos.cmn.a.a.a(z, STManager.REGION_OF_CN);
                    a(applicationContext);
                    com.opos.mobad.service.e.a.a().a(applicationContext, z3);
                    com.opos.mobad.service.e.a.a().a(z2);
                    a(applicationContext, interfaceC0485a.a(), interfaceC0485a.b(), fVar.a(), 0, 0L);
                    com.opos.mobad.service.i.d.a().a(applicationContext, interfaceC0485a.a(), fVar.a(), fVar.c());
                    if (!com.opos.cmn.an.f.a.b(applicationContext)) {
                        com.opos.cmn.an.e.c.a().a(applicationContext);
                    }
                    com.opos.mobad.service.f.a.a().a(applicationContext, cVar, gVar, interfaceC0485a, fVar, null, bVar);
                    com.opos.cmn.c.a.b();
                    n.a().a(applicationContext.getApplicationContext());
                    this.f23610b = true;
                    d.a().a(applicationContext.getApplicationContext());
                    this.f23616h.a(applicationContext.getApplicationContext(), z3, i2);
                    com.opos.mobad.service.event.b.a().a(applicationContext.getApplicationContext());
                    com.opos.mobad.d.d.a().a(applicationContext);
                } catch (Exception e2) {
                    Log.w("ServiceManager", "", e2);
                }
            }
        }
    }

    public static final com.opos.mobad.service.d.a c() {
        return f23609a.f23612d;
    }

    public static final boolean d() {
        return f23609a.f23610b;
    }

    public static final void e() {
        synchronized (f.class) {
            f fVar = f23609a;
            f23609a = new f();
            fVar.f();
        }
    }

    private void f() {
        com.opos.cmn.an.e.c.a().b();
        com.opos.mobad.service.f.a.a().y();
        a.a().b();
        this.f23616h.a();
        com.opos.cmn.c.a.a();
    }
}
