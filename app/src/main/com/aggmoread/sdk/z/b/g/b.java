package com.aggmoread.sdk.z.b.g;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.comm.constants.Constants;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends com.aggmoread.sdk.z.b.e {

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.h.c f4440b;

    /* renamed from: c */
    public int f4441c;

    /* renamed from: d */
    public String f4442d;

    /* renamed from: e */
    public List<a> f4443e;

    public static class a {

        /* renamed from: a */
        private List<C0072a> f4444a;

        /* renamed from: com.aggmoread.sdk.z.b.g.b$a$a */
        public static class C0072a {

            /* renamed from: a */
            public String f4445a;

            /* renamed from: b */
            public String f4446b;

            /* renamed from: c */
            public String f4447c;

            /* renamed from: d */
            public String f4448d;

            /* renamed from: e */
            public List<C0073a> f4449e;

            /* renamed from: f */
            public String f4450f;

            /* renamed from: g */
            public int f4451g;

            /* renamed from: h */
            public int f4452h;

            /* renamed from: i */
            public String f4453i;

            /* renamed from: j */
            public List<String> f4454j;

            /* renamed from: k */
            public List<String> f4455k;

            /* renamed from: l */
            public List<String> f4456l;

            /* renamed from: m */
            public List<String> f4457m;

            /* renamed from: n */
            public List<String> f4458n;

            /* renamed from: o */
            public List<String> f4459o;

            /* renamed from: p */
            public List<String> f4460p;

            /* renamed from: q */
            public List<String> f4461q;

            /* renamed from: r */
            public List<String> f4462r;

            /* renamed from: s */
            public int f4463s = -1;

            /* renamed from: com.aggmoread.sdk.z.b.g.b$a$a$a */
            public static class C0073a {

                /* renamed from: a */
                public int f4464a;

                /* renamed from: b */
                public List<String> f4465b;

                public String toString() {
                    return "DeepLinkTrack{type=" + this.f4464a + ", urls=" + this.f4465b + '}';
                }
            }

            public String a() {
                return this.f4447c;
            }

            public List<String> b() {
                return this.f4457m;
            }

            public List<String> c() {
                return this.f4458n;
            }

            public List<String> d() {
                return this.f4459o;
            }

            public String e() {
                return this.f4446b;
            }

            public String f() {
                List<String> list = this.f4454j;
                return (list == null || list.size() <= 0) ? "" : this.f4454j.get(0);
            }

            public List<String> g() {
                return this.f4454j;
            }

            public int h() {
                return this.f4452h;
            }

            public String i() {
                return !TextUtils.isEmpty(this.f4446b) ? this.f4446b : !TextUtils.isEmpty(this.f4450f) ? this.f4450f : "";
            }

            public String j() {
                List<String> list = this.f4460p;
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return this.f4460p.get(0);
            }

            public List<String> k() {
                return this.f4455k;
            }

            public List<String> l() {
                List<String> list = this.f4460p;
                return list == null ? new ArrayList() : list;
            }

            public String m() {
                return this.f4445a;
            }

            public int n() {
                return this.f4463s;
            }

            public String o() {
                return this.f4453i;
            }

            public List<String> p() {
                return this.f4462r;
            }

            public List<String> q() {
                return this.f4461q;
            }

            public boolean r() {
                return this.f4451g == 2;
            }

            public List<String> a(int i10) {
                if (this.f4449e == null) {
                    return null;
                }
                for (int i11 = 0; i11 < this.f4449e.size(); i11++) {
                    C0073a c0073a = this.f4449e.get(i11);
                    if (i10 == c0073a.f4464a) {
                        return c0073a.f4465b;
                    }
                }
                return null;
            }

            public void b(int i10) {
            }

            public void c(int i10) {
            }

            public void d(int i10) {
                this.f4452h = i10;
            }

            public void e(int i10) {
                this.f4451g = i10;
            }

            public void f(int i10) {
                this.f4463s = i10;
            }

            public void g(int i10) {
            }

            public void h(int i10) {
            }

            public void i(int i10) {
            }

            public void j(List<String> list) {
                this.f4461q = list;
            }

            public void a(long j10) {
            }

            public void b(String str) {
                this.f4446b = str;
            }

            public void c(String str) {
                this.f4448d = str;
            }

            public void d(String str) {
                this.f4450f = str;
            }

            public void e(String str) {
            }

            public void f(String str) {
                this.f4445a = str;
            }

            public void g(String str) {
                this.f4453i = str;
            }

            public void h(List<String> list) {
                this.f4460p = list;
            }

            public void i(List<String> list) {
                this.f4462r = list;
            }

            public void a(String str) {
                this.f4447c = str;
            }

            public void b(List<String> list) {
                this.f4456l = list;
            }

            public void c(List<String> list) {
                this.f4457m = list;
            }

            public void d(List<String> list) {
                this.f4458n = list;
            }

            public void e(List<String> list) {
                this.f4459o = list;
            }

            public void f(List<String> list) {
                this.f4454j = list;
            }

            public void g(List<String> list) {
                this.f4455k = list;
            }

            public void a(List<C0073a> list) {
                this.f4449e = list;
            }
        }

        /* renamed from: com.aggmoread.sdk.z.b.g.b$a$b */
        public static class C0074b {

            /* renamed from: a */
            public int f4466a;

            /* renamed from: b */
            public List<String> f4467b;

            /* renamed from: c */
            public List<Object> f4468c;

            public void a(int i10) {
                this.f4466a = i10;
            }

            public String toString() {
                return "Track{type=" + this.f4466a + ", urls=" + this.f4467b + ", videoPlayPercentage=" + this.f4468c + '}';
            }

            public void a(List<String> list) {
                this.f4467b = list;
            }
        }

        public C0072a a() {
            List<C0072a> list = this.f4444a;
            if (list == null || list.size() <= 0) {
                return null;
            }
            return this.f4444a.get(0);
        }

        public void b(List<C0074b> list) {
        }

        public void a(String str) {
        }

        public void a(List<C0072a> list) {
            this.f4444a = list;
        }
    }

    private static List<a.C0072a.C0073a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            a.C0072a.C0073a c0073a = new a.C0072a.C0073a();
            JSONObject jSONObject = (JSONObject) jSONArray.get(i10);
            if (jSONObject.has("type") && !jSONObject.isNull("type")) {
                c0073a.f4464a = jSONObject.getInt("type");
            }
            if (jSONObject.has("urls") && !jSONObject.isNull("urls")) {
                c0073a.f4465b = b(jSONObject.getJSONArray("urls"));
            }
            arrayList.add(c0073a);
        }
        return arrayList;
    }

    public static b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.isNull(MediationConstant.KEY_ERROR_CODE) && jSONObject.has(MediationConstant.KEY_ERROR_CODE)) {
            String string = jSONObject.getString(MediationConstant.KEY_ERROR_CODE);
            if (!TextUtils.isEmpty(string)) {
                bVar.b(Integer.parseInt(string));
            }
        }
        if (!jSONObject.isNull("msg") && jSONObject.has("msg")) {
            String string2 = jSONObject.getString("msg");
            if (!TextUtils.isEmpty(string2)) {
                bVar.a(string2);
            }
        }
        if (jSONObject.has(com.sigmob.sdk.base.db.a.f18088a) && !jSONObject.isNull(com.sigmob.sdk.base.db.a.f18088a) && jSONObject.getJSONArray(com.sigmob.sdk.base.db.a.f18088a).length() > 0) {
            JSONArray jSONArray = jSONObject.getJSONArray(com.sigmob.sdk.base.db.a.f18088a);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i10);
                a aVar = new a();
                if (!jSONObject.isNull("slotId") && jSONObject2.has("slotId")) {
                    aVar.a(jSONObject2.getString("slotId"));
                }
                if (jSONObject2.has("metaGroup") && !jSONObject2.isNull("metaGroup") && jSONObject2.getJSONArray("metaGroup").length() > 0) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("metaGroup");
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray2.get(i11);
                        a.C0072a c0072a = new a.C0072a();
                        if (jSONObject3.has("price") && !jSONObject3.isNull("price")) {
                            c0072a.f(jSONObject3.getInt("price"));
                        }
                        if (jSONObject3.has("descs") && !jSONObject3.isNull("descs")) {
                            c0072a.f(b(jSONObject3.getJSONArray("descs")));
                        }
                        if (jSONObject3.has("imageUrl") && !jSONObject3.isNull("imageUrl")) {
                            c0072a.h(b(jSONObject3.getJSONArray("imageUrl")));
                        }
                        if (jSONObject3.has("iconUrls") && !jSONObject3.isNull("iconUrls")) {
                            c0072a.g(b(jSONObject3.getJSONArray("iconUrls")));
                        }
                        if (jSONObject3.has(Constants.KEYS.EXPOSED_CLICK_URL_KEY) && !jSONObject3.isNull(Constants.KEYS.EXPOSED_CLICK_URL_KEY)) {
                            c0072a.b(jSONObject3.getString(Constants.KEYS.EXPOSED_CLICK_URL_KEY));
                        }
                        if (jSONObject3.has("interactionType") && !jSONObject3.isNull("interactionType")) {
                            c0072a.e(jSONObject3.getInt("interactionType"));
                        }
                        if (jSONObject3.has("downType") && !jSONObject3.isNull("downType")) {
                            c0072a.d(jSONObject3.getInt("downType"));
                        }
                        if (jSONObject3.has("packageName") && !jSONObject3.isNull("packageName")) {
                            c0072a.f(jSONObject3.getString("packageName"));
                        }
                        if (jSONObject3.has("appSize") && !jSONObject3.isNull("appSize")) {
                            c0072a.b(jSONObject3.getInt("appSize"));
                        }
                        if (jSONObject3.has("downloadLink") && !jSONObject3.isNull("downloadLink")) {
                            c0072a.d(jSONObject3.getString("downloadLink"));
                        }
                        if (jSONObject3.has("winNoticeUrls") && !jSONObject3.isNull("winNoticeUrls")) {
                            c0072a.j(b(jSONObject3.getJSONArray("winNoticeUrls")));
                        }
                        if (jSONObject3.has("winCNoticeUrls") && !jSONObject3.isNull("winCNoticeUrls")) {
                            c0072a.i(b(jSONObject3.getJSONArray("winCNoticeUrls")));
                        }
                        if (jSONObject3.has("arrDownloadTrackUrl") && !jSONObject3.isNull("arrDownloadTrackUrl")) {
                            c0072a.b(b(jSONObject3.getJSONArray("arrDownloadTrackUrl")));
                        }
                        if (jSONObject3.has("arrDownloadedTrakUrl") && !jSONObject3.isNull("arrDownloadedTrakUrl")) {
                            c0072a.c(b(jSONObject3.getJSONArray("arrDownloadedTrakUrl")));
                        }
                        if (jSONObject3.has("arrIntallTrackUrl") && !jSONObject3.isNull("arrIntallTrackUrl")) {
                            c0072a.d(b(jSONObject3.getJSONArray("arrIntallTrackUrl")));
                        }
                        if (jSONObject3.has("arrIntalledTrackUrl") && !jSONObject3.isNull("arrIntalledTrackUrl")) {
                            c0072a.e(b(jSONObject3.getJSONArray("arrIntalledTrackUrl")));
                        }
                        if (jSONObject3.has("adTitle") && !jSONObject3.isNull("adTitle")) {
                            c0072a.a(jSONObject3.getString("adTitle"));
                        }
                        if (jSONObject3.has("deepLink") && !jSONObject3.isNull("deepLink")) {
                            c0072a.c(jSONObject3.getString("deepLink"));
                            if (jSONObject3.has("arrDeepLinkTrackUrl") && !jSONObject3.isNull("arrDeepLinkTrackUrl")) {
                                c0072a.a(a(jSONObject3.getJSONArray("arrDeepLinkTrackUrl")));
                            }
                        }
                        if (jSONObject3.has("creativeType") && !jSONObject3.isNull("creativeType")) {
                            c0072a.c(jSONObject3.getInt("creativeType"));
                        }
                        if (jSONObject3.has("videoUrl") && !jSONObject3.isNull("videoUrl")) {
                            c0072a.g(jSONObject3.getString("videoUrl"));
                        }
                        if (jSONObject3.has(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION) && !jSONObject3.isNull(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION)) {
                            c0072a.g(jSONObject3.getInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION));
                        }
                        if (jSONObject3.has(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE) && !jSONObject3.isNull(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE)) {
                            c0072a.a(jSONObject3.getLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE));
                        }
                        if (jSONObject3.has("videoWidth") && !jSONObject3.isNull("videoWidth")) {
                            c0072a.i(jSONObject3.getInt("videoWidth"));
                        }
                        if (jSONObject3.has("videoHeight") && !jSONObject3.isNull("videoHeight")) {
                            c0072a.h(jSONObject3.getInt("videoHeight"));
                        }
                        if (jSONObject3.has("end_card_html") && !jSONObject3.isNull("end_card_html")) {
                            c0072a.e(jSONObject3.getString("end_card_html"));
                        }
                        arrayList2.add(c0072a);
                    }
                    aVar.a(arrayList2);
                }
                if (jSONObject2.has("tracks") && !jSONObject.isNull("tracks")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("tracks");
                    ArrayList arrayList3 = new ArrayList();
                    for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i12);
                        a.C0074b c0074b = new a.C0074b();
                        if (jSONObject4.has("type") && !jSONObject4.isNull("type")) {
                            c0074b.a(jSONObject4.getInt("type"));
                        }
                        if (jSONObject4.has("urls") && !jSONObject4.isNull("urls")) {
                            c0074b.a(b(jSONObject4.getJSONArray("urls")));
                        }
                    }
                    aVar.b(arrayList3);
                }
                arrayList.add(aVar);
            }
        }
        bVar.a(arrayList);
        return bVar;
    }

    public com.aggmoread.sdk.z.b.h.c d() {
        return this.f4440b;
    }

    public boolean e() {
        List<a> list = this.f4443e;
        return list != null && list.size() > 0;
    }

    public boolean f() {
        return this.f4441c == 0;
    }

    private static List<String> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(jSONArray.getString(i10));
        }
        return arrayList;
    }

    public void a(com.aggmoread.sdk.z.b.h.c cVar) {
        this.f4440b = cVar;
    }

    public void a(String str) {
        this.f4442d = str;
    }

    public void b(int i10) {
        this.f4441c = i10;
    }

    public void a(List<a> list) {
        this.f4443e = list;
    }
}
