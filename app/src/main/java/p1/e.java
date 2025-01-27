package p1;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    public static String f29707a;

    /* renamed from: b */
    public static int f29708b;

    public static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            n1.a.f28723e.error("ARouter::", "Get package info error.");
            return null;
        }
    }

    public static boolean b(Context context) {
        PackageInfo a10 = a(context);
        if (a10 != null) {
            String str = a10.versionName;
            int i10 = a10.versionCode;
            SharedPreferences sharedPreferences = context.getSharedPreferences(b.f29699j, 0);
            if (str.equals(sharedPreferences.getString(b.f29701l, null)) && i10 == sharedPreferences.getInt(b.f29702m, -1)) {
                return false;
            }
            f29707a = str;
            f29708b = i10;
        }
        return true;
    }

    public static void c(Context context) {
        if (TextUtils.isEmpty(f29707a) || f29708b == 0) {
            return;
        }
        context.getSharedPreferences(b.f29699j, 0).edit().putString(b.f29701l, f29707a).putInt(b.f29702m, f29708b).apply();
    }
}
