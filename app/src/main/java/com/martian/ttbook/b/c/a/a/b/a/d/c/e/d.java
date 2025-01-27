package com.martian.ttbook.b.c.a.a.b.a.d.c.e;

import android.app.Activity;
import android.view.View;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.b.a.d.o;
import com.martian.ttbook.b.c.a.a.b.a.d.s;
import com.martian.ttbook.b.c.a.a.c.h;
import com.martian.ttbook.b.c.a.a.c.l.e;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.opos.acs.st.utils.ErrorContants;
import com.vivo.ad.nativead.NativeResponse;
import com.vivo.mobilead.nativead.NativeAdParams;
import com.vivo.mobilead.nativead.VivoNativeAd;
import com.vivo.mobilead.unified.IBidding;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class d extends l {

    /* renamed from: g */
    private static String f15371g = "VVUNITAG";

    /* renamed from: h */
    private VivoNativeAd f15372h;

    /* renamed from: j */
    private final HashMap<NativeResponse, c> f15373j;
    private long k;
    private s<NativeResponse> l;

    class a implements s<NativeResponse> {
        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.t
        public void a(i iVar) {
            d.this.D(iVar);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.t
        public void a(List<NativeResponse> list) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.f15371g, "ad loaded");
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (NativeResponse nativeResponse : list) {
                    if (d.this.F() && com.martian.ttbook.b.c.a.a.b.a.d.c.b.i(d.this.f15663d, com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(nativeResponse))) {
                        d.this.A(nativeResponse, 0);
                    } else {
                        d.this.C(nativeResponse, com.martian.ttbook.b.c.a.a.b.a.d.c.b.c(nativeResponse));
                        d dVar = d.this;
                        c cVar = new c(nativeResponse, dVar.f15662c, dVar.f15663d, dVar.f15661b);
                        arrayList.add(cVar);
                        d.this.f15373j.put(nativeResponse, cVar);
                    }
                }
                if (d.this.F() && arrayList.size() == 0) {
                    d.this.D(new i(30000019, "广告无填充！"));
                    return;
                }
            }
            d.this.f15663d.f15703e = list.size();
            d dVar2 = d.this;
            new k(dVar2.f15662c, dVar2.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
            ((e) d.this.f15662c.f15673g).onAdLoaded(arrayList);
            ((l) d.this).f15414f = true;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.s
        /* renamed from: b */
        public void a(NativeResponse nativeResponse) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.f15371g, "onADExposure");
            c cVar = (c) d.this.f15373j.get(nativeResponse);
            if (cVar != null) {
                com.martian.ttbook.b.c.a.a.d.b.m.a i2 = cVar.i();
                com.martian.ttbook.b.c.a.a.d.b.l.c(i2, cVar.f15218j);
                com.martian.ttbook.b.c.a.a.d.b.l.m(d.this.f15662c.f15668b, cVar.f15218j, h.INFORMATION_FLOW, i2, new View[0], new WeakReference(i2), null);
                d dVar = d.this;
                com.martian.ttbook.b.c.a.a.d.b.l.s(dVar.f15662c.f15668b, dVar.f15663d.e(), d.this.f15663d.b());
                byte[] h2 = d.this.f15662c.r.h();
                if (h2 != null) {
                    com.martian.ttbook.b.c.a.a.d.b.l.j(d.this.f15662c.f15668b, h2);
                }
                HashMap hashMap = new HashMap();
                d.this.k = System.currentTimeMillis();
                hashMap.put(com.martian.ttbook.b.c.a.a.e.h.f15836a, d.this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
                com.martian.ttbook.b.c.a.a.d.b.l.i(cVar.f15218j, true, true);
                d dVar2 = d.this;
                new k(dVar2.f15662c, dVar2.f15663d).a(5).c(k.b.n, cVar.f15210a).h();
                cVar.u();
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.s
        /* renamed from: c */
        public void b(NativeResponse nativeResponse) {
            com.martian.ttbook.b.c.a.a.e.d.g(d.f15371g, "onADClicked");
            c cVar = (c) d.this.f15373j.get(nativeResponse);
            d dVar = d.this;
            k kVar = new k(dVar.f15662c, dVar.f15663d);
            if (cVar != null) {
                boolean g2 = kVar.c(k.b.n, cVar.f15210a).g(d.this.f15663d, cVar.i(), d.this.k, cVar.f15218j);
                kVar.h();
                com.martian.ttbook.b.c.a.a.d.b.l.i(cVar.f15218j, false, true);
                if (g2) {
                    cVar.t();
                }
            }
        }
    }

    class b implements o {

        /* renamed from: a */
        final /* synthetic */ Activity f15375a;

        b(Activity activity) {
            this.f15375a = activity;
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void a() {
            com.martian.ttbook.b.c.a.a.e.d.g(d.f15371g, "init success");
            d.this.N(this.f15375a);
        }

        @Override // com.martian.ttbook.b.c.a.a.b.a.d.o
        public void b() {
            d.this.D(new i(-1000, "广告加载失败！"));
            com.martian.ttbook.b.c.a.a.e.d.g(d.f15371g, "returen #1");
        }
    }

    public d(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
        this.f15373j = new HashMap<>();
        this.l = new a();
    }

    public void N(Activity activity) {
        int i2 = this.f15662c.m;
        if (i2 < 1) {
            i2 = 1;
        }
        NativeAdParams.Builder builder = new NativeAdParams.Builder(this.f15663d.f15701c.d(e.c.Q, ""));
        builder.setAdCount(i2);
        builder.setUsePrivacyAndPermission(true);
        this.f15372h = new VivoNativeAd(activity, builder.build(), com.martian.ttbook.b.c.a.a.b.a.d.c.d.a().g(this.l));
        com.martian.ttbook.b.c.a.a.e.d.g(f15371g, "load ad");
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15372h.loadAd();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void B(Object obj, int i2, int i3) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.h((IBidding) obj, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    protected void E(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.c.b.j(obj, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        com.martian.ttbook.b.c.a.a.e.d.g(f15371g, "handle enter");
        Activity d2 = com.martian.ttbook.b.c.a.a.b.a.d.c.b.d(this.f15662c.f15670d);
        if (d2 == null) {
            D(new i(-1001, "当前传入Activity为空"));
        } else {
            n.b(this.f15662c.f15670d.getApplicationContext(), this.f15663d.f15701c.d(e.c.U, ""), new b(d2));
        }
    }
}
