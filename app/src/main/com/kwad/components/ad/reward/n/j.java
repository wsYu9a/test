package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class j extends d implements View.OnClickListener {
    private DialogFragment AF;
    private TextView AG;
    private View AH;
    private View AI;
    private AdTemplate adTemplate;
    private TextView iO;
    private KSCornerImageView mJ;
    private TextView mK;
    private TextView mL;
    private h.a rn;

    /* renamed from: uc */
    private ViewGroup f11740uc;
    private View wR;

    public j(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.AF = dialogFragment;
        this.adTemplate = adTemplate;
        this.rn = aVar;
        this.f11740uc = (ViewGroup) layoutInflater.inflate(R.layout.ksad_reward_jinniu_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.mJ = (KSCornerImageView) this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_icon);
        this.iO = (TextView) this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_title);
        this.mK = (TextView) this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_desc);
        this.AG = (TextView) this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_play_time_tips);
        this.mL = (TextView) this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_detail);
        this.wR = this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_btn_close);
        this.AH = this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_btn_deny);
        this.AI = this.f11740uc.findViewById(R.id.ksad_reward_jinniu_dialog_btn_continue);
        this.wR.setOnClickListener(this);
        this.AH.setOnClickListener(this);
        this.AI.setOnClickListener(this);
        this.mJ.setOnClickListener(this);
        this.iO.setOnClickListener(this);
        this.mK.setOnClickListener(this);
        this.mL.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadAppIcon(this.mJ, cVar.gz(), this.adTemplate, 4);
        this.iO.setText(cVar.getTitle());
        this.mK.setText(cVar.gA());
        this.AG.setText(cVar.gC());
        if (com.kwad.sdk.core.response.b.a.cj(this.adTemplate)) {
            this.mL.setText(String.format("%s >", com.kwad.sdk.core.response.b.a.aE(com.kwad.sdk.core.response.b.e.eb(this.adTemplate))));
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ha() {
        return this.f11740uc;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.wR)) {
            this.AF.dismiss();
            h.a aVar2 = this.rn;
            if (aVar2 != null) {
                aVar2.gu();
                return;
            }
            return;
        }
        if (view.equals(this.AH)) {
            this.AF.dismiss();
            h.a aVar3 = this.rn;
            if (aVar3 != null) {
                aVar3.G(false);
                return;
            }
            return;
        }
        if (view.equals(this.AI)) {
            this.AF.dismiss();
            h.a aVar4 = this.rn;
            if (aVar4 != null) {
                aVar4.gu();
                return;
            }
            return;
        }
        if (view.equals(this.mJ)) {
            h.a aVar5 = this.rn;
            if (aVar5 != null) {
                aVar5.g(127, 2);
                return;
            }
            return;
        }
        if (view.equals(this.iO)) {
            h.a aVar6 = this.rn;
            if (aVar6 != null) {
                aVar6.g(128, 2);
                return;
            }
            return;
        }
        if (view.equals(this.mK)) {
            h.a aVar7 = this.rn;
            if (aVar7 != null) {
                aVar7.g(129, 2);
                return;
            }
            return;
        }
        if (!view.equals(this.mL) || (aVar = this.rn) == null) {
            return;
        }
        aVar.g(131, 2);
    }
}
