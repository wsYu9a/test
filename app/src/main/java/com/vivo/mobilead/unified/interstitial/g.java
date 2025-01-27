package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class g extends a {
    private com.vivo.mobilead.g.b C;
    private volatile boolean D;
    private volatile boolean E;

    public g(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.D = false;
        this.E = false;
    }

    @Override // com.vivo.mobilead.unified.a
    public void a(com.vivo.mobilead.g.b bVar) {
        this.C = bVar;
    }

    protected void s() {
        if (!this.E) {
            this.D = true;
            return;
        }
        MediaListener mediaListener = this.u;
        if (mediaListener != null) {
            mediaListener.onVideoCached();
        }
    }

    public void t() {
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdReady();
        }
    }

    protected void u() {
        if (!this.D) {
            this.E = true;
            return;
        }
        MediaListener mediaListener = this.u;
        if (mediaListener != null) {
            mediaListener.onVideoCached();
        }
    }

    protected void a(l0 l0Var) {
        com.vivo.mobilead.g.b bVar = this.C;
        if (bVar != null) {
            bVar.a(l0Var);
        }
    }
}
