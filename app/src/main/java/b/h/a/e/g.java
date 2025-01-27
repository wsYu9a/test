package b.h.a.e;

import android.text.TextUtils;
import android.util.Base64;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class g {
    private static Map<String, String> q = new ConcurrentHashMap(16);

    /* renamed from: a, reason: collision with root package name */
    public static final String f4980a = a("T1BQTw==");

    /* renamed from: b, reason: collision with root package name */
    public static final String f4981b = a(com.cdo.oaps.ad.a.f6501c);

    /* renamed from: c, reason: collision with root package name */
    public static final String f4982c = a("T3Bwbw==");

    /* renamed from: d, reason: collision with root package name */
    public static final String f4983d = a("UmVhbG1l");

    /* renamed from: e, reason: collision with root package name */
    public static final String f4984e = a("cmVhbG1l");

    /* renamed from: f, reason: collision with root package name */
    public static final String f4985f = a("T25lUGx1cw==");

    /* renamed from: g, reason: collision with root package name */
    public static final String f4986g = a("b25lcGx1cw==");

    /* renamed from: h, reason: collision with root package name */
    public static final String f4987h = a("Q29sb3JPUw==");

    /* renamed from: i, reason: collision with root package name */
    public static final String f4988i = a("Q09MT1JPUw==");

    /* renamed from: j, reason: collision with root package name */
    public static final String f4989j = a("Y29sb3Jvcw==");
    public static final String k = a("Y29sb3JPUw==");
    public static final String l = a("Y29sb3I=");
    public static final String m = a("Q29sb3JCdWlsZA==");
    public static final String n = a("T3BsdXNPUw==");
    public static final String o = a("SHlkcm9nZW4gT1Mg");
    public static final String p = a("T3h5Z2VuIE9TIA==");

    private static String a(String str) {
        String str2 = q.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        String str3 = new String(Base64.decode(str.getBytes(), 0));
        q.put(str, str3);
        return str3;
    }
}
