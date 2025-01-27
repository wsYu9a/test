package b.c.a.b;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* loaded from: classes.dex */
class c {

    /* renamed from: a */
    private static String f4297a = "A0";

    /* renamed from: b */
    private static int f4298b = 15;

    /* renamed from: c */
    private static String f4299c = "G0";

    /* renamed from: d */
    private static String f4300d = "null";

    /* renamed from: e */
    private static String f4301e = "unknown";

    /* renamed from: f */
    private static String f4302f = "0";

    c() {
    }

    static String a() {
        String substring = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date()).substring(0, 6);
        String str = substring + h();
        if (str.length() < f4298b) {
            str = (str + "123456789012345").substring(0, f4298b);
        }
        return b(m.p(str).replace(",", substring));
    }

    private static String b(String str) {
        int length = str.length();
        if (length >= 29) {
            return str.substring(0, 29);
        }
        StringBuilder sb = new StringBuilder(str);
        while (length < 29) {
            sb.append("0");
            length = sb.length();
        }
        return sb.toString();
    }

    public static boolean c(int i2) {
        return i2 == g.f4320a || i2 == g.f4323d;
    }

    public static boolean d(int i2) {
        return (i2 & 65280) != 0;
    }

    public static boolean e(int i2) {
        return (i2 & 16711680) != 0;
    }

    static boolean f(String str) {
        return str.startsWith(f4297a) || str.startsWith(f4299c);
    }

    static boolean g(String str) {
        return m.j(str) || f4301e.equalsIgnoreCase(str) || f4300d.equalsIgnoreCase(str) || f4302f.equalsIgnoreCase(str);
    }

    private static String h() {
        String valueOf = String.valueOf(Math.abs(UUID.randomUUID().toString().hashCode()));
        if (valueOf.length() < 9) {
            while (valueOf.length() < 9) {
                valueOf = valueOf + "0";
            }
        }
        return valueOf.substring(0, 9);
    }
}
