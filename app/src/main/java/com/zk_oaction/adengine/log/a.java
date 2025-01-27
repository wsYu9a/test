package com.zk_oaction.adengine.log;

import android.content.Context;
import android.os.Build;
import com.baidu.mobads.sdk.internal.bj;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.zk_oaction.adengine.lk_sdk.d;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    public int f35189a;

    /* renamed from: h */
    public String f35196h;

    /* renamed from: i */
    public String f35197i;

    /* renamed from: j */
    public String f35198j;
    public int k;
    public String l;
    public String m;
    public int n;
    public String o;
    public String p;
    public String q;
    public boolean s;
    public long r = System.currentTimeMillis();

    /* renamed from: b */
    public String f35190b = bj.f5602g;

    /* renamed from: c */
    public String f35191c = "HD_SDK";

    /* renamed from: d */
    public String f35192d = "409";

    /* renamed from: e */
    public String f35193e = "4.09.20220518.release";

    /* renamed from: f */
    public String f35194f = "409";

    /* renamed from: g */
    public String f35195g = "HD_A1010";

    public a(Context context, int i2, String str, String str2, String str3) {
        this.f35189a = i2;
        this.p = str;
        this.q = str2;
        this.f35196h = context.getPackageName();
        try {
            this.f35197i = String.valueOf(context.getPackageManager().getPackageInfo(this.f35196h, 0).versionCode);
        } catch (Throwable unused) {
            this.f35197i = "0";
        }
        this.f35198j = this.f35195g;
        this.k = Build.VERSION.SDK_INT;
        this.l = Build.BRAND;
        this.m = Build.MODEL;
        this.s = d.a(context);
        this.o = str3;
    }

    public void a(JSONObject jSONObject) {
        jSONObject.put("level", this.f35189a);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", this.f35190b);
        jSONObject2.put("id", this.f35191c);
        jSONObject2.put("version", this.f35192d);
        jSONObject2.put("channel", this.f35195g);
        jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, this.f35193e);
        jSONObject2.put("ui_version", this.f35194f);
        jSONObject.put("runner", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("pkg", this.f35196h);
        jSONObject3.put("version", this.f35197i);
        jSONObject3.put("channel", this.f35198j);
        jSONObject.put("mainapp", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("andver", this.k);
        jSONObject4.put("oaid", this.o);
        jSONObject4.put(bj.f5605j, this.l);
        jSONObject4.put(bj.f5604i, this.m);
        jSONObject4.put(TKDownloadReason.KSAD_TK_NET, this.n);
        jSONObject4.put("iswifi", this.s);
        jSONObject.put("device", jSONObject4);
        jSONObject.put("eid", this.p);
        jSONObject.put("ecnt", this.q);
        jSONObject.put("etime", this.r);
        jSONObject.put("retry", 0);
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
