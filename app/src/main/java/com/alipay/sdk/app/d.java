package com.alipay.sdk.app;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public static String f5308a;

    public static String a() {
        ac a2 = ac.a(ac.CANCELED.a());
        return b(a2.a(), a2.b(), "");
    }

    public static String b(int i2, String str, String str2) {
        return "resultStatus={" + i2 + "};memo={" + str + "};result={" + str2 + "}";
    }

    private static void c(String str) {
        f5308a = str;
    }

    public static String d() {
        ac a2 = ac.a(ac.PARAMS_ERROR.a());
        return b(a2.a(), a2.b(), "");
    }

    private static String e() {
        return f5308a;
    }
}
