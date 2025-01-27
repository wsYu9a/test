package v2;

import p3.f;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static boolean f31217a = false;

    /* renamed from: b */
    public static String f31218b;

    public static String a() {
        com.alipay.sdk.m.j.c b10 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.CANCELED.b());
        return b(b10.b(), b10.a(), "");
    }

    public static String b(int i10, String str, String str2) {
        return "resultStatus={" + i10 + "};memo={" + str + "};result={" + str2 + f.f29748d;
    }

    public static void c(String str) {
        f31218b = str;
    }

    public static void d(boolean z10) {
        f31217a = z10;
    }

    public static String e() {
        com.alipay.sdk.m.j.c b10 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.DOUBLE_REQUEST.b());
        return b(b10.b(), b10.a(), "");
    }

    public static boolean f() {
        return f31217a;
    }

    public static String g() {
        return f31218b;
    }

    public static String h() {
        com.alipay.sdk.m.j.c b10 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.PARAMS_ERROR.b());
        return b(b10.b(), b10.a(), "");
    }
}
