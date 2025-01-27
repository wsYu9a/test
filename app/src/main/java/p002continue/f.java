package p002continue;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import bh.a0;
import bh.b;
import bh.c;
import bh.e;
import bh.h;
import bh.i;
import bh.j;
import bh.k;
import bh.s;
import com.sntech.ads.SNAdConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p002continue.c;
import p002continue.e;
import p002continue.g;

/* loaded from: classes4.dex */
public final class f {

    /* renamed from: e */
    public Application f25210e;

    /* renamed from: a */
    public final Map<String, h> f25206a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Map<String, h> f25207b = new ConcurrentHashMap();

    /* renamed from: c */
    public final Set<Object> f25208c = new HashSet();

    /* renamed from: d */
    public SNAdConfig f25209d = null;

    /* renamed from: f */
    public boolean f25211f = false;

    /* renamed from: g */
    public boolean f25212g = false;

    public static class a implements e {
    }

    public static class b {

        /* renamed from: a */
        public static final f f25213a = new f();
    }

    public static /* synthetic */ void n(i iVar, Observable observable, Object obj) {
        if (!(((e) obj) instanceof e.c) || iVar == null) {
            return;
        }
        iVar.a(Boolean.TRUE);
    }

    public final void A(Application application) {
        b.a.f1608a.k("Loader", "onApplicationCreate");
        p().post(new Runnable() { // from class: bh.m

            /* renamed from: c */
            public final /* synthetic */ Application f1635c;

            public /* synthetic */ m(Application application2) {
                application = application2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p002continue.f.this.u(application);
            }
        });
    }

    public final void h(Application application) {
        b.a.f1608a.k("Loader", "onApplicationLowMemory");
        p().post(new Runnable() { // from class: bh.p

            /* renamed from: c */
            public final /* synthetic */ Application f1641c;

            public /* synthetic */ p(Application application2) {
                application = application2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p002continue.f.this.q(application);
            }
        });
    }

