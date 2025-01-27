package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ch {

    /* renamed from: a */
    private Context f9185a;

    /* renamed from: b */
    private int f9186b;

    public ch(Context context, int i2) {
        this.f9185a = context;
        this.f9186b = i2;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.f9197j).a(this.f9185a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        long currentTimeMillis;
        JSONObject jSONObject;
        JSONArray a2;
        try {
            currentTimeMillis = System.currentTimeMillis();
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        if (!WeaponHI.as) {
            return null;
        }
        h a3 = h.a(this.f9185a, "re_po_rt");
        int b2 = a3.b(de.m, 0);
        boolean e2 = a3.e("a1_p_s_p_s");
        boolean e3 = a3.e("a1_p_s_p_s_c_b");
        if (b2 == 1 && ((e2 || e3) && (a2 = new w(this.f9185a).a(0)) != null)) {
            jSONObject.put("10000", a2);
            try {
                jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        }
        return null;
    }
}
