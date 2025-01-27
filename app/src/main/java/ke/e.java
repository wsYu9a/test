package ke;

import android.os.Build;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a */
    public static final String f27803a = "Xiaomi";

    /* renamed from: b */
    public static final String f27804b = "HUAWEI";

    /* renamed from: c */
    public static final String f27805c = "HONOR";

    /* renamed from: d */
    public static final String f27806d = "OPPO";

    /* renamed from: e */
    public static final String f27807e = "vivo";

    /* renamed from: f */
    public static final String f27808f = "OnePlus";

    /* renamed from: g */
    public static final String f27809g = "realme";

    /* renamed from: h */
    public static final String f27810h = "Samsung";

    public static boolean a(String str) {
        return Build.MANUFACTURER.equalsIgnoreCase(str);
    }

    public static String b() {
        return c() ? "huawei" : j() ? f27807e : g() ? "oppo" : e() ? "xiaomi" : f() ? "onePlus" : h() ? f27809g : i() ? "samsung" : "others";
    }

    public static boolean c() {
        return a(f27804b);
    }

    public static boolean d() {
        return a(f27805c);
    }

    public static boolean e() {
        return a(f27803a);
    }

    public static boolean f() {
        return a(f27808f);
    }

    public static boolean g() {
        return a("OPPO");
    }

    public static boolean h() {
        return a(f27809g);
    }

    public static boolean i() {
        return a(f27810h);
    }

    public static boolean j() {
        return a(f27807e);
    }
}
