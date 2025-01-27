package com.ss.android.download.api.model;

import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.pa;
import com.vivo.ic.dm.Downloads;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: g */
    private final boolean f24070g;
    private final String gv;

    /* renamed from: i */
    private final String f24071i;

    /* renamed from: j */
    private String f24072j;
    private final JSONObject k;
    private final long lg;
    private final Object nt;
    private final String p;
    private final List<String> pa;
    private final long q;
    private final boolean r;
    private final JSONObject s;
    private final int t;
    private final String w;
    private final JSONObject y;
    private final String zx;

    public static class j {
        private JSONObject ei;
        private String gv;

        /* renamed from: i */
        private String f24074i;

        /* renamed from: j */
        private String f24075j;
        private JSONObject k;
        private long lg;
        private int nt;
        private Object p;
        private Map<String, Object> pa;
        private long q;
        private String r;
        private String s;
        private List<String> t;
        private JSONObject y;
        private String zx;

        /* renamed from: g */
        private boolean f24073g = false;
        private boolean w = false;

        public j g(String str) {
            this.r = str;
            return this;
        }

        public j i(String str) {
            this.gv = str;
            return this;
        }

        public j j(boolean z) {
            this.w = z;
            return this;
        }

        public j zx(String str) {
            this.f24074i = str;
            return this;
        }

        public j j(String str) {
            this.zx = str;
            return this;
        }

        public j zx(long j2) {
            this.lg = j2;
            return this;
        }

        public j j(long j2) {
            this.q = j2;
            return this;
        }

        public j zx(boolean z) {
            this.f24073g = z;
            return this;
        }

        public j j(JSONObject jSONObject) {
            this.y = jSONObject;
            return this;
        }

        public j zx(JSONObject jSONObject) {
            this.k = jSONObject;
            return this;
        }

        public j j(List<String> list) {
            this.t = list;
            return this;
        }

        public j j(int i2) {
            this.nt = i2;
            return this;
        }

        public j j(Object obj) {
            this.p = obj;
            return this;
        }

        public i j() {
            if (TextUtils.isEmpty(this.f24075j)) {
                this.f24075j = BaseConstants.CATEGORY_UMENG;
            }
            JSONObject jSONObject = new JSONObject();
            if (this.y == null) {
                this.y = new JSONObject();
            }
            try {
                Map<String, Object> map = this.pa;
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : this.pa.entrySet()) {
                        if (!this.y.has(entry.getKey())) {
                            this.y.putOpt(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (this.w) {
                    this.s = this.f24074i;
                    JSONObject jSONObject2 = new JSONObject();
                    this.ei = jSONObject2;
                    if (this.f24073g) {
                        jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.y.toString());
                    } else {
                        Iterator<String> keys = this.y.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            this.ei.put(next, this.y.get(next));
                        }
                    }
                    this.ei.put("category", this.f24075j);
                    this.ei.put("tag", this.zx);
                    this.ei.put(Downloads.RequestHeaders.COLUMN_VALUE, this.q);
                    this.ei.put("ext_value", this.lg);
                    if (!TextUtils.isEmpty(this.r)) {
                        this.ei.put("refer", this.r);
                    }
                    JSONObject jSONObject3 = this.k;
                    if (jSONObject3 != null) {
                        this.ei = com.ss.android.download.api.i.zx.j(jSONObject3, this.ei);
                    }
                    if (this.f24073g) {
                        if (!this.ei.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.gv)) {
                            this.ei.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.gv);
                        }
                        this.ei.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                    }
                }
                if (this.f24073g) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, this.y.toString());
                    if (!jSONObject.has(BaseConstants.EVENT_LABEL_LOG_EXTRA) && !TextUtils.isEmpty(this.gv)) {
                        jSONObject.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.gv);
                    }
                    jSONObject.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
                } else {
                    jSONObject.put("extra", this.y);
                }
                if (!TextUtils.isEmpty(this.r)) {
                    jSONObject.putOpt("refer", this.r);
                }
                JSONObject jSONObject4 = this.k;
                if (jSONObject4 != null) {
                    jSONObject = com.ss.android.download.api.i.zx.j(jSONObject4, jSONObject);
                }
                this.y = jSONObject;
            } catch (Exception e2) {
                pa.v().j(e2, "DownloadEventModel build");
            }
            return new i(this);
        }
    }

    i(j jVar) {
        this.f24072j = jVar.f24075j;
        this.zx = jVar.zx;
        this.f24071i = jVar.f24074i;
        this.f24070g = jVar.f24073g;
        this.q = jVar.q;
        this.gv = jVar.gv;
        this.lg = jVar.lg;
        this.y = jVar.y;
        this.k = jVar.k;
        this.pa = jVar.t;
        this.t = jVar.nt;
        this.nt = jVar.p;
        this.r = jVar.w;
        this.w = jVar.s;
        this.s = jVar.ei;
        this.p = jVar.r;
    }

    public boolean g() {
        return this.f24070g;
    }

    public String gv() {
        return this.gv;
    }

    public String i() {
        return this.f24071i;
    }

    public String j() {
        return this.f24072j;
    }

    public JSONObject k() {
        return this.k;
    }

    public long lg() {
        return this.lg;
    }

    public Object nt() {
        return this.nt;
    }

    public boolean p() {
        return this.r;
    }

    public List<String> pa() {
        return this.pa;
    }

    public long q() {
        return this.q;
    }

    public String r() {
        return this.w;
    }

    public int t() {
        return this.t;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("category: ");
        sb.append(this.f24072j);
        sb.append("\ttag: ");
        sb.append(this.zx);
        sb.append("\tlabel: ");
        sb.append(this.f24071i);
        sb.append("\nisAd: ");
        sb.append(this.f24070g);
        sb.append("\tadId: ");
        sb.append(this.q);
        sb.append("\tlogExtra: ");
        sb.append(this.gv);
        sb.append("\textValue: ");
        sb.append(this.lg);
        sb.append("\nextJson: ");
        sb.append(this.y);
        sb.append("\nparamsJson: ");
        sb.append(this.k);
        sb.append("\nclickTrackUrl: ");
        List<String> list = this.pa;
        sb.append(list != null ? list.toString() : "");
        sb.append("\teventSource: ");
        sb.append(this.t);
        sb.append("\textraObject: ");
        Object obj = this.nt;
        sb.append(obj != null ? obj.toString() : "");
        sb.append("\nisV3: ");
        sb.append(this.r);
        sb.append("\tV3EventName: ");
        sb.append(this.w);
        sb.append("\tV3EventParams: ");
        JSONObject jSONObject = this.s;
        sb.append(jSONObject != null ? jSONObject.toString() : "");
        return sb.toString();
    }

    public JSONObject w() {
        return this.s;
    }

    public JSONObject y() {
        return this.y;
    }

    public String zx() {
        return this.zx;
    }
}
