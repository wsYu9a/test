package com.umeng.commonsdk.internal.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: com.umeng.commonsdk.internal.utils.a$a */
    public static class C0673a {

        /* renamed from: a */
        public String f24515a;

        /* renamed from: b */
        public String f24516b;
    }

    public static long a(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo a10 = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a10 != null) {
                return a10.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            ULog.e("getAppFirstInstallTime" + th2.getMessage());
            return 0L;
        }
    }

    public static void b(Context context) {
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            ULog.e("getAppInstaller:" + e10.getMessage());
            return null;
        }
    }

    public static int d(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo a10 = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a10 == null || (applicationInfo = a10.applicationInfo) == null) {
                return 0;
            }
            return applicationInfo.uid;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            ULog.e("getAppUid:" + th2.getMessage());
            return 0;
        }
    }

    public static DisplayMetrics e(Context context) {
        if (context == null) {
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static List<C0673a> f(Context context) {
        String[] list;
        if (context == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Android/data/");
            if (file.isDirectory() && (list = file.list()) != null && list.length > 0) {
                for (String str : list) {
                    if (str != null && !str.startsWith(p1.b.f29697h)) {
                        C0673a c0673a = new C0673a();
                        c0673a.f24515a = str;
                        c0673a.f24516b = e(context, str);
                        arrayList.add(c0673a);
                    }
                }
            }
        } catch (Exception e10) {
            ULog.e("getAppList:" + e10.getMessage());
        }
        return arrayList;
    }

    public static ActivityManager.MemoryInfo g(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String h(Context context) {
        return null;
    }

    public static String i(Context context) {
        return null;
    }

    public static long b(Context context, String str) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo a10 = com.umeng.commonsdk.utils.b.a().a(context, str, 64);
            if (a10 != null) {
                return a10.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            ULog.e("getAppLastUpdateTime:" + th2.getMessage());
            return 0L;
        }
    }

    private static String e(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return (String) applicationInfo.loadLabel(context.getPackageManager());
            }
            return null;
        } catch (Exception e10) {
            ULog.e("getLabel:" + e10.getMessage());
            return null;
        }
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier(com.gyf.immersionbar.b.f10638c, "dimen", "android"));
    }

    public static boolean a() {
        return h.a();
    }

    public static float a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Configuration configuration = new Configuration();
        try {
            configuration.updateFrom(context.getResources().getConfiguration());
            return configuration.fontScale;
        } catch (Exception e10) {
            ULog.e("getFontSize:" + e10.getMessage());
            return 0.0f;
        }
    }

    public static String b() {
        return new SimpleDateFormat().format(new Date());
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier(com.gyf.immersionbar.b.f10639d, "dimen", "android"));
    }

    public static long c() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String d() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : HelperUtils.getUmengMD5(obj);
        } catch (Exception e10) {
            ULog.e("getHostName:" + e10.getMessage());
            return null;
        }
    }
}
