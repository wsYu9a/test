package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* loaded from: classes.dex */
public class Bugly {

    /* renamed from: a */
    private static boolean f24570a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            com.tencent.bugly.crashreport.common.info.a m = com.tencent.bugly.crashreport.common.info.a.m();
            if (m == null) {
                return null;
            }
            if (TextUtils.isEmpty(m.I)) {
                J a2 = J.a();
                if (a2 == null) {
                    return m.I;
                }
                Map<String, byte[]> a3 = a2.a(556, (I) null, true);
                if (a3 != null && (bArr = a3.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return m.I;
        }
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        CrashReport.setIsDevelopmentDevice(context, z);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i2) {
        CrashReport.setUserSceneTag(context, i2);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (f24570a) {
                return;
            }
            f24570a = true;
            Context a2 = ca.a(context);
            applicationContext = a2;
            if (a2 == null) {
                Log.e(X.f25019b, "init arg 'context' should not be null!");
                return;
            }
            b.a(CrashModule.getInstance());
            b.a(Beta.getInstance());
            b.f24586a = enable;
            b.a(applicationContext, str, z, buglyStrategy);
        }
    }
}
