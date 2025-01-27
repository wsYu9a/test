package com.kwad.sdk.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;

/* loaded from: classes2.dex */
public final class ap {
    private static String aAi = "";
    private static volatile Boolean aAj;

    private static String DO() {
        return Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
    }

    private static String DP() {
        try {
            Object b2 = s.b(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return b2 instanceof String ? (String) b2 : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static String cj(@NonNull Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return "";
    }

    public static String getProcessName(@NonNull Context context) {
        if (!TextUtils.isEmpty(aAi)) {
            return aAi;
        }
        String DO = DO();
        aAi = DO;
        if (!TextUtils.isEmpty(DO)) {
            return aAi;
        }
        String DP = DP();
        aAi = DP;
        if (!TextUtils.isEmpty(DP)) {
            return aAi;
        }
        String cj = cj(context);
        aAi = cj;
        return cj;
    }

    public static boolean isInMainProcess(Context context) {
        if (aAj == null) {
            String processName = getProcessName(context);
            aAj = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return aAj.booleanValue();
    }
}
