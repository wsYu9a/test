package com.vivo.ad.model;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.opos.acs.st.STManager;
import com.vivo.ic.jsonparser.JsonParserUtil;
import com.vivo.mobilead.util.x0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements Serializable {
    private String A;
    private String B;
    private String C;
    private String D;
    private long E;
    private int[] F;
    private m G;
    private d H;
    private boolean I;
    private o J;
    private g K;
    private String L;
    private int M;
    private int N;
    private String O;
    private int P;
    private String Q;
    private y R;

    /* renamed from: a */
    private e f26853a;

    /* renamed from: b */
    private String f26854b;

    /* renamed from: c */
    private int f26855c;

    /* renamed from: d */
    private String f26856d;

    /* renamed from: e */
    private int f26857e;

    /* renamed from: f */
    private String f26858f;

    /* renamed from: g */
    private int f26859g;

    /* renamed from: h */
    private int f26860h;

    /* renamed from: i */
    private int f26861i;

    /* renamed from: j */
    private int f26862j;
    private String k;
    private String l;
    private String m;
    private a0 n;
    private int o;
    private r p;
    private v q;
    private f r;
    private q s;
    private u t;
    private List<h> u;
    private ArrayList<a> v;
    private long w;
    private c x;
    private int y;
    private int z;

    public b(JSONObject jSONObject) {
        this.w = 0L;
        this.x = new c();
        this.y = 3;
        this.I = false;
        this.f26854b = JsonParserUtil.getString("positionId", jSONObject);
        this.f26855c = JsonParserUtil.getInt("subCode", jSONObject);
        this.f26856d = JsonParserUtil.getString(STManager.KEY_AD_ID, jSONObject);
        this.f26857e = JsonParserUtil.getInt("adType", jSONObject);
        this.f26860h = JsonParserUtil.getInt("adStyle", jSONObject);
        this.f26861i = JsonParserUtil.getInt("materialType", jSONObject);
        this.f26862j = JsonParserUtil.getInt("adSource", jSONObject);
        this.k = JsonParserUtil.getString(OapsKey.KEY_TOKEN, jSONObject);
        this.l = JsonParserUtil.getString("linkUrl", jSONObject);
        this.m = JsonParserUtil.getString("renderHtml", jSONObject);
        this.o = JsonParserUtil.getInt("webviewType", jSONObject);
        this.z = JsonParserUtil.getInt("dspId", jSONObject);
        this.B = JsonParserUtil.getString("sourceAvatar", jSONObject);
        this.f26859g = JsonParserUtil.getInt("renderStyle", jSONObject, 0);
        this.L = JsonParserUtil.getString("dealId", jSONObject);
        this.M = JsonParserUtil.getInt(OapsKey.KEY_PRICE, jSONObject, 0);
        this.N = JsonParserUtil.getInt("bidMode", jSONObject, 0);
        this.O = JsonParserUtil.getString("noticeUrl", jSONObject);
        String string = JsonParserUtil.getString("tag", jSONObject);
        this.A = string;
        if (TextUtils.isEmpty(string)) {
            this.A = "广告";
        }
        this.C = JsonParserUtil.getString("adLogo", jSONObject);
        this.D = JsonParserUtil.getString("adText", jSONObject);
        this.y = JsonParserUtil.getInt("showTime", jSONObject, 3);
        this.E = JsonParserUtil.getLong("expireTime", jSONObject);
        x0.b("ADItemData", "showTime get " + this.y);
        JSONObject object = JsonParserUtil.getObject("deepLink", jSONObject);
        if (object != null) {
            this.p = new r(object);
        }
        JSONObject object2 = JsonParserUtil.getObject("quickLink", jSONObject);
        if (object2 != null) {
            this.q = new v(object2);
        }
        JSONObject object3 = JsonParserUtil.getObject("material", jSONObject);
        if (object3 != null) {
            this.r = new f(object3);
        }
        JSONObject object4 = JsonParserUtil.getObject("app", jSONObject);
        if (object4 != null) {
            this.s = new q(object4, this.f26857e);
        }
        JSONObject object5 = JsonParserUtil.getObject("rpkApp", jSONObject);
        if (object5 != null) {
            this.t = new u(object5);
        }
        this.u = new ArrayList();
        JSONArray jSONArray = JsonParserUtil.getJSONArray("monitorUrls", jSONObject);
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    this.u.add(new h(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        JSONArray jSONArray2 = JsonParserUtil.getJSONArray("feedbackOptions", jSONObject);
        if (jSONArray2 != null) {
            this.v = new ArrayList<>();
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
                if (optJSONObject != null) {
                    this.v.add(new a(optJSONObject));
                }
            }
        }
        JSONObject object6 = JsonParserUtil.getObject("video", jSONObject);
        if (object6 != null) {
            this.n = new a0(object6);
        }
        JSONObject object7 = JsonParserUtil.getObject("config", jSONObject);
        if (object7 != null) {
            e eVar = new e(object7, this.f26857e, this.n != null);
            this.f26853a = eVar;
            eVar.a(this.f26857e);
        }
        System.currentTimeMillis();
        if (this.E <= 0) {
            this.E = 10800L;
        }
        JSONArray jSONArray3 = JsonParserUtil.getJSONArray("showPriority", jSONObject);
        if (jSONArray3 != null && jSONArray3.length() > 0) {
            this.F = new int[jSONArray3.length()];
            for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                this.F[i4] = jSONArray3.optInt(i4);
            }
        }
        JSONObject object8 = JsonParserUtil.getObject("downloadDeepLink", jSONObject);
        if (object8 != null) {
            this.G = new m(object8);
        }
        JSONObject object9 = JsonParserUtil.getObject("activeButtonInfo", jSONObject);
        if (object9 != null) {
            this.H = new d(object9);
        }
        JSONObject object10 = JsonParserUtil.getObject("interactInfo", jSONObject);
        if (object10 != null) {
            this.J = new o(object10);
        }
        JSONObject object11 = JsonParserUtil.getObject("styleData", jSONObject);
        if (object11 != null) {
            this.R = new y(object11);
        }
        JSONObject object12 = JsonParserUtil.getObject("miniProgram", jSONObject);
        if (object12 != null) {
            this.K = new g(object12);
        }
        int i5 = this.f26857e;
        if (i5 == 3) {
            this.f26858f = "2";
            return;
        }
        if (i5 == 4) {
            this.f26858f = "1";
            return;
        }
        if (i5 == 5) {
            this.f26858f = "4";
        } else if (i5 == 9) {
            this.f26858f = BaseWrapper.ENTER_ID_MESSAGE;
        } else if (i5 == 2) {
            this.f26858f = "3";
        }
    }

    public String A() {
        return this.O;
    }

    public int B() {
        if (c() != null) {
            return c().q();
        }
        return 0;
    }

    public String C() {
        return this.f26854b;
    }

    public int D() {
        return this.M;
    }

    public String E() {
        return this.m;
    }

    public int F() {
        return this.f26859g;
    }

    public String G() {
        c cVar = this.x;
        return cVar != null ? cVar.b() : "";
    }

    public u H() {
        return this.t;
    }

    public v I() {
        return this.q;
    }

    public int[] J() {
        return this.F;
    }

    public int K() {
        return this.y;
    }

    public String L() {
        return this.B;
    }

    public y M() {
        return this.R;
    }

    public int N() {
        return this.f26855c;
    }

    public String O() {
        return this.A;
    }

    public String P() {
        return this.k;
    }

    public a0 Q() {
        return this.n;
    }

    public int R() {
        return this.o;
    }

    public String S() {
        return this.Q;
    }

    public boolean T() {
        int i2 = this.f26860h;
        return i2 == 2 || i2 == 5 || i2 == 6 || i2 == 12;
    }

    public boolean U() {
        return this.f26860h == 9;
    }

    public boolean V() {
        r rVar = this.p;
        return rVar != null && rVar.a() == 1;
    }

    public boolean W() {
        int i2 = this.f26860h;
        return i2 == 5 || i2 == 6;
    }

    public boolean X() {
        return this.I;
    }

    public boolean Y() {
        return this.f26861i == 20;
    }

    public boolean Z() {
        return this.f26860h == 8;
    }

    public void a(long j2) {
        this.w = j2;
    }

    public boolean a0() {
        return this.f26860h == 11;
    }

    public void b(int i2) {
        this.f26861i = i2;
    }

    public boolean b0() {
        int i2 = this.f26860h;
        return i2 == 1 || i2 == 10 || i2 == 11;
    }

    public e c() {
        return this.f26853a;
    }

    public String d() {
        return this.f26856d;
    }

    public String e() {
        return this.C;
    }

    public f f() {
        return this.r;
    }

    public g g() {
        return this.K;
    }

    public List<h> h() {
        return this.u;
    }

    public String i() {
        return this.f26858f;
    }

    public int j() {
        return this.f26860h;
    }

    public String k() {
        return this.D;
    }

    public int l() {
        return this.f26857e;
    }

    public int m() {
        return this.N;
    }

    public int n() {
        return this.P;
    }

    public String o() {
        return this.L;
    }

    public m p() {
        return this.G;
    }

    public int q() {
        return this.z;
    }

    public ArrayList<a> r() {
        return this.v;
    }

    public boolean s() {
        return com.vivo.mobilead.manager.b.l().f();
    }

    public o t() {
        return this.J;
    }

    public String toString() {
        return "ADItemData{positionId='" + this.f26854b + "', subCode=" + this.f26855c + ", adId='" + this.f26856d + "', adType=" + this.f26857e + ", adStyle=" + this.f26860h + ", materialType=" + this.f26861i + ", adSource=" + this.f26862j + ", token='" + this.k + "', linkUrl='" + this.l + "', renderHtml='" + this.m + "', mVideo=" + this.n + ", webViewType=" + this.o + ", mNormalDeeplink=" + this.p + ", mNormalAppInfo=" + this.s + ", mLoadTimestamp=" + this.w + ", mADMarkInfo=" + this.x + ", showTime=" + this.y + ", dspId=" + this.z + ", expireTime=" + this.E + ", showPriority=" + this.F + ", price=" + this.M + ", bidMode=" + this.N + ", styleData" + this.R + '}';
    }

    public int u() {
        if (c() != null) {
            return c().m();
        }
        return 0;
    }

    public String v() {
        return this.l;
    }

    public long w() {
        return this.w;
    }

    public int x() {
        return this.f26861i;
    }

    public q y() {
        return this.s;
    }

    public r z() {
        return this.p;
    }

    public c a() {
        return this.x;
    }

    public d b() {
        return this.H;
    }

    public void a(boolean z) {
        this.I = z;
    }

    public void a(int i2) {
        this.P = i2;
    }

    public void a(ArrayList<a> arrayList) {
        this.v = arrayList;
    }

    public void a(String str) {
        this.Q = str;
    }

    public b() {
        this.w = 0L;
        this.x = new c();
        this.y = 3;
        this.I = false;
    }
}
