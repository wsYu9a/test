package com.aggmoread.sdk.client;

import java.util.Map;

/* loaded from: classes.dex */
public class AMRewardAdConfig {
    private String customData;
    private RewardListener rewardAdListener;
    private int rewardAmount;
    private String rewardName;
    private String userID;

    public interface RewardListener {
        void onReward(Map<String, Object> map);
    }

    public String getCustomData() {
        return this.customData;
    }

    public RewardListener getRewardAdListener() {
        return this.rewardAdListener;
    }

    public int getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setRewardAdListener(RewardListener rewardListener) {
        this.rewardAdListener = rewardListener;
    }

    public void setRewardAmount(int i10) {
        this.rewardAmount = i10;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
