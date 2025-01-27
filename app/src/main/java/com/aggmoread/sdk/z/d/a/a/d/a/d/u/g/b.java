package com.aggmoread.sdk.z.d.a.a.d.a.d.u.g;

import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f5699a;

    public interface a {
        void a(NativeExpressADView nativeExpressADView);

        void b(NativeExpressADView nativeExpressADView);

        void b(List<NativeExpressADView> list);

        void c(NativeExpressADView nativeExpressADView);

        void d(NativeExpressADView nativeExpressADView);

        void e(NativeExpressADView nativeExpressADView);

        void f(NativeExpressADView nativeExpressADView);

        void g(NativeExpressADView nativeExpressADView);

        void h(NativeExpressADView nativeExpressADView);

        void onNoAD(AdError adError);
    }

    public b(a aVar) {
        this.f5699a = aVar;
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
            if (this.f5699a != null) {
                String name = method.getName();
                Object obj2 = objArr[0];
                if ("onADLoaded".equals(name)) {
                    this.f5699a.b((List<NativeExpressADView>) obj2);
                } else if ("onRenderFail".equals(name)) {
                    this.f5699a.f((NativeExpressADView) obj2);
                } else if ("onRenderSuccess".equals(name)) {
                    this.f5699a.b((NativeExpressADView) obj2);
                } else if ("onADExposure".equals(name)) {
                    this.f5699a.c((NativeExpressADView) obj2);
                } else if ("onADClicked".equals(name)) {
                    this.f5699a.h((NativeExpressADView) obj2);
                } else if ("onADClosed".equals(name)) {
                    this.f5699a.a((NativeExpressADView) obj2);
                } else if ("onADLeftApplication".equals(name)) {
                    this.f5699a.e((NativeExpressADView) obj2);
                } else if ("onADOpenOverlay".equals(name)) {
                    this.f5699a.g((NativeExpressADView) obj2);
                } else if ("onADCloseOverlay".equals(name)) {
                    this.f5699a.d((NativeExpressADView) obj2);
                } else if ("onNoAD".equals(name)) {
                    this.f5699a.onNoAD((AdError) obj2);
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
