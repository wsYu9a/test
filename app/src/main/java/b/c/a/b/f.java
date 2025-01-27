package b.c.a.b;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.vivo.advv.Color;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private static String f4310a = "";

    /* renamed from: b */
    private static String f4311b = "clientId";

    /* renamed from: c */
    private static String f4312c = "G0";

    /* renamed from: d */
    public static f f4313d = new f();

    /* renamed from: e */
    private static String f4314e = com.alipay.sdk.authjs.a.f5378e;

    /* renamed from: f */
    private static String f4315f = "localId";

    /* renamed from: g */
    private static String f4316g = "e3c9997fed83a974";

    /* renamed from: h */
    public final String f4317h;

    /* renamed from: i */
    public final String f4318i;

    /* renamed from: j */
    public final String f4319j;
    private String k;
    private volatile h l;

    private f() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getPath());
        String str = File.separator;
        sb.append(str);
        sb.append(".mcs");
        String sb2 = sb.toString();
        this.f4319j = sb2;
        this.f4318i = sb2 + str + "mcs_msg.ini";
        this.f4317h = sb2 + str + f4316g + ".ini";
    }

    private h c(Context context) {
        h k = k(context);
        if (TextUtils.isEmpty(k.f4330a)) {
            this.k = c.a();
            k.f4331b = g.f4325f;
            if (b.f4296b) {
                b.a("自动生成ClientId：" + this.k);
            }
            o(context, this.k);
            k.f4330a = this.k;
        } else {
            this.k = k.f4330a;
        }
        return k;
    }

    private h e(Context context) {
        h hVar;
        int i2;
        if (this.l == null) {
            synchronized (f.class) {
                if (this.l == null) {
                    this.l = h(context, true);
                }
            }
        } else if (!TextUtils.isEmpty(this.l.f4330a)) {
            if (c.c(this.l.f4331b)) {
                hVar = this.l;
                i2 = g.f4320a;
            } else if (c.d(this.l.f4331b)) {
                hVar = this.l;
                i2 = (this.l.f4331b & Color.MAGENTA) | g.f4324e;
            }
            hVar.f4331b = i2;
        }
        return this.l;
    }

    private h f(Context context) {
        h f2 = i.f(context);
        if (TextUtils.isEmpty(f2.f4330a)) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                f2 = i.d(context);
            }
            if (TextUtils.isEmpty(f2.f4330a) && i2 >= 26) {
                f2 = i.c(context);
            }
            if (TextUtils.isEmpty(f2.f4330a)) {
                f2 = i.b(context);
            }
        }
        if (c.g(f2.f4330a)) {
            f2.f4330a = null;
        }
        return f2;
    }

    private h h(Context context, boolean z) {
        return (l.e(context) || l.d(context)) ? k.e() : i(context, z);
    }

    private h i(Context context, boolean z) {
        Context applicationContext = context.getApplicationContext();
        if (b.f4296b) {
            b.a("开始获取系统Imei");
        }
        h f2 = f(applicationContext);
        if (b.f4296b) {
            b.a("系统Imei:已获取");
        }
        if ((f2 == null || TextUtils.isEmpty(f2.f4330a)) && Build.VERSION.SDK_INT < 29) {
            if (b.f4296b) {
                b.a("系统LocalID: " + f2);
            }
            int i2 = f2.f4331b;
            h g2 = z ? g(applicationContext) : c(applicationContext);
            g2.f4331b |= i2;
            f2 = g2;
        }
        if (TextUtils.isEmpty(f2.f4330a) && Build.VERSION.SDK_INT >= 29) {
            f2.f4331b = (f2.f4331b & Color.MAGENTA) | g.k;
            if (b.f4296b) {
                b.a("Android版本大于等于Q");
            }
        }
        return f2;
    }

    private String j() {
        String n = m.n(this.f4318i);
        if (TextUtils.isEmpty(n)) {
            return null;
        }
        String h2 = m.h(n, null, f4311b, f4310a);
        if (c.f(h2)) {
            return h2;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
    
        if (b.c.a.b.c.g(r5) != false) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private b.c.a.b.h k(android.content.Context r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = "android.permission.READ_EXTERNAL_STORAGE"
            int r2 = b.c.a.a.b.a(r5, r2)     // Catch: java.lang.Exception -> L6d
            if (r2 != 0) goto L64
            boolean r2 = b.c.a.b.b.f4296b     // Catch: java.lang.Exception -> L6d
            if (r2 == 0) goto L24
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6d
            r2.<init>()     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = "读取"
            r2.append(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = r4.f4317h     // Catch: java.lang.Exception -> L6d
            r2.append(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L6d
            b.c.a.b.b.a(r2)     // Catch: java.lang.Exception -> L6d
        L24:
            java.io.File r2 = new java.io.File     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = r4.f4317h     // Catch: java.lang.Exception -> L6d
            r2.<init>(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r2 = b.c.a.b.m.d(r2)     // Catch: java.lang.Exception -> L6d
            boolean r3 = b.c.a.b.c.g(r2)     // Catch: java.lang.Exception -> L6d
            if (r3 == 0) goto L5f
            boolean r2 = b.c.a.b.b.f4296b     // Catch: java.lang.Exception -> L6d
            if (r2 == 0) goto L54
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6d
            r2.<init>()     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = r4.f4317h     // Catch: java.lang.Exception -> L6d
            r2.append(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = "内容无效，开始读取"
            r2.append(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r3 = r4.f4318i     // Catch: java.lang.Exception -> L6d
            r2.append(r3)     // Catch: java.lang.Exception -> L6d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L6d
            b.c.a.b.b.a(r2)     // Catch: java.lang.Exception -> L6d
        L54:
            java.lang.String r2 = r4.j()     // Catch: java.lang.Exception -> L6d
            boolean r3 = b.c.a.b.c.g(r2)     // Catch: java.lang.Exception -> L6d
            if (r3 == 0) goto L5f
            r2 = r1
        L5f:
            int r0 = b.c.a.b.g.f4326g     // Catch: java.lang.Exception -> L62
            goto L6e
        L62:
            goto L6e
        L64:
            boolean r2 = b.c.a.b.b.f4296b     // Catch: java.lang.Exception -> L6d
            if (r2 == 0) goto L6d
            java.lang.String r2 = "当前没有读取sdcard权限"
            b.c.a.b.b.a(r2)     // Catch: java.lang.Exception -> L6d
        L6d:
            r2 = r1
        L6e:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto La1
            java.lang.String r5 = b.c.a.b.e.a(r5)
            int r0 = b.c.a.b.g.f4327h
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L9f
            boolean r2 = b.c.a.b.b.f4296b
            if (r2 == 0) goto L98
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "读取SP："
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            b.c.a.b.b.a(r2)
        L98:
            boolean r2 = b.c.a.b.c.g(r5)
            if (r2 == 0) goto L9f
            goto La2
        L9f:
            r1 = r5
            goto La2
        La1:
            r1 = r2
        La2:
            boolean r5 = b.c.a.b.b.f4296b
            if (r5 == 0) goto Lba
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "readLocalIdFromSdcard  "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            b.c.a.b.b.a(r5)
        Lba:
            b.c.a.b.h r5 = new b.c.a.b.h
            r5.<init>(r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a.b.f.k(android.content.Context):b.c.a.b.h");
    }

    private void o(Context context, String str) {
        try {
            e.c(context, str);
            if (b.c.a.a.b.a(context, com.kuaishou.weapon.p0.g.f9325j) == 0) {
                m.e(str.getBytes(), new File(this.f4317h));
            }
        } catch (Exception unused) {
        }
    }

    public Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put(f4314e, b(context));
        h g2 = g(context);
        hashMap.put(f4315f, g2 == null ? f4310a : g2.f4330a);
        return hashMap;
    }

    public String b(Context context) {
        if (b.f4296b) {
            b.a("开始执行getClientId");
        }
        h e2 = e(context);
        String str = e2 == null ? "" : e2.f4330a;
        if (b.f4296b) {
            b.a("结束执行getClientId");
        }
        return str != null ? str : f4310a;
    }

    public d d(Context context) {
        if (b.f4296b) {
            b.a("开始执行getClientIdInfo");
        }
        d dVar = new d(e(context));
        if (b.f4296b) {
            b.a("结束执行getClientIdInfo");
        }
        return dVar;
    }

    h g(Context context) {
        if (TextUtils.isEmpty(this.k)) {
            return c(context);
        }
        if (b.f4296b) {
            b.a("返回内存localId：" + this.k);
        }
        return new h(this.k, g.f4324e);
    }

    public String l(Context context) {
        if (b.f4296b) {
            b.a("开始执行refreshClientId");
        }
        this.l = h(context, false);
        String str = this.l == null ? f4310a : this.l.f4330a;
        if (b.f4296b) {
            b.a("结束执行refreshClientId");
        }
        return str != null ? str : f4310a;
    }

    public String m(Context context) {
        if (b.f4296b) {
            b.a("开始执行refreshClientIdForImei");
        }
        this.l = h(context, true);
        String str = this.l == null ? f4310a : this.l.f4330a;
        if (b.f4296b) {
            b.a("结束执行refreshClientIdForImei");
        }
        return str != null ? str : f4310a;
    }

    @Deprecated
    public String n(Context context) {
        return m(context);
    }
}
