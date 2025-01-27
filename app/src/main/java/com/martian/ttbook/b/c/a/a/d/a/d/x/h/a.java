package com.martian.ttbook.b.c.a.a.d.a.d.x.h;

import android.app.Activity;
import android.content.Context;
import com.martian.ttbook.b.c.a.a.b;
import com.martian.ttbook.b.c.a.a.b.a.c;
import com.martian.ttbook.b.c.a.a.b.a.d.j;
import com.martian.ttbook.b.c.a.a.b.a.d.n;
import com.martian.ttbook.b.c.a.a.d.a.d.x.d;
import com.martian.ttbook.b.c.a.a.d.b.d;
import com.martian.ttbook.b.c.a.a.d.b.e;
import com.martian.ttbook.b.c.a.a.d.b.k;
import com.martian.ttbook.b.c.a.a.d.b.l;
import com.martian.ttbook.b.c.a.a.e.i;
import com.martian.ttbook.sdk.client.AdExtras;
import com.opos.acs.st.utils.ErrorContants;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class a extends j implements RewardVideoADListener {

    /* renamed from: f */
    private RewardVideoAD f15654f;

    /* renamed from: g */
    private boolean f15655g;

    /* renamed from: h */
    private AtomicBoolean f15656h;

    /* renamed from: j */
    private Object[] f15657j;

    public a(d dVar, e eVar) {
        super(dVar, eVar);
        this.f15655g = false;
        this.f15656h = new AtomicBoolean();
        this.f15657j = b.n();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void C(Activity activity) {
        RewardVideoAD rewardVideoAD;
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "showInner ac");
        if (!this.f15655g || (rewardVideoAD = this.f15654f) == null || rewardVideoAD.hasShown() || !this.f15656h.compareAndSet(false, true)) {
            return;
        }
        com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15654f, this.f15664e);
        this.f15654f.showAD(activity);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j
    public void D() {
        RewardVideoAD rewardVideoAD;
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "showInner ");
        if (!this.f15655g || (rewardVideoAD = this.f15654f) == null || rewardVideoAD.hasShown() || !this.f15656h.compareAndSet(false, true)) {
            return;
        }
        com.martian.ttbook.b.c.a.a.d.a.d.x.a.e(this.f15654f, this.f15664e);
        this.f15654f.showAD();
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void a(int i2, int i3, String str) {
        i.d(this.f15654f, i3, i2, str);
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void c(c cVar) {
        this.f15664e = cVar;
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onADClick");
        k kVar = new k(this.f15662c, this.f15663d);
        boolean g2 = kVar.g(this.f15663d, null, 0L, this.f15657j);
        kVar.h();
        if (g2) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdClicked();
            }
        }
        l.i(this.f15657j, false, true);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onADClose");
        new k(this.f15662c, this.f15663d).a(1).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdDismissed();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onADExpose");
        new k(this.f15662c, this.f15663d).a(5).c(k.b.q, this.f15663d.f15700b.d(e.c.f15716f, ErrorContants.NET_ERROR)).h();
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdExposed();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onADLoad");
        int b2 = com.martian.ttbook.b.c.a.a.d.a.d.x.c.b(this.f15654f);
        if (com.martian.ttbook.b.c.a.a.d.a.d.x.c.e(this.f15663d, b2)) {
            A(0);
            return;
        }
        B(b2);
        this.f15655g = true;
        this.f15661b.put(AdExtras.EXTRA_APP_INFOURL, com.martian.ttbook.b.c.a.a.d.a.d.x.a.b(this.f15654f));
        new k(this.f15662c, this.f15663d).a(4).h();
        com.martian.ttbook.b.c.a.a.d.a.d.x.c.d(this.f15661b, this.f15654f, this.f15663d);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdLoaded(arrayList);
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onADShow");
        d dVar = this.f15662c;
        l.o(dVar.f15668b, this.f15657j, dVar.f15671e, Integer.valueOf(this.f15663d.f()));
        l.s(this.f15662c.f15668b, this.f15663d.e(), this.f15663d.b());
        if (this.f15662c.m() != null) {
            d dVar2 = this.f15662c;
            l.k(dVar2.f15668b, dVar2.m());
        }
        byte[] h2 = this.f15662c.r.h();
        if (h2 != null) {
            l.j(this.f15662c.f15668b, h2);
        }
        l.i(this.f15657j, true, true);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onAdShow();
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onError " + adError.getErrorCode() + ", " + adError.getErrorMsg());
        com.martian.ttbook.b.c.a.a.d.b.i iVar = new com.martian.ttbook.b.c.a.a.d.b.i(adError.getErrorCode(), adError.getErrorMsg());
        new k(this.f15662c, this.f15663d).a(2).b(iVar).h();
        if (this.f15655g || !this.f15663d.k()) {
            this.f15662c.f15673g.a(iVar);
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "reward onReward map");
        l.q(this.f15657j, 1);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onReward(map);
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onVideoCached");
        if (this.f15655g) {
            com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
            if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
                ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).b();
            }
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "onVideoComplete");
        l.q(this.f15657j, 2);
        com.martian.ttbook.b.c.a.a.c.e eVar = this.f15662c.f15673g;
        if (eVar instanceof com.martian.ttbook.b.c.a.a.c.o.b) {
            ((com.martian.ttbook.b.c.a.a.c.o.b) eVar).onVideoComplete();
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.b.a.d.j, com.martian.ttbook.b.c.a.a.c.a
    public void sendWinNotification(int i2) {
        i.c(this.f15654f, i2);
    }

    @Override // com.martian.ttbook.b.c.a.a.d.b.a
    public void w() {
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "handle");
        d dVar = this.f15662c;
        com.martian.ttbook.b.c.a.a.c.q.b bVar = dVar.s;
        Context context = dVar.f15670d;
        com.martian.ttbook.b.c.a.a.e.e eVar = this.f15663d.f15701c;
        Object obj = e.c.U;
        n.f(context, eVar.d(obj, ""));
        boolean k = bVar != null ? bVar.k() : true;
        com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "mute = " + k);
        d.e eVar2 = d.e.REWARD;
        Context applicationContext = this.f15662c.f15670d.getApplicationContext();
        String d2 = this.f15663d.f15701c.d(obj, "");
        com.martian.ttbook.b.c.a.a.e.e eVar3 = this.f15663d.f15701c;
        Object obj2 = e.c.Q;
        this.f15654f = (RewardVideoAD) com.martian.ttbook.b.c.a.a.d.a.d.x.d.b(eVar2, applicationContext, d2, eVar3.d(obj2, ""), this, Boolean.valueOf(true ^ k));
        this.f15655g = false;
        if (this.f15662c.p != null) {
            com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "set ssv");
            String g2 = this.f15662c.p.g();
            String a2 = this.f15662c.p.a();
            com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", "u = " + g2 + ", cd = " + a2);
            String b2 = i.b(a2, this.f15663d.f15701c.l(obj2));
            StringBuilder sb = new StringBuilder();
            sb.append(" _extrasInfo = ");
            sb.append(b2);
            com.martian.ttbook.b.c.a.a.e.d.g("GDTRETAG", sb.toString());
            this.f15654f.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setUserId(g2).setCustomData(b2).build());
        }
        new k(this.f15662c, this.f15663d).a(3).h();
        this.f15654f.loadAD();
    }
}
