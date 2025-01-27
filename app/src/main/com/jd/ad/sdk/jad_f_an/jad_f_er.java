package com.jd.ad.sdk.jad_f_an;

import android.view.View;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.jad_f_an;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* loaded from: classes2.dex */
public class jad_f_er implements View.OnClickListener {
    public final /* synthetic */ View jad_f_an;
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_an jad_f_bo;

    public jad_f_er(com.jd.ad.sdk.feed.jad_f_an jad_f_anVar, View view) {
        this.jad_f_bo = jad_f_anVar;
        this.jad_f_an = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.jad_f_bo;
        View view2 = this.jad_f_an;
        jad_f_anVar.getClass();
        if (view2 == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().setViewForceExposure(jad_f_anVar.jad_f_dq);
        int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(view2.getContext(), view2, jad_f_anVar.jad_f_dq);
        jad_f_an.InterfaceC0316jad_f_an interfaceC0316jad_f_an = jad_f_anVar.jad_f_kx;
        if (interfaceC0316jad_f_an != null) {
            JADFeed.jad_f_dq jad_f_dqVar = (JADFeed.jad_f_dq) interfaceC0316jad_f_an;
            JADFeed.this.reportClickEvent(onViewClicked);
            JADFeed.this.callbackAdClickOnUiThread();
        }
    }
}
