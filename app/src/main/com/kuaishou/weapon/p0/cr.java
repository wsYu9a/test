package com.kuaishou.weapon.p0;

/* loaded from: classes2.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f10961a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f10962b = true;

    static {
        try {
            f10961a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", null).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", null).invoke(null, null), null)).booleanValue();
        } catch (Exception unused) {
            f10961a = false;
        }
        f10962b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f10961a;
    }

    public static boolean b() {
        return f10962b;
    }
}
