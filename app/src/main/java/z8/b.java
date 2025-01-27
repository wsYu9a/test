package z8;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.Log;
import com.kuaishou.weapon.p0.an;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

/* loaded from: classes3.dex */
public abstract class b {
    public static boolean a(Context context) {
        return c(context) || d(context) || b();
    }

    public static boolean b() {
        boolean z10 = false;
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (!readLine.endsWith(".so") && !readLine.endsWith(".jar")) {
                }
                hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
            }
            for (String str : hashSet) {
                if (str.contains("com.saurik.substrate")) {
                    Log.wtf("HookDetection", "Substrate shared object found: " + str);
                    z10 = true;
                }
                if (str.contains("XposedBridge.jar")) {
                    Log.wtf("HookDetection", "Xposed JAR found: " + str);
                    z10 = true;
                }
            }
            bufferedReader.close();
        } catch (Exception e10) {
            Log.wtf("HookDetection", e10.toString());
        }
        return z10;
    }

    public static boolean c(Context context) {
        boolean z10 = false;
        for (ApplicationInfo applicationInfo : context.getPackageManager().getInstalledApplications(128)) {
            if (applicationInfo.packageName.equals("de.robv.android.xposed.installer")) {
                Log.wtf("HookDetection", "Xposed found on the system.");
                z10 = true;
            }
            if (applicationInfo.packageName.equals("com.saurik.substrate")) {
                Log.wtf("HookDetection", "Substrate found on the system.");
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean d(Context context) {
        try {
            throw new Exception("blah");
        } catch (Exception e10) {
            boolean z10 = false;
            int i10 = 0;
            for (StackTraceElement stackTraceElement : e10.getStackTrace()) {
                if (stackTraceElement.getClassName().equals("com.android.internal.os.ZygoteInit") && (i10 = i10 + 1) == 2) {
                    Log.wtf("HookDetection", "Substrate is active on the device.");
                    z10 = true;
                }
                if (stackTraceElement.getClassName().equals("com.saurik.substrate.MS$2") && stackTraceElement.getMethodName().equals("invoked")) {
                    Log.wtf("HookDetection", "A method on the stack trace has been hooked using Substrate.");
                    z10 = true;
                }
                if (stackTraceElement.getClassName().equals(an.f10772b) && stackTraceElement.getMethodName().equals("main")) {
                    Log.wtf("HookDetection", "Xposed is active on the device.");
                    z10 = true;
                }
                if (stackTraceElement.getClassName().equals(an.f10772b) && stackTraceElement.getMethodName().equals("handleHookedMethod")) {
                    Log.wtf("HookDetection", "A method on the stack trace has been hooked using Xposed.");
                    z10 = true;
                }
            }
            return z10;
        }
    }
}
