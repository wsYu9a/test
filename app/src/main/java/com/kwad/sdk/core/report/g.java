package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class g extends b<n, f> {
    private static volatile boolean aBL = false;
    private static volatile g aBM;
    private static r<n, f> aBN;

    /* renamed from: com.kwad.sdk.core.report.g$1 */
    public class AnonymousClass1 implements k<n> {
        final /* synthetic */ n aBO;

        public AnonymousClass1(n nVar) {
            nVar = nVar;
        }

        @Override // com.kwad.sdk.core.report.k
        /* renamed from: Gq */
        public n Gl() {
            return nVar.Gs();
        }
    }

    /* renamed from: com.kwad.sdk.core.report.g$2 */
    public class AnonymousClass2 implements k<n> {
        final /* synthetic */ n aBO;

        public AnonymousClass2(n nVar) {
            nVar = nVar;
        }

        @Override // com.kwad.sdk.core.report.k
        /* renamed from: Gq */
        public n Gl() {
            return nVar.Gs();
        }
    }

    private g() {
    }

    private static g Gp() {
        if (aBM == null) {
            synchronized (g.class) {
                try {
                    if (aBM == null) {
                        aBM = new g();
                    }
                } finally {
                }
            }
        }
        aBM.checkInit();
        return aBM;
    }

    private static boolean ab(long j10) {
        s sVar = (s) ServiceProvider.get(s.class);
        return sVar != null && sVar.ab(j10);
    }

    private void b(n nVar, boolean z10) {
        if (nVar == null || !aBL) {
            return;
        }
        if (z10 || ab(nVar.actionType)) {
            aBM.b(new k<n>() { // from class: com.kwad.sdk.core.report.g.1
                final /* synthetic */ n aBO;

                public AnonymousClass1(n nVar2) {
                    nVar = nVar2;
                }

                @Override // com.kwad.sdk.core.report.k
                /* renamed from: Gq */
                public n Gl() {
                    return nVar.Gs();
                }
            });
        } else {
            aBM.a(new k<n>() { // from class: com.kwad.sdk.core.report.g.2
                final /* synthetic */ n aBO;

                public AnonymousClass2(n nVar2) {
                    nVar = nVar2;
                }

                @Override // com.kwad.sdk.core.report.k
                /* renamed from: Gq */
                public n Gl() {
                    return nVar.Gs();
                }
            });
        }
    }

    private synchronized void checkInit() {
        try {
            if (aBL) {
                return;
            }
            com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
            if (fVar == null) {
                return;
            }
            com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
            if (hVar == null) {
                return;
            }
            Context context = fVar.getContext();
            if (context == null) {
                return;
            }
            int aH = hVar.aH(context);
            j(context, aH);
            t.init(context);
            t.Gy();
            com.kwad.sdk.core.d.c.d("BatchReporter", "cache type = " + aH);
            if (aH == 2) {
                a(q.bw(context));
            }
            aBL = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.kwad.sdk.core.report.b
    /* renamed from: y */
    public f w(List<n> list) {
        r<n, f> rVar = aBN;
        if (rVar != null) {
            return rVar.Gx();
        }
        String z10 = z(list);
        return !TextUtils.isEmpty(z10) ? new f(z10) : new f(list);
    }

    private static String z(List<n> list) {
        if (list.get(0) == null || TextUtils.isEmpty(list.get(0).aDb)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(",\"actionList\":[");
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next().aDb);
            sb2.append(',');
        }
        int length = sb2.length();
        sb2.replace(length - 1, length, "]");
        return sb2.toString();
    }

    /* renamed from: a */
    public static void a2(@NonNull n nVar) {
        a(nVar, false);
    }

    public static void a(@NonNull n nVar, boolean z10) {
        Gp().b(nVar, z10);
    }

    @Override // com.kwad.sdk.core.report.b
    public final Runnable a(Context context, l<n> lVar, AtomicInteger atomicInteger) {
        u<n, f> Gv;
        r<n, f> rVar = aBN;
        return (rVar == null || (Gv = rVar.Gv()) == null) ? super.a(context, lVar, atomicInteger) : Gv;
    }

    @Override // com.kwad.sdk.core.report.b
    /* renamed from: b */
    public f a(n nVar) {
        r<n, f> rVar = aBN;
        if (rVar != null) {
            return rVar.Gw();
        }
        return (f) super.a((g) nVar);
    }
}
