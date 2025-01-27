package com.kwad.components.ad.reward.k;

import android.content.Context;
import android.content.res.Resources;
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
import com.kwad.sdk.utils.ai;

/* loaded from: classes.dex */
public final class n extends w implements View.OnClickListener {
    private TextView lP;
    private com.kwad.components.ad.reward.j qt;
    private TextView yI;
    private TextView yJ;
    private KsLogoView zj;
    private KsLogoView zk;
    private KsAuthorIconView zl;
    private RelativeLayout zm;
    private String zo;
    private boolean zn = false;
    private Runnable zp = new Runnable() { // from class: com.kwad.components.ad.reward.k.n.2
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.kwai.a.a(n.this.lP, n.this.zo, KsLogoView.a(n.this.zj));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                n.this.lP.setText(n.this.zo);
                n.this.lP.setVisibility(0);
            }
        }
    };

    /* renamed from: com.kwad.components.ad.reward.k.n$1 */
    final class AnonymousClass1 implements KsLogoView.a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.widget.KsLogoView.a
        public final void jU() {
            n.this.lP.post(n.this.zp);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k.n$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.c.kwai.a.a(n.this.lP, n.this.zo, KsLogoView.a(n.this.zj));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                n.this.lP.setText(n.this.zo);
                n.this.lP.setVisibility(0);
            }
        }
    }

    public n(com.kwad.components.ad.reward.j jVar) {
        this.qt = jVar;
    }

    private void bindView(AdTemplate adTemplate) {
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        this.yI.setText(com.kwad.sdk.core.response.a.a.bK(cb));
        com.kwad.components.core.widget.e eVar = new com.kwad.components.core.widget.e();
        this.zl.setVisibility(0);
        this.zl.bindView(adTemplate);
        this.zl.a(eVar);
        this.yJ.setText(com.kwad.sdk.core.response.a.a.aw(cb));
        if (com.kwad.sdk.core.response.a.a.aX(cb) == 8) {
            this.zk.setVisibility(0);
            this.zk.S(adTemplate);
            this.lP.setText(com.kwad.sdk.core.response.a.a.an(cb));
        } else {
            this.zo = com.kwad.sdk.core.response.a.a.an(cb);
            KsLogoView ksLogoView = new KsLogoView(this.sn.getContext(), false);
            this.zj = ksLogoView;
            ksLogoView.setLogoLoadFinishListener(new KsLogoView.a() { // from class: com.kwad.components.ad.reward.k.n.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.widget.KsLogoView.a
                public final void jU() {
                    n.this.lP.post(n.this.zp);
                }
            });
            this.zj.S(adTemplate);
            this.zk.setVisibility(8);
        }
    }

    private static void h(View view, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = com.kwad.sdk.c.kwai.a.a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.sn;
        if (viewGroup == null) {
            return;
        }
        this.zl = (KsAuthorIconView) viewGroup.findViewById(R.id.ksad_live_author_icon);
        this.yI = (TextView) this.sn.findViewById(R.id.kwad_actionbar_title);
        this.lP = (TextView) this.sn.findViewById(R.id.kwad_actionbar_des_text);
        this.yJ = (TextView) this.sn.findViewById(R.id.ksad_live_actionbar_btn);
        this.zk = (KsLogoView) this.sn.findViewById(R.id.ksad_reward_live_kwai_logo);
        if (!this.zn) {
            this.zm = (RelativeLayout) this.sn.findViewById(R.id.ksad_reward_origin_live_relative);
        }
        this.sn.setOnClickListener(this);
        this.yJ.setOnClickListener(this);
        this.zl.setOnClickListener(this);
        this.lP.setOnClickListener(this);
        this.yI.setOnClickListener(this);
    }

    public final void a(ViewGroup viewGroup, int i2) {
        boolean z;
        if (i2 == 8) {
            super.a(viewGroup, R.id.ksad_reward_origin_live_shop_stub, R.id.ksad_reward_origin_live_root);
            z = true;
        } else {
            super.a(viewGroup, R.id.ksad_reward_origin_live_base_stub, R.id.ksad_reward_origin_live_root);
            z = false;
        }
        this.zn = z;
        initView();
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void a(v vVar) {
        super.a(vVar);
        bindView(vVar.getAdTemplate());
    }

    @Override // com.kwad.components.ad.reward.k.d
    protected final void ag(boolean z) {
        super.ag(z);
        Context context = this.sn.getContext();
        if (ai.DL()) {
            return;
        }
        if (this.zn) {
            ViewGroup.LayoutParams layoutParams = this.sn.getLayoutParams();
            layoutParams.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_live_subscribe_card_width_horizontal);
            this.sn.setLayoutParams(layoutParams);
            h(this.sn, 85);
            return;
        }
        this.sn.findViewById(R.id.ksad_reward_origin_live_base1).setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.zm.getLayoutParams();
        Resources resources = context.getResources();
        int i2 = R.dimen.ksad_live_subscribe_card_width_horizontal;
        layoutParams2.width = resources.getDimensionPixelSize(i2);
        this.zm.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.yJ.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(i2);
        this.yJ.setLayoutParams(layoutParams3);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        com.kwad.components.ad.reward.j jVar;
        Context context;
        int i2;
        if (view.equals(this.yJ)) {
            jVar = this.qt;
            context = view.getContext();
            i2 = 29;
        } else if (view.equals(this.zl)) {
            jVar = this.qt;
            context = view.getContext();
            i2 = 30;
        } else if (view.equals(this.lP)) {
            jVar = this.qt;
            context = view.getContext();
            i2 = 32;
        } else if (!view.equals(this.yI)) {
            if (view.equals(this.sn)) {
                this.qt.a(1, view.getContext(), 53, 2);
                return;
            }
            return;
        } else {
            jVar = this.qt;
            context = view.getContext();
            i2 = 31;
        }
        jVar.a(1, context, i2, 1);
    }
}
