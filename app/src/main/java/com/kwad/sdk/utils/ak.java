package com.kwad.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.service.ServiceProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class ak {
    public static void af(String str, String str2) {
        String str3;
        com.kwad.sdk.core.d.b.w("PackageUtil", "saveDownloadFile " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str3 = "cannot save package, has no download apk info.";
        } else {
            File file = new File(str);
            if (file.exists()) {
                Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
                if (context == null) {
                    return;
                }
                y.f(context, str2, file.length());
                try {
                    y.g(context, str2, a.getFileMD5(file));
                    return;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(e2);
                    return;
                }
            }
            str3 = "cannot save package, download apk is not exists.";
        }
        com.kwad.sdk.core.d.b.w("PackageUtil", str3);
    }

    public static int ag(String str, String str2) {
        String str3;
        ApplicationInfo applicationInfo;
        com.kwad.sdk.core.d.b.w("PackageUtil", "isPackageChanged " + str + " packageName " + str2);
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            return 0;
        }
        long N = y.N(context, str);
        String O = y.O(context, str);
        if (TextUtils.isEmpty(O) || N <= 0) {
            str3 = "cannot judge package, has no download apk info.";
        } else {
            try {
                PackageInfo packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(str2, 0);
                if (TextUtils.isEmpty(str2) || packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || TextUtils.isEmpty(applicationInfo.publicSourceDir)) {
                    str3 = "cannot judge package, cannot get installed apk info.";
                } else {
                    File file = new File(packageInfo.applicationInfo.publicSourceDir);
                    if (!file.exists()) {
                        str3 = "cannot judge package, insgtalled apk is not exists.";
                    } else {
                        if (N != file.length()) {
                            return 1;
                        }
                        if (TextUtils.isEmpty(O)) {
                            str3 = "cannot judge package, cannot calculate md5 of download file.";
                        } else {
                            String fileMD5 = a.getFileMD5(file);
                            if (!TextUtils.isEmpty(fileMD5)) {
                                return O.equalsIgnoreCase(fileMD5) ? 2 : 1;
                            }
                            str3 = "cannot judge package, cannot calculate md5 of installed file.";
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                com.kwad.sdk.core.d.b.printStackTrace(e2);
                return 0;
            }
        }
        com.kwad.sdk.core.d.b.w("PackageUtil", str3);
        return 0;
    }

    public static boolean ah(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }

    public static int ai(@Nullable Context context, String str) {
        if (context == null || str == null || c.bw(context) || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9324i) != 0) {
            return -1;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str);
        return (file.exists() && file.isDirectory()) ? 1 : 0;
    }

    public static boolean aj(@Nullable Context context, @Nullable String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            com.kwad.sdk.core.d.b.d("PackageUtil", "openApp context: " + context);
            launchIntentForPackage.setFlags(337641472);
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ak(@Nullable Context context, @Nullable String str) {
        Uri fromFile;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                intent.addFlags(3);
                if (Build.VERSION.SDK_INT >= 24) {
                    fromFile = FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
                } else {
                    fromFile = Uri.fromFile(file);
                }
                intent.setDataAndType(fromFile, AdBaseConstants.MIME_APK);
                Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
                while (it.hasNext()) {
                    context.grantUriPermission(it.next().activityInfo.packageName, fromFile, 3);
                }
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public static String eI(String str) {
        PackageInfo packageArchiveInfo;
        if (!new File(str).exists()) {
            com.kwad.sdk.core.d.b.w("PackageUtil", "cannot save package, download apk is not exists.");
            return null;
        }
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1)) == null) {
            return null;
        }
        return packageArchiveInfo.applicationInfo.packageName;
    }
}
