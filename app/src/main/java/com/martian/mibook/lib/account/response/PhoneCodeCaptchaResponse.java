package com.martian.mibook.lib.account.response;

/* loaded from: classes3.dex */
public class PhoneCodeCaptchaResponse {
    private Integer expireSeconds;
    private String token;

    public int getExpireSeconds() {
        Integer num = this.expireSeconds;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getToken() {
        return this.token;
    }

    public void setExpireSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
