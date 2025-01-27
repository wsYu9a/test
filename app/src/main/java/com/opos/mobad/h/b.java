package com.opos.mobad.h;

import android.content.Context;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.model.data.AdData;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class b extends a {

    /* renamed from: i */
    protected com.opos.mobad.ad.c.f f20871i;

    /* renamed from: j */
    protected int f20872j;
    protected volatile String k;

    public b(Context context, String str, int i2, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, dVar);
        this.f20872j = i2;
        this.f20871i = fVar;
    }

    public b(Context context, String str, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.ad.c.f fVar) {
        super(context, str, dVar);
        this.f20871i = fVar;
    }

    protected void a(q qVar) {
        if (qVar != null) {
            try {
                com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdFailed nativeAdError=" + qVar.toString());
                b().a(qVar);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e2);
            }
        }
    }

    protected void a(AdData adData, List<com.opos.mobad.ad.c.d> list) {
        try {
            com.opos.cmn.an.f.a.b("InterBaseNativeAd", "notifyOnAdReady");
            if (adData == null || list == null) {
                return;
            }
            b().a(list);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InterBaseNativeAd", "", (Throwable) e2);
        }
    }

    public com.opos.mobad.ad.c.f b() {
        com.opos.mobad.ad.c.f fVar = this.f20871i;
        return fVar != null ? fVar : com.opos.mobad.ad.c.f.f19475b;
    }

    public m c() {
        com.opos.mobad.ad.c.f fVar = this.f20871i;
        return (fVar == null || !(fVar instanceof m)) ? m.f19476c : (m) fVar;
    }
}
