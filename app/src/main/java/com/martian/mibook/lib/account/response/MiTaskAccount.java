package com.martian.mibook.lib.account.response;

import com.martian.libsupport.h;
import com.martian.rpauth.response.IAccount;

/* loaded from: classes.dex */
public class MiTaskAccount implements IAccount {

    @h.a
    private Integer coins;

    @h.a
    private Integer coinsRate;

    @h.a
    private Integer commission;

    @h.a
    private Integer deposit;

    @h.a
    private Integer duration;

    @h.a
    private Boolean fiveStar;

    @h.a
    private Boolean fresh;

    @h.a
    private Integer money;

    @h.a
    private Integer mrate;

    @h.a
    private Boolean phoneBound;

    @h.a
    private Integer rate;

    @h.a
    private String rateNotice;

    @h.a
    private Boolean showCommission;

    @h.a
    private Integer totalDuration;

    @h.a
    private Integer totalReadingCoins;

    @h.a
    private Integer totalReadingDuration;

    @h.a
    private Integer totalSaleCommission;

    @h.a
    private Long uid;

    @h.a
    private Integer valid_invitee_num;

    @h.a
    private Integer wealth;

    @h.a
    private Integer freshRedpaper = 1;

    @h.a
    private Integer alipayMission = 0;

    @h.a
    private Integer alipayMissionMoney = 0;

    @h.a
    private Integer videoWithdrawCount = 0;

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

    public void setAlipayMission(Integer alipayMission) {
        this.alipayMission = alipayMission;
    }

    public void setAlipayMissionMoney(Integer alipayMissionMoney) {
        this.alipayMissionMoney = alipayMissionMoney;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setCoinsRate(Integer coinsRate) {
        this.coinsRate = coinsRate;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setDeadline(Long deadline) {
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setFiveStar(Boolean fiveStar) {
        this.fiveStar = fiveStar;
    }

    public void setFresh(Boolean fresh) {
        this.fresh = fresh;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setFreshRedpaper(Integer freshRedpaper) {
        this.freshRedpaper = freshRedpaper;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setFresh_redpaper(Integer fresh_Redpaper) {
        this.freshRedpaper = fresh_Redpaper;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setIsVip(Integer isVip) {
    }

    public void setMRate(Integer mrate) {
        this.mrate = mrate;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setMrate(Integer mrate) {
        this.mrate = mrate;
    }

    public void setPhoneBound(Boolean phoneBound) {
        this.phoneBound = phoneBound;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public void setRateNotice(String rateNotice) {
        this.rateNotice = rateNotice;
    }

    public void setShowCommission(Boolean showCommission) {
        this.showCommission = showCommission;
    }

    public void setTotalDuration(Integer totalDuration) {
        this.totalDuration = totalDuration;
    }

    public void setTotalReadingCoins(Integer totalReadingCoins) {
        this.totalReadingCoins = totalReadingCoins;
    }

    public void setTotalReadingDuration(Integer totalReadingDuration) {
        this.totalReadingDuration = totalReadingDuration;
    }

    public void setTotalSaleCommission(Integer totalSaleCommission) {
        this.totalSaleCommission = totalSaleCommission;
    }

    public void setTotal_reading_duration(Integer totalReadingDuration) {
        this.totalReadingDuration = totalReadingDuration;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setValid_invitee_num(Integer valid_invitee_num) {
        this.valid_invitee_num = valid_invitee_num;
    }

    public void setVideoWithdrawCount(Integer videoWithdrawCount) {
        this.videoWithdrawCount = videoWithdrawCount;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setVipStartTime(Long vip_start_time) {
    }

    public void setWealth(Integer wealth) {
        this.wealth = wealth;
    }
}
