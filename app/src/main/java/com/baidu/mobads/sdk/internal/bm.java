package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public enum bm {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");


    /* renamed from: c, reason: collision with root package name */
    public static final String f5615c = "msg";

    /* renamed from: d, reason: collision with root package name */
    private int f5617d;

    /* renamed from: e, reason: collision with root package name */
    private String f5618e;

    bm(int i2, String str) {
        this.f5617d = i2;
        this.f5618e = str;
    }

    public int b() {
        return this.f5617d;
    }

    public String c() {
        return this.f5618e;
    }
}
