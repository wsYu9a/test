package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class d {
    private static long fA;
    private static com.kwad.sdk.core.f.d fv;
    private static com.kwad.sdk.core.f.c fw;
    private static Vibrator fx;
    private static List<c> fy = new CopyOnWriteArrayList();
    private static List<a> fz = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.ad.feed.d$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.f.b {

        /* renamed from: com.kwad.components.ad.feed.d$1$1 */
        public class RunnableC03681 implements Runnable {
            public RunnableC03681() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                d.fv.Hb();
            }
        }

        @Override // com.kwad.sdk.core.f.b
        public final void a(double d10) {
            if (d.fy != null) {
                Iterator it = d.fy.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    c cVar = (c) it.next();
                    if (cVar != null && cVar.fD != null && cVar.fD.b(d10)) {
                        bt.a(cVar.mContext, d.E(cVar.mContext));
                        break;
                    }
                }
                bt.a(new Runnable() { // from class: com.kwad.components.ad.feed.d.1.1
                    public RunnableC03681() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                        d.fv.Hb();
                    }
                }, null, 500L);
            }
        }

        @Override // com.kwad.sdk.core.f.b
        public final void bw() {
        }
    }

    /* renamed from: com.kwad.components.ad.feed.d$2 */
    public class AnonymousClass2 implements com.kwad.sdk.core.f.a {
        @Override // com.kwad.sdk.core.f.a
        public final void bx() {
        }

        @Override // com.kwad.sdk.core.f.a
        public final void o(String str) {
            if (d.fz != null) {
                for (a aVar : d.fz) {
                    if (aVar != null && aVar.fC != null && aVar.fC.p(str)) {
                        bt.a(aVar.mContext, d.E(aVar.mContext));
                        return;
                    }
                }
            }
        }
    }

    public static class a {
        private b fC;
        private Context mContext;

        public a(b bVar, Context context) {
            this.fC = bVar;
            this.mContext = context;
        }
    }

    public interface b {
        boolean p(String str);
    }

    public static class c {
        private InterfaceC0369d fD;
        private Context mContext;

        public c(InterfaceC0369d interfaceC0369d, Context context) {
            this.fD = interfaceC0369d;
            this.mContext = context;
        }
    }

    /* renamed from: com.kwad.components.ad.feed.d$d */
    public interface InterfaceC0369d {
        boolean b(double d10);
    }

    public static void C(Context context) {
        try {
            com.kwad.sdk.core.f.c cVar = fw;
            if (cVar != null) {
                cVar.bz(context);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void D(Context context) {
        try {
            com.kwad.sdk.core.f.c cVar = fw;
            if (cVar != null) {
                cVar.bA(context);
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static Vibrator E(Context context) {
        if (fx == null) {
            fx = (Vibrator) context.getSystemService("vibrator");
        }
        return fx;
    }

    public static void a(float f10, Context context, InterfaceC0369d interfaceC0369d) {
        if (fv == null) {
            a(f10, context);
        }
        fy.add(new c(interfaceC0369d, context));
    }

    public static synchronized boolean bs() {
        synchronized (d.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - fA <= 500) {
                return false;
            }
            fA = currentTimeMillis;
            return true;
        }
    }

    public static void a(InterfaceC0369d interfaceC0369d) {
        for (c cVar : fy) {
            if (cVar != null && cVar.fD == interfaceC0369d) {
                fy.remove(cVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sShakeItems size " + fy.size());
    }

    private static void a(float f10, Context context) {
        fv = new com.kwad.sdk.core.f.d(f10);
        fy = new CopyOnWriteArrayList();
        fv.a(new com.kwad.sdk.core.f.b() { // from class: com.kwad.components.ad.feed.d.1

            /* renamed from: com.kwad.components.ad.feed.d$1$1 */
            public class RunnableC03681 implements Runnable {
                public RunnableC03681() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                    d.fv.Hb();
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void a(double d10) {
                if (d.fy != null) {
                    Iterator it = d.fy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        c cVar = (c) it.next();
                        if (cVar != null && cVar.fD != null && cVar.fD.b(d10)) {
                            bt.a(cVar.mContext, d.E(cVar.mContext));
                            break;
                        }
                    }
                    bt.a(new Runnable() { // from class: com.kwad.components.ad.feed.d.1.1
                        public RunnableC03681() {
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "onShakeEvent openGate2");
                            d.fv.Hb();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.f.b
            public final void bw() {
            }
        });
        fv.g(f10);
        fv.bz(context);
    }

    public static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context, b bVar) {
        com.kwad.sdk.core.f.c cVar = fw;
        if (cVar == null) {
            a(rotateInfo, context);
        } else {
            cVar.a(rotateInfo);
        }
        fz.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : fz) {
            if (aVar != null && aVar.fC == bVar) {
                fz.remove(aVar);
            }
        }
        com.kwad.sdk.core.d.c.d("KSFeedRotateAndShakeManager", "sRotateItems size " + fz.size());
    }

    private static void a(AdMatrixInfo.RotateInfo rotateInfo, Context context) {
        com.kwad.sdk.core.f.c cVar = new com.kwad.sdk.core.f.c(rotateInfo);
        fw = cVar;
        cVar.a(new com.kwad.sdk.core.f.a() { // from class: com.kwad.components.ad.feed.d.2
            @Override // com.kwad.sdk.core.f.a
            public final void bx() {
            }

            @Override // com.kwad.sdk.core.f.a
            public final void o(String str) {
                if (d.fz != null) {
                    for (a aVar : d.fz) {
                        if (aVar != null && aVar.fC != null && aVar.fC.p(str)) {
                            bt.a(aVar.mContext, d.E(aVar.mContext));
                            return;
                        }
                    }
                }
            }
        });
        fw.bz(context);
    }
}
