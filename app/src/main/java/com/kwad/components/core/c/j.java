package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bd;
import java.util.List;

/* loaded from: classes3.dex */
public class j extends o<com.kwad.components.core.request.a, AdResultData> {
    private final com.kwad.components.core.request.model.a Lm;

    /* renamed from: com.kwad.components.core.c.j$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ AdResultData Ln;

        public AnonymousClass1(AdResultData adResultData) {
            adResultData = adResultData;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            j jVar = j.this;
            j.k(adResultData);
        }
    }

    public j(com.kwad.components.core.request.model.a aVar) {
        this.Lm = aVar;
    }

    @WorkerThread
    public static void k(AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        a nj2 = a.nj();
        if (nj2 == null || proceedTemplateList.size() <= 0) {
            return;
        }
        AdTemplate adTemplate = proceedTemplateList.get(0);
        e s10 = e.s(adResultData.getPosId());
        nj2.nk();
        nj2.i(h.a(s10, adResultData));
        nj2.a(e.an(adTemplate));
    }

    public boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
        return false;
    }

    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a */
    public void onSuccess(@NonNull com.kwad.components.core.request.a aVar, @NonNull AdResultData adResultData) {
        super.onSuccess(aVar, adResultData);
        GlobalThreadPools.Hp().submit(new bd() { // from class: com.kwad.components.core.c.j.1
            final /* synthetic */ AdResultData Ln;

            public AnonymousClass1(AdResultData adResultData2) {
                adResultData = adResultData2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                j jVar = j.this;
                j.k(adResultData);
            }
        });
        if (a(this.Lm, adResultData2)) {
            return;
        }
        com.kwad.components.core.request.model.a.a(this.Lm, adResultData2, false);
    }

    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a */
    public void onError(@NonNull com.kwad.components.core.request.a aVar, int i10, String str) {
        super.onError(aVar, i10, str);
        com.kwad.components.core.request.model.a.a(this.Lm, i10, str, false);
    }
}
