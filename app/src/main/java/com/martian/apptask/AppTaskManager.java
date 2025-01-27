package com.martian.apptask;

import android.content.Context;
import android.text.TextUtils;
import com.martian.apptask.data.AlipayRedpaper;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.apptask.g.g;
import com.martian.libsupport.h;

/* loaded from: classes2.dex */
public class AppTaskManager {

    /* renamed from: a */
    private static final String f9624a = "package_";

    /* renamed from: b */
    private static final String f9625b = "package_time_";

    /* renamed from: c */
    private static final String f9626c = "PREF_PACKAGE_OPENED_";

    /* renamed from: d */
    public static final String f9627d = "PREF_TOTAL_COINS";

    /* renamed from: e */
    public static final String f9628e = "TOUSHI_STATE";

    /* renamed from: f */
    public static final String f9629f = "PREF_VIP_DEADLINE";

    /* renamed from: g */
    public static final String f9630g = "PREF_FIRST_GRAP";

    /* renamed from: h */
    private static final String f9631h = "PREF_REDPAPER_OPENED_";

    /* renamed from: i */
    private final Context f9632i;

    public interface a {
        void a(AppTaskList appTaskList);

        void onLoading(boolean loading);

        void onResultError(b.d.c.b.c errorResult);
    }

    public interface b {
        void a(AppTask appTask);

        void onLoading(boolean loading);

        void onResultError(b.d.c.b.c errorResult);
    }

    public AppTaskManager(Context context) {
        this.f9632i = context;
    }

    public static boolean A(Context context, String packageName) {
        return i(context, packageName) == -1;
    }

    public static boolean C(Context context, AppTask app) {
        if (!g.g(context, app.packageName)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f9626c);
        sb.append(app.packageName);
        return h.d(context, sb.toString(), false);
    }

    public static boolean D(Context context, String packageName) {
        if (!g.g(context, packageName)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f9626c);
        sb.append(packageName);
        return h.d(context, sb.toString(), false);
    }

    public static boolean E(Context context, AlipayRedpaper redpaper) {
        if (h.h(context, f9625b + redpaper.getPackageName(), -1L) == -1) {
            return true;
        }
        return w(context, redpaper.getPackageName(), 120L);
    }

    public static boolean F(Context context, AlipayRedpaper redpaper) {
        return E(context, redpaper) && G(context, redpaper);
    }

    public static boolean G(Context context, AlipayRedpaper redpaper) {
        if (l(redpaper) >= 5) {
            return true;
        }
        long h2 = h.h(context, f9631h + redpaper.getTime(), -1L);
        return h2 != -1 && System.currentTimeMillis() - h2 > 60000;
    }

    public static boolean H(Context context) {
        return h.d(context, f9628e, false);
    }

    public static boolean I(Context context) {
        long h2 = h.h(context, f9629f, -1L);
        if (h2 != -1 || !H(context)) {
            return System.currentTimeMillis() < h2;
        }
        S(context, 92);
        return true;
    }

    public static void J(Context context, AppTask app) {
        h.p(context, f9626c + app.packageName, true);
    }

    public static void K(Context context, String packageName) {
        h.p(context, f9626c + packageName, true);
    }

    public static void L(Context context, String packageName) {
        h.n(context, f9625b + packageName, System.currentTimeMillis());
    }

    public static void N(Context context, AppTask app) {
        if (TextUtils.isEmpty(app.packageName) || A(context, app.packageName)) {
            return;
        }
        h.m(context, f9624a + app.packageName, app.taskCoins);
        L(context, app.packageName);
    }

    public static void O(Context context, String packageName, int coins) {
        if (TextUtils.isEmpty(packageName) || A(context, packageName)) {
            return;
        }
        h.m(context, f9624a + packageName, coins);
        L(context, packageName);
    }

    public static void Q(Context context) {
        h.p(context, f9630g, false);
    }

    public static void R(Context context, int nCoins) {
        h.m(context, f9627d, nCoins);
    }

    public static void S(Context context, int days) {
        h.n(context, f9629f, System.currentTimeMillis() + (days * 24 * 60 * 60 * 1000));
    }

    public static boolean T(Context context, String packageName, long activateSeconds) {
        if (h(context, packageName, activateSeconds) > 0) {
            return false;
        }
        K(context, packageName);
        return V(context, packageName, activateSeconds);
    }

    public static boolean U(Context context, AppTask app) {
        return V(context, app.packageName, app.activateSeconds);
    }

