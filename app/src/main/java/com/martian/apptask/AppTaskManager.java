package com.martian.apptask;

import android.content.Context;
import android.text.TextUtils;
import ba.j;
import com.martian.apptask.data.AlipayRedpaper;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.common.ConfigSingleton;
import i8.g;
import x8.c;

/* loaded from: classes3.dex */
public class AppTaskManager {

    /* renamed from: b */
    public static final String f11985b = "package_";

    /* renamed from: c */
    public static final String f11986c = "package_time_";

    /* renamed from: d */
    public static final String f11987d = "PREF_PACKAGE_OPENED_";

    /* renamed from: e */
    public static final String f11988e = "PREF_TOTAL_COINS";

    /* renamed from: f */
    public static final String f11989f = "TOUSHI_STATE";

    /* renamed from: g */
    public static final String f11990g = "PREF_VIP_DEADLINE";

    /* renamed from: h */
    public static final String f11991h = "PREF_FIRST_GRAP";

    /* renamed from: i */
    public static final String f11992i = "PREF_REDPAPER_OPENED_";

    /* renamed from: a */
    public final Context f11993a;

    public interface a {
        void a(AppTaskList appTaskList);

        void onLoading(boolean z10);

        void onResultError(c cVar);
    }

    public interface b {
        void a(AppTask appTask);

        void onLoading(boolean z10);

        void onResultError(c cVar);
    }

    public AppTaskManager(Context context) {
        this.f11993a = context;
    }

    public static boolean A(Context context, String str) {
        return i(context, str) == -1;
    }

