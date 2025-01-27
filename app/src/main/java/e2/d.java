package e2;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a */
    public static final Map<String, a> f25591a = new ConcurrentHashMap();

    public static class a {

        /* renamed from: a */
        public String f25592a;

        /* renamed from: b */
        public long f25593b;

        /* renamed from: c */
        public long f25594c;
    }

    public static String a(String str) {
        a aVar;
        String str2;
        Map<String, a> map = f25591a;
        if (map == null || (aVar = map.get(str)) == null) {
            return null;
        }
        if (System.currentTimeMillis() - aVar.f25593b < aVar.f25594c && (str2 = aVar.f25592a) != null) {
            return str2;
        }
        map.remove(str);
        return null;
    }

    public static void b(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Map<String, a> map = f25591a;
        a aVar = map.get(str);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.f25592a = str2;
        aVar.f25594c = 86400000L;
        aVar.f25593b = System.currentTimeMillis();
        map.put(str, aVar);
    }
}
