package com.martian.mibook.j;

import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes4.dex */
public class u2 {
    public static void a(com.martian.libmars.activity.j1 activity, boolean force) {
        if (MiConfigSingleton.V3().x5()) {
            if (force || MiConfigSingleton.V3().y6()) {
                try {
                    MiConfigSingleton.V3().a7();
                    if (com.martian.libcomm.utils.f.b(activity)) {
                        com.martian.mibook.lib.account.e.c.a(activity, 1000, com.martian.libcomm.utils.f.a(), null);
                    }
                    if (com.martian.libcomm.utils.c.i()) {
                        com.martian.mibook.lib.account.e.c.a(activity, 1001, "", null);
                    }
                    if (!com.martian.libsupport.k.p(MiConfigSingleton.V3().z())) {
                        String p8 = MiConfigSingleton.V3().p8(MiConfigSingleton.V3().z());
                        if (!com.martian.libsupport.k.p(p8)) {
                            com.martian.mibook.lib.account.e.c.a(activity, 1003, p8, null);
                        }
                    }
                    String Z3 = MiConfigSingleton.V3().Z3(activity);
                    if (com.martian.libsupport.k.p(Z3)) {
                        return;
                    }
                    com.martian.mibook.lib.account.e.c.a(activity, 1005, Z3, null);
                } catch (Exception unused) {
                }
            }
        }
    }
}
