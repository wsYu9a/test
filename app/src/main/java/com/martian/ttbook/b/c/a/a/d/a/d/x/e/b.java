package com.martian.ttbook.b.c.a.a.d.a.d.x.e;

import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f15623a;

    public interface a {
        void a(List<NativeExpressADView> list);

        void d(NativeExpressADView nativeExpressADView);

        void e(NativeExpressADView nativeExpressADView);

        void k(NativeExpressADView nativeExpressADView);

        void m(NativeExpressADView nativeExpressADView);

        void o(NativeExpressADView nativeExpressADView);

        void onNoAD(AdError adError);

        void p(NativeExpressADView nativeExpressADView);

        void r(NativeExpressADView nativeExpressADView);

        void s(NativeExpressADView nativeExpressADView);
    }

    public b(a aVar) {
        this.f15623a = aVar;
    }

    public NativeExpressAD.NativeExpressADListener a() {
        return (NativeExpressAD.NativeExpressADListener) Proxy.newProxyInstance(NativeExpressAD.NativeExpressADListener.class.getClassLoader(), new Class[]{NativeExpressAD.NativeExpressADListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (this.f15623a != null) {
                String name = method.getName();
                Object obj2 = objArr[0];
                if ("onADLoaded".equals(name)) {
                    this.f15623a.a((List) obj2);
                } else if ("onRenderFail".equals(name)) {
                    this.f15623a.r((NativeExpressADView) obj2);
                } else if ("onRenderSuccess".equals(name)) {
                    this.f15623a.p((NativeExpressADView) obj2);
                } else if ("onADExposure".equals(name)) {
                    this.f15623a.m((NativeExpressADView) obj2);
                } else if ("onADClicked".equals(name)) {
                    this.f15623a.d((NativeExpressADView) obj2);
                } else if ("onADClosed".equals(name)) {
                    this.f15623a.k((NativeExpressADView) obj2);
                } else if ("onADLeftApplication".equals(name)) {
                    this.f15623a.s((NativeExpressADView) obj2);
                } else if ("onADOpenOverlay".equals(name)) {
                    this.f15623a.e((NativeExpressADView) obj2);
                } else if ("onADCloseOverlay".equals(name)) {
                    this.f15623a.o((NativeExpressADView) obj2);
                } else if ("onNoAD".equals(name)) {
                    this.f15623a.onNoAD((AdError) obj2);
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
