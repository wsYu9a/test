package com.aggmoread.sdk.client;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class AMAdLoadSlot {
    public ViewGroup adContainer;
    public int adCount;
    public AMAdSize adSize;
    public String adSlotId;
    public String bidToken;
    public int fetchTimeOut;
    public int limitTime;
    public int refreshTime;
    public AMRewardAdConfig rewardAdConfig;
    public AMVideoConfigs videoConfigs;

    public static class Builder {
        private ViewGroup adContainer;
        private int adCount;
        private AMAdSize adSize;
        private String adSlotId;
        private String bidToken;
        public AMRewardAdConfig rewardAdConfig;
        private AMVideoConfigs videoConfigs;
        private int fetchTimeOut = -1;
        private int refreshTime = -1;
        private int limitTime = -1;

        public AMAdLoadSlot build() {
            AMAdLoadSlot aMAdLoadSlot = new AMAdLoadSlot();
            aMAdLoadSlot.adSize = this.adSize;
            aMAdLoadSlot.adSlotId = this.adSlotId;
            aMAdLoadSlot.videoConfigs = this.videoConfigs;
            aMAdLoadSlot.adCount = this.adCount;
            aMAdLoadSlot.adContainer = this.adContainer;
            aMAdLoadSlot.bidToken = this.bidToken;
            aMAdLoadSlot.rewardAdConfig = this.rewardAdConfig;
            aMAdLoadSlot.fetchTimeOut = this.fetchTimeOut;
            aMAdLoadSlot.refreshTime = this.refreshTime;
            aMAdLoadSlot.limitTime = this.limitTime;
            return aMAdLoadSlot;
        }

        public Builder setAMAdSize(AMAdSize aMAdSize) {
            this.adSize = aMAdSize;
            return this;
        }

        public Builder setAdContainer(ViewGroup viewGroup) {
            this.adContainer = viewGroup;
            return this;
        }

        public Builder setAdCount(int i10) {
            this.adCount = i10;
            return this;
        }

        public Builder setFetchTimeOut(int i10) {
            this.fetchTimeOut = i10;
            return this;
        }

        public Builder setLimitTime(int i10) {
            this.limitTime = i10;
            return this;
        }

        public Builder setRefreshTime(int i10) {
            this.refreshTime = i10;
            return this;
        }

        public Builder setRewardConfig(AMRewardAdConfig aMRewardAdConfig) {
            this.rewardAdConfig = aMRewardAdConfig;
            return this;
        }

        public Builder setSSBidToken(String str) {
            this.bidToken = str;
            return this;
        }

        public Builder setSlotId(String str) {
            this.adSlotId = str;
            return this;
        }

        public Builder setVideoConfig(AMVideoConfigs aMVideoConfigs) {
            this.videoConfigs = aMVideoConfigs;
            return this;
        }
    }

    private AMAdLoadSlot() {
    }

    public /* synthetic */ AMAdLoadSlot(AnonymousClass1 anonymousClass1) {
        this();
    }
}
