package y5;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class t {

    /* renamed from: a */
    public static final t[] f33052a = {new f(), new c(), new j(), new b(), new e0(), new e(), new f0(), new i(), new x(), new z(), new u(), new w(), new n(), new j0(), new d0(), new c0(), new p(), new s(), new l(), new h0()};

    /* renamed from: b */
    public static final Pattern f33053b = Pattern.compile("\\d+");

    /* renamed from: c */
    public static final Pattern f33054c = Pattern.compile("&");

    /* renamed from: d */
    public static final Pattern f33055d = Pattern.compile("=");

    /* renamed from: e */
    public static final String f33056e = "\ufeff";

    public static void a(CharSequence charSequence, Map<String, String> map) {
        String[] split = f33055d.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], p(split[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    public static int b(CharSequence charSequence, int i10) {
        int i11 = 0;
        for (int i12 = i10 - 1; i12 >= 0 && charSequence.charAt(i12) == '\\'; i12--) {
            i11++;
        }
        return i11;
    }

    public static String c(t5.k kVar) {
        String g10 = kVar.g();
        return g10.startsWith(f33056e) ? g10.substring(1) : g10;
    }

    public static boolean d(CharSequence charSequence, int i10) {
        return charSequence != null && i10 > 0 && i10 == charSequence.length() && f33053b.matcher(charSequence).matches();
    }

    public static boolean e(CharSequence charSequence, int i10, int i11) {
        int i12;
        return charSequence != null && i11 > 0 && charSequence.length() >= (i12 = i11 + i10) && f33053b.matcher(charSequence.subSequence(i10, i12)).matches();
    }

    public static String[] f(String str, String str2, char c10, boolean z10) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i10 = 0;
        while (i10 < length) {
            int indexOf = str2.indexOf(str, i10);
            if (indexOf < 0) {
                break;
            }
            int length2 = indexOf + str.length();
            ArrayList arrayList2 = arrayList;
            boolean z11 = true;
            int i11 = length2;
            while (z11) {
                int indexOf2 = str2.indexOf(c10, i11);
                if (indexOf2 < 0) {
                    i11 = str2.length();
                } else if (b(str2, indexOf2) % 2 != 0) {
                    i11 = indexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String o10 = o(str2.substring(length2, indexOf2));
                    if (z10) {
                        o10 = o10.trim();
                    }
                    if (!o10.isEmpty()) {
                        arrayList2.add(o10);
                    }
                    i11 = indexOf2 + 1;
                }
                z11 = false;
            }
            i10 = i11;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String g(String str, String str2, char c10, boolean z10) {
        String[] f10 = f(str, str2, c10, z10);
        if (f10 == null) {
            return null;
        }
        return f10[0];
    }

    public static void h(String str, StringBuilder sb2) {
        if (str != null) {
            sb2.append('\n');
            sb2.append(str);
        }
    }

    public static void i(String[] strArr, StringBuilder sb2) {
        if (strArr != null) {
            for (String str : strArr) {
                sb2.append('\n');
                sb2.append(str);
            }
        }
    }

    public static String[] j(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    public static int l(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        if (c10 >= 'a' && c10 <= 'f') {
            return c10 - 'W';
        }
        if (c10 < 'A' || c10 > 'F') {
            return -1;
        }
        return c10 - '7';
    }

    public static Map<String, String> m(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        for (String str2 : f33054c.split(str.substring(indexOf + 1))) {
            a(str2, hashMap);
        }
        return hashMap;
    }

    public static q n(t5.k kVar) {
        for (t tVar : f33052a) {
            q k10 = tVar.k(kVar);
            if (k10 != null) {
                return k10;
            }
        }
        return new a0(kVar.g(), null);
    }

    public static String o(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length - 1);
        sb2.append(str.toCharArray(), 0, indexOf);
        boolean z10 = false;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (z10 || charAt != '\\') {
                sb2.append(charAt);
                z10 = false;
            } else {
                z10 = true;
            }
            indexOf++;
        }
        return sb2.toString();
    }

    public static String p(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public abstract q k(t5.k kVar);
}
