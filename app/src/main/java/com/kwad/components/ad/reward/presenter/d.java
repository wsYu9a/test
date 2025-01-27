package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.k.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes.dex */
public final class d extends a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.ad.reward.presenter.d$1 */
    final class AnonymousClass1 implements m.a {
        final /* synthetic */ com.kwad.components.ad.reward.a.c rU;

        AnonymousClass1(com.kwad.components.ad.reward.a.c cVar) {
            cVar = cVar;
        }

        @Override // com.kwad.components.ad.reward.k.m.a
        public final void hu() {
            cVar.showDialog();
        }
    }

    public d(AdTemplate adTemplate, AdInfo adInfo, ViewGroup viewGroup) {
        this.mAdInfo = adInfo;
        this.mAdTemplate = adTemplate;
        if (com.kwad.components.ad.reward.kwai.b.j(adInfo)) {
            com.kwad.components.ad.reward.a.c cVar = new com.kwad.components.ad.reward.a.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_order_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e((ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(R.id.ksad_reward_order_root)), new m.a() { // from class: com.kwad.components.ad.reward.presenter.d.1
                final /* synthetic */ com.kwad.components.ad.reward.a.c rU;

                AnonymousClass1(com.kwad.components.ad.reward.a.c cVar2) {
                    cVar = cVar2;
                }

                @Override // com.kwad.components.ad.reward.k.m.a
                public final void hu() {
                    cVar.showDialog();
                }
            }));
            return;
        }
        if (com.kwad.sdk.core.response.a.a.ck(adInfo)) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_jinniu_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d((ViewGroup) (viewStub2 != null ? viewStub2.inflate() : viewGroup.findViewById(R.id.ksad_reward_jinniu_root))));
        }
    }
}
