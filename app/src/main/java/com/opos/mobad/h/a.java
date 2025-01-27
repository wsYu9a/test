package com.opos.mobad.h;

import android.content.Context;
import android.view.View;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.model.d.g;
import com.opos.mobad.model.d.n;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public abstract class a implements com.opos.mobad.model.c.a {

    /* renamed from: i */
    private static final String f20861i = com.opos.cmn.an.a.b.a("b3Bwb191bmlvbl90b2tlbj0=");
    private static Map<String, Long> k = new ConcurrentHashMap();
    private static Map<String, Long> l = new ConcurrentHashMap();

    /* renamed from: a */
    protected Context f20862a;

    /* renamed from: b */
    protected String f20863b;

    /* renamed from: c */
    protected n f20864c;

    /* renamed from: d */
    protected boolean f20865d;

    /* renamed from: g */
    protected com.opos.mobad.cmn.a.a f20868g;

    /* renamed from: h */
    protected a.b f20869h;

    /* renamed from: j */
    private long f20870j = 1500;

    /* renamed from: e */
    protected long f20866e = 0;

    /* renamed from: f */
    protected long f20867f = 0;

    public a(Context context, String str, com.opos.mobad.cmn.a.d dVar) {
        this.f20862a = com.opos.mobad.service.b.a(context);
        this.f20863b = str;
        this.f20864c = new g(this.f20862a, com.opos.mobad.model.b.a(context).a());
        this.f20868g = new com.opos.mobad.cmn.a.a(this.f20862a, str, dVar);
        a.b a2 = com.opos.mobad.cmn.a.b.f.a(context, (View) null);
        this.f20869h = a2;
        this.f20868g.a(a2);
        a();
    }

    private void a() {
        com.opos.mobad.cmn.service.pkginstall.c.a().a(this.f20862a);
    }

    protected int a(int i2) {
        return 0;
    }

    public void a(AdItemData adItemData) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData == null || materialData.n() == null || materialData.n().size() <= 0) {
                    return;
                }
                com.opos.mobad.service.g.b.a(this.f20862a, materialData.n());
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e2);
            }
        }
    }

    public void a(AdItemData adItemData, boolean z, Map<String, String> map) {
        if (adItemData != null) {
            try {
                MaterialData materialData = adItemData.i().get(0);
                if (materialData != null) {
                    this.f20868g.a(adItemData);
                    com.opos.mobad.cmn.a.b.d.a(this.f20862a, this.f20863b, adItemData, materialData, z, map);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterBaseAd", "", (Throwable) e2);
            }
        }
    }

    protected String b(int i2) {
        return i2 != 10008 ? i2 != 11001 ? i2 != 11003 ? i2 != 11005 ? "" : "ads must display on android version after19" : "you request ad too often." : "ad has destroyed." : "ad has showed, please reload ad";
    }
}
