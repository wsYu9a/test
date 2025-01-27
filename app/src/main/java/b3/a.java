package b3;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p3.d;
import p3.g;
import p3.k;

/* loaded from: classes.dex */
public final class a {
    public static final String A = "DynCon";
    public static final int B = 10000;
    public static final String C = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final int D = 10;
    public static final boolean E = true;
    public static final boolean F = false;
    public static final boolean G = true;
    public static final boolean H = true;
    public static final boolean I = false;
    public static final boolean J = false;
    public static final boolean K = false;
    public static final boolean L = false;
    public static final boolean M = true;
    public static final String N = "";
    public static final boolean O = false;
    public static final boolean P = false;
    public static final int Q = 1000;
    public static final boolean R = true;
    public static final String S = "";
    public static final boolean T = false;
    public static final boolean U = false;
    public static final int V = 1000;
    public static final int W = 20000;
    public static final boolean X = false;
    public static final String Y = "alipay_cashier_dynamic_config";
    public static final String Z = "timeout";

    /* renamed from: a0 */
    public static final String f1108a0 = "h5_port_degrade";

    /* renamed from: b0 */
    public static final String f1109b0 = "st_sdk_config";

    /* renamed from: c0 */
    public static final String f1110c0 = "tbreturl";

    /* renamed from: d0 */
    public static final String f1111d0 = "launchAppSwitch";

    /* renamed from: e0 */
    public static final String f1112e0 = "configQueryInterval";

    /* renamed from: f0 */
    public static final String f1113f0 = "deg_log_mcgw";

    /* renamed from: g0 */
    public static final String f1114g0 = "deg_start_srv_first";

    /* renamed from: h0 */
    public static final String f1115h0 = "prev_jump_dual";

    /* renamed from: i0 */
    public static final String f1116i0 = "bind_use_imp";

    /* renamed from: j0 */
    public static final String f1117j0 = "retry_bnd_once";

    /* renamed from: k0 */
    public static final String f1118k0 = "skip_trans";

    /* renamed from: l0 */
    public static final String f1119l0 = "start_trans";

    /* renamed from: m0 */
    public static final String f1120m0 = "up_before_pay";

    /* renamed from: n0 */
    public static final String f1121n0 = "lck_k";

    /* renamed from: o0 */
    public static final String f1122o0 = "use_sc_lck_a";

    /* renamed from: p0 */
    public static final String f1123p0 = "utdid_factor";

    /* renamed from: q0 */
    public static final String f1124q0 = "cfg_max_time";

    /* renamed from: r0 */
    public static final String f1125r0 = "get_oa_id";

    /* renamed from: s0 */
    public static final String f1126s0 = "notifyFailApp";

    /* renamed from: t0 */
    public static final String f1127t0 = "startactivity_in_ui_thread";

    /* renamed from: u0 */
    public static final String f1128u0 = "intercept_batch";

    /* renamed from: v0 */
    public static final String f1129v0 = "bind_with_startActivity";

    /* renamed from: w0 */
    public static final String f1130w0 = "enableStartActivityFallback";

    /* renamed from: x0 */
    public static final String f1131x0 = "enableBindExFallback";

    /* renamed from: y0 */
    public static a f1132y0;

    /* renamed from: w */
    public JSONObject f1155w;

    /* renamed from: a */
    public int f1133a = 10000;

    /* renamed from: b */
    public boolean f1134b = false;

    /* renamed from: c */
    public String f1135c = C;

    /* renamed from: d */
    public int f1136d = 10;

    /* renamed from: e */
    public boolean f1137e = true;

    /* renamed from: f */
    public boolean f1138f = false;

    /* renamed from: g */
    public boolean f1139g = false;

    /* renamed from: h */
    public boolean f1140h = false;

    /* renamed from: i */
    public boolean f1141i = true;

    /* renamed from: j */
    public boolean f1142j = true;

    /* renamed from: k */
    public boolean f1143k = false;

    /* renamed from: l */
    public boolean f1144l = false;

    /* renamed from: m */
    public boolean f1145m = false;

    /* renamed from: n */
    public boolean f1146n = false;

    /* renamed from: o */
    public boolean f1147o = true;

    /* renamed from: p */
    public String f1148p = "";

    /* renamed from: q */
    public String f1149q = "";

    /* renamed from: r */
    public boolean f1150r = false;

    /* renamed from: s */
    public boolean f1151s = false;

