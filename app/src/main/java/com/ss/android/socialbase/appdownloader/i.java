package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.i.pa;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: j */
    private static int f24463j;
    private static NotificationChannel zx;

    /* renamed from: com.ss.android.socialbase.appdownloader.i$1 */
    static class AnonymousClass1 implements com.ss.android.socialbase.appdownloader.i.k {

        /* renamed from: i */
        final /* synthetic */ boolean f24464i;

        /* renamed from: j */
        final /* synthetic */ Context f24465j;
        final /* synthetic */ int zx;

        AnonymousClass1(Context context, int i2, boolean z) {
            context = context;
            i2 = i2;
            z = z;
        }

        @Override // com.ss.android.socialbase.appdownloader.i.k
        public void j() {
            int unused = i.f24463j = i.g(context, i2, z);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.i$2 */
    static class AnonymousClass2 implements Runnable {

        /* renamed from: g */
        final /* synthetic */ DownloadInfo f24466g;

        /* renamed from: i */
        final /* synthetic */ boolean f24467i;

        /* renamed from: j */
        final /* synthetic */ Context f24468j;
        final /* synthetic */ File q;
        final /* synthetic */ int zx;

        AnonymousClass2(Context context, int i2, boolean z, DownloadInfo downloadInfo, File file) {
            context = context;
            i2 = i2;
            z = z;
            downloadInfo = downloadInfo;
            file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            int j2 = i.j(context, i2, z, downloadInfo, file);
            if (j2 == 1 && g.pa().w() != null) {
                g.pa().w().onOpenInstaller(downloadInfo, null);
            }
            i.zx(downloadInfo, z, j2);
        }
    }

    public static int g(Context context, int i2, boolean z) {
        if (DownloadSetting.obtain(i2).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(i2);
        }
        j((Activity) y.j().zx());
        return DownloadSetting.obtain(i2).optInt("install_queue_enable", 0) == 1 ? y.j().j(context, i2, z) : zx(context, i2, z);
    }

    public static boolean i(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return zx(context, downloadInfo, j(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    private static String j(long j2, long j3, String str, boolean z) {
        double d2 = j2;
        if (j3 > 1) {
            double d3 = j3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d2 /= d3;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d2) + " " + str;
        }
        return new DecimalFormat("#").format(d2) + " " + str;
    }

    public static String zx(long j2) {
        long[] jArr = {DownloadConstants.TB, DownloadConstants.GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return j(j2, j3, strArr[i2]);
            }
        }
        return null;
    }

    public static boolean i(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    public static List<String> i() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static String j(long j2) {
        return j(j2, true);
    }

    public static int zx(Context context, int i2, boolean z) {
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.i.2

                    /* renamed from: g */
                    final /* synthetic */ DownloadInfo f24466g;

                    /* renamed from: i */
                    final /* synthetic */ boolean f24467i;

                    /* renamed from: j */
                    final /* synthetic */ Context f24468j;
                    final /* synthetic */ File q;
                    final /* synthetic */ int zx;

                    AnonymousClass2(Context context2, int i22, boolean z2, DownloadInfo downloadInfo2, File file2) {
                        context = context2;
                        i2 = i22;
                        z = z2;
                        downloadInfo = downloadInfo2;
                        file = file2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        int j2 = i.j(context, i2, z, downloadInfo, file);
                        if (j2 == 1 && g.pa().w() != null) {
                            g.pa().w().onOpenInstaller(downloadInfo, null);
                        }
                        i.zx(downloadInfo, z, j2);
                    }
                });
                return 1;
            }
        }
        zx(downloadInfo2, z2, 2);
        return 2;
    }

    private static JSONObject g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String j(long j2, boolean z) {
        long[] jArr = {DownloadConstants.TB, DownloadConstants.GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j2 < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j3 = jArr[i2];
            if (j2 >= j3) {
                return j(j2, j3, strArr[i2], z);
            }
        }
        return null;
    }

    private static String j(long j2, long j3, String str) {
        double d2 = j2;
        if (j3 > 1) {
            double d3 = j3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            d2 /= d3;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d2) + str;
        }
        return new DecimalFormat("#.##").format(d2) + str;
    }

    public static void zx(DownloadInfo downloadInfo, boolean z, int i2) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i2);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, jSONObject);
    }

    public static int j(Context context, int i2, boolean z) {
        pa lg = g.pa().lg();
        if (lg == null) {
            return g(context, i2, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        f24463j = 1;
        lg.j(downloadInfo, new com.ss.android.socialbase.appdownloader.i.k() { // from class: com.ss.android.socialbase.appdownloader.i.1

            /* renamed from: i */
            final /* synthetic */ boolean f24464i;

            /* renamed from: j */
            final /* synthetic */ Context f24465j;
            final /* synthetic */ int zx;

            AnonymousClass1(Context context2, int i22, boolean z2) {
                context = context2;
                i2 = i22;
                z = z2;
            }

            @Override // com.ss.android.socialbase.appdownloader.i.k
            public void j() {
                int unused = i.f24463j = i.g(context, i2, z);
            }
        });
        return f24463j;
    }

    public static boolean zx(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return j(context, downloadInfo, packageInfo, false);
    }

    public static int zx(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo j2 = j(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (j2 != null) {
                    int i2 = j2.versionCode;
                    downloadInfo.setAppVersionCode(i2);
                    return i2;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int j(Context context, int i2, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfo;
        Intent j2;
        Process process;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
                process = null;
            }
            try {
                process.waitFor();
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
        }
        try {
            packageInfo = j(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        if (g.pa().i() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                g.pa().i().j(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                g.pa().i().j(downloadInfo, null, 11);
            }
        }
        if (j(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (zx(context, downloadInfo, packageInfo)) {
            j2 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else {
            if (!z && j(context, i2, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            j2 = j(context, downloadInfo, file, z, iArr);
        }
        if (j2 == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        j2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        if (downloadInfo.getLinkMode() > 0 && DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.KEY_APP_INSTALL_RETURN_RESULT, 0) == 1) {
            j2.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && zx.j(context, downloadInfo, j2, z)) {
            return 1;
        }
        return j(context, j2);
    }

    public static String zx() {
        return DownloadUtils.getDownloadPath();
    }

    public static boolean zx(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String zx(@NonNull Context context) {
        try {
            if (zx == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                zx = notificationChannel;
                notificationChannel.setSound(null, null);
                zx.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(zx);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static int j(Context context, Intent intent) {
        try {
            if (g.pa().r() != null) {
                if (g.pa().r().installApp(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean j(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.i.g zx2 = g.pa().zx();
        if (zx2 != null) {
            zx2.j(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (zx2.j()) {
                return true;
            }
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.onNotificationEvent(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.i.i j2 = g.pa().j();
        return (j2 instanceof com.ss.android.socialbase.appdownloader.i.j) && ((com.ss.android.socialbase.appdownloader.i.j) j2).i();
    }

    public static boolean j(Context context, int i2, File file) {
        if (DownloadSetting.obtain(i2).optInt("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.gv.q.nt() || com.ss.android.socialbase.appdownloader.gv.q.p()) && SystemUtils.checkServiceExists(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int j() {
        return g.pa().gv() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri j(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.g r2 = com.ss.android.socialbase.appdownloader.g.pa()
            com.ss.android.socialbase.appdownloader.i.gv r2 = r2.q()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.j(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.i.j(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent j(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri j2 = j(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, g.pa().g(), file);
        if (j2 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(j2, AdBaseConstants.MIME_APK);
        com.ss.android.socialbase.appdownloader.i.g zx2 = g.pa().zx();
        int j3 = zx2 != null ? zx2.j(downloadInfo.getId(), z) : 0;
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i2 = j3;
        if (downloadNotificationEventListener != null) {
            i2 = downloadNotificationEventListener.interceptAfterNotificationSuccess(z);
        }
        iArr[0] = i2;
        if (i2 != 0) {
            return null;
        }
        return intent;
    }

    public static boolean j(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && j(DownloadComponentManager.getAppContext(), downloadInfo, str);
        }
        return true;
    }

    public static boolean j(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo j2 = j(downloadInfo, file);
                if (j2 == null || !j2.packageName.equals(str)) {
                    return false;
                }
                int i2 = j2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, j());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i2 != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
                    return false;
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("extra_apk_package_name"), null);
                int i3 = DownloadUtils.getInt(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (string == null || TextUtils.isEmpty(string) || !string.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, j());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || i3 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean j(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i2 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i2);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, j());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i3 = packageInfo2.versionCode;
        return z ? i2 < i3 : (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) != 1) ? i2 <= i3 : i2 < i3;
    }

    public static boolean j(Context context, DownloadInfo downloadInfo) {
        return j(context, downloadInfo, true);
    }

    public static boolean j(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return i(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, j());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo j(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return j(downloadInfo, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String j(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = i(r5)
            if (r3 == 0) goto L77
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L77
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.i.j(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String j(String str, DownloadSetting downloadSetting) {
        JSONObject optJSONObject;
        String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int j(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == -2) {
            return 2;
        }
        if (i2 == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i2) || i2 == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i2) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r0 != null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean j(android.content.Context r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 20
            if (r0 <= r2) goto L40
            if (r6 != 0) goto La
            goto L40
        La:
            r0 = 0
            int r2 = com.ss.android.socialbase.appdownloader.q.zx()     // Catch: java.lang.Throwable -> L3d
            android.content.res.Resources r3 = r6.getResources()     // Catch: java.lang.Throwable -> L3d
            int r2 = r3.getColor(r2)     // Catch: java.lang.Throwable -> L3d
            int r3 = com.ss.android.socialbase.appdownloader.q.i()     // Catch: java.lang.Throwable -> L3d
            int r4 = com.ss.android.socialbase.appdownloader.q.g()     // Catch: java.lang.Throwable -> L3d
            r5 = 2
            int[] r5 = new int[r5]     // Catch: java.lang.Throwable -> L3d
            r5[r1] = r3     // Catch: java.lang.Throwable -> L3d
            r3 = 1
            r5[r3] = r4     // Catch: java.lang.Throwable -> L3d
            int r4 = com.ss.android.socialbase.appdownloader.q.q()     // Catch: java.lang.Throwable -> L3d
            android.content.res.TypedArray r0 = r6.obtainStyledAttributes(r4, r5)     // Catch: java.lang.Throwable -> L3d
            int r6 = r0.getColor(r1, r1)     // Catch: java.lang.Throwable -> L3d
            if (r2 != r6) goto L39
            r0.recycle()     // Catch: java.lang.Throwable -> L38
        L38:
            return r3
        L39:
            r0.recycle()     // Catch: java.lang.Throwable -> L40
            goto L40
        L3d:
            if (r0 == 0) goto L40
            goto L39
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.i.j(android.content.Context):boolean");
    }

    public static void j(DownloadInfo downloadInfo, boolean z, boolean z2) {
        g.pa().j(new gv(DownloadComponentManager.getAppContext(), downloadInfo.getUrl()).j(downloadInfo.getTitle()).zx(downloadInfo.getName()).i(downloadInfo.getSavePath()).j(downloadInfo.isShowNotification()).zx(downloadInfo.isAutoInstallWithoutNotification()).i(downloadInfo.isOnlyWifi() || z2).g(downloadInfo.getExtra()).q(downloadInfo.getMimeType()).j(downloadInfo.getExtraHeaders()).q(true).zx(downloadInfo.getRetryCount()).i(downloadInfo.getBackUpUrlRetryCount()).zx(downloadInfo.getBackUpUrls()).g(downloadInfo.getMinProgressTimeMsInterval()).q(downloadInfo.getMaxProgressCount()).gv(z).g(downloadInfo.isNeedHttpsToHttpRetry()).gv(downloadInfo.getPackageName()).lg(downloadInfo.getMd5()).j(downloadInfo.getExpectFileLength()).k(downloadInfo.isNeedDefaultHttpServiceBackUp()).pa(downloadInfo.isNeedReuseFirstConnection()).nt(downloadInfo.isNeedIndependentProcess()).j(downloadInfo.getEnqueueType()).r(downloadInfo.isForce()).p(downloadInfo.isHeadConnectionAvailable()).lg(downloadInfo.isNeedRetryDelay()).y(downloadInfo.getRetryDelayTimeArray()).j(g(downloadInfo.getDownloadSettingString())).pa(downloadInfo.getIconUrl()).gv(downloadInfo.getExecutorGroup()).s(downloadInfo.isAutoInstall()));
    }

    public static void j(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static PackageInfo j(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.gv.j.q.j(DownloadComponentManager.getAppContext(), file, j());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo j2 = com.ss.android.socialbase.appdownloader.gv.j.q.j(DownloadComponentManager.getAppContext(), file, j());
        downloadInfo.setPackageInfo(j2);
        return j2;
    }

    public static int j(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
