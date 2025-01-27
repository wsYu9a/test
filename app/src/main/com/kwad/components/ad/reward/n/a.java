package com.kwad.components.ad.reward.n;

import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes2.dex */
public class a implements b {
    private Context mContext;
    private com.kwad.components.ad.reward.g rO;

    public a(Context context, com.kwad.components.ad.reward.g gVar) {
        this.rO = gVar;
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.n.b
    public final void he() {
        this.rO.a(1, this.mContext, 1, 1);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void iC() {
        this.rO.a(1, this.mContext, 13, 2);
    }

    @Override // com.kwad.components.ad.reward.n.b
    public void iE() {
        this.rO.a(1, this.mContext, TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE, 2);
    }
}
