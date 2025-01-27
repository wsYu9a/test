package b.c.a.b;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static String f4307a = "clientId";

    /* renamed from: b, reason: collision with root package name */
    private static String f4308b = "e3c9997fed83a974";

    /* renamed from: c, reason: collision with root package name */
    private static volatile SharedPreferences f4309c;

    public static String a(Context context) {
        b(context);
        return f4309c.getString(f4307a, null);
    }

    private static void b(Context context) {
        if (f4309c == null) {
            synchronized (e.class) {
                if (f4309c == null) {
                    f4309c = context.getSharedPreferences(f4308b, 0);
                }
            }
        }
    }

    public static void c(Context context, String str) {
        b(context);
        f4309c.edit().putString(f4307a, str).apply();
    }
}
