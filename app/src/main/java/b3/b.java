package b3;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.m.u.c;
import com.sigmob.sdk.archives.tar.e;
import java.util.Random;
import p3.k;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d */
    public static final String f1167d = "virtualImeiAndImsi";

    /* renamed from: e */
    public static final String f1168e = "virtual_imei";

    /* renamed from: f */
    public static final String f1169f = "virtual_imsi";

    /* renamed from: g */
    public static volatile b f1170g;

    /* renamed from: a */
    public String f1171a;

    /* renamed from: b */
    public String f1172b = "sdk-and-lite";

    /* renamed from: c */
    public String f1173c;

    public b() {
        String a10 = v2.a.a();
        if (v2.a.c()) {
            return;
        }
        this.f1172b += '_' + a10;
    }

    public static String b(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    public static synchronized void d(String str) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            PreferenceManager.getDefaultSharedPreferences(n3.b.e().c()).edit().putString(z2.b.f33624i, str).apply();
            z2.a.f33595f = str;
        }
    }

    public static synchronized b e() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f1170g == null) {
                    f1170g = new b();
                }
                bVar = f1170g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public static String f(Context context) {
        if (context == null) {
            return "";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            sb2.append("(");
            sb2.append(packageName);
            sb2.append(";");
            sb2.append(packageInfo.versionCode);
            sb2.append(")");
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String g() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public static String h() {
        return "-1;-1";
    }

    public static String i() {
        return "1";
    }

    public static String j() {
        Context c10 = n3.b.e().c();
        SharedPreferences sharedPreferences = c10.getSharedPreferences(f1167d, 0);
        String string = sharedPreferences.getString(f1168e, null);
        if (TextUtils.isEmpty(string)) {
            string = TextUtils.isEmpty(o3.a.a(c10).i()) ? g() : c.c(c10).d();
            sharedPreferences.edit().putString(f1168e, string).apply();
        }
        return string;
    }

    public static String k() {
        String e10;
        Context c10 = n3.b.e().c();
        SharedPreferences sharedPreferences = c10.getSharedPreferences(f1167d, 0);
        String string = sharedPreferences.getString(f1169f, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(o3.a.a(c10).i())) {
                String d10 = n3.b.e().d();
                e10 = (TextUtils.isEmpty(d10) || d10.length() < 18) ? g() : d10.substring(3, 18);
            } else {
                e10 = c.c(c10).e();
            }
            string = e10;
            sharedPreferences.edit().putString(f1169f, string).apply();
        }
        return string;
    }

    public static String l() {
        return e.S;
    }

    public static String m() {
        return "-1";
    }

    public String a() {
        return this.f1173c;
    }

    public String c(n3.a aVar, o3.a aVar2, boolean z10) {
        Context c10 = n3.b.e().c();
        c c11 = c.c(c10);
        if (TextUtils.isEmpty(this.f1171a)) {
            this.f1171a = "Msp/15.8.30 (" + k.W() + ";" + k.T() + ";" + k.L(c10) + ";" + k.U(c10) + ";" + k.X(c10) + ";" + b(c10);
        }
        String b10 = c.g(c10).b();
        String E = k.E(c10);
        String i10 = i();
        String e10 = c11.e();
        String d10 = c11.d();
        String k10 = k();
        String j10 = j();
        if (aVar2 != null) {
            this.f1173c = aVar2.h();
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean f10 = n3.b.f();
        String h10 = c11.h();
        String m10 = m();
        String l10 = l();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f1171a);
        sb2.append(";");
        sb2.append(b10);
        sb2.append(";");
        sb2.append(E);
        sb2.append(";");
        sb2.append(i10);
        sb2.append(";");
        sb2.append(e10);
        sb2.append(";");
        sb2.append(d10);
        sb2.append(";");
        sb2.append(this.f1173c);
        sb2.append(";");
        sb2.append(replace);
        sb2.append(";");
        sb2.append(replace2);
        sb2.append(";");
        sb2.append(f10);
        sb2.append(";");
        sb2.append(h10);
        sb2.append(";");
        sb2.append(h());
        sb2.append(";");
        sb2.append(this.f1172b);
        sb2.append(";");
        sb2.append(k10);
        sb2.append(";");
        sb2.append(j10);
        sb2.append(";");
        sb2.append(m10);
        sb2.append(";");
        sb2.append(l10);
        if (aVar2 != null) {
            String b11 = com.alipay.sdk.m.w.b.b(aVar, c10, o3.a.a(c10).i(), com.alipay.sdk.m.w.b.d(aVar, c10));
            if (!TextUtils.isEmpty(b11)) {
                sb2.append(";;;");
                sb2.append(b11);
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
