package com.qq.e.comm.constants;

/* loaded from: classes3.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);


    /* renamed from: a, reason: collision with root package name */
    private int f16556a;

    LoginType(int i10) {
        this.f16556a = i10;
        ordinal();
    }

    public int getValue() {
        return this.f16556a;
    }
}