    public static boolean V(Context context, String packageName, long activateSeconds) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        if (packageName.startsWith("package:")) {
            packageName = packageName.substring(8);
        }
        if (!w(context, packageName, activateSeconds) || A(context, packageName)) {
            return false;
        }
        r(context, i(context, packageName));
        t(context, packageName);
        return true;
    }

    public static void X(Context context, AlipayRedpaper redpaper) {
        if (m(context, redpaper) == -1) {
            h.n(context, f9631h + redpaper.getTime(), System.currentTimeMillis());
        }
    }

    public static boolean a(Context context, int nCoins) {
        return o(context) >= nCoins;
    }

    public static void b(Context context) {
        h.n(context, f9629f, -1L);
        h.p(context, f9628e, false);
    }

    public static boolean d(Context context, int nCoins) {
        int o = o(context);
        if (o < nCoins) {
            return false;
        }
        h.m(context, f9627d, o - nCoins);
        return true;
    }

    public static void e(Context context) {
        h.p(context, f9628e, false);
    }

    public static void f(Context context) {
        h.p(context, f9628e, true);
    }

    public static long g(Context context, AppTask app) {
        long h2 = h.h(context, f9625b + app.packageName, -1L);
        if (h2 == -1) {
            return app.activateSeconds;
        }
        long currentTimeMillis = (app.activateSeconds * 1000) - (System.currentTimeMillis() - h2);
        if (currentTimeMillis < 0) {
            return 0L;
        }
        return currentTimeMillis;
    }

    public static long h(Context context, String packageName, long activateSeconds) {
        long h2 = h.h(context, f9625b + packageName, -1L);
        if (h2 == -1) {
            return activateSeconds;
        }
        long currentTimeMillis = (activateSeconds * 1000) - (System.currentTimeMillis() - h2);
        if (currentTimeMillis < 0) {
            return 0L;
        }
        return currentTimeMillis;
    }

    public static int i(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return 0;
        }
        return h.f(context, f9624a + packageName, 0);
    }

    public static boolean k(Context context) {
        return h.d(context, f9630g, true);
    }

    public static int l(AlipayRedpaper redpaper) {
        return com.martian.libmars.d.h.F().q("ALIPAY_REDPAPER_PACKAGE_" + redpaper.getPackageName());
    }

    private static long m(Context context, AlipayRedpaper redpaper) {
        return h.h(context, f9631h + redpaper.getTime(), -1L);
    }

    public static int o(Context context) {
        return h.f(context, f9627d, 0);
    }

    public static long p(Context context) {
        return h.h(context, f9629f, -1L);
    }

    public static void r(Context context, int nCoins) {
        h.m(context, f9627d, o(context) + nCoins);
    }

    public static void s(AlipayRedpaper redpaper) {
        if (com.martian.libmars.d.h.F().L0("FIRST_IN_PROCEED_" + redpaper.getTime())) {
            com.martian.libmars.d.h.F().B0("ALIPAY_REDPAPER_PACKAGE_" + redpaper.getPackageName());
        }
    }

    public static void t(Context context, String packageName) {
        h.m(context, f9624a + packageName, -1);
    }

    public static boolean v(Context context, AppTask app) {
        if (!C(context, app)) {
            return false;
        }
        long h2 = h.h(context, f9625b + app.packageName, -1L);
        return h2 != -1 && System.currentTimeMillis() - h2 > app.activateSeconds * 1000;
    }

    public static boolean w(Context context, String packageName, long activateSeconds) {
        if (!D(context, packageName)) {
            return false;
        }
        long h2 = h.h(context, f9625b + packageName, -1L);
        return h2 != -1 && System.currentTimeMillis() - h2 > activateSeconds * 1000;
    }

    public static boolean y(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f9624a);
        sb.append(packageName);
        return h.f(context, sb.toString(), -1) != -1;
    }

    public boolean B(String packageName) {
        return A(this.f9632i, packageName);
    }

    public void M(String packageName) {
        L(this.f9632i, packageName);
    }

    public void P(AppTask app) {
        N(this.f9632i, app);
    }

    public boolean W(AppTask app) {
        return U(this.f9632i, app);
    }

    public boolean c(int nCoins) {
        return d(this.f9632i, nCoins);
    }

    public int j(String packageName) {
        return i(this.f9632i, packageName);
    }

    public int n() {
        return o(this.f9632i);
    }

    public void q(int nCoins) {
        r(this.f9632i, nCoins);
    }

    public void u(String packageName) {
        t(this.f9632i, packageName);
    }

    public boolean x(AppTask app) {
        return v(this.f9632i, app);
    }

    public boolean z(String packageName) {
        return y(this.f9632i, packageName);
    }
}
