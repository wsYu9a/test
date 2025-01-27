package com.ss.android.downloadlib.lg;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.w;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class nt {
    private static Object[] zx = new Object[0];

    /* renamed from: i */
    private static Object[] f24333i = new Object[73];

    /* renamed from: j */
    static final char[] f24334j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: g */
    private static String f24332g = null;

    public static boolean g(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pa.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static Intent gv(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        return launchIntentForPackage;
    }

    public static Drawable i(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static File k(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        Logger.d("ToolUtils", sb.toString());
        return file;
    }

    public static Signature[] lg(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean q(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 <= packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Signature[] y(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean zx(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static long j(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.i.zx.j(jSONObject, str);
    }

    public static int zx(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @WorkerThread
    public static boolean i(String str) {
        File file;
        Context context = com.ss.android.downloadlib.addownload.pa.getContext();
        if (TextUtils.isEmpty(str) || !g(context, str)) {
            return false;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.pa.k().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.pa.k().optInt("get_ext_dir_mode") == 1) {
                file = k(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/" + str);
            }
            if (!file.exists()) {
                return false;
            }
            long j2 = lg.j(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < j2) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static JSONObject j(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.i.zx.j(jSONObject, jSONObject2);
    }

    @NonNull
    public static JSONObject j(JSONObject jSONObject) {
        return com.ss.android.download.api.i.zx.j(jSONObject);
    }

    @NonNull
    public static JSONObject j(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.i.zx.j(jSONObjectArr);
    }

    public static boolean j(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return !queryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean zx(com.ss.android.downloadad.api.j.zx zxVar) {
        if (zxVar == null) {
            return false;
        }
        return j(zxVar.q(), zxVar.xj(), zxVar.b()).j();
    }

    public static boolean zx(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.pa.getContext();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static PackageInfo j(com.ss.android.downloadad.api.j.zx zxVar) {
        DownloadInfo downloadInfo;
        if (zxVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.pa.getContext()).getDownloadInfo(zxVar.v())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.i.j(com.ss.android.downloadlib.addownload.pa.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Drawable j(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void zx() {
        try {
            if (com.ss.android.downloadlib.addownload.pa.q().j(com.ss.android.downloadlib.addownload.pa.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.pa.getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.pa.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @NonNull
    public static HashMap<String, String> zx(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hashMap;
    }

    public static com.ss.android.downloadlib.addownload.zx.i j(String str, int i2, String str2) {
        com.ss.android.downloadlib.addownload.zx.i iVar = new com.ss.android.downloadlib.addownload.zx.i();
        if (TextUtils.isEmpty(str)) {
            return iVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.pa.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                iVar.zx(packageInfo.versionCode);
                iVar.j(com.ss.android.downloadlib.addownload.zx.i.zx);
                w lg = com.ss.android.downloadlib.addownload.pa.lg();
                if (lg != null && lg.j() && !j(packageInfo.versionCode, i2, packageInfo.versionName, str2)) {
                    iVar.j(com.ss.android.downloadlib.addownload.zx.i.f24227i);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iVar;
    }

    private static boolean j(int i2, int i3, String str, String str2) {
        if (i3 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i3 > 0 && i2 >= i3) || j(str, str2) >= 0;
    }

    public static boolean j(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return j(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).j();
    }

    public static boolean j(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 == packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean j(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < signatureArr.length; i2++) {
            if ((signatureArr[i2] == null && signatureArr2[i2] != null) || (signatureArr[i2] != null && !signatureArr[i2].equals(signatureArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    public static int j(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String j(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static int j(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i2 = 0;
                int i3 = 0;
                while (i2 < min) {
                    i3 = Integer.parseInt(split[i2]) - Integer.parseInt(split2[i2]);
                    if (i3 != 0) {
                        break;
                    }
                    i2++;
                }
                if (i3 != 0) {
                    return i3 > 0 ? 1 : -1;
                }
                for (int i4 = i2; i4 < split.length; i4++) {
                    if (Integer.parseInt(split[i4]) > 0) {
                        return 1;
                    }
                }
                while (i2 < split2.length) {
                    if (Integer.parseInt(split2[i2]) > 0) {
                        return -1;
                    }
                    i2++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String j(String... strArr) {
        return com.ss.android.download.api.i.zx.j(strArr);
    }

    @NonNull
    public static <T> T j(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static long j(long j2) {
        try {
            return j(Environment.getExternalStorageDirectory(), j2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    public static long j(File file, long j2) {
        if (file == null) {
            return j2;
        }
        try {
            return DownloadUtils.getAvailableSpaceBytes(file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    public static long j(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static boolean j() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void j(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
