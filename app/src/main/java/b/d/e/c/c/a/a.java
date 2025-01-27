package b.d.e.c.c.a;

import android.text.TextUtils;
import b.d.e.c.a.e;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a extends e {

    /* renamed from: b */
    private com.martian.ttbook.b.b.b.a f4711b;

    /* renamed from: c */
    public int f4712c;

    /* renamed from: d */
    public String f4713d;

    /* renamed from: e */
    public C0038a f4714e;

    /* renamed from: b.d.e.c.c.a.a$a */
    public static class C0038a {

        /* renamed from: a */
        public List<C0039a> f4715a;

        /* renamed from: b.d.e.c.c.a.a$a$a */
        public static class C0039a {

            /* renamed from: a */
            public String f4716a;

            /* renamed from: b */
            public String f4717b;

            /* renamed from: c */
            public String f4718c;

            /* renamed from: d */
            public String f4719d;

            /* renamed from: e */
            public String f4720e;

            /* renamed from: f */
            public List<C0040a> f4721f;

            /* renamed from: g */
            public List<String> f4722g;

            /* renamed from: h */
            public int f4723h;

            /* renamed from: i */
            public String f4724i;

            /* renamed from: j */
            public List<String> f4725j;
            public List<String> k;
            public List<String> l;
            public List<String> m;
            public List<String> n;
            public List<String> o;
            public String p;

            /* renamed from: b.d.e.c.c.a.a$a$a$a */
            public static class C0040a {

                /* renamed from: a */
                public int f4726a;

                /* renamed from: b */
                public List<String> f4727b;
            }

            public String a() {
                return !TextUtils.isEmpty(this.f4719d) ? this.f4719d : !TextUtils.isEmpty(this.f4720e) ? this.f4720e : "";
            }

            public List<String> b(int i2) {
                if (this.f4721f == null) {
                    return null;
                }
                for (int i3 = 0; i3 < this.f4721f.size(); i3++) {
                    C0040a c0040a = this.f4721f.get(i3);
                    if (i2 == c0040a.f4726a) {
                        return c0040a.f4727b;
                    }
                }
                return null;
            }

            public String c() {
                List<String> list = this.f4722g;
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return this.f4722g.get(0);
            }

            public boolean d() {
                return this.f4723h == 2;
            }
        }

        public C0039a a() {
            if (this.f4715a.size() > 0) {
                return this.f4715a.get(0);
            }
            return null;
        }
    }

    private static List<C0038a.C0039a.C0040a> e(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            C0038a.C0039a.C0040a c0040a = new C0038a.C0039a.C0040a();
            JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
            if (g(jSONObject, "type")) {
                c0040a.f4726a = jSONObject.getInt("type");
            }
            if (g(jSONObject, "urls")) {
                c0040a.f4727b = j(jSONObject.getJSONArray("urls"));
            }
            arrayList.add(c0040a);
        }
        return arrayList;
    }

    public static boolean g(JSONObject jSONObject, String str) {
        return !jSONObject.isNull(str) && jSONObject.has(str);
    }

    public static a h(JSONObject jSONObject) {
        a aVar = new a();
        if (g(jSONObject, "code")) {
            aVar.f4712c = jSONObject.getInt("code");
        }
        if (g(jSONObject, "msg")) {
            aVar.f4713d = jSONObject.getString("msg");
        }
        if (g(jSONObject, "ads")) {
            C0038a c0038a = new C0038a();
            JSONObject jSONObject2 = jSONObject.getJSONObject("ads");
            if (g(jSONObject2, "slotCode")) {
                jSONObject2.getString("slotCode");
            }
            if (g(jSONObject2, TTDownloadField.TT_META) && jSONObject2.getJSONArray(TTDownloadField.TT_META).length() > 0) {
                JSONArray jSONArray = jSONObject2.getJSONArray(TTDownloadField.TT_META);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    C0038a.C0039a c0039a = new C0038a.C0039a();
                    JSONObject jSONObject3 = (JSONObject) jSONArray.get(i2);
                    if (g(jSONObject3, "title")) {
                        c0039a.f4716a = jSONObject3.getString("title");
                    }
                    if (g(jSONObject3, SocialConstants.PARAM_APP_DESC)) {
                        c0039a.f4717b = jSONObject3.getString(SocialConstants.PARAM_APP_DESC);
                    }
                    if (g(jSONObject3, "icon")) {
                        c0039a.f4718c = jSONObject3.getString("icon");
                    }
                    if (g(jSONObject3, "click_url")) {
                        c0039a.f4719d = jSONObject3.getString("click_url");
                    }
                    if (g(jSONObject3, "deepLink")) {
                        c0039a.f4720e = jSONObject3.getString("deepLink");
                        if (g(jSONObject3, "arrDeepLinkTrackUrl")) {
                            c0039a.f4721f = e(jSONObject3.getJSONArray("arrDeepLinkTrackUrl"));
                        }
                    }
                    if (g(jSONObject3, "imgs")) {
                        c0039a.f4722g = j(jSONObject3.getJSONArray("imgs"));
                    }
                    if (g(jSONObject3, "creative_type")) {
                        jSONObject3.getInt("creative_type");
                    }
                    if (g(jSONObject3, "interaction_type")) {
                        c0039a.f4723h = jSONObject3.getInt("interaction_type");
                    }
                    if (g(jSONObject3, "package_name")) {
                        c0039a.f4724i = jSONObject3.getString("package_name");
                    }
                    if (g(jSONObject3, NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE)) {
                        jSONObject3.getInt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE);
                    }
                    if (g(jSONObject3, "show_track_url")) {
                        c0039a.l = j(jSONObject3.getJSONArray("show_track_url"));
                    }
                    if (g(jSONObject3, "click_track_url")) {
                        c0039a.m = j(jSONObject3.getJSONArray("click_track_url"));
                    }
                    if (g(jSONObject3, "download_track_url")) {
                        c0039a.n = j(jSONObject3.getJSONArray("download_track_url"));
                    }
                    if (g(jSONObject3, "install_track_url")) {
                        c0039a.o = j(jSONObject3.getJSONArray("install_track_url"));
                    }
                    if (g(jSONObject3, IAdInterListener.AdReqParam.WIDTH)) {
                        jSONObject3.getInt(IAdInterListener.AdReqParam.WIDTH);
                    }
                    if (g(jSONObject3, "tanUrl")) {
                        c0039a.p = jSONObject3.getString("tanUrl");
                    }
                    if (g(jSONObject3, "ci")) {
                        jSONObject3.getString("ci");
                    }
                    arrayList.add(c0039a);
                }
                c0038a.f4715a = arrayList;
                aVar.f4714e = c0038a;
            }
        }
        return aVar;
    }

    private static List<String> j(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        return arrayList;
    }

    public void f(com.martian.ttbook.b.b.b.a aVar) {
        this.f4711b = aVar;
    }

    public com.martian.ttbook.b.b.b.a i() {
        return this.f4711b;
    }

    public boolean k() {
        List<C0038a.C0039a> list;
        C0038a c0038a = this.f4714e;
        return (c0038a == null || (list = c0038a.f4715a) == null || list.size() <= 0) ? false : true;
    }

    public boolean l() {
        return this.f4712c == 0;
    }
}
