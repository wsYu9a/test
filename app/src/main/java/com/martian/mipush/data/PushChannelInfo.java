package com.martian.mipush.data;

/* loaded from: classes.dex */
public class PushChannelInfo {
    private String channelDesc;
    private String channelId;
    private String channelName;
    private boolean withSound;

    public PushChannelInfo(String id, String name, String desc, boolean withSound) {
        this.channelId = id;
        this.channelName = name;
        this.channelDesc = desc;
        this.withSound = withSound;
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

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public void setWithSound(boolean withSound) {
        this.withSound = withSound;
    }
}
