package b.d.c.a;

import android.content.Context;
import android.util.Log;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libsupport.e;
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

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    private static final String f4410a = "Set-Cookie";

    /* renamed from: b */
    private static final String f4411b = ";";

    /* renamed from: c */
    private static final String f4412c = "path";

    /* renamed from: d */
    private static final String f4413d = "expires";

    /* renamed from: e */
    private static final String f4414e = "EEE, dd-MMM-yyyy HH:mm:ss z";

    /* renamed from: f */
    private static final String f4415f = "; ";

    /* renamed from: g */
    private static final String f4416g = "Cookie";

    /* renamed from: h */
    private static final String f4417h = "martian_cache_cookie.json";

    /* renamed from: i */
    private static final char f4418i = '=';

    /* renamed from: j */
    private static final char f4419j = '.';
    private static final a k = new a();
    private Context m;
    private Map<String, Map<String, Map<String, String>>> l = new HashMap();
    private final DateFormat n = new SimpleDateFormat(f4414e, Locale.US);

    /* renamed from: b.d.c.a.a$a */
    /* loaded from: classes2.dex */
    class C0014a extends com.google.gson.b.a<Map<String, Map<String, Map<String, String>>>> {
        C0014a() {
        }
    }

    private boolean a(String cookiePath, String targetPath) {
        if (cookiePath == null || cookiePath.equals("/")) {
            return true;
        }
        return targetPath.regionMatches(0, cookiePath, 0, cookiePath.length());
    }

    private String b(String host) {
        return host.indexOf(46) != host.lastIndexOf(46) ? host.substring(host.indexOf(46) + 1) : host;
    }

    public static a c() {
        return k;
    }

    private boolean f(String cookieExpires) {
        if (cookieExpires == null) {
            return true;
        }
        try {
            return new Date().compareTo(this.n.parse(cookieExpires)) <= 0;
        } catch (ParseException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void g() {
        try {
            Context context = this.m;
            if (context != null) {
                String B = e.B(context, f4417h);
                Log.e("LOAD COOKIE", B);
                this.l = (Map) GsonUtils.b().fromJson(B, new C0014a().getType());
            }
        } catch (Exception unused) {
            this.l = new HashMap();
        }
    }

    public static void h(String[] args) {
        a aVar = new a();
        try {
            URL url = new URL("http://www.hccp.org/test/cookieTest.jsp");
            URLConnection openConnection = url.openConnection();
            openConnection.connect();
            aVar.k(openConnection);
            System.out.println(aVar);
            aVar.j(url.openConnection());
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private boolean i() {
        try {
            if (this.m == null || this.l == null) {
                return false;
            }
            String json = GsonUtils.b().toJson(this.l);
            Log.e("PERSIST COOKIE", json);
            e.E(this.m, f4417h, json);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean d(URL url) {
        String b2 = b(url.getHost());
        Map<String, Map<String, String>> map = this.l.get(b2);
        if (map == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            if (!f(map.get(str).get(f4413d))) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == map.size()) {
            this.l.remove(b2);
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                map.remove((String) it.next());
            }
        }
        return arrayList.isEmpty();
    }

    public void e(Context context) {
        this.m = context;
        g();
    }

    public boolean j(URLConnection conn) throws IOException {
        URL url = conn.getURL();
        String b2 = b(url.getHost());
        String path = url.getPath();
        Map<String, Map<String, String>> map = this.l.get(b2);
        if (map == null) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Map<String, String> map2 = map.get(next);
            if (a(map2.get("path"), path) && f(map2.get(f4413d))) {
                sb.append(next);
                sb.append("=");
                sb.append(map2.get(next));
                if (it.hasNext()) {
                    sb.append(f4415f);
                }
            }
        }
        try {
            conn.setRequestProperty(f4416g, sb.toString());
            return true;
        } catch (IllegalStateException unused) {
            Log.e("CookieManager", "Illegal State! Cookies cannot be set on a URLConnection that is already connected. Only call setCookies(java.net.URLConnection) AFTER calling java.net.URLConnection.connect().");
            return false;
        }
    }

    public void k(URLConnection conn) throws IOException {
        Map<String, Map<String, String>> map;
        String b2 = b(conn.getURL().getHost());
        if (this.l.containsKey(b2)) {
            map = this.l.get(b2);
        } else {
            HashMap hashMap = new HashMap();
            this.l.put(b2, hashMap);
            map = hashMap;
        }
        int i2 = 1;
        boolean z = false;
        while (true) {
            String headerFieldKey = conn.getHeaderFieldKey(i2);
            if (headerFieldKey == null) {
                break;
            }
            if (headerFieldKey.equalsIgnoreCase(f4410a)) {
                HashMap hashMap2 = new HashMap();
                Log.e("SET_COOKIE", conn.getHeaderField(i2));
                StringTokenizer stringTokenizer = new StringTokenizer(conn.getHeaderField(i2), f4411b);
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
                z = true;
            }
            i2++;
        }
        if (z) {
            i();
        }
    }

    public String toString() {
        return this.l.toString();
    }
}
