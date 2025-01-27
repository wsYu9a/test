package com.martian.ttbook.b.c.a.a.b.a.d.y.e;

import android.view.View;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.martian.ttbook.b.c.a.a.b.a.d.i;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.b.a.d.y.e.d;
import com.martian.ttbook.b.c.a.a.c.g;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends i implements TTAdNative.NativeExpressAdListener, d.b {

    /* renamed from: g */
    public TTAdNative f15494g;

    /* renamed from: h */
    private long f15495h;

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.e.d.b
    public void f(d dVar) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onClick ");
        k kVar = new k(this.f15662c, this.f15663d);
        if (dVar != null) {
            boolean g2 = kVar.c(k.b.n, dVar.f15210a).g(this.f15663d, dVar.i(), this.f15495h, dVar.f15218j);
            kVar.h();
            l.i(dVar.f15218j, false, true);
            if (g2) {
                com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                    ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).i(dVar);
                }
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.e.d.b
    public void g(d dVar) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onRenderSuccess ");
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).h(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.e.d.b
    public void i(d dVar) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onDiskSelectedClosed ");
        new k(this.f15662c, this.f15663d).c(k.b.n, dVar.f15210a).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).f(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.e.d.b
    public void j(d dVar) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onShow ");
        if (dVar.k()) {
            this.f15495h = System.currentTimeMillis();
            com.martian.ttbook.b.c.a.a.d.b.m.a i2 = dVar.i();
            l.c(i2, dVar.f15218j);
            l.m(this.f15662c.f15668b, dVar.f15218j, h.INFORMATION_FLOW, i2, new View[0], new WeakReference(i2), null);
            l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
            byte[] h2 = this.f15662c.r.h();
            if (h2 != null) {
                l.j(this.f15662c.f15668b, h2);
            }
            l.i(dVar.f15218j, true, true);
            new k(this.f15662c, this.f15663d).a(5).c(k.b.n, dVar.f15210a).h();
            if (this.f15662c.f15673g instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onAdExposed");
                ((com.martian.ttbook.b.c.a.a.c.l.c) this.f15662c.f15673g).c(dVar);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
    public void onError(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onError");
        D(new com.martian.ttbook.b.c.a.a.d.b.i(i2, str));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onAdLoaded");
        if (list == null || list.size() == 0) {
            com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", " empty");
            u(new com.martian.ttbook.b.c.a.a.d.b.i(10008, "无广告"));
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTNativeExpressAd> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new d(it.next(), this.f15662c, this.f15663d, this.f15661b, this));
        }
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).onAdLoaded(arrayList);
        }
        this.f15406f = true;
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.y.e.d.b
    public void t(d dVar, String str, int i2) {
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "onRenderFail ");
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).b(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        int i2;
        int i3;
        n.c(this.f15662c.f15670d, this.f15663d.f15701c.l(e.c.U), null);
        this.f15494g = com.martian.ttbook.b.c.a.a.b.a.d.y.c.b().createAdNative(this.f15662c.f15670d.getApplicationContext());
        g gVar = this.f15662c.q;
        if (gVar != null) {
            i2 = gVar.b();
            i3 = this.f15662c.q.a();
        } else {
            i2 = 0;
            i3 = 0;
        }
        int i4 = i3 >= 0 ? i3 : 0;
        if (i2 < 1) {
            i2 = com.martian.ttbook.b.c.a.a.e.l.b(this.f15662c.f15670d);
        }
        AdSlot build = new AdSlot.Builder().setCodeId(this.f15663d.f15701c.l(e.c.Q)).setSupportDeepLink(true).setAdCount(Math.max(1, Math.min(3, this.f15662c.m))).setExpressViewAcceptedSize(i2, i4).build();
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15494g.loadExpressDrawFeedAd(build, this);
        com.martian.ttbook.b.c.a.a.e.d.g("CSJHTAG", "load");
    }
}
