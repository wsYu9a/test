package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class PhoneCodeResponse {
    private Integer expireSeconds;
    private Integer requestIntervalSeconds;

    public int getExpireSeconds() {
        Integer num = this.expireSeconds;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getRequestIntervalSeconds() {
        Integer num = this.requestIntervalSeconds;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public void setRequestIntervalSeconds(Integer requestIntervalSeconds) {
        this.requestIntervalSeconds = requestIntervalSeconds;
    }
}
