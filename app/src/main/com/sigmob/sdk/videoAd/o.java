package com.sigmob.sdk.videoAd;

import com.sigmob.windad.WindAdError;

/* loaded from: classes4.dex */
public interface o {
    void onAdLoadError(WindAdError windAdError, String str);

    void onAdLoadSuccess(String str);

    void onAdPreLoadFail(WindAdError windAdError, String str);

    void onAdPreLoadSuccess(String str);
}
