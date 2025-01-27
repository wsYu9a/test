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

/* loaded from: classes3.dex */
public final class av {
    private static String aUk = "";
    private static volatile Boolean aUl;

    private static String NV() {
        String processName;
        if (Build.VERSION.SDK_INT < 28) {
            return "";
        }
        processName = Application.getProcessName();
        return processName;
    }

    private static String NW() {
        try {
            Object callStaticMethod = w.callStaticMethod(Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()), "currentProcessName", new Object[0]);
            return callStaticMethod instanceof String ? (String) callStaticMethod : "";
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private static String cL(@NonNull Context context) {
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
        if (!TextUtils.isEmpty(aUk)) {
            return aUk;
        }
        String NV = NV();
        aUk = NV;
        if (!TextUtils.isEmpty(NV)) {
            return aUk;
        }
        String NW = NW();
        aUk = NW;
        if (!TextUtils.isEmpty(NW)) {
            return aUk;
        }
        String cL = cL(context);
        aUk = cL;
        return cL;
    }

    public static boolean isInMainProcess(Context context) {
        if (aUl == null) {
            String processName = getProcessName(context);
            aUl = Boolean.valueOf(!TextUtils.isEmpty(processName) && processName.equals(context.getPackageName()));
        }
        return aUl.booleanValue();
    }
}
