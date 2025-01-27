package com.aggmoread.sdk.z.d.a.a.d.a.d.u.i;

import com.aggmoread.sdk.z.d.a.a.e.e;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class c implements InvocationHandler {

    /* renamed from: a */
    private a f5738a;

    public interface a {
        void a(long j10);

        void b();

        void c();

        void onVideoComplete();

        void onVideoError(AdError adError);

        void onVideoInit();

        void onVideoLoading();

        void onVideoPause();

        void onVideoStart();
    }

    public c(a aVar) {
        this.f5738a = aVar;
    }

    public UnifiedInterstitialMediaListener a() {
        return (UnifiedInterstitialMediaListener) Proxy.newProxyInstance(UnifiedInterstitialMediaListener.class.getClassLoader(), new Class[]{UnifiedInterstitialMediaListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (this.f5738a == null) {
            return null;
        }
        e.b("INTERSTITIALTAG", "name = " + name);
        if ("onVideoInit".equals(name)) {
            this.f5738a.onVideoInit();
        } else if ("onVideoLoading".equals(name)) {
            this.f5738a.onVideoLoading();
        } else if ("onVideoReady".equals(name)) {
            this.f5738a.a(((Long) objArr[0]).longValue());
        } else if ("onVideoStart".equals(name)) {
            this.f5738a.onVideoStart();
        } else if ("onVideoPause".equals(name)) {
            this.f5738a.onVideoPause();
        } else if ("onVideoComplete".equals(name)) {
            this.f5738a.onVideoComplete();
        } else if ("onVideoError".equals(name)) {
            this.f5738a.onVideoError((AdError) objArr[0]);
        } else if ("onVideoPageOpen".equals(name)) {
            this.f5738a.c();
        } else if ("onVideoPageClose".equals(name)) {
            this.f5738a.b();
        }
        return null;
    }
}
