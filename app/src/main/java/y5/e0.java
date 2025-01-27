package y5;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class e0 extends t {

    /* renamed from: f */
    public static final Pattern f32980f = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: g */
    public static final Pattern f32981g = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: h */
    public static final Pattern f32982h = Pattern.compile("\r\n[ \t]");

    /* renamed from: i */
    public static final Pattern f32983i = Pattern.compile("\\\\[nN]");

    /* renamed from: j */
    public static final Pattern f32984j = Pattern.compile("\\\\([,;\\\\])");

    /* renamed from: k */
    public static final Pattern f32985k = Pattern.compile("=");

    /* renamed from: l */
    public static final Pattern f32986l = Pattern.compile(";");

    /* renamed from: m */
    public static final Pattern f32987m = Pattern.compile("(?<!\\\\);+");

    /* renamed from: n */
    public static final Pattern f32988n = Pattern.compile(",");

    /* renamed from: o */
    public static final Pattern f32989o = Pattern.compile("[;,]");

    public static String[] A(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            int i10 = 1;
            while (true) {
                if (i10 >= list.size()) {
                    str = null;
                    break;
                }
                str = list.get(i10);
                int indexOf = str.indexOf(61);
                if (indexOf >= 0) {
                    if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                        str = str.substring(indexOf + 1);
                        break;
                    }
                    i10++;
                }
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    public static String q(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb2 = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i10 = 0;
        while (i10 < length) {
            char charAt2 = charSequence.charAt(i10);
            if (charAt2 != '\n' && charAt2 != '\r') {
                if (charAt2 != '=') {
                    w(byteArrayOutputStream, str, sb2);
                    sb2.append(charAt2);
                } else if (i10 < length - 2 && (charAt = charSequence.charAt(i10 + 1)) != '\r' && charAt != '\n') {
                    i10 += 2;
                    char charAt3 = charSequence.charAt(i10);
                    int l10 = t.l(charAt);
                    int l11 = t.l(charAt3);
                    if (l10 >= 0 && l11 >= 0) {
                        byteArrayOutputStream.write((l10 << 4) + l11);
                    }
                }
            }
            i10++;
        }
        w(byteArrayOutputStream, str, sb2);
        return sb2.toString();
    }

    public static void r(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i10 = 0;
                int i11 = 0;
                while (i10 < 4 && (indexOf = str.indexOf(59, i11)) >= 0) {
                    strArr[i10] = str.substring(i11, indexOf);
                    i10++;
                    i11 = indexOf + 1;
                }
                strArr[i10] = str.substring(i11);
                StringBuilder sb2 = new StringBuilder(100);
                v(strArr, 3, sb2);
                v(strArr, 1, sb2);
                v(strArr, 2, sb2);
                v(strArr, 0, sb2);
                v(strArr, 4, sb2);
                list.set(0, sb2.toString().trim());
            }
        }
    }

    public static boolean s(CharSequence charSequence) {
        return charSequence == null || f32981g.matcher(charSequence).matches();
    }

    public static List<String> t(CharSequence charSequence, String str, boolean z10, boolean z11) {
        List<List<String>> u10 = u(charSequence, str, z10, z11);
        if (u10 == null || u10.isEmpty()) {
            return null;
        }
        return u10.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c8, code lost:
    
        r4 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.util.List<java.lang.String>> u(java.lang.CharSequence r16, java.lang.String r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y5.e0.u(java.lang.CharSequence, java.lang.String, boolean, boolean):java.util.List");
    }

    public static void v(String[] strArr, int i10, StringBuilder sb2) {
        String str = strArr[i10];
        if (str == null || str.isEmpty()) {
            return;
        }
        if (sb2.length() > 0) {
            sb2.append(b5.a.O);
        }
        sb2.append(strArr[i10]);
    }

    public static void w(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb2) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, Charset.forName("UTF-8"));
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, Charset.forName("UTF-8"));
                }
            }
            byteArrayOutputStream.reset();
            sb2.append(str2);
        }
    }

    public static String y(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static String[] z(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<List<String>> it = collection.iterator();
        while (it.hasNext()) {
            String str = it.next().get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    @Override // y5.t
    /* renamed from: x */
    public d k(t5.k kVar) {
        String c10 = t.c(kVar);
        Matcher matcher = f32980f.matcher(c10);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> u10 = u("FN", c10, true, false);
        if (u10 == null) {
            u10 = u("N", c10, true, false);
            r(u10);
        }
        List<String> t10 = t("NICKNAME", c10, true, false);
        String[] split = t10 == null ? null : f32988n.split(t10.get(0));
        List<List<String>> u11 = u("TEL", c10, true, false);
        List<List<String>> u12 = u("EMAIL", c10, true, false);
        List<String> t11 = t("NOTE", c10, false, false);
        List<List<String>> u13 = u("ADR", c10, true, true);
        List<String> t12 = t("ORG", c10, true, true);
        List<String> t13 = t("BDAY", c10, true, false);
        List<String> list = (t13 == null || s(t13.get(0))) ? t13 : null;
        List<String> t14 = t("TITLE", c10, true, false);
        List<List<String>> u14 = u("URL", c10, true, false);
        List<String> t15 = t("IMPP", c10, true, false);
        List<String> t16 = t("GEO", c10, true, false);
        String[] split2 = t16 == null ? null : f32989o.split(t16.get(0));
        return new d(z(u10), split, null, z(u11), A(u11), z(u12), A(u12), y(t15), y(t11), z(u13), A(u13), y(t12), y(list), y(t14), z(u14), (split2 == null || split2.length == 2) ? split2 : null);
    }
}
