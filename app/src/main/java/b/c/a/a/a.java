package b.c.a.a;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4286a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f4287b = 3;

    /* renamed from: c, reason: collision with root package name */
    public static final int f4288c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f4289d = 1;

    a() {
    }

    public static final int d(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }

    static String e(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }

    public int a(Context context, String str, int i2, String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i2, str2);
        }
        return 1;
    }

    public int b(Context context, String str, int i2, String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i2, str2);
        }
        return 1;
    }

    public final int c(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
        }
        return 1;
    }
}
