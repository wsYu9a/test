package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static a f24748a;
    public int F;
    public String G;

    /* renamed from: b */
    private final Context f24749b;

    /* renamed from: c */
    private String f24750c;

    /* renamed from: e */
    public final String f24752e;

    /* renamed from: g */
    public String f24754g;

    /* renamed from: h */
    public final String f24755h;
    public boolean ha;

    /* renamed from: i */
    public String f24756i;
    public final String n;
    public final String o;
    public final String p;
    private String q;
    public SharedPreferences qa;

    /* renamed from: j */
    public boolean f24757j = true;
    public final String k = "com.tencent.bugly";
    public String l = "3.4.12(1.5.23)";
    public final String m = "";
    private String r = EnvironmentCompat.MEDIA_UNKNOWN;
    private String s = EnvironmentCompat.MEDIA_UNKNOWN;
    private String t = "";
    public long u = 0;
    private String v = null;
    private long w = -1;
    private long x = -1;
    private long y = -1;
    private String z = null;
    private String A = null;
    private Map<String, PlugInBean> B = null;
    private boolean C = true;
    private String D = null;
    public String E = null;
    private String H = null;
    public String I = null;
    private Boolean J = null;
    private String K = null;
    public String L = null;
    public String M = null;
    private Map<String, PlugInBean> N = null;
    private Map<String, PlugInBean> O = null;
    public List<String> P = null;
    private int Q = -1;
    private int R = -1;
    private Map<String, String> S = new HashMap();
    private Map<String, String> T = new HashMap();
    private Map<String, String> U = new HashMap();
    private boolean V = true;
    public String W = EnvironmentCompat.MEDIA_UNKNOWN;
    public long X = 0;
    public long Y = 0;
    public long Z = 0;
    public long aa = 0;
    public boolean ba = false;
    public String ca = null;
    public String da = null;
    public String ea = null;
    public String fa = "";
    public boolean ga = false;
    public Boolean ia = null;
    public Boolean ja = null;
    public HashMap<String, String> ka = new HashMap<>();
    private String la = null;
    private String ma = null;
    public List<String> na = new ArrayList();
    public boolean oa = false;
    public com.tencent.bugly.crashreport.b pa = null;
    private final Object ra = new Object();
    private final Object sa = new Object();
    private final Object ta = new Object();
    private final Object ua = new Object();
    private final Object va = new Object();
    private final Object wa = new Object();
    private final Object xa = new Object();

    /* renamed from: d */
    public final long f24751d = System.currentTimeMillis();

    /* renamed from: f */
    public final byte f24753f = 1;

    private a(Context context) {
        this.G = null;
        this.ha = false;
        this.f24749b = ca.a(context);
        c(context);
        this.f24754g = AppInfo.d(context);
        this.f24755h = AppInfo.a(context, Process.myPid());
        this.n = b.d();
        String f2 = b.f();
        this.o = f2;
        this.G = AppInfo.a(context);
        String str = "Android " + b.m() + ",level " + b.c();
        this.p = str;
        this.f24752e = f2 + ";" + str;
        b(context);
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.ha = true;
                X.a("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th) {
            if (com.tencent.bugly.b.f24588c) {
                th.printStackTrace();
            }
        }
        this.qa = ca.a("BUGLY_COMMON_VALUES", context);
        X.a("com info create end", new Object[0]);
    }

    private void b(Context context) {
        Map<String, String> b2 = AppInfo.b(context);
        if (b2 == null) {
            return;
        }
        try {
            this.P = AppInfo.a(b2);
            String str = b2.get("BUGLY_APPID");
            if (str != null) {
                this.H = str;
                a("APP_ID", str);
            }
            String str2 = b2.get("BUGLY_APP_VERSION");
            if (str2 != null) {
                this.E = str2;
            }
            String str3 = b2.get("BUGLY_APP_CHANNEL");
            if (str3 != null) {
                this.I = str3;
            }
            String str4 = b2.get("BUGLY_ENABLE_DEBUG");
            if (str4 != null) {
                this.ba = str4.equalsIgnoreCase("true");
            }
            String str5 = b2.get("com.tencent.rdm.uuid");
            if (str5 != null) {
                this.ea = str5;
            }
            String str6 = b2.get("BUGLY_APP_BUILD_NO");
            if (!TextUtils.isEmpty(str6)) {
                this.F = Integer.parseInt(str6);
            }
            String str7 = b2.get("BUGLY_AREA");
            if (str7 != null) {
                this.fa = str7;
            }
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private void c(Context context) {
        PackageInfo c2 = AppInfo.c(context);
        if (c2 == null) {
            return;
        }
        try {
            String str = c2.versionName;
            this.E = str;
            this.ca = str;
            this.da = Integer.toString(c2.versionCode);
        } catch (Throwable th) {
            if (X.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public static synchronized a m() {
        a aVar;
        synchronized (a.class) {
            aVar = f24748a;
        }
        return aVar;
    }

    public int A() {
        int i2;
        synchronized (this.va) {
            i2 = this.Q;
        }
        return i2;
    }

    public boolean B() {
        if (this.ja == null) {
            this.ja = Boolean.valueOf(b.f(this.f24749b));
            X.c("Does it has hook frame? " + this.ja, new Object[0]);
        }
        return this.ja.booleanValue();
    }

    public boolean C() {
        return this.V;
    }

    public boolean D() {
        if (this.ia == null) {
            this.ia = Boolean.valueOf(b.h(this.f24749b));
            X.c("Is it a virtual machine? " + this.ia, new Object[0]);
        }
        return this.ia.booleanValue();
    }

    public String E() {
        try {
            Map<String, ?> all = this.f24749b.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.sa) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.ka.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            X.b(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            X.b(th2);
        }
        if (this.ka.isEmpty()) {
            X.a("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.ka.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        X.a("SDK_INFO = %s", sb.toString());
        a("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public void F() {
        synchronized (this.ra) {
            this.f24750c = UUID.randomUUID().toString();
        }
    }

    public void a(boolean z) {
        this.V = z;
        com.tencent.bugly.crashreport.b bVar = this.pa;
        if (bVar != null) {
            bVar.setNativeIsAppForeground(z);
        }
    }

    public void d(String str) {
        this.q = str;
        synchronized (this.xa) {
            this.T.put("E8", str);
        }
    }

    public String e() {
        return !ca.b(this.f24756i) ? this.f24756i : this.H;
    }

    public synchronized void f(String str) {
        this.t = "" + str;
    }

    public void g(String str) {
        synchronized (this.wa) {
            if (str == null) {
                str = "10000";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(str);
            this.r = sb.toString();
        }
    }

    public Map<String, String> h() {
        synchronized (this.ta) {
            if (this.S.size() <= 0) {
                return null;
            }
            return new HashMap(this.S);
        }
    }

    public String i() {
        if (this.D == null) {
            this.D = b.e();
        }
        return this.D;
    }

    public String j() {
        if (this.A == null) {
            this.A = b.b(this.f24749b);
        }
        return this.A;
    }

    public String k() {
        if (this.z == null) {
            this.z = b.a(this.f24749b, true);
        }
        return this.z;
    }

    public String l() {
        String str = this.q;
        if (str != null) {
            return str;
        }
        String c2 = c();
        this.q = c2;
        return c2;
    }

    public Boolean n() {
        if (this.J == null) {
            this.J = Boolean.valueOf(b.q());
        }
        return this.J;
    }

    public synchronized Map<String, PlugInBean> o() {
        Map<String, PlugInBean> map;
        map = this.N;
        Map<String, PlugInBean> map2 = this.O;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public synchronized Map<String, PlugInBean> p() {
        Map<String, PlugInBean> map = this.B;
        if (map != null && map.size() > 0) {
            HashMap hashMap = new HashMap(this.B.size());
            hashMap.putAll(this.B);
            return hashMap;
        }
        return null;
    }

    public synchronized String q() {
        return this.t;
    }

    public String r() {
        if (this.K == null) {
            String str = "" + b.d(this.f24749b);
            this.K = str;
            X.c("ROM ID: %s", str);
        }
        return this.K;
    }

    public String s() {
        return this.l;
    }

    public int t() {
        return this.R;
    }

    public String u() {
        String str;
        synchronized (this.ra) {
            if (this.f24750c == null) {
                F();
            }
            str = this.f24750c;
        }
        return str;
    }

    public long v() {
        if (this.x <= 0) {
            this.x = b.i();
        }
        return this.x;
    }

    public long w() {
        if (this.w <= 0) {
            this.w = b.k();
        }
        return this.w;
    }

    public long x() {
        if (this.y <= 0) {
            this.y = b.l();
        }
        return this.y;
    }

    public String y() {
        String str;
        synchronized (this.wa) {
            str = this.r;
        }
        return str;
    }

    public int z() {
        int size;
        synchronized (this.ta) {
            size = this.S.size();
        }
        return size;
    }

    public Map<String, String> f() {
        synchronized (this.xa) {
            if (this.T.size() <= 0) {
                return null;
            }
            return new HashMap(this.T);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f24748a == null) {
                f24748a = new a(context);
            }
            aVar = f24748a;
        }
        return aVar;
    }

    public synchronized void e(String str) {
        this.s = "" + str;
    }

    public Map<String, String> g() {
        synchronized (this.ua) {
            if (this.U.size() <= 0) {
                return null;
            }
            return new HashMap(this.U);
        }
    }

    public int d() {
        return b.c();
    }

    public void a() {
        synchronized (this.ta) {
            this.S.clear();
        }
    }

    public void c(String str) {
        this.H = str;
        a("APP_ID", str);
    }

    public String c() {
        if (!this.C) {
            return "";
        }
        if (this.v == null) {
            this.v = ca.b("androidid", "");
            String a2 = b.a(this.f24749b);
            this.v = a2;
            if (!TextUtils.isEmpty(a2)) {
                ca.c("androidid", this.v);
            }
        }
        return this.v;
    }

    public String a(String str) {
        String str2;
        if (ca.b(str)) {
            X.e("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.ta) {
            str2 = this.S.get(str);
        }
        return str2;
    }

    public void a(String str, String str2) {
        if (!ca.b(str) && !ca.b(str2)) {
            synchronized (this.ua) {
                this.U.put(str, str2);
            }
            return;
        }
        X.e("server key&value should not be empty %s %s", "" + str, "" + str2);
    }

    public void c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.sa) {
            this.ka.put(str, str2);
        }
    }

    public void a(int i2) {
        int i3 = this.R;
        if (i3 != i2) {
            this.R = i2;
            X.c("server scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.R));
        }
    }

    public void b(boolean z) {
        this.C = z;
    }

    public String b(String str) {
        String remove;
        if (ca.b(str)) {
            X.e("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.ta) {
            remove = this.S.remove(str);
        }
        return remove;
    }

    public void b(String str, String str2) {
        if (!ca.b(str) && !ca.b(str2)) {
            synchronized (this.ta) {
                this.S.put(str, str2);
            }
            return;
        }
        X.e("key&value should not be empty %s %s", "" + str, "" + str2);
    }

    public Set<String> b() {
        Set<String> keySet;
        synchronized (this.ta) {
            keySet = this.S.keySet();
        }
        return keySet;
    }

    public void b(int i2) {
        synchronized (this.va) {
            int i3 = this.Q;
            if (i3 != i2) {
                this.Q = i2;
                X.c("user scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.Q));
            }
        }
    }
}
