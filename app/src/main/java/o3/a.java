package o3;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import d3.e;
import java.util.Random;
import org.json.JSONObject;
import p3.d;

/* loaded from: classes.dex */
public class a {

    /* renamed from: g */
    public static final String f29028g = "alipay_tid_storage";

    /* renamed from: h */
    public static final String f29029h = "tidinfo";

    /* renamed from: i */
    public static final String f29030i = "tid";

    /* renamed from: j */
    public static final String f29031j = "client_key";

    /* renamed from: k */
    public static final String f29032k = "timestamp";

    /* renamed from: l */
    public static final String f29033l = "vimei";

    /* renamed from: m */
    public static final String f29034m = "vimsi";

    /* renamed from: n */
    public static Context f29035n;

    /* renamed from: o */
    public static a f29036o;

    /* renamed from: a */
    public String f29037a;

    /* renamed from: b */
    public String f29038b;

    /* renamed from: c */
    public long f29039c;

    /* renamed from: d */
    public String f29040d;

    /* renamed from: e */
    public String f29041e;

    /* renamed from: f */
    public boolean f29042f = false;

    /* renamed from: o3.a$a */
    public static class C0750a {
        public static String a() {
            String str;
            try {
                str = a.f29035n.getApplicationContext().getPackageName();
            } catch (Throwable th2) {
                d.e(th2);
                str = "";
            }
            return (str + "0000000000000000000000000000").substring(0, 24);
        }

        public static String b(String str, String str2, boolean z10) {
            if (a.f29035n == null) {
                return null;
            }
            String string = a.f29035n.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z10) {
                string = e.a(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    d.g(z2.a.A, "tid_str: pref failed");
                }
            }
            d.g(z2.a.A, "tid_str: from local");
            return string;
        }

        public static void c(String str, String str2, String str3) {
            d(str, str2, str3, true);
        }

        public static void d(String str, String str2, String str3, boolean z10) {
            if (a.f29035n == null) {
                return;
            }
            SharedPreferences sharedPreferences = a.f29035n.getSharedPreferences(str, 0);
            if (z10) {
                String a10 = a();
                String c10 = e.c(a10, str3, str3);
                if (TextUtils.isEmpty(c10)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, a10);
                }
                str3 = c10;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static boolean e(String str, String str2) {
            if (a.f29035n == null) {
                return false;
            }
            return a.f29035n.getSharedPreferences(str, 0).contains(str2);
        }

        public static void f(String str, String str2) {
            if (a.f29035n == null) {
                return;
            }
            a.f29035n.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static boolean g(String str, String str2) {
            if (a.f29035n == null) {
                return false;
            }
            return a.f29035n.getSharedPreferences(str, 0).contains(str2);
        }

        public static String h(String str, String str2) {
            return b(str, str2, true);
        }
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            try {
                if (f29036o == null) {
                    f29036o = new a();
                }
                if (f29035n == null) {
                    f29036o.g(context);
                }
                aVar = f29036o;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public void b() {
        d.g(z2.a.A, "tid_str: del");
        r();
    }

    public void c(String str, String str2) {
        d.g(z2.a.A, "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f29037a = str;
        this.f29038b = str2;
        this.f29039c = System.currentTimeMillis();
        s();
        t();
    }

    public final void d(String str, String str2, String str3, String str4, Long l10) {
        if (e(str, str2, str3, str4)) {
            return;
        }
        this.f29037a = str;
        this.f29038b = str2;
        this.f29040d = str3;
        this.f29041e = str4;
        if (l10 == null) {
            this.f29039c = System.currentTimeMillis();
        } else {
            this.f29039c = l10.longValue();
        }
        s();
    }

    public final boolean e(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public String f() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public final void g(Context context) {
        if (context != null) {
            f29035n = context.getApplicationContext();
        }
        if (this.f29042f) {
            return;
        }
        this.f29042f = true;
        q();
    }

    public String h() {
        return this.f29038b;
    }

    public String i() {
        return this.f29037a;
    }

    public Long j() {
        return Long.valueOf(this.f29039c);
    }

    public String k() {
        return this.f29040d;
    }

    public String l() {
        return this.f29041e;
    }

    public boolean m() {
        return n();
    }

    public boolean n() {
        return TextUtils.isEmpty(this.f29037a) || TextUtils.isEmpty(this.f29038b) || TextUtils.isEmpty(this.f29040d) || TextUtils.isEmpty(this.f29041e);
    }

    public final String p() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = o3.a.C0750a.b(r3, r4, r5)     // Catch: java.lang.Exception -> L51
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L51
            if (r4 != 0) goto L55
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L51
            r4.<init>(r3)     // Catch: java.lang.Exception -> L51
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch: java.lang.Exception -> L51
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch: java.lang.Exception -> L4d
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L4a
            long r6 = r4.optLong(r6, r7)     // Catch: java.lang.Exception -> L4a
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L4a
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch: java.lang.Exception -> L4a
            java.lang.String r7 = "vimsi"
            java.lang.String r2 = r4.optString(r7, r0)     // Catch: java.lang.Exception -> L48
        L45:
            r0 = r2
            r2 = r3
            goto L5d
        L48:
            r0 = move-exception
            goto L59
        L4a:
            r0 = move-exception
            r6 = r2
            goto L59
        L4d:
            r0 = move-exception
            r5 = r2
        L4f:
            r6 = r5
            goto L59
        L51:
            r0 = move-exception
            r3 = r2
            r5 = r3
            goto L4f
        L55:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L5d
        L59:
            p3.d.e(r0)
            goto L45
        L5d:
            java.lang.String r3 = "mspl"
            java.lang.String r4 = "tid_str: load"
            p3.d.g(r3, r4)
            boolean r3 = r9.e(r2, r5, r6, r0)
            if (r3 == 0) goto L6e
            r9.r()
            goto L7c
        L6e:
            r9.f29037a = r2
            r9.f29038b = r5
            long r1 = r1.longValue()
            r9.f29039c = r1
            r9.f29040d = r6
            r9.f29041e = r0
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o3.a.q():void");
    }

    public final void r() {
        this.f29037a = "";
        this.f29038b = f();
        this.f29039c = System.currentTimeMillis();
        this.f29040d = p();
        this.f29041e = p();
        C0750a.f(f29028g, f29029h);
    }

    public final void s() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f29037a);
            jSONObject.put(f29031j, this.f29038b);
            jSONObject.put(f29032k, this.f29039c);
            jSONObject.put(f29033l, this.f29040d);
            jSONObject.put(f29034m, this.f29041e);
            C0750a.d(f29028g, f29029h, jSONObject.toString(), true);
        } catch (Exception e10) {
            d.e(e10);
        }
    }

    public final void t() {
    }
}
