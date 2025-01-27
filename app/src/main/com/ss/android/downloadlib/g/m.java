package com.ss.android.downloadlib.g;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ComponentName;
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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.config.o;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class m {

    /* renamed from: b */
    private static Object[] f21669b = new Object[0];

    /* renamed from: c */
    private static Object[] f21670c = new Object[73];

    /* renamed from: a */
    static final char[] f21668a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: d */
    private static String f21671d = null;

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String c(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Drawable d(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean e(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
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

    public static boolean f(Context context, String str) {
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
            int i10 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i10 <= packageInfo.versionCode;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static Intent g(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Signature[] h(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static Signature[] i(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static File j(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getExtDir: file.toString()-->");
        sb2.append(file.toString());
        Logger.d("ToolUtils", sb2.toString());
        return file;
    }

    public static long a(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.c.b.a(jSONObject, str);
    }

    public static int b(Context context, String str) {
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

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.c.b.a(jSONObject, jSONObject2);
    }

    @NonNull
    public static JSONObject a(JSONObject jSONObject) {
        return com.ss.android.download.api.c.b.a(jSONObject);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (r3 != false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r1 > 29) goto L98;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r7) {
        /*
            android.content.Context r0 = com.ss.android.downloadlib.addownload.k.a()
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            r2 = 0
            if (r1 == 0) goto Lc
            return r2
        Lc:
            boolean r1 = e(r0, r7)
            if (r1 != 0) goto L13
            return r2
        L13:
            android.content.pm.ApplicationInfo r1 = r0.getApplicationInfo()
            int r1 = r1.targetSdkVersion
            org.json.JSONObject r3 = com.ss.android.downloadlib.addownload.k.j()
            java.lang.String r4 = "get_ext_dir_mode"
            int r3 = r3.optInt(r4)
            r5 = 1
            r6 = 29
            if (r3 != 0) goto L37
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r6) goto L37
            if (r1 != r6) goto L34
            boolean r3 = y3.a.a()
            if (r3 == 0) goto L36
        L34:
            if (r1 <= r6) goto L37
        L36:
            return r5
        L37:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L52
            if (r1 < r6) goto L54
            android.content.pm.ApplicationInfo r1 = r0.getApplicationInfo()     // Catch: java.lang.Exception -> L52
            int r1 = r1.targetSdkVersion     // Catch: java.lang.Exception -> L52
            if (r1 < r6) goto L54
            org.json.JSONObject r1 = com.ss.android.downloadlib.addownload.k.j()     // Catch: java.lang.Exception -> L52
            int r1 = r1.optInt(r4)     // Catch: java.lang.Exception -> L52
            if (r1 != r5) goto L54
            java.io.File r1 = j(r0, r7)     // Catch: java.lang.Exception -> L52
            goto L72
        L52:
            r7 = move-exception
            goto L8f
        L54:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L52
            java.io.File r3 = android.os.Environment.getExternalStorageDirectory()     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Exception -> L52
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L52
            r4.<init>()     // Catch: java.lang.Exception -> L52
            java.lang.String r6 = "android/data/"
            r4.append(r6)     // Catch: java.lang.Exception -> L52
            r4.append(r7)     // Catch: java.lang.Exception -> L52
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L52
            r1.<init>(r3, r4)     // Catch: java.lang.Exception -> L52
        L72:
            boolean r3 = r1.exists()     // Catch: java.lang.Exception -> L52
            if (r3 != 0) goto L79
            return r2
        L79:
            long r3 = com.ss.android.downloadlib.g.g.a(r1)     // Catch: java.lang.Exception -> L52
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L52
            android.content.pm.PackageInfo r7 = r0.getPackageInfo(r7, r2)     // Catch: java.lang.Exception -> L52
            if (r7 == 0) goto L8e
            long r0 = r7.lastUpdateTime     // Catch: java.lang.Exception -> L52
            int r7 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r7 >= 0) goto L8e
            return r5
        L8e:
            return r2
        L8f:
            r7.printStackTrace()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.g.m.c(java.lang.String):boolean");
    }

    @NonNull
    public static JSONObject a(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.c.b.a(jSONObjectArr);
    }

    public static boolean a(Context context, Intent intent) {
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

    public static boolean b(com.ss.android.downloadad.api.a.b bVar) {
        if (bVar == null) {
            return false;
        }
        return a(bVar.e(), bVar.I(), bVar.J()).a();
    }

    public static boolean b(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.a();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static String a(long j10) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j10 >= DownloadConstants.GB) {
            return (j10 / DownloadConstants.GB) + "G";
        }
        if (j10 >= 1048576) {
            return (j10 / 1048576) + "M";
        }
        return decimalFormat.format(j10 / 1048576.0f) + "M";
    }

    public static long b(long j10) {
        try {
            return a(Environment.getExternalStorageDirectory(), j10);
        } catch (Exception e10) {
            e10.printStackTrace();
            return j10;
        }
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static PackageInfo a(com.ss.android.downloadad.api.a.b bVar) {
        DownloadInfo downloadInfo;
        if (bVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.a()).getDownloadInfo(bVar.s())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.c.a(com.ss.android.downloadlib.addownload.k.a(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    public static HashMap<String, String> b(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return hashMap;
    }

    public static Drawable a(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void c() {
        ComponentName componentName;
        try {
            if (com.ss.android.downloadlib.addownload.k.f().a(com.ss.android.downloadlib.addownload.k.a(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.k.a().getSystemService(TTDownloadField.TT_ACTIVITY);
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    String packageName = com.ss.android.downloadlib.addownload.k.a().getPackageName();
                    componentName = runningTaskInfo.topActivity;
                    if (packageName.equals(componentName.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static com.ss.android.downloadlib.addownload.b.c a(String str, int i10, String str2) {
        com.ss.android.downloadlib.addownload.b.c cVar = new com.ss.android.downloadlib.addownload.b.c();
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.k.a().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                cVar.b(packageInfo.versionCode);
                cVar.a(com.ss.android.downloadlib.addownload.b.c.f21199b);
                o h10 = com.ss.android.downloadlib.addownload.k.h();
                if (h10 != null && h10.a() && !a(packageInfo.versionCode, i10, packageInfo.versionName, str2)) {
                    cVar.a(com.ss.android.downloadlib.addownload.b.c.f21200c);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return cVar;
    }

    private static boolean a(int i10, int i11, String str, String str2) {
        if (i11 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i11 > 0 && i10 >= i11) || a(str, str2) >= 0;
    }

    public static boolean a(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return a(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).a();
    }

    public static boolean a(Context context, String str, String str2) {
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
            int i10 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i10 == packageInfo.versionCode;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < signatureArr.length; i10++) {
            Signature signature = signatureArr[i10];
            if ((signature == null && signatureArr2[i10] != null) || (signature != null && !signature.equals(signatureArr2[i10]))) {
                return false;
            }
        }
        return true;
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String a(String str, int i10) {
        if (i10 == 0) {
            return "";
        }
        return (TextUtils.isEmpty(str) || str.length() <= i10) ? str : str.substring(0, i10);
    }

    public static int a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i10 = 0;
                int i11 = 0;
                while (i10 < min) {
                    i11 = Integer.parseInt(split[i10]) - Integer.parseInt(split2[i10]);
                    if (i11 != 0) {
                        break;
                    }
                    i10++;
                }
                if (i11 != 0) {
                    return i11 > 0 ? 1 : -1;
                }
                for (int i12 = i10; i12 < split.length; i12++) {
                    if (Integer.parseInt(split[i12]) > 0) {
                        return 1;
                    }
                }
                while (i10 < split2.length) {
                    if (Integer.parseInt(split2[i10]) > 0) {
                        return -1;
                    }
                    i10++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String a(String... strArr) {
        return com.ss.android.download.api.c.b.a(strArr);
    }

    @NonNull
    public static <T> T a(T... tArr) {
        if (tArr != null) {
            for (T t10 : tArr) {
                if (t10 != null) {
                    return t10;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static boolean a() {
        try {
            if (com.ss.android.downloadlib.addownload.k.a().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.k.a().getPackageName(), 0).applicationInfo.targetSdkVersion == 33) {
                return Build.VERSION.SDK_INT == 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static long a(File file, long j10) {
        if (file == null) {
            return j10;
        }
        try {
            return DownloadUtils.getAvailableSpaceBytes(file.getAbsolutePath());
        } catch (Exception e10) {
            e10.printStackTrace();
            return j10;
        }
    }

    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return new StatFs(file.getAbsolutePath()).getTotalBytes();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1L;
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }
}
