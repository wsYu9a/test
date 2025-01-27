package b.c.a.a;

import android.content.Context;
import android.os.Binder;
import android.os.Process;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    public static final int f4290a = -1;

    /* renamed from: b */
    public static final int f4291b = -2;

    /* renamed from: c */
    public static final int f4292c = 0;

    public static int a(Context context, String str) {
        String packageName = Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null;
        if (packageName == null) {
            packageName = "";
        }
        return c(context, str, Binder.getCallingPid(), Binder.getCallingUid(), packageName);
    }

    private static int c(Context context, String str, int i2, int i3, String str2) {
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        String e2 = a.e(str);
        if (e2 != null) {
            if (str2 == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            if (a.d(context, e2, str2) != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static int d(Context context, String str) {
        return c(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public final int b(Context context, String str, String str2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return c(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }
}
