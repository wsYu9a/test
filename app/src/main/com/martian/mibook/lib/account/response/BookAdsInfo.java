package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class BookAdsInfo {
    private Integer bannerOnHookSeconds;
    private Integer interstitial;
    private Integer interstitialIntervalMinutes;
    private Integer pauseAdRequestFailTimes;
    private Integer readingAdsInterval;
    private Integer videoUnlock;

    public int getBannerOnHookSeconds() {
        Integer num = this.bannerOnHookSeconds;
        if (num == null) {
            return 0;
        }
        return num.intValue() * 1000;
    }

    public int getInterstitial() {
        Integer num = this.interstitial;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getInterstitialIntervalMinutes() {
        return this.interstitialIntervalMinutes;
    }

    public int getPauseAdRequestFailTimes() {
        Integer num = this.pauseAdRequestFailTimes;
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

    public void setBannerOnHookSeconds(Integer num) {
        this.bannerOnHookSeconds = num;
    }

    public void setInterstitial(Integer num) {
        this.interstitial = num;
    }

    public void setInterstitialIntervalMinutes(Integer num) {
        this.interstitialIntervalMinutes = num;
    }

    public void setPauseAdRequestFailTimes(Integer num) {
        this.pauseAdRequestFailTimes = num;
    }

    public void setReadingAdsInterval(Integer num) {
        this.readingAdsInterval = num;
    }

    public void setVideoUnlock(Integer num) {
        this.videoUnlock = num;
    }
}
