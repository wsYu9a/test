package com.baidu.mobads.sdk.api;

/* loaded from: classes2.dex */
public enum AdSize {
    Banner(0),
    Square(1),
    InterstitialGame(6),
    InterstitialReader(7),
    InterstitialRefresh(9),
    InterstitialOther(10),
    InterstitialForVideoBeforePlay(12),
    InterstitialForVideoPausePlay(13),
    RewardVideo(14),
    PrerollVideoNative(15),
    FeedNative(16),
    FeedH5TemplateNative(17);

    private int value;

    AdSize(int i10) {
        this.value = i10;
    }

    public int getValue() {
        return this.value;
    }
}
