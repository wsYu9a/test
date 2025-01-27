package com.vivo.mobilead.unified.interstitial;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class k extends g {
    public k(Activity activity, AdParams adParams) {
        super(activity, adParams);
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    protected void d(@NonNull AdError adError) {
        UnifiedVivoInterstitialAdListener unifiedVivoInterstitialAdListener = this.t;
        if (unifiedVivoInterstitialAdListener != null) {
            unifiedVivoInterstitialAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        } else {
            a(new l0().b(adError.getErrorCode()).a(adError.getErrorMsg()).c(adError.getRequestId()).a(c.a.f28912a).d(adError.getToken()).a(adError.getShowPriority()).a(false));
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.a
    protected void p() {
        a(new l0().a(c.a.f28912a).a(this.f29666f.J()).a(true).d(this.f29666f.P()).b(this.f29666f.d()).c(this.f29666f.G()));
    }
}
