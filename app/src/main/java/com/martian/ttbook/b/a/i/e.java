package com.martian.ttbook.b.a.i;

/* loaded from: classes4.dex */
public class e {
    public static Class a() {
        try {
            return Class.forName("com.martian.ttbook.sdk.adcomponents.adsdk.JhSdkDownloadNotifyClickReceiver");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void b(String str) {
        Class a2 = a();
        if (a2 != null) {
            try {
                a2.getDeclaredMethod("remove", String.class).invoke(a2, str);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(String str, l lVar) {
        b.d.e.c.a.d.k("APINFICLCKRIVER", "register enter , url = " + str);
        Class a2 = a();
        if (a2 != null) {
            try {
                a2.getDeclaredMethod("register", String.class, l.class).invoke(a2, str, lVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
