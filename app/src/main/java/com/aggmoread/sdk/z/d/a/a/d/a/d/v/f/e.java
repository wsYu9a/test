package com.aggmoread.sdk.z.d.a.a.d.a.d.v.f;

import androidx.annotation.Nullable;
import com.aggmoread.sdk.z.d.a.a.d.a.d.k;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e extends k implements KsLoadManager.NativeAdListener {

    /* renamed from: n */
    private static String f5774n = "AMUTAGKS";

    public e(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.k
    public void a(Object obj, int i10, int i11) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(obj, i11);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.k
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
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5774n, "slotId = " + c10 + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(parseLong).adNum(i10).build(), this);
            com.aggmoread.sdk.z.d.a.a.e.e.b(f5774n, "load ad");
            new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(0).b();
        } catch (Exception unused) {
            b(new i(1001002008, "广告ID配置错误，广告加载失败！"));
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
    public void onError(int i10, String str) {
        com.aggmoread.sdk.z.d.a.a.e.e.a(f5774n, "onAdError %s,%s", Integer.valueOf(i10), str);
        b(new i(i10, str));
    }

    @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
    public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b(f5774n, "ad loaded");
        boolean a10 = this.f5842g.a("com.sdk.key.ESP", 16);
        List<com.aggmoread.sdk.z.d.a.a.c.o.f> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            int i10 = -1;
            for (KsNativeAd ksNativeAd : list) {
                int a11 = com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(ksNativeAd);
                if (q() && com.aggmoread.sdk.z.d.a.a.d.a.d.v.b.a(this.f5843h, a11)) {
                    a(ksNativeAd, 0);
                } else {
                    b(ksNativeAd, a11);
                    arrayList.add(a10 ? new a(ksNativeAd, this.f5842g, this.f5843h, this.f5841f) : new d(ksNativeAd, this.f5842g, this.f5843h, this.f5841f));
                }
                i10 = a11;
            }
            if (q() && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }
}
