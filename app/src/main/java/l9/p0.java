package l9;

import android.util.Log;
import com.martian.libmars.common.ConfigSingleton;

/* loaded from: classes3.dex */
public class p0 {
    public static void a(Object obj, String str) {
        c(obj.getClass().getSimpleName(), str);
    }

    public static void b(String str) {
        c("ooo", str);
    }

    public static void c(String str, String str2) {
        if (ConfigSingleton.D().B0()) {
            Log.d(str, str2);
        }
    }

    public static void d(Object obj, String str) {
        e(obj.getClass().getSimpleName(), str);
    }

    public static void e(String str, String str2) {
        Log.e(str, str2);
    }
}
