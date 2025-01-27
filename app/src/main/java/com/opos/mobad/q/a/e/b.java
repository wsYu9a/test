package com.opos.mobad.q.a.e;

import com.opos.mobad.model.data.AdItemData;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static boolean f23247a = true;

    public static void a(boolean z) {
        f23247a = z;
    }

    public static boolean a(AdItemData adItemData) {
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "sPlayRemindAtCellular=" + f23247a);
        boolean z = false;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("WifiPlayUtils", "", (Throwable) e2);
        }
        if (f23247a) {
            if (adItemData != null && !adItemData.t()) {
                f23247a = false;
            }
            z = true;
        }
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "checkPlayConfirm=" + z);
        return z;
    }
}
