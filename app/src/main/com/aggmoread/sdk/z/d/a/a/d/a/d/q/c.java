package com.aggmoread.sdk.z.d.a.a.d.a.d.q;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private static c f5449a;

    public class a implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ j f5450a;

        public a(c cVar, j jVar) {
            this.f5450a = jVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            try {
                if (this.f5450a != null) {
                    String name = method.getName();
                    if (IAdInterListener.AdCommandType.AD_CLICK.equals(name)) {
                        this.f5450a.onAdClick();
                    } else if ("onADLoaded".equals(name)) {
                        this.f5450a.f();
                    } else if ("onAdClose".equals(name)) {
                        this.f5450a.onAdClose();
                    } else if ("onAdFailed".equals(name)) {
                        this.f5450a.b(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                    } else if ("onNoAd".equals(name)) {
                        this.f5450a.a(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                    } else if ("onAdCacheSuccess".equals(name)) {
                        this.f5450a.d();
                    } else if ("onAdCacheFailed".equals(name)) {
                        this.f5450a.b();
                    } else if ("onADExposed".equals(name)) {
                        this.f5450a.onADExposed();
                    } else if ("onADExposureFailed".equals(name)) {
                        this.f5450a.g();
                    } else if ("onVideoDownloadSuccess".equals(name)) {
                        this.f5450a.onVideoDownloadSuccess();
                    } else if ("onVideoDownloadFailed".equals(name)) {
                        this.f5450a.onVideoDownloadFailed();
                    } else if ("onLpClosed".equals(name)) {
                        this.f5450a.c();
                    }
                }
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    public class b implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ g f5451a;

        public b(c cVar, g gVar) {
            this.f5451a = gVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            try {
                if (this.f5451a != null) {
                    if ("onDislikeWindowShow".equals(method.getName())) {
                        this.f5451a.a();
                    } else if ("onDislikeItemClick".equals(method.getName())) {
                        this.f5451a.c();
                    } else if ("onDislikeWindowClose".equals(method.getName())) {
                        this.f5451a.b();
                    }
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.c$c */
    public class C0127c implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ k f5452a;

        public C0127c(c cVar, k kVar) {
            this.f5452a = kVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method == null) {
                return null;
            }
            try {
                if (this.f5452a != null) {
                    String name = method.getName();
                    if ("onLpClosed".equals(name)) {
                        this.f5452a.c();
                    } else if ("onAdPresent".equals(name)) {
                        this.f5452a.g();
                    } else if ("onAdExposed".equals(name)) {
                        this.f5452a.onAdExposed();
                    } else if ("onAdDismissed".equals(name)) {
                        this.f5452a.a();
                    } else if ("onAdSkip".equals(name)) {
                        this.f5452a.e();
                    } else if (IAdInterListener.AdCommandType.AD_CLICK.equals(name)) {
                        this.f5452a.onAdClick();
                    } else if ("onAdCacheSuccess".equals(name)) {
                        this.f5452a.d();
                    } else if ("onAdCacheFailed".equals(name)) {
                        this.f5452a.b();
                    } else if ("onADLoaded".equals(name)) {
                        this.f5452a.f();
                    } else if ("onAdFailed".equals(name)) {
                        this.f5452a.onAdFailed((String) objArr[0]);
                    }
                }
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    public class d implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ i f5453a;

        public d(i iVar) {
            this.f5453a = iVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method != null) {
                try {
                    if (this.f5453a != null) {
                        String name = method.getName();
                        if ("onNoAd".equals(name)) {
                            f a10 = c.this.a(objArr);
                            Object obj2 = a10.f5459c;
                            this.f5453a.b(a10.f5457a, a10.f5458b, obj2 instanceof NativeResponse ? (NativeResponse) obj2 : null);
                        } else if ("onNativeFail".equals(name)) {
                            f a11 = c.this.a(objArr);
                            Object obj3 = a11.f5459c;
                            this.f5453a.a(a11.f5457a, a11.f5458b, obj3 instanceof NativeResponse ? (NativeResponse) obj3 : null);
                        } else if ("onNativeLoad".equals(name)) {
                            this.f5453a.a((List) objArr[0]);
                        } else if ("onVideoDownloadSuccess".equals(name)) {
                            this.f5453a.onVideoDownloadSuccess();
                        } else if ("onVideoDownloadFailed".equals(name)) {
                            this.f5453a.onVideoDownloadFailed();
                        } else if ("onLpClosed".equals(name)) {
                            this.f5453a.c();
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            return null;
        }
    }

    public class e implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ h f5455a;

        public e(h hVar) {
            this.f5455a = hVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method != null) {
                try {
                    if (this.f5455a != null) {
                        String name = method.getName();
                        if ("onNoAd".equals(name)) {
                            f a10 = c.this.a(objArr);
                            Object obj2 = a10.f5459c;
                            this.f5455a.b(a10.f5457a, a10.f5458b, obj2 instanceof ExpressResponse ? (ExpressResponse) obj2 : null);
                        } else if ("onNativeFail".equals(name)) {
                            f a11 = c.this.a(objArr);
                            Object obj3 = a11.f5459c;
                            this.f5455a.a(a11.f5457a, a11.f5458b, obj3 instanceof ExpressResponse ? (ExpressResponse) obj3 : null);
                        } else if ("onNativeLoad".equals(name)) {
                            this.f5455a.a((List) objArr[0]);
                        } else if ("onVideoDownloadSuccess".equals(name)) {
                            this.f5455a.onVideoDownloadSuccess();
                        } else if ("onVideoDownloadFailed".equals(name)) {
                            this.f5455a.onVideoDownloadFailed();
                        } else if ("onLpClosed".equals(name)) {
                            this.f5455a.c();
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            return null;
        }
    }

    public static class f {

        /* renamed from: a */
        public int f5457a;

        /* renamed from: b */
        public String f5458b;

        /* renamed from: c */
        public Object f5459c;

        private f() {
            this.f5457a = -1;
        }

        public /* synthetic */ f(a aVar) {
            this();
        }
    }

    public interface g {
        void a();

        void b();

        void c();
    }

    public interface h {
        void a(int i10, String str, ExpressResponse expressResponse);

        void a(List<ExpressResponse> list);

        void b(int i10, String str, ExpressResponse expressResponse);

        void c();

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface i {
        void a(int i10, String str, NativeResponse nativeResponse);

        void a(List<NativeResponse> list);

        void b(int i10, String str, NativeResponse nativeResponse);

        void c();

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface j {
        void a(int i10, String str);

        void b();

        void b(int i10, String str);

        void c();

        void d();

        void f();

        void g();

        void onADExposed();

        void onAdClick();

        void onAdClose();

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface k {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();

        void g();

        void onAdClick();

        void onAdExposed();

        void onAdFailed(String str);
    }

    private c() {
    }

    public f a(Object[] objArr) {
        f fVar = new f(null);
        if (objArr != null) {
            if (objArr.length >= 1) {
                fVar.f5457a = ((Integer) objArr[0]).intValue();
            }
            if (objArr.length >= 2) {
                Object obj = objArr[1];
                if (obj instanceof String) {
                    fVar.f5458b = obj.toString();
                }
            }
            if (objArr.length >= 3) {
                fVar.f5459c = objArr[2];
            }
        }
        return fVar;
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            try {
                if (f5449a == null) {
                    synchronized (c.class) {
                        try {
                            if (f5449a == null) {
                                f5449a = new c();
                            }
                        } finally {
                        }
                    }
                }
                cVar = f5449a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    public BaiduNativeManager.ExpressAdListener a(h hVar) {
        return (BaiduNativeManager.ExpressAdListener) Proxy.newProxyInstance(BaiduNativeManager.ExpressAdListener.class.getClassLoader(), new Class[]{BaiduNativeManager.ExpressAdListener.class}, new e(hVar));
    }

    public BaiduNativeManager.FeedAdListener a(i iVar) {
        return (BaiduNativeManager.FeedAdListener) Proxy.newProxyInstance(BaiduNativeManager.FeedAdListener.class.getClassLoader(), new Class[]{BaiduNativeManager.FeedAdListener.class}, new d(iVar));
    }

    public ExpressInterstitialListener a(j jVar) {
        return (ExpressInterstitialListener) Proxy.newProxyInstance(ExpressInterstitialListener.class.getClassLoader(), new Class[]{ExpressInterstitialListener.class}, new a(this, jVar));
    }

    public ExpressResponse.ExpressDislikeListener a(g gVar) {
        return (ExpressResponse.ExpressDislikeListener) Proxy.newProxyInstance(ExpressResponse.ExpressDislikeListener.class.getClassLoader(), new Class[]{ExpressResponse.ExpressDislikeListener.class}, new b(this, gVar));
    }

    public SplashInteractionListener a(k kVar) {
        return (SplashInteractionListener) Proxy.newProxyInstance(SplashInteractionListener.class.getClassLoader(), new Class[]{SplashInteractionListener.class}, new C0127c(this, kVar));
    }

    public static void a(boolean z10) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("bd ap " + z10);
        try {
            MobadsPermissionSettings.setLimitPersonalAds(z10);
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a("ap e" + e10);
        }
    }
}
