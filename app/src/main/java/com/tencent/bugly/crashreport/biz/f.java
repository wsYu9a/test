package com.tencent.bugly.crashreport.biz;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.W;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.List;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public static boolean f22263a = false;

    /* renamed from: b */
    private static int f22264b = 10;

    /* renamed from: c */
    private static long f22265c = 300000;

    /* renamed from: d */
    private static long f22266d = 30000;

    /* renamed from: e */
    private static long f22267e = 0;

    /* renamed from: f */
    private static int f22268f = 0;

    /* renamed from: g */
    private static long f22269g = 0;

    /* renamed from: h */
    private static long f22270h = 0;

    /* renamed from: i */
    public static c f22271i = null;

    /* renamed from: j */
    private static long f22272j = 0;

    /* renamed from: k */
    private static Application.ActivityLifecycleCallbacks f22273k = null;

    /* renamed from: l */
    private static Class<?> f22274l = null;

    /* renamed from: m */
    private static boolean f22275m = true;

    public static /* synthetic */ int i() {
        int i10 = f22268f;
        f22268f = i10 + 1;
        return i10;
    }

    public static void l() {
        c cVar = f22271i;
        if (cVar != null) {
            cVar.a(2, false, 0L);
        }
    }

    private static void m() {
        com.tencent.bugly.crashreport.common.info.a m10 = com.tencent.bugly.crashreport.common.info.a.m();
        if (m10 == null) {
            return;
        }
        String str = null;
        boolean z10 = false;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getMethodName().equals("onCreate")) {
                str = stackTraceElement.getClassName();
            }
            if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                z10 = true;
            }
        }
        if (str == null) {
            str = "unknown";
        } else if (z10) {
            m10.a(true);
        } else {
            str = "background";
        }
        m10.W = str;
    }

    private static void n() {
        f22270h = System.currentTimeMillis();
        f22271i.a(1, false, 0L);
        X.c("[session] launch app, new start", new Object[0]);
    }

    public static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean z10;
        boolean z11;
        boolean z12 = false;
        if (buglyStrategy != null) {
            z11 = buglyStrategy.recordUserInfoOnceADay();
            z10 = buglyStrategy.isEnableUserInfo();
        } else {
            z10 = true;
            z11 = false;
        }
        if (!z11) {
            z12 = z10;
        } else if (!b(context)) {
            return;
        }
        m();
        if (z12) {
            c(context);
        }
        if (f22275m) {
            n();
            f22271i.a();
            f22271i.b(21600000L);
        }
    }

    @TargetApi(14)
    private static void d(Context context) {
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f22273k;
            if (activityLifecycleCallbacks != null) {
                application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            }
        } catch (Exception e10) {
            if (X.b(e10)) {
                return;
            }
            e10.printStackTrace();
        }
    }

    private static boolean b(Context context) {
        com.tencent.bugly.crashreport.common.info.a a10 = com.tencent.bugly.crashreport.common.info.a.a(context);
        List<UserInfoBean> a11 = f22271i.a(a10.f22296h);
        if (a11 == null) {
            return true;
        }
        for (int i10 = 0; i10 < a11.size(); i10++) {
            UserInfoBean userInfoBean = a11.get(i10);
            if (userInfoBean.f22242n.equals(a10.E) && userInfoBean.f22230b == 1) {
                long b10 = ca.b();
                if (b10 <= 0) {
                    return true;
                }
                if (userInfoBean.f22233e >= b10) {
                    if (userInfoBean.f22234f <= 0) {
                        f22271i.b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void a(StrategyBean strategyBean, boolean z10) {
        c cVar = f22271i;
        if (cVar != null && !z10) {
            cVar.b();
        }
        if (strategyBean == null) {
            return;
        }
        long j10 = strategyBean.f22352p;
        if (j10 > 0) {
            f22266d = j10;
        }
        int i10 = strategyBean.f22357u;
        if (i10 > 0) {
            f22264b = i10;
        }
        long j11 = strategyBean.f22358v;
        if (j11 > 0) {
            f22265c = j11;
        }
    }

    public static void c(long j10) {
        if (j10 < 0) {
            j10 = com.tencent.bugly.crashreport.common.strategy.c.b().c().f22352p;
        }
        f22267e = j10;
    }

    public static void a(Context context) {
        if (!f22263a || context == null) {
            return;
        }
        d(context);
        f22263a = false;
    }

    @TargetApi(14)
    private static void c(Context context) {
        Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
        if (application == null) {
            return;
        }
        try {
            if (f22273k == null) {
                f22273k = new e();
            }
            application.registerActivityLifecycleCallbacks(f22273k);
        } catch (Exception e10) {
            if (X.b(e10)) {
                return;
            }
            e10.printStackTrace();
        }
    }

    public static void b(Context context, BuglyStrategy buglyStrategy) {
        long j10;
        if (f22263a) {
            return;
        }
        boolean z10 = com.tencent.bugly.crashreport.common.info.a.a(context).f22300j;
        f22275m = z10;
        f22271i = new c(context, z10);
        f22263a = true;
        if (buglyStrategy != null) {
            f22274l = buglyStrategy.getUserInfoActivity();
            j10 = buglyStrategy.getAppReportDelay();
        } else {
            j10 = 0;
        }
        if (j10 <= 0) {
            c(context, buglyStrategy);
        } else {
            W.c().a(new d(context, buglyStrategy), j10);
        }
    }

    public static String b(String str, String str2) {
        return ca.a() + "  " + str + "  " + str2 + "\n";
    }
}
