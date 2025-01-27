package com.martian.ttbook.b.c.a.a.b.a.d.b0.d;

import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.SplashAd;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.martian.ttbook.b.c.a.a.b.a.d.i;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.c.g;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.opos.acs.st.utils.ErrorContants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends i implements KsLoadManager.FeedAdListener {

    /* renamed from: g */
    private static String f15317g = "KSHTAG";

    public b(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.i
    protected void B(Object obj, int i2, int i3) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.e(obj, i3);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.i
    protected void E(Object obj, int i2) {
        com.martian.ttbook.b.c.a.a.b.a.d.b0.b.g(obj, i2);
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onError(int i2, String str) {
        com.martian.ttbook.b.c.a.a.e.d.c(f15317g, "onAdError %s,%s", Integer.valueOf(i2), str);
        D(new com.martian.ttbook.b.c.a.a.d.b.i(i2, str));
    }

    @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
    public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15317g, "ad loaded");
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (KsFeedAd ksFeedAd : list) {
                if (F() && com.martian.ttbook.b.c.a.a.b.a.d.b0.b.f(this.f15663d, com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(ksFeedAd))) {
                    A(ksFeedAd, 0);
                } else {
                    C(ksFeedAd, com.martian.ttbook.b.c.a.a.b.a.d.b0.b.b(ksFeedAd));
                    arrayList.add(new c(ksFeedAd, this.f15662c, this.f15663d, this.f15661b));
                }
            }
            if (F() && arrayList.size() == 0) {
                D(new com.martian.ttbook.b.c.a.a.d.b.i(30000019, "广告无填充！"));
                return;
            }
        }
        this.f15663d.f15703e = list.size();
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
        ((com.martian.ttbook.b.c.a.a.c.l.c) this.f15662c.f15673g).onAdLoaded(arrayList);
        this.f15406f = true;
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        if (!n.j(this.f15662c.f15670d, this.f15663d.f15701c.d(e.c.U, ""))) {
            D(new com.martian.ttbook.b.c.a.a.d.b.i(-1000, "广告加载失败！"));
            return;
        }
        int i2 = this.f15662c.m;
        if (i2 < 1) {
            i2 = 1;
        }
        this.f15661b.put(SplashAd.KEY_BIDFAIL_ECPM, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR));
        try {
            String l = this.f15663d.f15701c.l(e.c.Q);
            String trim = l.replace("L", "").trim();
            long parseLong = Long.parseLong(trim);
            com.martian.ttbook.b.c.a.a.e.d.g(f15317g, "slotId = " + l + ",slotIdStr = " + trim + ",_slotId = " + parseLong);
            KsScene.Builder builder = new KsScene.Builder(parseLong);
            builder.adNum(Math.min(i2, 5));
            g gVar = this.f15662c.q;
            if (gVar != null) {
                if (gVar.b() > 0) {
                    builder.width(gVar.b());
                }
                if (gVar.a() > 0) {
                    builder.height(gVar.a());
                }
            }
            KsAdSDK.getLoadManager().loadConfigFeedAd(builder.build(), this);
            com.martian.ttbook.b.c.a.a.e.d.g(f15317g, "load ad");
            new k(this.f15662c, this.f15663d).a(3).h();
        } catch (Exception unused) {
            D(new com.martian.ttbook.b.c.a.a.d.b.i(-1000, "广告ID配置错误，广告加载失败！"));
        }
    }
}
