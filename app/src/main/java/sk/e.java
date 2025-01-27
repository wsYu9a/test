package sk;

import android.content.Context;
import android.os.Build;
import com.kuaishou.weapon.p0.g;

/* loaded from: classes5.dex */
public final class e {
    public static boolean a(Context context) {
        return context.checkCallingOrSelfPermission(g.f11107h) == 0;
    }

    public static boolean b(Context context) {
        int i10 = Build.VERSION.SDK_INT;
        return i10 < 26 ? context.checkCallingOrSelfPermission(g.f11103d) == 0 && context.checkCallingOrSelfPermission("android.permission.CHANGE_WIFI_STATE") == 0 : i10 < 28 ? context.checkCallingOrSelfPermission(g.f11106g) == 0 || context.checkCallingOrSelfPermission(g.f11107h) == 0 || context.checkCallingOrSelfPermission("android.permission.CHANGE_WIFI_STATE") == 0 : (i10 < 29 || context.getApplicationContext().getApplicationInfo().targetSdkVersion < 29) ? (context.checkCallingOrSelfPermission(g.f11106g) == 0 || context.checkCallingOrSelfPermission(g.f11107h) == 0) && context.checkCallingOrSelfPermission("android.permission.CHANGE_WIFI_STATE") == 0 : context.checkCallingOrSelfPermission(g.f11106g) == 0 && context.checkCallingOrSelfPermission("android.permission.CHANGE_WIFI_STATE") == 0;
    }
}
