package j2;

import android.util.Log;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final String f27159a = "OpenId";

    /* renamed from: b */
    public static boolean f27160b = false;

    public static String a(Object obj, Object obj2) {
        if (obj == null) {
            obj = "";
        }
        if (obj2 == null) {
            obj2 = "";
        }
        return String.format("%s:%s", obj, obj2);
    }

    public static String b(String str, Object... objArr) {
        int i10 = 0;
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = "-";
        }
        sb2.append(String.format("[%s] ", str));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb2.append(a(objArr[i10], objArr[i11]));
                if (i11 < length - 1) {
                    sb2.append(",");
                }
                i10 += 2;
            }
            if (i10 == objArr.length - 1) {
                sb2.append(objArr[i10]);
            }
        }
        return sb2.toString();
    }

    public static void c(boolean z10) {
        Log.d(f27159a, "setDebug:" + z10);
        f27160b = z10;
    }

    public static void d(String str, Object... objArr) {
        if (f27160b) {
            Log.d(f27159a, b(str, objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (f27160b) {
            Log.e(f27159a, b(str, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        if (f27160b) {
            Log.i(f27159a, b(str, objArr));
        }
    }

    public static void g(String str, Object... objArr) {
        if (f27160b) {
            Log.w(f27159a, b(str, objArr));
        }
    }
}
