package com.vivo.mobilead.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.vivo.ic.SystemUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class n {

    /* renamed from: a */
    private static int f30731a = 0;

    /* renamed from: b */
    private static int f30732b = 0;

    /* renamed from: c */
    private static float f30733c = 0.0f;

    /* renamed from: d */
    private static double f30734d = 0.0d;

    /* renamed from: e */
    private static boolean f30735e = false;

    /* renamed from: f */
    private static long f30736f = 0;

    /* renamed from: g */
    private static String f30737g = "";

    /* renamed from: h */
    private static int f30738h = -1;

    /* renamed from: i */
    private static String f30739i = "0";

    public static int c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr[1];
    }

    public static void d(Context context) {
        try {
            m();
            f30734d = i();
            f30736f = Math.round(Math.sqrt(Math.pow(f30731a, 2.0d) + Math.pow(f30732b, 2.0d)) / f30734d);
            String str = Build.MANUFACTURER;
            a.a(context);
            f30737g = context.getPackageName();
        } catch (Exception e2) {
            x0.b("DeviceInfo", "init device info error : ", e2);
            f30734d = 5.0d;
        }
    }

    public static int e() {
        return m.d(com.vivo.mobilead.manager.f.j().c());
    }

    public static int f() {
        return m.e(com.vivo.mobilead.manager.f.j().c());
    }

    public static long g() {
        return f30736f;
    }

    public static String h() {
        return f30737g;
    }

    private static double i() {
        Context c2;
        if (Build.VERSION.SDK_INT < 17 || (c2 = com.vivo.mobilead.manager.f.j().c()) == null) {
            return 5.0d;
        }
        try {
            WindowManager windowManager = (WindowManager) c2.getSystemService("window");
            windowManager.getDefaultDisplay().getRealSize(new Point());
            DisplayMetrics displayMetrics = c2.getResources().getDisplayMetrics();
            return Math.sqrt(Math.pow(r4.x / displayMetrics.xdpi, 2.0d) + Math.pow(r4.y / displayMetrics.ydpi, 2.0d));
        } catch (Exception e2) {
            VOpenLog.w("DeviceInfo", "" + e2.getMessage());
            return 5.0d;
        }
    }

    public static String j() {
        if (!SystemUtils.isVivoPhone()) {
            return "";
        }
        return l() + k();
    }

    @Nullable
    private static String k() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.version").getInputStream()), 1024);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return readLine;
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                return "";
            }
            try {
                bufferedReader2.close();
                return "";
            } catch (Exception unused4) {
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    @Nullable
    private static String l() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.name").getInputStream()), 1024);
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return readLine;
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 == null) {
                return "";
            }
            try {
                bufferedReader2.close();
                return "";
            } catch (Exception unused4) {
                return "";
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    private static void m() {
        try {
        } catch (Exception e2) {
            x0.b("DeviceInfo", "initScreenSize error : ", e2);
            f30731a = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
            f30732b = 1920;
            f30733c = 3.0f;
        }
        if (com.vivo.mobilead.manager.f.j().c() == null) {
            f30731a = DownloadErrorCode.ERROR_TTNET_NOT_MODIFIED;
            f30732b = 1920;
            f30733c = 3.0f;
            return;
        }
        int i2 = com.vivo.mobilead.manager.f.j().c().getResources().getDisplayMetrics().widthPixels;
        int i3 = com.vivo.mobilead.manager.f.j().c().getResources().getDisplayMetrics().heightPixels;
        if (i3 < i2) {
            f30732b = i2;
            f30731a = i3;
        } else {
            f30732b = i3;
            f30731a = i2;
        }
        float f2 = com.vivo.mobilead.manager.f.j().c().getResources().getDisplayMetrics().density;
        f30733c = f2;
        if (f30731a > 0 && f30732b > 0 && f2 > 0.0f) {
            f30735e = true;
        }
        x0.a("DeviceInfo", "initScreenSize sScreenWidth = " + f30731a + " ,sScreenHeight = " + f30732b + " , sScreenDensity = " + f30733c);
    }

    public static int[] b(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return new int[]{rect.right, rect.bottom};
    }

    public static long c() {
        return SystemClock.elapsedRealtime();
    }

    public static int[] a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int c(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
                return String.valueOf(batteryManager != null ? batteryManager.getIntProperty(4) : 0);
            } catch (Exception e2) {
                VOpenLog.w("DeviceInfo", "" + e2.getMessage());
            }
        }
        return "";
    }

    public static int b(Context context) {
        if (context == null) {
            return m.a(context, 1080.0f);
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return m.a(context, 1080.0f);
        }
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        if (displayMetrics == null) {
            return m.a(context, 1080.0f);
        }
        Configuration configuration = resources.getConfiguration();
        if (configuration == null) {
            return m.a(context, 1080.0f);
        }
        if (configuration.orientation == 2) {
            return displayMetrics.heightPixels;
        }
        return displayMetrics.widthPixels;
    }

    public static class a {

        /* renamed from: a */
        private static volatile long f30740a;

        /* renamed from: b */
        private static volatile long f30741b;

        protected static void a(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                    if (packageInfo != null) {
                        int unused = n.f30738h = packageInfo.versionCode;
                        String unused2 = n.f30739i = packageInfo.versionName;
                        f30740a = packageInfo.firstInstallTime;
                        f30741b = packageInfo.lastUpdateTime;
                    }
                } catch (Exception e2) {
                    x0.a("DeviceInfo", "initPackageInfo error! " + e2);
                }
            }
        }

        public static long b() {
            return f30741b;
        }

        public static int c() {
            return n.f30738h;
        }

        public static String d() {
            return n.f30739i;
        }

        public static long a() {
            return f30740a;
        }
    }

    public static boolean a(Activity activity) {
        int i2;
        boolean booleanValue;
        boolean z = false;
        try {
            i2 = Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
        }
        if (i2 >= 30) {
            Window window = activity.getWindow();
            Method method = null;
            try {
                Class<?> cls = window.getClass();
                if (cls != null && cls.getSuperclass() != null) {
                    for (Method method2 : cls.getSuperclass().getDeclaredMethods()) {
                        if (method2 != null && "getWindowControllerCallback".equals(method2.getName())) {
                            method = method2;
                        }
                    }
                }
                if (method != null) {
                    Object invoke = method.invoke(window, new Object[0]);
                    if (invoke != null) {
                        for (Method method3 : invoke.getClass().getDeclaredMethods()) {
                            if (method3 != null && "isInVivoFreeformMode".equals(method3.getName())) {
                                method = method3;
                            }
                        }
                        booleanValue = ((Boolean) method.invoke(invoke, new Object[0])).booleanValue();
                    }
                } else {
                    x0.b("DeviceInfo", "<isWindowModeFreeForm> registerActivityObserver not implement in IActivityManager");
                }
            } catch (Exception e2) {
                x0.b("DeviceInfo", "<isWindowModeFreeForm> registerActivityObserver-e = ", e2);
            }
            x0.a("DeviceInfo", "isWindowModeFreeForm，ret = " + z);
            return z;
        }
        if (i2 >= 28) {
            Object a2 = a(activity, "android.app.Activity", "isInVivoFreeformMode");
            if (a2 != null) {
                booleanValue = ((Boolean) a2).booleanValue();
            }
        } else {
            Object a3 = a(activity, "android.app.Activity", "getWindowStackId");
            if (a3 != null && ((Integer) a3).intValue() == 2) {
                z = true;
            }
        }
        x0.a("DeviceInfo", "isWindowModeFreeForm，ret = " + z);
        return z;
        z = booleanValue;
        x0.a("DeviceInfo", "isWindowModeFreeForm，ret = " + z);
        return z;
    }

    public static float d() {
        if (f30733c <= 0.0f || !f30735e) {
            m();
        }
        return f30733c;
    }

    private static Object a(Object obj, String str, String str2) {
        try {
            Method method = Class.forName(str).getMethod(str2, new Class[0]);
            if (method != null) {
                method.setAccessible(true);
                return method.invoke(obj, new Object[0]);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
        return null;
    }
}
