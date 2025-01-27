package com.martian.mipush.data;

/* loaded from: classes3.dex */
public class PushChannelInfo {
    private String channelDesc;
    private String channelId;
    private String channelName;
    private boolean withSound;

    public PushChannelInfo(String str, String str2, String str3, boolean z10) {
        this.channelId = str;
        this.channelName = str2;
        this.channelDesc = str3;
        this.withSound = z10;
    }

    public String getChannelDesc() {
        return this.channelDesc;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public boolean isWithSound() {
        return this.withSound;
    }

    public void setChannelDesc(String str) {
        this.channelDesc = str;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setChannelName(String str) {
        this.channelName = str;
    }

    public void setWithSound(boolean z10) {
        this.withSound = z10;
    }
}
