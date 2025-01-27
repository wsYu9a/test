package com.martian.ttbook.b.c.a.a.b.a.d.x;

import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private static c f15438a;

    class a implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ d f15439a;

        a(c cVar, d dVar) {
            this.f15439a = dVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            try {
                if (this.f15439a != null) {
                    String name = method.getName();
                    if (IAdInterListener.AdCommandType.AD_CLICK.equals(name)) {
                        this.f15439a.onAdClick();
                    } else if ("onADLoaded".equals(name)) {
                        this.f15439a.onADLoaded();
                    } else if ("onAdClose".equals(name)) {
                        this.f15439a.onAdClose();
                    } else if ("onAdFailed".equals(name)) {
                        this.f15439a.a(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                    } else if ("onNoAd".equals(name)) {
                        this.f15439a.onNoAd(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                    } else if ("onAdCacheSuccess".equals(name)) {
                        this.f15439a.onAdCacheSuccess();
                    } else if ("onAdCacheFailed".equals(name)) {
                        this.f15439a.onAdCacheFailed();
                    } else if ("onADExposed".equals(name)) {
                        this.f15439a.onADExposed();
                    } else if ("onADExposureFailed".equals(name)) {
                        this.f15439a.a();
                    } else if ("onVideoDownloadSuccess".equals(name)) {
                        this.f15439a.onVideoDownloadSuccess();
                    } else if ("onVideoDownloadFailed".equals(name)) {
                        this.f15439a.onVideoDownloadFailed();
                    } else if ("onLpClosed".equals(name)) {
                        this.f15439a.onLpClosed();
                    }
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    class b implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0322c f15440a;

        b(c cVar, InterfaceC0322c interfaceC0322c) {
            this.f15440a = interfaceC0322c;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            try {
                if (this.f15440a != null) {
                    if ("onDislikeWindowShow".equals(method.getName())) {
                        this.f15440a.a();
                    } else if ("onDislikeItemClick".equals(method.getName())) {
                        this.f15440a.c();
                    } else if ("onDislikeWindowClose".equals(method.getName())) {
                        this.f15440a.b();
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.x.c$c */
    public interface InterfaceC0322c {
        void a();

        void b();

        void c();
    }

    public interface d {
        void a();

        void a(int i2, String str);

        void onADExposed();

        void onADLoaded();

        void onAdCacheFailed();

        void onAdCacheSuccess();

        void onAdClick();

        void onAdClose();

        void onLpClosed();

        void onNoAd(int i2, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    private c() {
    }

    public static synchronized c c() {
        c cVar;
        synchronized (c.class) {
            if (f15438a == null) {
                synchronized (c.class) {
                    if (f15438a == null) {
                        f15438a = new c();
                    }
                }
            }
            cVar = f15438a;
        }
        return cVar;
    }

    public ExpressInterstitialListener a(d dVar) {
        return (ExpressInterstitialListener) Proxy.newProxyInstance(ExpressInterstitialListener.class.getClassLoader(), new Class[]{ExpressInterstitialListener.class}, new a(this, dVar));
    }

    public ExpressResponse.ExpressDislikeListener b(InterfaceC0322c interfaceC0322c) {
        return (ExpressResponse.ExpressDislikeListener) Proxy.newProxyInstance(ExpressResponse.ExpressDislikeListener.class.getClassLoader(), new Class[]{ExpressResponse.ExpressDislikeListener.class}, new b(this, interfaceC0322c));
    }
}
