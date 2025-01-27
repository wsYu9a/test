package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.k.h;
import com.kwad.components.ad.reward.k.v;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ai;

/* loaded from: classes2.dex */
public final class d extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.ad.reward.k.b {
    private ViewGroup gv;
    private KsLogoView sh;
    private h uq;

    public d(ViewGroup viewGroup) {
        this.gv = viewGroup;
    }

    public static FrameLayout.LayoutParams a(Context context, AdInfo adInfo, KsLogoView ksLogoView, int i2, boolean z) {
        FrameLayout.LayoutParams layoutParams = null;
        if (ksLogoView != null && context != null) {
            ViewGroup.LayoutParams layoutParams2 = ksLogoView.getLayoutParams();
            if (!(layoutParams2 instanceof FrameLayout.LayoutParams)) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams2;
            layoutParams = a(layoutParams3);
            if (z) {
                ksLogoView.setVisibility(0);
            }
            boolean z2 = (!ai.DL() && (com.kwad.components.ad.reward.kwai.b.j(adInfo) || com.kwad.sdk.core.response.a.a.ck(adInfo))) || (ai.DL() && com.kwad.sdk.core.response.a.a.cj(adInfo));
            layoutParams3.gravity = 85;
            if (z2) {
                i2 = R.dimen.ksad_reward_follow_card_margin;
            }
            layoutParams3.bottomMargin = context.getResources().getDimensionPixelOffset(i2);
            layoutParams3.rightMargin = context.getResources().getDimensionPixelOffset(R.dimen.ksad_reward_follow_card_margin);
            ksLogoView.setLayoutParams(layoutParams3);
        }
        return layoutParams;
    }

    private static FrameLayout.LayoutParams a(FrameLayout.LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = layoutParams.gravity;
        return layoutParams2;
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        h hVar = new h(this.qt, this.gv, this.sh);
        this.uq = hVar;
        hVar.b(v.B(this.qt.mAdTemplate));
        a(getContext(), com.kwad.sdk.core.response.a.d.cb(this.qt.mAdTemplate), this.sh, R.dimen.ksad_reward_jinniu_logo_margin_bottom, false);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void gO() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void ic() {
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void id() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sh = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }
}
