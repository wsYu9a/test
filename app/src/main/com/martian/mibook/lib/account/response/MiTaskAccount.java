package com.martian.mibook.lib.account.response;

import ba.j;
import com.martian.rpauth.response.IAccount;

/* loaded from: classes3.dex */
public class MiTaskAccount implements IAccount {

    @j.a
    private Integer coins;

    @j.a
    private Integer coinsRate;

    @j.a
    private Integer commission;

    @j.a
    private Integer deposit;

    @j.a
    private Integer duration;

    @j.a
    private Boolean fiveStar;

    @j.a
    private Boolean fresh;

    @j.a
    private Integer money;

    @j.a
    private Integer mrate;

    @j.a
    private Boolean phoneBound;

    @j.a
    private Integer rate;

    @j.a
    private String rateNotice;

    @j.a
    private Boolean showCommission;

    @j.a
    private Integer totalDuration;

    @j.a
    private Integer totalReadingCoins;

    @j.a
    private Integer totalReadingDuration;

    @j.a
    private Integer totalSaleCommission;

    @j.a
    private Long uid;

    @j.a
    private Integer valid_invitee_num;

    @j.a
    private Integer wealth;

    @j.a
    private Integer freshRedpaper = 1;

    @j.a
    private Integer alipayMission = 0;

    @j.a
    private Integer alipayMissionMoney = 0;

    @j.a
    private Integer videoWithdrawCount = 0;

    @j.a
    private Integer expLevel = 0;

    @j.a
    private Integer reward = 0;

    public boolean enableVideoWithdraw() {
        Integer num = this.videoWithdrawCount;
        return num != null && num.intValue() >= 0;
    }

    public int getAlipayMission() {
        Integer num = this.alipayMission;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getAlipayMissionMoney() {
        Integer num = this.alipayMissionMoney;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getCoinsRate() {
        Integer num = this.coinsRate;
        if (num == null) {
            return 10000;
        }
        return num.intValue();
    }

    public int getCommission() {
        Integer num = this.commission;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public Long getDeadline() {
        return null;
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getDeposit() {
        Integer num = this.deposit;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getExpLevel() {
        Integer num = this.expLevel;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getFiveStar() {
        Boolean bool = this.fiveStar;
        return bool != null && bool.booleanValue();
    }

    public boolean getFresh() {
        Boolean bool = this.fresh;
        return bool != null && bool.booleanValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getFreshRedpaper() {
        return this.freshRedpaper.intValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getFresh_redpaper() {
        return this.freshRedpaper.intValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getIsVip() {
        return 0;
    }

    public int getMRate() {
        Integer num = this.mrate;
        if (num != null && num.intValue() > 0) {
            return this.mrate.intValue();
        }
        return 500;
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getMrate() {
        return this.mrate;
    }

    public boolean getPhoneBound() {
        Boolean bool = this.phoneBound;
        return bool != null && bool.booleanValue();
    }

    public int getRate() {
        Integer num = this.rate;
        if (num != null && num.intValue() > 0) {
            return this.rate.intValue();
        }
        return 500;
    }

    public String getRateNotice() {
        return this.rateNotice;
    }

    public int getReward() {
        Integer num = this.reward;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getShowCommission() {
        Boolean bool = this.showCommission;
        return bool == null || bool.booleanValue();
    }

    public int getTotalDuration() {
        Integer num = this.totalDuration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getTotalReadingCoins() {
        Integer num = this.totalReadingCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getTotalReadingDuration() {
        Integer num = this.totalReadingDuration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getTotalSaleCommission() {
        return this.totalSaleCommission;
    }

    @Override // com.martian.rpauth.response.IAccount
    public Long getUid() {
        return this.uid;
    }

    public int getValidInviteeNum() {
        Integer num = this.valid_invitee_num;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getValid_invitee_num() {
        return this.valid_invitee_num;
    }

    public Integer getVideoWithdrawCount() {
        return this.videoWithdrawCount;
    }

    @Override // com.martian.rpauth.response.IAccount
    public Long getVipStartTime() {
        return null;
    }

    public int getWealth() {
        Integer num = this.wealth;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean isFreshVideoWithdraw() {
        return enableVideoWithdraw() && this.videoWithdrawCount.intValue() == 0;
    }

    public void setAlipayMission(Integer num) {
        this.alipayMission = num;
    }

    public void setAlipayMissionMoney(Integer num) {
        this.alipayMissionMoney = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setCoinsRate(Integer num) {
        this.coinsRate = num;
    }

    public void setCommission(Integer num) {
        this.commission = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setDeadline(Long l10) {
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setDeposit(Integer num) {
        this.deposit = num;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setExpLevel(Integer num) {
        this.expLevel = num;
    }

    public void setFiveStar(Boolean bool) {
        this.fiveStar = bool;
    }

    public void setFresh(Boolean bool) {
        this.fresh = bool;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setFreshRedpaper(Integer num) {
        this.freshRedpaper = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setFresh_redpaper(Integer num) {
        this.freshRedpaper = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setIsVip(Integer num) {
    }

    public void setMRate(Integer num) {
        this.mrate = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setMrate(Integer num) {
        this.mrate = num;
    }

    public void setPhoneBound(Boolean bool) {
        this.phoneBound = bool;
    }

    public void setRate(Integer num) {
        this.rate = num;
    }

    public void setRateNotice(String str) {
        this.rateNotice = str;
    }

    public void setReward(Integer num) {
        this.reward = num;
    }

    public void setShowCommission(Boolean bool) {
        this.showCommission = bool;
    }

    public void setTotalDuration(Integer num) {
        this.totalDuration = num;
    }

    public void setTotalReadingCoins(Integer num) {
        this.totalReadingCoins = num;
    }

    public void setTotalReadingDuration(Integer num) {
        this.totalReadingDuration = num;
    }

    public void setTotalSaleCommission(Integer num) {
        this.totalSaleCommission = num;
    }

    public void setTotal_reading_duration(Integer num) {
        this.totalReadingDuration = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setUid(Long l10) {
        this.uid = l10;
    }

    public void setValid_invitee_num(Integer num) {
        this.valid_invitee_num = num;
    }

    public void setVideoWithdrawCount(Integer num) {
        this.videoWithdrawCount = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setVipStartTime(Long l10) {
    }

    public void setWealth(Integer num) {
        this.wealth = num;
    }
}
