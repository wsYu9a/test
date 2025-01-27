package com.vivo.mobilead.unified.splash;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.view.m;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class i extends g {
    public i(Activity activity, AdParams adParams) {
        super(activity, adParams);
    }

    @Override // com.vivo.mobilead.unified.splash.a, com.vivo.mobilead.unified.a, com.vivo.mobilead.unified.base.callback.j
    public void a(@NonNull AdError adError) {
        super.a(adError);
        a(new l0().a(c.a.f28912a).a(false).b(adError.getADID()).d(adError.getToken()).a(adError.getShowPriority()).b(adError.getErrorCode()).a(adError.getErrorMsg()));
    }

    @Override // com.vivo.mobilead.unified.splash.a
    protected void o() {
        super.o();
        a(new l0().a(c.a.f28912a).a(true).b(this.x.d()).d(this.x.P()).a(this.x.J()).c(this.x.G()));
    }

    @Override // com.vivo.mobilead.unified.splash.g
    public void p() {
        UnifiedVivoSplashAdListener unifiedVivoSplashAdListener = this.u;
        if (unifiedVivoSplashAdListener != null) {
            m mVar = this.v;
            if (mVar == null) {
                unifiedVivoSplashAdListener.onAdFailed(new VivoAdError(40218, "没有广告，建议过一会儿重试"));
                return;
            }
            mVar.f();
            this.u.onAdReady(this.v);
            this.z = System.currentTimeMillis();
        }
    }
}
