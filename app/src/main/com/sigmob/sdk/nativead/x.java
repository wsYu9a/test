package com.sigmob.sdk.nativead;

import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: classes4.dex */
public interface x {
    void onNativeAdLoadFail(int i10, String str);

    void onNativeAdLoaded(List<WindNativeAdData> list);
}
