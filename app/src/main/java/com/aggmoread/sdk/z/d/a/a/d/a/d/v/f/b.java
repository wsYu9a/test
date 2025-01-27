package com.aggmoread.sdk.z.d.a.a.d.a.d.v.f;

import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.d.a.d.h;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b extends h implements KsLoadManager.FeedAdListener {

    /* renamed from: n */
    private static String f5759n = "AMEPTAGKS";

    public b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.h
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(obj, i11);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.h
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
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5759n, "slotId = " + c10 + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsScene.Builder builder = new KsScene.Builder(parseLong);
            builder.adNum(Math.min(i10, 5));
            com.aggmoread.sdk.z.d.a.a.c.h hVar = this.f5842g.f5871q;
            if (hVar != null) {
                if (hVar.b() > 0) {
                    builder.width(hVar.b());
                }
                if (hVar.a() > 0) {
                    builder.height(hVar.a());
                }
            }
            KsAdSDK.getLoadManager().loadConfigFeedAd(builder.build(), this);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5759n, "load ad");
            new k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception unused) {
            b(new i(1001002008, "广告ID配置错误，广告加载失败！"));
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onError(int i10, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5759n, "onAdError %s,%s", Integer.valueOf(i10), str);
        b(new i(i10, str));
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5759n, "ad loaded");
        List<com.aggmoread.sdk.z.d.a.a.c.o.d> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            int i10 = -1;
            for (KsFeedAd ksFeedAd : list) {
                int a10 = com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) ksFeedAd);
                if (q() && com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5843h, a10)) {
                    a(ksFeedAd, 0);
                } else {
                    b(ksFeedAd, com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a((Object) ksFeedAd));
                    arrayList.add(new c(ksFeedAd, this.f5842g, this.f5843h, this.f5841f));
                }
                i10 = a10;
            }
            if (q() && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }
}
