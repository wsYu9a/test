package p3;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a */
    public static final String f29756a = "resultStatus";

    /* renamed from: b */
    public static final String f29757b = "memo";

    /* renamed from: c */
    public static final String f29758c = "result";

    public static String a(String str, String str2) {
        try {
            Matcher matcher = Pattern.compile("(^|;)" + str2 + "=\\{([^}]*?)\\}").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (Throwable th2) {
            d.e(th2);
        }
        return "?";
    }

    public static Map<String, String> b() {
        com.alipay.sdk.m.j.c b10 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.CANCELED.b());
        HashMap hashMap = new HashMap();
        hashMap.put(f29756a, Integer.toString(b10.b()));
        hashMap.put(f29757b, b10.a());
        hashMap.put(f29758c, "");
        return hashMap;
    }

    public static Map<String, String> c(String str) {
        String[] split = str.split(";");
        HashMap hashMap = new HashMap();
        for (String str2 : split) {
            String substring = str2.substring(0, str2.indexOf("={"));
            hashMap.put(substring, e(str2, substring));
        }
        return hashMap;
    }

    public static Map<String, String> d(n3.a aVar, String str) {
        Map<String, String> b10 = b();
        try {
            return c(str);
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, x2.b.f31799q, th2);
            return b10;
        }
    }

    public static String e(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(f.f29748d));
    }
}
