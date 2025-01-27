package com.opos.mobad.p;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {
    private static int a() {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int i2 = 0;
        if (allStackTraces != null && allStackTraces.size() > 0) {
            for (Thread thread : allStackTraces.keySet()) {
                if (thread.getName().startsWith("single_thread") || thread.getName().startsWith("comp_thread") || thread.getName().startsWith("io_thread") || thread.getName().startsWith("scheduled_thread")) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public static String a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            long maxMemory = Runtime.getRuntime().maxMemory();
            long j2 = Runtime.getRuntime().totalMemory();
            jSONObject.put("dmm", maxMemory);
            jSONObject.put("dtm", j2);
        } catch (Throwable unused) {
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j3 = memoryInfo.totalMem;
            long j4 = memoryInfo.availMem;
            jSONObject.put("mm", j3);
            jSONObject.put("am", j4);
        } catch (Throwable unused2) {
        }
        try {
            jSONObject.put("limits", a("/proc/self/limits"));
        } catch (Throwable unused3) {
        }
        try {
            jSONObject.put("status", a("/proc/self/status"));
        } catch (Throwable unused4) {
        }
        try {
            jSONObject.put("oposThreads", a());
        } catch (Throwable unused5) {
        }
        try {
            jSONObject.put("pfd", b("/proc/self/fd"));
        } catch (Throwable unused6) {
        }
        return jSONObject.toString();
    }

    private static String a(String str) {
        return a(str, 50);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0059, code lost:
    
        if (r1 == null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r4, int r5) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L50
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L50
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L50
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L50
            r4 = 0
        L10:
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Throwable -> L4e
            if (r2 == 0) goto L34
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L4e
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L4e
            if (r3 <= 0) goto L10
            int r4 = r4 + 1
            if (r5 == 0) goto L26
            if (r4 > r5) goto L10
        L26:
            java.lang.String r3 = "  "
            r0.append(r3)     // Catch: java.lang.Throwable -> L4e
            r0.append(r2)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r2 = "\n"
            r0.append(r2)     // Catch: java.lang.Throwable -> L4e
            goto L10
        L34:
            if (r5 <= 0) goto L4a
            if (r4 <= r5) goto L4a
            java.lang.String r5 = "  ......\n"
            r0.append(r5)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r5 = "  (number of records: "
            r0.append(r5)     // Catch: java.lang.Throwable -> L4e
            r0.append(r4)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r4 = ")\n"
            r0.append(r4)     // Catch: java.lang.Throwable -> L4e
        L4a:
            r1.close()     // Catch: java.lang.Exception -> L5c
            goto L5c
        L4e:
            r4 = move-exception
            goto L52
        L50:
            r4 = move-exception
            r1 = 0
        L52:
            java.lang.String r5 = "sysContext"
            java.lang.String r2 = "get info fail"
            com.opos.cmn.an.f.a.b(r5, r2, r4)     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L5c
            goto L4a
        L5c:
            java.lang.String r4 = r0.toString()
            return r4
        L61:
            r4 = move-exception
            if (r1 == 0) goto L67
            r1.close()     // Catch: java.lang.Exception -> L67
        L67:
            goto L69
        L68:
            throw r4
        L69:
            goto L68
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.p.a.a(java.lang.String, int):java.lang.String");
    }

    private static int b(String str) {
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return file.list().length;
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("sysContext", "get proc dir fail", th);
        }
        return 0;
    }
}
