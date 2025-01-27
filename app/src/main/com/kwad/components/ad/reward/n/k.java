package com.kwad.components.ad.reward.n;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class k extends d implements com.kwad.sdk.widget.c {
    private ViewStub AJ;
    private ViewGroup AK;
    private KsStyledTextButton AL;
    private KsStyledTextButton AM;
    private KsPriceView Ak;
    private TextView An;
    private TextView Ao;
    private View Ap;
    private TextView iO;
    private KSCornerImageView mJ;
    private TextView mK;
    private com.kwad.components.ad.reward.g rO;

    public k(com.kwad.components.ad.reward.g gVar, ViewStub viewStub) {
        this.AJ = viewStub;
        this.rO = gVar;
    }

    private void d(View view, boolean z10) {
        if (view.equals(this.AM)) {
            this.rO.a(2, view.getContext(), z10 ? 38 : 153, 1);
        } else if (view.equals(this.AL)) {
            this.rO.a(2, view.getContext(), z10 ? 37 : 153, 1);
        } else if (view.equals(this.AK)) {
            this.rO.a(2, view.getContext(), z10 ? 2 : 153, 2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        a(rVar.getAdTemplate(), com.kwad.components.ad.reward.model.a.M(rVar.getAdTemplate()));
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.dQ(this.rO.mAdTemplate)) {
            d(view, false);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ha() {
        return this.AK;
    }

    public final void hide() {
        ViewGroup viewGroup = this.AK;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    public k(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup) {
        this.AK = viewGroup;
        this.rO = gVar;
    }

    private void a(AdTemplate adTemplate, com.kwad.components.ad.reward.model.a aVar) {
        KSImageLoader.loadAppIcon(this.mJ, aVar.gz(), adTemplate, 8);
        this.iO.setText(aVar.getTitle());
        this.mK.setText(aVar.gA());
        int dimensionPixelSize = this.AK.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
        this.Ak.getConfig().af(dimensionPixelSize).ah(dimensionPixelSize).ag(this.AK.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
        this.Ak.d(aVar.getPrice(), aVar.getOriginPrice(), true);
        String hr = aVar.hr();
        this.Ap.setVisibility(TextUtils.isEmpty(hr) ? 8 : 0);
        if (hr != null) {
            this.An.setText(hr);
        }
        this.Ao.setText(aVar.hs());
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        d(view, true);
    }
}
