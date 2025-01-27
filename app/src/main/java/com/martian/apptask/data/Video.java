package com.martian.apptask.data;

import java.util.List;

/* loaded from: classes2.dex */
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

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setKeepSeconds(Integer keepSeconds) {
        this.keepSeconds = keepSeconds;
    }

    public void setPageClickTrackers(List<String> pageClickTrackers) {
        this.pageClickTrackers = pageClickTrackers;
    }

    public void setPageCloseTrackers(List<String> pageCloseTrackers) {
        this.pageCloseTrackers = pageCloseTrackers;
    }

    public void setPlayEndTrackers(List<String> playEndTrackers) {
        this.playEndTrackers = playEndTrackers;
    }

    public void setPlayInterruptTrackers(List<String> playInterruptTrackers) {
        this.playInterruptTrackers = playInterruptTrackers;
    }

    public void setPlayStartTrackers(List<String> playStartTrackers) {
        this.playStartTrackers = playStartTrackers;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVhtml(String vhtml) {
        this.vhtml = vhtml;
    }
}
