package com.vivo.mobilead.unified.reward;

import android.app.Activity;
import android.content.Context;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public class e extends a {
    public e(Context context, AdParams adParams, UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener) {
        super(context, adParams);
        this.t = unifiedVivoRewardVideoAdListener;
    }

    @Override // com.vivo.mobilead.unified.reward.a
    public void a(Activity activity) {
        try {
            super.a(activity);
        } catch (Exception unused) {
            d.c().a(false);
            UnifiedVivoRewardVideoAdListener unifiedVivoRewardVideoAdListener = this.t;
            if (unifiedVivoRewardVideoAdListener != null) {
                unifiedVivoRewardVideoAdListener.onAdFailed(new VivoAdError(402129, "视频播放出错，建议重试"));
            }
        }
    }
}
