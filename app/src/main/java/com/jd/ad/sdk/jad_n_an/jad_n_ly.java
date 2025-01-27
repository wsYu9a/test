package com.jd.ad.sdk.jad_n_an;

import android.view.View;

/* loaded from: classes2.dex */
public class jad_n_ly implements View.OnClickListener {
    public final /* synthetic */ jad_n_hu jad_n_an;

    public jad_n_ly(jad_n_hu jad_n_huVar) {
        this.jad_n_an = jad_n_huVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        jad_n_hu.jad_n_an(this.jad_n_an, view, true);
    }
}
