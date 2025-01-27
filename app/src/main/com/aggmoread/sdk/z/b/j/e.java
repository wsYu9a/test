package com.aggmoread.sdk.z.b.j;

/* loaded from: classes.dex */
public class e {
    public static Class a() {
        try {
            return Class.forName("com.aggmoread.sdk.a.adcomm.amsdk.AMCustomBroadReceiver");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(String str) {
        Class a10 = a();
        if (a10 != null) {
            try {
                a10.getDeclaredMethod("remove", String.class).invoke(a10, str);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void a(String str, l lVar) {
        com.aggmoread.sdk.z.b.d.c("APINFICLCKRIVER", "register enter , url = " + str);
        Class a10 = a();
        if (a10 != null) {
            try {
                a10.getDeclaredMethod("register", String.class, l.class).invoke(a10, str, lVar);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
