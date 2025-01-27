package ba;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.martian.libmars.widget.FoldedTextView;
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

/* loaded from: classes3.dex */
public class l {
    public static String A(String str, int i10) {
        return (q(str) || i10 <= 0) ? "" : i10 > str.length() ? str : str.substring(0, i10 - 1);
    }

    public static String B(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() - 1;
        int i10 = 0;
        while (i10 <= length && (str.charAt(i10) <= ' ' || str.charAt(i10) == 12288)) {
            i10++;
        }
        int i11 = length;
        while (i11 >= i10 && (str.charAt(i11) <= ' ' || str.charAt(i11) == 12288)) {
            i11--;
        }
        return (i10 == 0 && i11 == length) ? str : str.substring(i10, i11 + 1);
    }

    public static String C(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        int length = str.length() - 1;
        int i10 = 0;
        while (i10 <= length && r(str.charAt(i10))) {
            i10++;
        }
        while (length >= i10 && r(str.charAt(length))) {
            length--;
        }
        return str.substring(i10, length + 1);
    }

    public static String D(String str) {
        return q(str) ? "" : str.replaceAll("[，,：:！!\\s]", "").toLowerCase();
    }

    public static String a(String str) {
        String replaceAll = str.replaceAll("(?i)[^a-zA-Z0-9一-龥]", "");
        char[] charArray = replaceAll.toCharArray();
        for (int i10 = 0; i10 < replaceAll.length(); i10++) {
            if (charArray[i10] < 255) {
                charArray[i10] = b5.a.O;
            }
        }
        return String.copyValueOf(charArray).trim();
    }

