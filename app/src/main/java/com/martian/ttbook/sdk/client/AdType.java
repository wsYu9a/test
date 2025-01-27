package com.martian.ttbook.sdk.client;

import com.martian.ads.ad.AdConfig;

/* loaded from: classes4.dex */
public enum AdType {
    SPLASH(2, "splash"),
    INFORMATION_FLOW(4, "informationFlow"),
    MULTI(8, "multi"),
    BANNER(1, "banner"),
    INTERSTITIAL(3, AdConfig.AdType.INTERSTITIAL),
    REWARD_VIDEO(5, AdConfig.AdType.REWARD_VIDEO),
    REWARD_VIDEO_DOWNLOAD(6, "reward_video_download"),
    FULL_SCREEN_VIDEO(7, "full_screen_video"),
    UNKNOWN(-1, "unknow");

    private final int valueInt;
    private final String valueString;

    AdType(int i2, String str) {
        this.valueInt = i2;
        this.valueString = str;
    }

    public int getIntValue() {
        return this.valueInt;
    }

    public String getStringValue() {
        return this.valueString;
    }
}
