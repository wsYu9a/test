package com.martian.rpauth.response;

/* loaded from: classes.dex */
public interface IAccount {
    int getCoins();

    Long getDeadline();

    int getDeposit();

    int getFreshRedpaper();

    int getFresh_redpaper();

    int getIsVip();

    int getMoney();

    Long getUid();

    Long getVipStartTime();

    void setCoins(Integer coins);

    void setDeadline(Long deadline);

    void setDeposit(Integer deposit);

    void setFreshRedpaper(Integer fresh_Redpaper);

    void setFresh_redpaper(Integer fresh_Redpaper);

    void setIsVip(Integer isVip);

    void setMoney(Integer money);

    void setUid(Long uid);

    void setVipStartTime(Long vip_start_time);
}
