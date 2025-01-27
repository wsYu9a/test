package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class ap {

    public interface a {
        void d(Throwable th2);

        void pa();
    }

    public static boolean a(@Nullable String str, a aVar) {
        Uri fromFile;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Context context = ServiceProvider.getContext();
            File file = new File(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.addFlags(3);
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
            } else {
                fromFile = Uri.fromFile(file);
            }
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
            while (it.hasNext()) {
                context.grantUriPermission(it.next().activityInfo.packageName, fromFile, 3);
            }
            context.startActivity(intent);
            if (aVar == null) {
                return true;
            }
            aVar.pa();
            return true;
        } catch (Throwable th2) {
            if (aVar != null) {
                aVar.d(th2);
            }
            return false;
        }
    }

    public static boolean an(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageInfo = ao.getPackageInfo(context, str, 0);
            if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null) {
                if (applicationInfo.enabled) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean ao(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo d10 = ao.d(context, str, 0);
            if (d10 != null && (applicationInfo = d10.applicationInfo) != null) {
                if (applicationInfo.enabled) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static int ap(@Nullable Context context, String str) {
        if (context == null || str == null || d.bW(context)) {
            return -1;
        }
        try {
            if (context.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33) {
                return -1;
            }
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11108i) != 0) {
                return -1;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str);
            return (file.exists() && file.isDirectory()) ? 1 : 0;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static boolean aq(@Nullable Context context, @Nullable String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            com.kwad.sdk.core.d.c.d("PackageUtil", "openApp context: " + context);
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void at(String str, String str2) {
        com.kwad.sdk.core.d.c.w("PackageUtil", "saveDownloadFile " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, has no download apk info.");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, download apk is not exists.");
            return;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        ad.f(context, str2, file.length());
        try {
            ad.g(context, str2, com.kwad.sdk.utils.a.getFileMD5(file));
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }

    public static int au(String str, String str2) {
        ApplicationInfo applicationInfo;
        com.kwad.sdk.core.d.c.w("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 0;
        }
        long V = ad.V(context, str);
        String W = ad.W(context, str);
        if (TextUtils.isEmpty(W) || V <= 0) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, has no download apk info.");
            return 0;
        }
        PackageInfo d10 = ao.d(context, str2, 0);
        if (d10 == null) {
            return 0;
        }
        if (TextUtils.isEmpty(str2) || (applicationInfo = d10.applicationInfo) == null || TextUtils.isEmpty(applicationInfo.publicSourceDir)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot get installed apk info.");
            return 0;
        }
        File file = new File(d10.applicationInfo.publicSourceDir);
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, insgtalled apk is not exists.");
            return 0;
        }
        if (V != file.length()) {
            return 1;
        }
        if (TextUtils.isEmpty(W)) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of download file.");
            return 0;
        }
        String fileMD5 = com.kwad.sdk.utils.a.getFileMD5(file);
        if (!TextUtils.isEmpty(fileMD5)) {
            return W.equalsIgnoreCase(fileMD5) ? 2 : 1;
        }
        com.kwad.sdk.core.d.c.w("PackageUtil", "cannot judge package, cannot calculate md5 of installed file.");
        return 0;
    }

    public static boolean gS(@Nullable String str) {
        return a(str, null);
    }

    public static String gT(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.d.c.w("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }
}
