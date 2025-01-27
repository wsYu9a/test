package com.kwad.components.ad.reward.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.ad.reward.widget.KsAuthorIconView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;

/* loaded from: classes2.dex */
public final class o extends s implements View.OnClickListener {
    private TextView AO;
    private TextView AP;
    private KsLogoView Bo;
    private KsLogoView Bp;
    private KsAuthorIconView Bq;
    private RelativeLayout Br;
    private String Bt;
    private TextView mK;
    private com.kwad.components.ad.reward.g rO;
    private boolean Bs = false;
    private Runnable Bu = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.a.a.a(o.this.mK, o.this.Bt, KsLogoView.a(o.this.Bo));
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                o.this.mK.setText(o.this.Bt);
                o.this.mK.setVisibility(0);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.n.o$1 */
    public class AnonymousClass1 implements KsLogoView.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.KsLogoView.a
        public final void kx() {
            o.this.mK.post(o.this.Bu);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n.o$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.a.a.a(o.this.mK, o.this.Bt, KsLogoView.a(o.this.Bo));
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                o.this.mK.setText(o.this.Bt);
                o.this.mK.setVisibility(0);
            }
        }
    }

    public o(com.kwad.components.ad.reward.g gVar) {
        this.rO = gVar;
    }

    private void f(AdTemplate adTemplate) {
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.AO.setText(com.kwad.sdk.core.response.b.a.cj(eb2));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.Bq.setVisibility(0);
        this.Bq.f(adTemplate);
        this.Bq.a(eVar);
        this.AP.setText(com.kwad.sdk.core.response.b.a.aE(eb2));
        if (com.kwad.sdk.core.response.b.a.bf(eb2) == 8) {
            this.Bp.setVisibility(0);
            this.Bp.aK(adTemplate);
            this.mK.setText(com.kwad.sdk.core.response.b.a.au(eb2));
        } else {
            this.Bt = com.kwad.sdk.core.response.b.a.au(eb2);
            KsLogoView ksLogoView = new KsLogoView(this.f11741uc.getContext(), false);
            this.Bo = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.n.o.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void kx() {
                    o.this.mK.post(o.this.Bu);
                }
            });
            this.Bo.aK(adTemplate);
            this.Bp.setVisibility(8);
        }
    }

    private static void h(View view, int i10) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.f11741uc;
        if (viewGroup == null) {
            return;
        }
        this.Bq = (KsAuthorIconView) viewGroup.findViewById(R.id.ksad_live_author_icon);
        this.AO = (TextView) this.f11741uc.findViewById(R.id.kwad_actionbar_title);
        this.mK = (TextView) this.f11741uc.findViewById(R.id.kwad_actionbar_des_text);
        this.AP = (TextView) this.f11741uc.findViewById(R.id.ksad_live_actionbar_btn);
        this.Bp = (KsLogoView) this.f11741uc.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.Bs) {
            this.Br = (RelativeLayout) this.f11741uc.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.f11741uc.setOnClickListener(this);
        this.AP.setOnClickListener(this);
        this.Bq.setOnClickListener(this);
        this.mK.setOnClickListener(this);
        this.AO.setOnClickListener(this);
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void ac(boolean z10) {
        super.ac(z10);
        Context context = this.f11741uc.getContext();
        if (an.NS()) {
            return;
        }
        if (this.Bs) {
            ViewGroup.LayoutParams layoutParams = this.f11741uc.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.f11741uc.setLayoutParams(layoutParams);
            h(this.f11741uc, 85);
            return;
        }
        this.f11741uc.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.Br.getLayoutParams();
        layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.Br.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.AP.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.AP.setLayoutParams(layoutParams3);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.AP)) {
            this.rO.a(1, view.getContext(), 29, 1);
            return;
        }
        if (view.equals(this.Bq)) {
            this.rO.a(1, view.getContext(), 30, 1);
            return;
        }
        if (view.equals(this.mK)) {
            this.rO.a(1, view.getContext(), 32, 1);
        } else if (view.equals(this.AO)) {
            this.rO.a(1, view.getContext(), 31, 1);
        } else if (view.equals(this.f11741uc)) {
            this.rO.a(1, view.getContext(), 53, 2);
        }
    }

    public final void a(ViewGroup viewGroup, int i10) {
        if (i10 == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            this.Bs = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            this.Bs = false;
        }
        initView();
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        f(rVar.getAdTemplate());
    }
}
