package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class h {
    public static boolean y(com.kwad.components.ad.reward.j jVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = jVar.mAdTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if ((com.kwad.sdk.core.response.a.a.bv(cb) && (aVar = jVar.oP) != null && aVar.oY()) || com.kwad.components.ad.reward.kwai.b.l(cb) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.kwai.b.gI()) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.ax(cb) && com.kwad.sdk.core.response.a.a.ak(cb);
    }
}
