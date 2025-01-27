package p3;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    public static final String f29745a = "pref_trade_token";

    /* renamed from: b */
    public static final String f29746b = ";";

    /* renamed from: c */
    public static final String f29747c = "result={";

    /* renamed from: d */
    public static final String f29748d = "}";

    /* renamed from: e */
    public static final String f29749e = "trade_token=\"";

    /* renamed from: f */
    public static final String f29750f = "\"";

    /* renamed from: g */
    public static final String f29751g = "trade_token=";

    public static String a(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(";");
        for (int i10 = 0; i10 < split.length; i10++) {
            if (split[i10].startsWith(f29747c) && split[i10].endsWith(f29748d)) {
                String[] split2 = split[i10].substring(8, r3.length() - 1).split("&");
                int i11 = 0;
                while (true) {
                    if (i11 >= split2.length) {
                        break;
                    }
                    if (split2[i11].startsWith(f29749e) && split2[i11].endsWith("\"")) {
                        str2 = split2[i11].substring(13, r1.length() - 1);
                        break;
                    }
                    if (split2[i11].startsWith(f29751g)) {
                        str2 = split2[i11].substring(12);
                        break;
                    }
                    i11++;
                }
            }
        }
        return str2;
    }

    public static String b(n3.a aVar, Context context) {
        String b10 = g.b(aVar, context, f29745a, "");
        d.g(z2.a.A, "get trade token: " + b10);
        return b10;
    }

    public static void c(n3.a aVar, Context context, String str) {
        try {
            String a10 = a(str);
            d.g(z2.a.A, "trade token: " + a10);
            if (TextUtils.isEmpty(a10)) {
                return;
            }
            g.e(aVar, context, f29745a, a10);
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, x2.b.I, th2);
            d.e(th2);
        }
    }
}
