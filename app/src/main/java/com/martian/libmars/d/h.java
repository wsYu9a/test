package com.martian.libmars.d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.multidex.MultiDexApplication;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.libmars.R;
import com.martian.libmars.utils.k0;
import com.martian.libmars.utils.o0;
import com.martian.libmars.utils.q0;
import com.martian.libsupport.l;
import com.martian.mibook.application.MiConfigSingleton;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class h extends MultiDexApplication {
    public static final int A = 6;
    public static final int B = 7;
    public static final int C = 2;
    public static final int D = 1;
    public static final int E = 0;
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 3;
    public static final int I = 99;
    public static final String J = "run_times";
    public static final String K = "run_times_today";
    public static final String L = "last_runtime";
    private static final String M = "_PREF_CLICK_TIME_";
    private static final String N = "counter_";
    private static final String O = "PREF_LOGIN_BONUS";
    private static final String P = "PREF_MESSAGE_LAST_NID";
    private static final String Q = "PREF_MESSAGE_LATEST_NID";
    private static final String R = "pref_reading_mode";
    private static final String S = "pref_night_mode";
    public static final String T = "pref_traditional_chinese";
    public static final String U = "pref_base_function_mode";

    /* renamed from: a */
    public static final String f9882a = "PRIVACY_ENABLE";

    /* renamed from: c */
    public static final String f9884c = "pref_ttbook_channel_meta_data";

    /* renamed from: d */
    public static final String f9885d = "pref_develop_environment_mode";

    /* renamed from: e */
    public static final int f9886e = 0;

    /* renamed from: f */
    public static final int f9887f = 1;

    /* renamed from: g */
    public static final int f9888g = 2;

    /* renamed from: h */
    public static final String f9889h = "pref_push_channel";

    /* renamed from: i */
    public static final String f9890i = "pref_push_regid";

    /* renamed from: j */
    public static final String f9891j = "pref_imei";
    public static final String k = "pref_open_udid";
    public static final String l = "pref_mac_address";
    public static final String m = "pref_ip_address";
    public static final String n = "pref_iccid";
    public static final String o = "pref_imsi";
    public static final String p = "pref_android_id";
    public static final String q = "pref_optype";
    public static h s = null;
    private static final String t = "PREFERENCE_UNIQUE_OAID";
    public static final int w = 0;
    public static final int x = 3;
    public static final int y = 4;
    public static final int z = 5;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    private String a0;
    private String b0;
    private String c0;
    protected Typeface e0;
    private boolean k0;
    private boolean q0;
    private Boolean r0;

    /* renamed from: b */
    public static final String f9883b = Environment.getExternalStorageDirectory() + "/";
    public static String r = "TestDev";
    private static int u = 0;
    public static String[] v = {"appid", "PACKAGE_NAME", "VERSION_NAME", "IMEI", "DEVICE_MODEL", "DEVICE_VENDOR", "OPERATOR_TYPE", "CONNECT_TYPE", "SYSTEM_VERSION", "SYSTEM_TYPE", "SCREEN_HEIGHT", "SCREEN_WIDTH", "CHANNEL", "OAID"};
    private int d0 = -1;
    private String f0 = "";
    private int g0 = -1;
    private String h0 = null;
    private int i0 = -1;
    private int j0 = -1;
    public long l0 = System.currentTimeMillis();
    public final Comparator<UsageStats> m0 = new Comparator() { // from class: com.martian.libmars.d.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return h.X0((UsageStats) obj, (UsageStats) obj2);
        }
    };
    private int n0 = -1;
    private int o0 = -1;
    private final Set<g.a> p0 = new HashSet();

    public interface a {
        void a();

        void b();
    }

    private String C0(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    private void E1() {
        long h2 = com.martian.libsupport.h.h(this, L, -1L);
        if (h2 <= 0 || !R0(h2)) {
            this.j0 = 1;
        } else {
            this.j0 = h0() + 1;
        }
        com.martian.libsupport.h.n(this, L, System.currentTimeMillis());
        com.martian.libsupport.h.m(this, K, this.j0);
    }

    public static h F() {
        return s;
    }

    private String L() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "0.0.0.0";
        } catch (SocketException e2) {
            e2.printStackTrace();
            return "0.0.0.0";
        }
    }

    /* renamed from: V0 */
    public /* synthetic */ void W0(String s2) {
        this.h0 = s2;
        z1(this, s2);
    }

    static /* synthetic */ int X0(UsageStats lhs, UsageStats rhs) {
        if (l.r()) {
            return (lhs.getLastTimeUsed() > rhs.getLastTimeUsed() ? 1 : (lhs.getLastTimeUsed() == rhs.getLastTimeUsed() ? 0 : -1));
        }
        return 0;
    }

    /* renamed from: Y0 */
    public /* synthetic */ void Z0(final a listener) {
        if (listener != null) {
            listener.b();
        }
        this.q0 = false;
    }

    /* renamed from: a1 */
    public /* synthetic */ void b1(final a listener) {
        if (listener != null) {
            listener.a();
        }
        this.q0 = false;
    }

    public static int b(float dipValue) {
        return (int) ((dipValue * F().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static String c0(Context context) {
        return com.martian.libsupport.h.j(context, t);
    }

    /* renamed from: c1 */
    public /* synthetic */ void d1(final a listener) {
        if (listener != null) {
            listener.b();
        }
        this.q0 = false;
    }

    /* renamed from: e1 */
    public /* synthetic */ void f1(final Activity activity, final a listener) {
        k0.Q(activity, "取消登录", "未登录将导致VIP、金币、阅读进度等信息丢失，确认取消登录吗？", "确认取消", "重新登录", true, new k0.l() { // from class: com.martian.libmars.d.a
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                h.this.Z0(listener);
            }
        }, new k0.j() { // from class: com.martian.libmars.d.f
            @Override // com.martian.libmars.utils.k0.j
            public final void a() {
                h.this.b1(listener);
            }
        });
    }

    public static int i1(float pxValue) {
        return (int) ((pxValue / F().getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int s() {
        if (this.g0 < 0) {
            if ("Beta".equalsIgnoreCase(m())) {
                this.g0 = 1;
            } else {
                this.g0 = Z(f9885d, (getApplicationInfo().flags & 2) == 0 ? 0 : 2);
            }
        }
        return this.g0;
    }

    private static void z1(Context context, String oaid) {
        if (com.martian.libsupport.k.p(oaid)) {
            return;
        }
        com.martian.libsupport.h.o(context, t, oaid);
    }

    @SuppressLint({"HardwareIds"})
    public String A() {
        if (this.a0 == null) {
            String j2 = com.martian.libsupport.h.j(this, o);
            this.a0 = j2;
            if (j2 == null) {
                try {
                    this.a0 = ((TelephonyManager) getSystemService("phone")).getSubscriberId();
                } catch (SecurityException e2) {
                    e2.printStackTrace();
                }
                if (this.a0 == null) {
                    this.a0 = "";
                }
                com.martian.libsupport.h.o(this, o, this.a0);
            }
        }
        return this.a0;
    }

    public int A0() {
        int g0 = g0() + 1;
        this.i0 = g0;
        com.martian.libsupport.h.m(this, J, g0);
        E1();
        return this.i0;
    }

    public void A1(boolean isTrad) {
        this.r0 = Boolean.valueOf(isTrad);
        com.martian.libsupport.h.p(this, T, isTrad);
    }

    @SuppressLint({"HardwareIds"})
    public String B() {
        if (this.Z == null) {
            String j2 = com.martian.libsupport.h.j(this, n);
            this.Z = j2;
            if (j2 == null) {
                if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c)) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
                        if (telephonyManager != null) {
                            this.Z = telephonyManager.getSimSerialNumber();
                        }
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.Z == null) {
                    this.Z = "";
                }
                com.martian.libsupport.h.o(this, n, this.Z);
            }
        }
        return this.Z;
    }

    public int B0(String counterName) {
        int q2 = q(counterName) + 1;
        com.martian.libsupport.h.m(getApplicationContext(), N + counterName, q2);
        return q2;
    }

    public void B1(Typeface typeface) {
        this.e0 = typeface;
    }

    public int C() {
        return I0() ? R.drawable.icon_placeholder_night : R.drawable.icon_placeholder_day;
    }

    public void C1(final Activity activity, final a listener) {
        if (this.q0) {
            return;
        }
        this.q0 = true;
        k0.Q(activity, "登录已过期", "是否重新登录？", "取消", "重新登录", false, new k0.l() { // from class: com.martian.libmars.d.e
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                h.this.d1(listener);
            }
        }, new k0.j() { // from class: com.martian.libmars.d.d
            @Override // com.martian.libmars.utils.k0.j
            public final void a() {
                h.this.f1(activity, listener);
            }
        });
    }

    public o0 D() {
        return null;
    }

    public boolean D0(String prefname) {
        boolean d2 = com.martian.libsupport.h.d(this, prefname, false);
        com.martian.libsupport.h.p(this, prefname, true);
        return d2;
    }

    public void D1(Activity activity) {
        View findViewById;
        if (activity == null || (findViewById = activity.findViewById(activity.hashCode())) == null) {
            return;
        }
        if (P0()) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
    }

    public String E() {
        return com.martian.libsupport.k.r(z());
    }

    public boolean E0() {
        return this.k0;
    }

    public boolean F0() {
        return com.martian.libsupport.h.d(this, U, false);
    }

    public void F1() {
        for (g.a aVar : this.p0) {
            if (aVar != null) {
                aVar.g();
            }
        }
    }

    public String G() {
        if (U0()) {
            try {
                WifiInfo connectionInfo = ((WifiManager) getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo();
                if (connectionInfo != null) {
                    this.Y = C0(connectionInfo.getIpAddress());
                }
            } catch (SecurityException e2) {
                e2.printStackTrace();
            }
        } else {
            this.Y = L();
        }
        return this.Y;
    }

    public boolean G0() {
        return s() == 1;
    }

    public boolean H(String prefname) {
        return com.martian.libsupport.h.d(this, prefname, false);
    }

    public boolean H0(String type) {
        long h2 = com.martian.libsupport.h.h(this, getPackageName() + M + type, -1L);
        return h2 != -1 && R0(h2);
    }

    public boolean I(String prefname) {
        return com.martian.libsupport.h.d(this, prefname, true);
    }

    public boolean I0() {
        if (this.n0 == -1) {
            this.n0 = com.martian.libsupport.h.f(this, R, 0);
        }
        return this.n0 == 1 || P0();
    }

    public int J() {
        return com.martian.libsupport.h.f(this, P, 0);
    }

    public boolean J0() {
        return Q0() || G0();
    }

    public int K() {
        return com.martian.libsupport.h.f(this, Q, 0);
    }

    public boolean K0(Activity activity) {
        String name = activity.getClass().getName();
        boolean d2 = com.martian.libsupport.h.d(this, name, true);
        com.martian.libsupport.h.p(this, name, false);
        return d2;
    }

    public boolean L0(String prefname) {
        boolean d2 = com.martian.libsupport.h.d(this, prefname, true);
        com.martian.libsupport.h.p(this, prefname, false);
        return d2;
    }

    public int M() {
        return com.martian.libsupport.h.f(this, O, 0);
    }

    public boolean M0() {
        return g0() > 1 && h0() == 1;
    }

    public String N() {
        return Q0() ? "http://testm.taoyuewenhua.com/logoff_request" : "http://m.taoyuewenhua.com/logoff_request";
    }

    public boolean N0() {
        return getPackageName().equals(r());
    }

    public String O() {
        if (this.X == null) {
            String j2 = com.martian.libsupport.h.j(this, l);
            this.X = j2;
            if (j2 == null) {
                if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c)) {
                    try {
                        this.X = l.e(this);
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.X == null) {
                    this.X = "";
                }
                com.martian.libsupport.h.o(this, l, this.X);
            }
        }
        return this.X;
    }

    public boolean O0() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.isConnected()) {
                    return false;
                }
            }
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public String P() {
        StringBuilder sb = new StringBuilder();
        sb.append(Q());
        String str = File.separator;
        sb.append(str);
        sb.append(MiConfigSingleton.t0);
        sb.append(str);
        return sb.toString();
    }

    public boolean P0() {
        if (this.o0 == -1) {
            this.o0 = com.martian.libsupport.h.f(this, S, 0);
        }
        return this.o0 == 1;
    }

    public String Q() {
        return "martian";
    }

    public boolean Q0() {
        return s() == 2;
    }

    protected String R() {
        try {
            Bundle bundle = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
            return bundle != null ? bundle.getString("UMENG_CHANNEL") : "";
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        } catch (NullPointerException e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public boolean R0(long timeStamp) {
        return S0(timeStamp, false);
    }

    public String S() {
        return Build.MODEL;
    }

    public boolean S0(long timeStamp, boolean isLocal) {
        Calendar calendar;
        Calendar calendar2;
        if (isLocal) {
            calendar = Calendar.getInstance();
            calendar2 = Calendar.getInstance();
        } else {
            calendar = Calendar.getInstance(Locale.CHINA);
            calendar2 = Calendar.getInstance(Locale.CHINA);
        }
        calendar2.setTimeInMillis(timeStamp);
        return calendar2.get(1) == calendar.get(1) && calendar.get(6) - calendar2.get(6) == 0;
    }

    public int T() {
        return P0() ? R.color.night_background_navigationbar : I0() ? R.color.night_background_card : R.color.white;
    }

    public boolean T0() {
        if (this.r0 == null) {
            this.r0 = Boolean.valueOf(com.martian.libsupport.h.d(this, T, l.K()));
        }
        return this.r0.booleanValue();
    }

    public String U() {
        int p2 = p();
        return p2 != 2 ? p2 != 4 ? p2 != 5 ? p2 != 6 ? p2 != 7 ? "evdo" : "5G" : "lte" : "edge" : "gprs" : com.alipay.mobilesecuritysdk.constant.a.I;
    }

    public boolean U0() {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                return networkInfo.isConnected();
            }
            return false;
        } catch (SecurityException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public String V() {
        if (!com.martian.libsupport.k.p(this.h0)) {
            return this.h0;
        }
        String c0 = c0(this);
        this.h0 = c0;
        if (!com.martian.libsupport.k.p(c0)) {
            return this.h0;
        }
        int i2 = u;
        u = i2 + 1;
        if (i2 > 3) {
            return this.h0;
        }
        try {
            UMConfigure.getOaid(this, new OnGetOaidListener() { // from class: com.martian.libmars.d.b
                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public final void onGetOaid(String str) {
                    h.this.W0(str);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return this.h0;
    }

    @SuppressLint({"HardwareIds"})
    public String W() {
        if (this.b0 == null) {
            String j2 = com.martian.libsupport.h.j(this, k);
            this.b0 = j2;
            if (j2 == null) {
                if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c)) {
                    try {
                        this.b0 = Settings.Secure.getString(getContentResolver(), "android_id");
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.b0 == null) {
                    this.b0 = "";
                }
                com.martian.libsupport.h.o(this, k, this.b0);
            }
        }
        return this.b0;
    }

    public int X() {
        if (this.d0 < 0) {
            int f2 = com.martian.libsupport.h.f(this, q, -1);
            this.d0 = f2;
            if (f2 < 0) {
                if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c)) {
                    try {
                        String subscriberId = ((TelephonyManager) getSystemService("phone")).getSubscriberId();
                        if (!TextUtils.isEmpty(subscriberId)) {
                            if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002")) {
                                if (subscriberId.startsWith("46001")) {
                                    this.d0 = 3;
                                } else if (subscriberId.startsWith("46003")) {
                                    this.d0 = 2;
                                } else {
                                    this.d0 = 99;
                                }
                            }
                            this.d0 = 1;
                        }
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.d0 < 0) {
                    this.d0 = 0;
                }
                com.martian.libsupport.h.m(this, q, this.d0);
            }
        }
        return this.d0;
    }

    public boolean Y(String prefType, boolean defaultValue) {
        return com.martian.libsupport.h.d(this, prefType, defaultValue);
    }

    public int Z(String prefType, int defaultValue) {
        return com.martian.libsupport.h.f(this, prefType, defaultValue);
    }

    public void a(g.a listener) {
        this.p0.add(listener);
    }

    public long a0(String prefName) {
        return com.martian.libsupport.h.h(this, prefName, -1L);
    }

    public String b0(String prefName) {
        return com.martian.libsupport.h.j(this, prefName);
    }

    @SuppressLint({"HardwareIds"})
    public String c() {
        if (this.c0 == null) {
            String j2 = com.martian.libsupport.h.j(this, p);
            this.c0 = j2;
            if (j2 == null) {
                try {
                    this.c0 = "" + Settings.Secure.getString(getContentResolver(), "android_id");
                } catch (SecurityException e2) {
                    e2.printStackTrace();
                }
                if (this.c0 == null) {
                    this.c0 = "";
                }
                com.martian.libsupport.h.o(this, p, this.c0);
            }
        }
        return this.c0;
    }

    public String d() {
        return com.martian.libsupport.k.r(c());
    }

    public String d0() {
        if (!com.martian.libsupport.k.p(this.V)) {
            return this.V;
        }
        try {
            this.V = com.martian.libsupport.b.e(getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException unused) {
            q0.h(this, "Failed to fetch package sign.");
        }
        return this.V;
    }

    public String e() {
        return Build.VERSION.RELEASE;
    }

    public abstract i e0();

    public abstract g f();

    public abstract String f0();

    public int g() {
        return I0() ? ContextCompat.getColor(this, R.color.night_background) : ContextCompat.getColor(this, R.color.white);
    }

    public int g0() {
        if (this.i0 == -1) {
            this.i0 = com.martian.libsupport.h.f(this, J, 0);
        }
        return this.i0;
    }

    public boolean g1(String type, int interval) {
        long time = new Date().getTime() - com.martian.libsupport.h.h(getApplicationContext(), type, -1L);
        long j2 = interval;
        if (time > j2) {
            com.martian.libsupport.h.n(getApplicationContext(), type, new Date().getTime());
        }
        return time >= j2;
    }

    public int h() {
        return I0() ? R.drawable.border_background_unclickable_night : R.drawable.border_background_unclickable_day;
    }

    public int h0() {
        if (this.j0 == -1) {
            this.j0 = com.martian.libsupport.h.f(this, K, 0);
        }
        return this.j0;
    }

    public boolean h1() {
        return H(f9882a);
    }

    public int i() {
        return I0() ? R.drawable.image_loading_default_horizontal_night : R.drawable.image_loading_default_horizontal;
    }

    public int i0() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public String j() {
        return Build.BRAND;
    }

    public int j0() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public void j1(g.a listener) {
        this.p0.remove(listener);
    }

    public int k() {
        return 1;
    }

    public int k0() {
        return I0() ? R.drawable.theme_seekbar_progress_drawable_night : R.drawable.theme_seekbar_progress_drawable;
    }

    public void k1(String counterName) {
        com.martian.libsupport.h.m(getApplicationContext(), N + counterName, 0);
    }

    public String l() {
        return Q0() ? "http://testm.taoyuewenhua.com/logoff_cancel" : "http://m.taoyuewenhua.com/logoff_cancel";
    }

    public int l0() {
        return I0() ? R.drawable.theme_seek_bar_thumb_night : R.drawable.theme_seek_bar_thumb;
    }

    protected void l1(boolean visible) {
        this.k0 = visible;
        if (visible) {
            return;
        }
        this.l0 = System.currentTimeMillis();
    }

    public String m() {
        if (!com.martian.libsupport.k.p(this.f0)) {
            return this.f0;
        }
        String b0 = b0(f9884c);
        this.f0 = b0;
        if (!com.martian.libsupport.k.p(b0)) {
            return this.f0;
        }
        String f0 = f0();
        this.f0 = f0;
        if (!com.martian.libsupport.k.p(f0)) {
            m1(this.f0);
        }
        return this.f0;
    }

    public int m0() {
        return I0() ? R.drawable.selector_default_night : R.drawable.selector_default_day;
    }

    public void m1(String newChannel) {
        this.f0 = newChannel;
        y1(f9884c, newChannel);
    }

    public String n(String text) {
        return T0() ? com.martian.libcomm.utils.d.b(text) : text;
    }

    public String n0(String text) {
        return T0() ? com.martian.libcomm.utils.d.a(text) : text;
    }

    public void n1(String type) {
        if (com.martian.libsupport.k.p(type)) {
            return;
        }
        com.martian.libsupport.h.n(this, getPackageName() + M + type, System.currentTimeMillis());
    }

    public int o(String clickType) {
        return com.martian.libsupport.h.f(getApplicationContext(), clickType, 0);
    }

    public String o0(String key) {
        if (key.equals("appid")) {
            return f().f9879a;
        }
        if (key.equals("PACKAGE_NAME")) {
            return getPackageName();
        }
        if (key.equals("VERSION_NAME")) {
            return x0();
        }
        if (key.equals("IMEI")) {
            return z();
        }
        if (key.equals("OAID")) {
            return V();
        }
        if (key.equals("DEVICE_MODEL")) {
            return Build.MODEL;
        }
        if (key.equals("DEVICE_VENDOR")) {
            return Build.BRAND;
        }
        if (key.equals("OPERATOR_TYPE")) {
            return X() + "";
        }
        if (key.equals("CONNECT_TYPE")) {
            return p() + "";
        }
        if (key.equals("ANDROID_ID")) {
            return c();
        }
        if (key.equals("SYSTEM_VERSION")) {
            return e();
        }
        if (key.equals("SYSTEM_TYPE")) {
            return "1";
        }
        if (key.equals("IMSI")) {
            return A();
        }
        if (key.equals("SCREEN_WIDTH")) {
            return j0() + "";
        }
        if (!key.equals("SCREEN_HEIGHT")) {
            return key.equals("MAC") ? O() : key.equals("OPENUDID") ? W() : key.equals("CHANNEL") ? m() : key.equalsIgnoreCase(am.aa) ? B() : "";
        }
        return i0() + "";
    }

    public void o1(boolean z2) {
        this.n0 = z2 ? 1 : 0;
        com.martian.libsupport.h.m(this, R, z2 ? 1 : 0);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        s = this;
        b.d.c.a.a.c().e(getApplicationContext());
    }

    public int p() {
        if (U0()) {
            return 2;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo == null) {
            return 0;
        }
        int subtype = networkInfo.getSubtype();
        if (subtype != 10) {
            if (subtype == 11) {
                return 4;
            }
            if (subtype != 14) {
                switch (subtype) {
                    case 0:
                        return 3;
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                        return 4;
                    case 3:
                    case 5:
                    case 6:
                        break;
                    default:
                        if (networkInfo.getSubtype() == 13) {
                            return 6;
                        }
                        return (networkInfo.getSubtype() == 12 || networkInfo.getSubtype() == 15) ? 5 : 3;
                }
            }
        }
        return 5;
    }

    public int p0() {
        return I0() ? ContextCompat.getColor(this, R.color.night_text_color_primary) : ContextCompat.getColor(this, R.color.day_text_color_primary);
    }

    public void p1(int mode) {
        this.g0 = mode;
        w1(f9885d, mode);
    }

    public int q(String counterName) {
        return com.martian.libsupport.h.f(getApplicationContext(), N + counterName, 0);
    }

    public int q0() {
        return I0() ? ContextCompat.getColor(this, R.color.night_text_color_secondary) : ContextCompat.getColor(this, R.color.day_text_color_secondary);
    }

    public void q1(int nid) {
        if (nid > J()) {
            com.martian.libsupport.h.m(this, P, nid);
        }
    }

    protected String r() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            return readLine;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    public int r0() {
        return I0() ? ContextCompat.getColor(this, R.color.night_text_color_thirdly) : ContextCompat.getColor(this, R.color.day_text_color_thirdly);
    }

    public void r1(int nid) {
        com.martian.libsupport.h.m(this, Q, nid);
    }

    public int s0() {
        return I0() ? ContextCompat.getColor(this, R.color.night_text_color_unclickable) : ContextCompat.getColor(this, R.color.day_text_color_unclickable);
    }

    public void s1(int bonus) {
        com.martian.libsupport.h.m(this, O, bonus);
    }

    public String t() {
        return l.c(this);
    }

    public abstract int t0();

    public void t1(boolean z2) {
        this.o0 = z2 ? 1 : 0;
        com.martian.libsupport.h.m(this, S, z2 ? 1 : 0);
    }

    public String u() {
        StringBuilder sb = new StringBuilder();
        sb.append(v());
        String str = File.separator;
        sb.append(str);
        sb.append(MiConfigSingleton.t0);
        sb.append(str);
        return sb.toString();
    }

    public String u0() {
        if (!l.s()) {
            return ((ActivityManager) getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1).get(0).topActivity.getPackageName();
        }
        UsageStatsManager usageStatsManager = (UsageStatsManager) getApplicationContext().getSystemService("usagestats");
        if (usageStatsManager != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Calendar calendar = Calendar.getInstance();
            calendar.set(5, calendar.get(5) - 1);
            List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, calendar.getTimeInMillis(), currentTimeMillis);
            if (queryUsageStats != null && !queryUsageStats.isEmpty()) {
                Collections.sort(queryUsageStats, this.m0);
                return queryUsageStats.get(queryUsageStats.size() - 1).getPackageName();
            }
        }
        return "";
    }

    public void u1(boolean baseFunctionMode) {
        com.martian.libsupport.h.p(this, U, baseFunctionMode);
        if (baseFunctionMode) {
            v1(f9882a, false);
        }
    }

    public String v() {
        return y() + File.separator + "martian";
    }

    public Typeface v0() {
        return this.e0;
    }

    public void v1(String prefType, boolean pref) {
        com.martian.libsupport.h.p(this, prefType, pref);
    }

    public String w() {
        StringBuilder sb = new StringBuilder();
        sb.append(v());
        String str = File.separator;
        sb.append(str);
        sb.append("images");
        sb.append(str);
        return sb.toString();
    }

    public int w0() {
        Context applicationContext = getApplicationContext();
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public void w1(String prefType, int pref) {
        com.martian.libsupport.h.m(this, prefType, pref);
    }

    public String x() {
        StringBuilder sb = new StringBuilder();
        sb.append(v());
        String str = File.separator;
        sb.append(str);
        sb.append("video");
        sb.append(str);
        return sb.toString();
    }

    public String x0() {
        Context applicationContext = getApplicationContext();
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "Unknown";
        }
    }

    public void x1(String prefName, long value) {
        com.martian.libsupport.h.n(this, prefName, value);
    }

    public String y() {
        return Environment.getExternalStorageDirectory() + "";
    }

    public abstract com.maritan.libweixin.g y0();

    public void y1(String prefName, String name) {
        com.martian.libsupport.h.o(this, prefName, name);
    }

    @SuppressLint({"HardwareIds"})
    public String z() {
        if (this.W == null) {
            String j2 = com.martian.libsupport.h.j(this, f9891j);
            this.W = j2;
            if (j2 == null) {
                if (com.martian.libsupport.permission.g.d(this, com.kuaishou.weapon.p0.g.f9318c)) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
                        if (telephonyManager != null) {
                            if (!l.t()) {
                                this.W = telephonyManager.getDeviceId();
                            } else if (l.D()) {
                                this.W = "";
                            } else if (l.A()) {
                                if (telephonyManager.getPhoneCount() == 2) {
                                    this.W = telephonyManager.getImei(0);
                                } else {
                                    this.W = telephonyManager.getImei();
                                }
                            } else if (telephonyManager.getPhoneCount() == 2) {
                                this.W = telephonyManager.getDeviceId(0);
                            } else {
                                this.W = telephonyManager.getDeviceId();
                            }
                        }
                    } catch (SecurityException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.W == null) {
                    this.W = "";
                }
                com.martian.libsupport.h.o(this, f9891j, this.W);
            }
        }
        return this.W;
    }

    public int z0(String clickType) {
        int o2 = o(clickType) + 1;
        com.martian.libsupport.h.m(getApplicationContext(), clickType, o2);
        return o2;
    }
}
