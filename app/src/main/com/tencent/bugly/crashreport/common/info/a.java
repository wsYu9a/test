package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
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
    private static a f22282a;
    public int F;
    public String G;

    /* renamed from: b */
    private final Context f22284b;

    /* renamed from: c */
    private String f22286c;

    /* renamed from: e */
    public final String f22290e;

    /* renamed from: g */
    public String f22294g;

    /* renamed from: h */
    public final String f22296h;

    /* renamed from: ha */
    public boolean f22297ha;

    /* renamed from: i */
    public String f22298i;

    /* renamed from: n */
    public final String f22308n;

    /* renamed from: o */
    public final String f22310o;

    /* renamed from: p */
    public final String f22312p;

    /* renamed from: q */
    private String f22314q;

    /* renamed from: qa */
    public SharedPreferences f22315qa;

    /* renamed from: j */
    public boolean f22300j = true;

    /* renamed from: k */
    public final String f22302k = "com.tencent.bugly";

    /* renamed from: l */
    public String f22304l = "3.4.12(1.5.23)";

    /* renamed from: m */
    public final String f22306m = "";

    /* renamed from: r */
    private String f22316r = "unknown";

    /* renamed from: s */
    private String f22318s = "unknown";

    /* renamed from: t */
    private String f22320t = "";

    /* renamed from: u */
    public long f22322u = 0;

    /* renamed from: v */
    private String f22324v = null;

    /* renamed from: w */
    private long f22326w = -1;

    /* renamed from: x */
    private long f22328x = -1;

    /* renamed from: y */
    private long f22330y = -1;

    /* renamed from: z */
    private String f22331z = null;
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
    public String W = "unknown";
    public long X = 0;
    public long Y = 0;
    public long Z = 0;

    /* renamed from: aa */
    public long f22283aa = 0;

    /* renamed from: ba */
    public boolean f22285ba = false;

    /* renamed from: ca */
    public String f22287ca = null;

    /* renamed from: da */
    public String f22289da = null;

    /* renamed from: ea */
    public String f22291ea = null;

    /* renamed from: fa */
    public String f22293fa = "";

    /* renamed from: ga */
    public boolean f22295ga = false;

    /* renamed from: ia */
    public Boolean f22299ia = null;

    /* renamed from: ja */
    public Boolean f22301ja = null;

    /* renamed from: ka */
    public HashMap<String, String> f22303ka = new HashMap<>();

    /* renamed from: la */
    private String f22305la = null;

    /* renamed from: ma */
    private String f22307ma = null;

    /* renamed from: na */
    public List<String> f22309na = new ArrayList();

    /* renamed from: oa */
    public boolean f22311oa = false;

    /* renamed from: pa */
    public com.tencent.bugly.crashreport.b f22313pa = null;

    /* renamed from: ra */
    private final Object f22317ra = new Object();

    /* renamed from: sa */
    private final Object f22319sa = new Object();

    /* renamed from: ta */
    private final Object f22321ta = new Object();

    /* renamed from: ua */
    private final Object f22323ua = new Object();

    /* renamed from: va */
    private final Object f22325va = new Object();

    /* renamed from: wa */
    private final Object f22327wa = new Object();

    /* renamed from: xa */
    private final Object f22329xa = new Object();

    /* renamed from: d */
    public final long f22288d = System.currentTimeMillis();

    /* renamed from: f */
    public final byte f22292f = 1;

    private a(Context context) {
        this.G = null;
        this.f22297ha = false;
        this.f22284b = ca.a(context);
        c(context);
        this.f22294g = AppInfo.d(context);
        this.f22296h = AppInfo.a(context, Process.myPid());
        this.f22308n = b.d();
        String f10 = b.f();
        this.f22310o = f10;
        this.G = AppInfo.a(context);
        String str = "Android " + b.m() + ",level " + b.c();
        this.f22312p = str;
        this.f22290e = f10 + ";" + str;
        b(context);
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f22297ha = true;
                X.a("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th2) {
            if (com.tencent.bugly.b.f22066c) {
                th2.printStackTrace();
            }
        }
        this.f22315qa = ca.a("BUGLY_COMMON_VALUES", context);
        X.a("com info create end", new Object[0]);
    }

    private void b(Context context) {
        Map<String, String> b10 = AppInfo.b(context);
        if (b10 == null) {
            return;
        }
        try {
            this.P = AppInfo.a(b10);
            String str = b10.get("BUGLY_APPID");
            if (str != null) {
                this.H = str;
                a("APP_ID", str);
            }
            String str2 = b10.get("BUGLY_APP_VERSION");
            if (str2 != null) {
                this.E = str2;
            }
            String str3 = b10.get("BUGLY_APP_CHANNEL");
            if (str3 != null) {
                this.I = str3;
            }
            String str4 = b10.get("BUGLY_ENABLE_DEBUG");
            if (str4 != null) {
                this.f22285ba = str4.equalsIgnoreCase("true");
            }
            String str5 = b10.get("com.tencent.rdm.uuid");
            if (str5 != null) {
                this.f22291ea = str5;
            }
            String str6 = b10.get("BUGLY_APP_BUILD_NO");
            if (!TextUtils.isEmpty(str6)) {
                this.F = Integer.parseInt(str6);
            }
            String str7 = b10.get("BUGLY_AREA");
            if (str7 != null) {
                this.f22293fa = str7;
            }
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    private void c(Context context) {
        PackageInfo c10 = AppInfo.c(context);
        if (c10 == null) {
            return;
        }
        try {
            String str = c10.versionName;
            this.E = str;
            this.f22287ca = str;
            this.f22289da = Integer.toString(c10.versionCode);
        } catch (Throwable th2) {
            if (X.b(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public static synchronized a m() {
        a aVar;
        synchronized (a.class) {
            aVar = f22282a;
        }
        return aVar;
    }

    public int A() {
        int i10;
        synchronized (this.f22325va) {
            i10 = this.Q;
        }
        return i10;
    }

    public boolean B() {
        if (this.f22301ja == null) {
            this.f22301ja = Boolean.valueOf(b.f(this.f22284b));
            X.c("Does it has hook frame? " + this.f22301ja, new Object[0]);
        }
        return this.f22301ja.booleanValue();
    }

    public boolean C() {
        return this.V;
    }

    public boolean D() {
        if (this.f22299ia == null) {
            this.f22299ia = Boolean.valueOf(b.h(this.f22284b));
            X.c("Is it a virtual machine? " + this.f22299ia, new Object[0]);
        }
        return this.f22299ia.booleanValue();
    }

    public String E() {
        try {
            Map<String, ?> all = this.f22284b.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f22319sa) {
                    try {
                    } catch (Throwable th2) {
                        X.b(th2);
                    } finally {
                    }
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        this.f22303ka.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Throwable th3) {
            X.b(th3);
        }
        if (this.f22303ka.isEmpty()) {
            X.a("SDK_INFO is empty", new Object[0]);
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.f22303ka.entrySet()) {
            sb2.append("[");
            sb2.append(entry2.getKey());
            sb2.append(",");
            sb2.append(entry2.getValue());
            sb2.append("] ");
        }
        X.a("SDK_INFO = %s", sb2.toString());
        a("SDK_INFO", sb2.toString());
        return sb2.toString();
    }

    public void F() {
        synchronized (this.f22317ra) {
            this.f22286c = UUID.randomUUID().toString();
        }
    }

    public void a(boolean z10) {
        this.V = z10;
        com.tencent.bugly.crashreport.b bVar = this.f22313pa;
        if (bVar != null) {
            bVar.setNativeIsAppForeground(z10);
        }
    }

    public void d(String str) {
        this.f22314q = str;
        synchronized (this.f22329xa) {
            this.T.put("E8", str);
        }
    }

    public String e() {
        return !ca.b(this.f22298i) ? this.f22298i : this.H;
    }

    public synchronized void f(String str) {
        this.f22320t = "" + str;
    }

    public void g(String str) {
        synchronized (this.f22327wa) {
            if (str == null) {
                str = "10000";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(str);
            this.f22316r = sb2.toString();
        }
    }

    public Map<String, String> h() {
        synchronized (this.f22321ta) {
            try {
                if (this.S.size() <= 0) {
                    return null;
                }
                return new HashMap(this.S);
            } catch (Throwable th2) {
                throw th2;
            }
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
            this.A = b.b(this.f22284b);
        }
        return this.A;
    }

    public String k() {
        if (this.f22331z == null) {
            this.f22331z = b.a(this.f22284b, true);
        }
        return this.f22331z;
    }

    public String l() {
        String str = this.f22314q;
        if (str != null) {
            return str;
        }
        String c10 = c();
        this.f22314q = c10;
        return c10;
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
        return this.f22320t;
    }

    public String r() {
        if (this.K == null) {
            String str = "" + b.d(this.f22284b);
            this.K = str;
            X.c("ROM ID: %s", str);
        }
        return this.K;
    }

    public String s() {
        return this.f22304l;
    }

    public int t() {
        return this.R;
    }

    public String u() {
        String str;
        synchronized (this.f22317ra) {
            try {
                if (this.f22286c == null) {
                    F();
                }
                str = this.f22286c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str;
    }

    public long v() {
        if (this.f22328x <= 0) {
            this.f22328x = b.i();
        }
        return this.f22328x;
    }

    public long w() {
        if (this.f22326w <= 0) {
            this.f22326w = b.k();
        }
        return this.f22326w;
    }

    public long x() {
        if (this.f22330y <= 0) {
            this.f22330y = b.l();
        }
        return this.f22330y;
    }

    public String y() {
        String str;
        synchronized (this.f22327wa) {
            str = this.f22316r;
        }
        return str;
    }

    public int z() {
        int size;
        synchronized (this.f22321ta) {
            size = this.S.size();
        }
        return size;
    }

    public Map<String, String> f() {
        synchronized (this.f22329xa) {
            try {
                if (this.T.size() <= 0) {
                    return null;
                }
                return new HashMap(this.T);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f22282a == null) {
                    f22282a = new a(context);
                }
                aVar = f22282a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public synchronized void e(String str) {
        this.f22318s = "" + str;
    }

    public Map<String, String> g() {
        synchronized (this.f22323ua) {
            try {
                if (this.U.size() <= 0) {
                    return null;
                }
                return new HashMap(this.U);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int d() {
        return b.c();
    }

    public void a() {
        synchronized (this.f22321ta) {
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
        if (this.f22324v == null) {
            this.f22324v = ca.b("androidid", "");
            String a10 = b.a(this.f22284b);
            this.f22324v = a10;
            if (!TextUtils.isEmpty(a10)) {
                ca.c("androidid", this.f22324v);
            }
        }
        return this.f22324v;
    }

    public String a(String str) {
        String str2;
        if (ca.b(str)) {
            X.e("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.f22321ta) {
            str2 = this.S.get(str);
        }
        return str2;
    }

    public void a(String str, String str2) {
        if (!ca.b(str) && !ca.b(str2)) {
            synchronized (this.f22323ua) {
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
        synchronized (this.f22319sa) {
            this.f22303ka.put(str, str2);
        }
    }

    public void a(int i10) {
        int i11 = this.R;
        if (i11 != i10) {
            this.R = i10;
            X.c("server scene tag %d changed to tag %d", Integer.valueOf(i11), Integer.valueOf(this.R));
        }
    }

    public void b(boolean z10) {
        this.C = z10;
    }

    public String b(String str) {
        String remove;
        if (ca.b(str)) {
            X.e("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.f22321ta) {
            remove = this.S.remove(str);
        }
        return remove;
    }

    public void b(String str, String str2) {
        if (!ca.b(str) && !ca.b(str2)) {
            synchronized (this.f22321ta) {
                this.S.put(str, str2);
            }
            return;
        }
        X.e("key&value should not be empty %s %s", "" + str, "" + str2);
    }

    public Set<String> b() {
        Set<String> keySet;
        synchronized (this.f22321ta) {
            keySet = this.S.keySet();
        }
        return keySet;
    }

    public void b(int i10) {
        synchronized (this.f22325va) {
            try {
                int i11 = this.Q;
                if (i11 != i10) {
                    this.Q = i10;
                    X.c("user scene tag %d changed to tag %d", Integer.valueOf(i11), Integer.valueOf(this.Q));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
