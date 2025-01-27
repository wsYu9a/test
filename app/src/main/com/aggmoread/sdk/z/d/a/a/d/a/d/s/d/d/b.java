package com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.d;

import com.aggmoread.sdk.z.d.a.a.c.h;
import com.aggmoread.sdk.z.d.a.a.d.a.d.e;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.e.q;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends e {

    public class a implements TTAdNative.DrawFeedAdListener {
        public a() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
        public void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onAdLoaded list = ");
            sb2.append(list == null ? "null" : Integer.valueOf(list.size()));
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMDRAWTAGCSJ", sb2.toString());
            if (list != null && list.size() > 0) {
                for (TTDrawFeedAd tTDrawFeedAd : list) {
                    MediationNativeManager mediationManager = tTDrawFeedAd.getMediationManager();
                    if (mediationManager != null && mediationManager.isExpress()) {
                        b bVar = b.this;
                        arrayList.add(new com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.d.a(tTDrawFeedAd, bVar.f5842g, bVar.f5843h, bVar.f5841f));
                    }
                }
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMDRAWTAGCSJ", "onAdLoaded adList " + arrayList.size());
            b.this.e(arrayList);
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMDRAWTAGCSJ", "onAdLoaded");
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
        public void onError(int i10, String str) {
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMDRAWTAGCSJ", "onAdLoadedFial");
            b.this.b(new i(i10, str));
        }
    }

    public b(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    private void r() {
        int i10;
        int i11;
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMDRAWTAGCSJ", "loadAd");
        com.aggmoread.sdk.z.d.a.a.c.t.b bVar = this.f5842g.f5873s;
        boolean d10 = bVar != null ? bVar.d() : false;
        h hVar = this.f5842g.f5871q;
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
        createAdNative.loadDrawFeedAd(build, new a());
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMDRAWTAGCSJ", "handleAd");
        boolean c10 = com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.b.c(this.f5842g.f5858d, this.f5843h.f5907c.c(e.c.X), this.f5843h.f5907c.c(e.c.W));
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMDRAWTAGCSJ", "isInit " + c10);
        if (c10) {
            r();
        } else {
            b(new i(1001003005, "csj: MSDK未初始化，请稍后重试!"));
        }
    }
}
