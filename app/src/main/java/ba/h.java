package ba;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a */
    public static final String f1473a = "checkOpNoThrow";

    /* renamed from: b */
    public static final String f1474b = "OP_POST_NOTIFICATION";

    /* renamed from: c */
    public static final int f1475c = 1001;

    public static Intent a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Intent intent = new Intent();
            if (m.u()) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
                intent.putExtra("android.provider.extra.CHANNEL_ID", i10);
            }
            intent.putExtra("app_package", packageName);
            intent.putExtra("app_uid", i10);
            return intent;
        } catch (Exception unused) {
            return new Intent("android.settings.SETTINGS");
        }
    }

    public static void b(Activity activity) {
        try {
            activity.startActivityForResult(a(activity), 1001);
        } catch (ActivityNotFoundException e10) {
            e10.printStackTrace();
        }
    }

    public static boolean c(Context context) {
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i10 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod(f1473a, cls2, cls2, String.class);
            Integer num = (Integer) cls.getDeclaredField(f1474b).get(Integer.class);
            num.intValue();
            return ((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i10), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean d(Context context) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Method declaredMethod = notificationManager.getClass().getDeclaredMethod("getService", null);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(notificationManager, null);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i10 = applicationInfo.uid;
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("areNotificationsEnabledForPackage", String.class, Integer.TYPE);
            declaredMethod2.setAccessible(true);
            return ((Boolean) declaredMethod2.invoke(invoke, packageName, Integer.valueOf(i10))).booleanValue();
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean e(Context context) {
        return m.u() ? d(context) : c(context);
    }
}
