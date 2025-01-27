package com.aggmoread.sdk.z.a.d;

import android.text.TextUtils;
import b7.d;
import com.aggmoread.sdk.z.b.e;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends e {

    /* renamed from: b */
    private com.aggmoread.sdk.z.a.e.a f4150b;

    /* renamed from: c */
    public int f4151c;

    /* renamed from: d */
    public String f4152d;

    /* renamed from: e */
    public C0052a f4153e;

    /* renamed from: com.aggmoread.sdk.z.a.d.a$a */
    public static class C0052a {

        /* renamed from: a */
        public int f4154a;

        /* renamed from: b */
        public List<C0053a> f4155b = new ArrayList();

        /* renamed from: com.aggmoread.sdk.z.a.d.a$a$a */
        public static class C0053a {
            public String A;
            public String B;
            public String C;

            /* renamed from: a */
            public int f4156a;

            /* renamed from: b */
            public double f4157b;

            /* renamed from: c */
            public String f4158c;

            /* renamed from: d */
            public String f4159d;

            /* renamed from: e */
            public String f4160e;

            /* renamed from: g */
            public String f4162g;

            /* renamed from: h */
            public String f4163h;

            /* renamed from: i */
            public int f4164i;

            /* renamed from: j */
            public int f4165j;

            /* renamed from: o */
            public d f4170o;

            /* renamed from: p */
            public C0054a f4171p;

            /* renamed from: q */
            public String f4172q;

            /* renamed from: r */
            public int f4173r;

            /* renamed from: s */
            public int f4174s;

            /* renamed from: t */
            public int f4175t;

            /* renamed from: u */
            public String f4176u;

            /* renamed from: v */
            public int f4177v;

            /* renamed from: w */
            public String f4178w;

            /* renamed from: x */
            public String f4179x;

            /* renamed from: y */
            public String f4180y;

            /* renamed from: z */
            public int f4181z;

            /* renamed from: f */
            public String f4161f = null;

            /* renamed from: k */
            public int f4166k = 0;

            /* renamed from: l */
            public List<c> f4167l = new ArrayList();

            /* renamed from: m */
            public List<String> f4168m = new ArrayList();

            /* renamed from: n */
            public List<String> f4169n = new ArrayList();

            /* renamed from: com.aggmoread.sdk.z.a.d.a$a$a$a */
            public static class C0054a {

                /* renamed from: a */
                public String f4182a;

                /* renamed from: b */
                public String f4183b;

                /* renamed from: c */
                public long f4184c;

                /* renamed from: d */
                public String f4185d;

                /* renamed from: e */
                public String f4186e;

                /* renamed from: f */
                public String f4187f;

                /* renamed from: g */
                public String f4188g;

                /* renamed from: h */
                public String f4189h;

                /* renamed from: i */
                public String f4190i;

                /* renamed from: j */
                public String f4191j;

                /* renamed from: o */
                public String f4196o;

                /* renamed from: k */
                public List<String> f4192k = new ArrayList();

                /* renamed from: l */
                public List<String> f4193l = new ArrayList();

                /* renamed from: m */
                public List<String> f4194m = new ArrayList();

                /* renamed from: n */
                public List<String> f4195n = new ArrayList();

                /* renamed from: p */
                public List<b> f4197p = new ArrayList();

                public List<String> a(int i10) {
                    for (int i11 = 0; i11 < this.f4197p.size(); i11++) {
                        b bVar = this.f4197p.get(i11);
                        if (bVar.f4198a == i10) {
                            return bVar.f4199b;
                        }
                    }
                    return null;
                }

                public String toString() {
                    return "AppObj{pkgName='" + this.f4182a + "', name='" + this.f4183b + "', size=" + this.f4184c + ", md5='" + this.f4185d + "', logoUrl='" + this.f4186e + "', downUrl='" + this.f4187f + "', softCorpName='" + this.f4188g + "', sensitiveUrl='" + this.f4189h + "', usesPermission='" + this.f4190i + "', version='" + this.f4191j + "', dsUrls=" + this.f4192k + ", dfUrls=" + this.f4193l + ", ssUrls=" + this.f4194m + ", sfUrls=" + this.f4195n + ", deepLink='" + this.f4196o + "', eventTracks=" + this.f4197p + '}';
                }
            }

            /* renamed from: com.aggmoread.sdk.z.a.d.a$a$a$b */
            public static class b {

                /* renamed from: a */
                public int f4198a;

                /* renamed from: b */
                public List<String> f4199b = new ArrayList();

                public String toString() {
                    return "EventTrackObj{eventType=" + this.f4198a + ", eventTrackUrls=" + this.f4199b + '}';
                }
            }

            /* renamed from: com.aggmoread.sdk.z.a.d.a$a$a$c */
            public static class c {

                /* renamed from: a */
                public String f4200a;

                /* renamed from: b */
                public double f4201b;

                /* renamed from: c */
                public double f4202c;

                /* renamed from: d */
                public String f4203d;

                public String toString() {
                    return "ImageObj{url='" + this.f4200a + "', width=" + this.f4201b + ", height=" + this.f4202c + ", desc='" + this.f4203d + "'}";
                }
            }

            /* renamed from: com.aggmoread.sdk.z.a.d.a$a$a$d */
            public static class d {

                /* renamed from: a */
                public String f4204a;

                /* renamed from: b */
                public String f4205b;

                /* renamed from: c */
                public int f4206c;

                /* renamed from: d */
                public int f4207d;

                /* renamed from: e */
                public int f4208e;

                /* renamed from: f */
                public int f4209f;

                /* renamed from: g */
                public int f4210g;

                /* renamed from: h */
                public int f4211h;

                /* renamed from: i */
                public int f4212i;

                /* renamed from: j */
                public int f4213j;

                /* renamed from: k */
                public int f4214k;

                /* renamed from: l */
                public String f4215l;

                /* renamed from: m */
                public String f4216m;

                /* renamed from: n */
                public String f4217n;

                /* renamed from: o */
                public String f4218o;

                /* renamed from: p */
                public String f4219p;

                /* renamed from: q */
                public String f4220q;

                /* renamed from: r */
                public String f4221r;

                /* renamed from: s */
                public String f4222s;

                /* renamed from: t */
                public int f4223t;

                /* renamed from: u */
                public List<b> f4224u = new ArrayList();

                public List<String> a(int i10) {
                    for (int i11 = 0; i11 < this.f4224u.size(); i11++) {
                        b bVar = this.f4224u.get(i11);
                        if (bVar.f4198a == i10) {
                            return bVar.f4199b;
                        }
                    }
                    return null;
                }

                public String toString() {
                    return "VideoObj{videoUrl='" + this.f4204a + "', coverUrl='" + this.f4205b + "', length=" + this.f4206c + ", duration=" + this.f4207d + ", width=" + this.f4208e + ", height=" + this.f4209f + ", mimeType=" + this.f4210g + ", videoType=" + this.f4211h + ", skip=" + this.f4212i + ", skipMinTime=" + this.f4213j + ", preloadTtl=" + this.f4214k + ", endcardUrl='" + this.f4215l + "', backgroundUrl='" + this.f4216m + "', videoDesc='" + this.f4217n + "', c_url='" + this.f4218o + "', lastFrameText='" + this.f4219p + "', lastFrameIconUrl='" + this.f4220q + "', iconUrl='" + this.f4221r + "', iconDesc='" + this.f4222s + "', validTime=" + this.f4223t + ", eventTracks=" + this.f4224u + '}';
                }
            }

            public String a() {
                return !TextUtils.isEmpty(this.f4161f) ? this.f4161f : !TextUtils.isEmpty(this.f4162g) ? this.f4162g : "";
            }

            public String b() {
                c cVar;
                List<c> list = this.f4167l;
                if (list == null || list.size() <= 0 || (cVar = this.f4167l.get(0)) == null) {
                    return null;
                }
                return cVar.f4200a;
            }

            public boolean c() {
                return this.f4165j == 1;
            }

            public String toString() {
                return "MetaGroupBean{id=" + this.f4156a + ", price=" + this.f4157b + ", title='" + this.f4158c + "', desc='" + this.f4159d + "', icon='" + this.f4160e + "', click_url='" + this.f4161f + "', deeplink='" + this.f4162g + "', crid='" + this.f4163h + "', creative_type=" + this.f4164i + ", interaction_type=" + this.f4165j + ", w=" + this.f4166k + ", imgs=" + this.f4167l + ", show_track_url=" + this.f4168m + ", click_track_url=" + this.f4169n + ", video=" + this.f4170o + ", appInfo=" + this.f4171p + ", package_name='" + this.f4172q + "', adWidth=" + this.f4173r + ", adHeight=" + this.f4174s + ", adType=" + this.f4175t + ", source='" + this.f4176u + "', nativeAdType=" + this.f4177v + ", matterIcon='" + this.f4178w + "', actionurl='" + this.f4179x + "', phone_no='" + this.f4180y + "', htmltype=" + this.f4181z + ", admhtml='" + this.A + "', tanUrl='" + this.B + "', ci='" + this.C + "'}";
            }

            public List<String> a(int i10) {
                C0054a c0054a = this.f4171p;
                if (c0054a != null) {
                    return c0054a.a(i10);
                }
                return null;
            }

            public List<String> b(int i10) {
                d dVar = this.f4170o;
                if (dVar != null) {
                    return dVar.a(i10);
                }
                return null;
            }
        }

        public C0053a a() {
            if (this.f4155b.size() > 0) {
                return this.f4155b.get(0);
            }
            return null;
        }

        public String toString() {
            return "AdsBean{impid='" + this.f4154a + "', meta=" + this.f4155b + '}';
        }
    }

    private static C0052a.C0053a.b a(JSONObject jSONObject, JSONObject jSONObject2, int i10) {
        C0052a.C0053a.b bVar = new C0052a.C0053a.b();
        if (a(jSONObject, "eventType")) {
            bVar.f4198a = jSONObject.getInt("eventType");
        }
        if (a(jSONObject2, "eventTrackUrls")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("eventTrackUrls");
            if (jSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    bVar.f4199b.add(jSONArray.getString(i11));
                }
            }
        }
        return bVar;
    }

    public static a b(JSONObject jSONObject) {
        a aVar = new a();
        if (a(jSONObject, "code")) {
            aVar.f4151c = jSONObject.getInt("code");
        }
        if (a(jSONObject, d.f1362o)) {
            aVar.f4152d = jSONObject.getString(d.f1362o);
        }
        com.aggmoread.sdk.z.b.d.c("DARTAG", "build #1");
        if (a(jSONObject, h3.e.f26408m)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(h3.e.f26408m);
            if (a(jSONObject2, "requestId")) {
                jSONObject2.getString("requestId");
            }
            if (a(jSONObject2, "ts")) {
                jSONObject2.getLong("ts");
            }
            com.aggmoread.sdk.z.b.d.c("DARTAG", "parse data");
            C0052a c0052a = new C0052a();
            if (a(jSONObject2, "groups")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("groups");
                if (jSONArray.length() > 0) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(0);
                    if (a(jSONObject3, "impId")) {
                        c0052a.f4154a = jSONObject3.getInt("impId");
                    }
                    if (a(jSONObject3, com.sigmob.sdk.base.db.a.f18088a)) {
                        JSONArray jSONArray2 = jSONObject3.getJSONArray(com.sigmob.sdk.base.db.a.f18088a);
                        if (jSONArray2.length() > 0) {
                            JSONObject jSONObject4 = jSONArray2.getJSONObject(0);
                            C0052a.C0053a c0053a = new C0052a.C0053a();
                            if (a(jSONObject4, "id")) {
                                c0053a.f4156a = jSONObject4.getInt("id");
                            }
                            if (a(jSONObject4, "price")) {
                                c0053a.f4157b = jSONObject4.getInt("price");
                            }
                            if (a(jSONObject4, "downloadAd")) {
                                c0053a.f4165j = jSONObject4.getInt("downloadAd");
                            }
                            if (a(jSONObject4, "title")) {
                                c0053a.f4158c = jSONObject4.getString("title");
                            }
                            if (a(jSONObject4, SocialConstants.PARAM_APP_DESC)) {
                                c0053a.f4159d = jSONObject4.getString(SocialConstants.PARAM_APP_DESC);
                            }
                            if (a(jSONObject4, "link")) {
                                c0053a.f4161f = jSONObject4.getString("link");
                            }
                            if (a(jSONObject4, "creativeId")) {
                                c0053a.f4163h = jSONObject4.getString("creativeId");
                            }
                            if (a(jSONObject4, "adIcon")) {
                                c0053a.f4160e = jSONObject4.getString("adIcon");
                            }
                            if (a(jSONObject4, "source")) {
                                c0053a.f4176u = jSONObject4.getString("source");
                            }
                            if (a(jSONObject4, "adType")) {
                                c0053a.f4175t = jSONObject4.getInt("adType");
                            }
                            if (a(jSONObject4, "adWidth")) {
                                c0053a.f4173r = jSONObject4.getInt("adWidth");
                            }
                            if (a(jSONObject4, "adHeight")) {
                                c0053a.f4174s = jSONObject4.getInt("adHeight");
                            }
                            if (a(jSONObject4, "nativeAdType")) {
                                c0053a.f4177v = jSONObject4.getInt("nativeAdType");
                            }
                            if (a(jSONObject4, "matterIcon")) {
                                c0053a.f4178w = jSONObject4.getString("matterIcon");
                            }
                            if (a(jSONObject4, "actionurl")) {
                                c0053a.f4179x = jSONObject4.getString("actionurl");
                            }
                            if (a(jSONObject4, "phone_no")) {
                                c0053a.f4180y = jSONObject4.getString("phone_no");
                            }
                            if (a(jSONObject4, "htmltype")) {
                                c0053a.f4181z = jSONObject4.getInt("htmltype");
                            }
                            if (a(jSONObject4, "admhtml")) {
                                c0053a.A = jSONObject4.getString("admhtml");
                            }
                            if (a(jSONObject4, "impTrackUrls")) {
                                JSONArray jSONArray3 = jSONObject4.getJSONArray("impTrackUrls");
                                if (jSONArray3.length() > 0) {
                                    for (int i10 = 0; i10 < jSONArray3.length(); i10++) {
                                        c0053a.f4168m.add(jSONArray3.getString(i10));
                                    }
                                }
                            }
                            if (a(jSONObject4, "clickTrackUrls")) {
                                JSONArray jSONArray4 = jSONObject4.getJSONArray("clickTrackUrls");
                                if (jSONArray4.length() > 0) {
                                    for (int i11 = 0; i11 < jSONArray4.length(); i11++) {
                                        c0053a.f4169n.add(jSONArray4.getString(i11));
                                    }
                                }
                            }
                            b(jSONObject4, c0053a);
                            c(jSONObject4, c0053a);
                            a(jSONObject4, c0053a);
                            c0052a.f4155b.add(c0053a);
                            com.aggmoread.sdk.z.b.d.c("DARTAG", "parse  meta bean " + c0053a);
                        }
                    }
                }
            }
            aVar.f4153e = c0052a;
        }
        com.aggmoread.sdk.z.b.d.c("DARTAG", "parse end " + aVar);
        return aVar;
    }

    private static void c(JSONObject jSONObject, C0052a.C0053a c0053a) {
        if (a(jSONObject, "video")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("video");
            C0052a.C0053a.d dVar = new C0052a.C0053a.d();
            if (a(jSONObject2, "videoUrl")) {
                dVar.f4204a = jSONObject2.getString("videoUrl");
            }
            if (a(jSONObject2, com.sigmob.sdk.videocache.sourcestorage.a.f20681d)) {
                dVar.f4206c = jSONObject2.getInt(com.sigmob.sdk.videocache.sourcestorage.a.f20681d);
            }
            if (a(jSONObject2, "duration")) {
                dVar.f4207d = jSONObject2.getInt("duration");
            }
            if (a(jSONObject2, "mimeType")) {
                dVar.f4210g = jSONObject2.getInt("mimeType");
            }
            if (a(jSONObject2, "width")) {
                dVar.f4208e = jSONObject2.getInt("width");
            }
            if (a(jSONObject2, "height")) {
                dVar.f4209f = jSONObject2.getInt("height");
            }
            if (a(jSONObject2, "coverUrl")) {
                dVar.f4205b = jSONObject2.getString("coverUrl");
            }
            if (a(jSONObject2, "coverUrl")) {
                dVar.f4205b = jSONObject2.getString("coverUrl");
            }
            if (a(jSONObject2, "videoType")) {
                dVar.f4211h = jSONObject2.getInt("videoType");
            }
            if (a(jSONObject2, "skip")) {
                dVar.f4212i = jSONObject2.getInt("skip");
            }
            if (a(jSONObject2, "skipMinTime")) {
                dVar.f4213j = jSONObject2.getInt("skipMinTime");
            }
            if (a(jSONObject2, "preloadTtl")) {
                dVar.f4214k = jSONObject2.getInt("preloadTtl");
            }
            if (a(jSONObject2, "endcardUrl")) {
                dVar.f4215l = jSONObject2.getString("endcardUrl");
            }
            if (a(jSONObject2, "backgroundUrl")) {
                dVar.f4216m = jSONObject2.getString("backgroundUrl");
            }
            if (a(jSONObject2, "videoDesc")) {
                dVar.f4217n = jSONObject2.getString("videoDesc");
            }
            if (a(jSONObject2, "c_url")) {
                dVar.f4218o = jSONObject2.getString("c_url");
            }
            if (a(jSONObject2, "lastFrameText")) {
                dVar.f4219p = jSONObject2.getString("lastFrameText");
            }
            if (a(jSONObject2, "lastFrameIconUrl")) {
                dVar.f4220q = jSONObject2.getString("lastFrameIconUrl");
            }
            if (a(jSONObject2, DBDefinition.ICON_URL)) {
                dVar.f4221r = jSONObject2.getString(DBDefinition.ICON_URL);
            }
            if (a(jSONObject2, "iconDesc")) {
                dVar.f4222s = jSONObject2.getString("iconDesc");
            }
            if (a(jSONObject2, "validTime")) {
                dVar.f4223t = jSONObject2.getInt("validTime");
            }
            if (a(jSONObject2, "eventTracks")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("eventTracks");
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        dVar.f4224u.add(a(jSONObject2, jSONArray.getJSONObject(i10), i10));
                    }
                }
            }
            c0053a.f4170o = dVar;
        }
    }

    public com.aggmoread.sdk.z.a.e.a d() {
        return this.f4150b;
    }

    public boolean e() {
        List<C0052a.C0053a> list;
        C0052a c0052a = this.f4153e;
        return (c0052a == null || (list = c0052a.f4155b) == null || list.size() <= 0) ? false : true;
    }

    public boolean f() {
        return this.f4151c == 0;
    }

    public String toString() {
        return "RsAdResponse{rsRequest=" + this.f4150b + ", code=" + this.f4151c + ", msg='" + this.f4152d + "', ads=" + this.f4153e + '}';
    }

    private static void b(JSONObject jSONObject, C0052a.C0053a c0053a) {
        if (a(jSONObject, "imgs")) {
            JSONArray jSONArray = jSONObject.getJSONArray("imgs");
            if (jSONArray.length() > 0) {
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    C0052a.C0053a.c cVar = new C0052a.C0053a.c();
                    if (a(jSONObject2, "url")) {
                        cVar.f4200a = jSONObject2.getString("url");
                    }
                    if (a(jSONObject2, "width")) {
                        cVar.f4201b = jSONObject2.getInt("width");
                    }
                    if (a(jSONObject2, "height")) {
                        cVar.f4202c = jSONObject2.getInt("height");
                    }
                    if (a(jSONObject2, SocialConstants.PARAM_APP_DESC)) {
                        cVar.f4203d = jSONObject2.getString(SocialConstants.PARAM_APP_DESC);
                    }
                    c0053a.f4167l.add(cVar);
                }
            }
        }
    }

    public void a(com.aggmoread.sdk.z.a.e.a aVar) {
        this.f4150b = aVar;
    }

    private static void a(JSONObject jSONObject, C0052a.C0053a c0053a) {
        if (a(jSONObject, "appInfo")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("appInfo");
            C0052a.C0053a.C0054a c0054a = new C0052a.C0053a.C0054a();
            if (a(jSONObject2, PushClientConstants.TAG_PKG_NAME)) {
                c0054a.f4182a = jSONObject2.getString(PushClientConstants.TAG_PKG_NAME);
            }
            if (a(jSONObject2, "deepLink")) {
                String string = jSONObject2.getString("deepLink");
                c0054a.f4196o = string;
                c0053a.f4162g = string;
            }
            if (a(jSONObject2, "name")) {
                c0054a.f4183b = jSONObject2.getString("name");
            }
            if (a(jSONObject2, "size")) {
                c0054a.f4184c = jSONObject2.getLong("size");
            }
            if (a(jSONObject2, "md5")) {
                c0054a.f4185d = jSONObject2.getString("md5");
            }
            if (a(jSONObject2, "logoUrl")) {
                c0054a.f4186e = jSONObject2.getString("logoUrl");
            }
            if (a(jSONObject2, "downUrl")) {
                c0054a.f4187f = jSONObject2.getString("downUrl");
            }
            if (a(jSONObject2, "softCorpName")) {
                c0054a.f4188g = jSONObject2.getString("softCorpName");
            }
            if (a(jSONObject2, "sensitiveUrl")) {
                c0054a.f4189h = jSONObject2.getString("sensitiveUrl");
            }
            if (a(jSONObject2, "usesPermission")) {
                c0054a.f4190i = jSONObject2.getString("usesPermission");
            }
            if (a(jSONObject2, "version")) {
                c0054a.f4191j = jSONObject2.getString("version");
            }
            if (a(jSONObject2, "dsUrls")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("dsUrls");
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        c0054a.f4192k.add(jSONArray.getString(i10));
                    }
                }
            }
            if (a(jSONObject2, "dfUrls")) {
                JSONArray jSONArray2 = jSONObject2.getJSONArray("dfUrls");
                if (jSONArray2.length() > 0) {
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        c0054a.f4193l.add(jSONArray2.getString(i11));
                    }
                }
            }
            if (a(jSONObject2, "ssUrls")) {
                JSONArray jSONArray3 = jSONObject2.getJSONArray("ssUrls");
                if (jSONArray3.length() > 0) {
                    for (int i12 = 0; i12 < jSONArray3.length(); i12++) {
                        c0054a.f4194m.add(jSONArray3.getString(i12));
                    }
                }
            }
            if (a(jSONObject2, "sfUrls")) {
                JSONArray jSONArray4 = jSONObject2.getJSONArray("sfUrls");
                if (jSONArray4.length() > 0) {
                    for (int i13 = 0; i13 < jSONArray4.length(); i13++) {
                        c0054a.f4195n.add(jSONArray4.getString(i13));
                    }
                }
            }
            if (a(jSONObject2, "eventTracks")) {
                JSONArray jSONArray5 = jSONObject2.getJSONArray("eventTracks");
                if (jSONArray5.length() > 0) {
                    for (int i14 = 0; i14 < jSONArray5.length(); i14++) {
                        c0054a.f4197p.add(a(jSONObject2, jSONArray5.getJSONObject(i14), i14));
                    }
                }
            }
            c0053a.f4171p = c0054a;
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return (jSONObject == null || jSONObject.isNull(str) || !jSONObject.has(str)) ? false : true;
    }
}
