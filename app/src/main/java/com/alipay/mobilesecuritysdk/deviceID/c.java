package com.alipay.mobilesecuritysdk.deviceID;

import android.content.Context;
import android.os.Environment;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    public static final String A = "rule";
    public static final String B = "checkcode";

    /* renamed from: a */
    public static final String f5227a = "profiles";

    /* renamed from: b */
    public static final String f5228b = "deviceid";

    /* renamed from: c */
    public static final String f5229c = "deviceFingerprint";

    /* renamed from: d */
    public static final String f5230d = "1";

    /* renamed from: e */
    public static final String f5231e = "AH1";

    /* renamed from: f */
    public static final String f5232f = "AH2";

    /* renamed from: g */
    public static final String f5233g = "AH3";

    /* renamed from: h */
    public static final String f5234h = "AH4";

    /* renamed from: i */
    public static final String f5235i = "AH5";

    /* renamed from: j */
    public static final String f5236j = "AH6";
    public static final String k = "AH7";
    public static final String l = "AH8";
    public static final String m = "AH9";
    public static final String n = "AH10";
    public static final String o = "AS1";
    public static final String p = "AS2";
    public static final String q = "AS3";
    public static final String r = "AS4";
    public static final String s = "AC1";
    public static final String t = "AC2";
    public static final String u = "appId";
    public static final String v = "deviceInfo";
    public static final String w = "deviceId";
    public static final String x = "priDeviceId";
    public static final String y = "time";
    public static final String z = "apdtk";
    private d C = new d();
    private g D = new g();

    private void g(String str) {
        ArrayList arrayList = new ArrayList();
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.u())) {
            arrayList.add(this.C.u().substring(0, 20));
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.w())) {
            arrayList.add(this.C.w().substring(0, 20));
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.l())) {
            arrayList.add(this.C.l().substring(0, 20));
        }
        arrayList.add(str);
        f.g(arrayList);
    }

    private String q() {
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.t())) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(this.C.t()).getJSONArray("params");
            if (jSONArray == null) {
                return null;
            }
            String str = new String();
            for (int i2 = 0; i2 != jSONArray.length(); i2++) {
                if (jSONArray.getString(i2).equals(s)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.u()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.u();
                }
                if (jSONArray.getString(i2).equals(t)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.w()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.w();
                }
                if (jSONArray.getString(i2).equals(f5231e)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.a()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.a();
                }
                if (jSONArray.getString(i2).equals(f5232f)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.c()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.c();
                }
                if (jSONArray.getString(i2).equals(f5233g)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.d()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.d();
                }
                if (jSONArray.getString(i2).equals(f5234h)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.e()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.e();
                }
                if (jSONArray.getString(i2).equals(f5235i)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.f()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.f();
                }
                if (jSONArray.getString(i2).equals(f5236j)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.g()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.g();
                }
                if (jSONArray.getString(i2).equals(k)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.h()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.h();
                }
                if (jSONArray.getString(i2).equals(l)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.i()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.i();
                }
                if (jSONArray.getString(i2).equals(m)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.j()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.j();
                }
                if (jSONArray.getString(i2).equals(n)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.b()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.b();
                }
                if (jSONArray.getString(i2).equals(o)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.m()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.m();
                }
                if (jSONArray.getString(i2).equals(p)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.n()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.n();
                }
                if (jSONArray.getString(i2).equals(q)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.o()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.o();
                }
                if (jSONArray.getString(i2).equals(r)) {
                    str = com.alipay.mobilesecuritysdk.c.a.i(this.C.p()) ? new StringBuilder(String.valueOf(str)).toString() : String.valueOf(str) + this.C.p();
                }
            }
            return str;
        } catch (JSONException e2) {
            g(f.e(e2));
            return null;
        }
    }

    private boolean r() {
        return !com.alipay.mobilesecuritysdk.c.a.i(u()) && u().length() > 0;
    }

    private boolean s() {
        return !com.alipay.mobilesecuritysdk.c.a.i(v()) && v().length() > 0;
    }

    public boolean a(Map<String, String> map) {
        return map != null && map.size() >= 0 && map.containsKey(w) && map.containsKey(B) && map.containsKey(z) && map.containsKey(y) && map.containsKey("rule");
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(w, this.C.r());
        hashMap.put(x, this.C.s());
        hashMap.put("appId", this.C.l());
        hashMap.put(y, this.C.v());
        hashMap.put(z, this.C.k());
        return hashMap;
    }

    public Map<String, String> c(Context context) {
        String a2 = this.D.a(context.getSharedPreferences(f5227a, 0), f5228b);
        if (com.alipay.mobilesecuritysdk.c.a.i(a2)) {
            return null;
        }
        String b2 = h.b(h.h(), a2);
        if (com.alipay.mobilesecuritysdk.c.a.i(b2)) {
            return null;
        }
        return new g().g(b2);
    }

    public Map<String, String> d(Context context) {
        return null;
    }

    public Map<String, Object> e() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.a())) {
            hashMap2.put(f5231e, "");
        } else {
            hashMap2.put(f5231e, this.C.a());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.c())) {
            hashMap2.put(f5232f, "");
        } else {
            hashMap2.put(f5232f, this.C.c());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.d())) {
            hashMap2.put(f5233g, "");
        } else {
            hashMap2.put(f5233g, this.C.d());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.e())) {
            hashMap2.put(f5234h, "");
        } else {
            hashMap2.put(f5234h, this.C.e());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.f())) {
            hashMap2.put(f5234h, "");
        } else {
            hashMap2.put(f5235i, this.C.f());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.g())) {
            hashMap2.put(f5236j, "");
        } else {
            hashMap2.put(f5236j, this.C.g());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.h())) {
            hashMap2.put(k, "");
        } else {
            hashMap2.put(k, this.C.h());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.i())) {
            hashMap2.put(l, "");
        } else {
            hashMap2.put(l, this.C.i());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.j())) {
            hashMap2.put(m, "");
        } else {
            hashMap2.put(m, this.C.j());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.b())) {
            hashMap2.put(n, "");
        } else {
            hashMap2.put(n, this.C.b());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.m())) {
            hashMap2.put(o, "");
        } else {
            hashMap2.put(o, this.C.m());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.n())) {
            hashMap2.put(p, "");
        } else {
            hashMap2.put(p, this.C.n());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.o())) {
            hashMap2.put(q, "");
        } else {
            hashMap2.put(q, this.C.o());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.p())) {
            hashMap2.put(r, "");
        } else {
            hashMap2.put(r, this.C.p());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.u())) {
            hashMap2.put(s, "");
        } else {
            hashMap2.put(s, this.C.u());
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(this.C.w())) {
            hashMap2.put(t, "");
        } else {
            hashMap2.put(t, this.C.w());
        }
        hashMap.put(v, hashMap2);
        if (!com.alipay.mobilesecuritysdk.c.a.i(this.C.r())) {
            hashMap.put(w, this.C.r());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(this.C.s())) {
            hashMap.put(x, this.C.s());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(this.C.l())) {
            hashMap.put("appId", this.C.l());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(this.C.v())) {
            hashMap.put(y, this.C.v());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(this.C.k())) {
            hashMap.put(z, this.C.k());
        }
        return hashMap;
    }

    public void f(Context context, Map<String, String> map) {
        a h2 = a.h();
        f.f(context);
        if (map != null) {
            try {
                if (map.size() > 0) {
                    if (!com.alipay.mobilesecuritysdk.c.a.i(map.get(b.b.a.b.b.f4200c))) {
                        this.C.R(map.get(b.b.a.b.b.f4200c));
                    }
                    if (!com.alipay.mobilesecuritysdk.c.a.i(map.get(b.b.a.b.b.f4204g))) {
                        this.C.T(map.get(b.b.a.b.b.f4204g));
                    }
                }
            } catch (Exception e2) {
                g(f.e(e2));
                return;
            }
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.f(context))) {
            this.C.x(h2.f(context));
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.g(context))) {
            this.C.z(h2.g(context));
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.i(context))) {
            this.C.A(h2.i(context));
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.c())) {
            this.C.B(h2.c());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.d())) {
            this.C.C(h2.d());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.b())) {
            this.C.D(h2.b());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(Long.toString(h2.r()))) {
            this.C.E(Long.toString(h2.r()));
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(Long.toString(h2.p()))) {
            this.C.F(Long.toString(h2.p()));
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.e(context))) {
            this.C.G(h2.e(context));
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.m())) {
            this.C.y(h2.m());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.o())) {
            this.C.J(h2.o());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.q())) {
            this.C.K(h2.q());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.a())) {
            this.C.L(h2.a());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.k())) {
            this.C.M(h2.k());
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(h2.l(context))) {
            this.C.I(h2.l(context));
        }
        Map<String, String> c2 = c(context);
        if (c2 != null && c2.size() > 0) {
            if (!com.alipay.mobilesecuritysdk.c.a.i(c2.get(z))) {
                this.C.H(c2.get(z));
            }
            if (!com.alipay.mobilesecuritysdk.c.a.i(c2.get(w))) {
                this.C.P(c2.get(w));
            }
            if (!com.alipay.mobilesecuritysdk.c.a.i(c2.get(y))) {
                this.C.S(c2.get(y));
            }
            if (!com.alipay.mobilesecuritysdk.c.a.i(c2.get("rule"))) {
                this.C.Q(c2.get("rule"));
            }
        }
        if (!com.alipay.mobilesecuritysdk.c.a.i(v()) && v().length() > 32) {
            this.C.O(v().substring(0, 32));
        } else {
            if (com.alipay.mobilesecuritysdk.c.a.i(u()) || u().length() <= 32) {
                return;
            }
            this.C.O(u().substring(0, 32));
        }
    }

    public String h(Context context) {
        e j2 = j(context);
        if (j2 == null) {
            return null;
        }
        try {
            if (!j2.j()) {
                return null;
            }
            String str = String.valueOf(j2.c()) + j2.g();
            HashMap hashMap = new HashMap();
            hashMap.put(w, j2.c());
            hashMap.put(x, j2.c());
            hashMap.put(y, j2.g());
            hashMap.put(B, j2.e());
            hashMap.put("rule", j2.f());
            hashMap.put(z, j2.d());
            try {
                m(context, new g().e(hashMap));
            } catch (JSONException unused) {
            }
            l(str);
            k(str);
            return j2.c();
        } catch (Exception e2) {
            g(f.e(e2));
            return null;
        }
    }

    public String i(Context context, Map<String, String> map) {
        if (map == null) {
            return h(context);
        }
        boolean t2 = t();
        if (a(map)) {
            if (!t2 && !com.alipay.mobilesecuritysdk.c.a.i(map.get(x)) && !com.alipay.mobilesecuritysdk.c.a.i(map.get(y))) {
                String str = String.valueOf(map.get(x)) + map.get(y);
                l(str);
                k(str);
            }
            String str2 = map.get(B);
            String p2 = p();
            if (n() && o(str2, p2)) {
                return map.get("apdid");
            }
        }
        return h(context);
    }

    public e j(Context context) {
        e eVar = new e();
        eVar.r(false);
        String f2 = this.D.f(e());
        if (f2 != null && f2.length() >= 0) {
            try {
                HttpResponse c2 = new a.a().c(context, com.alipay.mobilesecuritysdk.constant.a.C, f5229c, f2, "1", false);
                if (c2 != null && c2.getStatusLine().getStatusCode() == 200) {
                    return new g().c(EntityUtils.toString(c2.getEntity()));
                }
                eVar.r(false);
            } catch (IOException e2) {
                g(f.e(e2));
            }
        }
        return eVar;
    }

    public void k(String str) {
        try {
            if (com.alipay.mobilesecuritysdk.c.a.b()) {
                String d2 = h.d(h.h(), str);
                File file = new File(Environment.getExternalStorageDirectory(), com.alipay.mobilesecuritysdk.constant.a.E);
                if (!file.exists()) {
                    file.mkdir();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("device", d2);
                } catch (JSONException e2) {
                    g(f.e(e2));
                }
                try {
                    com.alipay.mobilesecuritysdk.c.a.f(String.valueOf(file.getAbsolutePath()) + File.separator + MiConfigSingleton.t0, jSONObject.toString());
                } catch (IOException e3) {
                    g(f.e(e3));
                }
            }
        } catch (Exception e4) {
            g(f.e(e4));
        }
    }

    public void l(String str) {
        if (com.alipay.mobilesecuritysdk.c.a.i(str)) {
            return;
        }
        String d2 = h.d(h.h(), str);
        if (com.alipay.mobilesecuritysdk.c.a.i(d2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device", d2);
            System.setProperty(f5228b, jSONObject.toString());
        } catch (JSONException e2) {
            g(f.e(e2));
        }
    }

    public void m(Context context, String str) {
        String d2 = h.d(h.h(), str);
        if (com.alipay.mobilesecuritysdk.c.a.i(d2)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(f5228b, d2);
        this.D.d(context.getSharedPreferences(f5227a, 0), hashMap);
    }

    public boolean n() {
        String v2 = v();
        String u2 = u();
        if (!com.alipay.mobilesecuritysdk.c.a.i(v2)) {
            return this.C.s().equals(v2.substring(0, 32));
        }
        if (com.alipay.mobilesecuritysdk.c.a.i(u2)) {
            return false;
        }
        return this.C.s().equals(u2.subSequence(0, 32));
    }

    public boolean o(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public String p() {
        String q2 = q();
        if (q2 == null) {
            q2 = "";
        }
        String d2 = com.alipay.mobilesecuritysdk.c.a.d(q2);
        return d2 == null ? "" : d2;
    }

    public boolean t() {
        return s() && r();
    }

    public String u() {
        String str;
        try {
            if (com.alipay.mobilesecuritysdk.c.a.b()) {
                File file = new File(Environment.getExternalStorageDirectory(), com.alipay.mobilesecuritysdk.constant.a.E);
                if (!file.exists()) {
                    file.mkdir();
                }
                String e2 = com.alipay.mobilesecuritysdk.c.a.e(String.valueOf(file.getAbsolutePath()) + File.separator + MiConfigSingleton.t0);
                if (com.alipay.mobilesecuritysdk.c.a.i(e2)) {
                    return null;
                }
                try {
                    str = new JSONObject(e2).getString("device");
                } catch (JSONException e3) {
                    g(f.e(e3));
                    str = null;
                }
                if (!com.alipay.mobilesecuritysdk.c.a.i(str)) {
                    return h.b(h.h(), str);
                }
            }
        } catch (Exception e4) {
            g(f.e(e4));
        }
        return null;
    }

    public String v() {
        String str;
        String property = System.getProperty(f5228b);
        if (!com.alipay.mobilesecuritysdk.c.a.i(property)) {
            try {
                str = new JSONObject(property).getString("device");
            } catch (JSONException e2) {
                g(f.e(e2));
                str = null;
            }
            if (!com.alipay.mobilesecuritysdk.c.a.i(str)) {
                return h.b(h.h(), str);
            }
        }
        return null;
    }
}
