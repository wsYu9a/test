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
import com.ss.android.socialbase.appdownloader.c.j;
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
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import q.a0;
import q.z;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static int f21771a;

    /* renamed from: b */
    private static NotificationChannel f21772b;

    /* renamed from: com.ss.android.socialbase.appdownloader.c$1 */
    public static class AnonymousClass1 implements com.ss.android.socialbase.appdownloader.c.i {

        /* renamed from: a */
        final /* synthetic */ Context f21773a;

        /* renamed from: b */
        final /* synthetic */ int f21774b;

        /* renamed from: c */
        final /* synthetic */ boolean f21775c;

        public AnonymousClass1(Context context, int i10, boolean z10) {
            context = context;
            i10 = i10;
            z10 = z10;
        }

        @Override // com.ss.android.socialbase.appdownloader.c.i
        public void a() {
            int unused = c.f21771a = c.d(context, i10, z10);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.c$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21776a;

        /* renamed from: b */
        final /* synthetic */ int f21777b;

        /* renamed from: c */
        final /* synthetic */ boolean f21778c;

        /* renamed from: d */
        final /* synthetic */ DownloadInfo f21779d;

        /* renamed from: e */
        final /* synthetic */ File f21780e;

        public AnonymousClass2(Context context, int i10, boolean z10, DownloadInfo downloadInfo, File file) {
            context = context;
            i10 = i10;
            z10 = z10;
            downloadInfo = downloadInfo;
            file = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.j().k();
            int a10 = c.a(context, i10, z10, downloadInfo, file);
            if (a10 == 1 && d.j().q() != null) {
                d.j().q().onOpenInstaller(downloadInfo, null);
            }
            c.b(downloadInfo, z10, a10);
        }
    }

    public static int d(Context context, int i10, boolean z10) {
        if (DownloadSetting.obtain(i10).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(i10);
        }
        a((Activity) h.a().b());
        return DownloadSetting.obtain(i10).optInt("install_queue_enable", 0) == 1 ? h.a().a(context, i10, z10) : b(context, i10, z10);
    }

    private static String a(long j10, long j11, String str, boolean z10) {
        double d10 = j10;
        if (j11 > 1) {
            d10 /= j11;
        }
        if (z10 || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d10) + " " + str;
        }
        return new DecimalFormat("#").format(d10) + " " + str;
    }

    public static String b(long j10) {
        long[] jArr = {DownloadConstants.TB, DownloadConstants.GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j10 < 1) {
            return "0 " + strArr[4];
        }
        for (int i10 = 0; i10 < 5; i10++) {
            long j11 = jArr[i10];
            if (j10 >= j11) {
                return a(j10, j11, strArr[i10]);
            }
        }
        return null;
    }

    public static boolean c(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return b(context, downloadInfo, a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static String a(long j10) {
        return a(j10, true);
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    public static String a(long j10, boolean z10) {
        long[] jArr = {DownloadConstants.TB, DownloadConstants.GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j10 < 1) {
            return "0 " + strArr[4];
        }
        for (int i10 = 0; i10 < 5; i10++) {
            long j11 = jArr[i10];
            if (j10 >= j11) {
                return a(j10, j11, strArr[i10], z10);
            }
        }
        return null;
    }

    public static List<String> c() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static int b(Context context, int i10, boolean z10) {
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.c.2

                    /* renamed from: a */
                    final /* synthetic */ Context f21776a;

                    /* renamed from: b */
                    final /* synthetic */ int f21777b;

                    /* renamed from: c */
                    final /* synthetic */ boolean f21778c;

                    /* renamed from: d */
                    final /* synthetic */ DownloadInfo f21779d;

                    /* renamed from: e */
                    final /* synthetic */ File f21780e;

                    public AnonymousClass2(Context context2, int i102, boolean z102, DownloadInfo downloadInfo2, File file2) {
                        context = context2;
                        i10 = i102;
                        z10 = z102;
                        downloadInfo = downloadInfo2;
                        file = file2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        d.j().k();
                        int a10 = c.a(context, i10, z10, downloadInfo, file);
                        if (a10 == 1 && d.j().q() != null) {
                            d.j().q().onOpenInstaller(downloadInfo, null);
                        }
                        c.b(downloadInfo, z10, a10);
                    }
                });
                return 1;
            }
        }
        b(downloadInfo2, z102, 2);
        return 2;
    }

    private static JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(long j10, long j11, String str) {
        double d10 = j10;
        if (j11 > 1) {
            d10 /= j11;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d10) + str;
        }
        return new DecimalFormat("#.##").format(d10) + str;
    }

    public static void b(DownloadInfo downloadInfo, boolean z10, int i10) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z10 ? 1 : 2);
            jSONObject.put("view_result", i10);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, jSONObject);
    }

    public static int a(Context context, int i10, boolean z10) {
        j g10 = d.j().g();
        if (g10 == null) {
            return d(context, i10, z10);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10);
        f21771a = 1;
        g10.a(downloadInfo, new com.ss.android.socialbase.appdownloader.c.i() { // from class: com.ss.android.socialbase.appdownloader.c.1

            /* renamed from: a */
            final /* synthetic */ Context f21773a;

            /* renamed from: b */
            final /* synthetic */ int f21774b;

            /* renamed from: c */
            final /* synthetic */ boolean f21775c;

            public AnonymousClass1(Context context2, int i102, boolean z102) {
                context = context2;
                i10 = i102;
                z10 = z102;
            }

            @Override // com.ss.android.socialbase.appdownloader.c.i
            public void a() {
                int unused = c.f21771a = c.d(context, i10, z10);
            }
        });
        return f21771a;
    }

    public static boolean b(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return a(context, downloadInfo, packageInfo, false);
    }

    public static int a(Context context, int i10, boolean z10, DownloadInfo downloadInfo, File file) {
        Process process;
        PackageInfo packageInfo;
        Intent a10;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
            } catch (Throwable th2) {
                th = th2;
                process = null;
            }
            try {
                process.waitFor();
            } catch (Throwable th3) {
                th = th3;
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
            packageInfo = a(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            th = null;
        } catch (Throwable th5) {
            th = th5;
            packageInfo = null;
        }
        if (d.j().c() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                d.j().c().a(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                d.j().c().a(downloadInfo, null, 11);
            }
        }
        if (a(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (b(context, downloadInfo, packageInfo)) {
            a10 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else {
            if (!z10 && a(context, i10, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            a10 = a(context, downloadInfo, file, z10, iArr);
        }
        if (a10 == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        a10.addFlags(268435456);
        if (downloadInfo.getLinkMode() > 0 && DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.KEY_APP_INSTALL_RETURN_RESULT, 0) == 1) {
            a10.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && b.a(context, downloadInfo, a10, z10)) {
            return 1;
        }
        return a(context, a10);
    }

    public static int b(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo a10 = a(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (a10 != null) {
                    int i10 = a10.versionCode;
                    downloadInfo.setAppVersionCode(i10);
                    return i10;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static String b() {
        return DownloadUtils.getDownloadPath();
    }

    public static boolean b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String b(@NonNull Context context) {
        try {
            if (f21772b == null) {
                a0.a();
                NotificationChannel a10 = z.a("111111", "channel_appdownloader", 3);
                f21772b = a10;
                a10.setSound(null, null);
                f21772b.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(f21772b);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return "111111";
    }

    public static int a(Context context, Intent intent) {
        try {
            if (d.j().p() != null) {
                if (d.j().p().installApp(intent)) {
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

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.c.d b10 = d.j().b();
        if (b10 != null) {
            b10.a(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (b10.a()) {
                return true;
            }
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.onNotificationEvent(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.c.c a10 = d.j().a();
        return (a10 instanceof com.ss.android.socialbase.appdownloader.c.a) && ((com.ss.android.socialbase.appdownloader.c.a) a10).b();
    }

    public static boolean a(Context context, int i10, File file) {
        if (DownloadSetting.obtain(i10).optInt("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.f.e.m() || com.ss.android.socialbase.appdownloader.f.e.n()) && SystemUtils.checkServiceExists(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
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
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    public static int a() {
        return d.j().f() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri a(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.d r2 = com.ss.android.socialbase.appdownloader.d.j()
            com.ss.android.socialbase.appdownloader.c.f r2 = r2.e()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.a(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3c
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L32
            r0 = 24
            if (r2 < r0) goto L34
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L32
            if (r2 != 0) goto L34
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L32
            goto L3c
        L32:
            r2 = move-exception
            goto L39
        L34:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L32
            goto L3c
        L39:
            r2.printStackTrace()
        L3c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent a(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z10, int[] iArr) {
        Uri a10 = a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, d.j().d(), file);
        if (a10 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(a10, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.c.d b10 = d.j().b();
        int a11 = b10 != null ? b10.a(downloadInfo.getId(), z10) : 0;
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i10 = a11;
        if (downloadNotificationEventListener != null) {
            i10 = downloadNotificationEventListener.interceptAfterNotificationSuccess(z10);
        }
        iArr[0] = i10;
        if (i10 != 0) {
            return null;
        }
        return intent;
    }

    public static boolean a(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && a(DownloadComponentManager.getAppContext(), downloadInfo, str);
        }
        return true;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo a10 = a(downloadInfo, file);
                if (a10 == null || !a10.packageName.equals(str)) {
                    return false;
                }
                int i10 = a10.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i10 != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
                    return false;
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("extra_apk_package_name"), null);
                int i11 = DownloadUtils.getInt(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (string == null || TextUtils.isEmpty(string) || !string.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, a());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || i11 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z10) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i10 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i10);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, a());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i11 = packageInfo2.versionCode;
        return z10 ? i10 < i11 : (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) != 1) ? i10 <= i11 : i10 < i11;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo) {
        return a(context, downloadInfo, true);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, boolean z10) {
        PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z10) {
            return c(context, downloadInfo);
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, a());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        return DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo a(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return a(downloadInfo, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L94;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
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
            boolean r3 = c(r5)
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String a(String str, DownloadSetting downloadSetting) {
        JSONObject optJSONObject;
        if (downloadSetting != null && (optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) != null) {
            String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
            if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
                optString = optString.substring(1);
            }
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            if (!optString.contains("%s")) {
                optString = optString + str;
            } else {
                try {
                    optString = String.format(optString, str);
                } catch (Throwable unused) {
                }
            }
            return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
        }
        return "";
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int a(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 == -2) {
            return 2;
        }
        if (i10 == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i10) || i10 == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i10) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
    
        if (r1 == null) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            r1 = 0
            int r2 = com.ss.android.socialbase.appdownloader.e.b()     // Catch: java.lang.Throwable -> L34
            android.content.res.Resources r3 = r5.getResources()     // Catch: java.lang.Throwable -> L34
            int r2 = r3.getColor(r2)     // Catch: java.lang.Throwable -> L34
            int r3 = com.ss.android.socialbase.appdownloader.e.c()     // Catch: java.lang.Throwable -> L34
            int r4 = com.ss.android.socialbase.appdownloader.e.d()     // Catch: java.lang.Throwable -> L34
            int[] r3 = new int[]{r3, r4}     // Catch: java.lang.Throwable -> L34
            int r4 = com.ss.android.socialbase.appdownloader.e.e()     // Catch: java.lang.Throwable -> L34
            android.content.res.TypedArray r1 = r5.obtainStyledAttributes(r4, r3)     // Catch: java.lang.Throwable -> L34
            int r5 = r1.getColor(r0, r0)     // Catch: java.lang.Throwable -> L34
            if (r2 != r5) goto L30
            r1.recycle()     // Catch: java.lang.Throwable -> L2e
        L2e:
            r5 = 1
            return r5
        L30:
            r1.recycle()     // Catch: java.lang.Throwable -> L38
            goto L38
        L34:
            if (r1 == 0) goto L38
            goto L30
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.c.a(android.content.Context):boolean");
    }

    public static void a(DownloadInfo downloadInfo, boolean z10, boolean z11) {
        d.j().a(new f(DownloadComponentManager.getAppContext(), downloadInfo.getUrl()).a(downloadInfo.getTitle()).b(downloadInfo.getName()).c(downloadInfo.getSavePath()).a(downloadInfo.isShowNotification()).b(downloadInfo.isAutoInstallWithoutNotification()).c(downloadInfo.isOnlyWifi() || z11).e(downloadInfo.getExtra()).f(downloadInfo.getMimeType()).a(downloadInfo.getExtraHeaders()).e(true).b(downloadInfo.getRetryCount()).c(downloadInfo.getBackUpUrlRetryCount()).b(downloadInfo.getBackUpUrls()).d(downloadInfo.getMinProgressTimeMsInterval()).e(downloadInfo.getMaxProgressCount()).f(z10).d(downloadInfo.isNeedHttpsToHttpRetry()).g(downloadInfo.getPackageName()).h(downloadInfo.getMd5()).a(downloadInfo.getExpectFileLength()).i(downloadInfo.isNeedDefaultHttpServiceBackUp()).j(downloadInfo.isNeedReuseFirstConnection()).l(downloadInfo.isNeedIndependentProcess()).a(downloadInfo.getEnqueueType()).n(downloadInfo.isForce()).m(downloadInfo.isHeadConnectionAvailable()).g(downloadInfo.isNeedRetryDelay()).i(downloadInfo.getRetryDelayTimeArray()).a(d(downloadInfo.getDownloadSettingString())).k(downloadInfo.getIconUrl()).f(downloadInfo.getExecutorGroup()).p(downloadInfo.isAutoInstall()));
    }

    public static void a(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static PackageInfo a(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.f.a.e.a(DownloadComponentManager.getAppContext(), file, a());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo a10 = com.ss.android.socialbase.appdownloader.f.a.e.a(DownloadComponentManager.getAppContext(), file, a());
        downloadInfo.setPackageInfo(a10);
        return a10;
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
