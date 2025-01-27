package com.opos.cmn.an.h.a;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private static ActivityManager f16524a = null;

    /* renamed from: b */
    private static volatile String f16525b = "";

    public static ActivityManager a(Context context) {
        if (f16524a == null && context != null) {
            f16524a = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
        }
        return f16524a;
    }

    private static String a() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002c, code lost:
    
        if (r4.getPackageName().equals(r5) != false) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "ActMgrTool"
            r1 = 1
            r2 = 0
            android.app.ActivityManager r4 = a(r4)     // Catch: java.lang.Exception -> L2f
            if (r4 == 0) goto L35
            boolean r3 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L2f
            if (r3 != 0) goto L35
            java.util.List r4 = r4.getRunningTasks(r1)     // Catch: java.lang.Exception -> L2f
            boolean r3 = r4.isEmpty()     // Catch: java.lang.Exception -> L2f
            if (r3 != 0) goto L35
            java.lang.Object r4 = r4.get(r2)     // Catch: java.lang.Exception -> L2f
            android.app.ActivityManager$RunningTaskInfo r4 = (android.app.ActivityManager.RunningTaskInfo) r4     // Catch: java.lang.Exception -> L2f
            android.content.ComponentName r4 = r4.topActivity     // Catch: java.lang.Exception -> L2f
            if (r4 == 0) goto L35
            java.lang.String r4 = r4.getPackageName()     // Catch: java.lang.Exception -> L2f
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L2f
            if (r4 == 0) goto L35
            goto L36
        L2f:
            r4 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.c(r0, r1, r4)
        L35:
            r1 = 0
        L36:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r2 = "isRunningTasks pkgName="
            r4.append(r2)
            if (r5 == 0) goto L43
            goto L45
        L43:
            java.lang.String r5 = "null"
        L45:
            r4.append(r5)
            java.lang.String r5 = ",result="
            r4.append(r5)
            r4.append(r1)
            java.lang.String r4 = r4.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.a.a.a(android.content.Context, java.lang.String):boolean");
    }

    public static int b(Context context) {
        int i2;
        try {
            i2 = Process.myPid();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e2);
            i2 = -1;
        }
        com.opos.cmn.an.f.a.b("ActMgrTool", "getMyPid pid=" + i2);
        return i2;
    }

    private static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        if (r1 == null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String c() {
        /*
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L4f
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r3.<init>()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            int r4 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r3.append(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r4 = "/cmdline"
            r3.append(r4)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L4b
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L3f
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L3f
            if (r2 != 0) goto L39
            java.lang.String r0 = r0.trim()     // Catch: java.lang.Exception -> L3d java.lang.Throwable -> L3f
        L39:
            r1.close()     // Catch: java.lang.Exception -> L4f
            goto L4f
        L3d:
            goto L4c
        L3f:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L45
        L44:
            r1 = move-exception
        L45:
            if (r0 == 0) goto L4a
            r0.close()     // Catch: java.lang.Exception -> L4a
        L4a:
            throw r1
        L4b:
            r1 = r0
        L4c:
            if (r1 == 0) goto L4f
            goto L39
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.a.a.c():java.lang.String");
    }

    public static String c(Context context) {
        try {
            if (TextUtils.isEmpty(f16525b)) {
                f16525b = a();
                if (TextUtils.isEmpty(f16525b)) {
                    f16525b = b();
                }
                if (TextUtils.isEmpty(f16525b)) {
                    f16525b = c();
                }
                if (TextUtils.isEmpty(f16525b)) {
                    f16525b = f(context);
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "getMyProName", th);
        }
        if (f16525b == null) {
            f16525b = "";
        }
        com.opos.cmn.an.f.a.b("ActMgrTool", "getMyProName = " + f16525b);
        return f16525b;
    }

    public static boolean d(Context context) {
        boolean z;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e2);
        }
        if (a(context, context.getPackageName())) {
            if (e(context)) {
                z = true;
                com.opos.cmn.an.f.a.b("ActMgrTool", "isForegroundApp=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("ActMgrTool", "isForegroundApp=" + z);
        return z;
    }

    public static boolean e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        boolean z = false;
        try {
            ActivityManager a2 = a(context);
            if (a2 != null && (runningAppProcesses = a2.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                com.opos.cmn.an.f.a.b("ActMgrTool", "android.os.Process.myPid()=" + Process.myPid());
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    com.opos.cmn.an.f.a.b("ActMgrTool", "appProcess.processName=" + runningAppProcessInfo.processName + ",appProcess.pid=" + runningAppProcessInfo.pid + ",appProcess.importance=" + runningAppProcessInfo.importance);
                    if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.pid == Process.myPid()) {
                        z = true;
                    }
                }
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("ActMgrTool", "", e2);
        }
        com.opos.cmn.an.f.a.b("ActMgrTool", "isRunningAppProcesses result=" + z);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        r0 = r3.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String f(android.content.Context r6) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "ActMgrTool"
            android.app.ActivityManager r2 = a(r6)     // Catch: java.lang.Exception -> L29
            if (r2 == 0) goto L2d
            java.util.List r2 = r2.getRunningAppProcesses()     // Catch: java.lang.Exception -> L29
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Exception -> L29
        L12:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L2d
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> L29
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch: java.lang.Exception -> L29
            int r4 = r3.pid     // Catch: java.lang.Exception -> L29
            int r5 = b(r6)     // Catch: java.lang.Exception -> L29
            if (r4 != r5) goto L12
            java.lang.String r0 = r3.processName     // Catch: java.lang.Exception -> L29
            goto L2d
        L29:
            r6 = move-exception
            com.opos.cmn.an.f.a.c(r1, r0, r6)
        L2d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "getProcessNameByAms = "
            r6.append(r2)
            if (r0 == 0) goto L3b
            r2 = r0
            goto L3d
        L3b:
            java.lang.String r2 = " null "
        L3d:
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            com.opos.cmn.an.f.a.b(r1, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.h.a.a.f(android.content.Context):java.lang.String");
    }
}
