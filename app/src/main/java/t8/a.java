package t8;

import android.content.Context;
import android.util.Log;
import ba.g;
import com.google.gson.reflect.TypeToken;
import com.martian.libcomm.utils.GsonUtils;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: d */
    public static final String f30749d = "Set-Cookie";

    /* renamed from: e */
    public static final String f30750e = ";";

    /* renamed from: f */
    public static final String f30751f = "path";

    /* renamed from: g */
    public static final String f30752g = "expires";

    /* renamed from: h */
    public static final String f30753h = "EEE, dd-MMM-yyyy HH:mm:ss z";

    /* renamed from: i */
    public static final String f30754i = "; ";

    /* renamed from: j */
    public static final String f30755j = "Cookie";

    /* renamed from: k */
    public static final String f30756k = "martian_cache_cookie.json";

    /* renamed from: l */
    public static final char f30757l = '=';

    /* renamed from: m */
    public static final char f30758m = '.';

    /* renamed from: n */
    public static final a f30759n = new a();

    /* renamed from: b */
    public Context f30761b;

    /* renamed from: a */
    public Map<String, Map<String, Map<String, String>>> f30760a = new HashMap();

    /* renamed from: c */
    public final DateFormat f30762c = new SimpleDateFormat(f30753h, Locale.US);

    /* renamed from: t8.a$a */
    public class C0788a extends TypeToken<Map<String, Map<String, Map<String, String>>>> {
        public C0788a() {
        }
    }

    public static a c() {
        return f30759n;
    }

    public static void h(String[] strArr) {
        a aVar = new a();
        try {
            URL url = new URL("http://www.hccp.org/test/cookieTest.jsp");
            URLConnection openConnection = url.openConnection();
            openConnection.connect();
            aVar.k(openConnection);
            System.out.println(aVar);
            aVar.j(url.openConnection());
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public final boolean a(String str, String str2) {
        if (str == null || str.equals("/")) {
            return true;
        }
        return str2.regionMatches(0, str, 0, str.length());
    }

    public final String b(String str) {
        return str.indexOf(46) != str.lastIndexOf(46) ? str.substring(str.indexOf(46) + 1) : str;
    }

    public boolean d(URL url) {
        String b10 = b(url.getHost());
        Map<String, Map<String, String>> map = this.f30760a.get(b10);
        if (map == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            if (!f(map.get(str).get(f30752g))) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == map.size()) {
            this.f30760a.remove(b10);
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                map.remove((String) it.next());
            }
        }
        return arrayList.isEmpty();
    }

    public void e(Context context) {
        this.f30761b = context;
        g();
    }

    public final boolean f(String str) {
        if (str == null) {
            return true;
        }
        try {
            return new Date().compareTo(this.f30762c.parse(str)) <= 0;
        } catch (ParseException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final void g() {
        try {
            Context context = this.f30761b;
            if (context != null) {
                this.f30760a = (Map) GsonUtils.b().fromJson(g.B(context, f30756k), new C0788a().getType());
            }
        } catch (Exception unused) {
            this.f30760a = new HashMap();
        }
    }

    public final boolean i() {
        try {
            if (this.f30761b == null || this.f30760a == null) {
                return false;
            }
            String json = GsonUtils.b().toJson(this.f30760a);
            Log.e("PERSIST COOKIE", json);
            g.F(this.f30761b, f30756k, json);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean j(URLConnection uRLConnection) throws IOException {
        URL url = uRLConnection.getURL();
        String b10 = b(url.getHost());
        String path = url.getPath();
        Map<String, Map<String, String>> map = this.f30760a.get(b10);
        if (map == null) {
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Map<String, String> map2 = map.get(next);
            if (a(map2.get(f30751f), path) && f(map2.get(f30752g))) {
                sb2.append(next);
                sb2.append("=");
                sb2.append(map2.get(next));
                if (it.hasNext()) {
                    sb2.append(f30754i);
                }
            }
        }
        try {
            uRLConnection.setRequestProperty("Cookie", sb2.toString());
            return true;
        } catch (IllegalStateException unused) {
            Log.e("CookieManager", "Illegal State! Cookies cannot be set on a URLConnection that is already connected. Only call setCookies(java.net.URLConnection) AFTER calling java.net.URLConnection.connect().");
            return false;
        }
    }

    public void k(URLConnection uRLConnection) throws IOException {
        Map<String, Map<String, String>> map;
        String b10 = b(uRLConnection.getURL().getHost());
        if (this.f30760a.containsKey(b10)) {
            map = this.f30760a.get(b10);
        } else {
            HashMap hashMap = new HashMap();
            this.f30760a.put(b10, hashMap);
            map = hashMap;
        }
        int i10 = 1;
        boolean z10 = false;
        while (true) {
            String headerFieldKey = uRLConnection.getHeaderFieldKey(i10);
            if (headerFieldKey == null) {
                break;
            }
            if (headerFieldKey.equalsIgnoreCase("Set-Cookie")) {
                HashMap hashMap2 = new HashMap();
                Log.e("SET_COOKIE", uRLConnection.getHeaderField(i10));
                StringTokenizer stringTokenizer = new StringTokenizer(uRLConnection.getHeaderField(i10), ";");
                if (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    int indexOf = nextToken.indexOf(61);
                    if (indexOf != -1 && indexOf != nextToken.length() - 1) {
                        String trim = nextToken.substring(0, indexOf).trim();
                        String substring = nextToken.substring(indexOf + 1);
                        map.put(trim, hashMap2);
                        hashMap2.put(trim, substring);
                    }
                }
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken2 = stringTokenizer.nextToken();
                    int indexOf2 = nextToken2.indexOf(61);
                    if (indexOf2 != -1 && indexOf2 != nextToken2.length() - 1) {
                        hashMap2.put(nextToken2.substring(0, indexOf2).toLowerCase().trim(), nextToken2.substring(indexOf2 + 1));
                    }
                }
                z10 = true;
            }
            i10++;
        }
        if (z10) {
            i();
        }
    }

    public String toString() {
        return this.f30760a.toString();
    }
}
