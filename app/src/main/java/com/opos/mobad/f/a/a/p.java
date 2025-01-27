package com.opos.mobad.f.a.a;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class p<P> implements com.opos.mobad.ad.c.a<P> {

    /* renamed from: a */
    private final int f20625a;

    /* renamed from: b */
    private final n f20626b;

    public p(int i2, n nVar) {
        this.f20625a = i2;
        this.f20626b = nVar;
    }

    @Override // com.opos.mobad.ad.c.a
    public void a(int i2, String str) {
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdFailed adChannel:" + this.f20625a + ", code:" + i2 + ", msg:" + str);
        this.f20626b.a(this.f20625a, i2, str);
    }

    @Override // com.opos.mobad.ad.c.a
    public void a(List<P> list) {
        HashMap hashMap;
        n nVar = this.f20626b;
        if (nVar instanceof q) {
            hashMap = ((q) nVar).f20627a;
        } else {
            if (!(nVar instanceof r)) {
                com.opos.cmn.an.f.a.a("delegator", "delegator instance error");
                com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f20625a);
                this.f20626b.d(this.f20625a);
            }
            hashMap = ((r) nVar).f20628a;
        }
        hashMap.put(Integer.valueOf(this.f20625a), list);
        com.opos.cmn.an.f.a.a("delegator", "delegator onAdReady:" + this.f20625a);
        this.f20626b.d(this.f20625a);
    }
}
