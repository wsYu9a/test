package com.vivo.mobilead.f;

import android.app.Activity;
import android.app.Application;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.vivo.mobilead.manager.a;
import com.vivo.mobilead.util.i0;
import com.vivo.mobilead.util.x0;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class c {
    private static final String n = "c";

    /* renamed from: a */
    private com.vivo.mobilead.f.b f28825a;

    /* renamed from: b */
    private LinkedHashMap<String, com.vivo.mobilead.f.a> f28826b;

    /* renamed from: c */
    private Activity f28827c;

    /* renamed from: d */
    private long f28828d;

    /* renamed from: e */
    private boolean f28829e;

    /* renamed from: f */
    private AtomicInteger f28830f;

    /* renamed from: g */
    private HandlerThread f28831g;

    /* renamed from: h */
    private Handler f28832h;

    /* renamed from: i */
    private Handler f28833i;

    /* renamed from: j */
    private i0 f28834j;
    private long k;
    private boolean l;
    private Application.ActivityLifecycleCallbacks m;

    class a implements a.InterfaceC0600a {
        a() {
        }

        @Override // com.vivo.mobilead.manager.a.InterfaceC0600a
        public void a(boolean z) {
            c.this.f28829e = z;
            if (!z) {
                com.vivo.mobilead.c.b.e().b();
            } else {
                com.vivo.mobilead.c.b.e().d();
                com.vivo.mobilead.c.b.e().c();
            }
        }
    }

    class b implements Application.ActivityLifecycleCallbacks {
        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (c.this.f28834j != null) {
                c.this.f28834j.a();
                c.this.f28834j = null;
            }
            c.this.f28827c = null;
            com.vivo.mobilead.c.b.e().a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            c.this.f28827c = activity;
            com.vivo.mobilead.manager.a.b().a(activity.getClass().getSimpleName());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            com.vivo.mobilead.manager.a.b().a();
        }
    }

    /* renamed from: com.vivo.mobilead.f.c$c */
    class C0592c extends com.vivo.mobilead.util.f1.b {
        C0592c() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (c.this.f28830f.get() == 0) {
                c.this.f28830f.incrementAndGet();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                c.this.f28825a = new com.vivo.mobilead.f.b();
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        c.this.f28827c.getApplicationContext().registerReceiver(c.this.f28825a, intentFilter, 2);
                    } else {
                        c.this.f28827c.getApplicationContext().registerReceiver(c.this.f28825a, intentFilter);
                    }
                } catch (Exception unused) {
                    x0.b(com.vivo.mobilead.util.f1.b.TAG, "jump error！");
                }
            }
        }
    }

    class d extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f28838a;

        d(String str) {
            this.f28838a = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0085, code lost:
        
            com.vivo.mobilead.f.c.this.f28828d = java.lang.System.currentTimeMillis();
            com.vivo.mobilead.f.c.this.c(r0);
         */
        @Override // com.vivo.mobilead.util.f1.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void safelyRun() {
            /*
                r6 = this;
                java.lang.String r0 = r6.f28838a
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 == 0) goto L9
                return
            L9:
                com.vivo.mobilead.f.c r0 = com.vivo.mobilead.f.c.this
                java.util.LinkedHashMap r0 = com.vivo.mobilead.f.c.e(r0)
                java.lang.String r1 = r6.f28838a
                java.lang.Object r0 = r0.get(r1)
                com.vivo.mobilead.f.a r0 = (com.vivo.mobilead.f.a) r0
                if (r0 != 0) goto L1a
                return
            L1a:
                r1 = 1
                r0.a(r1)
                long r2 = java.lang.System.currentTimeMillis()
                com.vivo.mobilead.f.c r0 = com.vivo.mobilead.f.c.this
                long r4 = com.vivo.mobilead.f.c.f(r0)
                long r2 = r2 - r4
                com.vivo.mobilead.f.c r0 = com.vivo.mobilead.f.c.this
                long r4 = com.vivo.mobilead.f.c.g(r0)
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L34
                goto L35
            L34:
                r1 = 0
            L35:
                com.vivo.mobilead.f.c r0 = com.vivo.mobilead.f.c.this
                boolean r0 = r0.b()
                if (r0 == 0) goto Lc0
                if (r1 != 0) goto L41
                goto Lc0
            L41:
                com.vivo.mobilead.f.c r0 = com.vivo.mobilead.f.c.this     // Catch: java.lang.Exception -> L94
                java.util.LinkedHashMap r0 = com.vivo.mobilead.f.c.e(r0)     // Catch: java.lang.Exception -> L94
                java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Exception -> L94
                java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Exception -> L94
                boolean r1 = r0.hasNext()     // Catch: java.lang.Exception -> L94
                if (r1 != 0) goto L56
                goto Laf
            L56:
                java.lang.Object r0 = r0.next()     // Catch: java.lang.Exception -> L94
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Exception -> L94
                java.lang.Object r1 = r0.getValue()     // Catch: java.lang.Exception -> L94
                com.vivo.mobilead.f.a r1 = (com.vivo.mobilead.f.a) r1     // Catch: java.lang.Exception -> L94
                boolean r2 = r1.b()     // Catch: java.lang.Exception -> L94
                if (r2 != 0) goto L69
                goto L41
            L69:
                java.lang.Object r0 = r0.getKey()     // Catch: java.lang.Exception -> L94
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L94
                com.vivo.mobilead.f.c r2 = com.vivo.mobilead.f.c.this     // Catch: java.lang.Exception -> L94
                com.vivo.mobilead.f.c.a(r2, r0)     // Catch: java.lang.Exception -> L94
                long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L94
                long r4 = r1.a()     // Catch: java.lang.Exception -> L94
                long r2 = r2 - r4
                r4 = 600000(0x927c0, double:2.964394E-318)
                int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r1 <= 0) goto L85
                goto L41
            L85:
                com.vivo.mobilead.f.c r1 = com.vivo.mobilead.f.c.this     // Catch: java.lang.Exception -> L94
                long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L94
                com.vivo.mobilead.f.c.a(r1, r2)     // Catch: java.lang.Exception -> L94
                com.vivo.mobilead.f.c r1 = com.vivo.mobilead.f.c.this     // Catch: java.lang.Exception -> L94
                r1.c(r0)     // Catch: java.lang.Exception -> L94
                goto Laf
            L94:
                r0 = move-exception
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "InstallToast show failed: "
                r1.append(r2)
                java.lang.String r0 = r0.getMessage()
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.String r1 = "SafeRunnable"
                com.vivo.mobilead.util.x0.b(r1, r0)
            Laf:
                com.vivo.mobilead.f.c r0 = com.vivo.mobilead.f.c.this
                java.util.LinkedHashMap r0 = com.vivo.mobilead.f.c.e(r0)
                int r0 = r0.size()
                if (r0 != 0) goto Lc0
                com.vivo.mobilead.f.c r0 = com.vivo.mobilead.f.c.this
                r0.c()
            Lc0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.vivo.mobilead.f.c.d.safelyRun():void");
        }
    }

    class e extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f28840a;

        e(String str) {
            this.f28840a = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                String d2 = c.this.d(this.f28840a);
                if (TextUtils.isEmpty(d2)) {
                    return;
                }
                if (c.this.f28834j != null) {
                    c.this.f28834j.a();
                }
                c cVar = c.this;
                cVar.f28834j = new i0(cVar.f28827c);
                c.this.f28834j.a(this.f28840a, d2);
            } catch (Exception unused) {
                x0.b(com.vivo.mobilead.util.f1.b.TAG, "init error！");
            }
        }
    }

    class f extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f28842a;

        f(String str) {
            this.f28842a = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            if (!TextUtils.isEmpty(this.f28842a) && c.this.f28826b.get(this.f28842a) == null) {
                com.vivo.mobilead.f.a aVar = new com.vivo.mobilead.f.a();
                aVar.a(this.f28842a);
                aVar.a(System.currentTimeMillis());
                aVar.a(false);
                c.this.f28826b.put(this.f28842a, aVar);
            }
        }
    }

    private static class g {

        /* renamed from: a */
        private static final c f28844a = new c(null);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    private c() {
        this.f28830f = new AtomicInteger(0);
        this.f28833i = new Handler(Looper.getMainLooper());
        this.k = com.alipay.mobilesecuritysdk.constant.a.k;
        this.l = true;
        this.m = new b();
        this.f28826b = new LinkedHashMap<>();
        HandlerThread handlerThread = new HandlerThread("installToast");
        this.f28831g = handlerThread;
        handlerThread.start();
        this.f28832h = new Handler(this.f28831g.getLooper());
    }

    public static c d() {
        return g.f28844a;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28826b.remove(str);
    }

    public void c() {
        if (this.f28827c != null && this.f28830f.get() > 0) {
            this.f28830f.decrementAndGet();
            try {
                this.f28827c.getApplicationContext().unregisterReceiver(this.f28825a);
            } catch (Exception unused) {
                x0.b(n, "jump error！");
            }
        }
    }

    public String d(String str) {
        Activity activity = this.f28827c;
        if (activity == null) {
            return "";
        }
        PackageManager packageManager = activity.getApplicationContext().getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return packageManager.getApplicationLabel(applicationInfo).toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public boolean b() {
        return this.f28829e;
    }

    public void b(String str) {
        this.f28832h.post(new d(str));
    }

    public void c(String str) {
        if (this.f28827c == null) {
            return;
        }
        this.f28833i.post(new e(str));
    }

    public void a(Application application) {
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.m);
        com.vivo.mobilead.manager.a.b().a(new a());
    }

    public void a() {
        if (!this.l || this.f28827c == null) {
            return;
        }
        this.f28832h.post(new C0592c());
    }

    public void a(long j2) {
        if (j2 < 0) {
            return;
        }
        this.k = j2;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void a(String str) {
        if (this.l) {
            this.f28832h.post(new f(str));
        }
    }
}
