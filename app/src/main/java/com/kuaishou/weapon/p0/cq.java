package com.kuaishou.weapon.p0;

/* loaded from: classes.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f9225a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f9226b = true;

    static {
        try {
            f9225a = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f9225a = false;
        }
        f9226b = System.getProperty("java.vm.version").startsWith("2");
    }

    public static boolean a() {
        return f9225a;
    }

    public static boolean b() {
        return f9226b;
    }
}
