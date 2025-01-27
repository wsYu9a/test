package com.umeng.commonsdk.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class k {

    /* renamed from: b */
    public static final String f24550b = "_dsk_s";

    /* renamed from: c */
    public static final String f24551c = "_thm_z";

    /* renamed from: d */
    public static final String f24552d = "_gdf_r";

    /* renamed from: a */
    public static final String f24549a = bd.b().b(bd.f23539s);

    /* renamed from: e */
    private static Object f24553e = new Object();

    /* renamed from: com.umeng.commonsdk.internal.utils.k$1 */
    public static class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ String[] f24554a;

        /* renamed from: b */
        final /* synthetic */ Context f24555b;

        public AnonymousClass1(String[] strArr, Context context) {
            strArr = strArr;
            context = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                strArr[0] = k.c();
                strArr[1] = k.a();
                strArr[2] = k.b();
                ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                k.b(context, strArr);
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
            }
        }
    }

    public static void b(Context context) {
        if (c(context)) {
            return;
        }
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1

            /* renamed from: a */
            final /* synthetic */ String[] f24554a;

            /* renamed from: b */
            final /* synthetic */ Context f24555b;

            public AnonymousClass1(String[] strArr, Context context2) {
                strArr = strArr;
                context = context2;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = k.c();
                    strArr[1] = k.a();
                    strArr[2] = k.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    k.b(context, strArr);
                } catch (Throwable th2) {
                    UMCrashManager.reportCrash(context, th2);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f24549a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f24550b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f24549a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f24553e) {
                jSONObject.put(f24550b, sharedPreferences.getString(f24550b, ""));
                jSONObject.put(f24551c, sharedPreferences.getString(f24551c, ""));
                jSONObject.put(f24552d, sharedPreferences.getString(f24552d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            return null;
        }
    }

    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f24549a, 0)) == null) {
            return;
        }
        synchronized (f24553e) {
            sharedPreferences.edit().putString(f24550b, strArr[0]).putString(f24551c, strArr[1]).putString(f24552d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            java.lang.String r0 = "mtd"
            java.lang.String r1 = "sda"
            java.lang.String r2 = "mmcblk"
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L35
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L35
            java.lang.String r6 = "/proc/diskstats"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L35
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L35
        L13:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L30
            if (r3 == 0) goto L32
            boolean r5 = r3.contains(r2)     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L21
            r0 = r2
            goto L38
        L21:
            boolean r5 = r3.contains(r1)     // Catch: java.lang.Throwable -> L30
            if (r5 == 0) goto L29
            r0 = r1
            goto L38
        L29:
            boolean r3 = r3.contains(r0)     // Catch: java.lang.Throwable -> L30
            if (r3 == 0) goto L13
            goto L38
        L30:
            r3 = r4
            goto L35
        L32:
            java.lang.String r0 = "unknown"
            goto L38
        L35:
            java.lang.String r0 = "noper"
            r4 = r3
        L38:
            if (r4 == 0) goto L3d
            r4.close()     // Catch: java.lang.Throwable -> L3d
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static String b() {
        int i10;
        try {
            i10 = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i10 = -1;
        }
        if (i10 > 0) {
            return "goldfish";
        }
        if (i10 < 0) {
            return "noper";
        }
        return "unknown";
    }

    public static int a(String str, String str2) throws IOException {
        int i10;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i10 = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i10 = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i10;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i10;
        try {
            i10 = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i10 = -1;
        }
        if (i10 > 0) {
            return "thermal_zone";
        }
        if (i10 < 0) {
            return "noper";
        }
        return "unknown";
    }
}
