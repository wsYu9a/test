package c7;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a */
    public static final int f1749a = 26;

    public static String a(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e10) {
            e.c(e10);
            return PointCategory.APP;
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e10) {
            e.c(e10);
            return "0";
        }
    }

    public static String c(int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 : iArr) {
            sb2.append((char) i10);
        }
        return sb2.toString();
    }

    public static String d(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (IllegalArgumentException e10) {
            throw e10;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int f(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e10) {
            e.a("getVersionCode--Exception:" + e10.getMessage());
            return 0;
        }
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "0";
        }
    }

    public static String h(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e10) {
            e.a("getVersionName--Exception:" + e10.getMessage());
            return null;
        }
    }

    public static boolean i(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            e.d("isExistPackage NameNotFoundException:" + e10.getMessage());
            return false;
        }
    }

    public static boolean j(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e10) {
            e.d("isSupportPush NameNotFoundException:" + e10.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    public static int k(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e10) {
                e.d("parseInt--NumberFormatException" + e10.getMessage());
            }
        }
        return -1;
    }
}
