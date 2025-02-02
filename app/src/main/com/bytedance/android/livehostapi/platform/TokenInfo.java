package com.bytedance.android.livehostapi.platform;

/* loaded from: classes2.dex */
public class TokenInfo {
    public String accessToken;
    public long expireAt;
    public String name;
    public String openId;

    public TokenInfo() {
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getExpireAt() {
        return this.expireAt;
    }

    public String getName() {
        return this.name;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setExpireAt(long j10) {
        this.expireAt = j10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpenId(String str) {
        this.openId = str;
    }

    public TokenInfo(String str, String str2, String str3, long j10) {
        this.name = str;
        this.openId = str2;
        this.accessToken = str3;
        this.expireAt = j10;
    }
}
