package com.kwad.components.core.c;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public class d {
    private static volatile d KT = null;
    private static boolean KU = true;

    @NonNull
    private final SparseArray<c> KS;

    /* renamed from: com.kwad.components.core.c.d$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ com.kwad.components.core.request.model.a bC;

        /* renamed from: com.kwad.components.core.c.d$1$1 */
        public class C04181 extends bd {
            final /* synthetic */ e KW;

            public C04181(e eVar) {
                s10 = eVar;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.b(s10);
            }
        }

        public AnonymousClass1(com.kwad.components.core.request.model.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            e s10 = e.s(aVar.getPosId());
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.c.d.1.1
                final /* synthetic */ e KW;

                public C04181(e s102) {
                    s10 = s102;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    b.b(s10);
                }
            });
            c cVar = (d.a(d.this) || !(s102.isDefault() || s102.isEnable())) ? (c) d.this.KS.get(0) : (c) d.this.KS.get(s102.np());
            if (cVar == null) {
                cVar = (c) d.this.KS.get(1);
            }
            com.kwad.components.core.request.i ry = aVar.ry();
            if (ry != null) {
                cVar.getName();
                ry.ag();
            }
            d dVar = d.this;
            d.a(aVar, cVar);
            com.kwad.components.core.request.model.a aVar = aVar;
            com.kwad.sdk.commercial.d.d.b(aVar.Oy.adScene, aVar.rz());
            cVar.d(aVar);
        }
    }

    private d() {
        SparseArray<c> sparseArray = new SparseArray<>();
        this.KS = sparseArray;
        sparseArray.append(0, new n());
        sparseArray.append(1, new m());
        sparseArray.append(2, new l());
    }

    public static d nm() {
        if (KT == null) {
            synchronized (d.class) {
                try {
                    if (KT == null) {
                        KT = new d();
                    }
                } finally {
                }
            }
        }
        return KT;
    }

    private static boolean nn() {
        if (!KU) {
            return false;
        }
        try {
        } catch (ClassNotFoundException unused) {
            KU = false;
        }
        if (com.kwad.sdk.components.g.db("KEY_ENABLE_FORCE_ENABLE_AD_CACHE")) {
            return false;
        }
        Class.forName("com.kwad.devTools.PosConfigFetcher");
        KU = true;
        return KU;
    }

    public final void d(com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Hp().submit(new bd() { // from class: com.kwad.components.core.c.d.1
            final /* synthetic */ com.kwad.components.core.request.model.a bC;

            /* renamed from: com.kwad.components.core.c.d$1$1 */
            public class C04181 extends bd {
                final /* synthetic */ e KW;

                public C04181(e s102) {
                    s10 = s102;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    b.b(s10);
                }
            }

            public AnonymousClass1(com.kwad.components.core.request.model.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                e s102 = e.s(aVar.getPosId());
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.c.d.1.1
                    final /* synthetic */ e KW;

                    public C04181(e s1022) {
                        s10 = s1022;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        b.b(s10);
                    }
                });
                c cVar = (d.a(d.this) || !(s1022.isDefault() || s1022.isEnable())) ? (c) d.this.KS.get(0) : (c) d.this.KS.get(s1022.np());
                if (cVar == null) {
                    cVar = (c) d.this.KS.get(1);
                }
                com.kwad.components.core.request.i ry = aVar.ry();
                if (ry != null) {
                    cVar.getName();
                    ry.ag();
                }
                d dVar = d.this;
                d.a(aVar, cVar);
                com.kwad.components.core.request.model.a aVar2 = aVar;
                com.kwad.sdk.commercial.d.d.b(aVar2.Oy.adScene, aVar2.rz());
                cVar.d(aVar);
            }
        });
    }

    public static /* synthetic */ boolean a(d dVar) {
        return nn();
    }

    public static void a(com.kwad.components.core.request.model.a aVar, c cVar) {
        String name = cVar.getName();
        name.hashCode();
        if (name.equals("StrategyNetworkFirst")) {
            aVar.az("network_first");
        } else if (!name.equals("StrategyLocalCacheFirst")) {
            aVar.az("network_only");
        } else {
            aVar.az("cache_first");
        }
    }
}
