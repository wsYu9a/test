package com.martian.ttbook.b.c.a.a.d.b;

import com.martian.mibook.application.MiConfigSingleton;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.sdk.client.AdExtras;
import com.qq.e.comm.constants.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static String f15660a = "ADHTAG";

    /* renamed from: b */
    public HashMap<String, Object> f15661b = new HashMap<>();

    /* renamed from: c */
    public d f15662c;

    /* renamed from: d */
    public e f15663d;

    /* renamed from: e */
    protected com.martian.ttbook.b.c.a.a.b.a.c f15664e;

    public a(d dVar, e eVar) {
        this.f15662c = dVar;
        this.f15663d = eVar;
        this.f15664e = dVar.t;
        y();
    }

    public void u(i iVar) {
        this.f15662c.f(iVar, this.f15663d, true);
    }

    protected void v() {
        try {
            Map<Object, Object> b2 = l.b(this.f15662c);
            if (b2 != null) {
                Object obj = b2.get(Constants.KEYS.EXPOSED_CLICK_URL_KEY);
                Object obj2 = b2.get(MiConfigSingleton.u0);
                Object obj3 = b2.get("mediaId");
                Object obj4 = b2.get("examineId");
                com.martian.ttbook.b.c.a.a.e.d.g(f15660a, "clickUrl = " + obj + ",\t image = " + obj2 + ",\t mediaId = " + obj3);
                this.f15661b.put(AdExtras.EXTRA_MATERIAL_ID, obj3);
                this.f15661b.put(AdExtras.EXTRA_EXAMINE_ID, obj4);
                this.f15661b.put(AdExtras.EXTRA_IMG_URL, obj2);
                this.f15661b.put(AdExtras.EXTRA_CLICK_URL, obj);
            }
        } catch (Exception e2) {
            com.martian.ttbook.b.c.a.a.e.d.g(f15660a, "err " + e2.getMessage());
        }
    }

    protected void w() {
        u(new i(-10001, "不支持的广告类型,请检查广告ID和接口是否一致: adType=" + this.f15662c.f15671e.a() + " adSource=" + this.f15663d.f()));
    }

    protected boolean x() {
        return false;
    }

    protected void y() {
        String l = this.f15663d.f15701c.l(e.c.Q);
        int f2 = this.f15663d.f();
        int g2 = this.f15663d.f15701c.g(e.c.S);
        this.f15661b.put("EXTRA_network_placementId", l);
        this.f15661b.put(AdExtras.EXTRA_AD_SOURCE, Integer.valueOf(f2));
        this.f15661b.put("EXTRA_KEY_ad_priority", Integer.valueOf(g2));
    }

    public void z() {
        e eVar = this.f15663d;
        if (eVar != null) {
            eVar.h();
        }
        w();
    }
}
