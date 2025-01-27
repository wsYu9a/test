package com.martian.ttbook.b.c.a.a.b.a.d.b0.e;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f15334a;

    public interface a {
        void a(@Nullable List<KsFullScreenVideoAd> list);

        void b(@Nullable List<KsFullScreenVideoAd> list);

        void onError(int i2, String str);

        void onRequestResult(int i2);
    }

    public b(a aVar) {
        this.f15334a = aVar;
    }

    public KsLoadManager.FullScreenVideoAdListener a() {
        return (KsLoadManager.FullScreenVideoAdListener) Proxy.newProxyInstance(KsLoadManager.FullScreenVideoAdListener.class.getClassLoader(), new Class[]{KsLoadManager.FullScreenVideoAdListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f15334a == null) {
            return null;
        }
        if ("onError".equals(name)) {
            this.f15334a.onError(((Integer) objArr[0]).intValue(), (String) objArr[1]);
        } else if ("onFullScreenVideoResult".equals(name)) {
            this.f15334a.b(objArr[0] == null ? null : (List) objArr[0]);
        } else if ("onRequestResult".equals(name)) {
            this.f15334a.onRequestResult(((Integer) objArr[0]).intValue());
        } else if ("onFullScreenVideoAdLoad".equals(name)) {
            this.f15334a.a(objArr[0] == null ? null : (List) objArr[0]);
        }
        return null;
    }
}
