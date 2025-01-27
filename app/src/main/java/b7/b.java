package b7;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b extends d {
    public static final int A0 = 12311;
    public static final int B0 = 12312;
    public static final int C0 = 12313;
    public static final String D0 = "&";
    public static final String T = "tags";
    public static final String U = "alias";
    public static final String V = null;
    public static final String W = "code";
    public static final String X = "command";
    public static final String Y = "appKey";
    public static final String Z = "appSecret";

    /* renamed from: a0 */
    public static final String f1304a0 = "registerID";

    /* renamed from: b0 */
    public static final String f1305b0 = "sdkVersion";

    /* renamed from: c0 */
    public static final String f1306c0 = "params";

    /* renamed from: d0 */
    public static final int f1307d0 = 12288;

    /* renamed from: e0 */
    public static final int f1308e0 = 12289;

    /* renamed from: f0 */
    public static final int f1309f0 = 12290;

    /* renamed from: g0 */
    public static final int f1310g0 = 12291;

    /* renamed from: h0 */
    public static final int f1311h0 = 12292;

    /* renamed from: i0 */
    public static final int f1312i0 = 12293;

    /* renamed from: j0 */
    public static final int f1313j0 = 12294;

    /* renamed from: k0 */
    public static final int f1314k0 = 12295;

    /* renamed from: l0 */
    public static final int f1315l0 = 12296;

    /* renamed from: m0 */
    public static final int f1316m0 = 12297;

    /* renamed from: n0 */
    public static final int f1317n0 = 12298;

    /* renamed from: o0 */
    public static final int f1318o0 = 12299;

    /* renamed from: p0 */
    public static final int f1319p0 = 12300;

    /* renamed from: q0 */
    public static final int f1320q0 = 12301;

    /* renamed from: r0 */
    public static final int f1321r0 = 12302;

    /* renamed from: s0 */
    public static final int f1322s0 = 12303;

    /* renamed from: t0 */
    public static final int f1323t0 = 12304;

    /* renamed from: u0 */
    public static final int f1324u0 = 12305;

    /* renamed from: v0 */
    public static final int f1325v0 = 12306;

    /* renamed from: w0 */
    public static final int f1326w0 = 12307;

    /* renamed from: x0 */
    public static final int f1327x0 = 12308;

    /* renamed from: y0 */
    public static final int f1328y0 = 12309;

    /* renamed from: z0 */
    public static final int f1329z0 = 12310;
    public String L;
    public String M;
    public String N;
    public String O;
    public int P;
    public String Q;
    public int R = -2;
    public String S;

    public static List<String> p(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("&");
        if (split.length > 0) {
            arrayList = new ArrayList();
            for (String str2 : split) {
                if (!TextUtils.isEmpty(str2)) {
                    arrayList.add(str2);
                }
            }
        }
        return arrayList;
    }

    public static <T> String q(List<T> list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            sb2.append("&");
        }
        return sb2.toString();
    }

    public static List<i> r(String str, String str2, String str3, String str4) {
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray(str2);
            arrayList = new ArrayList();
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    i iVar = new i();
                    iVar.c(jSONObject.getString(str4));
                    iVar.d(jSONObject.getString(str3));
                    arrayList.add(iVar);
                } catch (JSONException e10) {
                    e = e10;
                    arrayList2 = arrayList;
                    e.printStackTrace();
                    arrayList = arrayList2;
                    c7.e.a("parseToSubscribeResultList--" + arrayList);
                    return arrayList;
                }
            }
        } catch (JSONException e11) {
            e = e11;
        }
        c7.e.a("parseToSubscribeResultList--" + arrayList);
        return arrayList;
    }

    @Override // b7.d
    public int getType() {
        return 4105;
    }

    public String h() {
        return this.L;
    }

    public String i() {
        return this.M;
    }

    public int j() {
        return this.P;
    }

    public String k() {
        return this.Q;
    }

    public String l() {
        return this.S;
    }

    public String m() {
        return this.N;
    }

    public int n() {
        return this.R;
    }

    public String o() {
        return this.O;
    }

    public void s(String str) {
        this.L = str;
    }

    public void t(String str) {
        this.M = str;
    }

    public String toString() {
        return "CommandMessage{, mRegisterID='" + this.N + "', mSdkVersion='" + this.O + "', mCommand=" + this.P + ", mContent='" + this.Q + "', mResponseCode=" + this.R + '}';
    }

    public void u(int i10) {
        this.P = i10;
    }

    public void v(String str) {
        this.Q = str;
    }

    public void w(String str) {
        this.S = str;
    }

    public void x(String str) {
        this.N = str;
    }

    public void y(int i10) {
        this.R = i10;
    }

    public void z(String str) {
        this.O = str;
    }
}
