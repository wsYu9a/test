package com.kwad.components.core.b;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class d implements com.kwad.components.core.b.c {
    private static volatile d HI = null;
    private static boolean HJ = true;

    @NonNull
    private SparseArray<com.kwad.components.core.b.c> HH;

    /* renamed from: com.kwad.components.core.b.d$1 */
    static class AnonymousClass1 extends com.kwad.components.core.k.a {
        final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

        /* renamed from: com.kwad.components.core.b.d$1$1 */
        final class C01641 implements com.kwad.sdk.e.c<com.kwad.components.core.n.a> {
            C01641() {
            }

            @Override // com.kwad.sdk.e.c
            /* renamed from: md */
            public com.kwad.components.core.n.a get() {
                if (aVar.getAdStyle() == 4) {
                    aVar.Os = SplashPreloadManager.rV().rW();
                }
                return new com.kwad.components.core.n.a(aVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.kwad.components.core.n.kwai.b bVar, com.kwad.components.core.n.kwai.a aVar) {
            super(bVar);
            aVar = aVar;
        }

        @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.m
        @NonNull
        /* renamed from: aj */
        public final AdResultData parseData(String str) {
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(KSLoggerReporter.bv(aVar.getAdStyle()), "requestFinish").report();
            return AdResultData.createFromResponseJson(str, aVar.JW.Ow);
        }

        @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: mc */
        public final com.kwad.components.core.n.a createRequest() {
            return d.a(new com.kwad.sdk.e.c<com.kwad.components.core.n.a>() { // from class: com.kwad.components.core.b.d.1.1
                C01641() {
                }

                @Override // com.kwad.sdk.e.c
                /* renamed from: md */
                public com.kwad.components.core.n.a get() {
                    if (aVar.getAdStyle() == 4) {
                        aVar.Os = SplashPreloadManager.rV().rW();
                    }
                    return new com.kwad.components.core.n.a(aVar);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.core.b.d$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

        /* renamed from: com.kwad.components.core.b.d$2$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.kwad.components.core.b.e HM;

            AnonymousClass1(com.kwad.components.core.b.e eVar) {
                n = eVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.b.b.b(n);
            }
        }

        AnonymousClass2(com.kwad.components.core.n.kwai.a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.components.core.b.e n = com.kwad.components.core.b.e.n(aVar.getPosId());
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.b.d.2.1
                final /* synthetic */ com.kwad.components.core.b.e HM;

                AnonymousClass1(com.kwad.components.core.b.e n2) {
                    n = n2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.core.b.b.b(n);
                }
            });
            com.kwad.components.core.b.c mb = (d.a(d.this) || !(n2.isDefault() || n2.isEnable())) ? d.this.mb() : (com.kwad.components.core.b.c) d.this.HH.get(n2.mg());
            if (mb == null) {
                mb = (com.kwad.components.core.b.c) d.this.HH.get(1);
            }
            mb.c(aVar);
        }
    }

    static class a implements Comparator<AdTemplate> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int cq = com.kwad.sdk.core.response.a.d.cq(adTemplate2) - com.kwad.sdk.core.response.a.d.cq(adTemplate);
            if (cq != 0) {
                return cq;
            }
            boolean z = adTemplate.fromCache;
            if (z && adTemplate2.fromCache) {
                return 0;
            }
            return z ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }
    }

    static class b extends p<com.kwad.components.core.n.a, AdResultData> {
        private com.kwad.components.core.n.kwai.a HO;

        /* renamed from: com.kwad.components.core.b.d$b$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ AdResultData HP;

            AnonymousClass1(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b bVar = b.this;
                b.c(adResultData);
            }
        }

        public b(com.kwad.components.core.n.kwai.a aVar) {
            this.HO = aVar;
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.n.a aVar, @NonNull AdResultData adResultData) {
            super.onSuccess(aVar, adResultData);
            GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.b.1
                final /* synthetic */ AdResultData HP;

                AnonymousClass1(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    b bVar = b.this;
                    b.c(adResultData);
                }
            });
            if (a(this.HO, adResultData2)) {
                return;
            }
            com.kwad.components.core.n.kwai.a.a(this.HO, adResultData2, false);
        }

        @WorkerThread
        public static void c(AdResultData adResultData) {
            List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
            com.kwad.components.core.b.a lW = com.kwad.components.core.b.a.lW();
            if (lW == null || proceedTemplateList.size() <= 0) {
                return;
            }
            AdTemplate adTemplate = proceedTemplateList.get(0);
            com.kwad.components.core.b.e n = com.kwad.components.core.b.e.n(adResultData.getPosId());
            lW.lX();
            lW.f(g.a(n, adResultData));
            lW.a(com.kwad.components.core.b.e.E(adTemplate));
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.n.a aVar, int i2, String str) {
            super.onError(aVar, i2, str);
            com.kwad.components.core.n.kwai.a.a(this.HO, i2, str, false);
        }

        protected boolean a(com.kwad.components.core.n.kwai.a aVar, AdResultData adResultData) {
            return false;
        }
    }

    interface c {
        void me();
    }

    /* renamed from: com.kwad.components.core.b.d$d */
    public static class C0165d implements com.kwad.components.core.b.c {
        @Override // com.kwad.components.core.b.c
        public final void c(com.kwad.components.core.n.kwai.a aVar) {
            d.a(aVar, new b(aVar));
        }
    }

    public static class e implements com.kwad.components.core.b.c {

        /* renamed from: com.kwad.components.core.b.d$e$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

            AnonymousClass1(com.kwad.components.core.n.kwai.a aVar) {
                aVar = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AdResultData d2 = d.d(aVar);
                if (d2 != null && !d2.isAdResultDataEmpty()) {
                    com.kwad.components.core.n.kwai.a.a(aVar, d2, true);
                } else {
                    com.kwad.components.core.n.kwai.a aVar = aVar;
                    d.a(aVar, new b(aVar));
                }
            }
        }

        @Override // com.kwad.components.core.b.c
        public final void c(com.kwad.components.core.n.kwai.a aVar) {
            GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.e.1
                final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

                AnonymousClass1(com.kwad.components.core.n.kwai.a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AdResultData d2 = d.d(aVar);
                    if (d2 != null && !d2.isAdResultDataEmpty()) {
                        com.kwad.components.core.n.kwai.a.a(aVar, d2, true);
                    } else {
                        com.kwad.components.core.n.kwai.a aVar2 = aVar;
                        d.a(aVar2, new b(aVar2));
                    }
                }
            });
        }
    }

    public static class f implements com.kwad.components.core.b.c {

        /* renamed from: com.kwad.components.core.b.d$f$1 */
        final class AnonymousClass1 extends b {
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

            /* renamed from: com.kwad.components.core.b.d$f$1$1 */
            final class RunnableC01661 implements Runnable {
                final /* synthetic */ SceneImpl HT;
                final /* synthetic */ int HU;
                final /* synthetic */ com.kwad.components.core.n.kwai.a bN;
                final /* synthetic */ AdResultData iv;

                /* renamed from: com.kwad.components.core.b.d$f$1$1$1 */
                final class C01671 implements c {
                    C01671() {
                    }

                    @Override // com.kwad.components.core.b.d.c
                    public final void me() {
                        RunnableC01661 runnableC01661 = RunnableC01661.this;
                        com.kwad.components.core.n.kwai.a.a(aVar, adResultData, false);
                    }
                }

                RunnableC01661(SceneImpl sceneImpl, AdResultData adResultData, int i2, com.kwad.components.core.n.kwai.a aVar) {
                    adScene = sceneImpl;
                    adResultData = adResultData;
                    adNum = i2;
                    aVar = aVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.a(adScene, adResultData, adNum, new c() { // from class: com.kwad.components.core.b.d.f.1.1.1
                        C01671() {
                        }

                        @Override // com.kwad.components.core.b.d.c
                        public final void me() {
                            RunnableC01661 runnableC01661 = RunnableC01661.this;
                            com.kwad.components.core.n.kwai.a.a(aVar, adResultData, false);
                        }
                    });
                }
            }

            /* renamed from: com.kwad.components.core.b.d$f$1$2 */
            final class AnonymousClass2 implements Runnable {
                final /* synthetic */ com.kwad.components.core.n.a HX;
                final /* synthetic */ int HY;
                final /* synthetic */ String HZ;

                /* renamed from: com.kwad.components.core.b.d$f$1$2$1 */
                final class C01681 implements c {
                    C01681() {
                    }

                    @Override // com.kwad.components.core.b.d.c
                    public final void me() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        com.kwad.components.core.n.kwai.a.a(AnonymousClass1.this.bN, i2, str, false);
                    }
                }

                AnonymousClass2(com.kwad.components.core.n.a aVar, int i2, String str) {
                    aVar = aVar;
                    i2 = i2;
                    str = str;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new c() { // from class: com.kwad.components.core.b.d.f.1.2.1
                        C01681() {
                        }

                        @Override // com.kwad.components.core.b.d.c
                        public final void me() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.kwad.components.core.n.kwai.a.a(AnonymousClass1.this.bN, i2, str, false);
                        }
                    });
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(com.kwad.components.core.n.kwai.a aVar, com.kwad.components.core.n.kwai.a aVar2) {
                super(aVar);
                this.bN = aVar2;
            }

            @WorkerThread
            public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i2, c cVar) {
                AdResultData d2 = d.d(this.bN);
                if (d2 == null || d2.isAdResultDataEmpty()) {
                    if (cVar != null) {
                        cVar.me();
                        return;
                    }
                    return;
                }
                List a2 = d.a((List<AdTemplate>[]) new List[]{d2.getProceedTemplateList()});
                List subList = a2.subList(0, Math.min(i2, a2.size()));
                if (subList.size() > 0) {
                    if (adResultData == null) {
                        adResultData = new AdResultData(sceneImpl);
                    }
                    com.kwad.components.core.n.kwai.a.a(this.bN, new AdResultData(adResultData, sceneImpl, subList), false);
                }
            }

            @Override // com.kwad.components.core.b.d.b, com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public final void onError(@NonNull com.kwad.components.core.n.a aVar, int i2, String str) {
                GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.f.1.2
                    final /* synthetic */ com.kwad.components.core.n.a HX;
                    final /* synthetic */ int HY;
                    final /* synthetic */ String HZ;

                    /* renamed from: com.kwad.components.core.b.d$f$1$2$1 */
                    final class C01681 implements c {
                        C01681() {
                        }

                        @Override // com.kwad.components.core.b.d.c
                        public final void me() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.kwad.components.core.n.kwai.a.a(AnonymousClass1.this.bN, i2, str, false);
                        }
                    }

                    AnonymousClass2(com.kwad.components.core.n.a aVar2, int i22, String str2) {
                        aVar = aVar2;
                        i2 = i22;
                        str = str2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new c() { // from class: com.kwad.components.core.b.d.f.1.2.1
                            C01681() {
                            }

                            @Override // com.kwad.components.core.b.d.c
                            public final void me() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.kwad.components.core.n.kwai.a.a(AnonymousClass1.this.bN, i2, str, false);
                            }
                        });
                    }
                });
            }

            @Override // com.kwad.components.core.b.d.b
            protected final boolean a(com.kwad.components.core.n.kwai.a aVar, AdResultData adResultData) {
                AdResultData d2;
                SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
                int adNum = adScene.getAdNum();
                if (adResultData.isAdResultDataEmpty()) {
                    GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.f.1.1
                        final /* synthetic */ SceneImpl HT;
                        final /* synthetic */ int HU;
                        final /* synthetic */ com.kwad.components.core.n.kwai.a bN;
                        final /* synthetic */ AdResultData iv;

                        /* renamed from: com.kwad.components.core.b.d$f$1$1$1 */
                        final class C01671 implements c {
                            C01671() {
                            }

                            @Override // com.kwad.components.core.b.d.c
                            public final void me() {
                                RunnableC01661 runnableC01661 = RunnableC01661.this;
                                com.kwad.components.core.n.kwai.a.a(aVar, adResultData, false);
                            }
                        }

                        RunnableC01661(SceneImpl adScene2, AdResultData adResultData2, int adNum2, com.kwad.components.core.n.kwai.a aVar2) {
                            adScene = adScene2;
                            adResultData = adResultData2;
                            adNum = adNum2;
                            aVar = aVar2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.a(adScene, adResultData, adNum, new c() { // from class: com.kwad.components.core.b.d.f.1.1.1
                                C01671() {
                                }

                                @Override // com.kwad.components.core.b.d.c
                                public final void me() {
                                    RunnableC01661 runnableC01661 = RunnableC01661.this;
                                    com.kwad.components.core.n.kwai.a.a(aVar, adResultData, false);
                                }
                            });
                        }
                    });
                    return true;
                }
                if (adResultData2.isBidding() && (d2 = d.d(aVar2)) != null && !d2.isAdResultDataEmpty()) {
                    List a2 = d.a((List<AdTemplate>[]) new List[]{d2.getProceedTemplateList(), adResultData2.getProceedTemplateList()});
                    List subList = a2.subList(0, Math.min(adNum2, a2.size()));
                    if (subList != null && subList.size() > 0) {
                        com.kwad.components.core.n.kwai.a.a(aVar2, new AdResultData(adResultData2, adScene2, subList), true);
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // com.kwad.components.core.b.c
        public final void c(com.kwad.components.core.n.kwai.a aVar) {
            d.a(aVar, new AnonymousClass1(aVar, aVar));
        }
    }

    private d() {
        SparseArray<com.kwad.components.core.b.c> sparseArray = new SparseArray<>();
        this.HH = sparseArray;
        sparseArray.append(1, new f());
        this.HH.append(2, new e());
        this.HH.append(0, new C0165d());
    }

    public static <T extends com.kwad.components.core.n.a> T a(com.kwad.sdk.e.c<T> cVar) {
        return cVar.get();
    }

    public static List<AdTemplate> a(List<AdTemplate>... listArr) {
        if (listArr == null) {
            return null;
        }
        ArrayList<AdTemplate> arrayList = new ArrayList();
        for (List<AdTemplate> list : listArr) {
            arrayList.addAll(list);
        }
        Collections.sort(arrayList, new a((byte) 0));
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : arrayList) {
            long cl = com.kwad.sdk.core.response.a.d.cl(adTemplate);
            if (!hashSet.contains(Long.valueOf(cl))) {
                hashSet.add(Long.valueOf(cl));
                arrayList2.add(adTemplate);
            }
        }
        return arrayList2;
    }

    public static void a(com.kwad.components.core.n.kwai.a aVar, @NonNull p<com.kwad.components.core.n.a, AdResultData> pVar) {
        new com.kwad.components.core.k.a(aVar.JW) { // from class: com.kwad.components.core.b.d.1
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

            /* renamed from: com.kwad.components.core.b.d$1$1 */
            final class C01641 implements com.kwad.sdk.e.c<com.kwad.components.core.n.a> {
                C01641() {
                }

                @Override // com.kwad.sdk.e.c
                /* renamed from: md */
                public com.kwad.components.core.n.a get() {
                    if (aVar.getAdStyle() == 4) {
                        aVar.Os = SplashPreloadManager.rV().rW();
                    }
                    return new com.kwad.components.core.n.a(aVar);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(com.kwad.components.core.n.kwai.b bVar, com.kwad.components.core.n.kwai.a aVar2) {
                super(bVar);
                aVar = aVar2;
            }

            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.m
            @NonNull
            /* renamed from: aj */
            public final AdResultData parseData(String str) {
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(KSLoggerReporter.bv(aVar.getAdStyle()), "requestFinish").report();
                return AdResultData.createFromResponseJson(str, aVar.JW.Ow);
            }

            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mc */
            public final com.kwad.components.core.n.a createRequest() {
                return d.a(new com.kwad.sdk.e.c<com.kwad.components.core.n.a>() { // from class: com.kwad.components.core.b.d.1.1
                    C01641() {
                    }

                    @Override // com.kwad.sdk.e.c
                    /* renamed from: md */
                    public com.kwad.components.core.n.a get() {
                        if (aVar.getAdStyle() == 4) {
                            aVar.Os = SplashPreloadManager.rV().rW();
                        }
                        return new com.kwad.components.core.n.a(aVar);
                    }
                });
            }
        }.request(pVar);
    }

    static /* synthetic */ boolean a(d dVar) {
        return ma();
    }

    @Nullable
    @WorkerThread
    public static AdResultData d(com.kwad.components.core.n.kwai.a aVar) {
        com.kwad.components.core.b.a lW = com.kwad.components.core.b.a.lW();
        if (lW == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<g> b2 = lW.b(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, com.kwad.components.core.b.e.n(aVar.getPosId()).mh());
        if (com.kwad.sdk.core.config.d.uR()) {
            g(b2);
        }
        if (b2 == null || b2.size() <= 0) {
            return null;
        }
        Collections.sort(b2);
        return g.h(b2.subList(0, Math.min(b2.size(), adNum)));
    }

    private static void g(List<g> list) {
        if (list == null) {
            return;
        }
        Iterator<g> it = list.iterator();
        while (it.hasNext()) {
            g next = it.next();
            if (com.kwad.components.core.b.f.mk().a(next)) {
                com.kwad.sdk.core.d.b.d("AdCacheFetcherHolder", "filterByMemCached contain: " + next.mr());
                it.remove();
            }
        }
    }

    public static d lZ() {
        if (HI == null) {
            synchronized (d.class) {
                if (HI == null) {
                    HI = new d();
                }
            }
        }
        return HI;
    }

    private static boolean ma() {
        if (!HJ) {
            return false;
        }
        try {
            Class.forName("com.kwad.devTools.PosConfigFetcher");
            HJ = true;
        } catch (ClassNotFoundException unused) {
            HJ = false;
        }
        return HJ;
    }

    public com.kwad.components.core.b.c mb() {
        return this.HH.get(0);
    }

    @Override // com.kwad.components.core.b.c
    public final void c(com.kwad.components.core.n.kwai.a aVar) {
        GlobalThreadPools.xR().submit(new Runnable() { // from class: com.kwad.components.core.b.d.2
            final /* synthetic */ com.kwad.components.core.n.kwai.a bN;

            /* renamed from: com.kwad.components.core.b.d$2$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ com.kwad.components.core.b.e HM;

                AnonymousClass1(com.kwad.components.core.b.e n2) {
                    n = n2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.components.core.b.b.b(n);
                }
            }

            AnonymousClass2(com.kwad.components.core.n.kwai.a aVar2) {
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.components.core.b.e n2 = com.kwad.components.core.b.e.n(aVar.getPosId());
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.b.d.2.1
                    final /* synthetic */ com.kwad.components.core.b.e HM;

                    AnonymousClass1(com.kwad.components.core.b.e n22) {
                        n = n22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.components.core.b.b.b(n);
                    }
                });
                com.kwad.components.core.b.c mb = (d.a(d.this) || !(n22.isDefault() || n22.isEnable())) ? d.this.mb() : (com.kwad.components.core.b.c) d.this.HH.get(n22.mg());
                if (mb == null) {
                    mb = (com.kwad.components.core.b.c) d.this.HH.get(1);
                }
                mb.c(aVar);
            }
        });
    }
}
