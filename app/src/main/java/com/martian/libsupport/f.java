package com.martian.libsupport;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private static final String f10600a = "checkOpNoThrow";

    /* renamed from: b */
    public static final String f10601b = "OP_POST_NOTIFICATION";

    /* renamed from: c */
    public static final int f10602c = 1001;

    public static void a(Activity activity) {
        ApplicationInfo applicationInfo = activity.getApplicationInfo();
        String packageName = activity.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Intent intent = new Intent();
            if (l.r()) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
                intent.putExtra("android.provider.extra.CHANNEL_ID", i2);
                intent.putExtra("app_package", packageName);
                intent.putExtra("app_uid", i2);
            } else if (l.p()) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("package:" + packageName));
            } else {
                intent = new Intent("android.settings.SETTINGS");
            }
            activity.startActivityForResult(intent, 1001);
        } catch (Exception unused) {
            activity.startActivityForResult(new Intent("android.settings.SETTINGS"), 1001);
        }
    }

    public static boolean b(Context context) {
        if (!l.p()) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod(f10600a, cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField(f10601b).get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Method declaredMethod = notificationManager.getClass().getDeclaredMethod("getService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(notificationManager, new Object[0]);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("areNotificationsEnabledForPackage", String.class, Integer.TYPE);
            declaredMethod2.setAccessible(true);
            return ((Boolean) declaredMethod2.invoke(invoke, packageName, Integer.valueOf(i2))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean d(Context context) {
        return l.A() ? c(context) : b(context);
    }
}
