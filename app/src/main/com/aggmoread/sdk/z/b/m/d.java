package com.aggmoread.sdk.z.b.m;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

/* loaded from: classes.dex */
public class d {
    public static Intent a(Context context, String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str);
    }

    public static PackageInfo b(Context context, String str) {
        try {
            if (!a(str)) {
                return null;
            }
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo;
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean a(String str) {
        return new File(str).exists();
    }
}
