package com.opos.mobad.cmn.a.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.SplashAd;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.oplus.quickgame.sdk.hall.Constant;
import com.opos.acs.st.STManager;
import com.opos.mobad.activity.VideoActivity;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.provider.statistic.StatisticModelIdentify;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: com.opos.mobad.cmn.a.b.d$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20113a;

        /* renamed from: b */
        final /* synthetic */ String f20114b;

        /* renamed from: c */
        final /* synthetic */ String f20115c;

        /* renamed from: d */
        final /* synthetic */ long f20116d;

        /* renamed from: e */
        final /* synthetic */ String f20117e;

        /* renamed from: f */
        final /* synthetic */ String f20118f;

        /* renamed from: g */
        final /* synthetic */ String f20119g;

        /* renamed from: h */
        final /* synthetic */ boolean f20120h;

        /* renamed from: i */
        final /* synthetic */ String f20121i;

        /* renamed from: j */
        final /* synthetic */ int f20122j;

        AnonymousClass1(Context context, String str, String str2, long j2, String str3, String str4, String str5, boolean z, String str6, int i2) {
            context = context;
            str = str;
            str3 = str2;
            j2 = j2;
            str4 = str3;
            str5 = str4;
            str2 = str5;
            z = z;
            str6 = str6;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    b2.put("adSource", "");
                    d.i(b2, str3);
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("ret", "1");
                    String str = str4;
                    if (str == null) {
                        str = "";
                    }
                    b2.put("filteIds", str);
                    String str2 = str5;
                    if (str2 == null) {
                        str2 = "";
                    }
                    b2.put("st", str2);
                    d.g(b2, str2);
                    b2.put("cache", z ? "1" : "0");
                    String str3 = str6;
                    if (str3 == null) {
                        str3 = "";
                    }
                    b2.put("classifyByAge", str3);
                    b2.put(SplashAd.KEY_BIDFAIL_ECPM, i2 + "");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$10 */
    static final class AnonymousClass10 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20124b;

        /* renamed from: c */
        final /* synthetic */ Context f20125c;

        /* renamed from: d */
        final /* synthetic */ boolean f20126d;

        /* renamed from: e */
        final /* synthetic */ int[] f20127e;

        /* renamed from: f */
        final /* synthetic */ Map f20128f;

        AnonymousClass10(MaterialData materialData, Context context, boolean z, int[] iArr, Map map) {
            materialData = materialData;
            context = context;
            z = z;
            iArr = iArr;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-click");
                d.h(b2, AdItemData.this.g());
                b2.put("valid", z ? "1" : "0");
                b2.put("evtType", "7");
                b2.put("dlChannel", materialData.t());
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                d.b(iArr, (Map<String, String>) b2);
                d.b((Map<String, String>) b2);
                Map map = map;
                if (map != null && map.size() > 0) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdLaunchAppHomePageEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$11 */
    static final class AnonymousClass11 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20129a;

        /* renamed from: b */
        final /* synthetic */ String f20130b;

        /* renamed from: c */
        final /* synthetic */ String f20131c;

        /* renamed from: d */
        final /* synthetic */ long f20132d;

        /* renamed from: e */
        final /* synthetic */ int f20133e;

        /* renamed from: f */
        final /* synthetic */ boolean f20134f;

        /* renamed from: g */
        final /* synthetic */ String f20135g;

        /* renamed from: h */
        final /* synthetic */ String f20136h;

        /* renamed from: i */
        final /* synthetic */ String f20137i;

        AnonymousClass11(Context context, String str, String str2, long j2, int i2, boolean z, String str3, String str4, String str5) {
            context = context;
            str = str;
            str2 = str2;
            j2 = j2;
            i2 = i2;
            z = z;
            str3 = str3;
            str4 = str4;
            str5 = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    b2.put("adSource", "");
                    d.i(b2, str2);
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("ret", "2");
                    d.g(b2, "");
                    HashMap hashMap = new HashMap();
                    hashMap.put("rsCode", "" + i2);
                    b2.put("cache", z ? "1" : "0");
                    String str = str3;
                    if (str == null) {
                        str = "";
                    }
                    b2.put("filteIds", str);
                    String str2 = str4;
                    if (str2 == null) {
                        str2 = "";
                    }
                    b2.put("st", str2);
                    String str3 = str5;
                    if (str3 == null) {
                        str3 = "";
                    }
                    b2.put("classifyByAge", str3);
                    if (hashMap.size() > 0) {
                        b2.putAll(hashMap);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$12 */
    static final class AnonymousClass12 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20139b;

        /* renamed from: c */
        final /* synthetic */ Context f20140c;

        AnonymousClass12(MaterialData materialData, Context context) {
            materialData = materialData;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                b2.put(STManager.KEY_DATA_TYPE, "lm-common");
                b2.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                d.b((Map<String, String>) b2);
                b2.put("valid", "1");
                b2.put("dlChannel", materialData.t());
                b2.put("data_event", "1");
                b2.put("status", "1");
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderStartEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$13 */
    static final class AnonymousClass13 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20142b;

        /* renamed from: c */
        final /* synthetic */ Context f20143c;

        AnonymousClass13(MaterialData materialData, Context context) {
            materialData = materialData;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                b2.put(STManager.KEY_DATA_TYPE, "lm-common");
                b2.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                d.b((Map<String, String>) b2);
                b2.put("valid", "1");
                b2.put("dlChannel", materialData.t());
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                b2.put("data_event", "1");
                b2.put("status", "3");
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderCompleteEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$14 */
    static final class AnonymousClass14 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20145b;

        /* renamed from: c */
        final /* synthetic */ Context f20146c;

        /* renamed from: d */
        final /* synthetic */ String f20147d;

        AnonymousClass14(MaterialData materialData, Context context, String str) {
            materialData = materialData;
            context = context;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                b2.put(STManager.KEY_DATA_TYPE, "lm-common");
                b2.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                d.b((Map<String, String>) b2);
                b2.put("valid", "1");
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                b2.put("dlChannel", materialData.t());
                b2.put("data_event", "1");
                b2.put("status", "2");
                if (!TextUtils.isEmpty(str)) {
                    b2.put("errormsg", str);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderFailEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$15 */
    static final class AnonymousClass15 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20149b;

        /* renamed from: c */
        final /* synthetic */ Context f20150c;

        /* renamed from: d */
        final /* synthetic */ boolean f20151d;

        /* renamed from: e */
        final /* synthetic */ int[] f20152e;

        /* renamed from: f */
        final /* synthetic */ Map f20153f;

        AnonymousClass15(MaterialData materialData, Context context, boolean z, int[] iArr, Map map) {
            materialData = materialData;
            context = context;
            z = z;
            iArr = iArr;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-click");
                d.h(b2, AdItemData.this.g());
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                b2.put("evtType", BaseWrapper.ENTER_ID_MESSAGE);
                d.b((Map<String, String>) b2);
                b2.put("valid", z ? "1" : "0");
                d.b(iArr, (Map<String, String>) b2);
                Map map = map;
                if (map != null && map.size() > 0) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$16 */
    static final class AnonymousClass16 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20154a;

        /* renamed from: b */
        final /* synthetic */ String f20155b;

        /* renamed from: c */
        final /* synthetic */ String f20156c;

        /* renamed from: d */
        final /* synthetic */ int f20157d;

        AnonymousClass16(Context context, String str, String str2, int i2) {
            context = context;
            str = str;
            str2 = str2;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Map b2 = d.b(context);
                b2.put(STManager.KEY_DATA_TYPE, "lm-activation");
                b2.put(STManager.KEY_AD_POS_ID, str);
                String str = str2;
                if (str == null) {
                    str = "";
                }
                b2.put(Constant.ParamObjKey.KEY_EXTERNAL_TARGET_PKG, str);
                b2.put("code", String.valueOf(i2));
                d.b(context, (String) null, (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("STEventUtils", "", e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$17 */
    static final class AnonymousClass17 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20159b;

        /* renamed from: c */
        final /* synthetic */ Context f20160c;

        /* renamed from: d */
        final /* synthetic */ String f20161d;

        /* renamed from: e */
        final /* synthetic */ int f20162e;

        AnonymousClass17(MaterialData materialData, Context context, String str, int i2) {
            materialData = materialData;
            context = context;
            str = str;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                b2.put(STManager.KEY_DATA_TYPE, "lm-feedback");
                b2.put(STManager.KEY_AD_POS_ID, str);
                b2.put("uSdkVC", f.h() + "");
                b2.put("fbContent", i2 + "");
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFeedbackEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$18 */
    static final class AnonymousClass18 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20163a;

        /* renamed from: b */
        final /* synthetic */ String f20164b;

        /* renamed from: c */
        final /* synthetic */ int f20165c;

        /* renamed from: d */
        final /* synthetic */ String f20166d;

        /* renamed from: e */
        final /* synthetic */ long f20167e;

        /* renamed from: f */
        final /* synthetic */ String f20168f;

        AnonymousClass18(Context context, String str, int i2, String str2, long j2, String str3) {
            context = context;
            str = str;
            i2 = i2;
            str2 = str2;
            j2 = j2;
            str3 = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                    b2.put("rsCode", String.valueOf(i2));
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    d.i(b2, str2);
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("type", "2");
                    String str = str3;
                    if (str == null) {
                        str = "";
                    }
                    b2.put("adStates", str);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCatchFetchEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$19 */
    static final class AnonymousClass19 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20169a;

        /* renamed from: b */
        final /* synthetic */ String f20170b;

        /* renamed from: c */
        final /* synthetic */ String f20171c;

        /* renamed from: d */
        final /* synthetic */ int f20172d;

        /* renamed from: e */
        final /* synthetic */ long f20173e;

        AnonymousClass19(Context context, String str, String str2, int i2, long j2) {
            context = context;
            str = str;
            str2 = str2;
            i2 = i2;
            j2 = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    d.i(b2, str2);
                    b2.put("rsCode", String.valueOf(i2));
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("type", "1");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$2 */
    static final class AnonymousClass2 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20175b;

        /* renamed from: c */
        final /* synthetic */ Context f20176c;

        /* renamed from: d */
        final /* synthetic */ String f20177d;

        /* renamed from: e */
        final /* synthetic */ boolean f20178e;

        /* renamed from: f */
        final /* synthetic */ int f20179f;

        /* renamed from: g */
        final /* synthetic */ Map f20180g;

        AnonymousClass2(MaterialData materialData, Context context, String str, boolean z, int i2, Map map) {
            materialData = materialData;
            context = context;
            str = str;
            z = z;
            i2 = i2;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-expose");
                d.h(b2, str);
                b2.put("valid", z ? "1" : "0");
                b2.put("sspWinPrice", i2 + "");
                d.b((Map<String, String>) b2);
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                Map map = map;
                if (map != null && map.size() > 0) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$20 */
    static final class AnonymousClass20 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20181a;

        /* renamed from: b */
        final /* synthetic */ String f20182b;

        /* renamed from: c */
        final /* synthetic */ String f20183c;

        /* renamed from: d */
        final /* synthetic */ long f20184d;

        /* renamed from: e */
        final /* synthetic */ String f20185e;

        /* renamed from: f */
        final /* synthetic */ String f20186f;

        /* renamed from: g */
        final /* synthetic */ boolean f20187g;

        /* renamed from: h */
        final /* synthetic */ String f20188h;

        /* renamed from: i */
        final /* synthetic */ int f20189i;

        AnonymousClass20(Context context, String str, String str2, long j2, String str3, String str4, boolean z, String str5, int i2) {
            context = context;
            str = str;
            str3 = str2;
            j2 = j2;
            str4 = str3;
            str2 = str4;
            z = z;
            str5 = str5;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    b2.put("adSource", "");
                    d.i(b2, str3);
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("ret", "1");
                    String str = str4;
                    if (str == null) {
                        str = "";
                    }
                    b2.put(UMModuleRegister.PROCESS, str);
                    d.g(b2, str2);
                    b2.put("cache", z ? "1" : "0");
                    String str2 = str5;
                    if (str2 == null) {
                        str2 = "";
                    }
                    b2.put("classifyByAge", str2);
                    b2.put(SplashAd.KEY_BIDFAIL_ECPM, i2 + "");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$21 */
    static final class AnonymousClass21 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20190a;

        /* renamed from: b */
        final /* synthetic */ String f20191b;

        /* renamed from: c */
        final /* synthetic */ String f20192c;

        /* renamed from: d */
        final /* synthetic */ long f20193d;

        /* renamed from: e */
        final /* synthetic */ int f20194e;

        /* renamed from: f */
        final /* synthetic */ boolean f20195f;

        /* renamed from: g */
        final /* synthetic */ String f20196g;

        /* renamed from: h */
        final /* synthetic */ String f20197h;

        AnonymousClass21(Context context, String str, String str2, long j2, int i2, boolean z, String str3, String str4) {
            context = context;
            str = str;
            str2 = str2;
            j2 = j2;
            i2 = i2;
            z = z;
            str3 = str3;
            str4 = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    b2.put("adSource", "");
                    d.i(b2, str2);
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("ret", "2");
                    d.g(b2, "");
                    HashMap hashMap = new HashMap();
                    hashMap.put("rsCode", "" + i2);
                    b2.put("cache", z ? "1" : "0");
                    String str = str3;
                    if (str == null) {
                        str = "";
                    }
                    b2.put(UMModuleRegister.PROCESS, str);
                    String str2 = str4;
                    if (str2 == null) {
                        str2 = "";
                    }
                    b2.put("classifyByAge", str2);
                    if (hashMap.size() > 0) {
                        b2.putAll(hashMap);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$22 */
    static final class AnonymousClass22 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20198a;

        /* renamed from: b */
        final /* synthetic */ String f20199b;

        /* renamed from: c */
        final /* synthetic */ String f20200c;

        /* renamed from: d */
        final /* synthetic */ String f20201d;

        /* renamed from: e */
        final /* synthetic */ long f20202e;

        /* renamed from: f */
        final /* synthetic */ boolean f20203f;

        /* renamed from: g */
        final /* synthetic */ String f20204g;

        /* renamed from: h */
        final /* synthetic */ String f20205h;

        AnonymousClass22(Context context, String str, String str2, String str3, long j2, boolean z, String str4, String str5) {
            context = context;
            str = str;
            str2 = str2;
            str3 = str3;
            j2 = j2;
            z = z;
            str4 = str4;
            str5 = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    d.i(b2, str2);
                    b2.put("ret", str3);
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("type", z ? "2" : "1");
                    String str = str4;
                    if (str == null) {
                        str = "";
                    }
                    b2.put("filteIds", str);
                    String str2 = str5;
                    if (str2 == null) {
                        str2 = "";
                    }
                    b2.put("st", str2);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$23 */
    static final class AnonymousClass23 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20206a;

        /* renamed from: b */
        final /* synthetic */ String f20207b;

        /* renamed from: c */
        final /* synthetic */ String f20208c;

        /* renamed from: d */
        final /* synthetic */ int f20209d;

        /* renamed from: e */
        final /* synthetic */ long f20210e;

        /* renamed from: f */
        final /* synthetic */ boolean f20211f;

        /* renamed from: g */
        final /* synthetic */ String f20212g;

        /* renamed from: h */
        final /* synthetic */ String f20213h;

        AnonymousClass23(Context context, String str, String str2, int i2, long j2, boolean z, String str3, String str4) {
            context = context;
            str = str;
            str2 = str2;
            i2 = i2;
            j2 = j2;
            z = z;
            str3 = str3;
            str4 = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    d.i(b2, str2);
                    b2.put("rsCode", String.valueOf(i2));
                    b2.put("ret", "2");
                    b2.put("rt", String.valueOf(j2));
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("type", z ? "2" : "1");
                    String str = str3;
                    if (str == null) {
                        str = "";
                    }
                    b2.put("filteIds", str);
                    String str2 = str4;
                    if (str2 == null) {
                        str2 = "";
                    }
                    b2.put("st", str2);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$24 */
    static final class AnonymousClass24 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20214a;

        /* renamed from: b */
        final /* synthetic */ String f20215b;

        /* renamed from: c */
        final /* synthetic */ String f20216c;

        /* renamed from: d */
        final /* synthetic */ String f20217d;

        /* renamed from: e */
        final /* synthetic */ String f20218e;

        /* renamed from: f */
        final /* synthetic */ String f20219f;

        /* renamed from: g */
        final /* synthetic */ Map f20220g;

        AnonymousClass24(Context context, String str, String str2, String str3, String str4, String str5, Map map) {
            context = context;
            str2 = str;
            str = str2;
            str5 = str3;
            str3 = str4;
            str4 = str5;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (com.opos.mobad.model.e.d.a(context, str2)) {
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                    b2.put(STManager.KEY_AD_POS_ID, str2);
                    b2.put("adSource", str);
                    d.i(b2, str5);
                    b2.put("ret", str3);
                    d.g(b2, str4);
                    Map map = map;
                    if (map != null && map.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                    d.b(context, (Map<String, String>) b2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$3 */
    static final class AnonymousClass3 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20222b;

        /* renamed from: c */
        final /* synthetic */ Context f20223c;

        /* renamed from: d */
        final /* synthetic */ String f20224d;

        /* renamed from: e */
        final /* synthetic */ boolean f20225e;

        /* renamed from: f */
        final /* synthetic */ int[] f20226f;

        /* renamed from: g */
        final /* synthetic */ Map f20227g;

        AnonymousClass3(MaterialData materialData, Context context, String str, boolean z, int[] iArr, Map map) {
            materialData = materialData;
            context = context;
            str = str;
            z = z;
            iArr = iArr;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-click");
                d.h(b2, str);
                b2.put("evtType", "1");
                b2.put("valid", z ? "1" : "0");
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                d.b(iArr, (Map<String, String>) b2);
                d.b((Map<String, String>) b2);
                Map map = map;
                if (map != null && map.size() > 0) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$4 */
    static final class AnonymousClass4 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20229b;

        /* renamed from: c */
        final /* synthetic */ Context f20230c;

        /* renamed from: d */
        final /* synthetic */ String f20231d;

        /* renamed from: e */
        final /* synthetic */ boolean f20232e;

        /* renamed from: f */
        final /* synthetic */ int[] f20233f;

        /* renamed from: g */
        final /* synthetic */ Map f20234g;

        AnonymousClass4(MaterialData materialData, Context context, String str, boolean z, int[] iArr, Map map) {
            materialData = materialData;
            context = context;
            str = str;
            z = z;
            iArr = iArr;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-click");
                d.h(b2, str);
                b2.put("evtType", "4");
                b2.put("valid", z ? "1" : "0");
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                d.b(iArr, (Map<String, String>) b2);
                d.b((Map<String, String>) b2);
                Map map = map;
                if (map != null && map.size() > 0) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$5 */
    static final class AnonymousClass5 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20236b;

        /* renamed from: c */
        final /* synthetic */ Context f20237c;

        /* renamed from: d */
        final /* synthetic */ String f20238d;

        /* renamed from: e */
        final /* synthetic */ int[] f20239e;

        /* renamed from: f */
        final /* synthetic */ boolean f20240f;

        /* renamed from: g */
        final /* synthetic */ Map f20241g;

        AnonymousClass5(MaterialData materialData, Context context, String str, int[] iArr, boolean z, Map map) {
            materialData = materialData;
            context = context;
            str = str;
            iArr = iArr;
            z = z;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map map;
            String str = "2";
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-click");
                b2.put("evtType", "2");
                d.h(b2, str);
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                d.b(iArr, (Map<String, String>) b2);
                if (z) {
                    str = "3";
                } else {
                    if (1 != AdItemData.this.k()) {
                        if (2 == AdItemData.this.k()) {
                        }
                        d.b((Map<String, String>) b2);
                        map = map;
                        if (map != null && map.size() > 0) {
                            b2.putAll(map);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", b2);
                        d.b(context, materialData.r(), (Map<String, String>) b2);
                    }
                    str = "1";
                }
                d.a((Map<String, String>) b2, str);
                d.b((Map<String, String>) b2);
                map = map;
                if (map != null) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$6 */
    static final class AnonymousClass6 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20243b;

        /* renamed from: c */
        final /* synthetic */ Context f20244c;

        /* renamed from: d */
        final /* synthetic */ String f20245d;

        /* renamed from: e */
        final /* synthetic */ boolean f20246e;

        /* renamed from: f */
        final /* synthetic */ int[] f20247f;

        /* renamed from: g */
        final /* synthetic */ Map f20248g;

        AnonymousClass6(MaterialData materialData, Context context, String str, boolean z, int[] iArr, Map map) {
            materialData = materialData;
            context = context;
            str = str;
            z = z;
            iArr = iArr;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.h(b2, str);
                d.j(b2, "lm-click");
                b2.put("evtType", "5");
                b2.put("valid", z ? "1" : "0");
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                d.b(iArr, (Map<String, String>) b2);
                d.b((Map<String, String>) b2);
                Map map = map;
                if (map != null && map.size() > 0) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordDeepLinkEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$7 */
    static final class AnonymousClass7 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20250b;

        /* renamed from: c */
        final /* synthetic */ Context f20251c;

        /* renamed from: d */
        final /* synthetic */ String f20252d;

        /* renamed from: e */
        final /* synthetic */ boolean f20253e;

        /* renamed from: f */
        final /* synthetic */ Map f20254f;

        AnonymousClass7(MaterialData materialData, Context context, String str, boolean z, Map map) {
            materialData = materialData;
            context = context;
            str = str;
            z = z;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-play");
                d.h(b2, str);
                d.b((Map<String, String>) b2);
                b2.put("valid", z ? "1" : "0");
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                Map map = map;
                if (map != null && map.size() > 0) {
                    b2.putAll(map);
                }
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$8 */
    static final class AnonymousClass8 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f20255a;

        /* renamed from: b */
        final /* synthetic */ String f20256b;

        /* renamed from: c */
        final /* synthetic */ boolean f20257c;

        /* renamed from: d */
        final /* synthetic */ String f20258d;

        /* renamed from: e */
        final /* synthetic */ AdItemData f20259e;

        /* renamed from: f */
        final /* synthetic */ MaterialData f20260f;

        /* renamed from: g */
        final /* synthetic */ int f20261g;

        AnonymousClass8(Context context, String str, boolean z, String str2, AdItemData adItemData, MaterialData materialData, int i2) {
            context = context;
            str = str;
            z = z;
            str2 = str2;
            adItemData = adItemData;
            materialData = materialData;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Map b2 = d.b(context);
                d.j(b2, "lm-play");
                d.h(b2, str);
                d.b((Map<String, String>) b2);
                b2.put("valid", z ? "1" : "0");
                if (!TextUtils.isEmpty(str2)) {
                    b2.put("clientTemplateId", str2);
                }
                d.b(adItemData, materialData, (Map<String, String>) b2);
                d.b(i2, (Map<String, String>) b2);
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b2);
                Context context = context;
                MaterialData materialData = materialData;
                d.b(context, materialData != null ? materialData.r() : "", (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.cmn.a.b.d$9 */
    static final class AnonymousClass9 implements Runnable {

        /* renamed from: b */
        final /* synthetic */ MaterialData f20263b;

        /* renamed from: c */
        final /* synthetic */ Context f20264c;

        AnonymousClass9(MaterialData materialData, Context context) {
            materialData = materialData;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (AdItemData.this == null || materialData == null) {
                    return;
                }
                Map b2 = d.b(context);
                d.j(b2, "lm-click");
                d.h(b2, AdItemData.this.g());
                b2.put("evtType", "6");
                d.b((Map<String, String>) b2);
                b2.put("valid", "1");
                b2.put("dlChannel", materialData.t());
                d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                com.opos.cmn.an.f.a.b("STEventUtils", "recordAdInstallCompleteEvent map=", b2);
                d.b(context, materialData.r(), (Map<String, String>) b2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
            case "1":
                return "3";
            case "2":
                return "1";
            case "3":
                return "10";
            case "4":
                return "7";
            case "5":
                return "8";
            case "6":
                return BaseWrapper.ENTER_ID_MESSAGE;
            default:
                return "";
        }
    }

    public static Map<String, String> a(long j2, long j3) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("vDrt", j3 + "");
            hashMap.put("vedioduration", j3 + "");
            hashMap.put("vPlyPos", j2 + "");
            hashMap.put("currentPos", j2 + "");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
        }
        return hashMap;
    }

    public static Map<String, String> a(String str, long j2, long j3) {
        HashMap hashMap = new HashMap();
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                Map<String, String> a2 = a(j2, j3);
                if (a2 != null && a2.size() > 0) {
                    hashMap.putAll(a2);
                }
                hashMap.put("vPrs", str);
                hashMap.put("playProgress", str);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
        }
        return hashMap;
    }

    public static void a(Context context, AdItemData adItemData, MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.9

            /* renamed from: b */
            final /* synthetic */ MaterialData f20263b;

            /* renamed from: c */
            final /* synthetic */ Context f20264c;

            AnonymousClass9(MaterialData materialData2, Context context2) {
                materialData = materialData2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-click");
                    d.h(b2, AdItemData.this.g());
                    b2.put("evtType", "6");
                    d.b((Map<String, String>) b2);
                    b2.put("valid", "1");
                    b2.put("dlChannel", materialData.t());
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdInstallCompleteEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, AdItemData adItemData, MaterialData materialData, String str) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.14

            /* renamed from: b */
            final /* synthetic */ MaterialData f20145b;

            /* renamed from: c */
            final /* synthetic */ Context f20146c;

            /* renamed from: d */
            final /* synthetic */ String f20147d;

            AnonymousClass14(MaterialData materialData2, Context context2, String str2) {
                materialData = materialData2;
                context = context2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-common");
                    b2.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                    d.b((Map<String, String>) b2);
                    b2.put("valid", "1");
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    b2.put("dlChannel", materialData.t());
                    b2.put("data_event", "1");
                    b2.put("status", "2");
                    if (!TextUtils.isEmpty(str)) {
                        b2.put("errormsg", str);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderFailEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr) {
        a(context, adItemData, materialData, z, iArr, (Map<String, String>) null);
    }

    public static void a(Context context, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.10

            /* renamed from: b */
            final /* synthetic */ MaterialData f20124b;

            /* renamed from: c */
            final /* synthetic */ Context f20125c;

            /* renamed from: d */
            final /* synthetic */ boolean f20126d;

            /* renamed from: e */
            final /* synthetic */ int[] f20127e;

            /* renamed from: f */
            final /* synthetic */ Map f20128f;

            AnonymousClass10(MaterialData materialData2, Context context2, boolean z2, int[] iArr2, Map map2) {
                materialData = materialData2;
                context = context2;
                z = z2;
                iArr = iArr2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-click");
                    d.h(b2, AdItemData.this.g());
                    b2.put("valid", z ? "1" : "0");
                    b2.put("evtType", "7");
                    b2.put("dlChannel", materialData.t());
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    d.b(iArr, (Map<String, String>) b2);
                    d.b((Map<String, String>) b2);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdLaunchAppHomePageEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.17

            /* renamed from: b */
            final /* synthetic */ MaterialData f20159b;

            /* renamed from: c */
            final /* synthetic */ Context f20160c;

            /* renamed from: d */
            final /* synthetic */ String f20161d;

            /* renamed from: e */
            final /* synthetic */ int f20162e;

            AnonymousClass17(MaterialData materialData2, Context context2, String str2, int i22) {
                materialData = materialData2;
                context = context2;
                str = str2;
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-feedback");
                    b2.put(STManager.KEY_AD_POS_ID, str);
                    b2.put("uSdkVC", f.h() + "");
                    b2.put("fbContent", i2 + "");
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFeedbackEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, int i2, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.2

            /* renamed from: b */
            final /* synthetic */ MaterialData f20175b;

            /* renamed from: c */
            final /* synthetic */ Context f20176c;

            /* renamed from: d */
            final /* synthetic */ String f20177d;

            /* renamed from: e */
            final /* synthetic */ boolean f20178e;

            /* renamed from: f */
            final /* synthetic */ int f20179f;

            /* renamed from: g */
            final /* synthetic */ Map f20180g;

            AnonymousClass2(MaterialData materialData2, Context context2, String str2, boolean z2, int i22, Map map2) {
                materialData = materialData2;
                context = context2;
                str = str2;
                z = z2;
                i2 = i22;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-expose");
                    d.h(b2, str);
                    b2.put("valid", z ? "1" : "0");
                    b2.put("sspWinPrice", i2 + "");
                    d.b((Map<String, String>) b2);
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, String str2, int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.8

            /* renamed from: a */
            final /* synthetic */ Context f20255a;

            /* renamed from: b */
            final /* synthetic */ String f20256b;

            /* renamed from: c */
            final /* synthetic */ boolean f20257c;

            /* renamed from: d */
            final /* synthetic */ String f20258d;

            /* renamed from: e */
            final /* synthetic */ AdItemData f20259e;

            /* renamed from: f */
            final /* synthetic */ MaterialData f20260f;

            /* renamed from: g */
            final /* synthetic */ int f20261g;

            AnonymousClass8(Context context2, String str3, boolean z2, String str22, AdItemData adItemData2, MaterialData materialData2, int i22) {
                context = context2;
                str = str3;
                z = z2;
                str2 = str22;
                adItemData = adItemData2;
                materialData = materialData2;
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Map b2 = d.b(context);
                    d.j(b2, "lm-play");
                    d.h(b2, str);
                    d.b((Map<String, String>) b2);
                    b2.put("valid", z ? "1" : "0");
                    if (!TextUtils.isEmpty(str2)) {
                        b2.put("clientTemplateId", str2);
                    }
                    d.b(adItemData, materialData, (Map<String, String>) b2);
                    d.b(i2, (Map<String, String>) b2);
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b2);
                    Context context2 = context;
                    MaterialData materialData2 = materialData;
                    d.b(context2, materialData2 != null ? materialData2.r() : "", (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, Map<String, String> map) {
        a(context, str, adItemData, materialData, z, 0, map);
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.3

            /* renamed from: b */
            final /* synthetic */ MaterialData f20222b;

            /* renamed from: c */
            final /* synthetic */ Context f20223c;

            /* renamed from: d */
            final /* synthetic */ String f20224d;

            /* renamed from: e */
            final /* synthetic */ boolean f20225e;

            /* renamed from: f */
            final /* synthetic */ int[] f20226f;

            /* renamed from: g */
            final /* synthetic */ Map f20227g;

            AnonymousClass3(MaterialData materialData2, Context context2, String str2, boolean z2, int[] iArr2, Map map2) {
                materialData = materialData2;
                context = context2;
                str = str2;
                z = z2;
                iArr = iArr2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-click");
                    d.h(b2, str);
                    b2.put("evtType", "1");
                    b2.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    d.b(iArr, (Map<String, String>) b2);
                    d.b((Map<String, String>) b2);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, AdItemData adItemData, MaterialData materialData, int[] iArr, boolean z) {
        HashMap hashMap = new HashMap();
        a(hashMap, z ? "5" : "4");
        a(context, str, false, adItemData, materialData, (Map<String, String>) hashMap, iArr);
    }

    public static void a(Context context, String str, String str2, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("STEventUtils", "report null");
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.16

                /* renamed from: a */
                final /* synthetic */ Context f20154a;

                /* renamed from: b */
                final /* synthetic */ String f20155b;

                /* renamed from: c */
                final /* synthetic */ String f20156c;

                /* renamed from: d */
                final /* synthetic */ int f20157d;

                AnonymousClass16(Context context2, String str3, String str22, int i22) {
                    context = context2;
                    str = str3;
                    str2 = str22;
                    i2 = i22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-activation");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        String str3 = str2;
                        if (str3 == null) {
                            str3 = "";
                        }
                        b2.put(Constant.ParamObjKey.KEY_EXTERNAL_TARGET_PKG, str3);
                        b2.put("code", String.valueOf(i2));
                        d.b(context, (String) null, (Map<String, String>) b2);
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.b("STEventUtils", "", e2);
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, String str2, int i2, long j2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.19

            /* renamed from: a */
            final /* synthetic */ Context f20169a;

            /* renamed from: b */
            final /* synthetic */ String f20170b;

            /* renamed from: c */
            final /* synthetic */ String f20171c;

            /* renamed from: d */
            final /* synthetic */ int f20172d;

            /* renamed from: e */
            final /* synthetic */ long f20173e;

            AnonymousClass19(Context context2, String str3, String str22, int i22, long j22) {
                context = context2;
                str = str3;
                str2 = str22;
                i2 = i22;
                j2 = j22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b2, str2);
                        b2.put("rsCode", String.valueOf(i2));
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("type", "1");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, int i2, long j2, boolean z, String str3, String str4) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.21

            /* renamed from: a */
            final /* synthetic */ Context f20190a;

            /* renamed from: b */
            final /* synthetic */ String f20191b;

            /* renamed from: c */
            final /* synthetic */ String f20192c;

            /* renamed from: d */
            final /* synthetic */ long f20193d;

            /* renamed from: e */
            final /* synthetic */ int f20194e;

            /* renamed from: f */
            final /* synthetic */ boolean f20195f;

            /* renamed from: g */
            final /* synthetic */ String f20196g;

            /* renamed from: h */
            final /* synthetic */ String f20197h;

            AnonymousClass21(Context context2, String str5, String str22, long j22, int i22, boolean z2, String str32, String str42) {
                context = context2;
                str = str5;
                str2 = str22;
                j2 = j22;
                i2 = i22;
                z = z2;
                str3 = str32;
                str4 = str42;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        b2.put("adSource", "");
                        d.i(b2, str2);
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("ret", "2");
                        d.g(b2, "");
                        HashMap hashMap = new HashMap();
                        hashMap.put("rsCode", "" + i2);
                        b2.put("cache", z ? "1" : "0");
                        String str5 = str3;
                        if (str5 == null) {
                            str5 = "";
                        }
                        b2.put(UMModuleRegister.PROCESS, str5);
                        String str22 = str4;
                        if (str22 == null) {
                            str22 = "";
                        }
                        b2.put("classifyByAge", str22);
                        if (hashMap.size() > 0) {
                            b2.putAll(hashMap);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, int i2, String str3, long j2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.18

            /* renamed from: a */
            final /* synthetic */ Context f20163a;

            /* renamed from: b */
            final /* synthetic */ String f20164b;

            /* renamed from: c */
            final /* synthetic */ int f20165c;

            /* renamed from: d */
            final /* synthetic */ String f20166d;

            /* renamed from: e */
            final /* synthetic */ long f20167e;

            /* renamed from: f */
            final /* synthetic */ String f20168f;

            AnonymousClass18(Context context2, String str4, int i22, String str22, long j22, String str32) {
                context = context2;
                str = str4;
                i2 = i22;
                str2 = str22;
                j2 = j22;
                str3 = str32;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b2.put("rsCode", String.valueOf(i2));
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b2, str2);
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("type", "2");
                        String str4 = str3;
                        if (str4 == null) {
                            str4 = "";
                        }
                        b2.put("adStates", str4);
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCatchFetchEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, int i2, String str3, long j2, String str4, boolean z) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.23

            /* renamed from: a */
            final /* synthetic */ Context f20206a;

            /* renamed from: b */
            final /* synthetic */ String f20207b;

            /* renamed from: c */
            final /* synthetic */ String f20208c;

            /* renamed from: d */
            final /* synthetic */ int f20209d;

            /* renamed from: e */
            final /* synthetic */ long f20210e;

            /* renamed from: f */
            final /* synthetic */ boolean f20211f;

            /* renamed from: g */
            final /* synthetic */ String f20212g;

            /* renamed from: h */
            final /* synthetic */ String f20213h;

            AnonymousClass23(Context context2, String str5, String str22, int i22, long j22, boolean z2, String str32, String str42) {
                context = context2;
                str = str5;
                str2 = str22;
                i2 = i22;
                j2 = j22;
                z = z2;
                str3 = str32;
                str4 = str42;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b2, str2);
                        b2.put("rsCode", String.valueOf(i2));
                        b2.put("ret", "2");
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("type", z ? "2" : "1");
                        String str5 = str3;
                        if (str5 == null) {
                            str5 = "";
                        }
                        b2.put("filteIds", str5);
                        String str22 = str4;
                        if (str22 == null) {
                            str22 = "";
                        }
                        b2.put("st", str22);
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, int i2, String str3, long j2, boolean z, String str4, String str5) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.11

            /* renamed from: a */
            final /* synthetic */ Context f20129a;

            /* renamed from: b */
            final /* synthetic */ String f20130b;

            /* renamed from: c */
            final /* synthetic */ String f20131c;

            /* renamed from: d */
            final /* synthetic */ long f20132d;

            /* renamed from: e */
            final /* synthetic */ int f20133e;

            /* renamed from: f */
            final /* synthetic */ boolean f20134f;

            /* renamed from: g */
            final /* synthetic */ String f20135g;

            /* renamed from: h */
            final /* synthetic */ String f20136h;

            /* renamed from: i */
            final /* synthetic */ String f20137i;

            AnonymousClass11(Context context2, String str6, String str22, long j22, int i22, boolean z2, String str32, String str42, String str52) {
                context = context2;
                str = str6;
                str2 = str22;
                j2 = j22;
                i2 = i22;
                z = z2;
                str3 = str32;
                str4 = str42;
                str5 = str52;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        b2.put("adSource", "");
                        d.i(b2, str2);
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("ret", "2");
                        d.g(b2, "");
                        HashMap hashMap = new HashMap();
                        hashMap.put("rsCode", "" + i2);
                        b2.put("cache", z ? "1" : "0");
                        String str6 = str3;
                        if (str6 == null) {
                            str6 = "";
                        }
                        b2.put("filteIds", str6);
                        String str22 = str4;
                        if (str22 == null) {
                            str22 = "";
                        }
                        b2.put("st", str22);
                        String str32 = str5;
                        if (str32 == null) {
                            str32 = "";
                        }
                        b2.put("classifyByAge", str32);
                        if (hashMap.size() > 0) {
                            b2.putAll(hashMap);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, String str3, long j2, boolean z, String str4, String str5, int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.20

            /* renamed from: a */
            final /* synthetic */ Context f20181a;

            /* renamed from: b */
            final /* synthetic */ String f20182b;

            /* renamed from: c */
            final /* synthetic */ String f20183c;

            /* renamed from: d */
            final /* synthetic */ long f20184d;

            /* renamed from: e */
            final /* synthetic */ String f20185e;

            /* renamed from: f */
            final /* synthetic */ String f20186f;

            /* renamed from: g */
            final /* synthetic */ boolean f20187g;

            /* renamed from: h */
            final /* synthetic */ String f20188h;

            /* renamed from: i */
            final /* synthetic */ int f20189i;

            AnonymousClass20(Context context2, String str6, String str32, long j22, String str42, String str22, boolean z2, String str52, int i22) {
                context = context2;
                str = str6;
                str3 = str32;
                j2 = j22;
                str4 = str42;
                str2 = str22;
                z = z2;
                str5 = str52;
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        b2.put("adSource", "");
                        d.i(b2, str3);
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("ret", "1");
                        String str6 = str4;
                        if (str6 == null) {
                            str6 = "";
                        }
                        b2.put(UMModuleRegister.PROCESS, str6);
                        d.g(b2, str2);
                        b2.put("cache", z ? "1" : "0");
                        String str22 = str5;
                        if (str22 == null) {
                            str22 = "";
                        }
                        b2.put("classifyByAge", str22);
                        b2.put(SplashAd.KEY_BIDFAIL_ECPM, i2 + "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, String str3, String str4, long j2, String str5, boolean z) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.22

            /* renamed from: a */
            final /* synthetic */ Context f20198a;

            /* renamed from: b */
            final /* synthetic */ String f20199b;

            /* renamed from: c */
            final /* synthetic */ String f20200c;

            /* renamed from: d */
            final /* synthetic */ String f20201d;

            /* renamed from: e */
            final /* synthetic */ long f20202e;

            /* renamed from: f */
            final /* synthetic */ boolean f20203f;

            /* renamed from: g */
            final /* synthetic */ String f20204g;

            /* renamed from: h */
            final /* synthetic */ String f20205h;

            AnonymousClass22(Context context2, String str6, String str22, String str32, long j22, boolean z2, String str42, String str52) {
                context = context2;
                str = str6;
                str2 = str22;
                str3 = str32;
                j2 = j22;
                z = z2;
                str4 = str42;
                str5 = str52;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-fetch");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        d.i(b2, str2);
                        b2.put("ret", str3);
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("type", z ? "2" : "1");
                        String str6 = str4;
                        if (str6 == null) {
                            str6 = "";
                        }
                        b2.put("filteIds", str6);
                        String str22 = str5;
                        if (str22 == null) {
                            str22 = "";
                        }
                        b2.put("st", str22);
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdFetchEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, String str3, String str4, long j2, boolean z, String str5, String str6, int i2) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.1

            /* renamed from: a */
            final /* synthetic */ Context f20113a;

            /* renamed from: b */
            final /* synthetic */ String f20114b;

            /* renamed from: c */
            final /* synthetic */ String f20115c;

            /* renamed from: d */
            final /* synthetic */ long f20116d;

            /* renamed from: e */
            final /* synthetic */ String f20117e;

            /* renamed from: f */
            final /* synthetic */ String f20118f;

            /* renamed from: g */
            final /* synthetic */ String f20119g;

            /* renamed from: h */
            final /* synthetic */ boolean f20120h;

            /* renamed from: i */
            final /* synthetic */ String f20121i;

            /* renamed from: j */
            final /* synthetic */ int f20122j;

            AnonymousClass1(Context context2, String str7, String str32, long j22, String str42, String str52, String str22, boolean z2, String str62, int i22) {
                context = context2;
                str = str7;
                str3 = str32;
                j2 = j22;
                str4 = str42;
                str5 = str52;
                str2 = str22;
                z = z2;
                str6 = str62;
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b2.put(STManager.KEY_AD_POS_ID, str);
                        b2.put("adSource", "");
                        d.i(b2, str3);
                        b2.put("rt", String.valueOf(j2));
                        b2.put("uSdkVC", f.h() + "");
                        b2.put("ret", "1");
                        String str7 = str4;
                        if (str7 == null) {
                            str7 = "";
                        }
                        b2.put("filteIds", str7);
                        String str22 = str5;
                        if (str22 == null) {
                            str22 = "";
                        }
                        b2.put("st", str22);
                        d.g(b2, str2);
                        b2.put("cache", z ? "1" : "0");
                        String str32 = str6;
                        if (str32 == null) {
                            str32 = "";
                        }
                        b2.put("classifyByAge", str32);
                        b2.put(SplashAd.KEY_BIDFAIL_ECPM, i2 + "");
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.24

            /* renamed from: a */
            final /* synthetic */ Context f20214a;

            /* renamed from: b */
            final /* synthetic */ String f20215b;

            /* renamed from: c */
            final /* synthetic */ String f20216c;

            /* renamed from: d */
            final /* synthetic */ String f20217d;

            /* renamed from: e */
            final /* synthetic */ String f20218e;

            /* renamed from: f */
            final /* synthetic */ String f20219f;

            /* renamed from: g */
            final /* synthetic */ Map f20220g;

            AnonymousClass24(Context context2, String str22, String str6, String str52, String str32, String str42, Map map2) {
                context = context2;
                str2 = str22;
                str = str6;
                str5 = str52;
                str3 = str32;
                str4 = str42;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (com.opos.mobad.model.e.d.a(context, str2)) {
                        Map b2 = d.b(context);
                        b2.put(STManager.KEY_DATA_TYPE, "lm-show");
                        b2.put(STManager.KEY_AD_POS_ID, str2);
                        b2.put("adSource", str);
                        d.i(b2, str5);
                        b2.put("ret", str3);
                        d.g(b2, str4);
                        Map map2 = map;
                        if (map2 != null && map2.size() > 0) {
                            b2.putAll(map);
                        }
                        com.opos.cmn.an.f.a.b("STEventUtils", "recordAdReqEvent map=", b2);
                        d.b(context, (Map<String, String>) b2);
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(Context context, String str, boolean z, AdItemData adItemData, MaterialData materialData, Map<String, String> map, int[] iArr) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.5

            /* renamed from: b */
            final /* synthetic */ MaterialData f20236b;

            /* renamed from: c */
            final /* synthetic */ Context f20237c;

            /* renamed from: d */
            final /* synthetic */ String f20238d;

            /* renamed from: e */
            final /* synthetic */ int[] f20239e;

            /* renamed from: f */
            final /* synthetic */ boolean f20240f;

            /* renamed from: g */
            final /* synthetic */ Map f20241g;

            AnonymousClass5(MaterialData materialData2, Context context2, String str2, int[] iArr2, boolean z2, Map map2) {
                materialData = materialData2;
                context = context2;
                str = str2;
                iArr = iArr2;
                z = z2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Map map2;
                String str2 = "2";
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-click");
                    b2.put("evtType", "2");
                    d.h(b2, str);
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    d.b(iArr, (Map<String, String>) b2);
                    if (z) {
                        str2 = "3";
                    } else {
                        if (1 != AdItemData.this.k()) {
                            if (2 == AdItemData.this.k()) {
                            }
                            d.b((Map<String, String>) b2);
                            map2 = map;
                            if (map2 != null && map2.size() > 0) {
                                b2.putAll(map);
                            }
                            com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", b2);
                            d.b(context, materialData.r(), (Map<String, String>) b2);
                        }
                        str2 = "1";
                    }
                    d.a((Map<String, String>) b2, str2);
                    d.b((Map<String, String>) b2);
                    map2 = map;
                    if (map2 != null) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdCloseEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void a(View view, Map<String, String> map) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            map.put("expCoordinate", iArr[0] + "-" + iArr[1]);
            int height = view.getHeight();
            map.put("expSize", view.getWidth() + "-" + height);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
        }
    }

    public static void a(Map<String, String> map, String str) {
        if (map != null) {
            map.put("clsType", str);
            map.put("handleObj", "12");
            map.put("handleValue", b(str));
        }
    }

    public static void a(Map<String, String> map, String str, String str2) {
        if (map != null) {
            try {
                map.put("actSource", str);
                map.put("handleObj", a(str));
                map.put(VideoActivity.EXTRA_KEY_ACTION_TYPE, String.valueOf(str2));
                map.put("handleValue", String.valueOf(str2));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
            }
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        str.hashCode();
        switch (str) {
        }
        return "";
    }

    public static Map<String, String> b(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("appId", f.a());
        hashMap.put("phBrand", com.opos.cmn.an.b.a.a(context));
        hashMap.put("phMaker", com.opos.cmn.an.b.c.e());
        hashMap.put(OapsKey.KEY_APP_ID, com.opos.mobad.service.e.a.a().e());
        hashMap.put("ua", f.i());
        hashMap.put("ouidStatus", com.opos.mobad.service.e.a.a().j() ? "1" : "0");
        hashMap.put("appOuidStatus", com.opos.mobad.service.e.a.a().d() ? "1" : "0");
        return hashMap;
    }

    public static void b(int i2, Map<String, String> map) {
        try {
            map.put("vPlyRet", i2 + "");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
        }
    }

    public static void b(Context context, AdItemData adItemData, MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.12

            /* renamed from: b */
            final /* synthetic */ MaterialData f20139b;

            /* renamed from: c */
            final /* synthetic */ Context f20140c;

            AnonymousClass12(MaterialData materialData2, Context context2) {
                materialData = materialData2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-common");
                    b2.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    d.b((Map<String, String>) b2);
                    b2.put("valid", "1");
                    b2.put("dlChannel", materialData.t());
                    b2.put("data_event", "1");
                    b2.put("status", "1");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderStartEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void b(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.7

            /* renamed from: b */
            final /* synthetic */ MaterialData f20250b;

            /* renamed from: c */
            final /* synthetic */ Context f20251c;

            /* renamed from: d */
            final /* synthetic */ String f20252d;

            /* renamed from: e */
            final /* synthetic */ boolean f20253e;

            /* renamed from: f */
            final /* synthetic */ Map f20254f;

            AnonymousClass7(MaterialData materialData2, Context context2, String str2, boolean z2, Map map2) {
                materialData = materialData2;
                context = context2;
                str = str2;
                z = z2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-play");
                    d.h(b2, str);
                    d.b((Map<String, String>) b2);
                    b2.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdExpEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void b(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.4

            /* renamed from: b */
            final /* synthetic */ MaterialData f20229b;

            /* renamed from: c */
            final /* synthetic */ Context f20230c;

            /* renamed from: d */
            final /* synthetic */ String f20231d;

            /* renamed from: e */
            final /* synthetic */ boolean f20232e;

            /* renamed from: f */
            final /* synthetic */ int[] f20233f;

            /* renamed from: g */
            final /* synthetic */ Map f20234g;

            AnonymousClass4(MaterialData materialData2, Context context2, String str2, boolean z2, int[] iArr2, Map map2) {
                materialData = materialData2;
                context = context2;
                str = str2;
                z = z2;
                iArr = iArr2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-click");
                    d.h(b2, str);
                    b2.put("evtType", "4");
                    b2.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    d.b(iArr, (Map<String, String>) b2);
                    d.b((Map<String, String>) b2);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void b(Context context, String str, Map<String, String> map) {
        String c2;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    c2 = c(map);
                    new com.opos.mobad.provider.statistic.a(com.opos.mobad.service.b.a(context), new StatisticModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b())).a(str, c2);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.b("STEventUtils", "report transform fail", e2);
                return;
            }
        }
        c2 = "";
        new com.opos.mobad.provider.statistic.a(com.opos.mobad.service.b.a(context), new StatisticModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b())).a(str, c2);
    }

    public static void b(Context context, Map<String, String> map) {
        b(context, (String) null, map);
    }

    public static final void b(AdItemData adItemData, MaterialData materialData, Map<String, String> map) {
        map.put("adSource", adItemData.b());
        map.put(STManager.KEY_AD_ID, adItemData.f());
        map.put("cache", adItemData.I() ? "1" : "0");
        map.put("planId", adItemData.h());
        g(map, adItemData.c());
        map.put("mtId", materialData.c());
        map.put("traceId", materialData.q());
        i(map, adItemData.a());
        map.put("classifyByAge", adItemData.W() != null ? adItemData.W() : "");
        if (TextUtils.isEmpty(adItemData.aa())) {
            return;
        }
        map.put("cKeyWords", adItemData.aa());
    }

    public static final void b(Map<String, String> map) {
        map.put("uSdkVC", f.h() + "");
        map.put("bizSdkVer", f.h() + "");
        map.put("InstVer", com.opos.mobad.service.f.a.a().d());
        map.put("InstSdkVer", com.opos.mobad.service.f.a.a().b());
    }

    public static void b(Map<String, String> map, String str) {
        if (map != null) {
            map.put("foregroundStatus", str);
        }
    }

    public static final void b(int[] iArr, Map<String, String> map) {
        if (iArr == null || iArr.length != 4) {
            return;
        }
        map.put(STManager.KEY_DOWN_X, iArr[0] + "");
        map.put(STManager.KEY_DOWN_Y, iArr[1] + "");
        map.put(STManager.KEY_UP_X, iArr[2] + "");
        map.put(STManager.KEY_UP_Y, iArr[3] + "");
        map.put("coordinates", iArr[2] + "-" + iArr[3] + "-" + iArr[0] + "-" + iArr[1]);
    }

    private static String c(Map<String, String> map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject.toString();
    }

    public static void c(Context context, AdItemData adItemData, MaterialData materialData) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.13

            /* renamed from: b */
            final /* synthetic */ MaterialData f20142b;

            /* renamed from: c */
            final /* synthetic */ Context f20143c;

            AnonymousClass13(MaterialData materialData2, Context context2) {
                materialData = materialData2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    b2.put(STManager.KEY_DATA_TYPE, "lm-common");
                    b2.put(STManager.KEY_AD_POS_ID, AdItemData.this.g());
                    d.b((Map<String, String>) b2);
                    b2.put("valid", "1");
                    b2.put("dlChannel", materialData.t());
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    b2.put("data_event", "1");
                    b2.put("status", "3");
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdDownloaderCompleteEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void c(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.6

            /* renamed from: b */
            final /* synthetic */ MaterialData f20243b;

            /* renamed from: c */
            final /* synthetic */ Context f20244c;

            /* renamed from: d */
            final /* synthetic */ String f20245d;

            /* renamed from: e */
            final /* synthetic */ boolean f20246e;

            /* renamed from: f */
            final /* synthetic */ int[] f20247f;

            /* renamed from: g */
            final /* synthetic */ Map f20248g;

            AnonymousClass6(MaterialData materialData2, Context context2, String str2, boolean z2, int[] iArr2, Map map2) {
                materialData = materialData2;
                context = context2;
                str = str2;
                z = z2;
                iArr = iArr2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.h(b2, str);
                    d.j(b2, "lm-click");
                    b2.put("evtType", "5");
                    b2.put("valid", z ? "1" : "0");
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    d.b(iArr, (Map<String, String>) b2);
                    d.b((Map<String, String>) b2);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordDeepLinkEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void d(Context context, String str, AdItemData adItemData, MaterialData materialData, boolean z, int[] iArr, Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.d.15

            /* renamed from: b */
            final /* synthetic */ MaterialData f20149b;

            /* renamed from: c */
            final /* synthetic */ Context f20150c;

            /* renamed from: d */
            final /* synthetic */ boolean f20151d;

            /* renamed from: e */
            final /* synthetic */ int[] f20152e;

            /* renamed from: f */
            final /* synthetic */ Map f20153f;

            AnonymousClass15(MaterialData materialData2, Context context2, boolean z2, int[] iArr2, Map map2) {
                materialData = materialData2;
                context = context2;
                z = z2;
                iArr = iArr2;
                map = map2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AdItemData.this == null || materialData == null) {
                        return;
                    }
                    Map b2 = d.b(context);
                    d.j(b2, "lm-click");
                    d.h(b2, AdItemData.this.g());
                    d.b(AdItemData.this, materialData, (Map<String, String>) b2);
                    b2.put("evtType", BaseWrapper.ENTER_ID_MESSAGE);
                    d.b((Map<String, String>) b2);
                    b2.put("valid", z ? "1" : "0");
                    d.b(iArr, (Map<String, String>) b2);
                    Map map2 = map;
                    if (map2 != null && map2.size() > 0) {
                        b2.putAll(map);
                    }
                    com.opos.cmn.an.f.a.b("STEventUtils", "recordAdClickEvent map=", b2);
                    d.b(context, materialData.r(), (Map<String, String>) b2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("STEventUtils", "", (Throwable) e2);
                }
            }
        });
    }

    public static void g(Map<String, String> map, String str) {
        if (map != null) {
            map.put("respId", str);
        }
    }

    public static void h(Map<String, String> map, String str) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.put(STManager.KEY_AD_POS_ID, str);
        map.put("newPosId", str);
    }

    public static void i(Map<String, String> map, String str) {
        if (map != null) {
            map.put("sdkReqId", str != null ? str : "");
            if (str == null) {
                str = "";
            }
            map.put("reqId", str);
        }
    }

    public static void j(Map<String, String> map, String str) {
        if (map != null) {
            map.put(STManager.KEY_DATA_TYPE, str);
            map.put("oriDatatype", str);
        }
    }
}
