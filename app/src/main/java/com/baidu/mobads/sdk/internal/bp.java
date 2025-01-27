package com.baidu.mobads.sdk.internal;

/* loaded from: classes2.dex */
public enum bp {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");


    /* renamed from: c, reason: collision with root package name */
    public static final String f6926c = "msg";

    /* renamed from: d, reason: collision with root package name */
    private int f6928d;

    /* renamed from: e, reason: collision with root package name */
    private String f6929e;

    bp(int i10, String str) {
        this.f6928d = i10;
        this.f6929e = str;
    }

    public int b() {
        return this.f6928d;
    }

    public String c() {
        return this.f6929e;
    }
}
