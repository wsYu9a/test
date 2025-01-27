package com.opos.mobad.service;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.m.a.g;
import com.opos.mobad.m.a.h;
import com.opos.mobad.m.a.i;
import com.opos.mobad.m.a.v;
import com.opos.mobad.m.a.w;
import com.opos.mobad.service.h.b;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: f */
    private static volatile a f23467f;

    /* renamed from: a */
    private InterfaceC0478a f23468a;

    /* renamed from: b */
    private String f23469b;

    /* renamed from: c */
    private int f23470c = 0;

    /* renamed from: d */
    private AtomicInteger f23471d = new AtomicInteger(0);

    /* renamed from: e */
    private AtomicInteger f23472e = new AtomicInteger(0);

    /* renamed from: g */
    private AtomicInteger f23473g = new AtomicInteger(0);

    /* renamed from: com.opos.mobad.service.a$1 */
    class AnonymousClass1 implements Callable<Integer> {

        /* renamed from: a */
        final /* synthetic */ Context f23474a;

        /* renamed from: b */
        final /* synthetic */ String f23475b;

        /* renamed from: c */
        final /* synthetic */ boolean f23476c;

        AnonymousClass1(Context context, String str, boolean z) {
            context = context;
            str = str;
            z = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Integer call() throws Exception {
            T t;
            b.C0487b c2 = a.this.c(context, str);
            return Integer.valueOf((c2 == null || c2.f23682a != 200 || (t = c2.f23684c) == 0) ? z ? a.this.g() : a.this.f() : ((v) t).f21454i.booleanValue() ? 1 : ((v) c2.f23684c).f21453h == w.VIP ? 2 : 0);
        }
    }

    /* renamed from: com.opos.mobad.service.a$2 */
    class AnonymousClass2 implements b.a<v> {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.service.h.b.a
        /* renamed from: a */
        public v b(BufferedSource bufferedSource) throws IOException {
            if (bufferedSource == null) {
                return null;
            }
            return v.f21448c.a(bufferedSource);
        }
    }

    /* renamed from: com.opos.mobad.service.a$a */
    public interface InterfaceC0478a {
        void a(int i2);

        void a(String str);
    }

    private a() {
    }

    private static final com.opos.mobad.m.a.h a(Context context) {
        com.opos.mobad.m.a.g b2 = new g.a().b(com.opos.mobad.service.e.a.a().e()).a(com.opos.mobad.service.e.a.a().k()).c(com.opos.cmn.f.a.a(context)).d(com.opos.mobad.service.e.a.a().f()).e(com.opos.mobad.service.e.a.a().g()).f(com.opos.mobad.service.e.a.a().h()).a(Boolean.valueOf(com.opos.mobad.service.e.a.a().j())).b(Boolean.valueOf(com.opos.mobad.service.e.a.a().d())).g(com.opos.mobad.service.e.a.a().l()).b();
        return new h.a().a(b2).a(new i.a().c(com.opos.cmn.an.b.c.c()).a(com.opos.cmn.an.b.d.b()).b(com.opos.cmn.an.b.d.a()).b()).b(com.opos.cmn.an.b.a.a(context)).a(com.opos.cmn.an.b.c.a()).b();
    }

    public static final a a() {
        a aVar = f23467f;
        if (aVar == null) {
            synchronized (a.class) {
                aVar = f23467f;
                if (aVar == null) {
                    aVar = new a();
                    f23467f = aVar;
                }
            }
        }
        return aVar;
    }

    private FutureTask<Integer> a(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(this.f23469b) || this.f23470c == 0) {
            return null;
        }
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() { // from class: com.opos.mobad.service.a.1

            /* renamed from: a */
            final /* synthetic */ Context f23474a;

            /* renamed from: b */
            final /* synthetic */ String f23475b;

            /* renamed from: c */
            final /* synthetic */ boolean f23476c;

            AnonymousClass1(Context context2, String str2, boolean z2) {
                context = context2;
                str = str2;
                z = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Integer call() throws Exception {
                T t;
                b.C0487b c2 = a.this.c(context, str);
                return Integer.valueOf((c2 == null || c2.f23682a != 200 || (t = c2.f23684c) == 0) ? z ? a.this.g() : a.this.f() : ((v) t).f21454i.booleanValue() ? 1 : ((v) c2.f23684c).f21453h == w.VIP ? 2 : 0);
            }
        });
        com.opos.cmn.an.j.b.c(futureTask);
        return futureTask;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.mobad.service.h.b.C0487b<com.opos.mobad.m.a.v> c(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            com.opos.mobad.m.a.t$a r0 = new com.opos.mobad.m.a.t$a
            r0.<init>()
            java.lang.String r1 = r3.f23469b
            com.opos.mobad.m.a.t$a r0 = r0.a(r1)
            int r1 = r3.f23470c
            r2 = -1
            if (r1 == r2) goto L1c
            if (r1 == 0) goto L19
            r2 = 1
            if (r1 == r2) goto L16
            goto L1c
        L16:
            com.opos.mobad.m.a.w r1 = com.opos.mobad.m.a.w.VIP
            goto L1e
        L19:
            com.opos.mobad.m.a.w r1 = com.opos.mobad.m.a.w.NORMAL
            goto L1e
        L1c:
            com.opos.mobad.m.a.w r1 = com.opos.mobad.m.a.w.UNKNOWN_STATUS
        L1e:
            r0.a(r1)
            com.opos.mobad.m.a.u$a r1 = new com.opos.mobad.m.a.u$a
            r1.<init>()
            com.opos.mobad.m.a.t r0 = r0.b()
            com.opos.mobad.m.a.u$a r0 = r1.a(r0)
            com.opos.mobad.m.a.h r1 = a(r4)
            com.opos.mobad.m.a.u$a r0 = r0.a(r1)
            com.opos.mobad.m.a.u$a r5 = r0.a(r5)
            java.lang.String r0 = r4.getPackageName()
            com.opos.mobad.m.a.u$a r5 = r5.b(r0)
            com.opos.mobad.m.a.u r5 = r5.b()
            byte[] r5 = r5.b()
            com.opos.mobad.service.a$2 r0 = new com.opos.mobad.service.a$2
            r0.<init>()
            java.lang.String r1 = "https://uapi.ads.heytapmobi.com/union/instant/vip/right"
            com.opos.mobad.service.h.b$b r4 = com.opos.mobad.service.h.b.a(r4, r1, r5, r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "check result:"
            r5.append(r0)
            if (r4 == 0) goto L66
            T r0 = r4.f23684c
            com.opos.mobad.m.a.v r0 = (com.opos.mobad.m.a.v) r0
            goto L67
        L66:
            r0 = 0
        L67:
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.String r0 = "am"
            com.opos.cmn.an.f.a.b(r0, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.a.c(android.content.Context, java.lang.String):com.opos.mobad.service.h.b$b");
    }

    public FutureTask<Integer> a(Context context, String str) {
        return a(context, str, false);
    }

    public void a(String str, int i2, String str2, String str3, String str4, String str5, String str6) {
        InterfaceC0478a interfaceC0478a;
        com.opos.cmn.an.f.a.b("am", "do exercise");
        com.opos.mobad.service.i.d.a().a(str, str2, str3, str4, str5, str6, this.f23469b);
        if (TextUtils.isEmpty(this.f23469b) || (interfaceC0478a = this.f23468a) == null) {
            return;
        }
        try {
            interfaceC0478a.a(i2);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("am", "on exercise fail", th);
        }
    }

    public FutureTask<Integer> b(Context context, String str) {
        return a(context, str, true);
    }

    public void b() {
        this.f23469b = null;
        this.f23470c = 0;
        this.f23468a = null;
        this.f23471d = new AtomicInteger(0);
        this.f23472e = new AtomicInteger(0);
    }

    public String c() {
        return this.f23469b;
    }

    public int d() {
        return this.f23470c;
    }

    public void e() {
        InterfaceC0478a interfaceC0478a = this.f23468a;
        if (interfaceC0478a != null) {
            try {
                interfaceC0478a.a(this.f23469b);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.b("am", "promote fail", th);
            }
        }
    }

    public int f() {
        return (this.f23471d.get() > 60 || this.f23471d.incrementAndGet() > 60) ? 0 : 1;
    }

    public int g() {
        return (this.f23473g.get() > 10 || this.f23472e.incrementAndGet() > 10) ? 0 : 1;
    }
}
