package com.aggmoread.sdk.z.d.a.a.d.a.d.u;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IBidding;
import com.sigmob.windad.WindAds;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {

    public static class a implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0161d f5676a;

        public a(InterfaceC0161d interfaceC0161d) {
            this.f5676a = interfaceC0161d;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (!"onReward".equals(method.getName())) {
                return null;
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "onReward enter");
            Object obj2 = objArr[0];
            if (!(obj2 instanceof Map)) {
                return null;
            }
            this.f5676a.onReward((Map) obj2);
            return null;
        }
    }

    public static class b implements InterfaceC0161d {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5677a;

        public b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
            this.f5677a = dVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.InterfaceC0161d
        public void onReward(Map<String, Object> map) {
            if (this.f5677a.f5870p.c() != null) {
                this.f5677a.f5870p.c().onReward(map);
            }
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a */
        static final /* synthetic */ int[] f5678a;

        static {
            int[] iArr = new int[e.values().length];
            f5678a = iArr;
            try {
                iArr[e.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5678a[e.UNIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5678a[e.EXPRESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5678a[e.REWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5678a[e.INTERSTITIAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5678a[e.FULLSCREEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5678a[e.BANNER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.u.d$d */
    public interface InterfaceC0161d {
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
        private Class f5687b;

        e(Class cls) {
            this.f5687b = cls;
        }

        public Class a() {
            return this.f5687b;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "AD_TYPE{cls=" + this.f5687b + '}';
        }
    }

    public static int a(Object obj) {
        int i10;
        Object a10;
        try {
            a10 = a(obj.getClass(), "getECPM", obj);
        } catch (Exception unused) {
        }
        if (a10 instanceof Integer) {
            i10 = ((Integer) a10).intValue();
            com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "gdt get ecpm " + i10);
            return i10;
        }
        i10 = -1;
        com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "gdt get ecpm " + i10);
        return i10;
    }

    public static void b(Object obj, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        com.aggmoread.sdk.z.d.a.a.c.r.c cVar;
        if (dVar == null || (cVar = dVar.f5870p) == null || cVar.c() == null) {
            return;
        }
        a(obj, dVar, eVar);
        a(obj, new b(dVar));
    }

    public static Object a(Context context, String str, String str2, e eVar, String str3, Object obj, Object... objArr) {
        Object obj2;
        Object a10;
        try {
            com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "entity token " + str3);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (TextUtils.isEmpty(str3) || !m.a("4.430")) {
            boolean a11 = m.a("4.440");
            com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "isConstructorNoAppId = " + a11 + ", type: " + eVar);
            if (a11) {
                switch (c.f5678a[eVar.ordinal()]) {
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
                        return new UnifiedInterstitialAD(com.aggmoread.sdk.z.d.a.a.d.a.d.m.a(context), str2, (UnifiedInterstitialADListener) obj);
                    case 7:
                        return new UnifiedBannerView(com.aggmoread.sdk.z.d.a.a.d.a.d.m.a(context), str2, (UnifiedBannerADListener) obj);
                }
            }
            Class a12 = eVar.a();
            switch (c.f5678a[eVar.ordinal()]) {
                case 1:
                    return a12.getConstructor(Context.class, View.class, String.class, String.class, SplashADListener.class, Integer.TYPE).newInstance(context, objArr[0], str, str2, obj, objArr[1]);
                case 2:
                    return a12.getConstructor(Context.class, String.class, String.class, NativeADUnifiedListener.class).newInstance(context, str, str2, obj);
                case 3:
                    return a12.getConstructor(Context.class, ADSize.class, String.class, String.class, NativeExpressAD.NativeExpressADListener.class).newInstance(context, objArr[0], str, str2, obj);
                case 4:
                    return a12.getConstructor(Context.class, String.class, String.class, RewardVideoADListener.class, Boolean.TYPE).newInstance(context, str, str2, obj, objArr[0]);
                case 5:
                case 6:
                    return a12.getConstructor(Activity.class, String.class, String.class, UnifiedInterstitialADListener.class).newInstance(com.aggmoread.sdk.z.d.a.a.d.a.d.m.a(context), str, str2, obj);
                case 7:
                    return a12.getConstructor(Activity.class, String.class, String.class, UnifiedBannerADListener.class).newInstance(com.aggmoread.sdk.z.d.a.a.d.a.d.m.a(context), str, str2, obj);
            }
            return null;
        }
        Class a13 = eVar.a();
        switch (c.f5678a[eVar.ordinal()]) {
            case 1:
                if (!TextUtils.isEmpty(str3)) {
                    Class cls = Integer.TYPE;
                    Integer num = (Integer) objArr[1];
                    num.intValue();
                    Object a14 = a((Class<Object>) a13, (Class<?>[]) new Class[]{Context.class, String.class, SplashADListener.class, cls, Map.class, View.class, String.class}, context, str2, (SplashADListener) obj, num, null, null, str3);
                    if (a14 != null) {
                        obj2 = a14;
                        break;
                    } else {
                        Integer num2 = (Integer) objArr[1];
                        num2.intValue();
                        a10 = a((Class<Object>) a13, (Class<?>[]) new Class[]{Context.class, String.class, SplashADListener.class, cls, String.class}, context, str2, (SplashADListener) obj, num2, str3);
                        obj2 = a10;
                        break;
                    }
                }
                obj2 = null;
                break;
            case 2:
                if (!TextUtils.isEmpty(str3)) {
                    a10 = a((Class<Object>) a13, (Class<?>[]) new Class[]{Context.class, String.class, NativeADUnifiedListener.class, String.class}, context, str2, (NativeADUnifiedListener) obj, str3);
                    obj2 = a10;
                    break;
                }
                obj2 = null;
                break;
            case 3:
                if (!TextUtils.isEmpty(str3)) {
                    a10 = a((Class<Object>) a13, (Class<?>[]) new Class[]{Context.class, ADSize.class, String.class, NativeExpressAD.NativeExpressADListener.class, String.class}, context, (ADSize) objArr[0], str2, (NativeExpressAD.NativeExpressADListener) obj, str3);
                    obj2 = a10;
                    break;
                }
                obj2 = null;
                break;
            case 4:
                if (!TextUtils.isEmpty(str3)) {
                    Class[] clsArr = {Context.class, String.class, RewardVideoADListener.class, Boolean.TYPE, String.class};
                    Boolean bool = (Boolean) objArr[0];
                    bool.booleanValue();
                    a10 = a((Class<Object>) a13, (Class<?>[]) clsArr, context, str2, (RewardVideoADListener) obj, bool, str3);
                    obj2 = a10;
                    break;
                }
                obj2 = null;
                break;
            case 5:
            case 6:
                if (!TextUtils.isEmpty(str3)) {
                    a10 = a((Class<Object>) a13, (Class<?>[]) new Class[]{Activity.class, String.class, UnifiedInterstitialADListener.class, Map.class, String.class}, com.aggmoread.sdk.z.d.a.a.d.a.d.m.a(context), str2, (UnifiedInterstitialADListener) obj, null, str3);
                    obj2 = a10;
                    break;
                }
                obj2 = null;
                break;
            case 7:
                if (!TextUtils.isEmpty(str3)) {
                    a10 = a((Class<Object>) a13, (Class<?>[]) new Class[]{Activity.class, String.class, UnifiedBannerADListener.class, Map.class, String.class}, com.aggmoread.sdk.z.d.a.a.d.a.d.m.a(context), str2, (UnifiedBannerADListener) obj, null, str3);
                    obj2 = a10;
                    break;
                }
                obj2 = null;
                break;
            default:
                obj2 = null;
                break;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "entity  " + obj2);
        return obj2;
    }

    public static void b(boolean z10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("installList enable " + z10);
        a("setEnableCollectAppInstallStatus", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
    }

    public static Object a(Class<?> cls, String str, Object obj) {
        return a(cls, str, null, obj, new Object[0]);
    }

    public static Object a(Class<?> cls, String str, Class<?>[] clsArr, Object obj, Object... objArr) {
        try {
            com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "obj: " + obj + ", cls " + cls);
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "err " + e10.getMessage());
            return null;
        }
    }

    private static <T> T a(Class<T> cls, Class<?>[] clsArr, Object... objArr) {
        try {
            T newInstance = cls.getConstructor(clsArr).newInstance(objArr);
            com.aggmoread.sdk.z.d.a.a.e.e.a("new instance success " + newInstance);
            return newInstance;
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a("new instance fail " + e10.getMessage());
            return null;
        }
    }

    public static void a(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.e.e.a("GDT_PAH_TAG", "s win s = %s, p = %s", obj, Integer.valueOf(i10));
        Class<?> cls = obj.getClass();
        try {
            Method method = cls.getMethod("sendWinNotification", Map.class);
            Object obj2 = IBidding.class.getField("EXPECT_COST_PRICE").get(null);
            HashMap hashMap = new HashMap();
            if (obj2 instanceof String) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "key_cost " + obj2);
                hashMap.put((String) obj2, Integer.valueOf(i10));
            }
            method.invoke(obj, hashMap);
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a("GDT_PAH_TAG", "send map method err  = %s", e10);
            try {
                cls.getMethod("sendWinNotification", Integer.TYPE).invoke(obj, Integer.valueOf(i10));
            } catch (Exception e11) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("GDT_PAH_TAG", "send method err  = %s", e11);
            }
        }
    }

    public static void a(Object obj, int i10, int i11, String str) {
        String str2 = str;
        com.aggmoread.sdk.z.d.a.a.e.e.a("GDT_PAH_TAG", "s los s = %s,p = %s,r = %s, ad = %s", obj, Integer.valueOf(i10), Integer.valueOf(i11), str2);
        Class<?> cls = obj.getClass();
        try {
            Method method = cls.getMethod("sendLossNotification", Map.class);
            HashMap hashMap = new HashMap();
            Field field = IBidding.class.getField(WindAds.LOSS_REASON);
            Field field2 = IBidding.class.getField("WIN_PRICE");
            Field field3 = IBidding.class.getField(WindAds.ADN_ID);
            Object obj2 = field.get(null);
            Object obj3 = field2.get(null);
            Object obj4 = field3.get(null);
            if (obj2 instanceof String) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "key_cost " + obj2);
                hashMap.put((String) obj2, Integer.valueOf(i11));
            }
            if (obj3 instanceof String) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "key_price " + obj3);
                hashMap.put((String) obj3, Integer.valueOf(i10));
            }
            if (obj4 instanceof String) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "key_adn " + obj4);
                hashMap.put((String) obj4, str2);
            }
            method.invoke(obj, hashMap);
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a("GDT_PAH_TAG", "send map method err  = %s", e10);
            try {
                Class<?> cls2 = Integer.TYPE;
                Method method2 = cls.getMethod("sendLossNotification", cls2, cls2, String.class);
                Integer valueOf = Integer.valueOf(i10);
                Integer valueOf2 = Integer.valueOf(i11);
                if (str2 == null) {
                    str2 = "";
                }
                method2.invoke(obj, valueOf, valueOf2, str2);
            } catch (Exception e11) {
                com.aggmoread.sdk.z.d.a.a.e.e.a("GDT_PAH_TAG", "err  = %s", e11);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public static void a(Object obj, InterfaceC0161d interfaceC0161d) {
        if (ADRewardListener.class != 0) {
            try {
                Object newProxyInstance = Proxy.newProxyInstance(ADRewardListener.class.getClassLoader(), new Class[]{ADRewardListener.class}, new a(interfaceC0161d));
                com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "set reward listener " + ADRewardListener.class);
                obj.getClass().getMethod("setRewardListener", ADRewardListener.class).invoke(obj, newProxyInstance);
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "err " + e10);
            }
        }
    }

    public static void a(Object obj, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        try {
            String e10 = dVar.f5870p.e();
            String a10 = dVar.f5870p.a();
            com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", "u = " + e10 + ", cd = " + a10);
            String a11 = m.a(a10, eVar.f5907c.c(e.c.T));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" _extrasInfo = ");
            sb2.append(a11);
            com.aggmoread.sdk.z.d.a.a.e.e.b("GDT_PAH_TAG", sb2.toString());
            obj.getClass().getMethod("setServerSideVerificationOptions", ServerSideVerificationOptions.class).invoke(obj, new ServerSideVerificationOptions.Builder().setUserId(e10).setCustomData(a11).build());
        } catch (Exception e11) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "set ss ver err " + e11);
        }
    }

    public static void a(String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("shakable " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("shakable", str);
        a("setExtraUserData", (Class<?>[]) new Class[]{Map.class}, hashMap);
    }

    private static void a(String str, Class<?>[] clsArr, Object... objArr) {
        try {
            a(Class.forName("com.qq.e.comm.managers.setting.GlobalSetting"), str, clsArr, null, objArr);
            com.aggmoread.sdk.z.d.a.a.e.e.b("invoke");
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("e " + e10.getMessage());
        }
    }

    public static void a(boolean z10) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("isAgreePrivacy " + z10);
        a("setAgreePrivacyStrategy", (Class<?>[]) new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
    }
}
