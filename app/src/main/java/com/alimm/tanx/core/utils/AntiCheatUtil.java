package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Binder;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class AntiCheatUtil implements NotConfused {
    private static volatile AntiCheatUtil instance;

    private boolean canDrawOverlays(Context context) {
        boolean canDrawOverlays;
        boolean canDrawOverlays2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 23) {
            return true;
        }
        if (i10 >= 27) {
            canDrawOverlays2 = Settings.canDrawOverlays(context);
            return canDrawOverlays2;
        }
        canDrawOverlays = Settings.canDrawOverlays(context);
        if (canDrawOverlays) {
            return true;
        }
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return false;
            }
            View view = new View(context);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(0, 0, i10 >= 26 ? 2038 : 2003, 24, -2);
            view.setLayoutParams(layoutParams);
            windowManager.addView(view, layoutParams);
            windowManager.removeView(view);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    private static boolean checkFloatPermission(Context context) {
        boolean canDrawOverlays;
        if (Build.VERSION.SDK_INT >= 23) {
            canDrawOverlays = Settings.canDrawOverlays(context);
            return canDrawOverlays;
        }
        try {
            Class<?> cls = Class.forName("android.content.Context");
            Field declaredField = cls.getDeclaredField("APP_OPS_SERVICE");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(cls);
            if (!(obj instanceof String)) {
                return false;
            }
            Object invoke = cls.getMethod("getSystemService", String.class).invoke(context, (String) obj);
            Class<?> cls2 = Class.forName("android.app.AppOpsManager");
            Field declaredField2 = cls2.getDeclaredField("MODE_ALLOWED");
            declaredField2.setAccessible(true);
            Class<?> cls3 = Integer.TYPE;
            return ((Integer) cls2.getMethod("checkOp", cls3, cls3, String.class).invoke(invoke, 24, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == declaredField2.getInt(cls2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static AntiCheatUtil getInstance() {
        if (instance == null) {
            synchronized (AntiCheatUtil.class) {
                try {
                    if (instance == null) {
                        instance = new AntiCheatUtil();
                    }
                } finally {
                }
            }
        }
        return instance;
    }

    public boolean accessibilityEnabled(Context context) {
        AccessibilityManager accessibilityManager;
        if (context == null || (accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility")) == null) {
            return false;
        }
        return accessibilityManager.isEnabled();
    }

    public float getBatteryPercentage(Context context) {
        Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return -1.0f;
        }
        return (registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1)) * 100.0f;
    }

    public int getCurrentVolume(Context context) {
        AudioManager audioManager;
        if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
            return -1;
        }
        return audioManager.getStreamVolume(3);
    }

    public boolean isCharging(Context context) {
        Intent registerReceiver;
        if (context == null || (registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"))) == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public boolean isSystemAlertPermissions(Context context) {
        if (context == null) {
            return false;
        }
        return checkFloatPermission(context);
    }
}
