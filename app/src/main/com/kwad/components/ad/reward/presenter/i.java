package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class i {
    public static boolean z(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bJ(eb2) && (aVar = gVar.f11691qh) != null && aVar.qW()) || com.kwad.components.ad.reward.a.b.k(eb2) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.gW()) {
            return true;
        }
        return com.kwad.sdk.core.response.b.a.aF(eb2) && com.kwad.sdk.core.response.b.a.at(eb2);
    }
}
