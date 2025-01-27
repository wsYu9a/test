package com.kwad.components.core.e.e;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import com.kwad.sdk.R;

/* loaded from: classes3.dex */
public final class d extends b implements View.OnClickListener {
    private TextView Nu;
    private TextView Nv;
    private TextView so;

    @Override // com.kwad.components.core.e.e.b, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void as() {
        super.as();
        if (this.Nt.Ns.op() == 1) {
            this.so.setText("即将打开" + com.kwad.sdk.core.response.b.a.ck(this.mAdInfo));
        } else if (this.Nt.Ns.op() == 2) {
            this.so.setText("即将打开第三方页面");
        }
        com.kwad.sdk.c.a.a.a(this, this.Nu, this.Nv);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.Nt.Ns.al(true);
        this.Nt.Nq.dismiss();
        if (view == this.Nu) {
            com.kwad.components.core.e.d.a.a(this.Nt.Ns);
            com.kwad.sdk.core.adlog.c.p(this.Nt.Ns.getAdTemplate(), 230);
        } else if (view == this.Nv) {
            com.kwad.sdk.core.adlog.c.p(this.Nt.Ns.getAdTemplate(), 231);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.so = (TextView) findViewById(R.id.ksad_second_confirm_content_view);
        this.Nu = (TextView) findViewById(R.id.ksad_second_confirm_ensure);
        this.Nv = (TextView) findViewById(R.id.ksad_second_confirm_cancle);
    }
}
