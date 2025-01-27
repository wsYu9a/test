package com.kuaishou.weapon.p0;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class ak {
    public static boolean a(Context context) {
        if (!g.a(context, new String[]{g.f9324i})) {
            return false;
        }
        String[] strArr = {"/storage/emulated/0/DCIM/Camera/virtual.mp4", "/storage/emulated/0/DCIM/Camera1/virtual.mp4"};
        for (int i2 = 0; i2 < 2; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }
}
