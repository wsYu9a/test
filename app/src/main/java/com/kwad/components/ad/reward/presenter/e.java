package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.components.ad.reward.n.n;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class e extends b {
    private AdInfo mAdInfo;

    /* renamed from: com.kwad.components.ad.reward.presenter.e$1 */
    public class AnonymousClass1 implements n.a {
        final /* synthetic */ com.kwad.components.ad.reward.b.c tH;

        public AnonymousClass1(com.kwad.components.ad.reward.b.c cVar) {
            cVar = cVar;
        }

        @Override // com.kwad.components.ad.reward.n.n.a
        public final void hO() {
            cVar.showDialog();
        }
    }

    public e(AdInfo adInfo, ViewGroup viewGroup) {
        this.mAdInfo = adInfo;
        if (com.kwad.components.ad.reward.a.b.i(adInfo)) {
            com.kwad.components.ad.reward.b.c cVar = new com.kwad.components.ad.reward.b.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_order_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e(viewStub != null ? (ViewGroup) viewStub.inflate() : (ViewGroup) viewGroup.findViewById(R.id.ksad_reward_order_root), new n.a() { // from class: com.kwad.components.ad.reward.presenter.e.1
                final /* synthetic */ com.kwad.components.ad.reward.b.c tH;

                public AnonymousClass1(com.kwad.components.ad.reward.b.c cVar2) {
                    cVar = cVar2;
                }

                @Override // com.kwad.components.ad.reward.n.n.a
                public final void hO() {
                    cVar.showDialog();
                }
            }));
            return;
        }
        if (com.kwad.sdk.core.response.b.a.ch(adInfo) == 1) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_jinniu_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d(viewStub2 != null ? (ViewGroup) viewStub2.inflate() : (ViewGroup) viewGroup.findViewById(R.id.ksad_reward_jinniu_root)));
        }
    }
}
