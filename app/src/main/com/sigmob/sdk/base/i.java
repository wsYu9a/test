package com.sigmob.sdk.base;

import com.sigmob.windad.WindAdError;
import com.sigmob.windad.rewardVideo.WindRewardInfo;

/* loaded from: classes4.dex */
public interface i {
    void a(WindAdError windAdError, String str);

    void a(WindRewardInfo windRewardInfo, String str);

    void a(String str);

    void b(WindAdError windAdError, String str);

    void b(String str);

    void c(String str);

    void d(String str);

    void e(String str);

    void onVideoAdPlayEnd(String str);
}