    public static String b(String str) {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt != ' ' && charAt != 12288 && charAt != '\n' && charAt != '\r') {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public static int c(String str, String str2) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, str.length() + 1, str2.length() + 1);
        for (int i10 = 0; i10 <= str.length(); i10++) {
            iArr[i10][0] = i10;
        }
        for (int i11 = 1; i11 <= str2.length(); i11++) {
            iArr[0][i11] = i11;
        }
        for (int i12 = 1; i12 <= str.length(); i12++) {
            for (int i13 = 1; i13 <= str2.length(); i13++) {
                int[] iArr2 = iArr[i12];
                int i14 = i12 - 1;
                int[] iArr3 = iArr[i14];
                int i15 = i13 - 1;
                iArr2[i13] = t(iArr3[i13] + 1, iArr2[i15] + 1, iArr3[i15] + (str.charAt(i14) == str2.charAt(i15) ? 0 : 1));
            }
        }
        return iArr[str.length()][str2.length()];
    }

    public static float d(String str, String str2) {
        if (q(str) || q(str2)) {
            return 0.0f;
        }
        if (str.equalsIgnoreCase(str2)) {
            return 1.0f;
        }
        return (r0 - c(str, str2)) / Math.max(str.length(), str2.length());
    }

    public static boolean e(String str) {
        if (q(str)) {
            return false;
        }
        return Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str).find();
    }

    public static void f(Context context, CharSequence charSequence) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData newPlainText = ClipData.newPlainText(TTDownloadField.TT_LABEL, charSequence);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(newPlainText);
        }
    }

    public static String g(String str, String str2) {
        if (q(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf("=");
        if (lastIndexOf != -1 && lastIndexOf != str.length() - 1) {
            int i10 = lastIndexOf + 1;
            try {
                return str.substring(0, i10) + h(str.substring(i10), str2);
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        return str;
    }

    public static String h(String str, String str2) throws UnsupportedEncodingException {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        while (i10 != -1) {
            int indexOf = str.indexOf("+", i10);
            if (indexOf == -1) {
                sb2.append(URLEncoder.encode(str.substring(i10), str2));
                return sb2.toString();
            }
            sb2.append(URLEncoder.encode(str.substring(i10, indexOf), str2) + "+");
            i10 = indexOf + 1;
        }
        return sb2.toString();
    }

    public static String i(String str, String str2) {
        return j(str, str2, "?", "&", "=");
    }

    public static String j(String str, String str2, String str3, String str4, String str5) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(str3)) == str.length() - 1) {
            return "";
        }
        if (lastIndexOf != -1) {
            str = str4 + str.substring(lastIndexOf + 1);
        }
        String str6 = str4 + str2 + str5;
        int indexOf = str.indexOf(str4 + str2 + str5);
        if (indexOf == -1) {
            return "";
        }
        int indexOf2 = str.indexOf(str4, indexOf + 1);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring(indexOf + str6.length(), indexOf2);
    }

    public static String k(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str.replaceAll(",", "").replaceAll(":", "").replaceAll("!", "").replaceAll("，", "").replaceAll("：", "").replaceAll("！", ""), z5.k.f33694e).replace(b5.a.O, '+');
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String l(String str, int i10) {
        if (q(str)) {
            return str;
        }
        int max = Math.max(i10, 7);
        if (str.length() <= max) {
            return str;
        }
        int i11 = max - 3;
        return str.substring(0, i11 - (i11 / 2)) + FoldedTextView.f12585y + str.substring((str.length() - r0) - 1);
    }

    public static SpannableString m(Context context, String str, String str2, int i10) {
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.indexOf(str2);
        if (indexOf >= 0) {
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i10)), indexOf, str2.length() + indexOf, 33);
        }
        return spannableString;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String n(java.lang.String r11) {
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
            if (r3 != r9) goto L69
            int r3 = r11.indexOf(r8, r2)
            if (r3 != r9) goto L67
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
            r4 = 0
            goto L76
        L69:
            if (r3 <= r2) goto L67
            int r4 = r3 + (-1)
            char r4 = r11.charAt(r4)
            if (r4 != r8) goto L67
            int r3 = r3 + (-1)
            r4 = 1
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
        throw new UnsupportedOperationException("Method not decompiled: ba.l.n(java.lang.String):java.lang.String");
    }

    public static boolean o(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str.equals(str2);
    }

    public static boolean p(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean q(String str) {
        return str == null || str.equals("");
    }

    public static boolean r(char c10) {
        return c10 == '.' || c10 == ',' || c10 == '!' || c10 == ':' || c10 == '-' || c10 == '?' || c10 == '\'' || c10 == '\"' || c10 == '~' || c10 == 12288 || c10 == ' ' || c10 == ';' || c10 == 12290 || c10 == 65292 || c10 == 65281 || c10 == 65306 || c10 == 65311 || c10 == 8216 || c10 == 8217 || c10 == 8220 || c10 == 8221 || c10 == 65374 || c10 == 65307 || c10 == '\n' || c10 == '\r';
    }

    public static String s(String str) {
        if (q(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b10 : digest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            throw new RuntimeException("Huh, MD5 should be supported?", e10);
        }
    }

    public static int t(int i10, int i11, int i12) {
        return Math.min(Math.min(i10, i11), i12);
    }

    public static Hashtable<String, String> u(String str, String str2, String str3, String str4) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(str2)) == str.length() - 1) {
            return null;
        }
        if (lastIndexOf != -1) {
            str = str.substring(lastIndexOf + 1);
        }
        String[] split = str.split(str3);
        Hashtable<String, String> hashtable = new Hashtable<>();
        for (String str5 : split) {
            int indexOf = str5.indexOf(str4);
            if (indexOf != -1 && indexOf != str5.length() - 1) {
                hashtable.put(str5.substring(0, indexOf), str5.substring(indexOf + str4.length()));
            }
        }
        return hashtable;
    }

    public static List<Integer> v(String str) {
        return w(str, 0);
    }

    public static List<Integer> w(String str, int i10) {
        ArrayList arrayList = new ArrayList(32);
        arrayList.add(Integer.valueOf(i10));
        boolean z10 = false;
        while (i10 < str.length()) {
            if (r(str.charAt(i10))) {
                z10 = true;
            } else if (z10) {
                arrayList.add(Integer.valueOf(i10));
                z10 = false;
            }
            i10++;
        }
        arrayList.add(Integer.valueOf(str.length()));
        return arrayList;
    }

    public static String x(String str, int i10) {
        int i11 = 0;
        if (!TextUtils.isEmpty(str)) {
            int i12 = i10;
            boolean z10 = false;
            while (true) {
                if (i12 >= str.length()) {
                    break;
                }
                if (r(str.charAt(i12))) {
                    z10 = true;
                } else if (z10) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
        }
        return (i10 >= i11 || i10 <= 0) ? "" : str.substring(i10, i11 - 1);
    }

    public static String y(String str) {
        return !q(str) ? str.replaceAll("[\r\n\\s\u3000]", "") : str;
    }

    public static String z(String str) {
        return !q(str) ? str.replaceAll("[ \\t\\u3000]", "").trim() : str;
    }
}
