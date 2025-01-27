package com.heytap.mcssdk.n;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends d {
    public static final String L = "tags";
    public static final String M = "alias";
    public static final String N = null;
    public static final String O = "code";
    public static final String P = "command";
    public static final String Q = "appKey";
    public static final String R = "appSecret";
    public static final String S = "registerID";
    public static final String T = "sdkVersion";
    public static final String U = "params";
    public static final int V = 12288;
    public static final int W = 12289;
    public static final int X = 12290;
    public static final int Y = 12291;
    public static final int Z = 12292;
    public static final int a0 = 12293;
    public static final int b0 = 12294;
    public static final int c0 = 12295;
    public static final int d0 = 12296;
    public static final int e0 = 12297;
    public static final int f0 = 12298;
    public static final int g0 = 12299;
    public static final int h0 = 12300;
    public static final int i0 = 12301;
    public static final int j0 = 12302;
    public static final int k0 = 12303;
    public static final int l0 = 12304;
    public static final int m0 = 12305;
    public static final int n0 = 12306;
    public static final int o0 = 12307;
    public static final int p0 = 12308;
    public static final int q0 = 12309;
    public static final int r0 = 12310;
    public static final int s0 = 12311;
    public static final int t0 = 12312;
    public static final int u0 = 12313;
    private static final String v0 = "&";
    private int A0;
    private String B0;
    private int C0 = -2;
    private String D0;
    private String w0;
    private String x0;
    private String y0;
    private String z0;

    public static List<String> p(String str) {
        ArrayList arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(v0);
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
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(v0);
        }
        return sb.toString();
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
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    i iVar = new i();
                    iVar.c(jSONObject.getString(str4));
                    iVar.d(jSONObject.getString(str3));
                    arrayList.add(iVar);
                } catch (JSONException e2) {
                    e = e2;
                    arrayList2 = arrayList;
                    e.printStackTrace();
                    arrayList = arrayList2;
                    com.heytap.mcssdk.o.e.a("parseToSubscribeResultList--" + arrayList);
                    return arrayList;
                }
            }
        } catch (JSONException e3) {
            e = e3;
        }
        com.heytap.mcssdk.o.e.a("parseToSubscribeResultList--" + arrayList);
        return arrayList;
    }

    @Override // com.heytap.mcssdk.n.d
    public int getType() {
        return 4105;
    }

    public String h() {
        return this.w0;
    }

    public String i() {
        return this.x0;
    }

    public int j() {
        return this.A0;
    }

    public String k() {
        return this.B0;
    }

    public String l() {
        return this.D0;
    }

    public String m() {
        return this.y0;
    }

    public int n() {
        return this.C0;
    }

    public String o() {
        return this.z0;
    }

    public void s(String str) {
        this.w0 = str;
    }

    public void t(String str) {
        this.x0 = str;
    }

    public String toString() {
        return "CommandMessage{, mRegisterID='" + this.y0 + "', mSdkVersion='" + this.z0 + "', mCommand=" + this.A0 + ", mContent='" + this.B0 + "', mResponseCode=" + this.C0 + '}';
    }

    public void u(int i2) {
        this.A0 = i2;
    }

    public void v(String str) {
        this.B0 = str;
    }

    public void w(String str) {
        this.D0 = str;
    }

    public void x(String str) {
        this.y0 = str;
    }

    public void y(int i2) {
        this.C0 = i2;
    }

    public void z(String str) {
        this.z0 = str;
    }
}
