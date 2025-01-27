package com.martian.ttbook.b.c.a.a.b.a.d.b0.g;

import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f15350a;

    public interface a {
        void b(@Nullable List<KsRewardVideoAd> list);

        void onError(int i2, String str);

        void onRequestResult(int i2);

        void q(@Nullable List<KsRewardVideoAd> list);
    }

    public b(a aVar) {
        this.f15350a = aVar;
    }

    public KsLoadManager.RewardVideoAdListener a() {
        return (KsLoadManager.RewardVideoAdListener) Proxy.newProxyInstance(KsLoadManager.RewardVideoAdListener.class.getClassLoader(), new Class[]{KsLoadManager.RewardVideoAdListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f15350a == null) {
            return null;
        }
        if ("onError".equals(name)) {
            this.f15350a.onError(((Integer) objArr[0]).intValue(), (String) objArr[1]);
        } else if ("onRewardVideoResult".equals(name)) {
            this.f15350a.b(objArr[0] == null ? null : (List) objArr[0]);
        } else if ("onRequestResult".equals(name)) {
            this.f15350a.onRequestResult(((Integer) objArr[0]).intValue());
        } else if ("onRewardVideoAdLoad".equals(name)) {
            this.f15350a.q(objArr[0] == null ? null : (List) objArr[0]);
        }
        return null;
    }
}
