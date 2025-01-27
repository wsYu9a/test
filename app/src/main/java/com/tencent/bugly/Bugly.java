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

/* loaded from: classes4.dex */
public class Bugly {

    /* renamed from: a */
    private static boolean f22037a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
            if (m10 == null) {
                return null;
            }
            if (TextUtils.isEmpty(m10.I)) {
                J a10 = J.a();
                if (a10 == null) {
                    return m10.I;
                }
                Map<String, byte[]> a11 = a10.a(556, (I) null, true);
                if (a11 != null && (bArr = a11.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return m10.I;
        }
    }

    public static void init(Context context, String str, boolean z10) {
        init(context, str, z10, null);
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setIsDevelopmentDevice(Context context, boolean z10) {
        CrashReport.setIsDevelopmentDevice(context, z10);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i10) {
        CrashReport.setUserSceneTag(context, i10);
    }

    public static synchronized void init(Context context, String str, boolean z10, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (f22037a) {
                return;
            }
            f22037a = true;
            Context a10 = ca.a(context);
            applicationContext = a10;
            if (a10 == null) {
                Log.e(X.f22679b, "init arg 'context' should not be null!");
                return;
            }
            b.a(CrashModule.getInstance());
            b.a(Beta.getInstance());
            b.f22064a = enable;
            b.a(applicationContext, str, z10, buglyStrategy);
        }
    }
}