    /* renamed from: t */
    public boolean f1152t = false;

    /* renamed from: u */
    public int f1153u = 1000;

    /* renamed from: v */
    public boolean f1154v = false;

    /* renamed from: x */
    public boolean f1156x = true;

    /* renamed from: y */
    public List<b> f1157y = null;

    /* renamed from: z */
    public int f1158z = -1;

    /* renamed from: b3.a$a */
    public class RunnableC0013a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ n3.a f1159b;

        /* renamed from: c */
        public final /* synthetic */ Context f1160c;

        /* renamed from: d */
        public final /* synthetic */ boolean f1161d;

        /* renamed from: e */
        public final /* synthetic */ int f1162e;

        public RunnableC0013a(n3.a aVar, Context context, boolean z10, int i10) {
            this.f1159b = aVar;
            this.f1160c = context;
            this.f1161d = z10;
            this.f1162e = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h3.b a10 = new j3.b().a(this.f1159b, this.f1160c);
                if (a10 != null) {
                    a.this.h(this.f1159b, a10.a());
                    a.this.f(n3.a.w());
                    x2.a.c(this.f1159b, x2.b.f31789l, "offcfg|" + this.f1161d + "|" + this.f1162e);
                }
            } catch (Throwable th2) {
                d.e(th2);
            }
        }
    }

    public static final class b {

        /* renamed from: a */
        public final String f1164a;

        /* renamed from: b */
        public final int f1165b;

        /* renamed from: c */
        public final String f1166c;

        public b(String str, int i10, String str2) {
            this.f1164a = str;
            this.f1165b = i10;
            this.f1166c = str2;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString(f.S));
        }

        public static List<b> b(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                b a10 = a(jSONArray.optJSONObject(i10));
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
            return arrayList;
        }

        public static JSONArray c(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(d(it.next()));
            }
            return jSONArray;
        }

        public static JSONObject d(b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", bVar.f1164a).put("v", bVar.f1165b).put(f.S, bVar.f1166c);
            } catch (JSONException e10) {
                d.e(e10);
                return null;
            }
        }

        public String toString() {
            return String.valueOf(d(this));
        }
    }

    public static a J() {
        if (f1132y0 == null) {
            a aVar = new a();
            f1132y0 = aVar;
            aVar.A();
        }
        return f1132y0;
    }

    public void A() {
        Context c10 = n3.b.e().c();
        String b10 = g.b(n3.a.w(), c10, Y, null);
        try {
            this.f1158z = Integer.parseInt(g.b(n3.a.w(), c10, f1123p0, "-1"));
        } catch (Exception unused) {
        }
        e(b10);
    }

    public boolean B() {
        return this.f1151s;
    }

    public boolean C() {
        return this.f1154v;
    }

    public boolean D() {
        return this.f1150r;
    }

    public boolean E() {
        return this.f1156x;
    }

    public boolean F() {
        return this.f1134b;
    }

    public boolean G() {
        return this.f1138f;
    }

    public boolean H() {
        return this.f1146n;
    }

    public final int I() {
        return this.f1153u;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeout", s());
        jSONObject.put(f1108a0, F());
        jSONObject.put(f1110c0, y());
        jSONObject.put(f1112e0, n());
        jSONObject.put(f1111d0, b.c(t()));
        jSONObject.put(f1128u0, q());
        jSONObject.put(f1113f0, o());
        jSONObject.put(f1114g0, p());
        jSONObject.put(f1115h0, u());
        jSONObject.put(f1116i0, l());
        jSONObject.put(f1117j0, v());
        jSONObject.put(f1118k0, x());
        jSONObject.put(f1119l0, H());
        jSONObject.put(f1120m0, z());
        jSONObject.put(f1122o0, w());
        jSONObject.put(f1121n0, r());
        jSONObject.put(f1129v0, m());
        jSONObject.put(f1124q0, I());
        jSONObject.put(f1125r0, E());
        jSONObject.put(f1126s0, C());
        jSONObject.put(f1130w0, D());
        jSONObject.put(f1131x0, B());
        jSONObject.put(f1127t0, G());
        jSONObject.put(p3.a.f29720b, b());
        return jSONObject;
    }

    public JSONObject b() {
        return this.f1155w;
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            i(new JSONObject(str));
        } catch (Throwable th2) {
            d.e(th2);
        }
    }

    public final void f(n3.a aVar) {
        try {
            JSONObject a10 = a();
            g.e(aVar, n3.b.e().c(), Y, a10.toString());
        } catch (Exception e10) {
            d.e(e10);
        }
    }

    public void g(n3.a aVar, Context context, boolean z10, int i10) {
        x2.a.c(aVar, x2.b.f31789l, "oncfg|" + z10 + "|" + i10);
        RunnableC0013a runnableC0013a = new RunnableC0013a(aVar, context, z10, i10);
        if (!z10 || k.d0()) {
            Thread thread = new Thread(runnableC0013a);
            thread.setName("AlipayDCP");
            thread.start();
            return;
        }
        int I2 = I();
        if (k.v(I2, runnableC0013a, "AlipayDCPBlok")) {
            return;
        }
        x2.a.i(aVar, x2.b.f31789l, x2.b.f31792m0, "" + I2);
    }

    public final void h(n3.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject(f1109b0);
            p3.a.e(aVar, optJSONObject, p3.a.b(aVar, jSONObject));
            if (optJSONObject != null) {
                i(optJSONObject);
            } else {
                d.j(A, "empty config");
            }
        } catch (Throwable th2) {
            d.e(th2);
        }
    }

    public final void i(JSONObject jSONObject) {
        this.f1133a = jSONObject.optInt("timeout", 10000);
        this.f1134b = jSONObject.optBoolean(f1108a0, false);
        this.f1135c = jSONObject.optString(f1110c0, C).trim();
        this.f1136d = jSONObject.optInt(f1112e0, 10);
        this.f1157y = b.b(jSONObject.optJSONArray(f1111d0));
        this.f1137e = jSONObject.optBoolean(f1128u0, true);
        this.f1140h = jSONObject.optBoolean(f1113f0, false);
        this.f1141i = jSONObject.optBoolean(f1114g0, true);
        this.f1142j = jSONObject.optBoolean(f1115h0, true);
        this.f1143k = jSONObject.optBoolean(f1116i0, false);
        this.f1144l = jSONObject.optBoolean(f1117j0, false);
        this.f1145m = jSONObject.optBoolean(f1118k0, false);
        this.f1146n = jSONObject.optBoolean(f1119l0, false);
        this.f1147o = jSONObject.optBoolean(f1120m0, true);
        this.f1148p = jSONObject.optString(f1121n0, "");
        this.f1152t = jSONObject.optBoolean(f1122o0, false);
        this.f1154v = jSONObject.optBoolean(f1126s0, false);
        this.f1149q = jSONObject.optString(f1129v0, "");
        this.f1153u = jSONObject.optInt(f1124q0, 1000);
        this.f1156x = jSONObject.optBoolean(f1125r0, true);
        this.f1150r = jSONObject.optBoolean(f1130w0, false);
        this.f1151s = jSONObject.optBoolean(f1131x0, false);
        this.f1138f = jSONObject.optBoolean(f1127t0, false);
        this.f1155w = jSONObject.optJSONObject(p3.a.f29720b);
    }

    public void j(boolean z10) {
        this.f1139g = z10;
    }

    public boolean k(Context context, int i10) {
        if (this.f1158z == -1) {
            this.f1158z = k.a();
            g.e(n3.a.w(), context, f1123p0, String.valueOf(this.f1158z));
        }
        return this.f1158z < i10;
    }

    public boolean l() {
        return this.f1143k;
    }

    public String m() {
        return this.f1149q;
    }

    public int n() {
        return this.f1136d;
    }

    public boolean o() {
        return this.f1140h;
    }

    public boolean p() {
        return this.f1141i;
    }

    public boolean q() {
        return this.f1137e;
    }

    public String r() {
        return this.f1148p;
    }

    public int s() {
        int i10 = this.f1133a;
        if (i10 < 1000 || i10 > 20000) {
            d.g(A, "time(def) = 10000");
            return 10000;
        }
        d.g(A, "time = " + this.f1133a);
        return this.f1133a;
    }

    public List<b> t() {
        return this.f1157y;
    }

    public boolean u() {
        return this.f1142j;
    }

    public boolean v() {
        return this.f1144l;
    }

    public boolean w() {
        return this.f1152t;
    }

    public boolean x() {
        return this.f1145m;
    }

    public String y() {
        return this.f1135c;
    }

    public boolean z() {
        return this.f1147o;
    }
}
