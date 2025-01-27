package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e;

import android.view.View;
import com.aggmoread.sdk.z.d.a.a.c.i;
import com.aggmoread.sdk.z.d.a.a.d.a.d.h;
import com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.q;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a extends h {

    /* renamed from: n */
    private long f5607n;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.a$a */
    public class C0147a implements TTAdNative.NativeExpressAdListener {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.a$a$a */
        public class C0148a implements b.InterfaceC0150b {
            public C0148a() {
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b.InterfaceC0150b
            public void a(b bVar) {
                e.b("AMEPTAGCSJ", "onRenderSuccess ");
                if (bVar != null) {
                    bVar.o();
                }
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b.InterfaceC0150b
            public void b(b bVar) {
                e.b("AMEPTAGCSJ", "onShow ");
                if (bVar.q()) {
                    a.this.f5607n = System.currentTimeMillis();
                    com.aggmoread.sdk.z.d.a.a.d.b.m.a a10 = bVar.a();
                    l.a(a10, bVar.f5281n);
                    l.a(a.this.f5842g.f5856b, bVar.f5281n, i.INFORMATION_FLOW, a10, new View[0], new WeakReference(a10), null);
                    a aVar = a.this;
                    l.b(aVar.f5842g.f5856b, aVar.f5843h.e(), a.this.f5843h.b());
                    byte[] b10 = a.this.f5842g.f5872r.b();
                    if (b10 != null) {
                        l.a(a.this.f5842g.f5856b, b10);
                    }
                    l.a((Object) bVar.f5281n, true, true);
                    l.a(bVar.f5281n, a.this.f5843h);
                    bVar.k();
                }
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b.InterfaceC0150b
            public void c(b bVar) {
                e.b("AMEPTAGCSJ", "onClick ");
                if (bVar != null) {
                    bVar.i();
                }
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b.InterfaceC0150b
            public void d(b bVar) {
                e.b("AMEPTAGCSJ", "onDiskSelectedClosed ");
                if (bVar != null) {
                    bVar.j();
                }
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.e.b.InterfaceC0150b
            public void a(b bVar, String str, int i10) {
                e.b("AMEPTAGCSJ", "onRenderFail ");
                if (bVar != null) {
                    bVar.n();
                }
            }
        }

        public C0147a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onError(int i10, String str) {
            e.b("AMEPTAGCSJ", "onAdLoadedFial");
            a.this.b(new com.aggmoread.sdk.z.d.a.a.d.b.i(i10, str));
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
        public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onAdLoaded list = ");
            sb2.append(list == null ? "null" : Integer.valueOf(list.size()));
            e.b("AMEPTAGCSJ", sb2.toString());
            if (list != null && list.size() > 0) {
                for (TTNativeExpressAd tTNativeExpressAd : list) {
                    a aVar = a.this;
                    arrayList.add(new b(tTNativeExpressAd, aVar.f5842g, aVar.f5843h, aVar.f5841f, new C0148a()));
                }
            }
            e.b("AMEPTAGCSJ", "onAdLoaded adList " + arrayList.size());
            a.this.e(arrayList);
            e.b("AMEPTAGCSJ", "onAdLoaded");
        }
    }

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    private void r() {
        int i10;
        int i11;
        e.b("AMEPTAGCSJ", "loadAd");
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        boolean d10 = bVar != null ? bVar.d() : false;
        com.aggmoread.sdk.z.d.a.a.c.h hVar = this.f5842g.f5871q;
        if (hVar != null) {
            i10 = hVar.b();
            i11 = this.f5842g.f5871q.a();
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (i10 < 1) {
            i10 = q.b(this.f5842g.f5858d);
        }
        TTAdNative createAdNative = TTAdSdk.getAdManager().createAdNative(this.f5842g.f5858d);
        AdSlot build = new AdSlot.Builder().setCodeId(this.f5843h.f5907c.c(e.c.T)).setImageAcceptedSize(i10, i11).setAdCount(Math.max(1, Math.min(3, this.f5842g.f5867m))).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(d10).build()).build();
        new k(this.f5842g, this.f5843h).a(0).b();
        createAdNative.loadNativeExpressAd(build, new C0147a());
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMEPTAGCSJ", "handleAd");
        boolean c10 = com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.c(this.f5842g.f5858d, this.f5843h.f5907c.c(e.c.X), this.f5843h.f5907c.c(e.c.W));
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMEPTAGCSJ", "isInit " + c10);
        if (c10) {
            r();
        } else {
            b(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003005, "csj: MSDK未初始化，请稍后重试!"));
        }
    }
}
