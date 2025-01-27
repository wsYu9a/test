package com.bytedance.android.live.base.api.outer.data;

/* loaded from: classes.dex */
public class AnchorInfo {
    String avatar;
    long fansCount;
    String nickname;
    String openId;

    public AnchorInfo(String str, String str2, String str3, long j2) {
        this.openId = str;
        this.nickname = str2;
        this.avatar = str3;
        this.fansCount = j2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getFansCount() {
        return this.fansCount;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFansCount(long j2) {
        this.fansCount = j2;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }
}
