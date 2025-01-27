package com.aggmoread.sdk.z.d.a.a.d.a.d.v.f;

import com.kwad.sdk.api.KsNativeAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class f implements InvocationHandler {

    /* renamed from: a */
    private a f5775a;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void onVideoPlayError(int i10, int i11);

        void onVideoPlayStart();
    }

    public KsNativeAd.VideoPlayListener a(a aVar) {
        this.f5775a = aVar;
        return (KsNativeAd.VideoPlayListener) Proxy.newProxyInstance(KsNativeAd.VideoPlayListener.class.getClassLoader(), new Class[]{KsNativeAd.VideoPlayListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (this.f5775a == null) {
            return null;
        }
        if ("onVideoPlayReady".equals(method.getName())) {
            this.f5775a.b();
        } else if ("onVideoPlayStart".equals(method.getName())) {
            this.f5775a.onVideoPlayStart();
        } else if ("onVideoPlayComplete".equals(method.getName())) {
            this.f5775a.a();
        } else if ("onVideoPlayError".equals(method.getName())) {
            this.f5775a.onVideoPlayError(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
        } else if ("onVideoPlayPause".equals(method.getName())) {
            this.f5775a.c();
        } else if ("onVideoPlayResume".equals(method.getName())) {
            this.f5775a.d();
        }
        return null;
    }
}
