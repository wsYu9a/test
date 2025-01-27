package com.martian.ttbook.b.c.a.a.d.a.d.x.e;

import android.content.Context;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d;
import com.martian.ttbook.b.c.a.a.d.a.d.x.e.g;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.e.i;
import com.martian.ttbook.sdk.client.AdRequest;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends l implements g.a {

    /* renamed from: g */
    private static String f15631g = "GDTHTAG";

    /* renamed from: h */
    public NativeUnifiedAD f15632h;

    public f(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void B(Object obj, int i2, int i3) {
        i.d(obj, i3, i2, null);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void E(Object obj, int i2) {
        i.c(obj, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.g.a
    public void a(List<NativeUnifiedADData> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15631g, "ad loaded");
        int r = com.martian.ttbook.b.c.a.a.d.b.l.r(this.f15662c);
        v();
        if (r == 9) {
            u(new com.martian.ttbook.b.c.a.a.d.b.i(30000018, "GDT ad blocked"));
            return;
        }
        boolean i2 = this.f15662c.i(AdRequest.Parameters.KEY_ESP, 16);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            boolean F = F();
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                if (F && com.martian.ttbook.b.c.a.a.d.a.d.x.c.f(this.f15663d, nativeUnifiedADData)) {
                    A(nativeUnifiedADData, 0);
                } else {
                    C(nativeUnifiedADData, com.martian.ttbook.b.c.a.a.d.a.d.x.c.b(nativeUnifiedADData));
                    arrayList.add(i2 ? new a(nativeUnifiedADData, this.f15632h, this.f15662c, this.f15663d, this.f15661b, r) : new e(nativeUnifiedADData, this.f15632h, this.f15662c, this.f15663d, this.f15661b, r));
                }
            }
            if (F && arrayList.size() == 0) {
                D(new com.martian.ttbook.b.c.a.a.d.b.i(30000019, "广告无填充！"));
                return;
            }
        }
        this.f15663d.f15703e = list.size();
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
        ((com.martian.ttbook.b.c.a.a.c.l.e) this.f15662c.f15673g).onAdLoaded(arrayList);
        this.f15414f = true;
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.g.a
    public void onNoAD(AdError adError) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15631g, "onAdError %s", adError);
        D(new com.martian.ttbook.b.c.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        Context context = this.f15662c.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        n.f(context, eVar.d(obj, ""));
        this.f15632h = (NativeUnifiedAD) com.martian.ttbook.b.c.a.a.d.a.d.x.d.b(d.e.UNIFIED, this.f15662c.f15670d, this.f15663d.f15701c.d(obj, ""), this.f15663d.f15701c.d(e.c.Q, ""), new g(this).a(), new Object[0]);
        int i2 = this.f15662c.m;
        int i3 = 1;
        if (i2 < 1) {
            i2 = 1;
        }
        int c2 = this.f15663d.f15702d.c(e.c.u, 0);
        if (c2 > 0) {
            if (c2 > 1) {
                com.martian.ttbook.b.c.a.a.d.b.l.d(this.f15662c, 9);
            }
            com.martian.ttbook.b.c.a.a.d.b.l.e(this.f15662c, this.f15663d);
        } else {
            i3 = i2;
        }
        com.martian.ttbook.b.c.a.a.e.d.g(f15631g, "load ad");
        com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15662c.s;
        if (bVar != null) {
            this.f15632h.setMaxVideoDuration(bVar.d());
            this.f15632h.setMinVideoDuration(this.f15662c.s.g());
        }
        this.f15632h.loadData(i3);
        new k(this.f15662c, this.f15663d).a(3).h();
    }
}
