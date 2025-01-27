package com.martian.rpauth.response;

import com.martian.libsupport.h;

@h.b(name = "rocket.com.rpauth.response.MartianRPAccount")
/* loaded from: classes.dex */
public class MartianRPAccount implements IAccount {

    @h.a
    private Integer bookCoins;

    @h.a
    private Integer coins;

    @h.a
    private Integer commission;

    @h.a
    private Integer consumeCoins;

    @h.a
    private Integer consumeCount;

    @h.a
    private Integer deposit;

    @h.a
    private Integer duration;

    @h.a
    private Boolean isVip;

    @h.a
    private Integer money;

    @h.a
    private Boolean paymentUser;

    @h.a
    private Integer rechargeCoins;

    @h.a
    private Integer rechargeCount;

    @h.a
    private Integer totalDuration;

    @h.a
    private Long uid;

    @h.a
    private Long vipEnd;

    @h.a
    private Integer wealth;

    @h.a
    private Integer freshRedpaper = 1;

    @h.a
    private Integer freshRedpaperIos = 1;

    @h.a
    private Integer alipayMission = 0;

    @h.a
    private Integer alipayMissionMoney = 0;

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

    public int getBookCoins() {
        Integer num = this.bookCoins;
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

    public Integer getCommission() {
        Integer num = this.commission;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getConsumeCoins() {
        Integer num = this.consumeCoins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getConsumeCount() {
        Integer num = this.consumeCount;
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

    @Override // com.martian.rpauth.response.IAccount
    public int getFreshRedpaper() {
        return this.freshRedpaper.intValue();
    }

    public int getFreshRedpaperIos() {
        return this.freshRedpaperIos.intValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getFresh_redpaper() {
        return this.freshRedpaper.intValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getIsVip() {
        Boolean bool = this.isVip;
        return (bool == null || bool.booleanValue()) ? 1 : 1;
    }

    @Override // com.martian.rpauth.response.IAccount
    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getRechargeCoins() {
        Integer num = this.rechargeCoins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getRechargeCount() {
        Integer num = this.rechargeCount;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getTotalDuration() {
        Integer num = this.totalDuration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // com.martian.rpauth.response.IAccount
    public Long getUid() {
        return this.uid;
    }

    public Boolean getVip() {
        return this.isVip;
    }

    public Long getVipEnd() {
        return this.vipEnd;
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

    public boolean isPaymentUser() {
        Boolean bool = this.paymentUser;
        return bool != null && bool.booleanValue();
    }

    public void setAlipayMission(Integer alipayMission) {
        this.alipayMission = alipayMission;
    }

    public void setAlipayMissionMoney(Integer alipayMissionMoney) {
        this.alipayMissionMoney = alipayMissionMoney;
    }

    public void setBookCoins(Integer bookCoins) {
        this.bookCoins = bookCoins;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public void setConsumeCoins(Integer consumeCoins) {
        this.consumeCoins = consumeCoins;
    }

    public void setConsumeCount(Integer consumeCount) {
        this.consumeCount = consumeCount;
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

    @Override // com.martian.rpauth.response.IAccount
    public void setFreshRedpaper(Integer freshRedpaper) {
        this.freshRedpaper = freshRedpaper;
    }

    public void setFreshRedpaperIos(Integer freshRedpaperIos) {
        this.freshRedpaperIos = freshRedpaperIos;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setFresh_redpaper(Integer fresh_Redpaper) {
        this.freshRedpaper = fresh_Redpaper;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setIsVip(Integer isVip) {
        this.isVip = Boolean.valueOf(isVip.intValue() > 0);
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setPaymentUser(Boolean paymentUser) {
        this.paymentUser = paymentUser;
    }

    public void setRechargeCoins(Integer rechargeCoins) {
        this.rechargeCoins = rechargeCoins;
    }

    public void setRechargeCount(Integer rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public void setTotalDuration(Integer totalDuration) {
        this.totalDuration = totalDuration;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setVip(Boolean vip) {
        this.isVip = vip;
    }

    public void setVipEnd(Long vipEnd) {
        this.vipEnd = vipEnd;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setVipStartTime(Long vip_start_time) {
    }

    public void setWealth(Integer wealth) {
        this.wealth = wealth;
    }
}
