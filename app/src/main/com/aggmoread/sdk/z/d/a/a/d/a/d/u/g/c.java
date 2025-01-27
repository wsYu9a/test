package com.aggmoread.sdk.z.d.a.a.d.a.d.u.g;

import android.content.Context;
import android.view.View;
import com.aggmoread.sdk.z.d.a.a.c.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.h;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class c extends h implements b.a {

    /* renamed from: p */
    private static String f5700p = "AMEPTAGGDT";

    /* renamed from: n */
    public NativeExpressAD f5701n;

    /* renamed from: o */
    private final HashMap<NativeExpressADView, d> f5702o;

    public c(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5702o = new HashMap<>();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void a(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onADClosed");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            dVar.j();
            this.f5702o.remove(dVar);
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void b(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onRenderSuccess");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            dVar.o();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void c(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onADExposure");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = dVar.a();
            l.a(a10, dVar.f5281n);
            l.a(this.f5842g.f5856b, dVar.f5281n, i.INFORMATION_FLOW, a10, new View[0], new WeakReference(a10), null);
            l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
            byte[] b10 = this.f5842g.f5872r.b();
            if (b10 != null) {
                l.a(this.f5842g.f5856b, b10);
            }
            System.currentTimeMillis();
            l.a((Object) dVar.f5281n, true, true);
            l.a(dVar.f5281n, this.f5843h);
            dVar.k();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void d(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onADCloseOverlay");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void e(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onADLeftApplication");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            dVar.l();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void f(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onRenderFail");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            this.f5702o.remove(dVar);
            dVar.n();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void g(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onADOpenOverlay");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void h(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onADClicked");
        d dVar = this.f5702o.get(nativeExpressADView);
        if (dVar != null) {
            dVar.i();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        Context context = this.f5842g.f5858d;
        com.aggmoread.sdk.z.d.a.a.e.f fVar = this.f5843h.f5907c;
        Object obj = e.c.X;
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(context, fVar.a(obj, ""));
        com.aggmoread.sdk.z.d.a.a.c.h hVar = this.f5842g.f5871q;
        ADSize aDSize = new ADSize(hVar.b(), hVar.a());
        NativeExpressAD nativeExpressAD = (NativeExpressAD) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5842g.f5858d, this.f5843h.f5907c.c(obj), this.f5843h.f5907c.c(e.c.T), d.e.EXPRESS, this.f5845j, new b(this).a(), aDSize);
        this.f5701n = nativeExpressAD;
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        if (bVar != null) {
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(bVar.a()).setAutoPlayMuted(bVar.d()).setDetailPageMuted(bVar.e()).build());
            if (bVar.c() >= 5 && bVar.c() <= 61) {
                this.f5701n.setMinVideoDuration(bVar.c());
            }
            if (bVar.b() >= 5 && bVar.b() <= 61) {
                this.f5701n.setMaxVideoDuration(bVar.b());
            }
        }
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5701n.loadAD(this.f5842g.f5867m);
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "load");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void onNoAD(AdError adError) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onNoAD");
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.h
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(obj, i11, i10, null);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void b(List<NativeExpressADView> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5700p, "onADLoaded");
        List<com.aggmoread.sdk.z.d.a.a.c.o.d> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            boolean q10 = q();
            boolean o10 = o();
            int i10 = -1;
            for (NativeExpressADView nativeExpressADView : list) {
                int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(nativeExpressADView);
                if (o10) {
                    if (q10 && com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(this.f5843h, nativeExpressADView.getBoundData())) {
                        a(nativeExpressADView, 0);
                        i10 = a10;
                    } else {
                        b(nativeExpressADView, a10);
                    }
                }
                d dVar = new d(nativeExpressADView, this.f5842g, this.f5843h, this.f5841f);
                arrayList.add(dVar);
                this.f5702o.put(nativeExpressADView, dVar);
                i10 = a10;
            }
            if (q10 && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.h
    public void c(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(obj, i10);
    }
}
