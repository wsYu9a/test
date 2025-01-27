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

    public void setAdtype(Integer adtype) {
        this.adtype = adtype;
    }

    public void setCreative(String creative) {
        this.creative = creative;
    }

    public void setCtype(Integer ctype) {
        this.ctype = ctype;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setEvent(LmEvent event) {
        this.event = event;
    }

    public void setExt(LmEnv ext) {
        this.ext = ext;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
