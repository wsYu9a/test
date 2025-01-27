package com.martian.rpauth.response;

import ba.j;

@j.b(name = "rocket.com.rpauth.response.MartianRPAccount")
/* loaded from: classes3.dex */
public class MartianRPAccount implements IAccount {

    @j.a
    private Integer bookCoins;

    @j.a
    private Integer chargeUser;

    @j.a
    private Integer coins;

    @j.a
    private Integer commission;

    @j.a
    private Integer consumeCoins;

    @j.a
    private Integer consumeCount;

    @j.a
    private Integer deposit;

    @j.a
    private Integer duration;

    @j.a
    private Boolean isVip;

    @j.a
    private Integer money;

    @j.a
    private Boolean paymentUser;

    @j.a
    private Integer rechargeCoins;

    @j.a
    private Integer rechargeCount;

    @j.a
    private Integer totalDuration;

    @j.a
    private Long uid;

    @j.a
    private Long vipEnd;

    @j.a
    private Integer wealth;

    @j.a
    private Integer freshRedpaper = 1;

    @j.a
    private Integer freshRedpaperIos = 1;

    @j.a
    private Integer alipayMission = 0;

    @j.a
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
        return (bool == null || !bool.booleanValue()) ? 0 : 1;
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

    public boolean isChargeUser() {
        Integer num = this.chargeUser;
        return num != null && num.intValue() == 1;
    }

    public boolean isPaymentUser() {
        Boolean bool = this.paymentUser;
        return bool != null && bool.booleanValue();
    }

    public void setAlipayMission(Integer num) {
        this.alipayMission = num;
    }

    public void setAlipayMissionMoney(Integer num) {
        this.alipayMissionMoney = num;
    }

    public void setBookCoins(Integer num) {
        this.bookCoins = num;
    }

    public void setChargeUser(Integer num) {
        this.chargeUser = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setCommission(Integer num) {
        this.commission = num;
    }

    public void setConsumeCoins(Integer num) {
        this.consumeCoins = num;
    }

    public void setConsumeCount(Integer num) {
        this.consumeCount = num;
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

    @Override // com.martian.rpauth.response.IAccount
    public void setFreshRedpaper(Integer num) {
        this.freshRedpaper = num;
    }

    public void setFreshRedpaperIos(Integer num) {
        this.freshRedpaperIos = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setFresh_redpaper(Integer num) {
        this.freshRedpaper = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setIsVip(Integer num) {
        this.isVip = Boolean.valueOf(num.intValue() > 0);
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setPaymentUser(Boolean bool) {
        this.paymentUser = bool;
    }

    public void setRechargeCoins(Integer num) {
        this.rechargeCoins = num;
    }

    public void setRechargeCount(Integer num) {
        this.rechargeCount = num;
    }

    public void setTotalDuration(Integer num) {
        this.totalDuration = num;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setUid(Long l10) {
        this.uid = l10;
    }

    public void setVip(Boolean bool) {
        this.isVip = bool;
    }

    public void setVipEnd(Long l10) {
        this.vipEnd = l10;
    }

    @Override // com.martian.rpauth.response.IAccount
    public void setVipStartTime(Long l10) {
    }

    public void setWealth(Integer num) {
        this.wealth = num;
    }
}
