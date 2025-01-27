package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    public static final String f26239a = "UM_PROBE_DATA";

    /* renamed from: b */
    public static final String f26240b = "_dsk_s";

    /* renamed from: c */
    public static final String f26241c = "_thm_z";

    /* renamed from: d */
    public static final String f26242d = "_gdf_r";

    /* renamed from: e */
    private static Object f26243e = new Object();

    /* renamed from: com.umeng.commonsdk.internal.utils.k$1 */
    static class AnonymousClass1 extends Thread {

        /* renamed from: a */
        final /* synthetic */ String[] f26244a;

        /* renamed from: b */
        final /* synthetic */ Context f26245b;

        AnonymousClass1(String[] strArr, Context context) {
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
            } catch (Throwable th) {
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static void b(Context context) {
        if (c(context)) {
            return;
        }
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1

            /* renamed from: a */
            final /* synthetic */ String[] f26244a;

            /* renamed from: b */
            final /* synthetic */ Context f26245b;

            AnonymousClass1(String[] strArr, Context context2) {
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
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26239a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f26240b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f26239a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f26243e) {
                jSONObject.put(f26240b, sharedPreferences.getString(f26240b, ""));
                jSONObject.put(f26241c, sharedPreferences.getString(f26241c, ""));
                jSONObject.put(f26242d, sharedPreferences.getString(f26242d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f26239a, 0)) == null) {
            return;
        }
        synchronized (f26243e) {
            sharedPreferences.edit().putString(f26240b, strArr[0]).putString(f26241c, strArr[1]).putString(f26242d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L34
            java.lang.String r3 = "/proc/diskstats"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L34
        Ld:
            java.lang.String r0 = r1.readLine()     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = "mtd"
            java.lang.String r3 = "sda"
            java.lang.String r4 = "mmcblk"
            if (r0 == 0) goto L30
            boolean r5 = r0.contains(r4)     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto L21
            r2 = r4
            goto L37
        L21:
            boolean r4 = r0.contains(r3)     // Catch: java.lang.Throwable -> L33
            if (r4 == 0) goto L29
            r2 = r3
            goto L37
        L29:
            boolean r0 = r0.contains(r2)     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto Ld
            goto L37
        L30:
            java.lang.String r2 = "unknown"
            goto L37
        L33:
            r0 = r1
        L34:
            java.lang.String r2 = "noper"
            r1 = r0
        L37:
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.lang.Throwable -> L3c
        L3c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static String b() {
        int i2;
        try {
            i2 = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i2 = -1;
        }
        return i2 > 0 ? "goldfish" : i2 < 0 ? "noper" : EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public static int a(String str, String str2) throws IOException {
        int i2;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i2 = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i2 = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i2;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i2;
        try {
            i2 = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i2 = -1;
        }
        return i2 > 0 ? "thermal_zone" : i2 < 0 ? "noper" : EnvironmentCompat.MEDIA_UNKNOWN;
    }
}
