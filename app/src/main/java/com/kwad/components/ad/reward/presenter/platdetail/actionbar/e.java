package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.n;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.s.i;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes2.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements RewardActionBarControl.c {

    /* renamed from: if */
    private ViewGroup f6if;
    private KsLogoView tU;
    private n.a wA;
    private n wx;
    private int wy;
    private FrameLayout.LayoutParams wz;

    /* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e$1 */
    public class AnonymousClass1 extends com.kwad.components.ad.reward.n.a {
        public AnonymousClass1(Context context, g gVar) {
            super(context, gVar);
        }

        @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
        public final void iC() {
            e.this.rO.a(1, e.this.getContext(), 10, 2);
        }

        @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
        public final void iE() {
            e.this.rO.a(1, e.this.getContext(), 10, 2);
        }
    }

    public e(ViewGroup viewGroup, n.a aVar) {
        this.f6if = viewGroup;
        this.wA = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void as() {
        super.as();
        this.rO.f11692qi.a(this);
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(this.rO.mAdTemplate);
        this.wy = this.tU.getVisibility();
        this.wz = d.a(getContext(), eb2, this.tU, R.dimen.ksad_reward_order_logo_margin_bottom, !this.rO.f11689qf.kh());
        n nVar = new n(this.f6if, new com.kwad.components.ad.reward.n.a(getContext(), this.rO) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            public AnonymousClass1(Context context, g gVar) {
                super(context, gVar);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void iC() {
                e.this.rO.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void iE() {
                e.this.rO.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.wx = nVar;
        nVar.a(this.wA);
        this.wx.b(r.V(this.rO.mAdTemplate));
        i.a(new com.kwad.components.core.widget.e(), this.wx.ha());
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.f6if.setVisibility(0);
        RewardActionBarControl.a(aVar, this.f6if, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.tU = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tU.setVisibility(this.wy);
        FrameLayout.LayoutParams layoutParams = this.wz;
        if (layoutParams != null) {
            this.tU.setLayoutParams(layoutParams);
        }
    }
}
