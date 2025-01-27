package com.martian.ttbook.b.c.a.a.d.a.d.x.d;

import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class a implements InvocationHandler {

    /* renamed from: a */
    private InterfaceC0347a f15605a;

    /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.d.a$a */
    public interface InterfaceC0347a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void onADClicked();

        void onADExposure();

        void onNoAD(AdError adError);
    }

    public a(InterfaceC0347a interfaceC0347a) {
        this.f15605a = interfaceC0347a;
    }

    public UnifiedBannerADListener a() {
        return (UnifiedBannerADListener) Proxy.newProxyInstance(UnifiedBannerADListener.class.getClassLoader(), new Class[]{UnifiedBannerADListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (this.f15605a != null) {
                String name = method.getName();
                if ("onADReceive".equals(name)) {
                    this.f15605a.b();
                } else if ("onADExposure".equals(name)) {
                    this.f15605a.onADExposure();
                } else if ("onADClicked".equals(name)) {
                    this.f15605a.onADClicked();
                } else if ("onADClosed".equals(name)) {
                    this.f15605a.c();
                } else if ("onADLeftApplication".equals(name)) {
                    this.f15605a.a();
                } else if ("onADOpenOverlay".equals(name)) {
                    this.f15605a.e();
                } else if ("onADCloseOverlay".equals(name)) {
                    this.f15605a.d();
                } else if ("onNoAD".equals(name)) {
                    this.f15605a.onNoAD((AdError) objArr[0]);
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
