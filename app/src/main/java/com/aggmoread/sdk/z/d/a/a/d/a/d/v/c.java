package com.aggmoread.sdk.z.d.a.a.d.a.d.v;

import com.aggmoread.sdk.z.d.a.a.e.e;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInitCallback;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.model.SplashAdExtraData;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class c {

    /* renamed from: b */
    private static c f5749b;

    /* renamed from: a */
    private boolean f5750a = false;

    public static class a implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ b f5751a;

        public a(b bVar) {
            this.f5751a = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if ("onSuccess".equals(method.getName())) {
                e.b("AMHTAGKS", "onSuccess enter");
                this.f5751a.b();
                return null;
            }
            if (!"onFail".equals(method.getName())) {
                return null;
            }
            e.b("AMHTAGKS", "onFail enter code : " + objArr[0] + " , msg " + objArr[1]);
            this.f5751a.a();
            return null;
        }
    }

    public interface b {
        void a();

        void b();
    }

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f5749b == null) {
                    synchronized (c.class) {
                        try {
                            if (f5749b == null) {
                                f5749b = new c();
                            }
                        } finally {
                        }
                    }
                }
                cVar = f5749b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    public static void c() {
        a(KsAdSDK.class, null, "start", null, new Object[0]);
    }

    public void b(boolean z10) {
        this.f5750a = z10;
    }

    public KsScene.Builder a(KsScene.Builder builder) {
        if (builder != null) {
            try {
                Object newInstance = SplashAdExtraData.class.newInstance();
                a(SplashAdExtraData.class, newInstance, "setDisableShakeStatus", new Class[]{Boolean.TYPE}, Boolean.valueOf(b()));
                a(builder.getClass(), builder, "setSplashExtraData", new Class[]{SplashAdExtraData.class}, newInstance);
            } catch (Exception e10) {
                e.b("AMHTAGKS", "fill splash extra err " + e10);
            }
        }
        return builder;
    }

    public boolean b() {
        return this.f5750a;
    }

    private static Object a(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            e.b("AMHTAGKS", "method " + str);
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e10) {
            e.b("AMHTAGKS", "find method err " + e10);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static void a(SdkConfig.Builder builder, b bVar) {
        if (KsInitCallback.class != 0) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(KsInitCallback.class.getClassLoader(), new Class[]{KsInitCallback.class}, new a(bVar));
                e.b("AMHTAGKS", "set reward listener " + KsInitCallback.class);
                builder.getClass().getMethod("setStartCallback", KsInitCallback.class).invoke(builder, newProxyInstance);
            } catch (Exception e10) {
                e.b("AMHTAGKS", "err " + e10);
            }
        }
    }

    public static void a(boolean z10) {
        e.b("AMHTAGKS", "pr " + z10);
        try {
            KsAdSDK.setPersonalRecommend(z10);
        } catch (Exception e10) {
            e.b("AMHTAGKS", "pr e" + e10);
        }
    }
}
