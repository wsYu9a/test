package com.tencent.connect.auth;

/* loaded from: classes4.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: a */
    private String f22954a;

    /* renamed from: b */
    private String f22955b;

    /* renamed from: c */
    private String f22956c;

    /* renamed from: d */
    private int f22957d = 1;

    /* renamed from: e */
    private long f22958e = -1;

    public QQToken(String str) {
        this.f22954a = str;
    }

    public String getAccessToken() {
        return this.f22955b;
    }

    public String getAppId() {
        return this.f22954a;
    }

    public int getAuthSource() {
        return this.f22957d;
    }

    public long getExpireTimeInSecond() {
        return this.f22958e;
    }

    public String getOpenId() {
        return this.f22956c;
    }

    public boolean isSessionValid() {
        return this.f22955b != null && System.currentTimeMillis() < this.f22958e;
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f22955b = str;
        this.f22958e = 0L;
        if (str2 != null) {
            this.f22958e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f22954a = str;
    }

    public void setAuthSource(int i10) {
        this.f22957d = i10;
    }

    public void setOpenId(String str) {
        this.f22956c = str;
    }
}
