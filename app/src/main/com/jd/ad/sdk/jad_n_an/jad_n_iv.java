package com.jd.ad.sdk.jad_n_an;

import android.view.View;

/* loaded from: classes2.dex */
public class jad_n_iv implements View.OnClickListener {
    public final /* synthetic */ View jad_n_an;
    public final /* synthetic */ boolean jad_n_bo;
    public final /* synthetic */ jad_n_hu jad_n_cp;

    public jad_n_iv(jad_n_hu jad_n_huVar, View view, boolean z10) {
        this.jad_n_cp = jad_n_huVar;
        this.jad_n_an = view;
        this.jad_n_bo = z10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.jad_n_cp.jad_n_bo(this.jad_n_an);
        if (this.jad_n_bo) {
            jad_n_hu.jad_n_an(this.jad_n_cp, this.jad_n_an, false);
        }
    }
}
