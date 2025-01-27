package b.b.a.c;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a */
    private static final String f4223a = "Msp-Param";

    public static e a() {
        a aVar = new a();
        aVar.f4218a = b.b.a.b.a.f4189b;
        aVar.f4219b = "com.alipay.mobilecashier";
        aVar.f4220c = "/device/findAccount";
        aVar.f4221d = "3.0.0";
        b.b.a.f.a a2 = b.b.a.f.a.a();
        com.alipay.sdk.tid.b a3 = com.alipay.sdk.tid.b.a();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(a3.f5438b)) {
                jSONObject.put(b.b.a.b.b.f4200c, a3.f5438b);
            }
            jSONObject.put(b.b.a.b.b.f4204g, a2.f());
            jSONObject.put(b.b.a.b.b.f4205h, b.b.a.b.a.f4191d);
            jSONObject.put(b.b.a.b.b.f4207j, a3.f5439c);
            jSONObject.put("imei", com.alipay.sdk.util.c.a(a2.f4274b).e());
            jSONObject.put("imsi", com.alipay.sdk.util.c.a(a2.f4274b).b());
        } catch (JSONException unused) {
        }
        return new e(aVar, jSONObject);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static b.b.a.c.e b(b.b.a.c.c r26, java.lang.String r27, org.json.JSONObject r28) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.b.a.c.b.b(b.b.a.c.c, java.lang.String, org.json.JSONObject):b.b.a.c.e");
    }

    private static e c(JSONObject jSONObject, boolean z) {
        a aVar = new a();
        aVar.f4218a = b.b.a.b.a.f4189b;
        aVar.f4219b = "com.alipay.mobilecashier";
        aVar.f4220c = "/cashier/main";
        aVar.f4221d = "4.0.2";
        if (jSONObject == null) {
            return null;
        }
        e eVar = new e(aVar, jSONObject);
        eVar.f4241g = z;
        return eVar;
    }

    private static String d(String str) {
        if (str.contains("biz_type")) {
            return j(str);
        }
        return null;
    }

    private static void e(c cVar, e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("&");
        if (split.length == 0) {
            return;
        }
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        for (String str6 : split) {
            if (TextUtils.isEmpty(str2)) {
                str2 = !str6.contains("biz_type") ? null : j(str6);
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = !str6.contains("biz_no") ? null : j(str6);
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = (!str6.contains("trade_no") || str6.startsWith("out_trade_no")) ? null : j(str6);
            }
            if (TextUtils.isEmpty(str5)) {
                str5 = !str6.contains("app_userid") ? null : j(str6);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            sb.append("biz_type=" + str2 + ";");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append("biz_no=" + str3 + ";");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append("trade_no=" + str4 + ";");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append("app_userid=" + str5 + ";");
        }
        if (sb.length() == 0) {
            return;
        }
        String sb2 = sb.toString();
        if (sb2.endsWith(";")) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        cVar.f4225b = new Header[]{new BasicHeader(f4223a, sb2)};
        eVar.f4239e = new WeakReference<>(cVar);
    }

    private static void f(c cVar, HttpResponse httpResponse) {
        Header[] headers = httpResponse.getHeaders(f4223a);
        if (cVar == null || headers.length <= 0) {
            return;
        }
        cVar.f4225b = headers;
    }

    public static byte[] g(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            byte[] bArr2 = new byte[4096];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr2, 0, 4096);
                if (read == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.flush();
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        return byteArray;
                    } catch (Exception unused) {
                        return byteArray;
                    }
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private static String h(String str) {
        if (str.contains("biz_no")) {
            return j(str);
        }
        return null;
    }

    private static String i(String str) {
        if (!str.contains("trade_no") || str.startsWith("out_trade_no")) {
            return null;
        }
        return j(str);
    }

    private static String j(String str) {
        String[] split = str.split("=");
        if (split.length <= 1) {
            return null;
        }
        String str2 = split[1];
        return str2.contains("\"") ? str2.replaceAll("\"", "") : str2;
    }

    private static String k(String str) {
        if (str.contains("app_userid")) {
            return j(str);
        }
        return null;
    }
}
