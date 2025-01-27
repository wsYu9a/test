package com.martian.libugrowth.adx.response;

/* loaded from: classes3.dex */
public class LmAd {
    private Integer adtype;
    private String creative;
    private Integer ctype;
    private Integer delay;
    private Integer duration;
    private LmEvent event;
    private LmEnv ext;
    private Integer idx;
    private Integer mid;
    private String page;

    public Integer getAdtype() {
        return this.adtype;
    }

    public String getCreative() {
        return this.creative;
    }

    public Integer getCtype() {
        return this.ctype;
    }

    public Integer getDelay() {
        return this.delay;
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public LmEvent getEvent() {
        return this.event;
    }

    public LmEnv getExt() {
        return this.ext;
    }

    public Integer getIdx() {
        return this.idx;
    }

    public Integer getMid() {
        return this.mid;
    }

    public String getPage() {
        return this.page;
    }

    public void setAdtype(Integer num) {
        this.adtype = num;
    }

    public void setCreative(String str) {
        this.creative = str;
    }

    public void setCtype(Integer num) {
        this.ctype = num;
    }

    public void setDelay(Integer num) {
        this.delay = num;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setEvent(LmEvent lmEvent) {
        this.event = lmEvent;
    }

    public void setExt(LmEnv lmEnv) {
        this.ext = lmEnv;
    }

    public void setIdx(Integer num) {
        this.idx = num;
    }

    public void setMid(Integer num) {
        this.mid = num;
    }

    public void setPage(String str) {
        this.page = str;
    }
}
