package p3;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    public static String f29752a;

    public static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(f29752a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th2) {
                d.e(th2);
                str = "";
            }
            f29752a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return f29752a;
    }

    public static synchronized String b(n3.a aVar, Context context, String str, String str2) {
        String str3;
        synchronized (g.class) {
            try {
                try {
                    String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                    str3 = TextUtils.isEmpty(string) ? null : d3.e.a(a(context), string, str);
                    if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                        x2.a.i(aVar, x2.b.f31791m, x2.b.F, String.format("%s,%s", str, string));
                    }
                } catch (Exception e10) {
                    d.e(e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str3;
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z10;
        synchronized (g.class) {
            try {
                z10 = PreferenceManager.getDefaultSharedPreferences(context).contains(str);
            } catch (Throwable th2) {
                d.e(th2);
                z10 = false;
            }
        }
        return z10;
    }

    public static synchronized void d(Context context, String str) {
        synchronized (g.class) {
            try {
                PreferenceManager.getDefaultSharedPreferences(context).edit().remove(str).apply();
            } finally {
            }
        }
    }

    public static synchronized void e(n3.a aVar, Context context, String str, String str2) {
        synchronized (g.class) {
            try {
                String c10 = d3.e.c(a(context), str2, str);
                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(c10)) {
                    x2.a.i(aVar, x2.b.f31791m, x2.b.G, String.format("%s,%s", str, str2));
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, c10).apply();
            } catch (Throwable th2) {
                try {
                    d.e(th2);
                } finally {
                }
            }
        }
    }
}
