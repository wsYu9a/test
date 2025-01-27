package com.martian.ttbook.b.c.a.a.b.a.d.c;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.martian.ttbook.b.c.a.a.b.a.d.p;
import com.martian.ttbook.b.c.a.a.b.a.d.q;
import com.martian.ttbook.b.c.a.a.b.a.d.r;
import com.martian.ttbook.b.c.a.a.b.a.d.s;
import com.martian.ttbook.b.c.a.a.b.a.d.u;
import com.martian.ttbook.b.c.a.a.b.a.d.v;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.e.j;
import com.vivo.ad.model.AdError;
import com.vivo.ad.nativead.NativeAdListener;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.unified.interstitial.UnifiedVivoInterstitialAdListener;
import com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAdListener;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;
import com.vivo.mobilead.unified.reward.UnifiedVivoRewardVideoAdListener;
import com.vivo.mobilead.unified.splash.UnifiedVivoSplashAdListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static d f15355a;

    static class a implements InvocationHandler {

        /* renamed from: a */
        private Object f15356a;

        /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.d$a$a */
        class RunnableC0312a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Method f15357a;

            /* renamed from: b */
            final /* synthetic */ Object[] f15358b;

            RunnableC0312a(Method method, Object[] objArr) {
                this.f15357a = method;
                this.f15358b = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.martian.ttbook.b.c.a.a.e.d.a("invoke method in main" + this.f15357a.getName());
                a.this.d(this.f15357a, this.f15358b);
            }
        }

        public a(Object obj) {
            this.f15356a = obj;
        }

        private i a(Object[] objArr) {
            int i2;
            String str;
            if (objArr != null && objArr.length > 0) {
                if (objArr[0] instanceof VivoAdError) {
                    VivoAdError vivoAdError = (VivoAdError) objArr[0];
                    i2 = vivoAdError.getCode();
                    str = vivoAdError.getMsg();
                } else if (objArr[0] instanceof AdError) {
                    AdError adError = (AdError) objArr[0];
                    i2 = adError.getErrorCode();
                    str = adError.getErrorMsg();
                }
                return new i(i2, str);
            }
            i2 = -3000;
            str = "广告加载失败";
            return new i(i2, str);
        }

        private boolean c(String str, Method method) {
            if (method != null) {
                return str.equals(method.getName());
            }
            return false;
        }

        public boolean d(Method method, Object[] objArr) {
            Object obj = this.f15356a;
            if (obj instanceof q) {
                if (c("onVideoStart", method)) {
                    ((q) this.f15356a).onVideoStart();
                } else if (c("onVideoPause", method)) {
                    ((q) this.f15356a).onVideoPause();
                } else if (c("onVideoPlay", method)) {
                    ((q) this.f15356a).a();
                } else if (c("onVideoError", method)) {
                    ((q) this.f15356a).a(a(objArr));
                } else if (c("onVideoCompletion", method)) {
                    ((q) this.f15356a).onVideoComplete();
                } else if (c("onVideoCached", method)) {
                    ((q) this.f15356a).onVideoReady(-1L);
                }
                return true;
            }
            if (obj instanceof v) {
                if (c("onAdReady", method)) {
                    ((v) this.f15356a).a((v) objArr[0]);
                } else if (c("onAdFailed", method)) {
                    ((v) this.f15356a).a(a(objArr));
                } else if (c("onAdShow", method)) {
                    ((v) this.f15356a).onAdExposed();
                } else if (c(IAdInterListener.AdCommandType.AD_CLICK, method)) {
                    ((v) this.f15356a).onAdClicked();
                } else if (c("onAdSkip", method)) {
                    ((v) this.f15356a).onAdSkip();
                } else if (c("onAdTimeOver", method)) {
                    ((v) this.f15356a).onAdTimeOver();
                }
                return true;
            }
            if (obj instanceof p) {
                if (c("onAdReady", method)) {
                    ((p) this.f15356a).a((p) null);
                } else if (c("onAdFailed", method)) {
                    ((p) this.f15356a).a(a(objArr));
                } else if (c(IAdInterListener.AdCommandType.AD_CLICK, method)) {
                    ((p) this.f15356a).onAdClicked();
                } else if (c("onAdShow", method)) {
                    ((p) this.f15356a).onAdShow();
                    ((p) this.f15356a).onAdExposed();
                } else if (c("onAdClose", method)) {
                    ((p) this.f15356a).onAdDismissed();
                }
                return true;
            }
            if (obj instanceof u) {
                if (c("onAdReady", method)) {
                    ((u) this.f15356a).onAdLoaded();
                } else if (c("onAdFailed", method)) {
                    ((u) this.f15356a).a(a(objArr));
                } else if (c(IAdInterListener.AdCommandType.AD_CLICK, method)) {
                    ((u) this.f15356a).onAdClicked();
                } else if (c("onAdShow", method)) {
                    ((u) this.f15356a).onAdExposed();
                } else if (c("onAdClose", method)) {
                    ((u) this.f15356a).onAdDismissed();
                } else if (c("onRewardVerify", method)) {
                    ((u) this.f15356a).onReward();
                }
                return true;
            }
            if (obj instanceof r) {
                if (c("onAdReady", method)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((VivoNativeExpressView) objArr[0]);
                    ((r) this.f15356a).onAdLoaded(arrayList);
                } else if (c("onAdFailed", method)) {
                    ((r) this.f15356a).a(a(objArr));
                } else if (c(IAdInterListener.AdCommandType.AD_CLICK, method)) {
                    ((r) this.f15356a).b((VivoNativeExpressView) objArr[0]);
                } else if (c("onAdShow", method)) {
                    ((r) this.f15356a).a((r) objArr[0]);
                } else if (c("onAdClose", method)) {
                    ((r) this.f15356a).c((VivoNativeExpressView) objArr[0]);
                }
            } else if (obj instanceof s) {
                if (c("onADLoaded", method)) {
                    ((s) this.f15356a).a((List) objArr[0]);
                } else if (c("onNoAD", method)) {
                    ((s) this.f15356a).a(a(objArr));
                } else if (c("onClick", method)) {
                    ((s) this.f15356a).b((NativeResponse) objArr[0]);
                } else if (c("onAdShow", method)) {
                    ((s) this.f15356a).a((s) objArr[0]);
                }
            }
            return false;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            com.martian.ttbook.b.c.a.a.e.d.a("invoke method " + method.getName());
            j.c(new RunnableC0312a(method, objArr));
            return null;
        }
    }

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f15355a == null) {
                synchronized (d.class) {
                    if (f15355a == null) {
                        f15355a = new d();
                    }
                }
            }
            dVar = f15355a;
        }
        return dVar;
    }

    private <T> T c(Object obj, Class<T> cls) {
        try {
            return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(obj)));
        } catch (Exception unused) {
            return null;
        }
    }

    private <T> T e(Object obj, Class<T> cls) {
        return (T) c(obj, cls);
    }

    public UnifiedVivoNativeExpressAdListener b(Object obj) {
        return (UnifiedVivoNativeExpressAdListener) e(obj, UnifiedVivoNativeExpressAdListener.class);
    }

    public UnifiedVivoInterstitialAdListener d(Object obj) {
        return (UnifiedVivoInterstitialAdListener) e(obj, UnifiedVivoInterstitialAdListener.class);
    }

    public MediaListener f(Object obj) {
        return (MediaListener) e(obj, MediaListener.class);
    }

    public NativeAdListener g(Object obj) {
        return (NativeAdListener) e(obj, NativeAdListener.class);
    }

    public UnifiedVivoRewardVideoAdListener h(Object obj) {
        return (UnifiedVivoRewardVideoAdListener) e(obj, UnifiedVivoRewardVideoAdListener.class);
    }

    public UnifiedVivoSplashAdListener i(Object obj) {
        return (UnifiedVivoSplashAdListener) e(obj, UnifiedVivoSplashAdListener.class);
    }
}
