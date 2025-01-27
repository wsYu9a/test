package com.shu.priory.bean;

/* loaded from: classes3.dex */
public class AdAudio {
    private int bitrate;
    private long cacheDeadLine;
    private int duration;
    private int format;
    private String url;

    public int getBitrate() {
        return this.bitrate;
    }

    public long getCacheDeadLine() {
        return this.cacheDeadLine;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFormat() {
        return this.format;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBitrate(int i10) {
        this.bitrate = i10;
    }

    public void setCacheDeadLine(long j10) {
        this.cacheDeadLine = j10;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setFormat(int i10) {
        this.format = i10;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
