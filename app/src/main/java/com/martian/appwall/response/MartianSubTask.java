package com.martian.appwall.response;

/* loaded from: classes2.dex */
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
        Long l = this.completedTime;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
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

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setCompletedTime(Long completedTime) {
        this.completedTime = completedTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setIntervalDays(Integer intervalDays) {
        this.intervalDays = intervalDays;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUseDurationInMins(Integer useDurationInMins) {
        this.useDurationInMins = useDurationInMins;
    }
}
