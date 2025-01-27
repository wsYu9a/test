package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.content.pm.ServiceInfo;

/* loaded from: classes4.dex */
public class SystemUtils {
    public static boolean checkServiceExists(Context context, String str, String str2) {
        try {
            for (ServiceInfo serviceInfo : context.getPackageManager().getPackageInfo(str, 4).services) {
                if (serviceInfo.exported && serviceInfo.enabled && serviceInfo.permission == null && serviceInfo.name.equals(str2)) {
                    return true;
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }
}
