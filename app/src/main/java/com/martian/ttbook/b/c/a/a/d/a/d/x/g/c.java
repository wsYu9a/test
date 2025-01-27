package com.martian.ttbook.b.c.a.a.d.a.d.x.g;

import com.martian.ttbook.b.c.a.a.e.d;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class c implements InvocationHandler {

    /* renamed from: a */
    private a f15653a;

    public interface a {
        void onVideoComplete();

        void onVideoError(AdError adError);

        void onVideoInit();

        void onVideoLoading();

        void onVideoPageClose();

        void onVideoPageOpen();

        void onVideoPause();

        void onVideoReady(long j2);

        void onVideoStart();
    }

    public c(a aVar) {
        this.f15653a = aVar;
    }

    public UnifiedInterstitialMediaListener a() {
        return (UnifiedInterstitialMediaListener) Proxy.newProxyInstance(UnifiedInterstitialMediaListener.class.getClassLoader(), new Class[]{UnifiedInterstitialMediaListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f15653a == null) {
            return null;
        }
        d.g("INTERSTITIALTAG", "name = " + name);
        if ("onVideoInit".equals(name)) {
            this.f15653a.onVideoInit();
        } else if ("onVideoLoading".equals(name)) {
            this.f15653a.onVideoLoading();
        } else if ("onVideoReady".equals(name)) {
            this.f15653a.onVideoReady(((Long) objArr[0]).longValue());
        } else if ("onVideoStart".equals(name)) {
            this.f15653a.onVideoStart();
        } else if ("onVideoPause".equals(name)) {
            this.f15653a.onVideoPause();
        } else if ("onVideoComplete".equals(name)) {
            this.f15653a.onVideoComplete();
        } else if ("onVideoError".equals(name)) {
            this.f15653a.onVideoError((AdError) objArr[0]);
        } else if ("onVideoPageOpen".equals(name)) {
            this.f15653a.onVideoPageOpen();
        } else if ("onVideoPageClose".equals(name)) {
            this.f15653a.onVideoPageClose();
        }
        return null;
    }
}
