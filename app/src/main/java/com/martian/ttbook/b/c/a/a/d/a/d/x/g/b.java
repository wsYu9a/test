package com.martian.ttbook.b.c.a.a.d.a.d.x.g;

import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f15652a;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void onADClicked();

        void onADExposure();

        void onNoAD(AdError adError);

        void onVideoCached();
    }

    public b(a aVar) {
        this.f15652a = aVar;
    }

    public UnifiedInterstitialADListener a() {
        return (UnifiedInterstitialADListener) Proxy.newProxyInstance(UnifiedInterstitialADListener.class.getClassLoader(), new Class[]{UnifiedInterstitialADListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f15652a == null) {
            return null;
        }
        if ("onADReceive".equals(name)) {
            this.f15652a.b();
        } else if ("onVideoCached".equals(name)) {
            this.f15652a.onVideoCached();
        } else if ("onNoAD".equals(name)) {
            this.f15652a.onNoAD((AdError) objArr[0]);
        } else if ("onADOpened".equals(name)) {
            this.f15652a.f();
        } else if ("onADExposure".equals(name)) {
            this.f15652a.onADExposure();
        } else if ("onADClicked".equals(name)) {
            this.f15652a.onADClicked();
        } else if ("onADLeftApplication".equals(name)) {
            this.f15652a.a();
        } else if ("onADClosed".equals(name)) {
            this.f15652a.c();
        } else if ("onRenderSuccess".equals(name)) {
            this.f15652a.d();
        } else if ("onRenderFail".equals(name)) {
            this.f15652a.e();
        }
        return null;
    }
}
