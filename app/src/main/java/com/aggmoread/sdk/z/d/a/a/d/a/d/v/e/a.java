package com.aggmoread.sdk.z.d.a.a.d.a.d.v.e;

import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.c.h;
import com.aggmoread.sdk.z.d.a.a.d.a.d.e;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class a extends e implements KsLoadManager.DrawAdListener {

    /* renamed from: n */
    private static String f5752n = "AMDRAWTAGKS";

    public a(d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.e
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(obj, i11);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.e
    public void c(Object obj, int i10) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.b(obj, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        if (!com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5842g.f5858d, this.f5843h.f5907c.a(e.c.X, ""))) {
            b(new i(1001002008, "广告加载失败！"));
            return;
        }
        int i10 = this.f5842g.f5867m;
        if (i10 < 1) {
            i10 = 1;
        }
        this.f5841f.put("ecpm", this.f5843h.f5906b.a(e.c.f5928f, "-1"));
        try {
            String c10 = this.f5843h.f5907c.c(e.c.T);
            String trim = c10.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5752n, "slotId = " + c10 + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsScene.Builder builder = new KsScene.Builder(parseLong);
            builder.adNum(Math.min(i10, 5));
            h hVar = this.f5842g.f5871q;
            if (hVar != null) {
                if (hVar.b() > 0) {
                    builder.width(hVar.b());
                }
                if (hVar.a() > 0) {
                    builder.height(hVar.a());
                }
            }
            KsAdSDK.getLoadManager().loadDrawAd(builder.build(), this);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5752n, "load ad");
            new k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception unused) {
            b(new i(1001002008, "广告ID配置错误，广告加载失败！"));
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
    public void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5752n, "ad loaded");
        List<com.aggmoread.sdk.z.d.a.a.c.n.a> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            int i10 = -1;
            for (KsDrawAd ksDrawAd : list) {
                int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) ksDrawAd);
                if (q() && com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5843h, a10)) {
                    a(ksDrawAd, 0);
                } else {
                    b(ksDrawAd, com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) ksDrawAd));
                    arrayList.add(new b(ksDrawAd, this.f5842g, this.f5843h, this.f5841f));
                }
                i10 = a10;
            }
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5752n, "ad loaded size " + arrayList.size());
            if (q() && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
    public void onError(int i10, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5752n, "onAdError %s,%s", Integer.valueOf(i10), str);
        b(new i(i10, str));
    }
}
