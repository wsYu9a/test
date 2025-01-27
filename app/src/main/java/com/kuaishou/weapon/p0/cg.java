package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cg {

    /* renamed from: a */
    private Context f9183a;

    /* renamed from: b */
    private int f9184b;

    public cg(Context context, int i2) {
        this.f9183a = context;
        this.f9184b = i2;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.f9197j).a(this.f9183a);
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
        JSONArray a2;
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f9183a, "re_po_rt").b(de.w, 1) == 1 && (a2 = new x().a(this.f9183a)) != null && a2.length() > 0) {
                jSONObject.put("10000", a2);
                try {
                    jSONObject.put("11203", bg.b(com.kwad.sdk.d.b.Ax().Av()));
                    jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                    jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                    jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }
}
