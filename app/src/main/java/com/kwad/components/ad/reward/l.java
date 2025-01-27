package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class l {
    public static void j(g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if ((com.kwad.sdk.core.response.b.a.bJ(eb2) && (aVar = gVar.f11691qh) != null && aVar.qW()) || com.kwad.components.ad.reward.a.b.k(eb2) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.b.a.aF(eb2) || !com.kwad.sdk.core.response.b.a.at(eb2) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
