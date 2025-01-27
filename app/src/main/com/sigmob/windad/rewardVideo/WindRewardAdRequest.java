package com.sigmob.windad.rewardVideo;

import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: classes4.dex */
public class WindRewardAdRequest extends WindAdRequest {

    /* renamed from: i */
    public boolean f20905i;

    /* renamed from: j */
    public boolean f20906j;

    public WindRewardAdRequest(String str, String str2, Map<String, Object> map) {
        super(str, str2, map);
        this.f20870a = 1;
    }

    public static WindRewardAdRequest getWindVideoAdRequest(WindAdRequest windAdRequest) {
        if (windAdRequest != null) {
            return new WindRewardAdRequest(windAdRequest.getPlacementId(), windAdRequest.getUserId(), windAdRequest.getOptions());
        }
        return null;
    }

    public boolean isEnableKeepOn() {
        return this.f20906j;
    }

    public boolean isEnableScreenLockDisPlayAd() {
        return this.f20905i;
    }

    public void setEnableKeepOn(boolean z10) {
        this.f20906j = z10;
    }

    public void setEnableScreenLockDisPlayAd(boolean z10) {
        this.f20905i = z10;
    }
}
