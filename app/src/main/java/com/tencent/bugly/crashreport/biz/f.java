package com.tencent.bugly.crashreport.biz;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.List;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public static boolean f24732a = false;

    /* renamed from: b */
    private static int f24733b = 10;

    /* renamed from: c */
    private static long f24734c = 300000;

    /* renamed from: d */
    private static long f24735d = 30000;

    /* renamed from: e */
    private static long f24736e = 0;

    /* renamed from: f */
    private static int f24737f = 0;

    /* renamed from: g */
    private static long f24738g = 0;

    /* renamed from: h */
    private static long f24739h = 0;

    /* renamed from: i */
    public static c f24740i = null;

    /* renamed from: j */
    private static long f24741j = 0;
    private static Application.ActivityLifecycleCallbacks k = null;
    private static Class<?> l = null;
    private static boolean m = true;

    static /* synthetic */ int i() {
        int i2 = f24737f;
        f24737f = i2 + 1;
        return i2;
    }

    public static void l() {
        c cVar = f24740i;
        if (cVar != null) {
            cVar.a(2, false, 0L);
        }
    }

    private static void m() {
        com.tencent.bugly.crashreport.common.info.a m2 = com.tencent.bugly.crashreport.common.info.a.m();
        if (m2 == null) {
            return;
        }
        String str = null;
        boolean z = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onCreate")) {
                str = stackTraceElement.getClassName();
            }
            if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                z = true;
            }
        }
        if (str == null) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        } else if (z) {
            m2.a(true);
        } else {
            str = "background";
        }
        m2.W = str;
    }

    private static void n() {
        f24739h = System.currentTimeMillis();
        f24740i.a(1, false, 0L);
        X.c("[session] launch app, new start", new Object[0]);
    }

    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (buglyStrategy != null) {
            z2 = buglyStrategy.recordUserInfoOnceADay();
            z = buglyStrategy.isEnableUserInfo();
        } else {
            z = true;
            z2 = false;
        }
        if (!z2) {
            z3 = z;
        } else if (!b(context)) {
            return;
        }
        m();
        if (z3) {
            c(context);
        }
        if (m) {
            n();
            f24740i.a();
            f24740i.b(21600000L);
        }
    }

    @TargetApi(14)
    private static void d(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = k;
            if (activityLifecycleCallbacks != null) {
                application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Exception e2) {
            if (X.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    private static boolean b(Context context) {
        com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
        List<UserInfoBean> a3 = f24740i.a(a2.f24755h);
        if (a3 == null) {
            return true;
        }
        for (int i2 = 0; i2 < a3.size(); i2++) {
            UserInfoBean userInfoBean = a3.get(i2);
            if (userInfoBean.n.equals(a2.E) && userInfoBean.f24708b == 1) {
                long b2 = ca.b();
                if (b2 <= 0) {
                    return true;
                }
                if (userInfoBean.f24711e >= b2) {
                    if (userInfoBean.f24712f <= 0) {
                        f24740i.b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        c cVar = f24740i;
        if (cVar != null && !z) {
            cVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.p;
        if (j2 > 0) {
            f24735d = j2;
        }
        int i2 = strategyBean.u;
        if (i2 > 0) {
            f24733b = i2;
        }
        long j3 = strategyBean.v;
        if (j3 > 0) {
            f24734c = j3;
        }
    }

    public static void c(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.c.b().c().p;
        }
        f24736e = j2;
    }

    public static void a(Context context) {
        if (!f24732a || context == null) {
            return;
        }
        d(context);
        f24732a = false;
    }

    @TargetApi(14)
    private static void c(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            return;
        }
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (k == null) {
                k = new e();
            }
            application.registerActivityLifecycleCallbacks(k);
        } catch (Exception e2) {
            if (X.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void b(Context context, BuglyStrategy buglyStrategy) {
        long j2;
        if (f24732a) {
            return;
        }
        boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).f24757j;
        m = z;
        f24740i = new c(context, z);
        f24732a = true;
        if (buglyStrategy != null) {
            l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            W.c().a(new d(context, buglyStrategy), j2);
        }
    }

    public static String b(String str, String str2) {
        return ca.a() + "  " + str + "  " + str2 + "\n";
    }
}
