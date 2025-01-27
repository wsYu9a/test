package com.kwad.components.ad.reward.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;

/* loaded from: classes.dex */
public final class q extends d implements View.OnClickListener {
    private ViewGroup yE;
    private KsStyledTextButton zH;
    private View zI;

    @Nullable
    private com.kwad.components.ad.reward.g.b zJ;

    public q(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        this.yE = (ViewGroup) layoutInflater.inflate(R.layout.ksad_play_again_dialog, viewGroup, false);
        initView();
    }

    private void initView() {
        this.zH = (KsStyledTextButton) this.yE.findViewById(R.id.ksad_play_again_btn_action);
        this.zI = this.yE.findViewById(R.id.ksad_play_again_btn_exit);
        this.zH.setOnClickListener(this);
        this.zI.setOnClickListener(this);
    }

    public final void b(@Nullable com.kwad.components.ad.reward.g.b bVar) {
        this.zJ = bVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.yE;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.zJ == null) {
            return;
        }
        if (view.equals(this.zH)) {
            this.zJ.onPlayAgainClick(false);
        } else if (view.equals(this.zI)) {
            this.zJ.gu();
        }
    }
}
