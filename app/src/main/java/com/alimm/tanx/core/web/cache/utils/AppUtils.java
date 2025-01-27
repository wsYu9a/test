package com.alimm.tanx.core.web.cache.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public class AppUtils {
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return 0;
        }
    }
}
