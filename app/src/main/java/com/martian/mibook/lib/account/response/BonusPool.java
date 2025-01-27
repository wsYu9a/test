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

    public void setCheckinDays(Integer checkinDays) {
        this.checkinDays = checkinDays;
    }

    public void setCheckinToday(boolean checkinToday) {
        this.checkinToday = Boolean.valueOf(checkinToday);
    }

    public void setCoinList(List<Integer> coinList) {
        this.coinList = coinList;
    }

    public void setFullCheckinDays(Integer fullCheckinDays) {
        this.fullCheckinDays = fullCheckinDays;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setNextCoins(Integer nextCoins) {
        this.nextCoins = nextCoins;
    }

    public void setNextDuration(Integer nextDuration) {
        this.nextDuration = nextDuration;
    }

    public void setCheckinToday(Boolean checkinToday) {
        this.checkinToday = checkinToday;
    }
}
