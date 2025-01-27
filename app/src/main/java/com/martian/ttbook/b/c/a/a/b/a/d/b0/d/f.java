package com.martian.ttbook.b.c.a.a.b.a.d.b0.d;

import com.kwad.sdk.api.KsNativeAd;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class f implements InvocationHandler {

    /* renamed from: a */
    private a f15326a;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void onVideoPlayError(int i2, int i3);

        void onVideoPlayStart();
    }

    public KsNativeAd.VideoPlayListener a(a aVar) {
        this.f15326a = aVar;
        return (KsNativeAd.VideoPlayListener) Proxy.newProxyInstance(KsNativeAd.VideoPlayListener.class.getClassLoader(), new Class[]{KsNativeAd.VideoPlayListener.class}, this);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (this.f15326a == null) {
            return null;
        }
        if ("onVideoPlayReady".equals(method.getName())) {
            this.f15326a.b();
        } else if ("onVideoPlayStart".equals(method.getName())) {
            this.f15326a.onVideoPlayStart();
        } else if ("onVideoPlayComplete".equals(method.getName())) {
            this.f15326a.a();
        } else if ("onVideoPlayError".equals(method.getName())) {
            this.f15326a.onVideoPlayError(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
        } else if ("onVideoPlayPause".equals(method.getName())) {
            this.f15326a.c();
        } else if ("onVideoPlayResume".equals(method.getName())) {
            this.f15326a.d();
        }
        return null;
    }
}
