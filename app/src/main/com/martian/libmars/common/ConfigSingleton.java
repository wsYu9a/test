package com.martian.libmars.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.core.content.ContextCompat;
import androidx.multidex.MultiDexApplication;
import ba.d;
import ba.j;
import ba.l;
import ba.m;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.g;
import com.martian.libcomm.utils.ChineseConverter;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import ea.c;
import g9.i;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import l9.i0;
import l9.p0;

/* loaded from: classes3.dex */
public abstract class ConfigSingleton extends MultiDexApplication {
    public static final String B = "pref_ttbook_channel_meta_data";
    public static final String C = "pref_develop_environment_mode";
    public static final int D = 0;
    public static final int E = 1;
    public static final int F = 2;
    public static final int G = 3;
    public static final String H = "pref_push_channel";
    public static final String I = "pref_push_regid";
    public static final String J = "pref_imei";
    public static final String K = "pref_open_udid";
    public static final String L = "pref_mac_address";
    public static final String M = "pref_iccid";
    public static final String N = "pref_imsi";
    public static final String O = "pref_android_id";
    public static final String P = "pref_optype";
    public static final String Q = "pref_partitioned_storage";
    public static ConfigSingleton R = null;
    public static final String S = "PREFERENCE_UNIQUE_OAID";
    public static final int V = 0;
    public static final int W = 3;
    public static final int X = 4;
    public static final int Y = 5;
    public static final int Z = 6;

    /* renamed from: a0 */
    public static final int f12081a0 = 7;

    /* renamed from: b0 */
    public static final int f12082b0 = 2;

    /* renamed from: c0 */
    public static final int f12083c0 = 0;

    /* renamed from: d0 */
    public static final int f12084d0 = 1;

    /* renamed from: e0 */
    public static final int f12085e0 = 2;

    /* renamed from: f0 */
    public static final int f12086f0 = 3;

    /* renamed from: g0 */
    public static final int f12087g0 = 99;

    /* renamed from: h0 */
    public static final String f12088h0 = "run_times";

    /* renamed from: i0 */
    public static final String f12089i0 = "run_times_today";

    /* renamed from: j0 */
    public static final String f12090j0 = "last_runtime";

    /* renamed from: k0 */
    public static final String f12091k0 = "counter_";

    /* renamed from: l0 */
    public static final String f12092l0 = "pref_reading_mode_new";

    /* renamed from: m0 */
    public static final String f12093m0 = "pref_night_mode_new";

    /* renamed from: n0 */
    public static final String f12094n0 = "pref_traditional_chinese";

    /* renamed from: o0 */
    public static final String f12095o0 = "pref_base_function_mode";

    /* renamed from: z */
    public static final String f12096z = "PRIVACY_ENABLE";

    /* renamed from: b */
    public String f12097b;

    /* renamed from: c */
    public String f12098c;

    /* renamed from: d */
    public String f12099d;

    /* renamed from: e */
    public String f12100e;

    /* renamed from: f */
    public String f12101f;

    /* renamed from: g */
    public String f12102g;

    /* renamed from: h */
    public String f12103h;

    /* renamed from: i */
    public String f12104i;

    /* renamed from: k */
    public Typeface f12106k;

    /* renamed from: q */
    public Boolean f12112q;

    /* renamed from: r */
    public boolean f12113r;

    /* renamed from: u */
    public Boolean f12116u;

    /* renamed from: v */
    public Boolean f12117v;

    /* renamed from: x */
    public boolean f12119x;

    /* renamed from: y */
    public Boolean f12120y;
    public static final String A = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/";
    public static int T = 0;
    public static String[] U = {"appid", "PACKAGE_NAME", "VERSION_NAME", "IMEI", "DEVICE_MODEL", "DEVICE_VENDOR", "OPERATOR_TYPE", "CONNECT_TYPE", "SYSTEM_VERSION", "SYSTEM_TYPE", "SCREEN_HEIGHT", "SCREEN_WIDTH", "CHANNEL", "OAID"};

    /* renamed from: j */
    public int f12105j = -1;

    /* renamed from: l */
    public String f12107l = "";

    /* renamed from: m */
    public int f12108m = -1;

