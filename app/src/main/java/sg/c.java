package sg;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static String f30664a;

    public static String a() {
        if (!TextUtils.isEmpty(f30664a)) {
            return f30664a;
        }
        hg.b i10 = hg.c.c().i();
        if (i10 == null) {
            return "";
        }
        String g10 = TextUtils.isEmpty(i10.c()) ? g(hg.c.c().e()) : i10.c();
        String b10 = TextUtils.isEmpty(i10.e()) ? b(hg.c.c().e()) : i10.e();
        if (TextUtils.isEmpty(g10) || TextUtils.isEmpty(b10)) {
            return "";
        }
        f30664a = g10 + ";" + b10 + ";Android;" + Build.VERSION.RELEASE + ";" + Build.MODEL;
        if (a.f30663a) {
            a.a("TANX_EXPOSE_UTIL", "getUserAgent: mUserAgent = " + f30664a);
        }
        return f30664a;
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e10) {
            a.a("TANX_EXPOSE_UTIL", "getVersionName: exception" + e10.getMessage());
            return "";
        }
    }

    public static String c(String str) {
        try {
            return String.format("%032x", new BigInteger(1, MessageDigest.getInstance("MD5").digest(str.getBytes())));
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str, JSONObject jSONObject) {
        if (str != null && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    str = str.replace(next, optString);
                }
            }
        }
        return str;
    }

    public static String e(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new JSONObject(map).toString();
    }

    public static Map<String, Object> f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (!TextUtils.isEmpty(next) && opt != null) {
                hashMap.put(next, opt);
            }
        }
        return hashMap;
    }

    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageName();
        } catch (Exception e10) {
            a.a("TANX_EXPOSE_UTIL", "getVersionName: exception" + e10.getMessage());
            return "";
        }
    }
}
