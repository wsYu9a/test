package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.biz.f;
import com.tencent.bugly.crashreport.common.strategy.c;
import com.tencent.bugly.proguard.H;
import com.tencent.bugly.proguard.I;
import com.tencent.bugly.proguard.J;
import com.tencent.bugly.proguard.T;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ba;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public static boolean f24586a = true;

    /* renamed from: b */
    public static List<a> f24587b = new ArrayList();

    /* renamed from: c */
    public static boolean f24588c;

    /* renamed from: d */
    private static J f24589d;

    /* renamed from: e */
    private static boolean f24590e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.P;
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, (BuglyStrategy) null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (f24590e) {
                X.e("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(X.f25019b, "[init] context of init() is null, check it.");
                return;
            }
            com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
            if (a(a2)) {
                f24586a = false;
                return;
            }
            String e2 = a2.e();
            if (e2 == null) {
                Log.e(X.f25019b, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
            } else {
                a(context, e2, a2.ba, buglyStrategy);
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (f24590e) {
                X.e("[init] initial Multi-times, ignore this.", new Object[0]);
                return;
            }
            if (context == null) {
                Log.w(X.f25019b, "[init] context is null, check it.");
                return;
            }
            if (str == null) {
                Log.e(X.f25019b, "init arg 'crashReportAppID' should not be null!");
                return;
            }
            f24590e = true;
            if (z) {
                f24588c = true;
                X.f25020c = true;
                X.e("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                X.b("--------------------------------------------------------------------------------------------", new Object[0]);
                X.e("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                X.e("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                X.e("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                X.e("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                X.b("--------------------------------------------------------------------------------------------", new Object[0]);
                X.d("[init] Open debug mode of Bugly.", new Object[0]);
            }
            X.c(" crash report start initializing...", new Object[0]);
            X.d("[init] Bugly start initializing...", new Object[0]);
            X.c("[init] Bugly complete version: v%s", "3.4.12(1.5.23)");
            Context a2 = ca.a(context);
            com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a2);
            a3.E();
            ba.a(a2);
            f24589d = J.a(a2, f24587b);
            T.a(a2);
            c a4 = c.a(a2, f24587b);
            H a5 = H.a(a2);
            if (a(a3)) {
                f24586a = false;
                return;
            }
            a3.c(str);
            X.c("[param] Set APP ID:%s", str);
            a(buglyStrategy, a3);
            for (int i2 = 0; i2 < f24587b.size(); i2++) {
                try {
                    if (a5.a(f24587b.get(i2).id)) {
                        f24587b.get(i2).init(a2, z, buglyStrategy);
                    }
                } catch (Throwable th) {
                    if (!X.b(th)) {
                        th.printStackTrace();
                    }
                }
            }
            f.b(a2, buglyStrategy);
            a4.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
            X.d("[init] Bugly initialization finished.", new Object[0]);
        }
    }

    private static void a(BuglyStrategy buglyStrategy, com.tencent.bugly.crashreport.common.info.a aVar) {
        byte[] bArr;
        if (buglyStrategy == null) {
            return;
        }
        String appVersion = buglyStrategy.getAppVersion();
        if (!TextUtils.isEmpty(appVersion)) {
            if (appVersion.length() > 100) {
                String substring = appVersion.substring(0, 100);
                X.e("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                appVersion = substring;
            }
            aVar.E = appVersion;
            X.c("[param] Set App version: %s", buglyStrategy.getAppVersion());
        }
        try {
            if (buglyStrategy.isReplaceOldChannel()) {
                String appChannel = buglyStrategy.getAppChannel();
                if (!TextUtils.isEmpty(appChannel)) {
                    if (appChannel.length() > 100) {
                        String substring2 = appChannel.substring(0, 100);
                        X.e("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                        appChannel = substring2;
                    }
                    f24589d.a(556, "app_channel", appChannel.getBytes(), (I) null, false);
                    aVar.I = appChannel;
                }
            } else {
                Map<String, byte[]> a2 = f24589d.a(556, (I) null, true);
                if (a2 != null && (bArr = a2.get("app_channel")) != null) {
                    aVar.I = new String(bArr);
                }
            }
            X.c("[param] Set App channel: %s", aVar.I);
        } catch (Exception e2) {
            if (f24588c) {
                e2.printStackTrace();
            }
        }
        String appPackageName = buglyStrategy.getAppPackageName();
        if (!TextUtils.isEmpty(appPackageName)) {
            if (appPackageName.length() > 100) {
                String substring3 = appPackageName.substring(0, 100);
                X.e("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                appPackageName = substring3;
            }
            aVar.f24754g = appPackageName;
            X.c("[param] Set App package: %s", buglyStrategy.getAppPackageName());
        }
        String deviceID = buglyStrategy.getDeviceID();
        if (deviceID != null) {
            if (deviceID.length() > 100) {
                String substring4 = deviceID.substring(0, 100);
                X.e("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                deviceID = substring4;
            }
            aVar.d(deviceID);
            X.c("[param] Set device ID: %s", deviceID);
        }
        aVar.f24757j = buglyStrategy.isUploadProcess();
        ba.f25030c = buglyStrategy.isBuglyLogUpload();
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!f24587b.contains(aVar)) {
                f24587b.add(aVar);
            }
        }
    }
}
