package com.tencent.connect.auth;

/* loaded from: classes4.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: a */
    private String f25239a;

    /* renamed from: b */
    private String f25240b;

    /* renamed from: c */
    private String f25241c;

    /* renamed from: d */
    private int f25242d = 1;

    /* renamed from: e */
    private long f25243e = -1;

    public QQToken(String str) {
        this.f25239a = str;
    }

    public String getAccessToken() {
        return this.f25240b;
    }

    public String getAppId() {
        return this.f25239a;
    }

    public int getAuthSource() {
        return this.f25242d;
    }

    public long getExpireTimeInSecond() {
        return this.f25243e;
    }

    public String getOpenId() {
        return this.f25241c;
    }

    public boolean isSessionValid() {
        return this.f25240b != null && System.currentTimeMillis() < this.f25243e;
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f25240b = str;
        this.f25243e = 0L;
        if (str2 != null) {
            this.f25243e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f25239a = str;
    }

    public void setAuthSource(int i2) {
        this.f25242d = i2;
    }

    public void setOpenId(String str) {
        this.f25241c = str;
    }
}
