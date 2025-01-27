package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.core.i.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class g extends b implements a.InterfaceC0432a {
    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        boolean Fl = com.kwad.sdk.core.local.a.Fl();
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onBind localCheckResult: " + Fl);
        SceneImpl sceneImpl = this.mAdTemplate.mAdScene;
        if (sceneImpl == null || !Fl) {
            return;
        }
        com.kwad.components.core.i.a.a(sceneImpl, this);
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void e(@Nullable List<com.kwad.components.core.i.c> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.kwad.sdk.core.d.c.d("RewardInnerAdLoadPresenter", "onInnerAdLoad: " + list.size());
        AdTemplate adTemplate = list.get(0).getAdTemplate();
        boolean cC = com.kwad.sdk.core.response.b.b.cC(adTemplate);
        List<a.InterfaceC0432a> gc2 = this.rO.gc();
        if (cC) {
            com.kwad.sdk.core.local.a.e(com.kwad.sdk.core.response.b.b.cz(adTemplate), com.kwad.sdk.core.response.b.b.cA(adTemplate));
            if (gc2 != null) {
                Iterator<a.InterfaceC0432a> it = gc2.iterator();
                while (it.hasNext()) {
                    it.next().e(list);
                }
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void onError(int i10, String str) {
        List<a.InterfaceC0432a> gc2 = this.rO.gc();
        if (gc2 != null) {
            Iterator<a.InterfaceC0432a> it = gc2.iterator();
            while (it.hasNext()) {
                it.next().onError(i10, str);
            }
        }
    }

    @Override // com.kwad.components.core.i.a.InterfaceC0432a
    public final void onRequestResult(int i10) {
        List<a.InterfaceC0432a> gc2 = this.rO.gc();
        if (gc2 != null) {
            Iterator<a.InterfaceC0432a> it = gc2.iterator();
            while (it.hasNext()) {
                it.next().onRequestResult(i10);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
