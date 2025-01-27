package com.kwad.components.ad.reward.b;

import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.reward.b.b;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bd;

/* loaded from: classes2.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements b.a {
    private AdTemplate mAdTemplate;
    private boolean sE = false;

    /* renamed from: com.kwad.components.ad.reward.b.c$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ int[] sF;

        public AnonymousClass1(int[] iArr) {
            G = iArr;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "targetView x: " + G[0] + ", y: " + G[1]);
            b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, G);
            c.a(c.this, true);
        }
    }

    private static boolean l(AdInfo adInfo) {
        AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(adInfo);
        return (!com.kwad.components.ad.reward.a.b.i(adInfo) || cW == null || cW.isCouponListEmpty()) ? false : true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.mAdTemplate = this.rO.mAdTemplate;
    }

    @Override // com.kwad.components.ad.reward.b.b.a
    public final void he() {
        this.rO.a(1, getContext(), 29, 1);
    }

    public final void showDialog() {
        com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "onBind hasShown : " + this.sE);
        if (this.sE) {
            return;
        }
        AdInfo eb2 = e.eb(this.mAdTemplate);
        ViewGroup viewGroup = (ViewGroup) this.rO.mRootContainer.findViewById(R.id.ksad_reward_order_coupon_list);
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        View view = viewGroup;
        if (childCount > 0) {
            view = viewGroup.getChildAt(0);
        }
        int[] G = com.kwad.sdk.c.a.a.G(view);
        if (!l(eb2) || G == null) {
            return;
        }
        view.post(new bd() { // from class: com.kwad.components.ad.reward.b.c.1
            final /* synthetic */ int[] sF;

            public AnonymousClass1(int[] G2) {
                G = G2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("RewardCouponDialogPresenter", "targetView x: " + G[0] + ", y: " + G[1]);
                b.a(c.this.getActivity(), c.this.mAdTemplate, c.this, G);
                c.a(c.this, true);
            }
        });
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.sE = true;
        return true;
    }
}
