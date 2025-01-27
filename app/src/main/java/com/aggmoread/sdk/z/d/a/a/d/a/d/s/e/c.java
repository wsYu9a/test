package com.aggmoread.sdk.z.d.a.a.d.a.d.s.e;

import com.aggmoread.sdk.z.d.a.a.d.a.d.k;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.e.q;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class c extends k implements TTAdNative.FeedAdListener {

    /* renamed from: n */
    public TTAdNative f5653n;

    public c(d dVar, e eVar) {
        super(dVar, eVar);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.b.a
    public void l() {
        com.aggmoread.sdk.z.d.a.a.d.a.d.s.b.a(this.f5842g.f5858d, this.f5843h.f5907c.c(e.c.X), null);
        this.f5653n = com.aggmoread.sdk.z.d.a.a.d.a.d.s.c.a().createAdNative(this.f5842g.f5858d);
        int b10 = q.b(this.f5842g.f5858d);
        int i10 = (int) (b10 * 0.75d);
        if (i10 < 1) {
            i10 = 1;
        }
        this.f5653n.loadFeedAd(new AdSlot.Builder().setCodeId(this.f5843h.f5907c.c(e.c.T)).setSupportDeepLink(true).setAdCount(Math.max(1, Math.min(3, this.f5842g.f5867m))).setImageAcceptedSize(b10, i10).build(), this);
        new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5842g, this.f5843h).a(0).b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onError(int i10, String str) {
        b(new i(i10, str));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        com.aggmoread.sdk.z.d.a.a.e.e.b("XXX", "ad loaded");
        boolean a10 = this.f5842g.a("com.sdk.key.ESP", 16);
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            int i10 = -1;
            for (TTFeedAd tTFeedAd : list) {
                int b10 = com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.b(tTFeedAd);
                if (!q() || !com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.a(this.f5843h, tTFeedAd)) {
                    arrayList.add(a10 ? new a(tTFeedAd, this.f5842g, this.f5843h, this.f5841f) : new b(tTFeedAd, this.f5842g, this.f5843h, this.f5841f));
                }
                i10 = b10;
            }
            if (q() && arrayList.size() == 0) {
                a(i10, 0);
                return;
            }
        }
        e(arrayList);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.k
    public boolean q() {
        return com.aggmoread.sdk.z.d.a.a.d.a.d.s.a.a(this.f5843h);
    }
}
