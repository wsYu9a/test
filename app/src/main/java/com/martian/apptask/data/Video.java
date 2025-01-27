package com.martian.apptask.data;

import java.util.List;

/* loaded from: classes3.dex */
public class Video {
    private Integer duration;
    private Integer keepSeconds;
    private List<String> pageClickTrackers;
    private List<String> pageCloseTrackers;
    private List<String> playEndTrackers;
    private List<String> playInterruptTrackers;
    private List<String> playStartTrackers;
    private String url;
    private String vhtml;

    public Integer getDuration() {
        return this.duration;
    }

    public int getKeepSeconds() {
        Integer num = this.keepSeconds;
        if (num == null) {
            return 30;
        }
        if (num.intValue() <= 0) {
            return 3;
        }
        if (this.keepSeconds.intValue() > 60) {
            return 60;
        }
        return this.keepSeconds.intValue();
    }

    public List<String> getPageClickTrackers() {
        return this.pageClickTrackers;
    }

    public List<String> getPageCloseTrackers() {
        return this.pageCloseTrackers;
    }

    public List<String> getPlayEndTrackers() {
        return this.playEndTrackers;
    }

    public List<String> getPlayInterruptTrackers() {
        return this.playInterruptTrackers;
    }

    public List<String> getPlayStartTrackers() {
        return this.playStartTrackers;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVhtml() {
        return this.vhtml;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setKeepSeconds(Integer num) {
        this.keepSeconds = num;
    }

    public void setPageClickTrackers(List<String> list) {
        this.pageClickTrackers = list;
    }

    public void setPageCloseTrackers(List<String> list) {
        this.pageCloseTrackers = list;
    }

    public void setPlayEndTrackers(List<String> list) {
        this.playEndTrackers = list;
    }

    public void setPlayInterruptTrackers(List<String> list) {
        this.playInterruptTrackers = list;
    }

    public void setPlayStartTrackers(List<String> list) {
        this.playStartTrackers = list;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVhtml(String str) {
        this.vhtml = str;
    }
}
