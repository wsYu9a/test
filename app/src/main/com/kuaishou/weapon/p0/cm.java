package com.kuaishou.weapon.p0;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cm {

    /* renamed from: a */
    private String f10934a;

    /* renamed from: b */
    private String f10935b;

    /* renamed from: c */
    private String f10936c;

    /* renamed from: d */
    private String f10937d;

    /* renamed from: e */
    private String f10938e;

    /* renamed from: f */
    private String f10939f;

    /* renamed from: g */
    private String f10940g;

    /* renamed from: h */
    private String f10941h;

    /* renamed from: i */
    private String f10942i;

    /* renamed from: j */
    private String f10943j;

    /* renamed from: k */
    private String f10944k;

    /* renamed from: l */
    private String f10945l;

    public cm(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        this.f10942i = sb2.toString();
        this.f10936c = str;
        this.f10940g = str2;
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
            jSONObject.put("1", this.f10934a);
            jSONObject.put("2", this.f10935b);
            jSONObject.put("3", this.f10936c);
            jSONObject.put("4", this.f10937d);
            jSONObject.put("5", this.f10938e);
            jSONObject.put("6", this.f10939f);
            jSONObject.put("7", this.f10940g);
            jSONObject.put("8", this.f10941h);
            jSONObject.put("9", this.f10942i);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, this.f10943j);
            jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, this.f10945l);
            jSONObject.put("13", "com.kuaishou.weapon");
            jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.f10934a;
    }

    public String b() {
        return this.f10935b;
    }

    public String c() {
        return this.f10936c;
    }

    public String d() {
        return this.f10937d;
    }

    public String e() {
        return this.f10938e;
    }

    public String f() {
        return this.f10939f;
    }

    public String g() {
        return this.f10940g;
    }

    public String h() {
        return this.f10941h;
    }

    public String i() {
        return this.f10942i;
    }

    public String j() {
        return this.f10943j;
    }

    public String k() {
        return this.f10944k;
    }

    public String l() {
        return this.f10945l;
    }

    public void a(String str) {
        this.f10934a = str;
    }

    public void b(String str) {
        this.f10935b = str;
    }

    public void c(String str) {
        this.f10936c = str;
    }

    public void d(String str) {
        this.f10937d = str;
    }

    public void e(String str) {
        this.f10938e = str;
    }

    public void f(String str) {
        this.f10939f = str;
    }

    public void g(String str) {
        this.f10940g = str;
    }

    public void h(String str) {
        this.f10941h = str;
    }

    public void i(String str) {
        this.f10942i = str;
    }

    public void j(String str) {
        this.f10943j = str;
    }

    public void k(String str) {
        this.f10944k = str;
    }

    public void l(String str) {
        this.f10945l = str;
    }

    public static String b(Context context) {
        try {
            String str = WeaponHI.sKDeviceId;
            if (!TextUtils.isEmpty(str)) {
                bi.f10826v = 1;
                return str;
            }
        } catch (Exception unused) {
        }
        try {
            h a10 = h.a(context, "re_po_rt");
            boolean e10 = a10.e("a1_p_s_p_s");
            boolean e11 = a10.e("a1_p_s_p_s_c_b");
            if (e10 || e11) {
                String str2 = "ANDROID_" + Settings.Secure.getString(context.getContentResolver(), "android_id");
                if (!TextUtils.isEmpty(str2)) {
                    bi.f10826v = 3;
                    return str2;
                }
            }
        } catch (Exception unused2) {
        }
        bi.f10826v = 4;
        return "";
    }

    public JSONObject a(Context context) {
        try {
            a(b(context));
            b(m());
            d(bh.q(context));
            e(bh.r(context));
            f(bh.s(context));
            h("5.3.6");
            j(bt.a(context));
            l(WeaponHI.sKSAppkey);
            return n();
        } catch (Throwable unused) {
            return null;
        }
    }
}
