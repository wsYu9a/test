package com.ss.android.socialbase.appdownloader.f.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0071, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0075, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo a(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 393
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.e.a(java.io.File):android.content.pm.PackageInfo");
    }

    private static PackageInfo b(@NonNull Context context, @NonNull File file, int i10) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            a("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i10);
        } catch (Throwable th2) {
            a("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th2.getMessage());
            return null;
        }
    }

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i10) {
        if (DownloadExpSwitchCode.isSwitchEnable(268435456) && Build.VERSION.SDK_INT < 26) {
            try {
                return a(file);
            } catch (Throwable th2) {
                a("getPackageInfo::unzip_getpackagearchiveinfo", th2.getMessage());
                return b(context, file, i10);
            }
        }
        return b(context, file, i10);
    }

    private static void a(@NonNull String str, @NonNull String str2) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(b7.d.f1362o, str2);
        } catch (JSONException unused) {
        }
        downloadMonitorListener.monitorEvent(str, jSONObject, null, null);
    }

    private static String a(int i10) {
        if ((i10 >>> 24) == 1) {
            return "android:";
        }
        return "";
    }

    private static String a(a aVar, int i10) {
        int b10 = aVar.b(i10);
        int c10 = aVar.c(i10);
        if (b10 == 3) {
            return aVar.d(i10);
        }
        return b10 == 2 ? String.format("?%s%08X", a(c10), Integer.valueOf(c10)) : (b10 < 16 || b10 > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c10), Integer.valueOf(b10)) : String.valueOf(c10);
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e10) {
            a("getPackageInfo::fail_load_label", e10.getMessage());
            return null;
        }
    }
}
