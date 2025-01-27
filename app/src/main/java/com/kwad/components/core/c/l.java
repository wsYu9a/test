package com.kwad.components.core.c;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bd;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class l implements c {

    /* renamed from: com.kwad.components.core.c.l$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ com.kwad.components.core.request.model.a bC;

        public AnonymousClass1(com.kwad.components.core.request.model.a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            AdResultData e10 = l.e(aVar);
            if (e10 != null && !e10.isAdResultDataEmpty()) {
                com.kwad.components.core.request.model.a.a(aVar, e10, true);
            } else {
                com.kwad.components.core.request.model.a aVar = aVar;
                n.a(aVar, new j(aVar));
            }
        }
    }

    @Nullable
    @WorkerThread
    public static AdResultData e(com.kwad.components.core.request.model.a aVar) {
        a nj2 = a.nj();
        if (nj2 == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> a10 = nj2.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.s(aVar.getPosId()).nq());
        if (com.kwad.sdk.core.config.d.DZ()) {
            k(a10);
        }
        if (a10 == null || a10.size() <= 0) {
            return null;
        }
        Collections.sort(a10);
        return h.j(a10.subList(0, Math.min(a10.size(), adNum)));
    }

    private static void k(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (g.nu().a(next)) {
                com.kwad.sdk.core.d.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.nB());
                it.remove();
            }
        }
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Hp().submit(new bd() { // from class: com.kwad.components.core.c.l.1
            final /* synthetic */ com.kwad.components.core.request.model.a bC;

            public AnonymousClass1(com.kwad.components.core.request.model.a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                AdResultData e10 = l.e(aVar);
                if (e10 != null && !e10.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, e10, true);
                } else {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    n.a(aVar2, new j(aVar2));
                }
            }
        });
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }
}
