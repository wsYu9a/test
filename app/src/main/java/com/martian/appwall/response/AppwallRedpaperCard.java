package com.martian.appwall.response;

/* loaded from: classes2.dex */
public class AppwallRedpaperCard {
    private String desc;
    private Boolean grabbed;
    private String iconUrl;
    private Boolean outOfGrab;
    private Long startTime;
    private String title;
    private Long vrid;

    public String getDesc() {
        return this.desc;
    }

    public Boolean getGrabbed() {
        Boolean bool = this.grabbed;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public Boolean getOutOfGrab() {
        Boolean bool = this.outOfGrab;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getVrid() {
        return this.vrid;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setGrabbed(Boolean grabbed) {
        this.grabbed = grabbed;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public void setOutOfGrab(Boolean outOfGrab) {
        this.outOfGrab = outOfGrab;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVrid(Long vrid) {
        this.vrid = vrid;
    }
}
