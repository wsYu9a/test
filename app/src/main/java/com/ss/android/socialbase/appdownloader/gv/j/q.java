package com.ss.android.socialbase.appdownloader.gv.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.heytap.mcssdk.n.d;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q {
    /* JADX WARN: Code restructure failed: missing block: B:149:0x006a, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x006e, code lost:
    
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
    public static android.content.pm.PackageInfo j(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.gv.j.q.j(java.io.File):android.content.pm.PackageInfo");
    }

    private static String j(int i2) {
        return (i2 >>> 24) == 1 ? "android:" : "";
    }

    private static PackageInfo zx(@NonNull Context context, @NonNull File file, int i2) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            j("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i2);
        } catch (Throwable th) {
            j("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    public static PackageInfo j(@NonNull Context context, @NonNull File file, int i2) {
        int i3;
        if (DownloadExpSwitchCode.isSwitchEnable(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP) && (i3 = Build.VERSION.SDK_INT) >= 21 && i3 < 26) {
            try {
                return j(file);
            } catch (Throwable th) {
                j("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return zx(context, file, i2);
            }
        }
        return zx(context, file, i2);
    }

    private static void j(@NonNull String str, @NonNull String str2) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(d.l, str2);
        } catch (JSONException unused) {
        }
        downloadMonitorListener.monitorEvent(str, jSONObject, null, null);
    }

    private static String j(j jVar, int i2) {
        int zx = jVar.zx(i2);
        int i3 = jVar.i(i2);
        if (zx == 3) {
            return jVar.g(i2);
        }
        return zx == 2 ? String.format("?%s%08X", j(i3), Integer.valueOf(i3)) : (zx < 16 || zx > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(i3), Integer.valueOf(zx)) : String.valueOf(i3);
    }

    public static String j(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e2) {
            j("getPackageInfo::fail_load_label", e2.getMessage());
            return null;
        }
    }
}