    public final Collection<h> i() {
        return new ArrayList(((HashMap) t()).values());
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    public final /* synthetic */ void j(Application application) {
        Iterator it = this.f25207b.values().iterator();
        while (it.hasNext()) {
            bh.a.a().post(new Runnable() { // from class: bh.n

                /* renamed from: c */
                public final /* synthetic */ Application f1637c;

                public /* synthetic */ n(Application application2) {
                    application = application2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    h.this.onApplicationAttachBaseContext(application);
                }
            });
        }
        this.f25211f = true;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.ArrayList, java.util.List<continue.c<?>>] */
    public final void k(Application application, SNAdConfig sNAdConfig, i<Boolean> iVar) {
        this.f25209d = sNAdConfig;
        this.f25210e = application;
        g gVar = g.a.f25217a;
        a aVar = new a();
        c cVar = new c("SNADS.LOGGER", sNAdConfig.isDebug());
        c cVar2 = new c("SNADS.PLUGIN", sNAdConfig.isDebug());
        s sVar = new Observer() { // from class: bh.s
            public /* synthetic */ s() {
            }

            @Override // java.util.Observer
            public final void update(Observable observable, Object obj) {
                p002continue.f.n(i.this, observable, obj);
            }
        };
        b.a.f1608a.f1630a = cVar;
        b.a.f1609b.f1630a = cVar2;
        Creturn creturn = new Creturn(application);
        gVar.f25214a = creturn;
        creturn.addObserver(sVar);
        gVar.f25216c = aVar;
        gVar.f25215b = new d(gVar.f25214a);
        boolean a10 = k.a(this.f25210e, this.f25209d.getMainProcessName());
        long currentTimeMillis = System.currentTimeMillis();
        gVar.f25215b.a();
        if (a10) {
            Creturn creturn2 = gVar.f25214a;
            creturn2.getClass();
            try {
                a0.q(creturn2.f25222e);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        j jVar = b.a.f1608a;
        StringBuilder a11 = nh.b.a("loadLocalPlugin:");
        a11.append(TextUtils.join(",", gVar.f25215b.f25203g));
        a11.append(",cost ");
        a11.append(System.currentTimeMillis() - currentTimeMillis);
        a11.append("ms");
        jVar.k("PluginManager", a11.toString());
        if (a10) {
            g gVar2 = g.a.f25217a;
            d dVar = gVar2.f25215b;
            Iterator it = dVar.f25204h.iterator();
            while (it.hasNext()) {
                dVar.f25195c.b((c) it.next());
                it.remove();
            }
            Creturn creturn3 = gVar2.f25214a;
            creturn3.b(new c.e(creturn3));
            b.a.f1608a.k("PluginManager", "requestPlugin");
        }
    }

    public final /* synthetic */ void l(h hVar) {
        hVar.onApplicationAttachBaseContext(this.f25210e);
    }

    public final boolean o(String str) {
        return ((HashMap) t()).containsKey(str);
    }

    public final Handler p() {
        if (!bh.a.f1604a.isAlive()) {
            synchronized (bh.a.class) {
                try {
                    if (!bh.a.f1604a.isAlive()) {
                        HandlerThread handlerThread = new HandlerThread("snadsdk_work_thread", -1);
                        bh.a.f1604a = handlerThread;
                        handlerThread.start();
                        bh.a.f1605b = new Handler(bh.a.f1604a.getLooper());
                    }
                } finally {
                }
            }
        }
        return bh.a.f1605b;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    public final /* synthetic */ void q(Application application) {
        Iterator it = this.f25207b.values().iterator();
        while (it.hasNext()) {
            ((h) it.next()).onApplicationLowMemory(application);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    public final void r(h hVar) {
        hVar.onLoad(this.f25210e, this.f25209d);
        this.f25207b.put(hVar.f1621e, hVar);
        this.f25206a.remove(hVar.f1621e);
        if (this.f25211f) {
            bh.a.a().post(new Runnable() { // from class: bh.q

                /* renamed from: c */
                public final /* synthetic */ h f1643c;

                public /* synthetic */ q(h hVar2) {
                    hVar = hVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    p002continue.f.this.l(hVar);
                }
            });
        }
        if (this.f25212g) {
            bh.a.a().post(new Runnable() { // from class: bh.r

                /* renamed from: c */
                public final /* synthetic */ h f1645c;

                public /* synthetic */ r(h hVar2) {
                    hVar = hVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    p002continue.f.this.v(hVar);
                }
            });
        }
    }

    public final void s(String str) {
        p().post(new Runnable() { // from class: bh.v

            /* renamed from: c */
            public final /* synthetic */ String f1652c;

            public /* synthetic */ v(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p002continue.f.this.x(str);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    public final Map<String, h> t() {
        HashMap hashMap = new HashMap(this.f25207b.size() + this.f25206a.size());
        hashMap.putAll(this.f25206a);
        hashMap.putAll(this.f25207b);
        return hashMap;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    public final /* synthetic */ void u(Application application) {
        Iterator it = this.f25207b.values().iterator();
        while (it.hasNext()) {
            bh.a.a().post(new Runnable() { // from class: bh.o

                /* renamed from: c */
                public final /* synthetic */ Application f1639c;

                public /* synthetic */ o(Application application2) {
                    application = application2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    h.this.onApplicationCreate(application);
                }
            });
        }
        this.f25212g = true;
    }

    public final /* synthetic */ void v(h hVar) {
        hVar.onApplicationCreate(this.f25210e);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    public final /* synthetic */ void x(String str) {
        h hVar = (h) this.f25207b.get(str);
        if (hVar != null) {
            hVar.onUnload(this.f25210e);
        }
        this.f25207b.remove(str);
    }

    public final void y(Application application) {
        b.a.f1608a.k("Loader", "onApplicationAttachBaseContext");
        p().post(new Runnable() { // from class: bh.u

            /* renamed from: c */
            public final /* synthetic */ Application f1650c;

            public /* synthetic */ u(Application application2) {
                application = application2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p002continue.f.this.j(application);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<java.lang.String, bh.h>, java.util.concurrent.ConcurrentHashMap] */
    public final void z(h hVar) {
        this.f25206a.put(hVar.f1621e, hVar);
        hVar.d(this.f25210e);
        p().post(new Runnable() { // from class: bh.t

            /* renamed from: c */
            public final /* synthetic */ h f1648c;

            public /* synthetic */ t(h hVar2) {
                hVar = hVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                p002continue.f.this.r(hVar);
            }
        });
    }
}
