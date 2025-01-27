package com.martian.appwall.response;

/* loaded from: classes2.dex */
public class MartianStartSubTask {
    private Integer coins;
    private Long startTime;
    private Integer stindex;

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public long getStartTime() {
        Long l = this.startTime;
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public int getStindex() {
        Integer num = this.stindex;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setStindex(Integer stindex) {
        this.stindex = stindex;
    }
}
