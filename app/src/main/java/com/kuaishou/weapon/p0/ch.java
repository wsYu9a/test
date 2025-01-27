package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ch {

    /* renamed from: a */
    private Context f10900a;

    /* renamed from: b */
    private int f10901b;

    public ch(Context context, int i10) {
        this.f10900a = context;
        this.f10901b = i10;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f10900a, "re_po_rt").b(df.f11071y, 1) != 1) {
                return null;
            }
            try {
                JSONArray a10 = new x().a(this.f10900a);
                if (a10 != null && a10.length() > 0) {
                    jSONObject.put("10000", a10);
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Kh().Kg()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Kh().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Kh().getAppId()));
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a10;
        try {
            JSONObject a11 = new cm(str, ck.f10916l).a(this.f10900a);
            if (a11 != null && (a10 = a()) != null && a10.length() != 0) {
                a11.put("module_section", a10);
                return a11.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
