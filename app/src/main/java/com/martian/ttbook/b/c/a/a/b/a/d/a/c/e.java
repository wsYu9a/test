package com.martian.ttbook.b.c.a.a.b.a.d.a.c;

import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.sdk.client.AdRequest;
import com.qumeng.advlib.core.AdRequestParam;
import com.qumeng.advlib.core.IMultiAdObject;
import com.qumeng.advlib.core.IMultiAdRequest;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public class e extends l implements AdRequestParam.ADLoadListener {

    /* renamed from: g */
    private static String f15235g = "QMHTAG";

    public e(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    public void G(IMultiAdObject iMultiAdObject) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15235g, "ad loaded");
        boolean i2 = this.f15662c.i(AdRequest.Parameters.KEY_ESP, 16);
        ArrayList arrayList = new ArrayList();
        if (iMultiAdObject != null) {
            if (F() && com.martian.ttbook.b.c.a.a.b.a.d.a.b.f(this.f15663d, com.martian.ttbook.b.c.a.a.b.a.d.a.b.c(iMultiAdObject))) {
                D(new i(30000019, "广告无填充！"));
                return;
            }
            arrayList.add(i2 ? new a(iMultiAdObject, this.f15662c, this.f15663d, this.f15661b) : new d(iMultiAdObject, this.f15662c, this.f15663d, this.f15661b));
        }
        com.martian.ttbook.b.c.a.a.d.b.e eVar = this.f15663d;
        eVar.f15703e = 1;
        new k(this.f15662c, eVar).a(4).c(k.b.B, 1).h();
        ((com.martian.ttbook.b.c.a.a.c.l.e) this.f15662c.f15673g).onAdLoaded(arrayList);
        this.f15414f = true;
    }

    public void onAdFailed(String str) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15235g, "onAdError %s", str);
        D(new i(-3000, str));
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        IMultiAdRequest e2 = com.martian.ttbook.b.c.a.a.b.a.d.a.b.e(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""));
        String l = this.f15663d.f15701c.l(e.c.Q);
        this.f15661b.put("EXTRA_network_placementId", l);
        com.martian.ttbook.b.c.a.a.e.d.g(f15235g, "slotId = " + l);
        AdRequestParam build = new AdRequestParam.Builder().adslotID(l).adType(3).adLoadListener(this).build();
        com.martian.ttbook.b.c.a.a.e.d.g(f15235g, "load ad");
        if (e2 != null) {
            e2.invokeADV(build);
        }
        new k(this.f15662c, this.f15663d).a(3).h();
    }
}
