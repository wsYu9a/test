package com.bytedance.sdk.openadsdk;

/* loaded from: classes.dex */
public class CSJAdError {

    /* renamed from: j, reason: collision with root package name */
    private int f6352j;
    private String zx;

    public CSJAdError(int i2, String str) {
        this.f6352j = i2;
        this.zx = str;
    }

    public int getCode() {
        return this.f6352j;
    }

    public String getMsg() {
        return this.zx;
    }
}
