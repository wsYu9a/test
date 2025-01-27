package com.vivo.mobilead.unified.banner;

import android.app.Activity;
import android.widget.FrameLayout;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class f extends b {
    protected com.vivo.mobilead.g.b N;
    protected Activity O;
    protected FrameLayout P;

    public f(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.O = activity;
        this.P = new FrameLayout(activity);
    }

    @Override // com.vivo.mobilead.unified.a
    public void a(com.vivo.mobilead.g.b bVar) {
        this.N = bVar;
    }

    public void p() {
        UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = this.t;
        if (unifiedVivoBannerAdListener != null) {
            FrameLayout frameLayout = this.P;
            if (frameLayout != null) {
                unifiedVivoBannerAdListener.onAdReady(frameLayout);
            } else {
                unifiedVivoBannerAdListener.onAdFailed(new VivoAdError(40218, "没有广告，建议过一会儿重试"));
            }
        }
    }

    protected void a(l0 l0Var) {
        com.vivo.mobilead.g.b bVar = this.N;
        if (bVar != null) {
            bVar.a(l0Var);
        }
    }
}
