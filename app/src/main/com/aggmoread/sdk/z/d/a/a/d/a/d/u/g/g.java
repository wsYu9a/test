package com.aggmoread.sdk.z.d.a.a.d.a.d.u.g;

import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes.dex */
public class g implements InvocationHandler {

    /* renamed from: a */
    private a f5717a;

    public interface a {
        void b(List<NativeUnifiedADData> list);

        void onNoAD(AdError adError);
    }

    public g(a aVar) {
        this.f5717a = aVar;
    }

    public NativeADUnifiedListener a() {
        return (NativeADUnifiedListener) Proxy.newProxyInstance(NativeADUnifiedListener.class.getClassLoader(), new Class[]{NativeADUnifiedListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (this.f5717a != null) {
                String name = method.getName();
                Object obj2 = objArr[0];
                if ("onADLoaded".equals(name)) {
                    this.f5717a.b((List) obj2);
                } else if ("onNoAD".equals(name)) {
                    this.f5717a.onNoAD((AdError) obj2);
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
