package com.vivo.mobilead.unified.reward;

import android.content.Context;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class h extends a {
    protected com.vivo.mobilead.g.b v;
    private volatile boolean w;
    private volatile boolean x;

    public h(Context context, AdParams adParams) {
        super(context, adParams);
        this.w = false;
        this.x = false;
    }

    @Override // com.vivo.mobilead.unified.a
    public void a(com.vivo.mobilead.g.b bVar) {
        this.v = bVar;
    }

    protected void p() {
        if (!this.x) {
            this.w = true;
            return;
        }
        MediaListener mediaListener = this.u;
        if (mediaListener != null) {
            mediaListener.onVideoCached();
        }
    }

    public void q() {
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdReady();
        }
    }

    protected void r() {
        if (!this.w) {
            this.x = true;
            return;
        }
        MediaListener mediaListener = this.u;
        if (mediaListener != null) {
            mediaListener.onVideoCached();
        }
    }

    protected void a(l0 l0Var) {
        com.vivo.mobilead.g.b bVar = this.v;
        if (bVar != null) {
            bVar.a(l0Var);
        }
    }
}
