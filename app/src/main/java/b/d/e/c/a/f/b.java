package b.d.e.c.a.f;

import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.connect.share.QzonePublish;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b extends b.d.e.c.a.e {

    /* renamed from: b */
    private com.martian.ttbook.b.a.g.c f4565b;

    /* renamed from: c */
    public int f4566c;

    /* renamed from: d */
    public String f4567d;

    /* renamed from: e */
    public List<a> f4568e;

    public static class a {

        /* renamed from: a */
        private List<C0022a> f4569a;

        /* renamed from: b.d.e.c.a.f.b$a$a */
        public static class C0022a {

            /* renamed from: a */
            public String f4570a;

            /* renamed from: b */
            public String f4571b;

            /* renamed from: c */
            public String f4572c;

            /* renamed from: d */
            public String f4573d;

            /* renamed from: e */
            public List<C0023a> f4574e;

            /* renamed from: f */
            public String f4575f;

            /* renamed from: g */
            public int f4576g;

            /* renamed from: h */
            public int f4577h;

            /* renamed from: i */
            public String f4578i;

            /* renamed from: j */
            public List<String> f4579j;
            public List<String> k;
            public List<String> l;
            public List<String> m;
            public List<String> n;
            public List<String> o;
            public List<String> p;
            public List<String> q;
            public List<String> r;

            /* renamed from: b.d.e.c.a.f.b$a$a$a */
            public static class C0023a {

                /* renamed from: a */
                public int f4580a;

                /* renamed from: b */
                public List<String> f4581b;

                public String toString() {
                    return "DeepLinkTrack{type=" + this.f4580a + ", urls=" + this.f4581b + '}';
                }
            }

            public void A(int i2) {
            }

            public void B(String str) {
                this.f4578i = str;
            }

            public void C(List<String> list) {
                this.k = list;
            }

            public String D() {
                return !TextUtils.isEmpty(this.f4571b) ? this.f4571b : !TextUtils.isEmpty(this.f4575f) ? this.f4575f : "";
            }

            public void E(int i2) {
            }

            public void F(List<String> list) {
                this.p = list;
            }

            public String G() {
                List<String> list = this.p;
                if (list == null || list.size() <= 0) {
                    return null;
                }
                return this.p.get(0);
            }

            public void H(List<String> list) {
                this.r = list;
            }

            public List<String> I() {
                return this.k;
            }

            public void J(List<String> list) {
                this.q = list;
            }

            public List<String> K() {
                List<String> list = this.p;
                return list == null ? new ArrayList() : list;
            }

            public String L() {
                return this.f4570a;
            }

            public String M() {
                return this.f4578i;
            }

            public List<String> N() {
                return this.r;
            }

            public List<String> O() {
                return this.q;
            }

            public boolean P() {
                return this.f4576g == 2;
            }

            public List<C0023a> a() {
                return this.f4574e;
            }

            public List<String> b(int i2) {
                if (this.f4574e == null) {
                    return null;
                }
                for (int i3 = 0; i3 < this.f4574e.size(); i3++) {
                    C0023a c0023a = this.f4574e.get(i3);
                    if (i2 == c0023a.f4580a) {
                        return c0023a.f4581b;
                    }
                }
                return null;
            }

            public void c(long j2) {
            }

            public void d(String str) {
                this.f4572c = str;
            }

            public void e(List<C0023a> list) {
                this.f4574e = list;
            }

            public List<String> f() {
                return this.m;
            }

            public void g(int i2) {
            }

            public void h(String str) {
                this.f4571b = str;
            }

            public void i(List<String> list) {
                this.l = list;
            }

            public List<String> j() {
                return this.n;
            }

            public void k(int i2) {
            }

            public void l(String str) {
                this.f4573d = str;
            }

            public void m(List<String> list) {
                this.m = list;
            }

            public List<String> n() {
                return this.o;
            }

            public void o(int i2) {
                this.f4577h = i2;
            }

            public void p(String str) {
                this.f4575f = str;
            }

            public void q(List<String> list) {
                this.n = list;
            }

            public String r() {
                return this.f4571b;
            }

            public void s(int i2) {
                this.f4576g = i2;
            }

            public void t(String str) {
            }

            public void u(List<String> list) {
                this.o = list;
            }

            public List<String> v() {
                return this.f4579j;
            }

            public void w(int i2) {
            }

            public void x(String str) {
                this.f4570a = str;
            }

            public void y(List<String> list) {
                this.f4579j = list;
            }

            public int z() {
                return this.f4577h;
            }
        }

        /* renamed from: b.d.e.c.a.f.b$a$b */
        public static class C0024b {

            /* renamed from: a */
            public int f4582a;

            /* renamed from: b */
            public List<String> f4583b;

            /* renamed from: c */
            public List<Object> f4584c;

            public void a(int i2) {
                this.f4582a = i2;
            }

            public void b(List<String> list) {
                this.f4583b = list;
            }

            public String toString() {
                return "Track{type=" + this.f4582a + ", urls=" + this.f4583b + ", videoPlayPercentage=" + this.f4584c + '}';
            }
        }

        public C0022a a() {
            List<C0022a> list = this.f4569a;
            if (list == null || list.size() <= 0) {
                return null;
            }
            return this.f4569a.get(0);
        }

        public void b(String str) {
        }

        public void c(List<C0022a> list) {
            this.f4569a = list;
        }

        public void d(List<C0024b> list) {
        }
    }

    private static List<a.C0022a.C0023a> e(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a.C0022a.C0023a c0023a = new a.C0022a.C0023a();
            JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
            if (jSONObject.has("type") && !jSONObject.isNull("type")) {
                c0023a.f4580a = jSONObject.getInt("type");
            }
            if (jSONObject.has("urls") && !jSONObject.isNull("urls")) {
                c0023a.f4581b = l(jSONObject.getJSONArray("urls"));
            }
            arrayList.add(c0023a);
        }
        return arrayList;
    }

    public static b j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.isNull("errorCode") && jSONObject.has("errorCode")) {
            String string = jSONObject.getString("errorCode");
            if (!TextUtils.isEmpty(string)) {
                bVar.f(Integer.parseInt(string));
            }
        }
        if (!jSONObject.isNull("msg") && jSONObject.has("msg")) {
            String string2 = jSONObject.getString("msg");
            if (!TextUtils.isEmpty(string2)) {
                bVar.h(string2);
            }
        }
        if (jSONObject.has("ads") && !jSONObject.isNull("ads") && jSONObject.getJSONArray("ads").length() > 0) {
            JSONArray jSONArray = jSONObject.getJSONArray("ads");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                a aVar = new a();
                if (!jSONObject.isNull("slotId") && jSONObject2.has("slotId")) {
                    aVar.b(jSONObject2.getString("slotId"));
                }
                if (jSONObject2.has("metaGroup") && !jSONObject2.isNull("metaGroup") && jSONObject2.getJSONArray("metaGroup").length() > 0) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("metaGroup");
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                        JSONObject jSONObject3 = (JSONObject) jSONArray2.get(i3);
                        a.C0022a c0022a = new a.C0022a();
                        if (jSONObject3.has("descs") && !jSONObject3.isNull("descs")) {
                            c0022a.y(l(jSONObject3.getJSONArray("descs")));
                        }
                        if (jSONObject3.has("imageUrl") && !jSONObject3.isNull("imageUrl")) {
                            c0022a.F(l(jSONObject3.getJSONArray("imageUrl")));
                        }
                        if (jSONObject3.has("iconUrls") && !jSONObject3.isNull("iconUrls")) {
                            c0022a.C(l(jSONObject3.getJSONArray("iconUrls")));
                        }
                        if (jSONObject3.has(Constants.KEYS.EXPOSED_CLICK_URL_KEY) && !jSONObject3.isNull(Constants.KEYS.EXPOSED_CLICK_URL_KEY)) {
                            c0022a.h(jSONObject3.getString(Constants.KEYS.EXPOSED_CLICK_URL_KEY));
                        }
                        if (jSONObject3.has("interactionType") && !jSONObject3.isNull("interactionType")) {
                            c0022a.s(jSONObject3.getInt("interactionType"));
                        }
                        if (jSONObject3.has("downType") && !jSONObject3.isNull("downType")) {
                            c0022a.o(jSONObject3.getInt("downType"));
                        }
                        if (jSONObject3.has(DBDefinition.PACKAGE_NAME) && !jSONObject3.isNull(DBDefinition.PACKAGE_NAME)) {
                            c0022a.x(jSONObject3.getString(DBDefinition.PACKAGE_NAME));
                        }
                        if (jSONObject3.has("appSize") && !jSONObject3.isNull("appSize")) {
                            c0022a.g(jSONObject3.getInt("appSize"));
                        }
                        if (jSONObject3.has("downloadLink") && !jSONObject3.isNull("downloadLink")) {
                            c0022a.p(jSONObject3.getString("downloadLink"));
                        }
                        if (jSONObject3.has("winNoticeUrls") && !jSONObject3.isNull("winNoticeUrls")) {
                            c0022a.J(l(jSONObject3.getJSONArray("winNoticeUrls")));
                        }
                        if (jSONObject3.has("winCNoticeUrls") && !jSONObject3.isNull("winCNoticeUrls")) {
                            c0022a.H(l(jSONObject3.getJSONArray("winCNoticeUrls")));
                        }
                        if (jSONObject3.has("arrDownloadTrackUrl") && !jSONObject3.isNull("arrDownloadTrackUrl")) {
                            c0022a.i(l(jSONObject3.getJSONArray("arrDownloadTrackUrl")));
                        }
                        if (jSONObject3.has("arrDownloadedTrakUrl") && !jSONObject3.isNull("arrDownloadedTrakUrl")) {
                            c0022a.m(l(jSONObject3.getJSONArray("arrDownloadedTrakUrl")));
                        }
                        if (jSONObject3.has("arrIntallTrackUrl") && !jSONObject3.isNull("arrIntallTrackUrl")) {
                            c0022a.q(l(jSONObject3.getJSONArray("arrIntallTrackUrl")));
                        }
                        if (jSONObject3.has("arrIntalledTrackUrl") && !jSONObject3.isNull("arrIntalledTrackUrl")) {
                            c0022a.u(l(jSONObject3.getJSONArray("arrIntalledTrackUrl")));
                        }
                        if (jSONObject3.has("adTitle") && !jSONObject3.isNull("adTitle")) {
                            c0022a.d(jSONObject3.getString("adTitle"));
                        }
                        if (jSONObject3.has("deepLink") && !jSONObject3.isNull("deepLink")) {
                            c0022a.l(jSONObject3.getString("deepLink"));
                            if (jSONObject3.has("arrDeepLinkTrackUrl") && !jSONObject3.isNull("arrDeepLinkTrackUrl")) {
                                c0022a.e(e(jSONObject3.getJSONArray("arrDeepLinkTrackUrl")));
                            }
                        }
                        if (jSONObject3.has("creativeType") && !jSONObject3.isNull("creativeType")) {
                            c0022a.k(jSONObject3.getInt("creativeType"));
                        }
                        if (jSONObject3.has("videoUrl") && !jSONObject3.isNull("videoUrl")) {
                            c0022a.B(jSONObject3.getString("videoUrl"));
                        }
                        if (jSONObject3.has(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION) && !jSONObject3.isNull(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION)) {
                            c0022a.w(jSONObject3.getInt(QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION));
                        }
                        if (jSONObject3.has(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE) && !jSONObject3.isNull(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE)) {
                            c0022a.c(jSONObject3.getLong(QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE));
                        }
                        if (jSONObject3.has("videoWidth") && !jSONObject3.isNull("videoWidth")) {
                            c0022a.E(jSONObject3.getInt("videoWidth"));
                        }
                        if (jSONObject3.has("videoHeight") && !jSONObject3.isNull("videoHeight")) {
                            c0022a.A(jSONObject3.getInt("videoHeight"));
                        }
                        if (jSONObject3.has("end_card_html") && !jSONObject3.isNull("end_card_html")) {
                            c0022a.t(jSONObject3.getString("end_card_html"));
                        }
                        arrayList2.add(c0022a);
                    }
                    aVar.c(arrayList2);
                }
                if (jSONObject2.has("tracks") && !jSONObject.isNull("tracks")) {
                    JSONArray jSONArray3 = jSONObject2.getJSONArray("tracks");
                    ArrayList arrayList3 = new ArrayList();
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        JSONObject jSONObject4 = jSONArray3.getJSONObject(i4);
                        a.C0024b c0024b = new a.C0024b();
                        if (jSONObject4.has("type") && !jSONObject4.isNull("type")) {
                            c0024b.a(jSONObject4.getInt("type"));
                        }
                        if (jSONObject4.has("urls") && !jSONObject4.isNull("urls")) {
                            c0024b.b(l(jSONObject4.getJSONArray("urls")));
                        }
                    }
                    aVar.d(arrayList3);
                }
                arrayList.add(aVar);
            }
        }
        bVar.i(arrayList);
        return bVar;
    }

    private static List<String> l(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.getString(i2));
        }
        return arrayList;
    }

    public void f(int i2) {
        this.f4566c = i2;
    }

    public void g(com.martian.ttbook.b.a.g.c cVar) {
        this.f4565b = cVar;
    }

    public void h(String str) {
        this.f4567d = str;
    }

    public void i(List<a> list) {
        this.f4568e = list;
    }

    public com.martian.ttbook.b.a.g.c k() {
        return this.f4565b;
    }

    public boolean m() {
        List<a> list = this.f4568e;
        return list != null && list.size() > 0;
    }

    public boolean n() {
        return this.f4566c == 0;
    }
}
