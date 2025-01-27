package com.alipay.sdk.app;

/* loaded from: classes.dex */
public class EnvUtils {

    /* renamed from: a, reason: collision with root package name */
    public static EnvEnum f6491a = EnvEnum.ONLINE;

    public enum EnvEnum {
        ONLINE,
        PRE_SANDBOX,
        SANDBOX
    }

    public static EnvEnum a() {
        return f6491a;
    }

    public static boolean b() {
        return f6491a == EnvEnum.SANDBOX;
    }

    public static boolean c() {
        return f6491a == EnvEnum.PRE_SANDBOX;
    }

    public static boolean d() {
        return c() || b();
    }

    public static void e(EnvEnum envEnum) {
        f6491a = envEnum;
    }
}
