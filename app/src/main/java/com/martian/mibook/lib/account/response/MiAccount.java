package com.martian.mibook.lib.account.response;

import com.martian.libsupport.h;

/* loaded from: classes3.dex */
public class MiAccount {

    @h.a
    private Integer deposit;

    @h.a
    private Integer duration;

    @h.a
    private Integer freshRedpaper;

    @h.a
    private Integer money;

    @h.a
    private Integer totalDuration;

    @h.a
    private Long uid;

    @h.a
    private Integer wealth;

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

    public int getFreshRedpaper() {
        Integer num = this.freshRedpaper;
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }

    public int getMoney() {
        Integer num = this.money;
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

    public Long getUid() {
        return this.uid;
    }

    public int getWealth() {
        Integer num = this.wealth;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setFreshRedpaper(Integer freshRedpaper) {
        this.freshRedpaper = freshRedpaper;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setTotalDuration(Integer totalDuration) {
        this.totalDuration = this.duration;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public void setWealth(Integer wealth) {
        this.wealth = wealth;
    }
}
