package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public static final String f5472a = "none";

    /* renamed from: b */
    public static final String f5473b = "text";

    /* renamed from: c */
    public static final String f5474c = "static_image";

    /* renamed from: d */
    public static final String f5475d = "gif";

    /* renamed from: e */
    public static final String f5476e = "rich_media";

    /* renamed from: f */
    public static final String f5477f = "html";

    /* renamed from: g */
    public static final String f5478g = "hybrid";

    /* renamed from: h */
    public static final String f5479h = "video";

    /* renamed from: i */
    private static final long f5480i = 1750000;
    private String A;
    private String B;
    private int C;
    private String D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private String K;
    private List<String> M;
    private JSONObject N;
    private long O;
    private long P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private JSONObject X;
    private int Y;
    private int Z;
    private int aa;
    private List<String> ab;

    /* renamed from: j */
    private String f5481j;
    private String k;
    private String l;
    private String m;
    private int n;
    private int o;
    private String p;
    private long q;
    private int r;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private int s = 1;
    private String L = f5472a;
    private int ac = 0;

    /* JADX WARN: Removed duplicated region for block: B:45:0x0146 A[Catch: all -> 0x0175, JSONException -> 0x017a, TryCatch #3 {JSONException -> 0x017a, all -> 0x0175, blocks: (B:5:0x007c, B:8:0x008e, B:10:0x009f, B:11:0x00b6, B:13:0x00c2, B:15:0x00cd, B:17:0x00d3, B:18:0x00d5, B:20:0x00db, B:22:0x00e1, B:24:0x00e9, B:28:0x00f2, B:30:0x00fc, B:32:0x0119, B:36:0x011f, B:37:0x0125, B:39:0x012d, B:41:0x0133, B:43:0x013d, B:45:0x0146, B:47:0x0154, B:49:0x015b, B:50:0x0163, B:52:0x0169), top: B:4:0x007c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.mobads.sdk.internal.a a(org.json.JSONObject r17) {
        /*
            Method dump skipped, instructions count: 789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.a.a(org.json.JSONObject):com.baidu.mobads.sdk.internal.a");
    }

    public static boolean a(int i2) {
        return (i2 < 28 || 31 == i2 || 32 == i2 || 38 == i2 || 39 == i2 || 40 == i2 || 42 < i2) ? false : true;
    }

    public String A() {
        return this.z;
    }

    public String B() {
        return this.y;
    }

    public String C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public long E() {
        return this.P;
    }

    public List<String> F() {
        return this.M;
    }

    public String G() {
        return this.Q;
    }

    public JSONObject H() {
        return this.N;
    }

    public String I() {
        return this.T;
    }

    public String J() {
        return this.U;
    }

    public String K() {
        return this.V;
    }

    public String L() {
        String str = this.W;
        return (str == null || str.length() <= 4) ? this.W : "";
    }

    public int M() {
        return this.aa;
    }

    public List<String> N() {
        return this.ab;
    }

    public JSONObject O() {
        return this.X;
    }

    public int P() {
        return this.Y;
    }

    public int Q() {
        return this.Z;
    }

    public int R() {
        return this.ac;
    }

    public JSONObject S() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", this.Q);
            jSONObject.put("tit", this.f5481j);
            jSONObject.put(SocialConstants.PARAM_APP_DESC, this.k);
            jSONObject.put(OapsKey.KEY_PAGEKEY, this.v);
            jSONObject.put("appname", this.p);
            jSONObject.put(SocialConstants.PARAM_ACT, this.C);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b() {
        return this.k;
    }

    public String c() {
        return this.l;
    }

    public String d() {
        return this.m;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.o;
    }

    public String g() {
        return this.p;
    }

    public String h() {
        return this.R;
    }

    public String i() {
        return this.S;
    }

    public long j() {
        return this.q;
    }

    public int k() {
        return this.r;
    }

    public int l() {
        return this.s;
    }

    public String m() {
        return this.v;
    }

    public String n() {
        return this.w;
    }

    public String o() {
        return this.x;
    }

    public int p() {
        return this.C;
    }

    public String q() {
        return this.D;
    }

    public int r() {
        return this.E;
    }

    public int s() {
        return this.F;
    }

    public int t() {
        return this.G;
    }

    public int u() {
        return this.H;
    }

    public int v() {
        return this.I;
    }

    public int w() {
        return this.J;
    }

    public String x() {
        return this.L;
    }

    public long y() {
        return this.O;
    }

    public String z() {
        return !TextUtils.isEmpty(this.u) ? this.u : this.t;
    }

    public static List<a> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    arrayList.add(a(jSONArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    private static int a(JSONObject jSONObject, int i2, int i3) {
        String[] split;
        int i4 = 0;
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("st_op");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("tp_id");
                    if (!TextUtils.isEmpty(optString) && optString.startsWith("opt_style_") && (split = optString.substring(10).split("_")) != null && split.length > 0) {
                        i4 = Integer.parseInt(split[0]);
                    }
                }
            } catch (Throwable th) {
                bq.a().d(th.getMessage());
            }
        }
        if (a(i4)) {
            i2 = i4;
        } else if (!a(i2)) {
            i2 = i3;
        }
        if (i2 == 42) {
            return 41;
        }
        return i2;
    }

    public String a() {
        return this.f5481j;
    }
}
