package com.martian.mibook.lib.account.response;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class BonusPool {
    private Integer checkinDays;
    private Boolean checkinToday;
    private List<Integer> coinList;
    private Integer fullCheckinDays;
    private Integer money;
    private Integer nextCoins;
    private Integer nextDuration;

    public int getCheckinDays() {
        Integer num = this.checkinDays;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getCheckinToday() {
        Boolean bool = this.checkinToday;
        return bool != null && bool.booleanValue();
    }

    public List<Integer> getCoinList() {
        if (this.coinList == null) {
            this.coinList = new ArrayList();
        }
        return this.coinList;
    }

    public int getFullCheckinDays() {
        Integer num = this.fullCheckinDays;
        if (num == null) {
            return 7;
        }
        return num.intValue();
    }

    public Integer getMoney() {
        return this.money;
    }

    public Integer getNextCoins() {
        Integer num = this.nextCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getNextDuration() {
        return this.nextDuration;
    }

    public void setCheckinDays(Integer num) {
        this.checkinDays = num;
    }

    public void setCheckinToday(boolean z10) {
        this.checkinToday = Boolean.valueOf(z10);
    }

    public void setCoinList(List<Integer> list) {
        this.coinList = list;
    }

    public void setFullCheckinDays(Integer num) {
        this.fullCheckinDays = num;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setNextCoins(Integer num) {
        this.nextCoins = num;
    }

    public void setNextDuration(Integer num) {
        this.nextDuration = num;
    }

    public void setCheckinToday(Boolean bool) {
        this.checkinToday = bool;
    }
}
