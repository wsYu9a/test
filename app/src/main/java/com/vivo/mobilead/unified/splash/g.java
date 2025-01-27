package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import android.widget.FrameLayout;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class g extends a {
    protected com.vivo.mobilead.g.b E;
    protected Activity F;
    protected FrameLayout G;

    public g(Activity activity, AdParams adParams) {
        super(activity, adParams);
        this.F = activity;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(activity);
        this.G = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
    }

    @Override // com.vivo.mobilead.unified.a
    public void a(com.vivo.mobilead.g.b bVar) {
        this.E = bVar;
    }

    public void p() {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            FrameLayout frameLayout = this.G;
            if (frameLayout == null) {
                unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(40218, "没有广告，建议过一会儿重试"));
            } else {
                unifiedVivoSplashAdListener.onAdReady(frameLayout);
                this.z = System.currentTimeMillis();
            }
        }
    }

    public void a(UnifiedVivoSplashAdListener unifiedVivoSplashAdListener) {
        this.u = unifiedVivoSplashAdListener;
    }

    protected void a(l0 l0Var) {
        com.vivo.mobilead.g.b bVar = this.E;
        if (bVar != null) {
            bVar.a(l0Var);
        }
    }
}
