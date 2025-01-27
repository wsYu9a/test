package b.b.a.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.util.j;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.comm.constants.ErrorCode;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    private static final String f4228a = "virtualImeiAndImsi";

    /* renamed from: b */
    private static final String f4229b = "virtual_imei";

    /* renamed from: c */
    private static final String f4230c = "virtual_imsi";

    /* renamed from: d */
    private static d f4231d;

    /* renamed from: e */
    String f4232e;

    /* renamed from: f */
    String f4233f = "sdk-and-lite";

    /* renamed from: g */
    String f4234g;

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f4231d == null) {
                f4231d = new d();
            }
            dVar = f4231d;
        }
        return dVar;
    }

    private static String b(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    private static String c(Context context, HashMap<String, String> hashMap) {
        return com.alipay.mobilesecuritysdk.b.a.a(context, hashMap);
    }

    private String d(com.alipay.sdk.tid.b bVar) {
        String b2;
        Context context = b.b.a.f.a.a().f4274b;
        com.alipay.sdk.util.c a2 = com.alipay.sdk.util.c.a(context);
        if (TextUtils.isEmpty(this.f4232e)) {
            String b3 = j.b();
            String g2 = j.g();
            String l = j.l(context);
            String str = b.b.a.b.a.f4189b;
            this.f4232e = "Msp/9.2.1 (" + b3 + ";" + g2 + ";" + l + ";" + str.substring(0, str.indexOf("://")) + ";" + j.n(context) + ";" + Float.toString(new TextView(context).getTextSize());
        }
        String a3 = com.alipay.sdk.util.c.d(context).a();
        String o = j.o(context);
        String b4 = a2.b();
        String e2 = a2.e();
        Context context2 = b.b.a.f.a.a().f4274b;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(f4228a, 0);
        String string = sharedPreferences.getString(f4230c, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a().f5438b)) {
                String f2 = b.b.a.f.a.a().f();
                b2 = TextUtils.isEmpty(f2) ? f() : f2.substring(3, 18);
            } else {
                b2 = com.alipay.sdk.util.c.a(context2).b();
            }
            string = b2;
            sharedPreferences.edit().putString(f4230c, string).commit();
        }
        Context context3 = b.b.a.f.a.a().f4274b;
        SharedPreferences sharedPreferences2 = context3.getSharedPreferences(f4228a, 0);
        String string2 = sharedPreferences2.getString(f4229b, null);
        if (TextUtils.isEmpty(string2)) {
            string2 = TextUtils.isEmpty(com.alipay.sdk.tid.b.a().f5438b) ? f() : com.alipay.sdk.util.c.a(context3).e();
            sharedPreferences2.edit().putString(f4229b, string2).commit();
        }
        if (bVar != null) {
            this.f4234g = bVar.f5439c;
        }
        String replace = Build.MANUFACTURER.replace(";", " ");
        String replace2 = Build.MODEL.replace(";", " ");
        boolean e3 = b.b.a.f.a.e();
        String g3 = a2.g();
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo();
        String ssid = connectionInfo != null ? connectionInfo.getSSID() : ErrorContants.NET_ERROR;
        WifiInfo connectionInfo2 = ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo();
        String bssid = connectionInfo2 != null ? connectionInfo2.getBSSID() : "00";
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4232e);
        sb.append(";");
        sb.append(a3);
        sb.append(";");
        sb.append(o);
        sb.append(";");
        sb.append("1");
        sb.append(";");
        sb.append(b4);
        sb.append(";");
        sb.append(e2);
        sb.append(";");
        sb.append(this.f4234g);
        sb.append(";");
        sb.append(replace);
        sb.append(";");
        sb.append(replace2);
        sb.append(";");
        sb.append(e3);
        sb.append(";");
        sb.append(g3);
        sb.append(";");
        sb.append(b.b.a.f.b.a());
        sb.append(";");
        sb.append(this.f4233f);
        sb.append(";");
        sb.append(string);
        sb.append(";");
        sb.append(string2);
        sb.append(";");
        sb.append(ssid);
        sb.append(";");
        sb.append(bssid);
        if (bVar != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(b.b.a.b.b.f4200c, bVar.f5438b);
            hashMap.put(b.b.a.b.b.f4204g, b.b.a.f.a.a().f());
            String a4 = com.alipay.mobilesecuritysdk.b.a.a(context, hashMap);
            if (!TextUtils.isEmpty(a4)) {
                sb.append(";");
                sb.append(a4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    static String f() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(ErrorCode.PrivateError.LOAD_TIME_OUT) + 1000);
    }

    private static String g(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getSSID() : ErrorContants.NET_ERROR;
    }

    private String h() {
        return this.f4234g;
    }

    private static String i(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getBSSID() : "00";
    }

    private static String j() {
        return "1";
    }

    private static String k() {
        Context context = b.b.a.f.a.a().f4274b;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f4228a, 0);
        String string = sharedPreferences.getString(f4229b, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String f2 = TextUtils.isEmpty(com.alipay.sdk.tid.b.a().f5438b) ? f() : com.alipay.sdk.util.c.a(context).e();
        sharedPreferences.edit().putString(f4229b, f2).commit();
        return f2;
    }

    private static String l() {
        String b2;
        Context context = b.b.a.f.a.a().f4274b;
        SharedPreferences sharedPreferences = context.getSharedPreferences(f4228a, 0);
        String string = sharedPreferences.getString(f4230c, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a().f5438b)) {
            String f2 = b.b.a.f.a.a().f();
            b2 = TextUtils.isEmpty(f2) ? f() : f2.substring(3, 18);
        } else {
            b2 = com.alipay.sdk.util.c.a(context).b();
        }
        String str = b2;
        sharedPreferences.edit().putString(f4230c, str).commit();
        return str;
    }

    public final synchronized void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(b.b.a.f.a.a().f4274b).edit().putString(b.b.a.b.b.f4206i, str).commit();
        b.b.a.b.a.f4190c = str;
    }
}
