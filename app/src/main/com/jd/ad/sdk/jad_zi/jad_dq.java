package com.jd.ad.sdk.jad_zi;

import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;
import com.jd.ad.sdk.logger.Logger;

/* loaded from: classes2.dex */
public class jad_dq extends com.jd.ad.sdk.jad_hu.jad_an {
    public final /* synthetic */ String jad_er;
    public final /* synthetic */ int jad_fs;
    public final /* synthetic */ IDynamicInteractionListener jad_jt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jad_dq(jad_er jad_erVar, String str, String str2, int i10, IDynamicInteractionListener iDynamicInteractionListener) {
        super(str);
        this.jad_er = str2;
        this.jad_fs = i10;
        this.jad_jt = iDynamicInteractionListener;
    }

    @Override // com.jd.ad.sdk.jad_hu.jad_an
    public void jad_an(View view) {
        int i10 = this.jad_dq;
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("dynamic render click layer name:");
        jad_an.append(this.jad_er);
        jad_an.append(", adAnimationType:");
        jad_an.append(this.jad_fs);
        jad_an.append(", adTriggerSourceType:");
        jad_an.append(i10);
        Logger.d(jad_an.toString());
        IDynamicInteractionListener iDynamicInteractionListener = this.jad_jt;
        if (iDynamicInteractionListener != null) {
            iDynamicInteractionListener.onAdClicked(this.jad_fs, this.jad_dq);
        }
    }
}
