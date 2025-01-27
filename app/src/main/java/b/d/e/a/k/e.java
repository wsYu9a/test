package b.d.e.a.k;

import android.content.Context;
import android.text.TextUtils;
import com.martian.ttbook.sdk.client.AdClientContext;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a */
    static final String f4550a = "e";

    /* renamed from: b */
    static final ConcurrentHashMap<String, d> f4551b = new ConcurrentHashMap<>();

    public static <R> R a(Class<? extends d> cls) {
        if (!d()) {
            throw new com.martian.ttbook.a.i.a("must call SDK init(...) method");
        }
        String e2 = e(cls);
        if (TextUtils.isEmpty(e2)) {
            throw new com.martian.ttbook.a.i.a("serviceName is null");
        }
        R r = (R) f4551b.get(e2);
        if (r != null) {
            return r;
        }
        throw new com.martian.ttbook.a.i.a("service(" + e2 + ") not found");
    }

    public static void b(Context context) {
        c cVar = new c();
        cVar.a(context);
        c(b.class, cVar);
    }

    public static void c(Class<? extends d> cls, d dVar) {
        if (!d()) {
            throw new com.martian.ttbook.a.i.a("must call init(...) method");
        }
        b.d.e.a.j.c.h(f4550a, "putService proxy serviceImpl = " + dVar.getClass().getName());
        f4551b.put(e(cls), (d) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new b.d.e.a.b(cls, dVar)));
    }

    static boolean d() {
        return AdClientContext.isRealy();
    }

    public static String e(Class<?> cls) {
        return cls.getName();
    }
}
