package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes3.dex */
public final class m implements c {

    /* renamed from: com.kwad.components.core.c.m$1 */
    public class AnonymousClass1 extends j {
        final /* synthetic */ com.kwad.components.core.request.model.a bC;

        /* renamed from: com.kwad.components.core.c.m$1$1 */
        public class RunnableC04191 implements Runnable {
            final /* synthetic */ SceneImpl Lr;
            final /* synthetic */ int Ls;
            final /* synthetic */ com.kwad.components.core.request.model.a bC;
            final /* synthetic */ AdResultData jX;

            /* renamed from: com.kwad.components.core.c.m$1$1$1 */
            public class C04201 implements k {
                public C04201() {
                }

                @Override // com.kwad.components.core.c.k
                public final void nC() {
                    RunnableC04191 runnableC04191 = RunnableC04191.this;
                    com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                }
            }

            public RunnableC04191(SceneImpl sceneImpl, AdResultData adResultData, int i10, com.kwad.components.core.request.model.a aVar) {
                adScene = sceneImpl;
                adResultData = adResultData;
                adNum = i10;
                aVar = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass1.this.a(adScene, adResultData, adNum, new k() { // from class: com.kwad.components.core.c.m.1.1.1
                    public C04201() {
                    }

                    @Override // com.kwad.components.core.c.k
                    public final void nC() {
                        RunnableC04191 runnableC04191 = RunnableC04191.this;
                        com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                    }
                });
            }
        }

        /* renamed from: com.kwad.components.core.c.m$1$2 */
        public class AnonymousClass2 implements Runnable {
            final /* synthetic */ com.kwad.components.core.request.a Lv;
            final /* synthetic */ int Lw;
            final /* synthetic */ String Lx;

            /* renamed from: com.kwad.components.core.c.m$1$2$1 */
            public class C04211 implements k {
                public C04211() {
                }

                @Override // com.kwad.components.core.c.k
                public final void nC() {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bC, i10, str, false);
                }
            }

            public AnonymousClass2(com.kwad.components.core.request.a aVar, int i10, String str) {
                aVar = aVar;
                i10 = i10;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new k() { // from class: com.kwad.components.core.c.m.1.2.1
                    public C04211() {
                    }

                    @Override // com.kwad.components.core.c.k
                    public final void nC() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bC, i10, str, false);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.kwad.components.core.request.model.a aVar, com.kwad.components.core.request.model.a aVar2) {
            super(aVar);
            this.bC = aVar2;
        }

        @Override // com.kwad.components.core.c.j
        public final boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
            AdResultData e10;
            SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
            int adNum = adScene.getAdNum();
            if (adResultData.isAdResultDataEmpty()) {
                GlobalThreadPools.Hp().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.1
                    final /* synthetic */ SceneImpl Lr;
                    final /* synthetic */ int Ls;
                    final /* synthetic */ com.kwad.components.core.request.model.a bC;
                    final /* synthetic */ AdResultData jX;

                    /* renamed from: com.kwad.components.core.c.m$1$1$1 */
                    public class C04201 implements k {
                        public C04201() {
                        }

                        @Override // com.kwad.components.core.c.k
                        public final void nC() {
                            RunnableC04191 runnableC04191 = RunnableC04191.this;
                            com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                        }
                    }

                    public RunnableC04191(SceneImpl adScene2, AdResultData adResultData2, int adNum2, com.kwad.components.core.request.model.a aVar2) {
                        adScene = adScene2;
                        adResultData = adResultData2;
                        adNum = adNum2;
                        aVar = aVar2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(adScene, adResultData, adNum, new k() { // from class: com.kwad.components.core.c.m.1.1.1
                            public C04201() {
                            }

                            @Override // com.kwad.components.core.c.k
                            public final void nC() {
                                RunnableC04191 runnableC04191 = RunnableC04191.this;
                                com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                            }
                        });
                    }
                });
                return true;
            }
            if (adResultData2.isBidding() && (e10 = l.e(aVar2)) != null && !e10.isAdResultDataEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(e10.getProceedTemplateList());
                arrayList.addAll(adResultData2.getProceedTemplateList());
                List<AdTemplate> l10 = m.l(arrayList);
                List<AdTemplate> subList = l10.subList(0, Math.min(adNum2, l10.size()));
                if (subList != null && subList.size() > 0) {
                    com.kwad.components.core.request.model.a.a(aVar2, new AdResultData(adResultData2, adScene2, subList), true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.components.core.c.j, com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public final void onError(@NonNull com.kwad.components.core.request.a aVar, int i10, String str) {
            GlobalThreadPools.Hp().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.2
                final /* synthetic */ com.kwad.components.core.request.a Lv;
                final /* synthetic */ int Lw;
                final /* synthetic */ String Lx;

                /* renamed from: com.kwad.components.core.c.m$1$2$1 */
                public class C04211 implements k {
                    public C04211() {
                    }

                    @Override // com.kwad.components.core.c.k
                    public final void nC() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bC, i10, str, false);
                    }
                }

                public AnonymousClass2(com.kwad.components.core.request.a aVar2, int i102, String str2) {
                    aVar = aVar2;
                    i10 = i102;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new k() { // from class: com.kwad.components.core.c.m.1.2.1
                        public C04211() {
                        }

                        @Override // com.kwad.components.core.c.k
                        public final void nC() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bC, i10, str, false);
                        }
                    });
                }
            });
        }

        @WorkerThread
        public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i10, k kVar) {
            AdResultData e10 = l.e(this.bC);
            if (e10 == null || e10.isAdResultDataEmpty()) {
                if (kVar != null) {
                    kVar.nC();
                    return;
                }
                return;
            }
            List<AdTemplate> l10 = m.l(e10.getProceedTemplateList());
            List<AdTemplate> subList = l10.subList(0, Math.min(i10, l10.size()));
            if (subList.size() > 0) {
                if (adResultData == null) {
                    adResultData = new AdResultData(sceneImpl);
                }
                com.kwad.components.core.request.model.a.a(this.bC, new AdResultData(adResultData, sceneImpl, subList), false);
            }
        }
    }

    public static class a implements Comparator<AdTemplate> {
        private a() {
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int ep = com.kwad.sdk.core.response.b.e.ep(adTemplate2) - com.kwad.sdk.core.response.b.e.ep(adTemplate);
            if (ep != 0) {
                return ep;
            }
            boolean z10 = adTemplate.fromCache;
            if (z10 && adTemplate2.fromCache) {
                return 0;
            }
            return z10 ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static List<AdTemplate> l(List<AdTemplate> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new a((byte) 0));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : list) {
            long el = com.kwad.sdk.core.response.b.e.el(adTemplate);
            if (!hashSet.contains(Long.valueOf(el))) {
                hashSet.add(Long.valueOf(el));
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        n.a(aVar, new AnonymousClass1(aVar, aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkFirst";
    }
}
