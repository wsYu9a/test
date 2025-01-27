package b.h.a;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import b.h.a.d;
import b.h.a.g$b.a;
import com.oplus.log.env.oversea.AreaEnv;
import com.oplus.log.env.test.TestAreaEnv;
import java.net.URLEncoder;

/* loaded from: classes4.dex */
public class k {

    /* renamed from: a */
    private static final String f5038a = "b.h.a.k";

    /* renamed from: b */
    private static String f5039b = "";

    /* renamed from: c */
    private static String f5040c = "222%23";

    /* renamed from: d */
    private static String f5041d;

    private static String a() {
        String str;
        try {
            str = TestAreaEnv.getHostTest();
        } catch (Throwable unused) {
            str = "";
        }
        try {
            return c.j() ? str : b.h.a.e.b.e() ? b.h.a.e.b.g() ? AreaEnv.getIndiaHost() : AreaEnv.getSingaporeHost() : a.a();
        } catch (Throwable th) {
            if (!c.j()) {
                Log.e("NearX-HLog", "makeUploadUrl--> Don't find AreaEnv class");
                return "";
            }
            Log.e("NearX-HLog", "makeUploadUrl-->".concat(String.valueOf(th)));
            th.printStackTrace();
            return "";
        }
    }

    private static String b(d.b bVar) {
        return bVar == null ? "" : bVar.a();
    }

    private static String c(d.c cVar) {
        if (cVar == null) {
            return "";
        }
        return (cVar.a() == null ? "" : cVar.a()) + "/" + (cVar.b() == null ? "" : cVar.b()) + "/" + (cVar.c() != null ? cVar.c() : "");
    }

    private static String d(String str) {
        try {
            if (TextUtils.isEmpty(f5041d)) {
                f5041d = f5040c + b.h.a.e.a.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            return (TextUtils.isEmpty(f5041d) || f5040c.equals(f5041d)) ? str : f5041d;
        } catch (Exception e2) {
            if (!c.j()) {
                return str;
            }
            e2.printStackTrace();
            return str;
        }
    }

    public static String e(String str, String str2, d.b bVar, d.c cVar, String str3) {
        return ((a() + "/usertrace/log/business/config").replace("business", str) + "?subType=" + str2 + "&imei=" + h(b(bVar)) + "&openId=" + d(c(cVar)) + "&tracePkg=" + str3).replaceAll(" ", "_");
    }

    public static String f(String str, String str2, String str3, int i2, String str4, String str5, d.b bVar, d.c cVar, String str6) {
        StringBuilder sb = new StringBuilder((a() + "/usertrace/log/business/upload").replace("business", str));
        sb.append("?traceId=");
        sb.append(str2);
        sb.append("&businessVersion=");
        sb.append(b.h.a.e.b.f(b.h.a.e.b.a()));
        sb.append("&protocolVersion=3&errorCode=");
        sb.append(i2);
        sb.append("&subType=");
        sb.append(str5);
        sb.append("&brand=");
        sb.append(b.h.a.e.f.b());
        sb.append("&model=");
        sb.append(Build.MODEL);
        sb.append("&osVersion=");
        sb.append(b.h.a.e.f.c());
        sb.append("&romVersion=");
        sb.append(b.h.a.e.f.a());
        sb.append("&androidVersion=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("&imei=");
        sb.append(h(b(bVar)));
        sb.append("&openId=");
        sb.append(d(c(cVar)));
        sb.append("&tracePkg=");
        sb.append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=");
            sb.append(str4);
        }
        return sb.toString().replaceAll(" ", "_");
    }

    public static String g(String str, String str2, String str3, int i2, String str4, String str5, d.b bVar, d.c cVar, String str6, String str7, String str8, long j2, String str9, String str10, b bVar2) {
        String replace = (a() + "/usertrace/log/business/report").replace("business", str);
        String h2 = h(b(bVar));
        String d2 = d(c(cVar));
        String a2 = b.h.a.e.k.a(str2, str8, j2, i2, str5, h2, d2, str6, str7, str3, str4, str9, str10, bVar2);
        StringBuilder sb = new StringBuilder(replace);
        sb.append("?specificId=");
        sb.append(str2);
        sb.append("&reportReason=");
        sb.append(URLEncoder.encode(str8));
        sb.append("&program=");
        sb.append(str7);
        sb.append("&ts=");
        sb.append(j2);
        sb.append("&sign=");
        sb.append(a2);
        sb.append("&businessVersion=");
        sb.append(b.h.a.e.b.f(b.h.a.e.b.a()));
        sb.append("&protocolVersion=3&errorCode=");
        sb.append(i2);
        sb.append("&subType=");
        sb.append(str5);
        sb.append("&brand=");
        sb.append(b.h.a.e.f.b());
        sb.append("&model=");
        sb.append(Build.MODEL);
        sb.append("&osVersion=");
        sb.append(b.h.a.e.f.c());
        sb.append("&romVersion=");
        sb.append(b.h.a.e.f.a());
        sb.append("&androidVersion=");
        sb.append(Build.VERSION.RELEASE);
        sb.append("&imei=");
        sb.append(h2);
        sb.append("&openId=");
        sb.append(d2);
        sb.append("&tracePkg=");
        sb.append(str6);
        if (!TextUtils.isEmpty(str3)) {
            sb.append("&fileName=");
            sb.append(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("&errorMsg=");
            sb.append(str4);
        }
        String sb2 = sb.toString();
        bVar2.a("NearX-HLog", "签名后请求空格替换前参数: data: ".concat(String.valueOf(sb2)));
        String replaceAll = sb2.replaceAll(" ", "_");
        bVar2.a("NearX-HLog", "签名后请求空格替换后参数: data: ".concat(String.valueOf(replaceAll)));
        return replaceAll;
    }

    private static String h(String str) {
        try {
            if (TextUtils.isEmpty(f5039b)) {
                f5039b = f5040c + b.h.a.e.a.a("puwQbwBb9CMen91BMLD+UA==", str);
            }
            return (TextUtils.isEmpty(f5039b) || f5040c.equals(f5039b)) ? str : f5039b;
        } catch (Exception e2) {
            if (!c.j()) {
                return str;
            }
            e2.printStackTrace();
            return str;
        }
    }
}
