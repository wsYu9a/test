package com.kwad.components.core.n.b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes3.dex */
public abstract class a<T extends IOfflineCompo<?>> {
    private long GC;
    private String OA = "";

    /* renamed from: com.kwad.components.core.n.b.a$1 */
    public class AnonymousClass1 extends b.a {
        long OB;
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public void b(com.kwad.library.solder.lib.b.a aVar) {
            super.b((AnonymousClass1) aVar);
            c.d(a.this.getTag(), "install component resource start");
            com.kwad.components.core.n.c.a.b(a.this.pD(), a.this.getDuration(), a.this.OA);
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: c */
        public void a(com.kwad.library.solder.lib.b.a aVar) {
            super.a((AnonymousClass1) aVar);
            c.d(a.this.getTag(), "install component resource success");
            com.kwad.components.core.n.c.a.c(a.this.pD(), a.this.getDuration(), a.this.OA);
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: d */
        public void e(com.kwad.library.solder.lib.b.a aVar) {
            super.e((AnonymousClass1) aVar);
            this.OB = SystemClock.elapsedRealtime();
            a.this.OA = aVar.yC() ? "ASSETS" : "NETWORK";
            c.d(a.this.getTag(), "update component resource start");
            com.kwad.components.core.n.c.c.d(a.this.pD(), a.this.getDuration(), a.this.OA);
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: e */
        public void c(com.kwad.library.solder.lib.b.a aVar) {
            super.c((AnonymousClass1) aVar);
            c.d(a.this.getTag(), "load component resource start");
            a.this.OA = "LOCAL";
            com.kwad.components.core.n.c.a.b(a.this.pD(), a.this.getDuration(), aVar.yt().yg().yH());
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
            super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
            c.d(a.this.getTag(), "load component resource success");
            com.kwad.components.core.n.c.a.a(a.this.pD(), a.this.getDuration(), a.this.OA);
            a.this.a(context, !"LOCAL".equals(r4.OA), aVar2.yc());
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        /* renamed from: a */
        public void d(com.kwad.library.solder.lib.b.a aVar) {
            super.d((AnonymousClass1) aVar);
            c.d(a.this.getTag(), "update component resource success");
            com.kwad.components.core.n.c.c.a(a.this.pD(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.OB, a.this.OA);
        }

        @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
        public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
            super.a((AnonymousClass1) aVar, pluginError);
            if (aVar.getState() == 1) {
                com.kwad.components.core.n.c.c.b(a.this.pD(), a.this.getDuration(), pluginError.getCode(), a.this.OA, pluginError.getMessage());
            }
            com.kwad.components.core.n.c.a.a(a.this.pD(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.OA);
            c.d(a.this.getTag(), "load component resource failed error: " + pluginError);
        }
    }

    private void ap(Context context) {
        if (com.kwad.components.core.a.Ku.booleanValue()) {
            c.d(getTag(), "init start disableOffline");
            a(context, false, getClass().getClassLoader());
            return;
        }
        com.kwad.library.solder.lib.c.b pA = pA();
        c.d(getTag(), "load component start pluginInfo: " + pA);
        com.kwad.library.solder.a.a.a(context, pA, new b.a() { // from class: com.kwad.components.core.n.b.a.1
            long OB;
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public void b(com.kwad.library.solder.lib.b.a aVar) {
                super.b((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource start");
                com.kwad.components.core.n.c.a.b(a.this.pD(), a.this.getDuration(), a.this.OA);
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: c */
            public void a(com.kwad.library.solder.lib.b.a aVar) {
                super.a((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "install component resource success");
                com.kwad.components.core.n.c.a.c(a.this.pD(), a.this.getDuration(), a.this.OA);
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: d */
            public void e(com.kwad.library.solder.lib.b.a aVar) {
                super.e((AnonymousClass1) aVar);
                this.OB = SystemClock.elapsedRealtime();
                a.this.OA = aVar.yC() ? "ASSETS" : "NETWORK";
                c.d(a.this.getTag(), "update component resource start");
                com.kwad.components.core.n.c.c.d(a.this.pD(), a.this.getDuration(), a.this.OA);
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: e */
            public void c(com.kwad.library.solder.lib.b.a aVar) {
                super.c((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "load component resource start");
                a.this.OA = "LOCAL";
                com.kwad.components.core.n.c.a.b(a.this.pD(), a.this.getDuration(), aVar.yt().yg().yH());
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, com.kwad.library.b.a aVar2) {
                super.a((AnonymousClass1) aVar, (com.kwad.library.solder.lib.b.a) aVar2);
                c.d(a.this.getTag(), "load component resource success");
                com.kwad.components.core.n.c.a.a(a.this.pD(), a.this.getDuration(), a.this.OA);
                a.this.a(context, !"LOCAL".equals(r4.OA), aVar2.yc());
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            /* renamed from: a */
            public void d(com.kwad.library.solder.lib.b.a aVar) {
                super.d((AnonymousClass1) aVar);
                c.d(a.this.getTag(), "update component resource success");
                com.kwad.components.core.n.c.c.a(a.this.pD(), a.this.getDuration(), SystemClock.elapsedRealtime() - this.OB, a.this.OA);
            }

            @Override // com.kwad.library.solder.lib.ext.b.C0475b, com.kwad.library.solder.lib.ext.b
            public void a(com.kwad.library.solder.lib.b.a aVar, PluginError pluginError) {
                super.a((AnonymousClass1) aVar, pluginError);
                if (aVar.getState() == 1) {
                    com.kwad.components.core.n.c.c.b(a.this.pD(), a.this.getDuration(), pluginError.getCode(), a.this.OA, pluginError.getMessage());
                }
                com.kwad.components.core.n.c.a.a(a.this.pD(), a.this.getDuration(), pluginError.getCode(), "cmp_load_error " + pluginError.getMessage(), a.this.OA);
                c.d(a.this.getTag(), "load component resource failed error: " + pluginError);
            }
        });
    }

    public long getDuration() {
        return SystemClock.elapsedRealtime() - this.GC;
    }

    private com.kwad.library.solder.lib.c.b pA() {
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.ann = pE();
        bVar.Lc = true;
        bVar.anr = false;
        bVar.ano = com.kwad.sdk.core.network.idc.a.Fz().eg(pG());
        bVar.version = pF();
        bVar.anq = pH();
        if (com.kwad.components.core.a.Kx.booleanValue()) {
            bVar.amQ = pI();
            bVar.amR = true;
        }
        if (TextUtils.isEmpty(pH()) || TextUtils.isEmpty(pE()) || TextUtils.isEmpty(pF()) || TextUtils.isEmpty(pG())) {
            com.kwad.components.core.n.c.a.a(pD(), getDuration(), 6001, "buildRemotePlugInfo error", this.OA);
        }
        return bVar;
    }

    private void pB() {
        c.d(getTag(), "init component start cost: " + getDuration());
        com.kwad.components.core.n.c.a.d(pD(), getDuration());
    }

    public abstract void a(Context context, boolean z10, T t10);

    public final void av(int i10) {
        c.d(getTag(), "init component error time: " + getDuration());
        com.kwad.components.core.n.c.a.a(pD(), getDuration(), 5001, "cmp_init_error, errorCode:" + i10, this.OA);
    }

    public abstract String getTag();

    public final void init(Context context) {
        try {
            if (!isEnabled()) {
                try {
                    c.d(getTag(), "del start");
                    com.kwad.library.solder.a.a.k(context, pE());
                } catch (Throwable unused) {
                }
            } else {
                this.GC = SystemClock.elapsedRealtime();
                com.kwad.components.core.n.c.a.c(pD(), getDuration());
                c.d(getTag(), "init start");
                ap(context);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public abstract boolean isEnabled();

    public final void pC() {
        c.d(getTag(), "init component success cost: " + getDuration());
        com.kwad.components.core.n.c.a.c(pD(), getDuration(), i.ym().yg().yH());
    }

    public abstract String pD();

    public abstract String pE();

    public abstract String pF();

    public abstract String pG();

    public abstract String pH();

    public abstract String pI();

    public abstract String pJ();

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Context context, boolean z10, ClassLoader classLoader) {
        pB();
        String pJ = pJ();
        try {
            IOfflineCompo iOfflineCompo = (IOfflineCompo) classLoader.loadClass(pJ).newInstance();
            c.d(getTag(), "load component instance success: " + iOfflineCompo.getClass().getName() + ", loadFromNet:" + z10 + ", classLoader:" + classLoader);
            a(context, z10, (boolean) iOfflineCompo);
        } catch (Throwable th2) {
            com.kwad.components.core.n.c.a.a(pD(), getDuration(), 4005, "loadClass error", this.OA);
            c.e(getTag(), "loadClass or instance failed: " + pJ, th2);
        }
    }
}
