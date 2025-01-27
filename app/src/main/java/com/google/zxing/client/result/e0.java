package com.google.zxing.client.result;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class e0 extends t {

    /* renamed from: f */
    private static final Pattern f8220f = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: g */
    private static final Pattern f8221g = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: h */
    private static final Pattern f8222h = Pattern.compile("\r\n[ \t]");

    /* renamed from: i */
    private static final Pattern f8223i = Pattern.compile("\\\\[nN]");

    /* renamed from: j */
    private static final Pattern f8224j = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern k = Pattern.compile("=");
    private static final Pattern l = Pattern.compile(";");
    private static final Pattern m = Pattern.compile("(?<!\\\\);+");
    private static final Pattern n = Pattern.compile(",");
    private static final Pattern o = Pattern.compile("[;,]");

    private static String[] A(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            int i2 = 1;
            while (true) {
                if (i2 >= list.size()) {
                    str = null;
                    break;
                }
                str = list.get(i2);
                int indexOf = str.indexOf(61);
                if (indexOf >= 0) {
                    if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                        str = str.substring(indexOf + 1);
                        break;
                    }
                    i2++;
                }
            }
            arrayList.add(str);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static String q(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 != '\n' && charAt2 != '\r') {
                if (charAt2 != '=') {
                    w(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (i2 < length - 2 && (charAt = charSequence.charAt(i2 + 1)) != '\r' && charAt != '\n') {
                    i2 += 2;
                    char charAt3 = charSequence.charAt(i2);
                    int l2 = t.l(charAt);
                    int l3 = t.l(charAt3);
                    if (l2 >= 0 && l3 >= 0) {
                        byteArrayOutputStream.write((l2 << 4) + l3);
                    }
                }
            }
            i2++;
        }
        w(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void r(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < 4 && (indexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, indexOf);
                    i2++;
                    i3 = indexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                v(strArr, 3, sb);
                v(strArr, 1, sb);
                v(strArr, 2, sb);
                v(strArr, 0, sb);
                v(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static boolean s(CharSequence charSequence) {
        return charSequence == null || f8221g.matcher(charSequence).matches();
    }

    static List<String> t(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> u = u(charSequence, str, z, z2);
        if (u == null || u.isEmpty()) {
            return null;
        }
        return u.get(0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00c8, code lost:
    
        r4 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.util.List<java.util.List<java.lang.String>> u(java.lang.CharSequence r16, java.lang.String r17, boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.result.e0.u(java.lang.CharSequence, java.lang.String, boolean, boolean):java.util.List");
    }

    private static void v(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] == null || strArr[i2].isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i2]);
    }

    private static void w(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
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
            sb.append(str2);
        }
    }

    private static String y(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] z(Collection<List<String>> collection) {
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

    @Override // com.google.zxing.client.result.t
    /* renamed from: x */
    public d k(com.google.zxing.k kVar) {
        String c2 = t.c(kVar);
        Matcher matcher = f8220f.matcher(c2);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> u = u("FN", c2, true, false);
        if (u == null) {
            u = u("N", c2, true, false);
            r(u);
        }
        List<String> t = t("NICKNAME", c2, true, false);
        String[] split = t == null ? null : n.split(t.get(0));
        List<List<String>> u2 = u("TEL", c2, true, false);
        List<List<String>> u3 = u("EMAIL", c2, true, false);
        List<String> t2 = t("NOTE", c2, false, false);
        List<List<String>> u4 = u("ADR", c2, true, true);
        List<String> t3 = t("ORG", c2, true, true);
        List<String> t4 = t("BDAY", c2, true, false);
        List<String> list = (t4 == null || s(t4.get(0))) ? t4 : null;
        List<String> t5 = t("TITLE", c2, true, false);
        List<List<String>> u5 = u("URL", c2, true, false);
        List<String> t6 = t("IMPP", c2, true, false);
        List<String> t7 = t("GEO", c2, true, false);
        String[] split2 = t7 == null ? null : o.split(t7.get(0));
        return new d(z(u), split, null, z(u2), A(u2), z(u3), A(u3), y(t6), y(t2), z(u4), A(u4), y(t3), y(list), y(t5), z(u5), (split2 == null || split2.length == 2) ? split2 : null);
    }
}
