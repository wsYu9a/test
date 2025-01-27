package com.aggmoread.sdk.z.d.a.a.d.a.d.u.e;

import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class a implements InvocationHandler {

    /* renamed from: a */
    private InterfaceC0162a f5688a;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.e.a$a */
    public interface InterfaceC0162a {
        void a();

        void b();

        void onADClicked();

        void onADCloseOverlay();

        void onADExposure();

        void onADLeftApplication();

        void onADOpenOverlay();

        void onNoAD(AdError adError);
    }

    public a(InterfaceC0162a interfaceC0162a) {
        this.f5688a = interfaceC0162a;
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
            if (this.f5688a != null) {
                String name = method.getName();
                if ("onADReceive".equals(name)) {
                    this.f5688a.a();
                } else if ("onADExposure".equals(name)) {
                    this.f5688a.onADExposure();
                } else if ("onADClicked".equals(name)) {
                    this.f5688a.onADClicked();
                } else if ("onADClosed".equals(name)) {
                    this.f5688a.b();
                } else if ("onADLeftApplication".equals(name)) {
                    this.f5688a.onADLeftApplication();
                } else if ("onADOpenOverlay".equals(name)) {
                    this.f5688a.onADOpenOverlay();
                } else if ("onADCloseOverlay".equals(name)) {
                    this.f5688a.onADCloseOverlay();
                } else if ("onNoAD".equals(name)) {
                    this.f5688a.onNoAD((AdError) objArr[0]);
                }
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
