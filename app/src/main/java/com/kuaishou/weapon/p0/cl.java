package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cl {

    /* renamed from: a */
    private String f9201a;

    /* renamed from: b */
    private String f9202b;

    /* renamed from: c */
    private String f9203c;

    /* renamed from: d */
    private String f9204d;

    /* renamed from: e */
    private String f9205e;

    /* renamed from: f */
    private String f9206f;

    /* renamed from: g */
    private String f9207g;

    /* renamed from: h */
    private String f9208h;

    /* renamed from: i */
    private String f9209i;

    /* renamed from: j */
    private String f9210j;
    private String k;
    private String l;

    public cl(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.f9209i = sb.toString();
        this.f9203c = str;
        this.f9207g = str2;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bh.v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h a2 = h.a(context, "re_po_rt");
            boolean e2 = a2.e("a1_p_s_p_s");
            boolean e3 = a2.e("a1_p_s_p_s_c_b");
            if (e2 || e3) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bh.v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bh.v = 4;
        return "";
    }

    public static String m() {
        try {
            return !TextUtils.isEmpty(WeaponHI.skProductName) ? WeaponHI.skProductName : "UNKNOWN_PRODUCT";
        } catch (Exception unused) {
            return "UNKNOWN_PRODUCT";
        }
    }

    private JSONObject n() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("1", this.f9201a);
            jSONObject.put("2", this.f9202b);
            jSONObject.put("3", this.f9203c);
            jSONObject.put("4", this.f9204d);
            jSONObject.put("5", this.f9205e);
            jSONObject.put("6", this.f9206f);
            jSONObject.put("7", this.f9207g);
            jSONObject.put("8", this.f9208h);
            jSONObject.put(BaseWrapper.ENTER_ID_MESSAGE, this.f9209i);
            jSONObject.put("11", this.f9210j);
            jSONObject.put("12", this.l);
            jSONObject.put("13", "com.kuaishou.weapon");
            jSONObject.put("14", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.f9201a;
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bg.q(context));
            e(bg.r(context));
            f(bg.s(context));
            h("5.0.9");
            j(bs.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(String str) {
        this.f9201a = str;
    }

    public String b() {
        return this.f9202b;
    }

    public void b(String str) {
        this.f9202b = str;
    }

    public String c() {
        return this.f9203c;
    }

    public void c(String str) {
        this.f9203c = str;
    }

    public String d() {
        return this.f9204d;
    }

    public void d(String str) {
        this.f9204d = str;
    }

    public String e() {
        return this.f9205e;
    }

    public void e(String str) {
        this.f9205e = str;
    }

    public String f() {
        return this.f9206f;
    }

    public void f(String str) {
        this.f9206f = str;
    }

    public String g() {
        return this.f9207g;
    }

    public void g(String str) {
        this.f9207g = str;
    }

    public String h() {
        return this.f9208h;
    }

    public void h(String str) {
        this.f9208h = str;
    }

    public String i() {
        return this.f9209i;
    }

    public void i(String str) {
        this.f9209i = str;
    }

    public String j() {
        return this.f9210j;
    }

    public void j(String str) {
        this.f9210j = str;
    }

    public String k() {
        return this.k;
    }

    public void k(String str) {
        this.k = str;
    }

    public String l() {
        return this.l;
    }

    public void l(String str) {
        this.l = str;
    }
}