    public static boolean C(Context context, AppTask appTask) {
        if (!g.m(context, appTask.packageName)) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f11987d);
        sb2.append(appTask.packageName);
        return j.d(context, sb2.toString(), false);
    }

    public static boolean D(Context context, String str) {
        if (!g.m(context, str)) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f11987d);
        sb2.append(str);
        return j.d(context, sb2.toString(), false);
    }

    public static boolean E(Context context, AlipayRedpaper alipayRedpaper) {
        if (j.h(context, f11986c + alipayRedpaper.getPackageName(), -1L) == -1) {
            return true;
        }
        return w(context, alipayRedpaper.getPackageName(), 120L);
    }

    public static boolean F(Context context, AlipayRedpaper alipayRedpaper) {
        return E(context, alipayRedpaper) && G(context, alipayRedpaper);
    }

    public static boolean G(Context context, AlipayRedpaper alipayRedpaper) {
        if (l(alipayRedpaper) >= 5) {
            return true;
        }
        long h10 = j.h(context, f11992i + alipayRedpaper.getTime(), -1L);
        return h10 != -1 && System.currentTimeMillis() - h10 > 60000;
    }

    public static boolean H(Context context) {
        return j.d(context, f11989f, false);
    }

    public static boolean I(Context context) {
        long h10 = j.h(context, f11990g, -1L);
        if (h10 != -1 || !H(context)) {
            return System.currentTimeMillis() < h10;
        }
        S(context, 92);
        return true;
    }

    public static void J(Context context, AppTask appTask) {
        j.p(context, f11987d + appTask.packageName, true);
    }

    public static void K(Context context, String str) {
        j.p(context, f11987d + str, true);
    }

    public static void L(Context context, String str) {
        j.n(context, f11986c + str, System.currentTimeMillis());
    }

    public static void N(Context context, AppTask appTask) {
        if (TextUtils.isEmpty(appTask.packageName) || A(context, appTask.packageName)) {
            return;
        }
        j.m(context, f11985b + appTask.packageName, appTask.taskCoins);
        L(context, appTask.packageName);
    }

    public static void O(Context context, String str, int i10) {
        if (TextUtils.isEmpty(str) || A(context, str)) {
            return;
        }
        j.m(context, f11985b + str, i10);
        L(context, str);
    }

    public static void Q(Context context) {
        j.p(context, f11991h, false);
    }

    public static void R(Context context, int i10) {
        j.m(context, f11988e, i10);
    }

    public static void S(Context context, int i10) {
        j.n(context, f11990g, System.currentTimeMillis() + (i10 * 86400000));
    }

    public static boolean T(Context context, String str, long j10) {
        if (h(context, str, j10) > 0) {
            return false;
        }
        K(context, str);
        return V(context, str, j10);
    }

    public static boolean U(Context context, AppTask appTask) {
        return V(context, appTask.packageName, appTask.activateSeconds);
    }

    public static boolean V(Context context, String str, long j10) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("package:")) {
            str = str.substring(8);
        }
        if (!w(context, str, j10) || A(context, str)) {
            return false;
        }
        r(context, i(context, str));
        t(context, str);
        return true;
    }

    public static void X(Context context, AlipayRedpaper alipayRedpaper) {
        if (m(context, alipayRedpaper) == -1) {
            j.n(context, f11992i + alipayRedpaper.getTime(), System.currentTimeMillis());
        }
    }

    public static boolean a(Context context, int i10) {
        return o(context) >= i10;
    }

    public static void b(Context context) {
        j.n(context, f11990g, -1L);
        j.p(context, f11989f, false);
    }

    public static boolean d(Context context, int i10) {
        int o10 = o(context);
        if (o10 < i10) {
            return false;
        }
        j.m(context, f11988e, o10 - i10);
        return true;
    }

    public static void e(Context context) {
        j.p(context, f11989f, false);
    }

    public static void f(Context context) {
        j.p(context, f11989f, true);
    }

    public static long g(Context context, AppTask appTask) {
        long h10 = j.h(context, f11986c + appTask.packageName, -1L);
        if (h10 == -1) {
            return appTask.activateSeconds;
        }
        long currentTimeMillis = (appTask.activateSeconds * 1000) - (System.currentTimeMillis() - h10);
        if (currentTimeMillis < 0) {
            return 0L;
        }
        return currentTimeMillis;
    }

    public static long h(Context context, String str, long j10) {
        long h10 = j.h(context, f11986c + str, -1L);
        if (h10 == -1) {
            return j10;
        }
        long currentTimeMillis = (j10 * 1000) - (System.currentTimeMillis() - h10);
        if (currentTimeMillis < 0) {
            return 0L;
        }
        return currentTimeMillis;
    }

    public static int i(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return j.f(context, f11985b + str, 0);
    }

    public static boolean k(Context context) {
        return j.d(context, f11991h, true);
    }

    public static int l(AlipayRedpaper alipayRedpaper) {
        return ConfigSingleton.D().v("ALIPAY_REDPAPER_PACKAGE_" + alipayRedpaper.getPackageName());
    }

    public static long m(Context context, AlipayRedpaper alipayRedpaper) {
        return j.h(context, f11992i + alipayRedpaper.getTime(), -1L);
    }

    public static int o(Context context) {
        return j.f(context, f11988e, 0);
    }

    public static long p(Context context) {
        return j.h(context, f11990g, -1L);
    }

    public static void r(Context context, int i10) {
        j.m(context, f11988e, o(context) + i10);
    }

    public static void s(AlipayRedpaper alipayRedpaper) {
        if (ConfigSingleton.D().E0("FIRST_IN_PROCEED_" + alipayRedpaper.getTime())) {
            ConfigSingleton.D().t0("ALIPAY_REDPAPER_PACKAGE_" + alipayRedpaper.getPackageName());
        }
    }

    public static void t(Context context, String str) {
        j.m(context, f11985b + str, -1);
    }

    public static boolean v(Context context, AppTask appTask) {
        if (!C(context, appTask)) {
            return false;
        }
        long h10 = j.h(context, f11986c + appTask.packageName, -1L);
        return h10 != -1 && System.currentTimeMillis() - h10 > appTask.activateSeconds * 1000;
    }

    public static boolean w(Context context, String str, long j10) {
        if (!D(context, str)) {
            return false;
        }
        long h10 = j.h(context, f11986c + str, -1L);
        return h10 != -1 && System.currentTimeMillis() - h10 > j10 * 1000;
    }

    public static boolean y(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f11985b);
        sb2.append(str);
        return j.f(context, sb2.toString(), -1) != -1;
    }

    public boolean B(String str) {
        return A(this.f11993a, str);
    }

    public void M(String str) {
        L(this.f11993a, str);
    }

    public void P(AppTask appTask) {
        N(this.f11993a, appTask);
    }

    public boolean W(AppTask appTask) {
        return U(this.f11993a, appTask);
    }

    public boolean c(int i10) {
        return d(this.f11993a, i10);
    }

    public int j(String str) {
        return i(this.f11993a, str);
    }

    public int n() {
        return o(this.f11993a);
    }

    public void q(int i10) {
        r(this.f11993a, i10);
    }

    public void u(String str) {
        t(this.f11993a, str);
    }

    public boolean x(AppTask appTask) {
        return v(this.f11993a, appTask);
    }

    public boolean z(String str) {
        return y(this.f11993a, str);
    }
}
