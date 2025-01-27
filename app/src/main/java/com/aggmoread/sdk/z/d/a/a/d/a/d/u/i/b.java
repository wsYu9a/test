package com.aggmoread.sdk.z.d.a.a.d.a.d.u.i;

import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class b implements InvocationHandler {

    /* renamed from: a */
    private a f5737a;

    public interface a {
        void a();

        void b();

        void c();

        void onADClicked();

        void onADExposure();

        void onADLeftApplication();

        void onNoAD(AdError adError);

        void onRenderFail();

        void onRenderSuccess();

        void onVideoCached();
    }

    public b(a aVar) {
        this.f5737a = aVar;
    }

    public UnifiedInterstitialADListener a() {
        return (UnifiedInterstitialADListener) Proxy.newProxyInstance(UnifiedInterstitialADListener.class.getClassLoader(), new Class[]{UnifiedInterstitialADListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f5737a == null) {
            return null;
        }
        if ("onADReceive".equals(name)) {
            this.f5737a.a();
        } else if ("onVideoCached".equals(name)) {
            this.f5737a.onVideoCached();
        } else if ("onNoAD".equals(name)) {
            this.f5737a.onNoAD((AdError) objArr[0]);
        } else if ("onADOpened".equals(name)) {
            this.f5737a.c();
        } else if ("onADExposure".equals(name)) {
            this.f5737a.onADExposure();
        } else if ("onADClicked".equals(name)) {
            this.f5737a.onADClicked();
        } else if ("onADLeftApplication".equals(name)) {
            this.f5737a.onADLeftApplication();
        } else if ("onADClosed".equals(name)) {
            this.f5737a.b();
        } else if ("onRenderSuccess".equals(name)) {
            this.f5737a.onRenderSuccess();
        } else if ("onRenderFail".equals(name)) {
            this.f5737a.onRenderFail();
        }
        return null;
    }
}
