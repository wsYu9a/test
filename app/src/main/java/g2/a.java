package g2;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {
    public static String a(Context context, String str, String str2) {
        String a10;
        synchronized (a.class) {
            String str3 = null;
            if (context != null) {
                if (!t3.a.c(str) && !t3.a.c(str2)) {
                    try {
                        a10 = e.a(context, str, str2, "");
                    } catch (Throwable unused) {
                    }
                    if (t3.a.c(a10)) {
                        return null;
                    }
                    str3 = s3.c.e(s3.c.a(), a10);
                    return str3;
                }
            }
            return null;
        }
    }

    public static void b(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            try {
                if (t3.a.c(str) || t3.a.c(str2) || context == null) {
                    return;
                }
                try {
                    String b10 = s3.c.b(s3.c.a(), str3);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, b10);
                    e.b(context, str, hashMap);
                } catch (Throwable unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
