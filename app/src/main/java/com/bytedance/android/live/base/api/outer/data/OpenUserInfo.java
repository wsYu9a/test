package com.bytedance.android.live.base.api.outer.data;

/* loaded from: classes.dex */
public class OpenUserInfo {
    public final String avatar;
    private final String nickName;

    public OpenUserInfo(String str, String str2) {
        this.nickName = str;
        this.avatar = str2;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNickName() {
        return this.nickName;
    }
}
