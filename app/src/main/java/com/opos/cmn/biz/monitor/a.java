package com.opos.cmn.biz.monitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.opos.cmn.biz.monitor.MonitorEvent;
import com.opos.cmn.biz.monitor.b;
import com.opos.cmn.biz.monitor.b.e;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static volatile a f16665a = null;

    /* renamed from: b */
    private static volatile boolean f16666b = false;

    /* renamed from: c */
    private com.opos.cmn.biz.monitor.b.a f16667c;

    /* renamed from: d */
    private com.opos.cmn.biz.monitor.b.a f16668d = new com.opos.cmn.biz.monitor.b.d();

    /* renamed from: com.opos.cmn.biz.monitor.a$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16669a;

        /* renamed from: b */
        final /* synthetic */ String f16670b;

        /* renamed from: c */
        final /* synthetic */ boolean f16671c;

        /* renamed from: d */
        final /* synthetic */ boolean f16672d;

        /* renamed from: e */
        final /* synthetic */ com.opos.cmn.biz.monitor.a.d f16673e;

        /* renamed from: com.opos.cmn.biz.monitor.a$1$1 */
        class C03741 implements e.a {
            C03741() {
            }

            @Override // com.opos.cmn.biz.monitor.b.e.a
            public void a() {
                com.opos.cmn.an.f.a.b("MonitorManager", "onFail: " + str);
                if (a2) {
                    com.opos.cmn.biz.monitor.a.c.a().a(true);
                }
            }

            @Override // com.opos.cmn.biz.monitor.b.e.a
            public void a(byte[] bArr) {
                com.opos.cmn.an.f.a.b("MonitorManager", "onSuccess: " + str);
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                if (z2) {
                    if (a2) {
                        com.opos.cmn.an.f.a.b("MonitorManager", "mixIn monitor, remove cache");
                        if (!com.opos.cmn.biz.monitor.b.e.a(bArr)) {
                            com.opos.cmn.an.f.a.b("MonitorManager", "request success but response fail");
                        }
                    } else {
                        com.opos.cmn.an.f.a.b("MonitorManager", "needTry monitor, remove cache");
                    }
                    com.opos.cmn.biz.monitor.a.c.a().b(dVar);
                }
                com.opos.cmn.biz.monitor.a.c.a().b();
            }
        }

        AnonymousClass1(Context context, String str, boolean z, boolean z2, com.opos.cmn.biz.monitor.a.d dVar) {
            context = context;
            str = str;
            z2 = z;
            a2 = z2;
            dVar = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            new com.opos.cmn.biz.monitor.b.e(context, str, 3, a.this.b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.1.1
                C03741() {
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a() {
                    com.opos.cmn.an.f.a.b("MonitorManager", "onFail: " + str);
                    if (a2) {
                        com.opos.cmn.biz.monitor.a.c.a().a(true);
                    }
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a(byte[] bArr) {
                    com.opos.cmn.an.f.a.b("MonitorManager", "onSuccess: " + str);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (z2) {
                        if (a2) {
                            com.opos.cmn.an.f.a.b("MonitorManager", "mixIn monitor, remove cache");
                            if (!com.opos.cmn.biz.monitor.b.e.a(bArr)) {
                                com.opos.cmn.an.f.a.b("MonitorManager", "request success but response fail");
                            }
                        } else {
                            com.opos.cmn.an.f.a.b("MonitorManager", "needTry monitor, remove cache");
                        }
                        com.opos.cmn.biz.monitor.a.c.a().b(dVar);
                    }
                    com.opos.cmn.biz.monitor.a.c.a().b();
                }
            }).a();
        }
    }

    /* renamed from: com.opos.cmn.biz.monitor.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Runnable f16676a;

        AnonymousClass2(Runnable runnable) {
            runnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.cmn.an.j.b.a().execute(runnable);
        }
    }

    private a() {
    }

    public static a a() {
        a aVar;
        if (f16665a != null) {
            return f16665a;
        }
        synchronized (a.class) {
            if (f16665a != null) {
                aVar = f16665a;
            } else {
                f16665a = new a();
                aVar = f16665a;
            }
        }
        return aVar;
    }

    private void a(Context context, String str, boolean z, long j2) {
        b(context);
        boolean a2 = e.a(str);
        boolean z2 = a2 || z;
        com.opos.cmn.an.f.a.b("MonitorManager", "send request url:" + str + ", isMixIn:" + a2 + ", isNeedTry:" + z + ", delayMill: " + j2);
        com.opos.cmn.biz.monitor.a.d dVar = new com.opos.cmn.biz.monitor.a.d(str);
        if (z2) {
            com.opos.cmn.biz.monitor.a.c.a().a(dVar);
        }
        AnonymousClass1 anonymousClass1 = new Runnable() { // from class: com.opos.cmn.biz.monitor.a.1

            /* renamed from: a */
            final /* synthetic */ Context f16669a;

            /* renamed from: b */
            final /* synthetic */ String f16670b;

            /* renamed from: c */
            final /* synthetic */ boolean f16671c;

            /* renamed from: d */
            final /* synthetic */ boolean f16672d;

            /* renamed from: e */
            final /* synthetic */ com.opos.cmn.biz.monitor.a.d f16673e;

            /* renamed from: com.opos.cmn.biz.monitor.a$1$1 */
            class C03741 implements e.a {
                C03741() {
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a() {
                    com.opos.cmn.an.f.a.b("MonitorManager", "onFail: " + str);
                    if (a2) {
                        com.opos.cmn.biz.monitor.a.c.a().a(true);
                    }
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a(byte[] bArr) {
                    com.opos.cmn.an.f.a.b("MonitorManager", "onSuccess: " + str);
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    if (z2) {
                        if (a2) {
                            com.opos.cmn.an.f.a.b("MonitorManager", "mixIn monitor, remove cache");
                            if (!com.opos.cmn.biz.monitor.b.e.a(bArr)) {
                                com.opos.cmn.an.f.a.b("MonitorManager", "request success but response fail");
                            }
                        } else {
                            com.opos.cmn.an.f.a.b("MonitorManager", "needTry monitor, remove cache");
                        }
                        com.opos.cmn.biz.monitor.a.c.a().b(dVar);
                    }
                    com.opos.cmn.biz.monitor.a.c.a().b();
                }
            }

            AnonymousClass1(Context context2, String str2, boolean z22, boolean a22, com.opos.cmn.biz.monitor.a.d dVar2) {
                context = context2;
                str = str2;
                z2 = z22;
                a2 = a22;
                dVar = dVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                new com.opos.cmn.biz.monitor.b.e(context, str, 3, a.this.b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.1.1
                    C03741() {
                    }

                    @Override // com.opos.cmn.biz.monitor.b.e.a
                    public void a() {
                        com.opos.cmn.an.f.a.b("MonitorManager", "onFail: " + str);
                        if (a2) {
                            com.opos.cmn.biz.monitor.a.c.a().a(true);
                        }
                    }

                    @Override // com.opos.cmn.biz.monitor.b.e.a
                    public void a(byte[] bArr) {
                        com.opos.cmn.an.f.a.b("MonitorManager", "onSuccess: " + str);
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        if (z2) {
                            if (a2) {
                                com.opos.cmn.an.f.a.b("MonitorManager", "mixIn monitor, remove cache");
                                if (!com.opos.cmn.biz.monitor.b.e.a(bArr)) {
                                    com.opos.cmn.an.f.a.b("MonitorManager", "request success but response fail");
                                }
                            } else {
                                com.opos.cmn.an.f.a.b("MonitorManager", "needTry monitor, remove cache");
                            }
                            com.opos.cmn.biz.monitor.a.c.a().b(dVar);
                        }
                        com.opos.cmn.biz.monitor.a.c.a().b();
                    }
                }).a();
            }
        };
        if (j2 <= 0) {
            anonymousClass1.run();
        } else {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.2

                /* renamed from: a */
                final /* synthetic */ Runnable f16676a;

                AnonymousClass2(Runnable anonymousClass12) {
                    runnable = anonymousClass12;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.j.b.a().execute(runnable);
                }
            }, j2);
        }
    }

    private void b(Context context) {
        if (f16666b) {
            return;
        }
        a(context);
    }

    public void a(Context context) {
        a(context, null);
    }

    public void a(Context context, d dVar) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("MonitorManager", "init monitor failed, context can not be null");
        } else {
            if (f16666b) {
                return;
            }
            com.opos.cmn.biz.monitor.a.c.a().a(context);
            f16666b = true;
        }
    }

    public void a(Context context, String str, MonitorEvent monitorEvent) {
        b(context);
        a(context, str, monitorEvent, new b.a().a(true).a());
    }

    public void a(Context context, String str, MonitorEvent monitorEvent, b bVar) {
        String str2;
        b(context);
        if (context == null) {
            str2 = "report with context null";
        } else {
            if (!TextUtils.isEmpty(str)) {
                if (monitorEvent == null) {
                    com.opos.cmn.an.f.a.b("MonitorManager", "report with monitor event null");
                    monitorEvent = new MonitorEvent.b().a();
                }
                if (bVar == null || bVar.f16714a) {
                    str = e.a(context, str, monitorEvent).f16752a;
                }
                a(context, str, bVar != null && bVar.f16715b, bVar != null ? bVar.f16716c : 0L);
                return;
            }
            str2 = "report with url null";
        }
        com.opos.cmn.an.f.a.d("MonitorManager", str2);
    }

    public com.opos.cmn.biz.monitor.b.a b() {
        com.opos.cmn.biz.monitor.b.a aVar = this.f16667c;
        return aVar != null ? aVar : this.f16668d;
    }

    public String b(Context context, String str, MonitorEvent monitorEvent) {
        b(context);
        if (context == null || TextUtils.isEmpty(str)) {
            return str;
        }
        if (monitorEvent == null) {
            monitorEvent = new MonitorEvent.b().a();
        }
        return e.a(context, str, monitorEvent).f16752a;
    }
}
