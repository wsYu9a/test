package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a */
    public static final String f6635a = "none";

    /* renamed from: b */
    public static final String f6636b = "text";

    /* renamed from: c */
    public static final String f6637c = "static_image";

    /* renamed from: d */
    public static final String f6638d = "gif";

    /* renamed from: e */
    public static final String f6639e = "rich_media";

    /* renamed from: f */
    public static final String f6640f = "html";

    /* renamed from: g */
    public static final String f6641g = "hybrid";

    /* renamed from: h */
    public static final String f6642h = "video";

    /* renamed from: i */
    private static final long f6643i = 1750000;
    private String A;
    private String B;
    private String C;
    private String D;
    private int E;
    private String F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private String M;
    private List<String> O;
    private JSONObject P;
    private long Q;
    private long R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private JSONObject Z;

    /* renamed from: aa */
    private int f6644aa;

    /* renamed from: ab */
    private int f6645ab;

    /* renamed from: ac */
    private int f6646ac;

    /* renamed from: ad */
    private List<String> f6647ad;

    /* renamed from: af */
    private String f6649af;

    /* renamed from: ag */
    private String f6650ag;

    /* renamed from: ah */
    private JSONObject f6651ah;

    /* renamed from: ai */
    private JSONObject f6652ai;

    /* renamed from: j */
    private String f6653j;

    /* renamed from: k */
    private String f6654k;

    /* renamed from: l */
    private String f6655l;

    /* renamed from: m */
    private String f6656m;

    /* renamed from: n */
    private int f6657n;

    /* renamed from: o */
    private int f6658o;

    /* renamed from: p */
    private String f6659p;

    /* renamed from: q */
    private long f6660q;

    /* renamed from: r */
    private int f6661r;

    /* renamed from: t */
    private String f6663t;

    /* renamed from: u */
    private String f6664u;

    /* renamed from: v */
    private String f6665v;

    /* renamed from: w */
    private String f6666w;

    /* renamed from: x */
    private String f6667x;

    /* renamed from: y */
    private String f6668y;

    /* renamed from: z */
    private String f6669z;

    /* renamed from: s */
    private int f6662s = 1;
    private String N = "none";

    /* renamed from: ae */
    private int f6648ae = 0;

    public static boolean a(int i10) {
        return (i10 < 28 || 31 == i10 || 32 == i10 || 38 == i10 || 39 == i10 || 40 == i10 || 42 < i10) ? false : true;
    }

    public String A() {
        return this.f6665v;
    }

    public String B() {
        return this.A;
    }

    public String C() {
        return this.f6669z;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    public String F() {
        return this.D;
    }

    public long G() {
        return this.R;
    }

    public List<String> H() {
        return this.O;
    }

    public String I() {
        return this.S;
    }

    public JSONObject J() {
        return this.P;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        return this.W;
    }

    public String M() {
        return this.X;
    }

    public String N() {
        String str = this.Y;
        return (str == null || str.length() <= 4) ? this.Y : "";
    }

    public int O() {
        return this.f6646ac;
    }

    public List<String> P() {
        return this.f6647ad;
    }

    public JSONObject Q() {
        return this.Z;
    }

    public int R() {
        return this.f6644aa;
    }

    public int S() {
        return this.f6645ab;
    }

    public int T() {
        return this.f6648ae;
    }

    public JSONObject U() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.S);
            jSONObject.put("tit", this.f6653j);
            jSONObject.put(SocialConstants.PARAM_APP_DESC, this.f6654k);
            jSONObject.put(com.umeng.analytics.pro.f.S, this.f6666w);
            jSONObject.put("appname", this.f6659p);
            jSONObject.put(SocialConstants.PARAM_ACT, this.E);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String V() {
        return this.f6649af;
    }

    public String W() {
        if (TextUtils.isEmpty(this.f6650ag)) {
            return "";
        }
        try {
            long parseLong = Long.parseLong(this.f6650ag);
            int length = this.f6650ag.length();
            return (parseLong <= 100000 || length <= 5) ? "" : this.f6650ag.substring(length - 4, length);
        } catch (Throwable th2) {
            ay.b(th2);
            return "";
        }
    }

    public String b() {
        return this.f6654k;
    }

    public String c() {
        return this.f6655l;
    }

    public String d() {
        return this.f6656m;
    }

    public int e() {
        return this.f6657n;
    }

    public int f() {
        return this.f6658o;
    }

    public String g() {
        return this.f6659p;
    }

    public String h() {
        return this.T;
    }

    public String i() {
        return this.U;
    }

    public long j() {
        return this.f6660q;
    }

    public int k() {
        return this.f6661r;
    }

    public int l() {
        return this.f6662s;
    }

    public String m() {
        return this.f6666w;
    }

    public String n() {
        return this.f6667x;
    }

    public String o() {
        return this.f6668y;
    }

    public int p() {
        return this.E;
    }

    public String q() {
        return this.F;
    }

    public int r() {
        return this.G;
    }

    public int s() {
        return this.H;
    }

    public int t() {
        return this.I;
    }

    public int u() {
        return this.J;
    }

    public int v() {
        return this.K;
    }

    public int w() {
        return this.L;
    }

    public String x() {
        return this.N;
    }

    public long y() {
        return this.Q;
    }

    public String z() {
        return !TextUtils.isEmpty(this.f6664u) ? this.f6664u : this.f6663t;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x014f A[Catch: all -> 0x00b9, JSONException -> 0x00bc, TryCatch #4 {JSONException -> 0x00bc, all -> 0x00b9, blocks: (B:5:0x007e, B:8:0x0090, B:10:0x00a1, B:11:0x00bf, B:13:0x00cb, B:15:0x00d6, B:17:0x00dc, B:18:0x00de, B:20:0x00e4, B:22:0x00ea, B:24:0x00f2, B:28:0x00fb, B:30:0x0105, B:32:0x0122, B:36:0x0128, B:37:0x012e, B:39:0x0136, B:41:0x013c, B:43:0x0146, B:45:0x014f, B:47:0x015d, B:49:0x0164, B:50:0x016c, B:52:0x0172), top: B:4:0x007e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r17) {
        /*
            Method dump skipped, instructions count: 852
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public String a(String str) {
        if (this.f6651ah == null) {
            return null;
        }
        JSONObject jSONObject = this.f6652ai;
        JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("apo") : null;
        String optString = this.f6651ah.optString(str);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        if (TextUtils.equals(optString, "fallback") && optJSONObject != null) {
            return optJSONObject.optString("fallback");
        }
        if (TextUtils.equals(optString, "page") && optJSONObject != null) {
            return optJSONObject.optString("page");
        }
        JSONObject jSONObject2 = this.f6652ai;
        if (jSONObject2 != null) {
            return jSONObject2.optString(optString);
        }
        return null;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i10)));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i10, int i11) {
        String[] split;
        int i12 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split(hf.e.f26694a)) != null && split.length > 0) {
                        i12 = Integer.parseInt(split[0]);
                    }
                }
            } catch (Throwable th2) {
                bt.a().d(th2.getMessage());
            }
        }
        if (a(i12)) {
            i10 = i12;
        } else if (!a(i10)) {
            i10 = i11;
        }
        if (i10 == 42) {
            return 41;
        }
        return i10;
    }

    public String a() {
        return this.f6653j;
    }
}
