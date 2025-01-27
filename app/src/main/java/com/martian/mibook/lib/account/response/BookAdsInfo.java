package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class BookAdsInfo {
    private Integer interstitial;
    private Integer readingAdsInterval;
    private Integer videoUnlock;

    public int getInterstitial() {
        Integer num = this.interstitial;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getReadingAdsInterval() {
        return this.readingAdsInterval;
    }

    public int getVideoUnlock() {
        Integer num = this.videoUnlock;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setInterstitial(Integer interstitial) {
        this.interstitial = interstitial;
    }

    public void setReadingAdsInterval(Integer readingAdsInterval) {
        this.readingAdsInterval = readingAdsInterval;
    }

    public void setVideoUnlock(Integer videoUnlock) {
        this.videoUnlock = videoUnlock;
    }
}
