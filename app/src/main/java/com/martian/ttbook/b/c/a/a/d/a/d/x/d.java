package com.martian.ttbook.b.c.a.a.d.a.d.x;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.martian.ttbook.b.c.a.a.e.i;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.interstitial2.ADRewardListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {

    static class a implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0348d f15606a;

        a(InterfaceC0348d interfaceC0348d) {
            this.f15606a = interfaceC0348d;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"onReward".equals(method.getName()) || !(objArr[0] instanceof Map)) {
                return null;
            }
            this.f15606a.onReward((Map) objArr[0]);
            return null;
        }
    }

    static class b implements ADRewardListener {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0348d f15611a;

        b(InterfaceC0348d interfaceC0348d) {
            this.f15611a = interfaceC0348d;
        }

        @Override // com.qq.e.comm.listeners.ADRewardListener
        public void onReward(Map<String, Object> map) {
            this.f15611a.onReward(map);
        }
    }

    static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f15613a;

        static {
            int[] iArr = new int[e.values().length];
            f15613a = iArr;
            try {
                iArr[e.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15613a[e.UNIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15613a[e.EXPRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15613a[e.REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15613a[e.INTERSTITIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15613a[e.FULLSCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15613a[e.BANNER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.martian.ttbook.b.c.a.a.d.a.d.x.d$d */
    public interface InterfaceC0348d {
        void onReward(Map<String, Object> map);
    }

    public enum e {
        SPLASH(SplashAD.class),
        UNIFIED(NativeUnifiedAD.class),
        EXPRESS(NativeExpressAD.class),
        INTERSTITIAL(UnifiedInterstitialAD.class),
        REWARD(RewardVideoAD.class),
        FULLSCREEN(UnifiedInterstitialAD.class),
        BANNER(UnifiedBannerView.class);


        /* renamed from: b */
        private Class f15622b;

        e(Class cls) {
            this.f15622b = cls;
        }

        public Class a() {
            return this.f15622b;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "AD_TYPE{cls=" + this.f15622b + '}';
        }
    }

    public static int a(Object obj) {
        int i2;
        Object c2;
        try {
            c2 = c(obj.getClass(), "getECPM", obj);
        } catch (Exception unused) {
        }
        if (c2 instanceof Integer) {
            i2 = ((Integer) c2).intValue();
            com.martian.ttbook.b.c.a.a.e.d.g("xxx", "gdt get ecpm " + i2);
            return i2;
        }
        i2 = -1;
        com.martian.ttbook.b.c.a.a.e.d.g("xxx", "gdt get ecpm " + i2);
        return i2;
    }

    public static Object b(e eVar, Context context, String str, String str2, Object obj, Object... objArr) {
        try {
            boolean i2 = i.i("4.440");
            com.martian.ttbook.b.c.a.a.e.d.g("GDT_PAH_TAG", "isConstructorNoAppId = " + i2 + ", type: " + eVar);
            if (i2) {
                switch (c.f15613a[eVar.ordinal()]) {
                    case 1:
                        return new SplashAD(context, str2, (SplashADListener) obj, ((Integer) objArr[1]).intValue());
                    case 2:
                        return new NativeUnifiedAD(context, str2, (NativeADUnifiedListener) obj);
                    case 3:
                        return new NativeExpressAD(context, (ADSize) objArr[0], str2, (NativeExpressAD.NativeExpressADListener) obj);
                    case 4:
                        return new RewardVideoAD(context, str2, (RewardVideoADListener) obj, ((Boolean) objArr[0]).booleanValue());
                    case 5:
                    case 6:
                        return new UnifiedInterstitialAD(com.martian.ttbook.b.c.a.a.d.a.d.v.d.a.a.a(context), str2, (UnifiedInterstitialADListener) obj);
                    case 7:
                        return new UnifiedBannerView(com.martian.ttbook.b.c.a.a.d.a.d.v.d.a.a.a(context), str2, (UnifiedBannerADListener) obj);
                    default:
                        return null;
                }
            }
            Class a2 = eVar.a();
            switch (c.f15613a[eVar.ordinal()]) {
                case 1:
                    return a2.getConstructor(Context.class, View.class, String.class, String.class, SplashADListener.class, Integer.TYPE).newInstance(context, objArr[0], str, str2, obj, objArr[1]);
                case 2:
                    return a2.getConstructor(Context.class, String.class, String.class, NativeADUnifiedListener.class).newInstance(context, str, str2, obj);
                case 3:
                    return a2.getConstructor(Context.class, ADSize.class, String.class, String.class, NativeExpressAD.NativeExpressADListener.class).newInstance(context, objArr[0], str, str2, obj);
                case 4:
                    return a2.getConstructor(Context.class, String.class, String.class, RewardVideoADListener.class, Boolean.TYPE).newInstance(context, str, str2, obj, objArr[0]);
                case 5:
                case 6:
                    return a2.getConstructor(Activity.class, String.class, String.class, UnifiedInterstitialADListener.class).newInstance(com.martian.ttbook.b.c.a.a.d.a.d.v.d.a.a.a(context), str, str2, obj);
                case 7:
                    return a2.getConstructor(Activity.class, String.class, String.class, UnifiedBannerADListener.class).newInstance(com.martian.ttbook.b.c.a.a.d.a.d.v.d.a.a.a(context), str, str2, obj);
                default:
                    return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Object c(Class cls, String str, Object obj) {
        try {
            com.martian.ttbook.b.c.a.a.e.d.g("GDT_PAH_TAG", ", obj: " + obj + ", cls " + cls);
            return cls.getMethod(str, new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.martian.ttbook.b.c.a.a.e.d.g("GDT_PAH_TAG", "err " + e2.getMessage());
            return null;
        }
    }

    public static void d(UnifiedInterstitialAD unifiedInterstitialAD, InterfaceC0348d interfaceC0348d) {
        try {
            try {
                Class<?> cls = Class.forName("com.qq.e.comm.listeners.ADRewardListener");
                Object newProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(interfaceC0348d));
                Method method = unifiedInterstitialAD.getClass().getMethod("setRewardListener", cls);
                method.setAccessible(true);
                method.invoke(unifiedInterstitialAD, newProxyInstance);
            } catch (Exception unused) {
                unifiedInterstitialAD.setRewardListener(new b(interfaceC0348d));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
