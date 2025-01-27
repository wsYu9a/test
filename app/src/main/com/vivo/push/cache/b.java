package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.p;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private static volatile b f24973a;

    /* renamed from: b */
    private d f24974b;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f24973a == null) {
                    f24973a = new b();
                }
                bVar = f24973a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public final d a(Context context) {
        d dVar = this.f24974b;
        if (dVar != null) {
            return dVar;
        }
        try {
            Method method = ClientConfigManagerImpl.class.getMethod("getInstance", Context.class);
            p.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            d dVar2 = (d) method.invoke(null, context);
            this.f24974b = dVar2;
            return dVar2;
        } catch (Exception e10) {
            e10.printStackTrace();
            p.b("ConfigManagerFactory", "createConfig error", e10);
            return null;
        }
    }
}
