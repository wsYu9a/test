package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class m {
    public static void m(j jVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = jVar.mAdTemplate;
        Context context = jVar.mContext;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if ((com.kwad.sdk.core.response.a.a.bv(cb) && (aVar = jVar.oP) != null && aVar.oY()) || com.kwad.components.ad.reward.kwai.b.l(cb) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.ax(cb) || !com.kwad.sdk.core.response.a.a.ak(cb) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        jVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
