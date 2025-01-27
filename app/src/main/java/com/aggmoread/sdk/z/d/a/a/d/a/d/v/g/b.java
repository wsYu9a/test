package com.aggmoread.sdk.z.d.a.a.d.a.d.v.g;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f5788a;

    public interface a {
        void a(@Nullable List<KsFullScreenVideoAd> list);

        void b(@Nullable List<KsFullScreenVideoAd> list);

        void onError(int i10, String str);

        void onRequestResult(int i10);
    }

    public b(a aVar) {
        this.f5788a = aVar;
    }

    public KsLoadManager.FullScreenVideoAdListener a() {
        return (KsLoadManager.FullScreenVideoAdListener) Proxy.newProxyInstance(KsLoadManager.FullScreenVideoAdListener.class.getClassLoader(), new Class[]{KsLoadManager.FullScreenVideoAdListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f5788a == null) {
            return null;
        }
        if ("onError".equals(name)) {
            this.f5788a.onError(((Integer) objArr[0]).intValue(), (String) objArr[1]);
        } else if ("onFullScreenVideoResult".equals(name)) {
            a aVar = this.f5788a;
            Object obj2 = objArr[0];
            aVar.b(obj2 == null ? null : (List) obj2);
        } else if ("onRequestResult".equals(name)) {
            this.f5788a.onRequestResult(((Integer) objArr[0]).intValue());
        } else if ("onFullScreenVideoAdLoad".equals(name)) {
            a aVar2 = this.f5788a;
            Object obj3 = objArr[0];
            aVar2.a(obj3 == null ? null : (List) obj3);
        }
        return null;
    }
}
