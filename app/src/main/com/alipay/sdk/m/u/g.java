package com.alipay.sdk.m.u;

/* loaded from: classes.dex */
public enum g {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NETWORK_TYPE_20(20, "5G"),
    NONE(-1, "none");


    /* renamed from: a, reason: collision with root package name */
    public int f6610a;

    /* renamed from: b, reason: collision with root package name */
    public String f6611b;

    g(int i10, String str) {
        this.f6610a = i10;
        this.f6611b = str;
    }

    public final int a() {
        return this.f6610a;
    }

    public final String b() {
        return this.f6611b;
    }

    public static g a(int i10) {
        for (g gVar : values()) {
            if (gVar.a() == i10) {
                return gVar;
            }
        }
        return NONE;
    }
}
