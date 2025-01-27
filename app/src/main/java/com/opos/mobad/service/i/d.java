package com.opos.mobad.service.i;

import android.content.Context;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.opos.acs.st.STManager;
import com.opos.mobad.provider.statistic.StatisticModelIdentify;
import com.opos.mobad.service.i.f;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private static d f23688a;

    /* renamed from: b */
    private Context f23689b;

    /* renamed from: c */
    private String f23690c;

    /* renamed from: d */
    private int f23691d;

    /* renamed from: e */
    private int f23692e;

    /* renamed from: f */
    private String f23693f;

    /* renamed from: g */
    private com.opos.mobad.provider.statistic.a f23694g;

    /* renamed from: h */
    private com.opos.mobad.provider.record.a f23695h;

    /* renamed from: i */
    private long f23696i = 0;

    /* renamed from: com.opos.mobad.service.i.d$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ JSONObject f23697a;

        AnonymousClass1(JSONObject jSONObject) {
            jSONObject = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (d.this.f23694g == null) {
                str = "do but client null";
            } else {
                try {
                    d.this.f23694g.a(com.opos.mobad.service.f.b().h(), jSONObject.toString());
                    return;
                } catch (Exception unused) {
                    str = "do fail";
                }
            }
            com.opos.cmn.an.f.a.b("StatisticManager", str);
        }
    }

    /* renamed from: com.opos.mobad.service.i.d$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ JSONObject f23699a;

        AnonymousClass2(JSONObject jSONObject) {
            d2 = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f23695h == null) {
                com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                return;
            }
            try {
                if (d.this.f23696i <= 0) {
                    d dVar = d.this;
                    dVar.f23696i = dVar.f23695h.e();
                }
                if (d.this.f23696i + 86400000 <= System.currentTimeMillis()) {
                    if (d.this.f23694g == null) {
                        com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                        return;
                    }
                    d.this.f23694g.a(d2.toString());
                    d.this.f23696i = System.currentTimeMillis();
                }
            } catch (Exception unused) {
                com.opos.cmn.an.f.a.b("StatisticManager", "do fail");
            }
        }
    }

    /* renamed from: com.opos.mobad.service.i.d$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23701a;

        /* renamed from: b */
        final /* synthetic */ String f23702b;

        /* renamed from: c */
        final /* synthetic */ String f23703c;

        /* renamed from: d */
        final /* synthetic */ String f23704d;

        /* renamed from: e */
        final /* synthetic */ String f23705e;

        /* renamed from: f */
        final /* synthetic */ String f23706f;

        /* renamed from: g */
        final /* synthetic */ String f23707g;

        AnonymousClass3(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            str = str;
            str3 = str2;
            str2 = str3;
            str4 = str4;
            str5 = str5;
            str7 = str6;
            str6 = str7;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                JSONObject d2 = d.this.d();
                d.this.e(d2, "lm-vip-callback");
                d.d(d2, str);
                d2.put("adSource", str3);
                d2.put(STManager.KEY_AD_ID, str2);
                d2.put("pTraceId", str4);
                d2.put("platformPkg", d.this.f23689b.getPackageName());
                d.c(d2, str5);
                d.this.b(d2);
                d2.put(OapsKey.KEY_TOKEN, str7);
                com.opos.cmn.an.f.a.b("StatisticManager", "recordVIP map=", d2);
                d.this.f23694g.a(str6, d2.toString());
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
            }
        }
    }

    private d() {
    }

    public static d a() {
        d dVar = f23688a;
        if (dVar == null) {
            synchronized (d.class) {
                if (f23688a == null) {
                    f23688a = new d();
                }
                dVar = f23688a;
            }
        }
        return dVar;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    private void a(String str, String str2, String str3, int i2, long j2, String str4, long j3) {
        try {
            JSONObject d2 = d();
            d2.put(STManager.KEY_DATA_TYPE, "lm-show");
            d2.put(STManager.KEY_AD_POS_ID, str);
            d2.put("rt", j2);
            d2.put("adSource", str2);
            d2.put("uSdkVC", this.f23691d + "");
            if (str3 == null) {
                str3 = "";
            }
            d2.put("sdkReqId", str3);
            d2.put("ret", "2");
            d2.put("rsCode", "" + i2);
            if (str4 == null) {
                str4 = "";
            }
            d2.put(UMModuleRegister.PROCESS, a(str4));
            d2.put("stgVC", j3);
            a(d2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e2);
        }
    }

    public static JSONObject b(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
        }
        return jSONObject;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("uSdkVC", this.f23691d + "");
                jSONObject.put("bizSdkVer", this.f23691d + "");
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
            }
        }
    }

    public static void c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put("sdkReqId", str != null ? str : "");
                if (str == null) {
                    str = "";
                }
                jSONObject.put("reqId", str);
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
            }
        }
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", this.f23690c);
        jSONObject.put("phBrand", com.opos.cmn.an.b.a.a(this.f23689b));
        jSONObject.put("phMaker", com.opos.cmn.an.b.c.e());
        jSONObject.put(OapsKey.KEY_APP_ID, com.opos.mobad.service.e.a.a().e());
        jSONObject.put("ua", com.opos.cmn.i.d.a());
        jSONObject.put("coverVc", this.f23692e);
        jSONObject.put("extInfo", !TextUtils.isEmpty(this.f23693f) ? this.f23693f : "");
        jSONObject.put("classifyByAge", com.opos.mobad.service.f.a.a().w());
        jSONObject.put("ouidStatus", com.opos.mobad.service.e.a.a().j() ? "1" : "0");
        jSONObject.put("appOuidStatus", com.opos.mobad.service.e.a.a().d() ? "1" : "0");
        return jSONObject;
    }

    public static void d(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put(STManager.KEY_AD_POS_ID, str);
                jSONObject.put("newPosId", str);
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
            }
        }
    }

    public void e(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put(STManager.KEY_DATA_TYPE, str);
                jSONObject.put("oriDatatype", str);
            } catch (JSONException e2) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
            }
        }
    }

    public void a(Context context, String str, int i2, int i3) {
        this.f23689b = context;
        this.f23690c = str;
        this.f23691d = i2;
        this.f23692e = i3;
        this.f23694g = new com.opos.mobad.provider.statistic.a(this.f23689b, new StatisticModelIdentify(com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
        this.f23695h = new com.opos.mobad.provider.record.a(context);
    }

    public void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report null");
            return;
        }
        try {
            JSONObject d2 = d();
            d2.put(STManager.KEY_DATA_TYPE, "lm-count");
            d2.put(STManager.KEY_AD_POS_ID, str);
            d2.put("event", "1:1");
            d2.put("uCount", String.valueOf(i2));
            d2.put("uSdkVC", this.f23691d + "");
            a(d2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e2);
        }
    }

    public void a(String str, String str2, int i2, int i3, int i4) {
        try {
            JSONObject d2 = d();
            e(d2, "lm-bid-call");
            d2.put("adPosId", str);
            d2.put("appId", this.f23690c);
            d2.put("uSdkVC", this.f23691d + "");
            d2.put("accType", 1);
            d2.put("sdkReqId", str2);
            d2.put("bidResult", 0);
            d2.put("returnPrice", i3);
            d2.put("sspWinPrice", i4);
            d2.put("adSource", i2);
            a(d2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e2);
        }
    }

    public void a(String str, String str2, int i2, long j2, String str3, long j3) {
        try {
            JSONObject d2 = d();
            d2.put(STManager.KEY_DATA_TYPE, "lm-show");
            d2.put(STManager.KEY_AD_POS_ID, str);
            d2.put("rt", j2);
            d2.put("adSource", "sdk_serial");
            d2.put("uSdkVC", this.f23691d + "");
            d2.put("hitSource", i2);
            if (str3 == null) {
                str3 = "";
            }
            d2.put(UMModuleRegister.PROCESS, a(str3));
            if (str2 == null) {
                str2 = "";
            }
            d2.put("sdkReqId", str2);
            d2.put("ret", "1");
            d2.put("stgVC", j3);
            a(d2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e2);
        }
    }

    public void a(String str, String str2, int i2, long j2, String str3, String str4, long j3) {
        try {
            JSONObject d2 = d();
            d2.put(STManager.KEY_DATA_TYPE, "lm-show");
            d2.put(STManager.KEY_AD_POS_ID, str);
            d2.put("rt", j2);
            d2.put("adSource", str4);
            d2.put("hitSource", i2);
            d2.put("uSdkVC", this.f23691d + "");
            if (str3 == null) {
                str3 = "";
            }
            d2.put(UMModuleRegister.PROCESS, a(str3));
            if (str2 == null) {
                str2 = "";
            }
            d2.put("sdkReqId", str2);
            d2.put("ret", "1");
            d2.put("stgVC", j3);
            a(d2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e2);
        }
    }

    public void a(String str, String str2, int i2, String str3, int i3, int i4, int i5) {
        try {
            JSONObject d2 = d();
            e(d2, "lm-bid-call");
            d2.put("adPosId", str);
            d2.put("appId", this.f23690c);
            d2.put("uSdkVC", this.f23691d + "");
            d2.put("accType", 1);
            d2.put("sdkReqId", str2);
            d2.put("bidResult", i2);
            d2.put("returnPrice", i4);
            d2.put("adSource", i3);
            a(d2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e2);
        }
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.i.d.3

            /* renamed from: a */
            final /* synthetic */ String f23701a;

            /* renamed from: b */
            final /* synthetic */ String f23702b;

            /* renamed from: c */
            final /* synthetic */ String f23703c;

            /* renamed from: d */
            final /* synthetic */ String f23704d;

            /* renamed from: e */
            final /* synthetic */ String f23705e;

            /* renamed from: f */
            final /* synthetic */ String f23706f;

            /* renamed from: g */
            final /* synthetic */ String f23707g;

            AnonymousClass3(String str8, String str32, String str22, String str42, String str52, String str72, String str62) {
                str = str8;
                str3 = str32;
                str2 = str22;
                str4 = str42;
                str5 = str52;
                str7 = str72;
                str6 = str62;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject d2 = d.this.d();
                    d.this.e(d2, "lm-vip-callback");
                    d.d(d2, str);
                    d2.put("adSource", str3);
                    d2.put(STManager.KEY_AD_ID, str2);
                    d2.put("pTraceId", str4);
                    d2.put("platformPkg", d.this.f23689b.getPackageName());
                    d.c(d2, str5);
                    d.this.b(d2);
                    d2.put(OapsKey.KEY_TOKEN, str7);
                    com.opos.cmn.an.f.a.b("StatisticManager", "recordVIP map=", d2);
                    d.this.f23694g.a(str6, d2.toString());
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
                }
            }
        });
    }

    public void a(String str, Map<String, String> map) {
        try {
            JSONObject d2 = d();
            d2.put(STManager.KEY_DATA_TYPE, str);
            b(d2);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null) {
                        d2.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            a(d2);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report fail", e2);
        }
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() > 0) {
                    a(b(map));
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e2);
                return;
            }
        }
        com.opos.cmn.an.f.a.a("StatisticManager", "report but null map");
    }

    void a(JSONObject jSONObject) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.i.d.1

            /* renamed from: a */
            final /* synthetic */ JSONObject f23697a;

            AnonymousClass1(JSONObject jSONObject2) {
                jSONObject = jSONObject2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (d.this.f23694g == null) {
                    str = "do but client null";
                } else {
                    try {
                        d.this.f23694g.a(com.opos.mobad.service.f.b().h(), jSONObject.toString());
                        return;
                    } catch (Exception unused) {
                        str = "do fail";
                    }
                }
                com.opos.cmn.an.f.a.b("StatisticManager", str);
            }
        });
    }

    public void b() {
        if (this.f23696i + 86400000 > System.currentTimeMillis()) {
            return;
        }
        try {
            JSONObject d2 = d();
            d2.put(STManager.KEY_DATA_TYPE, "lm-c-ps");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.i.d.2

                /* renamed from: a */
                final /* synthetic */ JSONObject f23699a;

                AnonymousClass2(JSONObject d22) {
                    d2 = d22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f23695h == null) {
                        com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                        return;
                    }
                    try {
                        if (d.this.f23696i <= 0) {
                            d dVar = d.this;
                            dVar.f23696i = dVar.f23695h.e();
                        }
                        if (d.this.f23696i + 86400000 <= System.currentTimeMillis()) {
                            if (d.this.f23694g == null) {
                                com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                                return;
                            }
                            d.this.f23694g.a(d2.toString());
                            d.this.f23696i = System.currentTimeMillis();
                        }
                    } catch (Exception unused) {
                        com.opos.cmn.an.f.a.b("StatisticManager", "do fail");
                    }
                }
            });
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e2);
        }
    }

    public void b(String str, String str2, int i2, long j2, String str3, long j3) {
        a(str, "sdk_serial", str2, i2, j2, str3, j3);
    }

    public void b(String str, String str2, int i2, long j2, String str3, String str4, long j3) {
        a(str, str4, str2, i2, j2, str3, j3);
    }

    public f.a c() {
        JSONObject jSONObject;
        try {
            jSONObject = d();
            try {
                jSONObject.put("uSdkVC", this.f23691d + "");
                jSONObject.put("pkgName", this.f23689b.getPackageName());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            jSONObject = null;
        }
        return new f.a(jSONObject);
    }
}
