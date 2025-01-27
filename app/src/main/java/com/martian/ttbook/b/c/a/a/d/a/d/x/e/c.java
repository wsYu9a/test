package com.martian.ttbook.b.c.a.a.d.a.d.x.e;

import android.content.Context;
import android.view.View;
import com.martian.ttbook.b.c.a.a.b.a.d.i;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d;
import com.martian.ttbook.b.c.a.a.d.a.d.x.e.b;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends i implements b.a {

    /* renamed from: g */
    private static String f15624g = "GDTHTAG";

    /* renamed from: h */
    public NativeExpressAD f15625h;

    /* renamed from: j */
    private long f15626j;
    private final HashMap<NativeExpressADView, d> k;

    public c(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.k = new HashMap<>();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.i
    protected void B(Object obj, int i2, int i3) {
        com.martian.ttbook.b.c.a.a.e.i.d(obj, i3, i2, null);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.i
    protected void E(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.e.i.c(obj, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void a(List<NativeExpressADView> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onADLoaded");
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            boolean F = F();
            for (NativeExpressADView nativeExpressADView : list) {
                if (F && com.martian.ttbook.b.c.a.a.d.a.d.x.c.f(this.f15663d, nativeExpressADView.getBoundData())) {
                    A(nativeExpressADView, 0);
                } else {
                    C(nativeExpressADView, com.martian.ttbook.b.c.a.a.d.a.d.x.c.b(nativeExpressADView));
                    d dVar = new d(nativeExpressADView, this.f15662c, this.f15663d, this.f15661b);
                    arrayList.add(dVar);
                    this.k.put(nativeExpressADView, dVar);
                }
            }
            if (F && arrayList.size() == 0) {
                D(new com.martian.ttbook.b.c.a.a.d.b.i(30000019, "广告无填充！"));
                return;
            }
        }
        this.f15663d.f15703e = arrayList.size();
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).onAdLoaded(arrayList);
        }
        this.f15406f = true;
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void d(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onADClicked");
        d dVar = this.k.get(nativeExpressADView);
        k kVar = new k(this.f15662c, this.f15663d);
        if (dVar != null) {
            boolean g2 = kVar.c(k.b.n, dVar.f15210a).g(this.f15663d, dVar.i(), this.f15626j, dVar.f15218j);
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

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void e(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onADOpenOverlay");
        d dVar = this.k.get(nativeExpressADView);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).e(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void k(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onADClosed");
        d dVar = this.k.get(nativeExpressADView);
        new k(this.f15662c, this.f15663d).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).f(dVar);
        }
        this.k.remove(dVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void m(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onADExposure");
        d dVar = this.k.get(nativeExpressADView);
        if (dVar != null) {
            com.martian.ttbook.b.c.a.a.d.b.m.a i2 = dVar.i();
            l.c(i2, dVar.f15218j);
            l.m(this.f15662c.f15668b, dVar.f15218j, h.INFORMATION_FLOW, i2, new View[0], new WeakReference(i2), null);
            l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
            byte[] h2 = this.f15662c.r.h();
            if (h2 != null) {
                l.j(this.f15662c.f15668b, h2);
            }
            HashMap hashMap = new HashMap();
            this.f15626j = System.currentTimeMillis();
            hashMap.put(com.martian.ttbook.b.c.a.a.e.h.f15836a, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
            l.i(dVar.f15218j, true, true);
            new k(this.f15662c, this.f15663d).a(5).c(k.b.n, dVar.f15210a).h();
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).c(dVar);
            }
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void o(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onADCloseOverlay");
        d dVar = this.k.get(nativeExpressADView);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).g(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void onNoAD(AdError adError) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onNoAD");
        D(new com.martian.ttbook.b.c.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void p(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onRenderSuccess");
        d dVar = this.k.get(nativeExpressADView);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).h(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void r(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onRenderFail");
        d dVar = this.k.get(nativeExpressADView);
        this.k.remove(dVar);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).b(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.a.d.x.e.b.a
    public void s(NativeExpressADView nativeExpressADView) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "onADLeftApplication");
        d dVar = this.k.get(nativeExpressADView);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
            ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).d(dVar);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        Context context = this.f15662c.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        n.f(context, eVar.d(obj, ""));
        com.martian.ttbook.b.c.a.a.c.g gVar = this.f15662c.q;
        ADSize aDSize = new ADSize(gVar.b(), gVar.a());
        NativeExpressAD nativeExpressAD = (NativeExpressAD) com.martian.ttbook.b.c.a.a.d.a.d.x.d.b(d.e.EXPRESS, this.f15662c.f15670d, this.f15663d.f15701c.l(obj), this.f15663d.f15701c.l(e.c.Q), new b(this).a(), aDSize);
        this.f15625h = nativeExpressAD;
        com.martian.ttbook.b.c.a.a.c.q.b bVar = this.f15662c.s;
        if (bVar != null) {
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(0).setAutoPlayMuted(bVar.k()).build());
        }
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15625h.loadAD(this.f15662c.m);
        com.martian.ttbook.b.c.a.a.e.d.g(f15624g, "load");
    }
}
