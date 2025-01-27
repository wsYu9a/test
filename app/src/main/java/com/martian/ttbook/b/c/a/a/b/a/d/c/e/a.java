package com.martian.ttbook.b.c.a.a.b.a.d.c.e;

import android.app.Activity;
import android.view.View;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.b.a.d.o;
import com.martian.ttbook.b.c.a.a.b.a.d.r;
import com.martian.ttbook.b.c.a.a.c.e;
import com.martian.ttbook.b.c.a.a.c.g;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.opos.acs.st.utils.ErrorContants;
import com.vivo.mobilead.unified.base.AdParams;
import com.vivo.mobilead.unified.nativead.UnifiedVivoNativeExpressAd;
import com.vivo.mobilead.unified.nativead.VivoNativeExpressView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends l {

    /* renamed from: g */
    private static String f15360g = "VVUNITAG";

    /* renamed from: h */
    private UnifiedVivoNativeExpressAd f15361h;

    /* renamed from: j */
    private final HashMap<VivoNativeExpressView, com.martian.ttbook.b.c.a.a.b.a.d.c.e.b> f15362j;
    private long k;
    private r<VivoNativeExpressView> l;

    /* renamed from: com.martian.ttbook.b.c.a.a.b.a.d.c.e.a$a */
    class C0313a implements r<VivoNativeExpressView> {
        C0313a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.r
        public void a(i iVar) {
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15360g, "onAdError " + iVar);
            a.this.D(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.r
        public void b(VivoNativeExpressView vivoNativeExpressView) {
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15360g, "onADClicked");
            com.martian.ttbook.b.c.a.a.b.a.d.c.e.b bVar = (com.martian.ttbook.b.c.a.a.b.a.d.c.e.b) a.this.f15362j.get(vivoNativeExpressView);
            a aVar = a.this;
            k kVar = new k(aVar.f15662c, aVar.f15663d);
            if (bVar != null) {
                boolean g2 = kVar.c(k.b.n, bVar.f15210a).g(a.this.f15663d, bVar.i(), a.this.k, bVar.f15218j);
                kVar.h();
                com.martian.ttbook.b.c.a.a.d.b.l.i(bVar.f15218j, false, true);
                if (g2) {
                    e eVar = a.this.f15662c.f15673g;
                    if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                        ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).i(bVar);
                    }
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.r
        public void c(VivoNativeExpressView vivoNativeExpressView) {
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15360g, "onADClosed");
            com.martian.ttbook.b.c.a.a.b.a.d.c.e.b bVar = (com.martian.ttbook.b.c.a.a.b.a.d.c.e.b) a.this.f15362j.get(vivoNativeExpressView);
            a aVar = a.this;
            new k(aVar.f15662c, aVar.f15663d).a(1).h();
            e eVar = a.this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).f(bVar);
            }
            a.this.f15362j.remove(bVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.r
        /* renamed from: d */
        public void a(VivoNativeExpressView vivoNativeExpressView) {
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15360g, "onADExposure");
            com.martian.ttbook.b.c.a.a.b.a.d.c.e.b bVar = (com.martian.ttbook.b.c.a.a.b.a.d.c.e.b) a.this.f15362j.get(vivoNativeExpressView);
            if (bVar != null) {
                com.martian.ttbook.b.c.a.a.d.b.m.a i2 = bVar.i();
                com.martian.ttbook.b.c.a.a.d.b.l.c(i2, bVar.f15218j);
                com.martian.ttbook.b.c.a.a.d.b.l.m(a.this.f15662c.f15668b, bVar.f15218j, h.INFORMATION_FLOW, i2, new View[0], new WeakReference(i2), null);
                a aVar = a.this;
                com.martian.ttbook.b.c.a.a.d.b.l.s(aVar.f15662c.f15668b, aVar.f15663d.e(), a.this.f15663d.b());
                byte[] h2 = a.this.f15662c.r.h();
                if (h2 != null) {
                    com.martian.ttbook.b.c.a.a.d.b.l.j(a.this.f15662c.f15668b, h2);
                }
                HashMap hashMap = new HashMap();
                a.this.k = System.currentTimeMillis();
                hashMap.put(com.martian.ttbook.b.c.a.a.e.h.f15836a, a.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
                com.martian.ttbook.b.c.a.a.d.b.l.i(bVar.f15218j, true, true);
                a aVar2 = a.this;
                new k(aVar2.f15662c, aVar2.f15663d).a(5).c(k.b.n, bVar.f15210a).h();
                com.martian.ttbook.b.c.a.a.c.e eVar = a.this.f15662c.f15673g;
                if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.c) {
                    ((com.martian.ttbook.b.c.a.a.c.l.c) eVar).c(bVar);
                }
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.r
        public void onAdLoaded(List<VivoNativeExpressView> list) {
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15360g, "ad loaded");
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (VivoNativeExpressView vivoNativeExpressView : list) {
                    if (a.this.F() && com.martian.ttbook.b.c.a.a.b.a.d.c.b.i(a.this.f15663d, com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(vivoNativeExpressView))) {
                        a.this.A(vivoNativeExpressView, 0);
                    } else {
                        a.this.C(vivoNativeExpressView, com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(vivoNativeExpressView));
                        a aVar = a.this;
                        com.martian.ttbook.b.c.a.a.b.a.d.c.e.b bVar = new com.martian.ttbook.b.c.a.a.b.a.d.c.e.b(vivoNativeExpressView, aVar.f15662c, aVar.f15663d, aVar.f15661b);
                        arrayList.add(bVar);
                        a.this.f15362j.put(vivoNativeExpressView, bVar);
                    }
                }
                if (a.this.F() && arrayList.size() == 0) {
                    a.this.D(new i(30000019, "广告无填充！"));
                    return;
                }
            }
            a.this.f15663d.f15703e = list.size();
            a aVar2 = a.this;
            new k(aVar2.f15662c, aVar2.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
            ((com.martian.ttbook.b.c.a.a.c.l.c) a.this.f15662c.f15673g).onAdLoaded(arrayList);
            ((l) a.this).f15414f = true;
        }
    }

    class b implements o {

        /* renamed from: a */
        final /* synthetic */ Activity f15364a;

        b(Activity activity) {
            this.f15364a = activity;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15360g, "init success");
            a.this.N(this.f15364a);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void b() {
            a.this.D(new i(-1000, "广告加载失败！"));
            com.martian.ttbook.b.c.a.a.e.d.g(a.f15360g, "returen #1");
        }
    }

    public a(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15362j = new HashMap<>();
        this.l = new C0313a();
    }

    public void N(Activity activity) {
        AdParams.Builder f2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.f(this.f15663d);
        g gVar = this.f15662c.q;
        if (gVar != null) {
            if (gVar.b() > 0) {
                f2.setNativeExpressWidth(gVar.b());
            }
            if (gVar.a() > 0) {
                f2.setNativeExpressHegiht(gVar.a());
            }
        }
        f2.setVideoPolicy(com.martian.ttbook.b.c.a.a.b.a.d.c.b.b(this.f15662c.s));
        this.f15361h = new UnifiedVivoNativeExpressAd(activity, f2.build(), com.martian.ttbook.b.c.a.a.b.a.d.c.d.a().b(this.l));
        com.martian.ttbook.b.c.a.a.e.d.g(f15360g, "load ad");
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15361h.loadAd();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void B(Object obj, int i2, int i3) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.h(obj, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void E(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.j(obj, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15360g, "handle enter");
        Activity d2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.d(this.f15662c.f15670d);
        if (d2 == null) {
            D(new i(-1001, "当前传入Activity为空"));
        } else {
            n.b(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), new b(d2));
        }
    }
}
