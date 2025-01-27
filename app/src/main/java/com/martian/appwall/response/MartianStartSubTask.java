package com.martian.appwall.response;

/* loaded from: classes3.dex */
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
        Long l10 = this.startTime;
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    public int getStindex() {
        Integer num = this.stindex;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setStartTime(Long l10) {
        this.startTime = l10;
    }

    public void setStindex(Integer num) {
        this.stindex = num;
    }
}
