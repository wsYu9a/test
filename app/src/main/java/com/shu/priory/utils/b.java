package com.shu.priory.utils;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Process;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.shu.priory.config.SDKConstants;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    private static volatile Point[] f17301a = new Point[2];

    /* renamed from: b */
    private static volatile boolean f17302b;

    /* renamed from: c */
    private static volatile boolean f17303c;

    public static Rect a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        return new Rect(i10, iArr[1], view.getWidth() + i10, iArr[1] + view.getHeight());
    }

    public static boolean b(Context context) {
        return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }

    public static Rect c(Context context) {
        return new Rect(0, 0, ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth(), e(context));
    }

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    private static int e(Context context) {
        return !h(context) ? f(context) : g(context);
    }

    private static int f(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return 0;
    }

    private static int g(Context context) {
        char c10 = context.getResources().getConfiguration().orientation == 1 ? (char) 0 : (char) 1;
        if (f17301a[c10] == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return f(context);
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f17301a[c10] = point;
        }
        return f17301a[c10].y;
    }

    private static boolean h(Context context) {
        float f10;
        float f11;
        if (f17302b) {
            return f17303c;
        }
        f17302b = true;
        f17303c = false;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            int i10 = point.x;
            int i11 = point.y;
            if (i10 < i11) {
                f11 = i10;
                f10 = i11;
            } else {
                float f12 = i11;
                f10 = i10;
                f11 = f12;
            }
            if (f10 / f11 >= 1.97f) {
                f17303c = true;
            }
        }
        return f17303c;
    }

    public static boolean a(Context context) {
        String packageName = context.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return true;
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.equals(packageName)) {
                if (next.importance == 100) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "deviceCanHandleIntent:" + e10.getMessage());
            return false;
        }
    }

    public static boolean a(Context context, View view) {
        Rect c10 = c(context);
        Rect a10 = a(view);
        int i10 = (int) ((a10.bottom - a10.top) * 0.3d);
        Rect rect = new Rect(c10.left, c10.top + i10, c10.right, c10.bottom - i10);
        return Rect.intersects(rect, a10) || rect.contains(a10);
    }

    public static boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().getPackageArchiveInfo(str, 1) != null) {
                h.d(SDKConstants.TAG, "checkUninstallApk info not null");
                return true;
            }
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "checkUninstallApk error:" + e10.getMessage());
        }
        h.d(SDKConstants.TAG, "checkUninstallApk info is null");
        return false;
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("http:") || str.startsWith("https:")) ? false : true;
    }
}
