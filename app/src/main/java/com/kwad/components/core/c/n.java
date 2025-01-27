package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: classes3.dex */
public final class n implements c {

    /* renamed from: com.kwad.components.core.c.n$1 */
    public class AnonymousClass1 extends com.kwad.components.core.m.a {
        final /* synthetic */ com.kwad.components.core.request.model.a bC;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ImpInfo impInfo, com.kwad.components.core.request.model.a aVar) {
            super(impInfo);
            aVar = aVar;
        }

        @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.l
        @NonNull
        /* renamed from: ab */
        public final AdResultData parseData(String str) {
            AdResultData createFromResponseJson = AdResultData.createFromResponseJson(str, aVar.Oy.adScene);
            createFromResponseJson.setAdSource(PointCategory.NETWORK);
            return createFromResponseJson;
        }

        @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: nD */
        public final com.kwad.components.core.request.a createRequest() {
            if (aVar.getAdStyle() == 4) {
                com.kwad.components.ad.b.i iVar = (com.kwad.components.ad.b.i) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.i.class);
                aVar.Ud = iVar.R();
            }
            return new com.kwad.components.core.request.a(aVar);
        }
    }

    public static void a(com.kwad.components.core.request.model.a aVar, @NonNull j jVar) {
        new com.kwad.components.core.m.a(aVar.Oy) { // from class: com.kwad.components.core.c.n.1
            final /* synthetic */ com.kwad.components.core.request.model.a bC;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ImpInfo impInfo, com.kwad.components.core.request.model.a aVar2) {
                super(impInfo);
                aVar = aVar2;
            }

            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: ab */
            public final AdResultData parseData(String str) {
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(str, aVar.Oy.adScene);
                createFromResponseJson.setAdSource(PointCategory.NETWORK);
                return createFromResponseJson;
            }

            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: nD */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    com.kwad.components.ad.b.i iVar = (com.kwad.components.ad.b.i) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.i.class);
                    aVar.Ud = iVar.R();
                }
                return new com.kwad.components.core.request.a(aVar);
            }
        }.request(jVar);
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new j(aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }
}
