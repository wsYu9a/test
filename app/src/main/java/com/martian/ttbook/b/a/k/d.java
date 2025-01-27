package com.martian.ttbook.b.a.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.File;

/* loaded from: classes4.dex */
public class d {
    public static Intent a(Context context, String str) {
        return context.getPackageManager().getLaunchIntentForPackage(str);
    }

    public static boolean b(String str) {
        return new File(str).exists();
    }

    public static PackageInfo c(Context context, String str) {
        try {
            if (!b(str)) {
                return null;
            }
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 1) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
