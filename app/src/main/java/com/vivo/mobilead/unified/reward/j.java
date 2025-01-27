package com.vivo.mobilead.unified.reward;

import android.content.Context;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public class j extends h {
    public j(Context context, AdParams adParams) {
        super(context, adParams);
    }

    @Override // com.vivo.mobilead.unified.reward.a
    protected void d(@NonNull AdError adError) {
        UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
        if (unifiedVivoRewardVideoAdListener != null) {
            unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(adError.getErrorCode(), adError.getErrorMsg()));
        } else {
            a(new l0().a(c.a.f28912a).a(false).b(adError.getADID()).d(adError.getToken()).a(adError.getShowPriority()).b(adError.getErrorCode()).a(adError.getErrorMsg()));
        }
    }

    @Override // com.vivo.mobilead.unified.reward.a
    protected void o() {
        if (this.f29666f == null) {
            return;
        }
        a(new l0().a(c.a.f28912a).a(true).b(this.f29666f.d()).d(this.f29666f.P()).a(this.f29666f.J()).c(this.f29666f.G()));
    }
}
