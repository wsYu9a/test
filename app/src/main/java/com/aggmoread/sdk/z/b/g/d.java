package com.aggmoread.sdk.z.b.g;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.config.AdKeys;
import com.umeng.analytics.pro.bd;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private String f4478a;

    /* renamed from: b */
    private String f4479b;

    /* renamed from: c */
    private String f4480c;

    /* renamed from: d */
    private String f4481d;

    /* renamed from: e */
    private String f4482e;

    /* renamed from: f */
    private String f4483f;

    /* renamed from: g */
    private int f4484g;

    /* renamed from: h */
    private String f4485h;

    /* renamed from: i */
    private int f4486i;

    /* renamed from: j */
    private String f4487j;

    /* renamed from: k */
    private int f4488k;

    /* renamed from: l */
    private String f4489l;

    /* renamed from: m */
    private String f4490m;

    /* renamed from: n */
    private String f4491n;

    /* renamed from: o */
    private a f4492o = com.aggmoread.sdk.z.b.h.a.d().b();

    public static String b(Context context) {
        int i10 = context.getResources().getConfiguration().orientation;
        return i10 == 2 ? "L" : i10 == 1 ? "P" : "U";
    }

    public JSONObject a(Context context) {
        this.f4478a = this.f4492o.i();
        this.f4483f = this.f4492o.j();
        this.f4479b = this.f4492o.l();
        this.f4480c = this.f4492o.a();
        this.f4490m = this.f4492o.t();
        this.f4485h = this.f4492o.q();
        this.f4486i = this.f4492o.A() ? 2 : 1;
        this.f4487j = this.f4492o.w();
        this.f4484g = 1;
        this.f4488k = b(context).equals("L") ? 2 : b(context).equals("P") ? 1 : 0;
        this.f4489l = this.f4492o.e();
        this.f4481d = this.f4492o.n();
        this.f4482e = this.f4492o.y();
        this.f4491n = this.f4492o.p();
        JSONObject jSONObject = new JSONObject();
        try {
            String str = a(this.f4478a) ? this.f4480c : this.f4478a;
            jSONObject.put("imei", str);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("imeiMd5", com.aggmoread.sdk.z.b.j.g.a(str.toLowerCase()));
            }
            jSONObject.put("mac", this.f4479b);
            jSONObject.put("androidId", this.f4480c);
            if (!TextUtils.isEmpty(this.f4480c)) {
                jSONObject.put("androidIdMd5", com.aggmoread.sdk.z.b.j.g.a(this.f4480c.toLowerCase()));
            }
            jSONObject.put(AdKeys.OAID, a(this.f4491n) ? com.aggmoread.sdk.z.b.h.c.f4527o : this.f4491n);
            jSONObject.put(bm.f6904i, this.f4481d);
            jSONObject.put("vendor", this.f4482e);
            jSONObject.put("screenWidth", this.f4492o.z());
            jSONObject.put("screenHeight", this.f4492o.h());
            jSONObject.put("osType", this.f4484g);
            jSONObject.put("osVersion", this.f4485h);
            jSONObject.put("deviceType", this.f4486i);
            jSONObject.put(bd.f23524d, this.f4487j);
            jSONObject.put("ppi", this.f4492o.s());
            jSONObject.put("screenOrientation", this.f4488k);
            jSONObject.put("serialNo", a(this.f4490m, "unknown") ? this.f4480c : this.f4490m);
            jSONObject.put(bm.f6905j, this.f4489l);
            jSONObject.put("imsi", this.f4483f);
            jSONObject.put("updateMark", this.f4492o.x());
            jSONObject.put("bootMark", this.f4492o.d());
            jSONObject.put("systemBootTimeMilliSec", this.f4492o.u());
            jSONObject.put("deviceNameMd5", com.aggmoread.sdk.z.b.j.g.a(this.f4481d));
            jSONObject.put("physicalMemoryKBytes", this.f4492o.m());
            jSONObject.put("hardDiskSizeKBytes", this.f4492o.g());
            jSONObject.put("systemUpdateTimeNanoSec", this.f4492o.v());
            jSONObject.put("boardModel", this.f4492o.c());
            jSONObject.put("apiLevel", this.f4492o.r());
            jSONObject.put("density", this.f4492o.f());
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "JuHeApiDevice{imei='" + this.f4478a + "', mac='" + this.f4479b + "', androidId='" + this.f4480c + "', model='" + this.f4481d + "', vendor='" + this.f4482e + "', osType=" + this.f4484g + ", osVersion='" + this.f4485h + "', deviceType=" + this.f4486i + ", ua='" + this.f4487j + "', screenOrientation=" + this.f4488k + ", brand='" + this.f4489l + "', serialNo='" + this.f4490m + "'}";
    }

    private boolean a(String str) {
        return str == null || str.isEmpty();
    }

    private boolean a(String str, String str2) {
        return str == null || str.isEmpty() || str.equals("unknown");
    }
}
