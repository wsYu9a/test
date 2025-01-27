package com.aggmoread.sdk.z.d.a.a.d.a.d.u.f;

import android.content.Context;
import android.view.View;
import com.aggmoread.sdk.z.d.a.a.c.h;
import com.aggmoread.sdk.z.d.a.a.c.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.e;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.d;
import com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.f;
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
public class b extends e implements b.a {

    /* renamed from: q */
    private static String f5695q = "AMDRAWTAGGDT";

    /* renamed from: n */
    public NativeExpressAD f5696n;

    /* renamed from: o */
    private long f5697o;

    /* renamed from: p */
    private final HashMap<NativeExpressADView, a> f5698p;

    public b(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f5698p = new HashMap<>();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void a(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onADClosed");
        a aVar = this.f5698p.get(nativeExpressADView);
        new k(this.f5842g, this.f5843h).a(4).b();
        if (aVar != null && aVar.j() != null) {
            aVar.j().a();
        }
        this.f5698p.remove(aVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void b(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onRenderSuccess");
        a aVar = this.f5698p.get(nativeExpressADView);
        if (aVar == null || aVar.j() == null) {
            return;
        }
        aVar.j().onRenderSuccess();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void c(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onADExposure");
        a aVar = this.f5698p.get(nativeExpressADView);
        if (aVar != null) {
            com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = aVar.a();
            l.a(a10, aVar.f5281n);
            l.a(this.f5842g.f5856b, aVar.f5281n, i.INFORMATION_FLOW, a10, new View[0], new WeakReference(a10), null);
            l.b(this.f5842g.f5856b, this.f5843h.e(), this.f5843h.b());
            byte[] b10 = this.f5842g.f5872r.b();
            if (b10 != null) {
                l.a(this.f5842g.f5856b, b10);
            }
            this.f5697o = System.currentTimeMillis();
            l.a((Object) aVar.f5281n, true, true);
            l.a(aVar.f5281n, this.f5843h);
            aVar.d();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void d(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onADCloseOverlay");
        a aVar = this.f5698p.get(nativeExpressADView);
        if (aVar == null || aVar.j() == null) {
            return;
        }
        aVar.j().onADCloseOverlay();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void e(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onADLeftApplication");
        a aVar = this.f5698p.get(nativeExpressADView);
        if (aVar == null || aVar.j() == null) {
            return;
        }
        aVar.j().onADLeftApplication();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void f(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onRenderFail");
        a aVar = this.f5698p.get(nativeExpressADView);
        this.f5698p.remove(aVar);
        if (aVar == null || aVar.j() == null) {
            return;
        }
        aVar.j().onRenderFail();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void g(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onADOpenOverlay");
        a aVar = this.f5698p.get(nativeExpressADView);
        if (aVar == null || aVar.j() == null) {
            return;
        }
        aVar.j().onADOpenOverlay();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void h(NativeExpressADView nativeExpressADView) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onADClicked");
        a aVar = this.f5698p.get(nativeExpressADView);
        k kVar = new k(this.f5842g, this.f5843h);
        if (aVar != null) {
            boolean a10 = kVar.a(k.b.f6046n, aVar.f5273f).a(this.f5843h, aVar.a(), this.f5697o, aVar.f5281n);
            kVar.b();
            l.a((Object) aVar.f5281n, false, true);
            if (!a10 || aVar.j() == null) {
                return;
            }
            aVar.j().onAdClicked();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        Context context = this.f5842g.f5858d;
        f fVar = this.f5843h.f5907c;
        Object obj = e.c.X;
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.b.a(context, fVar.a(obj, ""));
        h hVar = this.f5842g.f5871q;
        ADSize aDSize = new ADSize(hVar.b(), hVar.a());
        NativeExpressAD nativeExpressAD = (NativeExpressAD) com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(this.f5842g.f5858d, this.f5843h.f5907c.c(obj), this.f5843h.f5907c.c(e.c.T), d.e.EXPRESS, this.f5845j, new com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b(this).a(), aDSize);
        this.f5696n = nativeExpressAD;
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        if (bVar != null) {
            nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(bVar.a()).setAutoPlayMuted(bVar.d()).setDetailPageMuted(bVar.e()).build());
            if (bVar.c() >= 5 && bVar.c() <= 61) {
                this.f5696n.setMinVideoDuration(bVar.c());
            }
            if (bVar.b() >= 5 && bVar.b() <= 61) {
                this.f5696n.setMaxVideoDuration(bVar.b());
            }
        }
        new k(this.f5842g, this.f5843h).a(0).b();
        this.f5696n.loadAD(this.f5842g.f5867m);
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "load");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void onNoAD(AdError adError) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onNoAD");
        b(new com.aggmoread.sdk.z.d.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.e
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(obj, i11, i10, null);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.u.g.b.a
    public void b(List<NativeExpressADView> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5695q, "onADLoaded");
        List<com.aggmoread.sdk.z.d.a.a.c.n.a> arrayList = new ArrayList<>();
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
                a aVar = new a(nativeExpressADView, this.f5842g, this.f5843h, this.f5841f);
                arrayList.add(aVar);
                this.f5698p.put(nativeExpressADView, aVar);
                i10 = a10;
            }
            if (q10 && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.e
    public void c(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.u.d.a(obj, i10);
    }
}
