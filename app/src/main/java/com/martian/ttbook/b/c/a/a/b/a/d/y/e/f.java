package com.martian.ttbook.b.c.a.a.b.a.d.y.e;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.martian.ttbook.b.c.a.a.b.a.d.l;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.i;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.sdk.client.AdRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends l implements TTAdNative.FeedAdListener {

    /* renamed from: g */
    public TTAdNative f15503g;

    public f(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar) {
        super(dVar, eVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.martian.ttbook.b.c.a.a.b.a.d.l
    public boolean F() {
        return com.martian.ttbook.b.c.a.a.b.a.d.y.a.e(this.f15663d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
    public void onError(int i2, String str) {
        D(new i(i2, str));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        com.martian.ttbook.b.c.a.a.e.d.g("XXX", "ad loaded");
        boolean i2 = this.f15662c.i(AdRequest.Parameters.KEY_ESP, 16);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (TTFeedAd tTFeedAd : list) {
                if (!F() || !com.martian.ttbook.b.c.a.a.b.a.d.y.a.f(this.f15663d, tTFeedAd)) {
                    arrayList.add(i2 ? new b(tTFeedAd, this.f15662c, this.f15663d, this.f15661b) : new e(tTFeedAd, this.f15662c, this.f15663d, this.f15661b));
                }
            }
            if (F() && arrayList.size() == 0) {
                D(new i(30000019, "广告无填充！"));
                return;
            }
        }
        this.f15663d.f15703e = list.size();
        new k(this.f15662c, this.f15663d).a(4).c(k.b.B, Integer.valueOf(list.size())).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.l.e) {
            ((com.martian.ttbook.b.c.a.a.c.l.e) eVar).onAdLoaded(arrayList);
        }
        this.f15414f = true;
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        n.c(this.f15662c.f15670d, this.f15663d.f15701c.l(e.c.U), null);
        this.f15503g = com.martian.ttbook.b.c.a.a.b.a.d.y.c.b().createAdNative(this.f15662c.f15670d);
        int b2 = com.martian.ttbook.b.c.a.a.e.l.b(this.f15662c.f15670d);
        double d2 = b2;
        Double.isNaN(d2);
        int i2 = (int) (d2 * 0.75d);
        if (i2 < 1) {
            i2 = 1;
        }
        this.f15503g.loadFeedAd(new AdSlot.Builder().setCodeId(this.f15663d.f15701c.l(e.c.Q)).setSupportDeepLink(true).setAdCount(Math.max(1, Math.min(3, this.f15662c.m))).setImageAcceptedSize(b2, i2).build(), this);
        new k(this.f15662c, this.f15663d).a(3).h();
    }
}
