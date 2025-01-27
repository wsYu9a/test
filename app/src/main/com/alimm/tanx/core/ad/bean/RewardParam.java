package com.alimm.tanx.core.ad.bean;

import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public class RewardParam extends BaseBean implements NotConfused {
    private boolean autoQuerySwitch;
    private boolean queryHistoryRewards;
    private boolean rewardVerification;

    public RewardParam() {
        this.autoQuerySwitch = true;
        this.queryHistoryRewards = true;
        this.rewardVerification = true;
    }

    public boolean isAutoQuerySwitch() {
        return this.autoQuerySwitch;
    }

    public boolean isQueryHistoryRewards() {
        return this.queryHistoryRewards;
    }

    public boolean isRewardVerification() {
        return this.rewardVerification;
    }

    public void setAutoQuerySwitch(boolean z10) {
        this.autoQuerySwitch = z10;
    }

    public void setQueryHistoryRewards(boolean z10) {
        this.queryHistoryRewards = z10;
    }

    public void setRewardVerification(boolean z10) {
        this.rewardVerification = z10;
    }

    public RewardParam(boolean z10, boolean z11) {
        this.autoQuerySwitch = true;
        this.queryHistoryRewards = z10;
        this.rewardVerification = z11;
    }

    public RewardParam(boolean z10, boolean z11, boolean z12) {
        this.autoQuerySwitch = z10;
        this.queryHistoryRewards = z11;
        this.rewardVerification = z12;
    }
}
