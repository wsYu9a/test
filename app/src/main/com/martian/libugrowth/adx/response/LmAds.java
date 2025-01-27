package com.martian.libugrowth.adx.response;

import java.util.List;

/* loaded from: classes3.dex */
public class LmAds {
    private List<LmAd> ads;
    private Double clickRate;
    private LmEnv env;
    private List<Float> exposeRate;
    private Integer internal;
    private Boolean ipControl;
    private Integer maxPageDuration;
    private Integer minPageDuration;
    private Integer pageRate;
    private String planId;
    private Integer reportTimeout;

    public List<LmAd> getAds() {
        return this.ads;
    }

    public Double getClickRate() {
        return this.clickRate;
    }

    public LmEnv getEnv() {
        return this.env;
    }

    public List<Float> getExposeRate() {
        return this.exposeRate;
    }

    public Integer getInternal() {
        return this.internal;
    }

    public boolean getIpControl() {
        Boolean bool = this.ipControl;
        return bool != null && bool.booleanValue();
    }

    public int getMaxPageDuration() {
        Integer num = this.maxPageDuration;
        if (num == null) {
            return 10;
        }
        return num.intValue();
    }

    public int getMinPageDuration() {
        Integer num = this.minPageDuration;
        if (num == null) {
            return 3;
        }
        return num.intValue();
    }

    public int getPageRate() {
        Integer num = this.pageRate;
        if (num == null) {
            return 65;
        }
        return num.intValue();
    }

    public String getPlanId() {
        return this.planId;
    }

    public long getReportTimeout() {
        if (this.reportTimeout == null) {
            return 3000L;
        }
        return r0.intValue() * 1000;
    }

    public void setAds(List<LmAd> list) {
        this.ads = list;
    }

    public void setClickRate(Double d10) {
        this.clickRate = d10;
    }

    public void setEnv(LmEnv lmEnv) {
        this.env = lmEnv;
    }

    public void setExposeRate(List<Float> list) {
        this.exposeRate = list;
    }

    public void setInternal(Integer num) {
        this.internal = num;
    }

    public void setIpControl(Boolean bool) {
        this.ipControl = bool;
    }

    public void setMaxPageDuration(Integer num) {
        this.maxPageDuration = num;
    }

    public void setMinPageDuration(Integer num) {
        this.minPageDuration = num;
    }

    public void setPageRate(Integer num) {
        this.pageRate = num;
    }

    public void setPlanId(String str) {
        this.planId = str;
    }

    public void setReportTimeout(Integer num) {
        this.reportTimeout = num;
    }
}