    /* renamed from: n */
    public String f12109n = null;

    /* renamed from: o */
    public int f12110o = -1;

    /* renamed from: p */
    public int f12111p = -1;

    /* renamed from: s */
    public long f12114s = System.currentTimeMillis();

    /* renamed from: t */
    public final Comparator<UsageStats> f12115t = new Comparator() { // from class: g9.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int P0;
            P0 = ConfigSingleton.P0((UsageStats) obj, (UsageStats) obj2);
            return P0;
        }
    };

    /* renamed from: w */
    public final Set<k9.a> f12118w = new HashSet();

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a();
    }

    public static ConfigSingleton D() {
        return R;
    }

    public static /* synthetic */ int P0(UsageStats usageStats, UsageStats usageStats2) {
        return Long.compare(usageStats.getLastTimeUsed(), usageStats2.getLastTimeUsed());
    }

    public static String U(Context context) {
        return j.j(context, S);
    }

    public static int W0(float f10) {
        return (int) ((f10 / D().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int i(float f10) {
        return (int) ((f10 * D().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void k1(Context context, String str) {
        if (l.q(str)) {
            return;
        }
        j.o(context, S, str);
    }

    public static int o1(int i10) {
        return (int) ((i10 * D().getResources().getDisplayMetrics().scaledDensity) + 0.5d);
    }

    @SuppressLint({"HardwareIds"})
    public String A() {
        int phoneCount;
        String deviceId;
        int phoneCount2;
        String imei;
        String imei2;
        if (this.f12098c == null) {
            String j10 = j.j(this, J);
            this.f12098c = j10;
            if (j10 == null) {
                if (c.d(this, g.f11102c)) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
                        if (telephonyManager != null) {
                            if (!m.n()) {
                                this.f12098c = telephonyManager.getDeviceId();
                            } else if (m.x()) {
                                this.f12098c = "";
                            } else if (m.u()) {
                                phoneCount2 = telephonyManager.getPhoneCount();
                                if (phoneCount2 == 2) {
                                    imei2 = telephonyManager.getImei(0);
                                    this.f12098c = imei2;
                                } else {
                                    imei = telephonyManager.getImei();
                                    this.f12098c = imei;
                                }
                            } else {
                                phoneCount = telephonyManager.getPhoneCount();
                                if (phoneCount == 2) {
                                    deviceId = telephonyManager.getDeviceId(0);
                                    this.f12098c = deviceId;
                                } else {
                                    this.f12098c = telephonyManager.getDeviceId();
                                }
                            }
                        }
                    } catch (SecurityException e10) {
                        p0.b(e10.getMessage());
                    }
                }
                if (this.f12098c == null) {
                    this.f12098c = "";
                }
                j.o(this, J, this.f12098c);
            }
        }
        return this.f12098c;
    }

    public boolean A0() {
        if (this.f12116u == null) {
            this.f12116u = Boolean.valueOf(j.d(this, f12092l0, false));
        }
        return this.f12116u.booleanValue() || H0();
    }

    @SuppressLint({"HardwareIds"})
    public String B() {
        if (this.f12102g == null) {
            String j10 = j.j(this, N);
            this.f12102g = j10;
            if (j10 == null) {
                try {
                    this.f12102g = ((TelephonyManager) getSystemService("phone")).getSubscriberId();
                } catch (SecurityException e10) {
                    p0.b(e10.getMessage());
                }
                if (this.f12102g == null) {
                    this.f12102g = "";
                }
                j.o(this, N, this.f12102g);
            }
        }
        return this.f12102g;
    }

    public boolean B0() {
        return x() != 0;
    }

    @SuppressLint({"HardwareIds"})
    public String C() {
        if (this.f12101f == null) {
            String j10 = j.j(this, M);
            this.f12101f = j10;
            if (j10 == null) {
                if (c.d(this, g.f11102c)) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) getSystemService("phone");
                        if (telephonyManager != null) {
                            this.f12101f = telephonyManager.getSimSerialNumber();
                        }
                    } catch (SecurityException e10) {
                        p0.b(e10.getMessage());
                    }
                }
                if (this.f12101f == null) {
                    this.f12101f = "";
                }
                j.o(this, M, this.f12101f);
            }
        }
        return this.f12101f;
    }

    public boolean C0(int i10) {
        if (i10 <= 0) {
            return false;
        }
        return i10 >= 100 || Math.abs(y().hashCode()) % 100 <= i10;
    }

    public boolean D0(Activity activity) {
        String name = activity.getClass().getName();
        boolean d10 = j.d(this, name, true);
        if (d10) {
            j.p(this, name, false);
        }
        return d10;
    }

    public String E() {
        WifiInfo connectionInfo;
        if (this.f12100e == null) {
            if (N0()) {
                try {
                    WifiManager wifiManager = (WifiManager) getSystemService("wifi");
                    if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                        this.f12100e = u0(connectionInfo.getIpAddress());
                    }
                } catch (SecurityException e10) {
                    p0.b(e10.getMessage());
                }
            }
            if (l.q(this.f12100e)) {
                this.f12100e = G();
            }
        }
        return this.f12100e;
    }

    public boolean E0(String str) {
        boolean d10 = j.d(this, str, true);
        if (d10) {
            j.p(this, str, false);
        }
        return d10;
    }

    public boolean F(String str) {
        return j.d(this, str, false);
    }

    public boolean F0() {
        return getPackageName().equals(w());
    }

    public final String G() {
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
        } catch (SocketException e10) {
            p0.b(e10.getMessage());
            return "0.0.0.0";
        }
    }

    public boolean G0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.isConnectedOrConnecting()) {
                        return false;
                    }
                }
                return true;
            }
        } catch (SecurityException e10) {
            p0.b(e10.getMessage());
        }
        return false;
    }

    public String H() {
        return J0() ? "http://testm.taoyuewenhua.com/logoff_request" : "http://m.taoyuewenhua.com/logoff_request";
    }

    public boolean H0() {
        if (this.f12117v == null) {
            this.f12117v = Boolean.valueOf(j.d(this, f12093m0, false));
        }
        return this.f12117v.booleanValue();
    }

    public String I() {
        if (this.f12099d == null) {
            String j10 = j.j(this, L);
            this.f12099d = j10;
            if (j10 == null) {
                if (c.d(this, g.f11102c)) {
                    try {
                        this.f12099d = m.f(this);
                    } catch (SecurityException e10) {
                        p0.b(e10.getMessage());
                    }
                }
                if (this.f12099d == null) {
                    this.f12099d = "";
                }
                j.o(this, L, this.f12099d);
            }
        }
        return this.f12099d;
    }

    public boolean I0() {
        if (this.f12112q == null) {
            this.f12112q = Boolean.valueOf(j.d(this, Q, false));
        }
        return this.f12112q.booleanValue();
    }

    public String J() {
        try {
            Bundle bundle = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
            return bundle != null ? bundle.getString("UMENG_CHANNEL") : "";
        } catch (PackageManager.NameNotFoundException | NullPointerException e10) {
            p0.b(e10.getMessage());
            return "";
        }
    }

    public boolean J0() {
        return x() == 2;
    }

    public String K() {
        return Build.MODEL;
    }

    public boolean K0(long j10) {
        return L0(j10, false);
    }

    public int L() {
        return H0() ? R.color.night_background_navigationbar : A0() ? R.color.night_background_card : R.color.white;
    }

    public boolean L0(long j10, boolean z10) {
        Calendar calendar;
        Calendar calendar2;
        if (z10) {
            calendar2 = Calendar.getInstance();
            calendar = Calendar.getInstance();
        } else {
            Locale locale = Locale.CHINA;
            Calendar calendar3 = Calendar.getInstance(locale);
            calendar = Calendar.getInstance(locale);
            calendar2 = calendar3;
        }
        calendar.setTimeInMillis(j10);
        return calendar.get(1) == calendar2.get(1) && calendar2.get(6) - calendar.get(6) == 0;
    }

    public String M() {
        if (!l.q(this.f12109n)) {
            return this.f12109n;
        }
        String U2 = U(this);
        this.f12109n = U2;
        if (!l.q(U2)) {
            return this.f12109n;
        }
        int i10 = T;
        T = i10 + 1;
        if (i10 > 3) {
            return this.f12109n;
        }
        N(null);
        return this.f12109n;
    }

    public boolean M0() {
        if (this.f12120y == null) {
            this.f12120y = Boolean.valueOf(j.d(this, f12094n0, m.F(this)));
        }
        return this.f12120y.booleanValue();
    }

    public void N(b bVar) {
        try {
            UMConfigure.getOaid(this, new OnGetOaidListener() { // from class: g9.h

                /* renamed from: b */
                public final /* synthetic */ WeakReference f26193b;

                public /* synthetic */ h(WeakReference weakReference) {
                    weakReference = weakReference;
                }

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public final void onGetOaid(String str) {
                    ConfigSingleton.this.O0(weakReference, str);
                }
            });
        } catch (Exception e10) {
            p0.b(e10.getMessage());
        }
    }

    public boolean N0() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.getType() == 1;
        } catch (SecurityException e10) {
            p0.b(e10.getMessage());
        }
        return false;
    }

    @SuppressLint({"HardwareIds"})
    public String O() {
        if (this.f12103h == null) {
            String j10 = j.j(this, K);
            this.f12103h = j10;
            if (j10 == null) {
                if (c.d(this, g.f11102c)) {
                    try {
                        this.f12103h = Settings.Secure.getString(getContentResolver(), "android_id");
                    } catch (SecurityException e10) {
                        p0.b(e10.getMessage());
                    }
                }
                if (this.f12103h == null) {
                    this.f12103h = "";
                }
                j.o(this, K, this.f12103h);
            }
        }
        return this.f12103h;
    }

    public final /* synthetic */ void O0(WeakReference weakReference, String str) {
        this.f12109n = str;
        k1(this, str);
        b bVar = (b) weakReference.get();
        if (bVar != null) {
            bVar.a();
        }
    }

    public int P() {
        if (this.f12105j < 0) {
            int f10 = j.f(this, P, -1);
            this.f12105j = f10;
            if (f10 < 0) {
                if (c.d(this, g.f11102c)) {
                    try {
                        String subscriberId = ((TelephonyManager) getSystemService("phone")).getSubscriberId();
                        if (!TextUtils.isEmpty(subscriberId)) {
                            if (!subscriberId.startsWith("46000") && !subscriberId.startsWith("46002")) {
                                if (subscriberId.startsWith("46001")) {
                                    this.f12105j = 3;
                                } else if (subscriberId.startsWith("46003")) {
                                    this.f12105j = 2;
                                } else {
                                    this.f12105j = 99;
                                }
                            }
                            this.f12105j = 1;
                        }
                    } catch (SecurityException e10) {
                        p0.b(e10.getMessage());
                    }
                }
                if (this.f12105j < 0) {
                    this.f12105j = 0;
                }
                j.m(this, P, this.f12105j);
            }
        }
        return this.f12105j;
    }

    public boolean Q(String str, boolean z10) {
        return j.d(this, str, z10);
    }

    public final /* synthetic */ void Q0(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
        this.f12119x = false;
    }

    public int R(String str, int i10) {
        return j.f(this, str, i10);
    }

    public final /* synthetic */ void R0(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
        this.f12119x = false;
    }

    public long S(String str) {
        return j.h(this, str, -1L);
    }

    public final /* synthetic */ void S0(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
        this.f12119x = false;
    }

    public String T(String str) {
        return j.j(this, str);
    }

    public final /* synthetic */ void T0(a aVar, DialogInterface dialogInterface) {
        if (aVar != null) {
            aVar.a();
        }
        this.f12119x = false;
    }

    public final /* synthetic */ void U0(Activity activity, a aVar) {
        i0.y0(activity, "取消登录", "未登录将导致VIP、金币、阅读进度等信息丢失，确认取消登录吗？", "确认取消", "重新登录", true, new i0.l() { // from class: g9.c

            /* renamed from: b */
            public final /* synthetic */ ConfigSingleton.a f26182b;

            public /* synthetic */ c(ConfigSingleton.a aVar2) {
                aVar = aVar2;
            }

            @Override // l9.i0.l
            public final void a() {
                ConfigSingleton.this.R0(aVar);
            }
        }, new i0.k() { // from class: g9.d

            /* renamed from: b */
            public final /* synthetic */ ConfigSingleton.a f26184b;

            public /* synthetic */ d(ConfigSingleton.a aVar2) {
                aVar = aVar2;
            }

            @Override // l9.i0.k
            public final void a() {
                ConfigSingleton.this.S0(aVar);
            }
        }, new DialogInterface.OnDismissListener() { // from class: g9.e

            /* renamed from: c */
            public final /* synthetic */ ConfigSingleton.a f26186c;

            public /* synthetic */ e(ConfigSingleton.a aVar2) {
                aVar = aVar2;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ConfigSingleton.this.T0(aVar, dialogInterface);
            }
        });
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public String V() {
        if (!l.q(this.f12097b)) {
            return this.f12097b;
        }
        try {
            this.f12097b = d.e(getApplicationContext().getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException unused) {
            p0.d(this, "Failed to fetch package sign.");
        }
        return this.f12097b;
    }

    public boolean V0() {
        return F(f12096z);
    }

    public abstract i W();

    public abstract String X();

    public void X0(k9.a aVar) {
        this.f12118w.remove(aVar);
    }

    public int Y() {
        if (this.f12110o == -1) {
            this.f12110o = j.f(this, f12088h0, 0);
        }
        return this.f12110o;
    }

    public void Y0(String str) {
        j.m(getApplicationContext(), f12091k0 + str, 0);
    }

    public int Z() {
        if (this.f12111p == -1) {
            this.f12111p = j.f(this, f12089i0, 0);
        }
        return this.f12111p;
    }

    public void Z0(boolean z10) {
        this.f12113r = z10;
        if (z10) {
            return;
        }
        this.f12114s = System.currentTimeMillis();
    }

    public int a0() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public void a1(String str) {
        this.f12107l = str;
        j1(B, str);
    }

    public int b0() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public void b1(boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        this.f12116u = valueOf;
        j.p(this, f12092l0, valueOf.booleanValue());
    }

    public int c0() {
        return A0() ? R.drawable.theme_seekbar_progress_drawable_night : R.drawable.theme_seekbar_progress_drawable;
    }

    public void c1(int i10) {
        this.f12108m = i10;
        h1(C, i10);
    }

    public int d0() {
        return A0() ? R.drawable.theme_seek_bar_thumb_night : R.drawable.theme_seek_bar_thumb;
    }

    public void d1(boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        this.f12117v = valueOf;
        j.p(this, f12093m0, valueOf.booleanValue());
    }

    public int e0() {
        return A0() ? R.drawable.selector_default_night : R.drawable.selector_default_day;
    }

    public void e1(boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        this.f12112q = valueOf;
        j.p(this, Q, valueOf.booleanValue());
    }

    public String f0(String str) {
        return ChineseConverter.INSTANCE.a(this).g(str);
    }

    public void f1(boolean z10) {
        j.p(this, f12095o0, z10);
        if (z10) {
            g1(f12096z, false);
        }
    }

    public String g0(String str) {
        return str.equals("appid") ? l().f26178a : str.equals("PACKAGE_NAME") ? getPackageName() : str.equals("VERSION_NAME") ? p0() : str.equals("IMEI") ? A() : str.equals("OAID") ? M() : str.equals("DEVICE_MODEL") ? Build.MODEL : str.equals("DEVICE_VENDOR") ? Build.BRAND : str.equals("OPERATOR_TYPE") ? String.valueOf(P()) : str.equals("CONNECT_TYPE") ? String.valueOf(u()) : str.equals("ANDROID_ID") ? j() : str.equals("SYSTEM_VERSION") ? k() : str.equals("SYSTEM_TYPE") ? "1" : str.equals("IMSI") ? B() : str.equals("SCREEN_WIDTH") ? String.valueOf(b0()) : str.equals("SCREEN_HEIGHT") ? String.valueOf(a0()) : str.equals("MAC") ? I() : str.equals("OPENUDID") ? O() : str.equals("CHANNEL") ? r() : str.equalsIgnoreCase(bt.f23584aa) ? C() : "";
    }

    public void g1(String str, boolean z10) {
        j.p(this, str, z10);
    }

    public void h(k9.a aVar) {
        this.f12118w.add(aVar);
    }

    public int h0() {
        return ContextCompat.getColor(this, A0() ? R.color.night_text_color_primary : R.color.day_text_color_primary);
    }

    public void h1(String str, int i10) {
        j.m(this, str, i10);
    }

    public int i0() {
        return ContextCompat.getColor(this, A0() ? R.color.night_text_color_secondary : R.color.day_text_color_secondary);
    }

    public void i1(String str, long j10) {
        j.n(this, str, j10);
    }

    @SuppressLint({"HardwareIds"})
    public String j() {
        if (this.f12104i == null) {
            String j10 = j.j(this, O);
            this.f12104i = j10;
            if (j10 == null) {
                try {
                    this.f12104i = Settings.Secure.getString(getContentResolver(), "android_id");
                } catch (SecurityException e10) {
                    p0.b(e10.getMessage());
                }
                if (this.f12104i == null) {
                    this.f12104i = "";
                }
                j.o(this, O, this.f12104i);
            }
        }
        return this.f12104i;
    }

    public int j0() {
        return ContextCompat.getColor(this, A0() ? R.color.night_text_color_thirdly : R.color.day_text_color_thirdly);
    }

    public void j1(String str, String str2) {
        j.o(this, str, str2);
    }

    public String k() {
        return Build.VERSION.RELEASE;
    }

    public int k0() {
        return ContextCompat.getColor(this, A0() ? R.color.night_text_color_unclickable : R.color.day_text_color_unclickable);
    }

    public abstract g9.a l();

    public abstract int l0();

    public void l1(boolean z10) {
        this.f12120y = Boolean.valueOf(z10);
        j.p(this, f12094n0, z10);
    }

    public int m() {
        return ContextCompat.getColor(this, A0() ? R.color.night_background_card : R.color.white);
    }

    public String m0() {
        ComponentName componentName;
        ComponentName componentName2;
        if (!m.m()) {
            ActivityManager.RunningTaskInfo runningTaskInfo = ((ActivityManager) getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningTasks(1).get(0);
            componentName = runningTaskInfo.topActivity;
            if (componentName == null) {
                return "";
            }
            componentName2 = runningTaskInfo.topActivity;
            return componentName2.getPackageName();
        }
        UsageStatsManager usageStatsManager = (UsageStatsManager) getApplicationContext().getSystemService("usagestats");
        if (usageStatsManager == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, calendar.get(5) - 1);
        List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, calendar.getTimeInMillis(), currentTimeMillis);
        if (queryUsageStats == null || queryUsageStats.isEmpty()) {
            return "";
        }
        Collections.sort(queryUsageStats, this.f12115t);
        return queryUsageStats.get(queryUsageStats.size() - 1).getPackageName();
    }

    public void m1(Typeface typeface) {
        this.f12106k = typeface;
    }

    public int n() {
        return ContextCompat.getColor(this, A0() ? R.color.night_background : R.color.white);
    }

    public Typeface n0() {
        return this.f12106k;
    }

    public void n1(Activity activity, a aVar) {
        if (this.f12119x || activity == null) {
            return;
        }
        this.f12119x = true;
        i0.x0(activity, "登录已过期", "是否重新登录？", "取消", "重新登录", false, new i0.l() { // from class: g9.f

            /* renamed from: b */
            public final /* synthetic */ ConfigSingleton.a f26188b;

            public /* synthetic */ f(ConfigSingleton.a aVar2) {
                aVar = aVar2;
            }

            @Override // l9.i0.l
            public final void a() {
                ConfigSingleton.this.Q0(aVar);
            }
        }, new i0.k() { // from class: g9.g

            /* renamed from: b */
            public final /* synthetic */ Activity f26190b;

            /* renamed from: c */
            public final /* synthetic */ ConfigSingleton.a f26191c;

            public /* synthetic */ g(Activity activity2, ConfigSingleton.a aVar2) {
                activity = activity2;
                aVar = aVar2;
            }

            @Override // l9.i0.k
            public final void a() {
                ConfigSingleton.this.U0(activity, aVar);
            }
        });
    }

    public String o() {
        return Build.BRAND;
    }

    public int o0() {
        Context applicationContext = getApplicationContext();
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
        } catch (Exception e10) {
            p0.b(e10.getMessage());
            return -1;
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        R = this;
        t8.a.c().e(getApplicationContext());
        ba.b.o(this);
    }

    public int p() {
        return 1;
    }

    public String p0() {
        Context applicationContext = getApplicationContext();
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (Exception e10) {
            p0.b(e10.getMessage());
            return "Unknown";
        }
    }

    public final void p1() {
        long h10 = j.h(this, f12090j0, -1L);
        if (h10 <= 0 || !K0(h10)) {
            this.f12111p = 1;
        } else {
            this.f12111p = Z() + 1;
        }
        j.n(this, f12090j0, System.currentTimeMillis());
        j.m(this, f12089i0, this.f12111p);
    }

    public String q() {
        return J0() ? "http://testm.taoyuewenhua.com/logoff_cancel" : "http://m.taoyuewenhua.com/logoff_cancel";
    }

    public abstract z7.c q0();

    public void q1() {
        for (k9.a aVar : this.f12118w) {
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    public String r() {
        if (!l.q(this.f12107l)) {
            return this.f12107l;
        }
        String T2 = T(B);
        this.f12107l = T2;
        if (!l.q(T2)) {
            return this.f12107l;
        }
        String X2 = X();
        this.f12107l = X2;
        if (!l.q(X2)) {
            a1(this.f12107l);
        }
        return this.f12107l;
    }

    public int r0(String str) {
        int t10 = t(str) + 1;
        j.m(getApplicationContext(), str, t10);
        return t10;
    }

    public String s(String str) {
        return M0() ? ChineseConverter.INSTANCE.a(this).f(str) : str;
    }

    public void s0() {
        int Y2 = Y() + 1;
        this.f12110o = Y2;
        j.m(this, f12088h0, Y2);
        p1();
    }

    public int t(String str) {
        return j.f(getApplicationContext(), str, 0);
    }

    public int t0(String str) {
        int v10 = v(str) + 1;
        j.m(getApplicationContext(), f12091k0 + str, v10);
        return v10;
    }

    public int u() {
        if (N0()) {
            return 2;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo == null) {
            return 0;
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == 20) {
            return 7;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
                return 4;
            case 3:
            case 5:
            case 6:
                return 5;
            default:
                switch (subtype) {
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 5;
                    case 11:
                        return 4;
                    case 13:
                        return 6;
                    default:
                        return 3;
                }
        }
    }

    public final String u0(int i10) {
        return (i10 & 255) + p1.b.f29697h + ((i10 >> 8) & 255) + p1.b.f29697h + ((i10 >> 16) & 255) + p1.b.f29697h + ((i10 >> 24) & 255);
    }

    public int v(String str) {
        return j.f(getApplicationContext(), f12091k0 + str, 0);
    }

    public boolean v0(String str) {
        boolean d10 = j.d(this, str, false);
        if (!d10) {
            j.p(this, str, true);
        }
        return d10;
    }

    public String w() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    p0.b(e10.getMessage());
                }
                return readLine;
            } catch (Throwable th2) {
                th = th2;
                try {
                    p0.b(th.getMessage());
                    return null;
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e11) {
                            p0.b(e11.getMessage());
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    public boolean w0() {
        return x() == 3;
    }

    public final int x() {
        if (this.f12108m < 0) {
            if ("AdTest".equalsIgnoreCase(r())) {
                c1(3);
            } else if ("Beta".equalsIgnoreCase(r())) {
                c1(1);
            } else {
                this.f12108m = R(C, (getApplicationInfo().flags & 2) == 0 ? 0 : 2);
            }
        }
        return this.f12108m;
    }

    public boolean x0() {
        return this.f12113r;
    }

    public String y() {
        return m.d(this);
    }

    public boolean y0() {
        return j.d(this, f12095o0, false);
    }

    public String z() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "";
    }

    public boolean z0() {
        return x() == 1;
    }
}
