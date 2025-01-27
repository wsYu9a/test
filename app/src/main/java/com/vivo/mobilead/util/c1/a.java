package com.vivo.mobilead.util.c1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.vivo.mobilead.util.x0;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static String f30566a = "CheckManifestUtils";

    public static boolean a(Context context, String str) {
        Intent intent = new Intent();
        PackageManager packageManager = context.getPackageManager();
        intent.setClassName(context.getPackageName(), str);
        if (packageManager.resolveActivity(intent, 0) != null) {
            return true;
        }
        Log.i(f30566a, str + "未在AndroidManifest中注册");
        throw new IllegalStateException("activity:" + str + "未在AndroidManifest中注册");
    }

    public static void a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        for (String str : c.f30568a) {
            if (a(str, context)) {
                if (Build.VERSION.SDK_INT >= 23 && -1 == packageManager.checkPermission(str, packageName)) {
                    x0.c(f30566a, "没有授权" + str);
                }
            } else {
                x0.c(f30566a, "AndroidManifest未声明广告SDK版本号");
                throw new IllegalStateException("permission:" + str + "未在AndroidManifest中注册");
            }
        }
    }

    public static boolean a(String str, Context context) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str2 : strArr) {
                    if (str2.equals(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
