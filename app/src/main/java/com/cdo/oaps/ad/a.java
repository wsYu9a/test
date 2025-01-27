package com.cdo.oaps.ad;

import android.util.Base64;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f6499a = "Y29tLm9uZXBsdXMubWFya2V0";

    /* renamed from: b, reason: collision with root package name */
    public static final String f6500b = "Y29tLm9wcG8ubWFya2V0";

    /* renamed from: c, reason: collision with root package name */
    public static final String f6501c = "b3Bwbw==";

    public static String a() {
        return b(f6499a);
    }

    public static String a(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    public static String b() {
        return b(f6500b);
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static String c() {
        return b(f6501c);
    }
}
