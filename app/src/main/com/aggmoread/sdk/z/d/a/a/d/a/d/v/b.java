package com.aggmoread.sdk.z.d.a.a.d.a.d.v;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.text.TextUtils;
import com.aggmoread.sdk.z.d.a.a.c.j;
import com.aggmoread.sdk.z.d.a.a.d.a.d.l;
import com.aggmoread.sdk.z.d.a.a.d.a.d.n;
import com.aggmoread.sdk.z.d.a.a.d.a.d.v.c;
import com.aggmoread.sdk.z.d.a.a.d.b.g;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.AdExposureFailureCode;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class b extends l {

    /* renamed from: a */
    private static b f5746a;

    /* renamed from: b */
    private static AtomicBoolean f5747b = new AtomicBoolean();

    public static class a extends KsCustomController {

        /* renamed from: a */
        final /* synthetic */ j f5748a;

        public a(j jVar) {
            this.f5748a = jVar;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadInstalledPackages() {
            return this.f5748a.a();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canReadLocation() {
            return this.f5748a.b();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseMacAddress() {
            return this.f5748a.c();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseNetworkState() {
            return this.f5748a.d();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseOaid() {
            return this.f5748a.e();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUsePhoneState() {
            return this.f5748a.f();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public boolean canUseStoragePermission() {
            return this.f5748a.g();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getAndroidId() {
            return this.f5748a.h();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getImei() {
            return this.f5748a.j();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String[] getImeis() {
            return this.f5748a.k();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public List<String> getInstalledPackages() {
            ArrayList arrayList = new ArrayList();
            List<PackageInfo> l10 = this.f5748a.l();
            if (l10 != null) {
                Iterator<PackageInfo> it = l10.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().packageName);
                }
            }
            return arrayList;
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public Location getLocation() {
            return this.f5748a.m();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getMacAddress() {
            return this.f5748a.n();
        }

        @Override // com.kwad.sdk.api.KsCustomController
        public String getOaid() {
            return this.f5748a.o();
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.v.b$b */
    public static class C0170b implements c.b {
        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.c.b
        public void a() {
            e.b("KSAdSDK", "ks start fail  ");
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.v.c.b
        public void b() {
            e.b("KSAdSDK", "ks start success  ");
        }
    }

    private b() {
    }

    public static int a(Object obj) {
        Exception e10;
        int i10;
        try {
            Method method = obj.getClass().getMethod("getECPM", null);
            method.setAccessible(true);
            i10 = ((Integer) method.invoke(obj, null)).intValue();
            if (i10 <= 0) {
                try {
                    e.a("c -1 ");
                    return -1;
                } catch (Exception e11) {
                    e10 = e11;
                    e10.printStackTrace();
                    e.a("ks ecpm err " + e10.getMessage());
                    return i10;
                }
            }
        } catch (Exception e12) {
            e10 = e12;
            i10 = -1;
        }
        return i10;
    }

    public static String b() {
        return KsAdSDK.getSDKVersion();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f5746a == null) {
                    synchronized (b.class) {
                        try {
                            if (f5746a == null) {
                                f5746a = new b();
                            }
                        } finally {
                        }
                    }
                }
                bVar = f5746a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bVar;
    }

    public static void b(Object obj, int i10) {
        a(obj, "setBidEcpm", new Object[]{Integer.valueOf(i10)}, Integer.TYPE);
        e.a("ks send success end");
    }

    private static Object a(Object obj, String str, Object[] objArr, Class... clsArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Exception e10) {
            e.a("ks invoke method failed,  method " + str + ", err " + e10.getMessage());
            return null;
        }
    }

    public static void b(Map<String, Object> map, int i10, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        a().a(map, i10, eVar);
    }

    public String a(KsDrawAd ksDrawAd) {
        if (ksDrawAd == null) {
            return null;
        }
        List<Object> a10 = a(ksDrawAd, AdInfo.class);
        if (a10.size() <= 0) {
            return null;
        }
        Object obj = a10.get(0);
        if (obj instanceof AdInfo) {
            return a((AdInfo) obj);
        }
        return null;
    }

    public String a(KsFeedAd ksFeedAd) {
        if (ksFeedAd == null) {
            return null;
        }
        List<Object> a10 = a(ksFeedAd, AdInfo.class);
        if (a10.size() <= 0) {
            return null;
        }
        Object obj = a10.get(0);
        if (obj instanceof AdInfo) {
            return a((AdInfo) obj);
        }
        return null;
    }

    public String a(KsFullScreenVideoAd ksFullScreenVideoAd) {
        if (ksFullScreenVideoAd == null) {
            return null;
        }
        List<Object> a10 = a(ksFullScreenVideoAd, AdInfo.class);
        if (a10.size() <= 0) {
            return null;
        }
        Object obj = a10.get(0);
        if (obj instanceof AdInfo) {
            return a((AdInfo) obj);
        }
        return null;
    }

    public String a(KsInterstitialAd ksInterstitialAd) {
        if (ksInterstitialAd == null) {
            return null;
        }
        List<Object> a10 = a(ksInterstitialAd, AdTemplate.class);
        if (a10.size() <= 0) {
            return null;
        }
        Object obj = a10.get(0);
        if (obj instanceof AdTemplate) {
            return a((AdTemplate) obj);
        }
        return null;
    }

    public String a(KsRewardVideoAd ksRewardVideoAd) {
        if (ksRewardVideoAd == null) {
            return null;
        }
        List<Object> a10 = a(ksRewardVideoAd, AdInfo.class);
        if (a10.size() <= 0) {
            return null;
        }
        Object obj = a10.get(0);
        if (obj instanceof AdInfo) {
            return a((AdInfo) obj);
        }
        return null;
    }

    public String a(KsSplashScreenAd ksSplashScreenAd) {
        List<AdInfo> list;
        if (ksSplashScreenAd == null) {
            return null;
        }
        List<Object> a10 = a(ksSplashScreenAd, AdTemplate.class);
        if (a10.size() <= 0) {
            return null;
        }
        Object obj = a10.get(0);
        if (!(obj instanceof AdTemplate) || (list = ((AdTemplate) obj).adInfoList) == null || list.size() <= 0) {
            return null;
        }
        return a(list.get(0));
    }

    private String a(AdInfo adInfo) {
        if (adInfo == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            AdInfo.AdBaseInfo adBaseInfo = adInfo.adBaseInfo;
            e.b("XXXXX", "adBaseInfo = [ appCategory " + adBaseInfo.appCategory + ", appName " + adBaseInfo.appName + ", adDescription " + adBaseInfo.adDescription + ", productName " + adBaseInfo.productName + "]");
            if (!TextUtils.isEmpty(adBaseInfo.appCategory)) {
                sb2.append(adBaseInfo.appCategory);
            }
            if (!TextUtils.isEmpty(adBaseInfo.appName)) {
                if (!TextUtils.isEmpty(sb2.toString())) {
                    sb2.append("#");
                }
                sb2.append(adBaseInfo.appName);
            }
            String sb3 = sb2.toString();
            if (!TextUtils.isEmpty(sb3)) {
                return sb3;
            }
            sb2.delete(0, sb2.length());
            String str = adBaseInfo.adDescription;
            if (!TextUtils.isEmpty(str)) {
                sb2.append(str);
            }
            String str2 = adBaseInfo.productName;
            if (!TextUtils.isEmpty(str2)) {
                sb2.append("#");
                sb2.append(str2);
            }
            return sb2.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            e.b("XXXXX", "getAdInfoStr err " + e10.getMessage());
            return null;
        }
    }

    private String a(AdTemplate adTemplate) {
        List<AdInfo> list;
        if (adTemplate == null || (list = adTemplate.adInfoList) == null || list.size() <= 0) {
            return null;
        }
        return a(list.get(0));
    }

    private List<Object> a(Object obj, Class cls) {
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> cls2 = obj.getClass();
            e.b("XXXXX", "getFieldValueByClassName ");
            Field[] declaredFields = cls2.getDeclaredFields();
            if (declaredFields.length > 0) {
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    e.b("XXXXX", "field name " + field.getName() + ", value " + obj2);
                    if (obj2 != null && obj2.getClass() == cls) {
                        arrayList.add(obj2);
                    }
                }
            }
        } catch (Exception e10) {
            e.b("XXXXX", "get field value err " + e10.getMessage());
        }
        return arrayList;
    }

    public static void a(Object obj, int i10) {
        try {
            Object obj2 = AdExposureFailureCode.class.getDeclaredField("BID_FAILED").get(null);
            Object newInstance = AdExposureFailedReason.class.getConstructor(null).newInstance(null);
            AdExposureFailedReason.class.getField("winEcpm").setInt(newInstance, i10);
            a(obj, "reportAdExposureFailed", new Object[]{obj2, newInstance}, Integer.TYPE, AdExposureFailedReason.class);
            e.a("ks send failed end");
        } catch (Exception e10) {
            e.a("ks send failed err " + e10.getMessage());
        }
    }

    public static boolean a(Context context, String str) {
        String appId = KsAdSDK.getAppId();
        if (!TextUtils.isEmpty(appId) && appId.equals(str)) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            e.b("KSAdSDK", "Context或APP_ID为空，初始化失败!");
            return false;
        }
        e.b("KSAdSDK", "ks init appId " + str);
        if (f5747b.compareAndSet(false, true)) {
            int i10 = n.f5391a;
            if (i10 != -1) {
                c.a(i10 == 1);
            }
            if (n.f5392b != -1) {
                c.a().b(n.f5392b == 0);
            }
        }
        SdkConfig.Builder debug = new SdkConfig.Builder().appId(str).showNotification(true).debug(com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue());
        j b10 = g.a().b();
        if (b10 != null) {
            debug.customController(new a(b10));
        }
        c.a(debug, new C0170b());
        boolean init = KsAdSDK.init(context.getApplicationContext(), debug.build());
        String appId2 = KsAdSDK.getAppId();
        c.c();
        boolean z10 = init && !TextUtils.isEmpty(appId2) && appId2.equals(str);
        e.b("KSAdSDK", "ks init result  " + z10);
        return z10;
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, int i10) {
        return m.a(eVar, i10);
    }
}
