package com.martian.appwall.response;

/* loaded from: classes2.dex */
public class MartianFinishSubTask {
    private MartianAppwallTask appwallTask;
    private Integer coins;
    private Integer duration;
    private Integer money;

    public MartianAppwallTask getAppwallTasks() {
        return this.appwallTask;
    }

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getDuration() {
        Integer num = this.duration;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setAppwallTasks(MartianAppwallTask appwallTask) {
        this.appwallTask = appwallTask;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
