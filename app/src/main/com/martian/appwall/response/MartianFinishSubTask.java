package com.martian.appwall.response;

/* loaded from: classes3.dex */
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

    public void setAppwallTasks(MartianAppwallTask martianAppwallTask) {
        this.appwallTask = martianAppwallTask;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }
}
