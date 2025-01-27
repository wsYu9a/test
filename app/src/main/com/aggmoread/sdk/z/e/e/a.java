package com.aggmoread.sdk.z.e.e;

import android.text.TextUtils;
import c7.g;
import com.aggmoread.sdk.z.b.d;
import com.aggmoread.sdk.z.b.e;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b */
    private com.aggmoread.sdk.z.e.f.a f6158b;

    /* renamed from: c */
    public int f6159c;

    /* renamed from: d */
    public String f6160d;

    /* renamed from: e */
    public String f6161e;

    /* renamed from: f */
    public String f6162f;

    /* renamed from: g */
    public C0192a f6163g;

    /* renamed from: com.aggmoread.sdk.z.e.e.a$a */
    public static class C0192a {

        /* renamed from: a */
        public List<C0193a> f6164a = new ArrayList();

        /* renamed from: com.aggmoread.sdk.z.e.e.a$a$a */
        public static class C0193a {

            /* renamed from: a */
            public String f6165a;

            /* renamed from: b */
            public int f6166b;

            /* renamed from: c */
            public String f6167c;

            /* renamed from: d */
            public String f6168d;

            /* renamed from: e */
            public String f6169e;

            /* renamed from: f */
            public String f6170f;

            /* renamed from: g */
            public String f6171g;

            /* renamed from: h */
            public String f6172h;

            /* renamed from: i */
            public int f6173i;

            /* renamed from: j */
            public int f6174j;

            /* renamed from: k */
            public int f6175k = 0;

            /* renamed from: l */
            public List<C0194a> f6176l = new ArrayList();

            /* renamed from: m */
            public List<String> f6177m = new ArrayList();

            /* renamed from: n */
            public List<String> f6178n = new ArrayList();

            /* renamed from: o */
            public b f6179o;

            /* renamed from: p */
            public String f6180p;

            /* renamed from: q */
            public String f6181q;

            /* renamed from: r */
            public String f6182r;

            /* renamed from: com.aggmoread.sdk.z.e.e.a$a$a$a */
            public static class C0194a {

                /* renamed from: a */
                public String f6183a;
            }

            /* renamed from: com.aggmoread.sdk.z.e.e.a$a$a$b */
            public static class b {

                /* renamed from: a */
                public List<String> f6184a = new ArrayList();

                /* renamed from: b */
                public List<String> f6185b = new ArrayList();

                public b() {
                    new ArrayList();
                }
            }

            /* renamed from: com.aggmoread.sdk.z.e.e.a$a$a$c */
            public static class c {

                /* renamed from: a */
                public List<String> f6186a;
            }

            public String a() {
                return !TextUtils.isEmpty(this.f6170f) ? this.f6170f : !TextUtils.isEmpty(this.f6171g) ? this.f6171g : "";
            }

            public String b() {
                C0194a c0194a;
                List<C0194a> list = this.f6176l;
                if (list == null || list.size() <= 0 || (c0194a = this.f6176l.get(0)) == null) {
                    return null;
                }
                return c0194a.f6183a;
            }

            public boolean c() {
                return this.f6174j == 1;
            }

            public String toString() {
                return "MetaGroupBean{impid='" + this.f6165a + "', price=" + this.f6166b + ", title='" + this.f6167c + "', desc='" + this.f6168d + "', icon='" + this.f6169e + "', click_url='" + this.f6170f + "', deeplink='" + this.f6171g + "', crid='" + this.f6172h + "', creative_type=" + this.f6173i + ", interaction_type=" + this.f6174j + ", w=" + this.f6175k + ", imgs=" + this.f6176l + ", show_track_url=" + this.f6177m + ", click_track_url=" + this.f6178n + ", video=" + this.f6179o + ", package_name='" + this.f6180p + "', tanUrl='" + this.f6181q + "', ci='" + this.f6182r + "'}";
            }
        }

        public C0193a a() {
            if (this.f6164a.size() > 0) {
                return this.f6164a.get(0);
            }
            return null;
        }

        public String toString() {
            return "AdsBean{meta=" + this.f6164a + '}';
        }
    }

    public static a b(JSONObject jSONObject) {
        a aVar = new a();
        if (a(jSONObject, "code")) {
            aVar.f6159c = jSONObject.getInt("code");
        }
        if (a(jSONObject, "id")) {
            aVar.f6161e = jSONObject.getString("id");
        }
        if (a(jSONObject, "bidid")) {
            aVar.f6162f = jSONObject.getString("bidid");
        }
        d.c("DARTAG", "build #1");
        if (a(jSONObject, "seatbid")) {
            d.c("DARTAG", "parse seatbid");
            C0192a c0192a = new C0192a();
            JSONArray jSONArray = jSONObject.getJSONArray("seatbid");
            if (jSONArray.length() > 0) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                if (a(jSONObject2, "bid")) {
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("bid");
                    if (jSONArray2.length() > 0) {
                        JSONArray jSONArray3 = jSONArray2.getJSONArray(0);
                        for (int i10 = 0; i10 < jSONArray3.length(); i10++) {
                            JSONObject jSONObject3 = (JSONObject) jSONArray3.get(i10);
                            C0192a.C0193a c0193a = new C0192a.C0193a();
                            if (a(jSONObject3, "impid")) {
                                c0193a.f6165a = jSONObject3.getString("impid");
                            }
                            if (a(jSONObject3, "price")) {
                                c0193a.f6166b = jSONObject3.getInt("price");
                            }
                            if (a(jSONObject3, "is_download")) {
                                c0193a.f6174j = jSONObject3.getInt("is_download");
                            }
                            if (a(jSONObject3, "title")) {
                                c0193a.f6167c = jSONObject3.getString("title");
                            }
                            if (a(jSONObject3, SocialConstants.PARAM_APP_DESC)) {
                                c0193a.f6168d = jSONObject3.getString(SocialConstants.PARAM_APP_DESC);
                            }
                            if (a(jSONObject3, "ldp")) {
                                c0193a.f6170f = jSONObject3.getString("ldp");
                            }
                            if (a(jSONObject3, "deeplink")) {
                                c0193a.f6171g = jSONObject3.getString("deeplink");
                            }
                            if (a(jSONObject3, "pkgname")) {
                                c0193a.f6180p = jSONObject3.getString("pkgname");
                            }
                            if (a(jSONObject3, "crid")) {
                                c0193a.f6172h = jSONObject3.getString("crid");
                            }
                            if (a(jSONObject3, "brand_logo")) {
                                c0193a.f6169e = jSONObject3.getString("brand_logo");
                            }
                            if (a(jSONObject3, "crid")) {
                                c0193a.f6172h = jSONObject3.getString("crid");
                            }
                            if (a(jSONObject3, "imptrackers")) {
                                JSONArray jSONArray4 = jSONObject3.getJSONArray("imptrackers");
                                if (jSONArray4.length() > 0) {
                                    for (int i11 = 0; i11 < jSONArray4.length(); i11++) {
                                        c0193a.f6177m.add(jSONArray4.getString(i11));
                                    }
                                }
                            }
                            if (a(jSONObject3, "clicktrackers")) {
                                JSONArray jSONArray5 = jSONObject3.getJSONArray("clicktrackers");
                                if (jSONArray5.length() > 0) {
                                    for (int i12 = 0; i12 < jSONArray5.length(); i12++) {
                                        c0193a.f6178n.add(jSONArray5.getString(i12));
                                    }
                                }
                            }
                            a(jSONObject3, c0193a);
                            b(jSONObject3, c0193a);
                            c0192a.f6164a.add(c0193a);
                            d.c("DARTAG", "parse seatbid " + i10 + ", meta bean " + c0193a);
                        }
                    }
                }
            }
            aVar.f6163g = c0192a;
        }
        d.c("DARTAG", "parse end " + aVar);
        return aVar;
    }

    public void a(com.aggmoread.sdk.z.e.f.a aVar) {
        this.f6158b = aVar;
    }

    public com.aggmoread.sdk.z.e.f.a d() {
        return this.f6158b;
    }

    public boolean e() {
        List<C0192a.C0193a> list;
        C0192a c0192a = this.f6163g;
        return (c0192a == null || (list = c0192a.f6164a) == null || list.size() <= 0) ? false : true;
    }

    public boolean f() {
        return this.f6159c == 0;
    }

    public String toString() {
        return "RsAdResponse{rsRequest=" + this.f6158b + ", code=" + this.f6159c + ", msg='" + this.f6160d + "', requestId='" + this.f6161e + "', bidId='" + this.f6162f + "', ads=" + this.f6163g + '}';
    }

    private static void a(JSONObject jSONObject, C0192a.C0193a c0193a) {
        if (a(jSONObject, "image")) {
            JSONArray jSONArray = jSONObject.getJSONArray("image");
            if (jSONArray.length() > 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    C0192a.C0193a.C0194a c0194a = new C0192a.C0193a.C0194a();
                    if (a(jSONObject2, "url")) {
                        c0194a.f6183a = jSONObject2.getString("url");
                    }
                    if (a(jSONObject2, "width")) {
                        jSONObject2.getInt("width");
                    }
                    if (a(jSONObject2, "height")) {
                        jSONObject2.getInt("height");
                    }
                    c0193a.f6176l.add(c0194a);
                }
            }
        }
    }

    private static void b(JSONObject jSONObject, C0192a.C0193a c0193a) {
        if (a(jSONObject, "video")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("video");
            C0192a.C0193a.b bVar = new C0192a.C0193a.b();
            if (a(jSONObject2, "vurl")) {
                jSONObject2.getString("vurl");
            }
            if (a(jSONObject2, "vsize")) {
                jSONObject2.getInt("vsize");
            }
            if (a(jSONObject2, "duration")) {
                jSONObject2.getInt("duration");
            }
            if (a(jSONObject2, "vw")) {
                jSONObject2.getInt("vw");
            }
            if (a(jSONObject2, "vh")) {
                jSONObject2.getInt("vh");
            }
            if (a(jSONObject2, "vm_p_start")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("vm_p_start");
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        String string = jSONArray.getString(i10);
                        if (!TextUtils.isEmpty(string)) {
                            bVar.f6184a.add(string);
                        }
                    }
                }
            }
            if (a(jSONObject2, "vm_p_succ")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("vm_p_succ");
                if (jSONArray2.length() > 0) {
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        String string2 = jSONArray2.getString(i11);
                        if (!TextUtils.isEmpty(string2)) {
                            bVar.f6185b.add(string2);
                        }
                    }
                }
            }
            if (a(jSONObject2, "vm_p_tracking")) {
                JSONArray jSONArray3 = jSONObject2.getJSONArray("vm_p_tracking");
                if (jSONArray3.length() > 0) {
                    for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i12);
                        C0192a.C0193a.c cVar = new C0192a.C0193a.c();
                        if (a(jSONObject3, "play_sec")) {
                            jSONObject3.getInt("play_sec");
                        }
                        if (a(jSONObject3, g.f1745c)) {
                            JSONArray jSONArray4 = jSONObject3.getJSONArray(g.f1745c);
                            if (jSONArray4.length() > 0) {
                                for (int i13 = 0; i13 < jSONArray4.length(); i13++) {
                                    String string3 = jSONArray4.getString(i13);
                                    if (!TextUtils.isEmpty(string3)) {
                                        cVar.f6186a.add(string3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return (jSONObject == null || jSONObject.isNull(str) || !jSONObject.has(str)) ? false : true;
    }
}
