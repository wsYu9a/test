package com.alipay.sdk.util;

/* loaded from: classes.dex */
public enum f {
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
    NONE(-1, com.baidu.mobads.sdk.internal.a.f5472a);

    private int p;
    private String q;

    f(int i2, String str) {
        this.p = i2;
        this.q = str;
    }

    public static f a(int i2) {
        for (f fVar : values()) {
            if (fVar.p == i2) {
                return fVar;
            }
        }
        return NONE;
    }

    private int b() {
        return this.p;
    }

    public final String a() {
        return this.q;
    }
}
