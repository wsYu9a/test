package com.aggmoread.sdk.z.d.a.a.d.a.d.q;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.aggmoread.sdk.z.d.a.a.d.a.d.l;
import com.aggmoread.sdk.z.d.a.a.d.a.d.n;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.j;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.r.f;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.open.SocialConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends l {

    /* renamed from: a */
    private static a f5446a;

    /* renamed from: b */
    static AtomicBoolean f5447b = new AtomicBoolean();

    /* renamed from: c */
    private static AtomicBoolean f5448c = new AtomicBoolean();

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.a$a */
    public static class C0126a implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            return null;
        }
    }

    public static class b implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            return null;
        }
    }

    private a() {
    }

    private static int a(com.aggmoread.sdk.z.d.a.a.a aVar, String str, int i10) {
        if (aVar == null || !aVar.a(str)) {
            return -1;
        }
        return aVar.a(str, i10);
    }

    public static String b() {
        String sDKVersion = AdSettings.getSDKVersion();
        e.a("bd: sdkVersion " + sDKVersion);
        return sDKVersion;
    }

    public static int a(Object obj) {
        Exception e10;
        int i10;
        String str;
        int i11 = -1;
        try {
            Method method = obj.getClass().getMethod("getECPMLevel", null);
            method.setAccessible(true);
            str = (String) method.invoke(obj, null);
        } catch (Exception e11) {
            e10 = e11;
            i10 = -1;
        }
        if (!TextUtils.isEmpty(str)) {
            i10 = Integer.valueOf(str).intValue();
            if (i10 <= 0) {
                try {
                    e.a("bd c -1 ");
                } catch (Exception e12) {
                    e10 = e12;
                    e10.printStackTrace();
                    e.a("bd ecpm err " + e10.getMessage());
                    i11 = i10;
                    e.a("bd ecpm " + i11);
                    return i11;
                }
            }
            i11 = i10;
        }
        e.a("bd ecpm " + i11);
        return i11;
    }

    private String b(Object obj) {
        int i10;
        String str;
        String str2;
        Object obj2;
        String str3;
        boolean z10 = true;
        String str4 = "v1 ";
        String str5 = ", field ";
        if (obj != null) {
            try {
                Object a10 = j.a(obj, IAdInterListener.class);
                if (a10 != null) {
                    Class<?> cls = a10.getClass();
                    e.b("XXXXX", "preload k = " + cls);
                    Object b10 = j.b(j.a(a10, "adProdTemplate"), "f");
                    j.a(b10, "com.baidu.mobads.container.adrequest.s", "first template");
                    String obj3 = j.a(b10, "p").toString();
                    e.b("XXXXX", "jsonStr " + obj3);
                    try {
                        if (!TextUtils.isEmpty(obj3)) {
                            return a(obj3);
                        }
                        Field[] declaredFields = cls.getDeclaredFields();
                        int length = declaredFields.length;
                        int i11 = 0;
                        while (i11 < length) {
                            Field field = declaredFields[i11];
                            field.setAccessible(z10);
                            Object obj4 = field.get(a10);
                            StringBuilder sb2 = new StringBuilder();
                            Object obj5 = a10;
                            sb2.append("field ");
                            sb2.append(field.getName());
                            sb2.append(str5);
                            sb2.append(obj4);
                            e.b("XXXXX", sb2.toString());
                            if (obj4 != null && obj4.getClass().getName().contains("com.baidu.mobads.container.adrequest")) {
                                Field[] declaredFields2 = obj4.getClass().getDeclaredFields();
                                int length2 = declaredFields2.length;
                                int i12 = 0;
                                while (i12 < length2) {
                                    Field field2 = declaredFields2[i12];
                                    field2.setAccessible(true);
                                    Object obj6 = field2.get(obj4);
                                    StringBuilder sb3 = new StringBuilder();
                                    Field[] fieldArr = declaredFields2;
                                    sb3.append("field_ ");
                                    sb3.append(field2.getName());
                                    sb3.append(str5);
                                    sb3.append(obj6);
                                    e.b("XXXXX", sb3.toString());
                                    if (obj6 == null || !obj6.getClass().getName().equals("com.baidu.mobads.container.adrequest.ProdAdRequestInfo")) {
                                        i10 = length2;
                                        str = str4;
                                        str2 = str5;
                                        j.b(obj6, "com.baidu.mobads.container.adrequest.ProdAdRequestInfo", field2.getName() + ",ProdAdRequestInfo");
                                        j.b(obj6, "com.baidu.mobads.container.adrequest", field2.getName() + ", adreuqest");
                                    } else {
                                        Field field3 = obj6.getClass().getField("adProdTemplate");
                                        field3.setAccessible(true);
                                        Object obj7 = field3.get(obj6);
                                        if (com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()) {
                                            e.b("XXXXX", str4 + obj7);
                                            j.b(obj7, "com.baidu.mobads.container.adrequest", str4);
                                        }
                                        if (obj7 != null) {
                                            Field[] fields = obj7.getClass().getFields();
                                            int length3 = fields.length;
                                            int i13 = 0;
                                            while (i13 < length3) {
                                                int i14 = length2;
                                                Field field4 = fields[i13];
                                                String str6 = str4;
                                                field4.setAccessible(true);
                                                Object obj8 = field4.get(obj7);
                                                if (obj8 != null) {
                                                    obj2 = obj7;
                                                    StringBuilder sb4 = new StringBuilder();
                                                    str3 = str5;
                                                    sb4.append("vvv filed name ");
                                                    sb4.append(field4.getName());
                                                    e.b("XXXXX", sb4.toString());
                                                    if (obj8.getClass().getName().contains("com.baidu.mobads.container.adrequest.s")) {
                                                        Field declaredField = obj8.getClass().getDeclaredField("p");
                                                        declaredField.setAccessible(true);
                                                        String obj9 = declaredField.get(obj8).toString();
                                                        e.b("XXXXX", "final json = " + obj9);
                                                        if (!TextUtils.isEmpty(obj9)) {
                                                            return null;
                                                        }
                                                    } else {
                                                        continue;
                                                    }
                                                } else {
                                                    obj2 = obj7;
                                                    str3 = str5;
                                                }
                                                j.a(obj8, "com.baidu.mobads.container.adrequest.s", "s_tag");
                                                i13++;
                                                length2 = i14;
                                                str4 = str6;
                                                obj7 = obj2;
                                                str5 = str3;
                                            }
                                        }
                                        i10 = length2;
                                        str = str4;
                                        str2 = str5;
                                    }
                                    i12++;
                                    declaredFields2 = fieldArr;
                                    length2 = i10;
                                    str4 = str;
                                    str5 = str2;
                                }
                                return null;
                            }
                            i11++;
                            a10 = obj5;
                            str4 = str4;
                            str5 = str5;
                            z10 = true;
                        }
                        return null;
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        return null;
                    }
                }
            } catch (Exception e11) {
                e = e11;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.content.Context] */
    public static Context a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, f fVar) {
        ContextWrapper contextWrapper;
        ?? r02 = dVar.f5858d;
        try {
            boolean a10 = fVar.a(eVar);
            e.a("isHack " + a10);
            contextWrapper = r02;
            if (a10) {
                ContextWrapper dVar2 = dVar.f5858d instanceof Activity ? new com.aggmoread.sdk.z.d.a.a.e.r.d((Activity) dVar.f5858d) : new com.aggmoread.sdk.z.d.a.a.e.r.e(dVar.f5858d);
                fVar.a(dVar2, eVar, new Object[0]);
                contextWrapper = dVar2;
            }
        } catch (Exception e10) {
            e.a("hack err " + e10.getMessage());
            contextWrapper = dVar.f5858d;
        }
        e.a("getAdContext " + contextWrapper);
        return contextWrapper;
    }

    public static void b(Map<String, Object> map, int i10, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        a().a(map, i10, eVar);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f5446a == null) {
                    synchronized (a.class) {
                        try {
                            if (f5446a == null) {
                                f5446a = new a();
                            }
                        } finally {
                        }
                    }
                }
                aVar = f5446a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public String a(ExpressInterstitialAd expressInterstitialAd) {
        return b(j.a(expressInterstitialAd, "mNativeInterstitialAdProd"));
    }

    public String a(ExpressResponse expressResponse) {
        return b(j.a(expressResponse, "f"));
    }

    public String a(FullScreenVideoAd fullScreenVideoAd) {
        return b(j.a(fullScreenVideoAd, "mAdProd"));
    }

    public String a(RewardVideoAd rewardVideoAd) {
        return b(j.a(rewardVideoAd, "mAdProd"));
    }

    public String a(SplashAd splashAd) {
        return b(j.a(splashAd, "mAdProd"));
    }

    private String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(ExposeManager.UtArgsNames.reqId)) {
                e.b("XXXXX", "req_id " + jSONObject.optString(ExposeManager.UtArgsNames.reqId));
            }
            if (!jSONObject.has("ad")) {
                return null;
            }
            JSONObject jSONObject2 = jSONObject.optJSONArray("ad").getJSONObject(0);
            if (jSONObject2 == null || !jSONObject2.keys().hasNext()) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            if (jSONObject2.has("appname")) {
                String optString = jSONObject2.optString("appname");
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            if (jSONObject2.has("tit")) {
                String optString2 = jSONObject2.optString("tit");
                if (!TextUtils.isEmpty(optString2) && !arrayList.contains(optString2)) {
                    arrayList.add(optString2);
                }
            }
            if (jSONObject2.has(SocialConstants.PARAM_APP_DESC)) {
                String optString3 = jSONObject2.optString(SocialConstants.PARAM_APP_DESC);
                if (!TextUtils.isEmpty(optString3) && !arrayList.contains(optString3)) {
                    arrayList.add(optString3);
                }
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (i10 != 0) {
                    sb2.append("#");
                }
                sb2.append((String) arrayList.get(i10));
            }
            if (sb2.length() > 0) {
                return sb2.toString();
            }
            return null;
        } catch (Exception e10) {
            e.b("XXXXX", "err " + e10);
            return null;
        }
    }

    public static void a(Context context, String str) {
        int i10;
        if (context == null || TextUtils.isEmpty(str)) {
            e.b("BDAdSDK", "Context或APP_ID为空，初始化失败!");
            return;
        }
        if (f5448c.compareAndSet(false, true) && (i10 = n.f5391a) != -1) {
            c.a(i10 == 1);
        }
        try {
            if (f5447b.compareAndSet(false, true)) {
                new BDAdConfig.Builder().setAppName("union_sdk").setDebug(com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue()).setAppsid(str).build(context).init();
                MobadsPermissionSettings.setPermissionLocation(false);
            }
        } catch (Exception unused) {
            f5447b.set(false);
        }
    }

    public static void a(RequestParameters.Builder builder, d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        if (builder != null) {
            int a10 = a(dVar.f5875u, "com.sdk.key.BID_DSP", 5);
            int a11 = a(dVar.f5875u, "com.sdk.key.BID_PRICE", -1);
            e.a("supplement d " + a10 + ",p " + a11);
            if (a10 < 1 || a10 > 5 || a11 < 0) {
                return;
            }
            j.a(builder, "addCustExt", (Class<?>[]) new Class[]{String.class, String.class}, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "" + a10);
            j.a(builder, "addCustExt", (Class<?>[]) new Class[]{String.class, String.class}, "B", "" + a11);
            int a12 = a(dVar.f5875u, "com.sdk.key.BID_EXPOSED", 0);
            e.a("supplement e " + a12);
            if (a12 < 0 || a12 > 1) {
                return;
            }
            j.a(builder, "addCustExt", (Class<?>[]) new Class[]{String.class, String.class}, "C", "" + a12);
        }
    }

    public static void a(Object obj, int i10) {
        try {
            Method a10 = j.a(obj, "biddingSuccess", (Class<?>[]) new Class[]{String.class});
            if (a10 != null) {
                a10.invoke(obj, String.valueOf(i10));
            } else {
                Method a11 = j.a(obj, "biddingSuccess", (Class<?>[]) new Class[]{LinkedHashMap.class, BiddingListener.class});
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("ecpm", String.valueOf(i10));
                a11.invoke(obj, linkedHashMap, Proxy.newProxyInstance(BiddingListener.class.getClassLoader(), new Class[]{BiddingListener.class}, new b()));
            }
            e.a("bd send sus " + i10);
        } catch (Exception e10) {
            e.a("bd send sus err " + e10);
        }
    }

    public static void a(Object obj, RequestParameters requestParameters) {
        j.a(obj, "setRequestParameters", (Class<?>[]) new Class[]{RequestParameters.class}, requestParameters);
    }

    public static void a(Object obj, String str) {
        try {
            Method a10 = j.a(obj, "biddingFail", (Class<?>[]) new Class[]{String.class});
            if (a10 != null) {
                a10.invoke(obj, str);
            } else {
                Method a11 = j.a(obj, "biddingSuccess", (Class<?>[]) new Class[]{LinkedHashMap.class, BiddingListener.class});
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(MediationConstant.KEY_REASON, 203);
                a11.invoke(obj, linkedHashMap, Proxy.newProxyInstance(BiddingListener.class.getClassLoader(), new Class[]{BiddingListener.class}, new C0126a()));
            }
            e.a("bd send fail " + str);
        } catch (Exception e10) {
            e.a("bd send fail err " + e10);
        }
    }

    public static boolean a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, int i10) {
        return m.a(eVar, i10);
    }
}
