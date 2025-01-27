package com.kwad.components.ad.reward.n;

import android.app.DialogFragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.h;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: classes2.dex */
public final class m extends d implements View.OnClickListener {
    private DialogFragment AF;
    private View AI;
    private ViewGroup AX;
    private View AY;
    private TextView AZ;
    private TextView Ba;
    private TextView Bb;
    private View Bc;
    private ImageView gG;
    private TextView iO;
    private h.a rn;

    public m(DialogFragment dialogFragment, AdTemplate adTemplate, LayoutInflater layoutInflater, ViewGroup viewGroup, h.a aVar) {
        this.AF = dialogFragment;
        this.rn = aVar;
        if (com.kwad.sdk.core.response.b.a.cS(com.kwad.sdk.core.response.b.e.eb(adTemplate))) {
            this.AX = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_origin_dialog, viewGroup, false);
            t(true);
        } else {
            this.AX = (ViewGroup) layoutInflater.inflate(R.layout.ksad_live_subscribe_dialog, viewGroup, false);
            t(false);
        }
    }

    private void t(boolean z10) {
        this.AY = this.AX.findViewById(R.id.ksad_live_subscribe_dialog_btn_close);
        this.iO = (TextView) this.AX.findViewById(R.id.ksad_live_subscribe_dialog_title);
        this.gG = (ImageView) this.AX.findViewById(R.id.ksad_live_subscribe_dialog_icon);
        this.Ba = (TextView) this.AX.findViewById(R.id.ksad_live_subscribe_dialog_content_txt);
        this.AZ = (TextView) this.AX.findViewById(R.id.ksad_live_subscribe_dialog_content);
        this.AI = this.AX.findViewById(R.id.ksad_live_subscribe_dialog_btn_continue);
        this.Bc = this.AX.findViewById(R.id.ksad_live_subscribe_dialog_btn_deny);
        this.Bb = (TextView) this.AX.findViewById(R.id.ksad_live_subscribe_dialog_vide_detail);
        if (z10) {
            this.AY.setVisibility(8);
        }
        this.AY.setOnClickListener(this);
        this.AI.setOnClickListener(this);
        this.Bc.setOnClickListener(this);
        this.Bb.setOnClickListener(this);
    }

    public final void a(h.c cVar) {
        KSImageLoader.loadCircleIcon(this.gG, cVar.gz(), this.AX.getContext().getResources().getDrawable(R.drawable.ksad_ic_default_user_avatar));
        String title = cVar.getTitle();
        if (this.iO != null && title != null) {
            SpannableString spannableString = new SpannableString(title);
            int color = ha().getResources().getColor(R.color.ksad_reward_main_color);
            spannableString.setSpan(new ForegroundColorSpan(color), 2, 4, 18);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
            int length = title.length();
            spannableString.setSpan(foregroundColorSpan, length - 2, length, 18);
            this.iO.setText(spannableString);
        }
        this.AZ.setText(cVar.gA());
        this.Ba.setText(cVar.gB());
        this.Bb.setText(String.format("%s", cVar.rw));
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup ha() {
        return this.AX;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        h.a aVar;
        if (view.equals(this.AY)) {
            this.AF.dismiss();
            h.a aVar2 = this.rn;
            if (aVar2 != null) {
                aVar2.gu();
                return;
            }
            return;
        }
        if (view.equals(this.AI)) {
            this.AF.dismiss();
            h.a aVar3 = this.rn;
            if (aVar3 != null) {
                aVar3.gu();
                return;
            }
            return;
        }
        if (!view.equals(this.Bc)) {
            if (!view.equals(this.Bb) || (aVar = this.rn) == null) {
                return;
            }
            aVar.g(131, 2);
            return;
        }
        this.AF.dismiss();
        h.a aVar4 = this.rn;
        if (aVar4 != null) {
            aVar4.G(false);
        }
    }
}
