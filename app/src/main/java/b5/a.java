package b5;

@a5.b
@g
/* loaded from: classes2.dex */
public final class a {
    public static final byte A = 23;
    public static final byte B = 24;
    public static final byte C = 25;
    public static final byte D = 26;
    public static final byte E = 27;
    public static final byte F = 28;
    public static final byte G = 29;
    public static final byte H = 30;
    public static final byte I = 31;
    public static final byte J = 32;
    public static final byte K = 32;
    public static final byte L = Byte.MAX_VALUE;
    public static final char M = 0;
    public static final char N = 127;
    public static final char O = ' ';

    /* renamed from: a */
    public static final byte f1174a = 0;

    /* renamed from: b */
    public static final byte f1175b = 1;

    /* renamed from: c */
    public static final byte f1176c = 2;

    /* renamed from: d */
    public static final byte f1177d = 3;

    /* renamed from: e */
    public static final byte f1178e = 4;

    /* renamed from: f */
    public static final byte f1179f = 5;

    /* renamed from: g */
    public static final byte f1180g = 6;

    /* renamed from: h */
    public static final byte f1181h = 7;

    /* renamed from: i */
    public static final byte f1182i = 8;

    /* renamed from: j */
    public static final byte f1183j = 9;

    /* renamed from: k */
    public static final byte f1184k = 10;

    /* renamed from: l */
    public static final byte f1185l = 10;

    /* renamed from: m */
    public static final byte f1186m = 11;

    /* renamed from: n */
    public static final byte f1187n = 12;

    /* renamed from: o */
    public static final byte f1188o = 13;

    /* renamed from: p */
    public static final byte f1189p = 14;

    /* renamed from: q */
    public static final byte f1190q = 15;

    /* renamed from: r */
    public static final byte f1191r = 16;

    /* renamed from: s */
    public static final byte f1192s = 17;

    /* renamed from: t */
    public static final byte f1193t = 17;

    /* renamed from: u */
    public static final byte f1194u = 18;

    /* renamed from: v */
    public static final byte f1195v = 19;

    /* renamed from: w */
    public static final byte f1196w = 19;

    /* renamed from: x */
    public static final byte f1197x = 20;

    /* renamed from: y */
    public static final byte f1198y = 21;

    /* renamed from: z */
    public static final byte f1199z = 22;

    public static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        int b10;
        int length = charSequence.length();
        if (charSequence == charSequence2) {
            return true;
        }
        if (length != charSequence2.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = charSequence.charAt(i10);
            char charAt2 = charSequence2.charAt(i10);
            if (charAt != charAt2 && ((b10 = b(charAt)) >= 26 || b10 != b(charAt2))) {
                return false;
            }
        }
        return true;
    }

    public static int b(char c10) {
        return (char) ((c10 | O) - 97);
    }

    public static boolean c(char c10) {
        return c10 >= 'a' && c10 <= 'z';
    }

    public static boolean d(char c10) {
        return c10 >= 'A' && c10 <= 'Z';
    }

    public static char e(char c10) {
        return d(c10) ? (char) (c10 ^ O) : c10;
    }

    public static String f(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return g((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = e(charSequence.charAt(i10));
        }
        return String.valueOf(cArr);
    }

    public static String g(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (d(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (d(c10)) {
                        charArray[i10] = (char) (c10 ^ O);
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static char h(char c10) {
        return c(c10) ? (char) (c10 ^ O) : c10;
    }

    public static String i(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return j((String) charSequence);
        }
        int length = charSequence.length();
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = h(charSequence.charAt(i10));
        }
        return String.valueOf(cArr);
    }

    public static String j(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            if (c(str.charAt(i10))) {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (c(c10)) {
                        charArray[i10] = (char) (c10 ^ O);
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static String k(CharSequence charSequence, int i10, String str) {
        u.E(charSequence);
        int length = i10 - str.length();
        u.m(length >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", i10, str.length());
        int length2 = charSequence.length();
        String str2 = charSequence;
        if (length2 <= i10) {
            String charSequence2 = charSequence.toString();
            int length3 = charSequence2.length();
            str2 = charSequence2;
            if (length3 <= i10) {
                return charSequence2;
            }
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append((CharSequence) str2, 0, length);
        sb2.append(str);
        return sb2.toString();
    }
}
