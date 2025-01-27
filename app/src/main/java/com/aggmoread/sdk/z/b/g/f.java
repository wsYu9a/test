package com.aggmoread.sdk.z.b.g;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private String f4501a;

    /* renamed from: b */
    private int f4502b;

    /* renamed from: c */
    private int f4503c;

    /* renamed from: d */
    private a f4504d = com.aggmoread.sdk.z.b.h.a.d().b();

    public JSONObject a(Context context) {
        this.f4501a = TextUtils.isEmpty(this.f4504d.o()) ? com.aggmoread.sdk.z.b.p.e.b(context) : this.f4504d.o();
        this.f4502b = com.aggmoread.sdk.z.b.p.e.c(context);
        this.f4503c = com.aggmoread.sdk.z.b.p.e.e(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", this.f4501a);
            jSONObject.put("connectionType", this.f4502b);
            jSONObject.put("operatorType", this.f4503c);
            Location k10 = this.f4504d.k();
            if (k10 != null) {
                double latitude = k10.getLatitude();
                double longitude = k10.getLongitude();
                jSONObject.put(com.umeng.analytics.pro.f.C, latitude);
                jSONObject.put("lon", longitude);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "JuHeApiNetwork{ip='" + this.f4501a + "', connectionType=" + this.f4502b + ", operatorType=" + this.f4503c + '}';
    }
}
