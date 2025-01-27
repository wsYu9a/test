package com.vivo.ad.model;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.ic.jsonparser.JsonParserUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q extends j {

    /* renamed from: f */
    private int f26922f;

    /* renamed from: g */
    private String f26923g;

    /* renamed from: h */
    private long f26924h;

    /* renamed from: i */
    private int f26925i;

    /* renamed from: j */
    private String f26926j;
    private String k;
    private String l;
    private int m;
    private int n;
    private float o;
    private String p;
    private int q;
    private String r;
    private int s;
    private String t;
    private String u;
    private String v;
    private String w;
    private List<s> x;

    public q(JSONObject jSONObject, int i2) {
        super(jSONObject);
        this.n = -1;
        this.f26923g = JsonParserUtil.getString(TTDownloadField.TT_DOWNLOAD_URL, jSONObject);
        this.f26924h = JsonParserUtil.getInt(OapsKey.KEY_SIZE, jSONObject);
        this.f26925i = JsonParserUtil.getInt("installedShow", jSONObject);
        this.f26926j = JsonParserUtil.getString("channelTicket", jSONObject);
        this.k = JsonParserUtil.getString("encryptParam", jSONObject);
        this.l = JsonParserUtil.getString("thirdStParam", jSONObject);
        this.m = JsonParserUtil.getInt("dldBitCtl", jSONObject, i2 == 2 ? 127 : 511);
        this.o = JsonParserUtil.getFloat("score", jSONObject, 0.0f);
        this.p = JsonParserUtil.getString("downloadCount", jSONObject);
        this.q = JsonParserUtil.getInt("appointmentId", jSONObject);
        this.r = JsonParserUtil.getString("appointmentPackage", jSONObject);
        this.n = JsonParserUtil.getInt("direction", jSONObject, -1);
        this.f26922f = JsonParserUtil.getInt("jumpH5", jSONObject, 0);
        this.s = JsonParserUtil.getInt("googleDld", jSONObject, 0);
        this.t = JsonParserUtil.getString("privacyPolicyUrl", jSONObject);
        this.u = JsonParserUtil.getString("developer", jSONObject);
        this.v = JsonParserUtil.getString("name", jSONObject);
        this.w = JsonParserUtil.getString("versionName", jSONObject);
        this.x = new ArrayList();
        JSONArray jSONArray = JsonParserUtil.getJSONArray("permission", jSONObject);
        if (jSONArray != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    this.x.add(new s(jSONArray.getJSONObject(i3)));
                } catch (JSONException | Exception unused) {
                }
            }
        }
    }

    @Override // com.vivo.ad.model.j
    public String d() {
        return this.v;
    }

    public String e() {
        return this.r;
    }

    public String f() {
        return this.f26926j;
    }

    public String g() {
        return this.u;
    }

    public int h() {
        return this.n;
    }

    public int i() {
        return this.m;
    }

    public String j() {
        return this.p;
    }

    public String k() {
        return this.f26923g;
    }

    public String l() {
        return this.k;
    }

    public int m() {
        return this.f26922f;
    }

    public List<s> n() {
        return this.x;
    }

    public String o() {
        return this.t;
    }

    public float p() {
        return this.o;
    }

    public long q() {
        return this.f26924h;
    }

    public String r() {
        return this.l;
    }

    public String s() {
        return this.w;
    }

    public boolean t() {
        return this.s != 0;
    }

    @Override // com.vivo.ad.model.j
    public String toString() {
        return "NormalAppInfo{, downloadUrl='" + this.f26923g + "', size=" + this.f26924h + ", installedShow=" + this.f26925i + ", encryptParam='" + this.k + "', thirdStParam='" + this.l + "', dldBitCtl=" + this.m + ", score=" + this.o + ", downloadCount=" + this.p + ", appointmentId=" + this.q + ", appointmentPackage=" + this.r + ", jumpH5=" + this.f26922f + '}';
    }
}
