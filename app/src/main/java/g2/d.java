package g2;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class d {
    public static synchronized void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            if (!t3.a.c(str)) {
                if (!t3.a.c(str2) && context != null) {
                    try {
                        String b10 = s3.c.b(s3.c.a(), str3);
                        HashMap hashMap = new HashMap();
                        hashMap.put(str2, b10);
                        e.b(context, str, hashMap);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }
}
