package com.ss.android.downloadlib.addownload.compliance;

import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadlib.g.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private boolean f21307a;

    /* renamed from: b */
    private a f21308b;

    /* renamed from: c */
    private int f21309c;

    /* renamed from: d */
    private int f21310d;

    /* renamed from: e */
    private int f21311e = 15;

    /* renamed from: f */
    private int f21312f;

    /* renamed from: g */
    private String f21313g;

    /* renamed from: h */
    private String f21314h;

    /* renamed from: i */
    private int f21315i;

    /* renamed from: j */
    private String f21316j;

    /* renamed from: k */
    private long f21317k;

    /* renamed from: l */
    private String f21318l;

    /* renamed from: m */
    private String f21319m;

    /* renamed from: n */
    private b f21320n;

    /* renamed from: o */
    private String f21321o;

    public static class a {

        /* renamed from: a */
        private String f21322a;

        /* renamed from: b */
        private String f21323b;

        /* renamed from: c */
        private long f21324c;

        /* renamed from: d */
        private long f21325d;

        /* renamed from: e */
        private String f21326e;

        /* renamed from: f */
        private String f21327f;

        /* renamed from: g */
        private List<C0637a> f21328g;

        /* renamed from: h */
        private String f21329h;

        /* renamed from: i */
        private String f21330i;

        /* renamed from: j */
        private String f21331j;

        /* renamed from: k */
        private String f21332k;

        /* renamed from: l */
        private String f21333l;

        /* renamed from: com.ss.android.downloadlib.addownload.compliance.e$a$a */
        public static class C0637a {

            /* renamed from: a */
            private String f21334a;

            /* renamed from: b */
            private String f21335b;

            public void a(String str) {
                this.f21334a = str;
            }

            public void b(String str) {
                this.f21335b = str;
            }
        }

        public void a(String str) {
            this.f21322a = str;
        }

        public void b(String str) {
            this.f21323b = str;
        }

        public void c(String str) {
            this.f21326e = str;
        }

        public void d(String str) {
            this.f21327f = str;
        }

        public void e(String str) {
            this.f21329h = str;
        }

        public void f(String str) {
            this.f21330i = str;
        }

        public void g(String str) {
            this.f21331j = str;
        }

        public void h(String str) {
            this.f21332k = str;
        }

        public void i(String str) {
            this.f21333l = str;
        }

        public void a(long j10) {
            this.f21324c = j10;
        }

        public void b(long j10) {
            this.f21325d = j10;
        }

        public void a(List<C0637a> list) {
            this.f21328g = list;
        }
    }

    public static class b {

        /* renamed from: a */
        private int f21336a;

        /* renamed from: b */
        private String f21337b;

        public void a(int i10) {
            this.f21336a = i10;
        }

        public void a(String str) {
            this.f21337b = str;
        }
    }

    public static e g(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            a a10 = a(jSONObject);
            b b10 = b(jSONObject);
            eVar.a(a10);
            eVar.a(b10);
            eVar.a(jSONObject.optInt("show_auth", 0) == 1);
            eVar.a(jSONObject.optInt("download_permit"));
            eVar.b(jSONObject.optInt("appstore_permit"));
            eVar.c(jSONObject.optInt("market_online_status", 15));
            eVar.d(jSONObject.optInt("hijack_permit"));
            eVar.a(jSONObject.optString("package_name"));
            eVar.b(jSONObject.optString("hijack_url"));
            eVar.e(jSONObject.optInt("code"));
            eVar.c(jSONObject.optString(b7.d.f1362o));
            eVar.a(jSONObject.optLong("request_duration", 0L));
            eVar.d(jSONObject.optString("back_web_url"));
            eVar.e(jSONObject.optString("hw_app_id"));
            eVar.f(jSONObject.optString("deep_link"));
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "ComplianceResult fromJson");
        }
        return eVar;
    }

    public void a(boolean z10) {
        this.f21307a = z10;
    }

    public void b(int i10) {
        this.f21310d = i10;
    }

    public void c(int i10) {
        this.f21311e = i10;
    }

    public void d(int i10) {
        this.f21312f = i10;
    }

    public void e(int i10) {
        this.f21315i = i10;
    }

    public void f(String str) {
        this.f21319m = str;
    }

    public String toString() {
        return a(this);
    }

    public void a(a aVar) {
        this.f21308b = aVar;
    }

    public void b(String str) {
        this.f21314h = str;
    }

    public void c(String str) {
        this.f21316j = str;
    }

    public void d(String str) {
        this.f21321o = str;
    }

    public void e(String str) {
        this.f21318l = str;
    }

    private static JSONArray c(a aVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<a.C0637a> list = aVar.f21328g;
        if (list != null && list.size() > 0) {
            for (a.C0637a c0637a : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0637a.f21334a);
                jSONObject.putOpt("permission_desc", c0637a.f21335b);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public void a(int i10) {
        this.f21309c = i10;
    }

    public String b() {
        return this.f21319m;
    }

    private static JSONObject b(a aVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (aVar != null) {
            jSONObject.putOpt("app_name", aVar.f21322a);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, aVar.f21323b);
            jSONObject.putOpt("update_time", Long.valueOf(aVar.f21324c));
            jSONObject.putOpt("size", Long.valueOf(aVar.f21325d));
            jSONObject.putOpt("developer_name", aVar.f21326e);
            jSONObject.putOpt("policy_url", aVar.f21330i);
            jSONObject.putOpt("icon_url", aVar.f21331j);
            jSONObject.putOpt("download_url", aVar.f21332k);
            jSONObject.putOpt("permissions", c(aVar));
            jSONObject.putOpt("permission_classify_url", aVar.f21329h);
            jSONObject.putOpt("desc_url", aVar.f21333l);
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f21313g = str;
    }

    public int a() {
        return this.f21315i;
    }

    public void a(long j10) {
        this.f21317k = j10;
    }

    public void a(b bVar) {
        this.f21320n = bVar;
    }

    public static String a(e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(eVar.f21307a ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(eVar.f21309c));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(eVar.f21310d));
            jSONObject.putOpt("market_online_status", Integer.valueOf(eVar.f21311e));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(eVar.f21312f));
            jSONObject.putOpt("package_name", eVar.f21313g);
            jSONObject.putOpt("hijack_url", eVar.f21314h);
            jSONObject.putOpt("code", Integer.valueOf(eVar.f21315i));
            jSONObject.putOpt(b7.d.f1362o, eVar.f21316j);
            jSONObject.putOpt("request_duration", Long.valueOf(eVar.f21317k));
            jSONObject.putOpt("auth_info", b(eVar.f21308b));
            jSONObject.putOpt("status", b(eVar.f21320n));
            jSONObject.putOpt("back_web_url", eVar.f21321o);
            jSONObject.putOpt("hw_app_id", eVar.f21318l);
            jSONObject.putOpt("deep_link", eVar.f21319m);
        } catch (JSONException e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    private static b b(JSONObject jSONObject) {
        b bVar = new b();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("status");
            if (optJSONObject != null) {
                bVar.a(optJSONObject.optInt("status"));
                bVar.a(optJSONObject.optString(b7.d.f1362o));
            }
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "ComplianceResult getStatus");
        }
        return bVar;
    }

    private static JSONObject b(b bVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (bVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(bVar.f21336a));
            jSONObject.putOpt(b7.d.f1362o, bVar.f21337b);
        }
        return jSONObject;
    }

    private static a a(JSONObject jSONObject) {
        a aVar = new a();
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("auth_info");
            if (optJSONObject != null) {
                aVar.a(optJSONObject.optString("app_name"));
                aVar.b(optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                aVar.a(m.a(optJSONObject, "update_time"));
                aVar.b(m.a(optJSONObject, "size"));
                aVar.c(optJSONObject.optString("developer_name"));
                aVar.d(optJSONObject.optString("package_name"));
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    a(optJSONArray, arrayList);
                    aVar.a(arrayList);
                }
                aVar.e(optJSONObject.optString("permission_classify_url"));
                aVar.f(optJSONObject.optString("policy_url"));
                aVar.g(optJSONObject.optString("icon_url"));
                aVar.h(optJSONObject.optString("download_url"));
                aVar.i(optJSONObject.optString("desc_url"));
            }
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "ComplianceResult getAuthInfo");
        }
        return aVar;
    }

    private static void a(JSONArray jSONArray, List<a.C0637a> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                a.C0637a c0637a = new a.C0637a();
                c0637a.a(optJSONObject.optString("permission_name"));
                c0637a.b(optJSONObject.optString("permission_desc"));
                list.add(c0637a);
            }
        }
    }
}
