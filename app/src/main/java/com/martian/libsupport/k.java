package com.martian.libsupport;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.baidu.mobads.sdk.internal.bu;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class k {
    public static String a(String buff) {
        String replaceAll = buff.replaceAll("(?i)[^a-zA-Z0-9一-龥]", "");
        char[] charArray = replaceAll.toCharArray();
        for (int i2 = 0; i2 < replaceAll.length(); i2++) {
            if (charArray[i2] < 255) {
                charArray[i2] = ' ';
            }
        }
        return String.copyValueOf(charArray).trim();
    }

    public static String b(String content) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < content.length(); i2++) {
            char charAt = content.charAt(i2);
            if (charAt != ' ' && charAt != 12288 && charAt != '\n' && charAt != '\r') {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static int c(String str1, String str2) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, str1.length() + 1, str2.length() + 1);
        for (int i2 = 0; i2 <= str1.length(); i2++) {
            iArr[i2][0] = i2;
        }
        for (int i3 = 1; i3 <= str2.length(); i3++) {
            iArr[0][i3] = i3;
        }
        for (int i4 = 1; i4 <= str1.length(); i4++) {
            for (int i5 = 1; i5 <= str2.length(); i5++) {
                int i6 = i4 - 1;
                int i7 = i5 - 1;
                iArr[i4][i5] = s(iArr[i6][i5] + 1, iArr[i4][i7] + 1, iArr[i6][i7] + (str1.charAt(i6) == str2.charAt(i7) ? 0 : 1));
            }
        }
        return iArr[str1.length()][str2.length()];
    }

    public static float d(String str1, String str2) {
        if (p(str1) || p(str2)) {
            return 0.0f;
        }
        if (str1.equalsIgnoreCase(str2)) {
            return 1.0f;
        }
        return (r0 - c(str1, str2)) / Math.max(str1.length(), str2.length());
    }

    public static boolean e(String str) {
        if (p(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str).find();
    }

    public static String f(String url, String charset) {
        int lastIndexOf;
        if (!p(url) && (lastIndexOf = url.lastIndexOf("=")) != -1 && lastIndexOf != url.length() - 1) {
            int i2 = lastIndexOf + 1;
            try {
                return url.substring(0, i2) + g(url.substring(i2), charset);
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return url;
    }

    public static String g(String url, String charset) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 != -1) {
            int indexOf = url.indexOf("+", i2);
            if (indexOf == -1) {
                sb.append(URLEncoder.encode(url.substring(i2), charset));
                return sb.toString();
            }
            sb.append(URLEncoder.encode(url.substring(i2, indexOf), charset) + "+");
            i2 = indexOf + 1;
        }
        return sb.toString();
    }

    public static String h(String url, String key) {
        return i(url, key, "?", "&", "=");
    }

    public static String i(String url, String key, String fsep, String psep, String ksep) {
        int lastIndexOf;
        if (url == null || (lastIndexOf = url.lastIndexOf(fsep)) == url.length() - 1) {
            return "";
        }
        if (lastIndexOf != -1) {
            url = psep + url.substring(lastIndexOf + 1);
        }
        String str = psep + key + ksep;
        int indexOf = url.indexOf(psep + key + ksep);
        if (indexOf == -1) {
            return "";
        }
        int indexOf2 = url.indexOf(psep, indexOf + 1);
        if (indexOf2 == -1) {
            indexOf2 = url.length();
        }
        return url.substring(indexOf + str.length(), indexOf2);
    }

    public static String j(String keyword) {
        if (keyword == null) {
            return "";
        }
        try {
            return URLEncoder.encode(keyword.replaceAll(",", "").replaceAll(":", "").replaceAll("!", "").replaceAll("，", "").replaceAll("：", "").replaceAll("！", ""), "UTF8").replace(' ', '+');
        } catch (Exception unused) {
            return "";
        }
    }

    public static String k(String src, int size) {
        int max;
        if (p(src) || src.length() <= (max = Math.max(size, 7))) {
            return src;
        }
        int i2 = max - 3;
        return src.substring(0, i2 - (i2 / 2)) + "..." + src.substring((src.length() - r0) - 1);
    }

    public static SpannableString l(Context context, String name, String keyword, int color) {
        SpannableString spannableString = new SpannableString(name);
        int indexOf = name.indexOf(keyword);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, color)), indexOf, keyword.length() + indexOf, 33);
        return spannableString;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m(java.lang.String r11) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 0
            r2 = 0
        L7:
            int r3 = r11.length()
            r4 = 12288(0x3000, float:1.7219E-41)
            r5 = 160(0xa0, float:2.24E-43)
            r6 = 32
            r7 = 10
            r8 = 13
            if (r2 >= r3) goto L28
            char r3 = r11.charAt(r2)
            if (r3 == r6) goto L25
            if (r3 == r5) goto L25
            if (r3 == r4) goto L25
            if (r3 == r7) goto L25
            if (r3 != r8) goto L28
        L25:
            int r2 = r2 + 1
            goto L7
        L28:
            java.lang.String r3 = "\u3000\u3000"
            r0.append(r3)
            int r3 = r11.indexOf(r7, r2)
            r9 = -1
            r10 = 1
            if (r3 != r9) goto L67
            int r3 = r11.indexOf(r8, r2)
            if (r3 != r9) goto L75
            java.lang.String r11 = r11.substring(r2)
            r0.append(r11)
            int r11 = r0.length()
            int r11 = r11 - r10
        L47:
            if (r11 < 0) goto L5a
            char r1 = r0.charAt(r11)
            if (r1 == r6) goto L57
            if (r1 == r5) goto L57
            if (r1 == r7) goto L57
            if (r1 == r4) goto L57
            if (r1 != r8) goto L5a
        L57:
            int r11 = r11 + (-1)
            goto L47
        L5a:
            int r11 = r11 + r10
            int r1 = r0.length()
            r0.delete(r11, r1)
            java.lang.String r11 = r0.toString()
            return r11
        L67:
            if (r3 <= r2) goto L75
            int r4 = r3 + (-1)
            char r4 = r11.charAt(r4)
            if (r4 != r8) goto L75
            int r3 = r3 + (-1)
            r4 = 1
            goto L76
        L75:
            r4 = 0
        L76:
            java.lang.String r2 = r11.substring(r2, r3)
            r0.append(r2)
            java.lang.String r2 = "\n"
            r0.append(r2)
            if (r4 == 0) goto L86
            int r3 = r3 + 1
        L86:
            int r2 = r3 + 1
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsupport.k.m(java.lang.String):java.lang.String");
    }

    public static boolean n(String str1, String str2) {
        if (str1 == null) {
            str1 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str1.equals(str2);
    }

    public static boolean o(String str1, String str2) {
        if (str1 == null) {
            str1 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str1.equalsIgnoreCase(str2);
    }

    public static boolean p(String str) {
        return str == null || str.equals("");
    }

    private static boolean q(char c2) {
        return c2 == '.' || c2 == ',' || c2 == '!' || c2 == ':' || c2 == '?' || c2 == '\'' || c2 == '\"' || c2 == '~' || c2 == ';' || c2 == 12290 || c2 == 65292 || c2 == 65281 || c2 == 65306 || c2 == 65311 || c2 == 8216 || c2 == 8217 || c2 == 8220 || c2 == 8221 || c2 == 65374 || c2 == 65307 || c2 == '\n' || c2 == '\r';
    }

    public static String r(String string) {
        if (p(string) || !l.p()) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(bu.f5659a).digest(string.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i2));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    private static int s(int a2, int b2, int c2) {
        return Math.min(Math.min(a2, b2), c2);
    }

    public static Hashtable<String, String> t(String url, String fsep, String psep, String ksep) {
        int lastIndexOf;
        if (url == null || (lastIndexOf = url.lastIndexOf(fsep)) == url.length() - 1) {
            return null;
        }
        if (lastIndexOf != -1) {
            url = url.substring(lastIndexOf + 1);
        }
        String[] split = url.split(psep);
        Hashtable<String, String> hashtable = new Hashtable<>();
        for (String str : split) {
            int indexOf = str.indexOf(ksep);
            if (indexOf != -1 && indexOf != str.length() - 1) {
                hashtable.put(str.substring(0, indexOf), str.substring(indexOf + ksep.length()));
            }
        }
        return hashtable;
    }

    public static List<Integer> u(String text) {
        ArrayList arrayList = new ArrayList(32);
        boolean z = false;
        for (int i2 = 0; i2 < text.length(); i2++) {
            if (q(text.charAt(i2))) {
                z = true;
            } else if (z) {
                arrayList.add(Integer.valueOf(i2));
                z = false;
            }
        }
        arrayList.add(Integer.valueOf(text.length()));
        return arrayList;
    }

    public static String v(String content) {
        return !p(content) ? content.replaceAll("[\r\n\\s\u3000]", "") : content;
    }

    public static String w(String content, int length) {
        return (p(content) || length <= 0) ? "" : length > content.length() ? content : content.substring(0, length - 1);
    }

    public static String x(String content) {
        if (content == null) {
            return null;
        }
        int i2 = 0;
        int length = content.length() - 1;
        while (i2 <= length && (content.charAt(i2) <= ' ' || content.charAt(i2) == 12288)) {
            i2++;
        }
        int i3 = length;
        while (i3 >= i2 && (content.charAt(i3) <= ' ' || content.charAt(i3) == 12288)) {
            i3--;
        }
        return (i2 == 0 && i3 == length) ? content : content.substring(i2, i3 + 1);
    }

    public static String y(String str) {
        return p(str) ? "" : str.replaceAll("[，,：:！!\\s]", "").toLowerCase();
    }
}
