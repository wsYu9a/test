package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private String f21009a;

    /* renamed from: b */
    private final String f21010b;

    /* renamed from: c */
    private final String f21011c;

    /* renamed from: d */
    private final boolean f21012d;

    /* renamed from: e */
    private final long f21013e;

    /* renamed from: f */
    private final String f21014f;

    /* renamed from: g */
    private final long f21015g;

    /* renamed from: h */
    private final JSONObject f21016h;

    /* renamed from: i */
    private final JSONObject f21017i;

    /* renamed from: j */
    private final List<String> f21018j;

    /* renamed from: k */
    private final int f21019k;

    /* renamed from: l */
    private final Object f21020l;

    /* renamed from: m */
    private final String f21021m;

    /* renamed from: n */
    private final boolean f21022n;

    /* renamed from: o */
    private final String f21023o;

    /* renamed from: p */
    private final JSONObject f21024p;

    public static class a {

        /* renamed from: a */
        private String f21025a;

        /* renamed from: b */
        private String f21026b;

        /* renamed from: c */
        private String f21027c;

        /* renamed from: e */
        private long f21029e;

        /* renamed from: f */
        private String f21030f;

        /* renamed from: g */
        private long f21031g;

        /* renamed from: h */
        private JSONObject f21032h;

        /* renamed from: i */
        private JSONObject f21033i;

        /* renamed from: j */
        private Map<String, Object> f21034j;

        /* renamed from: k */
        private List<String> f21035k;

        /* renamed from: l */
        private int f21036l;

        /* renamed from: m */
        private Object f21037m;

        /* renamed from: n */
        private String f21038n;

        /* renamed from: p */
        private String f21040p;

        /* renamed from: q */
        private JSONObject f21041q;

        /* renamed from: d */
        private boolean f21028d = false;

        /* renamed from: o */
        private boolean f21039o = false;

        public a a(boolean z10) {
            this.f21039o = z10;
            return this;
        }

        public a b(String str) {
            this.f21027c = str;
            return this;
        }

        public a c(String str) {
            this.f21030f = str;
            return this;
        }

        public a d(String str) {
            this.f21038n = str;
            return this;
        }

        public a a(String str) {
            this.f21026b = str;
            return this;
        }

        public a b(long j10) {
            this.f21031g = j10;
            return this;
        }

        public a a(long j10) {
            this.f21029e = j10;
            return this;
        }

        public a b(boolean z10) {
            this.f21028d = z10;
            return this;
        }

        public a a(JSONObject jSONObject) {
            this.f21032h = jSONObject;
            return this;
        }

        public a b(JSONObject jSONObject) {
            this.f21033i = jSONObject;
            return this;
        }

        public a a(List<String> list) {
            this.f21035k = list;
            return this;
        }

        public a a(int i10) {
            this.f21036l = i10;
            return this;
        }

        public a a(Object obj) {
            this.f21037m = obj;
            return this;
        }

        public c a() {
            if (TextUtils.isEmpty(this.f21025a)) {
                this.f21025a = "umeng";
            }
            JSONObject jSONObject = new JSONObject();
            if (this.f21032h == null) {
                this.f21032h = new JSONObject();
            }
            try {
                Map<String, Object> map = this.f21034j;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.f21034j.entrySet()) {
                        if (!this.f21032h.has(entry.getKey())) {
                            this.f21032h.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.f21039o) {
                    this.f21040p = this.f21027c;
                    JSONObject jSONObject2 = new JSONObject();
                    this.f21041q = jSONObject2;
                    if (this.f21028d) {
                        jSONObject2.put("ad_extra_data", this.f21032h.toString());
                    } else {
                        Iterator<String> keys = this.f21032h.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.f21041q.put(next, this.f21032h.get(next));
                        }
                    }
                    this.f21041q.put("category", this.f21025a);
                    this.f21041q.put(TTDownloadField.TT_TAG, this.f21026b);
                    this.f21041q.put("value", this.f21029e);
                    this.f21041q.put("ext_value", this.f21031g);
                    if (!TextUtils.isEmpty(this.f21038n)) {
                        this.f21041q.put(TTDownloadField.TT_REFER, this.f21038n);
                    }
                    JSONObject jSONObject3 = this.f21033i;
                    if (jSONObject3 != null) {
                        this.f21041q = com.ss.android.download.api.c.b.a(jSONObject3, this.f21041q);
                    }
                    if (this.f21028d) {
                        if (!this.f21041q.has("log_extra") && !TextUtils.isEmpty(this.f21030f)) {
                            this.f21041q.put("log_extra", this.f21030f);
                        }
                        this.f21041q.put("is_ad_event", "1");
                    }
                }
                if (this.f21028d) {
                    jSONObject.put("ad_extra_data", this.f21032h.toString());
                    if (!jSONObject.has("log_extra") && !TextUtils.isEmpty(this.f21030f)) {
                        jSONObject.put("log_extra", this.f21030f);
                    }
                    jSONObject.put("is_ad_event", "1");
                } else {
                    jSONObject.put("extra", this.f21032h);
                }
                if (!TextUtils.isEmpty(this.f21038n)) {
                    jSONObject.putOpt(TTDownloadField.TT_REFER, this.f21038n);
                }
                JSONObject jSONObject4 = this.f21033i;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.c.b.a(jSONObject4, jSONObject);
                }
                this.f21032h = jSONObject;
            } catch (Exception e10) {
                k.u().a(e10, "DownloadEventModel build");
            }
            return new c(this);
        }
    }

    public c(a aVar) {
        this.f21009a = aVar.f21025a;
        this.f21010b = aVar.f21026b;
        this.f21011c = aVar.f21027c;
        this.f21012d = aVar.f21028d;
        this.f21013e = aVar.f21029e;
        this.f21014f = aVar.f21030f;
        this.f21015g = aVar.f21031g;
        this.f21016h = aVar.f21032h;
        this.f21017i = aVar.f21033i;
        this.f21018j = aVar.f21035k;
        this.f21019k = aVar.f21036l;
        this.f21020l = aVar.f21037m;
        this.f21022n = aVar.f21039o;
        this.f21023o = aVar.f21040p;
        this.f21024p = aVar.f21041q;
        this.f21021m = aVar.f21038n;
    }

    public String a() {
        return this.f21009a;
    }

    public String b() {
        return this.f21010b;
    }

    public String c() {
        return this.f21011c;
    }

    public boolean d() {
        return this.f21012d;
    }

    public long e() {
        return this.f21013e;
    }

    public String f() {
        return this.f21014f;
    }

    public long g() {
        return this.f21015g;
    }

    public JSONObject h() {
        return this.f21016h;
    }

    public JSONObject i() {
        return this.f21017i;
    }

    public List<String> j() {
        return this.f21018j;
    }

    public int k() {
        return this.f21019k;
    }

    public Object l() {
        return this.f21020l;
    }

    public boolean m() {
        return this.f21022n;
    }

    public String n() {
        return this.f21023o;
    }

    public JSONObject o() {
        return this.f21024p;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("category: ");
        sb2.append(this.f21009a);
        sb2.append("\ttag: ");
        sb2.append(this.f21010b);
        sb2.append("\tlabel: ");
        sb2.append(this.f21011c);
        sb2.append("\nisAd: ");
        sb2.append(this.f21012d);
        sb2.append("\tadId: ");
        sb2.append(this.f21013e);
        sb2.append("\tlogExtra: ");
        sb2.append(this.f21014f);
        sb2.append("\textValue: ");
        sb2.append(this.f21015g);
        sb2.append("\nextJson: ");
        sb2.append(this.f21016h);
        sb2.append("\nparamsJson: ");
        sb2.append(this.f21017i);
        sb2.append("\nclickTrackUrl: ");
        List<String> list = this.f21018j;
        sb2.append(list != null ? list.toString() : "");
        sb2.append("\teventSource: ");
        sb2.append(this.f21019k);
        sb2.append("\textraObject: ");
        Object obj = this.f21020l;
        sb2.append(obj != null ? obj.toString() : "");
        sb2.append("\nisV3: ");
        sb2.append(this.f21022n);
        sb2.append("\tV3EventName: ");
        sb2.append(this.f21023o);
        sb2.append("\tV3EventParams: ");
        JSONObject jSONObject = this.f21024p;
        sb2.append(jSONObject != null ? jSONObject.toString() : "");
        return sb2.toString();
    }
}
