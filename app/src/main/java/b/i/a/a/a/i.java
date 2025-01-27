package b.i.a.a.a;

/* loaded from: classes4.dex */
public class i {
    public static int a(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            i2 = (i2 * 31) + c2;
        }
        return i2;
    }

    public static boolean b(String str) {
        return str == null || str.length() <= 0;
    }
}
