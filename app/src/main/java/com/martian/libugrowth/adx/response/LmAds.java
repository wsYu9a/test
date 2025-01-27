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

    public void setAds(List<LmAd> ads) {
        this.ads = ads;
    }

    public void setClickRate(Double clickRate) {
        this.clickRate = clickRate;
    }

    public void setEnv(LmEnv env) {
        this.env = env;
    }

    public void setExposeRate(List<Float> exposeRate) {
        this.exposeRate = exposeRate;
    }

    public void setInternal(Integer internal) {
        this.internal = internal;
    }

    public void setIpControl(Boolean ipControl) {
        this.ipControl = ipControl;
    }

    public void setMaxPageDuration(Integer maxPageDuration) {
        this.maxPageDuration = maxPageDuration;
    }

    public void setMinPageDuration(Integer minPageDuration) {
        this.minPageDuration = minPageDuration;
    }

    public void setPageRate(Integer pageRate) {
        this.pageRate = pageRate;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setReportTimeout(Integer reportTimeout) {
        this.reportTimeout = reportTimeout;
    }
}
