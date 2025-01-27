package com.martian.appwall.response;

/* loaded from: classes3.dex */
public class MartianSubTask {
    private Integer coins;
    private Long completedTime;
    private Integer duration;
    private Integer intervalDays;
    private Integer money;
    private Integer useDurationInMins;
    private String content = "";
    private String status = "";

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public long getCompletedTime() {
        Long l10 = this.completedTime;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public String getContent() {
        return this.content;
    }

    public Integer getDuration() {
        Integer num = this.duration;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public int getIntervalDays() {
        Integer num = this.intervalDays;
        if (num == null) {
            return 0;
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

    public String getStatus() {
        return this.status;
    }

    public int getUserDurationInMins() {
        Integer num = this.useDurationInMins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setCompletedTime(Long l10) {
        this.completedTime = l10;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setIntervalDays(Integer num) {
        this.intervalDays = num;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUseDurationInMins(Integer num) {
        this.useDurationInMins = num;
    }
}
