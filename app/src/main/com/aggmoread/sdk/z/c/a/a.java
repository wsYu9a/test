package com.aggmoread.sdk.z.c.a;

import android.text.TextUtils;
import com.aggmoread.sdk.z.b.e;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b */
    private com.aggmoread.sdk.z.c.b.a f5087b;

    /* renamed from: c */
    public int f5088c;

    /* renamed from: d */
    public String f5089d;

    /* renamed from: e */
    public C0101a f5090e;

    /* renamed from: com.aggmoread.sdk.z.c.a.a$a */
    public static class C0101a {

        /* renamed from: a */
        public List<C0102a> f5091a;

        /* renamed from: com.aggmoread.sdk.z.c.a.a$a$a */
        public static class C0102a {

            /* renamed from: a */
            public String f5092a;

            /* renamed from: b */
            public String f5093b;

            /* renamed from: c */
            public String f5094c;

            /* renamed from: d */
            public String f5095d;

            /* renamed from: e */
            public String f5096e;

            /* renamed from: f */
            public List<C0103a> f5097f;

            /* renamed from: g */
            public List<String> f5098g;

            /* renamed from: h */
            public int f5099h;

            /* renamed from: i */
            public String f5100i;

            /* renamed from: j */
            public List<String> f5101j;

            /* renamed from: k */
            public List<String> f5102k;

            /* renamed from: l */
            public List<String> f5103l;

            /* renamed from: m */
            public List<String> f5104m;

            /* renamed from: n */
            public List<String> f5105n;

            /* renamed from: o */
            public List<String> f5106o;

            /* renamed from: p */
            public String f5107p;

            /* renamed from: com.aggmoread.sdk.z.c.a.a$a$a$a */
            public static class C0103a {

                /* renamed from: a */
                public int f5108a;

                /* renamed from: b */
                public List<String> f5109b;
            }

            public String a() {
                return !TextUtils.isEmpty(this.f5095d) ? this.f5095d : !TextUtils.isEmpty(this.f5096e) ? this.f5096e : "";
            }

            public String b() {
                List<String> list = this.f5098g;
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return this.f5098g.get(0);
            }

            public boolean c() {
                return this.f5099h == 2;
            }

            public List<String> a(int i10) {
                if (this.f5097f == null) {
                    return null;
                }
                for (int i11 = 0; i11 < this.f5097f.size(); i11++) {
                    C0103a c0103a = this.f5097f.get(i11);
                    if (i10 == c0103a.f5108a) {
                        return c0103a.f5109b;
                    }
                }
                return null;
            }
        }

        public C0102a a() {
            if (this.f5091a.size() > 0) {
                return this.f5091a.get(0);
            }
            return null;
        }
    }

    private static List<C0101a.C0102a.C0103a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            C0101a.C0102a.C0103a c0103a = new C0101a.C0102a.C0103a();
            JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
            if (a(jSONObject, "type")) {
                c0103a.f5108a = jSONObject.getInt("type");
            }
            if (a(jSONObject, "urls")) {
                c0103a.f5109b = b(jSONObject.getJSONArray("urls"));
            }
            arrayList.add(c0103a);
        }
        return arrayList;
    }

    public static a b(JSONObject jSONObject) {
        a aVar = new a();
        if (a(jSONObject, "code")) {
            aVar.f5088c = jSONObject.getInt("code");
        }
        if (a(jSONObject, "msg")) {
            aVar.f5089d = jSONObject.getString("msg");
        }
        if (a(jSONObject, com.sigmob.sdk.base.db.a.f18088a)) {
            C0101a c0101a = new C0101a();
            JSONObject jSONObject2 = jSONObject.getJSONObject(com.sigmob.sdk.base.db.a.f18088a);
            if (a(jSONObject2, "slotCode")) {
                jSONObject2.getString("slotCode");
            }
            if (a(jSONObject2, TTDownloadField.TT_META) && jSONObject2.getJSONArray(TTDownloadField.TT_META).length() > 0) {
                JSONArray jSONArray = jSONObject2.getJSONArray(TTDownloadField.TT_META);
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    C0101a.C0102a c0102a = new C0101a.C0102a();
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i10);
                    if (a(jSONObject3, "title")) {
                        c0102a.f5092a = jSONObject3.getString("title");
                    }
                    if (a(jSONObject3, SocialConstants.PARAM_APP_DESC)) {
                        c0102a.f5093b = jSONObject3.getString(SocialConstants.PARAM_APP_DESC);
                    }
                    if (a(jSONObject3, "icon")) {
                        c0102a.f5094c = jSONObject3.getString("icon");
                    }
                    if (a(jSONObject3, "click_url")) {
                        c0102a.f5095d = jSONObject3.getString("click_url");
                    }
                    if (a(jSONObject3, "deepLink")) {
                        c0102a.f5096e = jSONObject3.getString("deepLink");
                        if (a(jSONObject3, "arrDeepLinkTrackUrl")) {
                            c0102a.f5097f = a(jSONObject3.getJSONArray("arrDeepLinkTrackUrl"));
                        }
                    }
                    if (a(jSONObject3, "imgs")) {
                        c0102a.f5098g = b(jSONObject3.getJSONArray("imgs"));
                    }
                    if (a(jSONObject3, "creative_type")) {
                        jSONObject3.getInt("creative_type");
                    }
                    if (a(jSONObject3, "interaction_type")) {
                        c0102a.f5099h = jSONObject3.getInt("interaction_type");
                    }
                    if (a(jSONObject3, "package_name")) {
                        c0102a.f5100i = jSONObject3.getString("package_name");
                    }
                    if (a(jSONObject3, NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE)) {
                        jSONObject3.getInt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE);
                    }
                    if (a(jSONObject3, "show_track_url")) {
                        c0102a.f5103l = b(jSONObject3.getJSONArray("show_track_url"));
                    }
                    if (a(jSONObject3, "click_track_url")) {
                        c0102a.f5104m = b(jSONObject3.getJSONArray("click_track_url"));
                    }
                    if (a(jSONObject3, "download_track_url")) {
                        c0102a.f5105n = b(jSONObject3.getJSONArray("download_track_url"));
                    }
                    if (a(jSONObject3, "install_track_url")) {
                        c0102a.f5106o = b(jSONObject3.getJSONArray("install_track_url"));
                    }
                    if (a(jSONObject3, IAdInterListener.AdReqParam.WIDTH)) {
                        jSONObject3.getInt(IAdInterListener.AdReqParam.WIDTH);
                    }
                    if (a(jSONObject3, "tanUrl")) {
                        c0102a.f5107p = jSONObject3.getString("tanUrl");
                    }
                    if (a(jSONObject3, "ci")) {
                        jSONObject3.getString("ci");
                    }
                    arrayList.add(c0102a);
                }
                c0101a.f5091a = arrayList;
                aVar.f5090e = c0101a;
            }
        }
        return aVar;
    }

    public com.aggmoread.sdk.z.c.b.a d() {
        return this.f5087b;
    }

    public boolean e() {
        List<C0101a.C0102a> list;
        C0101a c0101a = this.f5090e;
        return (c0101a == null || (list = c0101a.f5091a) == null || list.size() <= 0) ? false : true;
    }

    public boolean f() {
        return this.f5088c == 0;
    }

    private static List<String> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(jSONArray.getString(i10));
        }
        return arrayList;
    }

    public void a(com.aggmoread.sdk.z.c.b.a aVar) {
        this.f5087b = aVar;
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) && jSONObject.has(str);
    }
}
