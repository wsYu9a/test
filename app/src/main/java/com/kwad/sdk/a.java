package com.kwad.sdk;

/* loaded from: classes2.dex */
public final class a {
    public static final a Yi = new a(10000, "其他异常");
    public static final a Yj = new a(10001, "初始化参数异常");
    public int code;
    public String msg;

    public a(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }
}
