package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.p;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a */
    private static volatile b f30946a;

    /* renamed from: b */
    private d f30947b;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f30946a == null) {
                f30946a = new b();
            }
            bVar = f30946a;
        }
        return bVar;
    }

    public final d a(Context context) {
        d dVar = this.f30947b;
        if (dVar != null) {
            return dVar;
        }
        try {
            Method method = Class.forName("com.vivo.push.cache.ClientConfigManagerImpl").getMethod("getInstance", Context.class);
            p.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            d dVar2 = (d) method.invoke(null, context);
            this.f30947b = dVar2;
            return dVar2;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
