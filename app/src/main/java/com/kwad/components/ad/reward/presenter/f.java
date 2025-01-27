package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.g.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends a implements a.InterfaceC0176a {
    private AdTemplate mAdTemplate;

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.mAdTemplate = this.qt.mAdTemplate;
        boolean vV = com.kwad.sdk.core.c.a.vV();
        com.kwad.sdk.core.d.b.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + vV);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !vV) {
            return;
        }
        com.kwad.components.core.g.a.a(sceneImpl, this);
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0176a
    public final void onError(int i2, String str) {
        List<a.InterfaceC0176a> fQ = this.qt.fQ();
        if (fQ != null) {
            Iterator<a.InterfaceC0176a> it = fQ.iterator();
            while (it.hasNext()) {
                it.next().onError(i2, str);
            }
        }
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0176a
    public final void onInnerAdLoad(@Nullable List<com.kwad.components.core.g.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.b.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean aZ = com.kwad.sdk.core.response.a.b.aZ(adTemplate);
        List<a.InterfaceC0176a> fQ = this.qt.fQ();
        if (aZ) {
            com.kwad.sdk.core.c.a.c(com.kwad.sdk.core.response.a.b.aW(adTemplate), com.kwad.sdk.core.response.a.b.aX(adTemplate));
            if (fQ != null) {
                Iterator<a.InterfaceC0176a> it = fQ.iterator();
                while (it.hasNext()) {
                    it.next().onInnerAdLoad(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.g.a.InterfaceC0176a
    public final void onRequestResult(int i2) {
        List<a.InterfaceC0176a> fQ = this.qt.fQ();
        if (fQ != null) {
            Iterator<a.InterfaceC0176a> it = fQ.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i2);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
