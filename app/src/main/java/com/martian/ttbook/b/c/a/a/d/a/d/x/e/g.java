package com.martian.ttbook.b.c.a.a.d.a.d.x.e;

import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes4.dex */
public class g implements InvocationHandler {

    /* renamed from: a */
    private a f15633a;

    public interface a {
        void a(List<NativeUnifiedADData> list);

        void onNoAD(AdError adError);
    }

    public g(a aVar) {
        this.f15633a = aVar;
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
            if (this.f15633a != null) {
                String name = method.getName();
                Object obj2 = objArr[0];
                if ("onADLoaded".equals(name)) {
                    this.f15633a.a((List) obj2);
                } else if ("onNoAD".equals(name)) {
                    this.f15633a.onNoAD((AdError) obj2);
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
