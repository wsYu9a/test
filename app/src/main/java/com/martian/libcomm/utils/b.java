package com.martian.libcomm.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.Log;
import com.kuaishou.weapon.p0.an;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/* loaded from: classes2.dex */
public abstract class b {
    public static boolean a(Context context) {
        return c(context) || d(context) || b();
    }

    public static boolean b() {
        boolean z = false;
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            for (String str : hashSet) {
                if (str.contains("com.saurik.substrate")) {
                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                    z = true;
                }
                if (str.contains("XposedBridge.jar")) {
                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                    z = true;
                }
            }
            bufferedReader.close();
        } catch (Exception e2) {
            Log.wtf("HookDetection", e2.toString());
        }
        return z;
    }

    public static boolean c(Context context) {
        boolean z = false;
        for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(128)) {
            if (applicationInfo.packageName.equals("de.robv.android.xposed.installer")) {
                Log.wtf("HookDetection", "Xposed found on the system.");
                z = true;
            }
            if (applicationInfo.packageName.equals("com.saurik.substrate")) {
                Log.wtf("HookDetection", "Substrate found on the system.");
                z = true;
            }
        }
        return z;
    }

    public static boolean d(Context context) {
        try {
            throw new Exception("blah");
        } catch (Exception e2) {
            boolean z = false;
            int i2 = 0;
            for (StackTraceElement stackTraceElement : e2.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i2 = i2 + 1) == 2) {
                    Log.wtf("HookDetection", "Substrate is active on the device.");
                    z = true;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                    z = true;
                }
                if (stackTraceElement.getClassName().equals(an.f9076b) && stackTraceElement.getMethodName().equals("main")) {
                    Log.wtf("HookDetection", "Xposed is active on the device.");
                    z = true;
                }
                if (stackTraceElement.getClassName().equals(an.f9076b) && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    Log.wtf("HookDetection", "A method on the stack trace has been hooked using Xposed.");
                    z = true;
                }
            }
            return z;
        }
    }
}
