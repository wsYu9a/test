package u3;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import j3.c;
import org.json.JSONObject;
import p3.d;

/* loaded from: classes.dex */
public class b {
    public static a a(Context context, o3.a aVar) {
        if (aVar == null || aVar.n()) {
            return null;
        }
        return new a(aVar.i(), aVar.h(), aVar.j().longValue());
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        n3.b.e().b(context);
    }

    public static a c(Context context) throws Exception {
        try {
            h3.b a10 = new c().a(n3.a.w(), context);
            if (a10 != null) {
                JSONObject jSONObject = new JSONObject(a10.a());
                o3.a a11 = o3.a.a(context);
                String optString = jSONObject.optString("tid");
                String string = jSONObject.getString(o3.a.f29031j);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(string)) {
                    a11.c(optString, string);
                }
                return a(context, a11);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void d(Context context) {
        o3.a.a(context).b();
    }

    public static String e(Context context) {
        b(context);
        return com.alipay.sdk.m.u.c.c(context).d();
    }

    public static String f(Context context) {
        b(context);
        return com.alipay.sdk.m.u.c.c(context).e();
    }

    public static synchronized String g(Context context) {
        String a10;
        synchronized (b.class) {
            try {
                a k10 = k(context);
                a10 = a.d(k10) ? "" : k10.a();
            } finally {
            }
        }
        return a10;
    }

    public static String h(Context context) {
        b(context);
        b3.b.e();
        return b3.b.j();
    }

    public static String i(Context context) {
        b(context);
        b3.b.e();
        return b3.b.k();
    }

    public static a j(Context context) {
        o3.a a10 = o3.a.a(context);
        if (a10.m()) {
            return null;
        }
        return new a(a10.i(), a10.h(), a10.j().longValue());
    }

    public static synchronized a k(Context context) {
        synchronized (b.class) {
            d.g(z2.a.A, "load_create_tid");
            b(context);
            a l10 = l(context);
            if (a.d(l10)) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return null;
                }
                try {
                    l10 = c(context);
                } catch (Throwable unused) {
                }
            }
            return l10;
        }
    }

    public static a l(Context context) {
        b(context);
        a a10 = a(context, o3.a.a(context));
        if (a10 == null) {
            d.g(z2.a.A, "load_tid null");
        }
        return a10;
    }

    public static boolean m(Context context) throws Exception {
        a aVar;
        d.g(z2.a.A, "reset_tid");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Exception("Must be called on worker thread");
        }
        b(context);
        d(context);
        try {
            aVar = c(context);
        } catch (Throwable unused) {
            aVar = null;
        }
        return !a.d(aVar);
    }
}
