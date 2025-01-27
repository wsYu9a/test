package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ci {

    /* renamed from: a */
    private Context f10902a;

    /* renamed from: b */
    private int f10903b;

    public ci(Context context, int i10) {
        this.f10902a = context;
        this.f10903b = i10;
    }

    public JSONObject a() {
        long currentTimeMillis;
        JSONObject jSONObject;
        JSONArray a10;
        try {
            currentTimeMillis = System.currentTimeMillis();
            jSONObject = new JSONObject();
        } catch (Throwable unused) {
        }
        if (!WeaponHI.as) {
            return null;
        }
        h a11 = h.a(this.f10902a, "re_po_rt");
        int b10 = a11.b(df.f11061o, 0);
        boolean e10 = a11.e("a1_p_s_p_s");
        boolean e11 = a11.e("a1_p_s_p_s_c_b");
        if (b10 == 1 && ((e10 || e11) && (a10 = new w(this.f10902a).a(0)) != null)) {
            jSONObject.put("10000", a10);
            try {
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Kh().Kg()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Kh().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Kh().getAppId()));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        }
        return null;
    }

    public String a(String str) {
        JSONObject a10;
        try {
            JSONObject a11 = new cm(str, ck.f10916l).a(this.f10902a);
            if (a11 == null || (a10 = a()) == null) {
                return null;
            }
            a11.put("module_section", a10);
            return a11.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
