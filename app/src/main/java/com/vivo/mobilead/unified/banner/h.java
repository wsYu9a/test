package com.vivo.mobilead.unified.banner;

import android.app.Activity;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class h extends f {
    public h(Activity activity, AdParams adParams) {
        super(activity, adParams);
    }

    @Override // com.vivo.mobilead.unified.banner.b
    protected void d(@NonNull AdError adError) {
        a(new l0().a(c.a.f28912a).a(false).b(adError.getADID()).d(adError.getToken()).a(adError.getShowPriority()).b(adError.getErrorCode()).a(adError.getErrorMsg()));
    }

    @Override // com.vivo.mobilead.unified.banner.b
    protected void o() {
        a(new l0().a(c.a.f28912a).a(true).b(this.f29666f.d()).d(this.f29666f.P()).a(this.f29666f.J()).c(this.f29666f.G()));
    }

    @Override // com.vivo.mobilead.unified.banner.f
    public void p() {
        UnifiedVivoBannerAdListener unifiedVivoBannerAdListener = this.t;
        if (unifiedVivoBannerAdListener != null) {
            if (this.v == null) {
                unifiedVivoBannerAdListener.onAdFailed(new VivoAdError(40218, "没有广告，建议过一会儿重试"));
                return;
            }
            RelativeLayout relativeLayout = new RelativeLayout(this.f29661a);
            relativeLayout.addView(this.v);
            this.t.onAdReady(relativeLayout);
        }
    }
}
