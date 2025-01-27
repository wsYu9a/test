package com.google.zxing.client.result;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a */
    private static final t[] f8274a = {new f(), new c(), new j(), new b(), new e0(), new e(), new f0(), new i(), new x(), new z(), new u(), new w(), new n(), new j0(), new d0(), new c0(), new p(), new s(), new l(), new h0()};

    /* renamed from: b */
    private static final Pattern f8275b = Pattern.compile("\\d+");

    /* renamed from: c */
    private static final Pattern f8276c = Pattern.compile("&");

    /* renamed from: d */
    private static final Pattern f8277d = Pattern.compile("=");

    /* renamed from: e */
    private static final String f8278e = "\ufeff";

    private static void a(CharSequence charSequence, Map<String, String> map) {
        String[] split = f8277d.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], p(split[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    private static int b(CharSequence charSequence, int i2) {
        int i3 = 0;
        for (int i4 = i2 - 1; i4 >= 0 && charSequence.charAt(i4) == '\\'; i4--) {
            i3++;
        }
        return i3;
    }

    protected static String c(com.google.zxing.k kVar) {
        String g2 = kVar.g();
        return g2.startsWith(f8278e) ? g2.substring(1) : g2;
    }

    protected static boolean d(CharSequence charSequence, int i2) {
        return charSequence != null && i2 > 0 && i2 == charSequence.length() && f8275b.matcher(charSequence).matches();
    }

    protected static boolean e(CharSequence charSequence, int i2, int i3) {
        int i4;
        return charSequence != null && i3 > 0 && charSequence.length() >= (i4 = i3 + i2) && f8275b.matcher(charSequence.subSequence(i2, i4)).matches();
    }

    static String[] f(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i2 = 0;
        while (i2 < length) {
            int indexOf = str2.indexOf(str, i2);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            ArrayList arrayList2 = arrayList;
            boolean z2 = true;
            int i3 = length2;
            while (z2) {
                int indexOf2 = str2.indexOf(c2, i3);
                if (indexOf2 < 0) {
                    i3 = str2.length();
                } else if (b(str2, indexOf2) % 2 != 0) {
                    i3 = indexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String o = o(str2.substring(length2, indexOf2));
                    if (z) {
                        o = o.trim();
                    }
                    if (!o.isEmpty()) {
                        arrayList2.add(o);
                    }
                    i3 = indexOf2 + 1;
                }
                z2 = false;
            }
            i2 = i3;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    static String g(String str, String str2, char c2, boolean z) {
        String[] f2 = f(str, str2, c2, z);
        if (f2 == null) {
            return null;
        }
        return f2[0];
    }

    protected static void h(String str, StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    protected static void i(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                sb.append('\n');
                sb.append(str);
            }
        }
    }

    protected static String[] j(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static int l(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    static Map<String, String> m(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        for (String str2 : f8276c.split(str.substring(indexOf + 1))) {
            a(str2, hashMap);
        }
        return hashMap;
    }

    public static q n(com.google.zxing.k kVar) {
        for (t tVar : f8274a) {
            q k = tVar.k(kVar);
            if (k != null) {
                return k;
            }
        }
        return new a0(kVar.g(), null);
    }

    protected static String o(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, indexOf);
        boolean z = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z || charAt != '\\') {
                sb.append(charAt);
                z = false;
            } else {
                z = true;
            }
            indexOf++;
        }
        return sb.toString();
    }

    static String p(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public abstract q k(com.google.zxing.k kVar);
}
