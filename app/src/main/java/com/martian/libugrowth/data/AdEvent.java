package com.martian.libugrowth.data;

/* loaded from: classes3.dex */
public class AdEvent {
    private Boolean bidding;
    private Integer ecpm;
    private Integer requestTime;
    private String type;
    private Integer value;
    private Integer waterfallCount;
    private Integer waterfallTime;

    public Boolean getBidding() {
        return this.bidding;
    }

    public Integer getEcpm() {
        return this.ecpm;
    }

    public Integer getRequestTime() {
        return this.requestTime;
    }

    public String getType() {
        return this.type;
    }

    public Integer getValue() {
        return this.value;
    }

    public Integer getWaterfallCount() {
        return this.waterfallCount;
    }

    public Integer getWaterfallTime() {
        return this.waterfallTime;
    }

    public void increaseEcpm(int i10) {
        if (this.ecpm == null) {
            this.ecpm = 0;
        }
        this.ecpm = Integer.valueOf(this.ecpm.intValue() + i10);
    }

    public void increaseRequestTime(int i10, int i11) {
        if (this.requestTime == null) {
            this.requestTime = 0;
        }
        this.requestTime = Integer.valueOf(this.requestTime.intValue() + i10);
        if (i11 > 0) {
            increaseWaterfallTime(i10);
            increaseWaterfallCount(i11);
        }
    }

    public void increaseWaterfallCount(int i10) {
        if (this.waterfallCount == null) {
            this.waterfallCount = 0;
        }
        this.waterfallCount = Integer.valueOf(this.waterfallCount.intValue() + i10);
    }

    public void increaseWaterfallTime(int i10) {
        if (this.waterfallTime == null) {
            this.waterfallTime = 0;
        }
        this.waterfallTime = Integer.valueOf(this.waterfallTime.intValue() + i10);
    }

    public void inrcValue() {
        if (this.value == null) {
            this.value = 1;
        }
        this.value = Integer.valueOf(this.value.intValue() + 1);
    }

    public void setBidding(Boolean bool) {
        this.bidding = bool;
    }

    public AdEvent setEcpm(Integer num) {
        this.ecpm = num;
        return this;
    }

    public void setRequestTime(Integer num) {
        this.requestTime = num;
    }

    public AdEvent setType(String str) {
        this.type = str;
        return this;
    }

    public AdEvent setValue(Integer num) {
        this.value = num;
        return this;
    }

    public void setWaterfallCount(Integer num) {
        this.waterfallCount = num;
    }

    public void setWaterfallTime(Integer num) {
        this.waterfallTime = num;
    }
}
